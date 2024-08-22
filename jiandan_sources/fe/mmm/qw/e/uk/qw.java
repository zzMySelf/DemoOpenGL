package fe.mmm.qw.e.uk;

import android.util.Log;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.fp.Either;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;

public final class qw {
    static {
        Object obj;
        try {
            System.loadLibrary("c++_shared");
            obj = ExpectKt.success(Unit.INSTANCE);
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            obj = ExpectKt.failure(th2);
        }
        if (obj instanceof Either.Left) {
            new Either.Left(Integer.valueOf(Log.e("UbcLog", "Native libraries failed to load - " + ((Throwable) ((Either.Left) obj).getValue()))));
        } else if (!(obj instanceof Either.Right)) {
            throw new NoWhenBranchMatchedException();
        }
    }
}
