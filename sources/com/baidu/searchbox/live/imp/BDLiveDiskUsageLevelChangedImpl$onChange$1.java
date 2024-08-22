package com.baidu.searchbox.live.imp;

import android.util.Log;
import com.baidu.searchbox.download.center.clearcache.NotifyCompletionBack;
import com.baidu.searchbox.live.interfaces.callback.ILiveDiskClearCacheCallback;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/live/imp/BDLiveDiskUsageLevelChangedImpl$onChange$1", "Lcom/baidu/searchbox/live/interfaces/callback/ILiveDiskClearCacheCallback;", "notifyCompletion", "", "currentSize", "", "lib-feed-live_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BDLiveDiskUsageLevelChangedImpl.kt */
public final class BDLiveDiskUsageLevelChangedImpl$onChange$1 implements ILiveDiskClearCacheCallback {
    final /* synthetic */ NotifyCompletionBack $callback;

    BDLiveDiskUsageLevelChangedImpl$onChange$1(NotifyCompletionBack $callback2) {
        this.$callback = $callback2;
    }

    public void notifyCompletion(long currentSize) {
        Log.e("onDiskClearCacheChange", "BDLiveDiskUsageLevelChangedImpl callback");
        this.$callback.notifyCompletion();
    }
}
