package com.baidu.searchbox.search.tab.sortSelect;

import com.baidu.searchbox.search.tab.subTab.VideoCommonSubTabModel;
import com.baidu.searchbox.search.tab.tagsearch.VideoCommonTagModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J7\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010 \u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006&"}, d2 = {"Lcom/baidu/searchbox/search/tab/sortSelect/VideoCommonSortUnionModel;", "", "videoCommonSortModel", "Lcom/baidu/searchbox/search/tab/sortSelect/VideoCommonSortModel;", "videoCommonSubTabModel", "Lcom/baidu/searchbox/search/tab/subTab/VideoCommonSubTabModel;", "videoCommonTagModel", "Lcom/baidu/searchbox/search/tab/tagsearch/VideoCommonTagModel;", "frameData", "", "(Lcom/baidu/searchbox/search/tab/sortSelect/VideoCommonSortModel;Lcom/baidu/searchbox/search/tab/subTab/VideoCommonSubTabModel;Lcom/baidu/searchbox/search/tab/tagsearch/VideoCommonTagModel;Z)V", "getFrameData", "()Z", "setFrameData", "(Z)V", "getVideoCommonSortModel", "()Lcom/baidu/searchbox/search/tab/sortSelect/VideoCommonSortModel;", "setVideoCommonSortModel", "(Lcom/baidu/searchbox/search/tab/sortSelect/VideoCommonSortModel;)V", "getVideoCommonSubTabModel", "()Lcom/baidu/searchbox/search/tab/subTab/VideoCommonSubTabModel;", "setVideoCommonSubTabModel", "(Lcom/baidu/searchbox/search/tab/subTab/VideoCommonSubTabModel;)V", "getVideoCommonTagModel", "()Lcom/baidu/searchbox/search/tab/tagsearch/VideoCommonTagModel;", "setVideoCommonTagModel", "(Lcom/baidu/searchbox/search/tab/tagsearch/VideoCommonTagModel;)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "search_video_business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoCommonSortUnionModel.kt */
public final class VideoCommonSortUnionModel {
    private boolean frameData;
    private VideoCommonSortModel videoCommonSortModel;
    private VideoCommonSubTabModel videoCommonSubTabModel;
    private VideoCommonTagModel videoCommonTagModel;

    public static /* synthetic */ VideoCommonSortUnionModel copy$default(VideoCommonSortUnionModel videoCommonSortUnionModel, VideoCommonSortModel videoCommonSortModel2, VideoCommonSubTabModel videoCommonSubTabModel2, VideoCommonTagModel videoCommonTagModel2, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            videoCommonSortModel2 = videoCommonSortUnionModel.videoCommonSortModel;
        }
        if ((i2 & 2) != 0) {
            videoCommonSubTabModel2 = videoCommonSortUnionModel.videoCommonSubTabModel;
        }
        if ((i2 & 4) != 0) {
            videoCommonTagModel2 = videoCommonSortUnionModel.videoCommonTagModel;
        }
        if ((i2 & 8) != 0) {
            z = videoCommonSortUnionModel.frameData;
        }
        return videoCommonSortUnionModel.copy(videoCommonSortModel2, videoCommonSubTabModel2, videoCommonTagModel2, z);
    }

    public final VideoCommonSortModel component1() {
        return this.videoCommonSortModel;
    }

    public final VideoCommonSubTabModel component2() {
        return this.videoCommonSubTabModel;
    }

    public final VideoCommonTagModel component3() {
        return this.videoCommonTagModel;
    }

    public final boolean component4() {
        return this.frameData;
    }

    public final VideoCommonSortUnionModel copy(VideoCommonSortModel videoCommonSortModel2, VideoCommonSubTabModel videoCommonSubTabModel2, VideoCommonTagModel videoCommonTagModel2, boolean z) {
        return new VideoCommonSortUnionModel(videoCommonSortModel2, videoCommonSubTabModel2, videoCommonTagModel2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoCommonSortUnionModel)) {
            return false;
        }
        VideoCommonSortUnionModel videoCommonSortUnionModel = (VideoCommonSortUnionModel) obj;
        return Intrinsics.areEqual((Object) this.videoCommonSortModel, (Object) videoCommonSortUnionModel.videoCommonSortModel) && Intrinsics.areEqual((Object) this.videoCommonSubTabModel, (Object) videoCommonSortUnionModel.videoCommonSubTabModel) && Intrinsics.areEqual((Object) this.videoCommonTagModel, (Object) videoCommonSortUnionModel.videoCommonTagModel) && this.frameData == videoCommonSortUnionModel.frameData;
    }

    public int hashCode() {
        VideoCommonSortModel videoCommonSortModel2 = this.videoCommonSortModel;
        int i2 = 0;
        int hashCode = (videoCommonSortModel2 == null ? 0 : videoCommonSortModel2.hashCode()) * 31;
        VideoCommonSubTabModel videoCommonSubTabModel2 = this.videoCommonSubTabModel;
        int hashCode2 = (hashCode + (videoCommonSubTabModel2 == null ? 0 : videoCommonSubTabModel2.hashCode())) * 31;
        VideoCommonTagModel videoCommonTagModel2 = this.videoCommonTagModel;
        if (videoCommonTagModel2 != null) {
            i2 = videoCommonTagModel2.hashCode();
        }
        int i3 = (hashCode2 + i2) * 31;
        boolean z = this.frameData;
        if (z) {
            z = true;
        }
        return i3 + (z ? 1 : 0);
    }

    public String toString() {
        return "VideoCommonSortUnionModel(videoCommonSortModel=" + this.videoCommonSortModel + ", videoCommonSubTabModel=" + this.videoCommonSubTabModel + ", videoCommonTagModel=" + this.videoCommonTagModel + ", frameData=" + this.frameData + ')';
    }

    public VideoCommonSortUnionModel(VideoCommonSortModel videoCommonSortModel2, VideoCommonSubTabModel videoCommonSubTabModel2, VideoCommonTagModel videoCommonTagModel2, boolean frameData2) {
        this.videoCommonSortModel = videoCommonSortModel2;
        this.videoCommonSubTabModel = videoCommonSubTabModel2;
        this.videoCommonTagModel = videoCommonTagModel2;
        this.frameData = frameData2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VideoCommonSortUnionModel(VideoCommonSortModel videoCommonSortModel2, VideoCommonSubTabModel videoCommonSubTabModel2, VideoCommonTagModel videoCommonTagModel2, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(videoCommonSortModel2, videoCommonSubTabModel2, videoCommonTagModel2, (i2 & 8) != 0 ? false : z);
    }

    public final VideoCommonSortModel getVideoCommonSortModel() {
        return this.videoCommonSortModel;
    }

    public final void setVideoCommonSortModel(VideoCommonSortModel videoCommonSortModel2) {
        this.videoCommonSortModel = videoCommonSortModel2;
    }

    public final VideoCommonSubTabModel getVideoCommonSubTabModel() {
        return this.videoCommonSubTabModel;
    }

    public final void setVideoCommonSubTabModel(VideoCommonSubTabModel videoCommonSubTabModel2) {
        this.videoCommonSubTabModel = videoCommonSubTabModel2;
    }

    public final VideoCommonTagModel getVideoCommonTagModel() {
        return this.videoCommonTagModel;
    }

    public final void setVideoCommonTagModel(VideoCommonTagModel videoCommonTagModel2) {
        this.videoCommonTagModel = videoCommonTagModel2;
    }

    public final boolean getFrameData() {
        return this.frameData;
    }

    public final void setFrameData(boolean z) {
        this.frameData = z;
    }
}
