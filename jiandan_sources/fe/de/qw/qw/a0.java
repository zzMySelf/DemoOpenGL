package fe.de.qw.qw;

import androidx.annotation.Nullable;
import java.util.Arrays;
import org.json.JSONObject;

public final class a0 {

    /* renamed from: ad  reason: collision with root package name */
    public final String f1217ad;
    public final String qw;

    public /* synthetic */ a0(JSONObject jSONObject, z zVar) {
        this.qw = jSONObject.optString("productId");
        this.f1217ad = jSONObject.optString("productType");
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return this.qw.equals(a0Var.qw) && this.f1217ad.equals(a0Var.f1217ad);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.qw, this.f1217ad});
    }

    public final String toString() {
        return String.format("{id: %s, type: %s}", new Object[]{this.qw, this.f1217ad});
    }
}
