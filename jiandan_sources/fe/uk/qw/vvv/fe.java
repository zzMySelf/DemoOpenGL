package fe.uk.qw.vvv;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

public final class fe {

    /* renamed from: ad  reason: collision with root package name */
    public static final Executor f6047ad = new ad();
    public static final Executor qw = new qw();

    public class ad implements Executor {
        public void execute(@NonNull Runnable runnable) {
            runnable.run();
        }
    }

    public class qw implements Executor {
        public void execute(@NonNull Runnable runnable) {
            o.nn(runnable);
        }
    }

    public static Executor ad() {
        return qw;
    }

    public static Executor qw() {
        return f6047ad;
    }
}
