package fe.fe.ddd.p000if.yj;

import com.baidu.searchbox.elasticthread.executor.BaseExecutorCell;
import com.baidu.searchbox.elasticthread.statistic.Recordable;
import com.baidu.searchbox.elasticthread.task.ElasticTask;
import fe.fe.ddd.p000if.rg.rg;
import fe.fe.ddd.p000if.th.qw;

/* renamed from: fe.fe.ddd.if.yj.fe  reason: invalid package */
public class fe implements Recordable {

    /* renamed from: ad  reason: collision with root package name */
    public BaseExecutorCell f1494ad = BaseExecutorCell.ad(1, BaseExecutorCell.ExecutorType.SERIAL);
    public qw qw = new qw();

    public void ad(Runnable runnable, String str, int i2) {
        this.qw.th(runnable, str, i2);
    }

    public void de() {
        this.f1494ad.i();
    }

    public void fe() {
        this.f1494ad.o();
    }

    public boolean qw() {
        return ((rg) this.f1494ad).ppp();
    }

    public boolean rg() {
        ElasticTask ad2 = this.qw.ad();
        if (ad2 == null || !this.f1494ad.de(ad2)) {
            return false;
        }
        this.qw.o(ad2);
        return true;
    }
}
