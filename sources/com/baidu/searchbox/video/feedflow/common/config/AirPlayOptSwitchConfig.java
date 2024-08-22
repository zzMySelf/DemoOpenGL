package com.baidu.searchbox.video.feedflow.common.config;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/common/config/AirPlayOptSwitchConfig;", "", "airPlaySeamlessSwitch", "", "airPlayAutoFindSwitch", "airPlayAutoFindVideoDurationLimit", "", "exitAirPlayShowMenuGuideSwitch", "(ZZIZ)V", "getAirPlayAutoFindSwitch", "()Z", "getAirPlayAutoFindVideoDurationLimit", "()I", "getAirPlaySeamlessSwitch", "getExitAirPlayShowMenuGuideSwitch", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AirPlayOptSwitchConfig.kt */
public final class AirPlayOptSwitchConfig {
    private final boolean airPlayAutoFindSwitch;
    private final int airPlayAutoFindVideoDurationLimit;
    private final boolean airPlaySeamlessSwitch;
    private final boolean exitAirPlayShowMenuGuideSwitch;

    public AirPlayOptSwitchConfig() {
        this(false, false, 0, false, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AirPlayOptSwitchConfig copy$default(AirPlayOptSwitchConfig airPlayOptSwitchConfig, boolean z, boolean z2, int i2, boolean z3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = airPlayOptSwitchConfig.airPlaySeamlessSwitch;
        }
        if ((i3 & 2) != 0) {
            z2 = airPlayOptSwitchConfig.airPlayAutoFindSwitch;
        }
        if ((i3 & 4) != 0) {
            i2 = airPlayOptSwitchConfig.airPlayAutoFindVideoDurationLimit;
        }
        if ((i3 & 8) != 0) {
            z3 = airPlayOptSwitchConfig.exitAirPlayShowMenuGuideSwitch;
        }
        return airPlayOptSwitchConfig.copy(z, z2, i2, z3);
    }

    public final boolean component1() {
        return this.airPlaySeamlessSwitch;
    }

    public final boolean component2() {
        return this.airPlayAutoFindSwitch;
    }

    public final int component3() {
        return this.airPlayAutoFindVideoDurationLimit;
    }

    public final boolean component4() {
        return this.exitAirPlayShowMenuGuideSwitch;
    }

    public final AirPlayOptSwitchConfig copy(boolean z, boolean z2, int i2, boolean z3) {
        return new AirPlayOptSwitchConfig(z, z2, i2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AirPlayOptSwitchConfig)) {
            return false;
        }
        AirPlayOptSwitchConfig airPlayOptSwitchConfig = (AirPlayOptSwitchConfig) obj;
        return this.airPlaySeamlessSwitch == airPlayOptSwitchConfig.airPlaySeamlessSwitch && this.airPlayAutoFindSwitch == airPlayOptSwitchConfig.airPlayAutoFindSwitch && this.airPlayAutoFindVideoDurationLimit == airPlayOptSwitchConfig.airPlayAutoFindVideoDurationLimit && this.exitAirPlayShowMenuGuideSwitch == airPlayOptSwitchConfig.exitAirPlayShowMenuGuideSwitch;
    }

    public int hashCode() {
        boolean z = this.airPlaySeamlessSwitch;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        boolean z3 = this.airPlayAutoFindSwitch;
        if (z3) {
            z3 = true;
        }
        int hashCode = (((i2 + (z3 ? 1 : 0)) * 31) + Integer.hashCode(this.airPlayAutoFindVideoDurationLimit)) * 31;
        boolean z4 = this.exitAirPlayShowMenuGuideSwitch;
        if (!z4) {
            z2 = z4;
        }
        return hashCode + (z2 ? 1 : 0);
    }

    public String toString() {
        return "AirPlayOptSwitchConfig(airPlaySeamlessSwitch=" + this.airPlaySeamlessSwitch + ", airPlayAutoFindSwitch=" + this.airPlayAutoFindSwitch + ", airPlayAutoFindVideoDurationLimit=" + this.airPlayAutoFindVideoDurationLimit + ", exitAirPlayShowMenuGuideSwitch=" + this.exitAirPlayShowMenuGuideSwitch + ')';
    }

    public AirPlayOptSwitchConfig(boolean airPlaySeamlessSwitch2, boolean airPlayAutoFindSwitch2, int airPlayAutoFindVideoDurationLimit2, boolean exitAirPlayShowMenuGuideSwitch2) {
        this.airPlaySeamlessSwitch = airPlaySeamlessSwitch2;
        this.airPlayAutoFindSwitch = airPlayAutoFindSwitch2;
        this.airPlayAutoFindVideoDurationLimit = airPlayAutoFindVideoDurationLimit2;
        this.exitAirPlayShowMenuGuideSwitch = exitAirPlayShowMenuGuideSwitch2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AirPlayOptSwitchConfig(boolean z, boolean z2, int i2, boolean z3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z, (i3 & 2) != 0 ? false : z2, (i3 & 4) != 0 ? 0 : i2, (i3 & 8) != 0 ? false : z3);
    }

    public final boolean getAirPlaySeamlessSwitch() {
        return this.airPlaySeamlessSwitch;
    }

    public final boolean getAirPlayAutoFindSwitch() {
        return this.airPlayAutoFindSwitch;
    }

    public final int getAirPlayAutoFindVideoDurationLimit() {
        return this.airPlayAutoFindVideoDurationLimit;
    }

    public final boolean getExitAirPlayShowMenuGuideSwitch() {
        return this.exitAirPlayShowMenuGuideSwitch;
    }
}
