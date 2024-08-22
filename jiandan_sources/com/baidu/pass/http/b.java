package com.baidu.pass.http;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.alipay.sdk.m.u.i;
import com.baidu.android.common.others.IStringUtil;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.SimpleTimeZone;

public class b {
    public static final String a = "b";
    public static final String b = "Set-Cookie";
    public static final String c = "EEE, dd-MMM-yyyy HH:mm:ss 'GMT'";
    public static final String d = "Cookie";
    public static final String e = "https://";

    public static String a(String str, String str2, String str3, long j, boolean z) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append("=");
        sb.append(str3);
        sb.append(";domain=");
        sb.append(str);
        sb.append(";path=/;expires=");
        sb.append(simpleDateFormat.format(instance.getTime()));
        sb.append(";httponly");
        sb.append(z ? ";secure" : "");
        return sb.toString();
    }

    @TargetApi(9)
    public static void b(Context context, HttpURLConnection httpURLConnection, PassHttpParamDTO passHttpParamDTO) {
        try {
            CookieSyncManager.createInstance(context);
            CookieManager instance = CookieManager.getInstance();
            URI uri = new URI(passHttpParamDTO.url);
            String cookie = instance.getCookie("https://" + uri.getHost());
            c.a(a, "asyncCookie" + passHttpParamDTO.asyncCookie);
            c.a(a, "webviewCookies" + cookie);
            String[] strArr = null;
            if (!passHttpParamDTO.asyncCookie) {
                cookie = null;
            }
            List<HttpCookie> list = passHttpParamDTO.cookie;
            if (!TextUtils.isEmpty(cookie) || (list != null && !list.isEmpty())) {
                String str = "";
                if (!TextUtils.isEmpty(cookie)) {
                    strArr = cookie.split(i.b);
                }
                if (strArr != null) {
                    if (strArr.length > 0) {
                        for (String str2 : strArr) {
                            if (!TextUtils.isEmpty(str2)) {
                                List<HttpCookie> parse = HttpCookie.parse(str2);
                                if (!parse.isEmpty()) {
                                    HttpCookie httpCookie = parse.get(0);
                                    if (httpCookie != null) {
                                        if (!httpCookie.hasExpired()) {
                                            if (list != null) {
                                                for (HttpCookie next : list) {
                                                    if (httpCookie.getName().equals(next.getName()) && a(passHttpParamDTO.url, httpCookie)) {
                                                        httpCookie = next;
                                                    }
                                                }
                                            }
                                            if (!httpCookie.hasExpired()) {
                                                str = str + httpCookie.getName() + "=" + httpCookie.getValue() + i.b;
                                            }
                                            c.a(a, "httpCookie webview item name:" + httpCookie.getName() + ",value:" + httpCookie.getValue());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (list != null) {
                    for (HttpCookie next2 : list) {
                        if (a(passHttpParamDTO.url, next2)) {
                            str = str + next2.getName() + "=" + next2.getValue() + i.b;
                        }
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    String substring = str.substring(0, str.length() - 1);
                    c.a(a, "cookieStr" + substring);
                    httpURLConnection.setRequestProperty("Cookie", substring);
                }
            }
        } catch (Exception e2) {
            c.a(a, "asyncWebviewCookie2NA:" + e2.toString());
        }
    }

    @TargetApi(9)
    public static void a(Context context, HttpURLConnection httpURLConnection, PassHttpParamDTO passHttpParamDTO) {
        Map headerFields;
        try {
            c.a(a, "asyncCookie" + passHttpParamDTO.asyncCookie);
            if (!passHttpParamDTO.asyncCookie || (headerFields = httpURLConnection.getHeaderFields()) == null) {
                return;
            }
            if (!headerFields.isEmpty()) {
                List<String> list = (List) headerFields.get("Set-Cookie");
                if (list == null) {
                    return;
                }
                if (!list.isEmpty()) {
                    CookieSyncManager.createInstance(context);
                    CookieManager instance = CookieManager.getInstance();
                    instance.setAcceptCookie(true);
                    if (instance.acceptCookie()) {
                        for (String str : list) {
                            if (!TextUtils.isEmpty(str)) {
                                List<HttpCookie> parse = HttpCookie.parse(str);
                                if (!parse.isEmpty()) {
                                    HttpCookie httpCookie = parse.get(0);
                                    if (a(passHttpParamDTO.url, httpCookie)) {
                                        "httpcookie:" + httpCookie.toString();
                                        String a2 = a(httpCookie.getDomain(), httpCookie.getName(), httpCookie.getValue(), (httpCookie.getMaxAge() * 1000) + System.currentTimeMillis(), httpCookie.getSecure());
                                        "httpcookie build:" + a2;
                                        instance.setCookie("https://" + httpCookie.getDomain(), a2);
                                    }
                                }
                            }
                        }
                        if (Build.VERSION.SDK_INT < 21) {
                            CookieSyncManager.getInstance().sync();
                        } else {
                            instance.flush();
                        }
                    }
                }
            }
        } catch (Exception e2) {
            c.a(a, "asyncNaCookie2Webview:" + e2.toString());
        }
    }

    @TargetApi(9)
    public static boolean a(String str, HttpCookie httpCookie) {
        try {
            URL url = new URL(str);
            if (httpCookie.getDiscard() || httpCookie.hasExpired() || !a(url.getHost(), httpCookie.getDomain()) || !b(url.getPath(), httpCookie.getPath()) || !a(str, httpCookie.getSecure())) {
                return false;
            }
            return true;
        } catch (Exception unused) {
        }
    }

    public static boolean b(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        if (!str.startsWith(str2)) {
            return false;
        }
        if (!str2.endsWith("/") && str.charAt(str2.length()) != '/') {
            return false;
        }
        return true;
    }

    public static boolean a(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!z || str.startsWith("https://")) {
            return true;
        }
        return false;
    }

    public static boolean a(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        if ((!str.endsWith(str2) || str.charAt((str.length() - str2.length()) - 1) != '.' || c.b(str)) && !str.endsWith(str2) && !str2.startsWith(IStringUtil.CURRENT_PATH) && c.b(str)) {
            return false;
        }
        return true;
    }
}
