package fe.fe.ddd.de.ad;

import android.content.Context;
import android.os.Build;
import android.os.FileObserver;
import android.os.Handler;
import android.os.Looper;
import com.baidu.perf.signal.register.OnNativeANRListener;
import com.baidu.searchbox.anr.ioc.IANRRegister;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.ruka.ioc.IANRMonitor;
import com.github.anrwatchdog.ANRError;
import com.github.anrwatchdog.ANRWatchDog;
import java.io.File;

public class de implements IANRMonitor {

    /* renamed from: th  reason: collision with root package name */
    public static String f1381th = null;

    /* renamed from: uk  reason: collision with root package name */
    public static String f1382uk = "Ruka";

    /* renamed from: yj  reason: collision with root package name */
    public static long f1383yj;

    /* renamed from: ad  reason: collision with root package name */
    public ANRWatchDog f1384ad = null;

    /* renamed from: de  reason: collision with root package name */
    public boolean f1385de = false;

    /* renamed from: fe  reason: collision with root package name */
    public FileObserver f1386fe;
    public int qw = 5000;

    /* renamed from: rg  reason: collision with root package name */
    public OnNativeANRListener f1387rg;

    public class ad implements Runnable {
        public ad() {
        }

        public void run() {
            de.this.uk();
        }
    }

    /* renamed from: fe.fe.ddd.de.ad.de$de  reason: collision with other inner class name */
    public class C0074de implements OnNativeANRListener {
        public C0074de(de deVar) {
        }

        public void qw(int i2) {
            if (AppConfig.rg()) {
                String unused = de.f1382uk;
                "Java signal receiver ，sig = " + i2;
            }
            de.yj((StackTraceElement[]) null);
        }
    }

    public static class fe implements ANRWatchDog.ANRListener {
        public fe() {
        }

        public void qw(ANRError aNRError) {
            String unused = de.f1382uk;
            de.yj(aNRError.getSTStackTrace());
        }

        public /* synthetic */ fe(qw qwVar) {
            this();
        }
    }

    public class qw extends FileObserver {
        public qw(de deVar, String str, int i2) {
            super(str, i2);
        }

        public void onEvent(int i2, String str) {
            if (AppConfig.rg()) {
                String unused = de.f1382uk;
                "onEvent: " + str;
            }
            if (str != null) {
                String str2 = "/data/anr/" + str;
                if (str2.contains("trace")) {
                    de.yj((StackTraceElement[]) null);
                    return;
                }
                String unused2 = de.f1382uk;
                "not anr file " + str2;
            }
        }
    }

    public static String o(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        if (stackTraceElementArr != null) {
            try {
                if (stackTraceElementArr.length >= 1) {
                    for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                        sb.append(stackTraceElement.toString() + "\r\n");
                    }
                }
            } catch (Exception unused) {
            }
        }
        return sb.toString();
    }

    public static void th(StackTraceElement[] stackTraceElementArr) {
        String str;
        String str2;
        Context qw2 = fe.fe.ddd.i.qw.qw.qw();
        if (qw2 != null) {
            f1381th = String.valueOf(System.currentTimeMillis());
            if (fe.fe.ddd.de.th.qw.qw(qw2, 25000)) {
                String str3 = qw2.getFilesDir() + "/" + "anr_logcat.txt";
                fe.fe.ddd.de.th.qw.fe(str3, 2000);
                if (stackTraceElementArr == null || stackTraceElementArr.length <= 0) {
                    str = fe.fe.ddd.de.qw.qw.qw();
                } else {
                    str = o(stackTraceElementArr);
                }
                String str4 = str;
                if (!new File("/data/anr/traces.txt").canRead()) {
                    str2 = qw2.getFilesDir() + "/" + "all_stack_traces.txt";
                    fe.fe.ddd.de.th.qw.de(str2);
                } else {
                    str2 = "";
                }
                qw.qw().qw(fe.fe.ddd.i.qw.qw.qw(), new ad(f1381th, str4, str3, "/data/anr/traces.txt", str2));
            }
        }
    }

    public static void yj(StackTraceElement[] stackTraceElementArr) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - f1383yj >= 20000) {
                f1383yj = currentTimeMillis;
                th(stackTraceElementArr);
            }
        } catch (Throwable th2) {
            "handle anr error  " + th2.getMessage();
        }
    }

    public void ad() {
        if (!this.f1385de) {
            i();
            this.f1385de = true;
            if (Build.VERSION.SDK_INT < 21) {
                pf();
            } else {
                m61if(5000);
            }
            m62switch();
        }
    }

    public final void i() {
        for (IANRRegister next : rg.de().ad().qw()) {
            if (next instanceof fe.fe.ddd.de.rg.qw) {
                ((fe.fe.ddd.de.rg.qw) next).rg();
            }
        }
    }

    /* renamed from: if  reason: not valid java name */
    public void m61if(int i2) {
        if (i2 < 5000) {
            this.qw = 5000;
        } else {
            this.qw = i2;
        }
        ANRWatchDog aNRWatchDog = new ANRWatchDog(this.qw);
        this.f1384ad = aNRWatchDog;
        aNRWatchDog.fe();
        this.f1384ad.de(new fe((qw) null));
        if (AppConfig.rg()) {
            "start mANRWatchDog = " + this.f1384ad.getName() + " Monitor";
        }
        this.f1384ad.start();
    }

    public final void pf() {
        qw qwVar = new qw(this, "/data/anr/", 8);
        this.f1386fe = qwVar;
        try {
            qwVar.startWatching();
            boolean rg2 = AppConfig.rg();
        } catch (Throwable unused) {
            this.f1386fe = null;
        }
    }

    public boolean qw() {
        return rg.de().qw();
    }

    /* renamed from: switch  reason: not valid java name */
    public final void m62switch() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            uk();
        } else {
            new Handler(Looper.getMainLooper()).post(new ad());
        }
    }

    public final void uk() {
        boolean rg2 = AppConfig.rg();
        if (this.f1387rg == null) {
            C0074de deVar = new C0074de(this);
            this.f1387rg = deVar;
            fe.fe.ggg.qw.qw.qw.qw(deVar);
        }
        fe.fe.ggg.qw.qw.qw.ad(Build.VERSION.SDK_INT);
    }
}
