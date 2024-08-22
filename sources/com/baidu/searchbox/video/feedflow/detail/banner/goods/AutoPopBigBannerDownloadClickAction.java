package com.baidu.searchbox.video.feedflow.detail.banner.goods;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.video.feedflow.detail.appdownload.VideoDownloadClickType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/banner/goods/AutoPopBigBannerDownloadClickAction;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "type", "Lcom/baidu/searchbox/video/feedflow/detail/appdownload/VideoDownloadClickType;", "(Lcom/baidu/searchbox/video/feedflow/detail/appdownload/VideoDownloadClickType;)V", "getType", "()Lcom/baidu/searchbox/video/feedflow/detail/appdownload/VideoDownloadClickType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@UnicastAction
/* compiled from: GoodsBigBannerActionManifest.kt */
public final class AutoPopBigBannerDownloadClickAction implements Action {
    private final VideoDownloadClickType type;

    public static /* synthetic */ AutoPopBigBannerDownloadClickAction copy$default(AutoPopBigBannerDownloadClickAction autoPopBigBannerDownloadClickAction, VideoDownloadClickType videoDownloadClickType, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            videoDownloadClickType = autoPopBigBannerDownloadClickAction.type;
        }
        return autoPopBigBannerDownloadClickAction.copy(videoDownloadClickType);
    }

    public final VideoDownloadClickType component1() {
        return this.type;
    }

    public final AutoPopBigBannerDownloadClickAction copy(VideoDownloadClickType videoDownloadClickType) {
        Intrinsics.checkNotNullParameter(videoDownloadClickType, "type");
        return new AutoPopBigBannerDownloadClickAction(videoDownloadClickType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AutoPopBigBannerDownloadClickAction) && this.type == ((AutoPopBigBannerDownloadClickAction) obj).type;
    }

    public int hashCode() {
        return this.type.hashCode();
    }

    public String toString() {
        return "AutoPopBigBannerDownloadClickAction(type=" + this.type + ')';
    }

    public AutoPopBigBannerDownloadClickAction(VideoDownloadClickType type2) {
        Intrinsics.checkNotNullParameter(type2, "type");
        this.type = type2;
    }

    public final VideoDownloadClickType getType() {
        return this.type;
    }
}
