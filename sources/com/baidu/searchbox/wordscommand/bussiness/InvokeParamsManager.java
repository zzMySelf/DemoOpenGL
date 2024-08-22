package com.baidu.searchbox.wordscommand.bussiness;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.wordscommand.util.InvokeParamsSpUtil;

public class InvokeParamsManager {
    public static void saveInvokeSchemeToSp(String uri) {
        if (!TextUtils.isEmpty(uri)) {
            InvokeParamsSpUtil.getInstance().putString(InvokeParamsSpUtil.PARAM_INVOKE_SCHEME, uri);
            if (AppConfig.isDebug()) {
                Log.d("InvokeParamsManager", "SaveSchemeToSp: " + uri);
            }
        }
    }

    public static String getInvokeSchemeFromSp() {
        String scheme = InvokeParamsSpUtil.getInstance().getString(InvokeParamsSpUtil.PARAM_INVOKE_SCHEME, "");
        if (AppConfig.isDebug()) {
            Log.d("InvokeParamsManager", "GetInvokeScheme: " + scheme);
        }
        return scheme;
    }

    public static void release() {
        InvokeParamsSpUtil.getInstance().remove(InvokeParamsSpUtil.PARAM_INVOKE_SCHEME);
        if (AppConfig.isDebug()) {
            Log.d("InvokeParamsManager", "RemoveSchemeFromSp");
        }
    }
}
