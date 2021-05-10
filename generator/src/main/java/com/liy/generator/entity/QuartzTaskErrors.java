package com.liy.generator.entity;

import java.util.Date;

public class QuartzTaskErrors {
    private Long id;

    private String taskExecuteRecordid;

    private String errorKey;

    private Date createTime;

    private Date lastModifyTime;

    private String errorValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskExecuteRecordid() {
        return taskExecuteRecordid;
    }

    public void setTaskExecuteRecordid(String taskExecuteRecordid) {
        this.taskExecuteRecordid = taskExecuteRecordid;
    }

    public String getErrorKey() {
        return errorKey;
    }

    public void setErrorKey(String errorKey) {
        this.errorKey = errorKey;
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

    public String getErrorValue() {
        return errorValue;
    }

    public void setErrorValue(String errorValue) {
        this.errorValue = errorValue;
    }
}