package com.baidu.searchbox.comment.commentdetail.business;

import android.content.DialogInterface;
import com.baidu.searchbox.comment.model.CommentModel;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CommentDetailSubBusiness$$ExternalSyntheticLambda7 implements DialogInterface.OnClickListener {
    public final /* synthetic */ CommentDetailSubBusiness f$0;
    public final /* synthetic */ CommentModel f$1;
    public final /* synthetic */ boolean f$2;

    public /* synthetic */ CommentDetailSubBusiness$$ExternalSyntheticLambda7(CommentDetailSubBusiness commentDetailSubBusiness, CommentModel commentModel, boolean z) {
        this.f$0 = commentDetailSubBusiness;
        this.f$1 = commentModel;
        this.f$2 = z;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        CommentDetailSubBusiness.m16718doBlacklist$lambda13(this.f$0, this.f$1, this.f$2, dialogInterface, i2);
    }
}
