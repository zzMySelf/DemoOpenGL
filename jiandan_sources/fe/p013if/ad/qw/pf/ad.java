package fe.p013if.ad.qw.pf;

import android.graphics.Bitmap;
import android.graphics.RectF;
import java.util.Objects;

/* renamed from: fe.if.ad.qw.pf.ad  reason: invalid package */
public class ad {

    /* renamed from: ad  reason: collision with root package name */
    public Bitmap f4536ad;

    /* renamed from: de  reason: collision with root package name */
    public RectF f4537de;

    /* renamed from: fe  reason: collision with root package name */
    public boolean f4538fe;
    public int qw;

    /* renamed from: rg  reason: collision with root package name */
    public int f4539rg;

    public ad(int i2, Bitmap bitmap, RectF rectF, boolean z, int i3) {
        this.qw = i2;
        this.f4536ad = bitmap;
        this.f4537de = rectF;
        this.f4538fe = z;
        this.f4539rg = i3;
    }

    public int ad() {
        return this.qw;
    }

    public RectF de() {
        return this.f4537de;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ad)) {
            return false;
        }
        ad adVar = (ad) obj;
        if (adVar.ad() == this.qw && adVar.de().left == this.f4537de.left && adVar.de().right == this.f4537de.right && adVar.de().top == this.f4537de.top && adVar.de().bottom == this.f4537de.bottom) {
            return true;
        }
        return false;
    }

    public Bitmap fe() {
        return this.f4536ad;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.qw), this.f4537de, Boolean.valueOf(this.f4538fe), Integer.valueOf(this.f4539rg)});
    }

    public int qw() {
        return this.f4539rg;
    }

    public boolean rg() {
        return this.f4538fe;
    }

    public void th(int i2) {
        this.f4539rg = i2;
    }
}
