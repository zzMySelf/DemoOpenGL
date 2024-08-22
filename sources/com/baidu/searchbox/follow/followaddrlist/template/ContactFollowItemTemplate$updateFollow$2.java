package com.baidu.searchbox.follow.followaddrlist.template;

import com.baidu.searchbox.follow.button.BdFollowButton;
import com.baidu.searchbox.follow.followaddrlist.template.ITemplate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/baidu/searchbox/follow/followaddrlist/template/ContactFollowItemTemplate$updateFollow$2", "Lcom/baidu/searchbox/follow/button/BdFollowButton$FollowResultCallback;", "followFailed", "", "result", "Lcom/baidu/searchbox/follow/button/BdFollowButton$Result;", "errorCode", "", "followSuccess", "lib-follow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ContactFollowItemTemplate.kt */
public final class ContactFollowItemTemplate$updateFollow$2 implements BdFollowButton.FollowResultCallback {
    final /* synthetic */ ContactFollowItemTemplate this$0;

    ContactFollowItemTemplate$updateFollow$2(ContactFollowItemTemplate $receiver) {
        this.this$0 = $receiver;
    }

    public void followFailed(BdFollowButton.Result result, int errorCode) {
        Intrinsics.checkNotNullParameter(result, "result");
        ITemplate.OnChildListener access$getListener$p = this.this$0.listener;
        if (access$getListener$p != null) {
            access$getListener$p.followFailed(errorCode);
        }
    }

    public void followSuccess(BdFollowButton.Result result) {
        Intrinsics.checkNotNullParameter(result, "result");
        ITemplate.OnChildListener access$getListener$p = this.this$0.listener;
        if (access$getListener$p != null) {
            access$getListener$p.followSuccess(result.isFollowOpt());
        }
    }
}
