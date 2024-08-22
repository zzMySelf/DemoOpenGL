package com.baidu.searchbox.comment.definition;

import android.content.Context;
import com.baidu.searchbox.comment.BaseHolder;

public interface ICommentHolderFactory {
    BaseHolder get(int i2, Context context, ICommentView iCommentView);
}
