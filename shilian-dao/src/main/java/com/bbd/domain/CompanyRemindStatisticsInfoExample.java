package com.bbd.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompanyRemindStatisticsInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyRemindStatisticsInfoExample() {
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

        public Criteria andMailSuccessIsNull() {
            addCriterion("mail_success is null");
            return (Criteria) this;
        }

        public Criteria andMailSuccessIsNotNull() {
            addCriterion("mail_success is not null");
            return (Criteria) this;
        }

        public Criteria andMailSuccessEqualTo(Integer value) {
            addCriterion("mail_success =", value, "mailSuccess");
            return (Criteria) this;
        }

        public Criteria andMailSuccessNotEqualTo(Integer value) {
            addCriterion("mail_success <>", value, "mailSuccess");
            return (Criteria) this;
        }

        public Criteria andMailSuccessGreaterThan(Integer value) {
            addCriterion("mail_success >", value, "mailSuccess");
            return (Criteria) this;
        }

        public Criteria andMailSuccessGreaterThanOrEqualTo(Integer value) {
            addCriterion("mail_success >=", value, "mailSuccess");
            return (Criteria) this;
        }

        public Criteria andMailSuccessLessThan(Integer value) {
            addCriterion("mail_success <", value, "mailSuccess");
            return (Criteria) this;
        }

        public Criteria andMailSuccessLessThanOrEqualTo(Integer value) {
            addCriterion("mail_success <=", value, "mailSuccess");
            return (Criteria) this;
        }

        public Criteria andMailSuccessIn(List<Integer> values) {
            addCriterion("mail_success in", values, "mailSuccess");
            return (Criteria) this;
        }

        public Criteria andMailSuccessNotIn(List<Integer> values) {
            addCriterion("mail_success not in", values, "mailSuccess");
            return (Criteria) this;
        }

        public Criteria andMailSuccessBetween(Integer value1, Integer value2) {
            addCriterion("mail_success between", value1, value2, "mailSuccess");
            return (Criteria) this;
        }

        public Criteria andMailSuccessNotBetween(Integer value1, Integer value2) {
            addCriterion("mail_success not between", value1, value2, "mailSuccess");
            return (Criteria) this;
        }

        public Criteria andMailFailIsNull() {
            addCriterion("mail_fail is null");
            return (Criteria) this;
        }

        public Criteria andMailFailIsNotNull() {
            addCriterion("mail_fail is not null");
            return (Criteria) this;
        }

        public Criteria andMailFailEqualTo(Integer value) {
            addCriterion("mail_fail =", value, "mailFail");
            return (Criteria) this;
        }

        public Criteria andMailFailNotEqualTo(Integer value) {
            addCriterion("mail_fail <>", value, "mailFail");
            return (Criteria) this;
        }

        public Criteria andMailFailGreaterThan(Integer value) {
            addCriterion("mail_fail >", value, "mailFail");
            return (Criteria) this;
        }

        public Criteria andMailFailGreaterThanOrEqualTo(Integer value) {
            addCriterion("mail_fail >=", value, "mailFail");
            return (Criteria) this;
        }

        public Criteria andMailFailLessThan(Integer value) {
            addCriterion("mail_fail <", value, "mailFail");
            return (Criteria) this;
        }

        public Criteria andMailFailLessThanOrEqualTo(Integer value) {
            addCriterion("mail_fail <=", value, "mailFail");
            return (Criteria) this;
        }

        public Criteria andMailFailIn(List<Integer> values) {
            addCriterion("mail_fail in", values, "mailFail");
            return (Criteria) this;
        }

        public Criteria andMailFailNotIn(List<Integer> values) {
            addCriterion("mail_fail not in", values, "mailFail");
            return (Criteria) this;
        }

        public Criteria andMailFailBetween(Integer value1, Integer value2) {
            addCriterion("mail_fail between", value1, value2, "mailFail");
            return (Criteria) this;
        }

        public Criteria andMailFailNotBetween(Integer value1, Integer value2) {
            addCriterion("mail_fail not between", value1, value2, "mailFail");
            return (Criteria) this;
        }

        public Criteria andMsgSuccessIsNull() {
            addCriterion("msg_success is null");
            return (Criteria) this;
        }

        public Criteria andMsgSuccessIsNotNull() {
            addCriterion("msg_success is not null");
            return (Criteria) this;
        }

        public Criteria andMsgSuccessEqualTo(Integer value) {
            addCriterion("msg_success =", value, "msgSuccess");
            return (Criteria) this;
        }

        public Criteria andMsgSuccessNotEqualTo(Integer value) {
            addCriterion("msg_success <>", value, "msgSuccess");
            return (Criteria) this;
        }

        public Criteria andMsgSuccessGreaterThan(Integer value) {
            addCriterion("msg_success >", value, "msgSuccess");
            return (Criteria) this;
        }

        public Criteria andMsgSuccessGreaterThanOrEqualTo(Integer value) {
            addCriterion("msg_success >=", value, "msgSuccess");
            return (Criteria) this;
        }

        public Criteria andMsgSuccessLessThan(Integer value) {
            addCriterion("msg_success <", value, "msgSuccess");
            return (Criteria) this;
        }

        public Criteria andMsgSuccessLessThanOrEqualTo(Integer value) {
            addCriterion("msg_success <=", value, "msgSuccess");
            return (Criteria) this;
        }

        public Criteria andMsgSuccessIn(List<Integer> values) {
            addCriterion("msg_success in", values, "msgSuccess");
            return (Criteria) this;
        }

        public Criteria andMsgSuccessNotIn(List<Integer> values) {
            addCriterion("msg_success not in", values, "msgSuccess");
            return (Criteria) this;
        }

        public Criteria andMsgSuccessBetween(Integer value1, Integer value2) {
            addCriterion("msg_success between", value1, value2, "msgSuccess");
            return (Criteria) this;
        }

        public Criteria andMsgSuccessNotBetween(Integer value1, Integer value2) {
            addCriterion("msg_success not between", value1, value2, "msgSuccess");
            return (Criteria) this;
        }

        public Criteria andMsgFailIsNull() {
            addCriterion("msg_fail is null");
            return (Criteria) this;
        }

        public Criteria andMsgFailIsNotNull() {
            addCriterion("msg_fail is not null");
            return (Criteria) this;
        }

        public Criteria andMsgFailEqualTo(Integer value) {
            addCriterion("msg_fail =", value, "msgFail");
            return (Criteria) this;
        }

        public Criteria andMsgFailNotEqualTo(Integer value) {
            addCriterion("msg_fail <>", value, "msgFail");
            return (Criteria) this;
        }

        public Criteria andMsgFailGreaterThan(Integer value) {
            addCriterion("msg_fail >", value, "msgFail");
            return (Criteria) this;
        }

        public Criteria andMsgFailGreaterThanOrEqualTo(Integer value) {
            addCriterion("msg_fail >=", value, "msgFail");
            return (Criteria) this;
        }

        public Criteria andMsgFailLessThan(Integer value) {
            addCriterion("msg_fail <", value, "msgFail");
            return (Criteria) this;
        }

        public Criteria andMsgFailLessThanOrEqualTo(Integer value) {
            addCriterion("msg_fail <=", value, "msgFail");
            return (Criteria) this;
        }

        public Criteria andMsgFailIn(List<Integer> values) {
            addCriterion("msg_fail in", values, "msgFail");
            return (Criteria) this;
        }

        public Criteria andMsgFailNotIn(List<Integer> values) {
            addCriterion("msg_fail not in", values, "msgFail");
            return (Criteria) this;
        }

        public Criteria andMsgFailBetween(Integer value1, Integer value2) {
            addCriterion("msg_fail between", value1, value2, "msgFail");
            return (Criteria) this;
        }

        public Criteria andMsgFailNotBetween(Integer value1, Integer value2) {
            addCriterion("msg_fail not between", value1, value2, "msgFail");
            return (Criteria) this;
        }

        public Criteria andVoiceSuccessIsNull() {
            addCriterion("voice_success is null");
            return (Criteria) this;
        }

        public Criteria andVoiceSuccessIsNotNull() {
            addCriterion("voice_success is not null");
            return (Criteria) this;
        }

        public Criteria andVoiceSuccessEqualTo(Integer value) {
            addCriterion("voice_success =", value, "voiceSuccess");
            return (Criteria) this;
        }

        public Criteria andVoiceSuccessNotEqualTo(Integer value) {
            addCriterion("voice_success <>", value, "voiceSuccess");
            return (Criteria) this;
        }

        public Criteria andVoiceSuccessGreaterThan(Integer value) {
            addCriterion("voice_success >", value, "voiceSuccess");
            return (Criteria) this;
        }

        public Criteria andVoiceSuccessGreaterThanOrEqualTo(Integer value) {
            addCriterion("voice_success >=", value, "voiceSuccess");
            return (Criteria) this;
        }

        public Criteria andVoiceSuccessLessThan(Integer value) {
            addCriterion("voice_success <", value, "voiceSuccess");
            return (Criteria) this;
        }

        public Criteria andVoiceSuccessLessThanOrEqualTo(Integer value) {
            addCriterion("voice_success <=", value, "voiceSuccess");
            return (Criteria) this;
        }

        public Criteria andVoiceSuccessIn(List<Integer> values) {
            addCriterion("voice_success in", values, "voiceSuccess");
            return (Criteria) this;
        }

        public Criteria andVoiceSuccessNotIn(List<Integer> values) {
            addCriterion("voice_success not in", values, "voiceSuccess");
            return (Criteria) this;
        }

        public Criteria andVoiceSuccessBetween(Integer value1, Integer value2) {
            addCriterion("voice_success between", value1, value2, "voiceSuccess");
            return (Criteria) this;
        }

        public Criteria andVoiceSuccessNotBetween(Integer value1, Integer value2) {
            addCriterion("voice_success not between", value1, value2, "voiceSuccess");
            return (Criteria) this;
        }

        public Criteria andVoiceFailIsNull() {
            addCriterion("voice_fail is null");
            return (Criteria) this;
        }

        public Criteria andVoiceFailIsNotNull() {
            addCriterion("voice_fail is not null");
            return (Criteria) this;
        }

        public Criteria andVoiceFailEqualTo(Integer value) {
            addCriterion("voice_fail =", value, "voiceFail");
            return (Criteria) this;
        }

        public Criteria andVoiceFailNotEqualTo(Integer value) {
            addCriterion("voice_fail <>", value, "voiceFail");
            return (Criteria) this;
        }

        public Criteria andVoiceFailGreaterThan(Integer value) {
            addCriterion("voice_fail >", value, "voiceFail");
            return (Criteria) this;
        }

        public Criteria andVoiceFailGreaterThanOrEqualTo(Integer value) {
            addCriterion("voice_fail >=", value, "voiceFail");
            return (Criteria) this;
        }

        public Criteria andVoiceFailLessThan(Integer value) {
            addCriterion("voice_fail <", value, "voiceFail");
            return (Criteria) this;
        }

        public Criteria andVoiceFailLessThanOrEqualTo(Integer value) {
            addCriterion("voice_fail <=", value, "voiceFail");
            return (Criteria) this;
        }

        public Criteria andVoiceFailIn(List<Integer> values) {
            addCriterion("voice_fail in", values, "voiceFail");
            return (Criteria) this;
        }

        public Criteria andVoiceFailNotIn(List<Integer> values) {
            addCriterion("voice_fail not in", values, "voiceFail");
            return (Criteria) this;
        }

        public Criteria andVoiceFailBetween(Integer value1, Integer value2) {
            addCriterion("voice_fail between", value1, value2, "voiceFail");
            return (Criteria) this;
        }

        public Criteria andVoiceFailNotBetween(Integer value1, Integer value2) {
            addCriterion("voice_fail not between", value1, value2, "voiceFail");
            return (Criteria) this;
        }

        public Criteria andSendYearIsNull() {
            addCriterion("send_year is null");
            return (Criteria) this;
        }

        public Criteria andSendYearIsNotNull() {
            addCriterion("send_year is not null");
            return (Criteria) this;
        }

        public Criteria andSendYearEqualTo(Integer value) {
            addCriterion("send_year =", value, "sendYear");
            return (Criteria) this;
        }

        public Criteria andSendYearNotEqualTo(Integer value) {
            addCriterion("send_year <>", value, "sendYear");
            return (Criteria) this;
        }

        public Criteria andSendYearGreaterThan(Integer value) {
            addCriterion("send_year >", value, "sendYear");
            return (Criteria) this;
        }

        public Criteria andSendYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("send_year >=", value, "sendYear");
            return (Criteria) this;
        }

        public Criteria andSendYearLessThan(Integer value) {
            addCriterion("send_year <", value, "sendYear");
            return (Criteria) this;
        }

        public Criteria andSendYearLessThanOrEqualTo(Integer value) {
            addCriterion("send_year <=", value, "sendYear");
            return (Criteria) this;
        }

        public Criteria andSendYearIn(List<Integer> values) {
            addCriterion("send_year in", values, "sendYear");
            return (Criteria) this;
        }

        public Criteria andSendYearNotIn(List<Integer> values) {
            addCriterion("send_year not in", values, "sendYear");
            return (Criteria) this;
        }

        public Criteria andSendYearBetween(Integer value1, Integer value2) {
            addCriterion("send_year between", value1, value2, "sendYear");
            return (Criteria) this;
        }

        public Criteria andSendYearNotBetween(Integer value1, Integer value2) {
            addCriterion("send_year not between", value1, value2, "sendYear");
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