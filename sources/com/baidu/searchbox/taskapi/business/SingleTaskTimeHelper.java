package com.baidu.searchbox.taskapi.business;

import android.text.TextUtils;
import com.baidu.bdtask.BDPTask;
import com.baidu.searchbox.taskapi.core.config.TaskConfig;
import com.baidu.searchbox.taskapi.core.util.TaskDebugUtil;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0016\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0006J \u0010\u0011\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001a\u00020\u0005R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/taskapi/business/SingleTaskTimeHelper;", "", "()V", "taskDurationMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "clearMap", "", "isSingleTaskTimer", "", "mConfig", "Lcom/baidu/searchbox/taskapi/core/config/TaskConfig;", "recordSingleTaskDuration", "duplicatedId", "curProcess", "setTimerDuration", "tag", "lib_bdptask_operation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SingleTaskTimeHelper.kt */
public final class SingleTaskTimeHelper {
    public static final SingleTaskTimeHelper INSTANCE = new SingleTaskTimeHelper();
    private static final HashMap<String, Long> taskDurationMap = new HashMap<>();

    private SingleTaskTimeHelper() {
    }

    public final void recordSingleTaskDuration(String duplicatedId, long curProcess) {
        Intrinsics.checkNotNullParameter(duplicatedId, "duplicatedId");
        if (!TextUtils.isEmpty(duplicatedId)) {
            taskDurationMap.put(duplicatedId, Long.valueOf(curProcess));
            TaskDebugUtil.debugLog("【recordSingleTaskDuration】duplicatedId:" + duplicatedId + ", curProcess:" + curProcess);
        }
    }

    public final void setTimerDuration(String duplicatedId, TaskConfig mConfig, String tag) {
        Intrinsics.checkNotNullParameter(duplicatedId, "duplicatedId");
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (!TextUtils.isEmpty(duplicatedId)) {
            HashMap<String, Long> hashMap = taskDurationMap;
            Long taskDuration = hashMap.containsKey(duplicatedId) ? hashMap.get(duplicatedId) : 0L;
            if (taskDuration != null && mConfig != null && mConfig.getPageType() != null) {
                BDPTask.INSTANCE instance = BDPTask.INSTANCE;
                String actionId = mConfig.getActionId();
                Intrinsics.checkNotNullExpressionValue(actionId, "mConfig.actionId");
                instance.setDurationWithActionId(actionId, taskDuration.longValue(), duplicatedId, tag);
                TaskDebugUtil.debugLog("【setTimerDuration】duplicatedId:" + duplicatedId + ", taskDuration:" + taskDuration);
            }
        }
    }

    public final void clearMap() {
        taskDurationMap.clear();
    }

    public final boolean isSingleTaskTimer(TaskConfig mConfig) {
        TaskConfig.IIsSingleTaskTimerListener it;
        if (mConfig == null || (it = mConfig.getIsSingleTaskTimerListener()) == null) {
            return false;
        }
        Boolean isSingleTaskTimer = it.isSingleTaskTimer();
        Intrinsics.checkNotNullExpressionValue(isSingleTaskTimer, "it.isSingleTaskTimer");
        return isSingleTaskTimer.booleanValue();
    }
}
