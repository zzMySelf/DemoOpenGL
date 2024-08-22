package com.baidu.map.poipage.bee.mgr;

import com.baidu.map.poipage.bee.data.MapPoiSrcData;
import org.json.JSONObject;

public class BMWebViewPipeManager {
    private String backArgs;
    private MapPoiSrcData mapPoiSrcData = new MapPoiSrcData();
    private JSONObject s;

    private static class BMwebViewPipeManagerHolder {
        static final BMWebViewPipeManager BM_WEB_VIEW_PIPE_MANAGER = new BMWebViewPipeManager();

        private BMwebViewPipeManagerHolder() {
        }
    }

    public static BMWebViewPipeManager getInstance() {
        return BMwebViewPipeManagerHolder.BM_WEB_VIEW_PIPE_MANAGER;
    }

    public void storeSubContentParam(JSONObject s2) {
        this.s = s2;
    }

    public JSONObject getSubContentParam() {
        return this.s;
    }

    public String getBackArgs() {
        return this.backArgs;
    }

    public void setBackArgs(String backArgs2) {
        this.backArgs = backArgs2;
    }

    public MapPoiSrcData getMapPoiSrcData() {
        return this.mapPoiSrcData;
    }

    public void setMapPoiSrcData(MapPoiSrcData mapPoiSrcData2) {
        this.mapPoiSrcData = mapPoiSrcData2;
    }
}
