package com.baidu.searchbox.feed.model.gson.mapper;

import com.baidu.searchbox.feed.model.FeedBar;
import com.baidu.searchbox.feed.model.gson.bean.CommentBean;
import com.baidu.talos.core.render.bindingx.internal.BindingXConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/feed/model/gson/mapper/FeedBarCommentMapper;", "", "()V", "convertNumSafe", "", "strNum", "", "map", "", "input", "Lcom/baidu/searchbox/feed/model/gson/bean/CommentBean;", "output", "Lcom/baidu/searchbox/feed/model/FeedBar;", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedBarMapper.kt */
public final class FeedBarCommentMapper {
    public static final FeedBarCommentMapper INSTANCE = new FeedBarCommentMapper();

    private FeedBarCommentMapper() {
    }

    @JvmStatic
    public static final void map(CommentBean input, FeedBar output) {
        Intrinsics.checkNotNullParameter(output, BindingXConstants.KEY_INTERPOLATER_OUTPUT);
        if (input != null) {
            if (output.comment == null) {
                output.comment = new FeedBar.Comment();
            }
            FeedBar.Comment comment = output.comment;
            comment.cmd = input.getCmd();
            comment.count = INSTANCE.convertNumSafe(input.getCount());
        }
    }

    private final int convertNumSafe(String strNum) {
        try {
            return Integer.parseInt(strNum);
        } catch (NumberFormatException e2) {
            return 0;
        }
    }
}
