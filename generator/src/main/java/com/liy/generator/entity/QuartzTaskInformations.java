package com.liy.generator.entity;

import java.util.Date;

public class QuartzTaskInformations {
    private Long id;

    private String site;

    private String taskName;

    private String className;

    private String executeParameter;

    private String schedulerRule;

    private String frozenStatus;

    private String production;

    private Date createdTime;

    private Date lastModifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
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

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
}