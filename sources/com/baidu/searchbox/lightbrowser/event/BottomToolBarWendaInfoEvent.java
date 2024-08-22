package com.baidu.searchbox.lightbrowser.event;

import org.json.JSONObject;

public class BottomToolBarWendaInfoEvent {
    public JSONObject extObj = new JSONObject();
    public String scheme;
    public int status;
    public String titleName;

    public BottomToolBarWendaInfoEvent(int status2, String titleName2, String scheme2, JSONObject extObj2) {
        this.status = status2;
        this.titleName = titleName2;
        this.scheme = scheme2;
        this.extObj = extObj2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("status=").append(this.status).append(" titleName=").append(this.titleName).append(" scheme=").append(this.scheme).append(" extObj=").append(String.valueOf(this.extObj));
        return sb.toString();
    }
}
