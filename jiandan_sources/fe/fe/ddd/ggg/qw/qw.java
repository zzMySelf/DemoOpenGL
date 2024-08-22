package fe.fe.ddd.ggg.qw;

import com.baidu.searchbox.config.AppConfig;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

public class qw {

    /* renamed from: fe  reason: collision with root package name */
    public static final boolean f1443fe = AppConfig.rg();

    /* renamed from: ad  reason: collision with root package name */
    public JSONObject f1444ad;

    /* renamed from: de  reason: collision with root package name */
    public JSONObject f1445de;
    public JSONObject qw;

    public qw(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        if (!f1443fe || !(jSONObject == null || jSONObject2 == null)) {
            this.qw = jSONObject == null ? new JSONObject() : jSONObject;
            this.f1444ad = jSONObject2 == null ? new JSONObject() : jSONObject2;
            this.f1445de = jSONObject3;
            return;
        }
        throw new RuntimeException("version and data can not be null, it is impossible");
    }

    public final void ad(JSONObject jSONObject) {
        LinkedList<String> linkedList = new LinkedList<>();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject optJSONObject = jSONObject.optJSONObject(next);
            if (optJSONObject != null && optJSONObject.length() == 0) {
                linkedList.add(next);
            }
        }
        for (String remove : linkedList) {
            jSONObject.remove(remove);
        }
    }

    public JSONObject de() {
        return this.f1444ad;
    }

    public JSONObject fe() {
        return this.f1445de;
    }

    public void qw() {
        ad(this.qw);
        ad(this.f1444ad);
    }

    public JSONObject rg() {
        return this.qw;
    }
}
