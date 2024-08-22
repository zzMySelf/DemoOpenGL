package com.baidu.searchbox.download.center.ui.video.fusion.model;

import com.baidu.searchbox.download.center.ui.video.fusion.template.VideoTemplateType;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/download/center/ui/video/fusion/model/VideoNetDiskEntryModel;", "Lcom/baidu/searchbox/download/center/ui/video/fusion/model/AbsVideoCommonEntryModel;", "()V", "isShowBottomSpace", "", "()Z", "setShowBottomSpace", "(Z)V", "templateType", "Lcom/baidu/searchbox/download/center/ui/video/fusion/template/VideoTemplateType;", "getTemplateType", "()Lcom/baidu/searchbox/download/center/ui/video/fusion/template/VideoTemplateType;", "lib-download-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoNetDiskEntryModel.kt */
public final class VideoNetDiskEntryModel extends AbsVideoCommonEntryModel {
    private boolean isShowBottomSpace;
    private final VideoTemplateType templateType = VideoTemplateType.COMMON_NET_DISK_VIDEO_ENTRY;

    public VideoTemplateType getTemplateType() {
        return this.templateType;
    }

    public final boolean isShowBottomSpace() {
        return this.isShowBottomSpace;
    }

    public final void setShowBottomSpace(boolean z) {
        this.isShowBottomSpace = z;
    }
}
