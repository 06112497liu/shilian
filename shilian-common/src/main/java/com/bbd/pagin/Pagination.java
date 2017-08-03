package com.bbd.pagin;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 分页返回模型
 * 2015年10月27日 上午10:18:41
 */
@ApiModel(value = "分页")
public class Pagination {

    public static final String _offset = "offset";
    public static final String _limit  = "limit";
    @ApiModelProperty(value = "第几页", required = true)
    private long               offset  = 1;
    @ApiModelProperty(value = "每页数量,默认10条", required = true)
    private int                limit   = 10;
    @ApiModelProperty(value = "总的数量", required = true)
    private long               total;
    @ApiModelProperty(value = "返回数据", required = true)
    private Object             data;

    public Pagination() {
        super();
    }

    public Pagination(long offset, int limit) {
        super();
        this.offset = offset <= 0 ? 1 : offset;
        this.limit = limit;
    }

    public Pagination(long offset, int limit, long total, Object data) {
        this(offset, limit);
        this.total = total;
        this.data = data;
    }

    /**
     * 起始记录数
     * @return int
     */
    public long getOffset() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }

    /**
     * 页面大小
     * @return int
     */
    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    /**
     * 总条数
     * @return int
     */
    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    /**
     * 分页数据
     * @return
     */
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 获取分页开始下标
     * 
     * @return
     * @author hongQiang tang
     * @date 2017/05/12
     */
    @JsonInclude
    public long getPageStart() {
        return Math.max(0, (offset - 1) * limit);
    }

    @Override
    public String toString() {
        return "Pagination [offset=" + offset + ", limit=" + limit + ", total=" + total + ", data=" + data + "]";
    }
}
