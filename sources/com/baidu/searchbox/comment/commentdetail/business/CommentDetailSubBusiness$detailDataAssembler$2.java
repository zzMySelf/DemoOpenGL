package com.baidu.searchbox.comment.commentdetail.business;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/comment/commentdetail/business/CommentDetailDataAssembler;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentDetailSubBusiness.kt */
final class CommentDetailSubBusiness$detailDataAssembler$2 extends Lambda implements Function0<CommentDetailDataAssembler> {
    final /* synthetic */ CommentDetailSubBusiness this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CommentDetailSubBusiness$detailDataAssembler$2(CommentDetailSubBusiness commentDetailSubBusiness) {
        super(0);
        this.this$0 = commentDetailSubBusiness;
    }

    public final CommentDetailDataAssembler invoke() {
        return new CommentDetailDataAssembler(this.this$0.getManager(), this.this$0.getDetailConditionData(), this.this$0.getAttrs());
    }
}
