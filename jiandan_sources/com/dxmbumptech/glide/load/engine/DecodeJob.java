package com.dxmbumptech.glide.load.engine;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.baidu.android.common.others.lang.StringUtil;
import com.dxmbumptech.glide.Priority;
import com.dxmbumptech.glide.load.DataSource;
import com.dxmbumptech.glide.load.Key;
import com.dxmbumptech.glide.load.ResourceEncoder;
import com.dxmbumptech.glide.load.Transformation;
import com.dxmbumptech.glide.load.data.DataFetcher;
import com.dxmbumptech.glide.load.data.DataRewinder;
import com.dxmbumptech.glide.load.engine.DataFetcherGenerator;
import com.dxmbumptech.glide.load.engine.cache.DiskCache;
import com.dxmbumptech.glide.load.resource.bitmap.Downsampler;
import com.dxmbumptech.glide.util.pool.FactoryPools;
import fe.uk.qw.pf.fe.ggg;
import fe.uk.qw.pf.fe.nn;
import fe.uk.qw.pf.fe.pf;
import fe.uk.qw.pf.fe.ppp;
import fe.uk.qw.pf.fe.th;
import fe.uk.qw.pf.fe.vvv;
import fe.uk.qw.pf.fe.yj;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DecodeJob<R> implements DataFetcherGenerator.FetcherReadyCallback, Runnable, Comparable<DecodeJob<?>>, FactoryPools.Poolable {
    public Stage aaa;

    /* renamed from: ad  reason: collision with root package name */
    public final fe.uk.qw.pf.fe.rg<R> f3837ad = new fe.uk.qw.pf.fe.rg<>();
    public fe.uk.qw.pf.ad ddd;
    public Thread e;
    public long eee;
    public Key f;
    public Key g;
    public int ggg;
    public Object h;

    /* renamed from: i  reason: collision with root package name */
    public final Pools.Pool<DecodeJob<?>> f3838i;

    /* renamed from: if  reason: not valid java name */
    public fe.uk.qw.fe f145if;
    public DataSource j;
    public DataFetcher<?> k;
    public volatile DataFetcherGenerator l;
    public volatile boolean m;
    public int mmm;
    public volatile boolean n;
    public ad<R> nn;

    /* renamed from: o  reason: collision with root package name */
    public final fe<?> f3839o = new fe<>();
    public boolean p;

    /* renamed from: pf  reason: collision with root package name */
    public final th f3840pf = new th();
    public pf ppp;
    public RunReason qqq;
    public boolean rrr;

    /* renamed from: switch  reason: not valid java name */
    public Key f146switch;

    /* renamed from: th  reason: collision with root package name */
    public final List<Throwable> f3841th = new ArrayList();
    public Object tt;

    /* renamed from: uk  reason: collision with root package name */
    public final rg f3842uk;
    public int vvv;
    public Priority when;
    public yj xxx;

    /* renamed from: yj  reason: collision with root package name */
    public final fe.uk.qw.vvv.pf.ad f3843yj = fe.uk.qw.vvv.pf.ad.qw();

    public enum RunReason {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    public enum Stage {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    public interface ad<R> {
        void rg(GlideException glideException);

        void th(Resource<R> resource, DataSource dataSource, boolean z);

        void yj(DecodeJob<?> decodeJob);
    }

    public final class de<Z> implements th.qw<Z> {
        public final DataSource qw;

        public de(DataSource dataSource) {
            this.qw = dataSource;
        }

        @NonNull
        public Resource<Z> qw(@NonNull Resource<Z> resource) {
            return DecodeJob.this.eee(this.qw, resource);
        }
    }

    public static class fe<Z> {

        /* renamed from: ad  reason: collision with root package name */
        public ResourceEncoder<Z> f3845ad;

        /* renamed from: de  reason: collision with root package name */
        public ggg<Z> f3846de;
        public Key qw;

        public void ad(rg rgVar, fe.uk.qw.pf.ad adVar) {
            fe.uk.qw.vvv.pf.qw.qw("DecodeJob.encode");
            try {
                rgVar.qw().qw(this.qw, new fe.uk.qw.pf.fe.fe(this.f3845ad, this.f3846de, adVar));
            } finally {
                this.f3846de.yj();
                fe.uk.qw.vvv.pf.qw.fe();
            }
        }

        public boolean de() {
            return this.f3846de != null;
        }

        public <X> void fe(Key key, ResourceEncoder<X> resourceEncoder, ggg<X> ggg) {
            this.qw = key;
            this.f3845ad = resourceEncoder;
            this.f3846de = ggg;
        }

        public void qw() {
            this.qw = null;
            this.f3845ad = null;
            this.f3846de = null;
        }
    }

    public static /* synthetic */ class qw {

        /* renamed from: ad  reason: collision with root package name */
        public static final /* synthetic */ int[] f3847ad;

        /* renamed from: de  reason: collision with root package name */
        public static final /* synthetic */ int[] f3848de;
        public static final /* synthetic */ int[] qw;

        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|(2:5|6)|7|9|10|11|12|13|15|16|17|18|19|20|21|23|24|25|26|27|28|30) */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x006a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0074 */
        static {
            /*
                com.dxmbumptech.glide.load.EncodeStrategy[] r0 = com.dxmbumptech.glide.load.EncodeStrategy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3848de = r0
                r1 = 1
                com.dxmbumptech.glide.load.EncodeStrategy r2 = com.dxmbumptech.glide.load.EncodeStrategy.SOURCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f3848de     // Catch:{ NoSuchFieldError -> 0x001d }
                com.dxmbumptech.glide.load.EncodeStrategy r3 = com.dxmbumptech.glide.load.EncodeStrategy.TRANSFORMED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.dxmbumptech.glide.load.engine.DecodeJob$Stage[] r2 = com.dxmbumptech.glide.load.engine.DecodeJob.Stage.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f3847ad = r2
                com.dxmbumptech.glide.load.engine.DecodeJob$Stage r3 = com.dxmbumptech.glide.load.engine.DecodeJob.Stage.RESOURCE_CACHE     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r2 = f3847ad     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.dxmbumptech.glide.load.engine.DecodeJob$Stage r3 = com.dxmbumptech.glide.load.engine.DecodeJob.Stage.DATA_CACHE     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                r2 = 3
                int[] r3 = f3847ad     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.dxmbumptech.glide.load.engine.DecodeJob$Stage r4 = com.dxmbumptech.glide.load.engine.DecodeJob.Stage.SOURCE     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r3 = f3847ad     // Catch:{ NoSuchFieldError -> 0x004e }
                com.dxmbumptech.glide.load.engine.DecodeJob$Stage r4 = com.dxmbumptech.glide.load.engine.DecodeJob.Stage.FINISHED     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r3 = f3847ad     // Catch:{ NoSuchFieldError -> 0x0059 }
                com.dxmbumptech.glide.load.engine.DecodeJob$Stage r4 = com.dxmbumptech.glide.load.engine.DecodeJob.Stage.INITIALIZE     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                com.dxmbumptech.glide.load.engine.DecodeJob$RunReason[] r3 = com.dxmbumptech.glide.load.engine.DecodeJob.RunReason.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                qw = r3
                com.dxmbumptech.glide.load.engine.DecodeJob$RunReason r4 = com.dxmbumptech.glide.load.engine.DecodeJob.RunReason.INITIALIZE     // Catch:{ NoSuchFieldError -> 0x006a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x006a }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x006a }
            L_0x006a:
                int[] r1 = qw     // Catch:{ NoSuchFieldError -> 0x0074 }
                com.dxmbumptech.glide.load.engine.DecodeJob$RunReason r3 = com.dxmbumptech.glide.load.engine.DecodeJob.RunReason.SWITCH_TO_SOURCE_SERVICE     // Catch:{ NoSuchFieldError -> 0x0074 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0074 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0074 }
            L_0x0074:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x007e }
                com.dxmbumptech.glide.load.engine.DecodeJob$RunReason r1 = com.dxmbumptech.glide.load.engine.DecodeJob.RunReason.DECODE_DATA     // Catch:{ NoSuchFieldError -> 0x007e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007e }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007e }
            L_0x007e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.dxmbumptech.glide.load.engine.DecodeJob.qw.<clinit>():void");
        }
    }

    public interface rg {
        DiskCache qw();
    }

    public static class th {

        /* renamed from: ad  reason: collision with root package name */
        public boolean f3849ad;

        /* renamed from: de  reason: collision with root package name */
        public boolean f3850de;
        public boolean qw;

        public synchronized boolean ad() {
            this.f3849ad = true;
            return qw(false);
        }

        public synchronized boolean de() {
            this.f3850de = true;
            return qw(false);
        }

        public synchronized boolean fe(boolean z) {
            this.qw = true;
            return qw(z);
        }

        public final boolean qw(boolean z) {
            return (this.f3850de || z || this.f3849ad) && this.qw;
        }

        public synchronized void rg() {
            this.f3849ad = false;
            this.qw = false;
            this.f3850de = false;
        }
    }

    public DecodeJob(rg rgVar, Pools.Pool<DecodeJob<?>> pool) {
        this.f3842uk = rgVar;
        this.f3838i = pool;
    }

    public final void a() {
        this.e = Thread.currentThread();
        this.eee = fe.uk.qw.vvv.rg.ad();
        boolean z = false;
        while (!this.n && this.l != null && !(z = this.l.qw())) {
            this.aaa = m262switch(this.aaa);
            this.l = m261if();
            if (this.aaa == Stage.SOURCE) {
                ad();
                return;
            }
        }
        if ((this.aaa == Stage.FINISHED || this.n) && !z) {
            mmm();
        }
    }

    public final void aaa() {
        if (this.f3840pf.ad()) {
            tt();
        }
    }

    public void ad() {
        this.qqq = RunReason.SWITCH_TO_SOURCE_SERVICE;
        this.nn.yj(this);
    }

    public final <Data, ResourceType> Resource<R> b(Data data, DataSource dataSource, ppp<Data, ResourceType, R> ppp2) throws GlideException {
        fe.uk.qw.pf.ad when2 = when(dataSource);
        DataRewinder dataRewinder = this.f145if.i().m259if(data);
        try {
            return ppp2.qw(dataRewinder, when2, this.ggg, this.vvv, new de(dataSource));
        } finally {
            dataRewinder.ad();
        }
    }

    public final void c() {
        int i2 = qw.qw[this.qqq.ordinal()];
        if (i2 == 1) {
            this.aaa = m262switch(Stage.INITIALIZE);
            this.l = m261if();
            a();
        } else if (i2 == 2) {
            a();
        } else if (i2 == 3) {
            pf();
        } else {
            throw new IllegalStateException("Unrecognized run reason: " + this.qqq);
        }
    }

    public final void d() {
        Throwable th2;
        this.f3843yj.de();
        if (this.m) {
            if (this.f3841th.isEmpty()) {
                th2 = null;
            } else {
                List<Throwable> list = this.f3841th;
                th2 = list.get(list.size() - 1);
            }
            throw new IllegalStateException("Already notified", th2);
        }
        this.m = true;
    }

    public final void ddd(Resource<R> resource, DataSource dataSource, boolean z) {
        d();
        this.nn.th(resource, dataSource, z);
    }

    public boolean e() {
        Stage stage = m262switch(Stage.INITIALIZE);
        return stage == Stage.RESOURCE_CACHE || stage == Stage.DATA_CACHE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: fe.uk.qw.pf.fe.de} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v8, resolved type: fe.uk.qw.pf.fe.xxx} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: fe.uk.qw.pf.fe.xxx} */
    /* JADX WARNING: type inference failed for: r12v5, types: [com.dxmbumptech.glide.load.Key] */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <Z> com.dxmbumptech.glide.load.engine.Resource<Z> eee(com.dxmbumptech.glide.load.DataSource r12, @androidx.annotation.NonNull com.dxmbumptech.glide.load.engine.Resource<Z> r13) {
        /*
            r11 = this;
            java.lang.Object r0 = r13.get()
            java.lang.Class r8 = r0.getClass()
            com.dxmbumptech.glide.load.DataSource r0 = com.dxmbumptech.glide.load.DataSource.RESOURCE_DISK_CACHE
            r1 = 0
            if (r12 == r0) goto L_0x0020
            fe.uk.qw.pf.fe.rg<R> r0 = r11.f3837ad
            com.dxmbumptech.glide.load.Transformation r0 = r0.xxx(r8)
            fe.uk.qw.fe r2 = r11.f145if
            int r3 = r11.ggg
            int r4 = r11.vvv
            com.dxmbumptech.glide.load.engine.Resource r2 = r0.ad(r2, r13, r3, r4)
            r7 = r0
            r0 = r2
            goto L_0x0022
        L_0x0020:
            r0 = r13
            r7 = r1
        L_0x0022:
            boolean r2 = r13.equals(r0)
            if (r2 != 0) goto L_0x002b
            r13.recycle()
        L_0x002b:
            fe.uk.qw.pf.fe.rg<R> r13 = r11.f3837ad
            boolean r13 = r13.aaa(r0)
            if (r13 == 0) goto L_0x0040
            fe.uk.qw.pf.fe.rg<R> r13 = r11.f3837ad
            com.dxmbumptech.glide.load.ResourceEncoder r1 = r13.when(r0)
            fe.uk.qw.pf.ad r13 = r11.ddd
            com.dxmbumptech.glide.load.EncodeStrategy r13 = r1.ad(r13)
            goto L_0x0042
        L_0x0040:
            com.dxmbumptech.glide.load.EncodeStrategy r13 = com.dxmbumptech.glide.load.EncodeStrategy.NONE
        L_0x0042:
            r10 = r1
            fe.uk.qw.pf.fe.rg<R> r1 = r11.f3837ad
            com.dxmbumptech.glide.load.Key r2 = r11.f
            boolean r1 = r1.eee(r2)
            r2 = 1
            r1 = r1 ^ r2
            fe.uk.qw.pf.fe.yj r3 = r11.xxx
            boolean r12 = r3.fe(r1, r12, r13)
            if (r12 == 0) goto L_0x00b3
            if (r10 == 0) goto L_0x00a5
            int[] r12 = com.dxmbumptech.glide.load.engine.DecodeJob.qw.f3848de
            int r1 = r13.ordinal()
            r12 = r12[r1]
            if (r12 == r2) goto L_0x0092
            r1 = 2
            if (r12 != r1) goto L_0x007b
            fe.uk.qw.pf.fe.xxx r12 = new fe.uk.qw.pf.fe.xxx
            fe.uk.qw.pf.fe.rg<R> r13 = r11.f3837ad
            com.dxmbumptech.glide.load.engine.bitmap_recycle.ArrayPool r2 = r13.ad()
            com.dxmbumptech.glide.load.Key r3 = r11.f
            com.dxmbumptech.glide.load.Key r4 = r11.f146switch
            int r5 = r11.ggg
            int r6 = r11.vvv
            fe.uk.qw.pf.ad r9 = r11.ddd
            r1 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x009b
        L_0x007b:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown strategy: "
            r0.append(r1)
            r0.append(r13)
            java.lang.String r13 = r0.toString()
            r12.<init>(r13)
            throw r12
        L_0x0092:
            fe.uk.qw.pf.fe.de r12 = new fe.uk.qw.pf.fe.de
            com.dxmbumptech.glide.load.Key r13 = r11.f
            com.dxmbumptech.glide.load.Key r1 = r11.f146switch
            r12.<init>(r13, r1)
        L_0x009b:
            fe.uk.qw.pf.fe.ggg r0 = fe.uk.qw.pf.fe.ggg.rg(r0)
            com.dxmbumptech.glide.load.engine.DecodeJob$fe<?> r13 = r11.f3839o
            r13.fe(r12, r10, r0)
            goto L_0x00b3
        L_0x00a5:
            com.dxmbumptech.glide.Registry$NoResultEncoderAvailableException r12 = new com.dxmbumptech.glide.Registry$NoResultEncoderAvailableException
            java.lang.Object r13 = r0.get()
            java.lang.Class r13 = r13.getClass()
            r12.<init>(r13)
            throw r12
        L_0x00b3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dxmbumptech.glide.load.engine.DecodeJob.eee(com.dxmbumptech.glide.load.DataSource, com.dxmbumptech.glide.load.engine.Resource):com.dxmbumptech.glide.load.engine.Resource");
    }

    @NonNull
    public fe.uk.qw.vvv.pf.ad fe() {
        return this.f3843yj;
    }

    public DecodeJob<R> ggg(fe.uk.qw.fe feVar, Object obj, pf pfVar, Key key, int i2, int i3, Class<?> cls, Class<R> cls2, Priority priority, yj yjVar, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, boolean z3, fe.uk.qw.pf.ad adVar, ad<R> adVar2, int i4) {
        this.f3837ad.mmm(feVar, obj, key, i2, i3, yjVar, cls, cls2, priority, adVar, map, z, z2, this.f3842uk);
        this.f145if = feVar;
        this.f146switch = key;
        this.when = priority;
        this.ppp = pfVar;
        this.ggg = i2;
        this.vvv = i3;
        this.xxx = yjVar;
        this.rrr = z3;
        this.ddd = adVar;
        this.nn = adVar2;
        this.mmm = i4;
        this.qqq = RunReason.INITIALIZE;
        this.tt = obj;
        return this;
    }

    public final <Data> Resource<R> i(DataFetcher<?> dataFetcher, Data data, DataSource dataSource) throws GlideException {
        if (data == null) {
            dataFetcher.ad();
            return null;
        }
        try {
            long ad2 = fe.uk.qw.vvv.rg.ad();
            Resource<R> o2 = o(data, dataSource);
            if (Log.isLoggable("DecodeJob", 2)) {
                vvv("Decoded result " + o2, ad2);
            }
            return o2;
        } finally {
            dataFetcher.ad();
        }
    }

    /* renamed from: if  reason: not valid java name */
    public final DataFetcherGenerator m261if() {
        int i2 = qw.f3847ad[this.aaa.ordinal()];
        if (i2 == 1) {
            return new vvv(this.f3837ad, this);
        }
        if (i2 == 2) {
            return new fe.uk.qw.pf.fe.ad(this.f3837ad, this);
        }
        if (i2 == 3) {
            return new nn(this.f3837ad, this);
        }
        if (i2 == 4) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.aaa);
    }

    public final void mmm() {
        d();
        this.nn.rg(new GlideException("Failed to load resource", (List<Throwable>) new ArrayList(this.f3841th)));
        qqq();
    }

    public final void nn(Resource<R> resource, DataSource dataSource, boolean z) {
        if (resource instanceof Initializable) {
            ((Initializable) resource).initialize();
        }
        ggg<R> ggg2 = null;
        ggg<R> ggg3 = resource;
        if (this.f3839o.de()) {
            ggg<R> rg2 = ggg.rg(resource);
            ggg2 = rg2;
            ggg3 = rg2;
        }
        ddd(ggg3, dataSource, z);
        this.aaa = Stage.ENCODE;
        try {
            if (this.f3839o.de()) {
                this.f3839o.ad(this.f3842uk, this.ddd);
            }
            aaa();
        } finally {
            if (ggg2 != null) {
                ggg2.yj();
            }
        }
    }

    public final <Data> Resource<R> o(Data data, DataSource dataSource) throws GlideException {
        return b(data, dataSource, this.f3837ad.uk(data.getClass()));
    }

    public final void pf() {
        if (Log.isLoggable("DecodeJob", 2)) {
            long j2 = this.eee;
            xxx("Retrieved data", j2, "data: " + this.h + ", cache key: " + this.f + ", fetcher: " + this.k);
        }
        Resource<R> resource = null;
        try {
            resource = i(this.k, this.h, this.j);
        } catch (GlideException e2) {
            e2.setLoggingDetails(this.g, this.j);
            this.f3841th.add(e2);
        }
        if (resource != null) {
            nn(resource, this.j, this.p);
        } else {
            a();
        }
    }

    public final int ppp() {
        return this.when.ordinal();
    }

    public final void qqq() {
        if (this.f3840pf.de()) {
            tt();
        }
    }

    public void qw() {
        this.n = true;
        DataFetcherGenerator dataFetcherGenerator = this.l;
        if (dataFetcherGenerator != null) {
            dataFetcherGenerator.cancel();
        }
    }

    public void rg(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2) {
        this.f = key;
        this.h = obj;
        this.k = dataFetcher;
        this.j = dataSource;
        this.g = key2;
        boolean z = false;
        if (key != this.f3837ad.de().get(0)) {
            z = true;
        }
        this.p = z;
        if (Thread.currentThread() != this.e) {
            this.qqq = RunReason.DECODE_DATA;
            this.nn.yj(this);
            return;
        }
        fe.uk.qw.vvv.pf.qw.qw("DecodeJob.decodeFromRetrievedData");
        try {
            pf();
        } finally {
            fe.uk.qw.vvv.pf.qw.fe();
        }
    }

    public void rrr(boolean z) {
        if (this.f3840pf.fe(z)) {
            tt();
        }
    }

    public void run() {
        fe.uk.qw.vvv.pf.qw.ad("DecodeJob#run(model=%s)", this.tt);
        DataFetcher<?> dataFetcher = this.k;
        try {
            if (this.n) {
                mmm();
                if (dataFetcher != null) {
                    dataFetcher.ad();
                }
                fe.uk.qw.vvv.pf.qw.fe();
                return;
            }
            c();
            if (dataFetcher != null) {
                dataFetcher.ad();
            }
            fe.uk.qw.vvv.pf.qw.fe();
        } catch (CallbackException e2) {
            throw e2;
        } catch (Throwable th2) {
            if (dataFetcher != null) {
                dataFetcher.ad();
            }
            fe.uk.qw.vvv.pf.qw.fe();
            throw th2;
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public final Stage m262switch(Stage stage) {
        int i2 = qw.f3847ad[stage.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return this.rrr ? Stage.FINISHED : Stage.SOURCE;
            }
            if (i2 == 3 || i2 == 4) {
                return Stage.FINISHED;
            }
            if (i2 != 5) {
                throw new IllegalArgumentException("Unrecognized stage: " + stage);
            } else if (this.xxx.ad()) {
                return Stage.RESOURCE_CACHE;
            } else {
                return m262switch(Stage.RESOURCE_CACHE);
            }
        } else if (this.xxx.qw()) {
            return Stage.DATA_CACHE;
        } else {
            return m262switch(Stage.DATA_CACHE);
        }
    }

    public void th(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource) {
        dataFetcher.ad();
        GlideException glideException = new GlideException("Fetching data failed", (Throwable) exc);
        glideException.setLoggingDetails(key, dataSource, dataFetcher.qw());
        this.f3841th.add(glideException);
        if (Thread.currentThread() != this.e) {
            this.qqq = RunReason.SWITCH_TO_SOURCE_SERVICE;
            this.nn.yj(this);
            return;
        }
        a();
    }

    public final void tt() {
        this.f3840pf.rg();
        this.f3839o.qw();
        this.f3837ad.qw();
        this.m = false;
        this.f145if = null;
        this.f146switch = null;
        this.ddd = null;
        this.when = null;
        this.ppp = null;
        this.nn = null;
        this.aaa = null;
        this.l = null;
        this.e = null;
        this.f = null;
        this.h = null;
        this.j = null;
        this.k = null;
        this.eee = 0;
        this.n = false;
        this.tt = null;
        this.f3841th.clear();
        this.f3838i.release(this);
    }

    /* renamed from: uk */
    public int compareTo(@NonNull DecodeJob<?> decodeJob) {
        int ppp2 = ppp() - decodeJob.ppp();
        return ppp2 == 0 ? this.mmm - decodeJob.mmm : ppp2;
    }

    public final void vvv(String str, long j2) {
        xxx(str, j2, (String) null);
    }

    @NonNull
    public final fe.uk.qw.pf.ad when(DataSource dataSource) {
        fe.uk.qw.pf.ad adVar = this.ddd;
        if (Build.VERSION.SDK_INT < 26) {
            return adVar;
        }
        boolean z = dataSource == DataSource.RESOURCE_DISK_CACHE || this.f3837ad.qqq();
        Boolean bool = (Boolean) adVar.de(Downsampler.f3888i);
        if (bool != null && (!bool.booleanValue() || z)) {
            return adVar;
        }
        fe.uk.qw.pf.ad adVar2 = new fe.uk.qw.pf.ad();
        adVar2.fe(this.ddd);
        adVar2.rg(Downsampler.f3888i, Boolean.valueOf(z));
        return adVar2;
    }

    public final void xxx(String str, long j2, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(fe.uk.qw.vvv.rg.qw(j2));
        sb.append(", load key: ");
        sb.append(this.ppp);
        if (str2 != null) {
            str3 = StringUtil.ARRAY_ELEMENT_SEPARATOR + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        sb.toString();
    }
}
