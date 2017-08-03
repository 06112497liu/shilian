package com.bbd.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IndexRecruitInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IndexRecruitInfoExample() {
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

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(String value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(String value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(String value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(String value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(String value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(String value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLike(String value) {
            addCriterion("company_id like", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotLike(String value) {
            addCriterion("company_id not like", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<String> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<String> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(String value1, String value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(String value1, String value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andIndexTypeIdIsNull() {
            addCriterion("index_type_id is null");
            return (Criteria) this;
        }

        public Criteria andIndexTypeIdIsNotNull() {
            addCriterion("index_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andIndexTypeIdEqualTo(Integer value) {
            addCriterion("index_type_id =", value, "indexTypeId");
            return (Criteria) this;
        }

        public Criteria andIndexTypeIdNotEqualTo(Integer value) {
            addCriterion("index_type_id <>", value, "indexTypeId");
            return (Criteria) this;
        }

        public Criteria andIndexTypeIdGreaterThan(Integer value) {
            addCriterion("index_type_id >", value, "indexTypeId");
            return (Criteria) this;
        }

        public Criteria andIndexTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("index_type_id >=", value, "indexTypeId");
            return (Criteria) this;
        }

        public Criteria andIndexTypeIdLessThan(Integer value) {
            addCriterion("index_type_id <", value, "indexTypeId");
            return (Criteria) this;
        }

        public Criteria andIndexTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("index_type_id <=", value, "indexTypeId");
            return (Criteria) this;
        }

        public Criteria andIndexTypeIdIn(List<Integer> values) {
            addCriterion("index_type_id in", values, "indexTypeId");
            return (Criteria) this;
        }

        public Criteria andIndexTypeIdNotIn(List<Integer> values) {
            addCriterion("index_type_id not in", values, "indexTypeId");
            return (Criteria) this;
        }

        public Criteria andIndexTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("index_type_id between", value1, value2, "indexTypeId");
            return (Criteria) this;
        }

        public Criteria andIndexTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("index_type_id not between", value1, value2, "indexTypeId");
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

        public Criteria andRecruitDateIsNull() {
            addCriterion("recruit_date is null");
            return (Criteria) this;
        }

        public Criteria andRecruitDateIsNotNull() {
            addCriterion("recruit_date is not null");
            return (Criteria) this;
        }

        public Criteria andRecruitDateEqualTo(Date value) {
            addCriterion("recruit_date =", value, "recruitDate");
            return (Criteria) this;
        }

        public Criteria andRecruitDateNotEqualTo(Date value) {
            addCriterion("recruit_date <>", value, "recruitDate");
            return (Criteria) this;
        }

        public Criteria andRecruitDateGreaterThan(Date value) {
            addCriterion("recruit_date >", value, "recruitDate");
            return (Criteria) this;
        }

        public Criteria andRecruitDateGreaterThanOrEqualTo(Date value) {
            addCriterion("recruit_date >=", value, "recruitDate");
            return (Criteria) this;
        }

        public Criteria andRecruitDateLessThan(Date value) {
            addCriterion("recruit_date <", value, "recruitDate");
            return (Criteria) this;
        }

        public Criteria andRecruitDateLessThanOrEqualTo(Date value) {
            addCriterion("recruit_date <=", value, "recruitDate");
            return (Criteria) this;
        }

        public Criteria andRecruitDateIn(List<Date> values) {
            addCriterion("recruit_date in", values, "recruitDate");
            return (Criteria) this;
        }

        public Criteria andRecruitDateNotIn(List<Date> values) {
            addCriterion("recruit_date not in", values, "recruitDate");
            return (Criteria) this;
        }

        public Criteria andRecruitDateBetween(Date value1, Date value2) {
            addCriterion("recruit_date between", value1, value2, "recruitDate");
            return (Criteria) this;
        }

        public Criteria andRecruitDateNotBetween(Date value1, Date value2) {
            addCriterion("recruit_date not between", value1, value2, "recruitDate");
            return (Criteria) this;
        }

        public Criteria andRecruitNumIsNull() {
            addCriterion("recruit_num is null");
            return (Criteria) this;
        }

        public Criteria andRecruitNumIsNotNull() {
            addCriterion("recruit_num is not null");
            return (Criteria) this;
        }

        public Criteria andRecruitNumEqualTo(String value) {
            addCriterion("recruit_num =", value, "recruitNum");
            return (Criteria) this;
        }

        public Criteria andRecruitNumNotEqualTo(String value) {
            addCriterion("recruit_num <>", value, "recruitNum");
            return (Criteria) this;
        }

        public Criteria andRecruitNumGreaterThan(String value) {
            addCriterion("recruit_num >", value, "recruitNum");
            return (Criteria) this;
        }

        public Criteria andRecruitNumGreaterThanOrEqualTo(String value) {
            addCriterion("recruit_num >=", value, "recruitNum");
            return (Criteria) this;
        }

        public Criteria andRecruitNumLessThan(String value) {
            addCriterion("recruit_num <", value, "recruitNum");
            return (Criteria) this;
        }

        public Criteria andRecruitNumLessThanOrEqualTo(String value) {
            addCriterion("recruit_num <=", value, "recruitNum");
            return (Criteria) this;
        }

        public Criteria andRecruitNumLike(String value) {
            addCriterion("recruit_num like", value, "recruitNum");
            return (Criteria) this;
        }

        public Criteria andRecruitNumNotLike(String value) {
            addCriterion("recruit_num not like", value, "recruitNum");
            return (Criteria) this;
        }

        public Criteria andRecruitNumIn(List<String> values) {
            addCriterion("recruit_num in", values, "recruitNum");
            return (Criteria) this;
        }

        public Criteria andRecruitNumNotIn(List<String> values) {
            addCriterion("recruit_num not in", values, "recruitNum");
            return (Criteria) this;
        }

        public Criteria andRecruitNumBetween(String value1, String value2) {
            addCriterion("recruit_num between", value1, value2, "recruitNum");
            return (Criteria) this;
        }

        public Criteria andRecruitNumNotBetween(String value1, String value2) {
            addCriterion("recruit_num not between", value1, value2, "recruitNum");
            return (Criteria) this;
        }

        public Criteria andGraduateIsNull() {
            addCriterion("graduate is null");
            return (Criteria) this;
        }

        public Criteria andGraduateIsNotNull() {
            addCriterion("graduate is not null");
            return (Criteria) this;
        }

        public Criteria andGraduateEqualTo(String value) {
            addCriterion("graduate =", value, "graduate");
            return (Criteria) this;
        }

        public Criteria andGraduateNotEqualTo(String value) {
            addCriterion("graduate <>", value, "graduate");
            return (Criteria) this;
        }

        public Criteria andGraduateGreaterThan(String value) {
            addCriterion("graduate >", value, "graduate");
            return (Criteria) this;
        }

        public Criteria andGraduateGreaterThanOrEqualTo(String value) {
            addCriterion("graduate >=", value, "graduate");
            return (Criteria) this;
        }

        public Criteria andGraduateLessThan(String value) {
            addCriterion("graduate <", value, "graduate");
            return (Criteria) this;
        }

        public Criteria andGraduateLessThanOrEqualTo(String value) {
            addCriterion("graduate <=", value, "graduate");
            return (Criteria) this;
        }

        public Criteria andGraduateLike(String value) {
            addCriterion("graduate like", value, "graduate");
            return (Criteria) this;
        }

        public Criteria andGraduateNotLike(String value) {
            addCriterion("graduate not like", value, "graduate");
            return (Criteria) this;
        }

        public Criteria andGraduateIn(List<String> values) {
            addCriterion("graduate in", values, "graduate");
            return (Criteria) this;
        }

        public Criteria andGraduateNotIn(List<String> values) {
            addCriterion("graduate not in", values, "graduate");
            return (Criteria) this;
        }

        public Criteria andGraduateBetween(String value1, String value2) {
            addCriterion("graduate between", value1, value2, "graduate");
            return (Criteria) this;
        }

        public Criteria andGraduateNotBetween(String value1, String value2) {
            addCriterion("graduate not between", value1, value2, "graduate");
            return (Criteria) this;
        }

        public Criteria andRecruitPlaceIsNull() {
            addCriterion("recruit_place is null");
            return (Criteria) this;
        }

        public Criteria andRecruitPlaceIsNotNull() {
            addCriterion("recruit_place is not null");
            return (Criteria) this;
        }

        public Criteria andRecruitPlaceEqualTo(String value) {
            addCriterion("recruit_place =", value, "recruitPlace");
            return (Criteria) this;
        }

        public Criteria andRecruitPlaceNotEqualTo(String value) {
            addCriterion("recruit_place <>", value, "recruitPlace");
            return (Criteria) this;
        }

        public Criteria andRecruitPlaceGreaterThan(String value) {
            addCriterion("recruit_place >", value, "recruitPlace");
            return (Criteria) this;
        }

        public Criteria andRecruitPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("recruit_place >=", value, "recruitPlace");
            return (Criteria) this;
        }

        public Criteria andRecruitPlaceLessThan(String value) {
            addCriterion("recruit_place <", value, "recruitPlace");
            return (Criteria) this;
        }

        public Criteria andRecruitPlaceLessThanOrEqualTo(String value) {
            addCriterion("recruit_place <=", value, "recruitPlace");
            return (Criteria) this;
        }

        public Criteria andRecruitPlaceLike(String value) {
            addCriterion("recruit_place like", value, "recruitPlace");
            return (Criteria) this;
        }

        public Criteria andRecruitPlaceNotLike(String value) {
            addCriterion("recruit_place not like", value, "recruitPlace");
            return (Criteria) this;
        }

        public Criteria andRecruitPlaceIn(List<String> values) {
            addCriterion("recruit_place in", values, "recruitPlace");
            return (Criteria) this;
        }

        public Criteria andRecruitPlaceNotIn(List<String> values) {
            addCriterion("recruit_place not in", values, "recruitPlace");
            return (Criteria) this;
        }

        public Criteria andRecruitPlaceBetween(String value1, String value2) {
            addCriterion("recruit_place between", value1, value2, "recruitPlace");
            return (Criteria) this;
        }

        public Criteria andRecruitPlaceNotBetween(String value1, String value2) {
            addCriterion("recruit_place not between", value1, value2, "recruitPlace");
            return (Criteria) this;
        }

        public Criteria andDataSoruceIsNull() {
            addCriterion("data_soruce is null");
            return (Criteria) this;
        }

        public Criteria andDataSoruceIsNotNull() {
            addCriterion("data_soruce is not null");
            return (Criteria) this;
        }

        public Criteria andDataSoruceEqualTo(String value) {
            addCriterion("data_soruce =", value, "dataSoruce");
            return (Criteria) this;
        }

        public Criteria andDataSoruceNotEqualTo(String value) {
            addCriterion("data_soruce <>", value, "dataSoruce");
            return (Criteria) this;
        }

        public Criteria andDataSoruceGreaterThan(String value) {
            addCriterion("data_soruce >", value, "dataSoruce");
            return (Criteria) this;
        }

        public Criteria andDataSoruceGreaterThanOrEqualTo(String value) {
            addCriterion("data_soruce >=", value, "dataSoruce");
            return (Criteria) this;
        }

        public Criteria andDataSoruceLessThan(String value) {
            addCriterion("data_soruce <", value, "dataSoruce");
            return (Criteria) this;
        }

        public Criteria andDataSoruceLessThanOrEqualTo(String value) {
            addCriterion("data_soruce <=", value, "dataSoruce");
            return (Criteria) this;
        }

        public Criteria andDataSoruceLike(String value) {
            addCriterion("data_soruce like", value, "dataSoruce");
            return (Criteria) this;
        }

        public Criteria andDataSoruceNotLike(String value) {
            addCriterion("data_soruce not like", value, "dataSoruce");
            return (Criteria) this;
        }

        public Criteria andDataSoruceIn(List<String> values) {
            addCriterion("data_soruce in", values, "dataSoruce");
            return (Criteria) this;
        }

        public Criteria andDataSoruceNotIn(List<String> values) {
            addCriterion("data_soruce not in", values, "dataSoruce");
            return (Criteria) this;
        }

        public Criteria andDataSoruceBetween(String value1, String value2) {
            addCriterion("data_soruce between", value1, value2, "dataSoruce");
            return (Criteria) this;
        }

        public Criteria andDataSoruceNotBetween(String value1, String value2) {
            addCriterion("data_soruce not between", value1, value2, "dataSoruce");
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

        public Criteria andEMailIsNull() {
            addCriterion("e_mail is null");
            return (Criteria) this;
        }

        public Criteria andEMailIsNotNull() {
            addCriterion("e_mail is not null");
            return (Criteria) this;
        }

        public Criteria andEMailEqualTo(String value) {
            addCriterion("e_mail =", value, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailNotEqualTo(String value) {
            addCriterion("e_mail <>", value, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailGreaterThan(String value) {
            addCriterion("e_mail >", value, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailGreaterThanOrEqualTo(String value) {
            addCriterion("e_mail >=", value, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailLessThan(String value) {
            addCriterion("e_mail <", value, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailLessThanOrEqualTo(String value) {
            addCriterion("e_mail <=", value, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailLike(String value) {
            addCriterion("e_mail like", value, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailNotLike(String value) {
            addCriterion("e_mail not like", value, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailIn(List<String> values) {
            addCriterion("e_mail in", values, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailNotIn(List<String> values) {
            addCriterion("e_mail not in", values, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailBetween(String value1, String value2) {
            addCriterion("e_mail between", value1, value2, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailNotBetween(String value1, String value2) {
            addCriterion("e_mail not between", value1, value2, "eMail");
            return (Criteria) this;
        }

        public Criteria andContactInformationIsNull() {
            addCriterion("contact_information is null");
            return (Criteria) this;
        }

        public Criteria andContactInformationIsNotNull() {
            addCriterion("contact_information is not null");
            return (Criteria) this;
        }

        public Criteria andContactInformationEqualTo(String value) {
            addCriterion("contact_information =", value, "contactInformation");
            return (Criteria) this;
        }

        public Criteria andContactInformationNotEqualTo(String value) {
            addCriterion("contact_information <>", value, "contactInformation");
            return (Criteria) this;
        }

        public Criteria andContactInformationGreaterThan(String value) {
            addCriterion("contact_information >", value, "contactInformation");
            return (Criteria) this;
        }

        public Criteria andContactInformationGreaterThanOrEqualTo(String value) {
            addCriterion("contact_information >=", value, "contactInformation");
            return (Criteria) this;
        }

        public Criteria andContactInformationLessThan(String value) {
            addCriterion("contact_information <", value, "contactInformation");
            return (Criteria) this;
        }

        public Criteria andContactInformationLessThanOrEqualTo(String value) {
            addCriterion("contact_information <=", value, "contactInformation");
            return (Criteria) this;
        }

        public Criteria andContactInformationLike(String value) {
            addCriterion("contact_information like", value, "contactInformation");
            return (Criteria) this;
        }

        public Criteria andContactInformationNotLike(String value) {
            addCriterion("contact_information not like", value, "contactInformation");
            return (Criteria) this;
        }

        public Criteria andContactInformationIn(List<String> values) {
            addCriterion("contact_information in", values, "contactInformation");
            return (Criteria) this;
        }

        public Criteria andContactInformationNotIn(List<String> values) {
            addCriterion("contact_information not in", values, "contactInformation");
            return (Criteria) this;
        }

        public Criteria andContactInformationBetween(String value1, String value2) {
            addCriterion("contact_information between", value1, value2, "contactInformation");
            return (Criteria) this;
        }

        public Criteria andContactInformationNotBetween(String value1, String value2) {
            addCriterion("contact_information not between", value1, value2, "contactInformation");
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