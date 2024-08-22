package fe.mmm.qw.nn.de;

import android.text.TextUtils;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class uk {

    /* renamed from: ad  reason: collision with root package name */
    public final boolean f8118ad;
    @NotNull
    public final String qw;

    public uk(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "bduss");
        this.qw = str;
        this.f8118ad = z;
    }

    public final boolean ad() {
        return !TextUtils.isEmpty(this.qw) && Intrinsics.areEqual((Object) this.qw, (Object) fe.qw().getBduss());
    }

    @Nullable
    public final String qw(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "cookie");
        if (!ad()) {
            return str;
        }
        String ad2 = fe.qw().ad();
        if (TextUtils.isEmpty(ad2)) {
            fe.qw().qw(this.qw, this.f8118ad);
            if (!ad()) {
                return str;
            }
            ad2 = fe.qw().ad();
            if (TextUtils.isEmpty(ad2)) {
                return str;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(TextUtils.isEmpty(str) ? "" : "; ");
        sb.append("STOKEN=");
        sb.append(ad2);
        return sb.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public uk(@NotNull String str) {
        this(str, true);
        Intrinsics.checkNotNullParameter(str, "bduss");
    }
}
