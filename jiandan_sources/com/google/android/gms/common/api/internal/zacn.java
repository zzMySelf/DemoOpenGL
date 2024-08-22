package com.google.android.gms.common.api.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;

public final class zacn implements Runnable {
    public final /* synthetic */ zack zaky;
    public final /* synthetic */ Result zakz;

    public zacn(zack zack, Result result) {
        this.zaky = zack;
        this.zakz = result;
    }

    @WorkerThread
    public final void run() {
        try {
            BasePendingResult.zado.set(Boolean.TRUE);
            this.zaky.zakw.sendMessage(this.zaky.zakw.obtainMessage(0, this.zaky.zakr.onSuccess(this.zakz)));
            BasePendingResult.zado.set(Boolean.FALSE);
            zack.zab(this.zakz);
            GoogleApiClient googleApiClient = (GoogleApiClient) this.zaky.zadr.get();
            if (googleApiClient != null) {
                googleApiClient.zab(this.zaky);
            }
        } catch (RuntimeException e) {
            this.zaky.zakw.sendMessage(this.zaky.zakw.obtainMessage(1, e));
            BasePendingResult.zado.set(Boolean.FALSE);
            zack.zab(this.zakz);
            GoogleApiClient googleApiClient2 = (GoogleApiClient) this.zaky.zadr.get();
            if (googleApiClient2 != null) {
                googleApiClient2.zab(this.zaky);
            }
        } catch (Throwable th2) {
            BasePendingResult.zado.set(Boolean.FALSE);
            zack.zab(this.zakz);
            GoogleApiClient googleApiClient3 = (GoogleApiClient) this.zaky.zadr.get();
            if (googleApiClient3 != null) {
                googleApiClient3.zab(this.zaky);
            }
            throw th2;
        }
    }
}
