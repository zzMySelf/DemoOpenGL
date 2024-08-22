package com.baidu.searchbox.flowvideo.detail.repos;

import com.baidu.searchbox.NoProGuard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/flowvideo/detail/repos/ThirdLogModel;", "Lcom/baidu/searchbox/NoProGuard;", "type", "", "delay", "", "ext", "(Ljava/lang/String;ILjava/lang/String;)V", "getDelay", "()I", "setDelay", "(I)V", "getExt", "()Ljava/lang/String;", "getType", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowDetailModel.kt */
public final class ThirdLogModel implements NoProGuard {
    private int delay;
    private final String ext;
    private final String type;

    public ThirdLogModel() {
        this((String) null, 0, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ThirdLogModel copy$default(ThirdLogModel thirdLogModel, String str, int i2, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = thirdLogModel.type;
        }
        if ((i3 & 2) != 0) {
            i2 = thirdLogModel.delay;
        }
        if ((i3 & 4) != 0) {
            str2 = thirdLogModel.ext;
        }
        return thirdLogModel.copy(str, i2, str2);
    }

    public final String component1() {
        return this.type;
    }

    public final int component2() {
        return this.delay;
    }

    public final String component3() {
        return this.ext;
    }

    public final ThirdLogModel copy(String str, int i2, String str2) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, "ext");
        return new ThirdLogModel(str, i2, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ThirdLogModel)) {
            return false;
        }
        ThirdLogModel thirdLogModel = (ThirdLogModel) obj;
        return Intrinsics.areEqual((Object) this.type, (Object) thirdLogModel.type) && this.delay == thirdLogModel.delay && Intrinsics.areEqual((Object) this.ext, (Object) thirdLogModel.ext);
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + Integer.hashCode(this.delay)) * 31) + this.ext.hashCode();
    }

    public String toString() {
        return "ThirdLogModel(type=" + this.type + ", delay=" + this.delay + ", ext=" + this.ext + ')';
    }

    public ThirdLogModel(String type2, int delay2, String ext2) {
        Intrinsics.checkNotNullParameter(type2, "type");
        Intrinsics.checkNotNullParameter(ext2, "ext");
        this.type = type2;
        this.delay = delay2;
        this.ext = ext2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ThirdLogModel(String str, int i2, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? "" : str2);
    }

    public final String getType() {
        return this.type;
    }

    public final int getDelay() {
        return this.delay;
    }

    public final void setDelay(int i2) {
        this.delay = i2;
    }

    public final String getExt() {
        return this.ext;
    }
}
