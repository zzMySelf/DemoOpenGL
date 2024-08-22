package com.baidu.searchbox.home.feed.container.action;

import com.baidu.texas.context.Action;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0005\"\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/home/feed/container/action/NightModeChangedAction;", "Lcom/baidu/texas/context/Action;", "isNightMode", "", "(Z)V", "()Z", "setNightMode", "lib-feed-home_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Actions.kt */
public final class NightModeChangedAction implements Action {
    private boolean isNightMode;

    public NightModeChangedAction(boolean isNightMode2) {
        this.isNightMode = isNightMode2;
    }

    public final boolean isNightMode() {
        return this.isNightMode;
    }

    public final void setNightMode(boolean z) {
        this.isNightMode = z;
    }
}
