package fe.mmm.qw.f.ad.fe;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tera.scan.ui.utils.resources.IUIKitResources;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw {
    @Nullable

    /* renamed from: ad  reason: collision with root package name */
    public static IUIKitResources f7767ad;

    /* renamed from: de  reason: collision with root package name */
    public static boolean f7768de;
    @NotNull
    public static final qw qw = new qw();

    @NotNull
    public final Drawable ad(@NotNull Context context, int i2) {
        Drawable qw2;
        Intrinsics.checkNotNullParameter(context, "context");
        IUIKitResources iUIKitResources = f7767ad;
        if (iUIKitResources != null && (qw2 = iUIKitResources.qw(i2)) != null) {
            return qw2;
        }
        Drawable drawable = context.getResources().getDrawable(i2);
        Intrinsics.checkNotNullExpressionValue(drawable, "context.resources.getDrawable(resId)");
        return drawable;
    }

    @Nullable
    public final IUIKitResources de() {
        return f7767ad;
    }

    public final boolean fe() {
        return f7768de;
    }

    public final int qw(@NotNull Context context, int i2) {
        Intrinsics.checkNotNullParameter(context, "context");
        IUIKitResources iUIKitResources = f7767ad;
        return iUIKitResources != null ? iUIKitResources.ad(i2) : context.getResources().getColor(i2);
    }
}
