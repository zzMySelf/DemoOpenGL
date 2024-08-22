package com.baidu.searchbox.feed.payment.comment;

import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.feed.payment.model.CommentResultEvent;
import com.baidu.searchbox.feed.payment.model.SpColumnCommentItemData;
import com.baidu.searchbox.feed.payment.widget.ContentState;
import com.baidu.searchbox.feed.payment.widget.StateLayer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/feed/payment/comment/SpColumnCommentPage$onCreateView$2", "Lcom/baidu/searchbox/bdeventbus/Action;", "Lcom/baidu/searchbox/feed/payment/model/CommentResultEvent;", "call", "", "type", "lib-feed-spcolumn_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpColumnCommentPage.kt */
public final class SpColumnCommentPage$onCreateView$2 implements Action<CommentResultEvent> {
    final /* synthetic */ SpColumnCommentPage this$0;

    SpColumnCommentPage$onCreateView$2(SpColumnCommentPage $receiver) {
        this.this$0 = $receiver;
    }

    public void call(CommentResultEvent type) {
        SpColumnCommentItemData it;
        Intrinsics.checkNotNullParameter(type, "type");
        if (!this.this$0.isHistoryPage() && (it = type.getCommentData()) != null) {
            SpColumnCommentPage spColumnCommentPage = this.this$0;
            StateLayer access$getStateLayer$p = spColumnCommentPage.stateLayer;
            if (access$getStateLayer$p != null) {
                access$getStateLayer$p.turnStateTo(ContentState.INSTANCE);
            }
            CharSequence charSequence = it.alertTips;
            if (!(charSequence == null || charSequence.length() == 0)) {
                spColumnCommentPage.handleRefuseComment(it);
            }
            spColumnCommentPage.insertData(it, 0);
            spColumnCommentPage.insertItem = it;
            if (Intrinsics.areEqual((Object) it.replyId, (Object) "special")) {
                spColumnCommentPage.isFirstComment = true;
            }
        }
    }
}
