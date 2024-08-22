package fe.uk.qw.pf.rg;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import fe.uk.qw.vvv.o;
import java.util.Queue;

public class th<A, B> {
    public final fe.uk.qw.vvv.th<ad<A>, B> qw;

    @VisibleForTesting
    public static final class ad<A> {

        /* renamed from: fe  reason: collision with root package name */
        public static final Queue<ad<?>> f5932fe = o.rg(0);

        /* renamed from: ad  reason: collision with root package name */
        public int f5933ad;

        /* renamed from: de  reason: collision with root package name */
        public A f5934de;
        public int qw;

        public static <A> ad<A> qw(A a, int i2, int i3) {
            ad<A> poll;
            synchronized (f5932fe) {
                poll = f5932fe.poll();
            }
            if (poll == null) {
                poll = new ad<>();
            }
            poll.ad(a, i2, i3);
            return poll;
        }

        public final void ad(A a, int i2, int i3) {
            this.f5934de = a;
            this.f5933ad = i2;
            this.qw = i3;
        }

        public void de() {
            synchronized (f5932fe) {
                f5932fe.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ad)) {
                return false;
            }
            ad adVar = (ad) obj;
            if (this.f5933ad == adVar.f5933ad && this.qw == adVar.qw && this.f5934de.equals(adVar.f5934de)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.qw * 31) + this.f5933ad) * 31) + this.f5934de.hashCode();
        }
    }

    public class qw extends fe.uk.qw.vvv.th<ad<A>, B> {
        public qw(th thVar, long j) {
            super(j);
        }

        /* renamed from: when */
        public void o(@NonNull ad<A> adVar, @Nullable B b) {
            adVar.de();
        }
    }

    public th(long j) {
        this.qw = new qw(this, j);
    }

    public void ad(A a, int i2, int i3, B b) {
        this.qw.pf(ad.qw(a, i2, i3), b);
    }

    @Nullable
    public B qw(A a, int i2, int i3) {
        ad qw2 = ad.qw(a, i2, i3);
        B yj2 = this.qw.yj(qw2);
        qw2.de();
        return yj2;
    }
}
