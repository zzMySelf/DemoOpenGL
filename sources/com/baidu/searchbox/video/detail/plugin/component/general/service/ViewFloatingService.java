package com.baidu.searchbox.video.detail.plugin.component.general.service;

import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.video.detail.plugin.component.general.ViewFloatingComponent;
import com.baidu.searchbox.video.detail.service.IViewFloatingService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nH\u0016J \u0010\u0015\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\nH\u0016J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\nH\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001c"}, d2 = {"Lcom/baidu/searchbox/video/detail/plugin/component/general/service/ViewFloatingService;", "Lcom/baidu/searchbox/video/detail/service/IViewFloatingService;", "component", "Lcom/baidu/searchbox/video/detail/plugin/component/general/ViewFloatingComponent;", "(Lcom/baidu/searchbox/video/detail/plugin/component/general/ViewFloatingComponent;)V", "getComponent", "()Lcom/baidu/searchbox/video/detail/plugin/component/general/ViewFloatingComponent;", "getName", "", "getViewHeight", "", "onPositionChanged", "", "currentPosition", "endPosition", "isUp", "", "onScrollStateChanged", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "onScrolled", "dx", "dy", "onSwapView", "isTop", "setVisibility", "visibility", "lib-detail-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ViewFloatingService.kt */
public final class ViewFloatingService implements IViewFloatingService {
    private final ViewFloatingComponent component;

    public ViewFloatingService(ViewFloatingComponent component2) {
        this.component = component2;
    }

    public final ViewFloatingComponent getComponent() {
        return this.component;
    }

    public String getName() {
        String name = ViewFloatingService.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "ViewFloatingService::class.java.name");
        return name;
    }

    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        ViewFloatingComponent viewFloatingComponent = this.component;
        if (viewFloatingComponent != null) {
            viewFloatingComponent.onScrolled(recyclerView, dx, dy);
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        ViewFloatingComponent viewFloatingComponent = this.component;
        if (viewFloatingComponent != null) {
            viewFloatingComponent.onScrollStateChanged(recyclerView, newState);
        }
    }

    public void onSwapView(boolean isTop) {
        ViewFloatingComponent viewFloatingComponent = this.component;
        if (viewFloatingComponent != null) {
            viewFloatingComponent.onSwapView(isTop);
        }
    }

    public int getViewHeight() {
        ViewFloatingComponent viewFloatingComponent = this.component;
        if (viewFloatingComponent != null) {
            return viewFloatingComponent.getViewHeight();
        }
        return 0;
    }

    public void onPositionChanged(int currentPosition, int endPosition, boolean isUp) {
        ViewFloatingComponent viewFloatingComponent = this.component;
        if (viewFloatingComponent != null) {
            viewFloatingComponent.onPositionChanged(currentPosition, endPosition, isUp);
        }
    }

    public void setVisibility(int visibility) {
        ViewFloatingComponent viewFloatingComponent = this.component;
        if (viewFloatingComponent != null) {
            viewFloatingComponent.setVisibility(visibility);
        }
    }
}
