package fe.fe.ddd.p000if.rg;

import android.os.SystemClock;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.baidu.searchbox.elasticthread.executor.BaseExecutorCell;
import com.baidu.searchbox.elasticthread.statistic.Recordable;
import com.baidu.searchbox.elasticthread.task.ElasticTask;
import fe.fe.ddd.p000if.yj.de;
import java.util.concurrent.TimeUnit;

/* renamed from: fe.fe.ddd.if.rg.ad  reason: invalid package */
public abstract class ad extends BaseExecutorCell {

    /* renamed from: i  reason: collision with root package name */
    public long f1472i = 0;

    /* renamed from: if  reason: not valid java name */
    public int f28if;

    /* renamed from: o  reason: collision with root package name */
    public long f1473o = 0;

    /* renamed from: pf  reason: collision with root package name */
    public boolean f1474pf = false;

    /* renamed from: switch  reason: not valid java name */
    public long f29switch;

    public ad(int i2) {
        super(i2);
    }

    public boolean ggg() {
        return this.f1474pf;
    }

    public void i() {
        super.i();
        this.f28if = 0;
        this.f29switch = 0;
        if (this.f1474pf) {
            this.f29switch = 0 + 1;
        }
    }

    /* renamed from: if  reason: not valid java name */
    public void m67if(ElasticTask elasticTask) {
        super.m39if(elasticTask);
        if (this.f1474pf) {
            de.m70switch().xxx();
        }
    }

    public void o() {
        super.o();
        if (this.f1474pf) {
            this.f29switch += SystemClock.elapsedRealtime() - Math.max(this.f1031th, this.f1472i);
        }
    }

    public long ppp() {
        return this.f29switch;
    }

    public boolean qw() {
        if (this.f1474pf && uk() < this.f1027ad) {
            return true;
        }
        return false;
    }

    public void vvv() {
        if (this.f1474pf) {
            th();
            return;
        }
        this.f1474pf = true;
        this.f1472i = SystemClock.elapsedRealtime();
        if (this.f1032uk == Recordable.RecordStatus.RECORDING) {
            this.f28if++;
        }
        this.f1028de.setKeepAliveTime(CoroutineLiveDataKt.DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS);
    }

    public int when() {
        return this.f28if;
    }

    public void xxx() {
        if (!this.f1474pf) {
            th();
            return;
        }
        this.f1474pf = false;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.f1473o = elapsedRealtime;
        if (this.f1032uk == Recordable.RecordStatus.RECORDING) {
            this.f29switch += elapsedRealtime - Math.max(this.f1031th, this.f1472i);
        }
        this.f1028de.setKeepAliveTime(100, TimeUnit.MILLISECONDS);
    }
}
