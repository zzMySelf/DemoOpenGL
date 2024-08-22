package fe.mmm.qw.a;

import android.os.Process;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import java.util.concurrent.ThreadFactory;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Tag("DefaultThreadFactory")
public final class qw implements ThreadFactory {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final String f7614ad;

    /* renamed from: th  reason: collision with root package name */
    public int f7615th;

    /* renamed from: fe.mmm.qw.a.qw$qw  reason: collision with other inner class name */
    public static final class C0272qw extends Thread {
        public C0272qw(Runnable runnable, String str) {
            super(runnable, str);
        }

        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    public qw(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "poolType");
        this.f7614ad = str;
    }

    @NotNull
    public Thread newThread(@NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        String str = this.f7614ad + "-job-pool-thread-" + this.f7615th;
        LoggerKt.d$default("thread name = " + str, (Object) null, 1, (Object) null);
        C0272qw qwVar = new C0272qw(runnable, str);
        this.f7615th = this.f7615th + 1;
        return qwVar;
    }
}
