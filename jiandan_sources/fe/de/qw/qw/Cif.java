package fe.de.qw.qw;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: fe.de.qw.qw.if  reason: invalid class name */
public class Cif {

    /* renamed from: ad  reason: collision with root package name */
    public final String f1254ad;

    /* renamed from: de  reason: collision with root package name */
    public final JSONObject f1255de = new JSONObject(this.qw);
    public final String qw;

    public Cif(@NonNull String str, @NonNull String str2) throws JSONException {
        this.qw = str;
        this.f1254ad = str2;
    }

    @NonNull
    public String ad() {
        return this.f1255de.optString("orderId");
    }

    @NonNull
    public String de() {
        return this.qw;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cif)) {
            return false;
        }
        Cif ifVar = (Cif) obj;
        return TextUtils.equals(this.qw, ifVar.de()) && TextUtils.equals(this.f1254ad, ifVar.yj());
    }

    @NonNull
    public List<String> fe() {
        return uk();
    }

    public int hashCode() {
        return this.qw.hashCode();
    }

    @Nullable
    public qw qw() {
        String optString = this.f1255de.optString("obfuscatedAccountId");
        String optString2 = this.f1255de.optString("obfuscatedProfileId");
        if (optString == null && optString2 == null) {
            return null;
        }
        return new qw(optString, optString2);
    }

    public int rg() {
        return this.f1255de.optInt("purchaseState", 1) != 4 ? 1 : 2;
    }

    @NonNull
    public String th() {
        JSONObject jSONObject = this.f1255de;
        return jSONObject.optString("token", jSONObject.optString("purchaseToken"));
    }

    @NonNull
    public String toString() {
        return "Purchase. Json: ".concat(String.valueOf(this.qw));
    }

    public final ArrayList uk() {
        ArrayList arrayList = new ArrayList();
        if (this.f1255de.has("productIds")) {
            JSONArray optJSONArray = this.f1255de.optJSONArray("productIds");
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    arrayList.add(optJSONArray.optString(i2));
                }
            }
        } else if (this.f1255de.has("productId")) {
            arrayList.add(this.f1255de.optString("productId"));
        }
        return arrayList;
    }

    @NonNull
    public String yj() {
        return this.f1254ad;
    }
}
