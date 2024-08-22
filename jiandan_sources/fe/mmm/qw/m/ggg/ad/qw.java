package fe.mmm.qw.m.ggg.ad;

import com.tera.scan.webview.hybrid.call.ICallEntity;
import org.json.JSONException;
import org.json.JSONObject;

public class qw implements ICallEntity {

    /* renamed from: ad  reason: collision with root package name */
    public int f8034ad;

    /* renamed from: de  reason: collision with root package name */
    public String f8035de;

    /* renamed from: fe  reason: collision with root package name */
    public JSONObject f8036fe;
    public String qw;

    public qw(String str, int i2, String str2, JSONObject jSONObject) {
        this.qw = str;
        this.f8034ad = i2;
        this.f8035de = str2;
        this.f8036fe = jSONObject;
    }

    public String qw() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("code", this.f8034ad);
            jSONObject2.put("msg", this.f8035de);
            jSONObject2.put("result", this.f8036fe);
            jSONObject.put("callbackId", this.qw);
            jSONObject.put("data", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
