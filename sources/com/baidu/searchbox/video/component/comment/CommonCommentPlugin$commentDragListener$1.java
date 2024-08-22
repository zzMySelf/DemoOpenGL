package com.baidu.searchbox.video.component.comment;

import com.baidu.android.ext.widget.C0297BdPopupWindow;
import com.baidu.searchbox.comment.definition.ICommentListPopup;
import com.baidu.searchbox.video.component.comment.service.CommentDragListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016¨\u0006\u000f"}, d2 = {"com/baidu/searchbox/video/component/comment/CommonCommentPlugin$commentDragListener$1", "Lcom/baidu/searchbox/comment/definition/ICommentListPopup$SimpleCommentListPopupPullListener;", "onDrag", "", "left", "", "top", "dx", "dy", "onPullCancelled", "onPullCompleted", "onPullProgressChanged", "progress", "", "onPullStarted", "lib-video-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommonCommentPlugin.kt */
public final class CommonCommentPlugin$commentDragListener$1 extends ICommentListPopup.SimpleCommentListPopupPullListener {
    final /* synthetic */ CommonCommentPlugin this$0;

    CommonCommentPlugin$commentDragListener$1(CommonCommentPlugin $receiver) {
        this.this$0 = $receiver;
    }

    public void onPullCancelled() {
        for (CommentDragListener listener : this.this$0.commentDragListenerSet) {
            listener.onPullCancelled();
        }
    }

    public void onPullCompleted() {
        for (CommentDragListener listener : this.this$0.commentDragListenerSet) {
            listener.onPullCompleted();
        }
    }

    public void onPullProgressChanged(float progress) {
        for (CommentDragListener listener : this.this$0.commentDragListenerSet) {
            listener.onPullProgressChanged(progress);
        }
    }

    public void onPullStarted() {
        for (CommentDragListener listener : this.this$0.commentDragListenerSet) {
            listener.onPullStarted();
        }
    }

    public void onDrag(int left, int top, int dx, int dy) {
        for (CommentDragListener listener : this.this$0.commentDragListenerSet) {
            C0297BdPopupWindow commentPopup = this.this$0.getCommentPopup();
            listener.onDrag(left, top, dx, dy, commentPopup != null ? commentPopup.getWidth() : 0);
        }
    }
}
