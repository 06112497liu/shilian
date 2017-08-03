/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.reddata.es;

/**
 * ElasticSearch服务
 * @author tjwang
 * @version $Id: IEsService.java, v 0.1 2017/5/24 0024 12:38 tjwang Exp $
 */
public interface IEsService {

    void syncFullCompanyToEs();

    void syncIncreaseCompanyToEs();

}
