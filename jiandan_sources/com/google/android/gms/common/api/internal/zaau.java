package com.google.android.gms.common.api.internal;

import androidx.annotation.WorkerThread;

public abstract class zaau implements Runnable {
    public final /* synthetic */ zaak zafz;

    public zaau(zaak zaak) {
        this.zafz = zaak;
    }

    @WorkerThread
    public void run() {
        this.zafz.zaer.lock();
        try {
            if (!Thread.interrupted()) {
                zaal();
                this.zafz.zaer.unlock();
            }
        } catch (RuntimeException e) {
            this.zafz.zafv.zab(e);
        } finally {
            this.zafz.zaer.unlock();
        }
    }

    @WorkerThread
    public abstract void zaal();

    public /* synthetic */ zaau(zaak zaak, zaaj zaaj) {
        this(zaak);
    }
}
