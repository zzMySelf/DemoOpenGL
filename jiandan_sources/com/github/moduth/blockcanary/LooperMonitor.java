package com.github.moduth.blockcanary;

import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import fe.p013if.de.qw.de;
import fe.p013if.de.qw.fe;

public class LooperMonitor implements Printer {

    /* renamed from: ad  reason: collision with root package name */
    public long f4412ad = 0;

    /* renamed from: de  reason: collision with root package name */
    public long f4413de = 0;

    /* renamed from: fe  reason: collision with root package name */
    public BlockListener f4414fe = null;
    public long qw = 3000;

    /* renamed from: rg  reason: collision with root package name */
    public final boolean f4415rg;

    public interface BlockListener {
        void qw(long j, long j2, long j3, long j4);
    }

    public class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ long f4416ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ long f4418th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ long f4419uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ long f4420yj;

        public qw(long j, long j2, long j3, long j4) {
            this.f4416ad = j;
            this.f4418th = j2;
            this.f4420yj = j3;
            this.f4419uk = j4;
        }

        public void run() {
            LooperMonitor.this.f4414fe.qw(this.f4416ad, this.f4418th, this.f4420yj, this.f4419uk);
        }
    }

    public LooperMonitor(BlockListener blockListener, long j, boolean z) {
        if (blockListener != null) {
            this.f4414fe = blockListener;
            this.qw = j;
            this.f4415rg = z;
            return;
        }
        throw new IllegalArgumentException("blockListener should not be null.");
    }

    public final boolean ad(long j) {
        return j - this.f4412ad > this.qw;
    }

    public final void de(long j) {
        fe.ad().post(new qw(this.f4412ad, j, this.f4413de, SystemClock.currentThreadTimeMillis()));
    }

    public final void fe() {
        if (de.rg().f4599ad != null) {
            de.rg().f4599ad.de();
        }
        if (de.rg().f4600de != null) {
            de.rg().f4600de.de();
        }
    }

    public void println(String str) {
        if (this.f4415rg && Debug.isDebuggerConnected()) {
            return;
        }
        if (str.charAt(0) == '>') {
            this.f4412ad = System.currentTimeMillis();
            this.f4413de = SystemClock.currentThreadTimeMillis();
            fe();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (ad(currentTimeMillis)) {
            de(currentTimeMillis);
        }
        rg();
    }

    public final void rg() {
        if (de.rg().f4599ad != null) {
            de.rg().f4599ad.fe();
        }
        if (de.rg().f4600de != null) {
            de.rg().f4600de.fe();
        }
    }
}
