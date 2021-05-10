package com.liy.generator.entity;

import java.util.ArrayList;
import java.util.Date;
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

        public Criteria andTaskNoIsNull() {
            addCriterion("TASK_NO is null");
            return (Criteria) this;
        }

        public Criteria andTaskNoIsNotNull() {
            addCriterion("TASK_NO is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNoEqualTo(String value) {
            addCriterion("TASK_NO =", value, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoNotEqualTo(String value) {
            addCriterion("TASK_NO <>", value, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoGreaterThan(String value) {
            addCriterion("TASK_NO >", value, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoGreaterThanOrEqualTo(String value) {
            addCriterion("TASK_NO >=", value, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoLessThan(String value) {
            addCriterion("TASK_NO <", value, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoLessThanOrEqualTo(String value) {
            addCriterion("TASK_NO <=", value, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoLike(String value) {
            addCriterion("TASK_NO like", value, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoNotLike(String value) {
            addCriterion("TASK_NO not like", value, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoIn(List<String> values) {
            addCriterion("TASK_NO in", values, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoNotIn(List<String> values) {
            addCriterion("TASK_NO not in", values, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoBetween(String value1, String value2) {
            addCriterion("TASK_NO between", value1, value2, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoNotBetween(String value1, String value2) {
            addCriterion("TASK_NO not between", value1, value2, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNull() {
            addCriterion("TASK_NAME is null");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNotNull() {
            addCriterion("TASK_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNameEqualTo(String value) {
            addCriterion("TASK_NAME =", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotEqualTo(String value) {
            addCriterion("TASK_NAME <>", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThan(String value) {
            addCriterion("TASK_NAME >", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThanOrEqualTo(String value) {
            addCriterion("TASK_NAME >=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThan(String value) {
            addCriterion("TASK_NAME <", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThanOrEqualTo(String value) {
            addCriterion("TASK_NAME <=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLike(String value) {
            addCriterion("TASK_NAME like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotLike(String value) {
            addCriterion("TASK_NAME not like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameIn(List<String> values) {
            addCriterion("TASK_NAME in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotIn(List<String> values) {
            addCriterion("TASK_NAME not in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameBetween(String value1, String value2) {
            addCriterion("TASK_NAME between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotBetween(String value1, String value2) {
            addCriterion("TASK_NAME not between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNull() {
            addCriterion("CLASS_NAME is null");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNotNull() {
            addCriterion("CLASS_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andClassNameEqualTo(String value) {
            addCriterion("CLASS_NAME =", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotEqualTo(String value) {
            addCriterion("CLASS_NAME <>", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThan(String value) {
            addCriterion("CLASS_NAME >", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThanOrEqualTo(String value) {
            addCriterion("CLASS_NAME >=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThan(String value) {
            addCriterion("CLASS_NAME <", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThanOrEqualTo(String value) {
            addCriterion("CLASS_NAME <=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLike(String value) {
            addCriterion("CLASS_NAME like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotLike(String value) {
            addCriterion("CLASS_NAME not like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameIn(List<String> values) {
            addCriterion("CLASS_NAME in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotIn(List<String> values) {
            addCriterion("CLASS_NAME not in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameBetween(String value1, String value2) {
            addCriterion("CLASS_NAME between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotBetween(String value1, String value2) {
            addCriterion("CLASS_NAME not between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andExecuteParameterIsNull() {
            addCriterion("EXECUTE_PARAMETER is null");
            return (Criteria) this;
        }

        public Criteria andExecuteParameterIsNotNull() {
            addCriterion("EXECUTE_PARAMETER is not null");
            return (Criteria) this;
        }

        public Criteria andExecuteParameterEqualTo(String value) {
            addCriterion("EXECUTE_PARAMETER =", value, "executeParameter");
            return (Criteria) this;
        }

        public Criteria andExecuteParameterNotEqualTo(String value) {
            addCriterion("EXECUTE_PARAMETER <>", value, "executeParameter");
            return (Criteria) this;
        }

        public Criteria andExecuteParameterGreaterThan(String value) {
            addCriterion("EXECUTE_PARAMETER >", value, "executeParameter");
            return (Criteria) this;
        }

        public Criteria andExecuteParameterGreaterThanOrEqualTo(String value) {
            addCriterion("EXECUTE_PARAMETER >=", value, "executeParameter");
            return (Criteria) this;
        }

        public Criteria andExecuteParameterLessThan(String value) {
            addCriterion("EXECUTE_PARAMETER <", value, "executeParameter");
            return (Criteria) this;
        }

        public Criteria andExecuteParameterLessThanOrEqualTo(String value) {
            addCriterion("EXECUTE_PARAMETER <=", value, "executeParameter");
            return (Criteria) this;
        }

        public Criteria andExecuteParameterLike(String value) {
            addCriterion("EXECUTE_PARAMETER like", value, "executeParameter");
            return (Criteria) this;
        }

        public Criteria andExecuteParameterNotLike(String value) {
            addCriterion("EXECUTE_PARAMETER not like", value, "executeParameter");
            return (Criteria) this;
        }

        public Criteria andExecuteParameterIn(List<String> values) {
            addCriterion("EXECUTE_PARAMETER in", values, "executeParameter");
            return (Criteria) this;
        }

        public Criteria andExecuteParameterNotIn(List<String> values) {
            addCriterion("EXECUTE_PARAMETER not in", values, "executeParameter");
            return (Criteria) this;
        }

        public Criteria andExecuteParameterBetween(String value1, String value2) {
            addCriterion("EXECUTE_PARAMETER between", value1, value2, "executeParameter");
            return (Criteria) this;
        }

        public Criteria andExecuteParameterNotBetween(String value1, String value2) {
            addCriterion("EXECUTE_PARAMETER not between", value1, value2, "executeParameter");
            return (Criteria) this;
        }

        public Criteria andSchedulerRuleIsNull() {
            addCriterion("SCHEDULER_RULE is null");
            return (Criteria) this;
        }

        public Criteria andSchedulerRuleIsNotNull() {
            addCriterion("SCHEDULER_RULE is not null");
            return (Criteria) this;
        }

        public Criteria andSchedulerRuleEqualTo(String value) {
            addCriterion("SCHEDULER_RULE =", value, "schedulerRule");
            return (Criteria) this;
        }

        public Criteria andSchedulerRuleNotEqualTo(String value) {
            addCriterion("SCHEDULER_RULE <>", value, "schedulerRule");
            return (Criteria) this;
        }

        public Criteria andSchedulerRuleGreaterThan(String value) {
            addCriterion("SCHEDULER_RULE >", value, "schedulerRule");
            return (Criteria) this;
        }

        public Criteria andSchedulerRuleGreaterThanOrEqualTo(String value) {
            addCriterion("SCHEDULER_RULE >=", value, "schedulerRule");
            return (Criteria) this;
        }

        public Criteria andSchedulerRuleLessThan(String value) {
            addCriterion("SCHEDULER_RULE <", value, "schedulerRule");
            return (Criteria) this;
        }

        public Criteria andSchedulerRuleLessThanOrEqualTo(String value) {
            addCriterion("SCHEDULER_RULE <=", value, "schedulerRule");
            return (Criteria) this;
        }

        public Criteria andSchedulerRuleLike(String value) {
            addCriterion("SCHEDULER_RULE like", value, "schedulerRule");
            return (Criteria) this;
        }

        public Criteria andSchedulerRuleNotLike(String value) {
            addCriterion("SCHEDULER_RULE not like", value, "schedulerRule");
            return (Criteria) this;
        }

        public Criteria andSchedulerRuleIn(List<String> values) {
            addCriterion("SCHEDULER_RULE in", values, "schedulerRule");
            return (Criteria) this;
        }

        public Criteria andSchedulerRuleNotIn(List<String> values) {
            addCriterion("SCHEDULER_RULE not in", values, "schedulerRule");
            return (Criteria) this;
        }

        public Criteria andSchedulerRuleBetween(String value1, String value2) {
            addCriterion("SCHEDULER_RULE between", value1, value2, "schedulerRule");
            return (Criteria) this;
        }

        public Criteria andSchedulerRuleNotBetween(String value1, String value2) {
            addCriterion("SCHEDULER_RULE not between", value1, value2, "schedulerRule");
            return (Criteria) this;
        }

        public Criteria andFrozenStatusIsNull() {
            addCriterion("FROZEN_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andFrozenStatusIsNotNull() {
            addCriterion("FROZEN_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andFrozenStatusEqualTo(String value) {
            addCriterion("FROZEN_STATUS =", value, "frozenStatus");
            return (Criteria) this;
        }

        public Criteria andFrozenStatusNotEqualTo(String value) {
            addCriterion("FROZEN_STATUS <>", value, "frozenStatus");
            return (Criteria) this;
        }

        public Criteria andFrozenStatusGreaterThan(String value) {
            addCriterion("FROZEN_STATUS >", value, "frozenStatus");
            return (Criteria) this;
        }

        public Criteria andFrozenStatusGreaterThanOrEqualTo(String value) {
            addCriterion("FROZEN_STATUS >=", value, "frozenStatus");
            return (Criteria) this;
        }

        public Criteria andFrozenStatusLessThan(String value) {
            addCriterion("FROZEN_STATUS <", value, "frozenStatus");
            return (Criteria) this;
        }

        public Criteria andFrozenStatusLessThanOrEqualTo(String value) {
            addCriterion("FROZEN_STATUS <=", value, "frozenStatus");
            return (Criteria) this;
        }

        public Criteria andFrozenStatusLike(String value) {
            addCriterion("FROZEN_STATUS like", value, "frozenStatus");
            return (Criteria) this;
        }

        public Criteria andFrozenStatusNotLike(String value) {
            addCriterion("FROZEN_STATUS not like", value, "frozenStatus");
            return (Criteria) this;
        }

        public Criteria andFrozenStatusIn(List<String> values) {
            addCriterion("FROZEN_STATUS in", values, "frozenStatus");
            return (Criteria) this;
        }

        public Criteria andFrozenStatusNotIn(List<String> values) {
            addCriterion("FROZEN_STATUS not in", values, "frozenStatus");
            return (Criteria) this;
        }

        public Criteria andFrozenStatusBetween(String value1, String value2) {
            addCriterion("FROZEN_STATUS between", value1, value2, "frozenStatus");
            return (Criteria) this;
        }

        public Criteria andFrozenStatusNotBetween(String value1, String value2) {
            addCriterion("FROZEN_STATUS not between", value1, value2, "frozenStatus");
            return (Criteria) this;
        }

        public Criteria andFrozenTimeIsNull() {
            addCriterion("FROZEN_TIME is null");
            return (Criteria) this;
        }

        public Criteria andFrozenTimeIsNotNull() {
            addCriterion("FROZEN_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andFrozenTimeEqualTo(Date value) {
            addCriterion("FROZEN_TIME =", value, "frozenTime");
            return (Criteria) this;
        }

        public Criteria andFrozenTimeNotEqualTo(Date value) {
            addCriterion("FROZEN_TIME <>", value, "frozenTime");
            return (Criteria) this;
        }

        public Criteria andFrozenTimeGreaterThan(Date value) {
            addCriterion("FROZEN_TIME >", value, "frozenTime");
            return (Criteria) this;
        }

        public Criteria andFrozenTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("FROZEN_TIME >=", value, "frozenTime");
            return (Criteria) this;
        }

        public Criteria andFrozenTimeLessThan(Date value) {
            addCriterion("FROZEN_TIME <", value, "frozenTime");
            return (Criteria) this;
        }

        public Criteria andFrozenTimeLessThanOrEqualTo(Date value) {
            addCriterion("FROZEN_TIME <=", value, "frozenTime");
            return (Criteria) this;
        }

        public Criteria andFrozenTimeIn(List<Date> values) {
            addCriterion("FROZEN_TIME in", values, "frozenTime");
            return (Criteria) this;
        }

        public Criteria andFrozenTimeNotIn(List<Date> values) {
            addCriterion("FROZEN_TIME not in", values, "frozenTime");
            return (Criteria) this;
        }

        public Criteria andFrozenTimeBetween(Date value1, Date value2) {
            addCriterion("FROZEN_TIME between", value1, value2, "frozenTime");
            return (Criteria) this;
        }

        public Criteria andFrozenTimeNotBetween(Date value1, Date value2) {
            addCriterion("FROZEN_TIME not between", value1, value2, "frozenTime");
            return (Criteria) this;
        }

        public Criteria andUnfrozenTimeIsNull() {
            addCriterion("UNFROZEN_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUnfrozenTimeIsNotNull() {
            addCriterion("UNFROZEN_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUnfrozenTimeEqualTo(Date value) {
            addCriterion("UNFROZEN_TIME =", value, "unfrozenTime");
            return (Criteria) this;
        }

        public Criteria andUnfrozenTimeNotEqualTo(Date value) {
            addCriterion("UNFROZEN_TIME <>", value, "unfrozenTime");
            return (Criteria) this;
        }

        public Criteria andUnfrozenTimeGreaterThan(Date value) {
            addCriterion("UNFROZEN_TIME >", value, "unfrozenTime");
            return (Criteria) this;
        }

        public Criteria andUnfrozenTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UNFROZEN_TIME >=", value, "unfrozenTime");
            return (Criteria) this;
        }

        public Criteria andUnfrozenTimeLessThan(Date value) {
            addCriterion("UNFROZEN_TIME <", value, "unfrozenTime");
            return (Criteria) this;
        }

        public Criteria andUnfrozenTimeLessThanOrEqualTo(Date value) {
            addCriterion("UNFROZEN_TIME <=", value, "unfrozenTime");
            return (Criteria) this;
        }

        public Criteria andUnfrozenTimeIn(List<Date> values) {
            addCriterion("UNFROZEN_TIME in", values, "unfrozenTime");
            return (Criteria) this;
        }

        public Criteria andUnfrozenTimeNotIn(List<Date> values) {
            addCriterion("UNFROZEN_TIME not in", values, "unfrozenTime");
            return (Criteria) this;
        }

        public Criteria andUnfrozenTimeBetween(Date value1, Date value2) {
            addCriterion("UNFROZEN_TIME between", value1, value2, "unfrozenTime");
            return (Criteria) this;
        }

        public Criteria andUnfrozenTimeNotBetween(Date value1, Date value2) {
            addCriterion("UNFROZEN_TIME not between", value1, value2, "unfrozenTime");
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