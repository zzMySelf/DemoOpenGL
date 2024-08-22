package com.baidu.searchbox.feed.tab.newtip;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\b¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/feed/tab/newtip/AttenTabNewTipManager;", "", "()V", "canShow", "", "getCanShow", "()Z", "setCanShow", "(Z)V", "isShowing", "setShowing", "onDestroy", "", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AttenTabNewTipManager.kt */
public final class AttenTabNewTipManager {
    public static final AttenTabNewTipManager INSTANCE = new AttenTabNewTipManager();
    private static boolean canShow;
    private static boolean isShowing;

    private AttenTabNewTipManager() {
    }

    public final boolean getCanShow() {
        return canShow;
    }

    public final void setCanShow(boolean z) {
        canShow = z;
    }

    public final boolean isShowing() {
        return isShowing;
    }

    public final void setShowing(boolean z) {
        isShowing = z;
    }

    public final void onDestroy() {
        canShow = false;
    }
}
