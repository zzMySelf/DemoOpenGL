package fe.rg.qw.o.fe;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.pool.FactoryPools;
import fe.rg.qw.ggg.o.ad;
import fe.rg.qw.ggg.uk;

public final class ggg<Z> implements Resource<Z>, FactoryPools.Poolable {

    /* renamed from: i  reason: collision with root package name */
    public static final Pools.Pool<ggg<?>> f4786i = FactoryPools.rg(20, new qw());

    /* renamed from: ad  reason: collision with root package name */
    public final ad f4787ad = ad.qw();

    /* renamed from: th  reason: collision with root package name */
    public Resource<Z> f4788th;

    /* renamed from: uk  reason: collision with root package name */
    public boolean f4789uk;

    /* renamed from: yj  reason: collision with root package name */
    public boolean f4790yj;

    public class qw implements FactoryPools.Factory<ggg<?>> {
        /* renamed from: ad */
        public ggg<?> qw() {
            return new ggg<>();
        }
    }

    @NonNull
    public static <Z> ggg<Z> rg(Resource<Z> resource) {
        ggg<Z> acquire = f4786i.acquire();
        uk.fe(acquire);
        ggg<Z> ggg = acquire;
        ggg.de(resource);
        return ggg;
    }

    @NonNull
    public Class<Z> ad() {
        return this.f4788th.ad();
    }

    public final void de(Resource<Z> resource) {
        this.f4789uk = false;
        this.f4790yj = true;
        this.f4788th = resource;
    }

    @NonNull
    public ad fe() {
        return this.f4787ad;
    }

    @NonNull
    public Z get() {
        return this.f4788th.get();
    }

    public int qw() {
        return this.f4788th.qw();
    }

    public synchronized void recycle() {
        this.f4787ad.de();
        this.f4789uk = true;
        if (!this.f4790yj) {
            this.f4788th.recycle();
            th();
        }
    }

    public final void th() {
        this.f4788th = null;
        f4786i.release(this);
    }

    public synchronized void yj() {
        this.f4787ad.de();
        if (this.f4790yj) {
            this.f4790yj = false;
            if (this.f4789uk) {
                recycle();
            }
        } else {
            throw new IllegalStateException("Already unlocked");
        }
    }
}
