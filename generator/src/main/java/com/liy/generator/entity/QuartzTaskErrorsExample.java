package com.liy.generator.entity;

import java.util.ArrayList;
import java.util.Date;
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

        public Criteria andTaskExecuteRecordidIsNull() {
            addCriterion("TASK_EXECUTE_RECORDID is null");
            return (Criteria) this;
        }

        public Criteria andTaskExecuteRecordidIsNotNull() {
            addCriterion("TASK_EXECUTE_RECORDID is not null");
            return (Criteria) this;
        }

        public Criteria andTaskExecuteRecordidEqualTo(String value) {
            addCriterion("TASK_EXECUTE_RECORDID =", value, "taskExecuteRecordid");
            return (Criteria) this;
        }

        public Criteria andTaskExecuteRecordidNotEqualTo(String value) {
            addCriterion("TASK_EXECUTE_RECORDID <>", value, "taskExecuteRecordid");
            return (Criteria) this;
        }

        public Criteria andTaskExecuteRecordidGreaterThan(String value) {
            addCriterion("TASK_EXECUTE_RECORDID >", value, "taskExecuteRecordid");
            return (Criteria) this;
        }

        public Criteria andTaskExecuteRecordidGreaterThanOrEqualTo(String value) {
            addCriterion("TASK_EXECUTE_RECORDID >=", value, "taskExecuteRecordid");
            return (Criteria) this;
        }

        public Criteria andTaskExecuteRecordidLessThan(String value) {
            addCriterion("TASK_EXECUTE_RECORDID <", value, "taskExecuteRecordid");
            return (Criteria) this;
        }

        public Criteria andTaskExecuteRecordidLessThanOrEqualTo(String value) {
            addCriterion("TASK_EXECUTE_RECORDID <=", value, "taskExecuteRecordid");
            return (Criteria) this;
        }

        public Criteria andTaskExecuteRecordidLike(String value) {
            addCriterion("TASK_EXECUTE_RECORDID like", value, "taskExecuteRecordid");
            return (Criteria) this;
        }

        public Criteria andTaskExecuteRecordidNotLike(String value) {
            addCriterion("TASK_EXECUTE_RECORDID not like", value, "taskExecuteRecordid");
            return (Criteria) this;
        }

        public Criteria andTaskExecuteRecordidIn(List<String> values) {
            addCriterion("TASK_EXECUTE_RECORDID in", values, "taskExecuteRecordid");
            return (Criteria) this;
        }

        public Criteria andTaskExecuteRecordidNotIn(List<String> values) {
            addCriterion("TASK_EXECUTE_RECORDID not in", values, "taskExecuteRecordid");
            return (Criteria) this;
        }

        public Criteria andTaskExecuteRecordidBetween(String value1, String value2) {
            addCriterion("TASK_EXECUTE_RECORDID between", value1, value2, "taskExecuteRecordid");
            return (Criteria) this;
        }

        public Criteria andTaskExecuteRecordidNotBetween(String value1, String value2) {
            addCriterion("TASK_EXECUTE_RECORDID not between", value1, value2, "taskExecuteRecordid");
            return (Criteria) this;
        }

        public Criteria andErrorKeyIsNull() {
            addCriterion("ERROR_KEY is null");
            return (Criteria) this;
        }

        public Criteria andErrorKeyIsNotNull() {
            addCriterion("ERROR_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andErrorKeyEqualTo(String value) {
            addCriterion("ERROR_KEY =", value, "errorKey");
            return (Criteria) this;
        }

        public Criteria andErrorKeyNotEqualTo(String value) {
            addCriterion("ERROR_KEY <>", value, "errorKey");
            return (Criteria) this;
        }

        public Criteria andErrorKeyGreaterThan(String value) {
            addCriterion("ERROR_KEY >", value, "errorKey");
            return (Criteria) this;
        }

        public Criteria andErrorKeyGreaterThanOrEqualTo(String value) {
            addCriterion("ERROR_KEY >=", value, "errorKey");
            return (Criteria) this;
        }

        public Criteria andErrorKeyLessThan(String value) {
            addCriterion("ERROR_KEY <", value, "errorKey");
            return (Criteria) this;
        }

        public Criteria andErrorKeyLessThanOrEqualTo(String value) {
            addCriterion("ERROR_KEY <=", value, "errorKey");
            return (Criteria) this;
        }

        public Criteria andErrorKeyLike(String value) {
            addCriterion("ERROR_KEY like", value, "errorKey");
            return (Criteria) this;
        }

        public Criteria andErrorKeyNotLike(String value) {
            addCriterion("ERROR_KEY not like", value, "errorKey");
            return (Criteria) this;
        }

        public Criteria andErrorKeyIn(List<String> values) {
            addCriterion("ERROR_KEY in", values, "errorKey");
            return (Criteria) this;
        }

        public Criteria andErrorKeyNotIn(List<String> values) {
            addCriterion("ERROR_KEY not in", values, "errorKey");
            return (Criteria) this;
        }

        public Criteria andErrorKeyBetween(String value1, String value2) {
            addCriterion("ERROR_KEY between", value1, value2, "errorKey");
            return (Criteria) this;
        }

        public Criteria andErrorKeyNotBetween(String value1, String value2) {
            addCriterion("ERROR_KEY not between", value1, value2, "errorKey");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeIsNull() {
            addCriterion("LAST_MODIFY_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeIsNotNull() {
            addCriterion("LAST_MODIFY_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeEqualTo(Date value) {
            addCriterion("LAST_MODIFY_TIME =", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeNotEqualTo(Date value) {
            addCriterion("LAST_MODIFY_TIME <>", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeGreaterThan(Date value) {
            addCriterion("LAST_MODIFY_TIME >", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LAST_MODIFY_TIME >=", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeLessThan(Date value) {
            addCriterion("LAST_MODIFY_TIME <", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("LAST_MODIFY_TIME <=", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeIn(List<Date> values) {
            addCriterion("LAST_MODIFY_TIME in", values, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeNotIn(List<Date> values) {
            addCriterion("LAST_MODIFY_TIME not in", values, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeBetween(Date value1, Date value2) {
            addCriterion("LAST_MODIFY_TIME between", value1, value2, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("LAST_MODIFY_TIME not between", value1, value2, "lastModifyTime");
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