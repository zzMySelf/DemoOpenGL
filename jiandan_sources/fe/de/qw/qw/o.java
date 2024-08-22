package fe.de.qw.qw;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.biometric.BiometricPrompt;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class o {

    /* renamed from: ad  reason: collision with root package name */
    public final JSONObject f1269ad;

    /* renamed from: de  reason: collision with root package name */
    public final String f1270de;

    /* renamed from: fe  reason: collision with root package name */
    public final String f1271fe = this.f1269ad.optString("type");
    public final String qw;

    /* renamed from: rg  reason: collision with root package name */
    public final String f1272rg;

    /* renamed from: th  reason: collision with root package name */
    public final String f1273th;
    @Nullable

    /* renamed from: yj  reason: collision with root package name */
    public final List f1274yj;

    public static final class ad {
        public ad(JSONObject jSONObject) {
            jSONObject.optString("billingPeriod");
            jSONObject.optString("priceCurrencyCode");
            jSONObject.optString("formattedPrice");
            jSONObject.optLong("priceAmountMicros");
            jSONObject.optInt("recurrenceMode");
            jSONObject.optInt("billingCycleCount");
        }
    }

    public static class de {
        public de(JSONArray jSONArray) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        arrayList.add(new ad(optJSONObject));
                    }
                }
            }
        }
    }

    public static final class fe {
        public final String qw;

        public fe(JSONObject jSONObject) throws JSONException {
            this.qw = jSONObject.getString("offerIdToken");
            new de(jSONObject.getJSONArray("pricingPhases"));
            JSONObject optJSONObject = jSONObject.optJSONObject("installmentPlanDetails");
            if (optJSONObject != null) {
                new p(optJSONObject);
            }
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("offerTags");
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    arrayList.add(optJSONArray.getString(i2));
                }
            }
        }

        @NonNull
        public String qw() {
            return this.qw;
        }
    }

    public static final class qw {
        public final String qw;

        public qw(JSONObject jSONObject) {
            jSONObject.optString("formattedPrice");
            jSONObject.optLong("priceAmountMicros");
            jSONObject.optString("priceCurrencyCode");
            this.qw = jSONObject.optString("offerIdToken");
            jSONObject.optString("offerId");
            jSONObject.optInt("offerType");
        }

        @NonNull
        public final String qw() {
            return this.qw;
        }
    }

    public o(String str) throws JSONException {
        this.qw = str;
        JSONObject jSONObject = new JSONObject(this.qw);
        this.f1269ad = jSONObject;
        this.f1270de = jSONObject.optString("productId");
        if (TextUtils.isEmpty(this.f1270de)) {
            throw new IllegalArgumentException("Product id cannot be empty.");
        } else if (!TextUtils.isEmpty(this.f1271fe)) {
            this.f1272rg = this.f1269ad.optString("title");
            this.f1269ad.optString("name");
            this.f1269ad.optString(BiometricPrompt.KEY_DESCRIPTION);
            this.f1273th = this.f1269ad.optString("skuDetailsToken");
            if (!this.f1271fe.equals("inapp")) {
                ArrayList arrayList = new ArrayList();
                JSONArray optJSONArray = this.f1269ad.optJSONArray("subscriptionOfferDetails");
                if (optJSONArray != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        arrayList.add(new fe(optJSONArray.getJSONObject(i2)));
                    }
                }
                this.f1274yj = arrayList;
                return;
            }
            this.f1274yj = null;
        } else {
            throw new IllegalArgumentException("Product type cannot be empty.");
        }
    }

    @NonNull
    public String ad() {
        return this.f1270de;
    }

    @NonNull
    public String de() {
        return this.f1271fe;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        return TextUtils.equals(this.qw, ((o) obj).qw);
    }

    @Nullable
    public List<fe> fe() {
        return this.f1274yj;
    }

    public final int hashCode() {
        return this.qw.hashCode();
    }

    @Nullable
    public qw qw() {
        JSONObject optJSONObject = this.f1269ad.optJSONObject("oneTimePurchaseOfferDetails");
        if (optJSONObject != null) {
            return new qw(optJSONObject);
        }
        return null;
    }

    @NonNull
    public final String rg() {
        return this.f1269ad.optString("packageName");
    }

    public final String th() {
        return this.f1273th;
    }

    @NonNull
    public final String toString() {
        String str = this.qw;
        String obj = this.f1269ad.toString();
        String str2 = this.f1270de;
        String str3 = this.f1271fe;
        String str4 = this.f1272rg;
        String str5 = this.f1273th;
        String valueOf = String.valueOf(this.f1274yj);
        return "ProductDetails{jsonString='" + str + "', parsedJson=" + obj + ", productId='" + str2 + "', productType='" + str3 + "', title='" + str4 + "', productDetailsToken='" + str5 + "', subscriptionOfferDetails=" + valueOf + "}";
    }
}
