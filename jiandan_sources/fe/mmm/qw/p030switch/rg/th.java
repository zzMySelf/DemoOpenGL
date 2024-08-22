package fe.mmm.qw.p030switch.rg;

import com.mars.kotlin.extension.LoggerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fe.mmm.qw.switch.rg.th  reason: invalid package */
public final class th {
    @Nullable
    public static Function1<? super rg, Unit> qw;

    public static final void qw(@NotNull rg rgVar) {
        Intrinsics.checkNotNullParameter(rgVar, "statisticData");
        Function1<? super rg, Unit> function1 = qw;
        if (function1 != null) {
            function1.invoke(rgVar);
        } else {
            LoggerKt.e$default("call initFrameworkStatistic first!", (Object) null, 1, (Object) null);
        }
    }
}
