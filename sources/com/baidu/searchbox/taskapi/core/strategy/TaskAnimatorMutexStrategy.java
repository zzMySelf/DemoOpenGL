package com.baidu.searchbox.taskapi.core.strategy;

import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.taskapi.core.util.TaskDebugUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0007J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0007J\u0012\u0010\u000e\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u0005H\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/taskapi/core/strategy/TaskAnimatorMutexStrategy;", "", "()V", "animatorCallBackList", "", "Lcom/baidu/searchbox/taskapi/core/strategy/ITaskAnimatorCallback;", "animatorTimeOut", "", "checkRunnable", "Ljava/lang/Runnable;", "endAnimator", "", "animatorCallback", "removeAnimator", "startAnimator", "lib_bdptask_operation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TaskAnimatorMutexStrategy.kt */
public final class TaskAnimatorMutexStrategy {
    public static final TaskAnimatorMutexStrategy INSTANCE = new TaskAnimatorMutexStrategy();
    private static final List<ITaskAnimatorCallback> animatorCallBackList = new ArrayList();
    private static final long animatorTimeOut = 8000;
    private static final Runnable checkRunnable = new TaskAnimatorMutexStrategy$$ExternalSyntheticLambda0();

    private TaskAnimatorMutexStrategy() {
    }

    /* access modifiers changed from: private */
    /* renamed from: checkRunnable$lambda-0  reason: not valid java name */
    public static final void m4284checkRunnable$lambda0() {
        TaskDebugUtil.debugLog("【动画管理】[触发检测] [动画超时] [手动移除]");
        INSTANCE.endAnimator((ITaskAnimatorCallback) null);
    }

    @StableApi
    public final void startAnimator(ITaskAnimatorCallback animatorCallback) {
        Intrinsics.checkNotNullParameter(animatorCallback, "animatorCallback");
        TaskDebugUtil.debugLog("【动画管理】[开始动画] ");
        List<ITaskAnimatorCallback> list = animatorCallBackList;
        if (list.isEmpty()) {
            list.add(animatorCallback);
            TaskDebugUtil.debugLog("【动画管理】[没有其他动画] [直接执行]");
            animatorCallback.onAnimatorReadyStart();
            UiThreadUtils.getMainHandler().postDelayed(checkRunnable, animatorTimeOut);
            return;
        }
        TaskDebugUtil.debugLog("【动画管理】[有其他动画] [添加队列]");
        list.add(animatorCallback);
    }

    @StableApi
    public final void endAnimator(ITaskAnimatorCallback animatorCallback) {
        List<ITaskAnimatorCallback> list = animatorCallBackList;
        if (!(!list.isEmpty()) || Intrinsics.areEqual((Object) list.get(0), (Object) animatorCallback)) {
            TaskDebugUtil.debugLog("【动画管理】[动画结束] ");
            UiThreadUtils.getMainHandler().removeCallbacks(checkRunnable);
            TypeIntrinsics.asMutableCollection(list).remove(animatorCallback);
            if (!list.isEmpty()) {
                TaskDebugUtil.debugLog("【动画管理】[还有其他动画] [取一个]");
                list.remove(0).onAnimatorReadyStart();
                return;
            }
            TaskDebugUtil.debugLog("【动画管理】[没有其他动画] 【end】");
        }
    }

    @StableApi
    public final void removeAnimator(ITaskAnimatorCallback animatorCallback) {
        Intrinsics.checkNotNullParameter(animatorCallback, "animatorCallback");
        TaskDebugUtil.debugLog("【动画管理】[removeAnimator] ");
        animatorCallBackList.remove(animatorCallback);
    }
}
