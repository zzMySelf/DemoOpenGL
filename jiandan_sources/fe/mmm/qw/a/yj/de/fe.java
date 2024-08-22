package fe.mmm.qw.a.yj.de;

import android.os.SystemClock;
import com.tera.scan.scheduler.executor.task.FifoPriorityThreadPoolExecutor;
import fe.mmm.qw.a.ad;
import fe.mmm.qw.a.yj.qw.de;
import fe.mmm.qw.i.qw;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class fe {

    /* renamed from: ad  reason: collision with root package name */
    public volatile int f7634ad;

    /* renamed from: de  reason: collision with root package name */
    public long f7635de;

    /* renamed from: fe  reason: collision with root package name */
    public String f7636fe;
    public volatile int qw;

    /* renamed from: rg  reason: collision with root package name */
    public volatile boolean f7637rg;

    /* renamed from: th  reason: collision with root package name */
    public FifoPriorityThreadPoolExecutor f7638th;

    public fe(String str) {
        this(8, str);
    }

    public void ad() {
        if (this.f7637rg) {
            throw new IllegalStateException("Can NOT restart after scheduler stopped");
        }
    }

    public void de() {
        this.f7637rg = true;
        this.f7638th.shutdown();
    }

    public Future<?> fe(ad adVar) {
        if (adVar == null) {
            return null;
        }
        adVar.de(System.currentTimeMillis());
        FifoPriorityThreadPoolExecutor fifoPriorityThreadPoolExecutor = this.f7638th;
        if (fifoPriorityThreadPoolExecutor != null && !fifoPriorityThreadPoolExecutor.isShutdown()) {
            qw();
            return this.f7638th.submit(adVar);
        } else if (!ad.qw.qw()) {
            return null;
        } else {
            FifoPriorityThreadPoolExecutor fifoPriorityThreadPoolExecutor2 = this.f7638th;
            if (fifoPriorityThreadPoolExecutor2 == null || fifoPriorityThreadPoolExecutor2.isShutdown()) {
                synchronized (de.class) {
                    if (this.f7638th == null || this.f7638th.isShutdown()) {
                        this.f7638th = new FifoPriorityThreadPoolExecutor(8);
                        ad.qw.de("ts_shut_down", new JSONObject());
                    }
                }
            }
            return this.f7638th.submit(adVar);
        }
    }

    public final void qw() {
        int size;
        int i2;
        if (ad.qw.ad() && (size = this.f7638th.vvv().size()) >= this.qw) {
            long uptimeMillis = SystemClock.uptimeMillis();
            long availableProcessors = (long) Runtime.getRuntime().availableProcessors();
            long hashCode = (long) this.f7638th.hashCode();
            int i3 = this.f7638th.m920switch();
            int ppp = this.f7638th.ppp();
            int ggg = this.f7638th.ggg();
            long when = this.f7638th.when();
            ConcurrentHashMap<Integer, FifoPriorityThreadPoolExecutor.fe<?>> j = this.f7638th.j();
            Iterator<Map.Entry<Integer, FifoPriorityThreadPoolExecutor.fe<?>>> it = j.entrySet().iterator();
            long j2 = availableProcessors;
            JSONArray jSONArray = new JSONArray();
            long size2 = (long) j.size();
            long j3 = hashCode;
            long j4 = 0;
            long j5 = 0;
            boolean z = false;
            while (true) {
                i2 = size;
                if (!it.hasNext()) {
                    break;
                }
                FifoPriorityThreadPoolExecutor.fe feVar = (FifoPriorityThreadPoolExecutor.fe) it.next().getValue();
                long j6 = when;
                long fe2 = feVar.fe();
                if (j5 == 0) {
                    j5 = fe2;
                } else {
                    j5 = Math.min(fe2, j5);
                }
                long max = Math.max(fe2, j4);
                if (fe2 > ((long) this.f7634ad)) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("task_name", feVar.getName());
                        jSONObject.put("task_run_time", fe2);
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        qw.de("TaskScheduler", e.getMessage(), e);
                    }
                    z = true;
                }
                size = i2;
                when = j6;
                j4 = max;
            }
            long j7 = when;
            long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
            qw.rg("TaskScheduler", "get_task_cost time is :" + uptimeMillis2 + ", has task job :" + z);
            if (z) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("high_cost_task", jSONArray);
                    jSONObject2.put("high_cost_task_count", jSONArray.length());
                    jSONObject2.put("active_thread_count", i3);
                    jSONObject2.put("core_pool_size", ppp);
                    jSONObject2.put("largest_pool_size", ggg);
                    jSONObject2.put("completed_task_count", j7);
                    jSONObject2.put("wait_task_count", i2);
                    jSONObject2.put("threshold", this.qw);
                    jSONObject2.put("execute_time_min", j5);
                    jSONObject2.put("execute_time_max", j4);
                    jSONObject2.put("execute_task_count", size2);
                    jSONObject2.put("execute_hash_code", j3);
                    jSONObject2.put("cpu_count", j2);
                    jSONObject2.put("scheduler_create_time", this.f7635de);
                    jSONObject2.put("scheduler_tag", this.f7636fe);
                    jSONObject2.put("get_task_cost", uptimeMillis2);
                } catch (JSONException e2) {
                    qw.de("TaskScheduler", e2.getMessage(), e2);
                }
                qw.rg("TaskScheduler", "get_high_cost job is :" + jSONObject2.toString());
                ad.qw.de("ts_r_c_s", jSONObject2);
                this.qw = this.qw << 1;
                this.f7634ad = this.f7634ad << 1;
            }
        }
    }

    public fe(int i2, String str) {
        this.qw = 10;
        this.f7634ad = 10000;
        this.f7635de = SystemClock.uptimeMillis();
        this.f7636fe = "TaskScheduler";
        this.f7637rg = false;
        this.f7636fe = str;
        qw.uk("TaskScheduler", "maxThreadPoolSize = " + i2);
        this.f7638th = new FifoPriorityThreadPoolExecutor(i2);
    }
}
