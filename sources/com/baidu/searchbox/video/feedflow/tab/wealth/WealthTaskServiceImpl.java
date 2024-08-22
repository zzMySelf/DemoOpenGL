package com.baidu.searchbox.video.feedflow.tab.wealth;

import com.baidu.searchbox.video.feedflow.tab.wealth.service.IWealthTaskService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/tab/wealth/WealthTaskServiceImpl;", "Lcom/baidu/searchbox/video/feedflow/tab/wealth/service/IWealthTaskService;", "component", "Lcom/baidu/searchbox/video/feedflow/tab/wealth/WealthTaskComponent;", "(Lcom/baidu/searchbox/video/feedflow/tab/wealth/WealthTaskComponent;)V", "cancelWealthVideoTask", "", "isNeedShowWealthTaskDialog", "", "isPauseFromDialog", "isScrollGuideDialogShowing", "isWealthTaskComponentShowing", "isWealthTaskDialogShowing", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WealthTaskServiceImpl.kt */
public final class WealthTaskServiceImpl implements IWealthTaskService {
    private final WealthTaskComponent component;

    public WealthTaskServiceImpl(WealthTaskComponent component2) {
        Intrinsics.checkNotNullParameter(component2, "component");
        this.component = component2;
    }

    public boolean isNeedShowWealthTaskDialog() {
        return this.component.isNeedShowWealthTaskDialog();
    }

    public boolean isScrollGuideDialogShowing() {
        return this.component.isScrollGuideDialogShowing();
    }

    public boolean isWealthTaskDialogShowing() {
        return this.component.isWealthTaskDialogShowing();
    }

    public boolean isPauseFromDialog() {
        return this.component.isPauseFromDialog();
    }

    public boolean isWealthTaskComponentShowing() {
        return this.component.wealthTaskIsVisible() || this.component.paymentTaskIsVisible();
    }

    public void cancelWealthVideoTask() {
        this.component.cancelWealthVideoTask();
    }
}
