package com.baidu.searchbox.liveshow.scheme.task;

import com.baidu.bdtask.BDPTask;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.liveshow.scheme.task.LiveSchemeTaskAction;
import com.baidu.searchbox.liveshow.scheme.task.LiveTask;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rJ$\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011J3\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0016\u0010\u0016\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0017\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0018J\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\nH\u0002J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001e\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/liveshow/scheme/task/LiveTaskManager;", "", "()V", "activityTask", "", "Lcom/baidu/searchbox/liveshow/scheme/task/LiveTask;", "clearAllTask", "", "clearTask", "actTaskId", "", "completeTaskByType", "type", "Lcom/baidu/searchbox/liveshow/scheme/task/LiveSchemeTaskAction$TaskType;", "createTask", "actionId", "onCompleteSuccess", "Lkotlin/Function0;", "execute", "taskType", "executorType", "Lcom/baidu/searchbox/liveshow/scheme/task/TaskExecutorType;", "data", "", "(Lcom/baidu/searchbox/liveshow/scheme/task/LiveSchemeTaskAction$TaskType;Lcom/baidu/searchbox/liveshow/scheme/task/TaskExecutorType;[Ljava/lang/Object;)V", "findTask", "findTaskByType", "isTaskExist", "", "startTask", "task", "Companion", "lib-feed-live_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveTaskManager.kt */
public final class LiveTaskManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TASK_BATCH_SUBSCRIPTION = "https://tiebac.baidu.com/bdlive/user/batch_subscription";
    private final List<LiveTask> activityTask = new ArrayList();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/liveshow/scheme/task/LiveTaskManager$Companion;", "", "()V", "TASK_BATCH_SUBSCRIPTION", "", "lib-feed-live_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LiveTaskManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final String startTask(LiveTask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (StringsKt.isBlank(task.getActionId())) {
            if (!AppConfig.isDebug()) {
                return null;
            }
            throw new RuntimeException("Cny任务注册失败，actionId = " + task.getActionId());
        } else if (!isTaskExist(task.getActionId())) {
            return null;
        } else {
            LiveTask cacheTask = findTask(task.getActionId());
            if (Intrinsics.areEqual((Object) cacheTask != null ? cacheTask.getState() : null, (Object) LiveTask.State.Running.INSTANCE)) {
                return task.getActionId();
            }
            TypeIntrinsics.asMutableCollection(this.activityTask).remove(cacheTask);
            BDPTask.INSTANCE.registerTaskListenerWithActionId(task.getActionId(), new LiveTaskManager$startTask$1(task));
            this.activityTask.add(task);
            LiveTask.execute$default(task, Init.INSTANCE, (Object) null, 2, (Object) null);
            task.setState(LiveTask.State.Running.INSTANCE);
            return task.getActionId();
        }
    }

    private final boolean isTaskExist(String actionId) {
        return BDPTask.INSTANCE.findTaskStateByActionId(actionId) != null;
    }

    public final void completeTaskByType(LiveSchemeTaskAction.TaskType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        LiveTask $this$completeTaskByType_u24lambda_u2d0 = findTaskByType(type);
        if ($this$completeTaskByType_u24lambda_u2d0 != null && !Intrinsics.areEqual((Object) $this$completeTaskByType_u24lambda_u2d0.getState(), (Object) LiveTask.State.Complete.INSTANCE)) {
            $this$completeTaskByType_u24lambda_u2d0.setState(LiveTask.State.Complete.INSTANCE);
            BDPTask.INSTANCE.addActionWithActionId($this$completeTaskByType_u24lambda_u2d0.getActionId());
        }
    }

    public final void clearAllTask() {
        String $this$clearAllTask_u24lambda_u2d2_u24lambda_u2d1;
        for (LiveTask task : this.activityTask) {
            TaskInfo taskInfo = task.getTaskInfo();
            if (!(taskInfo == null || ($this$clearAllTask_u24lambda_u2d2_u24lambda_u2d1 = taskInfo.getActTaskId()) == null)) {
                clearTask($this$clearAllTask_u24lambda_u2d2_u24lambda_u2d1);
            }
        }
        this.activityTask.clear();
    }

    public final void execute(LiveSchemeTaskAction.TaskType taskType, TaskExecutorType executorType, Object... data) {
        Intrinsics.checkNotNullParameter(taskType, StatConstants.KEY_EXT_TASK_TYPE);
        Intrinsics.checkNotNullParameter(executorType, "executorType");
        Intrinsics.checkNotNullParameter(data, "data");
        LiveTask task = findTaskByType(taskType);
        if (task != null && Intrinsics.areEqual((Object) task.getState(), (Object) LiveTask.State.Running.INSTANCE)) {
            task.execute(executorType, data);
        }
    }

    public final void clearTask(String actTaskId) {
        Intrinsics.checkNotNullParameter(actTaskId, "actTaskId");
        BDPTask.INSTANCE.clearTaskByActTaskId(actTaskId);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.baidu.searchbox.liveshow.scheme.task.LiveTask} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.baidu.searchbox.liveshow.scheme.task.LiveTask} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.baidu.searchbox.liveshow.scheme.task.LiveTask} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.baidu.searchbox.liveshow.scheme.task.LiveTask} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.baidu.searchbox.liveshow.scheme.task.LiveTask findTask(java.lang.String r7) {
        /*
            r6 = this;
            r0 = r7
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x000e
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 == 0) goto L_0x000c
            goto L_0x000e
        L_0x000c:
            r0 = 0
            goto L_0x000f
        L_0x000e:
            r0 = 1
        L_0x000f:
            r1 = 0
            if (r0 == 0) goto L_0x0013
            return r1
        L_0x0013:
            java.util.List<com.baidu.searchbox.liveshow.scheme.task.LiveTask> r0 = r6.activityTask
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x001b:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0034
            java.lang.Object r2 = r0.next()
            r3 = r2
            com.baidu.searchbox.liveshow.scheme.task.LiveTask r3 = (com.baidu.searchbox.liveshow.scheme.task.LiveTask) r3
            r4 = 0
            java.lang.String r5 = r3.getActionId()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r7)
            if (r3 == 0) goto L_0x001b
            r1 = r2
        L_0x0034:
            com.baidu.searchbox.liveshow.scheme.task.LiveTask r1 = (com.baidu.searchbox.liveshow.scheme.task.LiveTask) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.liveshow.scheme.task.LiveTaskManager.findTask(java.lang.String):com.baidu.searchbox.liveshow.scheme.task.LiveTask");
    }

    private final LiveTask findTaskByType(LiveSchemeTaskAction.TaskType type) {
        Object obj;
        Iterator it = this.activityTask.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((LiveTask) obj).getType(), (Object) type)) {
                break;
            }
        }
        return (LiveTask) obj;
    }

    public final LiveTask createTask(LiveSchemeTaskAction.TaskType type, String actionId, Function0<Unit> onCompleteSuccess) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(actionId, "actionId");
        Intrinsics.checkNotNullParameter(onCompleteSuccess, "onCompleteSuccess");
        LiveTask cnyTask = new LiveTask(type, actionId);
        cnyTask.addExecutor(Complete.INSTANCE, new CompleteExecutor(this, onCompleteSuccess));
        return cnyTask;
    }
}
