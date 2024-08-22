package com.baidu.searchbox.comment.template.fluency;

import com.baidu.searchbox.comment.model.CommentModel;
import com.baidu.searchbox.comment.statistic.BDCommentStatisticHelper;
import com.baidu.searchbox.comment.template.content.CommentContentCallback;
import com.baidu.searchbox.comment.template.content.CommentContentModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, d2 = {"com/baidu/searchbox/comment/template/fluency/CommentOptTemplateView$bindCommentContent$1$2", "Lcom/baidu/searchbox/comment/template/content/CommentContentCallback;", "componentShow", "", "model", "Lcom/baidu/searchbox/comment/template/content/CommentContentModel;", "onContentLongClick", "onExceedStateChanged", "exceedState", "", "onViewAllTextClick", "lib-comment-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentOptTemplateView.kt */
public final class CommentOptTemplateView$bindCommentContent$1$2 implements CommentContentCallback {
    final /* synthetic */ CommentModel $data;
    final /* synthetic */ int $position;
    final /* synthetic */ CommentOptTemplateView this$0;

    CommentOptTemplateView$bindCommentContent$1$2(CommentModel $data2, CommentOptTemplateView $receiver, int $position2) {
        this.$data = $data2;
        this.this$0 = $receiver;
        this.$position = $position2;
    }

    public void onViewAllTextClick(CommentContentModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        CommentModel commentModel = this.$data;
        commentModel.setViewAllTextState(!commentModel.getViewAllTextState());
        CommentOptTemplateView.ubcInteract$default(this.this$0, BDCommentStatisticHelper.TYPE_UBC_FULL_TEXT_CLK, this.$data, (String) null, 4, (Object) null);
        this.this$0.onBindView(this.$position, this.$data);
    }

    public void onContentLongClick() {
        this.this$0.handleLongClick();
    }

    public void onExceedStateChanged(int exceedState) {
        this.$data.setExceedMaxLineState(exceedState);
    }

    public void componentShow(CommentContentModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
    }
}
