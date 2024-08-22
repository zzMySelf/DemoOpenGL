package com.google.android.gms.common.api.internal;

public abstract class zabd {
    public final zabb zahq;

    public zabd(zabb zabb) {
        this.zahq = zabb;
    }

    public final void zaa(zabe zabe) {
        zabe.zaer.lock();
        try {
            if (zabe.zahu == this.zahq) {
                zaal();
                zabe.zaer.unlock();
            }
        } finally {
            zabe.zaer.unlock();
        }
    }

    public abstract void zaal();
}
