package fe.mmm.qw.e;

import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Tag("LibStatisticsMgr")
public final class qw {
    @NotNull
    @JvmField

    /* renamed from: ad  reason: collision with root package name */
    public static String f7756ad = "baidu_netdisk_aiscan";
    @Nullable

    /* renamed from: de  reason: collision with root package name */
    public static Function0<Boolean> f7757de;
    @NotNull
    public static final qw qw = new qw();

    public final void ad(@Nullable Function0<Boolean> function0) {
        LoggerKt.d$default("mIsAgreeSecret set", (Object) null, 1, (Object) null);
        f7757de = function0;
    }

    public final boolean qw() {
        Function0<Boolean> function0 = f7757de;
        if (function0 != null) {
            return function0.invoke().booleanValue();
        }
        return false;
    }
}
