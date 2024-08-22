package fe.mmm.qw.a.yj.qw;

import androidx.annotation.NonNull;
import com.tera.scan.scheduler.executor.job.Job;
import fe.mmm.qw.a.ad;
import fe.mmm.qw.a.yj.de.de;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class qw implements Job {

    /* renamed from: ad  reason: collision with root package name */
    public volatile AtomicBoolean f7646ad = new AtomicBoolean(false);

    /* renamed from: i  reason: collision with root package name */
    public Object f7647i;

    /* renamed from: if  reason: not valid java name */
    public volatile long f323if;

    /* renamed from: o  reason: collision with root package name */
    public volatile long f7648o;

    /* renamed from: pf  reason: collision with root package name */
    public volatile long f7649pf;
    public String ppp;

    /* renamed from: switch  reason: not valid java name */
    public ad f324switch;

    /* renamed from: th  reason: collision with root package name */
    public volatile AtomicBoolean f7650th = new AtomicBoolean(false);

    /* renamed from: uk  reason: collision with root package name */
    public String f7651uk;
    public Timer when;

    /* renamed from: yj  reason: collision with root package name */
    public volatile AtomicBoolean f7652yj = new AtomicBoolean(false);

    /* renamed from: fe.mmm.qw.a.yj.qw.qw$qw  reason: collision with other inner class name */
    public class C0273qw extends TimerTask {
        public C0273qw() {
        }

        public void run() {
            qw.this.f324switch.de();
            fe.mmm.qw.i.qw.uk("BaseJob", "开始升级 up getPriority() = " + qw.this.getPriority() + " " + qw.this.hashCode());
            if (qw.this.getPriority() < 4) {
                qw.this.fe();
            } else {
                qw.this.when.cancel();
            }
        }
    }

    public qw(String str) {
        fe.mmm.qw.i.qw.uk("BaseJob", "BaseJob 开始 " + hashCode());
        this.f7651uk = str;
        this.f7648o = System.currentTimeMillis();
        fe.mmm.qw.i.qw.uk("BaseJob", "BaseJob getCurrSpaceUid:" + de.qw.fe());
        this.ppp = de.qw.fe();
    }

    public /* bridge */ /* synthetic */ Object call() throws Exception {
        rg();
        return this;
    }

    public void de(long j) {
        this.f7648o = j;
    }

    public void fe() {
        try {
            if (this.when != null) {
                this.when.schedule(new C0273qw(), 20000);
            }
        } catch (Exception e) {
            fe.mmm.qw.i.qw.uk("BaseJob", "beginCheck job e = " + e.toString());
        }
    }

    public final String getName() {
        return this.f7651uk;
    }

    public int getPriority() {
        return this.f324switch.qw();
    }

    public void ggg() {
    }

    public long i() {
        return this.f323if - this.f7648o;
    }

    /* renamed from: if  reason: not valid java name */
    public long m958if() {
        if (this.f7649pf == 0) {
            return 0;
        }
        return System.currentTimeMillis() - this.f7649pf;
    }

    public long o() {
        return this.f7649pf - this.f7648o;
    }

    public long pf() {
        return this.f323if - this.f7649pf;
    }

    public abstract void ppp() throws Exception;

    public void qw(ad adVar) {
        this.f324switch = adVar;
        if (adVar.ad()) {
            if (this.when == null) {
                this.when = new Timer();
            }
            fe();
        }
    }

    public Job rg() throws Exception {
        Timer timer = this.when;
        if (timer != null) {
            timer.cancel();
        }
        if (!when()) {
            this.f7646ad.set(false);
            this.f7650th.set(true);
            try {
                this.f7649pf = System.currentTimeMillis();
                if (!de.qw.ad(this.ppp, this.f7651uk)) {
                    uk();
                    return this;
                }
                ppp();
                uk();
            } catch (Exception e) {
                fe.mmm.qw.i.qw.th("BaseJob", "error ", e);
                if (fe.mmm.qw.i.qw.o()) {
                    throw e;
                }
            } catch (Throwable th2) {
                uk();
                throw th2;
            }
        } else {
            fe.mmm.qw.i.qw.rg("BaseJob", m959switch() + " >>>>> " + getName() + " >>>>>has cancel ed ");
        }
        return this;
    }

    /* renamed from: switch  reason: not valid java name */
    public Object m959switch() {
        return this.f7647i;
    }

    /* renamed from: th */
    public int compareTo(@NonNull Job job) {
        fe.mmm.qw.i.qw.uk("PriorityScheduler compareTo", "PriorityScheduler compareTo");
        return job.getPriority() - getPriority();
    }

    public String toString() {
        String str = this.f7651uk;
        if (str != null) {
            return str;
        }
        return super.toString();
    }

    public final void uk() {
        this.f7650th.set(false);
        this.f7652yj.set(true);
        this.f323if = System.currentTimeMillis();
        ggg();
        long pf2 = pf();
        if (pf2 > 20000) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("job_name", getName());
                jSONObject.put("job_cost", pf2);
                ad.qw.de("base_job_c", jSONObject);
            } catch (JSONException e) {
                fe.mmm.qw.i.qw.de("BaseJob", e.getMessage(), e);
            }
        }
    }

    public boolean when() {
        return this.f7646ad.get();
    }

    public void yj(Object obj) {
        this.f7647i = obj;
    }
}
