package com.baidu.swan.apps.publisher;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import com.baidu.swan.apps.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\u000e"}, d2 = {"Lcom/baidu/swan/apps/publisher/SwanAppReplyEditorHelper;", "", "()V", "getBackground", "Landroid/graphics/drawable/StateListDrawable;", "context", "Landroid/content/Context;", "normalColor", "", "getDrawableWithAlpha", "Landroid/graphics/drawable/GradientDrawable;", "alpha", "", "radius", "lib-swan-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SwanAppReplyEditorHelper.kt */
public final class SwanAppReplyEditorHelper {
    public static final SwanAppReplyEditorHelper INSTANCE = new SwanAppReplyEditorHelper();

    private SwanAppReplyEditorHelper() {
    }

    public final StateListDrawable getBackground(Context context, int normalColor) {
        Intrinsics.checkNotNullParameter(context, "context");
        float radius = context.getResources().getDimension(R.dimen.swanapp_reply_editor_sendbtn_radius);
        StateListDrawable drawable = new StateListDrawable();
        drawable.addState(new int[]{16842919}, getDrawableWithAlpha(0.2f, radius, normalColor));
        drawable.addState(new int[]{-16842910}, getDrawableWithAlpha(0.6f, radius, normalColor));
        drawable.addState(new int[]{16842910}, getDrawableWithAlpha(1.0f, radius, normalColor));
        return drawable;
    }

    private final GradientDrawable getDrawableWithAlpha(float alpha, float radius, int normalColor) {
        int rgb = 16777215 & normalColor;
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(rgb + (((int) (((float) 255) * RangesKt.coerceAtLeast(RangesKt.coerceAtMost(alpha, 1.0f), 0.0f))) << 24));
        drawable.setCornerRadius(radius);
        return drawable;
    }
}
