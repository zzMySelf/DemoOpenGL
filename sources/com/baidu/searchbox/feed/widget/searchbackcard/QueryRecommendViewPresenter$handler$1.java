package com.baidu.searchbox.feed.widget.searchbackcard;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/feed/widget/searchbackcard/QueryRecommendViewPresenter$handler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: QueryRecommendViewPresenter.kt */
public final class QueryRecommendViewPresenter$handler$1 extends Handler {
    final /* synthetic */ QueryRecommendViewPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QueryRecommendViewPresenter$handler$1(QueryRecommendViewPresenter $receiver, Looper $super_call_param$1) {
        super($super_call_param$1);
        this.this$0 = $receiver;
    }

    public void handleMessage(Message msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        switch (msg.what) {
            case 0:
                this.this$0.startEnterTransition();
                return;
            case 1:
                this.this$0.hideView(false);
                return;
            default:
                return;
        }
    }
}
