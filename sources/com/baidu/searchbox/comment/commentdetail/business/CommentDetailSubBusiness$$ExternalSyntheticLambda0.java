package com.baidu.searchbox.comment.commentdetail.business;

import com.baidu.searchbox.comment.data.CommentOprStatus;
import com.baidu.searchbox.comment.definition.BDCommentRequestCallback;
import com.baidu.searchbox.comment.model.CommentModel;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CommentDetailSubBusiness$$ExternalSyntheticLambda0 implements BDCommentRequestCallback {
    public final /* synthetic */ CommentDetailSubBusiness f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ CommentModel f$2;

    public /* synthetic */ CommentDetailSubBusiness$$ExternalSyntheticLambda0(CommentDetailSubBusiness commentDetailSubBusiness, boolean z, CommentModel commentModel) {
        this.f$0 = commentDetailSubBusiness;
        this.f$1 = z;
        this.f$2 = commentModel;
    }

    public final void onCompleted(int i2, Object obj, String str) {
        CommentDetailSubBusiness.m16719doBlacklist$lambda13$lambda12(this.f$0, this.f$1, this.f$2, i2, (CommentOprStatus) obj, str);
    }
}
