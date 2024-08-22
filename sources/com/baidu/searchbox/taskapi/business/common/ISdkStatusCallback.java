package com.baidu.searchbox.taskapi.business.common;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0017\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\u0003H&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0003H&J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0014\u001a\u00020\u0003H&¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/taskapi/business/common/ISdkStatusCallback;", "", "onAllTaskIsFinish", "", "taskSdkData", "Lcom/baidu/searchbox/taskapi/business/common/TaskSdkData;", "onOnceTaskIsFinish", "onProcessChange", "process", "", "(Ljava/lang/Float;)V", "onTaskDuplicated", "onTaskError", "errorCode", "", "errorMsg", "", "onTaskInterrupted", "onTaskRegister", "onTaskRunning", "onTaskStarted", "lib_bdptask_operation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ISdkStatusCallback.kt */
public interface ISdkStatusCallback {
    void onAllTaskIsFinish(TaskSdkData taskSdkData);

    void onOnceTaskIsFinish(TaskSdkData taskSdkData);

    void onProcessChange(Float f2);

    void onTaskDuplicated();

    void onTaskError(int i2, String str);

    void onTaskInterrupted();

    void onTaskRegister(TaskSdkData taskSdkData);

    void onTaskRunning(TaskSdkData taskSdkData);

    void onTaskStarted();
}
