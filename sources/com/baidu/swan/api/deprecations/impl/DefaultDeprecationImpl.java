package com.baidu.swan.api.deprecations.impl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Spanned;
import android.util.Pair;
import android.view.View;
import android.widget.ListView;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.api.deprecations.interfaces.ISwanAppDeprecation;
import okhttp3.Callback;
import okhttp3.Request;
import org.json.JSONObject;

public class DefaultDeprecationImpl implements ISwanAppDeprecation {
    public void callShareInBrowser(Activity context, String options, String successCallback, String errorCallback, boolean snapshot, boolean forceLightTheme, String source, ISwanAppDeprecation.BrowserShareCallback callback) {
    }

    public Activity getActivity() {
        return null;
    }

    public String getAppKey() {
        return null;
    }

    public void handleShowModal(Context context, JSONObject joParams, DialogInterface.OnClickListener negativeListener, DialogInterface.OnCancelListener cancelListener, DialogInterface.OnClickListener positiveListener) {
    }

    public void handleShowActionSheet(Context context, View container, ListView lv, UnitedSchemeEntity entity, CallbackHandler handler, DialogInterface.OnCancelListener cancelListener) {
    }

    public JSONObject getCachedLocation() {
        return new JSONObject();
    }

    public Pair<Integer, Integer> getCurScreenSize() {
        return new Pair<>(0, 0);
    }

    public Pair<Integer, Integer> getCurWindowSafeSize() {
        return new Pair<>(0, 0);
    }

    public String getIMEI() {
        return null;
    }

    public String getFileSuffix(String fileName) {
        return null;
    }

    public JSONObject buildSwanCrashMsg(String appId) {
        return null;
    }

    public void recordAppLaunchFailEvent(String detail, String url, String scheme) {
    }

    public void showDownloadApkDialog(Context activity, Spanned message, DialogInterface.OnClickListener positiveListener, DialogInterface.OnClickListener negativeListener) {
    }

    public void buildHttpClient(Request request, Callback callback) {
    }
}
