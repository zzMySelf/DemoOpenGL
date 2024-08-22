package com.baidu.searchbox.video.feedflow.detail.liveentrance;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.flowvideo.detail.repos.LiveEntranceModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/liveentrance/LiveEntranceNetSuccess;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "model", "Lcom/baidu/searchbox/flowvideo/detail/repos/LiveEntranceModel;", "liveHeatCount", "", "(Lcom/baidu/searchbox/flowvideo/detail/repos/LiveEntranceModel;Ljava/lang/String;)V", "getLiveHeatCount", "()Ljava/lang/String;", "getModel", "()Lcom/baidu/searchbox/flowvideo/detail/repos/LiveEntranceModel;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@UnicastAction
/* compiled from: LiveEntranceActionManifest.kt */
public final class LiveEntranceNetSuccess implements Action {
    private final String liveHeatCount;
    private final LiveEntranceModel model;

    public static /* synthetic */ LiveEntranceNetSuccess copy$default(LiveEntranceNetSuccess liveEntranceNetSuccess, LiveEntranceModel liveEntranceModel, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            liveEntranceModel = liveEntranceNetSuccess.model;
        }
        if ((i2 & 2) != 0) {
            str = liveEntranceNetSuccess.liveHeatCount;
        }
        return liveEntranceNetSuccess.copy(liveEntranceModel, str);
    }

    public final LiveEntranceModel component1() {
        return this.model;
    }

    public final String component2() {
        return this.liveHeatCount;
    }

    public final LiveEntranceNetSuccess copy(LiveEntranceModel liveEntranceModel, String str) {
        Intrinsics.checkNotNullParameter(liveEntranceModel, "model");
        Intrinsics.checkNotNullParameter(str, "liveHeatCount");
        return new LiveEntranceNetSuccess(liveEntranceModel, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveEntranceNetSuccess)) {
            return false;
        }
        LiveEntranceNetSuccess liveEntranceNetSuccess = (LiveEntranceNetSuccess) obj;
        return Intrinsics.areEqual((Object) this.model, (Object) liveEntranceNetSuccess.model) && Intrinsics.areEqual((Object) this.liveHeatCount, (Object) liveEntranceNetSuccess.liveHeatCount);
    }

    public int hashCode() {
        return (this.model.hashCode() * 31) + this.liveHeatCount.hashCode();
    }

    public String toString() {
        return "LiveEntranceNetSuccess(model=" + this.model + ", liveHeatCount=" + this.liveHeatCount + ')';
    }

    public LiveEntranceNetSuccess(LiveEntranceModel model2, String liveHeatCount2) {
        Intrinsics.checkNotNullParameter(model2, "model");
        Intrinsics.checkNotNullParameter(liveHeatCount2, "liveHeatCount");
        this.model = model2;
        this.liveHeatCount = liveHeatCount2;
    }

    public final String getLiveHeatCount() {
        return this.liveHeatCount;
    }

    public final LiveEntranceModel getModel() {
        return this.model;
    }
}
