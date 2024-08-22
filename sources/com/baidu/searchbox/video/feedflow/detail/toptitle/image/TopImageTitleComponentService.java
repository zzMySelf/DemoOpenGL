package com.baidu.searchbox.video.feedflow.detail.toptitle.image;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/toptitle/image/TopImageTitleComponentService;", "Lcom/baidu/searchbox/video/feedflow/detail/toptitle/image/ITopImageTitleService;", "component", "Lcom/baidu/searchbox/video/feedflow/detail/toptitle/image/TopImageTitleComponent;", "(Lcom/baidu/searchbox/video/feedflow/detail/toptitle/image/TopImageTitleComponent;)V", "getComponent", "()Lcom/baidu/searchbox/video/feedflow/detail/toptitle/image/TopImageTitleComponent;", "getPlayerContainerBackgroundUrl", "", "setVisible", "", "visible", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TopImageTitleComponentService.kt */
public final class TopImageTitleComponentService implements ITopImageTitleService {
    private final TopImageTitleComponent component;

    public TopImageTitleComponentService(TopImageTitleComponent component2) {
        Intrinsics.checkNotNullParameter(component2, "component");
        this.component = component2;
    }

    public final TopImageTitleComponent getComponent() {
        return this.component;
    }

    public String getPlayerContainerBackgroundUrl() {
        return this.component.getPlayerContainerBackgroundUrl();
    }

    public void setVisible(boolean visible) {
        this.component.setVisible(visible);
    }
}
