package fe.fe.ddd.p001switch.th;

import android.text.TextUtils;
import com.alipay.sdk.m.n.a;
import com.baidu.searchbox.http.cookie.CookieManager;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/* renamed from: fe.fe.ddd.switch.th.qw  reason: invalid package */
public class qw implements CookieJar {
    public CookieManager qw;

    public qw(CookieManager cookieManager) {
        this.qw = cookieManager;
    }

    public static int fe(String str, int i2, int i3) {
        while (i2 < i3) {
            char charAt = str.charAt(i2);
            if (charAt != 9 && charAt != 10 && charAt != 12 && charAt != 13 && charAt != ' ') {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int qw(String str, int i2, int i3, char c) {
        while (i2 < i3) {
            if (str.charAt(i2) == c) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int rg(String str, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            char charAt = str.charAt(i4);
            if (charAt != 9 && charAt != 10 && charAt != 12 && charAt != 13 && charAt != ' ') {
                return i4 + 1;
            }
        }
        return i2;
    }

    public static String th(String str, int i2, int i3) {
        int fe2 = fe(str, i2, i3);
        return str.substring(fe2, rg(str, fe2, i3));
    }

    public final String ad(String str) {
        if (str == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt <= 31 || charAt >= 127) {
                sb.append(String.format("\\u%04x", new Object[]{Integer.valueOf(charAt)}));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public final List<Cookie> de(HttpUrl httpUrl, String str) {
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int qw2 = qw(str, i2, length, ';');
            int qw3 = qw(str, i2, qw2, a.h);
            String th2 = th(str, i2, qw3);
            String th3 = qw3 < qw2 ? th(str, qw3 + 1, qw2) : "";
            if (th3.startsWith("\"") && th3.endsWith("\"")) {
                th3 = th3.substring(1, th3.length() - 1);
            }
            String ad2 = ad(th2);
            String ad3 = ad(th3);
            if (!TextUtils.isEmpty(ad2) && this.qw.de(httpUrl.toString(), ad2)) {
                arrayList.add(new Cookie.Builder().name(ad2).value(ad3).domain(httpUrl.host()).build());
            }
            i2 = qw2 + 1;
        }
        return arrayList;
    }

    public List<Cookie> loadForRequest(HttpUrl httpUrl) {
        ArrayList arrayList = new ArrayList();
        CookieManager cookieManager = this.qw;
        if (cookieManager != null) {
            String qw2 = cookieManager.qw(httpUrl.toString());
            if (!TextUtils.isEmpty(qw2)) {
                arrayList.addAll(de(httpUrl, qw2));
            }
        }
        return arrayList;
    }

    public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        if (this.qw != null) {
            ArrayList arrayList = new ArrayList();
            String httpUrl2 = httpUrl.toString();
            for (Cookie cookie : list) {
                String cookie2 = cookie.toString();
                if (!TextUtils.isEmpty(cookie2) && this.qw.ad(httpUrl2, cookie2)) {
                    arrayList.add(cookie2);
                }
            }
            this.qw.fe(httpUrl.toString(), arrayList);
        }
    }
}
