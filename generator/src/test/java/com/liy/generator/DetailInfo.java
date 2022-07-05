package com.liy.generator;

import java.util.List;

public class DetailInfo {

    private int seq;

    private String LEVEL;

    private String name;

    private String value;
    private List<DetailInfo> detailInfoList;

    public DetailInfo() {
    }

    public DetailInfo( int seq, String value ) {
        this.seq = seq;
        this.value = value;
    }

    public DetailInfo( String LEVEL, String name ) {
        this.LEVEL = LEVEL;
        this.name = name;
    }

    public String getLEVEL() {
        return LEVEL;
    }

    public void setLEVEL( String LEVEL ) {
        this.LEVEL = LEVEL;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public List<DetailInfo> getDetailInfoList() {
        return detailInfoList;
    }

    public void setDetailInfoList( List<DetailInfo> detailInfoList ) {
        this.detailInfoList = detailInfoList;
    }

    public String getValue() {
        return value;
    }

    public void setValue( String value ) {
        this.value = value;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq( int seq ) {
        this.seq = seq;
    }
}
