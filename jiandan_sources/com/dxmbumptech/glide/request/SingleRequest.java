package com.dxmbumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.dlife.ctaccountapi.x;
import com.dxmbumptech.glide.Priority;
import com.dxmbumptech.glide.load.engine.GlideException;
import com.dxmbumptech.glide.load.engine.Resource;
import com.dxmbumptech.glide.request.target.SizeReadyCallback;
import com.dxmbumptech.glide.request.target.Target;
import com.dxmbumptech.glide.request.transition.TransitionFactory;
import fe.uk.qw.de;
import fe.uk.qw.fe;
import fe.uk.qw.pf.fe.uk;
import fe.uk.qw.ppp.qw;
import fe.uk.qw.vvv.o;
import fe.uk.qw.vvv.pf.ad;
import fe.uk.qw.vvv.rg;
import java.util.List;
import java.util.concurrent.Executor;

public final class SingleRequest<R> implements Request, SizeReadyCallback, ResourceCallback {
    public static final boolean d = Log.isLoggable("Request", 2);
    @GuardedBy("requestLock")
    public int a;
    @GuardedBy("requestLock")
    public Status aaa;

    /* renamed from: ad  reason: collision with root package name */
    public final ad f3937ad;
    @GuardedBy("requestLock")
    public boolean b;
    @Nullable
    public RuntimeException c;
    @GuardedBy("requestLock")
    public uk.fe ddd;

    /* renamed from: de  reason: collision with root package name */
    public final Object f3938de;
    @GuardedBy("requestLock")
    @Nullable
    public Drawable eee;
    @Nullable

    /* renamed from: fe  reason: collision with root package name */
    public final RequestListener<R> f3939fe;
    public final TransitionFactory<? super R> ggg;

    /* renamed from: i  reason: collision with root package name */
    public final Class<R> f3940i;

    /* renamed from: if  reason: not valid java name */
    public final int f153if;
    public volatile uk mmm;
    @GuardedBy("requestLock")
    public long nn;

    /* renamed from: o  reason: collision with root package name */
    public final qw<?> f3941o;

    /* renamed from: pf  reason: collision with root package name */
    public final int f3942pf;
    @Nullable
    public final List<RequestListener<R>> ppp;
    @GuardedBy("requestLock")
    @Nullable
    public Drawable qqq;
    @Nullable
    public final String qw;

    /* renamed from: rg  reason: collision with root package name */
    public final RequestCoordinator f3943rg;
    @GuardedBy("requestLock")
    @Nullable
    public Drawable rrr;

    /* renamed from: switch  reason: not valid java name */
    public final Priority f154switch;

    /* renamed from: th  reason: collision with root package name */
    public final Context f3944th;
    @GuardedBy("requestLock")
    public int tt;
    @Nullable

    /* renamed from: uk  reason: collision with root package name */
    public final Object f3945uk;
    public final Executor vvv;
    public final Target<R> when;
    @GuardedBy("requestLock")
    public Resource<R> xxx;

    /* renamed from: yj  reason: collision with root package name */
    public final fe f3946yj;

    public enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    public SingleRequest(Context context, fe feVar, @NonNull Object obj, @Nullable Object obj2, Class<R> cls, qw<?> qwVar, int i2, int i3, Priority priority, Target<R> target, @Nullable RequestListener<R> requestListener, @Nullable List<RequestListener<R>> list, RequestCoordinator requestCoordinator, uk ukVar, TransitionFactory<? super R> transitionFactory, Executor executor) {
        this.qw = d ? String.valueOf(super.hashCode()) : null;
        this.f3937ad = ad.qw();
        this.f3938de = obj;
        this.f3944th = context;
        this.f3946yj = feVar;
        this.f3945uk = obj2;
        this.f3940i = cls;
        this.f3941o = qwVar;
        this.f3942pf = i2;
        this.f153if = i3;
        this.f154switch = priority;
        this.when = target;
        this.f3939fe = requestListener;
        this.ppp = list;
        this.f3943rg = requestCoordinator;
        this.mmm = ukVar;
        this.ggg = transitionFactory;
        this.vvv = executor;
        this.aaa = Status.PENDING;
        if (this.c == null && feVar.yj().qw(de.C0229de.class)) {
            this.c = new RuntimeException("Glide request origin trace");
        }
    }

    public static <R> SingleRequest<R> aaa(Context context, fe feVar, Object obj, Object obj2, Class<R> cls, qw<?> qwVar, int i2, int i3, Priority priority, Target<R> target, RequestListener<R> requestListener, @Nullable List<RequestListener<R>> list, RequestCoordinator requestCoordinator, uk ukVar, TransitionFactory<? super R> transitionFactory, Executor executor) {
        return new SingleRequest(context, feVar, obj, obj2, cls, qwVar, i2, i3, priority, target, requestListener, list, requestCoordinator, ukVar, transitionFactory, executor);
    }

    public static int ddd(int i2, float f) {
        return i2 == Integer.MIN_VALUE ? i2 : Math.round(f * ((float) i2));
    }

    public void ad(int i2, int i3) {
        Object obj;
        this.f3937ad.de();
        Object obj2 = this.f3938de;
        synchronized (obj2) {
            try {
                if (d) {
                    xxx("Got onSizeReady in " + rg.qw(this.nn));
                }
                if (this.aaa == Status.WAITING_FOR_SIZE) {
                    this.aaa = Status.RUNNING;
                    float aaa2 = this.f3941o.aaa();
                    this.tt = ddd(i2, aaa2);
                    this.a = ddd(i3, aaa2);
                    if (d) {
                        xxx("finished setup for calling load in " + rg.qw(this.nn));
                    }
                    obj = obj2;
                    try {
                        this.ddd = this.mmm.th(this.f3946yj, this.f3945uk, this.f3941o.mmm(), this.tt, this.a, this.f3941o.nn(), this.f3940i, this.f154switch, this.f3941o.uk(), this.f3941o.eee(), this.f3941o.h(), this.f3941o.d(), this.f3941o.when(), this.f3941o.b(), this.f3941o.tt(), this.f3941o.rrr(), this.f3941o.m387switch(), this, this.vvv);
                        if (this.aaa != Status.RUNNING) {
                            this.ddd = null;
                        }
                        if (d) {
                            xxx("finished onSizeReady in " + rg.qw(this.nn));
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                obj = obj2;
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a7, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void begin() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f3938de
            monitor-enter(r0)
            r4.yj()     // Catch:{ all -> 0x00b0 }
            fe.uk.qw.vvv.pf.ad r1 = r4.f3937ad     // Catch:{ all -> 0x00b0 }
            r1.de()     // Catch:{ all -> 0x00b0 }
            long r1 = fe.uk.qw.vvv.rg.ad()     // Catch:{ all -> 0x00b0 }
            r4.nn = r1     // Catch:{ all -> 0x00b0 }
            java.lang.Object r1 = r4.f3945uk     // Catch:{ all -> 0x00b0 }
            if (r1 != 0) goto L_0x003c
            int r1 = r4.f3942pf     // Catch:{ all -> 0x00b0 }
            int r2 = r4.f153if     // Catch:{ all -> 0x00b0 }
            boolean r1 = fe.uk.qw.vvv.o.ddd(r1, r2)     // Catch:{ all -> 0x00b0 }
            if (r1 == 0) goto L_0x0027
            int r1 = r4.f3942pf     // Catch:{ all -> 0x00b0 }
            r4.tt = r1     // Catch:{ all -> 0x00b0 }
            int r1 = r4.f153if     // Catch:{ all -> 0x00b0 }
            r4.a = r1     // Catch:{ all -> 0x00b0 }
        L_0x0027:
            android.graphics.drawable.Drawable r1 = r4.when()     // Catch:{ all -> 0x00b0 }
            if (r1 != 0) goto L_0x002f
            r1 = 5
            goto L_0x0030
        L_0x002f:
            r1 = 3
        L_0x0030:
            com.dxmbumptech.glide.load.engine.GlideException r2 = new com.dxmbumptech.glide.load.engine.GlideException     // Catch:{ all -> 0x00b0 }
            java.lang.String r3 = "Received null model"
            r2.<init>(r3)     // Catch:{ all -> 0x00b0 }
            r4.qqq(r2, r1)     // Catch:{ all -> 0x00b0 }
            monitor-exit(r0)     // Catch:{ all -> 0x00b0 }
            return
        L_0x003c:
            com.dxmbumptech.glide.request.SingleRequest$Status r1 = r4.aaa     // Catch:{ all -> 0x00b0 }
            com.dxmbumptech.glide.request.SingleRequest$Status r2 = com.dxmbumptech.glide.request.SingleRequest.Status.RUNNING     // Catch:{ all -> 0x00b0 }
            if (r1 == r2) goto L_0x00a8
            com.dxmbumptech.glide.request.SingleRequest$Status r1 = r4.aaa     // Catch:{ all -> 0x00b0 }
            com.dxmbumptech.glide.request.SingleRequest$Status r2 = com.dxmbumptech.glide.request.SingleRequest.Status.COMPLETE     // Catch:{ all -> 0x00b0 }
            if (r1 != r2) goto L_0x0052
            com.dxmbumptech.glide.load.engine.Resource<R> r1 = r4.xxx     // Catch:{ all -> 0x00b0 }
            com.dxmbumptech.glide.load.DataSource r2 = com.dxmbumptech.glide.load.DataSource.MEMORY_CACHE     // Catch:{ all -> 0x00b0 }
            r3 = 0
            r4.th(r1, r2, r3)     // Catch:{ all -> 0x00b0 }
            monitor-exit(r0)     // Catch:{ all -> 0x00b0 }
            return
        L_0x0052:
            com.dxmbumptech.glide.request.SingleRequest$Status r1 = com.dxmbumptech.glide.request.SingleRequest.Status.WAITING_FOR_SIZE     // Catch:{ all -> 0x00b0 }
            r4.aaa = r1     // Catch:{ all -> 0x00b0 }
            int r1 = r4.f3942pf     // Catch:{ all -> 0x00b0 }
            int r2 = r4.f153if     // Catch:{ all -> 0x00b0 }
            boolean r1 = fe.uk.qw.vvv.o.ddd(r1, r2)     // Catch:{ all -> 0x00b0 }
            if (r1 == 0) goto L_0x0068
            int r1 = r4.f3942pf     // Catch:{ all -> 0x00b0 }
            int r2 = r4.f153if     // Catch:{ all -> 0x00b0 }
            r4.ad(r1, r2)     // Catch:{ all -> 0x00b0 }
            goto L_0x006d
        L_0x0068:
            com.dxmbumptech.glide.request.target.Target<R> r1 = r4.when     // Catch:{ all -> 0x00b0 }
            r1.th(r4)     // Catch:{ all -> 0x00b0 }
        L_0x006d:
            com.dxmbumptech.glide.request.SingleRequest$Status r1 = r4.aaa     // Catch:{ all -> 0x00b0 }
            com.dxmbumptech.glide.request.SingleRequest$Status r2 = com.dxmbumptech.glide.request.SingleRequest.Status.RUNNING     // Catch:{ all -> 0x00b0 }
            if (r1 == r2) goto L_0x0079
            com.dxmbumptech.glide.request.SingleRequest$Status r1 = r4.aaa     // Catch:{ all -> 0x00b0 }
            com.dxmbumptech.glide.request.SingleRequest$Status r2 = com.dxmbumptech.glide.request.SingleRequest.Status.WAITING_FOR_SIZE     // Catch:{ all -> 0x00b0 }
            if (r1 != r2) goto L_0x0088
        L_0x0079:
            boolean r1 = r4.o()     // Catch:{ all -> 0x00b0 }
            if (r1 == 0) goto L_0x0088
            com.dxmbumptech.glide.request.target.Target<R> r1 = r4.when     // Catch:{ all -> 0x00b0 }
            android.graphics.drawable.Drawable r2 = r4.ppp()     // Catch:{ all -> 0x00b0 }
            r1.qw(r2)     // Catch:{ all -> 0x00b0 }
        L_0x0088:
            boolean r1 = d     // Catch:{ all -> 0x00b0 }
            if (r1 == 0) goto L_0x00a6
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b0 }
            r1.<init>()     // Catch:{ all -> 0x00b0 }
            java.lang.String r2 = "finished run method in "
            r1.append(r2)     // Catch:{ all -> 0x00b0 }
            long r2 = r4.nn     // Catch:{ all -> 0x00b0 }
            double r2 = fe.uk.qw.vvv.rg.qw(r2)     // Catch:{ all -> 0x00b0 }
            r1.append(r2)     // Catch:{ all -> 0x00b0 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00b0 }
            r4.xxx(r1)     // Catch:{ all -> 0x00b0 }
        L_0x00a6:
            monitor-exit(r0)     // Catch:{ all -> 0x00b0 }
            return
        L_0x00a8:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00b0 }
            java.lang.String r2 = "Cannot restart a running request"
            r1.<init>(r2)     // Catch:{ all -> 0x00b0 }
            throw r1     // Catch:{ all -> 0x00b0 }
        L_0x00b0:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00b0 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dxmbumptech.glide.request.SingleRequest.begin():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0034, code lost:
        if (r2 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0036, code lost:
        r4.mmm.pf(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void clear() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f3938de
            monitor-enter(r0)
            r4.yj()     // Catch:{ all -> 0x003c }
            fe.uk.qw.vvv.pf.ad r1 = r4.f3937ad     // Catch:{ all -> 0x003c }
            r1.de()     // Catch:{ all -> 0x003c }
            com.dxmbumptech.glide.request.SingleRequest$Status r1 = r4.aaa     // Catch:{ all -> 0x003c }
            com.dxmbumptech.glide.request.SingleRequest$Status r2 = com.dxmbumptech.glide.request.SingleRequest.Status.CLEARED     // Catch:{ all -> 0x003c }
            if (r1 != r2) goto L_0x0013
            monitor-exit(r0)     // Catch:{ all -> 0x003c }
            return
        L_0x0013:
            r4.m269if()     // Catch:{ all -> 0x003c }
            com.dxmbumptech.glide.load.engine.Resource<R> r1 = r4.xxx     // Catch:{ all -> 0x003c }
            r2 = 0
            if (r1 == 0) goto L_0x0020
            com.dxmbumptech.glide.load.engine.Resource<R> r1 = r4.xxx     // Catch:{ all -> 0x003c }
            r4.xxx = r2     // Catch:{ all -> 0x003c }
            r2 = r1
        L_0x0020:
            boolean r1 = r4.i()     // Catch:{ all -> 0x003c }
            if (r1 == 0) goto L_0x002f
            com.dxmbumptech.glide.request.target.Target<R> r1 = r4.when     // Catch:{ all -> 0x003c }
            android.graphics.drawable.Drawable r3 = r4.ppp()     // Catch:{ all -> 0x003c }
            r1.ad(r3)     // Catch:{ all -> 0x003c }
        L_0x002f:
            com.dxmbumptech.glide.request.SingleRequest$Status r1 = com.dxmbumptech.glide.request.SingleRequest.Status.CLEARED     // Catch:{ all -> 0x003c }
            r4.aaa = r1     // Catch:{ all -> 0x003c }
            monitor-exit(r0)     // Catch:{ all -> 0x003c }
            if (r2 == 0) goto L_0x003b
            fe.uk.qw.pf.fe.uk r0 = r4.mmm
            r0.pf(r2)
        L_0x003b:
            return
        L_0x003c:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003c }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dxmbumptech.glide.request.SingleRequest.clear():void");
    }

    public boolean de() {
        boolean z;
        synchronized (this.f3938de) {
            z = this.aaa == Status.CLEARED;
        }
        return z;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a5 A[Catch:{ all -> 0x00b6 }] */
    @androidx.annotation.GuardedBy("requestLock")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void eee(com.dxmbumptech.glide.load.engine.Resource<R> r10, R r11, com.dxmbumptech.glide.load.DataSource r12, boolean r13) {
        /*
            r9 = this;
            boolean r13 = r9.ggg()
            com.dxmbumptech.glide.request.SingleRequest$Status r0 = com.dxmbumptech.glide.request.SingleRequest.Status.COMPLETE
            r9.aaa = r0
            r9.xxx = r10
            fe.uk.qw.fe r10 = r9.f3946yj
            int r10 = r10.uk()
            r0 = 3
            if (r10 > r0) goto L_0x0064
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "Finished loading "
            r10.append(r0)
            java.lang.Class r0 = r11.getClass()
            java.lang.String r0 = r0.getSimpleName()
            r10.append(r0)
            java.lang.String r0 = " from "
            r10.append(r0)
            r10.append(r12)
            java.lang.String r0 = " for "
            r10.append(r0)
            java.lang.Object r0 = r9.f3945uk
            r10.append(r0)
            java.lang.String r0 = " with size ["
            r10.append(r0)
            int r0 = r9.tt
            r10.append(r0)
            java.lang.String r0 = "x"
            r10.append(r0)
            int r0 = r9.a
            r10.append(r0)
            java.lang.String r0 = "] in "
            r10.append(r0)
            long r0 = r9.nn
            double r0 = fe.uk.qw.vvv.rg.qw(r0)
            r10.append(r0)
            java.lang.String r0 = " ms"
            r10.append(r0)
            r10.toString()
        L_0x0064:
            r10 = 1
            r9.b = r10
            r6 = 0
            java.util.List<com.dxmbumptech.glide.request.RequestListener<R>> r0 = r9.ppp     // Catch:{ all -> 0x00b6 }
            if (r0 == 0) goto L_0x008c
            java.util.List<com.dxmbumptech.glide.request.RequestListener<R>> r0 = r9.ppp     // Catch:{ all -> 0x00b6 }
            java.util.Iterator r7 = r0.iterator()     // Catch:{ all -> 0x00b6 }
            r8 = 0
        L_0x0073:
            boolean r0 = r7.hasNext()     // Catch:{ all -> 0x00b6 }
            if (r0 == 0) goto L_0x008d
            java.lang.Object r0 = r7.next()     // Catch:{ all -> 0x00b6 }
            com.dxmbumptech.glide.request.RequestListener r0 = (com.dxmbumptech.glide.request.RequestListener) r0     // Catch:{ all -> 0x00b6 }
            java.lang.Object r2 = r9.f3945uk     // Catch:{ all -> 0x00b6 }
            com.dxmbumptech.glide.request.target.Target<R> r3 = r9.when     // Catch:{ all -> 0x00b6 }
            r1 = r11
            r4 = r12
            r5 = r13
            boolean r0 = r0.qw(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00b6 }
            r8 = r8 | r0
            goto L_0x0073
        L_0x008c:
            r8 = 0
        L_0x008d:
            com.dxmbumptech.glide.request.RequestListener<R> r0 = r9.f3939fe     // Catch:{ all -> 0x00b6 }
            if (r0 == 0) goto L_0x00a1
            com.dxmbumptech.glide.request.RequestListener<R> r0 = r9.f3939fe     // Catch:{ all -> 0x00b6 }
            java.lang.Object r2 = r9.f3945uk     // Catch:{ all -> 0x00b6 }
            com.dxmbumptech.glide.request.target.Target<R> r3 = r9.when     // Catch:{ all -> 0x00b6 }
            r1 = r11
            r4 = r12
            r5 = r13
            boolean r0 = r0.qw(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00b6 }
            if (r0 == 0) goto L_0x00a1
            goto L_0x00a2
        L_0x00a1:
            r10 = 0
        L_0x00a2:
            r10 = r10 | r8
            if (r10 != 0) goto L_0x00b0
            com.dxmbumptech.glide.request.transition.TransitionFactory<? super R> r10 = r9.ggg     // Catch:{ all -> 0x00b6 }
            com.dxmbumptech.glide.request.transition.Transition r10 = r10.qw(r12, r13)     // Catch:{ all -> 0x00b6 }
            com.dxmbumptech.glide.request.target.Target<R> r12 = r9.when     // Catch:{ all -> 0x00b6 }
            r12.fe(r11, r10)     // Catch:{ all -> 0x00b6 }
        L_0x00b0:
            r9.b = r6
            r9.mmm()
            return
        L_0x00b6:
            r10 = move-exception
            r9.b = r6
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dxmbumptech.glide.request.SingleRequest.eee(com.dxmbumptech.glide.load.engine.Resource, java.lang.Object, com.dxmbumptech.glide.load.DataSource, boolean):void");
    }

    public Object fe() {
        this.f3937ad.de();
        return this.f3938de;
    }

    @GuardedBy("requestLock")
    public final boolean ggg() {
        RequestCoordinator requestCoordinator = this.f3943rg;
        return requestCoordinator == null || !requestCoordinator.getRoot().qw();
    }

    @GuardedBy("requestLock")
    public final boolean i() {
        RequestCoordinator requestCoordinator = this.f3943rg;
        return requestCoordinator == null || requestCoordinator.fe(this);
    }

    @GuardedBy("requestLock")
    /* renamed from: if  reason: not valid java name */
    public final void m269if() {
        yj();
        this.f3937ad.de();
        this.when.rg(this);
        uk.fe feVar = this.ddd;
        if (feVar != null) {
            feVar.qw();
            this.ddd = null;
        }
    }

    public boolean isComplete() {
        boolean z;
        synchronized (this.f3938de) {
            z = this.aaa == Status.COMPLETE;
        }
        return z;
    }

    public boolean isRunning() {
        boolean z;
        synchronized (this.f3938de) {
            if (this.aaa != Status.RUNNING) {
                if (this.aaa != Status.WAITING_FOR_SIZE) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    @GuardedBy("requestLock")
    public final void mmm() {
        RequestCoordinator requestCoordinator = this.f3943rg;
        if (requestCoordinator != null) {
            requestCoordinator.yj(this);
        }
    }

    @GuardedBy("requestLock")
    public final void nn() {
        RequestCoordinator requestCoordinator = this.f3943rg;
        if (requestCoordinator != null) {
            requestCoordinator.th(this);
        }
    }

    @GuardedBy("requestLock")
    public final boolean o() {
        RequestCoordinator requestCoordinator = this.f3943rg;
        return requestCoordinator == null || requestCoordinator.ad(this);
    }

    public void pause() {
        synchronized (this.f3938de) {
            if (isRunning()) {
                clear();
            }
        }
    }

    @GuardedBy("requestLock")
    public final boolean pf() {
        RequestCoordinator requestCoordinator = this.f3943rg;
        return requestCoordinator == null || requestCoordinator.rg(this);
    }

    @GuardedBy("requestLock")
    public final Drawable ppp() {
        if (this.eee == null) {
            Drawable vvv2 = this.f3941o.vvv();
            this.eee = vvv2;
            if (vvv2 == null && this.f3941o.xxx() > 0) {
                this.eee = vvv(this.f3941o.xxx());
            }
        }
        return this.eee;
    }

    /* JADX INFO: finally extract failed */
    public final void qqq(GlideException glideException, int i2) {
        boolean z;
        this.f3937ad.de();
        synchronized (this.f3938de) {
            glideException.setOrigin(this.c);
            int uk2 = this.f3946yj.uk();
            if (uk2 <= i2) {
                "Load failed for " + this.f3945uk + " with size [" + this.tt + x.a + this.a + "]";
                if (uk2 <= 4) {
                    glideException.logRootCauses(BaiduWalletDelegate.b);
                }
            }
            this.ddd = null;
            this.aaa = Status.FAILED;
            boolean z2 = true;
            this.b = true;
            try {
                if (this.ppp != null) {
                    z = false;
                    for (RequestListener<R> ad2 : this.ppp) {
                        z |= ad2.ad(glideException, this.f3945uk, this.when, ggg());
                    }
                } else {
                    z = false;
                }
                if (this.f3939fe == null || !this.f3939fe.ad(glideException, this.f3945uk, this.when, ggg())) {
                    z2 = false;
                }
                if (!z && !z2) {
                    rrr();
                }
                this.b = false;
                nn();
            } catch (Throwable th2) {
                this.b = false;
                throw th2;
            }
        }
    }

    public boolean qw() {
        boolean z;
        synchronized (this.f3938de) {
            z = this.aaa == Status.COMPLETE;
        }
        return z;
    }

    public void rg(GlideException glideException) {
        qqq(glideException, 5);
    }

    @GuardedBy("requestLock")
    public final void rrr() {
        if (o()) {
            Drawable drawable = null;
            if (this.f3945uk == null) {
                drawable = when();
            }
            if (drawable == null) {
                drawable = m270switch();
            }
            if (drawable == null) {
                drawable = ppp();
            }
            this.when.de(drawable);
        }
    }

    @GuardedBy("requestLock")
    /* renamed from: switch  reason: not valid java name */
    public final Drawable m270switch() {
        if (this.qqq == null) {
            Drawable o2 = this.f3941o.o();
            this.qqq = o2;
            if (o2 == null && this.f3941o.i() > 0) {
                this.qqq = vvv(this.f3941o.i());
            }
        }
        return this.qqq;
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [fe.uk.qw.pf.fe.uk$fe, com.dxmbumptech.glide.load.engine.Resource<R>] */
    /* JADX WARNING: type inference failed for: r0v2, types: [com.dxmbumptech.glide.load.engine.Resource] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v18 */
    /* JADX WARNING: type inference failed for: r0v19 */
    /* JADX WARNING: type inference failed for: r0v20 */
    /* JADX WARNING: type inference failed for: r0v21 */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004f, code lost:
        if (r6 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0051, code lost:
        r5.mmm.pf(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        return;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void th(com.dxmbumptech.glide.load.engine.Resource<?> r6, com.dxmbumptech.glide.load.DataSource r7, boolean r8) {
        /*
            r5 = this;
            fe.uk.qw.vvv.pf.ad r0 = r5.f3937ad
            r0.de()
            r0 = 0
            java.lang.Object r1 = r5.f3938de     // Catch:{ all -> 0x00b9 }
            monitor-enter(r1)     // Catch:{ all -> 0x00b9 }
            r5.ddd = r0     // Catch:{ all -> 0x00b6 }
            if (r6 != 0) goto L_0x002f
            com.dxmbumptech.glide.load.engine.GlideException r6 = new com.dxmbumptech.glide.load.engine.GlideException     // Catch:{ all -> 0x00b6 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b6 }
            r7.<init>()     // Catch:{ all -> 0x00b6 }
            java.lang.String r8 = "Expected to receive a Resource<R> with an object of "
            r7.append(r8)     // Catch:{ all -> 0x00b6 }
            java.lang.Class<R> r8 = r5.f3940i     // Catch:{ all -> 0x00b6 }
            r7.append(r8)     // Catch:{ all -> 0x00b6 }
            java.lang.String r8 = " inside, but instead got null."
            r7.append(r8)     // Catch:{ all -> 0x00b6 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00b6 }
            r6.<init>(r7)     // Catch:{ all -> 0x00b6 }
            r5.rg(r6)     // Catch:{ all -> 0x00b6 }
            monitor-exit(r1)     // Catch:{ all -> 0x00b6 }
            return
        L_0x002f:
            java.lang.Object r2 = r6.get()     // Catch:{ all -> 0x00b6 }
            if (r2 == 0) goto L_0x005c
            java.lang.Class<R> r3 = r5.f3940i     // Catch:{ all -> 0x00b6 }
            java.lang.Class r4 = r2.getClass()     // Catch:{ all -> 0x00b6 }
            boolean r3 = r3.isAssignableFrom(r4)     // Catch:{ all -> 0x00b6 }
            if (r3 != 0) goto L_0x0042
            goto L_0x005c
        L_0x0042:
            boolean r3 = r5.pf()     // Catch:{ all -> 0x00b6 }
            if (r3 != 0) goto L_0x0057
            r5.xxx = r0     // Catch:{ all -> 0x00b2 }
            com.dxmbumptech.glide.request.SingleRequest$Status r7 = com.dxmbumptech.glide.request.SingleRequest.Status.COMPLETE     // Catch:{ all -> 0x00b2 }
            r5.aaa = r7     // Catch:{ all -> 0x00b2 }
            monitor-exit(r1)     // Catch:{ all -> 0x00b2 }
            if (r6 == 0) goto L_0x0056
            fe.uk.qw.pf.fe.uk r7 = r5.mmm
            r7.pf(r6)
        L_0x0056:
            return
        L_0x0057:
            r5.eee(r6, r2, r7, r8)     // Catch:{ all -> 0x00b6 }
            monitor-exit(r1)     // Catch:{ all -> 0x00b6 }
            return
        L_0x005c:
            r5.xxx = r0     // Catch:{ all -> 0x00b2 }
            com.dxmbumptech.glide.load.engine.GlideException r7 = new com.dxmbumptech.glide.load.engine.GlideException     // Catch:{ all -> 0x00b2 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b2 }
            r8.<init>()     // Catch:{ all -> 0x00b2 }
            java.lang.String r0 = "Expected to receive an object of "
            r8.append(r0)     // Catch:{ all -> 0x00b2 }
            java.lang.Class<R> r0 = r5.f3940i     // Catch:{ all -> 0x00b2 }
            r8.append(r0)     // Catch:{ all -> 0x00b2 }
            java.lang.String r0 = " but instead got "
            r8.append(r0)     // Catch:{ all -> 0x00b2 }
            if (r2 == 0) goto L_0x007b
            java.lang.Class r0 = r2.getClass()     // Catch:{ all -> 0x00b2 }
            goto L_0x007d
        L_0x007b:
            java.lang.String r0 = ""
        L_0x007d:
            r8.append(r0)     // Catch:{ all -> 0x00b2 }
            java.lang.String r0 = "{"
            r8.append(r0)     // Catch:{ all -> 0x00b2 }
            r8.append(r2)     // Catch:{ all -> 0x00b2 }
            java.lang.String r0 = "} inside Resource{"
            r8.append(r0)     // Catch:{ all -> 0x00b2 }
            r8.append(r6)     // Catch:{ all -> 0x00b2 }
            java.lang.String r0 = "}."
            r8.append(r0)     // Catch:{ all -> 0x00b2 }
            if (r2 == 0) goto L_0x009a
            java.lang.String r0 = ""
            goto L_0x009c
        L_0x009a:
            java.lang.String r0 = " To indicate failure return a null Resource object, rather than a Resource object containing null data."
        L_0x009c:
            r8.append(r0)     // Catch:{ all -> 0x00b2 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x00b2 }
            r7.<init>(r8)     // Catch:{ all -> 0x00b2 }
            r5.rg(r7)     // Catch:{ all -> 0x00b2 }
            monitor-exit(r1)     // Catch:{ all -> 0x00b2 }
            if (r6 == 0) goto L_0x00b1
            fe.uk.qw.pf.fe.uk r7 = r5.mmm
            r7.pf(r6)
        L_0x00b1:
            return
        L_0x00b2:
            r7 = move-exception
            r0 = r6
            r6 = r7
            goto L_0x00b7
        L_0x00b6:
            r6 = move-exception
        L_0x00b7:
            monitor-exit(r1)     // Catch:{ all -> 0x00b6 }
            throw r6     // Catch:{ all -> 0x00b9 }
        L_0x00b9:
            r6 = move-exception
            if (r0 == 0) goto L_0x00c1
            fe.uk.qw.pf.fe.uk r7 = r5.mmm
            r7.pf(r0)
        L_0x00c1:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dxmbumptech.glide.request.SingleRequest.th(com.dxmbumptech.glide.load.engine.Resource, com.dxmbumptech.glide.load.DataSource, boolean):void");
    }

    public boolean uk(Request request) {
        int i2;
        int i3;
        Object obj;
        Class<R> cls;
        qw<?> qwVar;
        Priority priority;
        int size;
        int i4;
        int i5;
        Object obj2;
        Class<R> cls2;
        qw<?> qwVar2;
        Priority priority2;
        int size2;
        Request request2 = request;
        if (!(request2 instanceof SingleRequest)) {
            return false;
        }
        synchronized (this.f3938de) {
            i2 = this.f3942pf;
            i3 = this.f153if;
            obj = this.f3945uk;
            cls = this.f3940i;
            qwVar = this.f3941o;
            priority = this.f154switch;
            size = this.ppp != null ? this.ppp.size() : 0;
        }
        SingleRequest singleRequest = (SingleRequest) request2;
        synchronized (singleRequest.f3938de) {
            i4 = singleRequest.f3942pf;
            i5 = singleRequest.f153if;
            obj2 = singleRequest.f3945uk;
            cls2 = singleRequest.f3940i;
            qwVar2 = singleRequest.f3941o;
            priority2 = singleRequest.f154switch;
            size2 = singleRequest.ppp != null ? singleRequest.ppp.size() : 0;
        }
        return i2 == i4 && i3 == i5 && o.ad(obj, obj2) && cls.equals(cls2) && qwVar.equals(qwVar2) && priority == priority2 && size == size2;
    }

    @GuardedBy("requestLock")
    public final Drawable vvv(@DrawableRes int i2) {
        return fe.uk.qw.pf.th.th.qw.qw(this.f3946yj, i2, this.f3941o.qqq() != null ? this.f3941o.qqq() : this.f3944th.getTheme());
    }

    @GuardedBy("requestLock")
    public final Drawable when() {
        if (this.rrr == null) {
            Drawable pf2 = this.f3941o.pf();
            this.rrr = pf2;
            if (pf2 == null && this.f3941o.m386if() > 0) {
                this.rrr = vvv(this.f3941o.m386if());
            }
        }
        return this.rrr;
    }

    public final void xxx(String str) {
        str + " this: " + this.qw;
    }

    @GuardedBy("requestLock")
    public final void yj() {
        if (this.b) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }
}
