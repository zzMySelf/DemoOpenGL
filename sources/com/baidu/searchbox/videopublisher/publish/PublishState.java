package com.baidu.searchbox.videopublisher.publish;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B5\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J9\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/videopublisher/publish/PublishState;", "", "publish", "Landroidx/lifecycle/MutableLiveData;", "", "collect", "numLimit", "(Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;)V", "getCollect", "()Landroidx/lifecycle/MutableLiveData;", "getNumLimit", "getPublish", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "lib-publisher-video_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PublishState.kt */
public final class PublishState {
    private final MutableLiveData<Unit> collect;
    private final MutableLiveData<Unit> numLimit;
    private final MutableLiveData<Unit> publish;

    public PublishState() {
        this((MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PublishState copy$default(PublishState publishState, MutableLiveData<Unit> mutableLiveData, MutableLiveData<Unit> mutableLiveData2, MutableLiveData<Unit> mutableLiveData3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            mutableLiveData = publishState.publish;
        }
        if ((i2 & 2) != 0) {
            mutableLiveData2 = publishState.collect;
        }
        if ((i2 & 4) != 0) {
            mutableLiveData3 = publishState.numLimit;
        }
        return publishState.copy(mutableLiveData, mutableLiveData2, mutableLiveData3);
    }

    public final MutableLiveData<Unit> component1() {
        return this.publish;
    }

    public final MutableLiveData<Unit> component2() {
        return this.collect;
    }

    public final MutableLiveData<Unit> component3() {
        return this.numLimit;
    }

    public final PublishState copy(MutableLiveData<Unit> mutableLiveData, MutableLiveData<Unit> mutableLiveData2, MutableLiveData<Unit> mutableLiveData3) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "publish");
        Intrinsics.checkNotNullParameter(mutableLiveData2, "collect");
        Intrinsics.checkNotNullParameter(mutableLiveData3, "numLimit");
        return new PublishState(mutableLiveData, mutableLiveData2, mutableLiveData3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PublishState)) {
            return false;
        }
        PublishState publishState = (PublishState) obj;
        return Intrinsics.areEqual((Object) this.publish, (Object) publishState.publish) && Intrinsics.areEqual((Object) this.collect, (Object) publishState.collect) && Intrinsics.areEqual((Object) this.numLimit, (Object) publishState.numLimit);
    }

    public int hashCode() {
        return (((this.publish.hashCode() * 31) + this.collect.hashCode()) * 31) + this.numLimit.hashCode();
    }

    public String toString() {
        return "PublishState(publish=" + this.publish + ", collect=" + this.collect + ", numLimit=" + this.numLimit + ')';
    }

    public PublishState(MutableLiveData<Unit> publish2, MutableLiveData<Unit> collect2, MutableLiveData<Unit> numLimit2) {
        Intrinsics.checkNotNullParameter(publish2, "publish");
        Intrinsics.checkNotNullParameter(collect2, "collect");
        Intrinsics.checkNotNullParameter(numLimit2, "numLimit");
        this.publish = publish2;
        this.collect = collect2;
        this.numLimit = numLimit2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PublishState(MutableLiveData mutableLiveData, MutableLiveData mutableLiveData2, MutableLiveData mutableLiveData3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new MutableLiveData() : mutableLiveData, (i2 & 2) != 0 ? new MutableLiveData() : mutableLiveData2, (i2 & 4) != 0 ? new MutableLiveData() : mutableLiveData3);
    }

    public final MutableLiveData<Unit> getPublish() {
        return this.publish;
    }

    public final MutableLiveData<Unit> getCollect() {
        return this.collect;
    }

    public final MutableLiveData<Unit> getNumLimit() {
        return this.numLimit;
    }
}
