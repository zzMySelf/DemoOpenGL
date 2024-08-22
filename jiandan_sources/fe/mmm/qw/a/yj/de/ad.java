package fe.mmm.qw.a.yj.de;

import androidx.annotation.NonNull;
import com.tera.scan.scheduler.executor.task.IPriority;
import com.tera.scan.scheduler.executor.task.ITask;
import com.tera.scan.scheduler.executor.task.ITaskModules;
import com.tera.scan.scheduler.executor.task.TaskUpgrade;
import fe.mmm.qw.i.qw;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class ad implements Comparable<ad>, TaskUpgrade, ITask, IPriority, ITaskModules, Callable<ad> {

    /* renamed from: ad  reason: collision with root package name */
    public int f7623ad;

    /* renamed from: i  reason: collision with root package name */
    public boolean f7624i;

    /* renamed from: if  reason: not valid java name */
    public long f321if;

    /* renamed from: o  reason: collision with root package name */
    public volatile long f7625o;

    /* renamed from: pf  reason: collision with root package name */
    public volatile long f7626pf;
    public volatile AtomicBoolean ppp = new AtomicBoolean(false);

    /* renamed from: switch  reason: not valid java name */
    public volatile AtomicBoolean f322switch = new AtomicBoolean(false);

    /* renamed from: th  reason: collision with root package name */
    public int f7627th;

    /* renamed from: uk  reason: collision with root package name */
    public String f7628uk;
    public volatile AtomicBoolean when = new AtomicBoolean(false);

    /* renamed from: yj  reason: collision with root package name */
    public int f7629yj;

    public ad(int i2, int i3, boolean z, String str) {
        this.f7628uk = str;
        this.f7623ad = i2;
        this.f7627th = i2;
        this.f7629yj = i3;
        this.f7624i = z;
    }

    public void ad() {
        this.f322switch.set(true);
    }

    public void de(long j) {
        this.f7625o = j;
    }

    /* renamed from: fe */
    public int compareTo(@NonNull ad adVar) {
        int i2 = this.f7627th;
        int i3 = adVar.f7627th;
        if (i2 != i3) {
            return i2 > i3 ? -1 : 1;
        }
        int i4 = this.f7629yj;
        int i5 = adVar.f7629yj;
        if (i4 == i5) {
            return 0;
        }
        if (i4 > i5) {
            return -1;
        }
        return 1;
    }

    public String getName() {
        return this.f7628uk;
    }

    public int getPriority() {
        return this.f7627th;
    }

    public void ggg(int i2) {
        this.f7623ad = i2;
        this.f7627th = i2;
    }

    public long i() {
        return this.f7626pf - this.f7625o;
    }

    /* renamed from: if  reason: not valid java name */
    public int m956if() {
        return this.f7623ad;
    }

    public long o() {
        return this.f321if - this.f7626pf;
    }

    public long pf() {
        if (this.f7626pf == 0) {
            return 0;
        }
        return System.currentTimeMillis() - this.f7626pf;
    }

    public abstract void ppp();

    public int qw() {
        return this.f7629yj;
    }

    public final void rg() {
        this.when.set(false);
        this.ppp.set(true);
        this.f321if = System.currentTimeMillis();
        ppp();
        long o2 = o();
        if (o2 > 20000) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("task_name", getName());
                jSONObject.put("task_cost", o2);
                fe.mmm.qw.a.ad.qw.de("base_task_c", jSONObject);
            } catch (JSONException e) {
                qw.de("BaseTask", e.getMessage(), e);
            }
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public boolean m957switch() {
        return this.f322switch.get();
    }

    public ad th() {
        if (!m957switch()) {
            this.when.set(true);
            try {
                this.f7626pf = System.currentTimeMillis();
                if (!de.qw.de(this.f7628uk)) {
                    rg();
                    return this;
                }
                when();
                rg();
            } catch (Exception e) {
                qw.th("BaseTask", getName() + " >>>>> error ", e);
            } catch (Throwable th2) {
                rg();
                throw th2;
            }
        } else {
            qw.rg("BaseTask", getName() + " >>>>> has cancel ed");
        }
        return this;
    }

    public long uk() {
        return this.f321if - this.f7625o;
    }

    public boolean vvv(long j) {
        if (!this.f7624i || this.f7627th >= 2 || j - this.f7625o < 20000) {
            return false;
        }
        this.f7627th++;
        return true;
    }

    public abstract void when() throws Exception;
}
