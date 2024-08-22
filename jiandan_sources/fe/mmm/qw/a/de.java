package fe.mmm.qw.a;

import com.mars.kotlin.extension.LoggerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class de {
    @Nullable
    public static Function1<? super fe, Unit> qw;

    public static final void qw(@NotNull fe feVar) {
        Intrinsics.checkNotNullParameter(feVar, "statisticData");
        Function1<? super fe, Unit> function1 = qw;
        if (function1 != null) {
            function1.invoke(feVar);
        } else {
            LoggerKt.e$default("call initFrameworkStatistic first!", (Object) null, 1, (Object) null);
        }
    }
}
