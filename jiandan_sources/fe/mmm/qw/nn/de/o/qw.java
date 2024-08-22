package fe.mmm.qw.nn.de.o;

import android.net.Uri;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class qw extends ad {

    /* renamed from: yj  reason: collision with root package name */
    public JSONObject f8109yj = new JSONObject();

    public void ad(String str, String str2) {
        uk(str, Uri.encode(str2));
    }

    /* renamed from: fe */
    public ad clone() {
        try {
            return super.clone();
        } catch (Exception unused) {
            qw qwVar = new qw();
            qwVar.f8109yj = this.f8109yj;
            return qwVar;
        }
    }

    public boolean rg(String str) {
        return str != null && this.f8109yj.has(str);
    }

    public String toString() {
        return this.f8109yj.toString();
    }

    public void uk(String str, Object obj) {
        try {
            this.f8109yj.put(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void yj(String str, JSONArray jSONArray) {
        uk(str, jSONArray);
    }
}
