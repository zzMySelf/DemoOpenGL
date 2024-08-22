package com.baidu.searchbox.feed.attention;

import com.baidu.searchbox.feed.attention.utils.AttentionStatHelper;
import com.baidu.searchbox.feed.attention.view.multiauthors.AvatarModel;
import com.baidu.searchbox.feed.attention.view.multiauthors.MultiAuthorsView;
import com.baidu.searchbox.feed.attention.view.multiauthors.OffsetListener;
import com.baidu.searchbox.feed.statistic.FeedStatisticConstants;
import com.baidu.searchbox.kotlinx.ViewExtensionsKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"com/baidu/searchbox/feed/attention/AuthorsFollowedActivity$initView$1", "Lcom/baidu/searchbox/feed/attention/view/multiauthors/OffsetListener;", "onClose", "", "onOffset", "dy", "", "totalOffset", "onReset", "lib-feed-attention_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AuthorsFollowedActivity.kt */
public final class AuthorsFollowedActivity$initView$1 implements OffsetListener {
    final /* synthetic */ AuthorsFollowedActivity this$0;

    AuthorsFollowedActivity$initView$1(AuthorsFollowedActivity $receiver) {
        this.this$0 = $receiver;
    }

    public void onOffset(int dy, int totalOffset) {
        MultiAuthorsView it;
        int height;
        if (totalOffset <= 0 && (it = this.this$0.multiAuthorsView) != null && (height = it.getMeasuredHeight() - dy) != it.getPaddingBottom() && height >= it.getInitHeight()) {
            ViewExtensionsKt.setSize(it, it.getMeasuredWidth(), height);
        }
    }

    public void onClose() {
        AvatarModel $this$onClose_u24lambda_u2d1;
        MultiAuthorsView access$getMultiAuthorsView$p = this.this$0.multiAuthorsView;
        if (!(access$getMultiAuthorsView$p == null || ($this$onClose_u24lambda_u2d1 = access$getMultiAuthorsView$p.getCurrentAuthorModel()) == null)) {
            AuthorsFollowedActivity authorsFollowedActivity = this.this$0;
            AttentionStatHelper.INSTANCE.ubcClick("list", FeedStatisticConstants.DOWN_CLOSE, $this$onClose_u24lambda_u2d1.getUid(), $this$onClose_u24lambda_u2d1.isNewTipValue());
            authorsFollowedActivity.ubcFollowClose("swipe", $this$onClose_u24lambda_u2d1.getMthid());
        }
        this.this$0.closeWithAnim();
    }

    public void onReset() {
        this.this$0.resetMultiViewHeight();
    }
}
