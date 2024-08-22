package fe.fe.ddd.p000if.uk;

import android.os.SystemClock;
import com.alipay.sdk.m.k.b;
import com.baidu.searchbox.elasticthread.ElasticDataUploader;
import com.baidu.searchbox.elasticthread.executor.BaseExecutorCell;
import com.baidu.searchbox.elasticthread.statistic.Recordable;
import com.google.gson.internal.bind.TypeAdapters;
import fe.fe.ddd.p000if.th.qw;
import fe.fe.ddd.p000if.yj.de;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: fe.fe.ddd.if.uk.ad  reason: invalid package */
public class ad implements Recordable {

    /* renamed from: ad  reason: collision with root package name */
    public volatile long f1479ad = 0;

    /* renamed from: de  reason: collision with root package name */
    public volatile long f1480de = 0;
    public volatile Recordable.RecordStatus qw = Recordable.RecordStatus.UNINITIATED;

    public Recordable.RecordStatus ad() {
        return this.qw;
    }

    public final JSONObject de(BaseExecutorCell baseExecutorCell) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (baseExecutorCell != null) {
            jSONObject.put("maxThreadNum", baseExecutorCell.rg());
            jSONObject.put("workTime", baseExecutorCell.yj());
            jSONObject.put("completedTaskCount", baseExecutorCell.fe());
        }
        return jSONObject;
    }

    public final JSONObject fe(fe.fe.ddd.p000if.rg.ad adVar, int i2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (adVar != null) {
            jSONObject.put("maxThreadNum", adVar.rg());
            jSONObject.put("workTime", adVar.yj());
            jSONObject.put("completedTaskCount", adVar.fe());
            jSONObject.put("openTime", adVar.ppp());
            jSONObject.put("openCount", adVar.when());
        }
        return jSONObject;
    }

    public long qw() {
        if (this.qw == Recordable.RecordStatus.RECORD_END) {
            return this.f1480de - this.f1479ad;
        }
        return -1;
    }

    public final JSONObject rg(qw qwVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("waitingTime", qwVar.rg());
        jSONObject.put("outputTaskCount", qwVar.de());
        return jSONObject;
    }

    public void th() {
        this.qw = Recordable.RecordStatus.RECORDING;
        this.f1479ad = SystemClock.elapsedRealtime();
        this.f1480de = 0;
    }

    public void uk() {
        if (this.qw == Recordable.RecordStatus.RECORD_END) {
            try {
                de deVar = de.m70switch();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("record_time", qw());
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                fe.fe.ddd.p000if.yj.qw pf2 = deVar.pf();
                jSONObject3.put("first", de(pf2.fe()));
                jSONObject3.put(TypeAdapters.AnonymousClass27.SECOND, de(pf2.de()));
                jSONObject3.put(b.f661o, de(pf2.ad()));
                jSONObject2.put("artery", jSONObject3);
                JSONObject jSONObject4 = new JSONObject();
                fe.fe.ddd.p000if.yj.ad adVar = deVar.m71if();
                jSONObject4.put("first", fe(adVar.rg(), fe.fe.ddd.p000if.de.when));
                jSONObject4.put(TypeAdapters.AnonymousClass27.SECOND, fe(adVar.th(), fe.fe.ddd.p000if.de.ppp));
                jSONObject4.put("disaster", fe(adVar.fe(), fe.fe.ddd.p000if.de.ggg));
                jSONObject2.put("dredge", jSONObject4);
                jSONObject.put("executor", jSONObject2);
                JSONObject jSONObject5 = new JSONObject();
                fe.fe.ddd.p000if.th.ad when = deVar.when();
                jSONObject5.put("immediate", rg(when.de(0)));
                jSONObject5.put("first", rg(when.de(1)));
                jSONObject5.put(TypeAdapters.AnonymousClass27.SECOND, rg(when.de(2)));
                jSONObject5.put(b.f661o, rg(when.de(3)));
                jSONObject.put("queue", jSONObject5);
                ElasticDataUploader.ad().de(jSONObject);
            } catch (Exception unused) {
            }
        }
    }

    public void yj() {
        this.qw = Recordable.RecordStatus.RECORD_END;
        this.f1480de = SystemClock.elapsedRealtime();
    }
}
