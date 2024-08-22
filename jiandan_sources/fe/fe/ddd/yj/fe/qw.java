package fe.fe.ddd.yj.fe;

import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.util.sp.SharedPrefsWrapper;
import com.baidu.searchbox.cloudcontrol.processor.IProcessorDataInterceptor;
import com.baidu.searchbox.config.AppConfig;
import fe.fe.ddd.p001switch.p002if.fe;
import fe.fe.ddd.p001switch.p002if.yj;
import fe.fe.ddd.yj.ad.ad;
import fe.fe.ddd.yj.th.de;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class qw {
    public final SharedPrefsWrapper qw = fe.fe.ddd.yj.qw.ad().rg();

    /* renamed from: fe.fe.ddd.yj.fe.qw$qw  reason: collision with other inner class name */
    public class C0097qw extends fe.fe.ddd.p001switch.rg.qw<fe.fe.ddd.yj.ad.qw> {

        /* renamed from: ad  reason: collision with root package name */
        public long f1766ad;

        /* renamed from: de  reason: collision with root package name */
        public long f1767de;

        /* renamed from: fe  reason: collision with root package name */
        public String f1768fe;

        /* renamed from: i  reason: collision with root package name */
        public HashMap<String, IProcessorDataInterceptor> f1769i;
        public String qw;

        /* renamed from: rg  reason: collision with root package name */
        public long f1770rg;

        /* renamed from: th  reason: collision with root package name */
        public long f1771th;

        /* renamed from: uk  reason: collision with root package name */
        public HashMap<String, Boolean> f1772uk;

        /* renamed from: yj  reason: collision with root package name */
        public HashMap<String, Object> f1773yj;

        public C0097qw(qw qwVar, String str) {
            this.qw = str;
        }

        public final void fe(int i2, int i3, int i4, String str) {
            de.ad(this.qw, i2, this.f1768fe, i3, i4, str, this.f1767de, this.f1771th, this.f1770rg);
        }

        public void i(HashMap<String, Object> hashMap) {
            this.f1773yj = hashMap;
        }

        /* renamed from: if  reason: not valid java name */
        public void m96if(long j) {
            this.f1770rg = j;
        }

        public void o(HashMap<String, IProcessorDataInterceptor> hashMap) {
            this.f1769i = hashMap;
        }

        public void pf(HashMap<String, Boolean> hashMap) {
            this.f1772uk = hashMap;
        }

        public void qw(Exception exc) {
            this.f1767de = SystemClock.elapsedRealtime() - this.f1766ad;
            rg(6, 0, exc.getMessage());
            fe.fe.ddd.yj.ad.qw qwVar = new fe.fe.ddd.yj.ad.qw();
            ad adVar = new ad();
            adVar.de(1);
            adVar.fe(exc.hashCode());
            qwVar.i(adVar);
            qwVar.uk(this.f1773yj);
            qwVar.m94if(this.f1772uk);
            new fe.fe.ddd.yj.rg.qw().rg(qwVar);
            boolean rg2 = AppConfig.rg();
        }

        public final void rg(int i2, int i3, String str) {
            de.ad(this.qw, i2, this.f1768fe, i3, -100, str, this.f1767de, this.f1771th, this.f1770rg);
        }

        /* renamed from: switch  reason: not valid java name */
        public void m97switch(long j) {
            this.f1766ad = j;
        }

        /* renamed from: th */
        public void ad(fe.fe.ddd.yj.ad.qw qwVar, int i2) {
            rg(0, i2, "");
            new fe.fe.ddd.yj.rg.qw().rg(qwVar);
        }

        /* renamed from: uk */
        public fe.fe.ddd.yj.ad.qw de(Response response, int i2) throws Exception {
            this.f1767de = SystemClock.elapsedRealtime() - this.f1766ad;
            if (response.code() != 200) {
                rg(2, i2, response.message());
            }
            if (response.body() != null) {
                String string = response.body().string();
                this.f1771th = (long) string.length();
                fe.fe.ddd.yj.ad.qw de2 = new ad(this.qw, this.f1768fe).de(new JSONObject(string), false);
                de2.uk(this.f1773yj);
                de2.m94if(this.f1772uk);
                de2.pf(this.f1769i);
                yj(de2, response, i2);
                return de2;
            }
            fe.fe.ddd.yj.ad.qw qwVar = new fe.fe.ddd.yj.ad.qw();
            ad adVar = new ad();
            adVar.de(1);
            adVar.fe(response.code());
            qwVar.i(adVar);
            qwVar.uk(this.f1773yj);
            qwVar.m94if(this.f1772uk);
            qwVar.pf(this.f1769i);
            rg(3, i2, response.message());
            return qwVar;
        }

        public void when(String str) {
            this.f1768fe = str;
        }

        public final void yj(fe.fe.ddd.yj.ad.qw qwVar, Response response, int i2) {
            if (qwVar.ad() != null) {
                int qw2 = qwVar.ad().qw();
                int ad2 = qwVar.ad().ad();
                if (qw2 == 2) {
                    fe(4, i2, ad2, response.message());
                } else if (qw2 == 3) {
                    fe(5, i2, ad2, response.message());
                }
            }
        }
    }

    public final void ad(String str, fe feVar) {
        try {
            String th2 = feVar.th();
            long j = -1;
            if (!(feVar.o() == null || feVar.o().body() == null)) {
                j = feVar.o().body().contentLength();
            }
            de.qw(str, th2, j);
        } catch (Exception e) {
            if (AppConfig.rg()) {
                "doStabilityRequestUBCEvent error " + e.toString();
            }
        }
    }

    public final boolean de(String str) {
        if (!TextUtils.equals(str, "1")) {
            return true;
        }
        String string = this.qw.getString("sp_hot_runtime_interval", "300");
        long j = this.qw.getLong("sp_last_request_time", 0);
        try {
            long parseLong = Long.parseLong(string);
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = currentTimeMillis - j;
            if (currentTimeMillis <= j || (j2 / 1000) - parseLong < 0) {
                return false;
            }
            return true;
        } catch (NumberFormatException unused) {
        }
    }

    public final boolean fe(String str) {
        if (!TextUtils.equals(str, "1") && !TextUtils.equals(str, "0")) {
            try {
                JSONArray jSONArray = new JSONArray(this.qw.getString("sp_runtype_black", ""));
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    if (TextUtils.equals(jSONArray.optString(i2), str)) {
                        return true;
                    }
                }
            } catch (JSONException unused) {
            }
        }
        return false;
    }

    public void qw(String str, ArrayList<fe.fe.ddd.yj.ad.de> arrayList) {
        String str2 = str;
        if (de(str) && !fe(str)) {
            C0097qw qwVar = new C0097qw(this, str2);
            String qw2 = fe.fe.ddd.yj.th.ad.qw(str);
            ArrayList<fe.fe.ddd.yj.ad.de> de2 = arrayList == null ? fe.fe.ddd.yj.qw.ad().de(str2) : arrayList;
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            String str3 = qw2;
            for (int i2 = 0; i2 < de2.size(); i2++) {
                fe.fe.ddd.yj.ad.de deVar = de2.get(i2);
                if (deVar != null) {
                    try {
                        jSONObject.put(deVar.th(), deVar.fe());
                    } catch (JSONException e) {
                        if (AppConfig.rg()) {
                            "post data put error" + e.toString();
                        }
                    }
                    Object qw3 = deVar.qw();
                    boolean yj2 = deVar.yj();
                    hashMap.put(deVar.th(), qw3);
                    hashMap2.put(deVar.th(), Boolean.valueOf(yj2));
                    IProcessorDataInterceptor ad2 = deVar.ad();
                    if (ad2 != null) {
                        hashMap3.put(deVar.th(), ad2);
                    }
                    HashMap<String, String> rg2 = deVar.rg();
                    try {
                        jSONObject2.put(deVar.th(), deVar.de());
                    } catch (JSONException e2) {
                        if (AppConfig.rg()) {
                            "filter data  put error" + e2.toString();
                        }
                    }
                    for (Map.Entry next : rg2.entrySet()) {
                        str3 = UrlUtil.addParam(str3, (String) next.getKey(), (String) next.getValue());
                    }
                }
            }
            qwVar.i(hashMap);
            qwVar.pf(hashMap2);
            qwVar.o(hashMap3);
            fe.fe.ddd.p001switch.de mmm = fe.fe.ddd.p001switch.de.mmm(fe.fe.ddd.i.qw.qw.qw());
            yj.qw ddd = mmm.ddd();
            ddd.uk(str3);
            fe.fe.ddd.p001switch.p002if.ad adVar = ddd;
            HashMap hashMap4 = new HashMap();
            if (jSONObject.length() != 0) {
                hashMap4.put("versions", jSONObject);
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("ccs_hotrun_interval", this.qw.getString("interval_version", "0"));
                jSONObject3.put("ccs_degrade_list", this.qw.getString("degrade_list_version", "0"));
            } catch (JSONException unused) {
                jSONObject3 = null;
            }
            if (!(jSONObject3 == null || jSONObject3.length() == 0)) {
                hashMap4.put("ctrlversion", jSONObject3);
            }
            if (jSONObject2.length() != 0) {
                hashMap4.put("filter", jSONObject2);
            }
            if (!this.qw.getBoolean("pubparam_in_black", false)) {
                String string = this.qw.getString("sp_pubparam", "");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        hashMap4.put("pubparam", new JSONObject(string));
                    } catch (JSONException unused2) {
                        boolean rg3 = AppConfig.rg();
                    }
                }
            }
            String jSONObject4 = new JSONObject(hashMap4).toString();
            adVar.i(RequestBody.create(MediaType.parse("application/json"), jSONObject4));
            adVar.yj(101);
            adVar.de(mmm.th(true, false));
            fe ad3 = adVar.ad();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            String th2 = ad3.th();
            qwVar.m97switch(elapsedRealtime);
            qwVar.when(th2);
            qwVar.m96if((long) jSONObject4.length());
            ad(str2, ad3);
            ad3.fe(qwVar);
        }
    }
}
