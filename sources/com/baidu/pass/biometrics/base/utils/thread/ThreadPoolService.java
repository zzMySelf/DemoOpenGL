package com.baidu.pass.biometrics.base.utils.thread;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolService {

    /* renamed from: c  reason: collision with root package name */
    private static final int f15819c = Runtime.getRuntime().availableProcessors();

    /* renamed from: d  reason: collision with root package name */
    private static final ThreadFactory f15820d = new ThreadFactory() {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f15825a = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "pass_face_thread # " + this.f15825a.getAndIncrement());
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private static final int f15821e = 0;

    /* renamed from: f  reason: collision with root package name */
    private static final int f15822f = 1;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f15823a;

    /* renamed from: b  reason: collision with root package name */
    private Handler f15824b;

    private static class SingletonContainer {
        public static ThreadPoolService mSingleInstance = new ThreadPoolService();

        private SingletonContainer() {
        }
    }

    public static ThreadPoolService getInstance() {
        return SingletonContainer.mSingleInstance;
    }

    public void run(TPRunnable tPRunnable) {
        this.f15823a.submit(tPRunnable);
    }

    public void runInUiThread(TPRunnable tPRunnable) {
        this.f15824b.sendMessage(this.f15824b.obtainMessage(0, tPRunnable));
    }

    private ThreadPoolService() {
        this.f15824b = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message message) {
                int i2 = message.what;
                if (i2 == 0) {
                    ((TPRunnable) message.obj).run();
                } else if (i2 == 1) {
                    ThreadPoolService.this.f15823a.submit(((TPRunnable) message.obj).runable);
                }
            }
        };
        this.f15823a = new ThreadPoolExecutor(Math.max(2, Math.min(f15819c - 1, 4)), Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), f15820d);
        if (Build.VERSION.SDK_INT >= 9) {
            this.f15823a.allowCoreThreadTimeOut(true);
        }
    }
}
