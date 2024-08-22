package fe.fe.ddd.yj;

import com.baidu.android.util.sp.SharedPrefsWrapper;
import com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor;
import com.baidu.searchbox.config.AppConfig;
import fe.fe.ddd.p000if.fe;
import fe.fe.ddd.yj.ad.de;
import fe.fe.ddd.yj.fe.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class qw {

    /* renamed from: de  reason: collision with root package name */
    public static qw f1774de;

    /* renamed from: ad  reason: collision with root package name */
    public SharedPrefsWrapper f1775ad = new SharedPrefsWrapper("cloudControlCCS117");
    public fe.fe.ddd.yj.de.qw qw = new fe.fe.ddd.yj.de.qw();

    /* renamed from: fe.fe.ddd.yj.qw$qw  reason: collision with other inner class name */
    public class C0098qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ String f1776ad;

        public C0098qw(qw qwVar, String str) {
            this.f1776ad = str;
        }

        public void run() {
            new fe.fe.ddd.yj.fe.qw().qw(this.f1776ad, (ArrayList<de>) null);
        }
    }

    public static qw ad() {
        synchronized (qw.class) {
            if (f1774de == null) {
                f1774de = new qw();
            }
        }
        return f1774de;
    }

    public ArrayList<de> de(String str) {
        JSONObject jSONObject;
        ArrayList<de> arrayList = new ArrayList<>();
        HashMap<String, ICloudControlProcessor> rg2 = this.qw.rg();
        try {
            jSONObject = new JSONObject(this.f1775ad.getString("degrade_list", ""));
        } catch (JSONException e) {
            if (AppConfig.rg()) {
                "drage is not json  " + e.toString();
            }
            jSONObject = null;
        }
        if (jSONObject != null && jSONObject.length() == 0) {
            return arrayList;
        }
        for (Map.Entry next : rg2.entrySet()) {
            String str2 = (String) next.getKey();
            de ad2 = ((ICloudControlProcessor) next.getValue()).ad(str, th(), jSONObject != null ? jSONObject.optJSONObject(str2) : null);
            if (AppConfig.rg()) {
                if (ad2 != null) {
                    try {
                        if (!this.qw.de(str2)) {
                            throw new Exception(str2 + " service is not register");
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else {
                    throw new Exception(str2 + " service get post data is error ");
                }
            }
            arrayList.add(ad2);
        }
        return arrayList;
    }

    public HashMap<String, ICloudControlProcessor> fe() {
        return this.qw.rg();
    }

    public boolean qw(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        try {
            fe.fe.ddd.yj.ad.qw qw2 = new ad(str).qw(jSONObject, jSONObject2);
            new fe.fe.ddd.yj.rg.qw().rg(qw2);
            if (qw2 == null) {
                return false;
            }
            return true;
        } catch (JSONException e) {
            if (AppConfig.rg()) {
                "connect response parse is error" + e.toString();
            }
            return false;
        }
    }

    public SharedPrefsWrapper rg() {
        return this.f1775ad;
    }

    public boolean th() {
        try {
            String string = this.f1775ad.getString("st", "0");
            String string2 = this.f1775ad.getString("et", "0");
            long parseLong = Long.parseLong(string);
            long parseLong2 = Long.parseLong(string2);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (parseLong > currentTimeMillis || currentTimeMillis > parseLong2) {
                return false;
            }
            return true;
        } catch (Exception unused) {
        }
    }

    public void uk(String str) {
        fe.de(new C0098qw(this, str), "requestCloudControl", 0);
    }

    public boolean yj(JSONObject jSONObject, String str, String str2) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        if (!th() || jSONObject == null) {
            return false;
        }
        if (jSONObject.length() == 0) {
            return true;
        }
        if (!jSONObject.has(str) || (optJSONObject = jSONObject.optJSONObject(str)) == null) {
            return false;
        }
        if (optJSONObject.length() == 0) {
            return true;
        }
        if (!optJSONObject.has(str2) || (optJSONObject2 = optJSONObject.optJSONObject(str2)) == null || optJSONObject2.length() != 0) {
            return false;
        }
        return true;
    }
}
