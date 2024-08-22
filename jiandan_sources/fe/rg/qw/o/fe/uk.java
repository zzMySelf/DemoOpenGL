package fe.rg.qw.o.fe;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.pool.FactoryPools;
import fe.rg.qw.ggg.i;
import fe.rg.qw.o.fe.Cswitch;
import java.util.Map;

public class uk implements o, MemoryCache.ResourceRemovedListener, Cswitch.qw {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f4880i = Log.isLoggable("Engine", 2);

    /* renamed from: ad  reason: collision with root package name */
    public final Cif f4881ad;

    /* renamed from: de  reason: collision with root package name */
    public final MemoryCache f4882de;

    /* renamed from: fe  reason: collision with root package name */
    public final ad f4883fe;
    public final when qw;

    /* renamed from: rg  reason: collision with root package name */
    public final ddd f4884rg;

    /* renamed from: th  reason: collision with root package name */
    public final de f4885th;

    /* renamed from: uk  reason: collision with root package name */
    public final qw f4886uk;

    /* renamed from: yj  reason: collision with root package name */
    public final qw f4887yj;

    @VisibleForTesting
    public static class ad {

        /* renamed from: ad  reason: collision with root package name */
        public final GlideExecutor f4888ad;

        /* renamed from: de  reason: collision with root package name */
        public final GlideExecutor f4889de;

        /* renamed from: fe  reason: collision with root package name */
        public final GlideExecutor f4890fe;
        public final GlideExecutor qw;

        /* renamed from: rg  reason: collision with root package name */
        public final o f4891rg;

        /* renamed from: th  reason: collision with root package name */
        public final Pools.Pool<i<?>> f4892th = FactoryPools.fe(150, new qw());

        public class qw implements FactoryPools.Factory<i<?>> {
            public qw() {
            }

            /* renamed from: ad */
            public i<?> qw() {
                ad adVar = ad.this;
                return new i(adVar.qw, adVar.f4888ad, adVar.f4889de, adVar.f4890fe, adVar.f4891rg, adVar.f4892th);
            }
        }

        public ad(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, o oVar) {
            this.qw = glideExecutor;
            this.f4888ad = glideExecutor2;
            this.f4889de = glideExecutor3;
            this.f4890fe = glideExecutor4;
            this.f4891rg = oVar;
        }

        public <R> i<R> qw(Key key, boolean z, boolean z2, boolean z3, boolean z4) {
            i<R> acquire = this.f4892th.acquire();
            fe.rg.qw.ggg.uk.fe(acquire);
            i<R> iVar = acquire;
            iVar.m305if(key, z, z2, z3, z4);
            return iVar;
        }
    }

    public static class de implements DecodeJob.rg {

        /* renamed from: ad  reason: collision with root package name */
        public volatile DiskCache f4893ad;
        public final DiskCache.Factory qw;

        public de(DiskCache.Factory factory) {
            this.qw = factory;
        }

        public DiskCache qw() {
            if (this.f4893ad == null) {
                synchronized (this) {
                    if (this.f4893ad == null) {
                        this.f4893ad = this.qw.build();
                    }
                    if (this.f4893ad == null) {
                        this.f4893ad = new fe.rg.qw.o.fe.aaa.qw();
                    }
                }
            }
            return this.f4893ad;
        }
    }

    public static class fe {

        /* renamed from: ad  reason: collision with root package name */
        public final ResourceCallback f4894ad;
        public final i<?> qw;

        public fe(ResourceCallback resourceCallback, i<?> iVar) {
            this.f4894ad = resourceCallback;
            this.qw = iVar;
        }

        public void qw() {
            this.qw.ggg(this.f4894ad);
        }
    }

    @VisibleForTesting
    public static class qw {

        /* renamed from: ad  reason: collision with root package name */
        public final Pools.Pool<DecodeJob<?>> f4895ad = FactoryPools.fe(150, new C0209qw());

        /* renamed from: de  reason: collision with root package name */
        public int f4896de;
        public final DecodeJob.rg qw;

        /* renamed from: fe.rg.qw.o.fe.uk$qw$qw  reason: collision with other inner class name */
        public class C0209qw implements FactoryPools.Factory<DecodeJob<?>> {
            public C0209qw() {
            }

            /* renamed from: ad */
            public DecodeJob<?> qw() {
                qw qwVar = qw.this;
                return new DecodeJob<>(qwVar.qw, qwVar.f4895ad);
            }
        }

        public qw(DecodeJob.rg rgVar) {
            this.qw = rgVar;
        }

        public <R> DecodeJob<R> qw(fe.rg.qw.fe feVar, Object obj, pf pfVar, Key key, int i2, int i3, Class<?> cls, Class<R> cls2, Priority priority, yj yjVar, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, boolean z3, fe.rg.qw.o.ad adVar, DecodeJob.ad<R> adVar2) {
            DecodeJob<R> acquire = this.f4895ad.acquire();
            fe.rg.qw.ggg.uk.fe(acquire);
            DecodeJob<R> decodeJob = acquire;
            int i4 = this.f4896de;
            int i5 = i4;
            this.f4896de = i4 + 1;
            decodeJob.ggg(feVar, obj, pfVar, key, i2, i3, cls, cls2, priority, yjVar, map, z, z2, z3, adVar, adVar2, i5);
            return decodeJob;
        }
    }

    public uk(MemoryCache memoryCache, DiskCache.Factory factory, GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, boolean z) {
        this(memoryCache, factory, glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, (when) null, (Cif) null, (qw) null, (ad) null, (qw) null, (ddd) null, z);
    }

    public static void i(String str, long j, Key key) {
        str + " in " + fe.rg.qw.ggg.fe.qw(j) + "ms, key: " + key;
    }

    public void ad(i<?> iVar, Key key, Cswitch<?> switchR) {
        i.qw();
        if (switchR != null) {
            switchR.yj(key, this);
            if (switchR.rg()) {
                this.f4886uk.qw(key, switchR);
            }
        }
        this.qw.fe(key, iVar);
    }

    public void de(i<?> iVar, Key key) {
        i.qw();
        this.qw.fe(key, iVar);
    }

    public void fe(Key key, Cswitch<?> switchR) {
        i.qw();
        this.f4886uk.fe(key);
        if (switchR.rg()) {
            this.f4882de.de(key, switchR);
        } else {
            this.f4884rg.qw(switchR);
        }
    }

    public void o(Resource<?> resource) {
        i.qw();
        if (resource instanceof Cswitch) {
            ((Cswitch) resource).th();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    public void qw(@NonNull Resource<?> resource) {
        i.qw();
        this.f4884rg.qw(resource);
    }

    public final Cswitch<?> rg(Key key) {
        Resource<?> fe2 = this.f4882de.fe(key);
        if (fe2 == null) {
            return null;
        }
        if (fe2 instanceof Cswitch) {
            return (Cswitch) fe2;
        }
        return new Cswitch<>(fe2, true, true);
    }

    public <R> fe th(fe.rg.qw.fe feVar, Object obj, Key key, int i2, int i3, Class<?> cls, Class<R> cls2, Priority priority, yj yjVar, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, fe.rg.qw.o.ad adVar, boolean z3, boolean z4, boolean z5, boolean z6, ResourceCallback resourceCallback) {
        boolean z7 = z3;
        ResourceCallback resourceCallback2 = resourceCallback;
        i.qw();
        long ad2 = f4880i ? fe.rg.qw.ggg.fe.ad() : 0;
        pf qw2 = this.f4881ad.qw(obj, key, i2, i3, map, cls, cls2, adVar);
        Cswitch<?> yj2 = yj(qw2, z7);
        if (yj2 != null) {
            resourceCallback2.rg(yj2, DataSource.MEMORY_CACHE);
            if (f4880i) {
                i("Loaded resource from active resources", ad2, qw2);
            }
            return null;
        }
        Cswitch<?> uk2 = uk(qw2, z7);
        if (uk2 != null) {
            resourceCallback2.rg(uk2, DataSource.MEMORY_CACHE);
            if (f4880i) {
                i("Loaded resource from cache", ad2, qw2);
            }
            return null;
        }
        i<?> qw3 = this.qw.qw(qw2, z6);
        if (qw3 != null) {
            qw3.ad(resourceCallback2);
            if (f4880i) {
                i("Added to existing load", ad2, qw2);
            }
            return new fe(resourceCallback2, qw3);
        }
        i qw4 = this.f4883fe.qw(qw2, z3, z4, z5, z6);
        DecodeJob<R> qw5 = this.f4887yj.qw(feVar, obj, qw2, key, i2, i3, cls, cls2, priority, yjVar, map, z, z2, z6, adVar, qw4);
        this.qw.de(qw2, qw4);
        qw4.ad(resourceCallback2);
        qw4.vvv(qw5);
        if (f4880i) {
            i("Started new load", ad2, qw2);
        }
        return new fe(resourceCallback2, qw4);
    }

    public final Cswitch<?> uk(Key key, boolean z) {
        if (!z) {
            return null;
        }
        Cswitch<?> rg2 = rg(key);
        if (rg2 != null) {
            rg2.de();
            this.f4886uk.qw(key, rg2);
        }
        return rg2;
    }

    @Nullable
    public final Cswitch<?> yj(Key key, boolean z) {
        if (!z) {
            return null;
        }
        Cswitch<?> rg2 = this.f4886uk.rg(key);
        if (rg2 != null) {
            rg2.de();
        }
        return rg2;
    }

    @VisibleForTesting
    public uk(MemoryCache memoryCache, DiskCache.Factory factory, GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, when when, Cif ifVar, qw qwVar, ad adVar, qw qwVar2, ddd ddd, boolean z) {
        this.f4882de = memoryCache;
        DiskCache.Factory factory2 = factory;
        this.f4885th = new de(factory);
        qw qwVar3 = qwVar == null ? new qw(z) : qwVar;
        this.f4886uk = qwVar3;
        qwVar3.yj(this);
        this.f4881ad = ifVar == null ? new Cif() : ifVar;
        this.qw = when == null ? new when() : when;
        this.f4883fe = adVar == null ? new ad(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, this) : adVar;
        this.f4887yj = qwVar2 == null ? new qw(this.f4885th) : qwVar2;
        this.f4884rg = ddd == null ? new ddd() : ddd;
        memoryCache.rg(this);
    }
}
