package com.pichillilorenzo.flutter_inappwebview;

import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.ValueCallback;
import androidx.annotation.Nullable;
import com.alipay.sdk.m.u.i;
import io.flutter.plugin.common.MethodChannel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public class MyCookieManager implements MethodChannel.MethodCallHandler {
    public static final String LOG_TAG = "MyCookieManager";
    public static CookieManager cookieManager;
    public MethodChannel channel;
    @Nullable
    public InAppWebViewFlutterPlugin plugin;

    public MyCookieManager(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
        this.plugin = inAppWebViewFlutterPlugin;
        MethodChannel methodChannel = new MethodChannel(inAppWebViewFlutterPlugin.messenger, "com.pichillilorenzo/flutter_inappwebview_cookiemanager");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
        cookieManager = getCookieManager();
    }

    public static String getCookieExpirationDate(Long l) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy hh:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(new Date(l.longValue()));
    }

    @Nullable
    public static CookieManager getCookieManager() {
        if (cookieManager == null) {
            try {
                cookieManager = CookieManager.getInstance();
            } catch (IllegalArgumentException unused) {
                return null;
            } catch (Exception e) {
                if (e.getMessage() != null && e.getClass().getCanonicalName().equals("android.webkit.WebViewFactory.MissingWebViewPackageException")) {
                    return null;
                }
                throw e;
            }
        }
        return cookieManager;
    }

    public void deleteAllCookies(final MethodChannel.Result result) {
        CookieManager cookieManager2 = getCookieManager();
        cookieManager = cookieManager2;
        if (cookieManager2 != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                cookieManager.removeAllCookies(new ValueCallback<Boolean>() {
                    public void onReceiveValue(Boolean bool) {
                        result.success(Boolean.TRUE);
                    }
                });
                cookieManager.flush();
                return;
            }
            CookieSyncManager createInstance = CookieSyncManager.createInstance(this.plugin.applicationContext);
            createInstance.startSync();
            cookieManager.removeAllCookie();
            result.success(Boolean.TRUE);
            createInstance.stopSync();
            createInstance.sync();
        }
    }

    public void deleteCookie(String str, String str2, String str3, String str4, final MethodChannel.Result result) {
        CookieManager cookieManager2 = getCookieManager();
        cookieManager = cookieManager2;
        if (cookieManager2 != null) {
            String str5 = str2 + "=; Path=" + str4 + "; Domain=" + str3 + "; Max-Age=-1;";
            if (Build.VERSION.SDK_INT >= 21) {
                cookieManager.setCookie(str, str5, new ValueCallback<Boolean>() {
                    public void onReceiveValue(Boolean bool) {
                        result.success(Boolean.TRUE);
                    }
                });
                cookieManager.flush();
                return;
            }
            CookieSyncManager createInstance = CookieSyncManager.createInstance(this.plugin.applicationContext);
            createInstance.startSync();
            cookieManager.setCookie(str, str5);
            result.success(Boolean.TRUE);
            createInstance.stopSync();
            createInstance.sync();
        }
    }

    public void deleteCookies(String str, String str2, String str3, MethodChannel.Result result) {
        CookieSyncManager cookieSyncManager;
        CookieManager cookieManager2 = getCookieManager();
        cookieManager = cookieManager2;
        if (cookieManager2 != null) {
            String cookie = cookieManager2.getCookie(str);
            if (cookie != null) {
                if (Build.VERSION.SDK_INT < 21) {
                    cookieSyncManager = CookieSyncManager.createInstance(this.plugin.applicationContext);
                    cookieSyncManager.startSync();
                } else {
                    cookieSyncManager = null;
                }
                for (String split : cookie.split(i.b)) {
                    String str4 = split.split("=", 2)[0].trim() + "=; Path=" + str3 + "; Domain=" + str2 + "; Max-Age=-1;";
                    if (Build.VERSION.SDK_INT >= 21) {
                        cookieManager.setCookie(str, str4, (ValueCallback) null);
                    } else {
                        cookieManager.setCookie(str, str4);
                    }
                }
                if (cookieSyncManager != null) {
                    cookieSyncManager.stopSync();
                    cookieSyncManager.sync();
                } else if (Build.VERSION.SDK_INT >= 21) {
                    cookieManager.flush();
                }
            }
            result.success(Boolean.TRUE);
        }
    }

    public void dispose() {
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.plugin = null;
    }

    public List<Map<String, Object>> getCookies(String str) {
        String cookie;
        ArrayList arrayList = new ArrayList();
        CookieManager cookieManager2 = getCookieManager();
        cookieManager = cookieManager2;
        if (!(cookieManager2 == null || (cookie = cookieManager2.getCookie(str)) == null)) {
            for (String split : cookie.split(i.b)) {
                String[] split2 = split.split("=", 2);
                String trim = split2[0].trim();
                String trim2 = split2.length > 1 ? split2[1].trim() : "";
                HashMap hashMap = new HashMap();
                hashMap.put("name", trim);
                hashMap.put("value", trim2);
                hashMap.put("expiresDate", (Object) null);
                hashMap.put("isSessionOnly", (Object) null);
                hashMap.put("domain", (Object) null);
                hashMap.put("sameSite", (Object) null);
                hashMap.put("isSecure", (Object) null);
                hashMap.put("isHttpOnly", (Object) null);
                hashMap.put("path", (Object) null);
                arrayList.add(hashMap);
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(io.flutter.plugin.common.MethodCall r13, io.flutter.plugin.common.MethodChannel.Result r14) {
        /*
            r12 = this;
            java.lang.String r1 = r13.method
            int r2 = r1.hashCode()
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r2) {
                case -1222815761: goto L_0x0036;
                case 126640486: goto L_0x002c;
                case 747417188: goto L_0x0022;
                case 822411705: goto L_0x0018;
                case 1989049945: goto L_0x000e;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x0040
        L_0x000e:
            java.lang.String r2 = "getCookies"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0040
            r1 = 1
            goto L_0x0041
        L_0x0018:
            java.lang.String r2 = "deleteAllCookies"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0040
            r1 = 4
            goto L_0x0041
        L_0x0022:
            java.lang.String r2 = "deleteCookies"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0040
            r1 = 3
            goto L_0x0041
        L_0x002c:
            java.lang.String r2 = "setCookie"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0040
            r1 = 0
            goto L_0x0041
        L_0x0036:
            java.lang.String r2 = "deleteCookie"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0040
            r1 = 2
            goto L_0x0041
        L_0x0040:
            r1 = -1
        L_0x0041:
            java.lang.String r2 = "name"
            java.lang.String r7 = "path"
            java.lang.String r8 = "domain"
            java.lang.String r9 = "url"
            if (r1 == 0) goto L_0x00a1
            if (r1 == r6) goto L_0x0093
            if (r1 == r5) goto L_0x0074
            if (r1 == r4) goto L_0x005d
            if (r1 == r3) goto L_0x0058
            r14.notImplemented()
            goto L_0x00f9
        L_0x0058:
            r12.deleteAllCookies(r14)
            goto L_0x00f9
        L_0x005d:
            java.lang.Object r1 = r13.argument(r9)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r13.argument(r8)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r0 = r13.argument(r7)
            java.lang.String r0 = (java.lang.String) r0
            r12.deleteCookies(r1, r2, r0, r14)
            goto L_0x00f9
        L_0x0074:
            java.lang.Object r1 = r13.argument(r9)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r13.argument(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r3 = r13.argument(r8)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r0 = r13.argument(r7)
            r4 = r0
            java.lang.String r4 = (java.lang.String) r4
            r0 = r12
            r5 = r14
            r0.deleteCookie(r1, r2, r3, r4, r5)
            goto L_0x00f9
        L_0x0093:
            java.lang.Object r0 = r13.argument(r9)
            java.lang.String r0 = (java.lang.String) r0
            java.util.List r0 = r12.getCookies(r0)
            r14.success(r0)
            goto L_0x00f9
        L_0x00a1:
            java.lang.Object r1 = r13.argument(r9)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r13.argument(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = "value"
            java.lang.Object r3 = r13.argument(r3)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r4 = r13.argument(r8)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r13.argument(r7)
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r6 = "expiresDate"
            java.lang.Object r6 = r13.argument(r6)
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x00d2
            java.lang.Long r7 = new java.lang.Long
            r7.<init>(r6)
            r6 = r7
            goto L_0x00d3
        L_0x00d2:
            r6 = 0
        L_0x00d3:
            java.lang.String r7 = "maxAge"
            java.lang.Object r7 = r13.argument(r7)
            java.lang.Integer r7 = (java.lang.Integer) r7
            java.lang.String r8 = "isSecure"
            java.lang.Object r8 = r13.argument(r8)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            java.lang.String r9 = "isHttpOnly"
            java.lang.Object r9 = r13.argument(r9)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            java.lang.String r10 = "sameSite"
            java.lang.Object r0 = r13.argument(r10)
            r10 = r0
            java.lang.String r10 = (java.lang.String) r10
            r0 = r12
            r11 = r14
            r0.setCookie(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
        L_0x00f9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pichillilorenzo.flutter_inappwebview.MyCookieManager.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    public void setCookie(String str, String str2, String str3, String str4, String str5, Long l, Integer num, Boolean bool, Boolean bool2, String str6, final MethodChannel.Result result) {
        CookieManager cookieManager2 = getCookieManager();
        cookieManager = cookieManager2;
        if (cookieManager2 != null) {
            String str7 = str2 + "=" + str3 + "; Domain=" + str4 + "; Path=" + str5;
            if (l != null) {
                str7 = str7 + "; Expires=" + getCookieExpirationDate(l);
            }
            if (num != null) {
                str7 = str7 + "; Max-Age=" + num.toString();
            }
            if (bool != null && bool.booleanValue()) {
                str7 = str7 + "; Secure";
            }
            if (bool2 != null && bool2.booleanValue()) {
                str7 = str7 + "; HttpOnly";
            }
            if (str6 != null) {
                str7 = str7 + "; SameSite=" + str6;
            }
            String str8 = str7 + i.b;
            if (Build.VERSION.SDK_INT >= 21) {
                cookieManager.setCookie(str, str8, new ValueCallback<Boolean>() {
                    public void onReceiveValue(Boolean bool) {
                        result.success(Boolean.TRUE);
                    }
                });
                cookieManager.flush();
                return;
            }
            CookieSyncManager createInstance = CookieSyncManager.createInstance(this.plugin.applicationContext);
            createInstance.startSync();
            cookieManager.setCookie(str, str8);
            result.success(Boolean.TRUE);
            createInstance.stopSync();
            createInstance.sync();
        }
    }
}
