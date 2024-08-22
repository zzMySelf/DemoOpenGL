package fe.fe.pf.th.qw;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sofire.xclient.privacycontrol.lib.OaidHelper;
import fe.fe.pf.ad;
import fe.fe.pf.de;
import fe.fe.pf.th.qw.de;
import fe.fe.pf.uk.qw;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class rg implements uk {
    public String a() {
        return de.ad().qw();
    }

    public String a(Context context) {
        return ad.th(context.getApplicationContext()).de();
    }

    public JSONArray b(Context context) {
        T t;
        ad.th thVar;
        de deVar = new de();
        ad.th(context).xxx(deVar);
        boolean ad2 = deVar.ad(10000);
        JSONArray jSONArray = new JSONArray();
        if (ad2) {
            de.ad qw = deVar.qw();
            if (!(qw == null || (t = qw.qw) == null || (thVar = (ad.th) t) == null || thVar.ad() == null)) {
                for (ad.yj next : thVar.ad()) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("aid", next.f2711ad);
                        jSONObject.put(SapiAccount.ExtraProperty.EXTRA_PKG, next.qw);
                        jSONObject.put("priority", next.f2712de);
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            deVar.de();
        }
        return jSONArray;
    }

    public String c(Context context) {
        de deVar = new de();
        OaidHelper.requestOid(ad.th(context), deVar);
        if (deVar.ad(10000)) {
            de.ad qw = deVar.qw();
            if (qw == null || TextUtils.isEmpty((CharSequence) qw.qw)) {
                return null;
            }
            return (String) qw.qw;
        }
        deVar.de();
        return null;
    }

    public String d(Context context) {
        de deVar = new de();
        ad.th(context).m183switch(deVar);
        if (deVar.ad(10000)) {
            de.ad qw = deVar.qw();
            if (qw == null || TextUtils.isEmpty((CharSequence) qw.qw)) {
                return null;
            }
            return (String) qw.qw;
        }
        deVar.de();
        return null;
    }

    public String e(Context context) {
        return ad.th(context.getApplicationContext()).rg();
    }

    public JSONArray f(Context context) {
        T t;
        List<fe.fe.pf.uk.ad> list;
        de deVar = new de();
        fe.fe.pf.de.ad().rg(context, deVar);
        boolean ad2 = deVar.ad(10000);
        JSONArray jSONArray = new JSONArray();
        if (ad2) {
            de.ad qw = deVar.qw();
            if (!(qw == null || (t = qw.qw) == null || (list = (List) t) == null || list.size() <= 0)) {
                for (fe.fe.pf.uk.ad adVar : list) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(SapiAccount.ExtraProperty.EXTRA_PKG, adVar.qw);
                        jSONObject.put("sigs", Arrays.toString(adVar.f2947ad));
                        jSONObject.put("vc", adVar.f2948de);
                        jSONObject.put("va", adVar.f2949fe);
                        jSONObject.put("installts", adVar.f2950rg);
                        jSONObject.put("lstupdatets", adVar.f2951th);
                        jSONArray.put(jSONObject);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            deVar.de();
        }
        return jSONArray;
    }

    public JSONObject qw(Context context) {
        T t;
        de deVar = new de();
        fe.fe.pf.de.ad().de(context, deVar);
        boolean ad2 = deVar.ad(10000);
        JSONObject jSONObject = new JSONObject();
        if (ad2) {
            de.ad qw = deVar.qw();
            if (!(qw == null || (t = qw.qw) == null)) {
                qw qwVar = (qw) t;
            }
        } else {
            deVar.de();
        }
        return jSONObject;
    }
}
