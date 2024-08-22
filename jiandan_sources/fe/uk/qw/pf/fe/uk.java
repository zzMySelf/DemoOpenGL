package fe.uk.qw.pf.fe;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.dxmbumptech.glide.Priority;
import com.dxmbumptech.glide.load.DataSource;
import com.dxmbumptech.glide.load.Key;
import com.dxmbumptech.glide.load.Transformation;
import com.dxmbumptech.glide.load.engine.DecodeJob;
import com.dxmbumptech.glide.load.engine.Resource;
import com.dxmbumptech.glide.load.engine.cache.DiskCache;
import com.dxmbumptech.glide.load.engine.cache.MemoryCache;
import com.dxmbumptech.glide.load.engine.executor.GlideExecutor;
import com.dxmbumptech.glide.request.ResourceCallback;
import com.dxmbumptech.glide.util.pool.FactoryPools;
import fe.uk.qw.pf.fe.Cswitch;
import fe.uk.qw.vvv.i;
import fe.uk.qw.vvv.rg;
import java.util.Map;
import java.util.concurrent.Executor;

public class uk implements o, MemoryCache.ResourceRemovedListener, Cswitch.qw {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f5854i = Log.isLoggable("Engine", 2);

    /* renamed from: ad  reason: collision with root package name */
    public final Cif f5855ad;

    /* renamed from: de  reason: collision with root package name */
    public final MemoryCache f5856de;

    /* renamed from: fe  reason: collision with root package name */
    public final ad f5857fe;
    public final when qw;

    /* renamed from: rg  reason: collision with root package name */
    public final ddd f5858rg;

    /* renamed from: th  reason: collision with root package name */
    public final de f5859th;

    /* renamed from: uk  reason: collision with root package name */
    public final qw f5860uk;

    /* renamed from: yj  reason: collision with root package name */
    public final qw f5861yj;

    @VisibleForTesting
    public static class ad {

        /* renamed from: ad  reason: collision with root package name */
        public final GlideExecutor f5862ad;

        /* renamed from: de  reason: collision with root package name */
        public final GlideExecutor f5863de;

        /* renamed from: fe  reason: collision with root package name */
        public final GlideExecutor f5864fe;
        public final GlideExecutor qw;

        /* renamed from: rg  reason: collision with root package name */
        public final o f5865rg;

        /* renamed from: th  reason: collision with root package name */
        public final Cswitch.qw f5866th;

        /* renamed from: yj  reason: collision with root package name */
        public final Pools.Pool<i<?>> f5867yj = FactoryPools.fe(150, new qw());

        public class qw implements FactoryPools.Factory<i<?>> {
            public qw() {
            }

            /* renamed from: ad */
            public i<?> qw() {
                ad adVar = ad.this;
                return new i(adVar.qw, adVar.f5862ad, adVar.f5863de, adVar.f5864fe, adVar.f5865rg, adVar.f5866th, adVar.f5867yj);
            }
        }

        public ad(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, o oVar, Cswitch.qw qwVar) {
            this.qw = glideExecutor;
            this.f5862ad = glideExecutor2;
            this.f5863de = glideExecutor3;
            this.f5864fe = glideExecutor4;
            this.f5865rg = oVar;
            this.f5866th = qwVar;
        }

        public <R> i<R> qw(Key key, boolean z, boolean z2, boolean z3, boolean z4) {
            i<R> acquire = this.f5867yj.acquire();
            i.fe(acquire);
            i<R> iVar = acquire;
            iVar.m373if(key, z, z2, z3, z4);
            return iVar;
        }
    }

    public static class de implements DecodeJob.rg {

        /* renamed from: ad  reason: collision with root package name */
        public volatile DiskCache f5868ad;
        public final DiskCache.Factory qw;

        public de(DiskCache.Factory factory) {
            this.qw = factory;
        }

        public DiskCache qw() {
            if (this.f5868ad == null) {
                synchronized (this) {
                    if (this.f5868ad == null) {
                        this.f5868ad = this.qw.build();
                    }
                    if (this.f5868ad == null) {
                        this.f5868ad = new fe.uk.qw.pf.fe.aaa.qw();
                    }
                }
            }
            return this.f5868ad;
        }
    }

    public class fe {

        /* renamed from: ad  reason: collision with root package name */
        public final ResourceCallback f5869ad;
        public final i<?> qw;

        public fe(ResourceCallback resourceCallback, i<?> iVar) {
            this.f5869ad = resourceCallback;
            this.qw = iVar;
        }

        public void qw() {
            synchronized (uk.this) {
                this.qw.xxx(this.f5869ad);
            }
        }
    }

    @VisibleForTesting
    public static class qw {

        /* renamed from: ad  reason: collision with root package name */
        public final Pools.Pool<DecodeJob<?>> f5871ad = FactoryPools.fe(150, new C0236qw());

        /* renamed from: de  reason: collision with root package name */
        public int f5872de;
        public final DecodeJob.rg qw;

        /* renamed from: fe.uk.qw.pf.fe.uk$qw$qw  reason: collision with other inner class name */
        public class C0236qw implements FactoryPools.Factory<DecodeJob<?>> {
            public C0236qw() {
            }

            /* renamed from: ad */
            public DecodeJob<?> qw() {
                qw qwVar = qw.this;
                return new DecodeJob<>(qwVar.qw, qwVar.f5871ad);
            }
        }

        public qw(DecodeJob.rg rgVar) {
            this.qw = rgVar;
        }

        public <R> DecodeJob<R> qw(fe.uk.qw.fe feVar, Object obj, pf pfVar, Key key, int i2, int i3, Class<?> cls, Class<R> cls2, Priority priority, yj yjVar, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, boolean z3, fe.uk.qw.pf.ad adVar, DecodeJob.ad<R> adVar2) {
            DecodeJob<R> acquire = this.f5871ad.acquire();
            i.fe(acquire);
            DecodeJob<R> decodeJob = acquire;
            int i4 = this.f5872de;
            int i5 = i4;
            this.f5872de = i4 + 1;
            decodeJob.ggg(feVar, obj, pfVar, key, i2, i3, cls, cls2, priority, yjVar, map, z, z2, z3, adVar, adVar2, i5);
            return decodeJob;
        }
    }

    public uk(MemoryCache memoryCache, DiskCache.Factory factory, GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, boolean z) {
        this(memoryCache, factory, glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, (when) null, (Cif) null, (qw) null, (ad) null, (qw) null, (ddd) null, z);
    }

    public static void o(String str, long j, Key key) {
        str + " in " + rg.qw(j) + "ms, key: " + key;
    }

    public synchronized void ad(i<?> iVar, Key key) {
        this.qw.fe(key, iVar);
    }

    public void de(@NonNull Resource<?> resource) {
        this.f5858rg.qw(resource, true);
    }

    public void fe(Key key, Cswitch<?> switchR) {
        this.f5860uk.fe(key);
        if (switchR.rg()) {
            this.f5856de.de(key, switchR);
        } else {
            this.f5858rg.qw(switchR, false);
        }
    }

    @Nullable
    public final Cswitch<?> i(pf pfVar, boolean z, long j) {
        if (!z) {
            return null;
        }
        Cswitch<?> yj2 = yj(pfVar);
        if (yj2 != null) {
            if (f5854i) {
                o("Loaded resource from active resources", j, pfVar);
            }
            return yj2;
        }
        Cswitch<?> uk2 = uk(pfVar);
        if (uk2 == null) {
            return null;
        }
        if (f5854i) {
            o("Loaded resource from cache", j, pfVar);
        }
        return uk2;
    }

    /* renamed from: if  reason: not valid java name */
    public final <R> fe m381if(fe.uk.qw.fe feVar, Object obj, Key key, int i2, int i3, Class<?> cls, Class<R> cls2, Priority priority, yj yjVar, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, fe.uk.qw.pf.ad adVar, boolean z3, boolean z4, boolean z5, boolean z6, ResourceCallback resourceCallback, Executor executor, pf pfVar, long j) {
        ResourceCallback resourceCallback2 = resourceCallback;
        Executor executor2 = executor;
        pf pfVar2 = pfVar;
        long j2 = j;
        i<?> qw2 = this.qw.qw(pfVar2, z6);
        if (qw2 != null) {
            qw2.qw(resourceCallback2, executor2);
            if (f5854i) {
                o("Added to existing load", j2, pfVar2);
            }
            return new fe(resourceCallback2, qw2);
        }
        i qw3 = this.f5857fe.qw(pfVar, z3, z4, z5, z6);
        i iVar = qw3;
        pf pfVar3 = pfVar2;
        DecodeJob<R> qw4 = this.f5861yj.qw(feVar, obj, pfVar, key, i2, i3, cls, cls2, priority, yjVar, map, z, z2, z6, adVar, qw3);
        this.qw.de(pfVar3, iVar);
        i iVar2 = iVar;
        pf pfVar4 = pfVar3;
        ResourceCallback resourceCallback3 = resourceCallback;
        iVar2.qw(resourceCallback3, executor);
        iVar2.ddd(qw4);
        if (f5854i) {
            o("Started new load", j, pfVar4);
        }
        return new fe(resourceCallback3, iVar2);
    }

    public void pf(Resource<?> resource) {
        if (resource instanceof Cswitch) {
            ((Cswitch) resource).th();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    public synchronized void qw(i<?> iVar, Key key, Cswitch<?> switchR) {
        if (switchR != null) {
            if (switchR.rg()) {
                this.f5860uk.qw(key, switchR);
            }
        }
        this.qw.fe(key, iVar);
    }

    public final Cswitch<?> rg(Key key) {
        Resource<?> rg2 = this.f5856de.rg(key);
        if (rg2 == null) {
            return null;
        }
        if (rg2 instanceof Cswitch) {
            return (Cswitch) rg2;
        }
        return new Cswitch<>(rg2, true, true, key, this);
    }

    public <R> fe th(fe.uk.qw.fe feVar, Object obj, Key key, int i2, int i3, Class<?> cls, Class<R> cls2, Priority priority, yj yjVar, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, fe.uk.qw.pf.ad adVar, boolean z3, boolean z4, boolean z5, boolean z6, ResourceCallback resourceCallback, Executor executor) {
        long ad2 = f5854i ? rg.ad() : 0;
        pf qw2 = this.f5855ad.qw(obj, key, i2, i3, map, cls, cls2, adVar);
        synchronized (this) {
            Cswitch<?> i4 = i(qw2, z3, ad2);
            if (i4 == null) {
                fe feVar2 = m381if(feVar, obj, key, i2, i3, cls, cls2, priority, yjVar, map, z, z2, adVar, z3, z4, z5, z6, resourceCallback, executor, qw2, ad2);
                return feVar2;
            }
            resourceCallback.th(i4, DataSource.MEMORY_CACHE, false);
            return null;
        }
    }

    public final Cswitch<?> uk(Key key) {
        Cswitch<?> rg2 = rg(key);
        if (rg2 != null) {
            rg2.de();
            this.f5860uk.qw(key, rg2);
        }
        return rg2;
    }

    @Nullable
    public final Cswitch<?> yj(Key key) {
        Cswitch<?> rg2 = this.f5860uk.rg(key);
        if (rg2 != null) {
            rg2.de();
        }
        return rg2;
    }

    @VisibleForTesting
    public uk(MemoryCache memoryCache, DiskCache.Factory factory, GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, when when, Cif ifVar, qw qwVar, ad adVar, qw qwVar2, ddd ddd, boolean z) {
        this.f5856de = memoryCache;
        DiskCache.Factory factory2 = factory;
        this.f5859th = new de(factory);
        qw qwVar3 = qwVar == null ? new qw(z) : qwVar;
        this.f5860uk = qwVar3;
        qwVar3.th(this);
        this.f5855ad = ifVar == null ? new Cif() : ifVar;
        this.qw = when == null ? new when() : when;
        this.f5857fe = adVar == null ? new ad(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, this, this) : adVar;
        this.f5861yj = qwVar2 == null ? new qw(this.f5859th) : qwVar2;
        this.f5858rg = ddd == null ? new ddd() : ddd;
        memoryCache.fe(this);
    }
}
