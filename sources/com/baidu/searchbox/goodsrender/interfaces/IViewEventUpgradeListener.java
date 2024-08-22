package com.baidu.searchbox.goodsrender.interfaces;

import android.view.View;
import org.json.JSONObject;

public interface IViewEventUpgradeListener extends IBaseListener {
    void handleViewEventCallback(String str, String str2, View view2, JSONObject jSONObject);
}
