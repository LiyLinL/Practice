package com.liy.generator.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DcInfo {

    @JsonProperty("K")
    private String key;

    @JsonProperty("V")
    private String value;

    @JsonProperty("T")
    private String time;

    public String getKey() {
        return key;
    }

    public void setKey( String key ) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue( String value ) {
        this.value = value;
    }

    public String getTime() {
        return time;
    }

    public void setTime( String time ) {
        this.time = time;
    }
}
