package fe.fe.pf.th.qw;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: fe.fe.pf.th.qw.if  reason: invalid class name */
public class Cif {

    /* renamed from: fe.fe.pf.th.qw.if$qw */
    public class qw implements Comparator<JSONObject> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ String f2924ad;

        public qw(String str) {
            this.f2924ad = str;
        }

        /* renamed from: qw */
        public int compare(JSONObject jSONObject, JSONObject jSONObject2) {
            return jSONObject.optString(this.f2924ad, "").compareTo(jSONObject2.optString(this.f2924ad, ""));
        }
    }

    public static boolean ad(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        String optString = jSONObject.optString(str);
        String optString2 = jSONObject2.optString(str);
        return TextUtils.isEmpty(optString) ? !TextUtils.isEmpty(optString2) : !optString.equals(optString2);
    }

    public static boolean de(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        return jSONObject.optLong(str, -1) != jSONObject2.optLong(str, -1);
    }

    public static JSONArray qw(JSONArray jSONArray, String str) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return jSONArray;
        }
        int length = jSONArray.length();
        ArrayList arrayList = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                arrayList.add(optJSONObject);
            }
        }
        Collections.sort(arrayList, new qw(str));
        return new JSONArray(arrayList);
    }
}
