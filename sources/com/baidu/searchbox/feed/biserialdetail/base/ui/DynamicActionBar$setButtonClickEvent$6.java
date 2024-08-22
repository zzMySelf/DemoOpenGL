package com.baidu.searchbox.feed.biserialdetail.base.ui;

import com.baidu.searchbox.feed.biserialdetail.base.ui.DynamicActionBar;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.follow.button.BdFollowButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/feed/biserialdetail/base/ui/DynamicActionBar$setButtonClickEvent$6", "Lcom/baidu/searchbox/follow/button/BdFollowButton$FollowStatusUpdateListener;", "onUpdate", "", "result", "Lcom/baidu/searchbox/follow/button/BdFollowButton$Result;", "lib-feed-biserial-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicActionBar.kt */
public final class DynamicActionBar$setButtonClickEvent$6 implements BdFollowButton.FollowStatusUpdateListener {
    final /* synthetic */ FeedItemData.AdditionalInfo $followInfo;
    final /* synthetic */ DynamicActionBar this$0;

    DynamicActionBar$setButtonClickEvent$6(FeedItemData.AdditionalInfo $followInfo2, DynamicActionBar $receiver) {
        this.$followInfo = $followInfo2;
        this.this$0 = $receiver;
    }

    public void onUpdate(BdFollowButton.Result result) {
        DynamicActionBar.OnFollowStatusUpdateListener access$getFollowStatusUpdateListener$p;
        Intrinsics.checkNotNullParameter(result, "result");
        FeedItemData.AdditionalInfo additionalInfo = this.$followInfo;
        if (Intrinsics.areEqual((Object) additionalInfo != null ? additionalInfo.thirdId : null, (Object) result.getThirdId()) && (access$getFollowStatusUpdateListener$p = this.this$0.followStatusUpdateListener) != null) {
            access$getFollowStatusUpdateListener$p.onFollowStatusUpdate(result.isFollowed());
        }
    }
}
