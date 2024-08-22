package com.baidu.searchbox.video.feedflow.detail.longoressnewmenu.service;

import android.view.MotionEvent;
import com.baidu.searchbox.video.feedflow.detail.longoressnewmenu.LongPressNewGuidePlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/longoressnewmenu/service/LongPressNewNewMenuService;", "Lcom/baidu/searchbox/video/feedflow/detail/longoressnewmenu/service/ILongPressNewMenuService;", "component", "Lcom/baidu/searchbox/video/feedflow/detail/longoressnewmenu/LongPressNewGuidePlugin;", "(Lcom/baidu/searchbox/video/feedflow/detail/longoressnewmenu/LongPressNewGuidePlugin;)V", "getComponent", "()Lcom/baidu/searchbox/video/feedflow/detail/longoressnewmenu/LongPressNewGuidePlugin;", "consumeEvent", "", "event", "Landroid/view/MotionEvent;", "isMenuShowing", "onPress", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LongPressNewNewMenuService.kt */
public final class LongPressNewNewMenuService implements ILongPressNewMenuService {
    private final LongPressNewGuidePlugin component;

    public LongPressNewNewMenuService(LongPressNewGuidePlugin component2) {
        Intrinsics.checkNotNullParameter(component2, "component");
        this.component = component2;
    }

    public final LongPressNewGuidePlugin getComponent() {
        return this.component;
    }

    public boolean onPress(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return this.component.onPress(event);
    }

    public boolean consumeEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return this.component.consumeEvent(event);
    }

    public boolean isMenuShowing() {
        return this.component.isLongGuideShowing();
    }
}
