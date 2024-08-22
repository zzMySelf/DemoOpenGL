package com.baidu.searchbox.video.feedflow.detail.longoressnewmenu.service;

import com.baidu.searchbox.video.feedflow.detail.longoressnewmenu.menu.LongPressNewMenuPanelPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/longoressnewmenu/service/LongPressNewMenuPanelService;", "Lcom/baidu/searchbox/video/feedflow/detail/longoressnewmenu/service/ILongPressNewMenuPanelService;", "component", "Lcom/baidu/searchbox/video/feedflow/detail/longoressnewmenu/menu/LongPressNewMenuPanelPlugin;", "(Lcom/baidu/searchbox/video/feedflow/detail/longoressnewmenu/menu/LongPressNewMenuPanelPlugin;)V", "getComponent", "()Lcom/baidu/searchbox/video/feedflow/detail/longoressnewmenu/menu/LongPressNewMenuPanelPlugin;", "isMenuPanelShowing", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LongPressNewMenuPanelService.kt */
public final class LongPressNewMenuPanelService implements ILongPressNewMenuPanelService {
    private final LongPressNewMenuPanelPlugin component;

    public LongPressNewMenuPanelService(LongPressNewMenuPanelPlugin component2) {
        Intrinsics.checkNotNullParameter(component2, "component");
        this.component = component2;
    }

    public final LongPressNewMenuPanelPlugin getComponent() {
        return this.component;
    }

    public boolean isMenuPanelShowing() {
        return this.component.isNewMenuPanelShowing();
    }
}
