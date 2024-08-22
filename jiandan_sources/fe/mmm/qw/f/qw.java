package fe.mmm.qw.f;

import android.app.Application;
import android.os.Build;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class qw {

    /* renamed from: ad  reason: collision with root package name */
    public static final boolean f7815ad = (Build.VERSION.SDK_INT >= 28);

    /* renamed from: de  reason: collision with root package name */
    public static Application f7816de;
    @NotNull
    public static final qw qw = new qw();

    static {
        int i2 = Build.VERSION.SDK_INT;
    }

    public final boolean ad() {
        return f7815ad;
    }

    @NotNull
    public final Application qw() {
        Application application = f7816de;
        if (application != null) {
            return application;
        }
        Intrinsics.throwUninitializedPropertyAccessException("app");
        return null;
    }
}
