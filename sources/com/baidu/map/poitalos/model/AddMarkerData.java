package com.baidu.map.poitalos.model;

import com.baidu.map.poitalos.Common;
import com.baidu.talos.core.data.ParamArray;
import com.baidu.talos.core.data.ParamMap;
import java.util.ArrayList;
import java.util.List;

public class AddMarkerData {
    private int currentHeight;
    private String currentState;
    private int filterHeight;
    private String industryIdentifier;
    private List<POIData> poiData;

    public AddMarkerData() {
    }

    public AddMarkerData(String industryIdentifier2, String currentState2, int currentHeight2, int filterHeight2, List<POIData> poiData2) {
        this.industryIdentifier = industryIdentifier2;
        this.currentState = currentState2;
        this.currentHeight = currentHeight2;
        this.filterHeight = filterHeight2;
        this.poiData = poiData2;
    }

    public String getIndustryIdentifier() {
        return this.industryIdentifier;
    }

    public void setIndustryIdentifier(String industryIdentifier2) {
        this.industryIdentifier = industryIdentifier2;
    }

    public String getCurrentState() {
        return this.currentState;
    }

    public void setCurrentState(String currentState2) {
        this.currentState = currentState2;
    }

    public int getCurrentHeight() {
        return this.currentHeight;
    }

    public void setCurrentHeight(int currentHeight2) {
        this.currentHeight = currentHeight2;
    }

    public int getFilterHeight() {
        return this.filterHeight;
    }

    public void setFilterHeight(int filterHeight2) {
        this.filterHeight = filterHeight2;
    }

    public List<POIData> getPoiData() {
        return this.poiData;
    }

    public void setPoiData(List<POIData> poiData2) {
        this.poiData = poiData2;
    }

    public static class POIData {
        private String iconUrl;
        private String locX;
        private String locY;
        private String poiTitle;
        private String uid;

        public POIData() {
        }

        public POIData(String locX2, String locY2, String poiTitle2, String uid2, String iconUrl2) {
            this.locX = locX2;
            this.locY = locY2;
            this.poiTitle = poiTitle2;
            this.uid = uid2;
            this.iconUrl = iconUrl2;
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

        public String getPoiTitle() {
            return this.poiTitle;
        }

        public void setPoiTitle(String poiTitle2) {
            this.poiTitle = poiTitle2;
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
    }

    public static AddMarkerData buildModel(ParamMap params) {
        if (params == null) {
            return null;
        }
        try {
            AddMarkerData addMarkerData = new AddMarkerData();
            if (params.hasKey("industryIdentifier")) {
                addMarkerData.setIndustryIdentifier(params.getString("industryIdentifier"));
            }
            if (params.hasKey("currentState")) {
                addMarkerData.setCurrentState(params.getString("currentState"));
            }
            if (params.hasKey("currentHeight")) {
                addMarkerData.setCurrentHeight(params.getInteger("currentHeight"));
            }
            if (params.hasKey("filterHeight")) {
                addMarkerData.setFilterHeight(params.getInteger("filterHeight"));
            }
            if (params.hasKey("poiData")) {
                List<POIData> poiDataList = new ArrayList<>();
                ParamArray array = params.getArray("poiData");
                for (int i2 = 0; i2 < array.size(); i2++) {
                    ParamMap poiDataMap = array.getMap(i2);
                    POIData poiData2 = new POIData();
                    poiData2.setLocX(poiDataMap.getString("loc_x"));
                    poiData2.setLocY(poiDataMap.getString("loc_y"));
                    poiData2.setPoiTitle(poiDataMap.getString("poi_title"));
                    poiData2.setUid(poiDataMap.getString("uid"));
                    poiData2.setIconUrl(poiDataMap.getString("icon_url"));
                    poiDataList.add(poiData2);
                }
                addMarkerData.setPoiData(poiDataList);
            }
            return addMarkerData;
        } catch (Exception e2) {
            if (Common.DEBUG) {
                e2.printStackTrace();
            }
            return null;
        }
    }
}
