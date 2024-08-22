package com.alipay.sdk.m.x;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import androidx.browser.trusted.sharing.ShareTarget;
import com.alipay.sdk.m.j.d;
import com.alipay.sdk.m.u.n;
import com.alipay.sdk.m.x.e;
import com.baidu.sapi2.views.SmsLoginView;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class d extends c implements e.f, e.g, e.h {
    public static final String A = "action";
    public static final String B = "pushWindow";
    public static final String C = "h5JsFuncCallback";
    public static final String D = "sdkInfo";
    public static final String E = "canUseTaoLogin";
    public static final String F = "taoLogin";
    public static final String l = "sdk_result_code:";
    public static final String m = "alipayjsbridge://";
    public static final String n = "onBack";

    /* renamed from: o  reason: collision with root package name */
    public static final String f687o = "setTitle";
    public static final String p = "onRefresh";
    public static final String q = "showBackButton";
    public static final String r = "onExit";
    public static final String s = "onLoadJs";
    public static final String t = "callNativeFunc";
    public static final String u = "back";
    public static final String v = "title";
    public static final String w = "refresh";
    public static final String x = "backButton";
    public static final String y = "refreshButton";
    public static final String z = "exit";
    public boolean e = true;
    public String f = ShareTarget.METHOD_GET;
    public boolean g = false;
    public final com.alipay.sdk.m.s.a h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f688i;
    public e j = null;
    public f k = new f();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            d.this.a.finish();
        }
    }

    public class b extends e {
        public final /* synthetic */ e a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(e eVar) {
            super((a) null);
            this.a = eVar;
        }

        public void onAnimationEnd(Animation animation) {
            this.a.a();
            boolean unused = d.this.g = false;
        }
    }

    public class c extends e {
        public final /* synthetic */ e a;
        public final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(e eVar, String str) {
            super((a) null);
            this.a = eVar;
            this.b = str;
        }

        public void onAnimationEnd(Animation animation) {
            d.this.removeView(this.a);
            d.this.j.a(this.b);
            boolean unused = d.this.g = false;
        }
    }

    /* renamed from: com.alipay.sdk.m.x.d$d  reason: collision with other inner class name */
    public class C0021d implements Runnable {
        public final /* synthetic */ Activity a;
        public final /* synthetic */ SslErrorHandler b;

        /* renamed from: com.alipay.sdk.m.x.d$d$a */
        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            public void onClick(DialogInterface dialogInterface, int i2) {
                C0021d.this.b.cancel();
                com.alipay.sdk.m.k.a.b(d.this.h, com.alipay.sdk.m.k.b.k, com.alipay.sdk.m.k.b.A, "2");
                com.alipay.sdk.m.j.b.a(com.alipay.sdk.m.j.b.a());
                C0021d.this.a.finish();
            }
        }

        public C0021d(Activity activity, SslErrorHandler sslErrorHandler) {
            this.a = activity;
            this.b = sslErrorHandler;
        }

        public void run() {
            b.a(this.a, "安全警告", "安全连接证书校验无效，将无法保证访问数据的安全性，请安装支付宝后重试。", "确定", new a(), (String) null, (DialogInterface.OnClickListener) null);
        }
    }

    public static abstract class e implements Animation.AnimationListener {
        public e() {
        }

        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    public static class g implements d.a {
        public final f a;
        public final String b;

        public g(f fVar, String str) {
            this.a = fVar;
            this.b = str;
        }

        public void a(boolean z, JSONObject jSONObject, String str) {
            try {
                this.a.a(new JSONObject().put(SmsLoginView.f.k, z).put("random", this.b).put("code", jSONObject).put("status", str));
            } catch (JSONException unused) {
            }
        }
    }

    public d(Activity activity, com.alipay.sdk.m.s.a aVar, String str) {
        super(activity, str);
        this.h = aVar;
        g();
    }

    private synchronized boolean e() {
        if (this.k.b()) {
            this.a.finish();
        } else {
            this.g = true;
            e eVar = this.j;
            this.j = this.k.c();
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(400);
            translateAnimation.setFillAfter(false);
            translateAnimation.setAnimationListener(new b(eVar));
            eVar.setAnimation(translateAnimation);
            removeView(eVar);
            addView(this.j);
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void f() {
        /*
            r3 = this;
            monitor-enter(r3)
            android.app.Activity r0 = r3.a     // Catch:{ all -> 0x001b }
            com.alipay.sdk.m.x.e r1 = r3.j     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x0019
            if (r1 != 0) goto L_0x000a
            goto L_0x0019
        L_0x000a:
            boolean r2 = r3.e     // Catch:{ all -> 0x001b }
            if (r2 == 0) goto L_0x0012
            r0.finish()     // Catch:{ all -> 0x001b }
            goto L_0x0017
        L_0x0012:
            java.lang.String r0 = "javascript:window.AlipayJSBridge.callListener('h5BackAction');"
            r1.a((java.lang.String) r0)     // Catch:{ all -> 0x001b }
        L_0x0017:
            monitor-exit(r3)
            return
        L_0x0019:
            monitor-exit(r3)
            return
        L_0x001b:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.x.d.f():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0035, code lost:
        return false;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean g() {
        /*
            r5 = this;
            monitor-enter(r5)
            com.alipay.sdk.m.x.e$e r0 = new com.alipay.sdk.m.x.e$e     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
            boolean r1 = r5.a()     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
            r2 = 1
            r1 = r1 ^ r2
            boolean r3 = r5.a()     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
            r3 = r3 ^ r2
            r0.<init>(r1, r3)     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
            com.alipay.sdk.m.x.e r1 = new com.alipay.sdk.m.x.e     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
            android.app.Activity r3 = r5.a     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
            com.alipay.sdk.m.s.a r4 = r5.h     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
            r1.<init>(r3, r4, r0)     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
            r5.j = r1     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
            r1.setChromeProxy(r5)     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
            com.alipay.sdk.m.x.e r0 = r5.j     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
            r0.setWebClientProxy(r5)     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
            com.alipay.sdk.m.x.e r0 = r5.j     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
            r0.setWebEventProxy(r5)     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
            com.alipay.sdk.m.x.e r0 = r5.j     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
            r5.addView(r0)     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
            monitor-exit(r5)
            return r2
        L_0x0030:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        L_0x0033:
            r0 = 0
            monitor-exit(r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.x.d.g():boolean");
    }

    private void h() {
        e eVar = this.j;
        if (eVar != null) {
            eVar.getWebView().loadUrl("javascript:(function() {\n    if (window.AlipayJSBridge) {\n        return\n    }\n\n    function alipayjsbridgeFunc(url) {\n        var iframe = document.createElement(\"iframe\");\n        iframe.style.width = \"1px\";\n        iframe.style.height = \"1px\";\n        iframe.style.display = \"none\";\n        iframe.src = url;\n        document.body.appendChild(iframe);\n        setTimeout(function() {\n            document.body.removeChild(iframe)\n        }, 100)\n    }\n    window.alipayjsbridgeSetTitle = function(title) {\n        document.title = title;\n        alipayjsbridgeFunc(\"alipayjsbridge://setTitle?title=\" + encodeURIComponent(title))\n    };\n    window.alipayjsbridgeRefresh = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onRefresh?\")\n    };\n    window.alipayjsbridgeBack = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onBack?\")\n    };\n    window.alipayjsbridgeExit = function(bsucc) {\n        alipayjsbridgeFunc(\"alipayjsbridge://onExit?bsucc=\" + bsucc)\n    };\n    window.alipayjsbridgeShowBackButton = function(bshow) {\n        alipayjsbridgeFunc(\"alipayjsbridge://showBackButton?bshow=\" + bshow)\n    };\n    window.AlipayJSBridge = {\n        version: \"2.0\",\n        addListener: addListener,\n        hasListener: hasListener,\n        callListener: callListener,\n        callNativeFunc: callNativeFunc,\n        callBackFromNativeFunc: callBackFromNativeFunc\n    };\n    var uniqueId = 1;\n    var h5JsCallbackMap = {};\n\n    function iframeCall(paramStr) {\n        setTimeout(function() {\n        \tvar iframe = document.createElement(\"iframe\");\n        \tiframe.style.width = \"1px\";\n        \tiframe.style.height = \"1px\";\n        \tiframe.style.display = \"none\";\n        \tiframe.src = \"alipayjsbridge://callNativeFunc?\" + paramStr;\n        \tvar parent = document.body || document.documentElement;\n        \tparent.appendChild(iframe);\n        \tsetTimeout(function() {\n            \tparent.removeChild(iframe)\n        \t}, 0)\n        }, 0)\n    }\n\n    function callNativeFunc(nativeFuncName, data, h5JsCallback) {\n        var h5JsCallbackId = \"\";\n        if (h5JsCallback) {\n            h5JsCallbackId = \"cb_\" + (uniqueId++) + \"_\" + new Date().getTime();\n            h5JsCallbackMap[h5JsCallbackId] = h5JsCallback\n        }\n        var dataStr = \"\";\n        if (data) {\n            dataStr = encodeURIComponent(JSON.stringify(data))\n        }\n        var paramStr = \"func=\" + nativeFuncName + \"&cbId=\" + h5JsCallbackId + \"&data=\" + dataStr;\n        iframeCall(paramStr)\n    }\n\n    function callBackFromNativeFunc(h5JsCallbackId, data) {\n        var h5JsCallback = h5JsCallbackMap[h5JsCallbackId];\n        if (h5JsCallback) {\n            h5JsCallback(data);\n            delete h5JsCallbackMap[h5JsCallbackId]\n        }\n    }\n    var h5ListenerMap = {};\n\n    function addListener(jsFuncName, jsFunc) {\n        h5ListenerMap[jsFuncName] = jsFunc\n    }\n\n    function hasListener(jsFuncName) {\n        var jsFunc = h5ListenerMap[jsFuncName];\n        if (!jsFunc) {\n            return false\n        }\n        return true\n    }\n\n    function callListener(h5JsFuncName, data, nativeCallbackId) {\n        var responseCallback;\n        if (nativeCallbackId) {\n            responseCallback = function(responseData) {\n                var dataStr = \"\";\n                if (responseData) {\n                    dataStr = encodeURIComponent(JSON.stringify(responseData))\n                }\n                var paramStr = \"func=h5JsFuncCallback\" + \"&cbId=\" + nativeCallbackId + \"&data=\" + dataStr;\n                iframeCall(paramStr)\n            }\n        }\n        var h5JsFunc = h5ListenerMap[h5JsFuncName];\n        if (h5JsFunc) {\n            h5JsFunc(data, responseCallback)\n        } else if (h5JsFuncName == \"h5BackAction\") {\n            if (!window.alipayjsbridgeH5BackAction || !alipayjsbridgeH5BackAction()) {\n                var paramStr = \"func=back\";\n                iframeCall(paramStr)\n            }\n        } else {\n            console.log(\"AlipayJSBridge: no h5JsFunc \" + h5JsFuncName + data)\n        }\n    }\n    var event;\n    if (window.CustomEvent) {\n        event = new CustomEvent(\"alipayjsbridgeready\")\n    } else {\n        event = document.createEvent(\"Event\");\n        event.initEvent(\"alipayjsbridgeready\", true, true)\n    }\n    document.dispatchEvent(event);\n    setTimeout(excuteH5InitFuncs, 0);\n\n    function excuteH5InitFuncs() {\n        if (window.AlipayJSBridgeInitArray) {\n            var h5InitFuncs = window.AlipayJSBridgeInitArray;\n            delete window.AlipayJSBridgeInitArray;\n            for (var i = 0; i < h5InitFuncs.length; i++) {\n                try {\n                    h5InitFuncs[i](AlipayJSBridge)\n                } catch (e) {\n                    setTimeout(function() {\n                        throw e\n                    })\n                }\n            }\n        }\n    }\n})();\n;window.AlipayJSBridge.callListener('h5PageFinished');");
        }
    }

    private synchronized void i() {
        WebView webView = this.j.getWebView();
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            f fVar = this.k;
            if (fVar == null || fVar.b()) {
                a(false);
            } else {
                e();
            }
        }
    }

    public synchronized void c() {
        this.j.a();
        this.k.a();
    }

    public synchronized boolean d(e eVar, String str) {
        com.alipay.sdk.m.s.a aVar = this.h;
        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "h5ld", SystemClock.elapsedRealtime() + "|" + n.i(str));
        if (!TextUtils.isEmpty(str) && !str.endsWith(".apk")) {
            h();
        }
        return false;
    }

    public synchronized boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.g ? true : super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0053, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0061, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean b() {
        /*
            r5 = this;
            monitor-enter(r5)
            android.app.Activity r0 = r5.a     // Catch:{ all -> 0x0062 }
            r1 = 1
            if (r0 != 0) goto L_0x0008
            monitor-exit(r5)
            return r1
        L_0x0008:
            boolean r2 = r5.a()     // Catch:{ all -> 0x0062 }
            if (r2 == 0) goto L_0x0059
            com.alipay.sdk.m.x.e r2 = r5.j     // Catch:{ all -> 0x0062 }
            if (r2 == 0) goto L_0x0054
            android.webkit.WebView r3 = r2.getWebView()     // Catch:{ all -> 0x0062 }
            if (r3 != 0) goto L_0x0019
            goto L_0x0054
        L_0x0019:
            android.webkit.WebView r2 = r2.getWebView()     // Catch:{ all -> 0x0062 }
            boolean r2 = r2.canGoBack()     // Catch:{ all -> 0x0062 }
            if (r2 == 0) goto L_0x0048
            boolean r2 = r5.d()     // Catch:{ all -> 0x0062 }
            if (r2 == 0) goto L_0x0052
            com.alipay.sdk.m.j.c r2 = com.alipay.sdk.m.j.c.NETWORK_ERROR     // Catch:{ all -> 0x0062 }
            int r2 = r2.b()     // Catch:{ all -> 0x0062 }
            com.alipay.sdk.m.j.c r2 = com.alipay.sdk.m.j.c.b(r2)     // Catch:{ all -> 0x0062 }
            int r3 = r2.b()     // Catch:{ all -> 0x0062 }
            java.lang.String r2 = r2.a()     // Catch:{ all -> 0x0062 }
            java.lang.String r4 = ""
            java.lang.String r2 = com.alipay.sdk.m.j.b.a(r3, r2, r4)     // Catch:{ all -> 0x0062 }
            com.alipay.sdk.m.j.b.a((java.lang.String) r2)     // Catch:{ all -> 0x0062 }
            r0.finish()     // Catch:{ all -> 0x0062 }
            goto L_0x0052
        L_0x0048:
            java.lang.String r2 = com.alipay.sdk.m.j.b.a()     // Catch:{ all -> 0x0062 }
            com.alipay.sdk.m.j.b.a((java.lang.String) r2)     // Catch:{ all -> 0x0062 }
            r0.finish()     // Catch:{ all -> 0x0062 }
        L_0x0052:
            monitor-exit(r5)
            return r1
        L_0x0054:
            r0.finish()     // Catch:{ all -> 0x0062 }
            monitor-exit(r5)
            return r1
        L_0x0059:
            boolean r0 = r5.g     // Catch:{ all -> 0x0062 }
            if (r0 != 0) goto L_0x0060
            r5.f()     // Catch:{ all -> 0x0062 }
        L_0x0060:
            monitor-exit(r5)
            return r1
        L_0x0062:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.x.d.b():boolean");
    }

    public synchronized void a(String str, String str2, boolean z2) {
        this.f = str2;
        this.j.getTitle().setText(str);
        this.e = z2;
    }

    public synchronized void c(e eVar, String str) {
        if (!str.startsWith("http") && !eVar.getUrl().endsWith(str)) {
            this.j.getTitle().setText(str);
        }
    }

    public boolean d() {
        return this.f688i;
    }

    private synchronized void a(boolean z2) {
        com.alipay.sdk.m.j.b.a(z2);
        this.a.finish();
    }

    public static class f {
        public final WeakReference<e> a;
        public final String b;
        public final String c;
        public final JSONObject d;
        public boolean e = false;

        public f(e eVar, String str, String str2, JSONObject jSONObject) {
            this.a = new WeakReference<>(eVar);
            this.b = str;
            this.c = str2;
            this.d = jSONObject;
        }

        public void a(JSONObject jSONObject) {
            e eVar;
            if (!this.e && (eVar = (e) n.a(this.a)) != null) {
                this.e = true;
                eVar.a(String.format("javascript:window.AlipayJSBridge.callBackFromNativeFunc('%s','%s');", new Object[]{a(this.c), a(jSONObject.toString())}));
            }
        }

        public static String a(String str) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            return str.replace("'", "");
        }
    }

    public synchronized void a(String str) {
        if ("POST".equals(this.f)) {
            this.j.a(str, (byte[]) null);
        } else {
            this.j.a(str);
        }
        c.a(this.j.getWebView());
    }

    public synchronized boolean a(e eVar, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (str2.startsWith("<head>") && str2.contains(l)) {
            this.a.runOnUiThread(new a());
        }
        jsPromptResult.cancel();
        return true;
    }

    private synchronized boolean b(String str, String str2) {
        synchronized (this) {
            e eVar = this.j;
            try {
                e eVar2 = new e(this.a, this.h, new e.C0023e(!a(), !a()));
                this.j = eVar2;
                eVar2.setChromeProxy(this);
                this.j.setWebClientProxy(this);
                this.j.setWebEventProxy(this);
                if (!TextUtils.isEmpty(str2)) {
                    this.j.getTitle().setText(str2);
                }
                this.g = true;
                this.k.a(eVar);
                TranslateAnimation translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
                translateAnimation.setDuration(400);
                translateAnimation.setFillAfter(false);
                translateAnimation.setAnimationListener(new c(eVar, str));
                this.j.setAnimation(translateAnimation);
                addView(this.j);
            } catch (Throwable unused) {
                return false;
            }
        }
        return true;
    }

    public synchronized boolean a(e eVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Activity activity = this.a;
        if (activity == null) {
            return true;
        }
        if (n.a(this.h, str, activity)) {
            return true;
        }
        if (str.startsWith(m)) {
            b(str.substring(17));
        } else if (TextUtils.equals(str, com.alipay.sdk.m.l.a.q)) {
            a(false);
        } else if (str.startsWith("http://") || str.startsWith("https://")) {
            this.j.a(str);
        } else {
            try {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                activity.startActivity(intent);
            } catch (Throwable th2) {
                com.alipay.sdk.m.k.a.a(this.h, com.alipay.sdk.m.k.b.l, th2);
            }
        }
        return true;
    }

    public synchronized boolean a(e eVar, int i2, String str, String str2) {
        this.f688i = true;
        com.alipay.sdk.m.s.a aVar = this.h;
        com.alipay.sdk.m.k.a.b(aVar, com.alipay.sdk.m.k.b.k, com.alipay.sdk.m.k.b.y, "onReceivedError:" + i2 + "|" + str2);
        eVar.getRefreshButton().setVisibility(0);
        return false;
    }

    public synchronized boolean b(e eVar, String str) {
        com.alipay.sdk.m.s.a aVar = this.h;
        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "h5ldd", SystemClock.elapsedRealtime() + "|" + n.i(str));
        h();
        eVar.getRefreshButton().setVisibility(0);
        return true;
    }

    public synchronized boolean a(e eVar, SslErrorHandler sslErrorHandler, SslError sslError) {
        Activity activity = this.a;
        if (activity == null) {
            return true;
        }
        com.alipay.sdk.m.s.a aVar = this.h;
        com.alipay.sdk.m.k.a.b(aVar, com.alipay.sdk.m.k.b.k, com.alipay.sdk.m.k.b.z, "2-" + sslError);
        activity.runOnUiThread(new C0021d(activity, sslErrorHandler));
        return true;
    }

    private synchronized void b(String str) {
        Map<String, String> b2 = n.b(this.h, str);
        if (str.startsWith(t)) {
            a(b2.get("func"), b2.get("cbId"), b2.get("data"));
        } else if (str.startsWith(n)) {
            i();
        } else if (str.startsWith("setTitle") && b2.containsKey("title")) {
            this.j.getTitle().setText(b2.get("title"));
        } else if (str.startsWith(p)) {
            this.j.getWebView().reload();
        } else if (str.startsWith(q) && b2.containsKey("bshow")) {
            this.j.getBackButton().setVisibility(TextUtils.equals("true", b2.get("bshow")) ? 0 : 4);
        } else if (str.startsWith(r)) {
            com.alipay.sdk.m.j.b.a(b2.get("result"));
            a(TextUtils.equals("true", b2.get("bsucc")));
        } else if (str.startsWith(s)) {
            this.j.a("javascript:(function() {\n    if (window.AlipayJSBridge) {\n        return\n    }\n\n    function alipayjsbridgeFunc(url) {\n        var iframe = document.createElement(\"iframe\");\n        iframe.style.width = \"1px\";\n        iframe.style.height = \"1px\";\n        iframe.style.display = \"none\";\n        iframe.src = url;\n        document.body.appendChild(iframe);\n        setTimeout(function() {\n            document.body.removeChild(iframe)\n        }, 100)\n    }\n    window.alipayjsbridgeSetTitle = function(title) {\n        document.title = title;\n        alipayjsbridgeFunc(\"alipayjsbridge://setTitle?title=\" + encodeURIComponent(title))\n    };\n    window.alipayjsbridgeRefresh = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onRefresh?\")\n    };\n    window.alipayjsbridgeBack = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onBack?\")\n    };\n    window.alipayjsbridgeExit = function(bsucc) {\n        alipayjsbridgeFunc(\"alipayjsbridge://onExit?bsucc=\" + bsucc)\n    };\n    window.alipayjsbridgeShowBackButton = function(bshow) {\n        alipayjsbridgeFunc(\"alipayjsbridge://showBackButton?bshow=\" + bshow)\n    };\n    window.AlipayJSBridge = {\n        version: \"2.0\",\n        addListener: addListener,\n        hasListener: hasListener,\n        callListener: callListener,\n        callNativeFunc: callNativeFunc,\n        callBackFromNativeFunc: callBackFromNativeFunc\n    };\n    var uniqueId = 1;\n    var h5JsCallbackMap = {};\n\n    function iframeCall(paramStr) {\n        setTimeout(function() {\n        \tvar iframe = document.createElement(\"iframe\");\n        \tiframe.style.width = \"1px\";\n        \tiframe.style.height = \"1px\";\n        \tiframe.style.display = \"none\";\n        \tiframe.src = \"alipayjsbridge://callNativeFunc?\" + paramStr;\n        \tvar parent = document.body || document.documentElement;\n        \tparent.appendChild(iframe);\n        \tsetTimeout(function() {\n            \tparent.removeChild(iframe)\n        \t}, 0)\n        }, 0)\n    }\n\n    function callNativeFunc(nativeFuncName, data, h5JsCallback) {\n        var h5JsCallbackId = \"\";\n        if (h5JsCallback) {\n            h5JsCallbackId = \"cb_\" + (uniqueId++) + \"_\" + new Date().getTime();\n            h5JsCallbackMap[h5JsCallbackId] = h5JsCallback\n        }\n        var dataStr = \"\";\n        if (data) {\n            dataStr = encodeURIComponent(JSON.stringify(data))\n        }\n        var paramStr = \"func=\" + nativeFuncName + \"&cbId=\" + h5JsCallbackId + \"&data=\" + dataStr;\n        iframeCall(paramStr)\n    }\n\n    function callBackFromNativeFunc(h5JsCallbackId, data) {\n        var h5JsCallback = h5JsCallbackMap[h5JsCallbackId];\n        if (h5JsCallback) {\n            h5JsCallback(data);\n            delete h5JsCallbackMap[h5JsCallbackId]\n        }\n    }\n    var h5ListenerMap = {};\n\n    function addListener(jsFuncName, jsFunc) {\n        h5ListenerMap[jsFuncName] = jsFunc\n    }\n\n    function hasListener(jsFuncName) {\n        var jsFunc = h5ListenerMap[jsFuncName];\n        if (!jsFunc) {\n            return false\n        }\n        return true\n    }\n\n    function callListener(h5JsFuncName, data, nativeCallbackId) {\n        var responseCallback;\n        if (nativeCallbackId) {\n            responseCallback = function(responseData) {\n                var dataStr = \"\";\n                if (responseData) {\n                    dataStr = encodeURIComponent(JSON.stringify(responseData))\n                }\n                var paramStr = \"func=h5JsFuncCallback\" + \"&cbId=\" + nativeCallbackId + \"&data=\" + dataStr;\n                iframeCall(paramStr)\n            }\n        }\n        var h5JsFunc = h5ListenerMap[h5JsFuncName];\n        if (h5JsFunc) {\n            h5JsFunc(data, responseCallback)\n        } else if (h5JsFuncName == \"h5BackAction\") {\n            if (!window.alipayjsbridgeH5BackAction || !alipayjsbridgeH5BackAction()) {\n                var paramStr = \"func=back\";\n                iframeCall(paramStr)\n            }\n        } else {\n            console.log(\"AlipayJSBridge: no h5JsFunc \" + h5JsFuncName + data)\n        }\n    }\n    var event;\n    if (window.CustomEvent) {\n        event = new CustomEvent(\"alipayjsbridgeready\")\n    } else {\n        event = document.createEvent(\"Event\");\n        event.initEvent(\"alipayjsbridgeready\", true, true)\n    }\n    document.dispatchEvent(event);\n    setTimeout(excuteH5InitFuncs, 0);\n\n    function excuteH5InitFuncs() {\n        if (window.AlipayJSBridgeInitArray) {\n            var h5InitFuncs = window.AlipayJSBridgeInitArray;\n            delete window.AlipayJSBridgeInitArray;\n            for (var i = 0; i < h5InitFuncs.length; i++) {\n                try {\n                    h5InitFuncs[i](AlipayJSBridge)\n                } catch (e) {\n                    setTimeout(function() {\n                        throw e\n                    })\n                }\n            }\n        }\n    }\n})();\n");
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(java.lang.String r10, java.lang.String r11, java.lang.String r12) {
        /*
            r9 = this;
            monitor-enter(r9)
            com.alipay.sdk.m.x.e r0 = r9.j     // Catch:{ all -> 0x01c3 }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r9)
            return
        L_0x0007:
            org.json.JSONObject r12 = com.alipay.sdk.m.u.n.h((java.lang.String) r12)     // Catch:{ all -> 0x01c3 }
            com.alipay.sdk.m.x.d$f r1 = new com.alipay.sdk.m.x.d$f     // Catch:{ all -> 0x01c3 }
            r1.<init>(r0, r10, r11, r12)     // Catch:{ all -> 0x01c3 }
            android.content.Context r11 = r0.getContext()     // Catch:{ all -> 0x01c3 }
            java.lang.String r2 = r1.b     // Catch:{ all -> 0x01b7 }
            r3 = -1
            int r4 = r2.hashCode()     // Catch:{ all -> 0x01b7 }
            r5 = 4
            r6 = 1
            r7 = 0
            switch(r4) {
                case -1785164386: goto L_0x007e;
                case -552487705: goto L_0x0073;
                case 3015911: goto L_0x0069;
                case 3127582: goto L_0x005f;
                case 110371416: goto L_0x0055;
                case 1085444827: goto L_0x004b;
                case 1703426986: goto L_0x0041;
                case 1906413305: goto L_0x0037;
                case 1947723784: goto L_0x002d;
                case 2033767917: goto L_0x0023;
                default: goto L_0x0021;
            }     // Catch:{ all -> 0x01b7 }
        L_0x0021:
            goto L_0x0088
        L_0x0023:
            java.lang.String r4 = "refreshButton"
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x01b7 }
            if (r2 == 0) goto L_0x0088
            r3 = 5
            goto L_0x0088
        L_0x002d:
            java.lang.String r4 = "sdkInfo"
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x01b7 }
            if (r2 == 0) goto L_0x0088
            r3 = 7
            goto L_0x0088
        L_0x0037:
            java.lang.String r4 = "backButton"
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x01b7 }
            if (r2 == 0) goto L_0x0088
            r3 = 4
            goto L_0x0088
        L_0x0041:
            java.lang.String r4 = "pushWindow"
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x01b7 }
            if (r2 == 0) goto L_0x0088
            r3 = 6
            goto L_0x0088
        L_0x004b:
            java.lang.String r4 = "refresh"
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x01b7 }
            if (r2 == 0) goto L_0x0088
            r3 = 1
            goto L_0x0088
        L_0x0055:
            java.lang.String r4 = "title"
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x01b7 }
            if (r2 == 0) goto L_0x0088
            r3 = 0
            goto L_0x0088
        L_0x005f:
            java.lang.String r4 = "exit"
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x01b7 }
            if (r2 == 0) goto L_0x0088
            r3 = 3
            goto L_0x0088
        L_0x0069:
            java.lang.String r4 = "back"
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x01b7 }
            if (r2 == 0) goto L_0x0088
            r3 = 2
            goto L_0x0088
        L_0x0073:
            java.lang.String r4 = "taoLogin"
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x01b7 }
            if (r2 == 0) goto L_0x0088
            r3 = 9
            goto L_0x0088
        L_0x007e:
            java.lang.String r4 = "canUseTaoLogin"
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x01b7 }
            if (r2 == 0) goto L_0x0088
            r3 = 8
        L_0x0088:
            switch(r3) {
                case 0: goto L_0x019f;
                case 1: goto L_0x0197;
                case 2: goto L_0x0193;
                case 3: goto L_0x017f;
                case 4: goto L_0x016e;
                case 5: goto L_0x015d;
                case 6: goto L_0x014b;
                case 7: goto L_0x0124;
                case 8: goto L_0x00eb;
                case 9: goto L_0x008d;
                default: goto L_0x008b;
            }     // Catch:{ all -> 0x01b7 }
        L_0x008b:
            goto L_0x01c1
        L_0x008d:
            java.lang.String r0 = r0.getUrl()     // Catch:{ all -> 0x01b7 }
            com.alipay.sdk.m.s.a r2 = r9.h     // Catch:{ all -> 0x01b7 }
            boolean r2 = com.alipay.sdk.m.u.n.a((com.alipay.sdk.m.s.a) r2, (java.lang.String) r0)     // Catch:{ all -> 0x01b7 }
            if (r2 != 0) goto L_0x00a4
            com.alipay.sdk.m.s.a r11 = r9.h     // Catch:{ all -> 0x01b7 }
            java.lang.String r12 = "biz"
            java.lang.String r1 = "jsUrlErr"
            com.alipay.sdk.m.k.a.b((com.alipay.sdk.m.s.a) r11, (java.lang.String) r12, (java.lang.String) r1, (java.lang.String) r0)     // Catch:{ all -> 0x01b7 }
            goto L_0x01c1
        L_0x00a4:
            java.lang.String r0 = "random"
            java.lang.String r0 = r12.optString(r0)     // Catch:{ all -> 0x01b7 }
            java.lang.String r2 = "options"
            org.json.JSONObject r12 = r12.optJSONObject(r2)     // Catch:{ all -> 0x01b7 }
            java.lang.String r2 = "random"
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x01b7 }
            if (r2 != 0) goto L_0x01c1
            if (r12 != 0) goto L_0x00bc
            goto L_0x01c1
        L_0x00bc:
            java.lang.String r2 = "url"
            java.lang.String r6 = r12.optString(r2)     // Catch:{ all -> 0x01b7 }
            java.lang.String r2 = "action"
            java.lang.String r7 = r12.optString(r2)     // Catch:{ all -> 0x01b7 }
            boolean r12 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x01b7 }
            if (r12 != 0) goto L_0x01c1
            boolean r12 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x01b7 }
            if (r12 == 0) goto L_0x00d6
            goto L_0x01c1
        L_0x00d6:
            boolean r12 = r11 instanceof android.app.Activity     // Catch:{ all -> 0x01b7 }
            if (r12 == 0) goto L_0x01c1
            com.alipay.sdk.m.s.a r3 = r9.h     // Catch:{ all -> 0x01b7 }
            r4 = r11
            android.app.Activity r4 = (android.app.Activity) r4     // Catch:{ all -> 0x01b7 }
            r5 = 1010(0x3f2, float:1.415E-42)
            com.alipay.sdk.m.x.d$g r8 = new com.alipay.sdk.m.x.d$g     // Catch:{ all -> 0x01b7 }
            r8.<init>(r1, r0)     // Catch:{ all -> 0x01b7 }
            com.alipay.sdk.m.j.d.a(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x01b7 }
            goto L_0x01c1
        L_0x00eb:
            java.lang.String r12 = r0.getUrl()     // Catch:{ all -> 0x01b7 }
            com.alipay.sdk.m.s.a r0 = r9.h     // Catch:{ all -> 0x01b7 }
            boolean r0 = com.alipay.sdk.m.u.n.a((com.alipay.sdk.m.s.a) r0, (java.lang.String) r12)     // Catch:{ all -> 0x01b7 }
            if (r0 != 0) goto L_0x0102
            com.alipay.sdk.m.s.a r11 = r9.h     // Catch:{ all -> 0x01b7 }
            java.lang.String r0 = "biz"
            java.lang.String r1 = "jsUrlErr"
            com.alipay.sdk.m.k.a.b((com.alipay.sdk.m.s.a) r11, (java.lang.String) r0, (java.lang.String) r1, (java.lang.String) r12)     // Catch:{ all -> 0x01b7 }
            goto L_0x01c1
        L_0x0102:
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ all -> 0x01b7 }
            r12.<init>()     // Catch:{ all -> 0x01b7 }
            com.alipay.sdk.m.s.a r0 = r9.h     // Catch:{ all -> 0x01b7 }
            boolean r11 = com.alipay.sdk.m.j.d.a(r0, r11)     // Catch:{ all -> 0x01b7 }
            java.lang.String r0 = "enabled"
            r12.put(r0, r11)     // Catch:{ all -> 0x01b7 }
            com.alipay.sdk.m.s.a r0 = r9.h     // Catch:{ all -> 0x01b7 }
            java.lang.String r2 = "biz"
            java.lang.String r3 = "TbChk"
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ all -> 0x01b7 }
            com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r0, (java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r11)     // Catch:{ all -> 0x01b7 }
            r1.a((org.json.JSONObject) r12)     // Catch:{ all -> 0x01b7 }
            goto L_0x01c1
        L_0x0124:
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ all -> 0x01b7 }
            r11.<init>()     // Catch:{ all -> 0x01b7 }
            java.lang.String r12 = "sdk_version"
            java.lang.String r0 = "15.8.16"
            r11.put(r12, r0)     // Catch:{ all -> 0x01b7 }
            java.lang.String r12 = "app_name"
            com.alipay.sdk.m.s.a r0 = r9.h     // Catch:{ all -> 0x01b7 }
            java.lang.String r0 = r0.b()     // Catch:{ all -> 0x01b7 }
            r11.put(r12, r0)     // Catch:{ all -> 0x01b7 }
            java.lang.String r12 = "app_version"
            com.alipay.sdk.m.s.a r0 = r9.h     // Catch:{ all -> 0x01b7 }
            java.lang.String r0 = r0.c()     // Catch:{ all -> 0x01b7 }
            r11.put(r12, r0)     // Catch:{ all -> 0x01b7 }
            r1.a((org.json.JSONObject) r11)     // Catch:{ all -> 0x01b7 }
            goto L_0x01c1
        L_0x014b:
            java.lang.String r11 = "url"
            java.lang.String r11 = r12.optString(r11)     // Catch:{ all -> 0x01b7 }
            java.lang.String r0 = "title"
            java.lang.String r1 = ""
            java.lang.String r12 = r12.optString(r0, r1)     // Catch:{ all -> 0x01b7 }
            r9.b((java.lang.String) r11, (java.lang.String) r12)     // Catch:{ all -> 0x01b7 }
            goto L_0x01c1
        L_0x015d:
            java.lang.String r11 = "show"
            boolean r11 = r12.optBoolean(r11, r6)     // Catch:{ all -> 0x01b7 }
            android.widget.ImageView r12 = r0.getRefreshButton()     // Catch:{ all -> 0x01b7 }
            if (r11 == 0) goto L_0x016a
            r5 = 0
        L_0x016a:
            r12.setVisibility(r5)     // Catch:{ all -> 0x01b7 }
            goto L_0x01c1
        L_0x016e:
            java.lang.String r11 = "show"
            boolean r11 = r12.optBoolean(r11, r6)     // Catch:{ all -> 0x01b7 }
            android.widget.ImageView r12 = r0.getBackButton()     // Catch:{ all -> 0x01b7 }
            if (r11 == 0) goto L_0x017b
            r5 = 0
        L_0x017b:
            r12.setVisibility(r5)     // Catch:{ all -> 0x01b7 }
            goto L_0x01c1
        L_0x017f:
            java.lang.String r11 = "result"
            r0 = 0
            java.lang.String r11 = r12.optString(r11, r0)     // Catch:{ all -> 0x01b7 }
            com.alipay.sdk.m.j.b.a((java.lang.String) r11)     // Catch:{ all -> 0x01b7 }
            java.lang.String r11 = "success"
            boolean r11 = r12.optBoolean(r11, r7)     // Catch:{ all -> 0x01b7 }
            r9.a((boolean) r11)     // Catch:{ all -> 0x01b7 }
            goto L_0x01c1
        L_0x0193:
            r9.i()     // Catch:{ all -> 0x01b7 }
            goto L_0x01c1
        L_0x0197:
            android.webkit.WebView r11 = r0.getWebView()     // Catch:{ all -> 0x01b7 }
            r11.reload()     // Catch:{ all -> 0x01b7 }
            goto L_0x01c1
        L_0x019f:
            java.lang.String r11 = "title"
            boolean r11 = r12.has(r11)     // Catch:{ all -> 0x01b7 }
            if (r11 == 0) goto L_0x01c1
            android.widget.TextView r11 = r0.getTitle()     // Catch:{ all -> 0x01b7 }
            java.lang.String r0 = "title"
            java.lang.String r1 = ""
            java.lang.String r12 = r12.optString(r0, r1)     // Catch:{ all -> 0x01b7 }
            r11.setText(r12)     // Catch:{ all -> 0x01b7 }
            goto L_0x01c1
        L_0x01b7:
            r11 = move-exception
            com.alipay.sdk.m.s.a r12 = r9.h     // Catch:{ all -> 0x01c3 }
            java.lang.String r0 = "biz"
            java.lang.String r1 = "jInfoErr"
            com.alipay.sdk.m.k.a.a(r12, r0, r1, r11, r10)     // Catch:{ all -> 0x01c3 }
        L_0x01c1:
            monitor-exit(r9)
            return
        L_0x01c3:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.x.d.a(java.lang.String, java.lang.String, java.lang.String):void");
    }

    public synchronized void b(e eVar) {
        f();
    }

    public synchronized void a(e eVar) {
        eVar.getWebView().reload();
        eVar.getRefreshButton().setVisibility(4);
    }
}
