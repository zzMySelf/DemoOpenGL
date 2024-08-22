package fe.mmm.qw.p030switch.rg;

import androidx.lifecycle.LiveData;
import com.tera.scan.framework.framework.FrameworkAccount;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fe.mmm.qw.switch.rg.qw  reason: invalid package */
public final class qw {
    @Nullable

    /* renamed from: ad  reason: collision with root package name */
    public static Function0<? extends LiveData<FrameworkAccount>> f8314ad;
    @Nullable
    public static Function0<? extends FrameworkAccount> qw;

    @NotNull
    public static final LiveData<FrameworkAccount> ad() {
        LiveData<FrameworkAccount> liveData;
        Function0<? extends LiveData<FrameworkAccount>> function0 = f8314ad;
        if (function0 != null && (liveData = (LiveData) function0.invoke()) != null) {
            return liveData;
        }
        throw new RuntimeException("call initFrameworkAccount first!");
    }

    public static final void de(@NotNull Function0<? extends FrameworkAccount> function0) {
        Intrinsics.checkNotNullParameter(function0, "account");
        qw = function0;
    }

    public static final void fe(@NotNull Function0<? extends LiveData<FrameworkAccount>> function0) {
        Intrinsics.checkNotNullParameter(function0, "account");
        f8314ad = function0;
    }

    @NotNull
    public static final FrameworkAccount qw() {
        FrameworkAccount frameworkAccount;
        Function0<? extends FrameworkAccount> function0 = qw;
        if (function0 != null && (frameworkAccount = (FrameworkAccount) function0.invoke()) != null) {
            return frameworkAccount;
        }
        throw new RuntimeException("call initFrameworkAccount first!");
    }
}
