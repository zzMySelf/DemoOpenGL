package com.baidu.searchbox.video.feedflow.ad.ecommerce;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/ecommerce/AdECommercePopVisibilityState;", "", "isVisible", "Landroidx/lifecycle/MutableLiveData;", "", "(Landroidx/lifecycle/MutableLiveData;)V", "()Landroidx/lifecycle/MutableLiveData;", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AdECommercePopVisibilityState.kt */
public final class AdECommercePopVisibilityState {
    private final MutableLiveData<Boolean> isVisible;

    public AdECommercePopVisibilityState() {
        this((MutableLiveData) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AdECommercePopVisibilityState copy$default(AdECommercePopVisibilityState adECommercePopVisibilityState, MutableLiveData<Boolean> mutableLiveData, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            mutableLiveData = adECommercePopVisibilityState.isVisible;
        }
        return adECommercePopVisibilityState.copy(mutableLiveData);
    }

    public final MutableLiveData<Boolean> component1() {
        return this.isVisible;
    }

    public final AdECommercePopVisibilityState copy(MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "isVisible");
        return new AdECommercePopVisibilityState(mutableLiveData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AdECommercePopVisibilityState) && Intrinsics.areEqual((Object) this.isVisible, (Object) ((AdECommercePopVisibilityState) obj).isVisible);
    }

    public int hashCode() {
        return this.isVisible.hashCode();
    }

    public String toString() {
        return "AdECommercePopVisibilityState(isVisible=" + this.isVisible + ')';
    }

    public AdECommercePopVisibilityState(MutableLiveData<Boolean> isVisible2) {
        Intrinsics.checkNotNullParameter(isVisible2, "isVisible");
        this.isVisible = isVisible2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdECommercePopVisibilityState(MutableLiveData mutableLiveData, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new MutableLiveData(true) : mutableLiveData);
    }

    public final MutableLiveData<Boolean> isVisible() {
        return this.isVisible;
    }
}
