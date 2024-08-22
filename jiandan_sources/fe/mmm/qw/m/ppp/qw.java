package fe.mmm.qw.m.ppp;

import com.tera.scan.webview.debugger.HybridDebuggerListener;
import fe.mmm.qw.m.ggg.fe.ad;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw {

    /* renamed from: ad  reason: collision with root package name */
    public static boolean f8055ad;
    @Nullable

    /* renamed from: de  reason: collision with root package name */
    public static HybridDebuggerListener f8056de;
    @NotNull
    public static final qw qw = new qw();

    public final void ad(@Nullable String str) {
        Unit unit;
        if (f8055ad) {
            try {
                Result.Companion companion = Result.Companion;
                HybridDebuggerListener hybridDebuggerListener = f8056de;
                if (hybridDebuggerListener != null) {
                    hybridDebuggerListener.qw(str);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                Result.m1155constructorimpl(unit);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m1155constructorimpl(ResultKt.createFailure(th2));
            }
        }
    }

    public final void qw(@NotNull String str, @Nullable ad adVar) {
        Unit unit;
        Intrinsics.checkNotNullParameter(str, "url");
        if (f8055ad) {
            try {
                Result.Companion companion = Result.Companion;
                HybridDebuggerListener hybridDebuggerListener = f8056de;
                if (hybridDebuggerListener != null) {
                    hybridDebuggerListener.ad(str, adVar);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                Result.m1155constructorimpl(unit);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m1155constructorimpl(ResultKt.createFailure(th2));
            }
        }
    }
}
