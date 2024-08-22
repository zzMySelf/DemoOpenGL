package fe.fe.ddd.yj.fe;

import android.text.TextUtils;
import com.baidu.android.util.sp.SharedPrefsWrapper;
import com.baidu.searchbox.config.AppConfig;
import fe.fe.ddd.yj.ad.rg;
import fe.fe.ddd.yj.qw;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ad {

    /* renamed from: ad  reason: collision with root package name */
    public String f1764ad;

    /* renamed from: de  reason: collision with root package name */
    public SharedPrefsWrapper f1765de = qw.ad().rg();
    public String qw;

    public ad(String str) {
        this.qw = str;
    }

    public long ad(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception unused) {
            boolean rg2 = AppConfig.rg();
            return 0;
        }
    }

    public fe.fe.ddd.yj.ad.qw de(JSONObject jSONObject, boolean z) throws JSONException {
        String str;
        JSONObject jSONObject2;
        rg rgVar;
        rg rgVar2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        JSONObject jSONObject3 = jSONObject;
        int optInt = jSONObject3.optInt("errno");
        if (optInt != 0) {
            fe.fe.ddd.yj.ad.qw qwVar = new fe.fe.ddd.yj.ad.qw();
            fe.fe.ddd.yj.ad.ad adVar = new fe.fe.ddd.yj.ad.ad();
            adVar.de(2);
            adVar.fe(optInt);
            qwVar.i(adVar);
            return qwVar;
        }
        String optString = jSONObject3.optString("logid");
        rg rgVar3 = new rg();
        rgVar3.uk(optString);
        rgVar3.o(this.f1764ad);
        rgVar3.i(this.qw);
        JSONObject optJSONObject = jSONObject3.optJSONObject("data");
        if (optJSONObject == null) {
            fe.fe.ddd.yj.ad.qw qwVar2 = new fe.fe.ddd.yj.ad.qw();
            fe.fe.ddd.yj.ad.ad adVar2 = new fe.fe.ddd.yj.ad.ad();
            adVar2.de(3);
            adVar2.fe(30);
            qwVar2.i(adVar2);
            return qwVar2;
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("service");
        String optString2 = optJSONObject.optString("pubparam");
        JSONObject optJSONObject3 = optJSONObject.optJSONObject("control");
        if (optJSONObject3 == null || optJSONObject3.length() == 0) {
            rgVar = rgVar3;
            jSONObject2 = optJSONObject2;
            str = optString2;
        } else {
            JSONArray jSONArray = new JSONArray();
            JSONObject optJSONObject4 = optJSONObject3.optJSONObject("ccs_hotrun_interval");
            int i7 = 1;
            if (optJSONObject4 != null) {
                jSONObject2 = optJSONObject2;
                String optString3 = optJSONObject4.optString("data");
                String optString4 = optJSONObject4.optString("version", "0");
                str = optString2;
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("product", "ccs_hotrun_interval");
                jSONObject4.put("version", optString4);
                rgVar2 = rgVar3;
                String string = this.f1765de.getString("interval_version", "0");
                if (!z || ad(optString4) > ad(string)) {
                    this.f1765de.putString("interval_version", optString4);
                    this.f1765de.putString("sp_hot_runtime_interval", optString3);
                    jSONObject4.put("valid", "1");
                    i3 = 0;
                    i2 = 1;
                } else {
                    jSONObject4.put("valid", "2");
                    i3 = 1;
                    i2 = 0;
                }
                jSONArray.put(jSONObject4);
            } else {
                rgVar2 = rgVar3;
                jSONObject2 = optJSONObject2;
                str = optString2;
                i3 = 0;
                i2 = 0;
                i7 = 0;
            }
            JSONObject optJSONObject5 = optJSONObject3.optJSONObject("ccs_degrade_list");
            if (optJSONObject5 != null) {
                i7++;
                JSONObject optJSONObject6 = optJSONObject5.optJSONObject("data");
                String optString5 = optJSONObject5.optString("version", "0");
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("product", "ccs_degrade_list");
                jSONObject5.put("version", optString5);
                String string2 = this.f1765de.getString("degrade_list_version", "0");
                if (!z || ad(optString5) > ad(string2)) {
                    this.f1765de.putString("degrade_list_version", optString5);
                    int i8 = i2 + 1;
                    if (optJSONObject6 == null || optJSONObject6.length() == 0) {
                        i5 = i3;
                        i4 = i8;
                        this.f1765de.putString("st", "0");
                        this.f1765de.putString("et", "0");
                        this.f1765de.putString("sp_runtype_black", "");
                        this.f1765de.putString("degrade_list", "");
                        this.f1765de.putBoolean("pubparam_in_black", false);
                        jSONObject5.put("valid", "0");
                    } else {
                        i5 = i3;
                        i4 = i8;
                        this.f1765de.putString("st", optJSONObject6.optString("st", "0"));
                        this.f1765de.putString("et", optJSONObject6.optString("et", "0"));
                        this.f1765de.putString("sp_runtype_black", optJSONObject6.optString("runtype_black"));
                        JSONObject optJSONObject7 = optJSONObject6.optJSONObject("req_body_black");
                        if (optJSONObject7 != null) {
                            String optString6 = optJSONObject7.optString("versions");
                            boolean has = optJSONObject7.has("pubparam");
                            this.f1765de.putString("degrade_list", optString6);
                            this.f1765de.putBoolean("pubparam_in_black", has);
                            jSONObject5.put("valid", "1");
                        } else {
                            this.f1765de.putString("degrade_list", "");
                            this.f1765de.putBoolean("pubparam_in_black", false);
                        }
                    }
                    i2 = i4;
                    i6 = i5;
                } else {
                    jSONObject5.put("valid", "2");
                    i6 = i3 + 1;
                }
                jSONArray.put(jSONObject5);
            } else {
                int i9 = i3;
            }
            rgVar = rgVar2;
            rgVar.qw(i7, i2, i3, jSONArray);
        }
        this.f1765de.putString("sp_pubparam", str);
        this.f1765de.putLong("sp_last_request_time", System.currentTimeMillis());
        if (jSONObject2 == null) {
            fe.fe.ddd.yj.ad.qw qwVar3 = new fe.fe.ddd.yj.ad.qw();
            fe.fe.ddd.yj.ad.ad adVar3 = new fe.fe.ddd.yj.ad.ad();
            adVar3.de(3);
            adVar3.fe(30);
            qwVar3.i(adVar3);
            qwVar3.o(rgVar);
            return qwVar3;
        }
        fe.fe.ddd.yj.ad.qw qwVar4 = new fe.fe.ddd.yj.ad.qw(jSONObject2);
        fe.fe.ddd.yj.ad.ad adVar4 = new fe.fe.ddd.yj.ad.ad();
        adVar4.de(0);
        qwVar4.i(adVar4);
        qwVar4.o(rgVar);
        return qwVar4;
    }

    public fe.fe.ddd.yj.ad.qw qw(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        fe.fe.ddd.yj.ad.qw de2 = de(jSONObject, TextUtils.equals("1", jSONObject2.optString("version_asc")));
        de2.m95switch(jSONObject2);
        return de2;
    }

    public ad(String str, String str2) {
        this.qw = str;
        this.f1764ad = str2;
    }
}
