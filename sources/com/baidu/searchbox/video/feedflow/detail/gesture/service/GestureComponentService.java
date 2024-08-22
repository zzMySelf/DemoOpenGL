package com.baidu.searchbox.video.feedflow.detail.gesture.service;

import android.widget.FrameLayout;
import com.baidu.searchbox.video.feedflow.detail.gesture.GestureComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/gesture/service/GestureComponentService;", "Lcom/baidu/searchbox/video/feedflow/detail/gesture/service/IGestureService;", "component", "Lcom/baidu/searchbox/video/feedflow/detail/gesture/GestureComponent;", "(Lcom/baidu/searchbox/video/feedflow/detail/gesture/GestureComponent;)V", "getComponent", "()Lcom/baidu/searchbox/video/feedflow/detail/gesture/GestureComponent;", "moveView", "", "viewGroup", "Landroid/widget/FrameLayout;", "returnView", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GestureComponentService.kt */
public final class GestureComponentService implements IGestureService {
    private final GestureComponent component;

    public GestureComponentService(GestureComponent component2) {
        Intrinsics.checkNotNullParameter(component2, "component");
        this.component = component2;
    }

    public final GestureComponent getComponent() {
        return this.component;
    }

    public void moveView(FrameLayout viewGroup) {
        this.component.moveView(viewGroup);
    }

    public void returnView() {
        this.component.returnView();
    }
}
