package com.baidu.searchbox.comment.commentlist.templateview;

import com.baidu.searchbox.comment.model.CommentModel;
import com.baidu.searchbox.comment.statistic.BDCommentStatisticHelper;
import com.baidu.searchbox.comment.template.follow.CommentFollowCallback;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"com/baidu/searchbox/comment/commentlist/templateview/CommentMaterialView$bindFollow$1$1", "Lcom/baidu/searchbox/comment/template/follow/CommentFollowCallback;", "onFollowBtnClick", "", "currentFollowState", "", "onFollowBtnShow", "show", "onFollowSuccess", "isFollow", "lib-comment-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentMaterialView.kt */
public final class CommentMaterialView$bindFollow$1$1 implements CommentFollowCallback {
    final /* synthetic */ CommentModel $model;
    final /* synthetic */ CommentMaterialView this$0;

    CommentMaterialView$bindFollow$1$1(CommentModel $model2, CommentMaterialView $receiver) {
        this.$model = $model2;
        this.this$0 = $receiver;
    }

    public void onFollowBtnShow(boolean show) {
        if (show && !this.$model.ignoreModel.isMaterialShow) {
            this.$model.ignoreModel.isMaterialShow = true;
            CommentMaterialView.ubcInteract$default(this.this$0, BDCommentStatisticHelper.TYPE_MATERIAL_FOLLOW_SHOW, this.$model, (String) null, 4, (Object) null);
        }
    }

    public void onFollowBtnClick(boolean currentFollowState) {
        CommentMaterialView.ubcInteract$default(this.this$0, !currentFollowState ? BDCommentStatisticHelper.TYPE_MATERIAL_FOLLOW_CLK : BDCommentStatisticHelper.TYPE_MATERIAL_FOLLOW_CANCEL, this.$model, (String) null, 4, (Object) null);
    }

    public void onFollowSuccess(boolean isFollow) {
        this.this$0.handleFollowChangeDataChannel(isFollow);
    }
}
