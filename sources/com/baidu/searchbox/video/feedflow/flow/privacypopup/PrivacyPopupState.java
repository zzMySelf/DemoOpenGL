package com.baidu.searchbox.video.feedflow.flow.privacypopup;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\t\"\u0004\b\f\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/privacypopup/PrivacyPopupState;", "", "isShowing", "", "isHasShown", "onItemSelected", "Landroidx/lifecycle/MutableLiveData;", "", "(ZZLandroidx/lifecycle/MutableLiveData;)V", "()Z", "setHasShown", "(Z)V", "setShowing", "getOnItemSelected", "()Landroidx/lifecycle/MutableLiveData;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PrivacyPopupState.kt */
public final class PrivacyPopupState {
    private boolean isHasShown;
    private boolean isShowing;
    private final MutableLiveData<Unit> onItemSelected;

    public PrivacyPopupState() {
        this(false, false, (MutableLiveData) null, 7, (DefaultConstructorMarker) null);
    }

    public PrivacyPopupState(boolean isShowing2, boolean isHasShown2, MutableLiveData<Unit> onItemSelected2) {
        Intrinsics.checkNotNullParameter(onItemSelected2, "onItemSelected");
        this.isShowing = isShowing2;
        this.isHasShown = isHasShown2;
        this.onItemSelected = onItemSelected2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PrivacyPopupState(boolean z, boolean z2, MutableLiveData mutableLiveData, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? false : z2, (i2 & 4) != 0 ? new MutableLiveData() : mutableLiveData);
    }

    public final boolean isShowing() {
        return this.isShowing;
    }

    public final void setShowing(boolean z) {
        this.isShowing = z;
    }

    public final boolean isHasShown() {
        return this.isHasShown;
    }

    public final void setHasShown(boolean z) {
        this.isHasShown = z;
    }

    public final MutableLiveData<Unit> getOnItemSelected() {
        return this.onItemSelected;
    }
}
