package com.baidu.searchbox.rewardsystem.status;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/rewardsystem/status/NotActiveStatusChangeStrategy;", "Lcom/baidu/searchbox/rewardsystem/status/BaseStatusChangeStrategy;", "()V", "getCurStatus", "", "transition", "curStatus", "newStatus", "lib_bdptask_operation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NotActiveStatusChangeStrategy.kt */
public final class NotActiveStatusChangeStrategy extends BaseStatusChangeStrategy {
    public int getCurStatus() {
        return 6;
    }

    public int transition(int curStatus, int newStatus) {
        if (curStatus != getCurStatus()) {
            return curStatus;
        }
        return newStatus;
    }
}
