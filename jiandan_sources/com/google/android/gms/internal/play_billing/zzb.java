package com.google.android.gms.internal.play_billing;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.android.billingclient.api.ProxyBillingActivity;
import fe.de.qw.qw.Cif;
import fe.de.qw.qw.ad;
import fe.de.qw.qw.i;
import fe.de.qw.qw.ppp;
import fe.de.qw.qw.th;
import fe.de.qw.qw.uk;
import fe.de.qw.qw.y;
import fe.de.qw.qw.yj;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;

public final class zzb {
    public static final int zza = Runtime.getRuntime().availableProcessors();

    public static int zza(Intent intent, String str) {
        if (intent != null) {
            return zzq(intent.getExtras(), ProxyBillingActivity.TAG);
        }
        zzo(ProxyBillingActivity.TAG, "Got null intent!");
        return 0;
    }

    public static int zzb(Bundle bundle, String str) {
        if (bundle == null) {
            zzo(str, "Unexpected null bundle received!");
            return 6;
        }
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            zzn(str, "getResponseCodeFromBundle() got null response code, assuming OK");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            zzo(str, "Unexpected type for bundle response code: ".concat(String.valueOf(obj.getClass().getName())));
            return 6;
        }
    }

    public static Bundle zzc(ad adVar, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("playBillingLibraryVersion", str);
        return bundle;
    }

    public static Bundle zzd(uk ukVar, boolean z, String str) {
        Bundle bundle = new Bundle();
        if (z) {
            bundle.putString("playBillingLibraryVersion", str);
        }
        return bundle;
    }

    public static Bundle zze(int i2, boolean z, String str, @Nullable String str2, ArrayList arrayList) {
        Bundle bundle = new Bundle();
        if (i2 >= 9) {
            bundle.putString("playBillingLibraryVersion", str);
        }
        if (i2 >= 9 && z) {
            bundle.putBoolean("enablePendingPurchases", true);
        }
        if (i2 >= 14) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            int size = arrayList.size();
            boolean z2 = false;
            boolean z3 = false;
            for (int i3 = 0; i3 < size; i3++) {
                y yVar = (y) arrayList.get(i3);
                arrayList2.add((Object) null);
                z2 |= !TextUtils.isEmpty((CharSequence) null);
                arrayList3.add((Object) null);
                z3 |= !TextUtils.isEmpty((CharSequence) null);
                arrayList4.add(0);
            }
            if (z2) {
                bundle.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList2);
            }
            if (z3) {
                bundle.putStringArrayList("SKU_OFFER_ID_LIST", arrayList3);
            }
        }
        return bundle;
    }

    public static Bundle zzf(th thVar, boolean z, boolean z2, boolean z3, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("playBillingLibraryVersion", str);
        if (thVar.ad() != 0) {
            bundle.putInt("prorationMode", thVar.ad());
        }
        if (!TextUtils.isEmpty(thVar.de())) {
            bundle.putString("accountId", thVar.de());
        }
        if (!TextUtils.isEmpty(thVar.fe())) {
            bundle.putString("obfuscatedProfileId", thVar.fe());
        }
        if (thVar.ppp()) {
            bundle.putBoolean("isOfferPersonalizedByDeveloper", true);
        }
        if (!TextUtils.isEmpty((CharSequence) null)) {
            bundle.putStringArrayList("skusToReplace", new ArrayList(Arrays.asList(new String[]{null})));
        }
        if (!TextUtils.isEmpty(thVar.rg())) {
            bundle.putString("oldSkuPurchaseToken", thVar.rg());
        }
        if (!TextUtils.isEmpty((CharSequence) null)) {
            bundle.putString("oldSkuPurchaseId", (String) null);
        }
        if (!TextUtils.isEmpty((CharSequence) null)) {
            bundle.putString("originalExternalTransactionId", (String) null);
        }
        if (!TextUtils.isEmpty((CharSequence) null)) {
            bundle.putString("paymentsPurchaseParams", (String) null);
        }
        if (z && z2) {
            bundle.putBoolean("enablePendingPurchases", true);
        }
        if (z3) {
            bundle.putBoolean("enableAlternativeBilling", true);
        }
        return bundle;
    }

    public static Bundle zzg(String str, ArrayList arrayList, @Nullable String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("playBillingLibraryVersion", str);
        bundle.putBoolean("enablePendingPurchases", true);
        bundle.putString("SKU_DETAILS_RESPONSE_FORMAT", "PRODUCT_DETAILS");
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            ppp.ad adVar = (ppp.ad) arrayList.get(i2);
            arrayList2.add((Object) null);
            z |= !TextUtils.isEmpty((CharSequence) null);
        }
        if (z) {
            bundle.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList2);
        }
        return bundle;
    }

    public static Bundle zzh(boolean z, boolean z2, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("playBillingLibraryVersion", str);
        if (z && z2) {
            bundle.putBoolean("enablePendingPurchases", true);
        }
        return bundle;
    }

    public static yj zzi(Intent intent, String str) {
        if (intent == null) {
            zzo("BillingHelper", "Got null intent!");
            yj.qw de2 = yj.de();
            de2.de(6);
            de2.ad("An internal error occurred.");
            return de2.qw();
        }
        yj.qw de3 = yj.de();
        de3.de(zzb(intent.getExtras(), str));
        de3.ad(zzk(intent.getExtras(), str));
        return de3.qw();
    }

    public static i zzj(Bundle bundle, String str) {
        if (bundle == null) {
            return new i(0, (String) null);
        }
        return new i(zzq(bundle, "BillingClient"), bundle.getString("IN_APP_MESSAGE_PURCHASE_TOKEN"));
    }

    public static String zzk(Bundle bundle, String str) {
        if (bundle == null) {
            zzo(str, "Unexpected null bundle received!");
            return "";
        }
        Object obj = bundle.get("DEBUG_MESSAGE");
        if (obj == null) {
            zzn(str, "getDebugMessageFromBundle() got null response code, assuming OK");
            return "";
        } else if (obj instanceof String) {
            return (String) obj;
        } else {
            zzo(str, "Unexpected type for debug message: ".concat(String.valueOf(obj.getClass().getName())));
            return "";
        }
    }

    public static String zzl(int i2) {
        return zza.zza(i2).toString();
    }

    @Nullable
    public static List zzm(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        ArrayList arrayList = new ArrayList();
        if (stringArrayList == null || stringArrayList2 == null) {
            Cif zzr = zzr(bundle.getString("INAPP_PURCHASE_DATA"), bundle.getString("INAPP_DATA_SIGNATURE"));
            if (zzr == null) {
                zzn("BillingHelper", "Couldn't find single purchase data as well.");
                return null;
            }
            arrayList.add(zzr);
        } else {
            int size = stringArrayList.size();
            zzn("BillingHelper", "Found purchase list of " + size + " items");
            int i2 = 0;
            while (i2 < stringArrayList.size() && i2 < stringArrayList2.size()) {
                Cif zzr2 = zzr(stringArrayList.get(i2), stringArrayList2.get(i2));
                if (zzr2 != null) {
                    arrayList.add(zzr2);
                }
                i2++;
            }
        }
        return arrayList;
    }

    public static void zzn(String str, String str2) {
        if (Log.isLoggable(str, 2) && !str2.isEmpty()) {
            int i2 = 40000;
            while (!str2.isEmpty() && i2 > 0) {
                int min = Math.min(str2.length(), Math.min(4000, i2));
                str2.substring(0, min);
                str2 = str2.substring(min);
                i2 -= min;
            }
        }
    }

    public static void zzo(String str, String str2) {
        if (Log.isLoggable(str, 5)) {
        }
    }

    public static void zzp(String str, String str2, Throwable th2) {
        if (Log.isLoggable(str, 5)) {
        }
    }

    public static int zzq(Bundle bundle, String str) {
        if (bundle != null) {
            return bundle.getInt("IN_APP_MESSAGE_RESPONSE_CODE", 0);
        }
        zzo(str, "Unexpected null bundle received!");
        return 0;
    }

    @Nullable
    public static Cif zzr(String str, String str2) {
        if (str == null || str2 == null) {
            zzn("BillingHelper", "Received a null purchase data.");
            return null;
        }
        try {
            return new Cif(str, str2);
        } catch (JSONException e) {
            zzo("BillingHelper", "Got JSONException while parsing purchase data: ".concat(e.toString()));
            return null;
        }
    }
}
