package com.baidu.searchbox.download.business.util;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.binder.BinderOptUtils;
import com.baidu.searchbox.config.AppConfig;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class DownloadUtils {
    public static final String DOWNLOAD_END_TOAST = "download_end_toast";
    public static final String DOWNLOAD_END_TOAST_HIDE = "1";
    private static final String TAG = "DownloadUtils";

    public static ContentValues buildDownloadEndToastHide(ContentValues values) {
        if (values == null) {
            return null;
        }
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(DOWNLOAD_END_TOAST, "1");
        } catch (JSONException e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
        }
        values.put("extra_info", jsonObject.toString());
        return values;
    }

    public static void safeRegisterReceiver(Context context, BroadcastReceiver receiver, IntentFilter filter) {
        if (context != null && receiver != null && filter != null) {
            try {
                BinderOptUtils.registerReceiverOpt(context, receiver, filter);
            } catch (Exception e2) {
                if (AppConfig.isDebug()) {
                    Log.e(TAG, "registerDownloadReceiver failed. " + e2.getMessage());
                }
            }
        }
    }

    public static void safeUnRegisterReceiver(Context context, BroadcastReceiver receiver) {
        if (context != null && receiver != null) {
            try {
                BinderOptUtils.unregisterReceiverOpt(context, receiver);
            } catch (Exception e2) {
                if (AppConfig.isDebug()) {
                    Log.e(TAG, "registerDownloadReceiver failed. " + e2);
                }
            }
        }
    }

    public static long getFileSize(String path) {
        if (TextUtils.isEmpty(path)) {
            return 0;
        }
        File file = new File(path);
        if (file.exists()) {
            return file.length();
        }
        return 0;
    }
}
