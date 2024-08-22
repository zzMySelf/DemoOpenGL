package fe.fe.p004if.qw.th;

import android.content.Context;
import fe.fe.p004if.qw.yj.fe;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: fe.fe.if.qw.th.qw  reason: invalid package */
public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public static qw f1983ad;

    /* renamed from: de  reason: collision with root package name */
    public static final int f1984de;

    /* renamed from: fe  reason: collision with root package name */
    public static final int f1985fe;

    /* renamed from: rg  reason: collision with root package name */
    public static final int f1986rg = ((f1984de * 2) + 1);
    public ThreadPoolExecutor qw = null;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f1984de = availableProcessors;
        f1985fe = Math.max(2, Math.min(availableProcessors - 1, 4));
    }

    public qw(Context context) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f1985fe, f1986rg, 30, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.qw = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        Executors.newSingleThreadExecutor();
    }

    public static qw qw(Context context) {
        if (context == null) {
            return null;
        }
        if (f1983ad == null) {
            synchronized (qw.class) {
                if (f1983ad == null) {
                    f1983ad = new qw(context);
                }
            }
        }
        return f1983ad;
    }

    public void ad(Runnable runnable) {
        try {
            this.qw.submit(runnable);
        } catch (Throwable th2) {
            fe.de("TaskManager", "Exception ", th2);
        }
    }
}
