package fe.fe.nn.uk;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sso.SSOManager;
import fe.fe.nn.ppp.de;
import fe.fe.nn.ppp.qw;
import fe.fe.nn.ppp.uk;
import fe.fe.nn.qw.ad;

public class fe {

    /* renamed from: ad  reason: collision with root package name */
    public static String f2403ad;
    public String qw = ad.qw;

    public fe(Context context) {
    }

    public static synchronized fe qw(Context context) {
        fe feVar;
        synchronized (fe.class) {
            feVar = new fe(context);
        }
        return feVar;
    }

    public String ad(String str, String str2) {
        String str3 = SSOManager.f1098ad;
        String str4 = SSOManager.f1099de;
        String str5 = "";
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            return str5;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        StringBuilder sb = new StringBuilder();
        try {
            str5 = de(str3, str4, currentTimeMillis);
        } catch (Throwable th2) {
            de.fe(th2);
        }
        sb.append(rg());
        sb.append(str);
        sb.append("/");
        sb.append("100");
        sb.append("/");
        sb.append(str3);
        sb.append("/");
        sb.append(currentTimeMillis);
        sb.append("/");
        sb.append(str5);
        sb.append("?skey=");
        sb.append(str2);
        return sb.toString();
    }

    public String de(String str, String str2, long j) {
        try {
            return uk.ad(str + j + str2);
        } catch (Throwable th2) {
            de.fe(th2);
            return "";
        }
    }

    public final void fe() {
        try {
            f2403ad = new String(qw.ad(this.qw));
        } catch (Throwable th2) {
            de.fe(th2);
        }
    }

    public final String rg() {
        if (TextUtils.isEmpty(f2403ad)) {
            fe();
        }
        return f2403ad;
    }
}
