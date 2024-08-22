package com.baidu.searchbox.comment.commentdetail;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.searchbox.comment.commentlist.business.TemplateDelegate;
import com.baidu.searchbox.comment.definition.ITemplateDelegate;
import com.baidu.searchbox.comment.model.BombConf;
import com.baidu.searchbox.comment.params.CommonAttrs;

public class CommentDetailManager {
    public static ICommentDetail showDetailWindow(CommonAttrs attrs, Context context, View parentView, BombConf bombConf, String friendTag, int commentTotalCount, ITemplateDelegate templateDelegate) {
        if (attrs == null || parentView == null || context == null) {
            return null;
        }
        if (templateDelegate == null) {
            templateDelegate = new TemplateDelegate("0");
        }
        CommentDetailWindow detailWindow = new CommentDetailWindow(context, attrs.detailDirection, attrs, templateDelegate);
        if (attrs.detailHeight != 0 && !TextUtils.equals(templateDelegate.getViewTemplate(), "3")) {
            detailWindow.setHeight(attrs.detailHeight);
        }
        if (attrs.detailWidth != 0) {
            detailWindow.setWidth(attrs.detailWidth);
        }
        detailWindow.show(parentView, attrs.isRoundUI);
        return detailWindow;
    }
}
