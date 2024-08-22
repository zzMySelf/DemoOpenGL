package ad.qw.qw.qw.qw.ad.ad;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw {
    public final int qw;

    public /* synthetic */ qw(int i2) {
        this.qw = i2;
    }

    @NotNull
    public static final /* synthetic */ qw ad(int i2) {
        return new qw(i2);
    }

    public static boolean de(int i2, @Nullable Object obj) {
        return (obj instanceof qw) && i2 == ((qw) obj).qw();
    }

    public static int fe(int i2) {
        return i2;
    }

    public static int rg(int i2) {
        return i2;
    }

    @NotNull
    public static String th(int i2) {
        return "GrowthLevel(value=" + i2 + ")";
    }

    public boolean equals(Object obj) {
        return de(this.qw, obj);
    }

    public int hashCode() {
        int i2 = this.qw;
        rg(i2);
        return i2;
    }

    public final /* synthetic */ int qw() {
        return this.qw;
    }

    public String toString() {
        return th(this.qw);
    }
}
