package com.baidu.bdtask.service.business.inner;

import com.baidu.bdtask.BDPTask;
import com.baidu.bdtask.TaskState;
import com.baidu.bdtask.utils.UniqueId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016¨\u0006\u0011"}, d2 = {"Lcom/baidu/bdtask/service/business/inner/TaskInnerServiceImpl;", "Lcom/baidu/bdtask/service/business/inner/TaskInnerService;", "()V", "cleanTaskNoClickTimes", "", "taskSingleKey", "", "dispatchTaskBusinessEvent", "eventId", "Lcom/baidu/bdtask/utils/UniqueId;", "findTaskBySingleKey", "Lcom/baidu/bdtask/TaskState;", "unregisterTaskWithActionId", "actionId", "unRegisterCode", "", "unRegisterMsg", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 9})
public final class a implements TaskInnerService {
    public void cleanTaskNoClickTimes(String taskSingleKey) {
        Intrinsics.checkParameterIsNotNull(taskSingleKey, "taskSingleKey");
        BDPTask innerInstance$lib_bdtask_business_build_release = BDPTask.INSTANCE.getInnerInstance$lib_bdtask_business_build_release();
        if (innerInstance$lib_bdtask_business_build_release != null) {
            innerInstance$lib_bdtask_business_build_release.cleanTaskNoClickTimes$lib_bdtask_business_build_release(taskSingleKey);
        }
    }

    public void dispatchTaskBusinessEvent(String taskSingleKey, UniqueId eventId) {
        Intrinsics.checkParameterIsNotNull(taskSingleKey, "taskSingleKey");
        Intrinsics.checkParameterIsNotNull(eventId, "eventId");
        BDPTask innerInstance$lib_bdtask_business_build_release = BDPTask.INSTANCE.getInnerInstance$lib_bdtask_business_build_release();
        if (innerInstance$lib_bdtask_business_build_release != null) {
            innerInstance$lib_bdtask_business_build_release.dispatchTaskBusinessEvent$lib_bdtask_business_build_release(taskSingleKey, eventId);
        }
    }

    public void unregisterTaskWithActionId(String actionId, int unRegisterCode, String unRegisterMsg) {
        Intrinsics.checkParameterIsNotNull(actionId, "actionId");
        Intrinsics.checkParameterIsNotNull(unRegisterMsg, "unRegisterMsg");
        BDPTask innerInstance$lib_bdtask_business_build_release = BDPTask.INSTANCE.getInnerInstance$lib_bdtask_business_build_release();
        if (innerInstance$lib_bdtask_business_build_release != null) {
            innerInstance$lib_bdtask_business_build_release.unregisterTaskWithActionId$lib_bdtask_business_build_release(actionId, unRegisterCode, unRegisterMsg);
        }
    }

    public TaskState findTaskBySingleKey(String taskSingleKey) {
        Intrinsics.checkParameterIsNotNull(taskSingleKey, "taskSingleKey");
        BDPTask innerInstance$lib_bdtask_business_build_release = BDPTask.INSTANCE.getInnerInstance$lib_bdtask_business_build_release();
        if (innerInstance$lib_bdtask_business_build_release != null) {
            return innerInstance$lib_bdtask_business_build_release.findTaskBySingleKey$lib_bdtask_business_build_release(taskSingleKey);
        }
        return null;
    }
}
