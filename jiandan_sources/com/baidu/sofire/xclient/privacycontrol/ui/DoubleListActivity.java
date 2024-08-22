package com.baidu.sofire.xclient.privacycontrol.ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.LinearLayout;
import com.baidu.aiscan.R;
import com.baidu.sofire.ac.F;
import org.json.JSONObject;

public class DoubleListActivity extends Activity {
    public WebView a;
    public LinearLayout b;
    public String c;
    public String d;
    public String e;
    public int f;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            DoubleListActivity doubleListActivity = DoubleListActivity.this;
            if (doubleListActivity.a.canGoBack()) {
                doubleListActivity.a.goBack();
            } else {
                doubleListActivity.finish();
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            DoubleListActivity.this.a.reload();
        }
    }

    public class c {
        public c() {
        }

        @JavascriptInterface
        public void closePage() {
            try {
                DoubleListActivity.this.finish();
            } catch (Throwable unused) {
            }
        }

        @JavascriptInterface
        public void gotoAccountDoubleListPage() {
            try {
                PassportHelper.gotoPassDoubleListPage(DoubleListActivity.this);
            } catch (Throwable unused) {
            }
        }

        @JavascriptInterface
        public void gotoUserCenter() {
            try {
                PassportHelper.gotoUserCenter();
            } catch (Throwable unused) {
            }
        }

        @JavascriptInterface
        public void schemeJump(String str) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    intent.setPackage(DoubleListActivity.this.getPackageName());
                    DoubleListActivity.this.startActivity(intent);
                }
            } catch (Throwable unused) {
            }
        }

        @JavascriptInterface
        public String sendToClient(String str) {
            try {
                return "getValues".equals(new JSONObject(str).optString("type")) ? DoubleListActivity.a(DoubleListActivity.this) : "";
            } catch (Throwable unused) {
                return "";
            }
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x003f */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0047 A[Catch:{ all -> 0x006e }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x005e A[Catch:{ all -> 0x006e }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x005f A[Catch:{ all -> 0x006e }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0069 A[Catch:{ all -> 0x006e }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x006a A[Catch:{ all -> 0x006e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(com.baidu.sofire.xclient.privacycontrol.ui.DoubleListActivity r5) {
        /*
            r5.getClass()
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = "uid"
            java.lang.String r2 = r5.c     // Catch:{ all -> 0x006e }
            java.lang.String r3 = ""
            if (r2 != 0) goto L_0x0011
            r2 = r3
        L_0x0011:
            r0.put(r1, r2)     // Catch:{ all -> 0x006e }
            java.lang.String r1 = "bduss"
            java.lang.String r2 = r5.e     // Catch:{ all -> 0x006e }
            if (r2 != 0) goto L_0x001b
            r2 = r3
        L_0x001b:
            r0.put(r1, r2)     // Catch:{ all -> 0x006e }
            android.content.Context r1 = r5.getApplicationContext()     // Catch:{ all -> 0x006e }
            java.lang.String r2 = com.baidu.sofire.xclient.privacycontrol.f.a.c     // Catch:{ all -> 0x003f }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x003f }
            if (r2 != 0) goto L_0x002b
            goto L_0x003c
        L_0x002b:
            com.baidu.sofire.ac.F r2 = com.baidu.sofire.ac.F.getInstance()     // Catch:{ all -> 0x003f }
            boolean r2 = r2.cp(r1)     // Catch:{ all -> 0x003f }
            if (r2 == 0) goto L_0x003c
            java.lang.String r1 = com.baidu.android.common.util.DeviceId.getCUID(r1)     // Catch:{ all -> 0x003f }
            com.baidu.sofire.xclient.privacycontrol.f.a.c = r1     // Catch:{ all -> 0x003f }
            goto L_0x003f
        L_0x003c:
            java.lang.String r1 = com.baidu.sofire.xclient.privacycontrol.f.a.c     // Catch:{ all -> 0x003f }
            goto L_0x0041
        L_0x003f:
            java.lang.String r1 = com.baidu.sofire.xclient.privacycontrol.f.a.c     // Catch:{ all -> 0x006e }
        L_0x0041:
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x006e }
            if (r2 == 0) goto L_0x004f
            android.content.Context r1 = r5.getApplicationContext()     // Catch:{ all -> 0x006e }
            java.lang.String r1 = com.baidu.sofire.xclient.privacycontrol.f.a.b(r1)     // Catch:{ all -> 0x006e }
        L_0x004f:
            java.lang.String r2 = "cuid"
            if (r1 != 0) goto L_0x0054
            r1 = r3
        L_0x0054:
            r0.put(r2, r1)     // Catch:{ all -> 0x006e }
            java.lang.String r1 = "ispass"
            int r2 = r5.f     // Catch:{ all -> 0x006e }
            r4 = 1
            if (r2 != r4) goto L_0x005f
            goto L_0x0060
        L_0x005f:
            r4 = 2
        L_0x0060:
            r0.put(r1, r4)     // Catch:{ all -> 0x006e }
            java.lang.String r1 = "tokens"
            java.lang.String r5 = r5.d     // Catch:{ all -> 0x006e }
            if (r5 != 0) goto L_0x006a
            goto L_0x006b
        L_0x006a:
            r3 = r5
        L_0x006b:
            r0.put(r1, r3)     // Catch:{ all -> 0x006e }
        L_0x006e:
            java.lang.String r5 = r0.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.xclient.privacycontrol.ui.DoubleListActivity.a(com.baidu.sofire.xclient.privacycontrol.ui.DoubleListActivity):java.lang.String");
    }

    public static void a(Context context, String str, String str2, String str3, int i2) {
        Intent intent = new Intent();
        intent.setPackage(context.getPackageName());
        intent.addFlags(268435456);
        intent.setComponent(new ComponentName(context, DoubleListActivity.class));
        intent.putExtra("uid", str);
        intent.putExtra("param", str3);
        intent.putExtra("bduss", str2);
        intent.putExtra("type", i2);
        context.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.privacy_lib_activity_double_list);
        this.a = (WebView) findViewById(R.id.privacy_web_view);
        this.b = (LinearLayout) findViewById(R.id.layout_retry);
        com.baidu.sofire.xclient.privacycontrol.e.b.c().b(1);
        Intent intent = getIntent();
        this.c = intent.getStringExtra("uid");
        this.f = intent.getIntExtra("type", 1);
        this.d = intent.getStringExtra("param");
        this.e = intent.getStringExtra("bduss");
        if (Build.VERSION.SDK_INT < 17) {
            this.a.removeJavascriptInterface("searchBoxJavaBridge_");
            this.a.removeJavascriptInterface("accessibility");
            this.a.removeJavascriptInterface("accessibilityTraversal");
        }
        this.a.getSettings().setJavaScriptEnabled(true);
        this.a.setWebViewClient(new com.baidu.sofire.xclient.privacycontrol.g.a(this));
        this.a.loadUrl("https://sofire.baidu.com/pr/ui/user.html?zid=" + F.getInstance().gzd(getApplicationContext()) + "&platform=android&appkey=" + com.baidu.sofire.xclient.privacycontrol.f.a.a(getApplicationContext()) + "&v=" + "1.2");
        findViewById(R.id.image_back).setOnClickListener(new a());
        findViewById(R.id.btn_retry).setOnClickListener(new b());
        this.a.addJavascriptInterface(new c(), "mjs");
    }

    public void onDestroy() {
        super.onDestroy();
        try {
            WebView webView = this.a;
            if (webView != null) {
                ViewParent parent = webView.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.a);
                }
                this.a.stopLoading();
                this.a.clearCache(true);
                this.a.clearHistory();
                this.a.removeAllViewsInLayout();
                this.a.removeAllViews();
                this.a.destroy();
                this.a = null;
            }
        } catch (Throwable unused) {
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4 || !this.a.canGoBack()) {
            return super.onKeyDown(i2, keyEvent);
        }
        this.a.goBack();
        return true;
    }
}
