package com.mars.kotlin.database.extension;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/mars/kotlin/database/extension/LifecycleViewModelStoreOwner;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/ViewModelStoreOwner;", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "Landroidx/lifecycle/ViewModelStore;", "getViewModelStore", "()Landroidx/lifecycle/ViewModelStore;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Landroidx/lifecycle/LifecycleOwner;)V", "database_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class LifecycleViewModelStoreOwner implements LifecycleOwner, ViewModelStoreOwner {
    public final LifecycleOwner owner;

    public LifecycleViewModelStoreOwner(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        this.owner = lifecycleOwner;
    }

    @NotNull
    public Lifecycle getLifecycle() {
        Lifecycle lifecycle = this.owner.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "owner.lifecycle");
        return lifecycle;
    }

    @NotNull
    public ViewModelStore getViewModelStore() {
        ViewModelStore viewModelStore;
        LifecycleOwner lifecycleOwner = this.owner;
        if (!(lifecycleOwner instanceof ViewModelStoreOwner)) {
            lifecycleOwner = null;
        }
        ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner) lifecycleOwner;
        if (viewModelStoreOwner != null && (viewModelStore = viewModelStoreOwner.getViewModelStore()) != null) {
            return viewModelStore;
        }
        throw new IllegalArgumentException("owner must implement LifecycleOwner and ViewModelStoreOwner");
    }
}
