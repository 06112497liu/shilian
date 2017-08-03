package com.bbd.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompanyMoveInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyMoveInfoExample() {
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

        public Criteria andMoveOutTimeIsNull() {
            addCriterion("move_out_time is null");
            return (Criteria) this;
        }

        public Criteria andMoveOutTimeIsNotNull() {
            addCriterion("move_out_time is not null");
            return (Criteria) this;
        }

        public Criteria andMoveOutTimeEqualTo(Date value) {
            addCriterion("move_out_time =", value, "moveOutTime");
            return (Criteria) this;
        }

        public Criteria andMoveOutTimeNotEqualTo(Date value) {
            addCriterion("move_out_time <>", value, "moveOutTime");
            return (Criteria) this;
        }

        public Criteria andMoveOutTimeGreaterThan(Date value) {
            addCriterion("move_out_time >", value, "moveOutTime");
            return (Criteria) this;
        }

        public Criteria andMoveOutTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("move_out_time >=", value, "moveOutTime");
            return (Criteria) this;
        }

        public Criteria andMoveOutTimeLessThan(Date value) {
            addCriterion("move_out_time <", value, "moveOutTime");
            return (Criteria) this;
        }

        public Criteria andMoveOutTimeLessThanOrEqualTo(Date value) {
            addCriterion("move_out_time <=", value, "moveOutTime");
            return (Criteria) this;
        }

        public Criteria andMoveOutTimeIn(List<Date> values) {
            addCriterion("move_out_time in", values, "moveOutTime");
            return (Criteria) this;
        }

        public Criteria andMoveOutTimeNotIn(List<Date> values) {
            addCriterion("move_out_time not in", values, "moveOutTime");
            return (Criteria) this;
        }

        public Criteria andMoveOutTimeBetween(Date value1, Date value2) {
            addCriterion("move_out_time between", value1, value2, "moveOutTime");
            return (Criteria) this;
        }

        public Criteria andMoveOutTimeNotBetween(Date value1, Date value2) {
            addCriterion("move_out_time not between", value1, value2, "moveOutTime");
            return (Criteria) this;
        }

        public Criteria andMoveOutRegisterAuthorityIsNull() {
            addCriterion("move_out_register_authority is null");
            return (Criteria) this;
        }

        public Criteria andMoveOutRegisterAuthorityIsNotNull() {
            addCriterion("move_out_register_authority is not null");
            return (Criteria) this;
        }

        public Criteria andMoveOutRegisterAuthorityEqualTo(String value) {
            addCriterion("move_out_register_authority =", value, "moveOutRegisterAuthority");
            return (Criteria) this;
        }

        public Criteria andMoveOutRegisterAuthorityNotEqualTo(String value) {
            addCriterion("move_out_register_authority <>", value, "moveOutRegisterAuthority");
            return (Criteria) this;
        }

        public Criteria andMoveOutRegisterAuthorityGreaterThan(String value) {
            addCriterion("move_out_register_authority >", value, "moveOutRegisterAuthority");
            return (Criteria) this;
        }

        public Criteria andMoveOutRegisterAuthorityGreaterThanOrEqualTo(String value) {
            addCriterion("move_out_register_authority >=", value, "moveOutRegisterAuthority");
            return (Criteria) this;
        }

        public Criteria andMoveOutRegisterAuthorityLessThan(String value) {
            addCriterion("move_out_register_authority <", value, "moveOutRegisterAuthority");
            return (Criteria) this;
        }

        public Criteria andMoveOutRegisterAuthorityLessThanOrEqualTo(String value) {
            addCriterion("move_out_register_authority <=", value, "moveOutRegisterAuthority");
            return (Criteria) this;
        }

        public Criteria andMoveOutRegisterAuthorityLike(String value) {
            addCriterion("move_out_register_authority like", value, "moveOutRegisterAuthority");
            return (Criteria) this;
        }

        public Criteria andMoveOutRegisterAuthorityNotLike(String value) {
            addCriterion("move_out_register_authority not like", value, "moveOutRegisterAuthority");
            return (Criteria) this;
        }

        public Criteria andMoveOutRegisterAuthorityIn(List<String> values) {
            addCriterion("move_out_register_authority in", values, "moveOutRegisterAuthority");
            return (Criteria) this;
        }

        public Criteria andMoveOutRegisterAuthorityNotIn(List<String> values) {
            addCriterion("move_out_register_authority not in", values, "moveOutRegisterAuthority");
            return (Criteria) this;
        }

        public Criteria andMoveOutRegisterAuthorityBetween(String value1, String value2) {
            addCriterion("move_out_register_authority between", value1, value2, "moveOutRegisterAuthority");
            return (Criteria) this;
        }

        public Criteria andMoveOutRegisterAuthorityNotBetween(String value1, String value2) {
            addCriterion("move_out_register_authority not between", value1, value2, "moveOutRegisterAuthority");
            return (Criteria) this;
        }

        public Criteria andMoveOutNatureIsNull() {
            addCriterion("move_out_nature is null");
            return (Criteria) this;
        }

        public Criteria andMoveOutNatureIsNotNull() {
            addCriterion("move_out_nature is not null");
            return (Criteria) this;
        }

        public Criteria andMoveOutNatureEqualTo(String value) {
            addCriterion("move_out_nature =", value, "moveOutNature");
            return (Criteria) this;
        }

        public Criteria andMoveOutNatureNotEqualTo(String value) {
            addCriterion("move_out_nature <>", value, "moveOutNature");
            return (Criteria) this;
        }

        public Criteria andMoveOutNatureGreaterThan(String value) {
            addCriterion("move_out_nature >", value, "moveOutNature");
            return (Criteria) this;
        }

        public Criteria andMoveOutNatureGreaterThanOrEqualTo(String value) {
            addCriterion("move_out_nature >=", value, "moveOutNature");
            return (Criteria) this;
        }

        public Criteria andMoveOutNatureLessThan(String value) {
            addCriterion("move_out_nature <", value, "moveOutNature");
            return (Criteria) this;
        }

        public Criteria andMoveOutNatureLessThanOrEqualTo(String value) {
            addCriterion("move_out_nature <=", value, "moveOutNature");
            return (Criteria) this;
        }

        public Criteria andMoveOutNatureLike(String value) {
            addCriterion("move_out_nature like", value, "moveOutNature");
            return (Criteria) this;
        }

        public Criteria andMoveOutNatureNotLike(String value) {
            addCriterion("move_out_nature not like", value, "moveOutNature");
            return (Criteria) this;
        }

        public Criteria andMoveOutNatureIn(List<String> values) {
            addCriterion("move_out_nature in", values, "moveOutNature");
            return (Criteria) this;
        }

        public Criteria andMoveOutNatureNotIn(List<String> values) {
            addCriterion("move_out_nature not in", values, "moveOutNature");
            return (Criteria) this;
        }

        public Criteria andMoveOutNatureBetween(String value1, String value2) {
            addCriterion("move_out_nature between", value1, value2, "moveOutNature");
            return (Criteria) this;
        }

        public Criteria andMoveOutNatureNotBetween(String value1, String value2) {
            addCriterion("move_out_nature not between", value1, value2, "moveOutNature");
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

        public Criteria andRegisterCapitalEqualTo(Double value) {
            addCriterion("register_capital =", value, "registerCapital");
            return (Criteria) this;
        }

        public Criteria andRegisterCapitalNotEqualTo(Double value) {
            addCriterion("register_capital <>", value, "registerCapital");
            return (Criteria) this;
        }

        public Criteria andRegisterCapitalGreaterThan(Double value) {
            addCriterion("register_capital >", value, "registerCapital");
            return (Criteria) this;
        }

        public Criteria andRegisterCapitalGreaterThanOrEqualTo(Double value) {
            addCriterion("register_capital >=", value, "registerCapital");
            return (Criteria) this;
        }

        public Criteria andRegisterCapitalLessThan(Double value) {
            addCriterion("register_capital <", value, "registerCapital");
            return (Criteria) this;
        }

        public Criteria andRegisterCapitalLessThanOrEqualTo(Double value) {
            addCriterion("register_capital <=", value, "registerCapital");
            return (Criteria) this;
        }

        public Criteria andRegisterCapitalIn(List<Double> values) {
            addCriterion("register_capital in", values, "registerCapital");
            return (Criteria) this;
        }

        public Criteria andRegisterCapitalNotIn(List<Double> values) {
            addCriterion("register_capital not in", values, "registerCapital");
            return (Criteria) this;
        }

        public Criteria andRegisterCapitalBetween(Double value1, Double value2) {
            addCriterion("register_capital between", value1, value2, "registerCapital");
            return (Criteria) this;
        }

        public Criteria andRegisterCapitalNotBetween(Double value1, Double value2) {
            addCriterion("register_capital not between", value1, value2, "registerCapital");
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