package fe.mmm.qw.m.ggg.ad;

import com.tera.scan.webview.hybrid.call.ICallEntity;
import org.json.JSONException;
import org.json.JSONObject;

public class ad implements ICallEntity {

    /* renamed from: ad  reason: collision with root package name */
    public int f8028ad;

    /* renamed from: de  reason: collision with root package name */
    public String f8029de;

    /* renamed from: fe  reason: collision with root package name */
    public JSONObject f8030fe;
    public String qw;

    public ad(String str, int i2, String str2, JSONObject jSONObject) {
        this.qw = str;
        this.f8028ad = i2;
        this.f8029de = str2;
        this.f8030fe = jSONObject;
    }

    public String qw() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("code", this.f8028ad);
            jSONObject2.put("msg", this.f8029de);
            jSONObject2.put("result", this.f8030fe);
            jSONObject.put("responseName", this.qw);
            jSONObject.put("responseData", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
