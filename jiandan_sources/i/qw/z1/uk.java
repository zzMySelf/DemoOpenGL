package i.qw.z1;

import kotlin.jvm.JvmField;
import kotlinx.coroutines.scheduling.TaskContext;
import org.jetbrains.annotations.NotNull;

public abstract class uk implements Runnable {
    @JvmField

    /* renamed from: ad  reason: collision with root package name */
    public long f6321ad;
    @NotNull
    @JvmField

    /* renamed from: th  reason: collision with root package name */
    public TaskContext f6322th;

    public uk(long j, @NotNull TaskContext taskContext) {
        this.f6321ad = j;
        this.f6322th = taskContext;
    }

    public uk() {
        this(0, th.f6319ad);
    }
}
