package fe.i.qw.ad;

import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.taskmanager.TaskManager;

public class qw implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final rg f4472ad = new rg();

    /* renamed from: th  reason: collision with root package name */
    public final ad f4473th;

    public qw(ad adVar) {
        this.f4473th = adVar;
    }

    public void qw(yj yjVar, EventBus.Event event) {
        this.f4472ad.ad(fe.qw(yjVar, event));
        TaskManager instance = TaskManager.getInstance("EBTaskManager");
        instance.getClass();
        instance.addTask(new TaskManager.Task(instance, 0, 0, false, "DxmAsyncPost_" + System.currentTimeMillis(), this), "AsyncPost");
    }

    public void run() {
        fe qw = this.f4472ad.qw();
        if (qw != null) {
            this.f4473th.fe(qw);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
