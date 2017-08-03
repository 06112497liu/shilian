package com.bbd.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusinessRecordsInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BusinessRecordsInfoExample() {
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

        public Criteria andContentTypeIsNull() {
            addCriterion("content_type is null");
            return (Criteria) this;
        }

        public Criteria andContentTypeIsNotNull() {
            addCriterion("content_type is not null");
            return (Criteria) this;
        }

        public Criteria andContentTypeEqualTo(Integer value) {
            addCriterion("content_type =", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotEqualTo(Integer value) {
            addCriterion("content_type <>", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeGreaterThan(Integer value) {
            addCriterion("content_type >", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("content_type >=", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeLessThan(Integer value) {
            addCriterion("content_type <", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeLessThanOrEqualTo(Integer value) {
            addCriterion("content_type <=", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeIn(List<Integer> values) {
            addCriterion("content_type in", values, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotIn(List<Integer> values) {
            addCriterion("content_type not in", values, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeBetween(Integer value1, Integer value2) {
            addCriterion("content_type between", value1, value2, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("content_type not between", value1, value2, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andRecordScoreIsNull() {
            addCriterion("record_score is null");
            return (Criteria) this;
        }

        public Criteria andRecordScoreIsNotNull() {
            addCriterion("record_score is not null");
            return (Criteria) this;
        }

        public Criteria andRecordScoreEqualTo(Double value) {
            addCriterion("record_score =", value, "recordScore");
            return (Criteria) this;
        }

        public Criteria andRecordScoreNotEqualTo(Double value) {
            addCriterion("record_score <>", value, "recordScore");
            return (Criteria) this;
        }

        public Criteria andRecordScoreGreaterThan(Double value) {
            addCriterion("record_score >", value, "recordScore");
            return (Criteria) this;
        }

        public Criteria andRecordScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("record_score >=", value, "recordScore");
            return (Criteria) this;
        }

        public Criteria andRecordScoreLessThan(Double value) {
            addCriterion("record_score <", value, "recordScore");
            return (Criteria) this;
        }

        public Criteria andRecordScoreLessThanOrEqualTo(Double value) {
            addCriterion("record_score <=", value, "recordScore");
            return (Criteria) this;
        }

        public Criteria andRecordScoreIn(List<Double> values) {
            addCriterion("record_score in", values, "recordScore");
            return (Criteria) this;
        }

        public Criteria andRecordScoreNotIn(List<Double> values) {
            addCriterion("record_score not in", values, "recordScore");
            return (Criteria) this;
        }

        public Criteria andRecordScoreBetween(Double value1, Double value2) {
            addCriterion("record_score between", value1, value2, "recordScore");
            return (Criteria) this;
        }

        public Criteria andRecordScoreNotBetween(Double value1, Double value2) {
            addCriterion("record_score not between", value1, value2, "recordScore");
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

        public Criteria andGmtActivityIsNull() {
            addCriterion("gmt_activity is null");
            return (Criteria) this;
        }

        public Criteria andGmtActivityIsNotNull() {
            addCriterion("gmt_activity is not null");
            return (Criteria) this;
        }

        public Criteria andGmtActivityEqualTo(Date value) {
            addCriterion("gmt_activity =", value, "gmtActivity");
            return (Criteria) this;
        }

        public Criteria andGmtActivityNotEqualTo(Date value) {
            addCriterion("gmt_activity <>", value, "gmtActivity");
            return (Criteria) this;
        }

        public Criteria andGmtActivityGreaterThan(Date value) {
            addCriterion("gmt_activity >", value, "gmtActivity");
            return (Criteria) this;
        }

        public Criteria andGmtActivityGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_activity >=", value, "gmtActivity");
            return (Criteria) this;
        }

        public Criteria andGmtActivityLessThan(Date value) {
            addCriterion("gmt_activity <", value, "gmtActivity");
            return (Criteria) this;
        }

        public Criteria andGmtActivityLessThanOrEqualTo(Date value) {
            addCriterion("gmt_activity <=", value, "gmtActivity");
            return (Criteria) this;
        }

        public Criteria andGmtActivityIn(List<Date> values) {
            addCriterion("gmt_activity in", values, "gmtActivity");
            return (Criteria) this;
        }

        public Criteria andGmtActivityNotIn(List<Date> values) {
            addCriterion("gmt_activity not in", values, "gmtActivity");
            return (Criteria) this;
        }

        public Criteria andGmtActivityBetween(Date value1, Date value2) {
            addCriterion("gmt_activity between", value1, value2, "gmtActivity");
            return (Criteria) this;
        }

        public Criteria andGmtActivityNotBetween(Date value1, Date value2) {
            addCriterion("gmt_activity not between", value1, value2, "gmtActivity");
            return (Criteria) this;
        }

        public Criteria andGmtRecordIsNull() {
            addCriterion("gmt_record is null");
            return (Criteria) this;
        }

        public Criteria andGmtRecordIsNotNull() {
            addCriterion("gmt_record is not null");
            return (Criteria) this;
        }

        public Criteria andGmtRecordEqualTo(Date value) {
            addCriterion("gmt_record =", value, "gmtRecord");
            return (Criteria) this;
        }

        public Criteria andGmtRecordNotEqualTo(Date value) {
            addCriterion("gmt_record <>", value, "gmtRecord");
            return (Criteria) this;
        }

        public Criteria andGmtRecordGreaterThan(Date value) {
            addCriterion("gmt_record >", value, "gmtRecord");
            return (Criteria) this;
        }

        public Criteria andGmtRecordGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_record >=", value, "gmtRecord");
            return (Criteria) this;
        }

        public Criteria andGmtRecordLessThan(Date value) {
            addCriterion("gmt_record <", value, "gmtRecord");
            return (Criteria) this;
        }

        public Criteria andGmtRecordLessThanOrEqualTo(Date value) {
            addCriterion("gmt_record <=", value, "gmtRecord");
            return (Criteria) this;
        }

        public Criteria andGmtRecordIn(List<Date> values) {
            addCriterion("gmt_record in", values, "gmtRecord");
            return (Criteria) this;
        }

        public Criteria andGmtRecordNotIn(List<Date> values) {
            addCriterion("gmt_record not in", values, "gmtRecord");
            return (Criteria) this;
        }

        public Criteria andGmtRecordBetween(Date value1, Date value2) {
            addCriterion("gmt_record between", value1, value2, "gmtRecord");
            return (Criteria) this;
        }

        public Criteria andGmtRecordNotBetween(Date value1, Date value2) {
            addCriterion("gmt_record not between", value1, value2, "gmtRecord");
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