package com.baidu.searchbox.download.center.ui.video.fusion.template;

import android.view.View;
import com.baidu.searchbox.download.center.ui.video.fusion.adapter.BaseVideoManagerHolder;
import com.baidu.searchbox.download.center.ui.video.fusion.model.AbsVideoTemplateModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J*\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/download/center/ui/video/fusion/template/VideoEmptyHolder;", "Lcom/baidu/searchbox/download/center/ui/video/fusion/adapter/BaseVideoManagerHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "update", "", "templateModel", "Lcom/baidu/searchbox/download/center/ui/video/fusion/model/AbsVideoTemplateModel;", "position", "", "editMode", "", "isSelected", "lib-download-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoEmptyHolder.kt */
public final class VideoEmptyHolder extends BaseVideoManagerHolder {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VideoEmptyHolder(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
    }

    public void update(AbsVideoTemplateModel templateModel, int position, boolean editMode, boolean isSelected) {
    }
}
