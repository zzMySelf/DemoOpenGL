package com.baidu.searchbox.video.feedflow.flow.taskreport;

import com.baidu.pyramid.annotation.component.ListHolder;
import com.baidu.searchbox.video.feedflow.flow.taskreport.core.ITaskReportActionListener;
import com.baidu.searchbox.video.feedflow.flow.taskreport.core.TaskReportActionRuntime;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/taskreport/TaskReportActionManager;", "", "()V", "taskReportActionRuntime", "Lcom/baidu/searchbox/video/feedflow/flow/taskreport/core/TaskReportActionRuntime;", "getTaskReportActionRuntime", "()Lcom/baidu/searchbox/video/feedflow/flow/taskreport/core/TaskReportActionRuntime;", "taskReportActionRuntime$delegate", "Lkotlin/Lazy;", "findActionByName", "Lcom/baidu/searchbox/video/feedflow/flow/taskreport/core/ITaskReportActionListener;", "name", "", "init", "", "release", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TaskReportActionManager.kt */
public final class TaskReportActionManager {
    public static final TaskReportActionManager INSTANCE = new TaskReportActionManager();
    private static final Lazy taskReportActionRuntime$delegate = LazyKt.lazy(TaskReportActionManager$taskReportActionRuntime$2.INSTANCE);

    private TaskReportActionManager() {
    }

    private final TaskReportActionRuntime getTaskReportActionRuntime() {
        return (TaskReportActionRuntime) taskReportActionRuntime$delegate.getValue();
    }

    public final void init() {
        List<ITaskReportActionListener> $this$forEach$iv;
        ListHolder<ITaskReportActionListener> listenerList = getTaskReportActionRuntime().getListenerList();
        if (listenerList != null && ($this$forEach$iv = listenerList.getList()) != null) {
            for (ITaskReportActionListener it : $this$forEach$iv) {
                it.onInit();
            }
        }
    }

    public final void release() {
        List<ITaskReportActionListener> $this$forEach$iv;
        ListHolder<ITaskReportActionListener> listenerList = getTaskReportActionRuntime().getListenerList();
        if (listenerList != null && ($this$forEach$iv = listenerList.getList()) != null) {
            for (ITaskReportActionListener it : $this$forEach$iv) {
                it.onDestroy();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.baidu.searchbox.video.feedflow.flow.taskreport.core.ITaskReportActionListener} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.baidu.searchbox.video.feedflow.flow.taskreport.core.ITaskReportActionListener} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: com.baidu.searchbox.video.feedflow.flow.taskreport.core.ITaskReportActionListener} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.baidu.searchbox.video.feedflow.flow.taskreport.core.ITaskReportActionListener} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.baidu.searchbox.video.feedflow.flow.taskreport.core.ITaskReportActionListener findActionByName(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            com.baidu.searchbox.video.feedflow.flow.taskreport.core.TaskReportActionRuntime r0 = r8.getTaskReportActionRuntime()
            com.baidu.pyramid.annotation.component.ListHolder r0 = r0.getListenerList()
            r1 = 0
            if (r0 == 0) goto L_0x003a
            java.util.List r0 = r0.getList()
            if (r0 == 0) goto L_0x003a
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r2 = 0
            java.util.Iterator r3 = r0.iterator()
        L_0x001d:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0037
            java.lang.Object r4 = r3.next()
            r5 = r4
            com.baidu.searchbox.video.feedflow.flow.taskreport.core.ITaskReportActionListener r5 = (com.baidu.searchbox.video.feedflow.flow.taskreport.core.ITaskReportActionListener) r5
            r6 = 0
            java.lang.String r7 = r5.getTaskName()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r9)
            if (r5 == 0) goto L_0x001d
            r1 = r4
            goto L_0x0038
        L_0x0037:
        L_0x0038:
            com.baidu.searchbox.video.feedflow.flow.taskreport.core.ITaskReportActionListener r1 = (com.baidu.searchbox.video.feedflow.flow.taskreport.core.ITaskReportActionListener) r1
        L_0x003a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.taskreport.TaskReportActionManager.findActionByName(java.lang.String):com.baidu.searchbox.video.feedflow.flow.taskreport.core.ITaskReportActionListener");
    }
}
