package com.baidu.map.poitalos.model;

import com.baidu.map.poitalos.Common;
import com.baidu.talos.core.data.ParamMap;

public class SingleWaterDropModel {
    private int currentHeight;
    private String iconUrl;
    private String locX;
    private String locY;
    private String poiTitle;
    private String uid;

    public SingleWaterDropModel() {
    }

    public SingleWaterDropModel(String locX2, String locY2, String uid2, String iconUrl2, String poiTitle2, int currentHeight2) {
        this.locX = locX2;
        this.locY = locY2;
        this.uid = uid2;
        this.iconUrl = iconUrl2;
        this.poiTitle = poiTitle2;
        this.currentHeight = currentHeight2;
    }

    public String getLocX() {
        return this.locX;
    }

    public void setLocX(String locX2) {
        this.locX = locX2;
    }

    public String getLocY() {
        return this.locY;
    }

    public void setLocY(String locY2) {
        this.locY = locY2;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String uid2) {
        this.uid = uid2;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setIconUrl(String iconUrl2) {
        this.iconUrl = iconUrl2;
    }

    public String getPoiTitle() {
        return this.poiTitle;
    }

    public void setPoiTitle(String poiTitle2) {
        this.poiTitle = poiTitle2;
    }

    public int getCurrentHeight() {
        return this.currentHeight;
    }

    public void setCurrentHeight(int currentHeight2) {
        this.currentHeight = currentHeight2;
    }

    public static SingleWaterDropModel buildModel(ParamMap params) {
        if (params == null) {
            return null;
        }
        try {
            SingleWaterDropModel singleWaterDropModel = new SingleWaterDropModel();
            singleWaterDropModel.setLocX(params.getString("loc_x"));
            singleWaterDropModel.setLocY(params.getString("loc_y"));
            singleWaterDropModel.setUid(params.getString("uid"));
            singleWaterDropModel.setIconUrl(params.getString("icon_url"));
            singleWaterDropModel.setPoiTitle(params.getString("poi_title"));
            singleWaterDropModel.setCurrentHeight(params.getInteger("current_height"));
            return singleWaterDropModel;
        } catch (Exception e2) {
            if (Common.DEBUG) {
                e2.printStackTrace();
            }
            return null;
        }
    }
}
