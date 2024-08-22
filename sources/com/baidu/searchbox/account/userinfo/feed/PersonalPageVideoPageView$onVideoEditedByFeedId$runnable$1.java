package com.baidu.searchbox.account.userinfo.feed;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/searchbox/account/userinfo/feed/PersonalPageVideoPageView$onVideoEditedByFeedId$runnable$1", "Ljava/lang/Runnable;", "run", "", "lib-userinfo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalPageVideoPageView.kt */
public final class PersonalPageVideoPageView$onVideoEditedByFeedId$runnable$1 implements Runnable {
    final /* synthetic */ String $feedId;
    final /* synthetic */ PersonalPageVideoPageView this$0;

    PersonalPageVideoPageView$onVideoEditedByFeedId$runnable$1(PersonalPageVideoPageView $receiver, String $feedId2) {
        this.this$0 = $receiver;
        this.$feedId = $feedId2;
    }

    public void run() {
        this.this$0.refreshVideoByFeedId(this.$feedId);
        this.this$0.refreshVideoRunnables.remove(this);
    }
}
