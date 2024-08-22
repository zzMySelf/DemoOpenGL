package com.baidu.searchbox.feed.ui.drawerslide;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/baidu/searchbox/feed/ui/drawerslide/DynamicUtilsKt$setCorner$1", "Landroid/view/ViewOutlineProvider;", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "lib-feed-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicUtils.kt */
public final class DynamicUtilsKt$setCorner$1 extends ViewOutlineProvider {
    final /* synthetic */ float $radius;

    DynamicUtilsKt$setCorner$1(float $radius2) {
        this.$radius = $radius2;
    }

    public void getOutline(View view2, Outline outline) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(outline, "outline");
        outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), this.$radius);
    }
}
