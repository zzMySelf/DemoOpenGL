package com.baidu.searchbox.home.feed.videodetail.model;

import android.text.TextUtils;
import com.baidu.searchbox.kmm.personalcenter.entities.constants.ConstantsKt;
import org.json.JSONObject;

public class ToastConfig {
    public String btnText;
    public int mShowDelay;
    public int mShowTime;
    public String message;
    public String url;

    public static ToastConfig parse(JSONObject toastObj) {
        if (toastObj == null) {
            return null;
        }
        ToastConfig toastConfig = new ToastConfig();
        toastConfig.message = toastObj.optString("message");
        toastConfig.btnText = toastObj.optString("btnText");
        toastConfig.url = toastObj.optString("url");
        toastConfig.mShowDelay = toastObj.optInt("showDelay");
        toastConfig.mShowTime = toastObj.optInt(ConstantsKt.SHOW_TIME);
        if (TextUtils.isEmpty(toastConfig.message) || TextUtils.isEmpty(toastConfig.btnText) || TextUtils.isEmpty(toastConfig.url)) {
            return null;
        }
        return toastConfig;
    }
}
