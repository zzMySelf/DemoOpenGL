package fe.ad.qw.qw.de;

import androidx.annotation.NonNull;
import com.alibaba.android.arouter.facade.template.ILogger;
import java.lang.Thread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class de implements ThreadFactory {

    /* renamed from: uk  reason: collision with root package name */
    public static final AtomicInteger f1191uk = new AtomicInteger(1);

    /* renamed from: ad  reason: collision with root package name */
    public final AtomicInteger f1192ad = new AtomicInteger(1);

    /* renamed from: th  reason: collision with root package name */
    public final ThreadGroup f1193th;

    /* renamed from: yj  reason: collision with root package name */
    public final String f1194yj;

    public class qw implements Thread.UncaughtExceptionHandler {
        public qw(de deVar) {
        }

        public void uncaughtException(Thread thread, Throwable th2) {
            ILogger iLogger = fe.ad.qw.qw.ad.qw.f1186de;
            iLogger.info(ILogger.defaultTag, "Running task appeared exception! Thread [" + thread.getName() + "], because [" + th2.getMessage() + "]");
        }
    }

    public de() {
        ThreadGroup threadGroup;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            threadGroup = securityManager.getThreadGroup();
        } else {
            threadGroup = Thread.currentThread().getThreadGroup();
        }
        this.f1193th = threadGroup;
        this.f1194yj = "ARouter task pool No." + f1191uk.getAndIncrement() + ", thread No.";
    }

    public Thread newThread(@NonNull Runnable runnable) {
        String str = this.f1194yj + this.f1192ad.getAndIncrement();
        fe.ad.qw.qw.ad.qw.f1186de.info(ILogger.defaultTag, "Thread production, name is [" + str + "]");
        Thread thread = new Thread(this.f1193th, runnable, str, 0);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        thread.setUncaughtExceptionHandler(new qw(this));
        return thread;
    }
}
