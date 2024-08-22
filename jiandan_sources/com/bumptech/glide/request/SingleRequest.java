package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.util.pool.FactoryPools;
import com.dlife.ctaccountapi.x;
import fe.rg.qw.fe;
import fe.rg.qw.ggg.i;
import fe.rg.qw.o.fe.uk;
import fe.rg.qw.when.ad;
import java.util.List;

public final class SingleRequest<R> implements Request, SizeReadyCallback, ResourceCallback, FactoryPools.Poolable {
    public static final Pools.Pool<SingleRequest<?>> j = FactoryPools.fe(150, new qw());
    public static final boolean k = Log.isLoggable("Request", 2);
    public Resource<R> aaa;

    /* renamed from: ad  reason: collision with root package name */
    public boolean f3754ad;
    @Nullable
    public List<RequestListener<R>> ddd;
    public Drawable e;
    public long eee;
    public Drawable f;
    public int g;
    public int ggg;
    public int h;

    /* renamed from: i  reason: collision with root package name */
    public RequestCoordinator f3755i;
    @Nullable

    /* renamed from: if  reason: not valid java name */
    public Object f139if;
    public TransitionFactory<? super R> mmm;
    public uk nn;

    /* renamed from: o  reason: collision with root package name */
    public Context f3756o;

    /* renamed from: pf  reason: collision with root package name */
    public fe f3757pf;
    public int ppp;
    public uk.fe qqq;
    public Status rrr;

    /* renamed from: switch  reason: not valid java name */
    public Class<R> f140switch;
    @Nullable

    /* renamed from: th  reason: collision with root package name */
    public final String f3758th;
    public Drawable tt;
    @Nullable

    /* renamed from: uk  reason: collision with root package name */
    public RequestListener<R> f3759uk;
    public Priority vvv;
    public ad when;
    public Target<R> xxx;

    /* renamed from: yj  reason: collision with root package name */
    public final fe.rg.qw.ggg.o.ad f3760yj;

    public enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    public class qw implements FactoryPools.Factory<SingleRequest<?>> {
        /* renamed from: ad */
        public SingleRequest<?> qw() {
            return new SingleRequest<>();
        }
    }

    public SingleRequest() {
        this.f3758th = k ? String.valueOf(super.hashCode()) : null;
        this.f3760yj = fe.rg.qw.ggg.o.ad.qw();
    }

    public static int aaa(int i2, float f2) {
        return i2 == Integer.MIN_VALUE ? i2 : Math.round(f2 * ((float) i2));
    }

    public static boolean ddd(SingleRequest<?> singleRequest, SingleRequest<?> singleRequest2) {
        List<RequestListener<R>> list = singleRequest.ddd;
        int size = list == null ? 0 : list.size();
        List<RequestListener<R>> list2 = singleRequest2.ddd;
        if (size == (list2 == null ? 0 : list2.size())) {
            return true;
        }
        return false;
    }

    public static <R> SingleRequest<R> rrr(Context context, fe feVar, Object obj, Class<R> cls, ad adVar, int i2, int i3, Priority priority, Target<R> target, RequestListener<R> requestListener, @Nullable List<RequestListener<R>> list, RequestCoordinator requestCoordinator, uk ukVar, TransitionFactory<? super R> transitionFactory) {
        SingleRequest<R> acquire = j.acquire();
        if (acquire == null) {
            acquire = new SingleRequest<>();
        }
        acquire.vvv(context, feVar, obj, cls, adVar, i2, i3, priority, target, requestListener, list, requestCoordinator, ukVar, transitionFactory);
        return acquire;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a5 A[Catch:{ all -> 0x00b6 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.bumptech.glide.load.engine.Resource<R> r11, R r12, com.bumptech.glide.load.DataSource r13) {
        /*
            r10 = this;
            boolean r6 = r10.xxx()
            com.bumptech.glide.request.SingleRequest$Status r0 = com.bumptech.glide.request.SingleRequest.Status.COMPLETE
            r10.rrr = r0
            r10.aaa = r11
            fe.rg.qw.fe r11 = r10.f3757pf
            int r11 = r11.th()
            r0 = 3
            if (r11 > r0) goto L_0x0064
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "Finished loading "
            r11.append(r0)
            java.lang.Class r0 = r12.getClass()
            java.lang.String r0 = r0.getSimpleName()
            r11.append(r0)
            java.lang.String r0 = " from "
            r11.append(r0)
            r11.append(r13)
            java.lang.String r0 = " for "
            r11.append(r0)
            java.lang.Object r0 = r10.f139if
            r11.append(r0)
            java.lang.String r0 = " with size ["
            r11.append(r0)
            int r0 = r10.g
            r11.append(r0)
            java.lang.String r0 = "x"
            r11.append(r0)
            int r0 = r10.h
            r11.append(r0)
            java.lang.String r0 = "] in "
            r11.append(r0)
            long r0 = r10.eee
            double r0 = fe.rg.qw.ggg.fe.qw(r0)
            r11.append(r0)
            java.lang.String r0 = " ms"
            r11.append(r0)
            r11.toString()
        L_0x0064:
            r11 = 1
            r10.f3754ad = r11
            r7 = 0
            java.util.List<com.bumptech.glide.request.RequestListener<R>> r0 = r10.ddd     // Catch:{ all -> 0x00b6 }
            if (r0 == 0) goto L_0x008c
            java.util.List<com.bumptech.glide.request.RequestListener<R>> r0 = r10.ddd     // Catch:{ all -> 0x00b6 }
            java.util.Iterator r8 = r0.iterator()     // Catch:{ all -> 0x00b6 }
            r9 = 0
        L_0x0073:
            boolean r0 = r8.hasNext()     // Catch:{ all -> 0x00b6 }
            if (r0 == 0) goto L_0x008d
            java.lang.Object r0 = r8.next()     // Catch:{ all -> 0x00b6 }
            com.bumptech.glide.request.RequestListener r0 = (com.bumptech.glide.request.RequestListener) r0     // Catch:{ all -> 0x00b6 }
            java.lang.Object r2 = r10.f139if     // Catch:{ all -> 0x00b6 }
            com.bumptech.glide.request.target.Target<R> r3 = r10.xxx     // Catch:{ all -> 0x00b6 }
            r1 = r12
            r4 = r13
            r5 = r6
            boolean r0 = r0.ad(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00b6 }
            r9 = r9 | r0
            goto L_0x0073
        L_0x008c:
            r9 = 0
        L_0x008d:
            com.bumptech.glide.request.RequestListener<R> r0 = r10.f3759uk     // Catch:{ all -> 0x00b6 }
            if (r0 == 0) goto L_0x00a1
            com.bumptech.glide.request.RequestListener<R> r0 = r10.f3759uk     // Catch:{ all -> 0x00b6 }
            java.lang.Object r2 = r10.f139if     // Catch:{ all -> 0x00b6 }
            com.bumptech.glide.request.target.Target<R> r3 = r10.xxx     // Catch:{ all -> 0x00b6 }
            r1 = r12
            r4 = r13
            r5 = r6
            boolean r0 = r0.ad(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00b6 }
            if (r0 == 0) goto L_0x00a1
            goto L_0x00a2
        L_0x00a1:
            r11 = 0
        L_0x00a2:
            r11 = r11 | r9
            if (r11 != 0) goto L_0x00b0
            com.bumptech.glide.request.transition.TransitionFactory<? super R> r11 = r10.mmm     // Catch:{ all -> 0x00b6 }
            com.bumptech.glide.request.transition.Transition r11 = r11.qw(r13, r6)     // Catch:{ all -> 0x00b6 }
            com.bumptech.glide.request.target.Target<R> r13 = r10.xxx     // Catch:{ all -> 0x00b6 }
            r13.rg(r12, r11)     // Catch:{ all -> 0x00b6 }
        L_0x00b0:
            r10.f3754ad = r7
            r10.eee()
            return
        L_0x00b6:
            r11 = move-exception
            r10.f3754ad = r7
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.a(com.bumptech.glide.load.engine.Resource, java.lang.Object, com.bumptech.glide.load.DataSource):void");
    }

    public void ad(int i2, int i3) {
        this.f3760yj.de();
        if (k) {
            mmm("Got onSizeReady in " + fe.rg.qw.ggg.fe.qw(this.eee));
        }
        if (this.rrr == Status.WAITING_FOR_SIZE) {
            this.rrr = Status.RUNNING;
            float tt2 = this.when.tt();
            this.g = aaa(i2, tt2);
            this.h = aaa(i3, tt2);
            if (k) {
                mmm("finished setup for calling load in " + fe.rg.qw.ggg.fe.qw(this.eee));
            }
            uk ukVar = this.nn;
            fe feVar = this.f3757pf;
            uk.fe th2 = ukVar.th(feVar, this.f139if, this.when.rrr(), this.g, this.h, this.when.eee(), this.f140switch, this.vvv, this.when.m323if(), this.when.b(), this.when.l(), this.when.g(), this.when.xxx(), this.when.e(), this.when.d(), this.when.c(), this.when.vvv(), this);
            this.qqq = th2;
            if (this.rrr != Status.RUNNING) {
                this.qqq = null;
            }
            if (k) {
                mmm("finished onSizeReady in " + fe.rg.qw.ggg.fe.qw(this.eee));
            }
        }
    }

    public final void b(Resource<?> resource) {
        this.nn.o(resource);
        this.aaa = null;
    }

    public void begin() {
        i();
        this.f3760yj.de();
        this.eee = fe.rg.qw.ggg.fe.ad();
        if (this.f139if == null) {
            if (i.xxx(this.ppp, this.ggg)) {
                this.g = this.ppp;
                this.h = this.ggg;
            }
            tt(new GlideException("Received null model"), ppp() == null ? 5 : 3);
            return;
        }
        Status status = this.rrr;
        if (status == Status.RUNNING) {
            throw new IllegalArgumentException("Cannot restart a running request");
        } else if (status == Status.COMPLETE) {
            rg(this.aaa, DataSource.MEMORY_CACHE);
        } else {
            this.rrr = Status.WAITING_FOR_SIZE;
            if (i.xxx(this.ppp, this.ggg)) {
                ad(this.ppp, this.ggg);
            } else {
                this.xxx.yj(this);
            }
            Status status2 = this.rrr;
            if ((status2 == Status.RUNNING || status2 == Status.WAITING_FOR_SIZE) && pf()) {
                this.xxx.qw(ggg());
            }
            if (k) {
                mmm("finished run method in " + fe.rg.qw.ggg.fe.qw(this.eee));
            }
        }
    }

    public final void c() {
        if (pf()) {
            Drawable drawable = null;
            if (this.f139if == null) {
                drawable = ppp();
            }
            if (drawable == null) {
                drawable = when();
            }
            if (drawable == null) {
                drawable = ggg();
            }
            this.xxx.de(drawable);
        }
    }

    public void clear() {
        i.qw();
        i();
        this.f3760yj.de();
        if (this.rrr != Status.CLEARED) {
            m256switch();
            Resource<R> resource = this.aaa;
            if (resource != null) {
                b(resource);
            }
            if (o()) {
                this.xxx.ad(ggg());
            }
            this.rrr = Status.CLEARED;
        }
    }

    public boolean de() {
        return this.rrr == Status.CLEARED;
    }

    public final void eee() {
        RequestCoordinator requestCoordinator = this.f3755i;
        if (requestCoordinator != null) {
            requestCoordinator.i(this);
        }
    }

    @NonNull
    public fe.rg.qw.ggg.o.ad fe() {
        return this.f3760yj;
    }

    public final Drawable ggg() {
        if (this.e == null) {
            Drawable mmm2 = this.when.mmm();
            this.e = mmm2;
            if (mmm2 == null && this.when.aaa() > 0) {
                this.e = nn(this.when.aaa());
            }
        }
        return this.e;
    }

    public final void i() {
        if (this.f3754ad) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    /* renamed from: if  reason: not valid java name */
    public final boolean m255if() {
        RequestCoordinator requestCoordinator = this.f3755i;
        return requestCoordinator == null || requestCoordinator.fe(this);
    }

    public boolean isComplete() {
        return this.rrr == Status.COMPLETE;
    }

    public boolean isRunning() {
        Status status = this.rrr;
        return status == Status.RUNNING || status == Status.WAITING_FOR_SIZE;
    }

    public final void mmm(String str) {
        str + " this: " + this.f3758th;
    }

    public final Drawable nn(@DrawableRes int i2) {
        return fe.rg.qw.o.th.rg.qw.qw(this.f3757pf, i2, this.when.a() != null ? this.when.a() : this.f3756o.getTheme());
    }

    public final boolean o() {
        RequestCoordinator requestCoordinator = this.f3755i;
        return requestCoordinator == null || requestCoordinator.o(this);
    }

    public final boolean pf() {
        RequestCoordinator requestCoordinator = this.f3755i;
        return requestCoordinator == null || requestCoordinator.ad(this);
    }

    public final Drawable ppp() {
        if (this.f == null) {
            Drawable ppp2 = this.when.ppp();
            this.f = ppp2;
            if (ppp2 == null && this.when.ggg() > 0) {
                this.f = nn(this.when.ggg());
            }
        }
        return this.f;
    }

    public final void qqq() {
        RequestCoordinator requestCoordinator = this.f3755i;
        if (requestCoordinator != null) {
            requestCoordinator.rg(this);
        }
    }

    public void qw(GlideException glideException) {
        tt(glideException, 5);
    }

    public void recycle() {
        i();
        this.f3756o = null;
        this.f3757pf = null;
        this.f139if = null;
        this.f140switch = null;
        this.when = null;
        this.ppp = -1;
        this.ggg = -1;
        this.xxx = null;
        this.ddd = null;
        this.f3759uk = null;
        this.f3755i = null;
        this.mmm = null;
        this.qqq = null;
        this.tt = null;
        this.e = null;
        this.f = null;
        this.g = -1;
        this.h = -1;
        j.release(this);
    }

    public void rg(Resource<?> resource, DataSource dataSource) {
        this.f3760yj.de();
        this.qqq = null;
        if (resource == null) {
            qw(new GlideException("Expected to receive a Resource<R> with an object of " + this.f140switch + " inside, but instead got null."));
            return;
        }
        Object obj = resource.get();
        if (obj == null || !this.f140switch.isAssignableFrom(obj.getClass())) {
            b(resource);
            StringBuilder sb = new StringBuilder();
            sb.append("Expected to receive an object of ");
            sb.append(this.f140switch);
            sb.append(" but instead got ");
            String str = "";
            sb.append(obj != null ? obj.getClass() : str);
            sb.append(StringUtil.ARRAY_START);
            sb.append(obj);
            sb.append("} inside Resource{");
            sb.append(resource);
            sb.append("}.");
            if (obj == null) {
                str = " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
            }
            sb.append(str);
            qw(new GlideException(sb.toString()));
        } else if (!m255if()) {
            b(resource);
            this.rrr = Status.COMPLETE;
        } else {
            a(resource, obj, dataSource);
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public final void m256switch() {
        i();
        this.f3760yj.de();
        this.xxx.fe(this);
        uk.fe feVar = this.qqq;
        if (feVar != null) {
            feVar.qw();
            this.qqq = null;
        }
    }

    public boolean th() {
        return isComplete();
    }

    /* JADX INFO: finally extract failed */
    public final void tt(GlideException glideException, int i2) {
        boolean z;
        this.f3760yj.de();
        int th2 = this.f3757pf.th();
        if (th2 <= i2) {
            "Load failed for " + this.f139if + " with size [" + this.g + x.a + this.h + "]";
            if (th2 <= 4) {
                glideException.logRootCauses(BaiduWalletDelegate.b);
            }
        }
        this.qqq = null;
        this.rrr = Status.FAILED;
        boolean z2 = true;
        this.f3754ad = true;
        try {
            if (this.ddd != null) {
                z = false;
                for (RequestListener<R> qw2 : this.ddd) {
                    z |= qw2.qw(glideException, this.f139if, this.xxx, xxx());
                }
            } else {
                z = false;
            }
            if (this.f3759uk == null || !this.f3759uk.qw(glideException, this.f139if, this.xxx, xxx())) {
                z2 = false;
            }
            if (!z && !z2) {
                c();
            }
            this.f3754ad = false;
            qqq();
        } catch (Throwable th3) {
            this.f3754ad = false;
            throw th3;
        }
    }

    public boolean uk(Request request) {
        if (!(request instanceof SingleRequest)) {
            return false;
        }
        SingleRequest singleRequest = (SingleRequest) request;
        if (this.ppp != singleRequest.ppp || this.ggg != singleRequest.ggg || !i.ad(this.f139if, singleRequest.f139if) || !this.f140switch.equals(singleRequest.f140switch) || !this.when.equals(singleRequest.when) || this.vvv != singleRequest.vvv || !ddd(this, singleRequest)) {
            return false;
        }
        return true;
    }

    public final void vvv(Context context, fe feVar, Object obj, Class<R> cls, ad adVar, int i2, int i3, Priority priority, Target<R> target, RequestListener<R> requestListener, @Nullable List<RequestListener<R>> list, RequestCoordinator requestCoordinator, uk ukVar, TransitionFactory<? super R> transitionFactory) {
        this.f3756o = context;
        this.f3757pf = feVar;
        this.f139if = obj;
        this.f140switch = cls;
        this.when = adVar;
        this.ppp = i2;
        this.ggg = i3;
        this.vvv = priority;
        this.xxx = target;
        this.f3759uk = requestListener;
        this.ddd = list;
        this.f3755i = requestCoordinator;
        this.nn = ukVar;
        this.mmm = transitionFactory;
        this.rrr = Status.PENDING;
    }

    public final Drawable when() {
        if (this.tt == null) {
            Drawable when2 = this.when.when();
            this.tt = when2;
            if (when2 == null && this.when.m324switch() > 0) {
                this.tt = nn(this.when.m324switch());
            }
        }
        return this.tt;
    }

    public final boolean xxx() {
        RequestCoordinator requestCoordinator = this.f3755i;
        return requestCoordinator == null || !requestCoordinator.qw();
    }

    public boolean yj() {
        return this.rrr == Status.FAILED;
    }
}
