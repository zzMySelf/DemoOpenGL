package fe.fe.ddd.p000if.uk;

import com.baidu.searchbox.elasticthread.executor.BaseExecutorCell;
import fe.fe.ddd.p000if.rg.ad;
import fe.fe.ddd.p000if.yj.de;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: fe.fe.ddd.if.uk.qw  reason: invalid package */
public class qw {
    public static volatile qw qw;

    public static qw qw() {
        if (qw == null) {
            synchronized (qw.class) {
                if (qw == null) {
                    qw = new qw();
                }
            }
        }
        return qw;
    }

    public final JSONObject ad(BaseExecutorCell baseExecutorCell) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (baseExecutorCell != null) {
            jSONObject.put("Status", "working");
            jSONObject.put("WorkingThreadNum", baseExecutorCell.uk());
            jSONObject.put("MaxThreadNum", baseExecutorCell.rg());
        }
        return jSONObject;
    }

    public final JSONObject de(ad adVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (adVar != null) {
            jSONObject.put("Status", adVar.ggg() ? "working" : "shutdown");
            jSONObject.put("WorkingThreadNum", adVar.uk());
            jSONObject.put("MaxThreadNum", adVar.rg());
        }
        return jSONObject;
    }

    public final JSONObject fe(fe.fe.ddd.p000if.th.qw qwVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("TaskNum", qwVar.fe());
        jSONObject.put("WaitingTime", qwVar.qw());
        return jSONObject;
    }

    public void rg() {
        try {
            de deVar = de.m70switch();
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            fe.fe.ddd.p000if.yj.qw pf2 = deVar.pf();
            jSONObject3.put("First", ad(pf2.fe()));
            jSONObject3.put("Second", ad(pf2.de()));
            jSONObject3.put("Third", ad(pf2.ad()));
            jSONObject2.put("Artery", jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            fe.fe.ddd.p000if.yj.ad adVar = deVar.m71if();
            jSONObject4.put("First", de(adVar.rg()));
            jSONObject4.put("Second", de(adVar.th()));
            jSONObject4.put("Disaster", de(adVar.fe()));
            jSONObject2.put("Dredge", jSONObject4);
            jSONObject.put("Executor", jSONObject2);
            JSONObject jSONObject5 = new JSONObject();
            fe.fe.ddd.p000if.th.ad when = deVar.when();
            jSONObject5.put("Immediate", fe(when.de(0)));
            jSONObject5.put("First", fe(when.de(1)));
            jSONObject5.put("Second", fe(when.de(2)));
            jSONObject5.put("Third", fe(when.de(3)));
            jSONObject.put("Queue", jSONObject5);
            new JSONObject().put("ElasticRealTimeData", jSONObject);
        } catch (Exception unused) {
        }
    }
}
