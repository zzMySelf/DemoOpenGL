package com.baidu.searchbox.comment.definition.titlebar;

import com.baidu.searchbox.comment.model.CommentConditionData;
import com.baidu.searchbox.comment.model.CommentListData;
import com.baidu.searchbox.comment.params.CommonAttrs;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0005H&J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0003H&J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0003H&J\u0012\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H&J\u0018\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003H&¨\u0006\u001b"}, d2 = {"Lcom/baidu/searchbox/comment/definition/titlebar/ICommentTitleController;", "", "getTitleBarHeight", "", "onDestroy", "", "onFontSizeChanged", "onNightModeChange", "setCommonAttrs", "commonAttrs", "Lcom/baidu/searchbox/comment/params/CommonAttrs;", "setConditionData", "conditionData", "Lcom/baidu/searchbox/comment/model/CommentConditionData;", "setDirectionType", "direction", "setICommentTitle", "commentTitle", "Lcom/baidu/searchbox/comment/definition/titlebar/ICommentTitle;", "updateCommentCount", "totalCount", "updateCommentTitle", "dataList", "Lcom/baidu/searchbox/comment/model/CommentListData;", "updateTitleInnerStyle", "commentCount", "visibleViewCount", "lib-comment-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ICommentTitleController.kt */
public interface ICommentTitleController {
    int getTitleBarHeight();

    void onDestroy();

    void onFontSizeChanged();

    void onNightModeChange();

    void setCommonAttrs(CommonAttrs commonAttrs);

    void setConditionData(CommentConditionData commentConditionData);

    void setDirectionType(int i2);

    void setICommentTitle(ICommentTitle iCommentTitle);

    void updateCommentCount(int i2);

    void updateCommentTitle(CommentListData commentListData);

    void updateTitleInnerStyle(int i2, int i3);
}
