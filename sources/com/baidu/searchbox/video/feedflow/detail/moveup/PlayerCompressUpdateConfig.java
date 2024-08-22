package com.baidu.searchbox.video.feedflow.detail.moveup;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J5\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/moveup/PlayerCompressUpdateConfig;", "", "switch", "", "sandwichVideoSwitch", "miniWHSize", "Lkotlin/Pair;", "", "(ZZLkotlin/Pair;)V", "getMiniWHSize", "()Lkotlin/Pair;", "getSandwichVideoSwitch", "()Z", "getSwitch", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MoveUpAnimationPlugin.kt */
public final class PlayerCompressUpdateConfig {
    private final Pair<Integer, Integer> miniWHSize;
    private final boolean sandwichVideoSwitch;

    /* renamed from: switch  reason: not valid java name */
    private final boolean f1112switch;

    public PlayerCompressUpdateConfig() {
        this(false, false, (Pair) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PlayerCompressUpdateConfig copy$default(PlayerCompressUpdateConfig playerCompressUpdateConfig, boolean z, boolean z2, Pair<Integer, Integer> pair, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = playerCompressUpdateConfig.f1112switch;
        }
        if ((i2 & 2) != 0) {
            z2 = playerCompressUpdateConfig.sandwichVideoSwitch;
        }
        if ((i2 & 4) != 0) {
            pair = playerCompressUpdateConfig.miniWHSize;
        }
        return playerCompressUpdateConfig.copy(z, z2, pair);
    }

    public final boolean component1() {
        return this.f1112switch;
    }

    public final boolean component2() {
        return this.sandwichVideoSwitch;
    }

    public final Pair<Integer, Integer> component3() {
        return this.miniWHSize;
    }

    public final PlayerCompressUpdateConfig copy(boolean z, boolean z2, Pair<Integer, Integer> pair) {
        return new PlayerCompressUpdateConfig(z, z2, pair);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayerCompressUpdateConfig)) {
            return false;
        }
        PlayerCompressUpdateConfig playerCompressUpdateConfig = (PlayerCompressUpdateConfig) obj;
        return this.f1112switch == playerCompressUpdateConfig.f1112switch && this.sandwichVideoSwitch == playerCompressUpdateConfig.sandwichVideoSwitch && Intrinsics.areEqual((Object) this.miniWHSize, (Object) playerCompressUpdateConfig.miniWHSize);
    }

    public int hashCode() {
        boolean z = this.f1112switch;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        boolean z3 = this.sandwichVideoSwitch;
        if (!z3) {
            z2 = z3;
        }
        int i3 = (i2 + (z2 ? 1 : 0)) * 31;
        Pair<Integer, Integer> pair = this.miniWHSize;
        return i3 + (pair == null ? 0 : pair.hashCode());
    }

    public String toString() {
        return "PlayerCompressUpdateConfig(switch=" + this.f1112switch + ", sandwichVideoSwitch=" + this.sandwichVideoSwitch + ", miniWHSize=" + this.miniWHSize + ')';
    }

    public PlayerCompressUpdateConfig(boolean z, boolean sandwichVideoSwitch2, Pair<Integer, Integer> miniWHSize2) {
        this.f1112switch = z;
        this.sandwichVideoSwitch = sandwichVideoSwitch2;
        this.miniWHSize = miniWHSize2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PlayerCompressUpdateConfig(boolean z, boolean z2, Pair pair, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? false : z2, (i2 & 4) != 0 ? null : pair);
    }

    public final boolean getSwitch() {
        return this.f1112switch;
    }

    public final boolean getSandwichVideoSwitch() {
        return this.sandwichVideoSwitch;
    }

    public final Pair<Integer, Integer> getMiniWHSize() {
        return this.miniWHSize;
    }
}
