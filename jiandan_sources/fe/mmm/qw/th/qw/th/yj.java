package fe.mmm.qw.th.qw.th;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class yj {

    /* renamed from: ad  reason: collision with root package name */
    public static long f8368ad;
    public static long qw;

    public static final <T extends View> void ad(@NotNull T t, long j, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        qw = j;
        t.setOnClickListener(new fe(t, function1));
    }

    public static /* synthetic */ void de(View view, long j, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = 300;
        }
        ad(view, j, function1);
    }

    public static final void fe(View view, Function1 function1, View view2) {
        Intrinsics.checkNotNullParameter(view, "$this_clickWithTrigger");
        Intrinsics.checkNotNullParameter(function1, "$block");
        if (!qw(view)) {
            return;
        }
        if (view2 != null) {
            function1.invoke(view2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of com.tera.scan.component.base.util.CommonClickUtilsKt.clickWithTrigger$lambda-0");
    }

    public static final <T extends View> boolean qw(T t) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f8368ad < qw) {
            return false;
        }
        f8368ad = currentTimeMillis;
        return true;
    }
}
