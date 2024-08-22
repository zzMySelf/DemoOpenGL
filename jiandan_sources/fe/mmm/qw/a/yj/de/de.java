package fe.mmm.qw.a.yj.de;

import com.mars.kotlin.extension.Tag;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Tag("LibTaskSchedulerMgr")
public final class de {
    @Nullable

    /* renamed from: ad  reason: collision with root package name */
    public static Function0<String> f7630ad;
    @Nullable

    /* renamed from: de  reason: collision with root package name */
    public static Function2<? super String, ? super String, Boolean> f7631de;
    @Nullable

    /* renamed from: fe  reason: collision with root package name */
    public static Function1<? super String, Boolean> f7632fe;
    @NotNull
    public static final de qw = new de();
    @Nullable

    /* renamed from: rg  reason: collision with root package name */
    public static Function5<? super String, ? super Long, ? super Long, ? super Long, ? super Long, Unit> f7633rg;

    public final boolean ad(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "oldUID");
        Intrinsics.checkNotNullParameter(str2, "name");
        Function2<? super String, ? super String, Boolean> function2 = f7631de;
        if (function2 != null) {
            return function2.invoke(str, str2).booleanValue();
        }
        return true;
    }

    public final boolean de(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        Function1<? super String, Boolean> function1 = f7632fe;
        if (function1 != null) {
            return function1.invoke(str).booleanValue();
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.invoke();
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String fe() {
        /*
            r1 = this;
            kotlin.jvm.functions.Function0<java.lang.String> r0 = f7630ad
            if (r0 == 0) goto L_0x000c
            java.lang.Object r0 = r0.invoke()
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x000e
        L_0x000c:
            java.lang.String r0 = ""
        L_0x000e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.a.yj.de.de.fe():java.lang.String");
    }

    public final void qw(@NotNull String str, long j, long j2, long j3, long j4) {
        Intrinsics.checkNotNullParameter(str, "name");
        Function5<? super String, ? super Long, ? super Long, ? super Long, ? super Long, Unit> function5 = f7633rg;
        if (function5 != null) {
            Long valueOf = Long.valueOf(j);
            function5.invoke(str, valueOf, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4));
        }
    }
}
