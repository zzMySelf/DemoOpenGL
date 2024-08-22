package fe.ggg.ad.qw.ad;

import com.mars.kotlin.extension.LoggerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw {

    /* renamed from: ad  reason: collision with root package name */
    public static volatile boolean f7576ad = true;
    @NotNull
    public static final qw qw = new qw();

    public final boolean ad() {
        return f7576ad;
    }

    public final void qw(@Nullable String str, @Nullable String str2) {
        if (str2 == null) {
            str2 = "";
        }
        LoggerKt.e(ad.qw(str2), str);
    }
}
