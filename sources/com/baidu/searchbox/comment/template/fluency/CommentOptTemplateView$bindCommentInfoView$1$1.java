package com.baidu.searchbox.comment.template.fluency;

import android.app.Activity;
import android.content.Context;
import com.baidu.searchbox.comment.BDCommentConstants;
import com.baidu.searchbox.comment.definition.BDCommentResultCustomCallback;
import com.baidu.searchbox.comment.definition.ICommentSubBusiness;
import com.baidu.searchbox.comment.model.CommentModel;
import com.baidu.searchbox.comment.statistic.BDCommentStatisticHelper;
import com.baidu.searchbox.comment.template.additionInfo.CommentAdditionInfoCallback;
import com.baidu.searchbox.comment.template.additionInfo.CommentAdditionInfoView;
import com.baidu.searchbox.comment.util.BDCommentUtil;
import com.baidu.searchbox.unitedscheme.BaseRouter;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"com/baidu/searchbox/comment/template/fluency/CommentOptTemplateView$bindCommentInfoView$1$1", "Lcom/baidu/searchbox/comment/template/additionInfo/CommentAdditionInfoCallback;", "onReplyClick", "", "onSourceClick", "origin", "Lcom/baidu/searchbox/comment/model/CommentModel$CommentOrigin;", "onTitleExtensionSourceClick", "scheme", "", "lib-comment-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentOptTemplateView.kt */
public final class CommentOptTemplateView$bindCommentInfoView$1$1 implements CommentAdditionInfoCallback {
    final /* synthetic */ CommentModel $data;
    final /* synthetic */ int $position;
    final /* synthetic */ CommentAdditionInfoView $this_run;
    final /* synthetic */ CommentOptTemplateView this$0;

    CommentOptTemplateView$bindCommentInfoView$1$1(CommentAdditionInfoView $receiver, CommentOptTemplateView $receiver2, int $position2, CommentModel $data2) {
        this.$this_run = $receiver;
        this.this$0 = $receiver2;
        this.$position = $position2;
        this.$data = $data2;
    }

    public void onReplyClick() {
        if (!BDCommentUtil.isTeenagerMode() && (this.$this_run.getContext() instanceof Activity)) {
            Map otherParams = new HashMap();
            otherParams.put(BDCommentConstants.CommentDetailInputFrom.KEY, "comment_reply");
            otherParams.put(BDCommentConstants.KEY_COMMENT_INPUT_CONTENT_BAR_SWITCH, "1");
            ICommentSubBusiness subBusiness = this.this$0.getSubBusiness();
            if (subBusiness != null) {
                Context context = this.$this_run.getContext();
                if (context != null) {
                    subBusiness.showComment((Activity) context, false, this.$position, this.$data, otherParams, (String) null, (BDCommentResultCustomCallback) null);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
                }
            }
            this.this$0.ubcInteract(BDCommentStatisticHelper.TYPE_REPLY_CLK, this.$data, this.$data.isParentComment() ? BDCommentStatisticHelper.VALUE_FIRST_COMMENT : BDCommentStatisticHelper.VALUE_SECOND_COMMENT);
        }
    }

    public void onSourceClick(CommentModel.CommentOrigin origin) {
        if (this.$this_run.getContext() instanceof Activity) {
            BaseRouter.invoke(this.$this_run.getContext(), origin != null ? origin.scheme : null);
            CommentOptTemplateView.ubcInteract$default(this.this$0, BDCommentStatisticHelper.TYPE_SOURCE_CLK, this.$data, (String) null, 4, (Object) null);
        }
    }

    public void onTitleExtensionSourceClick(String scheme) {
    }
}
