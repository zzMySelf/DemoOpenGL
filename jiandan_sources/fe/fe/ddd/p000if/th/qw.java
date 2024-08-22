package fe.fe.ddd.p000if.th;

import android.text.TextUtils;
import com.baidu.searchbox.elasticthread.statistic.Recordable;
import com.baidu.searchbox.elasticthread.task.ElasticTask;
import java.util.LinkedList;
import java.util.List;

/* renamed from: fe.fe.ddd.if.th.qw  reason: invalid package */
public class qw implements Recordable {

    /* renamed from: ad  reason: collision with root package name */
    public long f1476ad = 0;

    /* renamed from: de  reason: collision with root package name */
    public long f1477de = 0;

    /* renamed from: fe  reason: collision with root package name */
    public Recordable.RecordStatus f1478fe = Recordable.RecordStatus.UNINITIATED;
    public List<ElasticTask> qw = new LinkedList();

    public ElasticTask ad() {
        if (this.qw.isEmpty()) {
            return null;
        }
        return this.qw.get(0);
    }

    public long de() {
        return this.f1477de;
    }

    public int fe() {
        return this.qw.size();
    }

    public void i() {
        this.f1478fe = Recordable.RecordStatus.RECORD_END;
    }

    public void o(ElasticTask elasticTask) {
        this.qw.remove(elasticTask);
        if (this.f1478fe == Recordable.RecordStatus.RECORDING) {
            this.f1476ad += elasticTask.fe();
            this.f1477de++;
        }
    }

    public long qw() {
        long j = 0;
        for (ElasticTask fe2 : this.qw) {
            j += fe2.fe();
        }
        return j;
    }

    public long rg() {
        return this.f1476ad;
    }

    public void th(Runnable runnable, String str, int i2) {
        if (runnable == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("illegal params");
        }
        ElasticTask qw2 = fe.fe.ddd.p000if.i.qw.ad().qw(runnable, str, i2);
        this.qw.add(qw2);
        qw2.yj();
    }

    public void uk() {
        this.f1476ad = 0;
        this.f1477de = 0;
        this.f1478fe = Recordable.RecordStatus.RECORDING;
    }

    public boolean yj() {
        return this.qw.isEmpty();
    }
}
