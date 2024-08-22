package com.baidu.apsaras.scheduler.internal;

import android.os.Handler;
import com.baidu.apsaras.scheduler.MigrateRgroupListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/apsaras/scheduler/internal/AdvanceApsarasScheduler$migrateRgroupForPgroup$1", "Lcom/baidu/apsaras/scheduler/MigrateRgroupListener;", "onMigrateFinished", "", "lib-apsaras_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AdvanceApsarasScheduler.kt */
public final class AdvanceApsarasScheduler$migrateRgroupForPgroup$1 implements MigrateRgroupListener {
    final /* synthetic */ Handler $handler;
    final /* synthetic */ MigrateRgroupListener $listener;

    AdvanceApsarasScheduler$migrateRgroupForPgroup$1(Handler $handler2, MigrateRgroupListener $listener2) {
        this.$handler = $handler2;
        this.$listener = $listener2;
    }

    public void onMigrateFinished() {
        this.$handler.post(new AdvanceApsarasScheduler$migrateRgroupForPgroup$1$$ExternalSyntheticLambda0(this.$listener));
    }

    /* access modifiers changed from: private */
    /* renamed from: onMigrateFinished$lambda-0  reason: not valid java name */
    public static final void m12492onMigrateFinished$lambda0(MigrateRgroupListener $listener2) {
        $listener2.onMigrateFinished();
    }
}
