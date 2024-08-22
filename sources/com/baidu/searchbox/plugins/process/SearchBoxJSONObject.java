package com.baidu.searchbox.plugins.process;

import android.text.TextUtils;
import com.baidu.searchbox.config.AppConfig;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class SearchBoxJSONObject implements Serializable {
    private static final boolean DEBUG = (AppConfig.isDebug() & true);
    private static final String TAG = "SearchBoxJSONObject";
    private static final long serialVersionUID = -5264492144785045067L;
    private String mValue;

    public SearchBoxJSONObject(JSONObject jObject) {
        if (jObject != null) {
            this.mValue = jObject.toString();
        }
    }

    public JSONObject toJSONObject() {
        if (TextUtils.isEmpty(this.mValue)) {
            return null;
        }
        try {
            return new JSONObject(this.mValue);
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
            return null;
        }
    }
}
