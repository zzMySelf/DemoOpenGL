package com.baidu.searchbox.video.feedflow.flow.authorworks.bottom;

import android.view.View;
import com.baidu.searchbox.follow.button.BdFollowButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/video/feedflow/flow/authorworks/bottom/AuthorWorksBottomContainer$bindFollowData$1", "Lcom/baidu/searchbox/follow/button/BdFollowButton$FollowButtonClickCallback;", "onClick", "", "view", "Landroid/view/View;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AuthorWorksBottomContainer.kt */
public final class AuthorWorksBottomContainer$bindFollowData$1 implements BdFollowButton.FollowButtonClickCallback {
    final /* synthetic */ AuthorWorksBottomContainer this$0;

    AuthorWorksBottomContainer$bindFollowData$1(AuthorWorksBottomContainer $receiver) {
        this.this$0 = $receiver;
    }

    public void onClick(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        IAuthorWorkBottomListener listener = this.this$0.getListener();
        if (listener != null) {
            listener.onFollowBtnClick(this.this$0.getAuthorModel());
        }
    }
}
