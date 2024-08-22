package com.baidu.searchbox.comment.commentlist.viewholder;

import com.baidu.searchbox.comment.BaseHolder;
import com.baidu.searchbox.comment.definition.ICommentView;
import com.baidu.searchbox.comment.model.CommentModel;

public class CommentTemplateHolder extends BaseHolder<CommentModel> {
    public CommentTemplateHolder(ICommentView itemView) {
        super(itemView);
    }

    /* access modifiers changed from: protected */
    public Class<CommentModel> getDataType() {
        return CommentModel.class;
    }
}
