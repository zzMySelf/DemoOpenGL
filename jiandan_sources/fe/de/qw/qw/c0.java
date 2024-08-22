package fe.de.qw.qw;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.zzbe;
import com.android.billingclient.api.zzc;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzu;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c0 extends BroadcastReceiver {

    /* renamed from: ad  reason: collision with root package name */
    public final zzbe f1223ad;

    /* renamed from: de  reason: collision with root package name */
    public final zzc f1224de;

    /* renamed from: fe  reason: collision with root package name */
    public boolean f1225fe;
    public final PurchasesUpdatedListener qw;

    /* renamed from: rg  reason: collision with root package name */
    public final /* synthetic */ d0 f1226rg;

    public /* synthetic */ c0(d0 d0Var, zzbe zzbe, b0 b0Var) {
        this.f1226rg = d0Var;
        this.qw = null;
        this.f1224de = null;
        this.f1223ad = null;
    }

    public final void de(Context context, IntentFilter intentFilter) {
        if (!this.f1225fe) {
            context.registerReceiver(this.f1226rg.f1227ad, intentFilter);
            this.f1225fe = true;
        }
    }

    public final void onReceive(Context context, Intent intent) {
        yj zzi = zzb.zzi(intent, "BillingBroadcastManager");
        String action = intent.getAction();
        if (action.equals("com.android.vending.billing.PURCHASES_UPDATED")) {
            this.qw.fe(zzi, zzb.zzm(intent.getExtras()));
        } else if (action.equals("com.android.vending.billing.ALTERNATIVE_BILLING")) {
            Bundle extras = intent.getExtras();
            if (zzi.ad() != 0) {
                this.qw.fe(zzi, zzu.zzl());
            } else if (this.f1224de == null) {
                zzb.zzo("BillingBroadcastManager", "AlternativeBillingListener is null.");
                this.qw.fe(l.f1263th, zzu.zzl());
            } else if (extras == null) {
                zzb.zzo("BillingBroadcastManager", "Bundle is null.");
                this.qw.fe(l.f1263th, zzu.zzl());
            } else {
                String string = extras.getString("ALTERNATIVE_BILLING_USER_CHOICE_DATA");
                if (string != null) {
                    try {
                        JSONArray optJSONArray = new JSONObject(string).optJSONArray("products");
                        ArrayList arrayList = new ArrayList();
                        if (optJSONArray != null) {
                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                                if (optJSONObject != null) {
                                    arrayList.add(new a0(optJSONObject, (z) null));
                                }
                            }
                        }
                        this.f1224de.qw();
                    } catch (JSONException unused) {
                        zzb.zzo("BillingBroadcastManager", String.format("Error when parsing invalid alternative choice data: [%s]", new Object[]{string}));
                        this.qw.fe(l.f1263th, zzu.zzl());
                    }
                } else {
                    zzb.zzo("BillingBroadcastManager", "Couldn't find alternative billing user choice data in bundle.");
                    this.qw.fe(l.f1263th, zzu.zzl());
                }
            }
        }
    }

    public /* synthetic */ c0(d0 d0Var, PurchasesUpdatedListener purchasesUpdatedListener, zzc zzc, b0 b0Var) {
        this.f1226rg = d0Var;
        this.qw = purchasesUpdatedListener;
        this.f1224de = zzc;
        this.f1223ad = null;
    }
}
