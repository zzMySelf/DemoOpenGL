package fe.de.qw.qw;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;

@Deprecated
public class vvv {

    /* renamed from: ad  reason: collision with root package name */
    public final JSONObject f1301ad;
    public final String qw;

    @NonNull
    public String ad() {
        return this.f1301ad.optString("type");
    }

    public int de() {
        return this.f1301ad.optInt("offer_type");
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof vvv)) {
            return false;
        }
        return TextUtils.equals(this.qw, ((vvv) obj).qw);
    }

    @NonNull
    public String fe() {
        return this.f1301ad.optString("offer_id");
    }

    public int hashCode() {
        return this.qw.hashCode();
    }

    @NonNull
    public String qw() {
        return this.f1301ad.optString("productId");
    }

    @NonNull
    public String rg() {
        String optString = this.f1301ad.optString("offerIdToken");
        return optString.isEmpty() ? this.f1301ad.optString("offer_id_token") : optString;
    }

    @NonNull
    public final String th() {
        return this.f1301ad.optString("packageName");
    }

    @NonNull
    public String toString() {
        return "SkuDetails: ".concat(String.valueOf(this.qw));
    }

    public final String uk() {
        return this.f1301ad.optString("skuDetailsToken");
    }

    @NonNull
    public String yj() {
        return this.f1301ad.optString("serializedDocid");
    }
}
