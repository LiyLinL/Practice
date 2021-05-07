package com.liy.generator.entity;

import java.util.ArrayList;
import java.util.List;

public class QuartzTaskRecordsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QuartzTaskRecordsExample() {
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

        public Criteria andTasknoIsNull() {
            addCriterion("TASKNO is null");
            return (Criteria) this;
        }

        public Criteria andTasknoIsNotNull() {
            addCriterion("TASKNO is not null");
            return (Criteria) this;
        }

        public Criteria andTasknoEqualTo(String value) {
            addCriterion("TASKNO =", value, "taskno");
            return (Criteria) this;
        }

        public Criteria andTasknoNotEqualTo(String value) {
            addCriterion("TASKNO <>", value, "taskno");
            return (Criteria) this;
        }

        public Criteria andTasknoGreaterThan(String value) {
            addCriterion("TASKNO >", value, "taskno");
            return (Criteria) this;
        }

        public Criteria andTasknoGreaterThanOrEqualTo(String value) {
            addCriterion("TASKNO >=", value, "taskno");
            return (Criteria) this;
        }

        public Criteria andTasknoLessThan(String value) {
            addCriterion("TASKNO <", value, "taskno");
            return (Criteria) this;
        }

        public Criteria andTasknoLessThanOrEqualTo(String value) {
            addCriterion("TASKNO <=", value, "taskno");
            return (Criteria) this;
        }

        public Criteria andTasknoLike(String value) {
            addCriterion("TASKNO like", value, "taskno");
            return (Criteria) this;
        }

        public Criteria andTasknoNotLike(String value) {
            addCriterion("TASKNO not like", value, "taskno");
            return (Criteria) this;
        }

        public Criteria andTasknoIn(List<String> values) {
            addCriterion("TASKNO in", values, "taskno");
            return (Criteria) this;
        }

        public Criteria andTasknoNotIn(List<String> values) {
            addCriterion("TASKNO not in", values, "taskno");
            return (Criteria) this;
        }

        public Criteria andTasknoBetween(String value1, String value2) {
            addCriterion("TASKNO between", value1, value2, "taskno");
            return (Criteria) this;
        }

        public Criteria andTasknoNotBetween(String value1, String value2) {
            addCriterion("TASKNO not between", value1, value2, "taskno");
            return (Criteria) this;
        }

        public Criteria andTimekeyvalueIsNull() {
            addCriterion("TIMEKEYVALUE is null");
            return (Criteria) this;
        }

        public Criteria andTimekeyvalueIsNotNull() {
            addCriterion("TIMEKEYVALUE is not null");
            return (Criteria) this;
        }

        public Criteria andTimekeyvalueEqualTo(String value) {
            addCriterion("TIMEKEYVALUE =", value, "timekeyvalue");
            return (Criteria) this;
        }

        public Criteria andTimekeyvalueNotEqualTo(String value) {
            addCriterion("TIMEKEYVALUE <>", value, "timekeyvalue");
            return (Criteria) this;
        }

        public Criteria andTimekeyvalueGreaterThan(String value) {
            addCriterion("TIMEKEYVALUE >", value, "timekeyvalue");
            return (Criteria) this;
        }

        public Criteria andTimekeyvalueGreaterThanOrEqualTo(String value) {
            addCriterion("TIMEKEYVALUE >=", value, "timekeyvalue");
            return (Criteria) this;
        }

        public Criteria andTimekeyvalueLessThan(String value) {
            addCriterion("TIMEKEYVALUE <", value, "timekeyvalue");
            return (Criteria) this;
        }

        public Criteria andTimekeyvalueLessThanOrEqualTo(String value) {
            addCriterion("TIMEKEYVALUE <=", value, "timekeyvalue");
            return (Criteria) this;
        }

        public Criteria andTimekeyvalueLike(String value) {
            addCriterion("TIMEKEYVALUE like", value, "timekeyvalue");
            return (Criteria) this;
        }

        public Criteria andTimekeyvalueNotLike(String value) {
            addCriterion("TIMEKEYVALUE not like", value, "timekeyvalue");
            return (Criteria) this;
        }

        public Criteria andTimekeyvalueIn(List<String> values) {
            addCriterion("TIMEKEYVALUE in", values, "timekeyvalue");
            return (Criteria) this;
        }

        public Criteria andTimekeyvalueNotIn(List<String> values) {
            addCriterion("TIMEKEYVALUE not in", values, "timekeyvalue");
            return (Criteria) this;
        }

        public Criteria andTimekeyvalueBetween(String value1, String value2) {
            addCriterion("TIMEKEYVALUE between", value1, value2, "timekeyvalue");
            return (Criteria) this;
        }

        public Criteria andTimekeyvalueNotBetween(String value1, String value2) {
            addCriterion("TIMEKEYVALUE not between", value1, value2, "timekeyvalue");
            return (Criteria) this;
        }

        public Criteria andExecutetimeIsNull() {
            addCriterion("EXECUTETIME is null");
            return (Criteria) this;
        }

        public Criteria andExecutetimeIsNotNull() {
            addCriterion("EXECUTETIME is not null");
            return (Criteria) this;
        }

        public Criteria andExecutetimeEqualTo(Long value) {
            addCriterion("EXECUTETIME =", value, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeNotEqualTo(Long value) {
            addCriterion("EXECUTETIME <>", value, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeGreaterThan(Long value) {
            addCriterion("EXECUTETIME >", value, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeGreaterThanOrEqualTo(Long value) {
            addCriterion("EXECUTETIME >=", value, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeLessThan(Long value) {
            addCriterion("EXECUTETIME <", value, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeLessThanOrEqualTo(Long value) {
            addCriterion("EXECUTETIME <=", value, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeIn(List<Long> values) {
            addCriterion("EXECUTETIME in", values, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeNotIn(List<Long> values) {
            addCriterion("EXECUTETIME not in", values, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeBetween(Long value1, Long value2) {
            addCriterion("EXECUTETIME between", value1, value2, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeNotBetween(Long value1, Long value2) {
            addCriterion("EXECUTETIME not between", value1, value2, "executetime");
            return (Criteria) this;
        }

        public Criteria andTaskstatusIsNull() {
            addCriterion("TASKSTATUS is null");
            return (Criteria) this;
        }

        public Criteria andTaskstatusIsNotNull() {
            addCriterion("TASKSTATUS is not null");
            return (Criteria) this;
        }

        public Criteria andTaskstatusEqualTo(String value) {
            addCriterion("TASKSTATUS =", value, "taskstatus");
            return (Criteria) this;
        }

        public Criteria andTaskstatusNotEqualTo(String value) {
            addCriterion("TASKSTATUS <>", value, "taskstatus");
            return (Criteria) this;
        }

        public Criteria andTaskstatusGreaterThan(String value) {
            addCriterion("TASKSTATUS >", value, "taskstatus");
            return (Criteria) this;
        }

        public Criteria andTaskstatusGreaterThanOrEqualTo(String value) {
            addCriterion("TASKSTATUS >=", value, "taskstatus");
            return (Criteria) this;
        }

        public Criteria andTaskstatusLessThan(String value) {
            addCriterion("TASKSTATUS <", value, "taskstatus");
            return (Criteria) this;
        }

        public Criteria andTaskstatusLessThanOrEqualTo(String value) {
            addCriterion("TASKSTATUS <=", value, "taskstatus");
            return (Criteria) this;
        }

        public Criteria andTaskstatusLike(String value) {
            addCriterion("TASKSTATUS like", value, "taskstatus");
            return (Criteria) this;
        }

        public Criteria andTaskstatusNotLike(String value) {
            addCriterion("TASKSTATUS not like", value, "taskstatus");
            return (Criteria) this;
        }

        public Criteria andTaskstatusIn(List<String> values) {
            addCriterion("TASKSTATUS in", values, "taskstatus");
            return (Criteria) this;
        }

        public Criteria andTaskstatusNotIn(List<String> values) {
            addCriterion("TASKSTATUS not in", values, "taskstatus");
            return (Criteria) this;
        }

        public Criteria andTaskstatusBetween(String value1, String value2) {
            addCriterion("TASKSTATUS between", value1, value2, "taskstatus");
            return (Criteria) this;
        }

        public Criteria andTaskstatusNotBetween(String value1, String value2) {
            addCriterion("TASKSTATUS not between", value1, value2, "taskstatus");
            return (Criteria) this;
        }

        public Criteria andFailcountIsNull() {
            addCriterion("FAILCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andFailcountIsNotNull() {
            addCriterion("FAILCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andFailcountEqualTo(Integer value) {
            addCriterion("FAILCOUNT =", value, "failcount");
            return (Criteria) this;
        }

        public Criteria andFailcountNotEqualTo(Integer value) {
            addCriterion("FAILCOUNT <>", value, "failcount");
            return (Criteria) this;
        }

        public Criteria andFailcountGreaterThan(Integer value) {
            addCriterion("FAILCOUNT >", value, "failcount");
            return (Criteria) this;
        }

        public Criteria andFailcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("FAILCOUNT >=", value, "failcount");
            return (Criteria) this;
        }

        public Criteria andFailcountLessThan(Integer value) {
            addCriterion("FAILCOUNT <", value, "failcount");
            return (Criteria) this;
        }

        public Criteria andFailcountLessThanOrEqualTo(Integer value) {
            addCriterion("FAILCOUNT <=", value, "failcount");
            return (Criteria) this;
        }

        public Criteria andFailcountIn(List<Integer> values) {
            addCriterion("FAILCOUNT in", values, "failcount");
            return (Criteria) this;
        }

        public Criteria andFailcountNotIn(List<Integer> values) {
            addCriterion("FAILCOUNT not in", values, "failcount");
            return (Criteria) this;
        }

        public Criteria andFailcountBetween(Integer value1, Integer value2) {
            addCriterion("FAILCOUNT between", value1, value2, "failcount");
            return (Criteria) this;
        }

        public Criteria andFailcountNotBetween(Integer value1, Integer value2) {
            addCriterion("FAILCOUNT not between", value1, value2, "failcount");
            return (Criteria) this;
        }

        public Criteria andFailreasonIsNull() {
            addCriterion("FAILREASON is null");
            return (Criteria) this;
        }

        public Criteria andFailreasonIsNotNull() {
            addCriterion("FAILREASON is not null");
            return (Criteria) this;
        }

        public Criteria andFailreasonEqualTo(String value) {
            addCriterion("FAILREASON =", value, "failreason");
            return (Criteria) this;
        }

        public Criteria andFailreasonNotEqualTo(String value) {
            addCriterion("FAILREASON <>", value, "failreason");
            return (Criteria) this;
        }

        public Criteria andFailreasonGreaterThan(String value) {
            addCriterion("FAILREASON >", value, "failreason");
            return (Criteria) this;
        }

        public Criteria andFailreasonGreaterThanOrEqualTo(String value) {
            addCriterion("FAILREASON >=", value, "failreason");
            return (Criteria) this;
        }

        public Criteria andFailreasonLessThan(String value) {
            addCriterion("FAILREASON <", value, "failreason");
            return (Criteria) this;
        }

        public Criteria andFailreasonLessThanOrEqualTo(String value) {
            addCriterion("FAILREASON <=", value, "failreason");
            return (Criteria) this;
        }

        public Criteria andFailreasonLike(String value) {
            addCriterion("FAILREASON like", value, "failreason");
            return (Criteria) this;
        }

        public Criteria andFailreasonNotLike(String value) {
            addCriterion("FAILREASON not like", value, "failreason");
            return (Criteria) this;
        }

        public Criteria andFailreasonIn(List<String> values) {
            addCriterion("FAILREASON in", values, "failreason");
            return (Criteria) this;
        }

        public Criteria andFailreasonNotIn(List<String> values) {
            addCriterion("FAILREASON not in", values, "failreason");
            return (Criteria) this;
        }

        public Criteria andFailreasonBetween(String value1, String value2) {
            addCriterion("FAILREASON between", value1, value2, "failreason");
            return (Criteria) this;
        }

        public Criteria andFailreasonNotBetween(String value1, String value2) {
            addCriterion("FAILREASON not between", value1, value2, "failreason");
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