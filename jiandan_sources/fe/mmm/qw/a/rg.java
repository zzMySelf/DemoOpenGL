package fe.mmm.qw.a;

import android.os.AsyncTask;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import com.mars.kotlin.extension.fp.Either;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;

public final class rg {
    @Tag("optimizeAsyncTaskExecutor")
    public final void qw() {
        Object obj;
        Unit unit;
        try {
            Executor executor = AsyncTask.THREAD_POOL_EXECUTOR;
            ThreadPoolExecutor threadPoolExecutor = executor instanceof ThreadPoolExecutor ? (ThreadPoolExecutor) executor : null;
            if (threadPoolExecutor != null) {
                threadPoolExecutor.allowCoreThreadTimeOut(true);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            obj = ExpectKt.success(unit);
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            obj = ExpectKt.failure(th2);
        }
        if (obj instanceof Either.Left) {
            Throwable th3 = (Throwable) ((Either.Left) obj).getValue();
            new Either.Left((String) LoggerKt.e$default("Optimize AsyncTask executor error: allowCoreThreadTimeOut = true", (Object) null, 1, (Object) null));
        } else if (!(obj instanceof Either.Right)) {
            throw new NoWhenBranchMatchedException();
        }
    }
}
