package com.liy.generator.entity;

import java.util.Date;

public class QuartzTaskInformations {
    private Long id;

    private String taskNo;

    private String taskName;

    private String className;

    private String executeParameter;

    private String schedulerRule;

    private String frozenStatus;

    private Date frozenTime;

    private Date unfrozenTime;

    private Date createTime;

    private Date lastModifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getExecuteParameter() {
        return executeParameter;
    }

    public void setExecuteParameter(String executeParameter) {
        this.executeParameter = executeParameter;
    }

    public String getSchedulerRule() {
        return schedulerRule;
    }

    public void setSchedulerRule(String schedulerRule) {
        this.schedulerRule = schedulerRule;
    }

    public String getFrozenStatus() {
        return frozenStatus;
    }

    public void setFrozenStatus(String frozenStatus) {
        this.frozenStatus = frozenStatus;
    }

    public Date getFrozenTime() {
        return frozenTime;
    }

    public void setFrozenTime(Date frozenTime) {
        this.frozenTime = frozenTime;
    }

    public Date getUnfrozenTime() {
        return unfrozenTime;
    }

    public void setUnfrozenTime(Date unfrozenTime) {
        this.unfrozenTime = unfrozenTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
}