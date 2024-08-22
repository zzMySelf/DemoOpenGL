package fe.mmm.qw.nn.rg;

import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import fe.mmm.qw.nn.de.th;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public final class qw {
    @NotNull
    public static final qw qw = new qw();

    public final void qw(@Nullable String str) {
        if (str != null) {
            try {
                int optInt = new JSONObject(str).optInt("errno");
                if (optInt == -6) {
                    th.ad(optInt);
                }
                ExpectKt.success(Unit.INSTANCE);
            } catch (Throwable th2) {
                LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
                ExpectKt.failure(th2);
            }
        }
    }
}
