package com.bbd.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompanyAdInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyAdInfoExample() {
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

        public Criteria andRegisterNoIsNull() {
            addCriterion("register_no is null");
            return (Criteria) this;
        }

        public Criteria andRegisterNoIsNotNull() {
            addCriterion("register_no is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterNoEqualTo(String value) {
            addCriterion("register_no =", value, "registerNo");
            return (Criteria) this;
        }

        public Criteria andRegisterNoNotEqualTo(String value) {
            addCriterion("register_no <>", value, "registerNo");
            return (Criteria) this;
        }

        public Criteria andRegisterNoGreaterThan(String value) {
            addCriterion("register_no >", value, "registerNo");
            return (Criteria) this;
        }

        public Criteria andRegisterNoGreaterThanOrEqualTo(String value) {
            addCriterion("register_no >=", value, "registerNo");
            return (Criteria) this;
        }

        public Criteria andRegisterNoLessThan(String value) {
            addCriterion("register_no <", value, "registerNo");
            return (Criteria) this;
        }

        public Criteria andRegisterNoLessThanOrEqualTo(String value) {
            addCriterion("register_no <=", value, "registerNo");
            return (Criteria) this;
        }

        public Criteria andRegisterNoLike(String value) {
            addCriterion("register_no like", value, "registerNo");
            return (Criteria) this;
        }

        public Criteria andRegisterNoNotLike(String value) {
            addCriterion("register_no not like", value, "registerNo");
            return (Criteria) this;
        }

        public Criteria andRegisterNoIn(List<String> values) {
            addCriterion("register_no in", values, "registerNo");
            return (Criteria) this;
        }

        public Criteria andRegisterNoNotIn(List<String> values) {
            addCriterion("register_no not in", values, "registerNo");
            return (Criteria) this;
        }

        public Criteria andRegisterNoBetween(String value1, String value2) {
            addCriterion("register_no between", value1, value2, "registerNo");
            return (Criteria) this;
        }

        public Criteria andRegisterNoNotBetween(String value1, String value2) {
            addCriterion("register_no not between", value1, value2, "registerNo");
            return (Criteria) this;
        }

        public Criteria andAvailableFromIsNull() {
            addCriterion("available_from is null");
            return (Criteria) this;
        }

        public Criteria andAvailableFromIsNotNull() {
            addCriterion("available_from is not null");
            return (Criteria) this;
        }

        public Criteria andAvailableFromEqualTo(Date value) {
            addCriterion("available_from =", value, "availableFrom");
            return (Criteria) this;
        }

        public Criteria andAvailableFromNotEqualTo(Date value) {
            addCriterion("available_from <>", value, "availableFrom");
            return (Criteria) this;
        }

        public Criteria andAvailableFromGreaterThan(Date value) {
            addCriterion("available_from >", value, "availableFrom");
            return (Criteria) this;
        }

        public Criteria andAvailableFromGreaterThanOrEqualTo(Date value) {
            addCriterion("available_from >=", value, "availableFrom");
            return (Criteria) this;
        }

        public Criteria andAvailableFromLessThan(Date value) {
            addCriterion("available_from <", value, "availableFrom");
            return (Criteria) this;
        }

        public Criteria andAvailableFromLessThanOrEqualTo(Date value) {
            addCriterion("available_from <=", value, "availableFrom");
            return (Criteria) this;
        }

        public Criteria andAvailableFromIn(List<Date> values) {
            addCriterion("available_from in", values, "availableFrom");
            return (Criteria) this;
        }

        public Criteria andAvailableFromNotIn(List<Date> values) {
            addCriterion("available_from not in", values, "availableFrom");
            return (Criteria) this;
        }

        public Criteria andAvailableFromBetween(Date value1, Date value2) {
            addCriterion("available_from between", value1, value2, "availableFrom");
            return (Criteria) this;
        }

        public Criteria andAvailableFromNotBetween(Date value1, Date value2) {
            addCriterion("available_from not between", value1, value2, "availableFrom");
            return (Criteria) this;
        }

        public Criteria andAvailableToIsNull() {
            addCriterion("available_to is null");
            return (Criteria) this;
        }

        public Criteria andAvailableToIsNotNull() {
            addCriterion("available_to is not null");
            return (Criteria) this;
        }

        public Criteria andAvailableToEqualTo(Date value) {
            addCriterion("available_to =", value, "availableTo");
            return (Criteria) this;
        }

        public Criteria andAvailableToNotEqualTo(Date value) {
            addCriterion("available_to <>", value, "availableTo");
            return (Criteria) this;
        }

        public Criteria andAvailableToGreaterThan(Date value) {
            addCriterion("available_to >", value, "availableTo");
            return (Criteria) this;
        }

        public Criteria andAvailableToGreaterThanOrEqualTo(Date value) {
            addCriterion("available_to >=", value, "availableTo");
            return (Criteria) this;
        }

        public Criteria andAvailableToLessThan(Date value) {
            addCriterion("available_to <", value, "availableTo");
            return (Criteria) this;
        }

        public Criteria andAvailableToLessThanOrEqualTo(Date value) {
            addCriterion("available_to <=", value, "availableTo");
            return (Criteria) this;
        }

        public Criteria andAvailableToIn(List<Date> values) {
            addCriterion("available_to in", values, "availableTo");
            return (Criteria) this;
        }

        public Criteria andAvailableToNotIn(List<Date> values) {
            addCriterion("available_to not in", values, "availableTo");
            return (Criteria) this;
        }

        public Criteria andAvailableToBetween(Date value1, Date value2) {
            addCriterion("available_to between", value1, value2, "availableTo");
            return (Criteria) this;
        }

        public Criteria andAvailableToNotBetween(Date value1, Date value2) {
            addCriterion("available_to not between", value1, value2, "availableTo");
            return (Criteria) this;
        }

        public Criteria andAuthIsNull() {
            addCriterion("auth is null");
            return (Criteria) this;
        }

        public Criteria andAuthIsNotNull() {
            addCriterion("auth is not null");
            return (Criteria) this;
        }

        public Criteria andAuthEqualTo(String value) {
            addCriterion("auth =", value, "auth");
            return (Criteria) this;
        }

        public Criteria andAuthNotEqualTo(String value) {
            addCriterion("auth <>", value, "auth");
            return (Criteria) this;
        }

        public Criteria andAuthGreaterThan(String value) {
            addCriterion("auth >", value, "auth");
            return (Criteria) this;
        }

        public Criteria andAuthGreaterThanOrEqualTo(String value) {
            addCriterion("auth >=", value, "auth");
            return (Criteria) this;
        }

        public Criteria andAuthLessThan(String value) {
            addCriterion("auth <", value, "auth");
            return (Criteria) this;
        }

        public Criteria andAuthLessThanOrEqualTo(String value) {
            addCriterion("auth <=", value, "auth");
            return (Criteria) this;
        }

        public Criteria andAuthLike(String value) {
            addCriterion("auth like", value, "auth");
            return (Criteria) this;
        }

        public Criteria andAuthNotLike(String value) {
            addCriterion("auth not like", value, "auth");
            return (Criteria) this;
        }

        public Criteria andAuthIn(List<String> values) {
            addCriterion("auth in", values, "auth");
            return (Criteria) this;
        }

        public Criteria andAuthNotIn(List<String> values) {
            addCriterion("auth not in", values, "auth");
            return (Criteria) this;
        }

        public Criteria andAuthBetween(String value1, String value2) {
            addCriterion("auth between", value1, value2, "auth");
            return (Criteria) this;
        }

        public Criteria andAuthNotBetween(String value1, String value2) {
            addCriterion("auth not between", value1, value2, "auth");
            return (Criteria) this;
        }

        public Criteria andAuthTimeIsNull() {
            addCriterion("auth_time is null");
            return (Criteria) this;
        }

        public Criteria andAuthTimeIsNotNull() {
            addCriterion("auth_time is not null");
            return (Criteria) this;
        }

        public Criteria andAuthTimeEqualTo(Date value) {
            addCriterion("auth_time =", value, "authTime");
            return (Criteria) this;
        }

        public Criteria andAuthTimeNotEqualTo(Date value) {
            addCriterion("auth_time <>", value, "authTime");
            return (Criteria) this;
        }

        public Criteria andAuthTimeGreaterThan(Date value) {
            addCriterion("auth_time >", value, "authTime");
            return (Criteria) this;
        }

        public Criteria andAuthTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("auth_time >=", value, "authTime");
            return (Criteria) this;
        }

        public Criteria andAuthTimeLessThan(Date value) {
            addCriterion("auth_time <", value, "authTime");
            return (Criteria) this;
        }

        public Criteria andAuthTimeLessThanOrEqualTo(Date value) {
            addCriterion("auth_time <=", value, "authTime");
            return (Criteria) this;
        }

        public Criteria andAuthTimeIn(List<Date> values) {
            addCriterion("auth_time in", values, "authTime");
            return (Criteria) this;
        }

        public Criteria andAuthTimeNotIn(List<Date> values) {
            addCriterion("auth_time not in", values, "authTime");
            return (Criteria) this;
        }

        public Criteria andAuthTimeBetween(Date value1, Date value2) {
            addCriterion("auth_time between", value1, value2, "authTime");
            return (Criteria) this;
        }

        public Criteria andAuthTimeNotBetween(Date value1, Date value2) {
            addCriterion("auth_time not between", value1, value2, "authTime");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andRemoteIdIsNull() {
            addCriterion("remote_id is null");
            return (Criteria) this;
        }

        public Criteria andRemoteIdIsNotNull() {
            addCriterion("remote_id is not null");
            return (Criteria) this;
        }

        public Criteria andRemoteIdEqualTo(String value) {
            addCriterion("remote_id =", value, "remoteId");
            return (Criteria) this;
        }

        public Criteria andRemoteIdNotEqualTo(String value) {
            addCriterion("remote_id <>", value, "remoteId");
            return (Criteria) this;
        }

        public Criteria andRemoteIdGreaterThan(String value) {
            addCriterion("remote_id >", value, "remoteId");
            return (Criteria) this;
        }

        public Criteria andRemoteIdGreaterThanOrEqualTo(String value) {
            addCriterion("remote_id >=", value, "remoteId");
            return (Criteria) this;
        }

        public Criteria andRemoteIdLessThan(String value) {
            addCriterion("remote_id <", value, "remoteId");
            return (Criteria) this;
        }

        public Criteria andRemoteIdLessThanOrEqualTo(String value) {
            addCriterion("remote_id <=", value, "remoteId");
            return (Criteria) this;
        }

        public Criteria andRemoteIdLike(String value) {
            addCriterion("remote_id like", value, "remoteId");
            return (Criteria) this;
        }

        public Criteria andRemoteIdNotLike(String value) {
            addCriterion("remote_id not like", value, "remoteId");
            return (Criteria) this;
        }

        public Criteria andRemoteIdIn(List<String> values) {
            addCriterion("remote_id in", values, "remoteId");
            return (Criteria) this;
        }

        public Criteria andRemoteIdNotIn(List<String> values) {
            addCriterion("remote_id not in", values, "remoteId");
            return (Criteria) this;
        }

        public Criteria andRemoteIdBetween(String value1, String value2) {
            addCriterion("remote_id between", value1, value2, "remoteId");
            return (Criteria) this;
        }

        public Criteria andRemoteIdNotBetween(String value1, String value2) {
            addCriterion("remote_id not between", value1, value2, "remoteId");
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

        public Criteria andGmtUpdateIsNull() {
            addCriterion("gmt_update is null");
            return (Criteria) this;
        }

        public Criteria andGmtUpdateIsNotNull() {
            addCriterion("gmt_update is not null");
            return (Criteria) this;
        }

        public Criteria andGmtUpdateEqualTo(Date value) {
            addCriterion("gmt_update =", value, "gmtUpdate");
            return (Criteria) this;
        }

        public Criteria andGmtUpdateNotEqualTo(Date value) {
            addCriterion("gmt_update <>", value, "gmtUpdate");
            return (Criteria) this;
        }

        public Criteria andGmtUpdateGreaterThan(Date value) {
            addCriterion("gmt_update >", value, "gmtUpdate");
            return (Criteria) this;
        }

        public Criteria andGmtUpdateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_update >=", value, "gmtUpdate");
            return (Criteria) this;
        }

        public Criteria andGmtUpdateLessThan(Date value) {
            addCriterion("gmt_update <", value, "gmtUpdate");
            return (Criteria) this;
        }

        public Criteria andGmtUpdateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_update <=", value, "gmtUpdate");
            return (Criteria) this;
        }

        public Criteria andGmtUpdateIn(List<Date> values) {
            addCriterion("gmt_update in", values, "gmtUpdate");
            return (Criteria) this;
        }

        public Criteria andGmtUpdateNotIn(List<Date> values) {
            addCriterion("gmt_update not in", values, "gmtUpdate");
            return (Criteria) this;
        }

        public Criteria andGmtUpdateBetween(Date value1, Date value2) {
            addCriterion("gmt_update between", value1, value2, "gmtUpdate");
            return (Criteria) this;
        }

        public Criteria andGmtUpdateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_update not between", value1, value2, "gmtUpdate");
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