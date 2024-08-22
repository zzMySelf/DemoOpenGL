package fe.fe.nn.pf;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sso.SSOManager;
import com.baidu.wallet.base.widget.banner.BannerBaseItemInfo;
import fe.fe.nn.o.qw;
import fe.fe.nn.ppp.fe;
import org.json.JSONArray;
import org.json.JSONObject;

public class de {

    /* renamed from: ad  reason: collision with root package name */
    public static String f2261ad;

    /* renamed from: de  reason: collision with root package name */
    public static String f2262de;

    /* renamed from: fe  reason: collision with root package name */
    public static String f2263fe;
    public static String qw;

    public static String ad(Context context) {
        try {
            if (TextUtils.isEmpty(qw)) {
                qw = fe.fe.nn.ppp.de.ad(context);
            }
            if (TextUtils.isEmpty(qw)) {
                return "";
            }
            return qw;
        } catch (Throwable th2) {
            fe.fe.nn.ppp.de.fe(th2);
            return "";
        }
    }

    public static JSONObject de(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("1", ad(context));
            jSONObject.put("3", fe(context));
            jSONObject.put("2", rg(context));
            jSONObject.put("4", th(context));
            jSONObject.put(BannerBaseItemInfo.TYPE_LOGIN, str);
            jSONObject.put(BannerBaseItemInfo.TYPE_SCHEME, System.currentTimeMillis());
            jSONObject.put("7", "0");
            jSONObject.put("8", SSOManager.f1098ad);
            jSONObject.put("9", "sso");
            jSONObject.put("10", "1.2.6");
            jSONObject.put("14", fe.fe.nn.ppp.de.yj(context));
            jSONObject.put("23", qw.qw(context));
            jSONObject.put("26", "");
            jSONObject.put("31", fe.fe.nn.qw.qw.uk(context).f());
            return jSONObject;
        } catch (Throwable th2) {
            fe.fe.nn.ppp.de.fe(th2);
            return null;
        }
    }

    public static String fe(Context context) {
        try {
            if (TextUtils.isEmpty(f2261ad)) {
                f2261ad = fe.fe.nn.ppp.de.rg(context);
            }
            if (TextUtils.isEmpty(f2261ad)) {
                return "";
            }
            return f2261ad;
        } catch (Throwable th2) {
            fe.fe.nn.ppp.de.fe(th2);
            return "";
        }
    }

    public static String rg(Context context) {
        try {
            if (TextUtils.isEmpty(f2262de)) {
                f2262de = context.getPackageName();
            }
            if (TextUtils.isEmpty(f2262de)) {
                return "";
            }
            return f2262de;
        } catch (Throwable th2) {
            fe.fe.nn.ppp.de.fe(th2);
            return "";
        }
    }

    public static String th(Context context) {
        try {
            if (!TextUtils.isEmpty(f2263fe)) {
                return f2263fe;
            }
            String ad2 = fe.ad(context);
            f2263fe = ad2;
            return ad2;
        } catch (Throwable unused) {
            return "";
        }
    }

    public fe.fe.nn.p006switch.qw qw(Context context, String str, String str2, int i2, int i3) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(str);
            JSONObject de2 = de(context, str2);
            de2.put("module_section", jSONArray);
            fe.fe.nn.p006switch.qw qwVar = new fe.fe.nn.p006switch.qw();
            qwVar.rg(i2);
            qwVar.de(de2.toString());
            qwVar.yj(i3);
            return qwVar;
        } catch (Throwable th2) {
            fe.fe.nn.ppp.de.fe(th2);
            return null;
        }
    }
}
