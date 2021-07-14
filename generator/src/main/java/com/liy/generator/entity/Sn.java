package com.liy.generator.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Sn {

    @JsonProperty("SN")
    private String sn;

    @JsonProperty("STATUS")
    private String status;

    @JsonProperty("DC_INFO")
    private List<DcInfo> dcInfoList = new ArrayList<>();

    public String getSn() {
        return sn;
    }

    public void setSn( String sn ) {
        this.sn = sn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus( String status ) {
        this.status = status;
    }

    public List<DcInfo> getDcInfoList() {
        return dcInfoList;
    }

    public void setDcInfoList( List<DcInfo> dcInfoList ) {
        this.dcInfoList = dcInfoList;
    }
}
