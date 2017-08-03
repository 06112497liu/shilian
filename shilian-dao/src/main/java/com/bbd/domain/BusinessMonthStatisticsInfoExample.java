package com.bbd.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusinessMonthStatisticsInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BusinessMonthStatisticsInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNbxhIsNull() {
            addCriterion("nbxh is null");
            return (Criteria) this;
        }

        public Criteria andNbxhIsNotNull() {
            addCriterion("nbxh is not null");
            return (Criteria) this;
        }

        public Criteria andNbxhEqualTo(String value) {
            addCriterion("nbxh =", value, "nbxh");
            return (Criteria) this;
        }

        public Criteria andNbxhNotEqualTo(String value) {
            addCriterion("nbxh <>", value, "nbxh");
            return (Criteria) this;
        }

        public Criteria andNbxhGreaterThan(String value) {
            addCriterion("nbxh >", value, "nbxh");
            return (Criteria) this;
        }

        public Criteria andNbxhGreaterThanOrEqualTo(String value) {
            addCriterion("nbxh >=", value, "nbxh");
            return (Criteria) this;
        }

        public Criteria andNbxhLessThan(String value) {
            addCriterion("nbxh <", value, "nbxh");
            return (Criteria) this;
        }

        public Criteria andNbxhLessThanOrEqualTo(String value) {
            addCriterion("nbxh <=", value, "nbxh");
            return (Criteria) this;
        }

        public Criteria andNbxhLike(String value) {
            addCriterion("nbxh like", value, "nbxh");
            return (Criteria) this;
        }

        public Criteria andNbxhNotLike(String value) {
            addCriterion("nbxh not like", value, "nbxh");
            return (Criteria) this;
        }

        public Criteria andNbxhIn(List<String> values) {
            addCriterion("nbxh in", values, "nbxh");
            return (Criteria) this;
        }

        public Criteria andNbxhNotIn(List<String> values) {
            addCriterion("nbxh not in", values, "nbxh");
            return (Criteria) this;
        }

        public Criteria andNbxhBetween(String value1, String value2) {
            addCriterion("nbxh between", value1, value2, "nbxh");
            return (Criteria) this;
        }

        public Criteria andNbxhNotBetween(String value1, String value2) {
            addCriterion("nbxh not between", value1, value2, "nbxh");
            return (Criteria) this;
        }

        public Criteria andActivityYearIsNull() {
            addCriterion("activity_year is null");
            return (Criteria) this;
        }

        public Criteria andActivityYearIsNotNull() {
            addCriterion("activity_year is not null");
            return (Criteria) this;
        }

        public Criteria andActivityYearEqualTo(Integer value) {
            addCriterion("activity_year =", value, "activityYear");
            return (Criteria) this;
        }

        public Criteria andActivityYearNotEqualTo(Integer value) {
            addCriterion("activity_year <>", value, "activityYear");
            return (Criteria) this;
        }

        public Criteria andActivityYearGreaterThan(Integer value) {
            addCriterion("activity_year >", value, "activityYear");
            return (Criteria) this;
        }

        public Criteria andActivityYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity_year >=", value, "activityYear");
            return (Criteria) this;
        }

        public Criteria andActivityYearLessThan(Integer value) {
            addCriterion("activity_year <", value, "activityYear");
            return (Criteria) this;
        }

        public Criteria andActivityYearLessThanOrEqualTo(Integer value) {
            addCriterion("activity_year <=", value, "activityYear");
            return (Criteria) this;
        }

        public Criteria andActivityYearIn(List<Integer> values) {
            addCriterion("activity_year in", values, "activityYear");
            return (Criteria) this;
        }

        public Criteria andActivityYearNotIn(List<Integer> values) {
            addCriterion("activity_year not in", values, "activityYear");
            return (Criteria) this;
        }

        public Criteria andActivityYearBetween(Integer value1, Integer value2) {
            addCriterion("activity_year between", value1, value2, "activityYear");
            return (Criteria) this;
        }

        public Criteria andActivityYearNotBetween(Integer value1, Integer value2) {
            addCriterion("activity_year not between", value1, value2, "activityYear");
            return (Criteria) this;
        }

        public Criteria andActivityMonthIsNull() {
            addCriterion("activity_month is null");
            return (Criteria) this;
        }

        public Criteria andActivityMonthIsNotNull() {
            addCriterion("activity_month is not null");
            return (Criteria) this;
        }

        public Criteria andActivityMonthEqualTo(Integer value) {
            addCriterion("activity_month =", value, "activityMonth");
            return (Criteria) this;
        }

        public Criteria andActivityMonthNotEqualTo(Integer value) {
            addCriterion("activity_month <>", value, "activityMonth");
            return (Criteria) this;
        }

        public Criteria andActivityMonthGreaterThan(Integer value) {
            addCriterion("activity_month >", value, "activityMonth");
            return (Criteria) this;
        }

        public Criteria andActivityMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity_month >=", value, "activityMonth");
            return (Criteria) this;
        }

        public Criteria andActivityMonthLessThan(Integer value) {
            addCriterion("activity_month <", value, "activityMonth");
            return (Criteria) this;
        }

        public Criteria andActivityMonthLessThanOrEqualTo(Integer value) {
            addCriterion("activity_month <=", value, "activityMonth");
            return (Criteria) this;
        }

        public Criteria andActivityMonthIn(List<Integer> values) {
            addCriterion("activity_month in", values, "activityMonth");
            return (Criteria) this;
        }

        public Criteria andActivityMonthNotIn(List<Integer> values) {
            addCriterion("activity_month not in", values, "activityMonth");
            return (Criteria) this;
        }

        public Criteria andActivityMonthBetween(Integer value1, Integer value2) {
            addCriterion("activity_month between", value1, value2, "activityMonth");
            return (Criteria) this;
        }

        public Criteria andActivityMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("activity_month not between", value1, value2, "activityMonth");
            return (Criteria) this;
        }

        public Criteria andActivityExponentIsNull() {
            addCriterion("activity_exponent is null");
            return (Criteria) this;
        }

        public Criteria andActivityExponentIsNotNull() {
            addCriterion("activity_exponent is not null");
            return (Criteria) this;
        }

        public Criteria andActivityExponentEqualTo(Double value) {
            addCriterion("activity_exponent =", value, "activityExponent");
            return (Criteria) this;
        }

        public Criteria andActivityExponentNotEqualTo(Double value) {
            addCriterion("activity_exponent <>", value, "activityExponent");
            return (Criteria) this;
        }

        public Criteria andActivityExponentGreaterThan(Double value) {
            addCriterion("activity_exponent >", value, "activityExponent");
            return (Criteria) this;
        }

        public Criteria andActivityExponentGreaterThanOrEqualTo(Double value) {
            addCriterion("activity_exponent >=", value, "activityExponent");
            return (Criteria) this;
        }

        public Criteria andActivityExponentLessThan(Double value) {
            addCriterion("activity_exponent <", value, "activityExponent");
            return (Criteria) this;
        }

        public Criteria andActivityExponentLessThanOrEqualTo(Double value) {
            addCriterion("activity_exponent <=", value, "activityExponent");
            return (Criteria) this;
        }

        public Criteria andActivityExponentIn(List<Double> values) {
            addCriterion("activity_exponent in", values, "activityExponent");
            return (Criteria) this;
        }

        public Criteria andActivityExponentNotIn(List<Double> values) {
            addCriterion("activity_exponent not in", values, "activityExponent");
            return (Criteria) this;
        }

        public Criteria andActivityExponentBetween(Double value1, Double value2) {
            addCriterion("activity_exponent between", value1, value2, "activityExponent");
            return (Criteria) this;
        }

        public Criteria andActivityExponentNotBetween(Double value1, Double value2) {
            addCriterion("activity_exponent not between", value1, value2, "activityExponent");
            return (Criteria) this;
        }

        public Criteria andActivityScoreTypeIsNull() {
            addCriterion("activity_score_type is null");
            return (Criteria) this;
        }

        public Criteria andActivityScoreTypeIsNotNull() {
            addCriterion("activity_score_type is not null");
            return (Criteria) this;
        }

        public Criteria andActivityScoreTypeEqualTo(Integer value) {
            addCriterion("activity_score_type =", value, "activityScoreType");
            return (Criteria) this;
        }

        public Criteria andActivityScoreTypeNotEqualTo(Integer value) {
            addCriterion("activity_score_type <>", value, "activityScoreType");
            return (Criteria) this;
        }

        public Criteria andActivityScoreTypeGreaterThan(Integer value) {
            addCriterion("activity_score_type >", value, "activityScoreType");
            return (Criteria) this;
        }

        public Criteria andActivityScoreTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity_score_type >=", value, "activityScoreType");
            return (Criteria) this;
        }

        public Criteria andActivityScoreTypeLessThan(Integer value) {
            addCriterion("activity_score_type <", value, "activityScoreType");
            return (Criteria) this;
        }

        public Criteria andActivityScoreTypeLessThanOrEqualTo(Integer value) {
            addCriterion("activity_score_type <=", value, "activityScoreType");
            return (Criteria) this;
        }

        public Criteria andActivityScoreTypeIn(List<Integer> values) {
            addCriterion("activity_score_type in", values, "activityScoreType");
            return (Criteria) this;
        }

        public Criteria andActivityScoreTypeNotIn(List<Integer> values) {
            addCriterion("activity_score_type not in", values, "activityScoreType");
            return (Criteria) this;
        }

        public Criteria andActivityScoreTypeBetween(Integer value1, Integer value2) {
            addCriterion("activity_score_type between", value1, value2, "activityScoreType");
            return (Criteria) this;
        }

        public Criteria andActivityScoreTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("activity_score_type not between", value1, value2, "activityScoreType");
            return (Criteria) this;
        }

        public Criteria andDistrictIsNull() {
            addCriterion("district is null");
            return (Criteria) this;
        }

        public Criteria andDistrictIsNotNull() {
            addCriterion("district is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictEqualTo(String value) {
            addCriterion("district =", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotEqualTo(String value) {
            addCriterion("district <>", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictGreaterThan(String value) {
            addCriterion("district >", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictGreaterThanOrEqualTo(String value) {
            addCriterion("district >=", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLessThan(String value) {
            addCriterion("district <", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLessThanOrEqualTo(String value) {
            addCriterion("district <=", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLike(String value) {
            addCriterion("district like", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotLike(String value) {
            addCriterion("district not like", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictIn(List<String> values) {
            addCriterion("district in", values, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotIn(List<String> values) {
            addCriterion("district not in", values, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictBetween(String value1, String value2) {
            addCriterion("district between", value1, value2, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotBetween(String value1, String value2) {
            addCriterion("district not between", value1, value2, "district");
            return (Criteria) this;
        }

        public Criteria andCompanyStateIsNull() {
            addCriterion("company_state is null");
            return (Criteria) this;
        }

        public Criteria andCompanyStateIsNotNull() {
            addCriterion("company_state is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyStateEqualTo(Integer value) {
            addCriterion("company_state =", value, "companyState");
            return (Criteria) this;
        }

        public Criteria andCompanyStateNotEqualTo(Integer value) {
            addCriterion("company_state <>", value, "companyState");
            return (Criteria) this;
        }

        public Criteria andCompanyStateGreaterThan(Integer value) {
            addCriterion("company_state >", value, "companyState");
            return (Criteria) this;
        }

        public Criteria andCompanyStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_state >=", value, "companyState");
            return (Criteria) this;
        }

        public Criteria andCompanyStateLessThan(Integer value) {
            addCriterion("company_state <", value, "companyState");
            return (Criteria) this;
        }

        public Criteria andCompanyStateLessThanOrEqualTo(Integer value) {
            addCriterion("company_state <=", value, "companyState");
            return (Criteria) this;
        }

        public Criteria andCompanyStateIn(List<Integer> values) {
            addCriterion("company_state in", values, "companyState");
            return (Criteria) this;
        }

        public Criteria andCompanyStateNotIn(List<Integer> values) {
            addCriterion("company_state not in", values, "companyState");
            return (Criteria) this;
        }

        public Criteria andCompanyStateBetween(Integer value1, Integer value2) {
            addCriterion("company_state between", value1, value2, "companyState");
            return (Criteria) this;
        }

        public Criteria andCompanyStateNotBetween(Integer value1, Integer value2) {
            addCriterion("company_state not between", value1, value2, "companyState");
            return (Criteria) this;
        }

        public Criteria andPrimaryIndustryIsNull() {
            addCriterion("primary_industry is null");
            return (Criteria) this;
        }

        public Criteria andPrimaryIndustryIsNotNull() {
            addCriterion("primary_industry is not null");
            return (Criteria) this;
        }

        public Criteria andPrimaryIndustryEqualTo(String value) {
            addCriterion("primary_industry =", value, "primaryIndustry");
            return (Criteria) this;
        }

        public Criteria andPrimaryIndustryNotEqualTo(String value) {
            addCriterion("primary_industry <>", value, "primaryIndustry");
            return (Criteria) this;
        }

        public Criteria andPrimaryIndustryGreaterThan(String value) {
            addCriterion("primary_industry >", value, "primaryIndustry");
            return (Criteria) this;
        }

        public Criteria andPrimaryIndustryGreaterThanOrEqualTo(String value) {
            addCriterion("primary_industry >=", value, "primaryIndustry");
            return (Criteria) this;
        }

        public Criteria andPrimaryIndustryLessThan(String value) {
            addCriterion("primary_industry <", value, "primaryIndustry");
            return (Criteria) this;
        }

        public Criteria andPrimaryIndustryLessThanOrEqualTo(String value) {
            addCriterion("primary_industry <=", value, "primaryIndustry");
            return (Criteria) this;
        }

        public Criteria andPrimaryIndustryLike(String value) {
            addCriterion("primary_industry like", value, "primaryIndustry");
            return (Criteria) this;
        }

        public Criteria andPrimaryIndustryNotLike(String value) {
            addCriterion("primary_industry not like", value, "primaryIndustry");
            return (Criteria) this;
        }

        public Criteria andPrimaryIndustryIn(List<String> values) {
            addCriterion("primary_industry in", values, "primaryIndustry");
            return (Criteria) this;
        }

        public Criteria andPrimaryIndustryNotIn(List<String> values) {
            addCriterion("primary_industry not in", values, "primaryIndustry");
            return (Criteria) this;
        }

        public Criteria andPrimaryIndustryBetween(String value1, String value2) {
            addCriterion("primary_industry between", value1, value2, "primaryIndustry");
            return (Criteria) this;
        }

        public Criteria andPrimaryIndustryNotBetween(String value1, String value2) {
            addCriterion("primary_industry not between", value1, value2, "primaryIndustry");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyIsNull() {
            addCriterion("company_property is null");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyIsNotNull() {
            addCriterion("company_property is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyEqualTo(String value) {
            addCriterion("company_property =", value, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyNotEqualTo(String value) {
            addCriterion("company_property <>", value, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyGreaterThan(String value) {
            addCriterion("company_property >", value, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyGreaterThanOrEqualTo(String value) {
            addCriterion("company_property >=", value, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyLessThan(String value) {
            addCriterion("company_property <", value, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyLessThanOrEqualTo(String value) {
            addCriterion("company_property <=", value, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyLike(String value) {
            addCriterion("company_property like", value, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyNotLike(String value) {
            addCriterion("company_property not like", value, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyIn(List<String> values) {
            addCriterion("company_property in", values, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyNotIn(List<String> values) {
            addCriterion("company_property not in", values, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyBetween(String value1, String value2) {
            addCriterion("company_property between", value1, value2, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyNotBetween(String value1, String value2) {
            addCriterion("company_property not between", value1, value2, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andGmtCompanyRegisterIsNull() {
            addCriterion("gmt_company_register is null");
            return (Criteria) this;
        }

        public Criteria andGmtCompanyRegisterIsNotNull() {
            addCriterion("gmt_company_register is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCompanyRegisterEqualTo(Date value) {
            addCriterion("gmt_company_register =", value, "gmtCompanyRegister");
            return (Criteria) this;
        }

        public Criteria andGmtCompanyRegisterNotEqualTo(Date value) {
            addCriterion("gmt_company_register <>", value, "gmtCompanyRegister");
            return (Criteria) this;
        }

        public Criteria andGmtCompanyRegisterGreaterThan(Date value) {
            addCriterion("gmt_company_register >", value, "gmtCompanyRegister");
            return (Criteria) this;
        }

        public Criteria andGmtCompanyRegisterGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_company_register >=", value, "gmtCompanyRegister");
            return (Criteria) this;
        }

        public Criteria andGmtCompanyRegisterLessThan(Date value) {
            addCriterion("gmt_company_register <", value, "gmtCompanyRegister");
            return (Criteria) this;
        }

        public Criteria andGmtCompanyRegisterLessThanOrEqualTo(Date value) {
            addCriterion("gmt_company_register <=", value, "gmtCompanyRegister");
            return (Criteria) this;
        }

        public Criteria andGmtCompanyRegisterIn(List<Date> values) {
            addCriterion("gmt_company_register in", values, "gmtCompanyRegister");
            return (Criteria) this;
        }

        public Criteria andGmtCompanyRegisterNotIn(List<Date> values) {
            addCriterion("gmt_company_register not in", values, "gmtCompanyRegister");
            return (Criteria) this;
        }

        public Criteria andGmtCompanyRegisterBetween(Date value1, Date value2) {
            addCriterion("gmt_company_register between", value1, value2, "gmtCompanyRegister");
            return (Criteria) this;
        }

        public Criteria andGmtCompanyRegisterNotBetween(Date value1, Date value2) {
            addCriterion("gmt_company_register not between", value1, value2, "gmtCompanyRegister");
            return (Criteria) this;
        }

        public Criteria andBusinessRecordsIsNull() {
            addCriterion("business_records is null");
            return (Criteria) this;
        }

        public Criteria andBusinessRecordsIsNotNull() {
            addCriterion("business_records is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessRecordsEqualTo(String value) {
            addCriterion("business_records =", value, "businessRecords");
            return (Criteria) this;
        }

        public Criteria andBusinessRecordsNotEqualTo(String value) {
            addCriterion("business_records <>", value, "businessRecords");
            return (Criteria) this;
        }

        public Criteria andBusinessRecordsGreaterThan(String value) {
            addCriterion("business_records >", value, "businessRecords");
            return (Criteria) this;
        }

        public Criteria andBusinessRecordsGreaterThanOrEqualTo(String value) {
            addCriterion("business_records >=", value, "businessRecords");
            return (Criteria) this;
        }

        public Criteria andBusinessRecordsLessThan(String value) {
            addCriterion("business_records <", value, "businessRecords");
            return (Criteria) this;
        }

        public Criteria andBusinessRecordsLessThanOrEqualTo(String value) {
            addCriterion("business_records <=", value, "businessRecords");
            return (Criteria) this;
        }

        public Criteria andBusinessRecordsLike(String value) {
            addCriterion("business_records like", value, "businessRecords");
            return (Criteria) this;
        }

        public Criteria andBusinessRecordsNotLike(String value) {
            addCriterion("business_records not like", value, "businessRecords");
            return (Criteria) this;
        }

        public Criteria andBusinessRecordsIn(List<String> values) {
            addCriterion("business_records in", values, "businessRecords");
            return (Criteria) this;
        }

        public Criteria andBusinessRecordsNotIn(List<String> values) {
            addCriterion("business_records not in", values, "businessRecords");
            return (Criteria) this;
        }

        public Criteria andBusinessRecordsBetween(String value1, String value2) {
            addCriterion("business_records between", value1, value2, "businessRecords");
            return (Criteria) this;
        }

        public Criteria andBusinessRecordsNotBetween(String value1, String value2) {
            addCriterion("business_records not between", value1, value2, "businessRecords");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNull() {
            addCriterion("gmt_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("gmt_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Date value) {
            addCriterion("gmt_modified =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Date value) {
            addCriterion("gmt_modified <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Date value) {
            addCriterion("gmt_modified >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modified >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Date value) {
            addCriterion("gmt_modified <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modified <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Date> values) {
            addCriterion("gmt_modified in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Date> values) {
            addCriterion("gmt_modified not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Date value1, Date value2) {
            addCriterion("gmt_modified between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmtModified");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}