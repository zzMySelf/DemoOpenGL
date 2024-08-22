package com.baidu.searchbox.comment.commentlist.templateview;

import com.baidu.searchbox.comment.CommentRuntime;
import com.baidu.searchbox.comment.model.CommentModel;
import com.baidu.searchbox.comment.statistic.BDCommentStatisticHelper;
import com.baidu.searchbox.comment.template.userInfo.CommentUserIconCallback;
import com.baidu.searchbox.comment.template.userInfo.CommentUserIconModel;
import com.baidu.searchbox.comment.util.BDCommentUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/comment/commentlist/templateview/CommentMaterialView$bindUserIcon$1$1", "Lcom/baidu/searchbox/comment/template/userInfo/CommentUserIconCallback;", "onIconClick", "", "model", "Lcom/baidu/searchbox/comment/template/userInfo/CommentUserIconModel;", "lib-comment-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentMaterialView.kt */
public final class CommentMaterialView$bindUserIcon$1$1 implements CommentUserIconCallback {
    final /* synthetic */ CommentModel $data;
    final /* synthetic */ CommentMaterialView this$0;

    CommentMaterialView$bindUserIcon$1$1(CommentMaterialView $receiver, CommentModel $data2) {
        this.this$0 = $receiver;
        this.$data = $data2;
    }

    public void onIconClick(CommentUserIconModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        if (!BDCommentUtil.isTeenagerMode()) {
            CharSequence uk = model.getUk();
            boolean z = false;
            if (uk == null || uk.length() == 0) {
                CharSequence personalPageSchema = model.getPersonalPageSchema();
                if (personalPageSchema == null || personalPageSchema.length() == 0) {
                    return;
                }
            }
            CommentRuntime.getCommentContext().handleHomePagePerformanceFlow();
            String passUid = CommentRuntime.getCommentContext().getPassUId(model.getUk());
            String schema = model.getPersonalPageSchema();
            CharSequence charSequence = passUid;
            if (charSequence == null || charSequence.length() == 0) {
                CharSequence charSequence2 = schema;
                if (charSequence2 == null || charSequence2.length() == 0) {
                    z = true;
                }
                if (z) {
                    return;
                }
            }
            CommentMaterialView.ubcInteract$default(this.this$0, BDCommentStatisticHelper.TYPE_MATERIAL_USER_NAME_CLK, this.$data, (String) null, 4, (Object) null);
            BDCommentUtil.launchHomepage(schema, passUid, "");
        }
    }
}
