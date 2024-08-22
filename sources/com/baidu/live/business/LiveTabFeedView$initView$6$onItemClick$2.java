package com.baidu.live.business;

import android.text.TextUtils;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.feedpage.interfaces.ILiveFeedPageInvoke;
import com.baidu.searchbox.live.interfaces.service.AccountManagerService;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/live/business/LiveTabFeedView$initView$6$onItemClick$2", "Lcom/baidu/searchbox/live/interfaces/service/AccountManagerService$LoginResultListener;", "onResult", "", "state", "", "lib-live-feed-page_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveTabFeedView.kt */
public final class LiveTabFeedView$initView$6$onItemClick$2 implements AccountManagerService.LoginResultListener {
    final /* synthetic */ String $cmd;
    final /* synthetic */ LiveTabFeedView this$0;

    LiveTabFeedView$initView$6$onItemClick$2(String $cmd2, LiveTabFeedView $receiver) {
        this.$cmd = $cmd2;
        this.this$0 = $receiver;
    }

    public void onResult(int state) {
        ILiveFeedPageInvoke it;
        if (state == 0 && !TextUtils.isEmpty(this.$cmd) && (it = LiveFeedPageSdk.getInstance().getInvoker()) != null) {
            LiveTabFeedView liveTabFeedView = this.this$0;
            it.invokeScheme(liveTabFeedView.getContext(), this.$cmd);
        }
    }
}
