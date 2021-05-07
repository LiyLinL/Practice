package com.liy.generator.entity;

import java.util.ArrayList;
import java.util.List;

public class QuartzTaskErrorsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QuartzTaskErrorsExample() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTaskexecuterecordidIsNull() {
            addCriterion("TASKEXECUTERECORDID is null");
            return (Criteria) this;
        }

        public Criteria andTaskexecuterecordidIsNotNull() {
            addCriterion("TASKEXECUTERECORDID is not null");
            return (Criteria) this;
        }

        public Criteria andTaskexecuterecordidEqualTo(String value) {
            addCriterion("TASKEXECUTERECORDID =", value, "taskexecuterecordid");
            return (Criteria) this;
        }

        public Criteria andTaskexecuterecordidNotEqualTo(String value) {
            addCriterion("TASKEXECUTERECORDID <>", value, "taskexecuterecordid");
            return (Criteria) this;
        }

        public Criteria andTaskexecuterecordidGreaterThan(String value) {
            addCriterion("TASKEXECUTERECORDID >", value, "taskexecuterecordid");
            return (Criteria) this;
        }

        public Criteria andTaskexecuterecordidGreaterThanOrEqualTo(String value) {
            addCriterion("TASKEXECUTERECORDID >=", value, "taskexecuterecordid");
            return (Criteria) this;
        }

        public Criteria andTaskexecuterecordidLessThan(String value) {
            addCriterion("TASKEXECUTERECORDID <", value, "taskexecuterecordid");
            return (Criteria) this;
        }

        public Criteria andTaskexecuterecordidLessThanOrEqualTo(String value) {
            addCriterion("TASKEXECUTERECORDID <=", value, "taskexecuterecordid");
            return (Criteria) this;
        }

        public Criteria andTaskexecuterecordidLike(String value) {
            addCriterion("TASKEXECUTERECORDID like", value, "taskexecuterecordid");
            return (Criteria) this;
        }

        public Criteria andTaskexecuterecordidNotLike(String value) {
            addCriterion("TASKEXECUTERECORDID not like", value, "taskexecuterecordid");
            return (Criteria) this;
        }

        public Criteria andTaskexecuterecordidIn(List<String> values) {
            addCriterion("TASKEXECUTERECORDID in", values, "taskexecuterecordid");
            return (Criteria) this;
        }

        public Criteria andTaskexecuterecordidNotIn(List<String> values) {
            addCriterion("TASKEXECUTERECORDID not in", values, "taskexecuterecordid");
            return (Criteria) this;
        }

        public Criteria andTaskexecuterecordidBetween(String value1, String value2) {
            addCriterion("TASKEXECUTERECORDID between", value1, value2, "taskexecuterecordid");
            return (Criteria) this;
        }

        public Criteria andTaskexecuterecordidNotBetween(String value1, String value2) {
            addCriterion("TASKEXECUTERECORDID not between", value1, value2, "taskexecuterecordid");
            return (Criteria) this;
        }

        public Criteria andErrorkeyIsNull() {
            addCriterion("ERRORKEY is null");
            return (Criteria) this;
        }

        public Criteria andErrorkeyIsNotNull() {
            addCriterion("ERRORKEY is not null");
            return (Criteria) this;
        }

        public Criteria andErrorkeyEqualTo(String value) {
            addCriterion("ERRORKEY =", value, "errorkey");
            return (Criteria) this;
        }

        public Criteria andErrorkeyNotEqualTo(String value) {
            addCriterion("ERRORKEY <>", value, "errorkey");
            return (Criteria) this;
        }

        public Criteria andErrorkeyGreaterThan(String value) {
            addCriterion("ERRORKEY >", value, "errorkey");
            return (Criteria) this;
        }

        public Criteria andErrorkeyGreaterThanOrEqualTo(String value) {
            addCriterion("ERRORKEY >=", value, "errorkey");
            return (Criteria) this;
        }

        public Criteria andErrorkeyLessThan(String value) {
            addCriterion("ERRORKEY <", value, "errorkey");
            return (Criteria) this;
        }

        public Criteria andErrorkeyLessThanOrEqualTo(String value) {
            addCriterion("ERRORKEY <=", value, "errorkey");
            return (Criteria) this;
        }

        public Criteria andErrorkeyLike(String value) {
            addCriterion("ERRORKEY like", value, "errorkey");
            return (Criteria) this;
        }

        public Criteria andErrorkeyNotLike(String value) {
            addCriterion("ERRORKEY not like", value, "errorkey");
            return (Criteria) this;
        }

        public Criteria andErrorkeyIn(List<String> values) {
            addCriterion("ERRORKEY in", values, "errorkey");
            return (Criteria) this;
        }

        public Criteria andErrorkeyNotIn(List<String> values) {
            addCriterion("ERRORKEY not in", values, "errorkey");
            return (Criteria) this;
        }

        public Criteria andErrorkeyBetween(String value1, String value2) {
            addCriterion("ERRORKEY between", value1, value2, "errorkey");
            return (Criteria) this;
        }

        public Criteria andErrorkeyNotBetween(String value1, String value2) {
            addCriterion("ERRORKEY not between", value1, value2, "errorkey");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("CREATETIME is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("CREATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Long value) {
            addCriterion("CREATETIME =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Long value) {
            addCriterion("CREATETIME <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Long value) {
            addCriterion("CREATETIME >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Long value) {
            addCriterion("CREATETIME >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Long value) {
            addCriterion("CREATETIME <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Long value) {
            addCriterion("CREATETIME <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Long> values) {
            addCriterion("CREATETIME in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Long> values) {
            addCriterion("CREATETIME not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Long value1, Long value2) {
            addCriterion("CREATETIME between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Long value1, Long value2) {
            addCriterion("CREATETIME not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeIsNull() {
            addCriterion("LASTMODIFYTIME is null");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeIsNotNull() {
            addCriterion("LASTMODIFYTIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeEqualTo(Long value) {
            addCriterion("LASTMODIFYTIME =", value, "lastmodifytime");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeNotEqualTo(Long value) {
            addCriterion("LASTMODIFYTIME <>", value, "lastmodifytime");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeGreaterThan(Long value) {
            addCriterion("LASTMODIFYTIME >", value, "lastmodifytime");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeGreaterThanOrEqualTo(Long value) {
            addCriterion("LASTMODIFYTIME >=", value, "lastmodifytime");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeLessThan(Long value) {
            addCriterion("LASTMODIFYTIME <", value, "lastmodifytime");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeLessThanOrEqualTo(Long value) {
            addCriterion("LASTMODIFYTIME <=", value, "lastmodifytime");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeIn(List<Long> values) {
            addCriterion("LASTMODIFYTIME in", values, "lastmodifytime");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeNotIn(List<Long> values) {
            addCriterion("LASTMODIFYTIME not in", values, "lastmodifytime");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeBetween(Long value1, Long value2) {
            addCriterion("LASTMODIFYTIME between", value1, value2, "lastmodifytime");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeNotBetween(Long value1, Long value2) {
            addCriterion("LASTMODIFYTIME not between", value1, value2, "lastmodifytime");
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