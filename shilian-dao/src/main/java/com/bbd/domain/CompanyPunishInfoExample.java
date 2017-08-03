package com.bbd.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompanyPunishInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyPunishInfoExample() {
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

        public Criteria andPunishNoIsNull() {
            addCriterion("punish_no is null");
            return (Criteria) this;
        }

        public Criteria andPunishNoIsNotNull() {
            addCriterion("punish_no is not null");
            return (Criteria) this;
        }

        public Criteria andPunishNoEqualTo(String value) {
            addCriterion("punish_no =", value, "punishNo");
            return (Criteria) this;
        }

        public Criteria andPunishNoNotEqualTo(String value) {
            addCriterion("punish_no <>", value, "punishNo");
            return (Criteria) this;
        }

        public Criteria andPunishNoGreaterThan(String value) {
            addCriterion("punish_no >", value, "punishNo");
            return (Criteria) this;
        }

        public Criteria andPunishNoGreaterThanOrEqualTo(String value) {
            addCriterion("punish_no >=", value, "punishNo");
            return (Criteria) this;
        }

        public Criteria andPunishNoLessThan(String value) {
            addCriterion("punish_no <", value, "punishNo");
            return (Criteria) this;
        }

        public Criteria andPunishNoLessThanOrEqualTo(String value) {
            addCriterion("punish_no <=", value, "punishNo");
            return (Criteria) this;
        }

        public Criteria andPunishNoLike(String value) {
            addCriterion("punish_no like", value, "punishNo");
            return (Criteria) this;
        }

        public Criteria andPunishNoNotLike(String value) {
            addCriterion("punish_no not like", value, "punishNo");
            return (Criteria) this;
        }

        public Criteria andPunishNoIn(List<String> values) {
            addCriterion("punish_no in", values, "punishNo");
            return (Criteria) this;
        }

        public Criteria andPunishNoNotIn(List<String> values) {
            addCriterion("punish_no not in", values, "punishNo");
            return (Criteria) this;
        }

        public Criteria andPunishNoBetween(String value1, String value2) {
            addCriterion("punish_no between", value1, value2, "punishNo");
            return (Criteria) this;
        }

        public Criteria andPunishNoNotBetween(String value1, String value2) {
            addCriterion("punish_no not between", value1, value2, "punishNo");
            return (Criteria) this;
        }

        public Criteria andPunishTypeIsNull() {
            addCriterion("punish_type is null");
            return (Criteria) this;
        }

        public Criteria andPunishTypeIsNotNull() {
            addCriterion("punish_type is not null");
            return (Criteria) this;
        }

        public Criteria andPunishTypeEqualTo(String value) {
            addCriterion("punish_type =", value, "punishType");
            return (Criteria) this;
        }

        public Criteria andPunishTypeNotEqualTo(String value) {
            addCriterion("punish_type <>", value, "punishType");
            return (Criteria) this;
        }

        public Criteria andPunishTypeGreaterThan(String value) {
            addCriterion("punish_type >", value, "punishType");
            return (Criteria) this;
        }

        public Criteria andPunishTypeGreaterThanOrEqualTo(String value) {
            addCriterion("punish_type >=", value, "punishType");
            return (Criteria) this;
        }

        public Criteria andPunishTypeLessThan(String value) {
            addCriterion("punish_type <", value, "punishType");
            return (Criteria) this;
        }

        public Criteria andPunishTypeLessThanOrEqualTo(String value) {
            addCriterion("punish_type <=", value, "punishType");
            return (Criteria) this;
        }

        public Criteria andPunishTypeLike(String value) {
            addCriterion("punish_type like", value, "punishType");
            return (Criteria) this;
        }

        public Criteria andPunishTypeNotLike(String value) {
            addCriterion("punish_type not like", value, "punishType");
            return (Criteria) this;
        }

        public Criteria andPunishTypeIn(List<String> values) {
            addCriterion("punish_type in", values, "punishType");
            return (Criteria) this;
        }

        public Criteria andPunishTypeNotIn(List<String> values) {
            addCriterion("punish_type not in", values, "punishType");
            return (Criteria) this;
        }

        public Criteria andPunishTypeBetween(String value1, String value2) {
            addCriterion("punish_type between", value1, value2, "punishType");
            return (Criteria) this;
        }

        public Criteria andPunishTypeNotBetween(String value1, String value2) {
            addCriterion("punish_type not between", value1, value2, "punishType");
            return (Criteria) this;
        }

        public Criteria andPunishNameIsNull() {
            addCriterion("punish_name is null");
            return (Criteria) this;
        }

        public Criteria andPunishNameIsNotNull() {
            addCriterion("punish_name is not null");
            return (Criteria) this;
        }

        public Criteria andPunishNameEqualTo(String value) {
            addCriterion("punish_name =", value, "punishName");
            return (Criteria) this;
        }

        public Criteria andPunishNameNotEqualTo(String value) {
            addCriterion("punish_name <>", value, "punishName");
            return (Criteria) this;
        }

        public Criteria andPunishNameGreaterThan(String value) {
            addCriterion("punish_name >", value, "punishName");
            return (Criteria) this;
        }

        public Criteria andPunishNameGreaterThanOrEqualTo(String value) {
            addCriterion("punish_name >=", value, "punishName");
            return (Criteria) this;
        }

        public Criteria andPunishNameLessThan(String value) {
            addCriterion("punish_name <", value, "punishName");
            return (Criteria) this;
        }

        public Criteria andPunishNameLessThanOrEqualTo(String value) {
            addCriterion("punish_name <=", value, "punishName");
            return (Criteria) this;
        }

        public Criteria andPunishNameLike(String value) {
            addCriterion("punish_name like", value, "punishName");
            return (Criteria) this;
        }

        public Criteria andPunishNameNotLike(String value) {
            addCriterion("punish_name not like", value, "punishName");
            return (Criteria) this;
        }

        public Criteria andPunishNameIn(List<String> values) {
            addCriterion("punish_name in", values, "punishName");
            return (Criteria) this;
        }

        public Criteria andPunishNameNotIn(List<String> values) {
            addCriterion("punish_name not in", values, "punishName");
            return (Criteria) this;
        }

        public Criteria andPunishNameBetween(String value1, String value2) {
            addCriterion("punish_name between", value1, value2, "punishName");
            return (Criteria) this;
        }

        public Criteria andPunishNameNotBetween(String value1, String value2) {
            addCriterion("punish_name not between", value1, value2, "punishName");
            return (Criteria) this;
        }

        public Criteria andPunishTimeIsNull() {
            addCriterion("punish_time is null");
            return (Criteria) this;
        }

        public Criteria andPunishTimeIsNotNull() {
            addCriterion("punish_time is not null");
            return (Criteria) this;
        }

        public Criteria andPunishTimeEqualTo(Date value) {
            addCriterion("punish_time =", value, "punishTime");
            return (Criteria) this;
        }

        public Criteria andPunishTimeNotEqualTo(Date value) {
            addCriterion("punish_time <>", value, "punishTime");
            return (Criteria) this;
        }

        public Criteria andPunishTimeGreaterThan(Date value) {
            addCriterion("punish_time >", value, "punishTime");
            return (Criteria) this;
        }

        public Criteria andPunishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("punish_time >=", value, "punishTime");
            return (Criteria) this;
        }

        public Criteria andPunishTimeLessThan(Date value) {
            addCriterion("punish_time <", value, "punishTime");
            return (Criteria) this;
        }

        public Criteria andPunishTimeLessThanOrEqualTo(Date value) {
            addCriterion("punish_time <=", value, "punishTime");
            return (Criteria) this;
        }

        public Criteria andPunishTimeIn(List<Date> values) {
            addCriterion("punish_time in", values, "punishTime");
            return (Criteria) this;
        }

        public Criteria andPunishTimeNotIn(List<Date> values) {
            addCriterion("punish_time not in", values, "punishTime");
            return (Criteria) this;
        }

        public Criteria andPunishTimeBetween(Date value1, Date value2) {
            addCriterion("punish_time between", value1, value2, "punishTime");
            return (Criteria) this;
        }

        public Criteria andPunishTimeNotBetween(Date value1, Date value2) {
            addCriterion("punish_time not between", value1, value2, "punishTime");
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

        public Criteria andRemoteIdEqualTo(Integer value) {
            addCriterion("remote_id =", value, "remoteId");
            return (Criteria) this;
        }

        public Criteria andRemoteIdNotEqualTo(Integer value) {
            addCriterion("remote_id <>", value, "remoteId");
            return (Criteria) this;
        }

        public Criteria andRemoteIdGreaterThan(Integer value) {
            addCriterion("remote_id >", value, "remoteId");
            return (Criteria) this;
        }

        public Criteria andRemoteIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("remote_id >=", value, "remoteId");
            return (Criteria) this;
        }

        public Criteria andRemoteIdLessThan(Integer value) {
            addCriterion("remote_id <", value, "remoteId");
            return (Criteria) this;
        }

        public Criteria andRemoteIdLessThanOrEqualTo(Integer value) {
            addCriterion("remote_id <=", value, "remoteId");
            return (Criteria) this;
        }

        public Criteria andRemoteIdIn(List<Integer> values) {
            addCriterion("remote_id in", values, "remoteId");
            return (Criteria) this;
        }

        public Criteria andRemoteIdNotIn(List<Integer> values) {
            addCriterion("remote_id not in", values, "remoteId");
            return (Criteria) this;
        }

        public Criteria andRemoteIdBetween(Integer value1, Integer value2) {
            addCriterion("remote_id between", value1, value2, "remoteId");
            return (Criteria) this;
        }

        public Criteria andRemoteIdNotBetween(Integer value1, Integer value2) {
            addCriterion("remote_id not between", value1, value2, "remoteId");
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