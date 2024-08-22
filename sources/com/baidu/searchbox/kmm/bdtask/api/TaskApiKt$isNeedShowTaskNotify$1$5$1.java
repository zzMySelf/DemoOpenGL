package com.baidu.searchbox.kmm.bdtask.api;

import com.baidu.searchbox.kmm.bdtask.entity.TaskConstantsKt;
import com.baidu.searchbox.kmm.bdtask.entity.TaskNotifyEntity;
import com.baidu.searchbox.kmm.foundation.utils.KmmLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TaskApi.kt */
final class TaskApiKt$isNeedShowTaskNotify$1$5$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function3<Boolean, Boolean, TaskNotifyEntity, Unit> $completedCallback;
    final /* synthetic */ long $frequencyPopInterval;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TaskApiKt$isNeedShowTaskNotify$1$5$1(long j2, Function3<? super Boolean, ? super Boolean, ? super TaskNotifyEntity, Unit> function3) {
        super(0);
        this.$frequencyPopInterval = j2;
        this.$completedCallback = function3;
    }

    public final void invoke() {
        KmmLog.printLog(TaskConstantsKt.TASK_PRINT_TAG, "last pop time in " + this.$frequencyPopInterval + " ms");
        this.$completedCallback.invoke(true, false, null);
    }
}
