package fe.mmm.qw.th.qw.th.p031switch;

import android.os.Handler;
import android.os.Looper;
import org.jetbrains.annotations.NotNull;

/* renamed from: fe.mmm.qw.th.qw.th.switch.fe  reason: invalid package */
public final class fe {
    @NotNull
    public static final Handler qw = new qw(Looper.getMainLooper());

    /* renamed from: fe.mmm.qw.th.qw.th.switch.fe$qw */
    public static final class qw extends Handler {
        public qw(Looper looper) {
            super(looper);
        }
    }

    public static final boolean ad() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    @NotNull
    public static final Handler qw() {
        return qw;
    }
}
