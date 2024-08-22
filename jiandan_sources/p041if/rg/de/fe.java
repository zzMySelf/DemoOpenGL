package p041if.rg.de;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p041if.pf.ad;
import p041if.qw;
import p041if.rg.fe.rg;
import p041if.rg.fe.yj;
import p041if.uk.de;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.schedulers.ScheduledAction;
import rx.internal.util.RxThreadFactory;

/* renamed from: if.rg.de.fe  reason: invalid package */
public class fe extends qw.C0349qw implements Subscription {

    /* renamed from: i  reason: collision with root package name */
    public static final ConcurrentHashMap<ScheduledThreadPoolExecutor, ScheduledThreadPoolExecutor> f11163i = new ConcurrentHashMap<>();

    /* renamed from: if  reason: not valid java name */
    public static final Object f527if = new Object();

    /* renamed from: o  reason: collision with root package name */
    public static final AtomicReference<ScheduledExecutorService> f11164o = new AtomicReference<>();

    /* renamed from: pf  reason: collision with root package name */
    public static volatile Object f11165pf;

    /* renamed from: uk  reason: collision with root package name */
    public static final int f11166uk = Integer.getInteger("rx.scheduler.jdk6.purge-frequency-millis", 1000).intValue();

    /* renamed from: yj  reason: collision with root package name */
    public static final boolean f11167yj;

    /* renamed from: ad  reason: collision with root package name */
    public final ScheduledExecutorService f11168ad;

    /* renamed from: th  reason: collision with root package name */
    public volatile boolean f11169th;

    /* renamed from: if.rg.de.fe$qw */
    public static class qw implements Runnable {
        public void run() {
            fe.yj();
        }
    }

    static {
        boolean z = Boolean.getBoolean("rx.scheduler.jdk6.purge-force");
        int qw2 = rg.qw();
        f11167yj = !z && (qw2 == 0 || qw2 >= 21);
    }

    public fe(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (!m2363if(newScheduledThreadPool) && (newScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            uk((ScheduledThreadPoolExecutor) newScheduledThreadPool);
        }
        this.f11168ad = newScheduledThreadPool;
    }

    /* renamed from: if  reason: not valid java name */
    public static boolean m2363if(ScheduledExecutorService scheduledExecutorService) {
        Method method;
        Object obj;
        if (f11167yj) {
            if (scheduledExecutorService instanceof ScheduledThreadPoolExecutor) {
                Object obj2 = f11165pf;
                if (obj2 == f527if) {
                    return false;
                }
                if (obj2 == null) {
                    method = th(scheduledExecutorService);
                    if (method != null) {
                        obj = method;
                    } else {
                        obj = f527if;
                    }
                    f11165pf = obj;
                } else {
                    method = (Method) obj2;
                }
            } else {
                method = th(scheduledExecutorService);
            }
            if (method != null) {
                try {
                    method.invoke(scheduledExecutorService, new Object[]{Boolean.TRUE});
                    return true;
                } catch (InvocationTargetException e) {
                    de.i(e);
                } catch (IllegalAccessException e2) {
                    de.i(e2);
                } catch (IllegalArgumentException e3) {
                    de.i(e3);
                }
            }
        }
        return false;
    }

    public static void rg(ScheduledExecutorService scheduledExecutorService) {
        f11163i.remove(scheduledExecutorService);
    }

    public static Method th(ScheduledExecutorService scheduledExecutorService) {
        for (Method method : scheduledExecutorService.getClass().getMethods()) {
            if (method.getName().equals("setRemoveOnCancelPolicy")) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0] == Boolean.TYPE) {
                    return method;
                }
            }
        }
        return null;
    }

    public static void uk(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        while (true) {
            if (f11164o.get() != null) {
                break;
            }
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge-"));
            if (f11164o.compareAndSet((Object) null, newScheduledThreadPool)) {
                qw qwVar = new qw();
                int i2 = f11166uk;
                newScheduledThreadPool.scheduleAtFixedRate(qwVar, (long) i2, (long) i2, TimeUnit.MILLISECONDS);
                break;
            }
            newScheduledThreadPool.shutdownNow();
        }
        f11163i.putIfAbsent(scheduledThreadPoolExecutor, scheduledThreadPoolExecutor);
    }

    public static void yj() {
        try {
            Iterator<ScheduledThreadPoolExecutor> it = f11163i.keySet().iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor next = it.next();
                if (!next.isShutdown()) {
                    next.purge();
                } else {
                    it.remove();
                }
            }
        } catch (Throwable th2) {
            p041if.fe.qw.rg(th2);
            de.i(th2);
        }
    }

    public Subscription de(Action0 action0) {
        return fe(action0, 0, (TimeUnit) null);
    }

    public Subscription fe(Action0 action0, long j, TimeUnit timeUnit) {
        if (this.f11169th) {
            return p041if.pf.fe.ad();
        }
        return i(action0, j, timeUnit);
    }

    public ScheduledAction i(Action0 action0, long j, TimeUnit timeUnit) {
        Future future;
        ScheduledAction scheduledAction = new ScheduledAction(de.when(action0));
        if (j <= 0) {
            future = this.f11168ad.submit(scheduledAction);
        } else {
            future = this.f11168ad.schedule(scheduledAction, j, timeUnit);
        }
        scheduledAction.add((Future<?>) future);
        return scheduledAction;
    }

    public boolean isUnsubscribed() {
        return this.f11169th;
    }

    public ScheduledAction o(Action0 action0, long j, TimeUnit timeUnit, yj yjVar) {
        Future future;
        ScheduledAction scheduledAction = new ScheduledAction(de.when(action0), yjVar);
        yjVar.qw(scheduledAction);
        if (j <= 0) {
            future = this.f11168ad.submit(scheduledAction);
        } else {
            future = this.f11168ad.schedule(scheduledAction, j, timeUnit);
        }
        scheduledAction.add((Future<?>) future);
        return scheduledAction;
    }

    public ScheduledAction pf(Action0 action0, long j, TimeUnit timeUnit, ad adVar) {
        Future future;
        ScheduledAction scheduledAction = new ScheduledAction(de.when(action0), adVar);
        adVar.qw(scheduledAction);
        if (j <= 0) {
            future = this.f11168ad.submit(scheduledAction);
        } else {
            future = this.f11168ad.schedule(scheduledAction, j, timeUnit);
        }
        scheduledAction.add((Future<?>) future);
        return scheduledAction;
    }

    public void unsubscribe() {
        this.f11169th = true;
        this.f11168ad.shutdownNow();
        rg(this.f11168ad);
    }
}
