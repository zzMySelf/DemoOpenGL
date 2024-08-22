package com.baidu.searchbox.video.feedflow.ad.toptitle;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BE\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\u0002\u0010\nJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0003HÆ\u0003JI\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\tHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/toptitle/NadTopTitleState;", "", "duration", "Landroidx/lifecycle/MutableLiveData;", "", "show", "", "updateStyle", "height", "", "(Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;)V", "getDuration", "()Landroidx/lifecycle/MutableLiveData;", "getHeight", "getShow", "getUpdateStyle", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadTopTitleState.kt */
public final class NadTopTitleState {
    private final MutableLiveData<Long> duration;
    private final MutableLiveData<Integer> height;
    private final MutableLiveData<Boolean> show;
    private final MutableLiveData<Boolean> updateStyle;

    public NadTopTitleState() {
        this((MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ NadTopTitleState copy$default(NadTopTitleState nadTopTitleState, MutableLiveData<Long> mutableLiveData, MutableLiveData<Boolean> mutableLiveData2, MutableLiveData<Boolean> mutableLiveData3, MutableLiveData<Integer> mutableLiveData4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            mutableLiveData = nadTopTitleState.duration;
        }
        if ((i2 & 2) != 0) {
            mutableLiveData2 = nadTopTitleState.show;
        }
        if ((i2 & 4) != 0) {
            mutableLiveData3 = nadTopTitleState.updateStyle;
        }
        if ((i2 & 8) != 0) {
            mutableLiveData4 = nadTopTitleState.height;
        }
        return nadTopTitleState.copy(mutableLiveData, mutableLiveData2, mutableLiveData3, mutableLiveData4);
    }

    public final MutableLiveData<Long> component1() {
        return this.duration;
    }

    public final MutableLiveData<Boolean> component2() {
        return this.show;
    }

    public final MutableLiveData<Boolean> component3() {
        return this.updateStyle;
    }

    public final MutableLiveData<Integer> component4() {
        return this.height;
    }

    public final NadTopTitleState copy(MutableLiveData<Long> mutableLiveData, MutableLiveData<Boolean> mutableLiveData2, MutableLiveData<Boolean> mutableLiveData3, MutableLiveData<Integer> mutableLiveData4) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "duration");
        Intrinsics.checkNotNullParameter(mutableLiveData2, "show");
        Intrinsics.checkNotNullParameter(mutableLiveData3, "updateStyle");
        Intrinsics.checkNotNullParameter(mutableLiveData4, "height");
        return new NadTopTitleState(mutableLiveData, mutableLiveData2, mutableLiveData3, mutableLiveData4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NadTopTitleState)) {
            return false;
        }
        NadTopTitleState nadTopTitleState = (NadTopTitleState) obj;
        return Intrinsics.areEqual((Object) this.duration, (Object) nadTopTitleState.duration) && Intrinsics.areEqual((Object) this.show, (Object) nadTopTitleState.show) && Intrinsics.areEqual((Object) this.updateStyle, (Object) nadTopTitleState.updateStyle) && Intrinsics.areEqual((Object) this.height, (Object) nadTopTitleState.height);
    }

    public int hashCode() {
        return (((((this.duration.hashCode() * 31) + this.show.hashCode()) * 31) + this.updateStyle.hashCode()) * 31) + this.height.hashCode();
    }

    public String toString() {
        return "NadTopTitleState(duration=" + this.duration + ", show=" + this.show + ", updateStyle=" + this.updateStyle + ", height=" + this.height + ')';
    }

    public NadTopTitleState(MutableLiveData<Long> duration2, MutableLiveData<Boolean> show2, MutableLiveData<Boolean> updateStyle2, MutableLiveData<Integer> height2) {
        Intrinsics.checkNotNullParameter(duration2, "duration");
        Intrinsics.checkNotNullParameter(show2, "show");
        Intrinsics.checkNotNullParameter(updateStyle2, "updateStyle");
        Intrinsics.checkNotNullParameter(height2, "height");
        this.duration = duration2;
        this.show = show2;
        this.updateStyle = updateStyle2;
        this.height = height2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NadTopTitleState(MutableLiveData mutableLiveData, MutableLiveData mutableLiveData2, MutableLiveData mutableLiveData3, MutableLiveData mutableLiveData4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new MutableLiveData() : mutableLiveData, (i2 & 2) != 0 ? new MutableLiveData() : mutableLiveData2, (i2 & 4) != 0 ? new MutableLiveData() : mutableLiveData3, (i2 & 8) != 0 ? new MutableLiveData() : mutableLiveData4);
    }

    public final MutableLiveData<Long> getDuration() {
        return this.duration;
    }

    public final MutableLiveData<Boolean> getShow() {
        return this.show;
    }

    public final MutableLiveData<Boolean> getUpdateStyle() {
        return this.updateStyle;
    }

    public final MutableLiveData<Integer> getHeight() {
        return this.height;
    }
}
