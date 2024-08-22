package com.baidu.searchbox.datachannel;

import android.content.BroadcastReceiver;
import android.content.Intent;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseBroadcastReceiver extends BroadcastReceiver {
    public String mAction;
    public String mHost;
    public String mPage;

    public abstract void release();

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getClass().getSimpleName());
        builder.append(" ## ");
        builder.append("host:" + this.mHost);
        builder.append(" ## ");
        builder.append("page:" + this.mPage);
        builder.append(" ## ");
        builder.append("action:" + this.mAction);
        return builder.toString();
    }

    /* access modifiers changed from: protected */
    public String parseIntentToJson(Intent intent) {
        String action = intent.getAction();
        String data = intent.getStringExtra("data");
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("action", action);
            if (data != null) {
                jsonObject.put("data", data);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jsonObject.toString();
    }
}
