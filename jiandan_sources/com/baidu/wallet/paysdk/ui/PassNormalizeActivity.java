package com.baidu.wallet.paysdk.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Xml;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.webmanager.SafeWebView;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.wallet.api.IWalletLoginListener;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.DebugConfig;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.beans.BeanActivity;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.NFCUtil;
import com.baidu.wallet.core.utils.PassUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;

public class PassNormalizeActivity extends BeanActivity {
    public static final int FLAG_PAY_SKD = 1;
    public Activity mContent;
    public SafeWebView mWebView;
    public int type = 0;
    public String url = "";

    public class JavascriptInterfaceImpl implements NoProguard {
        public JavascriptInterfaceImpl() {
        }

        @JavascriptInterface
        public void authorized_response(String str) {
            Map access$100 = PassNormalizeActivity.this.parseAuthorizedResult(str);
            if (access$100 != null) {
                if (!TextUtils.isEmpty((CharSequence) access$100.get("pass_error_code")) && "0".equals(access$100.get("pass_error_code"))) {
                    PassUtil.backNormalized(DxmApplicationContextImpl.getApplicationContext(PassNormalizeActivity.this.mContent), PassNormalizeActivity.this.type, access$100);
                    DXMSdkSAUtils.onEventWithValues("normalizeComplete", Arrays.asList(new String[]{SmsLoginView.f.k}));
                    PassNormalizeActivity.this.finish();
                    return;
                }
                if (!TextUtils.isEmpty((CharSequence) access$100.get("pass_error_msg"))) {
                    GlobalUtils.toast(PassNormalizeActivity.this.mContent, (CharSequence) access$100.get("pass_error_msg"));
                } else {
                    GlobalUtils.toast(PassNormalizeActivity.this.mContent, "账号补全失败");
                }
                String str2 = (String) access$100.get("pass_error_code");
                if (TextUtils.isEmpty(str2)) {
                    str2 = "-12345";
                }
                DXMSdkSAUtils.onEventWithValues("normalizeComplete", Arrays.asList(new String[]{String.valueOf(str2)}));
            }
        }
    }

    public final class a extends SafeWebView.SafeWebViewClient {
        public void onFormResubmission(WebView webView, Message message, Message message2) {
        }

        public void onPageFinished(WebView webView, String str) {
            LogUtil.logd("onPageFinished url=" + str);
            if (PassNormalizeActivity.this.mContent != null) {
                WalletGlobalUtils.safeDismissDialog(PassNormalizeActivity.this, -1);
            }
            String property = DebugConfig.getInstance(PassNormalizeActivity.this.mContent).getProperty("pass_complete_verify", "http://wappass.baidu.com/v2/?bindingret");
            if (str != null && str.startsWith(property)) {
                PassNormalizeActivity.this.mWebView.loadUrl("javascript:window.sapi_obj.authorized_response(document.body.innerHTML);");
            }
            super.onPageFinished(webView, str);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            LogUtil.logd("url=" + str);
            if (str == null || !str.equals("http://www.baidu.com/")) {
                if (PassNormalizeActivity.this.mContent != null) {
                    PassNormalizeActivity passNormalizeActivity = PassNormalizeActivity.this;
                    WalletGlobalUtils.safeShowDialog(passNormalizeActivity, -1, ResUtils.getString(passNormalizeActivity.mContent, "ebpay_loading"));
                }
                super.onPageStarted(webView, str, bitmap);
                return;
            }
            PassUtil.backNormalized(PassNormalizeActivity.this.mContent, PassNormalizeActivity.this.type, (Map<String, String>) null);
            DXMSdkSAUtils.onEventWithValues("normalizeVerify", Arrays.asList(new String[]{QueryResponse.Options.CANCEL}));
            PassNormalizeActivity.this.finish();
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str == null || (!str.startsWith(IWalletLoginListener.LOGIN_TYPE_SMS) && !str.startsWith("tel") && !str.startsWith("bdscenter"))) {
                webView.loadUrl(str);
                return super.shouldOverrideUrlLoading(webView, str);
            }
            try {
                PassNormalizeActivity.this.mContent.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return true;
            } catch (Throwable th2) {
                LogUtil.logd(th2.getMessage());
                return true;
            }
        }

        public a() {
        }
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
    public Map<String, String> parseAuthorizedResult(String str) {
        HashMap hashMap;
        LogUtil.logd("html=" + str);
        String matcher = getMatcher("<client>([\\S\\s]*?)</client>", str);
        HashMap hashMap2 = null;
        if (TextUtils.isEmpty(matcher)) {
            return null;
        }
        try {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(new ByteArrayInputStream(matcher.getBytes()), "UTF-8");
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    if (!name.equalsIgnoreCase("data")) {
                        if (hashMap2 == null) {
                            if (name.equalsIgnoreCase(WXLoginActivity.y)) {
                                hashMap = new HashMap();
                                try {
                                    hashMap.put("pass_error_code", Integer.parseInt(newPullParser.nextText()) + "");
                                } catch (Exception e) {
                                    hashMap2 = hashMap;
                                    e = e;
                                }
                            }
                        }
                        if (hashMap2 == null) {
                            if (name.equalsIgnoreCase("error_description")) {
                                hashMap = new HashMap();
                                hashMap.put("pass_error_code", newPullParser.nextText());
                            }
                        }
                        if (hashMap2 != null) {
                            if (name.equalsIgnoreCase("errno")) {
                                hashMap2.put("pass_error_code", Integer.parseInt(newPullParser.nextText()) + "");
                            } else if (name.equalsIgnoreCase("errmsg")) {
                                hashMap2.put("pass_error_msg", newPullParser.nextText());
                            }
                        }
                    } else if (hashMap2 == null) {
                        hashMap = new HashMap();
                    }
                    hashMap2 = hashMap;
                }
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            return hashMap2;
        }
        return hashMap2;
    }

    public void handleResponse(int i2, Object obj, String str) {
    }

    public void onBackPressed() {
        if (this.mWebView.canGoBack()) {
            this.mWebView.goBack();
            return;
        }
        if (this.type == 1) {
            DXMSdkSAUtils.onEventWithValues("normalizeComplete", Arrays.asList(new String[]{QueryResponse.Options.CANCEL}));
        } else {
            DXMSdkSAUtils.onEventWithValues("normalizeVerify", Arrays.asList(new String[]{QueryResponse.Options.CANCEL}));
        }
        PassUtil.backNormalized(this.mContent, this.type, (Map<String, String>) null);
        finish();
    }

    @SuppressLint({"NewApi", "SetJavaScriptEnabled"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContent = getActivity();
        setFlagPaySdk();
        setContentView(ResUtils.layout(this.mContent, "wallet_base_webview_layout"));
        Intent intent = getIntent();
        if (intent != null) {
            this.url = intent.getStringExtra("normalize_url");
            this.type = intent.getIntExtra("pass_util_type", 0);
            LogUtil.logd("intent url=" + this.url);
        }
        LogUtil.logd("type111=" + this.type);
        if (this.type == 1) {
            DXMSdkSAUtils.onEventWithValues("normalizeComplete", Arrays.asList(new String[]{"open"}));
            initActionBar("ebpay_complete_pass");
        } else {
            DXMSdkSAUtils.onEventWithValues("normalizeVerify", Arrays.asList(new String[]{"open"}));
            initActionBar("ebpay_verify_pass");
        }
        LogUtil.logd("url=" + this.url);
        if (TextUtils.isEmpty(this.url)) {
            finish();
            return;
        }
        SafeWebView safeWebView = (SafeWebView) findViewById(ResUtils.id(this.mContent, "cust_webview"));
        this.mWebView = safeWebView;
        WebSettings settings = safeWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        this.mWebView.setScrollBarStyle(0);
        this.mWebView.clearCache(false);
        this.mWebView.resumeTimers();
        if (Build.VERSION.SDK_INT >= 11) {
            this.mWebView.removeJavascriptInterface("searchBoxJavaBridge_");
            this.mWebView.removeJavascriptInterface("accessibility");
            this.mWebView.removeJavascriptInterface("accessibilityTraversal");
        }
        if (Build.VERSION.SDK_INT <= 18) {
            this.mWebView.getSettings().setSavePassword(false);
        }
        this.mWebView.getSettings().setAllowFileAccess(false);
        this.mWebView.setWebViewClient(new a());
        settings.setMinimumFontSize(settings.getMinimumFontSize() + 8);
        this.mWebView.addJavascriptInterface(new JavascriptInterfaceImpl(), "sapi_obj");
        this.mWebView.loadUrl(this.url);
    }

    public void onPause() {
        super.onPause();
        if (Build.VERSION.SDK_INT >= 10) {
            NFCUtil.getInstance().disableForegroundDispatch(getActivity(), false);
        }
    }

    public void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= 10) {
            NFCUtil.getInstance().enableForegroundDispatch(getActivity(), false);
        }
    }

    public void setFlagPaySdk() {
        this.mFlag |= 1;
    }
}
