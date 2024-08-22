package com.baidu.searchbox.video.feedflow.flow.collection;

import com.baidu.searchbox.NoProGuard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/collection/LandscapePanelAutoplayModel;", "Lcom/baidu/searchbox/NoProGuard;", "enableAutoplayRelate", "", "enableAutoplayCollection", "enableAutoplayHome", "(ZZZ)V", "getEnableAutoplayCollection", "()Z", "getEnableAutoplayHome", "getEnableAutoplayRelate", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionPanelState.kt */
public final class LandscapePanelAutoplayModel implements NoProGuard {
    private final boolean enableAutoplayCollection;
    private final boolean enableAutoplayHome;
    private final boolean enableAutoplayRelate;

    public LandscapePanelAutoplayModel() {
        this(false, false, false, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ LandscapePanelAutoplayModel copy$default(LandscapePanelAutoplayModel landscapePanelAutoplayModel, boolean z, boolean z2, boolean z3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = landscapePanelAutoplayModel.enableAutoplayRelate;
        }
        if ((i2 & 2) != 0) {
            z2 = landscapePanelAutoplayModel.enableAutoplayCollection;
        }
        if ((i2 & 4) != 0) {
            z3 = landscapePanelAutoplayModel.enableAutoplayHome;
        }
        return landscapePanelAutoplayModel.copy(z, z2, z3);
    }

    public final boolean component1() {
        return this.enableAutoplayRelate;
    }

    public final boolean component2() {
        return this.enableAutoplayCollection;
    }

    public final boolean component3() {
        return this.enableAutoplayHome;
    }

    public final LandscapePanelAutoplayModel copy(boolean z, boolean z2, boolean z3) {
        return new LandscapePanelAutoplayModel(z, z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LandscapePanelAutoplayModel)) {
            return false;
        }
        LandscapePanelAutoplayModel landscapePanelAutoplayModel = (LandscapePanelAutoplayModel) obj;
        return this.enableAutoplayRelate == landscapePanelAutoplayModel.enableAutoplayRelate && this.enableAutoplayCollection == landscapePanelAutoplayModel.enableAutoplayCollection && this.enableAutoplayHome == landscapePanelAutoplayModel.enableAutoplayHome;
    }

    public int hashCode() {
        boolean z = this.enableAutoplayRelate;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        boolean z3 = this.enableAutoplayCollection;
        if (z3) {
            z3 = true;
        }
        int i3 = (i2 + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.enableAutoplayHome;
        if (!z4) {
            z2 = z4;
        }
        return i3 + (z2 ? 1 : 0);
    }

    public String toString() {
        return "LandscapePanelAutoplayModel(enableAutoplayRelate=" + this.enableAutoplayRelate + ", enableAutoplayCollection=" + this.enableAutoplayCollection + ", enableAutoplayHome=" + this.enableAutoplayHome + ')';
    }

    public LandscapePanelAutoplayModel(boolean enableAutoplayRelate2, boolean enableAutoplayCollection2, boolean enableAutoplayHome2) {
        this.enableAutoplayRelate = enableAutoplayRelate2;
        this.enableAutoplayCollection = enableAutoplayCollection2;
        this.enableAutoplayHome = enableAutoplayHome2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LandscapePanelAutoplayModel(boolean z, boolean z2, boolean z3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? false : z2, (i2 & 4) != 0 ? false : z3);
    }

    public final boolean getEnableAutoplayRelate() {
        return this.enableAutoplayRelate;
    }

    public final boolean getEnableAutoplayCollection() {
        return this.enableAutoplayCollection;
    }

    public final boolean getEnableAutoplayHome() {
        return this.enableAutoplayHome;
    }
}
