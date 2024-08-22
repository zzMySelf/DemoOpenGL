package com.baidu.searchbox.video.feedflow.detail.shortplay;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\rR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/shortplay/ShortPlayWatchingTabOrFlowState;", "", "()V", "shortPlayCount", "", "getShortPlayCount", "()I", "setShortPlayCount", "(I)V", "addShortPlayCount", "", "clearShortPlayCount", "isCoverLimitPlayCount", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShortPlayWatchingTabOrFlowState.kt */
public final class ShortPlayWatchingTabOrFlowState {
    private int shortPlayCount;

    public final int getShortPlayCount() {
        return this.shortPlayCount;
    }

    public final void setShortPlayCount(int i2) {
        this.shortPlayCount = i2;
    }

    public final void clearShortPlayCount() {
        this.shortPlayCount = 0;
    }

    public final void addShortPlayCount() {
        this.shortPlayCount++;
    }

    public final boolean isCoverLimitPlayCount() {
        return this.shortPlayCount >= 10;
    }
}
