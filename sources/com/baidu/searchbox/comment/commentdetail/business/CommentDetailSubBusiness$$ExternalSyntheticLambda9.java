package com.baidu.searchbox.comment.commentdetail.business;

import com.baidu.searchbox.comment.data.ReplyListData;
import com.baidu.searchbox.comment.definition.BDCommentRequestCallback;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CommentDetailSubBusiness$$ExternalSyntheticLambda9 implements BDCommentRequestCallback {
    public final /* synthetic */ CommentDetailSubBusiness f$0;

    public /* synthetic */ CommentDetailSubBusiness$$ExternalSyntheticLambda9(CommentDetailSubBusiness commentDetailSubBusiness) {
        this.f$0 = commentDetailSubBusiness;
    }

    public final void onCompleted(int i2, Object obj, String str) {
        CommentDetailSubBusiness.m16723requestCommentList$lambda20(this.f$0, i2, (ReplyListData) obj, str);
    }
}
