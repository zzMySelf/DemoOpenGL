package com.baidu.searchbox.sniffer;

import android.os.Handler;
import com.baidu.searchbox.sniffer.panel.manager.SnifferFileInfoCompactManager;
import com.baidu.searchbox.sniffer.utils.SnifferNetDiskRequestUtilsKt;
import com.baidu.searchbox.sniffer.utils.SnifferSaveNetUtilsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/searchbox/sniffer/PollingHandlerThread$onLooperPrepared$runnable$1", "Ljava/lang/Runnable;", "run", "", "lib-sniffer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PollingHandlerThread.kt */
public final class PollingHandlerThread$onLooperPrepared$runnable$1 implements Runnable {
    final /* synthetic */ Handler $workHandler;

    PollingHandlerThread$onLooperPrepared$runnable$1(Handler $workHandler2) {
        this.$workHandler = $workHandler2;
    }

    public void run() {
        ArrayList snifferSourceInfoList = new ArrayList();
        List<SnifferSourceInfo> $this$forEach$iv = SnifferFileInfoCompactManager.INSTANCE.getSnifferSourceInfoList();
        if ($this$forEach$iv != null) {
            for (SnifferSourceInfo it : $this$forEach$iv) {
                if (PollingStateManager.INSTANCE.getPollingTaskMap().containsKey(it.getSourceUrl())) {
                    snifferSourceInfoList.add(it);
                }
            }
        }
        if (snifferSourceInfoList.size() == 0) {
            PollingStateManager.INSTANCE.quitPolling();
        } else {
            SnifferSaveNetUtilsKt.queryNetDiskStatus(snifferSourceInfoList, SnifferNetDiskRequestUtilsKt.QUERY_TASK_FROM_POLLING, new PollingHandlerThread$onLooperPrepared$runnable$1$run$2(this.$workHandler, this));
        }
    }
}
