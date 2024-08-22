package com.baidu.searchbox.toolbar;

import org.json.JSONObject;

public class WendaToolBarItem extends BaseToolBarItem {
    private JSONObject extObj;
    private String mJumpScheme;
    private int mStatus;

    public WendaToolBarItem(int itemId) {
        super(itemId);
    }

    public WendaToolBarItem(int itemId, String jumpScheme, int status, JSONObject extObj2) {
        super(itemId);
        this.mJumpScheme = jumpScheme;
        this.mStatus = status;
        this.extObj = extObj2;
    }

    public void setExtObj(JSONObject extObj2) {
        this.extObj = extObj2;
    }

    public void setJumpScheme(String jumpScheme) {
        this.mJumpScheme = jumpScheme;
    }

    public void setStatus(int status) {
        this.mStatus = status;
    }

    public String getJumpScheme() {
        return this.mJumpScheme;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public JSONObject getExtObj() {
        return this.extObj;
    }
}
