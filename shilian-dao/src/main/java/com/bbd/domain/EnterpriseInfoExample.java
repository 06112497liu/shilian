package com.bbd.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EnterpriseInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EnterpriseInfoExample() {
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

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
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

        public Criteria andPhonesIsNull() {
            addCriterion("phones is null");
            return (Criteria) this;
        }

        public Criteria andPhonesIsNotNull() {
            addCriterion("phones is not null");
            return (Criteria) this;
        }

        public Criteria andPhonesEqualTo(String value) {
            addCriterion("phones =", value, "phones");
            return (Criteria) this;
        }

        public Criteria andPhonesNotEqualTo(String value) {
            addCriterion("phones <>", value, "phones");
            return (Criteria) this;
        }

        public Criteria andPhonesGreaterThan(String value) {
            addCriterion("phones >", value, "phones");
            return (Criteria) this;
        }

        public Criteria andPhonesGreaterThanOrEqualTo(String value) {
            addCriterion("phones >=", value, "phones");
            return (Criteria) this;
        }

        public Criteria andPhonesLessThan(String value) {
            addCriterion("phones <", value, "phones");
            return (Criteria) this;
        }

        public Criteria andPhonesLessThanOrEqualTo(String value) {
            addCriterion("phones <=", value, "phones");
            return (Criteria) this;
        }

        public Criteria andPhonesLike(String value) {
            addCriterion("phones like", value, "phones");
            return (Criteria) this;
        }

        public Criteria andPhonesNotLike(String value) {
            addCriterion("phones not like", value, "phones");
            return (Criteria) this;
        }

        public Criteria andPhonesIn(List<String> values) {
            addCriterion("phones in", values, "phones");
            return (Criteria) this;
        }

        public Criteria andPhonesNotIn(List<String> values) {
            addCriterion("phones not in", values, "phones");
            return (Criteria) this;
        }

        public Criteria andPhonesBetween(String value1, String value2) {
            addCriterion("phones between", value1, value2, "phones");
            return (Criteria) this;
        }

        public Criteria andPhonesNotBetween(String value1, String value2) {
            addCriterion("phones not between", value1, value2, "phones");
            return (Criteria) this;
        }

        public Criteria andEmailsIsNull() {
            addCriterion("emails is null");
            return (Criteria) this;
        }

        public Criteria andEmailsIsNotNull() {
            addCriterion("emails is not null");
            return (Criteria) this;
        }

        public Criteria andEmailsEqualTo(String value) {
            addCriterion("emails =", value, "emails");
            return (Criteria) this;
        }

        public Criteria andEmailsNotEqualTo(String value) {
            addCriterion("emails <>", value, "emails");
            return (Criteria) this;
        }

        public Criteria andEmailsGreaterThan(String value) {
            addCriterion("emails >", value, "emails");
            return (Criteria) this;
        }

        public Criteria andEmailsGreaterThanOrEqualTo(String value) {
            addCriterion("emails >=", value, "emails");
            return (Criteria) this;
        }

        public Criteria andEmailsLessThan(String value) {
            addCriterion("emails <", value, "emails");
            return (Criteria) this;
        }

        public Criteria andEmailsLessThanOrEqualTo(String value) {
            addCriterion("emails <=", value, "emails");
            return (Criteria) this;
        }

        public Criteria andEmailsLike(String value) {
            addCriterion("emails like", value, "emails");
            return (Criteria) this;
        }

        public Criteria andEmailsNotLike(String value) {
            addCriterion("emails not like", value, "emails");
            return (Criteria) this;
        }

        public Criteria andEmailsIn(List<String> values) {
            addCriterion("emails in", values, "emails");
            return (Criteria) this;
        }

        public Criteria andEmailsNotIn(List<String> values) {
            addCriterion("emails not in", values, "emails");
            return (Criteria) this;
        }

        public Criteria andEmailsBetween(String value1, String value2) {
            addCriterion("emails between", value1, value2, "emails");
            return (Criteria) this;
        }

        public Criteria andEmailsNotBetween(String value1, String value2) {
            addCriterion("emails not between", value1, value2, "emails");
            return (Criteria) this;
        }

        public Criteria andCompanyCreditCodeIsNull() {
            addCriterion("company_credit_code is null");
            return (Criteria) this;
        }

        public Criteria andCompanyCreditCodeIsNotNull() {
            addCriterion("company_credit_code is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyCreditCodeEqualTo(String value) {
            addCriterion("company_credit_code =", value, "companyCreditCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCreditCodeNotEqualTo(String value) {
            addCriterion("company_credit_code <>", value, "companyCreditCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCreditCodeGreaterThan(String value) {
            addCriterion("company_credit_code >", value, "companyCreditCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCreditCodeGreaterThanOrEqualTo(String value) {
            addCriterion("company_credit_code >=", value, "companyCreditCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCreditCodeLessThan(String value) {
            addCriterion("company_credit_code <", value, "companyCreditCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCreditCodeLessThanOrEqualTo(String value) {
            addCriterion("company_credit_code <=", value, "companyCreditCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCreditCodeLike(String value) {
            addCriterion("company_credit_code like", value, "companyCreditCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCreditCodeNotLike(String value) {
            addCriterion("company_credit_code not like", value, "companyCreditCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCreditCodeIn(List<String> values) {
            addCriterion("company_credit_code in", values, "companyCreditCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCreditCodeNotIn(List<String> values) {
            addCriterion("company_credit_code not in", values, "companyCreditCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCreditCodeBetween(String value1, String value2) {
            addCriterion("company_credit_code between", value1, value2, "companyCreditCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCreditCodeNotBetween(String value1, String value2) {
            addCriterion("company_credit_code not between", value1, value2, "companyCreditCode");
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

        public Criteria andPrimaryIndustryInitialIsNull() {
            addCriterion("primary_industry_initial is null");
            return (Criteria) this;
        }

        public Criteria andPrimaryIndustryInitialIsNotNull() {
            addCriterion("primary_industry_initial is not null");
            return (Criteria) this;
        }

        public Criteria andPrimaryIndustryInitialEqualTo(String value) {
            addCriterion("primary_industry_initial =", value, "primaryIndustryInitial");
            return (Criteria) this;
        }

        public Criteria andPrimaryIndustryInitialNotEqualTo(String value) {
            addCriterion("primary_industry_initial <>", value, "primaryIndustryInitial");
            return (Criteria) this;
        }

        public Criteria andPrimaryIndustryInitialGreaterThan(String value) {
            addCriterion("primary_industry_initial >", value, "primaryIndustryInitial");
            return (Criteria) this;
        }

        public Criteria andPrimaryIndustryInitialGreaterThanOrEqualTo(String value) {
            addCriterion("primary_industry_initial >=", value, "primaryIndustryInitial");
            return (Criteria) this;
        }

        public Criteria andPrimaryIndustryInitialLessThan(String value) {
            addCriterion("primary_industry_initial <", value, "primaryIndustryInitial");
            return (Criteria) this;
        }

        public Criteria andPrimaryIndustryInitialLessThanOrEqualTo(String value) {
            addCriterion("primary_industry_initial <=", value, "primaryIndustryInitial");
            return (Criteria) this;
        }

        public Criteria andPrimaryIndustryInitialLike(String value) {
            addCriterion("primary_industry_initial like", value, "primaryIndustryInitial");
            return (Criteria) this;
        }

        public Criteria andPrimaryIndustryInitialNotLike(String value) {
            addCriterion("primary_industry_initial not like", value, "primaryIndustryInitial");
            return (Criteria) this;
        }

        public Criteria andPrimaryIndustryInitialIn(List<String> values) {
            addCriterion("primary_industry_initial in", values, "primaryIndustryInitial");
            return (Criteria) this;
        }

        public Criteria andPrimaryIndustryInitialNotIn(List<String> values) {
            addCriterion("primary_industry_initial not in", values, "primaryIndustryInitial");
            return (Criteria) this;
        }

        public Criteria andPrimaryIndustryInitialBetween(String value1, String value2) {
            addCriterion("primary_industry_initial between", value1, value2, "primaryIndustryInitial");
            return (Criteria) this;
        }

        public Criteria andPrimaryIndustryInitialNotBetween(String value1, String value2) {
            addCriterion("primary_industry_initial not between", value1, value2, "primaryIndustryInitial");
            return (Criteria) this;
        }

        public Criteria andGmtApprovalIsNull() {
            addCriterion("gmt_approval is null");
            return (Criteria) this;
        }

        public Criteria andGmtApprovalIsNotNull() {
            addCriterion("gmt_approval is not null");
            return (Criteria) this;
        }

        public Criteria andGmtApprovalEqualTo(Date value) {
            addCriterion("gmt_approval =", value, "gmtApproval");
            return (Criteria) this;
        }

        public Criteria andGmtApprovalNotEqualTo(Date value) {
            addCriterion("gmt_approval <>", value, "gmtApproval");
            return (Criteria) this;
        }

        public Criteria andGmtApprovalGreaterThan(Date value) {
            addCriterion("gmt_approval >", value, "gmtApproval");
            return (Criteria) this;
        }

        public Criteria andGmtApprovalGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_approval >=", value, "gmtApproval");
            return (Criteria) this;
        }

        public Criteria andGmtApprovalLessThan(Date value) {
            addCriterion("gmt_approval <", value, "gmtApproval");
            return (Criteria) this;
        }

        public Criteria andGmtApprovalLessThanOrEqualTo(Date value) {
            addCriterion("gmt_approval <=", value, "gmtApproval");
            return (Criteria) this;
        }

        public Criteria andGmtApprovalIn(List<Date> values) {
            addCriterion("gmt_approval in", values, "gmtApproval");
            return (Criteria) this;
        }

        public Criteria andGmtApprovalNotIn(List<Date> values) {
            addCriterion("gmt_approval not in", values, "gmtApproval");
            return (Criteria) this;
        }

        public Criteria andGmtApprovalBetween(Date value1, Date value2) {
            addCriterion("gmt_approval between", value1, value2, "gmtApproval");
            return (Criteria) this;
        }

        public Criteria andGmtApprovalNotBetween(Date value1, Date value2) {
            addCriterion("gmt_approval not between", value1, value2, "gmtApproval");
            return (Criteria) this;
        }

        public Criteria andGmtCancelIsNull() {
            addCriterion("gmt_cancel is null");
            return (Criteria) this;
        }

        public Criteria andGmtCancelIsNotNull() {
            addCriterion("gmt_cancel is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCancelEqualTo(Date value) {
            addCriterion("gmt_cancel =", value, "gmtCancel");
            return (Criteria) this;
        }

        public Criteria andGmtCancelNotEqualTo(Date value) {
            addCriterion("gmt_cancel <>", value, "gmtCancel");
            return (Criteria) this;
        }

        public Criteria andGmtCancelGreaterThan(Date value) {
            addCriterion("gmt_cancel >", value, "gmtCancel");
            return (Criteria) this;
        }

        public Criteria andGmtCancelGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_cancel >=", value, "gmtCancel");
            return (Criteria) this;
        }

        public Criteria andGmtCancelLessThan(Date value) {
            addCriterion("gmt_cancel <", value, "gmtCancel");
            return (Criteria) this;
        }

        public Criteria andGmtCancelLessThanOrEqualTo(Date value) {
            addCriterion("gmt_cancel <=", value, "gmtCancel");
            return (Criteria) this;
        }

        public Criteria andGmtCancelIn(List<Date> values) {
            addCriterion("gmt_cancel in", values, "gmtCancel");
            return (Criteria) this;
        }

        public Criteria andGmtCancelNotIn(List<Date> values) {
            addCriterion("gmt_cancel not in", values, "gmtCancel");
            return (Criteria) this;
        }

        public Criteria andGmtCancelBetween(Date value1, Date value2) {
            addCriterion("gmt_cancel between", value1, value2, "gmtCancel");
            return (Criteria) this;
        }

        public Criteria andGmtCancelNotBetween(Date value1, Date value2) {
            addCriterion("gmt_cancel not between", value1, value2, "gmtCancel");
            return (Criteria) this;
        }

        public Criteria andGmtSuspendIsNull() {
            addCriterion("gmt_suspend is null");
            return (Criteria) this;
        }

        public Criteria andGmtSuspendIsNotNull() {
            addCriterion("gmt_suspend is not null");
            return (Criteria) this;
        }

        public Criteria andGmtSuspendEqualTo(Date value) {
            addCriterion("gmt_suspend =", value, "gmtSuspend");
            return (Criteria) this;
        }

        public Criteria andGmtSuspendNotEqualTo(Date value) {
            addCriterion("gmt_suspend <>", value, "gmtSuspend");
            return (Criteria) this;
        }

        public Criteria andGmtSuspendGreaterThan(Date value) {
            addCriterion("gmt_suspend >", value, "gmtSuspend");
            return (Criteria) this;
        }

        public Criteria andGmtSuspendGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_suspend >=", value, "gmtSuspend");
            return (Criteria) this;
        }

        public Criteria andGmtSuspendLessThan(Date value) {
            addCriterion("gmt_suspend <", value, "gmtSuspend");
            return (Criteria) this;
        }

        public Criteria andGmtSuspendLessThanOrEqualTo(Date value) {
            addCriterion("gmt_suspend <=", value, "gmtSuspend");
            return (Criteria) this;
        }

        public Criteria andGmtSuspendIn(List<Date> values) {
            addCriterion("gmt_suspend in", values, "gmtSuspend");
            return (Criteria) this;
        }

        public Criteria andGmtSuspendNotIn(List<Date> values) {
            addCriterion("gmt_suspend not in", values, "gmtSuspend");
            return (Criteria) this;
        }

        public Criteria andGmtSuspendBetween(Date value1, Date value2) {
            addCriterion("gmt_suspend between", value1, value2, "gmtSuspend");
            return (Criteria) this;
        }

        public Criteria andGmtSuspendNotBetween(Date value1, Date value2) {
            addCriterion("gmt_suspend not between", value1, value2, "gmtSuspend");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeIsNull() {
            addCriterion("company_type is null");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeIsNotNull() {
            addCriterion("company_type is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeEqualTo(String value) {
            addCriterion("company_type =", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeNotEqualTo(String value) {
            addCriterion("company_type <>", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeGreaterThan(String value) {
            addCriterion("company_type >", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("company_type >=", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeLessThan(String value) {
            addCriterion("company_type <", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeLessThanOrEqualTo(String value) {
            addCriterion("company_type <=", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeLike(String value) {
            addCriterion("company_type like", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeNotLike(String value) {
            addCriterion("company_type not like", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeIn(List<String> values) {
            addCriterion("company_type in", values, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeNotIn(List<String> values) {
            addCriterion("company_type not in", values, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeBetween(String value1, String value2) {
            addCriterion("company_type between", value1, value2, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeNotBetween(String value1, String value2) {
            addCriterion("company_type not between", value1, value2, "companyType");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberIsNull() {
            addCriterion("register_number is null");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberIsNotNull() {
            addCriterion("register_number is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberEqualTo(String value) {
            addCriterion("register_number =", value, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberNotEqualTo(String value) {
            addCriterion("register_number <>", value, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberGreaterThan(String value) {
            addCriterion("register_number >", value, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberGreaterThanOrEqualTo(String value) {
            addCriterion("register_number >=", value, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberLessThan(String value) {
            addCriterion("register_number <", value, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberLessThanOrEqualTo(String value) {
            addCriterion("register_number <=", value, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberLike(String value) {
            addCriterion("register_number like", value, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberNotLike(String value) {
            addCriterion("register_number not like", value, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberIn(List<String> values) {
            addCriterion("register_number in", values, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberNotIn(List<String> values) {
            addCriterion("register_number not in", values, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberBetween(String value1, String value2) {
            addCriterion("register_number between", value1, value2, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberNotBetween(String value1, String value2) {
            addCriterion("register_number not between", value1, value2, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterCapitalIsNull() {
            addCriterion("register_capital is null");
            return (Criteria) this;
        }

        public Criteria andRegisterCapitalIsNotNull() {
            addCriterion("register_capital is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterCapitalEqualTo(Float value) {
            addCriterion("register_capital =", value, "registerCapital");
            return (Criteria) this;
        }

        public Criteria andRegisterCapitalNotEqualTo(Float value) {
            addCriterion("register_capital <>", value, "registerCapital");
            return (Criteria) this;
        }

        public Criteria andRegisterCapitalGreaterThan(Float value) {
            addCriterion("register_capital >", value, "registerCapital");
            return (Criteria) this;
        }

        public Criteria andRegisterCapitalGreaterThanOrEqualTo(Float value) {
            addCriterion("register_capital >=", value, "registerCapital");
            return (Criteria) this;
        }

        public Criteria andRegisterCapitalLessThan(Float value) {
            addCriterion("register_capital <", value, "registerCapital");
            return (Criteria) this;
        }

        public Criteria andRegisterCapitalLessThanOrEqualTo(Float value) {
            addCriterion("register_capital <=", value, "registerCapital");
            return (Criteria) this;
        }

        public Criteria andRegisterCapitalIn(List<Float> values) {
            addCriterion("register_capital in", values, "registerCapital");
            return (Criteria) this;
        }

        public Criteria andRegisterCapitalNotIn(List<Float> values) {
            addCriterion("register_capital not in", values, "registerCapital");
            return (Criteria) this;
        }

        public Criteria andRegisterCapitalBetween(Float value1, Float value2) {
            addCriterion("register_capital between", value1, value2, "registerCapital");
            return (Criteria) this;
        }

        public Criteria andRegisterCapitalNotBetween(Float value1, Float value2) {
            addCriterion("register_capital not between", value1, value2, "registerCapital");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIsNull() {
            addCriterion("legal_person is null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIsNotNull() {
            addCriterion("legal_person is not null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonEqualTo(String value) {
            addCriterion("legal_person =", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotEqualTo(String value) {
            addCriterion("legal_person <>", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonGreaterThan(String value) {
            addCriterion("legal_person >", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonGreaterThanOrEqualTo(String value) {
            addCriterion("legal_person >=", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonLessThan(String value) {
            addCriterion("legal_person <", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonLessThanOrEqualTo(String value) {
            addCriterion("legal_person <=", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonLike(String value) {
            addCriterion("legal_person like", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotLike(String value) {
            addCriterion("legal_person not like", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIn(List<String> values) {
            addCriterion("legal_person in", values, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotIn(List<String> values) {
            addCriterion("legal_person not in", values, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonBetween(String value1, String value2) {
            addCriterion("legal_person between", value1, value2, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotBetween(String value1, String value2) {
            addCriterion("legal_person not between", value1, value2, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andRegisterAuthorityIsNull() {
            addCriterion("register_authority is null");
            return (Criteria) this;
        }

        public Criteria andRegisterAuthorityIsNotNull() {
            addCriterion("register_authority is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterAuthorityEqualTo(String value) {
            addCriterion("register_authority =", value, "registerAuthority");
            return (Criteria) this;
        }

        public Criteria andRegisterAuthorityNotEqualTo(String value) {
            addCriterion("register_authority <>", value, "registerAuthority");
            return (Criteria) this;
        }

        public Criteria andRegisterAuthorityGreaterThan(String value) {
            addCriterion("register_authority >", value, "registerAuthority");
            return (Criteria) this;
        }

        public Criteria andRegisterAuthorityGreaterThanOrEqualTo(String value) {
            addCriterion("register_authority >=", value, "registerAuthority");
            return (Criteria) this;
        }

        public Criteria andRegisterAuthorityLessThan(String value) {
            addCriterion("register_authority <", value, "registerAuthority");
            return (Criteria) this;
        }

        public Criteria andRegisterAuthorityLessThanOrEqualTo(String value) {
            addCriterion("register_authority <=", value, "registerAuthority");
            return (Criteria) this;
        }

        public Criteria andRegisterAuthorityLike(String value) {
            addCriterion("register_authority like", value, "registerAuthority");
            return (Criteria) this;
        }

        public Criteria andRegisterAuthorityNotLike(String value) {
            addCriterion("register_authority not like", value, "registerAuthority");
            return (Criteria) this;
        }

        public Criteria andRegisterAuthorityIn(List<String> values) {
            addCriterion("register_authority in", values, "registerAuthority");
            return (Criteria) this;
        }

        public Criteria andRegisterAuthorityNotIn(List<String> values) {
            addCriterion("register_authority not in", values, "registerAuthority");
            return (Criteria) this;
        }

        public Criteria andRegisterAuthorityBetween(String value1, String value2) {
            addCriterion("register_authority between", value1, value2, "registerAuthority");
            return (Criteria) this;
        }

        public Criteria andRegisterAuthorityNotBetween(String value1, String value2) {
            addCriterion("register_authority not between", value1, value2, "registerAuthority");
            return (Criteria) this;
        }

        public Criteria andRegisterStatusIsNull() {
            addCriterion("register_status is null");
            return (Criteria) this;
        }

        public Criteria andRegisterStatusIsNotNull() {
            addCriterion("register_status is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterStatusEqualTo(String value) {
            addCriterion("register_status =", value, "registerStatus");
            return (Criteria) this;
        }

        public Criteria andRegisterStatusNotEqualTo(String value) {
            addCriterion("register_status <>", value, "registerStatus");
            return (Criteria) this;
        }

        public Criteria andRegisterStatusGreaterThan(String value) {
            addCriterion("register_status >", value, "registerStatus");
            return (Criteria) this;
        }

        public Criteria andRegisterStatusGreaterThanOrEqualTo(String value) {
            addCriterion("register_status >=", value, "registerStatus");
            return (Criteria) this;
        }

        public Criteria andRegisterStatusLessThan(String value) {
            addCriterion("register_status <", value, "registerStatus");
            return (Criteria) this;
        }

        public Criteria andRegisterStatusLessThanOrEqualTo(String value) {
            addCriterion("register_status <=", value, "registerStatus");
            return (Criteria) this;
        }

        public Criteria andRegisterStatusLike(String value) {
            addCriterion("register_status like", value, "registerStatus");
            return (Criteria) this;
        }

        public Criteria andRegisterStatusNotLike(String value) {
            addCriterion("register_status not like", value, "registerStatus");
            return (Criteria) this;
        }

        public Criteria andRegisterStatusIn(List<String> values) {
            addCriterion("register_status in", values, "registerStatus");
            return (Criteria) this;
        }

        public Criteria andRegisterStatusNotIn(List<String> values) {
            addCriterion("register_status not in", values, "registerStatus");
            return (Criteria) this;
        }

        public Criteria andRegisterStatusBetween(String value1, String value2) {
            addCriterion("register_status between", value1, value2, "registerStatus");
            return (Criteria) this;
        }

        public Criteria andRegisterStatusNotBetween(String value1, String value2) {
            addCriterion("register_status not between", value1, value2, "registerStatus");
            return (Criteria) this;
        }

        public Criteria andOperateScopeIsNull() {
            addCriterion("operate_scope is null");
            return (Criteria) this;
        }

        public Criteria andOperateScopeIsNotNull() {
            addCriterion("operate_scope is not null");
            return (Criteria) this;
        }

        public Criteria andOperateScopeEqualTo(String value) {
            addCriterion("operate_scope =", value, "operateScope");
            return (Criteria) this;
        }

        public Criteria andOperateScopeNotEqualTo(String value) {
            addCriterion("operate_scope <>", value, "operateScope");
            return (Criteria) this;
        }

        public Criteria andOperateScopeGreaterThan(String value) {
            addCriterion("operate_scope >", value, "operateScope");
            return (Criteria) this;
        }

        public Criteria andOperateScopeGreaterThanOrEqualTo(String value) {
            addCriterion("operate_scope >=", value, "operateScope");
            return (Criteria) this;
        }

        public Criteria andOperateScopeLessThan(String value) {
            addCriterion("operate_scope <", value, "operateScope");
            return (Criteria) this;
        }

        public Criteria andOperateScopeLessThanOrEqualTo(String value) {
            addCriterion("operate_scope <=", value, "operateScope");
            return (Criteria) this;
        }

        public Criteria andOperateScopeLike(String value) {
            addCriterion("operate_scope like", value, "operateScope");
            return (Criteria) this;
        }

        public Criteria andOperateScopeNotLike(String value) {
            addCriterion("operate_scope not like", value, "operateScope");
            return (Criteria) this;
        }

        public Criteria andOperateScopeIn(List<String> values) {
            addCriterion("operate_scope in", values, "operateScope");
            return (Criteria) this;
        }

        public Criteria andOperateScopeNotIn(List<String> values) {
            addCriterion("operate_scope not in", values, "operateScope");
            return (Criteria) this;
        }

        public Criteria andOperateScopeBetween(String value1, String value2) {
            addCriterion("operate_scope between", value1, value2, "operateScope");
            return (Criteria) this;
        }

        public Criteria andOperateScopeNotBetween(String value1, String value2) {
            addCriterion("operate_scope not between", value1, value2, "operateScope");
            return (Criteria) this;
        }

        public Criteria andNameTypeIsNull() {
            addCriterion("name_type is null");
            return (Criteria) this;
        }

        public Criteria andNameTypeIsNotNull() {
            addCriterion("name_type is not null");
            return (Criteria) this;
        }

        public Criteria andNameTypeEqualTo(String value) {
            addCriterion("name_type =", value, "nameType");
            return (Criteria) this;
        }

        public Criteria andNameTypeNotEqualTo(String value) {
            addCriterion("name_type <>", value, "nameType");
            return (Criteria) this;
        }

        public Criteria andNameTypeGreaterThan(String value) {
            addCriterion("name_type >", value, "nameType");
            return (Criteria) this;
        }

        public Criteria andNameTypeGreaterThanOrEqualTo(String value) {
            addCriterion("name_type >=", value, "nameType");
            return (Criteria) this;
        }

        public Criteria andNameTypeLessThan(String value) {
            addCriterion("name_type <", value, "nameType");
            return (Criteria) this;
        }

        public Criteria andNameTypeLessThanOrEqualTo(String value) {
            addCriterion("name_type <=", value, "nameType");
            return (Criteria) this;
        }

        public Criteria andNameTypeLike(String value) {
            addCriterion("name_type like", value, "nameType");
            return (Criteria) this;
        }

        public Criteria andNameTypeNotLike(String value) {
            addCriterion("name_type not like", value, "nameType");
            return (Criteria) this;
        }

        public Criteria andNameTypeIn(List<String> values) {
            addCriterion("name_type in", values, "nameType");
            return (Criteria) this;
        }

        public Criteria andNameTypeNotIn(List<String> values) {
            addCriterion("name_type not in", values, "nameType");
            return (Criteria) this;
        }

        public Criteria andNameTypeBetween(String value1, String value2) {
            addCriterion("name_type between", value1, value2, "nameType");
            return (Criteria) this;
        }

        public Criteria andNameTypeNotBetween(String value1, String value2) {
            addCriterion("name_type not between", value1, value2, "nameType");
            return (Criteria) this;
        }

        public Criteria andAddrIsNull() {
            addCriterion("addr is null");
            return (Criteria) this;
        }

        public Criteria andAddrIsNotNull() {
            addCriterion("addr is not null");
            return (Criteria) this;
        }

        public Criteria andAddrEqualTo(String value) {
            addCriterion("addr =", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotEqualTo(String value) {
            addCriterion("addr <>", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThan(String value) {
            addCriterion("addr >", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThanOrEqualTo(String value) {
            addCriterion("addr >=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThan(String value) {
            addCriterion("addr <", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThanOrEqualTo(String value) {
            addCriterion("addr <=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLike(String value) {
            addCriterion("addr like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotLike(String value) {
            addCriterion("addr not like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrIn(List<String> values) {
            addCriterion("addr in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotIn(List<String> values) {
            addCriterion("addr not in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrBetween(String value1, String value2) {
            addCriterion("addr between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotBetween(String value1, String value2) {
            addCriterion("addr not between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(Double value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(Double value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(Double value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(Double value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(Double value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<Double> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<Double> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(Double value1, Double value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(Double value1, Double value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(Double value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(Double value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(Double value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(Double value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(Double value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<Double> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<Double> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(Double value1, Double value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(Double value1, Double value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
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

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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

        public Criteria andCompanyPropertyIsNull() {
            addCriterion("company_property is null");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyIsNotNull() {
            addCriterion("company_property is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyEqualTo(Integer value) {
            addCriterion("company_property =", value, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyNotEqualTo(Integer value) {
            addCriterion("company_property <>", value, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyGreaterThan(Integer value) {
            addCriterion("company_property >", value, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_property >=", value, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyLessThan(Integer value) {
            addCriterion("company_property <", value, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyLessThanOrEqualTo(Integer value) {
            addCriterion("company_property <=", value, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyIn(List<Integer> values) {
            addCriterion("company_property in", values, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyNotIn(List<Integer> values) {
            addCriterion("company_property not in", values, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyBetween(Integer value1, Integer value2) {
            addCriterion("company_property between", value1, value2, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyNotBetween(Integer value1, Integer value2) {
            addCriterion("company_property not between", value1, value2, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andAnnualStateIsNull() {
            addCriterion("annual_state is null");
            return (Criteria) this;
        }

        public Criteria andAnnualStateIsNotNull() {
            addCriterion("annual_state is not null");
            return (Criteria) this;
        }

        public Criteria andAnnualStateEqualTo(Integer value) {
            addCriterion("annual_state =", value, "annualState");
            return (Criteria) this;
        }

        public Criteria andAnnualStateNotEqualTo(Integer value) {
            addCriterion("annual_state <>", value, "annualState");
            return (Criteria) this;
        }

        public Criteria andAnnualStateGreaterThan(Integer value) {
            addCriterion("annual_state >", value, "annualState");
            return (Criteria) this;
        }

        public Criteria andAnnualStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("annual_state >=", value, "annualState");
            return (Criteria) this;
        }

        public Criteria andAnnualStateLessThan(Integer value) {
            addCriterion("annual_state <", value, "annualState");
            return (Criteria) this;
        }

        public Criteria andAnnualStateLessThanOrEqualTo(Integer value) {
            addCriterion("annual_state <=", value, "annualState");
            return (Criteria) this;
        }

        public Criteria andAnnualStateIn(List<Integer> values) {
            addCriterion("annual_state in", values, "annualState");
            return (Criteria) this;
        }

        public Criteria andAnnualStateNotIn(List<Integer> values) {
            addCriterion("annual_state not in", values, "annualState");
            return (Criteria) this;
        }

        public Criteria andAnnualStateBetween(Integer value1, Integer value2) {
            addCriterion("annual_state between", value1, value2, "annualState");
            return (Criteria) this;
        }

        public Criteria andAnnualStateNotBetween(Integer value1, Integer value2) {
            addCriterion("annual_state not between", value1, value2, "annualState");
            return (Criteria) this;
        }

        public Criteria andAbnormalStateIsNull() {
            addCriterion("abnormal_state is null");
            return (Criteria) this;
        }

        public Criteria andAbnormalStateIsNotNull() {
            addCriterion("abnormal_state is not null");
            return (Criteria) this;
        }

        public Criteria andAbnormalStateEqualTo(Integer value) {
            addCriterion("abnormal_state =", value, "abnormalState");
            return (Criteria) this;
        }

        public Criteria andAbnormalStateNotEqualTo(Integer value) {
            addCriterion("abnormal_state <>", value, "abnormalState");
            return (Criteria) this;
        }

        public Criteria andAbnormalStateGreaterThan(Integer value) {
            addCriterion("abnormal_state >", value, "abnormalState");
            return (Criteria) this;
        }

        public Criteria andAbnormalStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("abnormal_state >=", value, "abnormalState");
            return (Criteria) this;
        }

        public Criteria andAbnormalStateLessThan(Integer value) {
            addCriterion("abnormal_state <", value, "abnormalState");
            return (Criteria) this;
        }

        public Criteria andAbnormalStateLessThanOrEqualTo(Integer value) {
            addCriterion("abnormal_state <=", value, "abnormalState");
            return (Criteria) this;
        }

        public Criteria andAbnormalStateIn(List<Integer> values) {
            addCriterion("abnormal_state in", values, "abnormalState");
            return (Criteria) this;
        }

        public Criteria andAbnormalStateNotIn(List<Integer> values) {
            addCriterion("abnormal_state not in", values, "abnormalState");
            return (Criteria) this;
        }

        public Criteria andAbnormalStateBetween(Integer value1, Integer value2) {
            addCriterion("abnormal_state between", value1, value2, "abnormalState");
            return (Criteria) this;
        }

        public Criteria andAbnormalStateNotBetween(Integer value1, Integer value2) {
            addCriterion("abnormal_state not between", value1, value2, "abnormalState");
            return (Criteria) this;
        }

        public Criteria andIndexScoreIsNull() {
            addCriterion("index_score is null");
            return (Criteria) this;
        }

        public Criteria andIndexScoreIsNotNull() {
            addCriterion("index_score is not null");
            return (Criteria) this;
        }

        public Criteria andIndexScoreEqualTo(Double value) {
            addCriterion("index_score =", value, "indexScore");
            return (Criteria) this;
        }

        public Criteria andIndexScoreNotEqualTo(Double value) {
            addCriterion("index_score <>", value, "indexScore");
            return (Criteria) this;
        }

        public Criteria andIndexScoreGreaterThan(Double value) {
            addCriterion("index_score >", value, "indexScore");
            return (Criteria) this;
        }

        public Criteria andIndexScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("index_score >=", value, "indexScore");
            return (Criteria) this;
        }

        public Criteria andIndexScoreLessThan(Double value) {
            addCriterion("index_score <", value, "indexScore");
            return (Criteria) this;
        }

        public Criteria andIndexScoreLessThanOrEqualTo(Double value) {
            addCriterion("index_score <=", value, "indexScore");
            return (Criteria) this;
        }

        public Criteria andIndexScoreIn(List<Double> values) {
            addCriterion("index_score in", values, "indexScore");
            return (Criteria) this;
        }

        public Criteria andIndexScoreNotIn(List<Double> values) {
            addCriterion("index_score not in", values, "indexScore");
            return (Criteria) this;
        }

        public Criteria andIndexScoreBetween(Double value1, Double value2) {
            addCriterion("index_score between", value1, value2, "indexScore");
            return (Criteria) this;
        }

        public Criteria andIndexScoreNotBetween(Double value1, Double value2) {
            addCriterion("index_score not between", value1, value2, "indexScore");
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

        public Criteria andAnnualEmailsIsNull() {
            addCriterion("annual_emails is null");
            return (Criteria) this;
        }

        public Criteria andAnnualEmailsIsNotNull() {
            addCriterion("annual_emails is not null");
            return (Criteria) this;
        }

        public Criteria andAnnualEmailsEqualTo(String value) {
            addCriterion("annual_emails =", value, "annualEmails");
            return (Criteria) this;
        }

        public Criteria andAnnualEmailsNotEqualTo(String value) {
            addCriterion("annual_emails <>", value, "annualEmails");
            return (Criteria) this;
        }

        public Criteria andAnnualEmailsGreaterThan(String value) {
            addCriterion("annual_emails >", value, "annualEmails");
            return (Criteria) this;
        }

        public Criteria andAnnualEmailsGreaterThanOrEqualTo(String value) {
            addCriterion("annual_emails >=", value, "annualEmails");
            return (Criteria) this;
        }

        public Criteria andAnnualEmailsLessThan(String value) {
            addCriterion("annual_emails <", value, "annualEmails");
            return (Criteria) this;
        }

        public Criteria andAnnualEmailsLessThanOrEqualTo(String value) {
            addCriterion("annual_emails <=", value, "annualEmails");
            return (Criteria) this;
        }

        public Criteria andAnnualEmailsLike(String value) {
            addCriterion("annual_emails like", value, "annualEmails");
            return (Criteria) this;
        }

        public Criteria andAnnualEmailsNotLike(String value) {
            addCriterion("annual_emails not like", value, "annualEmails");
            return (Criteria) this;
        }

        public Criteria andAnnualEmailsIn(List<String> values) {
            addCriterion("annual_emails in", values, "annualEmails");
            return (Criteria) this;
        }

        public Criteria andAnnualEmailsNotIn(List<String> values) {
            addCriterion("annual_emails not in", values, "annualEmails");
            return (Criteria) this;
        }

        public Criteria andAnnualEmailsBetween(String value1, String value2) {
            addCriterion("annual_emails between", value1, value2, "annualEmails");
            return (Criteria) this;
        }

        public Criteria andAnnualEmailsNotBetween(String value1, String value2) {
            addCriterion("annual_emails not between", value1, value2, "annualEmails");
            return (Criteria) this;
        }

        public Criteria andAnnualPhonesIsNull() {
            addCriterion("annual_phones is null");
            return (Criteria) this;
        }

        public Criteria andAnnualPhonesIsNotNull() {
            addCriterion("annual_phones is not null");
            return (Criteria) this;
        }

        public Criteria andAnnualPhonesEqualTo(String value) {
            addCriterion("annual_phones =", value, "annualPhones");
            return (Criteria) this;
        }

        public Criteria andAnnualPhonesNotEqualTo(String value) {
            addCriterion("annual_phones <>", value, "annualPhones");
            return (Criteria) this;
        }

        public Criteria andAnnualPhonesGreaterThan(String value) {
            addCriterion("annual_phones >", value, "annualPhones");
            return (Criteria) this;
        }

        public Criteria andAnnualPhonesGreaterThanOrEqualTo(String value) {
            addCriterion("annual_phones >=", value, "annualPhones");
            return (Criteria) this;
        }

        public Criteria andAnnualPhonesLessThan(String value) {
            addCriterion("annual_phones <", value, "annualPhones");
            return (Criteria) this;
        }

        public Criteria andAnnualPhonesLessThanOrEqualTo(String value) {
            addCriterion("annual_phones <=", value, "annualPhones");
            return (Criteria) this;
        }

        public Criteria andAnnualPhonesLike(String value) {
            addCriterion("annual_phones like", value, "annualPhones");
            return (Criteria) this;
        }

        public Criteria andAnnualPhonesNotLike(String value) {
            addCriterion("annual_phones not like", value, "annualPhones");
            return (Criteria) this;
        }

        public Criteria andAnnualPhonesIn(List<String> values) {
            addCriterion("annual_phones in", values, "annualPhones");
            return (Criteria) this;
        }

        public Criteria andAnnualPhonesNotIn(List<String> values) {
            addCriterion("annual_phones not in", values, "annualPhones");
            return (Criteria) this;
        }

        public Criteria andAnnualPhonesBetween(String value1, String value2) {
            addCriterion("annual_phones between", value1, value2, "annualPhones");
            return (Criteria) this;
        }

        public Criteria andAnnualPhonesNotBetween(String value1, String value2) {
            addCriterion("annual_phones not between", value1, value2, "annualPhones");
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andZsxzqhIsNull() {
            addCriterion("zsxzqh is null");
            return (Criteria) this;
        }

        public Criteria andZsxzqhIsNotNull() {
            addCriterion("zsxzqh is not null");
            return (Criteria) this;
        }

        public Criteria andZsxzqhEqualTo(String value) {
            addCriterion("zsxzqh =", value, "zsxzqh");
            return (Criteria) this;
        }

        public Criteria andZsxzqhNotEqualTo(String value) {
            addCriterion("zsxzqh <>", value, "zsxzqh");
            return (Criteria) this;
        }

        public Criteria andZsxzqhGreaterThan(String value) {
            addCriterion("zsxzqh >", value, "zsxzqh");
            return (Criteria) this;
        }

        public Criteria andZsxzqhGreaterThanOrEqualTo(String value) {
            addCriterion("zsxzqh >=", value, "zsxzqh");
            return (Criteria) this;
        }

        public Criteria andZsxzqhLessThan(String value) {
            addCriterion("zsxzqh <", value, "zsxzqh");
            return (Criteria) this;
        }

        public Criteria andZsxzqhLessThanOrEqualTo(String value) {
            addCriterion("zsxzqh <=", value, "zsxzqh");
            return (Criteria) this;
        }

        public Criteria andZsxzqhLike(String value) {
            addCriterion("zsxzqh like", value, "zsxzqh");
            return (Criteria) this;
        }

        public Criteria andZsxzqhNotLike(String value) {
            addCriterion("zsxzqh not like", value, "zsxzqh");
            return (Criteria) this;
        }

        public Criteria andZsxzqhIn(List<String> values) {
            addCriterion("zsxzqh in", values, "zsxzqh");
            return (Criteria) this;
        }

        public Criteria andZsxzqhNotIn(List<String> values) {
            addCriterion("zsxzqh not in", values, "zsxzqh");
            return (Criteria) this;
        }

        public Criteria andZsxzqhBetween(String value1, String value2) {
            addCriterion("zsxzqh between", value1, value2, "zsxzqh");
            return (Criteria) this;
        }

        public Criteria andZsxzqhNotBetween(String value1, String value2) {
            addCriterion("zsxzqh not between", value1, value2, "zsxzqh");
            return (Criteria) this;
        }

        public Criteria andLockReasonIsNull() {
            addCriterion("lock_reason is null");
            return (Criteria) this;
        }

        public Criteria andLockReasonIsNotNull() {
            addCriterion("lock_reason is not null");
            return (Criteria) this;
        }

        public Criteria andLockReasonEqualTo(String value) {
            addCriterion("lock_reason =", value, "lockReason");
            return (Criteria) this;
        }

        public Criteria andLockReasonNotEqualTo(String value) {
            addCriterion("lock_reason <>", value, "lockReason");
            return (Criteria) this;
        }

        public Criteria andLockReasonGreaterThan(String value) {
            addCriterion("lock_reason >", value, "lockReason");
            return (Criteria) this;
        }

        public Criteria andLockReasonGreaterThanOrEqualTo(String value) {
            addCriterion("lock_reason >=", value, "lockReason");
            return (Criteria) this;
        }

        public Criteria andLockReasonLessThan(String value) {
            addCriterion("lock_reason <", value, "lockReason");
            return (Criteria) this;
        }

        public Criteria andLockReasonLessThanOrEqualTo(String value) {
            addCriterion("lock_reason <=", value, "lockReason");
            return (Criteria) this;
        }

        public Criteria andLockReasonLike(String value) {
            addCriterion("lock_reason like", value, "lockReason");
            return (Criteria) this;
        }

        public Criteria andLockReasonNotLike(String value) {
            addCriterion("lock_reason not like", value, "lockReason");
            return (Criteria) this;
        }

        public Criteria andLockReasonIn(List<String> values) {
            addCriterion("lock_reason in", values, "lockReason");
            return (Criteria) this;
        }

        public Criteria andLockReasonNotIn(List<String> values) {
            addCriterion("lock_reason not in", values, "lockReason");
            return (Criteria) this;
        }

        public Criteria andLockReasonBetween(String value1, String value2) {
            addCriterion("lock_reason between", value1, value2, "lockReason");
            return (Criteria) this;
        }

        public Criteria andLockReasonNotBetween(String value1, String value2) {
            addCriterion("lock_reason not between", value1, value2, "lockReason");
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