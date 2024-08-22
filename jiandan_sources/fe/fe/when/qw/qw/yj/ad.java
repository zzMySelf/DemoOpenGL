package fe.fe.when.qw.qw.yj;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ad {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public static final qw f3192ad = new qw((DefaultConstructorMarker) null);
    @Nullable
    public final Integer qw;

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ad qw() {
            return new ad(1001, (String) null, 2, (DefaultConstructorMarker) null);
        }
    }

    public ad(@Nullable Integer num, @Nullable String str) {
        this.qw = num;
    }

    public final boolean ad() {
        return !fe() && !qw();
    }

    @Nullable
    public final Integer de() {
        return this.qw;
    }

    public final boolean fe() {
        Integer num = this.qw;
        return num != null && num.intValue() == 0;
    }

    public final boolean qw() {
        Integer num = this.qw;
        return num != null && num.intValue() == 1004;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ad(Integer num, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : str);
    }
}
