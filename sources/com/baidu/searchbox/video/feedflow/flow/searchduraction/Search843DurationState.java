package com.baidu.searchbox.video.feedflow.flow.searchduraction;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B9\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0002\u0010\tR\u001b\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000bR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/searchduraction/Search843DurationState;", "", "isCovered", "Landroidx/lifecycle/MutableLiveData;", "", "detailItemSelected", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "uploadFirstJumpDuration", "", "(Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;)V", "getDetailItemSelected", "()Landroidx/lifecycle/MutableLiveData;", "getUploadFirstJumpDuration", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Search843DurationState.kt */
public final class Search843DurationState {
    private final MutableLiveData<ItemModel<?>> detailItemSelected;
    private final MutableLiveData<Boolean> isCovered;
    private final MutableLiveData<Unit> uploadFirstJumpDuration;

    public Search843DurationState() {
        this((MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, 7, (DefaultConstructorMarker) null);
    }

    public Search843DurationState(MutableLiveData<Boolean> isCovered2, MutableLiveData<ItemModel<?>> detailItemSelected2, MutableLiveData<Unit> uploadFirstJumpDuration2) {
        Intrinsics.checkNotNullParameter(isCovered2, "isCovered");
        Intrinsics.checkNotNullParameter(detailItemSelected2, "detailItemSelected");
        Intrinsics.checkNotNullParameter(uploadFirstJumpDuration2, "uploadFirstJumpDuration");
        this.isCovered = isCovered2;
        this.detailItemSelected = detailItemSelected2;
        this.uploadFirstJumpDuration = uploadFirstJumpDuration2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Search843DurationState(MutableLiveData mutableLiveData, MutableLiveData mutableLiveData2, MutableLiveData mutableLiveData3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new MutableLiveData() : mutableLiveData, (i2 & 2) != 0 ? new MutableLiveData() : mutableLiveData2, (i2 & 4) != 0 ? new MutableLiveData() : mutableLiveData3);
    }

    public final MutableLiveData<Boolean> isCovered() {
        return this.isCovered;
    }

    public final MutableLiveData<ItemModel<?>> getDetailItemSelected() {
        return this.detailItemSelected;
    }

    public final MutableLiveData<Unit> getUploadFirstJumpDuration() {
        return this.uploadFirstJumpDuration;
    }
}
