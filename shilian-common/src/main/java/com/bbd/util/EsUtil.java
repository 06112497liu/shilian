/*
 * Copyright (c) BrandBigData.com Inc.
 * All Rights Reserved 2017.
 */

/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.util;

import com.bbd.bean.EsBase;
import com.bbd.bean.RangeQueryBean;
import com.bbd.pagin.Pagination;
import com.google.common.collect.Lists;
import com.mybatis.domain.PageBounds;
import com.mybatis.domain.PageList;
import com.mybatis.domain.Paginator;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.ListenableActionFuture;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.*;
import org.elasticsearch.index.reindex.BulkIndexByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryAction;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author xc
 * @version $Id: ss.java, v 0.1 2016年12月12日 上午11:39:49 xc Exp $
 */
public class EsUtil {

    /**
     * 索引
     */
    public static final String     INDEX               = "bbd";
    /**
     * 失联企业
     */
    public static final String     COMPANY             = "company";
    public static final String     ID_PROP             = "id";
    /**
     * 滚动分片最大的值   单个片的数量 *　分片数量
     */
    private static final int       SRCOLL_FITCH_SIZE   = 10000 * 1;
    /**
     * 默认的滚动时间
     */
    private static final long      DEFALUT_SCROLL_TIME = 60000;
    private static Logger          logger              = LoggerFactory.getLogger(EsUtil.class);
    /**
     * es链接
     */
    private static TransportClient client;

    static {
        try {
            Settings settings = Settings.builder().put("cluster.name", ConfigUtil.getEsClusterName()).build();
            client = new PreBuiltTransportClient(settings).addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(ConfigUtil.getESHost()), ConfigUtil.getESPort()));
        } catch (UnknownHostException e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * es查询
     *
     * @param type   类型
     * @param keyMap 模糊查询值
     * @param pb     分页
     */
    public static <T> PageList<T> search(String type, Map<String, Object> matchMap, Map<String, Object> keyMap, List<RangeQueryBean> list, PageBounds pb, Class<T> clazz, String[] orderFields,
                                         SortOrder[] orderTypes) {

        boolean isFormSizeSearch = true;
        if (pb != null) {
            long end = pb.getOffset();
            logger.info("search max index is {}; ", end);
            if ((end + pb.getLimit()) > 10000) {
                isFormSizeSearch = false;
            }
        } else {
            pb = new PageBounds(1, 20);
        }
        // 准备查询请求
        SearchRequestBuilder searchBuilder = (isFormSizeSearch ? prepareSearchBuilder(type, orderFields, orderTypes) : prepareScrollSearchBuilder(type, orderFields, orderTypes));
        logger.info("serach builder prepared, type {}, order{}{}.", type, orderFields, orderTypes);
        searchBuilder.setQuery(prepareQuery(matchMap, keyMap, list));
        logger.info("search paramters prepared, paramters{},{},{}.", matchMap, keyMap, list);
        logger.debug("es search info : " + searchBuilder.toString());
        return (isFormSizeSearch ? searchByFormSize(pb, clazz, searchBuilder) : searchByScroll(pb, clazz, searchBuilder));
    }

    /**
     * @param type
     * @param orderFields
     * @param orderTypes
     * @return
     */
    private static SearchRequestBuilder prepareScrollSearchBuilder(String type, String[] orderFields, SortOrder[] orderTypes) {
        SearchRequestBuilder searchBuilder = prepareSearchBuilder(type, orderFields, orderTypes);
        searchBuilder.setScroll(new TimeValue(DEFALUT_SCROLL_TIME));
        searchBuilder.setSize(SRCOLL_FITCH_SIZE);
        return searchBuilder;
    }

    /**
     * form-size 查询实现
     */
    private static <T> PageList<T> searchByFormSize(PageBounds pb, Class<T> clazz, SearchRequestBuilder searchBuilder) {
        int pageSize = pb.getLimit();
        int start = pb.getOffset();
        logger.info("search by form size currentPage:{}, pageSize:{}", pb.getOffset(), pb.getLimit());
        searchBuilder.setFrom(start).setSize(pageSize);
        SearchResponse response = searchBuilder.setExplain(true).execute().actionGet();
        logger.info("hits:{};", response.getHits().toString());
        //pb.setTotal(response.getHits().getTotalHits());
        return getPageList(response, pb, clazz);
    }

    private static QueryBuilder prepareQuery(Map<String, Object> matchMap, Map<String, Object> keyMap, List<RangeQueryBean> list) {
        BoolQueryBuilder qb = QueryBuilders.boolQuery();
        if (matchMap != null) {
            for (String key : matchMap.keySet()) {
                Object value = matchMap.get(key);
                if (StringUtils.isNoneBlank(key) && value != null && StringUtils.isNoneBlank(value.toString())) {
                    logger.info("---matchMap----key:" + key + ";value:" + value);
                    qb.must(QueryBuilders.matchQuery(key, value));
                }
            }
        }
        if (keyMap != null) {
            for (String key : keyMap.keySet()) {
                Object value = keyMap.get(key);
                if (value instanceof String && StringUtils.isNoneBlank(key) && value != null && StringUtils.isNoneBlank(value.toString())) {
                    logger.info("---keyMap----key:" + key + ";value:" + value);
                    qb.filter(new QueryStringQueryBuilder(String.valueOf(value)).field(key));
                } else if (value instanceof List) {
                    logger.info("---keyMap----key:" + key + ";value:" + value);
                    qb.filter(new TermsQueryBuilder(key, ((List) value).toArray()));
                }
            }
        }
        if (list != null) {
            for (RangeQueryBean rangeQueryBean : list) {
                if (rangeQueryBean != null && StringUtils.isNotBlank(rangeQueryBean.getName()) && (rangeQueryBean.getFrom() != null || rangeQueryBean.getTo() != null)) {
                    logger.info("---rangeQueryBean----name:{} from:{} to {} .", rangeQueryBean.getName(), rangeQueryBean.getFrom(), rangeQueryBean.getTo());
                    qb.filter(QueryBuilders.rangeQuery(rangeQueryBean.getName()).from(rangeQueryBean.getFrom()).to(rangeQueryBean.getTo()));
                }
            }
        }
        return qb;
    }

    private static SearchRequestBuilder prepareSearchBuilder(String type, String[] orderFields, SortOrder[] orderTypes) {
        SearchRequestBuilder searchBuilder = client.prepareSearch(INDEX).setTypes(type).setSearchType(SearchType.DEFAULT);
        if (orderFields.length == 0 || orderFields.length > orderTypes.length) {
            searchBuilder.addSort("id", SortOrder.ASC);
        } else {
            int i = 0;
            for (String field : orderFields) {
                searchBuilder.addSort(field, orderTypes[i]);
                i++;
            }
        }
        return searchBuilder;
    }

    /**
     * es查询
     *
     * @param type   类型
     * @param keyMap 模糊查询值
     * @param pb     分页
     */
    public static <T> PageList<T> search(String type, Map<String, Object> matchMap, Map<String, Object> keyMap, List<RangeQueryBean> list, PageBounds pb, Class clazz) {
        String[] orderFields;
        SortOrder[] orderTypes = new SortOrder[] { SortOrder.DESC };
        if (matchMap == null || matchMap.size() == 0) {
            orderFields = new String[] { "id" };
        } else {
            orderFields = new String[] { "_score" };
        }

        return search(type, matchMap, keyMap, list, pb, clazz, orderFields, orderTypes);
    }

    /**
     * es查询
     *
     * @param type   类型
     * @param keyMap 模糊查询值
     * @param pb     分页
     */
    public static <T> PageList<T> search(String type, Map<String, Object> matchMap, Map<String, Object> keyMap, PageBounds pb, Class clazz) {
        return search(type, matchMap, keyMap, null, pb, clazz);
    }

    /**
     * @param pb
     * @param clazz
     * @param builer
     * @return
     */
    private static <T> PageList<T> searchByScroll(PageBounds pb, Class<T> clazz, SearchRequestBuilder builer) {
        int start = pb.getOffset();
        int pageSize = pb.getLimit();
        logger.info("search by form size currentPage:{}, pageSize:{}", pb.getOffset(), pb.getLimit());
        SearchResponse scrollResp = builer.get();
        // 获取数据的总长度
        long count = scrollResp.getHits().getTotalHits();
        long sum = scrollResp.getHits().getHits().length;
        // 如果页码超出了最大取最后一页的数据
        int offset = pb.getLimit();
        if ((count - pageSize) < start) {
            // 更新页码和开始位置
            offset = (int) Math.ceil(count / (pageSize * 1.0));
            logger.info("reset total page :{}", offset);
            start = (offset - 1) * pageSize;
        }
        // 计算滚动的次数
        int bs = start / 10000;
        long startTime = System.currentTimeMillis();
        // 滚动
        while (sum < bs * 10000) {
            scrollResp = client.prepareSearchScroll(scrollResp.getScrollId()).setScroll(new TimeValue(60000)).execute().actionGet();
            sum += scrollResp.getHits().getHits().length;
        }
        // 获取数据
        scrollResp = client.prepareSearchScroll(scrollResp.getScrollId()).setScroll(new TimeValue(60000)).execute().actionGet();
        logger.info(" scroll search total time: {} ", (System.currentTimeMillis() - startTime));

        return getPageList(scrollResp, pb, clazz);
    }

    public static <T> PageList<T> getPageList(SearchResponse response, PageBounds pb, Class<T> clazz) {
        Paginator p = new Paginator(pb.getPage(), pb.getLimit(), Long.valueOf(response.getHits().getTotalHits()).intValue());

        PageList<T> pageLIst = new PageList<T>(p);
        SearchHits hits = response.getHits();
        int limit = pb.getLimit();
        int total = Long.valueOf(hits.getTotalHits()).intValue();
        int len = limit < total ? limit : total;
        ArrayList<SearchHit> list = Lists.newArrayList(hits.getHits());
        List<SearchHit> hitList = list.subList(0, list.size() > len ? len : list.size());
        for (SearchHit hit : hitList) {
            String source = hit.getSourceAsString();
            logger.info("source:" + source.toString());
            T obj = JsonUtil.parseObject(source, clazz);
            pageLIst.add(obj);
        }

        return pageLIst;
    }

    public static <T> List<T> getResults(SearchResponse response, Class<T> clazz) {
        List<T> result = Lists.newArrayList();
        for (SearchHit hit : response.getHits()) {
            String source = hit.getSourceAsString();
            T obj = JsonUtil.parseObject(source, clazz);
            result.add(obj);
        }

        return result;
    }

    public static Pagination getPagination(SearchHit[] hits, Pagination page, Class<?> clazz) {
        List<Object> list = new ArrayList<Object>();
        for (SearchHit hit : hits) {
            Map<String, Object> source = hit.getSource();
            logger.info("source:" + source.toString());
            Object obj = null;
            try {
                obj = clazz.newInstance();
            } catch (InstantiationException e) {
                logger.error(e.getMessage(), e);
            } catch (IllegalAccessException e) {
                logger.error(e.getMessage(), e);
            }
            try {
                BeanUtils.copyProperties(obj, source);
            } catch (IllegalAccessException e) {
                logger.error("es数据解析异常：", e);
            } catch (InvocationTargetException e) {
                logger.error("es数据解析异常：", e);
            }
            list.add(obj);
        }
        page.setData(list);
        logger.info("page:" + page.toString());
        return page;
    }

    public static <T extends EsBase> void create(String type, List<T> bases) {
        BulkRequestBuilder bulkRequest = client.prepareBulk();
        for (EsBase base : bases) {
            bulkRequest.add(client.prepareIndex(INDEX, type, base.getId().toString()).setSource(JsonUtil.fromJson(base)));
        }

        BulkResponse bulkResponse = bulkRequest.get();
        logger.info("create time used : " + bulkResponse.getTookInMillis());
    }

    public static void delete(String type) {
        DeleteIndexResponse response = client.admin().indices().prepareDelete(INDEX).execute().actionGet();
        if (response.isAcknowledged()) {
            System.out.println("delete index " + INDEX + "  successfully!");
        } else {
            System.out.println("Fail to delete index " + INDEX);
        }
        logger.info("response" + response.toString());
    }

    public static void deleteAll(String type) {
        BulkIndexByScrollResponse response = DeleteByQueryAction.INSTANCE.newRequestBuilder(client).filter(QueryBuilders.matchAllQuery()).source(type).get();
        long deleted = response.getDeleted();
        logger.info("All datas under {} is deleted : {}", type, deleted);
    }

    public static boolean deleteBulk(String type, List<Long> ids) {
        boolean hasFailure = false;
        if (ids == null || ids.size() == 0) {
            return hasFailure;
        }
        BulkRequestBuilder builder = client.prepareBulk();
        for (Long id : ids) {
            builder.add(client.prepareDelete(INDEX, type, String.valueOf(id)).request());
        }
        ListenableActionFuture<BulkResponse> future = builder.execute();
        try {
            BulkResponse resp = future.get();
            return resp.hasFailures();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return true;
    }

    public static void update(String type, String id) {
        UpdateRequest req = new UpdateRequest();
        req.index(INDEX).type(type).id(id).doc();
    }

    /**
     * 获取最大的id号，用于增量插入
     *
     * @param type
     * @return
     */
    public static Long getLastId(String type) {
        Long result = 0L;
        SearchResponse resp = client.prepareSearch(INDEX).setTypes(type).addSort(ID_PROP, SortOrder.DESC).setSize(1).get();
        SearchHits hits = resp.getHits();
        if (hits.getTotalHits() > 0) {
            result = Long.parseLong(hits.getHits()[0].getId());
        }
        return result;
    }

    public static SearchRequestBuilder buildSearchRequestBuilder(String type, Map<String, Object> matchMap, Map<String, Object> keyMap, List<RangeQueryBean> list) {
        String[] orderFields = new String[] { "id" };
        SortOrder[] orderTypes = new SortOrder[] { SortOrder.ASC };

        SearchRequestBuilder searchBuilder = prepareScrollSearchBuilder(type, orderFields, orderTypes);
        searchBuilder.setQuery(prepareQuery(matchMap, keyMap, list));

        return searchBuilder;
    }

}
