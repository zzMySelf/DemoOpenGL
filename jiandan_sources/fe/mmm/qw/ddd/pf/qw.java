package fe.mmm.qw.ddd.pf;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw {

    /* renamed from: ad  reason: collision with root package name */
    public final int f7719ad;

    /* renamed from: de  reason: collision with root package name */
    public final int f7720de;

    /* renamed from: fe  reason: collision with root package name */
    public final int f7721fe;
    public final int qw;

    /* renamed from: rg  reason: collision with root package name */
    public final int f7722rg;

    public qw(int i2, int i3, int i4, int i5, int i6) {
        this.qw = i2;
        this.f7719ad = i3;
        this.f7720de = i4;
        this.f7721fe = i5;
        this.f7722rg = i6;
    }

    public final int ad() {
        return this.f7719ad;
    }

    public final int de() {
        return this.qw;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qw)) {
            return false;
        }
        qw qwVar = (qw) obj;
        return this.qw == qwVar.qw && this.f7719ad == qwVar.f7719ad && this.f7720de == qwVar.f7720de && this.f7721fe == qwVar.f7721fe && this.f7722rg == qwVar.f7722rg;
    }

    public final int fe() {
        return this.f7722rg;
    }

    public int hashCode() {
        return (((((((this.qw * 31) + this.f7719ad) * 31) + this.f7720de) * 31) + this.f7721fe) * 31) + this.f7722rg;
    }

    public final int qw() {
        return this.f7720de;
    }

    public final int rg() {
        return this.f7721fe;
    }

    @NotNull
    public String toString() {
        return "OCRPredictorData(preWidth=" + this.qw + ", preHeight=" + this.f7719ad + ", degree=" + this.f7720de + ", targetWidth=" + this.f7721fe + ", targetHeight=" + this.f7722rg + ')';
    }
}
