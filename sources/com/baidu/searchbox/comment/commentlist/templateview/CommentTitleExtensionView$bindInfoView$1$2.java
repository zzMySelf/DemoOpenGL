package com.baidu.searchbox.comment.commentlist.templateview;

import android.app.Activity;
import com.baidu.searchbox.comment.model.CommentModel;
import com.baidu.searchbox.comment.statistic.BDCommentStatisticHelper;
import com.baidu.searchbox.comment.template.additionInfo.CommentAdditionInfoCallback;
import com.baidu.searchbox.comment.template.additionInfo.CommentAdditionInfoView;
import com.baidu.searchbox.unitedscheme.BaseRouter;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/comment/commentlist/templateview/CommentTitleExtensionView$bindInfoView$1$2", "Lcom/baidu/searchbox/comment/template/additionInfo/CommentAdditionInfoCallback;", "onTitleExtensionSourceClick", "", "scheme", "", "lib-comment-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentTitleExtensionView.kt */
public final class CommentTitleExtensionView$bindInfoView$1$2 implements CommentAdditionInfoCallback {
    final /* synthetic */ CommentModel $data;
    final /* synthetic */ CommentAdditionInfoView $this_run;
    final /* synthetic */ CommentTitleExtensionView this$0;

    CommentTitleExtensionView$bindInfoView$1$2(CommentAdditionInfoView $receiver, CommentTitleExtensionView $receiver2, CommentModel $data2) {
        this.$this_run = $receiver;
        this.this$0 = $receiver2;
        this.$data = $data2;
    }

    public void onReplyClick() {
        CommentAdditionInfoCallback.DefaultImpls.onReplyClick(this);
    }

    public void onSourceClick(CommentModel.CommentOrigin origin) {
        CommentAdditionInfoCallback.DefaultImpls.onSourceClick(this, origin);
    }

    public void onTitleExtensionSourceClick(String scheme) {
        if (this.$this_run.getContext() instanceof Activity) {
            BaseRouter.invoke(this.$this_run.getContext(), scheme);
            CommentTitleExtensionView.ubcInteract$default(this.this$0, BDCommentStatisticHelper.TYPE_COMMENT_TITLE_EXTENSION_ORIGIN_CLICK, this.$data, (String) null, 4, (Object) null);
        }
    }
}
