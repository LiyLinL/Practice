package com.liy.generator.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Jackson {

    @JsonProperty("MESSAGE_ID")
    private String messageId;

    @JsonProperty("PROJECT")
    private String project;

    @JsonProperty("REQ_ID")
    private String reqId;

    @JsonProperty("SITE")
    private String site;

    @JsonProperty("FACTORY")
    private String factory;

    @JsonProperty("LINE_ID")
    private String lineId;

    @JsonProperty("OPERATION")
    private String operation;

    @JsonProperty("RESOURCE")
    private String resource;

    @JsonProperty("SENDER")
    private String sender;

    @JsonProperty("RECEIVER")
    private String receiver;

    @JsonProperty("STATION")
    private String station;

    @JsonProperty("SEND_TIME")
    private String sendTime;

    @JsonProperty("CARRIER_ID")
    private String carrierId;

    @JsonProperty("WORK_MODE")
    private String workMode;

    @JsonProperty("QTY")
    private String qty;

//    @JsonProperty("LOT_LIST")
//    private List<CheckInLot> lotList = new ArrayList<>();

    @JsonProperty("SN_LIST")
    private List<Sn> snList = new ArrayList<>();

    @JsonProperty("OTHER_1")
    private String other1;

    @JsonProperty("OTHER_2")
    private String other2;

    @JsonProperty("OTHER_3")
    private String other3;

    @JsonProperty("SN")
    private String sn;

    @JsonProperty("NEED_RECIPE")
    private String needRecipe;

    @JsonProperty("IS_BOOKING")
    private String isBooking;

    @JsonProperty("MOLD")
    private String mold;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId( String messageId ) {
        this.messageId = messageId;
    }

    public String getProject() {
        return project;
    }

    public void setProject( String project ) {
        this.project = project;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId( String reqId ) {
        this.reqId = reqId;
    }

    public String getSite() {
        return site;
    }

    public void setSite( String site ) {
        this.site = site;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory( String factory ) {
        this.factory = factory;
    }

    public String getLineId() {
        return lineId;
    }

    public void setLineId( String lineId ) {
        this.lineId = lineId;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation( String operation ) {
        this.operation = operation;
    }

    public String getResource() {
        return resource;
    }

    public void setResource( String resource ) {
        this.resource = resource;
    }

    public String getSender() {
        return sender;
    }

    public void setSender( String sender ) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver( String receiver ) {
        this.receiver = receiver;
    }

    public String getStation() {
        return station;
    }

    public void setStation( String station ) {
        this.station = station;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime( String sendTime ) {
        this.sendTime = sendTime;
    }

    public String getCarrierId() {
        return carrierId;
    }

    public void setCarrierId( String carrierId ) {
        this.carrierId = carrierId;
    }

    public String getWorkMode() {
        return workMode;
    }

    public void setWorkMode( String workMode ) {
        this.workMode = workMode;
    }

    public String getQty() {
        return qty;
    }

    public void setQty( String qty ) {
        this.qty = qty;
    }

    public String getOther1() {
        return other1;
    }

    public void setOther1( String other1 ) {
        this.other1 = other1;
    }

    public String getOther2() {
        return other2;
    }

    public void setOther2( String other2 ) {
        this.other2 = other2;
    }

    public String getOther3() {
        return other3;
    }

    public void setOther3( String other3 ) {
        this.other3 = other3;
    }

    public String getSn() {
        return sn;
    }

    public void setSn( String sn ) {
        this.sn = sn;
    }

    public String getNeedRecipe() {
        return needRecipe;
    }

    public void setNeedRecipe( String needRecipe ) {
        this.needRecipe = needRecipe;
    }

    public String getIsBooking() {
        return isBooking;
    }

    public void setIsBooking( String isBooking ) {
        this.isBooking = isBooking;
    }

    public String getMold() {
        return mold;
    }

    public void setMold( String mold ) {
        this.mold = mold;
    }

    public List<Sn> getSnList() {
        return snList;
    }

    public void setSnList( List<Sn> snList ) {
        this.snList = snList;
    }
}
