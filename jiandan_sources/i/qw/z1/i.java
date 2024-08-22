package i.qw.z1;

import com.baidu.android.common.others.lang.StringUtil;
import i.qw.l;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.scheduling.TaskContext;
import org.jetbrains.annotations.NotNull;

public final class i extends uk {
    @NotNull
    @JvmField

    /* renamed from: yj  reason: collision with root package name */
    public final Runnable f6308yj;

    public i(@NotNull Runnable runnable, long j, @NotNull TaskContext taskContext) {
        super(j, taskContext);
        this.f6308yj = runnable;
    }

    public void run() {
        try {
            this.f6308yj.run();
        } finally {
            this.f6322th.ppp();
        }
    }

    @NotNull
    public String toString() {
        return "Task[" + l.qw(this.f6308yj) + '@' + l.ad(this.f6308yj) + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.f6321ad + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.f6322th + ']';
    }
}
