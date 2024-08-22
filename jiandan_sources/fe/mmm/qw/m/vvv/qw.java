package fe.mmm.qw.m.vvv;

import android.webkit.CookieManager;
import com.alipay.sdk.m.u.i;
import com.dxmpay.wallet.core.Domains;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw {
    @Nullable
    public static Function0<Boolean> qw;

    public static final boolean ad(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        return StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "sandbox-pan.baidu-int.com", false, 2, (Object) null);
    }

    @Nullable
    public static final String de(@Nullable String str) {
        if (!qw()) {
            return str;
        }
        if (str != null) {
            return StringsKt__StringsJVMKt.replaceFirst$default(str, "pan.baidu.com", "sandbox-pan.baidu-int.com", false, 4, (Object) null);
        }
        return null;
    }

    @Tag("BaseCookiesSyncer")
    public static final void fe(CookieManager cookieManager, String str, String[] strArr) {
        for (String str2 : StringsKt__StringsKt.split$default((CharSequence) str, new String[]{i.b}, false, 0, 6, (Object) null)) {
            for (String str3 : strArr) {
                cookieManager.setCookie(str3, str2);
                LoggerKt.d$default(str3 + " 添加沙盒cookie:" + str2, (Object) null, 1, (Object) null);
            }
        }
    }

    public static final boolean qw() {
        Function0<Boolean> function0 = qw;
        if (function0 != null) {
            return function0.invoke().booleanValue();
        }
        return false;
    }

    public static final void rg(@NotNull String str) {
        CookieManager instance;
        Intrinsics.checkNotNullParameter(str, "url");
        if (qw()) {
            if ((StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "pan.baidu.com", false, 2, (Object) null) || ad(str)) && (instance = CookieManager.getInstance()) != null) {
                String cookie = instance.getCookie(Domains.BAIDU);
                if (cookie != null) {
                    fe(instance, cookie, new String[]{".baidu-int.com"});
                }
                String cookie2 = instance.getCookie("pan.baidu.com");
                if (cookie2 != null) {
                    fe(instance, cookie2, new String[]{"sandbox-pan.baidu-int.com"});
                }
            }
        }
    }
}
