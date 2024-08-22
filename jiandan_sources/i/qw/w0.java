package i.qw;

import i.qw.x1.c;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.Incomplete;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class w0 {
    @NotNull
    @JvmField

    /* renamed from: ad  reason: collision with root package name */
    public static final c f6218ad = new c("COMPLETING_WAITING_CHILDREN");
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public static final c f6219de = new c("COMPLETING_RETRY");
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public static final c f6220fe = new c("TOO_LATE_TO_CANCEL");
    @NotNull
    public static final c qw = new c("COMPLETING_ALREADY");
    @NotNull

    /* renamed from: rg  reason: collision with root package name */
    public static final c f6221rg = new c("SEALED");
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public static final y f6222th = new y(false);
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public static final y f6223yj = new y(true);

    @Nullable
    public static final Object uk(@Nullable Object obj) {
        Incomplete incomplete;
        k0 k0Var = obj instanceof k0 ? (k0) obj : null;
        return (k0Var == null || (incomplete = k0Var.qw) == null) ? obj : incomplete;
    }

    @Nullable
    public static final Object yj(@Nullable Object obj) {
        return obj instanceof Incomplete ? new k0((Incomplete) obj) : obj;
    }
}
