package com.baidu.searchbox.video.component.comment.service.imp;

import android.widget.PopupWindow;
import com.baidu.searchbox.video.component.comment.CommonCommentPlugin;
import com.baidu.searchbox.video.component.comment.service.ICommonCommentService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/video/component/comment/service/imp/CommonCommentService;", "Lcom/baidu/searchbox/video/component/comment/service/ICommonCommentService;", "plugin", "Lcom/baidu/searchbox/video/component/comment/CommonCommentPlugin;", "(Lcom/baidu/searchbox/video/component/comment/CommonCommentPlugin;)V", "getCommentPopup", "Landroid/widget/PopupWindow;", "hideAllCommentPopup", "", "lib-video-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommonCommentService.kt */
public final class CommonCommentService implements ICommonCommentService {
    private final CommonCommentPlugin plugin;

    public CommonCommentService(CommonCommentPlugin plugin2) {
        Intrinsics.checkNotNullParameter(plugin2, "plugin");
        this.plugin = plugin2;
    }

    public PopupWindow getCommentPopup() {
        CommonCommentPlugin commonCommentPlugin = this.plugin;
        return commonCommentPlugin != null ? commonCommentPlugin.getCommentPopup() : null;
    }

    public void hideAllCommentPopup() {
        this.plugin.hideAllCommentPopup();
    }
}
