package com.liy.generator.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {
    @JsonProperty("RESULT")
    private String result;

    @JsonProperty("REQ_ID")
    private String reqId;

    @JsonProperty("MESSAGE")
    private String message;

    @JsonProperty("LOT_NO")
    private String lotNo;

    @JsonProperty("LOT_STATUS")
    private String lotStatus;

    public String getResult() {
        return result;
    }

    public void setResult( String result ) {
        this.result = result;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId( String reqId ) {
        this.reqId = reqId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage( String message ) {
        this.message = message;
    }

    public String getLotNo() {
        return lotNo;
    }

    public void setLotNo( String lotNo ) {
        this.lotNo = lotNo;
    }

    public String getLotStatus() {
        return lotStatus;
    }

    public void setLotStatus( String lotStatus ) {
        this.lotStatus = lotStatus;
    }
}
