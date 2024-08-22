package i.qw;

import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class b1 implements DisposableHandle, ChildHandle {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public static final b1 f6105ad = new b1();

    public void dispose() {
    }

    public boolean fe(@NotNull Throwable th2) {
        return false;
    }

    @Nullable
    public Job getParent() {
        return null;
    }

    @NotNull
    public String toString() {
        return "NonDisposableHandle";
    }
}
