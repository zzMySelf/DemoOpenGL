package com.baidu.searchbox.ui.animview.praise.guide;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class CurrentShowData {
    private int cycleCurrentcount;
    private int dayCurrentCount;
    private int sessionCurrentCount;

    public int getSessionCurrentCount() {
        return this.sessionCurrentCount;
    }

    public void setSessionCurrentCount(int sessionCurrentCount2) {
        this.sessionCurrentCount = sessionCurrentCount2;
    }

    public int getDayCurrentCount() {
        return this.dayCurrentCount;
    }

    public void setDayCurrentCount(int dayCurrentCount2) {
        this.dayCurrentCount = dayCurrentCount2;
    }

    public int getCycleCurrentcount() {
        return this.cycleCurrentcount;
    }

    public void setCycleCurrentcount(int cycleCurrentcount2) {
        this.cycleCurrentcount = cycleCurrentcount2;
    }

    public void parseData(String jsonString) {
        if (!TextUtils.isEmpty(jsonString)) {
            try {
                JSONObject jsonObject = new JSONObject(jsonString);
                setDayCurrentCount(jsonObject.optInt("day_current_count", 0));
                setCycleCurrentcount(jsonObject.optInt("cycle_current_count", 0));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public String toJson() {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("day_current_count", this.dayCurrentCount);
            jsonObject.put("cycle_current_count", this.cycleCurrentcount);
            return jsonObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
