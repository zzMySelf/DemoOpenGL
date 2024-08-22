package com.baidu.android.util.concurrent;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Deprecated
public final class AsyncTaskAssistant {
    private static final int CORE_POOL_SIZE;
    private static final int CPU_COUNT;
    private static final boolean DEBUG = false;
    private static final int KEEP_ALIVE_SECONDS = 30;
    private static final int MAXIMUM_POOL_SIZE;
    private static final String TAG = "AsyncTaskAssistant";
    private static final Executor THREAD_POOL_EXECUTOR;
    private static Handler sHandler = new Handler(Looper.getMainLooper());
    private static final BlockingQueue<Runnable> sPoolWorkQueue;
    private static final ThreadFactory sThreadFactory;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        CORE_POOL_SIZE = Math.max(2, Math.min(availableProcessors - 1, 4));
        int max = Math.max(2, availableProcessors - 1);
        MAXIMUM_POOL_SIZE = max;
        AnonymousClass1 r10 = new ThreadFactory() {
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        };
        sThreadFactory = r10;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        sPoolWorkQueue = linkedBlockingQueue;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(max, max, 30, TimeUnit.SECONDS, linkedBlockingQueue, r10);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        THREAD_POOL_EXECUTOR = threadPoolExecutor;
    }

    private static class Task {
        String name;
        Runnable runnable;

        private Task() {
        }
    }

    private static class WorkerAsyncTask extends AsyncTask<Task, Object, Object> {
        private WorkerAsyncTask() {
        }

        /* access modifiers changed from: protected */
        public Object doInBackground(Task... params) {
            String name;
            Process.setThreadPriority(10);
            try {
                if (params[0] == null || params[0].runnable == null) {
                    return null;
                }
                if (!TextUtils.isEmpty(params[0].name)) {
                    name = params[0].name;
                } else {
                    name = "noname";
                }
                Thread.currentThread().setName(name);
                params[0].runnable.run();
                return null;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    private AsyncTaskAssistant() {
    }

    public static void execute(Runnable runnable, String name) {
        Task task = new Task();
        task.runnable = runnable;
        task.name = name;
        new WorkerAsyncTask().execute(new Task[]{task});
    }

    public static void execute(final Runnable runnable, final String name, long delayTimeMS) {
        sHandler.postDelayed(new Runnable() {
            public void run() {
                AsyncTaskAssistant.execute(runnable, name);
            }
        }, delayTimeMS);
    }

    public static void executeOnThreadPool(Runnable runnable, String name) {
        Task task = new Task();
        task.runnable = runnable;
        task.name = name;
        new WorkerAsyncTask().executeOnExecutor(THREAD_POOL_EXECUTOR, new Task[]{task});
    }

    public static void executeOnThreadPool(final Runnable runnable, final String name, long delayTimeMS) {
        sHandler.postDelayed(new Runnable() {
            public void run() {
                AsyncTaskAssistant.executeOnThreadPool(runnable, name);
            }
        }, delayTimeMS);
    }
}
