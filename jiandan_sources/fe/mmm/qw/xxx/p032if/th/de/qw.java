package fe.mmm.qw.xxx.p032if.th.de;

import android.os.Build;
import android.view.View;
import androidx.core.text.TextUtilsCompat;
import java.util.Locale;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: fe.mmm.qw.xxx.if.th.de.qw  reason: invalid package */
public final class qw {
    @NotNull
    public static final qw qw = new qw();

    @JvmStatic
    public static final int ad(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 19 && TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            z = true;
        }
        int paddingStart = view.getPaddingStart();
        int paddingEnd = view.getPaddingEnd();
        int paddingLeft = view.getPaddingLeft();
        if (z) {
            if (paddingEnd != 0) {
                return paddingEnd;
            }
        } else if (paddingStart != 0) {
            return paddingStart;
        }
        return paddingLeft;
    }

    @JvmStatic
    public static final int de(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 19 && TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            z = true;
        }
        int paddingStart = view.getPaddingStart();
        int paddingEnd = view.getPaddingEnd();
        int paddingRight = view.getPaddingRight();
        if (z) {
            if (paddingStart != 0) {
                return paddingStart;
            }
        } else if (paddingEnd != 0) {
            return paddingEnd;
        }
        return paddingRight;
    }

    public final float qw(float f, float f2) {
        return !((f > 0.0f ? 1 : (f == 0.0f ? 0 : -1)) == 0) ? f : f2;
    }
}
