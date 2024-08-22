package com.baidu.searchbox.feed.payment.training;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006\u001a\n\u0010\u0007\u001a\u00020\u0005*\u00020\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"PANEL_CLOSE_ENTER_FAIL", "", "PANEL_CLOSE_ENTER_SUCCESS", "PANEL_CLOSE_NORMAL", "panelCloseFromNext", "", "Lcom/baidu/searchbox/feed/payment/training/CampCallback;", "panelCloseFromX", "lib-feed-spcolumn_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: TrainEnterManager.kt */
public final class TrainEnterManagerKt {
    public static final String PANEL_CLOSE_ENTER_FAIL = "1";
    public static final String PANEL_CLOSE_ENTER_SUCCESS = "2";
    public static final String PANEL_CLOSE_NORMAL = "0";

    public static final void panelCloseFromX(CampCallback $this$panelCloseFromX) {
        Intrinsics.checkNotNullParameter($this$panelCloseFromX, "<this>");
        $this$panelCloseFromX.onPanelClose("contact_panel_close");
    }

    public static final void panelCloseFromNext(CampCallback $this$panelCloseFromNext) {
        Intrinsics.checkNotNullParameter($this$panelCloseFromNext, "<this>");
        $this$panelCloseFromNext.onPanelClose("no_enter_camp_clk");
    }
}
