package com.baidu.bdtask.ctrl;

import com.baidu.bdtask.model.info.TaskInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/baidu/bdtask/model/info/TaskInfo;", "invoke"}, k = 3, mv = {1, 1, 9})
final class BDPTaskState$getCurActiveTaskState$1 extends Lambda implements Function1<TaskInfo, Boolean> {
    public static final BDPTaskState$getCurActiveTaskState$1 INSTANCE = new BDPTaskState$getCurActiveTaskState$1();

    BDPTaskState$getCurActiveTaskState$1() {
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((TaskInfo) obj));
    }

    public final boolean invoke(TaskInfo it) {
        Intrinsics.checkParameterIsNotNull(it, "it");
        return true;
    }
}
