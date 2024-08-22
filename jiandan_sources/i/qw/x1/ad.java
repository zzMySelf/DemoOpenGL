package i.qw.x1;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ad {
    public fe<?> qw;

    @NotNull
    public final fe<?> ad() {
        fe<?> feVar = this.qw;
        if (feVar != null) {
            return feVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("atomicOp");
        throw null;
    }

    @Nullable
    public abstract Object de(@NotNull fe<?> feVar);

    public final void fe(@NotNull fe<?> feVar) {
        this.qw = feVar;
    }

    public abstract void qw(@NotNull fe<?> feVar, @Nullable Object obj);
}
