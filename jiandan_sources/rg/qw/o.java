package rg.qw;

import android.content.SharedPreferences;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;
import rg.qw.uk;

public class o extends uk<JSONObject> {

    public class qw implements uk.qw<JSONObject> {
        /* renamed from: de */
        public JSONObject qw() {
            return new JSONObject();
        }

        /* renamed from: fe */
        public JSONObject load(String str) {
            try {
                return new JSONObject(str);
            } catch (JSONException unused) {
                return null;
            }
        }

        /* renamed from: rg */
        public String ad(JSONObject jSONObject) {
            return jSONObject.toString();
        }
    }

    public o(Future<SharedPreferences> future) {
        super(future, "super_properties", new qw());
    }
}
