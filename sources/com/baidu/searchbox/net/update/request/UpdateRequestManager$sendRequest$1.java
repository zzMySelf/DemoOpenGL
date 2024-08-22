package com.baidu.searchbox.net.update.request;

import com.baidu.searchbox.launched.LaunchedTaskSpeedStats;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: UpdateRequestManager.kt */
final class UpdateRequestManager$sendRequest$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ boolean $backgroundToForeground;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UpdateRequestManager$sendRequest$1(boolean z) {
        super(0);
        this.$backgroundToForeground = z;
    }

    public final void invoke() {
        LaunchedTaskSpeedStats stats = LaunchedTaskSpeedStats.getInstance();
        stats.beginSpeedNode("UpdateRequester", LaunchedTaskSpeedStats.STAGE_ASYNC_DELAY_TASK);
        UpdateRequestManager updateRequestManager = UpdateRequestManager.INSTANCE;
        UpdateRequestManager.mCurrentUpdateRequestTask = new UpdateRequestTask(this.$backgroundToForeground);
        UpdateRequestTask access$getMCurrentUpdateRequestTask$p = UpdateRequestManager.mCurrentUpdateRequestTask;
        if (access$getMCurrentUpdateRequestTask$p != null) {
            access$getMCurrentUpdateRequestTask$p.request(false);
        }
        stats.endSpeedNode("UpdateRequester", LaunchedTaskSpeedStats.STAGE_ASYNC_DELAY_TASK);
    }
}
