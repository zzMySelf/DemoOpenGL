package fe.uk.qw.pf.fe;

import androidx.annotation.NonNull;
import com.dxmbumptech.glide.load.Key;
import com.dxmbumptech.glide.load.engine.Resource;
import fe.uk.qw.vvv.i;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

/* renamed from: fe.uk.qw.pf.fe.switch  reason: invalid class name */
public class Cswitch<Z> implements Resource<Z> {

    /* renamed from: ad  reason: collision with root package name */
    public final boolean f5843ad;

    /* renamed from: i  reason: collision with root package name */
    public final Key f5844i;

    /* renamed from: o  reason: collision with root package name */
    public int f5845o;

    /* renamed from: pf  reason: collision with root package name */
    public boolean f5846pf;

    /* renamed from: th  reason: collision with root package name */
    public final boolean f5847th;

    /* renamed from: uk  reason: collision with root package name */
    public final qw f5848uk;

    /* renamed from: yj  reason: collision with root package name */
    public final Resource<Z> f5849yj;

    /* renamed from: fe.uk.qw.pf.fe.switch$qw */
    public interface qw {
        void fe(Key key, Cswitch<?> switchR);
    }

    public Cswitch(Resource<Z> resource, boolean z, boolean z2, Key key, qw qwVar) {
        i.fe(resource);
        this.f5849yj = resource;
        this.f5843ad = z;
        this.f5847th = z2;
        this.f5844i = key;
        i.fe(qwVar);
        this.f5848uk = qwVar;
    }

    @NonNull
    public Class<Z> ad() {
        return this.f5849yj.ad();
    }

    public synchronized void de() {
        if (!this.f5846pf) {
            this.f5845o++;
        } else {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
    }

    public Resource<Z> fe() {
        return this.f5849yj;
    }

    @NonNull
    public Z get() {
        return this.f5849yj.get();
    }

    public int qw() {
        return this.f5849yj.qw();
    }

    public synchronized void recycle() {
        if (this.f5845o > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        } else if (!this.f5846pf) {
            this.f5846pf = true;
            if (this.f5847th) {
                this.f5849yj.recycle();
            }
        } else {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
    }

    public boolean rg() {
        return this.f5843ad;
    }

    public void th() {
        boolean z;
        synchronized (this) {
            if (this.f5845o > 0) {
                z = true;
                int i2 = this.f5845o - 1;
                this.f5845o = i2;
                if (i2 != 0) {
                    z = false;
                }
            } else {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
        }
        if (z) {
            this.f5848uk.fe(this.f5844i, this);
        }
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f5843ad + ", listener=" + this.f5848uk + ", key=" + this.f5844i + ", acquired=" + this.f5845o + ", isRecycled=" + this.f5846pf + ", resource=" + this.f5849yj + ExtendedMessageFormat.END_FE;
    }
}
