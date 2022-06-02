package com.liy.generator;

import java.util.List;

public class DetailInfo {

    private String LEVEL;

    private String name;

    private List<DetailInfo> detailInfoList;

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
}
