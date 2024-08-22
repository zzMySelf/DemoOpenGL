package com.tera.scan.ui.view.widget.shadow;

import android.os.Build;
import android.view.View;
import androidx.annotation.ColorInt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"setShadow", "", "Landroid/view/View;", "shadowColor", "", "elevation", "", "component-ui-widget_aiscanConfigRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ShadowsKt {
    public static final void qw(@NotNull View view, @ColorInt int i2, float f) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (Build.VERSION.SDK_INT >= 28) {
            view.setElevation(f);
            view.setOutlineAmbientShadowColor(i2);
            view.setOutlineSpotShadowColor(i2);
            view.setClipToOutline(true);
            view.setOutlineProvider(new ShadowsKt$setShadow$1());
        }
    }
}
