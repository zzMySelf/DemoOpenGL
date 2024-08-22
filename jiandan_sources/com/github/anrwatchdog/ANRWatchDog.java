package com.github.anrwatchdog;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;

public class ANRWatchDog extends Thread {
    public static final ANRListener ddd = new qw();
    public static final InterruptionListener mmm = new de();
    public static final ANRInterceptor nn = new ad();

    /* renamed from: ad  reason: collision with root package name */
    public ANRListener f4387ad = ddd;
    public volatile long ggg = 0;

    /* renamed from: i  reason: collision with root package name */
    public final int f4388i;

    /* renamed from: if  reason: not valid java name */
    public boolean f163if = true;

    /* renamed from: o  reason: collision with root package name */
    public String f4389o = "";

    /* renamed from: pf  reason: collision with root package name */
    public boolean f4390pf = false;
    public fe.p013if.qw.qw ppp = null;

    /* renamed from: switch  reason: not valid java name */
    public boolean f164switch = false;

    /* renamed from: th  reason: collision with root package name */
    public ANRInterceptor f4391th = nn;

    /* renamed from: uk  reason: collision with root package name */
    public final Handler f4392uk = new Handler(Looper.getMainLooper());
    public volatile boolean vvv = false;
    public boolean when = false;
    public final Runnable xxx = new fe();

    /* renamed from: yj  reason: collision with root package name */
    public InterruptionListener f4393yj = mmm;

    public interface ANRInterceptor {
        long qw(long j);
    }

    public interface ANRListener {
        void qw(ANRError aNRError);
    }

    public interface InterruptionListener {
        void qw(InterruptedException interruptedException);
    }

    public static class ad implements ANRInterceptor {
        public long qw(long j) {
            return 0;
        }
    }

    public static class de implements InterruptionListener {
        public void qw(InterruptedException interruptedException) {
            "Interrupted: " + interruptedException.getMessage();
        }
    }

    public class fe implements Runnable {
        public fe() {
        }

        public void run() {
            long unused = ANRWatchDog.this.ggg = 0;
            boolean unused2 = ANRWatchDog.this.vvv = false;
        }
    }

    public static class qw implements ANRListener {
        public void qw(ANRError aNRError) {
            throw aNRError;
        }
    }

    public ANRWatchDog(int i2) {
        this.f4388i = i2;
    }

    public ANRWatchDog de(ANRListener aNRListener) {
        if (aNRListener == null) {
            this.f4387ad = ddd;
        } else {
            this.f4387ad = aNRListener;
        }
        return this;
    }

    public ANRWatchDog fe() {
        this.f4389o = null;
        return this;
    }

    public void run() {
        setName("|ANR-WatchDog|");
        long j = (long) this.f4388i;
        long j2 = 0;
        while (!isInterrupted()) {
            boolean z = this.ggg == 0;
            this.ggg += j;
            if (z) {
                this.f4392uk.post(this.xxx);
            }
            try {
                Thread.sleep(j);
                if (this.f164switch && this.when) {
                    if (this.ppp == null) {
                        this.ppp = new fe.p013if.qw.qw();
                    }
                    if (this.ggg != 0 || this.vvv) {
                        j2 = this.ggg;
                        this.ppp.qw();
                    } else {
                        this.when = false;
                        ANRError NewMainAllStackTrace = ANRError.NewMainAllStackTrace(this.ppp.ad(), j2);
                        if (NewMainAllStackTrace != null) {
                            this.f4387ad.qw(NewMainAllStackTrace);
                        }
                    }
                }
                if (this.ggg != 0 && !this.vvv) {
                    if (this.f163if || (!Debug.isDebuggerConnected() && !Debug.waitingForDebugger())) {
                        j = this.f4391th.qw(this.ggg);
                        if (j <= 0) {
                            if (this.f4389o != null) {
                                this.f4387ad.qw(ANRError.New(this.ggg, this.f4389o, this.f4390pf));
                            } else if (this.f164switch) {
                                this.when = true;
                                fe.p013if.qw.qw qwVar = new fe.p013if.qw.qw();
                                this.ppp = qwVar;
                                qwVar.qw();
                            } else {
                                this.f4387ad.qw(ANRError.NewMainOnly(this.ggg));
                            }
                            j = (long) this.f4388i;
                            this.vvv = true;
                        }
                    } else {
                        this.vvv = true;
                    }
                }
            } catch (InterruptedException e) {
                this.f4393yj.qw(e);
                return;
            }
        }
    }
}
