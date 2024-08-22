package fe.fe.mmm;

import android.text.TextUtils;
import com.alipay.sdk.m.m.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class nn {
    public static final boolean when = tt.vvv();

    /* renamed from: ad  reason: collision with root package name */
    public int f2067ad;

    /* renamed from: de  reason: collision with root package name */
    public JSONObject f2068de;

    /* renamed from: fe  reason: collision with root package name */
    public JSONObject f2069fe;

    /* renamed from: i  reason: collision with root package name */
    public int f2070i;

    /* renamed from: if  reason: not valid java name */
    public int f54if;

    /* renamed from: o  reason: collision with root package name */
    public int f2071o;

    /* renamed from: pf  reason: collision with root package name */
    public Integer f2072pf;
    public int qw;

    /* renamed from: rg  reason: collision with root package name */
    public JSONObject f2073rg;

    /* renamed from: switch  reason: not valid java name */
    public List<Cswitch> f55switch = new ArrayList();

    /* renamed from: th  reason: collision with root package name */
    public String f2074th;

    /* renamed from: uk  reason: collision with root package name */
    public int f2075uk;

    /* renamed from: yj  reason: collision with root package name */
    public int f2076yj;

    public nn(String str, JSONObject jSONObject) {
        this.f2068de = jSONObject;
    }

    public JSONObject ad() {
        return this.f2073rg;
    }

    public List<Cswitch> de() {
        return this.f55switch;
    }

    public int fe() {
        return this.f2076yj;
    }

    public int i() {
        return this.qw;
    }

    /* renamed from: if  reason: not valid java name */
    public boolean m130if() {
        try {
            if (this.f2068de == null) {
                return false;
            }
            if (this.f2068de.length() == 0) {
                return false;
            }
            JSONObject jSONObject = this.f2068de;
            this.f2069fe = jSONObject.optJSONObject("set");
            this.qw = jSONObject.optInt("threshold", 10000);
            this.f2067ad = jSONObject.optInt("timeup", 604800000);
            this.f2074th = jSONObject.optString("step");
            jSONObject.optString("replace");
            this.f2073rg = jSONObject.optJSONObject("del");
            this.f2076yj = jSONObject.optInt("all_size", 614400);
            this.f2075uk = jSONObject.optInt("single_size", 153600);
            this.f2070i = jSONObject.optInt("real_size", 614400);
            this.f2071o = jSONObject.optInt("non_real_size", 614400);
            this.f54if = jSONObject.optInt("trigger_number", 100);
            this.f2072pf = Integer.valueOf(jSONObject.optInt("biz_param_size", 512));
            int i2 = 1;
            if (this.f2069fe == null) {
                return true;
            }
            Iterator<String> keys = this.f2069fe.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next)) {
                    JSONObject optJSONObject = this.f2069fe.optJSONObject(next);
                    if (optJSONObject != null) {
                        if (optJSONObject.length() != 0) {
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
                            String optString = optJSONObject.optString("version");
                            if (optJSONObject2 != null) {
                                if (!TextUtils.isEmpty(optString)) {
                                    Iterator<String> it = keys;
                                    JSONObject jSONObject2 = optJSONObject2;
                                    Cswitch switchR = new Cswitch(next, optJSONObject2.optInt("switch", i2) != 0, optJSONObject2.optInt("isreal", 0) == 1, optJSONObject2.optInt(a.Z, 60), optJSONObject2.optInt("type", 0), optJSONObject2.optInt("isAbtest", 0) == 1);
                                    if (ggg.qw(next)) {
                                        switchR.b(jSONObject2.optInt("isSend", 1) == 1);
                                    }
                                    if (jSONObject2.has("rate")) {
                                        switchR.g(jSONObject2.getInt("rate"));
                                    }
                                    if (jSONObject2.has("c")) {
                                        switchR.eee(jSONObject2.getString("c"));
                                    }
                                    if (jSONObject2.has("limitUnit")) {
                                        switchR.d(jSONObject2.getInt("limitUnit"));
                                    }
                                    if (jSONObject2.has("limitCnt")) {
                                        switchR.c(jSONObject2.getInt("limitCnt"));
                                    }
                                    if (jSONObject2.has("idtype")) {
                                        switchR.tt(jSONObject2.getInt("idtype"));
                                    }
                                    switchR.f(jSONObject2.optInt("ch", 0) == 1);
                                    if (jSONObject2.has("dfc")) {
                                        switchR.a(jSONObject2.getInt("dfc") == 1);
                                    }
                                    if (jSONObject2.has("reallog")) {
                                        switchR.h(jSONObject2.getInt("reallog") == 1);
                                    }
                                    if (jSONObject2.has("gflow")) {
                                        switchR.rrr(jSONObject2.getInt("gflow"));
                                    }
                                    if (jSONObject2.has("uploadType")) {
                                        switchR.j(jSONObject2.optInt("uploadType", -1));
                                    }
                                    int optInt = jSONObject2.optInt("lcache", 2);
                                    if (optInt == 1 || optInt == 0) {
                                        switchR.e(optInt);
                                    }
                                    switchR.k(optString);
                                    JSONArray optJSONArray = jSONObject2.optJSONArray("bizparam");
                                    if (optJSONArray != null && optJSONArray.length() > 0) {
                                        switchR.qqq(optJSONArray);
                                    }
                                    this.f55switch.add(switchR);
                                    keys = it;
                                    i2 = 1;
                                }
                            }
                        }
                    }
                }
            }
            return true;
        } catch (JSONException e) {
            if (when) {
                e.printStackTrace();
            }
            return false;
        }
    }

    public int o() {
        return this.f2067ad;
    }

    public int pf() {
        return this.f54if;
    }

    public int qw() {
        Integer num = this.f2072pf;
        if (num == null) {
            return 512;
        }
        return num.intValue();
    }

    public int rg() {
        return this.f2071o;
    }

    /* renamed from: switch  reason: not valid java name */
    public void m131switch(List<Cswitch> list) {
        this.f55switch = list;
    }

    public int th() {
        return this.f2070i;
    }

    public String uk() {
        return this.f2074th;
    }

    public int yj() {
        return this.f2075uk;
    }

    public nn(List<Cswitch> list) {
        if (list != null && list.size() > 0) {
            this.f55switch.addAll(list);
        }
    }
}
