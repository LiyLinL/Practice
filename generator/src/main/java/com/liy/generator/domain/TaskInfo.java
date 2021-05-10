package com.liy.generator.domain;

public class TaskInfo {

    private String taskNo;

    private String cron;

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo( String taskNo ) {
        this.taskNo = taskNo;
    }

    public String getCron() {
        return cron;
    }

    public void setCron( String cron ) {
        this.cron = cron;
    }
}
