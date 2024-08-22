package fe.fe.ddd.yj.ad;

import com.baidu.searchbox.config.AppConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class rg {

    /* renamed from: ad  reason: collision with root package name */
    public JSONObject f1760ad = new JSONObject();

    /* renamed from: de  reason: collision with root package name */
    public String f1761de;

    /* renamed from: fe  reason: collision with root package name */
    public String f1762fe;
    public JSONObject qw = new JSONObject();

    /* renamed from: rg  reason: collision with root package name */
    public String f1763rg;

    public void ad(JSONObject jSONObject) {
        this.qw = jSONObject;
    }

    public JSONObject de() {
        return this.f1760ad;
    }

    public String fe() {
        return this.f1762fe;
    }

    public void i(String str) {
        this.f1761de = str;
    }

    public void o(String str) {
        this.f1763rg = str;
    }

    public void qw(int i2, int i3, int i4, JSONArray jSONArray) {
        try {
            this.f1760ad.put("count", i2 + "," + i3 + "," + i4);
            this.f1760ad.put("items", jSONArray);
        } catch (JSONException e) {
            if (AppConfig.rg()) {
                "collectDegradegInfo is error" + e.toString();
            }
        }
    }

    public String rg() {
        return this.f1761de;
    }

    public JSONObject th() {
        return this.qw;
    }

    public void uk(String str) {
        this.f1762fe = str;
    }

    public String yj() {
        return this.f1763rg;
    }
}
