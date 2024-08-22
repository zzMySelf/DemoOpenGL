package fe.fe.mmm;

import android.text.TextUtils;
import androidx.core.net.MailTo;
import fe.fe.mmm.u.rg;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aaa {

    /* renamed from: ad  reason: collision with root package name */
    public static final boolean f1991ad = tt.vvv();

    /* renamed from: de  reason: collision with root package name */
    public static volatile aaa f1992de;
    public qqq qw;

    public static class qw {

        /* renamed from: ad  reason: collision with root package name */
        public Map<String, JSONObject> f1993ad = new HashMap();
        public int qw = 0;
    }

    public static aaa o() {
        if (f1992de == null) {
            synchronized (aaa.class) {
                if (f1992de == null) {
                    f1992de = new aaa();
                }
            }
        }
        return f1992de;
    }

    public void ad(String str, boolean z, String str2) {
        if (this.qw == null || TextUtils.isEmpty(str) || !TextUtils.isDigitsOnly(str) || !de()) {
            return;
        }
        if (z || TextUtils.isEmpty(str2)) {
            this.qw.fe(str, z);
        } else {
            this.qw.de(str, str2);
        }
    }

    public boolean de() {
        i vvv = i.vvv();
        if (vvv != null && !vvv.yj("2980", 32)) {
            return false;
        }
        if (vvv == null || !vvv.fe("2980")) {
            return true;
        }
        return false;
    }

    public final boolean fe() {
        i vvv = i.vvv();
        if (vvv != null && !vvv.yj("2980", 32)) {
            return false;
        }
        if (vvv == null || !vvv.fe("2980")) {
            return true;
        }
        return false;
    }

    public final String i(JSONObject jSONObject, long j, long j2) {
        if (j == 0 || j2 == 0) {
            return "";
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("max", Long.valueOf(j));
            jSONObject2.putOpt("min", Long.valueOf(j));
            jSONObject.putOpt(String.valueOf(j2), jSONObject2);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    /* renamed from: if  reason: not valid java name */
    public String m116if(String str, String str2) {
        long th2 = rg.de().th(str2);
        long ad2 = rg.de().ad(str2);
        if (th2 == 0 || ad2 == 0) {
            return str;
        }
        try {
            JSONObject jSONObject = TextUtils.isEmpty(str) ? new JSONObject() : new JSONObject(str);
            String valueOf = String.valueOf(th2);
            JSONObject optJSONObject = jSONObject.optJSONObject(valueOf);
            if (optJSONObject == null) {
                return i(jSONObject, ad2, th2);
            }
            optJSONObject.putOpt("max", Long.valueOf(ad2));
            jSONObject.putOpt(valueOf, optJSONObject);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return str;
        }
    }

    public void pf(qqq qqq) {
        this.qw = qqq;
    }

    public void qw(String str, boolean z) {
        ad(str, z, (String) null);
    }

    public boolean rg(l lVar) {
        if (lVar == null || lVar.f() || !fe()) {
            return false;
        }
        this.qw.uk();
        Map<String, qw> eee = this.qw.eee(7);
        if (!(eee == null || eee.size() == 0)) {
            try {
                JSONObject jSONObject = new JSONObject();
                boolean z = false;
                for (String next : eee.keySet()) {
                    qw qwVar = eee.get(next);
                    if (qwVar != null) {
                        if (!TextUtils.isEmpty(next)) {
                            JSONObject jSONObject2 = new JSONObject();
                            JSONArray jSONArray = new JSONArray();
                            for (JSONObject put : qwVar.f1993ad.values()) {
                                jSONArray.put(put);
                            }
                            jSONObject2.put("total", qwVar.qw);
                            jSONObject2.put("data", jSONArray);
                            jSONObject.put(next.replace("-", ""), jSONObject2);
                            z = true;
                        }
                    }
                }
                if (z) {
                    vvv vvv = new vvv("2980");
                    vvv.f(jSONObject);
                    vvv.l(System.currentTimeMillis());
                    vvv.m(j.ad());
                    i vvv2 = i.vvv();
                    if (!(vvv2 == null || vvv2.ad("2980") == 0)) {
                        m.when(vvv);
                    }
                    if (vvv2 != null) {
                        vvv.eee(vvv2.m123if());
                    }
                    lVar.de(vvv, vvv.o());
                    lVar.qw(eee.keySet());
                    return true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public void th(Map<String, qw> map, String str, String str2, int i2, int i3, String str3) {
        qw qwVar;
        if (map != null) {
            if (map.containsKey(str)) {
                qwVar = map.get(str);
            } else {
                qw qwVar2 = new qw();
                map.put(str, qwVar2);
                qwVar = qwVar2;
            }
            Map<String, JSONObject> map2 = qwVar.f1993ad;
            if (map2.containsKey(str2) && f1991ad) {
                "*******duplicate ubc id record: " + str2;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", str2);
                jSONObject.put("c", i2);
                jSONObject.put(MailTo.CC, i3);
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject.put("logid", yj(str3));
                }
                qwVar.qw += i2;
                map2.put(str2, jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String uk(String str) {
        JSONObject jSONObject = new JSONObject();
        long th2 = rg.de().th(str);
        return i(jSONObject, rg.de().ad(str), th2);
    }

    public final String yj(String str) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                if (optJSONObject != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("s", next);
                    jSONObject2.putOpt("min", Long.valueOf(optJSONObject.optLong("min")));
                    jSONObject2.putOpt("max", Long.valueOf(optJSONObject.optLong("max")));
                    jSONArray.put(jSONObject2);
                }
            }
            if (jSONArray.length() > 0) {
                return jSONArray.toString();
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }
}
