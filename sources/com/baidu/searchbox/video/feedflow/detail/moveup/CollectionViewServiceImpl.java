package com.baidu.searchbox.video.feedflow.detail.moveup;

import com.baidu.searchbox.video.feedflow.flow.collection.service.ICollectionPanelViewService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/moveup/CollectionViewServiceImpl;", "Lcom/baidu/searchbox/video/feedflow/flow/collection/service/ICollectionPanelViewService;", "component", "Lcom/baidu/searchbox/video/feedflow/detail/moveup/MoveUpAnimationPlugin;", "(Lcom/baidu/searchbox/video/feedflow/detail/moveup/MoveUpAnimationPlugin;)V", "getComponent", "()Lcom/baidu/searchbox/video/feedflow/detail/moveup/MoveUpAnimationPlugin;", "getVerticalPopupPanelHeight", "", "()Ljava/lang/Integer;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionViewServiceImpl.kt */
public final class CollectionViewServiceImpl implements ICollectionPanelViewService {
    private final MoveUpAnimationPlugin component;

    public CollectionViewServiceImpl(MoveUpAnimationPlugin component2) {
        Intrinsics.checkNotNullParameter(component2, "component");
        this.component = component2;
    }

    public final MoveUpAnimationPlugin getComponent() {
        return this.component;
    }

    public Integer getVerticalPopupPanelHeight() {
        return this.component.getPanelHeight();
    }
}
