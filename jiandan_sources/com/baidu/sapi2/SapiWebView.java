package com.baidu.sapi2;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsoluteLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.TooltipCompatHandler;
import com.alipay.sdk.m.p.e;
import com.alipay.sdk.m.s.a;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiJsInterpreters;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.SapiUpgradeInterpreters;
import com.baidu.sapi2.activity.SlideActiviy;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import com.baidu.sapi2.booster.SapiCallBacks;
import com.baidu.sapi2.booster.SapiUtil;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.enums.LoginTypes;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.share.ShareUtils;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.utils.DarkModeUtil;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.SapiCoreUtil;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiHost;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatLoadLogin;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.SyncAccountUtils;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.Enums;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.FromType;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.wallet.api.IWalletLoginListener;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import com.baidu.wallet.paysdk.datamodel.Bank;
import com.google.android.material.timepicker.RadialViewGroup;
import fe.fe.ppp.ad.ad;
import fe.fe.xxx.fe.qw;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.http2.Http2ExchangeCodec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class SapiWebView extends WebView {
    public static final String ACCOUNT_CENTER = "account_center";
    public static final String ACCOUNT_CENTER_CHECK = "account_check";
    public static final String ACCOUNT_CENTER_REAL_NAME = "account_realname";
    public static final String ACTION_FORGET_PWD = "forget-pwd";
    public static final String ACTION_MODIFY_PWD = "modify-pwd";
    public static final String ACTION_RENREN_OFFLINE = "renren-offline";
    public static final int AUTHORIZATION_TYPE_OPEN = 1;
    public static final int AUTHORIZATION_TYPE_PASS = 0;
    public static final String BROWSE_MODE_AGREEMENT_HOST = "https://s.bdstatic.com";
    public static final String CALLBACK_PARAM_KEY = "__wp-action";
    public static final String CUSTOM_CSS_INTERPRETER_URL = "css/sapi_theme/style.css";
    public static final String DATA_ENCODING = "UTF-8";
    public static final String DATA_MIME_TYPE = "text/html";
    public static final long DEFAULT_TIMEOUT_MILLIS = 90000;
    public static final PassNameValuePair EXTRA_BIND_WIDGET_CONFLICT_DETECT = new PassNameValuePair("bindToSmsLogin", "1");
    public static final PassNameValuePair EXTRA_ERROR_ONE_KEY_LOGIN_FAIL = new PassNameValuePair("sdkError", "oneKeyLoginFail");
    public static final PassNameValuePair EXTRA_SMS_LOGIN_SHOW_SOCIAL_LOGIN = new PassNameValuePair("smsfastlogin", "1");
    public static final String EXTRA_STAT_EXTRA = "extrajson";
    public static final PassNameValuePair EXTRA_SUPPORT_DIRECT_LOGIN = new PassNameValuePair("direct", "1");
    public static final PassNameValuePair EXTRA_SUPPORT_OVERSEAS_PHONE_NUMBER = new PassNameValuePair("overseas", "1");
    public static final PassNameValuePair EXTRA_SUPPORT_PHONE = new PassNameValuePair("supportPhone", "1");
    public static final String FN_GUIDE_PROCESS = "javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.setXml){Pass.client.setXml('%s')}}())";
    public static final String FN_NET_AVAILABLE = "javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.net){Pass.client.net()}}())";
    public static final String FN_SWITCH_VIEW = "javascript:(function(){if(window.Pass&&Pass.switchView){Pass.switchView('back')}else{window.history.go(-1)}}())";
    public static final String HTTPS_SSL_DATE_INVALID_DIALOG_CANCEL = "取消";
    public static final String HTTPS_SSL_DATE_INVALID_DIALOG_MSG = "当前设备时间为yyyy年MM月dd日,请设置正确的系统时间";
    public static final String HTTPS_SSL_DATE_INVALID_DIALOG_SET_TIME = "立即设置时间";
    public static final String HTTPS_SSL_DATE_INVALID_DIALOG_TITLE = "系统时间错误";
    public static final String HTTPS_SSL_UNTRUSTED_DIALOG_MSG = "网站安全证书已过期或不可信，系统时间错误可能导致此问题";
    public static final String HTTPS_SSL_UNTRUSTED_DIALOG_TITLE = "证书安全警告";
    public static final String PARAMS_IS_ACCEPT_BROWSEMODE_AGREEMENT = "isAcceptBrowseModeAgreement";
    public static final String PARAMS_LOGIN_WITH_PRE_LOGIN_NAME = "preLoginName";
    public static final String PARAMS_LOGIN_WITH_USER_NAME = "loginUserName";
    public static final String PARAMS_SCREEN_TYPE = "screenType";
    public static final String PROMPT_ON_CANCEL = "prompt_on_cancel";
    public static final String QR_FACE_AUTH_PASS_PRODUCT_ID = "pp";
    public static final String SWITCH_ACCOUNT_PAGE = "switch_account";
    public static final String TAG = SapiWebView.class.getSimpleName();
    public static final String URL_HASH_CHINA_MOBILE_OAUTH = "#oneKeyLogin";
    public static final String URL_HASH_FACE_LOGIN = "#face_login";
    public static final String URL_HASH_FAST_REG = "#fastReg";
    public static final String URL_HASH_INSERT_LOGIN = "#insert_account";
    public static final String URL_HASH_JOIN_LOGIN = "#canshareAi";
    public static final String URL_HASH_LOGIN = "#login";
    public static final String URL_HASH_LOGIN_DEGRADE = "#/login";
    public static final String URL_HASH_LOGIN_WITH_USERNAME = "#authPwd";
    public static final String URL_HASH_PASSWORD_LOGIN = "#password_login";
    public static final String URL_HASH_REG = "#reg";
    public static final String URL_HASH_SHARE = "#canshare_accounts";
    public static final String URL_HASH_SHARE_OAUTH = "#share_auth";
    public static final String URL_HASH_SMS_LOGIN = "#sms_login";
    public static StatLoadLogin statLoadLogin;
    public AccountChangeCallback accountChangeCallback;
    public List<String> asynJsMehodName;
    public ChangePwdCallback changePwdCallback;
    public ArrayList<BaseCommand> checkCommandList = new ArrayList<>();
    public SapiConfiguration configuration;
    public Dialog dateInvalidDialog;
    public List<PassNameValuePair> extras;
    public FileChooserCallback fileChooserCallback;
    public boolean isAccountTools;
    public boolean isDestory;
    public volatile boolean isLoadThirdPartyUrl;
    public boolean isSupFaceLogin;
    public SapiJsCallBacks.CallBacks jsCallBacks;
    public SapiJsInterpreters jsInterpreters;
    public SapiUpgradeInterpreters jsUpgradeInterpreters;
    public int leftBtnIsVisible = 1;
    public LoginTypes mExcludeTypes;
    public ArrayList<LoginTypes> mExcludeTypesList;
    public boolean mHadMakeBarHide;
    public boolean mIsCFProess;
    public OnLoginAssertLoadSuccessListener mOnLoginAssertLoadSuccessListener;
    public View noNetworkView;
    public OnBackCallback onBackCallback;
    public OnFinishCallback onFinishCallback;
    public OnNewBackCallback onNewBackCallback;
    public ProgressBar progressBar;
    public ProgressDialog progressDialog;
    public ReloadConfig reloadConfig = new ReloadConfig();
    public SapiCache sapiCache;
    public boolean shareV2Disable = false;
    public boolean shouldClose;
    public boolean showLinkAccount;
    public boolean showSwitchAccount;
    public boolean supportTouchGuide = true;
    public Handler timeoutHandler = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 1) {
                SapiWebView.this.handleTimeout();
            }
        }
    };
    public long timeoutMillis;
    public TimeoutTask timeoutTask = new TimeoutTask();
    public View timeoutView;
    public String[] touchidPortraitAndSign = new String[2];
    public ArrayList<BaseCommand> useCommandList = new ArrayList<>();
    public volatile String userInfoXmlContent;
    public WebChromeClientCallback webChromeClientCallback;
    public WebviewClientCallback webviewClientCallback;
    public View webviewLoadingView;

    public interface AccountChangeCallback {
        void onAccountChange();
    }

    public static abstract class AccountDestoryCallback {

        public static class AccountDestoryResult {
        }

        public abstract void onAccountDestory(AccountDestoryResult accountDestoryResult);
    }

    public static abstract class AccountFreezeCallback {

        public static class AccountFreezeResult {
        }

        public abstract void onAccountFreeze(AccountFreezeResult accountFreezeResult);
    }

    public enum ActivityLifeCycle {
        ON_RESUME("webViewWillAppear"),
        ON_PAUSE("webViewWillDisappear");
        
        public String methodName;

        /* access modifiers changed from: public */
        ActivityLifeCycle(String str) {
            this.methodName = str;
        }
    }

    public interface BdussChangeCallback {
        void onBdussChange();
    }

    public interface BindWidgetCallback {
        void onPhoneNumberExist(String str);
    }

    public interface BioScanFaceCallback {
        public static final int BIO_SCAN_FACE_LOGIN = 2;
        public static final int BIO_SCAN_FACE_REG = 1;

        public static abstract class BioScanFaceResult {
            public int showGuidePage;
            public String subpro;
            public List<PassNameValuePair> transParamsList = new ArrayList();
            public Map<String, String> transParamsMap = new HashMap();
            public int type;
            public String uid;

            public abstract void setScanFaceIdentifyResult(String str);
        }

        void onBioScanFace(BioScanFaceResult bioScanFaceResult);
    }

    public interface BiometricsIdentifyCallback {
        public static final int LIVENESS_RECOG = 1;

        void onBiometricsIdentify(BiometricsIdentifyResult biometricsIdentifyResult);
    }

    public static abstract class BiometricsIdentifyResult {
        public static final int ERROR_CODE_GET_STOKEN_FAILED = -402;
        public static final String ERROR_MSG_GET_STOKEN_FAILED = "服务异常，请稍后再试";
        public static final String LIVENESS_RECOGNIZE_TYPE_AUTHTOKEN = "authtoken";
        public static final String LIVENESS_RECOGNIZE_TYPE_BDUSS = "bduss";
        public static final String LIVENESS_RECOGNIZE_TYPE_CERTINFO = "certinfo";
        public String authToken;
        public int biometricType;
        public Bundle extraParams;
        public String idCardNum;
        public String livenessRecogType;
        public String nation = "";
        public String phoneNum;
        public String realName;
        public int recordVideo;
        public int showGuidePage;
        public String subPro;
        public String verifyType = "";

        public abstract void setIdentifyToken(String str);
    }

    public interface ChangePwdCallback {
        void onSuccess();
    }

    public static class Command extends BaseCommand {
        public static Command parse(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str.toString());
                Command command = new Command();
                JSONObject optJSONObject = jSONObject.optJSONObject("action");
                if (optJSONObject != null) {
                    command.actionName = optJSONObject.optString("name");
                    JSONArray optJSONArray = optJSONObject.optJSONArray("params");
                    if (optJSONArray != null) {
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            command.actionParams.add(optJSONArray.optString(i2));
                        }
                    }
                }
                command.originCommand = str;
                return command;
            } catch (JSONException e) {
                Log.e(e);
                return null;
            }
        }
    }

    public interface CoverWebBdussCallback {
        void onCoverBduss(String str, CoverWebBdussResult coverWebBdussResult);
    }

    public static abstract class CoverWebBdussResult {
        public abstract void setWebBduss(String str);
    }

    public interface FileChooserCallback {
        void onFileChooser(ValueCallback<Uri> valueCallback);

        void onFileChooserForOSVersion5(ValueCallback<Uri[]> valueCallback);
    }

    public interface HistoryLoginCallback {
        void onSuccess();
    }

    public interface InvokeScAppCallback {

        public static abstract class InvokeScAppResult {
            public abstract void setInvokeResult(String str);
        }

        void onInvokeScApp(String str, String str2, List<PassNameValuePair> list, InvokeScAppResult invokeScAppResult);
    }

    public interface LeftBtnVisibleCallback {
        public static final int LEFT_BTN_INVISIBLE = 0;
        public static final int LEFT_BTN_VISIBLE = 1;

        void onLeftBtnVisible(int i2);
    }

    public interface LoadExternalWebViewCallback {
        void loadExternalWebview(LoadExternalWebViewResult loadExternalWebViewResult);
    }

    public static class LoadExternalWebViewResult {
        public String defaultTitle;
        public String externalUrl;
    }

    public interface LoadSlideWebViewCallback {
        void loadSlideWebview(LoadSlideWebViewResult loadSlideWebViewResult);
    }

    public static class LoadSlideWebViewResult {
        public String adapter;
        public String page;
        public String placeholderTitle;
        public String url;
    }

    public interface LocalConfigCallback {
        List<FastLoginFeature> getFastLoginFeatureList();
    }

    public interface OnBackCallback {
        void onBack();
    }

    public interface OnFinishCallback {
        void onFinish();
    }

    public interface OnLoginAssertLoadSuccessListener {
        void onAssertLoadFinish();
    }

    public interface OnNewBackCallback {
        boolean onBack();
    }

    public interface OnSlidePageFinishCallback {
        void onFinish(String str);
    }

    public interface PickPhotoCallback {
        public static final int PICK_IMAGE_ALBUM = 2;
        public static final int PICK_IMAGE_PHOTO = 1;

        void onPickImage(int i2, int i3, int i4, PickPhotoResult pickPhotoResult);
    }

    public static abstract class PickPhotoResult {
        public void setImageData(String str) {
        }
    }

    public static abstract class PreFillUserNameCallback {

        public static class PreFillUserNameResult {
            public String userName;
        }

        public abstract void onPreFillUserName(PreFillUserNameResult preFillUserNameResult);
    }

    public interface QrLoginCallback {
        void loginStatusChange(boolean z);
    }

    public interface QuickLoginHandler {
        void handleOtherLogin();
    }

    public interface RealnameAuthenticateCallback {
        void onFailure();

        void onSuccess();
    }

    public class ReloadConfig {
        public boolean bindAccount;
        public List<PassNameValuePair> paramsList;
        public String timeoutUrl;
        public String weixinBindUrl;
        public boolean wxSsoReload;

        public ReloadConfig() {
            this.timeoutUrl = null;
            this.wxSsoReload = false;
        }

        public void reset() {
            this.timeoutUrl = null;
            this.wxSsoReload = false;
        }
    }

    public interface ShareAccountClickCallback {
        void onClick(String str, String str2, String str3, String str4, String str5);
    }

    public static abstract class SwitchAccountCallback {

        public static class Result {
            public String displayName;
            public String encryptedUid;
            public String extraJson;
            public int loginType;
            public int switchAccountType;
            public String userName;
        }

        public abstract void onAccountSwitch(Result result);
    }

    public class TimeoutTask implements Runnable {
        public String url;

        public TimeoutTask() {
        }

        public void run() {
            if (SapiWebView.this.getProgress() < 100) {
                Message message = new Message();
                message.what = 1;
                message.obj = this.url;
                SapiWebView.this.timeoutHandler.sendMessage(message);
                SapiWebView.this.timeoutHandler.removeCallbacks(this);
            }
        }

        public void setUrl(String str) {
            this.url = str;
        }
    }

    public interface UniteVerifyCallback {
        void onSuccess(String str, String str2, SapiAccount sapiAccount);
    }

    public interface WebChromeClientCallback {
        boolean isSubClassHandleMessage(String str);

        void onConsoleMessage(String str, int i2, String str2);

        boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult);
    }

    public interface WebViewReceviceTitleCallback {
        void onTitleChange(String str);
    }

    public interface WebViewTitleCallback {
        void onTitleChange(String str);
    }

    public interface WebviewClientCallback {
        void onPageFinished(WebView webView, String str);

        void onPageStarted(WebView webView, String str, Bitmap bitmap);

        void shouldOverrideUrlLoading(WebView webView, String str);
    }

    public SapiWebView(Context context) {
        super(context);
        init();
    }

    private String addExtras(String str, List<PassNameValuePair> list) {
        if (list == null) {
            return str;
        }
        ArrayList arrayList = new ArrayList();
        for (PassNameValuePair next : list) {
            if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                try {
                    arrayList.add(new PassNameValuePair(URLEncoder.encode(next.getName(), "UTF-8"), URLEncoder.encode(next.getValue(), "UTF-8")));
                } catch (UnsupportedEncodingException e) {
                    Log.e(e);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return str;
        }
        return str + a.n + SapiUtils.createRequestParams(arrayList);
    }

    /* access modifiers changed from: private */
    public void authorizeSuccess(AccountType accountType) {
        if (!TextUtils.isEmpty(this.jsCallBacks.touchidPortraitAndSign[0])) {
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            String[] strArr = this.jsCallBacks.touchidPortraitAndSign;
            currentAccount.phone = strArr[0];
            currentAccount.email = strArr[1];
            SapiContext.getInstance().addTouchidAccounts(currentAccount);
        }
        if (this.jsCallBacks.authorizationListener != null) {
            try {
                String str = TAG;
                Log.d(str, "authorizeSuccess: onSuccess:" + accountType);
                if (!AuthorizationListener.class.equals(this.jsCallBacks.authorizationListener.getClass().getMethod("onSuccess", new Class[]{AccountType.class}).getDeclaringClass())) {
                    this.jsCallBacks.authorizationListener.onSuccess(accountType);
                    return;
                }
            } catch (NoSuchMethodException e) {
                Log.e(e);
            }
            this.jsCallBacks.authorizationListener.onSuccess();
        }
    }

    /* access modifiers changed from: private */
    public void closeLoading() {
        View view = this.webviewLoadingView;
        if (view != null) {
            view.setVisibility(8);
        }
        OnLoginAssertLoadSuccessListener onLoginAssertLoadSuccessListener = this.mOnLoginAssertLoadSuccessListener;
        if (onLoginAssertLoadSuccessListener != null) {
            onLoginAssertLoadSuccessListener.onAssertLoadFinish();
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    @TargetApi(7)
    private void configSapiWebView() {
        SapiConfiguration sapiConfiguration;
        WebSettings settings = getSettings();
        try {
            settings.setJavaScriptEnabled(true);
        } catch (NullPointerException e) {
            Log.e(e);
        }
        String userAgentString = settings.getUserAgentString();
        settings.setUserAgentString(userAgentString + " " + getUaInfo());
        settings.setTextSize(WebSettings.TextSize.NORMAL);
        settings.setDomStorageEnabled(true);
        setScrollBarStyle(0);
        settings.setSaveFormData(false);
        SapiConfiguration sapiConfiguration2 = this.configuration;
        if (sapiConfiguration2 != null) {
            settings.setTextZoom(sapiConfiguration2.getTextZoom());
        }
        settings.setSavePassword(false);
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33) {
            settings.setAlgorithmicDarkeningAllowed(false);
        } else if (i2 >= 29) {
            settings.setForceDark(0);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
        }
        if (Build.VERSION.SDK_INT >= 19 && (sapiConfiguration = this.configuration) != null && sapiConfiguration.debug) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    intent.setFlags(268435456);
                    SapiWebView.this.getContext().startActivity(intent);
                } catch (Throwable th2) {
                    Log.e(th2);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public String fixAdapterParamValue(String str) {
        boolean z;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        boolean z2 = false;
        if (confignation == null) {
            z = false;
        } else {
            if (!this.mHadMakeBarHide && confignation.customActionBarEnabled) {
                z2 = true;
            }
            z = confignation.showBottomBack;
        }
        return replaceParams(str, "adapter", ParamsUtil.getAdapterParamValue(z2, z));
    }

    private String generateJSStr(String str) {
        return String.format("javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.%s){ Pass.client.%s()}}())", new Object[]{str, str});
    }

    public static String getMatcher(String str, String str2) {
        Pattern compile = Pattern.compile(str);
        String str3 = "";
        if (TextUtils.isEmpty(str2)) {
            return str3;
        }
        Matcher matcher = compile.matcher(str2);
        while (matcher.find()) {
            str3 = matcher.group();
        }
        return str3;
    }

    /* access modifiers changed from: private */
    public void handleLoadingView() {
        View view = this.noNetworkView;
        if (view == null || view.getVisibility() != 0) {
            View view2 = this.timeoutView;
            if (view2 == null || view2.getVisibility() != 0) {
                post(new Runnable() {
                    public void run() {
                        if (SapiWebView.this.webviewLoadingView != null) {
                            SapiWebView.this.setWebViewShowLoading(true);
                            if (SapiWebView.this.progressBar != null) {
                                SapiWebView.this.progressBar.setVisibility(8);
                            }
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void handleNetworkUnavailable() {
        post(new Runnable() {
            public void run() {
                if (SapiWebView.this.progressBar != null) {
                    SapiWebView.this.progressBar.setVisibility(8);
                }
                SapiWebView.this.closeLoading();
                if (SapiWebView.this.noNetworkView != null) {
                    SapiWebView.this.noNetworkView.setVisibility(0);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void handleTimeout() {
        stopLoading();
        post(new Runnable() {
            public void run() {
                if (SapiWebView.this.progressBar != null) {
                    SapiWebView.this.progressBar.setVisibility(8);
                }
                SapiWebView.this.closeLoading();
                SapiWebView.this.reloadConfig.timeoutUrl = SapiWebView.this.timeoutTask.url;
                if (SapiWebView.this.timeoutView != null) {
                    SapiWebView.this.timeoutView.setVisibility(0);
                }
            }
        });
    }

    @SuppressLint({"AddJavascriptInterface"})
    @TargetApi(11)
    private void init() {
        SapiJsCallBacks.CallBacks callBacks = new SapiJsCallBacks.CallBacks();
        this.jsCallBacks = callBacks;
        callBacks.evalJavaScript = new SapiCallBacks.EvalJavaScript() {
            public /* synthetic */ void postResult(WebView webView, String str, SapiUtil.Command command) {
                qw.$default$postResult(this, webView, str, command);
            }
        };
        this.jsInterpreters = new SapiJsInterpreters(this, this.jsCallBacks);
        this.jsUpgradeInterpreters = new SapiUpgradeInterpreters(this, this.jsCallBacks);
        this.timeoutMillis = DEFAULT_TIMEOUT_MILLIS;
        this.configuration = SapiAccountManager.getInstance().getSapiConfiguration();
        this.sapiCache = new SapiCache();
        this.isSupFaceLogin = new FaceLoginService().isSupFaceLogin();
        configSapiWebView();
        setAsynJsMehodName();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 > 10 && i2 < 19) {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        }
        setWebViewClient(new WebViewClient() {
            /* JADX WARNING: Code restructure failed: missing block: B:25:0x017b, code lost:
                if ((r3.getHost() + r3.getPath()).contains(r2.getHost() + r2.getPath()) != false) goto L_0x017d;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onPageFinished(android.webkit.WebView r9, java.lang.String r10) {
                /*
                    r8 = this;
                    java.lang.String r0 = com.baidu.sapi2.SapiWebView.TAG
                    r1 = 1
                    java.lang.Object[] r2 = new java.lang.Object[r1]
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    java.lang.String r4 = "onPageFinished: "
                    r3.append(r4)
                    r3.append(r10)
                    java.lang.String r3 = r3.toString()
                    r4 = 0
                    r2[r4] = r3
                    com.baidu.sapi2.utils.Log.d(r0, r2)
                    super.onPageFinished(r9, r10)
                    int r0 = android.os.Build.VERSION.SDK_INT
                    r2 = 7
                    if (r0 <= r2) goto L_0x002f
                    com.baidu.sapi2.SapiWebView r0 = com.baidu.sapi2.SapiWebView.this
                    android.webkit.WebSettings r0 = r0.getSettings()
                    r0.setBlockNetworkLoads(r4)
                L_0x002f:
                    com.baidu.sapi2.SapiWebView r0 = com.baidu.sapi2.SapiWebView.this
                    r0.closeLoading()
                    com.baidu.sapi2.SapiWebView r0 = com.baidu.sapi2.SapiWebView.this
                    android.content.Context r0 = r0.getContext()
                    boolean r0 = com.baidu.sapi2.utils.SapiUtils.hasActiveNetwork(r0)
                    if (r0 == 0) goto L_0x005e
                    com.baidu.sapi2.SapiWebView r0 = com.baidu.sapi2.SapiWebView.this
                    android.view.View r0 = r0.noNetworkView
                    if (r0 == 0) goto L_0x005e
                    com.baidu.sapi2.SapiWebView r0 = com.baidu.sapi2.SapiWebView.this
                    android.view.View r0 = r0.noNetworkView
                    int r0 = r0.getVisibility()
                    r2 = 4
                    if (r0 == r2) goto L_0x005e
                    com.baidu.sapi2.SapiWebView r0 = com.baidu.sapi2.SapiWebView.this
                    android.view.View r0 = r0.noNetworkView
                    r0.setVisibility(r2)
                L_0x005e:
                    com.baidu.sapi2.SapiWebView r0 = com.baidu.sapi2.SapiWebView.this
                    java.lang.String r2 = "javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.net){Pass.client.net()}}())"
                    r0.loadUrl(r2)
                    com.baidu.sapi2.SapiWebView r0 = com.baidu.sapi2.SapiWebView.this
                    com.baidu.sapi2.SapiJsCallBacks$CallBacks r0 = r0.jsCallBacks
                    com.baidu.sapi2.SapiWebView$WebViewTitleCallback r0 = r0.webViewTitleCallback
                    if (r0 == 0) goto L_0x0076
                    com.baidu.sapi2.SapiWebView r0 = com.baidu.sapi2.SapiWebView.this
                    java.lang.String r2 = "javascript:prompt(JSON.stringify({action:{name:'action_set_title',params:[document.title, 'prompt_on_cancel', 'prompt_on_cancel']}}));"
                    r0.loadUrl(r2)
                L_0x0076:
                    com.baidu.sapi2.SapiWebView r0 = com.baidu.sapi2.SapiWebView.this
                    boolean r0 = r0.isLoadThirdPartyUrl
                    if (r0 == 0) goto L_0x00a8
                    com.baidu.sapi2.SapiWebView r0 = com.baidu.sapi2.SapiWebView.this
                    java.lang.String r0 = r0.userInfoXmlContent
                    boolean r0 = android.text.TextUtils.isEmpty(r0)
                    if (r0 != 0) goto L_0x00a8
                    com.baidu.sapi2.SapiWebView r0 = com.baidu.sapi2.SapiWebView.this
                    java.lang.Object[] r2 = new java.lang.Object[r1]
                    java.lang.String r3 = r0.userInfoXmlContent
                    r2[r4] = r3
                    java.lang.String r3 = "javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.setXml){Pass.client.setXml('%s')}}())"
                    java.lang.String r2 = java.lang.String.format(r3, r2)
                    com.baidu.sapi2.SapiWebView.super.loadUrl(r2)
                    com.baidu.sapi2.SapiWebView r0 = com.baidu.sapi2.SapiWebView.this
                    boolean unused = r0.isLoadThirdPartyUrl = r4
                    com.baidu.sapi2.SapiWebView r0 = com.baidu.sapi2.SapiWebView.this
                    r2 = 0
                    java.lang.String unused = r0.userInfoXmlContent = r2
                L_0x00a8:
                    com.baidu.sapi2.SapiAccountManager r0 = com.baidu.sapi2.SapiAccountManager.getInstance()
                    com.baidu.sapi2.SapiAccountService r0 = r0.getAccountService()
                    java.lang.String r0 = r0.getUrlAfterAuth()
                    android.net.Uri r0 = android.net.Uri.parse(r0)
                    com.baidu.sapi2.SapiAccountManager r2 = com.baidu.sapi2.SapiAccountManager.getInstance()
                    com.baidu.sapi2.SapiAccountService r2 = r2.getAccountService()
                    java.lang.String r2 = r2.getUrlFinishBind()
                    android.net.Uri.parse(r2)
                    com.baidu.sapi2.SapiAccountManager r2 = com.baidu.sapi2.SapiAccountManager.getInstance()
                    com.baidu.sapi2.SapiAccountService r2 = r2.getAccountService()
                    java.lang.String r2 = r2.getUrlSSOFinish()
                    android.net.Uri r2 = android.net.Uri.parse(r2)
                    android.net.Uri r3 = android.net.Uri.parse(r10)
                    com.baidu.sapi2.SapiAccountManager r5 = com.baidu.sapi2.SapiAccountManager.getInstance()
                    com.baidu.sapi2.SapiAccountService r5 = r5.getAccountService()
                    java.lang.String r6 = "account_center"
                    java.lang.String r5 = r5.getAccountCenterUrl(r6)
                    android.net.Uri r5 = android.net.Uri.parse(r5)
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder
                    r6.<init>()
                    java.lang.String r7 = r5.getHost()
                    r6.append(r7)
                    java.lang.String r5 = r5.getPath()
                    r6.append(r5)
                    java.lang.String r5 = r6.toString()
                    boolean r5 = r10.contains(r5)
                    if (r5 == 0) goto L_0x0110
                    com.baidu.sapi2.SapiWebView r4 = com.baidu.sapi2.SapiWebView.this
                    boolean unused = r4.shouldClose = r1
                    goto L_0x0115
                L_0x0110:
                    com.baidu.sapi2.SapiWebView r1 = com.baidu.sapi2.SapiWebView.this
                    boolean unused = r1.shouldClose = r4
                L_0x0115:
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r4 = r3.getHost()
                    r1.append(r4)
                    java.lang.String r4 = r3.getPath()
                    r1.append(r4)
                    java.lang.String r1 = r1.toString()
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder
                    r4.<init>()
                    java.lang.String r5 = r0.getHost()
                    r4.append(r5)
                    java.lang.String r0 = r0.getPath()
                    r4.append(r0)
                    java.lang.String r0 = r4.toString()
                    boolean r0 = r1.contains(r0)
                    if (r0 != 0) goto L_0x017d
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r1 = r3.getHost()
                    r0.append(r1)
                    java.lang.String r1 = r3.getPath()
                    r0.append(r1)
                    java.lang.String r0 = r0.toString()
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r3 = r2.getHost()
                    r1.append(r3)
                    java.lang.String r2 = r2.getPath()
                    r1.append(r2)
                    java.lang.String r1 = r1.toString()
                    boolean r0 = r0.contains(r1)
                    if (r0 == 0) goto L_0x0196
                L_0x017d:
                    android.net.Uri r0 = android.net.Uri.parse(r10)
                    java.lang.String r1 = "wapsec"
                    java.lang.String r0 = r0.getQueryParameter(r1)
                    java.lang.String r1 = "center"
                    boolean r0 = r1.equals(r0)
                    if (r0 != 0) goto L_0x0196
                    com.baidu.sapi2.SapiWebView r0 = com.baidu.sapi2.SapiWebView.this
                    java.lang.String r1 = "javascript:prompt(JSON.stringify({'action':{'name': 'authorized_response', 'params': [document.body.innerHTML, '1', 'prompt_on_cancel']}}));"
                    r0.loadUrl(r1)
                L_0x0196:
                    com.baidu.sapi2.SapiWebView r0 = com.baidu.sapi2.SapiWebView.this
                    android.os.Handler r0 = r0.timeoutHandler
                    com.baidu.sapi2.SapiWebView r1 = com.baidu.sapi2.SapiWebView.this
                    com.baidu.sapi2.SapiWebView$TimeoutTask r1 = r1.timeoutTask
                    r0.removeCallbacks(r1)
                    com.baidu.sapi2.SapiWebView r0 = com.baidu.sapi2.SapiWebView.this
                    com.baidu.sapi2.SapiWebView$WebviewClientCallback r0 = r0.webviewClientCallback
                    if (r0 == 0) goto L_0x01b6
                    com.baidu.sapi2.SapiWebView r0 = com.baidu.sapi2.SapiWebView.this
                    com.baidu.sapi2.SapiWebView$WebviewClientCallback r0 = r0.webviewClientCallback
                    r0.onPageFinished(r9, r10)
                L_0x01b6:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.SapiWebView.AnonymousClass4.onPageFinished(android.webkit.WebView, java.lang.String):void");
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                Log.d(SapiWebView.TAG, "onPageStarted: " + str);
                super.onPageStarted(webView, str, bitmap);
                if (SapiWebView.this.jsCallBacks.pageStateCallback != null) {
                    Uri parse = Uri.parse(SapiWebView.this.getLoginUrl());
                    Uri parse2 = Uri.parse(str);
                    if (parse2 != null) {
                        if ((parse2.getHost() + parse2.getPath()).equals(parse.getHost() + parse.getPath())) {
                            SapiWebView.this.jsCallBacks.pageStateCallback.pageState(1);
                        }
                    }
                    SapiWebView.this.jsCallBacks.pageStateCallback.pageState(2);
                }
                if (!SapiUtils.hasActiveNetwork(SapiWebView.this.getContext()) && !TextUtils.isEmpty(str) && !str.startsWith("javascript:") && !str.contains("loadDataWithBaseUrl")) {
                    SapiWebView.this.handleNetworkUnavailable();
                }
                SapiWebView.this.timeoutTask.setUrl(str);
                SapiWebView.this.timeoutHandler.postDelayed(SapiWebView.this.timeoutTask, SapiWebView.this.timeoutMillis);
                SapiWebView.this.handleLoadingView();
                if (str != null) {
                    if (str.contains(SapiWebView.ACTION_FORGET_PWD) || str.contains(SapiWebView.ACTION_MODIFY_PWD)) {
                        String queryParameter = Uri.parse(str).getQueryParameter(SapiWebView.CALLBACK_PARAM_KEY);
                        if (SapiWebView.ACTION_FORGET_PWD.equals(queryParameter) && SapiWebView.this.changePwdCallback != null) {
                            SapiWebView.this.post(new Runnable() {
                                public void run() {
                                    SapiWebView.this.stopLoading();
                                    if (SapiWebView.this.changePwdCallback != null) {
                                        SapiWebView.this.changePwdCallback.onSuccess();
                                    }
                                }
                            });
                        }
                        if (SapiWebView.ACTION_MODIFY_PWD.equals(queryParameter) && SapiWebView.this.changePwdCallback != null) {
                            SapiWebView.this.post(new Runnable() {
                                public void run() {
                                    SapiWebView.this.stopLoading();
                                    final String cookieBduss = SapiUtils.getCookieBduss();
                                    final String cookiePtoken = SapiUtils.getCookiePtoken();
                                    if (!TextUtils.isEmpty(cookieBduss)) {
                                        SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() {
                                            public void onFinish() {
                                                SapiWebView.this.dismissProgress();
                                            }

                                            public void onStart() {
                                                SapiWebView.this.showProgress();
                                            }

                                            public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                                                if (SapiWebView.this.changePwdCallback != null) {
                                                    SapiWebView.this.changePwdCallback.onSuccess();
                                                }
                                            }

                                            public void onFailure(GetUserInfoResult getUserInfoResult) {
                                                if (SapiWebView.this.changePwdCallback != null) {
                                                    SapiWebView.this.changePwdCallback.onSuccess();
                                                }
                                            }

                                            public void onSuccess(GetUserInfoResult getUserInfoResult) {
                                                SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                                                if (currentAccount != null) {
                                                    if (currentAccount.uid.equals(getUserInfoResult.uid)) {
                                                        currentAccount.bduss = cookieBduss;
                                                    }
                                                    if (!TextUtils.isEmpty(cookiePtoken)) {
                                                        currentAccount.ptoken = cookiePtoken;
                                                    }
                                                    currentAccount.deleteStokens();
                                                }
                                                SapiAccountManager.getInstance().validate(currentAccount);
                                                if (SapiWebView.this.changePwdCallback != null) {
                                                    SapiWebView.this.changePwdCallback.onSuccess();
                                                }
                                            }
                                        }, cookieBduss);
                                    } else if (SapiWebView.this.changePwdCallback != null) {
                                        SapiWebView.this.changePwdCallback.onSuccess();
                                    }
                                }
                            });
                        }
                    }
                    if (str.contains("__wp-action=renren-offline") && SapiWebView.ACTION_RENREN_OFFLINE.equals(Uri.parse(str).getQueryParameter(SapiWebView.CALLBACK_PARAM_KEY))) {
                        if (SapiWebView.this.jsCallBacks.rrLoginResponse != null) {
                            SapiWebView sapiWebView = SapiWebView.this;
                            sapiWebView.handleOpenApiAuthorizeResponse(sapiWebView.jsCallBacks.rrLoginResponse);
                        } else if (SapiWebView.this.jsCallBacks.authorizationListener != null) {
                            SapiWebView.this.post(new Runnable() {
                                public void run() {
                                    if (SapiWebView.this.jsCallBacks.authorizationListener != null) {
                                        SapiWebView.this.jsCallBacks.authorizationListener.onFailed(-100, "登录失败");
                                    }
                                }
                            });
                        }
                    }
                }
                if (SapiWebView.this.webviewClientCallback != null) {
                    SapiWebView.this.webviewClientCallback.onPageStarted(webView, str, bitmap);
                }
            }

            public void onReceivedError(WebView webView, int i2, String str, String str2) {
                super.onReceivedError(webView, i2, str, str2);
                Log.d(SapiWebView.TAG, "onReceivedError: ", Integer.valueOf(i2), str, str2);
                if (i2 == -8 || i2 == -6 || i2 == -2 || i2 == -5) {
                    SapiWebView.this.handleTimeout();
                }
            }

            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                String str;
                String str2;
                String access$400 = SapiWebView.TAG;
                Log.d(access$400, "onReceivedSslError: na_err_code", sslError.getPrimaryError() + "");
                StatService.onEvent("sslerr_view", Collections.singletonMap("na_err_code", sslError.getPrimaryError() + ""));
                if (sslError.getPrimaryError() == 4 || sslError.getPrimaryError() == 3) {
                    sslErrorHandler.cancel();
                    if (!(!SapiWebView.this.configuration.forbidSslErrorDialog)) {
                        if (SapiWebView.this.dateInvalidDialog == null) {
                            if (Build.VERSION.SDK_INT > 17) {
                                str2 = new SimpleDateFormat(SapiWebView.HTTPS_SSL_DATE_INVALID_DIALOG_MSG).format(new Date(System.currentTimeMillis()));
                                str = SapiWebView.HTTPS_SSL_DATE_INVALID_DIALOG_TITLE;
                            } else {
                                str = SapiWebView.HTTPS_SSL_UNTRUSTED_DIALOG_TITLE;
                                str2 = "网站安全证书已过期或不可信，系统时间错误可能导致此问题";
                            }
                            AlertDialog.Builder builder = new AlertDialog.Builder(SapiWebView.this.getContext());
                            builder.setTitle(str);
                            builder.setMessage(str2);
                            builder.setPositiveButton(SapiWebView.HTTPS_SSL_DATE_INVALID_DIALOG_SET_TIME, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialogInterface, int i2) {
                                    Intent intent = new Intent("android.settings.DATE_SETTINGS");
                                    intent.setFlags(268435456);
                                    SapiWebView.this.getContext().startActivity(intent);
                                    dialogInterface.dismiss();
                                    StatService.onEvent("sslerr_date_setting", (Map<String, String>) null);
                                }
                            });
                            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialogInterface, int i2) {
                                    dialogInterface.dismiss();
                                    StatService.onEvent("sslerr_date_cancel", (Map<String, String>) null);
                                }
                            });
                            Dialog unused = SapiWebView.this.dateInvalidDialog = builder.create();
                        }
                        if (!((Activity) SapiWebView.this.getContext()).isFinishing() && !SapiWebView.this.dateInvalidDialog.isShowing()) {
                            SapiWebView.this.dateInvalidDialog.show();
                        }
                    }
                }
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }

            public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                String access$400 = SapiWebView.TAG;
                Log.d(access$400, "onRenderProcessGone: " + renderProcessGoneDetail.toString());
                return true;
            }

            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                if (Build.VERSION.SDK_INT >= 21) {
                    try {
                        Log.d(SapiWebView.TAG, "shouldInterceptRequest: ", webResourceRequest.getUrl().toString());
                        if (webResourceRequest.getUrl().toString().contains(SapiWebView.CUSTOM_CSS_INTERPRETER_URL)) {
                            String str = SapiAccountManager.getInstance().getSapiConfiguration().skin;
                            if (!TextUtils.isEmpty(str)) {
                                return new WebResourceResponse("text/css", com.baidu.apollon.heartbeat.a.h, SapiCoreUtil.getCacheInputStream(SapiWebView.this.getContext(), str));
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                String access$400 = SapiWebView.TAG;
                Log.d(access$400, "shouldOverrideUrlLoading: " + str);
                if (str != null) {
                    if (str.startsWith(IWalletLoginListener.LOGIN_TYPE_SMS) || str.startsWith("tel") || str.startsWith("bdscenter")) {
                        try {
                            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                            intent.setFlags(268435456);
                            SapiWebView.this.getContext().startActivity(intent);
                        } catch (Throwable th2) {
                            Log.e(th2);
                        }
                        return true;
                    } else if (str.startsWith("wtloginmqq")) {
                        return true;
                    } else {
                        if (str.startsWith("sapi://")) {
                            return SapiWebView.this.sapiOverrideUrlLoading(webView, str);
                        }
                        if (SapiHost.getHost(SapiHost.ACTION_INTERCEPT_URL).equals(str)) {
                            SapiWebView.this.finish();
                        }
                        if (!(SapiWebView.this.jsCallBacks.bdOauthLoginParams == null || SapiWebView.this.jsCallBacks.bdOauthLoginParams.redirectUrl == null || !str.contains(SapiWebView.this.jsCallBacks.bdOauthLoginParams.redirectUrl))) {
                            SapiWebView.this.jsCallBacks.bdOauthLoginParams.callback.onCallback(str);
                            return true;
                        }
                    }
                }
                if (SapiWebView.this.webviewClientCallback != null) {
                    SapiWebView.this.webviewClientCallback.shouldOverrideUrlLoading(webView, str);
                }
                String access$4002 = SapiWebView.TAG;
                Log.d(access$4002, "shouldOverrideUrlLoading: " + str);
                return super.shouldOverrideUrlLoading(webView, str);
            }

            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                if (Build.VERSION.SDK_INT < 21) {
                    try {
                        Log.d(SapiWebView.TAG, "shouldInterceptRequest: url", str.toString());
                        if (str.contains(SapiWebView.CUSTOM_CSS_INTERPRETER_URL)) {
                            String str2 = SapiAccountManager.getInstance().getSapiConfiguration().skin;
                            if (!TextUtils.isEmpty(str2)) {
                                return new WebResourceResponse("text/css", com.baidu.apollon.heartbeat.a.h, SapiCoreUtil.getCacheInputStream(SapiWebView.this.getContext(), str2));
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
                return super.shouldInterceptRequest(webView, str);
            }
        });
        setWebChromeClient(new WebChromeClient() {
            public void onConsoleMessage(String str, int i2, String str2) {
                Log.d(str + " -- From line " + i2 + " of " + str2, new Object[0]);
                if (SapiWebView.this.webChromeClientCallback != null) {
                    SapiWebView.this.webChromeClientCallback.onConsoleMessage(str, i2, str2);
                }
            }

            public boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
                Context context = webView != null ? webView.getContext() : null;
                if (context == null) {
                    return true;
                }
                if (context instanceof Activity) {
                    Activity activity = (Activity) context;
                    if (Build.VERSION.SDK_INT >= 17 && (activity.isDestroyed() || activity.isFinishing())) {
                        return true;
                    }
                }
                AlertDialog.Builder positiveButton = new AlertDialog.Builder(context).setTitle("JavaScript Message").setMessage(str2).setPositiveButton(NewBindCardEntry.BING_CARD_SUCCESS_MSG, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        jsResult.confirm();
                    }
                });
                positiveButton.setCancelable(false);
                positiveButton.create();
                positiveButton.show();
                return true;
            }

            public boolean onJsPrompt(WebView webView, String str, final String str2, String str3, final JsPromptResult jsPromptResult) {
                if (SapiWebView.this.webChromeClientCallback != null && SapiWebView.this.webChromeClientCallback.isSubClassHandleMessage(str2)) {
                    return SapiWebView.this.webChromeClientCallback.onJsPrompt(webView, str, str2, str3, jsPromptResult);
                }
                Log.i(SapiWebView.TAG, "webview start: onJsPrompt", str2);
                final String[] strArr = {""};
                SapiWebView.this.jsCallBacks.promptResult = jsPromptResult;
                SapiWebView.this.post(new Runnable() {
                    public void run() {
                        Command parse = Command.parse(str2);
                        if (parse != null) {
                            String actionName = parse.getActionName();
                            if (SapiWebView.this.asynJsMehodName.contains(actionName)) {
                                SapiWebView.this.jsCallBacks.promptResult = jsPromptResult;
                            }
                            if (SapiUtil.CHECK_METHOD_SUPPOT.equals(actionName)) {
                                SapiWebView.this.checkCommandList.add(parse);
                            } else {
                                SapiWebView.this.useCommandList.add(parse);
                            }
                            SapiJsInterpreters.AbstractInterpreter interpreter = SapiWebView.this.jsInterpreters.getInterpreter(actionName);
                            if (interpreter != null) {
                                try {
                                    strArr[0] = interpreter.interpret(parse);
                                    String unused = SapiWebView.TAG;
                                    "onJsPrompt run: interpret: " + parse.getActionName();
                                    parse.setEndTime();
                                } catch (Throwable th2) {
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put("errno", 0);
                                        jSONObject.put("msg", "native function error");
                                        strArr[0] = jSONObject.toString();
                                        LinkedHashMap linkedHashMap = new LinkedHashMap(1);
                                        linkedHashMap.put("name", "native_fun_error");
                                        HashMap hashMap = new HashMap(2);
                                        hashMap.put("msg", android.util.Log.getStackTraceString(th2));
                                        hashMap.put("action_name", actionName);
                                        StatService.onEventAutoStatistic(linkedHashMap, hashMap);
                                    } catch (JSONException unused2) {
                                    }
                                }
                            }
                            if (parse.getActionParams().size() > 2 && SapiWebView.PROMPT_ON_CANCEL.equals(parse.getActionParams().get(2))) {
                                Log.d(SapiWebView.TAG, "onJsPrompt actionName:" + actionName + ",cancel: PROMPT_ON_CANCEL");
                                jsPromptResult.cancel();
                            } else if (!SapiWebView.this.asynJsMehodName.contains(actionName)) {
                                Log.d(SapiWebView.TAG, "onJsPrompt actionName:" + actionName + ",confirm " + strArr[0]);
                                jsPromptResult.confirm(strArr[0]);
                            }
                        } else {
                            jsPromptResult.cancel();
                        }
                    }
                });
                return true;
            }

            public void onProgressChanged(WebView webView, int i2) {
                if (SapiWebView.this.progressBar != null) {
                    if (i2 == 100) {
                        SapiWebView.this.progressBar.setVisibility(8);
                    } else {
                        if (SapiWebView.this.progressBar.getVisibility() == 8) {
                            SapiWebView.this.progressBar.setVisibility(0);
                        }
                        SapiWebView.this.progressBar.setProgress(i2);
                    }
                }
                super.onProgressChanged(webView, i2);
            }

            public void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
                if (!TextUtils.isEmpty(str) && !str.contains("http://") && !str.contains("https://") && !str.contains("baidu.com") && SapiWebView.this.jsCallBacks.webViewReceviceTitleCallback != null) {
                    SapiWebView.this.jsCallBacks.webViewReceviceTitleCallback.onTitleChange(str);
                }
            }

            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                if (SapiWebView.this.fileChooserCallback == null) {
                    return true;
                }
                SapiWebView.this.fileChooserCallback.onFileChooserForOSVersion5(valueCallback);
                return true;
            }

            public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
                if (SapiWebView.this.fileChooserCallback != null) {
                    SapiWebView.this.fileChooserCallback.onFileChooser(valueCallback);
                }
            }

            public void openFileChooser(ValueCallback<Uri> valueCallback) {
                if (SapiWebView.this.fileChooserCallback != null) {
                    SapiWebView.this.fileChooserCallback.onFileChooser(valueCallback);
                }
            }

            public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
                if (SapiWebView.this.fileChooserCallback != null) {
                    SapiWebView.this.fileChooserCallback.onFileChooser(valueCallback);
                }
            }
        });
        try {
            resumeTimers();
        } catch (Throwable th2) {
            Log.e(th2);
        }
        StatLoadLogin statLoadLogin2 = statLoadLogin;
        if (statLoadLogin2 != null) {
            statLoadLogin2.tWebviewInitDone = System.currentTimeMillis();
        }
    }

    private boolean isValidPackage() {
        for (String matches : SapiContext.getInstance().getAuthorizedPackagesForUA()) {
            if (getContext().getPackageName().matches(matches)) {
                return true;
            }
        }
        return false;
    }

    private void loadBackupLogin(int i2) {
        String str = addExtras(getLoginBackUrl(), this.extras) + "&loginInitType=" + i2;
        if (this.jsCallBacks.loadExternalWebViewCallback != null) {
            str = str + "&enableExternalWeb=1";
        }
        if (this.configuration.supportFaceLogin) {
            str = str + "&liveAbility=1";
        }
        if (this.configuration.isHideLoginHelpEntrance) {
            str = str + "&hideHelp=1";
        }
        loadUrl(str + URL_HASH_LOGIN_DEGRADE);
    }

    private void loadChinaMobileLogin(int i2, List<PassNameValuePair> list) {
        String str = addExtras(getLoginUrl(), list) + "&loginInitType=" + i2;
        if (this.jsCallBacks.loadExternalWebViewCallback != null) {
            str = str + "&enableExternalWeb=1";
        }
        if (this.configuration.supportFaceLogin) {
            str = str + "&liveAbility=1";
        }
        if (this.configuration.isHideLoginHelpEntrance) {
            str = str + "&hideHelp=1";
        }
        loadUrl(str + URL_HASH_CHINA_MOBILE_OAUTH);
    }

    private void loadFaceLogin(List<PassNameValuePair> list) {
        String addExtras = addExtras(getLoginUrl(), list);
        if (this.jsCallBacks.loadExternalWebViewCallback != null) {
            addExtras = addExtras + "&enableExternalWeb=1";
        }
        if (this.configuration.isHideLoginHelpEntrance) {
            addExtras = addExtras + "&hideHelp=1";
        }
        loadUrl((addExtras + "&liveAbility=1") + URL_HASH_FACE_LOGIN);
    }

    private void loadJoinLogin(List<PassNameValuePair> list) {
        String addExtras = addExtras(getLoginUrl(), list);
        if (this.jsCallBacks.loadExternalWebViewCallback != null) {
            addExtras = addExtras + "&enableExternalWeb=1";
        }
        if (this.configuration.supportFaceLogin) {
            addExtras = addExtras + "&liveAbility=1";
        }
        if (this.configuration.isHideLoginHelpEntrance) {
            addExtras = addExtras + "&hideHelp=1";
        }
        loadUrl(addExtras + URL_HASH_JOIN_LOGIN);
    }

    private void loadNameLogin(int i2) {
        String str = addExtras(getLoginUrl(), this.extras) + "&loginInitType=" + i2;
        if (this.jsCallBacks.loadExternalWebViewCallback != null) {
            str = str + "&enableExternalWeb=1";
        }
        if (this.configuration.supportFaceLogin) {
            str = str + "&liveAbility=1";
        }
        if (this.configuration.isHideLoginHelpEntrance) {
            str = str + "&hideHelp=1";
        }
        loadUrl(str + URL_HASH_INSERT_LOGIN);
    }

    private void loadNormalLogin(int i2, List<PassNameValuePair> list) {
        String str = addExtras(getLoginUrl(), list) + "&loginInitType=" + i2;
        if (i2 == 0) {
            if (this.jsCallBacks.loadExternalWebViewCallback != null) {
                str = str + "&enableExternalWeb=1";
            }
            if (this.configuration.supportFaceLogin) {
                str = str + "&liveAbility=1";
            }
            if (this.configuration.isHideLoginHelpEntrance) {
                str = str + "&hideHelp=1";
            }
            loadUrl(str + URL_HASH_LOGIN);
        } else if (i2 != 1) {
            loadUrl(str + URL_HASH_LOGIN);
        } else {
            if (this.jsCallBacks.loadExternalWebViewCallback != null) {
                str = str + "&enableExternalWeb=1";
            }
            if (this.configuration.supportFaceLogin) {
                str = str + "&liveAbility=1";
            }
            if (this.configuration.isHideLoginHelpEntrance) {
                str = str + "&hideHelp=1";
            }
            loadUrl(str + URL_HASH_SMS_LOGIN);
        }
    }

    private void loadPasswordLogin(int i2) {
        String str = addExtras(getLoginUrl(), this.extras) + "&loginInitType=" + i2;
        if (this.jsCallBacks.loadExternalWebViewCallback != null) {
            str = str + "&enableExternalWeb=1";
        }
        if (this.configuration.supportFaceLogin) {
            str = str + "&liveAbility=1";
        }
        if (this.configuration.isHideLoginHelpEntrance) {
            str = str + "&hideHelp=1";
        }
        loadUrl(str + URL_HASH_PASSWORD_LOGIN);
    }

    private void loadShareAccounts(int i2, List<PassNameValuePair> list) {
        String str;
        String loginUrl = getLoginUrl();
        if (this.jsCallBacks.loadExternalWebViewCallback != null) {
            loginUrl = loginUrl + "&enableExternalWeb=1";
        }
        if (this.configuration.supportFaceLogin) {
            loginUrl = loginUrl + "&liveAbility=1";
        }
        if (this.configuration.isHideLoginHelpEntrance) {
            loginUrl = loginUrl + "&hideHelp=1";
        }
        if (this.isSupFaceLogin && this.jsCallBacks.biometricsIdentifyCallback != null) {
            str = loginUrl + "&loginInitType=4";
        } else if (new OneKeyLoginSdkCall().checkSupOauth()) {
            str = loginUrl + "&loginInitType=5";
        } else {
            str = loginUrl + "&loginInitType=" + i2;
        }
        loadUrl(addExtras(str, list) + URL_HASH_SHARE);
    }

    private void loadUrlFromNetwork(final String str) {
        post(new Runnable() {
            public void run() {
                if (!SapiWebView.this.isDestory) {
                    String access$3700 = SapiWebView.this.fixAdapterParamValue(str);
                    String access$400 = SapiWebView.TAG;
                    Log.w(access$400, "loadUrlFromNetwork - run: " + access$3700);
                    SapiWebView.this.statLoadLogin(access$3700, false);
                    SapiWebView.super.loadUrl(access$3700);
                }
            }
        });
        if (!SapiUtils.hasActiveNetwork(getContext()) && !str.startsWith("javascript:")) {
            handleNetworkUnavailable();
        }
    }

    public static SocialResponse parseOpenApiAuthorizedResult(String str, Context context) {
        SocialResponse socialResponse;
        String matcher = getMatcher("<client>([\\S\\s]*?)</client>", str);
        SocialResponse socialResponse2 = null;
        if (TextUtils.isEmpty(matcher)) {
            return null;
        }
        try {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(new ByteArrayInputStream(matcher.getBytes()), "UTF-8");
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    Log.d(TAG, "parseOpenApiAuthorizedResult: start:", name);
                    if (!name.equalsIgnoreCase("data")) {
                        if (socialResponse2 == null) {
                            if (name.equalsIgnoreCase(WXLoginActivity.y)) {
                                socialResponse = new SocialResponse();
                                try {
                                    socialResponse.errorCode = Integer.parseInt(newPullParser.nextText());
                                } catch (Exception e) {
                                    Exception exc = e;
                                    socialResponse2 = socialResponse;
                                    e = exc;
                                }
                            }
                        }
                        if (socialResponse2 == null) {
                            if (name.equalsIgnoreCase("error_description")) {
                                socialResponse = new SocialResponse();
                                socialResponse.errorMsg = newPullParser.nextText();
                            }
                        }
                        if (socialResponse2 != null) {
                            if (name.equalsIgnoreCase(WXLoginActivity.y)) {
                                socialResponse2.errorCode = Integer.parseInt(newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("error_description")) {
                                socialResponse2.errorMsg = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("is_binded")) {
                                socialResponse2.isBinded = "1".equals(newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("display_name")) {
                                socialResponse2.displayname = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("passport_uname")) {
                                socialResponse2.username = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("bduid")) {
                                socialResponse2.uid = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("bduss")) {
                                socialResponse2.bduss = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("ptoken")) {
                                socialResponse2.ptoken = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("os_username")) {
                                String nextText = newPullParser.nextText();
                                socialResponse2.socialUname = nextText;
                                socialResponse2.socialNickname = nextText;
                            } else if (name.equalsIgnoreCase("os_headurl")) {
                                socialResponse2.socialPortraitUrl = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("os_openid")) {
                                socialResponse2.openid = newPullParser.nextText();
                                String str2 = TAG;
                                Log.d(str2, "parseOpenApiAuthorizedResult: openid:" + socialResponse2.openid);
                            } else if (name.equalsIgnoreCase("os_name")) {
                                socialResponse2.socialNickname = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("os_type")) {
                                socialResponse2.socialType = SocialType.getSocialType(Integer.parseInt(newPullParser.nextText()));
                            } else if (name.equalsIgnoreCase("notice_offline")) {
                                socialResponse2.offlineNotice = "1".equals(newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("guidebind")) {
                                socialResponse2.bindGuide = "1".equals(newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("bind_conflict")) {
                                socialResponse2.bindConflict = "1".equals(newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("wapsec")) {
                                socialResponse2.accountCenterFlag = "center".equals(newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("next_url_related")) {
                                String nextText2 = newPullParser.nextText();
                                if (socialResponse2.accountCenterFlag) {
                                    socialResponse2.nextUrl = nextText2;
                                }
                            } else if (name.equalsIgnoreCase("incomplete_user")) {
                                String nextText3 = newPullParser.nextText();
                                if ("0".equals(nextText3)) {
                                    socialResponse2.accountType = AccountType.NORMAL;
                                } else if ("1".equals(nextText3)) {
                                    socialResponse2.accountType = AccountType.INCOMPLETE_USER;
                                } else {
                                    socialResponse2.accountType = AccountType.UNKNOWN;
                                }
                            } else if (name.equalsIgnoreCase("stoken")) {
                                String[] split = newPullParser.nextText().split(Bank.HOT_BANK_LETTER);
                                socialResponse2.tplStokenMap.put(split[0], split[1]);
                            } else if (name.equalsIgnoreCase("actiontype")) {
                                socialResponse2.actionType = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase(SapiAccount.SAPI_ACCOUNT_FROMTYPE)) {
                                socialResponse2.fromType = FromType.getFromType(newPullParser.nextText());
                            } else if (name.equals("livinguname")) {
                                socialResponse2.livingUname = URLDecoder.decode(newPullParser.nextText());
                            } else if (name.equals("guest_account")) {
                                socialResponse2.isGuestAccount = newPullParser.nextText();
                            }
                        }
                    } else if (socialResponse2 == null) {
                        socialResponse = new SocialResponse();
                    }
                    socialResponse2 = socialResponse;
                } else if (eventType == 3) {
                    Log.d(TAG, "parseOpenApiAuthorizedResult: end:");
                }
            }
        } catch (Exception e2) {
            e = e2;
            Log.e(TAG, "parseOpenApiAuthorizedResult: Exception:", e);
            return socialResponse2;
        }
        return socialResponse2;
    }

    public static String replaceParams(String str, String str2, String str3) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                int indexOf = str.indexOf(str2 + "=");
                if (indexOf == -1) {
                    return str;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(str.substring(0, indexOf));
                sb.append(str2);
                sb.append("=");
                sb.append(str3);
                int indexOf2 = str.indexOf(a.n, indexOf);
                if (indexOf2 != -1) {
                    sb.append(str.substring(indexOf2));
                } else {
                    int indexOf3 = str.indexOf(Bank.HOT_BANK_LETTER, indexOf);
                    if (indexOf3 != -1) {
                        sb.append(str.substring(indexOf3));
                    }
                }
                return sb.toString();
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
        return str;
    }

    private void sendStat() {
        String str;
        String str2;
        Object obj;
        String str3;
        int i2;
        String str4;
        String str5;
        int i3;
        String str6;
        int i4;
        String str7;
        String str8;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<BaseCommand> it = this.useCommandList.iterator();
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            boolean hasNext = it.hasNext();
            str = "1";
            str2 = Http2ExchangeCodec.UPGRADE;
            if (!hasNext) {
                break;
            }
            BaseCommand next = it.next();
            HashMap hashMap = new HashMap();
            hashMap.put("name", next.actionName);
            if (!next.isUpgrade) {
                str = "0";
            }
            hashMap.put(str2, str);
            if (next.isUpgrade) {
                i7 += Integer.valueOf(next.getDurtime()).intValue();
                i6++;
            }
            i8 += Integer.valueOf(next.getDurtime()).intValue();
            hashMap.put("dur", next.getDurtime());
            hashMap.put("errno", next.errno);
            if (!"0".equals(next.errno)) {
                hashMap.put("cmd", next.originCommand);
                i5++;
            }
            arrayList.add(hashMap);
        }
        if (this.useCommandList.size() <= 0 || i5 <= 0) {
            obj = "errno";
            str3 = "0";
        } else {
            obj = "errno";
            str3 = String.format("%.4f", new Object[]{Double.valueOf((((double) i5) * 1.0d) / ((double) this.useCommandList.size()))});
        }
        if (this.useCommandList.size() <= 0 || i6 <= 0) {
            i2 = i8;
            str4 = "0";
        } else {
            i2 = i8;
            str4 = String.format("%.4f", new Object[]{Double.valueOf((((double) i6) * 1.0d) / ((double) this.useCommandList.size()))});
        }
        Iterator<BaseCommand> it2 = this.checkCommandList.iterator();
        int i9 = 0;
        int i10 = 0;
        while (it2.hasNext()) {
            BaseCommand next2 = it2.next();
            Iterator<BaseCommand> it3 = it2;
            HashMap hashMap2 = new HashMap();
            String str9 = str;
            if (next2.isUpgrade) {
                str8 = str9;
            } else {
                str8 = "0";
            }
            hashMap2.put(str2, str8);
            String str10 = str2;
            hashMap2.put(obj, next2.errno);
            hashMap2.put("params", next2.getActionParams().toString());
            arrayList2.add(hashMap2);
            if ("0".equals(next2.errno)) {
                i9++;
            } else if ("2".equals(next2.errno)) {
                i10++;
            }
            it2 = it3;
            str = str9;
            str2 = str10;
        }
        if (this.checkCommandList.size() <= 0 || i9 <= 0) {
            i3 = i9;
            str5 = "0";
            str6 = str5;
        } else {
            str5 = "0";
            i3 = i9;
            str6 = String.format("%.4f", new Object[]{Double.valueOf((((double) i9) * 1.0d) / ((double) this.checkCommandList.size()))});
        }
        if (this.checkCommandList.size() <= 0 || i6 <= 0) {
            i4 = i10;
            str7 = str5;
        } else {
            i4 = i10;
            str7 = String.format("%.4f", new Object[]{Double.valueOf((((double) i6) * 1.0d) / ((double) this.checkCommandList.size()))});
        }
        HashMap hashMap3 = new HashMap();
        JSONArray jSONArray = new JSONArray(arrayList);
        JSONArray jSONArray2 = new JSONArray(arrayList2);
        hashMap3.put(e.s, jSONArray.toString());
        hashMap3.put("check", jSONArray2.toString());
        hashMap3.put("opt_total_duration", String.valueOf(i7));
        hashMap3.put("opt_total_count", String.valueOf(i6));
        hashMap3.put("method_fail_rate", str3);
        hashMap3.put("method_opt_rate", str4);
        hashMap3.put("check_fail_rate", str6);
        hashMap3.put("check_opt_rate", str7);
        hashMap3.put("total_duration", String.valueOf(i2));
        hashMap3.put("method_total_count", String.valueOf(this.useCommandList.size()));
        hashMap3.put("check_total_count", String.valueOf(this.checkCommandList.size()));
        hashMap3.put("check_opt_count", String.valueOf(i4));
        hashMap3.put("method_fail_count", String.valueOf(i5));
        hashMap3.put("check_fail_count", String.valueOf(i3));
        HashMap hashMap4 = new HashMap();
        hashMap4.put("opt_total_duration", String.valueOf(i7));
        hashMap4.put("opt_total_count", String.valueOf(i6));
        hashMap4.put("method_fail_rate", str3);
        hashMap4.put("method_opt_rate", str4);
        hashMap4.put("check_fail_rate", str6);
        Object obj2 = "check_opt_rate";
        hashMap4.put(obj2, str7);
        StatService.onEventAutoStatExt("client_method_opt", hashMap3, hashMap4, getContext());
    }

    private void setAsynJsMehodName() {
        ArrayList arrayList = new ArrayList();
        this.asynJsMehodName = arrayList;
        arrayList.add("sapi_action_pick_image");
        this.asynJsMehodName.add("sapi_action_pick_date");
        this.asynJsMehodName.add("sapi_action_show_loading");
        this.asynJsMehodName.add("sapi_action_third_safety_verification");
        this.asynJsMehodName.add("sapi_biometrics_identification");
        this.asynJsMehodName.add("sapi_biometrics_identification_no_bduss");
        this.asynJsMehodName.add("sapi_biometrics_identification_with_authtoken");
        this.asynJsMehodName.add("sapi_biometrics_identification_with_uid");
        this.asynJsMehodName.add("sapi_action_sc_app_invoke");
        this.asynJsMehodName.add("oauth_sso_hash");
        this.asynJsMehodName.add("sapi_action_china_mobile_oauth");
        this.asynJsMehodName.add("address_manage_get_contact");
        this.asynJsMehodName.add("touchid_open_guide");
        this.asynJsMehodName.add("touchid_change_status");
        this.asynJsMehodName.add("touchid_login");
        this.asynJsMehodName.add("speech_recognition_get_content");
        this.asynJsMehodName.add("sapi_onekey_oauth_token");
        this.asynJsMehodName.add("sapi_biometrics_identification_live");
        this.asynJsMehodName.add("sapi_idcard_ocr_image");
        this.asynJsMehodName.add("get_all_client_accounts");
        this.asynJsMehodName.add("sapi_action_open_du_vip");
        this.asynJsMehodName.add("sapi_action_id_card_read");
    }

    /* access modifiers changed from: private */
    public void statLoadLogin(String str, boolean z) {
        if (statLoadLogin != null) {
            if (str.contains(URL_HASH_LOGIN) || str.contains(URL_HASH_SHARE) || str.contains(URL_HASH_JOIN_LOGIN) || str.contains(URL_HASH_FAST_REG) || str.contains(URL_HASH_SMS_LOGIN) || (this.isSupFaceLogin && str.contains(URL_HASH_FACE_LOGIN))) {
                statLoadLogin.tLoadLogin = System.currentTimeMillis();
                statLoadLogin.isLoadCache = z;
            }
        }
    }

    private void statStartLogin(String str) {
        if (statLoadLogin != null) {
            if (str.contains(URL_HASH_LOGIN) || str.contains(URL_HASH_SHARE) || str.contains(URL_HASH_JOIN_LOGIN) || str.contains(URL_HASH_FAST_REG) || str.contains(URL_HASH_SMS_LOGIN) || (this.isSupFaceLogin && str.contains(URL_HASH_FACE_LOGIN))) {
                statLoadLogin.tStartLogin = System.currentTimeMillis();
            }
        }
    }

    private void webViewShowLoadingAndDelayHide() {
        setWebViewShowLoading(true);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                SapiWebView.this.setWebViewShowLoading(false);
            }
        }, TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
    }

    public void asyncCommonCookie(List<PassNameValuePair> list) {
        List<PassNameValuePair> buildDeviceInfoCookie = buildDeviceInfoCookie();
        List<PassNameValuePair> buildDarkModeCookie = buildDarkModeCookie();
        if (list != null && !list.isEmpty()) {
            buildDeviceInfoCookie.addAll(list);
        }
        if (buildDarkModeCookie != null && !buildDarkModeCookie.isEmpty()) {
            buildDeviceInfoCookie.addAll(buildDarkModeCookie);
        }
        SapiUtils.syncCookies(getContext(), buildDeviceInfoCookie);
    }

    @TargetApi(8)
    public void asyncNaLifeCycle2H5(ActivityLifeCycle activityLifeCycle) {
        if (!getSettings().getBlockNetworkLoads()) {
            loadUrl(generateJSStr(activityLifeCycle.methodName));
        }
    }

    public void back() {
        View view;
        View view2;
        ProgressBar progressBar2;
        if (this.shouldClose && (progressBar2 = this.progressBar) != null && progressBar2.getVisibility() == 0) {
            Log.d(TAG, "back: 1");
            finish();
        } else if (this.shouldClose && (view2 = this.webviewLoadingView) != null && view2.getVisibility() == 0) {
            Log.d(TAG, "back: 2");
            finish();
        } else if (this.onNewBackCallback == null || this.jsCallBacks.rrLoginResponse != null) {
            Log.d(TAG, "back: 4");
            super.loadUrl(FN_SWITCH_VIEW);
            handleOpenApiAuthorizeResponse(this.jsCallBacks.rrLoginResponse);
        } else {
            Log.d(TAG, "back: 3");
            SapiUtils.hideSoftInput((Activity) getContext());
            this.onNewBackCallback.onBack();
        }
        View view3 = this.noNetworkView;
        if ((view3 != null && view3.getVisibility() == 0) || ((view = this.timeoutView) != null && view.getVisibility() == 0)) {
            Log.d(TAG, "back: 5");
            finish();
        }
    }

    public String buildBindBdussCookie() {
        return SapiUtils.buildBDUSSCookie(this.configuration.environment.getWap().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", ""), "BIND_BDUSS", "");
    }

    public List<PassNameValuePair> buildCommonParams() {
        ArrayList arrayList = new ArrayList();
        if (this.configuration.supportFaceLogin) {
            SapiJsCallBacks.CallBacks callBacks = this.jsCallBacks;
            if (!(callBacks.bioScanFaceCallback == null || callBacks.biometricsIdentifyCallback == null)) {
                arrayList.add(new PassNameValuePair("liveAbility", "1"));
            }
        }
        return arrayList;
    }

    public List<PassNameValuePair> buildDarkModeCookie() {
        boolean isDarkMode = DarkModeUtil.isDarkMode(getContext());
        ArrayList arrayList = new ArrayList();
        String replaceAll = this.configuration.environment.getWap().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
        String replaceAll2 = this.configuration.environment.getURL().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
        if (isDarkMode) {
            arrayList.add(new PassNameValuePair(this.configuration.environment.getWap(), SapiUtils.buildDarkModeCookie(replaceAll, "dark")));
            arrayList.add(new PassNameValuePair(this.configuration.environment.getURL(), SapiUtils.buildDarkModeCookie(replaceAll2, "dark")));
        } else {
            arrayList.add(new PassNameValuePair(this.configuration.environment.getWap(), SapiUtils.buildDarkModeCookie(replaceAll, "light")));
            arrayList.add(new PassNameValuePair(this.configuration.environment.getURL(), SapiUtils.buildDarkModeCookie(replaceAll2, "light")));
        }
        return arrayList;
    }

    public List<PassNameValuePair> buildDeviceInfoCookie() {
        String str;
        List<String> loginCookieDiKeys = SapiContext.getInstance().getSapiOptions().getLoginCookieDiKeys();
        ArrayList arrayList = new ArrayList();
        String str2 = "";
        String replaceAll = this.configuration.environment.getWap().replace("http://", str2).replace("https://", str2).replaceAll("(:[0-9]{1,4})?", str2);
        String replaceAll2 = this.configuration.environment.getURL().replace("http://", str2).replace("https://", str2).replaceAll("(:[0-9]{1,4})?", str2);
        Log.e("APP_VERSION", "wap_pass=" + replaceAll, ", passport=" + replaceAll2);
        if (loginCookieDiKeys.size() != 1 || !loginCookieDiKeys.get(0).equals("di")) {
            str = SapiDeviceInfo.getDiCookieInfo(loginCookieDiKeys);
        } else {
            str = SapiDeviceInfo.getDeviceInfo(SapiEnv.SAPI_CONFIG_URI);
        }
        arrayList.add(new PassNameValuePair(this.configuration.environment.getWap(), SapiUtils.buildDeviceInfoCookie(replaceAll, "DVIF", str == null ? str2 : str)));
        String url = this.configuration.environment.getURL();
        if (str != null) {
            str2 = str;
        }
        arrayList.add(new PassNameValuePair(url, SapiUtils.buildDeviceInfoCookie(replaceAll2, "DVIF", str2)));
        return arrayList;
    }

    public void destroy() {
        super.destroy();
        sendStat();
        this.isDestory = true;
        this.timeoutHandler.removeCallbacks(this.timeoutTask);
        if (Build.VERSION.SDK_INT < 21) {
            CookieSyncManager.getInstance().sync();
        } else {
            CookieManager.getInstance().flush();
        }
    }

    public void dismissProgress() {
        post(new Runnable() {
            public void run() {
                if (SapiWebView.this.progressDialog != null && SapiWebView.this.progressDialog.isShowing()) {
                    try {
                        SapiWebView.this.progressDialog.dismiss();
                    } catch (Throwable th2) {
                        Log.e(th2);
                    }
                }
            }
        });
    }

    public void finish() {
        Log.d(TAG, "finish: ");
        finish("");
    }

    public String getAccountCenterUrl(String str) {
        return SapiAccountManager.getInstance().getAccountService().getAccountCenterUrl(str) + a.n + SapiUtils.createRequestParams(buildCommonParams());
    }

    public String getAddressManageUrl() {
        return SapiAccountManager.getInstance().getAccountService().getAddressManageUrl() + a.n + SapiUtils.createRequestParams(buildCommonParams());
    }

    public String getBindWidgetUrl(BindWidgetAction bindWidgetAction) {
        return SapiAccountManager.getInstance().getAccountService().getBindWidgetUrl(bindWidgetAction) + a.n + SapiUtils.createRequestParams(buildCommonParams());
    }

    public String getCertGuardUrl() {
        return SapiAccountManager.getInstance().getAccountService().getCertGuardUrl() + a.n + SapiUtils.createRequestParams(buildCommonParams());
    }

    public String getChangeUsernameUrl() {
        return SapiAccountManager.getInstance().getAccountService().getChangeUsernameUrl() + a.n + SapiUtils.createRequestParams(buildCommonParams());
    }

    public String getDoubleListUrl() {
        return SapiAccountManager.getInstance().getAccountService().getDoubleListUrl() + a.n + SapiUtils.createRequestParams(buildCommonParams());
    }

    public String getForgetPwdUrl() {
        return SapiAccountManager.getInstance().getAccountService().getForgetPwdUrl() + a.n + SapiUtils.createRequestParams(buildCommonParams());
    }

    public String getHashUrl(String str, String str2) {
        String[] split = str2.split(Bank.HOT_BANK_LETTER);
        if (split.length <= 1) {
            return str2;
        }
        SapiOptions sapiOptions = SapiContext.getInstance().getSapiOptions();
        String cacheModuleId = this.sapiCache.getCacheModuleId(str2);
        String str3 = "";
        if (this.sapiCache.getModuleById(cacheModuleId) != null) {
            String str4 = this.sapiCache.getModuleById(cacheModuleId).hash;
            String rg2 = ad.rg(str.getBytes(), false);
            SapiOptions.Cache cache = sapiOptions.getCache();
            String version = cache != null ? cache.getVersion() : str3;
            if (str4.equals(rg2)) {
                if (!TextUtils.isEmpty(version)) {
                    str3 = str3 + "&passAppVersion=" + version;
                }
                str3 = str3 + "&passAppHash=" + this.sapiCache.getModuleById(cacheModuleId).hash;
            } else {
                str3 = str3 + "&passAppHash=" + ad.rg(str.getBytes(), false);
            }
        }
        return split[0] + str3 + Bank.HOT_BANK_LETTER + split[1];
    }

    public String getInvoiceBuildUrl() {
        return SapiAccountManager.getInstance().getAccountService().getInvoiceBuildUrl() + a.n + SapiUtils.createRequestParams(buildCommonParams());
    }

    public SapiJsCallBacks.CallBacks getJsCallBacks() {
        return this.jsCallBacks;
    }

    public String getLocalPhoneNumber() {
        return "";
    }

    public String getLoginBackUrl() {
        return SapiAccountManager.getInstance().getAccountService().getLoginBackUrl();
    }

    public String getLoginUrl() {
        return SapiAccountManager.getInstance().getAccountService().getLoginUrl();
    }

    public String getNormalizeGuestAccountUrl(SocialType socialType) {
        return SapiAccountManager.getInstance().getAccountService().getNormalizeGuestAccountUrl(socialType) + a.n + SapiUtils.createRequestParams(buildCommonParams());
    }

    public String getPersonalInfoUrl() {
        return SapiAccountManager.getInstance().getAccountService().getPersonalInfoUrl() + a.n + SapiUtils.createRequestParams(buildCommonParams());
    }

    public String getRealnameAuthenticateUrl() {
        return SapiAccountManager.getInstance().getAccountService().getRealnameAuthenticateUrl() + a.n + SapiUtils.createRequestParams(buildCommonParams());
    }

    public String getSwitchAccountUrl() {
        return SapiAccountManager.getInstance().getAccountService().getSwitchAccountUrl() + a.n + SapiUtils.createRequestParams(buildCommonParams());
    }

    public long getTimeoutMillis() {
        return this.timeoutMillis;
    }

    public String getUaInfo() {
        String str = "";
        String str2 = !TextUtils.isEmpty(Build.MODEL) ? Build.MODEL : str;
        if (!TextUtils.isEmpty(Build.VERSION.RELEASE)) {
            str = Build.VERSION.RELEASE;
        }
        String encode = URLEncoder.encode("Sapi_9.10.7.3_Android_" + SapiUtils.getAppName(getContext()) + "_" + SapiUtils.getVersionName(getContext()) + "_" + str2 + "_" + str + "_Sapi");
        if (!isValidPackage() || TextUtils.isEmpty(this.configuration.userAgent)) {
            return encode;
        }
        return encode + " " + this.configuration.userAgent;
    }

    public String getUniteVerifyUrl() {
        return SapiAccountManager.getInstance().getAccountService().getUniteVerifyUrl() + a.n + SapiUtils.createRequestParams(buildCommonParams());
    }

    public void handleAuthorizeResponse(final SapiAccountResponse sapiAccountResponse) {
        String str = TAG;
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder();
        sb.append("handleAuthorizeResponse: ");
        sb.append(sapiAccountResponse != null ? Integer.valueOf(sapiAccountResponse.errorCode) : StringUtil.NULL_STRING);
        objArr[0] = sb.toString();
        Log.d(str, objArr);
        if (sapiAccountResponse != null) {
            final SapiAccount sapiAccountResponseToAccount = sapiAccountResponseToAccount(sapiAccountResponse);
            if (SapiContext.getInstance().mLastLoginType != null) {
                SapiContext.getInstance().setPreLoginType(SapiContext.getInstance().mLastLoginType.getName());
            }
            if (this.jsCallBacks.authorizationListener != null) {
                post(new Runnable() {
                    public void run() {
                        try {
                            SapiWebView.this.jsCallBacks.authorizationListener.beforeSuccess(sapiAccountResponseToAccount);
                        } catch (Throwable th2) {
                            Log.e(th2);
                        }
                        Log.d(SapiWebView.TAG, "run: authorizeSuccess");
                        SapiAccountManager.getInstance().validate(sapiAccountResponseToAccount);
                        SapiWebView.this.authorizeSuccess(sapiAccountResponse.accountType);
                        SapiStatUtil.statShareV1Login(sapiAccountResponseToAccount, SapiWebView.this.extras);
                    }
                });
            }
        }
    }

    public void handleLoginHistoryLogin(final SapiAccount sapiAccount) {
        Log.d(TAG, "handleLoginHistoryLogin: ");
        if (SapiContext.getInstance().mLastLoginType != null) {
            SapiContext.getInstance().setPreLoginType(SapiContext.getInstance().mLastLoginType.getName());
        }
        if (this.jsCallBacks.authorizationListener != null) {
            post(new Runnable() {
                public void run() {
                    try {
                        SapiWebView.this.jsCallBacks.authorizationListener.beforeSuccess(sapiAccount);
                    } catch (Throwable th2) {
                        Log.e(th2);
                    }
                    Log.d(SapiWebView.TAG, "run: handleLoginHistoryLogin");
                    SapiAccountManager.getInstance().validate(sapiAccount);
                    SapiWebView.this.authorizeSuccess(sapiAccount.getAccountType());
                    SapiStatUtil.statShareV1Login(sapiAccount, SapiWebView.this.extras);
                }
            });
        }
    }

    public void handleOpenApiAuthorizeResponse(final SocialResponse socialResponse) {
        int i2;
        String str = TAG;
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder();
        sb.append("handleOpenApiAuthorizeResponse: ");
        sb.append(socialResponse != null ? Integer.valueOf(socialResponse.errorCode) : StringUtil.NULL_STRING);
        objArr[0] = sb.toString();
        Log.d(str, objArr);
        if (socialResponse != null) {
            final SapiAccount sapiAccountResponseToAccount = sapiAccountResponseToAccount(socialResponse);
            if (SapiAccount.isValidAccount(sapiAccountResponseToAccount)) {
                socialResponse.errorCode = 0;
            }
            if (SapiContext.getInstance().mLastLoginType != null) {
                SapiContext.getInstance().setPreLoginType(SapiContext.getInstance().mLastLoginType.getName());
            }
            if (socialResponse.accountCenterFlag && ((i2 = socialResponse.errorCode) == 0 || i2 == 110000)) {
                post(new Runnable() {
                    public void run() {
                        String access$400 = SapiWebView.TAG;
                        Log.d(access$400, "run: + nextUrl" + socialResponse.nextUrl);
                        SapiWebView.this.loadUrl(socialResponse.nextUrl);
                        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                        SapiAccountManager.getInstance().validate(sapiAccountResponseToAccount);
                        if (SapiWebView.this.accountChangeCallback != null && !currentAccount.uid.equals(sapiAccountResponseToAccount.uid)) {
                            SapiWebView.this.accountChangeCallback.onAccountChange();
                        }
                    }
                });
            } else if (this.jsCallBacks.authorizationListener != null) {
                int i3 = socialResponse.errorCode;
                if (i3 == 0 || i3 == 110000) {
                    post(new Runnable() {
                        public void run() {
                            try {
                                if (SapiWebView.this.jsCallBacks.authorizationListener != null) {
                                    SapiWebView.this.jsCallBacks.authorizationListener.beforeSuccess(sapiAccountResponseToAccount);
                                }
                            } catch (Throwable th2) {
                                Log.e(th2);
                            }
                            Log.d(SapiWebView.TAG, "run: authorizeSuccess");
                            SapiAccountManager.getInstance().validate(sapiAccountResponseToAccount);
                            SapiWebView.this.authorizeSuccess(AccountType.UNKNOWN);
                            SapiWebView.this.jsCallBacks.rrLoginResponse = null;
                        }
                    });
                } else {
                    post(new Runnable() {
                        public void run() {
                            if (SapiWebView.this.jsCallBacks.authorizationListener != null) {
                                AuthorizationListener authorizationListener = SapiWebView.this.jsCallBacks.authorizationListener;
                                SocialResponse socialResponse = socialResponse;
                                authorizationListener.onFailed(socialResponse.errorCode, socialResponse.errorMsg);
                            }
                            SapiWebView.this.jsCallBacks.rrLoginResponse = null;
                        }
                    });
                }
            }
        }
    }

    public void hideSoftInput() {
        SapiUtils.hideSoftInput((Activity) getContext());
    }

    public void loadAccountCenter(List<PassNameValuePair> list, String str) {
        loadAccountCenter(list, str, ACCOUNT_CENTER);
    }

    public void loadAccountRealName(String str, String str2, boolean z, String str3, int i2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("okU", SapiHost.getHost(SapiHost.ACTION_INTERCEPT_URL)));
        arrayList.add(new PassNameValuePair("realname_level", String.valueOf(i2)));
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(new PassNameValuePair("scene", str2));
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(new PassNameValuePair("customLink", str3));
        }
        arrayList.add(new PassNameValuePair("needcbkey", z ? "1" : "0"));
        loadAccountCenter(arrayList, str, ACCOUNT_CENTER_REAL_NAME);
    }

    public void loadAddressManage(List<PassNameValuePair> list) {
        loadUrl(addExtras(getAddressManageUrl(), list));
    }

    public void loadAuthWidget(List<PassNameValuePair> list, boolean z) {
        loadUrl(addExtras(SapiAccountManager.getInstance().getAccountService().getAuthWidgetUrl(z), list));
    }

    public void loadBindWidget(BindWidgetAction bindWidgetAction, String str, String str2, boolean z, List<PassNameValuePair> list) {
        if (bindWidgetAction != null) {
            Log.d(TAG, "loadBindWidget: " + bindWidgetAction.getName());
            if (!TextUtils.isEmpty(str)) {
                webLogin(getContext(), str);
                ArrayList arrayList = new ArrayList();
                if (!TextUtils.isEmpty(str2)) {
                    arrayList.add(new PassNameValuePair("skin", str2));
                }
                if (z) {
                    arrayList.add(new PassNameValuePair(RadialViewGroup.SKIP_TAG, "1"));
                }
                if (this.configuration.supportFaceLogin) {
                    arrayList.add(new PassNameValuePair("liveAbility", "1"));
                }
                String bindWidgetUrl = getBindWidgetUrl(bindWidgetAction);
                if (arrayList.size() > 0) {
                    bindWidgetUrl = bindWidgetUrl + a.n + SapiUtils.createRequestParams(arrayList);
                }
                String addExtras = addExtras(bindWidgetUrl, list);
                String buildBindBdussCookie = buildBindBdussCookie();
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(new PassNameValuePair(this.configuration.environment.getWap(), buildBindBdussCookie));
                loadUrl(addExtras, arrayList2);
                return;
            }
            throw new IllegalArgumentException("bduss can't be empty");
        }
        throw new IllegalArgumentException("BindWidgetAction can't be null");
    }

    public void loadCertGuardianUrl(List<PassNameValuePair> list) {
        loadUrl(addExtras(getCertGuardUrl(), list));
    }

    public void loadChangeUsernameUrl(List<PassNameValuePair> list) {
        loadUrl(addExtras(getChangeUsernameUrl(), list));
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (Build.VERSION.SDK_INT > 7) {
            getSettings().setBlockNetworkLoads(true);
        }
        final String str6 = str;
        final String str7 = str2;
        final String str8 = str3;
        final String str9 = str4;
        final String str10 = str5;
        post(new Runnable() {
            public void run() {
                String str;
                if (!SapiWebView.this.isDestory) {
                    String[] split = str6.split(Bank.HOT_BANK_LETTER);
                    if (split.length > 1) {
                        str = split[0] + "&loadDataWithBaseUrl=1" + Bank.HOT_BANK_LETTER + split[1];
                    } else {
                        str = str6 + "&loadDataWithBaseUrl=1";
                    }
                    String str2 = str;
                    Log.w(SapiWebView.TAG, "loadDataWithBaseURL - run: " + str2);
                    SapiWebView.this.statLoadLogin(str6, true);
                    SapiWebView.super.loadDataWithBaseURL(str2, str7, str8, str9, str10);
                }
            }
        });
    }

    public void loadDoubleListUrl(List<PassNameValuePair> list) {
        loadUrl(addExtras(getDoubleListUrl(), list));
    }

    public void loadExternalUrl(String str, List<PassNameValuePair> list) {
        if (!TextUtils.isEmpty(str)) {
            if (!str.contains(BROWSE_MODE_AGREEMENT_HOST)) {
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(new PassNameValuePair("clientfrom", SapiAccountService.DISPLAY_TYPE_NATIVE));
                list.add(new PassNameValuePair("client", SapiDeviceInfo.OS_TYPE));
                list.add(new PassNameValuePair("deliverParams", "1"));
                if (this.configuration.supportFaceLogin) {
                    list.add(new PassNameValuePair("scanface", "1"));
                    list.add(new PassNameValuePair("liveAbility", "1"));
                    list.add(new PassNameValuePair("supFaceLogin", "1"));
                }
                list.add(new PassNameValuePair(SlideActiviy.EXTRA_PARAMS_SLIDE_PAGE, "1"));
                if (this.jsCallBacks.pickPhotoCallback != null && this.configuration.supportPhoto) {
                    list.add(new PassNameValuePair("support_photo", "1"));
                }
                int indexOf = str.indexOf("?");
                if (indexOf > 0) {
                    int i2 = indexOf + 1;
                    str = str.substring(0, i2) + SapiUtils.createRequestParams(list) + a.n + str.substring(i2, str.length());
                } else {
                    str = str + "?" + SapiUtils.createRequestParams(list);
                }
            }
            loadUrl(str);
            return;
        }
        throw new IllegalArgumentException("externalUrl can't be empty");
    }

    public void loadForgetPwd() {
        loadForgetPwd((String) null);
    }

    public void loadHistoryLogin(HistoryLoginCallback historyLoginCallback) {
        this.jsCallBacks.historyLoginCallback = historyLoginCallback;
    }

    public void loadHonorSSOLogin(String str, String str2, String str3, List<PassNameValuePair> list) {
        loadUrl(addExtras(ParamsUtil.getUrlBindHonor(this.configuration, SocialType.HONOR, str, str2, str3), list));
    }

    public void loadHuaWeiSSOLogin(String str, List<PassNameValuePair> list) {
        loadUrl(addExtras(ParamsUtil.getUrlBind(this.configuration, SocialType.HUAWEI, str, (String) null, (String) null), list));
    }

    public void loadInvoiceBuild(List<PassNameValuePair> list) {
        loadUrl(addExtras(getInvoiceBuildUrl(), list));
    }

    public void loadIqiyiBindServer(String str) {
        if (str != null) {
            String str2 = TAG;
            Log.d(str2, "loadIqiyiBindServer: " + str);
            String buildIqiyiCookie = SapiUtils.buildIqiyiCookie(this.configuration.environment.getURL().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", ""), "mkey", Uri.parse(str).getQueryParameter("mkey"));
            ArrayList arrayList = new ArrayList();
            arrayList.add(new PassNameValuePair(this.configuration.environment.getURL(), buildIqiyiCookie));
            loadUrl(str, arrayList);
        }
    }

    public void loadLogin() {
        loadLogin(0, (List<PassNameValuePair>) null);
    }

    public void loadNormalizeGuestAccount(List<PassNameValuePair> list, String str, SocialType socialType) {
        webLogin(getContext(), str);
        loadUrl(addExtras(getNormalizeGuestAccountUrl(socialType), list));
    }

    public void loadPersonalInfoUrl(List<PassNameValuePair> list) {
        loadUrl(addExtras(getPersonalInfoUrl(), list));
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str, boolean z) {
        SapiJsCallBacks.CallBacks callBacks = this.jsCallBacks;
        callBacks.qrLoginCallback = qrLoginCallback;
        callBacks.finishPage = z;
        loadUrl(str + "&suppcheck=1");
    }

    public void loadRealnameAuthenticate(final String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty");
        } else if (!TextUtils.isEmpty(this.configuration.realnameAuthenticateStoken)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("pp");
            SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() {
                public void onFinish() {
                }

                public void onStart() {
                }

                public void onFailure(GetTplStokenResult getTplStokenResult) {
                    if (SapiWebView.this.jsCallBacks.realnameAuthenticateCallback != null) {
                        SapiWebView.this.jsCallBacks.realnameAuthenticateCallback.onFailure();
                    }
                }

                public void onSuccess(GetTplStokenResult getTplStokenResult) {
                    String realnameAuthenticateUrl = SapiWebView.this.getRealnameAuthenticateUrl();
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new PassNameValuePair("bduss", str));
                    arrayList.add(new PassNameValuePair("stoken", getTplStokenResult.tplStokenMap.get("pp")));
                    arrayList.add(new PassNameValuePair("bdstoken", SapiWebView.this.configuration.realnameAuthenticateStoken));
                    SapiWebView.this.loadUrl(realnameAuthenticateUrl + a.n + SapiUtils.createRequestParams(arrayList) + "#idcardverify");
                }
            }, str, arrayList);
        } else {
            throw new IllegalArgumentException("realnameAuthenticateStoken can't be empty");
        }
    }

    public void loadRegist(List<PassNameValuePair> list) {
        String loginUrl = getLoginUrl();
        loadUrl(addExtras(loginUrl, list) + URL_HASH_REG);
    }

    public void loadShareV2Login() {
        loadUrl((SapiAccountManager.getInstance().getAccountService().getWapShareLoginUrl() + "&adapter=3") + URL_HASH_SHARE_OAUTH);
    }

    public void loadSwitchAccount(List<PassNameValuePair> list) {
        loadUrl(addExtras(getSwitchAccountUrl(), list));
    }

    public void loadThirdPartySSOLogin(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Log.d(TAG, "loadThirdPartySSOLogin: ");
        this.isLoadThirdPartyUrl = true;
        this.userInfoXmlContent = str2;
        ArrayList arrayList = new ArrayList();
        String url = this.configuration.environment.getURL();
        arrayList.add(new PassNameValuePair(url, str3));
        arrayList.add(new PassNameValuePair("https://baidu.com", str4));
        arrayList.add(new PassNameValuePair("https://baidu.com", str5));
        arrayList.add(new PassNameValuePair(url, str6));
        arrayList.add(new PassNameValuePair(url, str7));
        loadUrl(str, arrayList);
    }

    public void loadUniteVerify(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(new PassNameValuePair("token", URLEncoder.encode(str, "UTF-8")));
                if (str2 != null) {
                    arrayList.add(new PassNameValuePair("u", str2));
                }
                if (str3 != null) {
                    arrayList.add(new PassNameValuePair("adtext", URLEncoder.encode(str3, "UTF-8")));
                }
            } catch (UnsupportedEncodingException e) {
                Log.e(e);
            }
            String uniteVerifyUrl = getUniteVerifyUrl();
            loadUrl(uniteVerifyUrl + a.n + SapiUtils.createRequestParams(arrayList));
            return;
        }
        throw new IllegalArgumentException("Invalid Params: verifyToken can't be empty");
    }

    public void loadUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = TAG;
            Log.d(str2, "loadUrl: " + str);
            loadUrl(fixAdapterParamValue(str), Collections.emptyList());
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public boolean onKeyUp(int i2) {
        if (i2 != 4 || this.leftBtnIsVisible != 1) {
            return false;
        }
        if (this.onBackCallback != null && this.jsCallBacks.rrLoginResponse == null) {
            Log.d(TAG, "onKeyUp: onBack");
            this.onBackCallback.onBack();
        }
        back();
        return true;
    }

    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        ProgressBar progressBar2 = this.progressBar;
        if (progressBar2 != null) {
            AbsoluteLayout.LayoutParams layoutParams = (AbsoluteLayout.LayoutParams) progressBar2.getLayoutParams();
            layoutParams.x = i2;
            layoutParams.y = i3;
            this.progressBar.setLayoutParams(layoutParams);
        }
        super.onScrollChanged(i2, i3, i4, i5);
    }

    public boolean overScrollBy(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z) {
        View view = this.noNetworkView;
        if (view != null && view.getVisibility() == 0) {
            return false;
        }
        View view2 = this.timeoutView;
        if (view2 == null || view2.getVisibility() != 0) {
            return super.overScrollBy(i2, i3, i4, i5, i6, i7, i8, i9, z);
        }
        return false;
    }

    public SapiAccountResponse parseAuthorizedResult(String str, Context context) {
        SapiAccountResponse sapiAccountResponse;
        String matcher = getMatcher("<client>([\\S\\s]*?)</client>", str);
        SapiAccountResponse sapiAccountResponse2 = null;
        if (TextUtils.isEmpty(matcher)) {
            return null;
        }
        try {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(new ByteArrayInputStream(matcher.getBytes()), "UTF-8");
            int eventType = newPullParser.getEventType();
            boolean z = false;
            while (eventType != 1) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    Log.d(TAG, "parseAuthorizedResult: start:", name);
                    if ("data".equalsIgnoreCase(name)) {
                        if (sapiAccountResponse2 == null) {
                            sapiAccountResponse = new SapiAccountResponse();
                        }
                    } else if (sapiAccountResponse2 != null || !WXLoginActivity.y.equalsIgnoreCase(name)) {
                        if (sapiAccountResponse2 == null) {
                            if ("error_description".equalsIgnoreCase(name)) {
                                sapiAccountResponse = new SapiAccountResponse();
                                sapiAccountResponse.errorMsg = newPullParser.nextText();
                            }
                        }
                        if (sapiAccountResponse2 != null) {
                            if ("errno".equalsIgnoreCase(name)) {
                                sapiAccountResponse2.errorCode = Integer.parseInt(newPullParser.nextText());
                            } else if ("uname".equalsIgnoreCase(name)) {
                                sapiAccountResponse2.username = newPullParser.nextText();
                            } else if ("errmsg".equalsIgnoreCase(name)) {
                                sapiAccountResponse2.errorMsg = newPullParser.nextText();
                            } else if ("bduss".equalsIgnoreCase(name)) {
                                sapiAccountResponse2.bduss = newPullParser.nextText();
                            } else if ("ptoken".equalsIgnoreCase(name)) {
                                sapiAccountResponse2.ptoken = newPullParser.nextText();
                            } else if ("stoken".equalsIgnoreCase(name)) {
                                if (!z) {
                                    sapiAccountResponse2.stoken = newPullParser.nextText();
                                } else {
                                    String[] split = newPullParser.nextText().split(Bank.HOT_BANK_LETTER);
                                    if (split.length > 1) {
                                        sapiAccountResponse2.tplStokenMap.put(split[0], split[1]);
                                    }
                                }
                            } else if ("displayname".equalsIgnoreCase(name)) {
                                sapiAccountResponse2.displayname = newPullParser.nextText();
                            } else if ("uid".equalsIgnoreCase(name)) {
                                sapiAccountResponse2.uid = newPullParser.nextText();
                            } else if ("authsid".equalsIgnoreCase(name)) {
                                String nextText = newPullParser.nextText();
                                sapiAccountResponse2.authSid = nextText;
                                sapiAccountResponse2.newReg = !TextUtils.isEmpty(nextText);
                            } else if ("stoken_list".equalsIgnoreCase(name)) {
                                z = true;
                            } else if ("os_headurl".equalsIgnoreCase(name)) {
                                sapiAccountResponse2.socialPortraitUrl = newPullParser.nextText();
                            } else if ("os_openid".equalsIgnoreCase(name)) {
                                sapiAccountResponse2.openid = newPullParser.nextText();
                                String str2 = TAG;
                                Log.d(str2, "parseAuthorizedResult: openid" + sapiAccountResponse2.openid);
                            } else if ("os_name".equalsIgnoreCase(name)) {
                                sapiAccountResponse2.socialNickname = newPullParser.nextText();
                            } else if ("os_type".equalsIgnoreCase(name)) {
                                sapiAccountResponse2.socialType = SocialType.getSocialType(Integer.parseInt(newPullParser.nextText()));
                            } else if ("incomplete_user".equalsIgnoreCase(name)) {
                                String nextText2 = newPullParser.nextText();
                                if ("0".equals(nextText2)) {
                                    sapiAccountResponse2.accountType = AccountType.NORMAL;
                                } else if ("1".equals(nextText2)) {
                                    sapiAccountResponse2.accountType = AccountType.INCOMPLETE_USER;
                                } else {
                                    sapiAccountResponse2.accountType = AccountType.UNKNOWN;
                                }
                            } else if ("actiontype".equalsIgnoreCase(name)) {
                                sapiAccountResponse2.actionType = newPullParser.nextText();
                            } else if (SapiAccount.SAPI_ACCOUNT_FROMTYPE.equalsIgnoreCase(name)) {
                                sapiAccountResponse2.fromType = FromType.getFromType(newPullParser.nextText());
                            } else if ("livinguname".equals(name)) {
                                sapiAccountResponse2.livingUname = URLDecoder.decode(newPullParser.nextText());
                            } else if (IWalletLoginListener.KEY_LOGIN_TYPE.equals(name)) {
                                String nextText3 = newPullParser.nextText();
                                if ("oneKeyLogin".equals(nextText3)) {
                                    String operatorType = new OneKeyLoginSdkCall().getOperatorType();
                                    if (OneKeyLoginSdkCall.OPERATOR_TYPE_CMCC.equals(operatorType)) {
                                        SapiContext.getInstance().setPreLoginType(Enums.LastLoginType.ONEKEYLOGIN_CM.getName());
                                    } else if (OneKeyLoginSdkCall.OPERATOR_TYPE_CUCC.equals(operatorType)) {
                                        SapiContext.getInstance().setPreLoginType(Enums.LastLoginType.ONEKEYLOGIN_CU.getName());
                                    } else if (OneKeyLoginSdkCall.OPERATOR_TYPE_CTCC.equals(operatorType)) {
                                        SapiContext.getInstance().setPreLoginType(Enums.LastLoginType.ONEKEYLOGIN_CT.getName());
                                    }
                                } else if ("password".equals(nextText3)) {
                                    SapiContext.getInstance().setPreLoginType(Enums.LastLoginType.PWD.getName());
                                } else if ("face".equals(nextText3)) {
                                    SapiContext.getInstance().setPreLoginType(Enums.LastLoginType.FACE.getName());
                                } else if (IWalletLoginListener.LOGIN_TYPE_SMS.equals(nextText3)) {
                                    SapiContext.getInstance().setPreLoginType(Enums.LastLoginType.SMS.getName());
                                }
                            } else if ("mobilephone".equals(name)) {
                                SapiContext.getInstance().putEncryptStr(SapiContext.KEY_LAST_LOGIN_PHONE, newPullParser.nextText());
                            } else if ("app".equals(name)) {
                                sapiAccountResponse2.app = newPullParser.nextText();
                            } else if (SapiAccount.SAPI_ACCOUNT_EXTRA.equals(name)) {
                                sapiAccountResponse2.extra = newPullParser.nextText();
                            } else if (SyncAccountUtils.KEY_PORTRAIT_SIGN.equals(name)) {
                                sapiAccountResponse2.portraitSign = newPullParser.nextText();
                            } else if (SapiAccount.SAPI_ACCOUNT_PORTRAIT.equals(name)) {
                                sapiAccountResponse2.portraitSign = newPullParser.nextText().replace("https://himg.bdimg.com/sys/portrait/item/", "").replace("http://himg.bdimg.com/sys/portrait/item/", "").replace(".jpg", "");
                            } else if ("guest_account".equals(name)) {
                                sapiAccountResponse2.isGuestAccount = newPullParser.nextText();
                            }
                        }
                    } else {
                        sapiAccountResponse = new SapiAccountResponse();
                        try {
                            sapiAccountResponse.errorCode = Integer.parseInt(newPullParser.nextText());
                        } catch (XmlPullParserException e) {
                            SapiAccountResponse sapiAccountResponse3 = sapiAccountResponse;
                            e = e;
                            sapiAccountResponse2 = sapiAccountResponse3;
                        } catch (Throwable th2) {
                            th = th2;
                            sapiAccountResponse2 = sapiAccountResponse;
                            Log.e(TAG, "parseAuthorizedResult: Throwable:", th);
                            sapiAccountResponse2.errorCode = 0;
                            return sapiAccountResponse2;
                        }
                    }
                    sapiAccountResponse2 = sapiAccountResponse;
                } else if (eventType == 3) {
                    try {
                        Log.d(TAG, "parseAuthorizedResult: end:");
                    } catch (XmlPullParserException e2) {
                        e = e2;
                        Log.e(TAG, "parseAuthorizedResult: XmlPullParserException:", e);
                    }
                }
                eventType = newPullParser.next();
            }
        } catch (Throwable th3) {
            th = th3;
        }
        if (sapiAccountResponse2 != null && !TextUtils.isEmpty(sapiAccountResponse2.bduss) && sapiAccountResponse2.errorCode == -100) {
            sapiAccountResponse2.errorCode = 0;
        }
        return sapiAccountResponse2;
    }

    public void preSetUserName(String str) {
        loadUrl("javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.fillLoginNameFn){Pass.client.fillLoginNameFn('" + str + "')}}())");
    }

    public void reload() {
        String str = this.reloadConfig.timeoutUrl;
        if (str != null) {
            loadUrl(str);
        } else {
            super.reload();
        }
        this.reloadConfig.reset();
    }

    public SapiAccount sapiAccountResponseToAccount(SapiAccountResponse sapiAccountResponse) {
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.uid = sapiAccountResponse.uid;
        sapiAccount.bduss = sapiAccountResponse.bduss;
        sapiAccount.displayname = sapiAccountResponse.displayname;
        sapiAccount.stoken = sapiAccountResponse.stoken;
        sapiAccount.ptoken = sapiAccountResponse.ptoken;
        sapiAccount.email = sapiAccountResponse.email;
        sapiAccount.username = sapiAccountResponse.username;
        sapiAccount.app = TextUtils.isEmpty(sapiAccountResponse.app) ? SapiUtils.getAppName(getContext()) : sapiAccountResponse.app;
        sapiAccount.extra = sapiAccountResponse.extra;
        sapiAccount.portrait = sapiAccountResponse.portraitSign;
        sapiAccount.fromType = sapiAccountResponse.fromType.getValue();
        SocialType socialType = SocialType.UNKNOWN;
        SocialType socialType2 = sapiAccountResponse.socialType;
        if (socialType != socialType2) {
            sapiAccount.addSocialInfo(socialType2, sapiAccountResponse.socialPortraitUrl, sapiAccountResponse.socialNickname, sapiAccountResponse.openid);
            sapiAccount.putExtra("account_type", Integer.valueOf(sapiAccountResponse.accountType.getType()));
        }
        sapiAccount.putExtra("tpl", this.configuration.tpl);
        if (!sapiAccountResponse.tplStokenMap.isEmpty()) {
            sapiAccount.addDispersionCertification(sapiAccountResponse.tplStokenMap);
        }
        SapiContext.getInstance().setAccountActionType(sapiAccountResponse.actionType);
        sapiAccount.addIsGuestAccount(sapiAccountResponse.isGuestAccount);
        if (!TextUtils.isEmpty(sapiAccountResponse.livingUname)) {
            new FaceLoginService().syncFaceLoginUID(getContext(), sapiAccountResponse.livingUname);
        }
        return sapiAccount;
    }

    public boolean sapiOverrideUrlLoading(final WebView webView, final String str) {
        final String[] strArr = {""};
        post(new Runnable() {
            public void run() {
                SapiUtil.Command command = null;
                try {
                    command = SapiUtil.Command.parse(URLDecoder.decode(str, "UTF-8"));
                    String access$400 = SapiWebView.TAG;
                    Log.d(access$400, "sapiOverrideUrlLoading + cmd:" + command.originCommand);
                } catch (UnsupportedEncodingException unused) {
                }
                if (command != null) {
                    String actionName = command.getActionName();
                    if (SapiUtil.CHECK_METHOD_SUPPOT.equals(actionName)) {
                        SapiWebView.this.checkCommandList.add(command);
                    } else {
                        SapiWebView.this.useCommandList.add(command);
                    }
                    if (!SapiJsInterpreters.getSupportList().contains(actionName)) {
                        String access$4002 = SapiWebView.TAG;
                        Log.w(access$4002, "sapiOverrideUrlLoading + !contains:" + actionName);
                        return;
                    }
                    SapiUpgradeInterpreters.AbstractInterpreter interpreter = SapiWebView.this.jsUpgradeInterpreters.getInterpreter(actionName);
                    if (interpreter != null) {
                        try {
                            strArr[0] = interpreter.interpret(command);
                            String access$4003 = SapiWebView.TAG;
                            Log.d(access$4003, "sapiOverrideUrlLoading + interpret:" + actionName);
                        } catch (Throwable th2) {
                            String access$4004 = SapiWebView.TAG;
                            Log.e(access$4004, "sapiOverrideUrlLoading + interpretE: " + actionName + " ,msg: " + th2.getMessage());
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("errno", 0);
                                jSONObject.put("msg", "native function error");
                                strArr[0] = jSONObject.toString();
                                LinkedHashMap linkedHashMap = new LinkedHashMap(1);
                                linkedHashMap.put("name", "native_fun_error");
                                HashMap hashMap = new HashMap(2);
                                hashMap.put("msg", android.util.Log.getStackTraceString(th2));
                                hashMap.put("action_name", actionName);
                                StatService.onEventAutoStatistic(linkedHashMap, hashMap);
                            } catch (JSONException unused2) {
                            }
                        }
                    }
                    if (command.getActionParams().size() > 2 && SapiWebView.PROMPT_ON_CANCEL.equals(command.getActionParams().get(2))) {
                        String access$4005 = SapiWebView.TAG;
                        Log.w(access$4005, "sapiOverrideUrlLoading + PROMPT_ON_CANCEL:" + actionName);
                    } else if (!SapiWebView.this.asynJsMehodName.contains(actionName)) {
                        String access$4006 = SapiWebView.TAG;
                        Log.d(access$4006, "sapiOverrideUrlLoading + synJsMehodName:" + actionName);
                        SapiWebView.this.jsCallBacks.evalJavaScript.postResult(webView, strArr[0], command);
                    }
                }
            }
        });
        return true;
    }

    public void scrollTo(int i2, int i3) {
        View view;
        View view2 = this.noNetworkView;
        if ((view2 != null && view2.getVisibility() == 0) || ((view = this.timeoutView) != null && view.getVisibility() == 0)) {
            super.scrollTo(0, 0);
        }
        super.scrollTo(i2, i3);
    }

    public void setAccountChangeCallback(AccountChangeCallback accountChangeCallback2) {
        this.accountChangeCallback = accountChangeCallback2;
    }

    public void setAccountDestoryCallback(AccountDestoryCallback accountDestoryCallback) {
        this.jsCallBacks.accountDestoryCallback = accountDestoryCallback;
    }

    public void setAccountFreezeCallback(AccountFreezeCallback accountFreezeCallback) {
        this.jsCallBacks.accountFreezeCallback = accountFreezeCallback;
    }

    public void setAuthorizationListener(AuthorizationListener authorizationListener) {
        this.jsCallBacks.authorizationListener = authorizationListener;
    }

    public void setBdOauthLoginParams(SapiJsCallBacks.BdOauthLoginParams bdOauthLoginParams) {
        this.jsCallBacks.bdOauthLoginParams = bdOauthLoginParams;
    }

    public void setBdussChangeCallback(BdussChangeCallback bdussChangeCallback) {
        this.jsCallBacks.bdussChangeCallback = bdussChangeCallback;
    }

    public void setBindWidgetCallback(BindWidgetCallback bindWidgetCallback) {
        this.jsCallBacks.bindWidgetCallback = bindWidgetCallback;
    }

    public void setBioScanFaceCallback(BioScanFaceCallback bioScanFaceCallback) {
        this.jsCallBacks.bioScanFaceCallback = bioScanFaceCallback;
    }

    public void setBiometricsIdentificationLiveCallBack(SapiJsCallBacks.BiometricsIdentificationLiveCallBack biometricsIdentificationLiveCallBack) {
        this.jsCallBacks.biometricsIdentificationLiveCallBack = biometricsIdentificationLiveCallBack;
    }

    public void setBiometricsIdentifyCallback(BiometricsIdentifyCallback biometricsIdentifyCallback) {
        this.jsCallBacks.biometricsIdentifyCallback = biometricsIdentifyCallback;
    }

    public void setCertGuardianRusultCallback(SapiJsCallBacks.CertGuardianRusultCallback certGuardianRusultCallback) {
        this.jsCallBacks.certGuardianRusultCallback = certGuardianRusultCallback;
    }

    public void setChangePwdCallback(ChangePwdCallback changePwdCallback2) {
        this.changePwdCallback = changePwdCallback2;
    }

    public void setCoverWebBdussCallback(CoverWebBdussCallback coverWebBdussCallback) {
        this.jsCallBacks.coverWebBdussCallback = coverWebBdussCallback;
    }

    public void setCurrentAccountBdussExpiredCallback(SapiJsCallBacks.CurrentAccountBdussExpiredCallback currentAccountBdussExpiredCallback) {
        this.jsCallBacks.currentAccountBdussExpiredCallback = currentAccountBdussExpiredCallback;
    }

    public void setCustomProtocolCallBack(SapiJsCallBacks.CustomProtocolCallBack customProtocolCallBack) {
        this.jsCallBacks.mCustomProtocolCallBack = customProtocolCallBack;
    }

    public void setDirectedLoginParams(SapiJsCallBacks.DirectedLoginParams directedLoginParams) {
        this.jsCallBacks.directedLoginParams = directedLoginParams;
    }

    public void setEvalJavaScriptCallBack(SapiCallBacks.EvalJavaScript evalJavaScript) {
        this.jsCallBacks.evalJavaScript = evalJavaScript;
    }

    public void setFileChooserCallback(FileChooserCallback fileChooserCallback2) {
        this.fileChooserCallback = fileChooserCallback2;
    }

    public void setFingerprintCallback(SapiJsCallBacks.FingerprintCallback fingerprintCallback) {
        this.jsCallBacks.fingerprintCallback = fingerprintCallback;
    }

    public void setFocusEdittextCoordinateYCallBack(SapiJsCallBacks.FocusEdittextCoordinateYCallBack focusEdittextCoordinateYCallBack) {
        this.jsCallBacks.focusEdittextCoordinateYCallBack = focusEdittextCoordinateYCallBack;
    }

    public void setGetCurrentPageNameCallback(SapiJsCallBacks.GetCurrentPageNameCallback getCurrentPageNameCallback) {
        this.jsCallBacks.getCurrentPageNameCallback = getCurrentPageNameCallback;
    }

    public void setGrantWebCallback(SapiJsCallBacks.GrantWebCallback grantWebCallback) {
        this.jsCallBacks.grantWebCallback = grantWebCallback;
    }

    public void setHadMakeBarHide(boolean z) {
        this.mHadMakeBarHide = z;
    }

    public void setHideSuccessTip(boolean z) {
        this.jsCallBacks.hideSuccessTip = z;
    }

    public void setIdCardNfcCallback(SapiJsCallBacks.IdCardNfcCallback idCardNfcCallback) {
        this.jsCallBacks.mIdCardNfcCallback = idCardNfcCallback;
    }

    public void setIdcardOcrImageCallBack(SapiJsCallBacks.IdcardOcrImageCallBack idcardOcrImageCallBack) {
        this.jsCallBacks.idcardOcrImageCallBack = idcardOcrImageCallBack;
    }

    public void setInvoiceBuildCallback(SapiJsCallBacks.InvoiceBuildCallback invoiceBuildCallback) {
        this.jsCallBacks.invoiceBuildCallback = invoiceBuildCallback;
    }

    public void setInvokeScAppCallback(InvokeScAppCallback invokeScAppCallback) {
        this.jsCallBacks.invokeScAppCallback = invokeScAppCallback;
    }

    public void setIsForbidRecord(SapiJsCallBacks.IsForbidRecordCallBack isForbidRecordCallBack) {
        this.jsCallBacks.isForbidRecordCallBack = isForbidRecordCallBack;
    }

    public void setJoinLoingParams(SapiJsCallBacks.JoinLoginParams joinLoginParams) {
        this.jsCallBacks.joinLoginParams = joinLoginParams;
    }

    public void setJumpToUriCallBack(SapiJsCallBacks.JumpToUriCallBack jumpToUriCallBack) {
        this.jsCallBacks.jumpToUriCallBack = jumpToUriCallBack;
    }

    public void setLeftBtnVisibleCallback(LeftBtnVisibleCallback leftBtnVisibleCallback) {
        this.jsCallBacks.leftBtnVisibleCallback = leftBtnVisibleCallback;
    }

    public void setLoadExternalWebViewCallback(LoadExternalWebViewCallback loadExternalWebViewCallback) {
        this.jsCallBacks.loadExternalWebViewCallback = loadExternalWebViewCallback;
    }

    public void setLoadSlideWebViewCallback(LoadSlideWebViewCallback loadSlideWebViewCallback) {
        this.jsCallBacks.loadSlideWebViewCallback = loadSlideWebViewCallback;
    }

    public void setLocalConfigCallback(LocalConfigCallback localConfigCallback) {
        this.jsCallBacks.localConfigCallback = localConfigCallback;
    }

    public void setLoginStatusChangeCallback(SapiJsCallBacks.LoginStatusChangeCallback loginStatusChangeCallback) {
        this.jsCallBacks.loginStatusChangeCallback = loginStatusChangeCallback;
    }

    public void setMakeVibrateCallBack(SapiJsCallBacks.MakeVibrateCallBack makeVibrateCallBack) {
        this.jsCallBacks.makeVibrateCallBack = makeVibrateCallBack;
    }

    public final void setNoNetworkView(View view) {
        if (this.noNetworkView == null) {
            this.noNetworkView = view;
            view.setVisibility(4);
            addView(this.noNetworkView, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public void setNormalizeGuestAccountCallback(SapiJsCallBacks.NormalizeGuestAccountCallback normalizeGuestAccountCallback, String str) {
        SapiJsCallBacks.CallBacks callBacks = this.jsCallBacks;
        callBacks.normalizeGuestAccountCallback = normalizeGuestAccountCallback;
        callBacks.normalizeGuestAccountDesc = str;
    }

    public void setOnBackCallback(OnBackCallback onBackCallback2) {
        this.onBackCallback = onBackCallback2;
    }

    public void setOnFinishCallback(OnFinishCallback onFinishCallback2) {
        this.onFinishCallback = onFinishCallback2;
    }

    public void setOnLoginAssertLoadSuccessListener(OnLoginAssertLoadSuccessListener onLoginAssertLoadSuccessListener) {
        this.mOnLoginAssertLoadSuccessListener = onLoginAssertLoadSuccessListener;
    }

    public void setOnNewBackCallback(OnNewBackCallback onNewBackCallback2) {
        this.onNewBackCallback = onNewBackCallback2;
    }

    public void setOnSlidePageFinishCallback(OnSlidePageFinishCallback onSlidePageFinishCallback) {
        this.jsCallBacks.onSlidePageFinishCallback = onSlidePageFinishCallback;
    }

    public void setOnUnbindAccountCallback(SapiJsCallBacks.OnUnbindThirdAccountCallback onUnbindThirdAccountCallback) {
        this.jsCallBacks.mOnUnbindThirdAccountCallback = onUnbindThirdAccountCallback;
    }

    public void setOpenCustomerServiceCallBack(SapiJsCallBacks.OpenCustomerServiceCallBack openCustomerServiceCallBack) {
        this.jsCallBacks.mOpenCustomerServiceCallBack = openCustomerServiceCallBack;
    }

    public void setOpenDuVipPayCallback(SapiJsCallBacks.OpenDuVipPayCallback openDuVipPayCallback) {
        this.jsCallBacks.mOpenDuVipPayCallback = openDuVipPayCallback;
    }

    public void setPageStateCallback(SapiJsCallBacks.PageStateCallback pageStateCallback) {
        this.jsCallBacks.pageStateCallback = pageStateCallback;
    }

    public void setPickPhotoCallback(PickPhotoCallback pickPhotoCallback) {
        this.jsCallBacks.pickPhotoCallback = pickPhotoCallback;
    }

    public void setPreFillUserNameCallback(PreFillUserNameCallback preFillUserNameCallback) {
        this.jsCallBacks.prefillUserNameCallback = preFillUserNameCallback;
    }

    public void setProgressBar(ProgressBar progressBar2) {
        if (this.progressBar == null) {
            this.progressBar = progressBar2;
            if (progressBar2 != null) {
                addView(progressBar2);
            }
        }
    }

    public void setRealNameStateCallback(SapiJsCallBacks.RealNameStatusCallback realNameStatusCallback) {
        this.jsCallBacks.realNameStatusCallback = realNameStatusCallback;
    }

    public void setRealNameSubErrorCallback(SapiJsCallBacks.RealNameSubErrorCallback realNameSubErrorCallback) {
        this.jsCallBacks.realNameSubErrorCallback = realNameSubErrorCallback;
    }

    public void setRealnameAuthenticateCallback(RealnameAuthenticateCallback realnameAuthenticateCallback) {
        this.jsCallBacks.realnameAuthenticateCallback = realnameAuthenticateCallback;
    }

    public void setShareAccountClickCallback(ShareAccountClickCallback shareAccountClickCallback) {
        this.jsCallBacks.shareAccountClickCallback = shareAccountClickCallback;
    }

    public void setShareV2LoginParams(SapiJsCallBacks.ShareV2LoginParams shareV2LoginParams) {
        this.jsCallBacks.shareV2LoginParams = shareV2LoginParams;
    }

    public void setSocialLoginHandler(Handler handler) {
        this.jsCallBacks.socialLoginHandler = handler;
    }

    public void setSocialVerificationHandler(Handler handler) {
        this.jsCallBacks.socialVerificationHandler = handler;
    }

    public void setSpeechRecognitionCallback(SapiJsCallBacks.SpeechRecognitionCallback speechRecognitionCallback) {
        this.jsCallBacks.speechRecognitionCallback = speechRecognitionCallback;
    }

    public void setStopSlideWebviewCallback(SapiJsCallBacks.StopSlideWebviewCallback stopSlideWebviewCallback) {
        this.jsCallBacks.stopSlideWebviewCallback = stopSlideWebviewCallback;
    }

    public void setSwitchAccountCallback(SwitchAccountCallback switchAccountCallback) {
        this.jsCallBacks.switchAccountCallback = switchAccountCallback;
    }

    public void setSwitchStyleForCloseBtnAndStatusBarCallBack(SapiJsCallBacks.SwitchStyleForCloseBtnAndStatusBarCallBack switchStyleForCloseBtnAndStatusBarCallBack) {
        this.jsCallBacks.mSwitchStyleForCloseBtnAndStatusBarCallBack = switchStyleForCloseBtnAndStatusBarCallBack;
    }

    public void setSyncAccountCallback(SapiJsCallBacks.SyncAccountCallBack syncAccountCallBack) {
        this.jsCallBacks.mSyncAccountCallBack = syncAccountCallBack;
    }

    public void setTimeoutMillis(long j) {
        this.timeoutMillis = j;
    }

    public final void setTimeoutView(View view) {
        if (this.timeoutView == null) {
            this.timeoutView = view;
            view.setVisibility(4);
            addView(this.timeoutView, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public void setUniteVerifyCallback(UniteVerifyCallback uniteVerifyCallback) {
        this.jsCallBacks.uniteVerifyCallback = uniteVerifyCallback;
    }

    public void setWebChromeClientCallback(WebChromeClientCallback webChromeClientCallback2) {
        this.webChromeClientCallback = webChromeClientCallback2;
    }

    public void setWebViewReceviceTitleCallback(WebViewReceviceTitleCallback webViewReceviceTitleCallback) {
        this.jsCallBacks.webViewReceviceTitleCallback = webViewReceviceTitleCallback;
    }

    public void setWebViewShowLoading(boolean z) {
        View view = this.webviewLoadingView;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public void setWebViewTitleCallback(WebViewTitleCallback webViewTitleCallback) {
        this.jsCallBacks.webViewTitleCallback = webViewTitleCallback;
    }

    public void setWebviewClientCallback(WebviewClientCallback webviewClientCallback2) {
        this.webviewClientCallback = webviewClientCallback2;
    }

    public void setWebviewLoadingView(View view) {
        if (this.webviewLoadingView == null) {
            this.webviewLoadingView = view;
            addView(view, new ViewGroup.LayoutParams(-1, -1));
            webViewShowLoadingAndDelayHide();
        }
    }

    public void setWebviewPageFinishCallback(SapiJsCallBacks.WebviewPageFinishCallback webviewPageFinishCallback) {
        this.jsCallBacks.webviewPageFinishCallback = webviewPageFinishCallback;
    }

    public void showProgress() {
        post(new Runnable() {
            public void run() {
                try {
                    ProgressDialog unused = SapiWebView.this.progressDialog = ProgressDialog.show(SapiWebView.this.getContext(), (CharSequence) null, "加载中...", true);
                } catch (Throwable th2) {
                    Log.e(th2);
                }
            }
        });
    }

    public void stopLoading() {
        try {
            super.stopLoading();
        } catch (NullPointerException unused) {
        }
    }

    public void webLogin(Context context, String str) {
        SapiAccountManager.getInstance().getAccountService().webLogin(context, str);
    }

    public void loadAccountCenter(List<PassNameValuePair> list, String str, String str2) {
        SapiAccountService.asyncStoken2Web(getContext(), str);
        String accountCenterUrl = getAccountCenterUrl(str2);
        if (list == null) {
            list = new ArrayList<>();
        }
        if (this.jsCallBacks.pickPhotoCallback != null && this.configuration.supportPhoto) {
            list.add(new PassNameValuePair("support_photo", "1"));
        }
        if (this.jsCallBacks.biometricsIdentifyCallback != null && this.configuration.supportFaceLogin) {
            list.add(new PassNameValuePair("supFaceLogin", "1"));
        }
        loadUrl(addExtras(accountCenterUrl, list));
    }

    public void loadForgetPwd(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(new PassNameValuePair("u", URLEncoder.encode(SapiHost.getHost(SapiHost.DOMAIN_BAIDU_HTTPS_URL) + "?" + CALLBACK_PARAM_KEY + "=" + ACTION_FORGET_PWD, "UTF-8")));
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(new PassNameValuePair("skin", str));
            }
        } catch (UnsupportedEncodingException e) {
            Log.e(e);
        }
        String forgetPwdUrl = getForgetPwdUrl();
        if (arrayList.size() > 0) {
            forgetPwdUrl = forgetPwdUrl + a.n + SapiUtils.createRequestParams(arrayList);
        }
        loadUrl(forgetPwdUrl);
    }

    public void loadLogin(List<PassNameValuePair> list) {
        loadLogin(0, list);
    }

    public void finish(final String str) {
        post(new Runnable() {
            public void run() {
                if (!SapiWebView.this.isDestory) {
                    SapiUtils.hideSoftInput((Activity) SapiWebView.this.getContext());
                    if (!TextUtils.isEmpty(str)) {
                        SapiWebView sapiWebView = SapiWebView.this;
                        if (!sapiWebView.isAccountTools) {
                            if (sapiWebView.jsCallBacks.onSlidePageFinishCallback != null) {
                                String access$400 = SapiWebView.TAG;
                                Log.d(access$400, "finish: onSlidePageFinishCallback, page: " + str);
                                SapiWebView.this.jsCallBacks.onSlidePageFinishCallback.onFinish(str);
                                return;
                            }
                            return;
                        }
                    }
                    if (SapiWebView.this.onFinishCallback != null) {
                        String access$4002 = SapiWebView.TAG;
                        Log.d(access$4002, "finish: onFinishCallback, page: " + str);
                        SapiWebView.this.onFinishCallback.onFinish();
                    }
                }
            }
        });
    }

    public void loadLogin(int i2, List<PassNameValuePair> list) {
        if (!this.configuration.supportFaceLogin || this.jsCallBacks.biometricsIdentifyCallback != null) {
            StatLoadLogin statLoadLogin2 = statLoadLogin;
            if (statLoadLogin2 != null) {
                statLoadLogin2.tBeforeLogin = System.currentTimeMillis();
            }
            this.extras = list;
            if (10 == i2) {
                loadBackupLogin(i2);
            } else if (list.contains(EXTRA_SUPPORT_DIRECT_LOGIN)) {
                loadNormalLogin(i2, list);
            } else if (4 == i2) {
                loadJoinLogin(list);
            } else if (i2 == 7) {
                loadPasswordLogin(i2);
            } else if (i2 == 6) {
                loadNameLogin(i2);
            } else {
                boolean z = ShareUtils.isInV2ShareDisableWhiteList(this.configuration) && this.shareV2Disable;
                this.shareV2Disable = z;
                if (this.jsCallBacks.shareAccountClickCallback != null && !z) {
                    list.add(new PassNameValuePair(ShareCallPacking.StatModel.KEY_SHARE_VERSION, "2"));
                    loadShareAccounts(i2, list);
                } else if (this.isSupFaceLogin) {
                    loadFaceLogin(list);
                } else if (new OneKeyLoginSdkCall().checkSupOauth()) {
                    loadChinaMobileLogin(i2, list);
                } else {
                    loadNormalLogin(i2, list);
                }
            }
            SapiStatUtil.statLoadLogin((String) null);
            return;
        }
        throw new RuntimeException("face login is support, the biometricsIdentifyCallback can't be null");
    }

    public void loadAuthWidget(List<PassNameValuePair> list) {
        loadUrl(addExtras(SapiAccountManager.getInstance().getAccountService().getAuthWidgetUrl(), list));
    }

    public void loadUrl(String str, List<PassNameValuePair> list) {
        String str2;
        statStartLogin(str);
        if (TextUtils.isEmpty(str) || str.contains("javascript:")) {
            str2 = null;
        } else {
            asyncCommonCookie(list);
            str2 = this.sapiCache.getCacheData(getContext(), str);
        }
        String str3 = str2;
        if (!TextUtils.isEmpty(str3)) {
            String hashUrl = getHashUrl(str3, str);
            loadDataWithBaseURL(hashUrl, str3, DATA_MIME_TYPE, "UTF-8", hashUrl);
            return;
        }
        loadUrlFromNetwork(str);
    }

    public void loadAccountRealName(String str, String str2, boolean z, String str3, int i2, Bundle bundle) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("okU", SapiHost.getHost(SapiHost.ACTION_INTERCEPT_URL)));
        arrayList.add(new PassNameValuePair("realname_level", String.valueOf(i2)));
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(new PassNameValuePair("scene", str2));
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(new PassNameValuePair("customLink", str3));
        }
        arrayList.add(new PassNameValuePair("needcbkey", z ? "1" : "0"));
        if (bundle != null && bundle.size() > 0) {
            for (String str4 : bundle.keySet()) {
                arrayList.add(new PassNameValuePair(str4, bundle.getString(str4)));
            }
        }
        loadAccountCenter(arrayList, str, ACCOUNT_CENTER_REAL_NAME);
    }

    public SapiWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SapiWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init();
    }
}
