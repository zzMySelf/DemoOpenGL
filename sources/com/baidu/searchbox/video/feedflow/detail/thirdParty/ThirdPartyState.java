package com.baidu.searchbox.video.feedflow.detail.thirdParty;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.flowvideo.detail.repos.ThirdLogModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\u0002\u0010\bR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\"\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/thirdParty/ThirdPartyState;", "", "hasReport", "", "hasDisPlayReport", "thirdLogModel", "Landroidx/lifecycle/MutableLiveData;", "Lcom/baidu/searchbox/flowvideo/detail/repos/ThirdLogModel;", "(ZZLandroidx/lifecycle/MutableLiveData;)V", "getHasDisPlayReport", "()Z", "setHasDisPlayReport", "(Z)V", "getHasReport", "setHasReport", "getThirdLogModel", "()Landroidx/lifecycle/MutableLiveData;", "setThirdLogModel", "(Landroidx/lifecycle/MutableLiveData;)V", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ThirdPartyState.kt */
public final class ThirdPartyState {
    private boolean hasDisPlayReport;
    private boolean hasReport;
    private MutableLiveData<ThirdLogModel> thirdLogModel;

    public ThirdPartyState() {
        this(false, false, (MutableLiveData) null, 7, (DefaultConstructorMarker) null);
    }

    public ThirdPartyState(boolean hasReport2, boolean hasDisPlayReport2, MutableLiveData<ThirdLogModel> thirdLogModel2) {
        Intrinsics.checkNotNullParameter(thirdLogModel2, "thirdLogModel");
        this.hasReport = hasReport2;
        this.hasDisPlayReport = hasDisPlayReport2;
        this.thirdLogModel = thirdLogModel2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ThirdPartyState(boolean z, boolean z2, MutableLiveData mutableLiveData, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? false : z2, (i2 & 4) != 0 ? new MutableLiveData() : mutableLiveData);
    }

    public final boolean getHasReport() {
        return this.hasReport;
    }

    public final void setHasReport(boolean z) {
        this.hasReport = z;
    }

    public final boolean getHasDisPlayReport() {
        return this.hasDisPlayReport;
    }

    public final void setHasDisPlayReport(boolean z) {
        this.hasDisPlayReport = z;
    }

    public final MutableLiveData<ThirdLogModel> getThirdLogModel() {
        return this.thirdLogModel;
    }

    public final void setThirdLogModel(MutableLiveData<ThirdLogModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.thirdLogModel = mutableLiveData;
    }
}
