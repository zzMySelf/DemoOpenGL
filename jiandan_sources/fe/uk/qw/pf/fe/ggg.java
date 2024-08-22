package fe.uk.qw.pf.fe;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.dxmbumptech.glide.load.engine.Resource;
import com.dxmbumptech.glide.util.pool.FactoryPools;
import fe.uk.qw.vvv.i;
import fe.uk.qw.vvv.pf.ad;

public final class ggg<Z> implements Resource<Z>, FactoryPools.Poolable {

    /* renamed from: i  reason: collision with root package name */
    public static final Pools.Pool<ggg<?>> f5753i = FactoryPools.fe(20, new qw());

    /* renamed from: ad  reason: collision with root package name */
    public final ad f5754ad = ad.qw();

    /* renamed from: th  reason: collision with root package name */
    public Resource<Z> f5755th;

    /* renamed from: uk  reason: collision with root package name */
    public boolean f5756uk;

    /* renamed from: yj  reason: collision with root package name */
    public boolean f5757yj;

    public class qw implements FactoryPools.Factory<ggg<?>> {
        /* renamed from: ad */
        public ggg<?> qw() {
            return new ggg<>();
        }
    }

    @NonNull
    public static <Z> ggg<Z> rg(Resource<Z> resource) {
        ggg<Z> acquire = f5753i.acquire();
        i.fe(acquire);
        ggg<Z> ggg = acquire;
        ggg.de(resource);
        return ggg;
    }

    @NonNull
    public Class<Z> ad() {
        return this.f5755th.ad();
    }

    public final void de(Resource<Z> resource) {
        this.f5756uk = false;
        this.f5757yj = true;
        this.f5755th = resource;
    }

    @NonNull
    public ad fe() {
        return this.f5754ad;
    }

    @NonNull
    public Z get() {
        return this.f5755th.get();
    }

    public int qw() {
        return this.f5755th.qw();
    }

    public synchronized void recycle() {
        this.f5754ad.de();
        this.f5756uk = true;
        if (!this.f5757yj) {
            this.f5755th.recycle();
            th();
        }
    }

    public final void th() {
        this.f5755th = null;
        f5753i.release(this);
    }

    public synchronized void yj() {
        this.f5754ad.de();
        if (this.f5757yj) {
            this.f5757yj = false;
            if (this.f5756uk) {
                recycle();
            }
        } else {
            throw new IllegalStateException("Already unlocked");
        }
    }
}
