package com.tera.scan.main.service;

import android.content.Context;
import android.content.Intent;
import com.tera.scan.framework.kernel.service.ISchedulerService;
import fe.mmm.qw.a.yj.de.fe;
import fe.mmm.qw.a.yj.qw.de;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u0003J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u0003R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/tera/scan/main/service/ServiceManager;", "", "scheduler", "Lcom/tera/scan/scheduler/executor/job/PriorityScheduler;", "taskScheduler", "Lcom/tera/scan/scheduler/executor/task/TaskScheduler;", "context", "Landroid/content/Context;", "(Lcom/tera/scan/scheduler/executor/job/PriorityScheduler;Lcom/tera/scan/scheduler/executor/task/TaskScheduler;Landroid/content/Context;)V", "mActiveService", "Lcom/tera/scan/framework/kernel/service/ISchedulerService;", "getMActiveService", "()Lcom/tera/scan/framework/kernel/service/ISchedulerService;", "mActiveService$delegate", "Lkotlin/Lazy;", "getSchedulerService", "intent", "Landroid/content/Intent;", "initSpeedScheduler", "", "initWithIndependenceScheduler", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ServiceManager {
    @NotNull
    public final Lazy qw;

    public ServiceManager(@Nullable de deVar, @Nullable fe feVar, @Nullable Context context) {
        this.qw = LazyKt__LazyJVMKt.lazy(new ServiceManager$mActiveService$2(deVar));
    }

    @Nullable
    public final ISchedulerService ad(@Nullable Intent intent) {
        int i2 = -1;
        if (intent != null) {
            i2 = intent.getIntExtra("com.mars.EXTRA_SERVICE_TYPE", -1);
        }
        if (i2 == 19) {
            return qw();
        }
        return null;
    }

    public final void de(@NotNull de deVar) {
        Intrinsics.checkNotNullParameter(deVar, "scheduler");
    }

    public final void fe(@NotNull de deVar) {
        Intrinsics.checkNotNullParameter(deVar, "scheduler");
    }

    public final ISchedulerService qw() {
        return (ISchedulerService) this.qw.getValue();
    }
}
