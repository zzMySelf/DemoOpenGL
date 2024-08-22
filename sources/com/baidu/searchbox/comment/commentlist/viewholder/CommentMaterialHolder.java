package com.baidu.searchbox.comment.commentlist.viewholder;

import com.baidu.searchbox.comment.BaseHolder;
import com.baidu.searchbox.comment.definition.ICommentView;
import com.baidu.searchbox.comment.model.CommentModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0014¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/comment/commentlist/viewholder/CommentMaterialHolder;", "Lcom/baidu/searchbox/comment/BaseHolder;", "Lcom/baidu/searchbox/comment/model/CommentModel;", "itemView", "Lcom/baidu/searchbox/comment/definition/ICommentView;", "(Lcom/baidu/searchbox/comment/definition/ICommentView;)V", "getDataType", "Ljava/lang/Class;", "lib-comment-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentMaterialHolder.kt */
public final class CommentMaterialHolder extends BaseHolder<CommentModel> {
    public CommentMaterialHolder(ICommentView<?> itemView) {
        super(itemView);
    }

    /* access modifiers changed from: protected */
    public Class<CommentModel> getDataType() {
        return CommentModel.class;
    }
}
