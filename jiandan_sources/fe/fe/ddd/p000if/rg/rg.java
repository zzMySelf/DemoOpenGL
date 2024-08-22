package fe.fe.ddd.p000if.rg;

import com.baidu.searchbox.elasticthread.ElasticDataUploader;
import com.baidu.searchbox.elasticthread.executor.BaseExecutorCell;
import com.baidu.searchbox.elasticthread.statistic.Recordable;
import com.baidu.searchbox.elasticthread.task.ElasticTask;
import fe.fe.ddd.p000if.de;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: fe.fe.ddd.if.rg.rg  reason: invalid package */
public class rg extends BaseExecutorCell {

    /* renamed from: i  reason: collision with root package name */
    public int f1475i = 0;

    public rg(int i2) {
        super(i2);
        if (i2 != 1) {
            th();
            "You are creating a SerialExecutorCell with maxThreadNum " + i2 + ". For SerialExecutorCell, maxThreadNum must be 1. So it will be forced to set to 1.";
            this.f1027ad = 1;
        }
        this.f1028de = new ThreadPoolExecutor(1, 1, de.f1470yj, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    public final JSONObject ggg(ElasticTask elasticTask) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("warning_type", "serial_block");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("block_task", elasticTask.qw());
            jSONObject.put("warning_data", jSONObject2);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public void i() {
        super.i();
        this.f1475i = 0;
    }

    /* renamed from: if  reason: not valid java name */
    public synchronized void m69if(ElasticTask elasticTask) {
        super.m39if(elasticTask);
        fe.fe.ddd.p000if.yj.de.m70switch().qqq();
    }

    public synchronized void pf(ElasticTask elasticTask) {
        super.pf(elasticTask);
        if (de.f1464i) {
            fe.fe.ddd.p000if.yj.de.m70switch().aaa(de.f1465o + 10);
        }
    }

    public synchronized boolean ppp() {
        if (!de.f1464i) {
            return false;
        }
        ElasticTask vvv = vvv();
        if (vvv == null) {
            return false;
        }
        if (vvv.de() < de.f1465o) {
            return false;
        }
        when(vvv);
        return true;
    }

    public boolean qw() {
        return uk() < 1;
    }

    public String th() {
        return "SerialElasticExecutorCell";
    }

    public final synchronized ElasticTask vvv() {
        if (this.qw.isEmpty()) {
            return null;
        }
        return this.qw.get(0);
    }

    public final void when(ElasticTask elasticTask) {
        if (this.f1032uk == Recordable.RecordStatus.RECORDING) {
            this.f1029fe += elasticTask.rg(this.f1031th, this.f1033yj);
            this.f1030rg++;
            this.f1475i++;
        }
        ElasticDataUploader.ad().fe(ggg(elasticTask));
        elasticTask.i((ElasticTask.ElasticTaskCallback) null);
        this.f1028de.shutdown();
        this.qw.clear();
        this.f1028de = new ThreadPoolExecutor(1, 1, de.f1470yj, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        fe.fe.ddd.p000if.yj.de.m70switch().qqq();
    }
}
