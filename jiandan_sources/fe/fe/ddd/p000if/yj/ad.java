package fe.fe.ddd.p000if.yj;

import android.os.SystemClock;
import com.baidu.searchbox.elasticthread.executor.BaseExecutorCell;
import com.baidu.searchbox.elasticthread.statistic.Recordable;
import com.baidu.searchbox.elasticthread.task.ElasticTask;
import fe.fe.ddd.p000if.de;

/* renamed from: fe.fe.ddd.if.yj.ad  reason: invalid package */
public class ad implements Recordable {

    /* renamed from: ad  reason: collision with root package name */
    public volatile fe.fe.ddd.p000if.rg.ad f1481ad;

    /* renamed from: de  reason: collision with root package name */
    public volatile fe.fe.ddd.p000if.rg.ad f1482de;

    /* renamed from: fe  reason: collision with root package name */
    public int f1483fe = 0;
    public volatile fe.fe.ddd.p000if.rg.ad qw;

    /* renamed from: rg  reason: collision with root package name */
    public long f1484rg = 0;

    public final void ad() {
        int i2 = this.f1483fe;
        if (1 == i2) {
            rg().xxx();
            this.f1483fe = 0;
        } else if (2 == i2) {
            th().xxx();
            this.f1483fe = 1;
        } else if (3 == i2) {
            fe().xxx();
            this.f1483fe = 2;
        }
    }

    public boolean de(ElasticTask elasticTask) {
        int i2 = this.f1483fe;
        if (i2 == 0) {
            return false;
        }
        return i2 == 1 ? rg().de(elasticTask) : i2 == 2 ? rg().de(elasticTask) || th().de(elasticTask) : i2 == 3 && (rg().de(elasticTask) || th().de(elasticTask) || fe().de(elasticTask));
    }

    public fe.fe.ddd.p000if.rg.ad fe() {
        if (this.f1482de == null) {
            synchronized (this) {
                if (this.f1482de == null) {
                    this.f1482de = (fe.fe.ddd.p000if.rg.ad) BaseExecutorCell.ad(de.ggg, BaseExecutorCell.ExecutorType.DREDGE_DISASTER);
                }
            }
        }
        return this.f1482de;
    }

    public final void i() {
        int i2 = this.f1483fe;
        if (i2 == 0) {
            rg().vvv();
            this.f1483fe = 1;
        } else if (1 == i2) {
            th().vvv();
            this.f1483fe = 2;
        } else if (2 == i2) {
            fe().vvv();
            this.f1483fe = 3;
        }
    }

    public int qw() {
        double qw2 = de.m70switch().when().qw();
        if (qw2 >= de.vvv && 3 != this.f1483fe) {
            if ((qw2 >= de.xxx) || SystemClock.elapsedRealtime() - this.f1484rg > de.nn) {
                i();
                this.f1484rg = SystemClock.elapsedRealtime();
                de.m70switch().vvv(de.nn + 10);
                return 1;
            }
        }
        if (this.f1483fe == 0 || qw2 >= de.ddd || SystemClock.elapsedRealtime() - this.f1484rg <= de.mmm) {
            return 0;
        }
        ad();
        this.f1484rg = SystemClock.elapsedRealtime();
        de.m70switch().vvv(de.mmm + 10);
        return -1;
    }

    public fe.fe.ddd.p000if.rg.ad rg() {
        if (this.qw == null) {
            synchronized (this) {
                if (this.qw == null) {
                    this.qw = (fe.fe.ddd.p000if.rg.ad) BaseExecutorCell.ad(de.when, BaseExecutorCell.ExecutorType.DREDGE_NORMAL);
                }
            }
        }
        return this.qw;
    }

    public fe.fe.ddd.p000if.rg.ad th() {
        if (this.f1481ad == null) {
            synchronized (this) {
                if (this.f1481ad == null) {
                    this.f1481ad = (fe.fe.ddd.p000if.rg.ad) BaseExecutorCell.ad(de.ppp, BaseExecutorCell.ExecutorType.DREDGE_NORMAL);
                }
            }
        }
        return this.f1481ad;
    }

    public void uk() {
        rg().o();
        th().o();
        fe().o();
    }

    public void yj() {
        rg().i();
        th().i();
        fe().i();
    }
}
