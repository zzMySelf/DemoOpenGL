package com.dxmpay.apollon.taskmanager;

import com.dxmpay.apollon.ApollonConstants;
import com.dxmpay.apollon.utils.ChannelUtils;
import com.dxmpay.wallet.core.utils.LogUtil;
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
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class TaskManager {
    public static final long TIMESLICE = 1000;

    /* renamed from: o  reason: collision with root package name */
    public static final boolean f4049o = ApollonConstants.DEBUG;

    /* renamed from: pf  reason: collision with root package name */
    public static final String f4050pf = TaskManager.class.getSimpleName();
    public static HashMap<String, TaskManager> sTskMgrMap = new HashMap<>();

    /* renamed from: ad  reason: collision with root package name */
    public String f4051ad;

    /* renamed from: de  reason: collision with root package name */
    public Timer f4052de = new Timer();

    /* renamed from: fe  reason: collision with root package name */
    public final HashMap<String, ArrayList<Task>> f4053fe = new HashMap<>();

    /* renamed from: i  reason: collision with root package name */
    public rg f4054i = new rg(this, (qw) null);
    public long qw = Long.MAX_VALUE;

    /* renamed from: rg  reason: collision with root package name */
    public final HashMap<Future<?>, Runnable> f4055rg = new HashMap<>();

    /* renamed from: th  reason: collision with root package name */
    public final BlockingQueue<Runnable> f4056th = new LinkedBlockingQueue(10);

    /* renamed from: uk  reason: collision with root package name */
    public fe f4057uk = new fe(5, 128, 1, TimeUnit.SECONDS, this.f4056th, this.f4058yj);

    /* renamed from: yj  reason: collision with root package name */
    public final ThreadFactory f4058yj = new qw(this);

    public class Task {

        /* renamed from: ad  reason: collision with root package name */
        public Runnable f4059ad;

        /* renamed from: de  reason: collision with root package name */
        public long f4060de;

        /* renamed from: fe  reason: collision with root package name */
        public long f4061fe;
        public String qw;

        /* renamed from: rg  reason: collision with root package name */
        public boolean f4062rg;

        /* renamed from: th  reason: collision with root package name */
        public long f4063th;

        public Task(TaskManager taskManager, long j, long j2, boolean z, String str, Runnable runnable) {
            this.f4061fe = j;
            this.f4063th = System.currentTimeMillis() + j;
            this.f4060de = j2;
            this.f4062rg = z;
            this.f4059ad = runnable;
            this.qw = str;
        }
    }

    public class ad extends TimerTask {
        public ad() {
        }

        public void run() {
            TaskManager.this.m271if();
        }
    }

    public class de implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ long f4065ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ Task f4066th;

        public de(long j, Task task) {
            this.f4065ad = j;
            this.f4066th = task;
        }

        public void run() {
            try {
                Thread.sleep(this.f4065ad);
            } catch (InterruptedException e) {
                LogUtil.e(TaskManager.f4050pf, e.getMessage(), e);
            }
            TaskManager.this.ggg(this.f4066th);
        }
    }

    public class fe extends ThreadPoolExecutor {
        public fe(int i2, int i3, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
            super(i2, i3, j, timeUnit, blockingQueue, threadFactory);
        }

        public void afterExecute(Runnable runnable, Throwable th2) {
            TaskManager.this.f4055rg.remove((Future) runnable);
            super.afterExecute(runnable, th2);
        }
    }

    public class qw implements ThreadFactory {

        /* renamed from: ad  reason: collision with root package name */
        public final AtomicInteger f4069ad = new AtomicInteger(1);

        public qw(TaskManager taskManager) {
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "DxmWalletTask #" + this.f4069ad.getAndIncrement());
        }
    }

    public TaskManager() {
        fe feVar;
        if (ChannelUtils.isSpecailPackage() && (feVar = this.f4057uk) != null) {
            feVar.allowCoreThreadTimeOut(true);
        }
    }

    public static synchronized TaskManager getInstance(String str) {
        TaskManager taskManager;
        synchronized (TaskManager.class) {
            taskManager = sTskMgrMap.get(str);
            if (taskManager == null) {
                taskManager = new TaskManager();
                sTskMgrMap.put(str, taskManager);
                taskManager.f4051ad = str;
            }
        }
        return taskManager;
    }

    public boolean addTask(Task task, String str) {
        if (task == null || task.f4059ad == null) {
            return false;
        }
        synchronized (this.f4053fe) {
            ArrayList<Task> de2 = de(str);
            if (!o(task, de2)) {
                if (task.f4063th <= System.currentTimeMillis()) {
                    when(task);
                } else if (task.f4061fe > 0) {
                    when(task);
                }
                if (task.f4060de > 0) {
                    task.f4063th = System.currentTimeMillis() + task.f4061fe + task.f4060de;
                    de2.add(task);
                    th(task);
                }
            } else {
                i(task, str);
            }
        }
        return true;
    }

    public void cancelAllTasks(String str) {
        synchronized (this.f4053fe) {
            ArrayList<Task> de2 = de(str);
            Iterator<Task> it = de2.iterator();
            while (it.hasNext()) {
                m272switch(it.next());
            }
            de2.clear();
            this.f4053fe.remove(str);
        }
    }

    public void cancelTask(String str, String str2) {
        synchronized (this.f4053fe) {
            ArrayList<Task> de2 = de(str);
            Iterator<Task> it = de2.iterator();
            while (it.hasNext()) {
                Task next = it.next();
                if (next.qw.equals(str2)) {
                    m272switch(next);
                    de2.remove(next.qw);
                }
            }
        }
    }

    public final ArrayList<Task> de(String str) {
        ArrayList<Task> arrayList = this.f4053fe.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        this.f4053fe.put(str, arrayList);
        return arrayList;
    }

    public final void ggg(Task task) {
        if (task.f4060de > 0) {
            task.f4061fe = 0;
        }
        if (task.f4062rg) {
            this.f4054i.execute(task.f4059ad);
            return;
        }
        this.f4055rg.put(this.f4057uk.submit(task.f4059ad), task.f4059ad);
        if (f4049o) {
            "execute task, " + task.qw + " execute time is " + System.currentTimeMillis();
        }
    }

    public final boolean i(Task task, String str) {
        if (task == null || task.f4059ad == null) {
            return false;
        }
        synchronized (this.f4053fe) {
            ArrayList<Task> de2 = de(str);
            Task qw2 = qw(task.qw, de2);
            if (qw2 == null) {
                return false;
            }
            m272switch(qw2);
            de2.remove(qw2);
            addTask(task, str);
            return true;
        }
    }

    /* renamed from: if  reason: not valid java name */
    public final void m271if() {
        boolean z = f4049o;
        synchronized (this.f4053fe) {
            long currentTimeMillis = System.currentTimeMillis();
            this.qw = Long.MAX_VALUE;
            for (String de2 : this.f4053fe.keySet()) {
                ArrayList arrayList = new ArrayList();
                Iterator<Task> it = de(de2).iterator();
                while (it.hasNext()) {
                    Task next = it.next();
                    if (next.f4063th - currentTimeMillis < 1000) {
                        if (f4049o) {
                            "task.mNextRunTime - current = " + (next.f4063th - currentTimeMillis);
                        }
                        when(next);
                        if (next.f4060de > 0) {
                            next.f4063th = next.f4060de + currentTimeMillis;
                            arrayList.add(next);
                        }
                    }
                    if (next.f4063th < this.qw) {
                        this.qw = next.f4063th;
                    }
                }
                if (this.qw < Long.MAX_VALUE) {
                    rg(this.qw - currentTimeMillis);
                }
            }
        }
    }

    public final boolean o(Task task, ArrayList<Task> arrayList) {
        String str;
        Iterator<Task> it = arrayList.iterator();
        while (it.hasNext()) {
            Task next = it.next();
            if (next != null && (str = next.qw) != null && str.equals(task.qw)) {
                return true;
            }
        }
        return false;
    }

    public final Task qw(String str, ArrayList<Task> arrayList) {
        Iterator<Task> it = arrayList.iterator();
        while (it.hasNext()) {
            Task next = it.next();
            if (str != null && str.equals(next.qw)) {
                return next;
            }
        }
        return null;
    }

    public final void rg(long j) {
        if (f4049o) {
            "intervalMillis: " + j;
        }
        Timer timer = this.f4052de;
        if (timer != null) {
            timer.cancel();
            this.f4052de = null;
        }
        this.f4052de = new Timer();
        this.f4052de.schedule(new ad(), j);
    }

    public void shutdown() {
        Timer timer = this.f4052de;
        if (timer != null) {
            timer.cancel();
            this.f4052de = null;
        }
        rg rgVar = this.f4054i;
        if (rgVar != null && rgVar.f4070ad != null) {
            while (true) {
                Runnable poll = this.f4054i.f4070ad.poll();
                if (poll == null) {
                    break;
                }
                this.f4054i.ad(poll);
            }
        }
        fe feVar = this.f4057uk;
        if (feVar != null) {
            try {
                feVar.shutdownNow();
                this.f4057uk.awaitTermination(3, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                LogUtil.e(f4050pf, e.getMessage(), e);
            }
        }
        String str = this.f4051ad;
        if (str != null) {
            sTskMgrMap.remove(str);
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public final void m272switch(Task task) {
        if (task.f4062rg) {
            this.f4054i.ad(task.f4059ad);
            return;
        }
        for (Future next : this.f4055rg.keySet()) {
            if (this.f4055rg.get(next) == task.f4059ad && next != null) {
                if (!next.isCancelled() || !next.isDone()) {
                    next.cancel(true);
                }
            }
        }
    }

    public final void th(Task task) {
        long j = task.f4063th;
        if (j < this.qw) {
            rg(Math.max(j - System.currentTimeMillis(), 1000));
        }
    }

    public final void when(Task task) {
        if (task.f4061fe > 0) {
            yj(task, task.f4063th - System.currentTimeMillis());
        } else {
            ggg(task);
        }
    }

    public final void yj(Task task, long j) {
        this.f4057uk.execute(new de(j, task));
    }

    public class rg implements Executor {

        /* renamed from: ad  reason: collision with root package name */
        public final LinkedList<Runnable> f4070ad;

        /* renamed from: th  reason: collision with root package name */
        public Runnable f4071th;

        public class qw implements Runnable {

            /* renamed from: ad  reason: collision with root package name */
            public final /* synthetic */ Runnable f4073ad;

            public qw(Runnable runnable) {
                this.f4073ad = runnable;
            }

            public void run() {
                try {
                    this.f4073ad.run();
                } finally {
                    rg.this.qw();
                }
            }
        }

        public rg() {
            this.f4070ad = new LinkedList<>();
        }

        public synchronized void ad(Runnable runnable) {
            this.f4070ad.remove(runnable);
        }

        public synchronized void execute(Runnable runnable) {
            this.f4070ad.offer(new qw(runnable));
            if (this.f4071th == null) {
                qw();
            }
        }

        public synchronized void qw() {
            Runnable poll = this.f4070ad.poll();
            this.f4071th = poll;
            if (poll != null) {
                TaskManager.this.f4055rg.put(TaskManager.this.f4057uk.submit(this.f4071th), this.f4071th);
            }
        }

        public /* synthetic */ rg(TaskManager taskManager, qw qwVar) {
            this();
        }
    }
}
