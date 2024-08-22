package fe.mmm.qw.a.yj.qw;

import android.os.SystemClock;
import com.tera.scan.scheduler.executor.job.FifoPriorityThreadPoolExecutor;
import com.tera.scan.scheduler.executor.job.Job;
import fe.mmm.qw.a.ad;
import fe.mmm.qw.i.qw;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class de {

    /* renamed from: ad  reason: collision with root package name */
    public volatile int f7642ad;

    /* renamed from: de  reason: collision with root package name */
    public volatile int f7643de;

    /* renamed from: fe  reason: collision with root package name */
    public long f7644fe;
    public FifoPriorityThreadPoolExecutor qw;

    /* renamed from: rg  reason: collision with root package name */
    public String f7645rg;

    public de(String str) {
        this(Runtime.getRuntime().availableProcessors(), str);
    }

    public void ad(Job job) {
        if (job != null) {
            job.yj("low");
            job.qw(new ad(1, true));
            rg(job);
        }
    }

    public final void de() {
        int size;
        int i2;
        long j;
        if (ad.qw.ad() && (size = this.qw.getQueue().size()) >= this.f7642ad) {
            long uptimeMillis = SystemClock.uptimeMillis();
            long hashCode = (long) this.qw.hashCode();
            long availableProcessors = (long) Runtime.getRuntime().availableProcessors();
            int activeCount = this.qw.getActiveCount();
            int corePoolSize = this.qw.getCorePoolSize();
            int largestPoolSize = this.qw.getLargestPoolSize();
            long completedTaskCount = this.qw.getCompletedTaskCount();
            ConcurrentHashMap<Integer, FifoPriorityThreadPoolExecutor.fe<?>> qw2 = this.qw.qw();
            Iterator<Map.Entry<Integer, FifoPriorityThreadPoolExecutor.fe<?>>> it = qw2.entrySet().iterator();
            long j2 = availableProcessors;
            long size2 = (long) qw2.size();
            boolean z = false;
            long j3 = j2;
            JSONArray jSONArray = new JSONArray();
            long j4 = hashCode;
            long j5 = size2;
            long j6 = 0;
            long j7 = 0;
            while (true) {
                i2 = size;
                if (!it.hasNext()) {
                    break;
                }
                FifoPriorityThreadPoolExecutor.fe feVar = (FifoPriorityThreadPoolExecutor.fe) it.next().getValue();
                long j8 = completedTaskCount;
                long fe2 = feVar.fe();
                if (j6 == 0) {
                    j = fe2;
                } else {
                    j = Math.min(fe2, j6);
                }
                j7 = Math.max(fe2, j7);
                long j9 = j;
                if (fe2 > ((long) this.f7643de)) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("task_name", feVar.getName());
                        jSONObject.put("task_run_time", fe2);
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        qw.de("PriorityScheduler", e.getMessage(), e);
                    }
                    z = true;
                }
                size = i2;
                completedTaskCount = j8;
                j6 = j9;
            }
            long j10 = completedTaskCount;
            long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
            qw.rg("PriorityScheduler", "get_job_cost time is :" + uptimeMillis2 + ", has high job :" + z);
            if (z) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("high_cost_task", jSONArray);
                    jSONObject2.put("high_cost_task_count", jSONArray.length());
                    jSONObject2.put("active_thread_count", activeCount);
                    jSONObject2.put("core_pool_size", corePoolSize);
                    jSONObject2.put("largest_pool_size", largestPoolSize);
                    jSONObject2.put("completed_task_count", j10);
                    jSONObject2.put("wait_task_count", i2);
                    jSONObject2.put("threshold", this.f7642ad);
                    jSONObject2.put("execute_time_min", j6);
                    jSONObject2.put("execute_time_max", j7);
                    jSONObject2.put("execute_task_count", j5);
                    jSONObject2.put("execute_hash_code", j4);
                    jSONObject2.put("cpu_count", j3);
                    jSONObject2.put("scheduler_create_time", this.f7644fe);
                    jSONObject2.put("scheduler_tag", this.f7645rg);
                    jSONObject2.put("get_task_cost", uptimeMillis2);
                } catch (JSONException e2) {
                    qw.de("PriorityScheduler", e2.getMessage(), e2);
                }
                qw.rg("PriorityScheduler", "get_high_cost job is :" + jSONObject2.toString());
                ad.qw.de("bj_r_c_s", jSONObject2);
                this.f7642ad = this.f7642ad << 1;
                this.f7643de = this.f7643de << 1;
            }
        }
    }

    public void fe() {
        this.qw.shutdown();
    }

    public void qw(Job job) {
        if (job != null) {
            job.yj("high");
            job.qw(new ad(3, true));
            rg(job);
        }
    }

    public void rg(Job job) {
        if (job != null) {
            job.de(System.currentTimeMillis());
            FifoPriorityThreadPoolExecutor fifoPriorityThreadPoolExecutor = this.qw;
            if (fifoPriorityThreadPoolExecutor != null && !fifoPriorityThreadPoolExecutor.isShutdown()) {
                de();
                this.qw.submit(job);
            } else if (ad.qw.qw()) {
                FifoPriorityThreadPoolExecutor fifoPriorityThreadPoolExecutor2 = this.qw;
                if (fifoPriorityThreadPoolExecutor2 == null || fifoPriorityThreadPoolExecutor2.isShutdown()) {
                    synchronized (de.class) {
                        if (this.qw == null || this.qw.isShutdown()) {
                            this.qw = new FifoPriorityThreadPoolExecutor(Runtime.getRuntime().availableProcessors());
                            ad.qw.de("ps_shut_down", new JSONObject());
                        }
                    }
                }
                this.qw.submit(job);
            }
        }
    }

    public de(int i2, String str) {
        this.f7642ad = 10;
        this.f7643de = 10000;
        this.f7644fe = SystemClock.uptimeMillis();
        this.f7645rg = "PriorityScheduler";
        this.f7645rg = str;
        qw.uk("PriorityScheduler", "lifo availableProcessors = " + i2);
        this.qw = new FifoPriorityThreadPoolExecutor(i2);
    }
}
