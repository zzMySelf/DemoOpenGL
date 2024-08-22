package ad.qw.qw.qw.qw.ad.ad;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ad {
    public final int qw;

    public /* synthetic */ ad(int i2) {
        this.qw = i2;
    }

    @NotNull
    public static final /* synthetic */ ad ad(int i2) {
        return new ad(i2);
    }

    public static boolean de(int i2, @Nullable Object obj) {
        return (obj instanceof ad) && i2 == ((ad) obj).qw();
    }

    public static int fe(int i2) {
        return i2;
    }

    public static int rg(int i2) {
        return i2;
    }

    @NotNull
    public static String th(int i2) {
        return "Identity(identity=" + i2 + ")";
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
