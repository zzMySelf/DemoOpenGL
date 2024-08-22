package com.baidu.swan.apps.component.abscomponents.simpledrawee;

import com.baidu.swan.apps.component.abscomponents.view.SwanAppViewComponentModel;
import org.json.JSONException;
import org.json.JSONObject;

public class SwanAppSimpleDraweeViewComponentModel extends SwanAppViewComponentModel {
    private static final String KEY_SRC = "src";
    private static final String TAG = "Component-Model-SimpleDrawee";
    public String imageSource = "";

    public SwanAppSimpleDraweeViewComponentModel(String componentType, String mComponentIdKey) {
        super(componentType, mComponentIdKey);
    }

    public void parseFromJson(JSONObject json) throws JSONException {
        if (json != null) {
            super.parseFromJson(json);
            this.imageSource = json.optString("src");
        }
    }
}
