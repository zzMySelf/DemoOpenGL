package fe.mmm.qw.xxx.p032if.th;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import fe.mmm.qw.d.fe.uk;
import fe.mmm.qw.m.xxx.qw;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: fe.mmm.qw.xxx.if.th.ad  reason: invalid package */
public final class ad {
    public static final void qw(@NotNull Activity activity, int i2) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        View decorView = activity.getWindow().getDecorView();
        ViewGroup viewGroup = decorView instanceof ViewGroup ? (ViewGroup) decorView : null;
        if (viewGroup != null) {
            uk.ad(activity, false, (ViewGroup) null);
            qw.i(activity);
            viewGroup.setBackgroundColor(activity.getResources().getColor(i2));
        }
    }
}
