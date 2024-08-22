package com.alipay.sdk.m.x;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.alipay.sdk.m.u.k;
import com.alipay.sdk.m.u.n;

public class e extends LinearLayout {
    public static Handler m = new Handler(Looper.getMainLooper());
    public ImageView a;
    public TextView b;
    public ImageView c;
    public ProgressBar d;
    public WebView e;
    public final C0023e f;
    public f g;
    public g h;

    /* renamed from: i  reason: collision with root package name */
    public h f689i;
    public final com.alipay.sdk.m.s.a j;
    public View.OnClickListener k;
    public final float l;

    public class a implements View.OnClickListener {

        /* renamed from: com.alipay.sdk.m.x.e$a$a  reason: collision with other inner class name */
        public class C0022a implements Runnable {
            public final /* synthetic */ View a;

            public C0022a(View view) {
                this.a = view;
            }

            public void run() {
                this.a.setEnabled(true);
            }
        }

        public a() {
        }

        public void onClick(View view) {
            h a2 = e.this.f689i;
            if (a2 != null) {
                view.setEnabled(false);
                e.m.postDelayed(new C0022a(view), 256);
                if (view == e.this.a) {
                    a2.b(e.this);
                } else if (view == e.this.c) {
                    a2.a(e.this);
                }
            }
        }
    }

    public class b implements DownloadListener {
        public final /* synthetic */ Context a;

        public b(Context context) {
            this.a = context;
        }

        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.setFlags(268435456);
                this.a.startActivity(intent);
            } catch (Throwable unused) {
            }
        }
    }

    public class c extends WebChromeClient {
        public c() {
        }

        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            return e.this.g.a(e.this, str, str2, str3, jsPromptResult);
        }

        public void onProgressChanged(WebView webView, int i2) {
            if (!e.this.f.b) {
                e.this.d.setVisibility(8);
            } else if (i2 > 90) {
                e.this.d.setVisibility(4);
            } else {
                if (e.this.d.getVisibility() == 4) {
                    e.this.d.setVisibility(0);
                }
                e.this.d.setProgress(i2);
            }
        }

        public void onReceivedTitle(WebView webView, String str) {
            e.this.g.c(e.this, str);
        }
    }

    public class d extends WebViewClient {
        public d() {
        }

        public void onPageFinished(WebView webView, String str) {
            if (!e.this.h.b(e.this, str)) {
                super.onPageFinished(webView, str);
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (!e.this.h.d(e.this, str)) {
                super.onPageFinished(webView, str);
            }
        }

        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            if (!e.this.h.a(e.this, i2, str, str2)) {
                super.onReceivedError(webView, i2, str, str2);
            }
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (!e.this.h.a(e.this, sslErrorHandler, sslError)) {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!e.this.h.a(e.this, str)) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            return true;
        }
    }

    /* renamed from: com.alipay.sdk.m.x.e$e  reason: collision with other inner class name */
    public static final class C0023e {
        public boolean a;
        public boolean b;

        public C0023e(boolean z, boolean z2) {
            this.a = z;
            this.b = z2;
        }
    }

    public interface f {
        boolean a(e eVar, String str, String str2, String str3, JsPromptResult jsPromptResult);

        void c(e eVar, String str);
    }

    public interface g {
        boolean a(e eVar, int i2, String str, String str2);

        boolean a(e eVar, SslErrorHandler sslErrorHandler, SslError sslError);

        boolean a(e eVar, String str);

        boolean b(e eVar, String str);

        boolean d(e eVar, String str);
    }

    public interface h {
        void a(e eVar);

        void b(e eVar);
    }

    public e(Context context, com.alipay.sdk.m.s.a aVar, C0023e eVar) {
        this(context, (AttributeSet) null, aVar, eVar);
    }

    public ImageView getBackButton() {
        return this.a;
    }

    public ProgressBar getProgressbar() {
        return this.d;
    }

    public ImageView getRefreshButton() {
        return this.c;
    }

    public TextView getTitle() {
        return this.b;
    }

    public String getUrl() {
        return this.e.getUrl();
    }

    public WebView getWebView() {
        return this.e;
    }

    public void setChromeProxy(f fVar) {
        this.g = fVar;
        if (fVar == null) {
            this.e.setWebChromeClient((WebChromeClient) null);
        } else {
            this.e.setWebChromeClient(new c());
        }
    }

    public void setWebClientProxy(g gVar) {
        this.h = gVar;
        if (gVar == null) {
            this.e.setWebViewClient((WebViewClient) null);
        } else {
            this.e.setWebViewClient(new d());
        }
    }

    public void setWebEventProxy(h hVar) {
        this.f689i = hVar;
    }

    public e(Context context, AttributeSet attributeSet, com.alipay.sdk.m.s.a aVar, C0023e eVar) {
        super(context, attributeSet);
        this.k = new a();
        this.f = eVar == null ? new C0023e(false, false) : eVar;
        this.j = aVar;
        this.l = context.getResources().getDisplayMetrics().density;
        setOrientation(1);
        a(context);
        b(context);
        c(context);
    }

    private void a(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setBackgroundColor(-218103809);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setVisibility(this.f.a ? 0 : 8);
        ImageView imageView = new ImageView(context);
        this.a = imageView;
        imageView.setOnClickListener(this.k);
        this.a.setScaleType(ImageView.ScaleType.CENTER);
        this.a.setImageDrawable(k.a(k.a, context));
        this.a.setPadding(a(12), 0, a(12), 0);
        linearLayout.addView(this.a, new LinearLayout.LayoutParams(-2, -2));
        View view = new View(context);
        view.setBackgroundColor(-2500135);
        linearLayout.addView(view, new LinearLayout.LayoutParams(a(1), a(25)));
        TextView textView = new TextView(context);
        this.b = textView;
        textView.setTextColor(-15658735);
        this.b.setTextSize(17.0f);
        this.b.setMaxLines(1);
        this.b.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(a(17), 0, 0, 0);
        layoutParams.weight = 1.0f;
        linearLayout.addView(this.b, layoutParams);
        ImageView imageView2 = new ImageView(context);
        this.c = imageView2;
        imageView2.setOnClickListener(this.k);
        this.c.setScaleType(ImageView.ScaleType.CENTER);
        this.c.setImageDrawable(k.a(k.b, context));
        this.c.setPadding(a(12), 0, a(12), 0);
        linearLayout.addView(this.c, new LinearLayout.LayoutParams(-2, -2));
        addView(linearLayout, new LinearLayout.LayoutParams(-1, a(48)));
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0081 */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0091 A[Catch:{ all -> 0x00ac }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(android.content.Context r9) {
        /*
            r8 = this;
            java.lang.String r0 = "accessibilityTraversal"
            java.lang.String r1 = "accessibility"
            java.lang.String r2 = "searchBoxJavaBridge_"
            android.webkit.WebView r3 = new android.webkit.WebView
            r3.<init>(r9)
            r8.e = r3
            r4 = 1
            r3.setVerticalScrollbarOverlay(r4)
            android.webkit.WebView r3 = r8.e
            r8.a((android.webkit.WebView) r3, (android.content.Context) r9)
            android.webkit.WebView r3 = r8.e
            android.webkit.WebSettings r3 = r3.getSettings()
            android.webkit.WebSettings$RenderPriority r5 = android.webkit.WebSettings.RenderPriority.HIGH
            r3.setRenderPriority(r5)
            r3.setSupportMultipleWindows(r4)
            r3.setUseWideViewPort(r4)
            r5 = 5242880(0x500000, double:2.590327E-317)
            r3.setAppCacheMaxSize(r5)
            java.io.File r5 = r9.getCacheDir()
            java.lang.String r5 = r5.getAbsolutePath()
            r3.setAppCachePath(r5)
            r5 = 0
            r3.setAllowFileAccess(r5)
            android.webkit.WebSettings$TextSize r6 = android.webkit.WebSettings.TextSize.NORMAL
            r3.setTextSize(r6)
            int r6 = android.os.Build.VERSION.SDK_INT
            r7 = 16
            if (r6 < r7) goto L_0x004d
            r3.setAllowFileAccessFromFileURLs(r5)
            r3.setAllowUniversalAccessFromFileURLs(r5)
        L_0x004d:
            r3.setAppCacheEnabled(r4)
            r3.setJavaScriptEnabled(r4)
            r3.setSavePassword(r5)
            r3.setJavaScriptCanOpenWindowsAutomatically(r4)
            r3.setCacheMode(r4)
            r3.setDomStorageEnabled(r4)
            r3.setAllowContentAccess(r5)
            android.webkit.WebView r3 = r8.e
            r3.setVerticalScrollbarOverlay(r4)
            android.webkit.WebView r3 = r8.e
            com.alipay.sdk.m.x.e$b r6 = new com.alipay.sdk.m.x.e$b
            r6.<init>(r9)
            r3.setDownloadListener(r6)
            android.webkit.WebView r9 = r8.e     // Catch:{ Exception -> 0x0081 }
            r9.removeJavascriptInterface(r2)     // Catch:{ Exception -> 0x0081 }
            android.webkit.WebView r9 = r8.e     // Catch:{ Exception -> 0x0081 }
            r9.removeJavascriptInterface(r1)     // Catch:{ Exception -> 0x0081 }
            android.webkit.WebView r9 = r8.e     // Catch:{ Exception -> 0x0081 }
            r9.removeJavascriptInterface(r0)     // Catch:{ Exception -> 0x0081 }
            goto L_0x00ac
        L_0x0081:
            android.webkit.WebView r9 = r8.e     // Catch:{ all -> 0x00ac }
            java.lang.Class r9 = r9.getClass()     // Catch:{ all -> 0x00ac }
            java.lang.String r3 = "removeJavascriptInterface"
            java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch:{ all -> 0x00ac }
            java.lang.reflect.Method r9 = r9.getMethod(r3, r6)     // Catch:{ all -> 0x00ac }
            if (r9 == 0) goto L_0x00ac
            android.webkit.WebView r3 = r8.e     // Catch:{ all -> 0x00ac }
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ all -> 0x00ac }
            r6[r5] = r2     // Catch:{ all -> 0x00ac }
            r9.invoke(r3, r6)     // Catch:{ all -> 0x00ac }
            android.webkit.WebView r2 = r8.e     // Catch:{ all -> 0x00ac }
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{ all -> 0x00ac }
            r3[r5] = r1     // Catch:{ all -> 0x00ac }
            r9.invoke(r2, r3)     // Catch:{ all -> 0x00ac }
            android.webkit.WebView r1 = r8.e     // Catch:{ all -> 0x00ac }
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch:{ all -> 0x00ac }
            r2[r5] = r0     // Catch:{ all -> 0x00ac }
            r9.invoke(r1, r2)     // Catch:{ all -> 0x00ac }
        L_0x00ac:
            android.webkit.WebView r9 = r8.e
            com.alipay.sdk.m.x.c.a((android.webkit.WebView) r9)
            android.widget.LinearLayout$LayoutParams r9 = new android.widget.LinearLayout$LayoutParams
            r0 = -1
            r9.<init>(r0, r0)
            android.webkit.WebView r0 = r8.e
            r8.addView(r0, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.x.e.c(android.content.Context):void");
    }

    private void b(Context context) {
        ProgressBar progressBar = new ProgressBar(context, (AttributeSet) null, 16973855);
        this.d = progressBar;
        progressBar.setProgressDrawable(context.getResources().getDrawable(17301612));
        this.d.setMax(100);
        this.d.setBackgroundColor(-218103809);
        addView(this.d, new LinearLayout.LayoutParams(-1, a(2)));
    }

    public void a(WebView webView, Context context) {
        String userAgentString = webView.getSettings().getUserAgentString();
        WebSettings settings = webView.getSettings();
        settings.setUserAgentString(userAgentString + n.g(context));
    }

    public void a(String str) {
        this.e.loadUrl(str);
        c.a(this.e);
    }

    public void a(String str, byte[] bArr) {
        this.e.postUrl(str, bArr);
    }

    public void a() {
        removeAllViews();
        this.e.removeAllViews();
        this.e.setWebViewClient((WebViewClient) null);
        this.e.setWebChromeClient((WebChromeClient) null);
        this.e.destroy();
    }

    private int a(int i2) {
        return (int) (((float) i2) * this.l);
    }
}
