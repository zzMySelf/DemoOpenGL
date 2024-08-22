package com.baidu.apollon.eventbus;

import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.taskmanager.TaskManager;
import java.util.Objects;

public class a implements Runnable {
    public final e a = new e();
    public final b b;

    public a(b bVar) {
        this.b = bVar;
    }

    public void a(g gVar, EventBus.Event event) {
        this.a.a(d.a(gVar, event));
        TaskManager instance = TaskManager.getInstance("EBTaskManager");
        Objects.requireNonNull(instance);
        instance.addTask(new TaskManager.Task(0, 0, false, "AsyncPost_" + System.currentTimeMillis(), this), "AsyncPost");
    }

    public void run() {
        d a2 = this.a.a();
        if (a2 != null) {
            this.b.a(a2);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
