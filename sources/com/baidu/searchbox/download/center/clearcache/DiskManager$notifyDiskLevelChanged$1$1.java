package com.baidu.searchbox.download.center.clearcache;

import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/searchbox/download/center/clearcache/DiskManager$notifyDiskLevelChanged$1$1", "Lcom/baidu/searchbox/download/center/clearcache/NotifyCompletionBack;", "notifyCompletion", "", "lib-clearcache-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DiskManager.kt */
public final class DiskManager$notifyDiskLevelChanged$1$1 implements NotifyCompletionBack {
    final /* synthetic */ CountDownLatch $countDownLatch;

    DiskManager$notifyDiskLevelChanged$1$1(CountDownLatch $countDownLatch2) {
        this.$countDownLatch = $countDownLatch2;
    }

    public void notifyCompletion() {
        this.$countDownLatch.countDown();
    }
}
