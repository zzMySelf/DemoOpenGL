package fe.de.qw.qw;

import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzb;
import fe.de.qw.qw.yj;
import java.util.ArrayList;

public final class r {
    public static yj qw(Bundle bundle, String str, String str2) {
        yj yjVar = l.f1263th;
        if (bundle == null) {
            zzb.zzo("BillingClient", String.format("%s got null owned items list", new Object[]{str2}));
            return yjVar;
        }
        int zzb = zzb.zzb(bundle, "BillingClient");
        String zzk = zzb.zzk(bundle, "BillingClient");
        yj.qw de2 = yj.de();
        de2.de(zzb);
        de2.ad(zzk);
        yj qw = de2.qw();
        if (zzb != 0) {
            zzb.zzo("BillingClient", String.format("%s failed. Response code: %s", new Object[]{str2, Integer.valueOf(zzb)}));
            return qw;
        } else if (!bundle.containsKey("INAPP_PURCHASE_ITEM_LIST") || !bundle.containsKey("INAPP_PURCHASE_DATA_LIST") || !bundle.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
            zzb.zzo("BillingClient", String.format("Bundle returned from %s doesn't contain required fields.", new Object[]{str2}));
            return yjVar;
        } else {
            ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
            ArrayList<String> stringArrayList2 = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
            ArrayList<String> stringArrayList3 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
            if (stringArrayList == null) {
                zzb.zzo("BillingClient", String.format("Bundle returned from %s contains null SKUs list.", new Object[]{str2}));
                return yjVar;
            } else if (stringArrayList2 == null) {
                zzb.zzo("BillingClient", String.format("Bundle returned from %s contains null purchases list.", new Object[]{str2}));
                return yjVar;
            } else if (stringArrayList3 != null) {
                return l.f1265yj;
            } else {
                zzb.zzo("BillingClient", String.format("Bundle returned from %s contains null signatures list.", new Object[]{str2}));
                return yjVar;
            }
        }
    }
}
