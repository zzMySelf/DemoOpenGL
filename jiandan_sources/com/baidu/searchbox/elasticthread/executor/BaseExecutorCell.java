package com.baidu.searchbox.elasticthread.executor;

import android.os.SystemClock;
import com.baidu.searchbox.elasticthread.statistic.Recordable;
import com.baidu.searchbox.elasticthread.task.ElasticTask;
import fe.fe.ddd.p000if.rg.de;
import fe.fe.ddd.p000if.rg.fe;
import fe.fe.ddd.p000if.rg.rg;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class BaseExecutorCell implements Recordable {

    /* renamed from: ad  reason: collision with root package name */
    public int f1027ad;

    /* renamed from: de  reason: collision with root package name */
    public ThreadPoolExecutor f1028de;

    /* renamed from: fe  reason: collision with root package name */
    public long f1029fe;
    public List<ElasticTask> qw = new LinkedList();

    /* renamed from: rg  reason: collision with root package name */
    public int f1030rg;

    /* renamed from: th  reason: collision with root package name */
    public long f1031th = 0;

    /* renamed from: uk  reason: collision with root package name */
    public Recordable.RecordStatus f1032uk = Recordable.RecordStatus.UNINITIATED;

    /* renamed from: yj  reason: collision with root package name */
    public long f1033yj = Long.MAX_VALUE;

    public enum ExecutorType {
        ARTERY,
        DREDGE_NORMAL,
        DREDGE_DISASTER,
        SERIAL
    }

    public static /* synthetic */ class ad {
        public static final /* synthetic */ int[] qw;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.baidu.searchbox.elasticthread.executor.BaseExecutorCell$ExecutorType[] r0 = com.baidu.searchbox.elasticthread.executor.BaseExecutorCell.ExecutorType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                qw = r0
                com.baidu.searchbox.elasticthread.executor.BaseExecutorCell$ExecutorType r1 = com.baidu.searchbox.elasticthread.executor.BaseExecutorCell.ExecutorType.ARTERY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x001d }
                com.baidu.searchbox.elasticthread.executor.BaseExecutorCell$ExecutorType r1 = com.baidu.searchbox.elasticthread.executor.BaseExecutorCell.ExecutorType.DREDGE_NORMAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.baidu.searchbox.elasticthread.executor.BaseExecutorCell$ExecutorType r1 = com.baidu.searchbox.elasticthread.executor.BaseExecutorCell.ExecutorType.DREDGE_DISASTER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.baidu.searchbox.elasticthread.executor.BaseExecutorCell$ExecutorType r1 = com.baidu.searchbox.elasticthread.executor.BaseExecutorCell.ExecutorType.SERIAL     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.elasticthread.executor.BaseExecutorCell.ad.<clinit>():void");
        }
    }

    public class qw implements ElasticTask.ElasticTaskCallback {
        public final /* synthetic */ ElasticTask qw;

        public qw(ElasticTask elasticTask) {
            this.qw = elasticTask;
        }

        public void ad() {
            BaseExecutorCell.this.pf(this.qw);
        }

        public void qw() {
            BaseExecutorCell.this.m39if(this.qw);
        }
    }

    public BaseExecutorCell(int i2) {
        this.f1027ad = i2;
    }

    public static BaseExecutorCell ad(int i2, ExecutorType executorType) {
        int i3 = ad.qw[executorType.ordinal()];
        if (i3 == 1) {
            return new fe.fe.ddd.p000if.rg.qw(i2);
        }
        if (i3 == 2) {
            return new fe(i2);
        }
        if (i3 == 3) {
            return new de(i2);
        }
        if (i3 != 4) {
            return null;
        }
        return new rg(i2);
    }

    public synchronized boolean de(ElasticTask elasticTask) {
        if (!qw()) {
            return false;
        }
        elasticTask.i(new qw(elasticTask));
        this.qw.add(elasticTask);
        this.f1028de.execute(elasticTask);
        return true;
    }

    public synchronized int fe() {
        return this.f1030rg;
    }

    public synchronized void i() {
        this.f1031th = SystemClock.elapsedRealtime();
        this.f1033yj = Long.MAX_VALUE;
        this.f1029fe = 0;
        this.f1030rg = 0;
        this.f1032uk = Recordable.RecordStatus.RECORDING;
    }

    /* renamed from: if  reason: not valid java name */
    public synchronized void m39if(ElasticTask elasticTask) {
        elasticTask.th();
        this.qw.remove(elasticTask);
        if (this.f1032uk == Recordable.RecordStatus.RECORDING) {
            this.f1029fe += elasticTask.rg(this.f1031th, this.f1033yj);
            this.f1030rg++;
        }
    }

    public synchronized void o() {
        this.f1033yj = SystemClock.elapsedRealtime();
        for (ElasticTask rg2 : this.qw) {
            this.f1029fe += rg2.rg(this.f1031th, this.f1033yj);
        }
        this.f1032uk = Recordable.RecordStatus.RECORD_END;
    }

    public synchronized void pf(ElasticTask elasticTask) {
        elasticTask.uk();
        m40switch(elasticTask);
    }

    public abstract boolean qw();

    public int rg() {
        return this.f1027ad;
    }

    /* renamed from: switch  reason: not valid java name */
    public final void m40switch(ElasticTask elasticTask) {
        int ad2 = elasticTask.ad();
        Thread currentThread = Thread.currentThread();
        if (ad2 == 0) {
            currentThread.setPriority(fe.fe.ddd.p000if.de.f1461ad);
        } else if (ad2 == 1) {
            currentThread.setPriority(fe.fe.ddd.p000if.de.f1462de);
        } else if (ad2 == 2) {
            currentThread.setPriority(fe.fe.ddd.p000if.de.f1463fe);
        } else if (ad2 == 3) {
            currentThread.setPriority(fe.fe.ddd.p000if.de.f1467rg);
        } else if (ad2 == 4) {
            currentThread.setPriority(fe.fe.ddd.p000if.de.f1468th);
        }
        currentThread.setName(elasticTask.qw());
    }

    public abstract String th();

    public synchronized int uk() {
        return this.qw.size();
    }

    public synchronized long yj() {
        return this.f1029fe;
    }
}
