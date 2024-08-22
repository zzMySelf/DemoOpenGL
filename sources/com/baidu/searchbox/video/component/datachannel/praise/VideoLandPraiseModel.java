package com.baidu.searchbox.video.component.datachannel.praise;

import com.baidu.searchbox.NoProGuard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/video/component/datachannel/praise/VideoLandPraiseModel;", "Lcom/baidu/searchbox/NoProGuard;", "count", "", "status", "", "nid", "", "(IZLjava/lang/String;)V", "getCount", "()I", "getNid", "()Ljava/lang/String;", "getStatus", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "lib-video-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PraiseDataChannelModel.kt */
public final class VideoLandPraiseModel implements NoProGuard {
    private final int count;
    private final String nid;
    private final boolean status;

    public VideoLandPraiseModel() {
        this(0, false, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ VideoLandPraiseModel copy$default(VideoLandPraiseModel videoLandPraiseModel, int i2, boolean z, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = videoLandPraiseModel.count;
        }
        if ((i3 & 2) != 0) {
            z = videoLandPraiseModel.status;
        }
        if ((i3 & 4) != 0) {
            str = videoLandPraiseModel.nid;
        }
        return videoLandPraiseModel.copy(i2, z, str);
    }

    public final int component1() {
        return this.count;
    }

    public final boolean component2() {
        return this.status;
    }

    public final String component3() {
        return this.nid;
    }

    public final VideoLandPraiseModel copy(int i2, boolean z, String str) {
        Intrinsics.checkNotNullParameter(str, "nid");
        return new VideoLandPraiseModel(i2, z, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoLandPraiseModel)) {
            return false;
        }
        VideoLandPraiseModel videoLandPraiseModel = (VideoLandPraiseModel) obj;
        return this.count == videoLandPraiseModel.count && this.status == videoLandPraiseModel.status && Intrinsics.areEqual((Object) this.nid, (Object) videoLandPraiseModel.nid);
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.count) * 31;
        boolean z = this.status;
        if (z) {
            z = true;
        }
        return ((hashCode + (z ? 1 : 0)) * 31) + this.nid.hashCode();
    }

    public String toString() {
        return "VideoLandPraiseModel(count=" + this.count + ", status=" + this.status + ", nid=" + this.nid + ')';
    }

    public VideoLandPraiseModel(int count2, boolean status2, String nid2) {
        Intrinsics.checkNotNullParameter(nid2, "nid");
        this.count = count2;
        this.status = status2;
        this.nid = nid2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VideoLandPraiseModel(int i2, boolean z, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i2, (i3 & 2) != 0 ? false : z, (i3 & 4) != 0 ? "" : str);
    }

    public final int getCount() {
        return this.count;
    }

    public final boolean getStatus() {
        return this.status;
    }

    public final String getNid() {
        return this.nid;
    }
}
