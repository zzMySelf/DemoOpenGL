package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import com.google.android.gms.common.api.zac;
import java.lang.ref.WeakReference;
import java.util.NoSuchElementException;

public final class zacr implements IBinder.DeathRecipient, zacq {
    public final WeakReference<BasePendingResult<?>> zalf;
    public final WeakReference<zac> zalg;
    public final WeakReference<IBinder> zalh;

    public zacr(BasePendingResult<?> basePendingResult, zac zac, IBinder iBinder) {
        this.zalg = new WeakReference<>(zac);
        this.zalf = new WeakReference<>(basePendingResult);
        this.zalh = new WeakReference<>(iBinder);
    }

    private final void zabw() {
        BasePendingResult basePendingResult = (BasePendingResult) this.zalf.get();
        zac zac = (zac) this.zalg.get();
        if (!(zac == null || basePendingResult == null)) {
            zac.remove(basePendingResult.zal().intValue());
        }
        IBinder iBinder = (IBinder) this.zalh.get();
        if (iBinder != null) {
            try {
                iBinder.unlinkToDeath(this, 0);
            } catch (NoSuchElementException unused) {
            }
        }
    }

    public final void binderDied() {
        zabw();
    }

    public final void zab(BasePendingResult<?> basePendingResult) {
        zabw();
    }

    public /* synthetic */ zacr(BasePendingResult basePendingResult, zac zac, IBinder iBinder, zaco zaco) {
        this(basePendingResult, (zac) null, iBinder);
    }
}
