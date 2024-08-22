package fe.fe.nn.uk;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.baidu.apollon.heartbeat.a;
import com.baidu.wallet.base.widget.banner.BannerBaseItemInfo;
import fe.fe.nn.ad;
import fe.fe.nn.o.qw;
import fe.fe.nn.ppp.Cif;
import fe.fe.nn.ppp.fe;
import fe.fe.nn.ppp.pf;
import fe.fe.nn.ppp.rg;
import fe.fe.nn.ppp.th;
import fe.fe.nn.ppp.uk;
import fe.fe.nn.rg.i;
import java.net.URLEncoder;
import java.util.Iterator;
import org.json.JSONObject;

public class de extends qw {

    /* renamed from: de  reason: collision with root package name */
    public fe f2402de;

    public de(Context context, Handler handler) {
        super(context, handler);
        this.f2404ad = context;
        this.f2402de = fe.qw(context);
    }

    public String ad() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("0", this.f2404ad.getPackageName());
            jSONObject.put(BannerBaseItemInfo.TYPE_SCHEME, fe.fe.nn.ppp.de.i(this.f2404ad));
            jSONObject.put("7", pf.qw(this.f2404ad));
            jSONObject.put("8", String.valueOf(Build.VERSION.SDK_INT));
            jSONObject.put("9", qw.fe(this.f2404ad));
            ad.qw("requestPolicy, param:" + jSONObject.toString());
            return de("q/1/qc", fe.fe.nn.ppp.de.de(this.f2404ad, jSONObject, ""));
        } catch (Throwable th2) {
            fe.fe.nn.ppp.de.fe(th2);
            return "";
        }
    }

    public String de(String str, JSONObject jSONObject) {
        try {
            fe.fe.nn.i.qw de2 = fe.fe.nn.i.ad.de(fe.fe.nn.i.ad.qw(), th.ad(jSONObject.toString().getBytes(a.h)));
            String ad2 = this.f2402de.ad(str, URLEncoder.encode(Base64.encodeToString(rg.ad(de2.qw(), uk.ad(fe.qw(this.f2404ad)).getBytes()), 0), a.h));
            if (TextUtils.isEmpty(ad2)) {
                return "";
            }
            String qw = qw(ad2, de2.ad());
            if (TextUtils.isEmpty(qw)) {
                return "";
            }
            try {
                JSONObject jSONObject2 = new JSONObject(qw);
                jSONObject2.optString("request_id");
                String optString = jSONObject2.optString("skey");
                String optString2 = jSONObject2.optString("data");
                String str2 = new String(fe.fe.nn.i.ad.ad(rg.qw(Base64.decode(optString.getBytes(), 0), uk.ad(fe.qw(this.f2404ad)).getBytes()), Base64.decode(optString2.getBytes(), 0)));
                ad.qw("requestPolicy, response:" + str2);
                return str2;
            } catch (Throwable th2) {
                fe.fe.nn.ppp.de.fe(th2);
            }
            return "";
        } catch (Throwable th3) {
            fe.fe.nn.ppp.de.fe(th3);
            return "";
        }
    }

    public String fe(JSONObject jSONObject, long j) {
        try {
            JSONObject th2 = th(true, false);
            th2.put("40", qw.de(this.f2404ad, true, false, "login"));
            th2.put("41", qw.ad(this.f2404ad, "login"));
            th2.put("24", "");
            th2.put("73", i.de().th());
            if (i.de().i()) {
                th2.put("50", Cif.qw(this.f2404ad));
                th2.put("60", qw.yj(this.f2404ad, "login"));
                Pair<Integer, String[]> fe2 = Cif.fe(this.f2404ad);
                if (fe2 != null) {
                    th2.put("20", fe2.first);
                    String[] strArr = (String[]) fe2.second;
                    if (strArr.length == 4) {
                        th2.put("14", strArr[0]);
                        th2.put("18", strArr[1]);
                        th2.put("15", strArr[2]);
                        th2.put("19", strArr[3]);
                    }
                }
            }
            return de("q/1/qmini", fe.fe.nn.ppp.de.de(this.f2404ad, rg(th2, jSONObject), "1077102"));
        } catch (Throwable th3) {
            fe.fe.nn.ppp.de.fe(th3);
            return "";
        }
    }

    public String i(JSONObject jSONObject, long j) {
        try {
            return de("q/1/qv", fe.fe.nn.ppp.de.de(this.f2404ad, rg(th(true, false), jSONObject), ""));
        } catch (Throwable th2) {
            fe.fe.nn.ppp.de.fe(th2);
            return "";
        }
    }

    public final JSONObject rg(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return null;
        }
        if (jSONObject == null) {
            return jSONObject2;
        }
        if (jSONObject2 == null) {
            return jSONObject;
        }
        try {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, jSONObject2.opt(next));
            }
        } catch (Throwable th2) {
            fe.fe.nn.ppp.de.fe(th2);
        }
        return jSONObject;
    }

    public final JSONObject th(boolean z, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        try {
            yj(jSONObject, "21", "");
            yj(jSONObject, "22", "");
            yj(jSONObject, "23", "");
        } catch (Throwable th2) {
            fe.fe.nn.ppp.de.fe(th2);
        }
        return jSONObject;
    }

    public boolean uk(JSONObject jSONObject) {
        try {
            JSONObject th2 = th(false, true);
            th2.put("24", "");
            th2.put("40", qw.de(this.f2404ad, false, true, "prelogin"));
            th2.put("41", qw.ad(this.f2404ad, "prelogin"));
            th2.put("27", qw.rg(this.f2404ad, "prelogin"));
            th2.put("28", qw.th(this.f2404ad, "prelogin"));
            th2.put("60", qw.yj(this.f2404ad, "prelogin"));
            th2.put("55", String.valueOf(Build.VERSION.SDK_INT));
            th2.put("50", Cif.qw(this.f2404ad));
            Pair<Integer, String[]> fe2 = Cif.fe(this.f2404ad);
            if (fe2 != null) {
                th2.put("20", fe2.first);
                String[] strArr = (String[]) fe2.second;
                if (strArr.length == 4) {
                    th2.put("14", strArr[0]);
                    th2.put("18", strArr[1]);
                    th2.put("15", strArr[2]);
                    th2.put("19", strArr[3]);
                }
            }
            JSONObject jSONObject2 = new JSONObject(de("q/1/qpre", fe.fe.nn.ppp.de.de(this.f2404ad, rg(th2, jSONObject), "1077104")));
            if (jSONObject2.optInt("0", 0) == 0) {
                i.de().rg(this.f2404ad, jSONObject2);
                return true;
            }
        } catch (Throwable th3) {
            fe.fe.nn.ppp.de.fe(th3);
        }
        return false;
    }

    public final void yj(JSONObject jSONObject, String str, String str2) {
        if (jSONObject != null && !TextUtils.isEmpty(str)) {
            try {
                if (TextUtils.isEmpty(str2)) {
                    jSONObject.put(str, "");
                } else {
                    jSONObject.put(str, str2);
                }
            } catch (Throwable th2) {
                fe.fe.nn.ppp.de.fe(th2);
            }
        }
    }
}
