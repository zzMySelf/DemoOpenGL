package com.baidu.searchbox.video.feedflow.detail.livebannner.v1;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.flowvideo.livebanner.repos.LiveBannerModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B7\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\bJ\u0006\u0010\r\u001a\u00020\u000eR\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/livebannner/v1/LiveBannerV1State;", "", "data", "Landroidx/lifecycle/MutableLiveData;", "Lcom/baidu/searchbox/flowvideo/livebanner/repos/LiveBannerModel;", "show", "", "hide", "(Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;)V", "getData", "()Landroidx/lifecycle/MutableLiveData;", "getHide", "getShow", "reset", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveBannerV1State.kt */
public final class LiveBannerV1State {
    private final MutableLiveData<LiveBannerModel> data;
    private final MutableLiveData<Integer> hide;
    private final MutableLiveData<Integer> show;

    public LiveBannerV1State() {
        this((MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, 7, (DefaultConstructorMarker) null);
    }

    public LiveBannerV1State(MutableLiveData<LiveBannerModel> data2, MutableLiveData<Integer> show2, MutableLiveData<Integer> hide2) {
        Intrinsics.checkNotNullParameter(data2, "data");
        Intrinsics.checkNotNullParameter(show2, "show");
        Intrinsics.checkNotNullParameter(hide2, "hide");
        this.data = data2;
        this.show = show2;
        this.hide = hide2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LiveBannerV1State(MutableLiveData mutableLiveData, MutableLiveData mutableLiveData2, MutableLiveData mutableLiveData3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new MutableLiveData() : mutableLiveData, (i2 & 2) != 0 ? new MutableLiveData() : mutableLiveData2, (i2 & 4) != 0 ? new MutableLiveData() : mutableLiveData3);
    }

    public final MutableLiveData<LiveBannerModel> getData() {
        return this.data;
    }

    public final MutableLiveData<Integer> getShow() {
        return this.show;
    }

    public final MutableLiveData<Integer> getHide() {
        return this.hide;
    }

    public final void reset() {
        this.data.setValue(null);
        this.hide.setValue(0);
    }
}
