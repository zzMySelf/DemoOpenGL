package com.baidu.searchbox.plugins.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.megapp.util.MegUtils;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.aps.invoker.PluginJavascriptInterface;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.common.security.JsInterfaceChecker;
import com.baidu.searchbox.common.security.JsInterfaceLogger;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.plugins.PluginInvokeActivity;
import com.baidu.searchbox.plugins.SearchBoxInvokeHelper;
import com.baidu.searchbox.plugins.bridge.ApsBusinessRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SearchBoxPluginJavascriptInterface extends PluginJavascriptInterface implements NoProGuard, IPluginJavascriptInterface {
    private static final boolean DEBUG = (AppConfig.isDebug() & true);
    public static final String JS_NAME = "Bdbox_android_plugin";
    private static final String TAG = "PluginJSInterface";
    private Context mContext;
    private JsInterfaceLogger.LogContext mLogContext;
    private ProgressListener mProgressListener;
    /* access modifiers changed from: private */
    public ResultCallback mResultCallback;
    private IWindowListener mWindowListener;

    public SearchBoxPluginJavascriptInterface setReuseLogContext(JsInterfaceLogger.ReusableLogContext context) {
        this.mLogContext = new JsInterfaceLogger.FilterLogContext(context, "SearchBoxPluginJavascriptInterface");
        return this;
    }

    public SearchBoxPluginJavascriptInterface(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public void setResultCallback(ResultCallback callback) {
        this.mResultCallback = callback;
    }

    public void setProgressListener(ProgressListener listener) {
        this.mProgressListener = listener;
    }

    public void setWindowListener(IWindowListener listener) {
        this.mWindowListener = listener;
    }

    @JavascriptInterface
    public void getInstalledPluginVersion(final String options) {
        new JsInterfaceLogger(this.mLogContext).setFun("getInstalledPluginVersion").setArgs(options).log();
        if (new JsInterfaceChecker(this.mLogContext) {
            /* access modifiers changed from: protected */
            public boolean checkHost(String host) {
                return PluginInvokeWhiteListUtils.jsSecurityCheck(AppRuntime.getAppContext(), options, host);
            }

            /* access modifiers changed from: protected */
            public void onCheckPermissionFinished(int res) {
                if (res == 0) {
                    SearchBoxPluginJavascriptInterface.super.getInstalledPluginVersion(options, (String) null);
                }
            }
        }.apsJsCheck()) {
            super.getInstalledPluginVersion(options, (String) null);
        }
    }

    @JavascriptInterface
    public void getInstalledPluginVersion(final String options, final String callback) {
        new JsInterfaceLogger(this.mLogContext).setFun("getInstalledPluginVersion").addArg("options", options).addArg("callback", callback).log();
        if (new JsInterfaceChecker(this.mLogContext) {
            /* access modifiers changed from: protected */
            public boolean checkHost(String host) {
                return PluginInvokeWhiteListUtils.jsSecurityCheck(AppRuntime.getAppContext(), options, host);
            }

            /* access modifiers changed from: protected */
            public void onCheckPermissionFinished(int res) {
                if (res == 0) {
                    SearchBoxPluginJavascriptInterface.super.getInstalledPluginVersion(options, callback);
                } else if (res == 1) {
                    SearchBoxPluginJavascriptInterface.this.onResultInHost(callback, "-1");
                }
            }
        }.apsJsCheck()) {
            super.getInstalledPluginVersion(options, callback);
        }
    }

    @JavascriptInterface
    public void installPlugin(final String options) {
        new JsInterfaceLogger(this.mLogContext).setFun("installPlugin").setArgs(options).log();
        if (new JsInterfaceChecker(this.mLogContext) {
            /* access modifiers changed from: protected */
            public boolean checkHost(String host) {
                return PluginInvokeWhiteListUtils.jsSecurityCheck(AppRuntime.getAppContext(), options, host);
            }

            /* access modifiers changed from: protected */
            public void onCheckPermissionFinished(int res) {
                if (res == 0) {
                    SearchBoxPluginJavascriptInterface.super.installPlugin(options, (String) null);
                }
            }
        }.apsJsCheck()) {
            super.installPlugin(options, (String) null);
        }
    }

    @JavascriptInterface
    public void installPlugin(final String options, final String callback) {
        new JsInterfaceLogger(this.mLogContext).setFun("installPlugin").addArg("options", options).addArg("callback", callback);
        if (new JsInterfaceChecker(this.mLogContext) {
            /* access modifiers changed from: protected */
            public boolean checkHost(String host) {
                return PluginInvokeWhiteListUtils.jsSecurityCheck(AppRuntime.getAppContext(), options, host);
            }

            /* access modifiers changed from: protected */
            public void onCheckPermissionFinished(int res) {
                if (res == 0) {
                    SearchBoxPluginJavascriptInterface.super.installPlugin(options, callback);
                } else if (res == 1) {
                    SearchBoxPluginJavascriptInterface.this.onResultInHost(callback, "0");
                }
            }
        }.apsJsCheck()) {
            super.installPlugin(options, callback);
        }
    }

    @JavascriptInterface
    public void sendGMVLog(final String options) {
        new JsInterfaceLogger(this.mLogContext).setFun("sendGMVLog").setArgs(options).log();
        if (new JsInterfaceChecker(this.mLogContext) {
            /* access modifiers changed from: protected */
            public boolean checkHost(String host) {
                return PluginInvokeWhiteListUtils.jsSecurityCheck(AppRuntime.getAppContext(), options, host);
            }

            /* access modifiers changed from: protected */
            public void onCheckPermissionFinished(int res) {
                if (res == 0) {
                    SearchBoxPluginJavascriptInterface.this.handleSendGMVLog(options, (String) null);
                }
            }
        }.apsJsCheck()) {
            handleSendGMVLog(options, (String) null);
        }
    }

    @JavascriptInterface
    public void sendGMVLog(final String options, final String callback) {
        new JsInterfaceLogger(this.mLogContext).setFun("sendGMVLog").addArg("options", options).addArg("callback", callback).log();
        if (new JsInterfaceChecker(this.mLogContext) {
            /* access modifiers changed from: protected */
            public boolean checkHost(String host) {
                return PluginInvokeWhiteListUtils.jsSecurityCheck(AppRuntime.getAppContext(), options, host);
            }

            /* access modifiers changed from: protected */
            public void onCheckPermissionFinished(int res) {
                ResultCallback rc;
                if (res == 0) {
                    SearchBoxPluginJavascriptInterface.this.handleSendGMVLog(options, callback);
                } else if (res == 1 && (rc = SearchBoxPluginJavascriptInterface.this.mResultCallback) != null && !TextUtils.isEmpty(callback)) {
                    rc.onCallback(callback, "0");
                }
            }
        }.apsJsCheck()) {
            handleSendGMVLog(options, callback);
        }
    }

    /* access modifiers changed from: private */
    public void handleSendGMVLog(String options, String callback) {
        try {
            JSONObject jObject = new JSONObject(options);
            JSONArray jArray = jObject.names();
            Map<String, String> paramMap = new HashMap<>();
            for (int i2 = 0; i2 < jArray.length(); i2++) {
                String key = jArray.getString(i2);
                if (!TextUtils.isEmpty(key)) {
                    String value = jObject.getString(key);
                    if (TextUtils.isEmpty(value)) {
                        value = "";
                    }
                    paramMap.put(key, value);
                }
            }
            if (paramMap.size() > 0) {
                ApsBusinessRuntime.getApsBusinessInterface().sendGMVLog(paramMap);
                ResultCallback rc = this.mResultCallback;
                if (rc != null && !TextUtils.isEmpty(callback)) {
                    rc.onCallback(callback, "1");
                    return;
                }
                return;
            }
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
        ResultCallback rc2 = this.mResultCallback;
        if (rc2 != null && !TextUtils.isEmpty(callback)) {
            rc2.onCallback(callback, "0");
        }
    }

    @JavascriptInterface
    public void invokePlugin(final String options) {
        new JsInterfaceLogger(this.mLogContext).setFun("invokePlugin").setArgs(options).log();
        if (new JsInterfaceChecker(this.mLogContext) {
            /* access modifiers changed from: protected */
            public boolean checkHost(String host) {
                return PluginInvokeWhiteListUtils.jsSecurityCheck(AppRuntime.getAppContext(), options, host);
            }

            /* access modifiers changed from: protected */
            public void onCheckPermissionFinished(int res) {
                if (res == 0) {
                    SearchBoxPluginJavascriptInterface.super.invokePlugin(options, (String) null);
                }
            }
        }.apsJsCheck()) {
            super.invokePlugin(options, (String) null);
        }
    }

    @JavascriptInterface
    public void invokePlugin(final String options, final String callbackOpts) {
        new JsInterfaceLogger(this.mLogContext).setFun("invokePlugin").addArg("options", options).addArg("callbackOpts", callbackOpts).log();
        if (new JsInterfaceChecker(this.mLogContext) {
            /* access modifiers changed from: protected */
            public boolean checkHost(String host) {
                return PluginInvokeWhiteListUtils.jsSecurityCheck(AppRuntime.getAppContext(), options, host);
            }

            /* access modifiers changed from: protected */
            public void onCheckPermissionFinished(int res) {
                if (res == 0) {
                    SearchBoxPluginJavascriptInterface.super.invokePlugin(options, callbackOpts);
                } else if (res == 1) {
                    SearchBoxPluginJavascriptInterface.this.onResultInHost(callbackOpts, "-1");
                }
            }
        }.apsJsCheck()) {
            super.invokePlugin(options, callbackOpts);
        }
    }

    /* access modifiers changed from: protected */
    public void onProgressInHost(final String listener, final String param) {
        final ProgressListener pl = this.mProgressListener;
        if (pl != null && !TextUtils.isEmpty(listener)) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    pl.onExecute(listener, param);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void onResultInHost(final String callback, final String result) {
        final ResultCallback rc = this.mResultCallback;
        if (rc != null && !TextUtils.isEmpty(callback)) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    rc.onCallback(callback, result);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void parseInvokePluginOptionsInHost(String options, PluginJavascriptInterface.InvokeParams params) {
        if (!TextUtils.isEmpty(options)) {
            try {
                if (new JSONObject(options).optInt(PluginInvokeActivity.EXTRA_BY_USER, 1) != 0) {
                    params.flag = 286261248;
                } else {
                    params.flag = 0;
                }
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public Object[] parseInvokePluginOptionsInHost(String options) {
        if (MegUtils.isDebug()) {
            Log.e(" parseInvoke·Option", "parseInvokePluginOptionsInHost : " + options);
        }
        if (TextUtils.isEmpty(options)) {
            return null;
        }
        try {
            JSONObject jObject = new JSONObject(options);
            boolean useNewWindow = jObject.optInt(PluginInvokeActivity.EXTRA_USE_NEW_WINDOW, 1) != 0;
            boolean needBaiduParams = jObject.optInt("need_baidu_params", 1) != 0;
            String websiteUrl = jObject.optString("website_url", "");
            String appId = jObject.optString("app_id", "");
            int urlFrameCode = jObject.optInt(PluginInvokeActivity.EXTRA_URL_FRAME_CODE, 1);
            boolean appIsVip = jObject.optInt(PluginInvokeActivity.EXTRA_APP_IS_VIP, 0) == 1;
            String logUrl = jObject.optString(PluginInvokeActivity.EXTRA_LOG_URL, "");
            JSONArray logHeaderArray = jObject.optJSONArray(PluginInvokeActivity.EXTRA_LOG_HEADER);
            if (!TextUtils.isEmpty(logUrl)) {
                PluginStatistic.addTCStatistics(this.mContext, logUrl, logHeaderArray);
            }
            return SearchBoxInvokeHelper.createOptions(websiteUrl, appId, "web", appIsVip, useNewWindow, needBaiduParams, urlFrameCode, this.mWindowListener);
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    public void release() {
        this.mLogContext = null;
        this.mResultCallback = null;
        this.mProgressListener = null;
        this.mWindowListener = null;
    }
}
