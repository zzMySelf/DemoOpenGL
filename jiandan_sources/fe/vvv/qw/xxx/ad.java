package fe.vvv.qw.xxx;

import androidx.annotation.NonNull;
import com.dlife.ctaccountapi.x;

public class ad implements Comparable<ad> {

    /* renamed from: ad  reason: collision with root package name */
    public final int f9128ad;

    /* renamed from: th  reason: collision with root package name */
    public final int f9129th;

    public ad(int i2, int i3) {
        this.f9128ad = i2;
        this.f9129th = i3;
    }

    public ad ad() {
        return new ad(this.f9129th, this.f9128ad);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ad)) {
            return false;
        }
        ad adVar = (ad) obj;
        if (this.f9128ad == adVar.f9128ad && this.f9129th == adVar.f9129th) {
            return true;
        }
        return false;
    }

    public int fe() {
        return this.f9129th;
    }

    public int hashCode() {
        int i2 = this.f9129th;
        int i3 = this.f9128ad;
        return i2 ^ ((i3 >>> 16) | (i3 << 16));
    }

    /* renamed from: qw */
    public int compareTo(@NonNull ad adVar) {
        return (this.f9128ad * this.f9129th) - (adVar.f9128ad * adVar.f9129th);
    }

    public int rg() {
        return this.f9128ad;
    }

    @NonNull
    public String toString() {
        return this.f9128ad + x.a + this.f9129th;
    }
}
