package com.baidu.searchbox.comment.template.fluency;

import com.baidu.searchbox.comment.definition.ICommentSubBusiness;
import com.baidu.searchbox.comment.model.CommentModel;
import com.baidu.searchbox.comment.statistic.BDCommentStatisticHelper;
import com.baidu.searchbox.comment.template.unfoldReply.CommentUnfoldReplyCallback;
import com.baidu.ubc.Flow;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/baidu/searchbox/comment/template/fluency/CommentOptVideoReplyTemplateView$bindCommentUnfoldReplyView$1$1", "Lcom/baidu/searchbox/comment/template/unfoldReply/CommentUnfoldReplyCallback;", "onFoldClick", "", "onUnfoldMoreClick", "lib-comment-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentOptVideoReplyTemplateView.kt */
public final class CommentOptVideoReplyTemplateView$bindCommentUnfoldReplyView$1$1 implements CommentUnfoldReplyCallback {
    final /* synthetic */ CommentModel $data;
    final /* synthetic */ int $position;
    final /* synthetic */ CommentOptVideoReplyTemplateView this$0;

    CommentOptVideoReplyTemplateView$bindCommentUnfoldReplyView$1$1(CommentOptVideoReplyTemplateView $receiver, CommentModel $data2, int $position2) {
        this.this$0 = $receiver;
        this.$data = $data2;
        this.$position = $position2;
    }

    public void onUnfoldMoreClick() {
        ICommentSubBusiness subBusiness = this.this$0.getSubBusiness();
        if (subBusiness != null) {
            subBusiness.requestUnfoldCommentList((Flow) null, this.$data);
        }
        CommentOptTemplateView.ubcInteract$default(this.this$0, BDCommentStatisticHelper.TYPE_VIEW_ALL_CLK, this.$data, (String) null, 4, (Object) null);
    }

    public void onFoldClick() {
        ICommentSubBusiness subBusiness = this.this$0.getSubBusiness();
        if (subBusiness != null) {
            subBusiness.foldCommentList(this.$position, this.$data);
        }
        this.this$0.ubcInteract(BDCommentStatisticHelper.TYPE_COMMENT_AREA_CLK, this.$data, BDCommentStatisticHelper.VALUE_SECOND_COMMENT);
    }
}
