package com.baidu.searchbox.feed.detail.util;

import android.view.View;
import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.feed.detail.arch.UiComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@StableApi
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/feed/detail/util/ComponentElement;", "", "component", "Lcom/baidu/searchbox/feed/detail/arch/UiComponent;", "view", "Landroid/view/View;", "(Lcom/baidu/searchbox/feed/detail/arch/UiComponent;Landroid/view/View;)V", "getComponent", "()Lcom/baidu/searchbox/feed/detail/arch/UiComponent;", "getView", "()Landroid/view/View;", "lib-component-arch_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ComponentPreCreator.kt */
public final class ComponentElement {
    private final UiComponent component;

    /* renamed from: view  reason: collision with root package name */
    private final View f18643view;

    public ComponentElement(UiComponent component2, View view2) {
        Intrinsics.checkNotNullParameter(component2, "component");
        Intrinsics.checkNotNullParameter(view2, "view");
        this.component = component2;
        this.f18643view = view2;
    }

    public final UiComponent getComponent() {
        return this.component;
    }

    public final View getView() {
        return this.f18643view;
    }
}
