package com.baidu.searchbox.video.feedflow.flow.launchpanel;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/launchpanel/LaunchSettingPanelShowCondition;", "", "playTimes", "", "playPercent", "(II)V", "getPlayPercent", "()I", "getPlayTimes", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LaunchSettingPanelState.kt */
public final class LaunchSettingPanelShowCondition {
    private final int playPercent;
    private final int playTimes;

    public static /* synthetic */ LaunchSettingPanelShowCondition copy$default(LaunchSettingPanelShowCondition launchSettingPanelShowCondition, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = launchSettingPanelShowCondition.playTimes;
        }
        if ((i4 & 2) != 0) {
            i3 = launchSettingPanelShowCondition.playPercent;
        }
        return launchSettingPanelShowCondition.copy(i2, i3);
    }

    public final int component1() {
        return this.playTimes;
    }

    public final int component2() {
        return this.playPercent;
    }

    public final LaunchSettingPanelShowCondition copy(int i2, int i3) {
        return new LaunchSettingPanelShowCondition(i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LaunchSettingPanelShowCondition)) {
            return false;
        }
        LaunchSettingPanelShowCondition launchSettingPanelShowCondition = (LaunchSettingPanelShowCondition) obj;
        return this.playTimes == launchSettingPanelShowCondition.playTimes && this.playPercent == launchSettingPanelShowCondition.playPercent;
    }

    public int hashCode() {
        return (Integer.hashCode(this.playTimes) * 31) + Integer.hashCode(this.playPercent);
    }

    public String toString() {
        return "LaunchSettingPanelShowCondition(playTimes=" + this.playTimes + ", playPercent=" + this.playPercent + ')';
    }

    public LaunchSettingPanelShowCondition(int playTimes2, int playPercent2) {
        this.playTimes = playTimes2;
        this.playPercent = playPercent2;
    }

    public final int getPlayPercent() {
        return this.playPercent;
    }

    public final int getPlayTimes() {
        return this.playTimes;
    }
}
