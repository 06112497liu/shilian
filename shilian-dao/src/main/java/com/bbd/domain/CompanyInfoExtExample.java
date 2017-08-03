package com.bbd.domain;

import java.util.ArrayList;
import java.util.List;

public class CompanyInfoExtExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyInfoExtExample() {
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

        public Criteria andFlowFlagIsNull() {
            addCriterion("flow_flag is null");
            return (Criteria) this;
        }

        public Criteria andFlowFlagIsNotNull() {
            addCriterion("flow_flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlowFlagEqualTo(Integer value) {
            addCriterion("flow_flag =", value, "flowFlag");
            return (Criteria) this;
        }

        public Criteria andFlowFlagNotEqualTo(Integer value) {
            addCriterion("flow_flag <>", value, "flowFlag");
            return (Criteria) this;
        }

        public Criteria andFlowFlagGreaterThan(Integer value) {
            addCriterion("flow_flag >", value, "flowFlag");
            return (Criteria) this;
        }

        public Criteria andFlowFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("flow_flag >=", value, "flowFlag");
            return (Criteria) this;
        }

        public Criteria andFlowFlagLessThan(Integer value) {
            addCriterion("flow_flag <", value, "flowFlag");
            return (Criteria) this;
        }

        public Criteria andFlowFlagLessThanOrEqualTo(Integer value) {
            addCriterion("flow_flag <=", value, "flowFlag");
            return (Criteria) this;
        }

        public Criteria andFlowFlagIn(List<Integer> values) {
            addCriterion("flow_flag in", values, "flowFlag");
            return (Criteria) this;
        }

        public Criteria andFlowFlagNotIn(List<Integer> values) {
            addCriterion("flow_flag not in", values, "flowFlag");
            return (Criteria) this;
        }

        public Criteria andFlowFlagBetween(Integer value1, Integer value2) {
            addCriterion("flow_flag between", value1, value2, "flowFlag");
            return (Criteria) this;
        }

        public Criteria andFlowFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("flow_flag not between", value1, value2, "flowFlag");
            return (Criteria) this;
        }

        public Criteria andLllegalFlagIsNull() {
            addCriterion("lllegal_flag is null");
            return (Criteria) this;
        }

        public Criteria andLllegalFlagIsNotNull() {
            addCriterion("lllegal_flag is not null");
            return (Criteria) this;
        }

        public Criteria andLllegalFlagEqualTo(Integer value) {
            addCriterion("lllegal_flag =", value, "lllegalFlag");
            return (Criteria) this;
        }

        public Criteria andLllegalFlagNotEqualTo(Integer value) {
            addCriterion("lllegal_flag <>", value, "lllegalFlag");
            return (Criteria) this;
        }

        public Criteria andLllegalFlagGreaterThan(Integer value) {
            addCriterion("lllegal_flag >", value, "lllegalFlag");
            return (Criteria) this;
        }

        public Criteria andLllegalFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("lllegal_flag >=", value, "lllegalFlag");
            return (Criteria) this;
        }

        public Criteria andLllegalFlagLessThan(Integer value) {
            addCriterion("lllegal_flag <", value, "lllegalFlag");
            return (Criteria) this;
        }

        public Criteria andLllegalFlagLessThanOrEqualTo(Integer value) {
            addCriterion("lllegal_flag <=", value, "lllegalFlag");
            return (Criteria) this;
        }

        public Criteria andLllegalFlagIn(List<Integer> values) {
            addCriterion("lllegal_flag in", values, "lllegalFlag");
            return (Criteria) this;
        }

        public Criteria andLllegalFlagNotIn(List<Integer> values) {
            addCriterion("lllegal_flag not in", values, "lllegalFlag");
            return (Criteria) this;
        }

        public Criteria andLllegalFlagBetween(Integer value1, Integer value2) {
            addCriterion("lllegal_flag between", value1, value2, "lllegalFlag");
            return (Criteria) this;
        }

        public Criteria andLllegalFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("lllegal_flag not between", value1, value2, "lllegalFlag");
            return (Criteria) this;
        }

        public Criteria andCancelFlagIsNull() {
            addCriterion("cancel_flag is null");
            return (Criteria) this;
        }

        public Criteria andCancelFlagIsNotNull() {
            addCriterion("cancel_flag is not null");
            return (Criteria) this;
        }

        public Criteria andCancelFlagEqualTo(Integer value) {
            addCriterion("cancel_flag =", value, "cancelFlag");
            return (Criteria) this;
        }

        public Criteria andCancelFlagNotEqualTo(Integer value) {
            addCriterion("cancel_flag <>", value, "cancelFlag");
            return (Criteria) this;
        }

        public Criteria andCancelFlagGreaterThan(Integer value) {
            addCriterion("cancel_flag >", value, "cancelFlag");
            return (Criteria) this;
        }

        public Criteria andCancelFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("cancel_flag >=", value, "cancelFlag");
            return (Criteria) this;
        }

        public Criteria andCancelFlagLessThan(Integer value) {
            addCriterion("cancel_flag <", value, "cancelFlag");
            return (Criteria) this;
        }

        public Criteria andCancelFlagLessThanOrEqualTo(Integer value) {
            addCriterion("cancel_flag <=", value, "cancelFlag");
            return (Criteria) this;
        }

        public Criteria andCancelFlagIn(List<Integer> values) {
            addCriterion("cancel_flag in", values, "cancelFlag");
            return (Criteria) this;
        }

        public Criteria andCancelFlagNotIn(List<Integer> values) {
            addCriterion("cancel_flag not in", values, "cancelFlag");
            return (Criteria) this;
        }

        public Criteria andCancelFlagBetween(Integer value1, Integer value2) {
            addCriterion("cancel_flag between", value1, value2, "cancelFlag");
            return (Criteria) this;
        }

        public Criteria andCancelFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("cancel_flag not between", value1, value2, "cancelFlag");
            return (Criteria) this;
        }

        public Criteria andSuspendFlagIsNull() {
            addCriterion("suspend_flag is null");
            return (Criteria) this;
        }

        public Criteria andSuspendFlagIsNotNull() {
            addCriterion("suspend_flag is not null");
            return (Criteria) this;
        }

        public Criteria andSuspendFlagEqualTo(Integer value) {
            addCriterion("suspend_flag =", value, "suspendFlag");
            return (Criteria) this;
        }

        public Criteria andSuspendFlagNotEqualTo(Integer value) {
            addCriterion("suspend_flag <>", value, "suspendFlag");
            return (Criteria) this;
        }

        public Criteria andSuspendFlagGreaterThan(Integer value) {
            addCriterion("suspend_flag >", value, "suspendFlag");
            return (Criteria) this;
        }

        public Criteria andSuspendFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("suspend_flag >=", value, "suspendFlag");
            return (Criteria) this;
        }

        public Criteria andSuspendFlagLessThan(Integer value) {
            addCriterion("suspend_flag <", value, "suspendFlag");
            return (Criteria) this;
        }

        public Criteria andSuspendFlagLessThanOrEqualTo(Integer value) {
            addCriterion("suspend_flag <=", value, "suspendFlag");
            return (Criteria) this;
        }

        public Criteria andSuspendFlagIn(List<Integer> values) {
            addCriterion("suspend_flag in", values, "suspendFlag");
            return (Criteria) this;
        }

        public Criteria andSuspendFlagNotIn(List<Integer> values) {
            addCriterion("suspend_flag not in", values, "suspendFlag");
            return (Criteria) this;
        }

        public Criteria andSuspendFlagBetween(Integer value1, Integer value2) {
            addCriterion("suspend_flag between", value1, value2, "suspendFlag");
            return (Criteria) this;
        }

        public Criteria andSuspendFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("suspend_flag not between", value1, value2, "suspendFlag");
            return (Criteria) this;
        }

        public Criteria andAbnormalFlagIsNull() {
            addCriterion("abnormal_flag is null");
            return (Criteria) this;
        }

        public Criteria andAbnormalFlagIsNotNull() {
            addCriterion("abnormal_flag is not null");
            return (Criteria) this;
        }

        public Criteria andAbnormalFlagEqualTo(Integer value) {
            addCriterion("abnormal_flag =", value, "abnormalFlag");
            return (Criteria) this;
        }

        public Criteria andAbnormalFlagNotEqualTo(Integer value) {
            addCriterion("abnormal_flag <>", value, "abnormalFlag");
            return (Criteria) this;
        }

        public Criteria andAbnormalFlagGreaterThan(Integer value) {
            addCriterion("abnormal_flag >", value, "abnormalFlag");
            return (Criteria) this;
        }

        public Criteria andAbnormalFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("abnormal_flag >=", value, "abnormalFlag");
            return (Criteria) this;
        }

        public Criteria andAbnormalFlagLessThan(Integer value) {
            addCriterion("abnormal_flag <", value, "abnormalFlag");
            return (Criteria) this;
        }

        public Criteria andAbnormalFlagLessThanOrEqualTo(Integer value) {
            addCriterion("abnormal_flag <=", value, "abnormalFlag");
            return (Criteria) this;
        }

        public Criteria andAbnormalFlagIn(List<Integer> values) {
            addCriterion("abnormal_flag in", values, "abnormalFlag");
            return (Criteria) this;
        }

        public Criteria andAbnormalFlagNotIn(List<Integer> values) {
            addCriterion("abnormal_flag not in", values, "abnormalFlag");
            return (Criteria) this;
        }

        public Criteria andAbnormalFlagBetween(Integer value1, Integer value2) {
            addCriterion("abnormal_flag between", value1, value2, "abnormalFlag");
            return (Criteria) this;
        }

        public Criteria andAbnormalFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("abnormal_flag not between", value1, value2, "abnormalFlag");
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