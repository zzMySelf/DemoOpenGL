package fe.mmm.qw.nn.de;

import com.tera.scan.network.network.CookieAccount;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class fe {
    @Nullable
    public static Function0<? extends CookieAccount> qw;

    public static final void ad(@NotNull Function0<? extends CookieAccount> function0) {
        Intrinsics.checkNotNullParameter(function0, "account");
        qw = function0;
    }

    @NotNull
    public static final CookieAccount qw() {
        CookieAccount cookieAccount;
        Function0<? extends CookieAccount> function0 = qw;
        if (function0 != null && (cookieAccount = (CookieAccount) function0.invoke()) != null) {
            return cookieAccount;
        }
        throw new RuntimeException("call initBizCookieAccount first!");
    }
}
