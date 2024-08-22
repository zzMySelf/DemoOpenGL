package fe.mmm.qw.m.ggg.ad;

import com.alipay.sdk.m.l.c;
import com.tera.scan.webview.hybrid.call.ICallEntity;
import org.json.JSONException;
import org.json.JSONObject;

public class rg implements ICallEntity {

    /* renamed from: ad  reason: collision with root package name */
    public String f8037ad;

    /* renamed from: de  reason: collision with root package name */
    public String f8038de;

    /* renamed from: fe  reason: collision with root package name */
    public String f8039fe;
    public String qw;

    public rg(String str, String str2, String str3, String str4) {
        this.qw = str;
        this.f8037ad = str2;
        this.f8038de = str3;
        this.f8039fe = str4;
    }

    public String qw() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(c.n, this.f8038de);
            jSONObject2.put("func", this.f8039fe);
            jSONObject.put("data", jSONObject2);
            jSONObject.put("handlerName", this.qw);
            jSONObject.put("callbackId", this.f8037ad);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
