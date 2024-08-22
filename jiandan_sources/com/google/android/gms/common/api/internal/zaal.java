package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.GoogleApiAvailabilityCache;
import java.util.ArrayList;
import java.util.Map;

public final class zaal extends zaau {
    public final /* synthetic */ zaak zafz;
    public final Map<Api.Client, zaam> zagn;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zaal(zaak zaak, Map<Api.Client, zaam> map) {
        super(zaak, (zaaj) null);
        this.zafz = zaak;
        this.zagn = map;
    }

    @WorkerThread
    public final void zaal() {
        GoogleApiAvailabilityCache googleApiAvailabilityCache = new GoogleApiAvailabilityCache(this.zafz.zaey);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Api.Client next : this.zagn.keySet()) {
            if (!next.requiresGooglePlayServices() || this.zagn.get(next).zaee) {
                arrayList2.add(next);
            } else {
                arrayList.add(next);
            }
        }
        int i2 = -1;
        int i3 = 0;
        if (!arrayList.isEmpty()) {
            int size = arrayList.size();
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                i2 = googleApiAvailabilityCache.getClientAvailability(this.zafz.mContext, (Api.Client) obj);
                if (i2 != 0) {
                    break;
                }
            }
        } else {
            int size2 = arrayList2.size();
            while (i3 < size2) {
                Object obj2 = arrayList2.get(i3);
                i3++;
                i2 = googleApiAvailabilityCache.getClientAvailability(this.zafz.mContext, (Api.Client) obj2);
                if (i2 == 0) {
                    break;
                }
            }
        }
        if (i2 != 0) {
            this.zafz.zafv.zaa(new zaao(this, this.zafz, new ConnectionResult(i2, (PendingIntent) null)));
            return;
        }
        if (this.zafz.zagh && this.zafz.zagf != null) {
            this.zafz.zagf.connect();
        }
        for (Api.Client next2 : this.zagn.keySet()) {
            BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks = this.zagn.get(next2);
            if (!next2.requiresGooglePlayServices() || googleApiAvailabilityCache.getClientAvailability(this.zafz.mContext, next2) == 0) {
                next2.connect(connectionProgressReportCallbacks);
            } else {
                this.zafz.zafv.zaa(new zaan(this, this.zafz, connectionProgressReportCallbacks));
            }
        }
    }
}
