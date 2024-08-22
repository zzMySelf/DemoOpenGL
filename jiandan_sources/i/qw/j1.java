package i.qw;

import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class j1 {
    public static /* synthetic */ CompletableJob ad(Job job, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            job = null;
        }
        return qw(job);
    }

    @NotNull
    public static final CompletableJob qw(@Nullable Job job) {
        return new i1(job);
    }
}
