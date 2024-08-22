package fe.mmm.qw.xxx.ppp;

import com.tera.scan.component.base.ui.dialog.CustomListAdapter;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class th {
    @NotNull

    /* renamed from: rg  reason: collision with root package name */
    public static final qw f8636rg = new qw((DefaultConstructorMarker) null);
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public static final String f8637th = "tag_home";
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public static final String f8638yj = "tag_files";

    /* renamed from: ad  reason: collision with root package name */
    public final int f8639ad;

    /* renamed from: de  reason: collision with root package name */
    public final int f8640de;
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public final String f8641fe;
    @NotNull
    public final String qw;

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String ad() {
            return th.f8637th;
        }

        @NotNull
        public final String qw() {
            return th.f8638yj;
        }
    }

    public th(@NotNull String str, int i2, int i3, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, CustomListAdapter.VIEW_TAG);
        Intrinsics.checkNotNullParameter(str2, "title");
        this.qw = str;
        this.f8639ad = i2;
        this.f8640de = i3;
        this.f8641fe = str2;
    }

    public final int de() {
        return this.f8639ad;
    }

    public final int fe() {
        return this.f8640de;
    }

    @NotNull
    public final String rg() {
        return this.qw;
    }

    @NotNull
    public final String th() {
        return this.f8641fe;
    }
}
