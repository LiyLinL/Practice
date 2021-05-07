package com.liy.generator.entity;

import java.util.ArrayList;
import java.util.List;

public class QuartzTaskInformationsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QuartzTaskInformationsExample() {
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

        public Criteria andVersionIsNull() {
            addCriterion("VERSION is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("VERSION =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("VERSION <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("VERSION >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("VERSION >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("VERSION <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("VERSION <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("VERSION in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("VERSION not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("VERSION between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("VERSION not between", value1, value2, "version");
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

        public Criteria andTasknameIsNull() {
            addCriterion("TASKNAME is null");
            return (Criteria) this;
        }

        public Criteria andTasknameIsNotNull() {
            addCriterion("TASKNAME is not null");
            return (Criteria) this;
        }

        public Criteria andTasknameEqualTo(String value) {
            addCriterion("TASKNAME =", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameNotEqualTo(String value) {
            addCriterion("TASKNAME <>", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameGreaterThan(String value) {
            addCriterion("TASKNAME >", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameGreaterThanOrEqualTo(String value) {
            addCriterion("TASKNAME >=", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameLessThan(String value) {
            addCriterion("TASKNAME <", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameLessThanOrEqualTo(String value) {
            addCriterion("TASKNAME <=", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameLike(String value) {
            addCriterion("TASKNAME like", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameNotLike(String value) {
            addCriterion("TASKNAME not like", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameIn(List<String> values) {
            addCriterion("TASKNAME in", values, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameNotIn(List<String> values) {
            addCriterion("TASKNAME not in", values, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameBetween(String value1, String value2) {
            addCriterion("TASKNAME between", value1, value2, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameNotBetween(String value1, String value2) {
            addCriterion("TASKNAME not between", value1, value2, "taskname");
            return (Criteria) this;
        }

        public Criteria andSchedulerruleIsNull() {
            addCriterion("SCHEDULERRULE is null");
            return (Criteria) this;
        }

        public Criteria andSchedulerruleIsNotNull() {
            addCriterion("SCHEDULERRULE is not null");
            return (Criteria) this;
        }

        public Criteria andSchedulerruleEqualTo(String value) {
            addCriterion("SCHEDULERRULE =", value, "schedulerrule");
            return (Criteria) this;
        }

        public Criteria andSchedulerruleNotEqualTo(String value) {
            addCriterion("SCHEDULERRULE <>", value, "schedulerrule");
            return (Criteria) this;
        }

        public Criteria andSchedulerruleGreaterThan(String value) {
            addCriterion("SCHEDULERRULE >", value, "schedulerrule");
            return (Criteria) this;
        }

        public Criteria andSchedulerruleGreaterThanOrEqualTo(String value) {
            addCriterion("SCHEDULERRULE >=", value, "schedulerrule");
            return (Criteria) this;
        }

        public Criteria andSchedulerruleLessThan(String value) {
            addCriterion("SCHEDULERRULE <", value, "schedulerrule");
            return (Criteria) this;
        }

        public Criteria andSchedulerruleLessThanOrEqualTo(String value) {
            addCriterion("SCHEDULERRULE <=", value, "schedulerrule");
            return (Criteria) this;
        }

        public Criteria andSchedulerruleLike(String value) {
            addCriterion("SCHEDULERRULE like", value, "schedulerrule");
            return (Criteria) this;
        }

        public Criteria andSchedulerruleNotLike(String value) {
            addCriterion("SCHEDULERRULE not like", value, "schedulerrule");
            return (Criteria) this;
        }

        public Criteria andSchedulerruleIn(List<String> values) {
            addCriterion("SCHEDULERRULE in", values, "schedulerrule");
            return (Criteria) this;
        }

        public Criteria andSchedulerruleNotIn(List<String> values) {
            addCriterion("SCHEDULERRULE not in", values, "schedulerrule");
            return (Criteria) this;
        }

        public Criteria andSchedulerruleBetween(String value1, String value2) {
            addCriterion("SCHEDULERRULE between", value1, value2, "schedulerrule");
            return (Criteria) this;
        }

        public Criteria andSchedulerruleNotBetween(String value1, String value2) {
            addCriterion("SCHEDULERRULE not between", value1, value2, "schedulerrule");
            return (Criteria) this;
        }

        public Criteria andFrozenstatusIsNull() {
            addCriterion("FROZENSTATUS is null");
            return (Criteria) this;
        }

        public Criteria andFrozenstatusIsNotNull() {
            addCriterion("FROZENSTATUS is not null");
            return (Criteria) this;
        }

        public Criteria andFrozenstatusEqualTo(String value) {
            addCriterion("FROZENSTATUS =", value, "frozenstatus");
            return (Criteria) this;
        }

        public Criteria andFrozenstatusNotEqualTo(String value) {
            addCriterion("FROZENSTATUS <>", value, "frozenstatus");
            return (Criteria) this;
        }

        public Criteria andFrozenstatusGreaterThan(String value) {
            addCriterion("FROZENSTATUS >", value, "frozenstatus");
            return (Criteria) this;
        }

        public Criteria andFrozenstatusGreaterThanOrEqualTo(String value) {
            addCriterion("FROZENSTATUS >=", value, "frozenstatus");
            return (Criteria) this;
        }

        public Criteria andFrozenstatusLessThan(String value) {
            addCriterion("FROZENSTATUS <", value, "frozenstatus");
            return (Criteria) this;
        }

        public Criteria andFrozenstatusLessThanOrEqualTo(String value) {
            addCriterion("FROZENSTATUS <=", value, "frozenstatus");
            return (Criteria) this;
        }

        public Criteria andFrozenstatusLike(String value) {
            addCriterion("FROZENSTATUS like", value, "frozenstatus");
            return (Criteria) this;
        }

        public Criteria andFrozenstatusNotLike(String value) {
            addCriterion("FROZENSTATUS not like", value, "frozenstatus");
            return (Criteria) this;
        }

        public Criteria andFrozenstatusIn(List<String> values) {
            addCriterion("FROZENSTATUS in", values, "frozenstatus");
            return (Criteria) this;
        }

        public Criteria andFrozenstatusNotIn(List<String> values) {
            addCriterion("FROZENSTATUS not in", values, "frozenstatus");
            return (Criteria) this;
        }

        public Criteria andFrozenstatusBetween(String value1, String value2) {
            addCriterion("FROZENSTATUS between", value1, value2, "frozenstatus");
            return (Criteria) this;
        }

        public Criteria andFrozenstatusNotBetween(String value1, String value2) {
            addCriterion("FROZENSTATUS not between", value1, value2, "frozenstatus");
            return (Criteria) this;
        }

        public Criteria andExecutornoIsNull() {
            addCriterion("EXECUTORNO is null");
            return (Criteria) this;
        }

        public Criteria andExecutornoIsNotNull() {
            addCriterion("EXECUTORNO is not null");
            return (Criteria) this;
        }

        public Criteria andExecutornoEqualTo(String value) {
            addCriterion("EXECUTORNO =", value, "executorno");
            return (Criteria) this;
        }

        public Criteria andExecutornoNotEqualTo(String value) {
            addCriterion("EXECUTORNO <>", value, "executorno");
            return (Criteria) this;
        }

        public Criteria andExecutornoGreaterThan(String value) {
            addCriterion("EXECUTORNO >", value, "executorno");
            return (Criteria) this;
        }

        public Criteria andExecutornoGreaterThanOrEqualTo(String value) {
            addCriterion("EXECUTORNO >=", value, "executorno");
            return (Criteria) this;
        }

        public Criteria andExecutornoLessThan(String value) {
            addCriterion("EXECUTORNO <", value, "executorno");
            return (Criteria) this;
        }

        public Criteria andExecutornoLessThanOrEqualTo(String value) {
            addCriterion("EXECUTORNO <=", value, "executorno");
            return (Criteria) this;
        }

        public Criteria andExecutornoLike(String value) {
            addCriterion("EXECUTORNO like", value, "executorno");
            return (Criteria) this;
        }

        public Criteria andExecutornoNotLike(String value) {
            addCriterion("EXECUTORNO not like", value, "executorno");
            return (Criteria) this;
        }

        public Criteria andExecutornoIn(List<String> values) {
            addCriterion("EXECUTORNO in", values, "executorno");
            return (Criteria) this;
        }

        public Criteria andExecutornoNotIn(List<String> values) {
            addCriterion("EXECUTORNO not in", values, "executorno");
            return (Criteria) this;
        }

        public Criteria andExecutornoBetween(String value1, String value2) {
            addCriterion("EXECUTORNO between", value1, value2, "executorno");
            return (Criteria) this;
        }

        public Criteria andExecutornoNotBetween(String value1, String value2) {
            addCriterion("EXECUTORNO not between", value1, value2, "executorno");
            return (Criteria) this;
        }

        public Criteria andFrozentimeIsNull() {
            addCriterion("FROZENTIME is null");
            return (Criteria) this;
        }

        public Criteria andFrozentimeIsNotNull() {
            addCriterion("FROZENTIME is not null");
            return (Criteria) this;
        }

        public Criteria andFrozentimeEqualTo(Long value) {
            addCriterion("FROZENTIME =", value, "frozentime");
            return (Criteria) this;
        }

        public Criteria andFrozentimeNotEqualTo(Long value) {
            addCriterion("FROZENTIME <>", value, "frozentime");
            return (Criteria) this;
        }

        public Criteria andFrozentimeGreaterThan(Long value) {
            addCriterion("FROZENTIME >", value, "frozentime");
            return (Criteria) this;
        }

        public Criteria andFrozentimeGreaterThanOrEqualTo(Long value) {
            addCriterion("FROZENTIME >=", value, "frozentime");
            return (Criteria) this;
        }

        public Criteria andFrozentimeLessThan(Long value) {
            addCriterion("FROZENTIME <", value, "frozentime");
            return (Criteria) this;
        }

        public Criteria andFrozentimeLessThanOrEqualTo(Long value) {
            addCriterion("FROZENTIME <=", value, "frozentime");
            return (Criteria) this;
        }

        public Criteria andFrozentimeIn(List<Long> values) {
            addCriterion("FROZENTIME in", values, "frozentime");
            return (Criteria) this;
        }

        public Criteria andFrozentimeNotIn(List<Long> values) {
            addCriterion("FROZENTIME not in", values, "frozentime");
            return (Criteria) this;
        }

        public Criteria andFrozentimeBetween(Long value1, Long value2) {
            addCriterion("FROZENTIME between", value1, value2, "frozentime");
            return (Criteria) this;
        }

        public Criteria andFrozentimeNotBetween(Long value1, Long value2) {
            addCriterion("FROZENTIME not between", value1, value2, "frozentime");
            return (Criteria) this;
        }

        public Criteria andUnfrozentimeIsNull() {
            addCriterion("UNFROZENTIME is null");
            return (Criteria) this;
        }

        public Criteria andUnfrozentimeIsNotNull() {
            addCriterion("UNFROZENTIME is not null");
            return (Criteria) this;
        }

        public Criteria andUnfrozentimeEqualTo(Long value) {
            addCriterion("UNFROZENTIME =", value, "unfrozentime");
            return (Criteria) this;
        }

        public Criteria andUnfrozentimeNotEqualTo(Long value) {
            addCriterion("UNFROZENTIME <>", value, "unfrozentime");
            return (Criteria) this;
        }

        public Criteria andUnfrozentimeGreaterThan(Long value) {
            addCriterion("UNFROZENTIME >", value, "unfrozentime");
            return (Criteria) this;
        }

        public Criteria andUnfrozentimeGreaterThanOrEqualTo(Long value) {
            addCriterion("UNFROZENTIME >=", value, "unfrozentime");
            return (Criteria) this;
        }

        public Criteria andUnfrozentimeLessThan(Long value) {
            addCriterion("UNFROZENTIME <", value, "unfrozentime");
            return (Criteria) this;
        }

        public Criteria andUnfrozentimeLessThanOrEqualTo(Long value) {
            addCriterion("UNFROZENTIME <=", value, "unfrozentime");
            return (Criteria) this;
        }

        public Criteria andUnfrozentimeIn(List<Long> values) {
            addCriterion("UNFROZENTIME in", values, "unfrozentime");
            return (Criteria) this;
        }

        public Criteria andUnfrozentimeNotIn(List<Long> values) {
            addCriterion("UNFROZENTIME not in", values, "unfrozentime");
            return (Criteria) this;
        }

        public Criteria andUnfrozentimeBetween(Long value1, Long value2) {
            addCriterion("UNFROZENTIME between", value1, value2, "unfrozentime");
            return (Criteria) this;
        }

        public Criteria andUnfrozentimeNotBetween(Long value1, Long value2) {
            addCriterion("UNFROZENTIME not between", value1, value2, "unfrozentime");
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

        public Criteria andSendtypeIsNull() {
            addCriterion("SENDTYPE is null");
            return (Criteria) this;
        }

        public Criteria andSendtypeIsNotNull() {
            addCriterion("SENDTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andSendtypeEqualTo(String value) {
            addCriterion("SENDTYPE =", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeNotEqualTo(String value) {
            addCriterion("SENDTYPE <>", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeGreaterThan(String value) {
            addCriterion("SENDTYPE >", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeGreaterThanOrEqualTo(String value) {
            addCriterion("SENDTYPE >=", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeLessThan(String value) {
            addCriterion("SENDTYPE <", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeLessThanOrEqualTo(String value) {
            addCriterion("SENDTYPE <=", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeLike(String value) {
            addCriterion("SENDTYPE like", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeNotLike(String value) {
            addCriterion("SENDTYPE not like", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeIn(List<String> values) {
            addCriterion("SENDTYPE in", values, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeNotIn(List<String> values) {
            addCriterion("SENDTYPE not in", values, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeBetween(String value1, String value2) {
            addCriterion("SENDTYPE between", value1, value2, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeNotBetween(String value1, String value2) {
            addCriterion("SENDTYPE not between", value1, value2, "sendtype");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("URL is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("URL is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("URL =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("URL <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("URL >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("URL >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("URL <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("URL <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("URL like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("URL not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("URL in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("URL not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("URL between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("URL not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andExecuteparamterIsNull() {
            addCriterion("EXECUTEPARAMTER is null");
            return (Criteria) this;
        }

        public Criteria andExecuteparamterIsNotNull() {
            addCriterion("EXECUTEPARAMTER is not null");
            return (Criteria) this;
        }

        public Criteria andExecuteparamterEqualTo(String value) {
            addCriterion("EXECUTEPARAMTER =", value, "executeparamter");
            return (Criteria) this;
        }

        public Criteria andExecuteparamterNotEqualTo(String value) {
            addCriterion("EXECUTEPARAMTER <>", value, "executeparamter");
            return (Criteria) this;
        }

        public Criteria andExecuteparamterGreaterThan(String value) {
            addCriterion("EXECUTEPARAMTER >", value, "executeparamter");
            return (Criteria) this;
        }

        public Criteria andExecuteparamterGreaterThanOrEqualTo(String value) {
            addCriterion("EXECUTEPARAMTER >=", value, "executeparamter");
            return (Criteria) this;
        }

        public Criteria andExecuteparamterLessThan(String value) {
            addCriterion("EXECUTEPARAMTER <", value, "executeparamter");
            return (Criteria) this;
        }

        public Criteria andExecuteparamterLessThanOrEqualTo(String value) {
            addCriterion("EXECUTEPARAMTER <=", value, "executeparamter");
            return (Criteria) this;
        }

        public Criteria andExecuteparamterLike(String value) {
            addCriterion("EXECUTEPARAMTER like", value, "executeparamter");
            return (Criteria) this;
        }

        public Criteria andExecuteparamterNotLike(String value) {
            addCriterion("EXECUTEPARAMTER not like", value, "executeparamter");
            return (Criteria) this;
        }

        public Criteria andExecuteparamterIn(List<String> values) {
            addCriterion("EXECUTEPARAMTER in", values, "executeparamter");
            return (Criteria) this;
        }

        public Criteria andExecuteparamterNotIn(List<String> values) {
            addCriterion("EXECUTEPARAMTER not in", values, "executeparamter");
            return (Criteria) this;
        }

        public Criteria andExecuteparamterBetween(String value1, String value2) {
            addCriterion("EXECUTEPARAMTER between", value1, value2, "executeparamter");
            return (Criteria) this;
        }

        public Criteria andExecuteparamterNotBetween(String value1, String value2) {
            addCriterion("EXECUTEPARAMTER not between", value1, value2, "executeparamter");
            return (Criteria) this;
        }

        public Criteria andTimekeyIsNull() {
            addCriterion("TIMEKEY is null");
            return (Criteria) this;
        }

        public Criteria andTimekeyIsNotNull() {
            addCriterion("TIMEKEY is not null");
            return (Criteria) this;
        }

        public Criteria andTimekeyEqualTo(String value) {
            addCriterion("TIMEKEY =", value, "timekey");
            return (Criteria) this;
        }

        public Criteria andTimekeyNotEqualTo(String value) {
            addCriterion("TIMEKEY <>", value, "timekey");
            return (Criteria) this;
        }

        public Criteria andTimekeyGreaterThan(String value) {
            addCriterion("TIMEKEY >", value, "timekey");
            return (Criteria) this;
        }

        public Criteria andTimekeyGreaterThanOrEqualTo(String value) {
            addCriterion("TIMEKEY >=", value, "timekey");
            return (Criteria) this;
        }

        public Criteria andTimekeyLessThan(String value) {
            addCriterion("TIMEKEY <", value, "timekey");
            return (Criteria) this;
        }

        public Criteria andTimekeyLessThanOrEqualTo(String value) {
            addCriterion("TIMEKEY <=", value, "timekey");
            return (Criteria) this;
        }

        public Criteria andTimekeyLike(String value) {
            addCriterion("TIMEKEY like", value, "timekey");
            return (Criteria) this;
        }

        public Criteria andTimekeyNotLike(String value) {
            addCriterion("TIMEKEY not like", value, "timekey");
            return (Criteria) this;
        }

        public Criteria andTimekeyIn(List<String> values) {
            addCriterion("TIMEKEY in", values, "timekey");
            return (Criteria) this;
        }

        public Criteria andTimekeyNotIn(List<String> values) {
            addCriterion("TIMEKEY not in", values, "timekey");
            return (Criteria) this;
        }

        public Criteria andTimekeyBetween(String value1, String value2) {
            addCriterion("TIMEKEY between", value1, value2, "timekey");
            return (Criteria) this;
        }

        public Criteria andTimekeyNotBetween(String value1, String value2) {
            addCriterion("TIMEKEY not between", value1, value2, "timekey");
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