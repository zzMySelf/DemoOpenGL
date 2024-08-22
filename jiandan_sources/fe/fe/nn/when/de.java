package fe.fe.nn.when;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class de implements ThreadFactory {

    /* renamed from: uk  reason: collision with root package name */
    public static final AtomicInteger f2409uk = new AtomicInteger(1);

    /* renamed from: ad  reason: collision with root package name */
    public final AtomicInteger f2410ad;

    /* renamed from: th  reason: collision with root package name */
    public String f2411th;

    /* renamed from: yj  reason: collision with root package name */
    public int f2412yj;

    public de() {
        this(5);
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f2411th + this.f2410ad.getAndIncrement());
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        int i2 = this.f2412yj;
        if (i2 != 5) {
            thread.setPriority(i2);
        } else {
            thread.setPriority(5);
        }
        return thread;
    }

    public de(int i2) {
        this.f2410ad = new AtomicInteger(1);
        this.f2411th = "sso-" + f2409uk.getAndIncrement() + "-thread-";
        this.f2412yj = i2;
    }
}
