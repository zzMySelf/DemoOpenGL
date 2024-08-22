package com.baidu.searchbox.browser;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.searchbox.browser.ioc.JsInterfaceRuntime;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.common.security.JsInterfaceChecker;
import com.baidu.searchbox.common.security.JsInterfaceLogger;
import com.baidu.searchbox.common.security.SchemeCheckerHelperImpl;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.ng.browser.BaseJsBridge;
import com.baidu.searchbox.ng.browser.NgWebView;
import java.util.List;

public class SendIntentJavaScriptInterface extends BaseJsBridge {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = (AppConfig.isDebug() & true);
    public static final String JAVASCRIPT_INTERFACE_NAME = "Bdbox_android_send_intent";
    private static final String TAG = "send_intent";
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public int mFrom = -1;
    /* access modifiers changed from: private */
    public Object mWebView;

    public SendIntentJavaScriptInterface(BdSailorWebView webView) {
        this.mWebView = webView;
        this.mContext = webView.getContext();
    }

    public SendIntentJavaScriptInterface(WebView webView) {
        this.mWebView = webView;
        this.mContext = webView.getContext();
    }

    public void setFrom(int from) {
        this.mFrom = from;
    }

    @JavascriptInterface
    public void send(String intentStr) {
        new JsInterfaceLogger(getLogContext()).setFun("send").setArgs(intentStr).log();
        String anyThreadUrl = "";
        Object obj = this.mWebView;
        if (obj instanceof NgWebView) {
            anyThreadUrl = ((NgWebView) obj).getAnyThreadUrl();
        }
        UiThreadUtil.runOnUiThread(new SendRunnable(intentStr, anyThreadUrl));
    }

    class SendRunnable implements Runnable {
        String mAnyThreadUrl = null;
        String mIntentStr = null;

        SendRunnable(String intent, String anyThreadUrl) {
            this.mIntentStr = intent;
            this.mAnyThreadUrl = anyThreadUrl;
        }

        public void run() {
            String url;
            if (SendIntentJavaScriptInterface.DEBUG) {
                Log.d(SendIntentJavaScriptInterface.TAG, "send() ===> " + this.mIntentStr);
            }
            if (SendIntentJavaScriptInterface.this.mWebView instanceof BdSailorWebView) {
                url = ((BdSailorWebView) SendIntentJavaScriptInterface.this.mWebView).getUrl();
            } else if (SendIntentJavaScriptInterface.this.mWebView instanceof WebView) {
                url = ((WebView) SendIntentJavaScriptInterface.this.mWebView).getUrl();
            } else {
                url = null;
            }
            if (url != null) {
                if ((url.equals(this.mAnyThreadUrl) || new JsInterfaceChecker(SendIntentJavaScriptInterface.this.getLogContext(), (String) null, this.mAnyThreadUrl).checkUrlInAnyThread()) && SchemeCheckerHelperImpl.getInstance().preCheckUrl(url) == 0) {
                    try {
                        PackageManager pm = SendIntentJavaScriptInterface.this.mContext.getPackageManager();
                        Intent msgIntent = Intent.parseUri(this.mIntentStr, 0);
                        if (!(!AppConfig.AppInfo.isModifyPkg() || msgIntent == null || msgIntent.getComponent() == null)) {
                            msgIntent.setComponent(new ComponentName(AppRuntime.getApplication().getPackageName(), msgIntent.getComponent().getClassName()));
                        }
                        if (msgIntent != null) {
                            msgIntent.putExtra(JsInterfaceRuntime.getMisc().getDownLoadKeyFrom(), SendIntentJavaScriptInterface.this.mFrom);
                        }
                        List<ResolveInfo> queryBroadcastReceivers = pm.queryBroadcastReceivers(msgIntent, 0);
                        List<ResolveInfo> infos = queryBroadcastReceivers;
                        if (queryBroadcastReceivers == null || infos.size() <= 0) {
                            List<ResolveInfo> queryIntentActivities = pm.queryIntentActivities(msgIntent, 0);
                            List<ResolveInfo> infos2 = queryIntentActivities;
                            if (queryIntentActivities == null || infos2.size() <= 0) {
                                List<ResolveInfo> queryIntentServices = pm.queryIntentServices(msgIntent, 0);
                                List<ResolveInfo> infos3 = queryIntentServices;
                                if (queryIntentServices == null || infos3.size() <= 0) {
                                    if (SendIntentJavaScriptInterface.DEBUG) {
                                        Log.d(SendIntentJavaScriptInterface.TAG, "No app can deal! ===> " + this.mIntentStr);
                                    }
                                    Intent urlIntent = new Intent("android.intent.action.VIEW");
                                    urlIntent.setData(Uri.parse(this.mIntentStr));
                                    urlIntent.addFlags(268435456);
                                    try {
                                        SendIntentJavaScriptInterface.this.mContext.startActivity(urlIntent);
                                    } catch (ActivityNotFoundException e2) {
                                        if (SendIntentJavaScriptInterface.DEBUG) {
                                            Log.e(SendIntentJavaScriptInterface.TAG, ">>> Uri cann't be deal ： " + this.mIntentStr);
                                        }
                                    }
                                } else {
                                    if (SendIntentJavaScriptInterface.DEBUG && msgIntent != null) {
                                        Log.d(SendIntentJavaScriptInterface.TAG, "Intent sent to service! ===> " + msgIntent.toURI());
                                    }
                                    SendIntentJavaScriptInterface sendIntentJavaScriptInterface = SendIntentJavaScriptInterface.this;
                                    sendIntentJavaScriptInterface.addPackageNameIfNeed(sendIntentJavaScriptInterface.mContext, msgIntent, infos3);
                                    SendIntentJavaScriptInterface.this.mContext.startService(msgIntent);
                                }
                            } else {
                                if (SendIntentJavaScriptInterface.DEBUG && msgIntent != null) {
                                    Log.d(SendIntentJavaScriptInterface.TAG, "Intent sent to actvity! ===> " + msgIntent.toURI());
                                }
                                SendIntentJavaScriptInterface sendIntentJavaScriptInterface2 = SendIntentJavaScriptInterface.this;
                                sendIntentJavaScriptInterface2.addPackageNameIfNeed(sendIntentJavaScriptInterface2.mContext, msgIntent, infos2);
                                if (msgIntent != null) {
                                    msgIntent.addFlags(268435456);
                                }
                                SendIntentJavaScriptInterface.this.mContext.startActivity(msgIntent);
                            }
                        } else {
                            if (SendIntentJavaScriptInterface.DEBUG && msgIntent != null) {
                                Log.d(SendIntentJavaScriptInterface.TAG, "Intent broadcasted to app! ===> " + msgIntent.toURI());
                            }
                            SendIntentJavaScriptInterface sendIntentJavaScriptInterface3 = SendIntentJavaScriptInterface.this;
                            sendIntentJavaScriptInterface3.addPackageNameIfNeed(sendIntentJavaScriptInterface3.mContext, msgIntent, infos);
                            if (msgIntent != null) {
                                msgIntent.putExtra(JsInterfaceRuntime.getMisc().getDownLoadKeyRandom(), JsInterfaceRuntime.getMisc().getDownLoadKeyRandomValue());
                            }
                            SendIntentJavaScriptInterface.this.mContext.sendBroadcast(msgIntent);
                        }
                    } catch (Exception e3) {
                        if (SendIntentJavaScriptInterface.DEBUG) {
                            Log.e(SendIntentJavaScriptInterface.TAG, "uri to intent fail \r\n" + e3.getMessage());
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void addPackageNameIfNeed(Context context, Intent msgIntent, List<ResolveInfo> infos) {
        String packageName = context.getPackageName();
        for (ResolveInfo info : infos) {
            if (DEBUG) {
                Log.d(TAG, "info.resolvePackageName=" + info.resolvePackageName + ", packageName=" + packageName);
            }
            if (info.activityInfo != null && TextUtils.equals(info.activityInfo.packageName, packageName)) {
                msgIntent.setPackage(packageName);
                return;
            } else if (info.serviceInfo != null && TextUtils.equals(info.serviceInfo.packageName, packageName)) {
                msgIntent.setPackage(packageName);
                return;
            }
        }
    }

    public void release() {
        super.release();
        this.mWebView = null;
        this.mContext = AppRuntime.getAppContext();
    }
}
