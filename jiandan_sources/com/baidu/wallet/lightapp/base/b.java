package com.baidu.wallet.lightapp.base;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.lightapp.base.statistics.LightAppStatEvent;
import com.baidu.wallet.paysdk.datamodel.Bank;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;

public class b {
    public final WebView a;
    public final String b;
    public final String c;
    public URL d;

    public b(WebView webView, String str, String str2) {
        this.a = webView;
        this.b = str;
        this.c = str2;
        if (webView != null) {
            a((Runnable) new Runnable() {
                public void run() {
                    try {
                        if (b.this.a != null) {
                            URL unused = b.this.d = new URL(b.this.a.getUrl());
                        }
                    } catch (MalformedURLException unused2) {
                    }
                }
            });
        }
    }

    public void b(final String str) {
        if (!TextUtils.isEmpty(this.c) && this.a != null) {
            a((Runnable) new Runnable() {
                public void run() {
                    try {
                        URL url = new URL(b.this.a.getUrl());
                        if (b.this.d != null && !url.sameFile(b.this.d)) {
                            HashSet hashSet = new HashSet();
                            hashSet.add(url.toString());
                            hashSet.add(b.this.d.toString());
                            return;
                        }
                    } catch (MalformedURLException unused) {
                    }
                    String d = b.this.c;
                    if (!TextUtils.isEmpty(str)) {
                        d = d + "(" + str + ")";
                    }
                    if (LogUtil.DEBUG) {
                        LogUtil.logd("loadUrl=" + d);
                    }
                    try {
                        if (b.this.a != null) {
                            if (Build.VERSION.SDK_INT >= 19) {
                                b.this.a.evaluateJavascript(d, (ValueCallback) null);
                                return;
                            }
                            b.this.a.loadUrl("javascript:" + d);
                        }
                    } catch (Throwable unused2) {
                    }
                }
            });
        }
    }

    public void a(final String str) {
        if (LogUtil.DEBUG) {
            LogUtil.logd("sucessJsCallback=" + str + Bank.HOT_BANK_LETTER + this.b);
        }
        if (TextUtils.isEmpty(this.b)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("sucessJsCallback");
            arrayList.add("param is null");
            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.METHOD_INVOKE_BD_WALLET_NATIVE_FAIL, arrayList);
        } else if (this.a != null) {
            a((Runnable) new Runnable() {
                public void run() {
                    try {
                        URL url = new URL(b.this.a.getUrl());
                        if (b.this.d != null && !url.sameFile(b.this.d)) {
                            HashSet hashSet = new HashSet();
                            hashSet.add(url.toString());
                            hashSet.add(b.this.d.toString());
                            return;
                        }
                    } catch (MalformedURLException e) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(b.this.a.getUrl());
                        arrayList.add("sucessJsCallback");
                        arrayList.add(e.toString());
                        DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.METHOD_INVOKE_BD_WALLET_NATIVE_FAIL, arrayList);
                    }
                    String c = b.this.b;
                    if (!TextUtils.isEmpty(str)) {
                        c = c + "(" + str + ")";
                    }
                    if (LogUtil.DEBUG) {
                        LogUtil.logd("loadUrl=" + c);
                    }
                    try {
                        if (b.this.a != null) {
                            if (Build.VERSION.SDK_INT >= 19) {
                                b.this.a.evaluateJavascript(c, (ValueCallback) null);
                                return;
                            }
                            b.this.a.loadUrl("javascript:" + c);
                        }
                    } catch (Throwable th2) {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(b.this.a.getUrl());
                        arrayList2.add("sucessJsCallback");
                        arrayList2.add(th2.toString());
                        arrayList2.add("webview evaluateJavascript fail");
                        DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.METHOD_INVOKE_BD_WALLET_NATIVE_FAIL, arrayList2);
                    }
                }
            });
        }
    }

    private void a(Runnable runnable) {
        if (runnable != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                new Handler(Looper.getMainLooper()).post(runnable);
            }
        }
    }
}
