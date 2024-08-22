package com.baidu.searchbox.favor;

import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.favor.callback.SyncCallback;
import com.baidu.searchbox.userassetsaggr.container.data.FavorSyncEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u001c\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\n\u001a\u00060\u000bj\u0002`\fH\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"com/baidu/searchbox/favor/FavorBottomBar$doSync$1", "Lcom/baidu/searchbox/favor/callback/SyncCallback;", "onError", "", "type", "", "erroCode", "", "errMsg", "onException", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onFinish", "isComplete", "", "lib-favor_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FavorBottomBar.kt */
public final class FavorBottomBar$doSync$1 extends SyncCallback {
    final /* synthetic */ FavorBottomBar this$0;

    FavorBottomBar$doSync$1(FavorBottomBar $receiver) {
        this.this$0 = $receiver;
    }

    public void onFinish(String type, boolean isComplete) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (isComplete) {
            this.this$0.updateSyncState(0);
            BdEventBus.Companion.getDefault().post(new FavorSyncEvent());
        }
    }

    public void onException(String type, Exception exception) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(exception, "exception");
        this.this$0.updateSyncState(0);
    }

    public void onError(String type, int erroCode, String errMsg) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        this.this$0.updateSyncState(0);
    }
}
