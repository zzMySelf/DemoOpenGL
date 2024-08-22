package com.google.android.gms.common.api.internal;

public final class zat implements Runnable {
    public final /* synthetic */ zaq zaet;

    public zat(zaq zaq) {
        this.zaet = zaq;
    }

    public final void run() {
        this.zaet.zaer.lock();
        try {
            this.zaet.zav();
        } finally {
            this.zaet.zaer.unlock();
        }
    }
}
