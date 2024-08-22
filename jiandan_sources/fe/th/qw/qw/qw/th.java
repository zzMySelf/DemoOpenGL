package fe.th.qw.qw.qw;

import android.text.TextUtils;
import com.duxiaoman.dxmpay.statistics.StatApi;
import java.util.Collection;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class th {

    /* renamed from: ad  reason: collision with root package name */
    public long f5586ad;

    /* renamed from: de  reason: collision with root package name */
    public String f5587de;

    /* renamed from: fe  reason: collision with root package name */
    public String f5588fe;

    /* renamed from: i  reason: collision with root package name */
    public int f5589i;
    public String qw;

    /* renamed from: rg  reason: collision with root package name */
    public String f5590rg;

    /* renamed from: th  reason: collision with root package name */
    public long f5591th;

    /* renamed from: uk  reason: collision with root package name */
    public Map<String, Object> f5592uk;

    /* renamed from: yj  reason: collision with root package name */
    public String f5593yj;

    public static th qw(String str, long j, String str2, long j2, String str3, Collection<String> collection, Map<String, Object> map, String str4) {
        th thVar = new th();
        thVar.f5589i = uk.qw(StatApi.getAppContext());
        thVar.qw = str;
        thVar.f5586ad = j;
        thVar.f5588fe = str2;
        thVar.f5591th = j2;
        thVar.f5590rg = str3;
        thVar.f5593yj = str4;
        if (collection != null) {
            JSONArray jSONArray = new JSONArray();
            for (String put : collection) {
                jSONArray.put(put);
            }
            thVar.f5587de = jSONArray.toString();
        }
        if (map != null && !map.isEmpty()) {
            thVar.f5592uk = map;
        }
        return thVar;
    }

    public JSONObject ad() throws NullPointerException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("nt", this.f5589i);
            jSONObject.put("en", this.qw);
            jSONObject.put("et", this.f5586ad);
            jSONObject.put("nu", this.f5591th);
            if (!TextUtils.isEmpty(this.f5588fe)) {
                jSONObject.put("eg", this.f5588fe);
            }
            jSONObject.putOpt("lk", this.f5590rg);
            if (this.f5587de != null) {
                jSONObject.put("ev", this.f5587de);
            }
            if (!TextUtils.isEmpty(this.f5593yj)) {
                jSONObject.put("at", this.f5593yj);
            }
            if (this.f5592uk != null && !this.f5592uk.isEmpty()) {
                for (Map.Entry next : this.f5592uk.entrySet()) {
                    if (next.getValue() instanceof Integer) {
                        jSONObject.put((String) next.getKey(), ((Integer) next.getValue()).intValue());
                    } else if (next.getValue() instanceof Long) {
                        jSONObject.put((String) next.getKey(), ((Long) next.getValue()).longValue());
                    } else if (next.getValue() instanceof Double) {
                        jSONObject.put((String) next.getKey(), ((Double) next.getValue()).doubleValue());
                    } else if (next.getValue() instanceof Short) {
                        jSONObject.put((String) next.getKey(), ((Short) next.getValue()).shortValue());
                    } else if (next.getValue() instanceof Float) {
                        jSONObject.put((String) next.getKey(), (double) ((Float) next.getValue()).floatValue());
                    } else if (next.getValue() instanceof Byte) {
                        jSONObject.put((String) next.getKey(), ((Byte) next.getValue()).byteValue());
                    } else if (next.getValue() instanceof String) {
                        jSONObject.put((String) next.getKey(), next.getValue().toString());
                    }
                }
            }
        } catch (Exception unused) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            return jSONObject;
        }
        throw null;
    }
}
