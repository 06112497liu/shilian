/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.reddata.remind.param;

/**
 * 年报提醒设置的条件
 * @author tjwang
 * @version $Id: MannualRemindCondition.java, v 0.1 2017/6/6 0006 17:37 tjwang Exp $
 */
public class MannualRemindCondition {

    private String companyName;

    private String district;

    private String primaryIndustry;

    private Double indexScoreFrom;

    private Double indexScoreTo;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPrimaryIndustry() {
        return primaryIndustry;
    }

    public void setPrimaryIndustry(String primaryIndustry) {
        this.primaryIndustry = primaryIndustry;
    }

    public Double getIndexScoreFrom() {
        return indexScoreFrom;
    }

    public void setIndexScoreFrom(Double indexScoreFrom) {
        this.indexScoreFrom = indexScoreFrom;
    }

    public Double getIndexScoreTo() {
        return indexScoreTo;
    }

    public void setIndexScoreTo(Double indexScoreTo) {
        this.indexScoreTo = indexScoreTo;
    }
}
