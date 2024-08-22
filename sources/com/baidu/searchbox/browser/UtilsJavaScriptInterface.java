package com.baidu.searchbox.browser;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.android.WrappedClipboardManager;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.android.util.sp.SharedPreferencesUtil;
import com.baidu.browser.BrowserType;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.abtest.AbTestManager;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.browser.ForwardToServer;
import com.baidu.searchbox.browser.ioc.JsInterfaceRuntime;
import com.baidu.searchbox.browser.utils.CommonJsInterfaceUtils;
import com.baidu.searchbox.command.CommandEntity;
import com.baidu.searchbox.command.CommandUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.common.security.JsInterfaceChecker;
import com.baidu.searchbox.common.security.JsInterfaceLogger;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.config.FontSizeConfig;
import com.baidu.searchbox.drag.LaunchDragUBCManager;
import com.baidu.searchbox.fileviewer.activity.FileViewerActivity;
import com.baidu.searchbox.gamecore.ubc.GameUBCConst;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.launch.ExternalTransferSpeedStats;
import com.baidu.searchbox.lightbrowser.base.R;
import com.baidu.searchbox.lightbrowser.jsbridge.JsCallInfoChecker;
import com.baidu.searchbox.lightbrowser.listener.CloseWindowListener;
import com.baidu.searchbox.lightbrowser.listener.IPageBackCallback;
import com.baidu.searchbox.lightbrowser.listener.IPageInfoCallBack;
import com.baidu.searchbox.lightbrowser.listener.IToolbarCallback;
import com.baidu.searchbox.lightbrowser.listener.IUrlShare;
import com.baidu.searchbox.lightbrowser.statistic.PerformanceFlowUtil;
import com.baidu.searchbox.lightbrowserbeeinterface.LightBrowserBeeInterface;
import com.baidu.searchbox.ng.browser.BaseJsBridge;
import com.baidu.searchbox.ng.browser.NgWebView;
import com.baidu.searchbox.ng.browser.util.NgWebViewUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.swan.api.SwanAppConstants;
import com.baidu.swan.game.ad.jsbridge.BaseHtmlBridgeHandler;
import com.baidu.talos.core.container.InitProps;
import com.baidu.ubc.UBC;
import com.baidu.webkit.sdk.jschecker.BdJsCallInfo;
import java.util.ArrayList;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UtilsJavaScriptInterface extends BaseJsBridge {
    private static final int CAMERA_GRANTED_FAIL = 2;
    private static final int CAMERA_GRANTED_SUCCESS = 3;
    private static final int CAMERA_PERMISSION_DENIED = 0;
    private static final int CAMERA_PERMISSION_GRANTED = 3;
    /* access modifiers changed from: private */
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String EVENT_BROADCAST_FIRE_JS_NAME = "_Box_.event.broadcast.fire";
    public static final String FALSE_VALUE = "0";
    public static final String JAVASCRIPT_INTERFACE_NAME = "Bdbox_android_utils";
    public static final String JAVASCRIPT_INTERFACE_NAME_WEB = "Bdbox.android.utils";
    public static final int REQUEST_CAMERA_PERMISSION_CODE = 101;
    private static final String TAG = "UtilsJS";
    public static final String TRUE_VALUE = "1";
    private static final long UBC_MIN_VERSION = 16789504;
    public static final String WEB_STORAGE_FILE = "feed_web_data";
    /* access modifiers changed from: private */
    public ICurrPageUrlCallback currPageUrlCallback;
    /* access modifiers changed from: private */
    public Context mActivity;
    private IBeeBdWindowCallback mBdWindow;
    private BrowserType mBrowserType;
    /* access modifiers changed from: private */
    public CloseWindowListener mCloseWindowListener;
    /* access modifiers changed from: private */
    public Context mContext;
    private boolean mIsForceLight;
    IPageBackCallback mPageBackCallback;
    private IPageInfoCallBack mPageInfoCallBack;
    /* access modifiers changed from: private */
    public String mPermissionCallback;
    private IUrlShare mShare;
    private String mSource;
    IToolbarCallback mToolbarCallback;
    /* access modifiers changed from: private */
    public BdSailorWebView mWebView;

    public interface ICurrPageUrlCallback {
        void onCurrPageUrl(String str);
    }

    public interface ILockScreenSearchResultCallback {
        void handle(String str, String str2);
    }

    public interface IPageShareDataCallback {
        void urlCollection(String str);
    }

    public interface OnShareResultListener {
        void notify(String str, String str2);

        void onSharePanelCancel();
    }

    public UtilsJavaScriptInterface(Context context, BdSailorWebView webView) {
        this(context, webView, (ICurrPageUrlCallback) null, (IUrlShare) null);
    }

    public UtilsJavaScriptInterface(Context context, BdSailorWebView webView, IUrlShare share) {
        this(context, webView, (ICurrPageUrlCallback) null, share);
    }

    public UtilsJavaScriptInterface(Context context, BdSailorWebView webView, ICurrPageUrlCallback callback, IUrlShare share) {
        this.mBdWindow = null;
        this.mBrowserType = BrowserType.MAIN;
        this.mIsForceLight = false;
        this.mSource = "";
        this.mPermissionCallback = null;
        this.mActivity = context;
        this.mContext = context.getApplicationContext();
        this.mWebView = webView;
        this.currPageUrlCallback = callback;
        this.mShare = share;
    }

    public UtilsJavaScriptInterface(Context context, BdSailorWebView webView, IBeeBdWindowCallback bdWindow, ICurrPageUrlCallback callback, IUrlShare share) {
        this.mBdWindow = null;
        this.mBrowserType = BrowserType.MAIN;
        this.mIsForceLight = false;
        this.mSource = "";
        this.mPermissionCallback = null;
        this.mActivity = context;
        this.mContext = context.getApplicationContext();
        this.mWebView = webView;
        this.currPageUrlCallback = callback;
        this.mBdWindow = bdWindow;
        this.mShare = share;
    }

    public static UtilsJavaScriptInterface addUtilsJavaScriptInterface(Context context, IBeeBdWindowCallback window, BdSailorWebView webView, JsInterfaceLogger.ReusableLogContext logContext, CloseWindowListener listener) {
        UtilsJavaScriptInterface utilJs = new UtilsJavaScriptInterface(context, webView, window, (ICurrPageUrlCallback) null, (IUrlShare) null);
        utilJs.setReuseLogContext(logContext);
        utilJs.setCloseWindowListener(listener);
        utilJs.setSource(JsInterfaceRuntime.getShare().getShareSourceBrowser());
        webView.addJavascriptInterface(utilJs, "Bdbox_android_utils");
        return utilJs;
    }

    public void setActivity(Activity activity) {
        this.mActivity = activity;
    }

    public void setCurrPageUrlCallback(ICurrPageUrlCallback callback) {
        this.currPageUrlCallback = callback;
    }

    public void setToolbarCallback(IToolbarCallback callback) {
        this.mToolbarCallback = callback;
    }

    public void setPageReportCallback(IPageBackCallback callback) {
        this.mPageBackCallback = callback;
    }

    public void setPageInfoCallBack(IPageInfoCallBack pageInfoCallBack) {
        this.mPageInfoCallBack = pageInfoCallBack;
    }

    public void release() {
        super.release();
        this.mBdWindow = null;
        this.mCloseWindowListener = null;
        this.mActivity = null;
        this.mPageBackCallback = null;
        this.mPageInfoCallBack = null;
        this.mToolbarCallback = null;
        this.mShare = null;
    }

    public void setIUrlShare(IUrlShare share) {
        this.mShare = share;
    }

    public void setForceShareLight(boolean isLight) {
        this.mIsForceLight = isLight;
    }

    public void setSource(String source) {
        this.mSource = source;
    }

    @JavascriptInterface
    public String paramsRender(String options) {
        return "";
    }

    @JavascriptInterface
    public String getNetInfo() {
        return "";
    }

    public BdSailorWebView getWebView() {
        return this.mWebView;
    }

    public Context getContext() {
        return this.mContext;
    }

    @JavascriptInterface
    public void toast(final String str) {
        new JsInterfaceLogger(getLogContext()).setFun("toast").setArgs(str).log();
        if (!TextUtils.isEmpty(str) && this.mContext != null) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    if (UtilsJavaScriptInterface.this.mWebView == null) {
                        return;
                    }
                    if (JSUtils.isBaiduDomain(UtilsJavaScriptInterface.this.mWebView) || JSUtils.isBaiduLocalDomain(UtilsJavaScriptInterface.this.mWebView.getUrl())) {
                        UniversalToast.makeText(NgWebViewUtils.getSafeContext(UtilsJavaScriptInterface.this.mWebView), (CharSequence) str).showToast();
                    }
                }
            });
        }
    }

    @JavascriptInterface
    public void callNativeShare() {
        new JsInterfaceLogger(getLogContext()).setFun("callNativeShare").log();
        boolean z = DEBUG;
        if (z) {
            Log.d(TAG, "callNativeShare");
        }
        IUrlShare iUrlShare = this.mShare;
        if (iUrlShare != null) {
            iUrlShare.urlShare();
            if (z) {
                Log.d(TAG, "callNativeShare execute success");
            }
        } else if (z) {
            Log.d(TAG, "mShare == null, need check IUrlShare inject");
        }
    }

    @JavascriptInterface
    public void setToolBarIcons(String params) {
        new JsInterfaceLogger(getLogContext()).setFun("setToolBarIcons").log();
        IToolbarCallback iToolbarCallback = this.mToolbarCallback;
        if (iToolbarCallback != null) {
            iToolbarCallback.onToolBarIcons(params);
        }
    }

    @JavascriptInterface
    public void getToolBarIcons(String callBack) {
        new JsInterfaceLogger(getLogContext()).setFun("getToolBarIcons").addArg("callBack", callBack).log();
        IToolbarCallback iToolbarCallback = this.mToolbarCallback;
        if (iToolbarCallback != null) {
            notifyCallback(callBack, iToolbarCallback.getToolBarIcons());
        }
    }

    @JavascriptInterface
    public void updateCollectionStatus(String options) {
        new JsInterfaceLogger(getLogContext()).setFun("updateCollectionStatus").setArgs(options).log();
        IPageInfoCallBack iPageInfoCallBack = this.mPageInfoCallBack;
        if (iPageInfoCallBack != null) {
            iPageInfoCallBack.onPageOptionInfo(options);
        }
    }

    @JavascriptInterface
    public void currPageUrl(final String url) {
        new JsInterfaceLogger(getLogContext()).setFun("currPageUrl").setArgs(url).log();
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (UtilsJavaScriptInterface.this.currPageUrlCallback != null && JSUtils.isBaiduDomain(UtilsJavaScriptInterface.this.mWebView)) {
                    UtilsJavaScriptInterface.this.currPageUrlCallback.onCurrPageUrl(url);
                }
            }
        });
    }

    @JavascriptInterface
    public boolean command(final String command) {
        String anyThreadUrl;
        new JsInterfaceLogger(getLogContext()).setFun("command").setArgs(command).log();
        final Context context = NgWebViewUtils.getSafeContext(this.mWebView);
        if (!(context instanceof Activity)) {
            return false;
        }
        final Intent intent = CommandUtils.parseCommand(context, command, 1);
        if (!CommonJsInterfaceUtils.isIntentAvailable(context, intent)) {
            return false;
        }
        BdSailorWebView bdSailorWebView = this.mWebView;
        if (bdSailorWebView instanceof NgWebView) {
            anyThreadUrl = ((NgWebView) bdSailorWebView).getAnyThreadUrl();
        } else {
            anyThreadUrl = null;
        }
        final Context context2 = context;
        final String str = command;
        final Intent intent2 = intent;
        if (new JsInterfaceChecker(getLogContext(), (String) null, anyThreadUrl) {
            /* access modifiers changed from: protected */
            public void onCheckPermissionFinished(int res) {
                if (res == 0) {
                    UtilsJavaScriptInterface.this.changeAnimFromIntent();
                    UiThreadUtil.runOnUiThread(new Runnable() {
                        public void run() {
                            LightBrowserBeeInterface lightBrowserBeeInterface;
                            if (!UtilsJavaScriptInterface.this.handleWebAppsCommandInvoke(context2, str) && (lightBrowserBeeInterface = (LightBrowserBeeInterface) ServiceManager.getService(LightBrowserBeeInterface.SERVICE_REFERENCE)) != null && !lightBrowserBeeInterface.handlejsCommand(context2, intent2)) {
                                CommandUtils.invokeCommand((Context) (Activity) context2, new CommandEntity(str, intent2));
                            }
                        }
                    });
                }
            }
        }.check()) {
            changeAnimFromIntent();
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    if (!UtilsJavaScriptInterface.this.handleWebAppsCommandInvoke(context, command)) {
                        CommandUtils.invokeCommand((Context) (Activity) context, new CommandEntity(command, intent));
                    }
                }
            });
        }
        return true;
    }

    @JavascriptInterface
    public boolean command(BdJsCallInfo jsCallInfo, final String command) {
        new JsInterfaceLogger(getLogContext()).setFun("command").setArgs(command).log();
        if (!JsCallInfoChecker.check(jsCallInfo, (String) null)) {
            return false;
        }
        final Context context = NgWebViewUtils.getSafeContext(this.mWebView);
        if (!(context instanceof Activity)) {
            return false;
        }
        final Intent intent = CommandUtils.parseCommand(context, command, 1);
        if (!CommonJsInterfaceUtils.isIntentAvailable(context, intent)) {
            return false;
        }
        changeAnimFromIntent();
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (!UtilsJavaScriptInterface.this.handleWebAppsCommandInvoke(context, command)) {
                    CommandUtils.invokeCommand((Context) (Activity) context, new CommandEntity(command, intent));
                }
            }
        });
        return true;
    }

    /* access modifiers changed from: private */
    public boolean handleWebAppsCommandInvoke(Context context, String command) {
        return JsInterfaceRuntime.getMisc().handleWebAppsCommandInvoke(context, command);
    }

    @JavascriptInterface
    public void location(String options, String callback) {
        new JsInterfaceLogger(getLogContext()).setFun("location").addArg("options", options).addArg("callback", callback).log();
        if (DEBUG) {
            Log.d(TAG, "location permission");
        }
        String anyThreadUrl = null;
        BdSailorWebView bdSailorWebView = this.mWebView;
        if (bdSailorWebView instanceof NgWebView) {
            anyThreadUrl = ((NgWebView) bdSailorWebView).getAnyThreadUrl();
        }
        final String str = options;
        final String str2 = callback;
        boolean check = new JsInterfaceChecker(getLogContext(), (String) null, anyThreadUrl) {
            /* access modifiers changed from: protected */
            public void onCheckPermissionFinished(int res) {
                if (res == 0) {
                    JsInterfaceRuntime.getMisc().getCurrentLocation(UtilsJavaScriptInterface.this.mWebView, UtilsJavaScriptInterface.this.mActivity, str, str2);
                }
            }
        }.check();
    }

    @JavascriptInterface
    public void feedback(String options) {
        new JsInterfaceLogger(getLogContext()).setFun("feedback").setArgs(options).log();
        JsInterfaceRuntime.getMisc().feedback(this.mActivity, this.mWebView, options);
    }

    @JavascriptInterface
    public void closeWindow() {
        new JsInterfaceLogger(getLogContext()).setFun(GameUBCConst.VALUE_NEW_CENTER_CLOSE).log();
        if (DEBUG) {
            Log.i(TAG, "invoke closeWindow");
        }
        if (this.mCloseWindowListener != null) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    if (UtilsJavaScriptInterface.this.mCloseWindowListener != null) {
                        UtilsJavaScriptInterface.this.mCloseWindowListener.doCloseWindow();
                    }
                }
            });
        }
    }

    public void setCloseWindowListener(CloseWindowListener listener) {
        this.mCloseWindowListener = listener;
    }

    public void setBrowserType(BrowserType browserType) {
        this.mBrowserType = browserType;
    }

    @JavascriptInterface
    public void callShare(String options, String successCallback, String errorCallback) {
        new JsInterfaceLogger(getLogContext()).setFun("callShare").addArg("options", options).addArg(SwanAppConstants.Deprecation.SUCCESS_CALLBACK, successCallback).addArg(SwanAppConstants.Deprecation.ERROR_CALLBACK, errorCallback).log();
        callShare(options, successCallback, true, errorCallback);
    }

    @JavascriptInterface
    public void callShare(String options, String successCallback, boolean snapshot, String errorCallback) {
        new JsInterfaceLogger(getLogContext()).setFun("callShare").addArg("options", options).addArg("snapshot", String.valueOf(snapshot)).addArg(SwanAppConstants.Deprecation.SUCCESS_CALLBACK, successCallback).addArg(SwanAppConstants.Deprecation.ERROR_CALLBACK, errorCallback).log();
        if (this.mIsForceLight) {
            callShare(options, successCallback, snapshot, true, errorCallback);
        } else {
            callShare(options, successCallback, snapshot, false, errorCallback);
        }
    }

    @JavascriptInterface
    public void callShare(String options) {
        if (DEBUG) {
            Log.i(TAG, "callShare");
        }
        new JsInterfaceLogger(getLogContext()).setFun("callShare").addArg("options", options).log();
        if (!TextUtils.isEmpty(options)) {
            JsInterfaceRuntime.getShare().callShare(this.mContext, options);
        }
    }

    @JavascriptInterface
    public void callShare(String options, String successCallback, boolean snapshot, boolean forceLightTheme, String errorCallback) {
        new JsInterfaceLogger(getLogContext()).setFun("callShare").addArg("options", options).addArg("snapshot", String.valueOf(snapshot)).addArg("forceLightTheme", String.valueOf(forceLightTheme)).addArg(SwanAppConstants.Deprecation.SUCCESS_CALLBACK, successCallback).addArg(SwanAppConstants.Deprecation.ERROR_CALLBACK, errorCallback).log();
        if (ProcessUtils.isMainProcess()) {
            IBeeBdWindowCallback iBeeBdWindowCallback = this.mBdWindow;
            if (iBeeBdWindowCallback != null && iBeeBdWindowCallback.isCommentToolbar()) {
                this.mSource = "searchhudongH5";
            }
            realCallShare(this.mActivity, this.mContext, this.mSource, this.mBrowserType, options, successCallback, snapshot, forceLightTheme, errorCallback, new OnShareResultListener() {
                public void notify(String callBack, String info) {
                    UtilsJavaScriptInterface.this.notifyCallback(callBack, info);
                }

                public void onSharePanelCancel() {
                }
            });
            return;
        }
        CommonJsInterfaceUtils.swanCallShare(this.mActivity, options, successCallback, errorCallback, snapshot, forceLightTheme, this.mSource, this);
    }

    @JavascriptInterface
    public static void realCallShare(Context activity, Context context, String source, BrowserType browserType, String options, String successCallback, boolean snapshot, boolean forceLightTheme, String errorCallback, OnShareResultListener listener) {
        if (DEBUG) {
            Log.i(TAG, "callShare");
        }
        if (context != null) {
            JsInterfaceRuntime.getShare().realCallShare(activity, context, source, browserType, options, successCallback, errorCallback, listener);
        }
    }

    @JavascriptInterface
    public void callCopyLink(String options, String successCallback, String errorCallback) {
        if (AppConfig.isDebug()) {
            Log.d(TAG, "copyLinkFromJs");
        }
        new JsInterfaceLogger(getLogContext()).setFun("callCopyLink").addArg("options", options).addArg(SwanAppConstants.Deprecation.SUCCESS_CALLBACK, successCallback).addArg(SwanAppConstants.Deprecation.ERROR_CALLBACK, errorCallback).log();
        if (!TextUtils.isEmpty(options)) {
            JsInterfaceRuntime.getShare().callCopyLink(this.mActivity, this.mWebView, this.mSource, options, errorCallback, this);
        }
    }

    @JavascriptInterface
    public void callNativeCopyLink() {
        if (AppConfig.isDebug()) {
            Log.d(TAG, "NativeCopyLink");
        }
        new JsInterfaceLogger(getLogContext()).setFun("callNativeCopyLink").log();
        JsInterfaceRuntime.getShare().callNativeCopyLink(this.mActivity, this.mWebView, this.mSource, this);
    }

    @JavascriptInterface
    public void wallpaper(String options, String callback) {
        new JsInterfaceLogger(getLogContext()).setFun("wallpaper").addArg("options", options).addArg("callback", callback).log();
        boolean z = DEBUG;
        if (z) {
            Log.d(TAG, "UtilsJavaScriptInterface#wallpaper, options = " + options);
        }
        if (!TextUtils.isEmpty(options) && this.mActivity != null) {
            try {
                JSONObject json = new JSONObject(options);
                final String url = json.optString("url");
                final String referer = json.optString("referer");
                final String source = json.optString("source");
                if (!TextUtils.isEmpty(url)) {
                    UiThreadUtil.runOnUiThread(new Runnable() {
                        public void run() {
                            if (UtilsJavaScriptInterface.this.mActivity != null) {
                                JsInterfaceRuntime.getFeed().launchWallpaperActivity(UtilsJavaScriptInterface.this.mActivity, url, referer, source, false);
                            }
                        }
                    });
                } else if (z) {
                    Log.d(TAG, "UtilsJavaScriptInterface#wallpaper, url = " + url);
                    UniversalToast.makeText(this.mActivity.getApplicationContext(), (CharSequence) "The image url is empty").showToast();
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void showCopyLinKDialog(String linkUrl) {
        WrappedClipboardManager.newInstance(this.mWebView.getContext()).setText(linkUrl);
        boolean isNightMode = NgWebViewUtils.isNightMode(this.mWebView.getContext());
        Context context = this.mWebView.getContext();
        if (!DeviceUtils.OSInfo.hasTiramisu() || !DeviceUtils.isSupportPreviewWhenClipCopy()) {
            UniversalToast.makeText(context, R.string.copy_dialog_title).showHighlightToast();
        }
    }

    @JavascriptInterface
    public void image(final String options, final String callback) {
        new JsInterfaceLogger(getLogContext()).setFun("image").addArg("options", options).addArg("callback", callback).log();
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (UtilsJavaScriptInterface.this.mActivity != null) {
                    boolean isSuccess = JsInterfaceRuntime.getFeed().launchPictureBrowser(UtilsJavaScriptInterface.this.mActivity, options);
                    if (!TextUtils.isEmpty(callback)) {
                        UtilsJavaScriptInterface.this.notifyCallback(callback, isSuccess ? "0" : "1");
                    }
                }
            }
        });
    }

    @JavascriptInterface
    public void lightImage(final String options, final String callback) {
        new JsInterfaceLogger(getLogContext()).setFun("lightImage").addArg("options", options).addArg("callback", callback).log();
        DefaultSharedPrefsWrapper.getInstance().putBoolean(JsInterfaceRuntime.getFeed().getKeyPictureAnimaState(), false);
        if (DEBUG) {
            Log.d(TAG, "options=" + options);
        }
        JsInterfaceRuntime.getFeed().pictureResetFlow();
        JsInterfaceRuntime.getFeed().pictureInstanceFlow(JsInterfaceRuntime.getFeed().getPictureInvalidContextId());
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (UtilsJavaScriptInterface.this.mActivity != null) {
                    boolean isSuccess = CommonJsInterfaceUtils.launchLightPictureBrowser(UtilsJavaScriptInterface.this.mActivity, options);
                    if (!TextUtils.isEmpty(callback)) {
                        UtilsJavaScriptInterface.this.notifyCallback(callback, isSuccess ? "0" : "1");
                    }
                }
            }
        });
    }

    @JavascriptInterface
    public void changePage(String options, String callback) {
        new JsInterfaceLogger(getLogContext()).setFun("changePage").addArg("options", options).addArg("callback", callback).log();
        if (CommonJsInterfaceUtils.isLightBrowserSubtitle()) {
            try {
                JSONObject json = new JSONObject(options);
                if (json.has("subtitle")) {
                    BdEventBus.Companion.getDefault().post(json.getString("subtitle"));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    @JavascriptInterface
    public void useHttps(String options) {
        new JsInterfaceLogger(getLogContext()).setFun("useHttps").setArgs(options).log();
        if (DEBUG) {
            Log.d(TAG, "UtilsJavaScriptInterface#useHttps, options = " + options);
        }
        if (!TextUtils.isEmpty(options)) {
            try {
                final boolean use = new JSONObject(options).getBoolean("use");
                UiThreadUtil.getMainHandler().post(new Runnable() {
                    public void run() {
                        JsInterfaceRuntime.getSearchBox().setUseHttps(use);
                    }
                });
            } catch (JSONException e2) {
                if (DEBUG) {
                    Log.e(TAG, "useHttps", e2);
                }
            }
        }
    }

    private ArrayList<String> getStringListFromJSONArray(JSONArray jsonArray) throws JSONException {
        if (jsonArray == null) {
            return null;
        }
        ArrayList<String> lRet = new ArrayList<>();
        int size = jsonArray.length();
        for (int i2 = 0; i2 < size; i2++) {
            lRet.add(jsonArray.getString(i2));
        }
        return lRet;
    }

    public void notifyCallback(String callBack, String info) {
        loadJavaScript(BaseHtmlBridgeHandler.JAVASCRIPT_PREFIX + callBack + FileViewerActivity.LEFT_BRACKET + info + ");");
    }

    /* access modifiers changed from: protected */
    public void loadJavaScript(final String js) {
        BdSailorWebView bdSailorWebView = this.mWebView;
        if (bdSailorWebView != null && !bdSailorWebView.isDestroyed() && !TextUtils.isEmpty(js)) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    String jsEx = js;
                    if (!jsEx.startsWith(BaseHtmlBridgeHandler.JAVASCRIPT_PREFIX)) {
                        jsEx = BaseHtmlBridgeHandler.JAVASCRIPT_PREFIX + jsEx;
                    }
                    if (UtilsJavaScriptInterface.DEBUG) {
                        Log.d(UtilsJavaScriptInterface.TAG, "share result:" + jsEx);
                    }
                    if (DeviceUtils.OSInfo.hasKitKat() || BdZeusUtil.isWebkitLoaded()) {
                        UtilsJavaScriptInterface.this.mWebView.evaluateJavascript(jsEx, (ValueCallback<String>) null);
                    } else {
                        UtilsJavaScriptInterface.this.mWebView.loadUrl(jsEx);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void changeAnimFromIntent() {
        BaseActivity.setNextPendingTransition(com.baidu.android.common.ui.style.R.anim.slide_in_from_right, com.baidu.android.common.ui.style.R.anim.slide_out_to_left, 0, 0);
    }

    @JavascriptInterface
    public void subscribePa(String paramJson, String onCallBack) {
        new JsInterfaceLogger(getLogContext()).setFun("subscribePa").addArg("paramJson", paramJson).addArg("onCallBack", onCallBack).log();
        long paId = 0;
        JsCallback callBack = new JsCallback(onCallBack, onCallBack);
        try {
            paId = new JSONObject(paramJson).getLong("paId");
        } catch (JSONException e2) {
            if (DEBUG) {
                Log.e(TAG, "subscribePa jsonException paramJson:" + paramJson);
            }
            callBack.setResult(false);
            callBack.notifyResult();
        }
        JSONObject resultJson = new JSONObject();
        try {
            resultJson.put("paId", paId);
            callBack.addField("other_param", resultJson);
        } catch (JSONException e3) {
            if (DEBUG) {
                Log.e(TAG, "resultJson exception:" + e3);
            }
        }
        JsInterfaceRuntime.getMisc().subscribePa(resultJson, callBack, paId, AppRuntime.getAppContext());
    }

    @JavascriptInterface
    public String getcuid() {
        new JsInterfaceLogger(getLogContext()).setFun("getcuid").log();
        String anyThreadUrl = null;
        BdSailorWebView bdSailorWebView = this.mWebView;
        if (bdSailorWebView instanceof NgWebView) {
            anyThreadUrl = ((NgWebView) bdSailorWebView).getAnyThreadUrl();
        }
        if (new JsInterfaceChecker(getLogContext(), (String) null, anyThreadUrl).checkUrlInAnyThread()) {
            return BaiduIdentityManager.getInstance(AppRuntime.getAppContext()).getUid();
        }
        return "";
    }

    @JavascriptInterface
    public void checkCameraPermission(final String callback) {
        new JsInterfaceLogger(getLogContext()).setFun("checkCameraPermission").addArg("callback", callback).log();
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                int hasPermission;
                if (UtilsJavaScriptInterface.this.mWebView == null) {
                    return;
                }
                if (JSUtils.isBaiduDomain(UtilsJavaScriptInterface.this.mWebView) || JSUtils.isBaiduLocalDomain(UtilsJavaScriptInterface.this.mWebView.getUrl())) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        hasPermission = UtilsJavaScriptInterface.this.mActivity.checkSelfPermission("android.permission.CAMERA");
                    } else {
                        hasPermission = 0;
                    }
                    if (UtilsJavaScriptInterface.DEBUG) {
                        Log.d(UtilsJavaScriptInterface.TAG, "checkCameraPermission hasPermission=" + hasPermission);
                    }
                    int result = hasPermission == 0 ? 3 : 0;
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("status", result);
                    } catch (JSONException e2) {
                        if (UtilsJavaScriptInterface.DEBUG) {
                            e2.printStackTrace();
                        }
                    }
                    UtilsJavaScriptInterface.this.postLoadJavaScript(callback, "'" + jsonObject.toString() + "'");
                }
            }
        });
    }

    @JavascriptInterface
    public void requestCameraPermission(final String callback) {
        new JsInterfaceLogger(getLogContext()).setFun("requestCameraPermission").addArg("callback", callback).log();
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (UtilsJavaScriptInterface.this.mWebView == null) {
                    return;
                }
                if (JSUtils.isBaiduDomain(UtilsJavaScriptInterface.this.mWebView) || JSUtils.isBaiduLocalDomain(UtilsJavaScriptInterface.this.mWebView.getUrl())) {
                    if (UtilsJavaScriptInterface.this.mActivity != null && (UtilsJavaScriptInterface.this.mActivity instanceof Activity)) {
                        Activity activity = (Activity) UtilsJavaScriptInterface.this.mActivity;
                        String[] cameraPermission = {"android.permission.CAMERA"};
                        if (DeviceUtil.OSInfo.hasMarshMallow()) {
                            if (activity.checkSelfPermission("android.permission.CAMERA") != 0) {
                                activity.requestPermissions(cameraPermission, 101);
                                String unused = UtilsJavaScriptInterface.this.mPermissionCallback = callback;
                                return;
                            } else if (UtilsJavaScriptInterface.DEBUG) {
                                CommonJsInterfaceUtils.showToast(activity, "has camera permission, do not request again");
                            }
                        }
                    }
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("status", 2);
                    } catch (JSONException e2) {
                        if (UtilsJavaScriptInterface.DEBUG) {
                            e2.printStackTrace();
                        }
                    }
                    UtilsJavaScriptInterface.this.postLoadJavaScript(callback, "'" + jsonObject.toString() + "'");
                }
            }
        });
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 101) {
            boolean hasGranted = false;
            if (grantResults != null && grantResults.length > 0 && grantResults[0] == 0) {
                hasGranted = true;
            }
            if (DEBUG) {
                Log.d(TAG, "onRequestPermissionsResult hasGranted=" + hasGranted);
            }
            if (!TextUtils.isEmpty(this.mPermissionCallback)) {
                int result = hasGranted ? 3 : 2;
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("status", result);
                } catch (JSONException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
                postLoadJavaScript(this.mPermissionCallback, "'" + jsonObject.toString() + "'");
            }
        }
    }

    @JavascriptInterface
    public void webStorage(final String params, final String callBack) {
        new JsInterfaceLogger(getLogContext()).setFun("webStorage").addArg("params", params).addArg("callBack", callBack).log();
        if (!TextUtils.isEmpty(params) && !TextUtils.isEmpty(callBack)) {
            BdSailorWebView bdSailorWebView = this.mWebView;
            final String anyThreadUrl = bdSailorWebView instanceof NgWebView ? ((NgWebView) bdSailorWebView).getAnyThreadUrl() : "";
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    if (UtilsJavaScriptInterface.this.mWebView != null && UtilsJavaScriptInterface.this.mWebView.getUrl() != null && !UtilsJavaScriptInterface.this.mWebView.getUrl().equals(anyThreadUrl) && !new JsInterfaceChecker(UtilsJavaScriptInterface.this.getLogContext(), (String) null, anyThreadUrl).checkUrlInAnyThread()) {
                        return;
                    }
                    if (UtilsJavaScriptInterface.this.mWebView != null && (JSUtils.isBaiduDomain(UtilsJavaScriptInterface.this.mWebView) || JSUtils.isBaiduLocalDomain(UtilsJavaScriptInterface.this.mWebView.getUrl()))) {
                        try {
                            JSONObject jsonObject = new JSONObject(params);
                            String action = jsonObject.optString("action");
                            String key = jsonObject.optString("key");
                            if (TextUtils.isEmpty(action)) {
                                return;
                            }
                            if (!TextUtils.isEmpty(key)) {
                                String data = jsonObject.optString("data");
                                String result = "";
                                if (action.equalsIgnoreCase("get")) {
                                    result = SharedPreferencesUtil.getInstance(UtilsJavaScriptInterface.this.mContext, "feed_web_data").getStringPreference(key, "");
                                } else if (action.equalsIgnoreCase("set")) {
                                    SharedPreferencesUtil.getInstance(UtilsJavaScriptInterface.this.mContext, "feed_web_data").setStringPreference(key, data);
                                } else if (action.equalsIgnoreCase("delete")) {
                                    SharedPreferencesUtil.getInstance(UtilsJavaScriptInterface.this.mContext, "feed_web_data").removeStringPreference(key);
                                }
                                JSONObject callBackObj = new JSONObject();
                                callBackObj.putOpt("errno", "1");
                                callBackObj.putOpt("errmsg", "success");
                                callBackObj.putOpt("data", result);
                                String info = callBackObj.toString();
                                if (UtilsJavaScriptInterface.DEBUG) {
                                    Log.i(UtilsJavaScriptInterface.TAG, "webStorage action:" + action + " key:" + key + " result:" + result.length());
                                }
                                UtilsJavaScriptInterface.this.mWebView.loadUrl(BaseHtmlBridgeHandler.JAVASCRIPT_PREFIX + callBack + FileViewerActivity.LEFT_BRACKET + info + ");");
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    } else if (UtilsJavaScriptInterface.this.mWebView != null) {
                        JSONObject jsonObject2 = new JSONObject();
                        try {
                            jsonObject2.putOpt("type", "webStorage");
                            jsonObject2.putOpt("value", UtilsJavaScriptInterface.this.mWebView.getUrl());
                            jsonObject2.putOpt("from", params);
                            jsonObject2.putOpt("source", callBack);
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                        UBC.onEvent(CommonJsInterfaceUtils.UBC_ID_WEB_STORAGE, jsonObject2.toString());
                    }
                }
            });
        }
    }

    @JavascriptInterface
    public void getGlobalSettings(final String callBack) {
        BdSailorWebView bdSailorWebView = this.mWebView;
        final String anyThreadUrl = bdSailorWebView instanceof NgWebView ? ((NgWebView) bdSailorWebView).getAnyThreadUrl() : "";
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (UtilsJavaScriptInterface.this.mWebView == null) {
                    return;
                }
                if (JSUtils.isBaiduDomain(UtilsJavaScriptInterface.this.mWebView) || JSUtils.isBaiduLocalDomain(UtilsJavaScriptInterface.this.mWebView.getUrl())) {
                    try {
                        if (UtilsJavaScriptInterface.this.mWebView == null || UtilsJavaScriptInterface.this.mWebView.getUrl() == null || UtilsJavaScriptInterface.this.mWebView.getUrl().equals(anyThreadUrl) || new JsInterfaceChecker(UtilsJavaScriptInterface.this.getLogContext(), (String) null, anyThreadUrl).checkUrlInAnyThread()) {
                            String fontSizeSring = FontSizeConfig.getFontSizeString(UtilsJavaScriptInterface.this.mContext);
                            JSONObject globalSettingsObj = new JSONObject();
                            globalSettingsObj.put("fontsize", fontSizeSring);
                            JSONObject callBackObj = new JSONObject();
                            callBackObj.putOpt("errno", "1");
                            callBackObj.putOpt("errmsg", "success");
                            callBackObj.putOpt("data", globalSettingsObj);
                            String info = callBackObj.toString();
                            UtilsJavaScriptInterface.this.postLoadJavaScript(callBack, info);
                            if (UtilsJavaScriptInterface.DEBUG) {
                                Log.d(UtilsJavaScriptInterface.TAG, "get global settings from NA, function name:" + callBack + "params:" + info);
                            }
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        });
    }

    @JavascriptInterface
    @Deprecated
    public void getABTestInfo(String params, String callBack) {
        new JsInterfaceLogger(getLogContext()).setFun("getABTestInfo").addArg("params", params).addArg("callBack", callBack).log();
        if (!TextUtils.isEmpty(params) && !TextUtils.isEmpty(callBack)) {
            try {
                String id = new JSONObject(params).optString("id");
                JSONObject callBackObj = new JSONObject();
                if (TextUtils.isEmpty(id)) {
                    callBackObj.putOpt("errno", "0");
                    callBackObj.put("errmsg", "id is Null");
                } else {
                    try {
                        int expreId = Integer.parseInt(id);
                        JSONObject idObj = AbTestManager.getInstance().getRawSwitch(expreId);
                        callBackObj.putOpt("errno", "1");
                        callBackObj.put("errmsg", "success");
                        JSONObject dataJsonObject = new JSONObject();
                        dataJsonObject.put("status", AbTestManager.getInstance().isInExperiment(expreId));
                        dataJsonObject.put("value", idObj);
                        callBackObj.putOpt("data", dataJsonObject);
                    } catch (NumberFormatException ex) {
                        ex.printStackTrace();
                        callBackObj.putOpt("errno", "0");
                        callBackObj.put("errmsg", "id is Not Integer Type");
                    }
                }
                postLoadJavaScript(callBack, callBackObj.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    @JavascriptInterface
    public void getABTestInfo(String callBack) {
        new JsInterfaceLogger(getLogContext()).setFun("getABTestInfo").setArgs(callBack).log();
        if (!TextUtils.isEmpty(callBack)) {
            JSONObject callBackObj = new JSONObject();
            try {
                JSONObject rawSwitch = AbTestManager.getInstance().getRawSwitch();
                callBackObj.putOpt("errno", "1");
                callBackObj.put("errmsg", "success");
                JSONObject dataJsonObject = new JSONObject();
                dataJsonObject.put("value", rawSwitch);
                callBackObj.putOpt("data", dataJsonObject);
                postLoadJavaScript(callBack, callBackObj.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    @JavascriptInterface
    public void getABTestSidList(String callBack) {
        new JsInterfaceLogger(getLogContext()).setFun("getABTestSidList").setArgs(callBack).log();
        if (!TextUtils.isEmpty(callBack)) {
            String expInfos = AbTestManager.getInstance().getExpInfos();
            JSONObject callBackObj = new JSONObject();
            try {
                callBackObj.putOpt("errno", "1");
                callBackObj.put("errmsg", "success");
                if (!TextUtils.isEmpty(expInfos)) {
                    callBackObj.put("data", new JSONArray(expInfos));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            postLoadJavaScript(callBack, callBackObj.toString());
        }
    }

    @JavascriptInterface
    public void getForwardServerCallback(String params, final String callBack) {
        new JsInterfaceLogger(getLogContext()).setFun("getForwardServerCallback").addArg("params", params).addArg("callBack", callBack).log();
        if (!TextUtils.isEmpty(params) && !TextUtils.isEmpty(callBack)) {
            try {
                JSONObject paramsJSON = new JSONObject(params);
                final String action = paramsJSON.getString("action");
                if (!TextUtils.isEmpty(action)) {
                    final String h5Params = paramsJSON.optString("h5params");
                    final ResponseCallback<ForwardToServer.ForwardData> responseCallback = new ResponseCallback<ForwardToServer.ForwardData>() {
                        public ForwardToServer.ForwardData parseResponse(Response response, int statusCode) throws Exception {
                            if (response.body() != null) {
                                return new ForwardToServer.ForwardData(response.body().string());
                            }
                            return null;
                        }

                        public void onSuccess(ForwardToServer.ForwardData response, int statusCode) {
                            if (AppConfig.isDebug()) {
                                Log.d(UtilsJavaScriptInterface.TAG, "response successful, response: " + response);
                            }
                            try {
                                JSONObject json = new JSONObject();
                                json.put("status", 1);
                                json.put("response", response.mResponse);
                                String info = json.toString();
                                if (UtilsJavaScriptInterface.DEBUG) {
                                    Log.d(UtilsJavaScriptInterface.TAG, "JS callback info :" + info);
                                }
                                UtilsJavaScriptInterface.this.postLoadJavaScript(callBack, info);
                            } catch (Exception e2) {
                                if (UtilsJavaScriptInterface.DEBUG) {
                                    e2.printStackTrace();
                                }
                            }
                        }

                        public void onFail(Exception exception) {
                            if (AppConfig.isDebug()) {
                                Log.d(UtilsJavaScriptInterface.TAG, "response fail");
                            }
                            UtilsJavaScriptInterface.this.returnFailNetConnection(callBack);
                        }
                    };
                    final String str = callBack;
                    UiThreadUtil.runOnUiThread(new Runnable() {
                        public void run() {
                            if (UtilsJavaScriptInterface.this.mWebView == null) {
                                return;
                            }
                            if ((JSUtils.isBaiduDomain(UtilsJavaScriptInterface.this.mWebView) || JSUtils.isBaiduLocalDomain(UtilsJavaScriptInterface.this.mWebView.getUrl())) && !ForwardToServer.getInstance().forwardTo(action, h5Params, responseCallback)) {
                                UtilsJavaScriptInterface.this.returnFailNetConnection(str);
                            }
                        }
                    });
                }
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        } else if (DEBUG) {
            Log.d(TAG, "Params is null");
        }
    }

    /* access modifiers changed from: private */
    public void returnFailNetConnection(String callBack) {
        try {
            JSONObject json = new JSONObject();
            json.put("status", 0);
            json.put("response", "");
            String info = json.toString();
            if (DEBUG) {
                Log.d(TAG, "JS callback info :" + info);
            }
            postLoadJavaScript(callBack, info);
        } catch (Exception e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    @JavascriptInterface
    public void getDeviceInfo(String params, String callBack) {
        new JsInterfaceLogger(getLogContext()).setFun("getDeviceInfo").addArg("params", params).addArg("callBack", callBack).log();
        if (!TextUtils.isEmpty(params)) {
            String anyThreadUrl = null;
            BdSailorWebView bdSailorWebView = this.mWebView;
            if (bdSailorWebView instanceof NgWebView) {
                anyThreadUrl = ((NgWebView) bdSailorWebView).getAnyThreadUrl();
            }
            final String str = params;
            final String str2 = callBack;
            new JsInterfaceChecker(getLogContext(), (String) null, anyThreadUrl) {
                /* access modifiers changed from: protected */
                public void onCheckPermissionFinished(int res) {
                    if (res == 0) {
                        try {
                            JSONObject callBackObj = new JSONObject();
                            JSONObject dataObj = new JSONObject();
                            JSONArray jsonArray = new JSONObject(str).optJSONArray("keys");
                            if (jsonArray != null) {
                                if (jsonArray.length() > 0) {
                                    for (int index = 0; index < jsonArray.length(); index++) {
                                        String key = jsonArray.optString(index);
                                        if ("netInfo".equals(key)) {
                                            JSONObject netInfoObj = new JSONObject();
                                            if (NetWorkUtils.isNetworkConnected(UtilsJavaScriptInterface.this.mContext)) {
                                                netInfoObj.putOpt("connected", "1");
                                                netInfoObj.putOpt("network", BaiduIdentityManager.getInstance(UtilsJavaScriptInterface.this.mContext).getCurrentNetTypeId());
                                            } else {
                                                netInfoObj.putOpt("connected", "0");
                                                netInfoObj.putOpt("network", "0");
                                            }
                                            dataObj.putOpt("netInfo", netInfoObj);
                                        } else if (InitProps.KEY_SCREEN_INFO.equals(key)) {
                                            JSONObject screenInfoObj = new JSONObject();
                                            screenInfoObj.putOpt("width", Integer.valueOf(DeviceUtils.ScreenInfo.getDisplayWidth(UtilsJavaScriptInterface.this.mContext)));
                                            screenInfoObj.putOpt("height", Integer.valueOf(DeviceUtils.ScreenInfo.getDisplayHeight(UtilsJavaScriptInterface.this.mContext)));
                                            screenInfoObj.putOpt("density", Integer.valueOf(DeviceUtils.ScreenInfo.getDensityDpi(UtilsJavaScriptInterface.this.mContext)));
                                            screenInfoObj.putOpt("dpi", Integer.valueOf(DeviceUtils.ScreenInfo.getDensityDpi(UtilsJavaScriptInterface.this.mContext)));
                                            dataObj.putOpt(InitProps.KEY_SCREEN_INFO, screenInfoObj);
                                        }
                                    }
                                }
                            }
                            callBackObj.putOpt("errno", "1");
                            callBackObj.put("errmsg", "success");
                            callBackObj.putOpt("data", dataObj);
                            UtilsJavaScriptInterface.this.postLoadJavaScript(str2, callBackObj.toString());
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }.check();
        }
    }

    @JavascriptInterface
    public void consoleLog(String params) {
        new JsInterfaceLogger(getLogContext()).setFun("consoleLog").addArg("params", params).log();
        if (!TextUtils.isEmpty(params) && DEBUG) {
            Log.e(TAG, "consoleLog : " + params + "->" + System.currentTimeMillis());
        }
    }

    @JavascriptInterface
    public void onPerformanceFlowEvent(String params) {
        new JsInterfaceLogger(getLogContext()).setFun("onPerformanceFlowEvent").addArg("params", params).log();
        if (!TextUtils.isEmpty(params)) {
            try {
                JSONObject jsonObject = new JSONObject(params);
                String operation = jsonObject.optString("operation");
                String actionId = jsonObject.optString("actionId");
                String value = jsonObject.optString("value");
                if (DEBUG) {
                    Log.e(TAG, "onPerformanceFlowEvent-->operation = " + operation + ", actionId = " + actionId + ", value = " + value);
                }
                if ("begin".equals(operation)) {
                    PerformanceFlowUtil.resetFlow();
                    PerformanceFlowUtil.instanceFlow("-1");
                    JsInterfaceRuntime.getFeed().resetFlow();
                    JsInterfaceRuntime.getFeed().instanceFlow(JsInterfaceRuntime.getFeed().getInvalidContextId());
                } else if ("end".equals(operation)) {
                    PerformanceFlowUtil.endFlow();
                    JsInterfaceRuntime.getFeed().endFlow();
                    JsInterfaceRuntime.getFeed().pushClickEndEvent();
                    ExternalTransferSpeedStats.endFlow();
                } else if ("event".equals(operation)) {
                    PerformanceFlowUtil.addEvent(actionId, value);
                    JsInterfaceRuntime.getFeed().addEvent(actionId, value);
                    ExternalTransferSpeedStats.addEvent(actionId, value);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    @JavascriptInterface
    public void onReliableLog(String params) {
        new JsInterfaceLogger(getLogContext()).setFun("onReliableLog").addArg("params", params).log();
        if (!TextUtils.isEmpty(params)) {
            JsInterfaceRuntime.getFeed().onReliableLog(params);
        }
    }

    @JavascriptInterface
    public void ubcEvent(String params) {
        new JsInterfaceLogger(getLogContext()).setFun("ubcEvent").addArg("params", params).log();
        if (!TextUtils.isEmpty(params)) {
            try {
                JSONObject jsonObject = new JSONObject(params);
                Long minVersion = 0L;
                try {
                    String minVersionStr = jsonObject.optString("min_v");
                    if (!TextUtils.isEmpty(minVersionStr)) {
                        minVersion = Long.valueOf(minVersionStr);
                    }
                    if (minVersion.longValue() >= UBC_MIN_VERSION) {
                        UBC.onEvent(jsonObject.optString("actionId"), jsonObject.optString("value"));
                    }
                } catch (NumberFormatException numberFormatException) {
                    numberFormatException.printStackTrace();
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    @JavascriptInterface
    public void startVoice(String params, String callBack) {
        JsInterfaceRuntime.getMisc().startVoice(this.mActivity, params, this, callBack);
    }

    @JavascriptInterface
    public void copy(String text, String callback) {
        if (AppConfig.isDebug()) {
            Log.i(TAG, "copy " + text);
        }
        String anyThreadUrl = null;
        BdSailorWebView bdSailorWebView = this.mWebView;
        if (bdSailorWebView instanceof NgWebView) {
            anyThreadUrl = ((NgWebView) bdSailorWebView).getAnyThreadUrl();
        }
        final String str = text;
        final String str2 = callback;
        new JsInterfaceChecker(getLogContext(), (String) null, anyThreadUrl) {
            /* access modifiers changed from: protected */
            public void onCheckPermissionFinished(int res) {
                if (res == 0) {
                    ((ClipboardManager) UtilsJavaScriptInterface.this.mContext.getSystemService(LaunchDragUBCManager.TYPE_CLIPBOARD)).setPrimaryClip(ClipData.newPlainText("text/plain", str));
                    UtilsJavaScriptInterface.this.postLoadJavaScript(str2, "0");
                }
            }
        }.check();
    }

    @JavascriptInterface
    public void showDislike(String param) {
        IPageBackCallback iPageBackCallback = this.mPageBackCallback;
        if (iPageBackCallback != null) {
            iPageBackCallback.parsePageDislikeData(param);
        }
    }

    @JavascriptInterface
    public void report(String param) {
        IPageBackCallback iPageBackCallback = this.mPageBackCallback;
        if (iPageBackCallback != null) {
            iPageBackCallback.parsePageReportData(param);
        }
    }

    public void postLoadJavaScript(final String callBack, final String info) {
        if (this.mWebView != null) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    UtilsJavaScriptInterface.this.loadJavaScript(BaseHtmlBridgeHandler.JAVASCRIPT_PREFIX + callBack + FileViewerActivity.LEFT_BRACKET + info + ");");
                }
            });
        }
    }

    public class JsCallback {
        private static final String RESULT_KEY = "result";
        private JSONObject mCallbackParam = new JSONObject();
        private String mErrorCallback;
        private String mSuccessCallback;

        public JsCallback(String successCallback, String errorCallback) {
            this.mSuccessCallback = successCallback;
            this.mErrorCallback = errorCallback;
        }

        public void addField(String key, String value) {
            try {
                this.mCallbackParam.put(key, value);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }

        public void addField(String key, JSONObject value) {
            try {
                this.mCallbackParam.put(key, value);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }

        public void setResult(boolean success) {
            setResult(success ^ true ? 1 : 0);
        }

        public void setResult(int resultCode) {
            try {
                this.mCallbackParam.put("result", resultCode);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }

        public void notifyResult() {
            int success = 0;
            try {
                success = this.mCallbackParam.getInt("result");
            } catch (JSONException e2) {
                if (UtilsJavaScriptInterface.DEBUG) {
                    Log.e(UtilsJavaScriptInterface.TAG, "result must be set befor notify!!!");
                }
            }
            UtilsJavaScriptInterface.this.notifyCallback(success == 0 ? this.mSuccessCallback : this.mErrorCallback, "'" + this.mCallbackParam.toString() + "'");
        }

        public void sendSuccCallBack() {
            setResult(true);
            notifyResult();
        }
    }
}
