package fe.fe.ddd.when.de;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.logsystem.javacrash.ProcessExceptionListener;
import fe.fe.ddd.when.yj.ad;
import java.lang.Thread;
import java.util.List;

public abstract class qw implements Thread.UncaughtExceptionHandler {

    /* renamed from: ad  reason: collision with root package name */
    public List<ProcessExceptionListener> f1674ad;
    public Thread.UncaughtExceptionHandler qw = null;

    public qw(@Nullable List<ProcessExceptionListener> list) {
        if (0 == 0) {
            this.qw = Thread.getDefaultUncaughtExceptionHandler();
        }
        this.f1674ad = list;
    }

    public abstract void qw(@NonNull Thread thread, @NonNull Throwable th2);

    public void uncaughtException(Thread thread, Throwable th2) {
        List<ProcessExceptionListener> list;
        List<ProcessExceptionListener> list2;
        Log.getStackTraceString(th2);
        List<ProcessExceptionListener> list3 = this.f1674ad;
        boolean z = list3 != null && list3.size() > 0;
        if (z) {
            try {
                if (this.f1674ad != null) {
                    for (ProcessExceptionListener next : this.f1674ad) {
                        if (next != null) {
                            next.th(this, th2);
                        }
                    }
                }
            } catch (Throwable th3) {
                if (ad.qw) {
                    th3.printStackTrace();
                }
                if (z && (list2 = this.f1674ad) != null) {
                    for (ProcessExceptionListener next2 : list2) {
                        if (next2 != null) {
                            try {
                                next2.rg(this, th2, th3);
                            } catch (Throwable th4) {
                                if (ad.qw) {
                                    Log.getStackTraceString(th4);
                                }
                            }
                        }
                    }
                }
            }
        }
        qw(thread, th2);
        if (z && this.f1674ad != null) {
            for (ProcessExceptionListener next3 : this.f1674ad) {
                if (next3 != null) {
                    try {
                        next3.qw(this, th2);
                    } catch (Throwable th5) {
                        if (ad.qw) {
                            Log.getStackTraceString(th5);
                        }
                    }
                }
            }
        }
        if (this.qw != null) {
            if (z) {
                try {
                    if (this.f1674ad != null) {
                        for (ProcessExceptionListener next4 : this.f1674ad) {
                            if (next4 != null) {
                                next4.fe(this.qw, th2);
                            }
                        }
                    }
                } catch (Throwable th6) {
                    if (ad.qw) {
                        th6.printStackTrace();
                    }
                    if (z && (list = this.f1674ad) != null) {
                        for (ProcessExceptionListener next5 : list) {
                            if (next5 != null) {
                                try {
                                    next5.ad(this.qw, th6, th6);
                                } catch (Throwable th7) {
                                    if (ad.qw) {
                                        Log.getStackTraceString(th7);
                                    }
                                }
                            }
                        }
                        return;
                    }
                    return;
                }
            }
            this.qw.uncaughtException(thread, th2);
            if (z && this.f1674ad != null) {
                for (ProcessExceptionListener next6 : this.f1674ad) {
                    if (next6 != null) {
                        try {
                            next6.de(this.qw, th2);
                        } catch (Throwable th8) {
                            if (ad.qw) {
                                Log.getStackTraceString(th8);
                            }
                        }
                    }
                }
            }
        }
    }
}
