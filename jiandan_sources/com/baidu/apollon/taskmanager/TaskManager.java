package com.baidu.apollon.taskmanager;

import android.text.TextUtils;
import com.baidu.apollon.ApollonConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class TaskManager {
    public static final long TIMESLICE = 1000;
    public static final boolean a = ApollonConstants.DEBUG;
    public static final String b = TaskManager.class.getSimpleName();
    public static final long c = Long.MAX_VALUE;
    public static TaskManager f = null;

    /* renamed from: i  reason: collision with root package name */
    public static final int f715i = 5;
    public static final int j = 128;
    public static final int k = 1;
    public static HashMap<String, TaskManager> mTskMgrMap = new HashMap<>();
    public long d = Long.MAX_VALUE;
    public Timer e = new Timer();
    public final HashMap<String, ArrayList<Task>> g = new HashMap<>();
    public final HashMap<Future<?>, Runnable> h = new HashMap<>();
    public BlockingQueue<Runnable> l = new LinkedBlockingQueue(10);
    public final ThreadFactory m = new ThreadFactory() {
        public final AtomicInteger b = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "WalletTask #" + this.b.getAndIncrement());
        }
    };
    public a n = new a(5, 128, 1, TimeUnit.SECONDS, this.l, this.m, new ThreadPoolExecutor.DiscardOldestPolicy());

    /* renamed from: o  reason: collision with root package name */
    public b f716o = new b();

    public class Task {
        public long a;
        public long mDelay;
        public boolean mIsSerial;
        public long mPeriod;
        public Runnable mRunnable;
        public String mTaskKey;

        public Task(long j, long j2, boolean z, String str, Runnable runnable) {
            this.mDelay = j;
            this.a = System.currentTimeMillis() + j;
            this.mPeriod = j2;
            this.mIsSerial = z;
            this.mRunnable = runnable;
            this.mTaskKey = str;
        }
    }

    public class a extends ThreadPoolExecutor {
        public a(int i2, int i3, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
            super(i2, i3, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        }

        public void afterExecute(Runnable runnable, Throwable th2) {
            TaskManager.this.h.remove((Future) runnable);
            super.afterExecute(runnable, th2);
        }
    }

    public TaskManager() {
        a aVar = this.n;
        if (aVar != null) {
            aVar.allowCoreThreadTimeOut(true);
        }
    }

    /* access modifiers changed from: private */
    public void d(Task task) {
        if (task.mPeriod > 0) {
            task.mDelay = 0;
        }
        if (task.mIsSerial) {
            this.f716o.execute(task.mRunnable);
            return;
        }
        this.h.put(this.n.submit(task.mRunnable), task.mRunnable);
        if (a) {
            "execute task, " + task.mTaskKey + " execute time is " + System.currentTimeMillis();
        }
    }

    public static synchronized TaskManager getInstance(String str) {
        TaskManager taskManager;
        synchronized (TaskManager.class) {
            if (mTskMgrMap.get(str) == null) {
                TaskManager taskManager2 = new TaskManager();
                f = taskManager2;
                mTskMgrMap.put(str, taskManager2);
            }
            taskManager = f;
        }
        return taskManager;
    }

    public boolean addTask(Task task, String str) {
        if (task == null || task.mRunnable == null) {
            return false;
        }
        synchronized (this.g) {
            ArrayList<Task> a2 = a(str);
            if (!a(task, a2)) {
                if (task.a <= System.currentTimeMillis()) {
                    c(task);
                } else if (task.mDelay > 0) {
                    c(task);
                }
                if (task.mPeriod > 0) {
                    task.a = System.currentTimeMillis() + task.mDelay + task.mPeriod;
                    a2.add(task);
                    a(task);
                }
            } else {
                a(task, str);
            }
        }
        return true;
    }

    public void cancelAllTasks(String str) {
        synchronized (this.g) {
            ArrayList<Task> a2 = a(str);
            Iterator<Task> it = a2.iterator();
            while (it.hasNext()) {
                b(it.next());
            }
            a2.clear();
            this.g.remove(str);
        }
    }

    public void cancelTask(String str, String str2) {
        synchronized (this.g) {
            ArrayList<Task> a2 = a(str);
            Iterator<Task> it = a2.iterator();
            while (it.hasNext()) {
                Task next = it.next();
                if (next.mTaskKey.equals(str2)) {
                    b(next);
                    a2.remove(next.mTaskKey);
                }
            }
        }
    }

    private void b(Task task) {
        if (task.mIsSerial) {
            this.f716o.a(task.mRunnable);
            return;
        }
        for (Future next : this.h.keySet()) {
            if (this.h.get(next) == task.mRunnable && next != null) {
                if (!next.isCancelled() || !next.isDone()) {
                    next.cancel(true);
                }
            }
        }
    }

    private void c(Task task) {
        if (task.mDelay > 0) {
            a(task, task.a - System.currentTimeMillis());
        } else {
            d(task);
        }
    }

    public class b implements Executor {
        public final LinkedList<Runnable> a;
        public Runnable b;

        public b() {
            this.a = new LinkedList<>();
        }

        public synchronized void a() {
            Runnable poll = this.a.poll();
            this.b = poll;
            if (poll != null) {
                TaskManager.this.n.execute(this.b);
            }
        }

        public synchronized void execute(final Runnable runnable) {
            this.a.offer(new Runnable() {
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        b.this.a();
                    }
                }
            });
            if (this.b == null) {
                a();
            }
        }

        public synchronized void a(Runnable runnable) {
            this.a.remove(runnable);
        }
    }

    private Task a(String str, ArrayList<Task> arrayList) {
        Iterator<Task> it = arrayList.iterator();
        while (it.hasNext()) {
            Task next = it.next();
            if (TextUtils.equals(str, next.mTaskKey)) {
                return next;
            }
        }
        return null;
    }

    private ArrayList<Task> a(String str) {
        ArrayList<Task> arrayList = this.g.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        this.g.put(str, arrayList);
        return arrayList;
    }

    private boolean a(Task task, String str) {
        if (task == null || task.mRunnable == null) {
            return false;
        }
        synchronized (this.g) {
            ArrayList<Task> a2 = a(str);
            Task a3 = a(task.mTaskKey, a2);
            if (a3 == null) {
                return false;
            }
            b(a3);
            a2.remove(a3);
            addTask(task, str);
            return true;
        }
    }

    private void a(Task task) {
        long j2 = task.a;
        if (j2 < this.d) {
            a(Math.max(j2 - System.currentTimeMillis(), 1000));
        }
    }

    private void a(long j2) {
        if (a) {
            "intervalMillis: " + j2;
        }
        Timer timer = this.e;
        if (timer != null) {
            timer.cancel();
            this.e = null;
        }
        this.e = new Timer();
        this.e.schedule(new TimerTask() {
            public void run() {
                TaskManager.this.a();
            }
        }, j2);
    }

    /* access modifiers changed from: private */
    public void a() {
        boolean z = a;
        synchronized (this.g) {
            long currentTimeMillis = System.currentTimeMillis();
            this.d = Long.MAX_VALUE;
            for (String a2 : this.g.keySet()) {
                ArrayList arrayList = new ArrayList();
                Iterator<Task> it = a(a2).iterator();
                while (it.hasNext()) {
                    Task next = it.next();
                    if (next.a - currentTimeMillis < 1000) {
                        if (a) {
                            "task.mNextRunTime - current = " + (next.a - currentTimeMillis);
                        }
                        c(next);
                        if (next.mPeriod > 0) {
                            next.a = next.mPeriod + currentTimeMillis;
                            arrayList.add(next);
                        }
                    }
                    if (next.a < this.d) {
                        this.d = next.a;
                    }
                }
                if (this.d < Long.MAX_VALUE) {
                    a(this.d - currentTimeMillis);
                }
            }
        }
    }

    private boolean a(Task task, ArrayList<Task> arrayList) {
        Iterator<Task> it = arrayList.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().mTaskKey, task.mTaskKey)) {
                return true;
            }
        }
        return false;
    }

    private void a(final Task task, final long j2) {
        this.n.execute(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(j2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                TaskManager.this.d(task);
            }
        });
    }
}
