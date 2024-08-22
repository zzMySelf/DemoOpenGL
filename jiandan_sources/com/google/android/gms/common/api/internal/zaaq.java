package com.google.android.gms.common.api.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;

public final class zaaq extends zaau {
    public final /* synthetic */ zaak zafz;
    public final ArrayList<Api.Client> zags;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zaaq(zaak zaak, ArrayList<Api.Client> arrayList) {
        super(zaak, (zaaj) null);
        this.zafz = zaak;
        this.zags = arrayList;
    }

    @WorkerThread
    public final void zaal() {
        this.zafz.zafv.zaeh.zahe = this.zafz.zaar();
        ArrayList<Api.Client> arrayList = this.zags;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Api.Client client = arrayList.get(i2);
            i2++;
            client.getRemoteService(this.zafz.zagj, this.zafz.zafv.zaeh.zahe);
        }
    }
}
