package i.qw;

import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class eee {
    public static /* synthetic */ CompletableDeferred ad(Job job, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            job = null;
        }
        return qw(job);
    }

    @NotNull
    public static final <T> CompletableDeferred<T> qw(@Nullable Job job) {
        return new qqq(job);
    }
}
