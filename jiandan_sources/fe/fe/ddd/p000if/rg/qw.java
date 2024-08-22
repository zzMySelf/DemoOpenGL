package fe.fe.ddd.p000if.rg;

import com.baidu.searchbox.elasticthread.executor.BaseExecutorCell;
import com.baidu.searchbox.elasticthread.task.ElasticTask;
import fe.fe.ddd.p000if.de;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: fe.fe.ddd.if.rg.qw  reason: invalid package */
public class qw extends BaseExecutorCell {
    public qw(int i2) {
        super(i2);
        this.f1028de = new ThreadPoolExecutor(i2, i2, de.f1470yj, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    /* renamed from: if  reason: not valid java name */
    public synchronized void m68if(ElasticTask elasticTask) {
        super.m39if(elasticTask);
        fe.fe.ddd.p000if.yj.de.m70switch().xxx();
    }

    public boolean qw() {
        return uk() < this.f1027ad;
    }

    public String th() {
        return "ArteryElasticExecutorCell";
    }
}
