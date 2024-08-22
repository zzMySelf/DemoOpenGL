package com.baidu.searchbox.elasticthread.task;

import android.os.SystemClock;

public class ElasticTask implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public Runnable f1035ad;

    /* renamed from: i  reason: collision with root package name */
    public long f1036i;

    /* renamed from: if  reason: not valid java name */
    public Status f14if = Status.WAITING;

    /* renamed from: o  reason: collision with root package name */
    public long f1037o;

    /* renamed from: pf  reason: collision with root package name */
    public long f1038pf;

    /* renamed from: th  reason: collision with root package name */
    public ElasticTaskCallback f1039th;

    /* renamed from: uk  reason: collision with root package name */
    public int f1040uk;

    /* renamed from: yj  reason: collision with root package name */
    public String f1041yj;

    public interface ElasticTaskCallback {
        void ad();

        void qw();
    }

    public enum Status {
        WAITING,
        RUNNING,
        COMPLETE
    }

    public ElasticTask(Runnable runnable, String str, long j, int i2) {
        this.f1035ad = runnable;
        this.f1041yj = str;
        this.f1040uk = i2;
    }

    public int ad() {
        return this.f1040uk;
    }

    public synchronized long de() {
        if (this.f14if == Status.WAITING) {
            return 0;
        }
        return Math.max(0, (this.f14if == Status.RUNNING ? SystemClock.elapsedRealtime() : this.f1038pf) - this.f1037o);
    }

    public synchronized long fe() {
        if (this.f1036i == 0) {
            return 0;
        }
        return Math.max(0, (this.f14if == Status.WAITING ? SystemClock.elapsedRealtime() : this.f1037o) - this.f1036i);
    }

    public void i(ElasticTaskCallback elasticTaskCallback) {
        this.f1039th = elasticTaskCallback;
    }

    public String qw() {
        return this.f1041yj;
    }

    public synchronized long rg(long j, long j2) {
        if (this.f14if == Status.WAITING) {
            return 0;
        }
        return Math.max(0, Math.min(this.f14if == Status.RUNNING ? SystemClock.elapsedRealtime() : this.f1038pf, j2) - Math.max(this.f1037o, j));
    }

    public void run() {
        try {
            if (this.f1039th != null) {
                this.f1039th.ad();
            }
        } catch (Exception unused) {
        }
        this.f1035ad.run();
        try {
            if (this.f1039th != null) {
                this.f1039th.qw();
            }
        } catch (Exception unused2) {
        }
    }

    public synchronized void th() {
        this.f14if = Status.COMPLETE;
        this.f1038pf = SystemClock.elapsedRealtime();
    }

    public synchronized void uk() {
        this.f14if = Status.RUNNING;
        this.f1037o = SystemClock.elapsedRealtime();
    }

    public synchronized void yj() {
        this.f14if = Status.WAITING;
        this.f1036i = SystemClock.elapsedRealtime();
    }
}
