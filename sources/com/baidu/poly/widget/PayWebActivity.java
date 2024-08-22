package com.baidu.poly.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import com.baidu.poly.R;
import com.baidu.poly.widget.CommonDialog;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.swan.apps.pay.panel.PaymentPanelManager;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* compiled from: SearchBox */
public class PayWebActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private WebView f17189a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f17190b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f17191c;

    /* renamed from: d  reason: collision with root package name */
    private String f17192d;

    /* renamed from: e  reason: collision with root package name */
    private Bundle f17193e;

    /* renamed from: f  reason: collision with root package name */
    private Bundle f17194f;

    /* compiled from: SearchBox */
    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view2) {
            PayWebActivity.this.setResult(0);
            PayWebActivity.this.finish();
        }
    }

    private void b() {
        Intent intent = getIntent();
        if (intent != null) {
            this.f17192d = intent.getStringExtra("load_url");
            this.f17193e = intent.getBundleExtra("launch_payment_data");
            this.f17194f = intent.getBundleExtra("user_params");
        }
    }

    private void c() {
        ImageView imageView = (ImageView) findViewById(R.id.iv_pay_back);
        this.f17190b = imageView;
        imageView.setOnClickListener(new a());
        WebView webView = (WebView) findViewById(R.id.webView);
        this.f17189a = webView;
        webView.setVerticalScrollBarEnabled(false);
        this.f17189a.setHorizontalScrollBarEnabled(false);
        this.f17189a.getSettings().setJavaScriptEnabled(true);
        this.f17189a.getSettings().setDomStorageEnabled(true);
        a();
        this.f17189a.setWebViewClient(new b());
        if (!TextUtils.isEmpty(this.f17192d)) {
            this.f17189a.loadUrl(this.f17192d);
        }
    }

    public void onBackPressed() {
        setResult(0);
        finish();
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_pay_web);
        this.f17191c = false;
        b();
        c();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        WebView webView = this.f17189a;
        if (webView != null) {
            webView.loadDataWithBaseURL((String) null, "", "text/html", "utf-8", (String) null);
            this.f17189a.clearHistory();
            ((ViewGroup) this.f17189a.getParent()).removeView(this.f17189a);
            this.f17189a.destroy();
            this.f17189a = null;
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.f17191c) {
            Intent intent = new Intent();
            intent.putExtras(this.f17193e);
            setResult(-1, intent);
            finish();
        }
    }

    public static Intent a(Context context, String str, Bundle bundle, Bundle bundle2) {
        Intent intent = new Intent(context, PayWebActivity.class);
        intent.putExtra("load_url", str);
        intent.putExtra("launch_payment_data", bundle);
        intent.putExtra("user_params", bundle2);
        return intent;
    }

    /* compiled from: SearchBox */
    class b extends WebViewClient {

        /* compiled from: SearchBox */
        class a extends CommonDialog.ButtonViewEntity {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ SslErrorHandler f17197a;

            /* renamed from: com.baidu.poly.widget.PayWebActivity$b$a$a  reason: collision with other inner class name */
            /* compiled from: SearchBox */
            class C0269a implements CommonDialog.OnButtonClinckListener {
                C0269a() {
                }

                public void onClick(Dialog dialog) {
                    SslErrorHandler sslErrorHandler = a.this.f17197a;
                    if (sslErrorHandler != null) {
                        sslErrorHandler.cancel();
                    }
                    dialog.dismiss();
                }
            }

            a(b bVar, SslErrorHandler sslErrorHandler) {
                this.f17197a = sslErrorHandler;
            }

            public String getButtonText() {
                return AccountConstants.PROFESSION_APPROVE_DIALOG_CANCEL_TITLE_DEFAULT;
            }

            public CommonDialog.OnButtonClinckListener getClickListener() {
                return new C0269a();
            }
        }

        /* renamed from: com.baidu.poly.widget.PayWebActivity$b$b  reason: collision with other inner class name */
        /* compiled from: SearchBox */
        class C0270b extends CommonDialog.ButtonViewEntity {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ SslErrorHandler f17199a;

            /* renamed from: com.baidu.poly.widget.PayWebActivity$b$b$a */
            /* compiled from: SearchBox */
            class a implements CommonDialog.OnButtonClinckListener {
                a() {
                }

                public void onClick(Dialog dialog) {
                    SslErrorHandler sslErrorHandler = C0270b.this.f17199a;
                    if (sslErrorHandler != null) {
                        sslErrorHandler.proceed();
                    }
                    dialog.dismiss();
                }
            }

            C0270b(b bVar, SslErrorHandler sslErrorHandler) {
                this.f17199a = sslErrorHandler;
            }

            public String getButtonText() {
                return "确认";
            }

            public CommonDialog.OnButtonClinckListener getClickListener() {
                return new a();
            }
        }

        b() {
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            new CommonDialog.Builder().setTitleText("无效/不受信任的证书").setContentText("您正在访问带有不受信任或无效证书的页面,确认继续吗？").setButtonEntity(new a(this, sslErrorHandler), new C0270b(this, sslErrorHandler)).build(PayWebActivity.this).show();
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            try {
                str = URLDecoder.decode(str, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            return PayWebActivity.this.a(str);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            if (Build.VERSION.SDK_INT < 24) {
                return true;
            }
            String uri = webResourceRequest.getUrl().toString();
            try {
                uri = URLDecoder.decode(uri, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            return PayWebActivity.this.a(uri);
        }
    }

    private void a() {
        WebView webView = this.f17189a;
        if (webView != null && this.f17194f != null) {
            StringBuilder sb = new StringBuilder(webView.getSettings().getUserAgentString());
            String string = this.f17194f.getString("sceneSource");
            if (!TextUtils.isEmpty(string)) {
                sb.append(" ");
                sb.append("sceneSource");
                sb.append("/");
                sb.append(string);
            }
            String string2 = this.f17194f.getString(PaymentPanelManager.PARAM_KEY_SWAN_NATIVE_VERSION);
            if (!TextUtils.isEmpty(string2)) {
                sb.append(" ");
                sb.append(PaymentPanelManager.PARAM_KEY_SWAN_NATIVE_VERSION);
                sb.append("/");
                sb.append(string2);
            }
            sb.append(" ");
            sb.append(com.baidu.poly.app.a.c());
            sb.append("/");
            sb.append(com.baidu.poly.app.a.i());
            this.f17189a.getSettings().setUserAgentString(sb.toString());
        }
    }

    /* access modifiers changed from: private */
    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (str.startsWith("cashier://closewindow")) {
            setResult(0);
            finish();
            return true;
        } else if (URLUtil.isNetworkUrl(str)) {
            return false;
        } else {
            try {
                this.f17191c = str.contains("weixin://");
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                startActivity(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return true;
        }
    }
}
