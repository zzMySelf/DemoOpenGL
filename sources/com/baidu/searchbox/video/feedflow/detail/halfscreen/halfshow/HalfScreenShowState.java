package com.baidu.searchbox.video.feedflow.detail.halfscreen.halfshow;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001BE\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\bR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/halfscreen/halfshow/HalfScreenShowState;", "", "closeBtnClick", "Landroidx/lifecycle/MutableLiveData;", "", "itemOnPageSelected", "itemOnDetachFromScreen", "checkHalfState", "(Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;)V", "getCheckHalfState", "()Landroidx/lifecycle/MutableLiveData;", "getCloseBtnClick", "getItemOnDetachFromScreen", "getItemOnPageSelected", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HalfScreenShowState.kt */
public final class HalfScreenShowState {
    private final MutableLiveData<Unit> checkHalfState;
    private final MutableLiveData<Unit> closeBtnClick;
    private final MutableLiveData<Unit> itemOnDetachFromScreen;
    private final MutableLiveData<Unit> itemOnPageSelected;

    public HalfScreenShowState() {
        this((MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, 15, (DefaultConstructorMarker) null);
    }

    public HalfScreenShowState(MutableLiveData<Unit> closeBtnClick2, MutableLiveData<Unit> itemOnPageSelected2, MutableLiveData<Unit> itemOnDetachFromScreen2, MutableLiveData<Unit> checkHalfState2) {
        Intrinsics.checkNotNullParameter(closeBtnClick2, "closeBtnClick");
        Intrinsics.checkNotNullParameter(itemOnPageSelected2, "itemOnPageSelected");
        Intrinsics.checkNotNullParameter(itemOnDetachFromScreen2, "itemOnDetachFromScreen");
        Intrinsics.checkNotNullParameter(checkHalfState2, "checkHalfState");
        this.closeBtnClick = closeBtnClick2;
        this.itemOnPageSelected = itemOnPageSelected2;
        this.itemOnDetachFromScreen = itemOnDetachFromScreen2;
        this.checkHalfState = checkHalfState2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HalfScreenShowState(MutableLiveData mutableLiveData, MutableLiveData mutableLiveData2, MutableLiveData mutableLiveData3, MutableLiveData mutableLiveData4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new MutableLiveData() : mutableLiveData, (i2 & 2) != 0 ? new MutableLiveData() : mutableLiveData2, (i2 & 4) != 0 ? new MutableLiveData() : mutableLiveData3, (i2 & 8) != 0 ? new MutableLiveData() : mutableLiveData4);
    }

    public final MutableLiveData<Unit> getCloseBtnClick() {
        return this.closeBtnClick;
    }

    public final MutableLiveData<Unit> getItemOnPageSelected() {
        return this.itemOnPageSelected;
    }

    public final MutableLiveData<Unit> getItemOnDetachFromScreen() {
        return this.itemOnDetachFromScreen;
    }

    public final MutableLiveData<Unit> getCheckHalfState() {
        return this.checkHalfState;
    }
}
