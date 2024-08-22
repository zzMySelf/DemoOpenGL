package fe.mmm.qw.f.ad.fe;

import android.content.res.TypedArray;
import com.tera.scan.ui.utils.resources.IUIKitResources;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ad {
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
        r0 = r1.qw(r0);
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.graphics.drawable.Drawable ad(@org.jetbrains.annotations.NotNull android.content.res.TypedArray r2, int r3) {
        /*
            java.lang.String r0 = "a"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            r0 = 0
            int r0 = r2.getResourceId(r3, r0)
            if (r0 == 0) goto L_0x001f
            fe.mmm.qw.f.ad.fe.qw r1 = fe.mmm.qw.f.ad.fe.qw.qw
            com.tera.scan.ui.utils.resources.IUIKitResources r1 = r1.de()
            if (r1 == 0) goto L_0x001a
            android.graphics.drawable.Drawable r0 = r1.qw(r0)
            if (r0 != 0) goto L_0x0020
        L_0x001a:
            android.graphics.drawable.Drawable r0 = r2.getDrawable(r3)
            goto L_0x0020
        L_0x001f:
            r0 = 0
        L_0x0020:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.f.ad.fe.ad.ad(android.content.res.TypedArray, int):android.graphics.drawable.Drawable");
    }

    public static final int qw(@NotNull TypedArray typedArray, int i2, int i3) {
        Intrinsics.checkNotNullParameter(typedArray, "a");
        int resourceId = typedArray.getResourceId(i2, 0);
        if (resourceId == 0) {
            return i3;
        }
        IUIKitResources de2 = qw.qw.de();
        return de2 != null ? de2.ad(resourceId) : typedArray.getColor(i2, i3);
    }
}
