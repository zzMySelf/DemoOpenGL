package io.reactivex.observers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.VolatileSizeArrayList;
import io.reactivex.observers.BaseTestConsumer;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public abstract class BaseTestConsumer<T, U extends BaseTestConsumer<T, U>> implements Disposable {

    /* renamed from: ad  reason: collision with root package name */
    public final CountDownLatch f10322ad = new CountDownLatch(1);

    /* renamed from: i  reason: collision with root package name */
    public boolean f10323i;

    /* renamed from: o  reason: collision with root package name */
    public int f10324o;

    /* renamed from: pf  reason: collision with root package name */
    public int f10325pf;

    /* renamed from: th  reason: collision with root package name */
    public final List<T> f10326th = new VolatileSizeArrayList();

    /* renamed from: uk  reason: collision with root package name */
    public long f10327uk;

    /* renamed from: yj  reason: collision with root package name */
    public final List<Throwable> f10328yj = new VolatileSizeArrayList();

    public enum TestWaitStrategy implements Runnable {
        SPIN {
            public void run() {
            }
        },
        YIELD {
            public void run() {
                Thread.yield();
            }
        },
        SLEEP_1MS {
            public void run() {
                TestWaitStrategy.sleep(1);
            }
        },
        SLEEP_10MS {
            public void run() {
                TestWaitStrategy.sleep(10);
            }
        },
        SLEEP_100MS {
            public void run() {
                TestWaitStrategy.sleep(100);
            }
        },
        SLEEP_1000MS {
            public void run() {
                TestWaitStrategy.sleep(1000);
            }
        };

        public static void sleep(int i2) {
            try {
                Thread.sleep((long) i2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public abstract void run();
    }
}
