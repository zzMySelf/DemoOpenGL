package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;

public final class zau implements zabs {
    public final /* synthetic */ zaq zaet;

    public zau(zaq zaq) {
        this.zaet = zaq;
    }

    public final void zab(@Nullable Bundle bundle) {
        this.zaet.zaer.lock();
        try {
            ConnectionResult unused = this.zaet.zaep = ConnectionResult.RESULT_SUCCESS;
            this.zaet.zav();
        } finally {
            this.zaet.zaer.unlock();
        }
    }

    public final void zac(@NonNull ConnectionResult connectionResult) {
        this.zaet.zaer.lock();
        try {
            ConnectionResult unused = this.zaet.zaep = connectionResult;
            this.zaet.zav();
        } finally {
            this.zaet.zaer.unlock();
        }
    }

    public /* synthetic */ zau(zaq zaq, zat zat) {
        this(zaq);
    }

    public final void zab(int i2, boolean z) {
        this.zaet.zaer.lock();
        try {
            if (this.zaet.zaeq) {
                boolean unused = this.zaet.zaeq = false;
                this.zaet.zaa(i2, z);
                return;
            }
            boolean unused2 = this.zaet.zaeq = true;
            this.zaet.zaei.onConnectionSuspended(i2);
            this.zaet.zaer.unlock();
        } finally {
            this.zaet.zaer.unlock();
        }
    }
}
