package com.baidu.searchbox.feed.payment.comment;

import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.feed.payment.model.CommentResultEvent;
import com.baidu.searchbox.feed.payment.model.SpColumnCommentItemData;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/baidu/searchbox/feed/payment/comment/FeedCommentInputDialogKt$eventCommentStatusCallback$1", "Lcom/baidu/searchbox/feed/payment/comment/CommentStatusCallback;", "onCommentResult", "", "statusCode", "", "result", "Lcom/baidu/searchbox/feed/payment/model/SpColumnCommentItemData;", "lib-feed-spcolumn_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedCommentInputDialog.kt */
public final class FeedCommentInputDialogKt$eventCommentStatusCallback$1 implements CommentStatusCallback {
    FeedCommentInputDialogKt$eventCommentStatusCallback$1() {
    }

    public void onCommentResult(int statusCode, SpColumnCommentItemData result) {
        if (statusCode == 0) {
            BdEventBus.Companion.getDefault().post(new CommentResultEvent(result));
        }
    }
}
