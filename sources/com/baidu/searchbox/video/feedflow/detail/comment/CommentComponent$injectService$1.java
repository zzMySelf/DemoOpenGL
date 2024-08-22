package com.baidu.searchbox.video.feedflow.detail.comment;

import android.graphics.PointF;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0017J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/baidu/searchbox/video/feedflow/detail/comment/CommentComponent$injectService$1", "Lcom/baidu/searchbox/video/feedflow/detail/comment/ICommentService;", "commentIconIsPressing", "", "getCommentIconDrawableRes", "", "getCommentView", "Lcom/baidu/searchbox/video/feedflow/detail/comment/CommentView;", "getCommentViewLocation", "Landroid/graphics/PointF;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentComponent.kt */
public final class CommentComponent$injectService$1 implements ICommentService {
    final /* synthetic */ CommentComponent this$0;

    CommentComponent$injectService$1(CommentComponent $receiver) {
        this.this$0 = $receiver;
    }

    public PointF getCommentViewLocation() {
        int[] loc = {0, 0};
        this.this$0.getCommentView().getLocationOnScreen(loc);
        return new PointF(((float) loc[0]) + (((float) this.this$0.getCommentView().getMeasuredWidth()) / 2.0f), (float) loc[1]);
    }

    public CommentView getCommentView() {
        return this.this$0.getCommentView();
    }

    public int getCommentIconDrawableRes() {
        return this.this$0.getCommentView().getIconDrawableRes();
    }

    public boolean commentIconIsPressing() {
        return this.this$0.getCommentView().getIsPressing();
    }
}
