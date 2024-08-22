package com.baidu.live.feedfollow;

import com.baidu.live.business.model.LiveFeedModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/live/business/model/LiveFeedModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveFeedFollowContainer.kt */
final class LiveFeedFollowContainer$feedModel$2 extends Lambda implements Function0<LiveFeedModel> {
    final /* synthetic */ LiveFeedFollowContainer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LiveFeedFollowContainer$feedModel$2(LiveFeedFollowContainer liveFeedFollowContainer) {
        super(0);
        this.this$0 = liveFeedFollowContainer;
    }

    public final LiveFeedModel invoke() {
        return new LiveFeedModel(this.this$0.getPage(), this.this$0.getSource());
    }
}
