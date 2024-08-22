package fe.fe.ddd.p000if.yj;

import com.baidu.searchbox.elasticthread.executor.BaseExecutorCell;
import com.baidu.searchbox.elasticthread.statistic.Recordable;
import com.baidu.searchbox.elasticthread.task.ElasticTask;
import fe.fe.ddd.p000if.de;

/* renamed from: fe.fe.ddd.if.yj.qw  reason: invalid package */
public class qw implements Recordable {

    /* renamed from: ad  reason: collision with root package name */
    public BaseExecutorCell f1495ad = BaseExecutorCell.ad(de.f26if, BaseExecutorCell.ExecutorType.ARTERY);

    /* renamed from: de  reason: collision with root package name */
    public BaseExecutorCell f1496de = BaseExecutorCell.ad(de.f27switch, BaseExecutorCell.ExecutorType.ARTERY);
    public BaseExecutorCell qw = BaseExecutorCell.ad(de.f1466pf, BaseExecutorCell.ExecutorType.ARTERY);

    public BaseExecutorCell ad() {
        return this.f1496de;
    }

    public BaseExecutorCell de() {
        return this.f1495ad;
    }

    public BaseExecutorCell fe() {
        return this.qw;
    }

    public boolean qw(ElasticTask elasticTask) {
        int ad2 = elasticTask.ad();
        return (ad2 == 0 || ad2 == 1) ? this.qw.de(elasticTask) || this.f1495ad.de(elasticTask) || this.f1496de.de(elasticTask) : ad2 == 2 ? this.f1495ad.de(elasticTask) || this.f1496de.de(elasticTask) : ad2 == 3 && this.f1496de.de(elasticTask);
    }

    public void rg() {
        this.qw.i();
        this.f1495ad.i();
        this.f1496de.i();
    }

    public void th() {
        this.qw.o();
        this.f1495ad.o();
        this.f1496de.o();
    }
}
