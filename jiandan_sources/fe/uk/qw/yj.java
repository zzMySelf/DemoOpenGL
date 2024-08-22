package fe.uk.qw;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.dxmbumptech.glide.Glide;
import com.dxmbumptech.glide.Priority;
import com.dxmbumptech.glide.load.resource.gif.GifDrawable;
import com.dxmbumptech.glide.manager.ConnectivityMonitor;
import com.dxmbumptech.glide.manager.ConnectivityMonitorFactory;
import com.dxmbumptech.glide.manager.Lifecycle;
import com.dxmbumptech.glide.manager.LifecycleListener;
import com.dxmbumptech.glide.manager.RequestManagerTreeNode;
import com.dxmbumptech.glide.request.Request;
import com.dxmbumptech.glide.request.RequestListener;
import com.dxmbumptech.glide.request.target.Target;
import fe.uk.qw.p021if.Cif;
import fe.uk.qw.p021if.pf;
import fe.uk.qw.ppp.de;
import fe.uk.qw.vvv.o;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class yj implements ComponentCallbacks2, LifecycleListener {
    public static final de ggg;

    /* renamed from: ad  reason: collision with root package name */
    public final Glide f6068ad;
    @GuardedBy("this")

    /* renamed from: i  reason: collision with root package name */
    public final RequestManagerTreeNode f6069i;

    /* renamed from: if  reason: not valid java name */
    public final ConnectivityMonitor f246if;
    @GuardedBy("this")

    /* renamed from: o  reason: collision with root package name */
    public final Cif f6070o;

    /* renamed from: pf  reason: collision with root package name */
    public final Runnable f6071pf;
    public boolean ppp;

    /* renamed from: switch  reason: not valid java name */
    public final CopyOnWriteArrayList<RequestListener<Object>> f247switch;

    /* renamed from: th  reason: collision with root package name */
    public final Context f6072th;
    @GuardedBy("this")

    /* renamed from: uk  reason: collision with root package name */
    public final pf f6073uk;
    @GuardedBy("this")
    public de when;

    /* renamed from: yj  reason: collision with root package name */
    public final Lifecycle f6074yj;

    public class ad implements ConnectivityMonitor.ConnectivityListener {
        @GuardedBy("RequestManager.this")
        public final pf qw;

        public ad(@NonNull pf pfVar) {
            this.qw = pfVar;
        }

        public void qw(boolean z) {
            if (z) {
                synchronized (yj.this) {
                    this.qw.rg();
                }
            }
        }
    }

    public class qw implements Runnable {
        public qw() {
        }

        public void run() {
            yj yjVar = yj.this;
            yjVar.f6074yj.ad(yjVar);
        }
    }

    static {
        de H = de.H(Bitmap.class);
        H.l();
        ggg = H;
        de H2 = de.H(GifDrawable.class);
        H2.l();
        de deVar = H2;
        de deVar2 = (de) ((de) de.I(fe.uk.qw.pf.fe.yj.f5890ad).u(Priority.LOW)).B(true);
    }

    public yj(@NonNull Glide glide, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context) {
        this(glide, lifecycle, requestManagerTreeNode, new pf(), glide.yj(), context);
    }

    public synchronized boolean aaa(@NonNull Target<?> target) {
        Request request = target.getRequest();
        if (request == null) {
            return true;
        }
        if (!this.f6073uk.qw(request)) {
            return false;
        }
        this.f6070o.pf(target);
        target.yj((Request) null);
        return true;
    }

    public synchronized void ddd() {
        this.f6073uk.th();
    }

    public synchronized void ggg() {
        this.f6073uk.de();
    }

    @CheckResult
    @NonNull
    public th<Bitmap> i() {
        return uk(Bitmap.class).ad(ggg);
    }

    /* renamed from: if  reason: not valid java name */
    public List<RequestListener<Object>> m394if() {
        return this.f247switch;
    }

    public synchronized void mmm(@NonNull Target<?> target, @NonNull Request request) {
        this.f6070o.o(target);
        this.f6073uk.yj(request);
    }

    public synchronized void nn(@NonNull de deVar) {
        de deVar2 = (de) deVar.clone();
        deVar2.de();
        this.when = deVar2;
    }

    @CheckResult
    @NonNull
    public th<Drawable> o() {
        return uk(Drawable.class);
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public synchronized void onDestroy() {
        this.f6070o.onDestroy();
        for (Target<?> pf2 : this.f6070o.i()) {
            pf(pf2);
        }
        this.f6070o.uk();
        this.f6073uk.ad();
        this.f6074yj.qw(this);
        this.f6074yj.qw(this.f246if);
        o.mmm(this.f6071pf);
        this.f6068ad.ddd(this);
    }

    public void onLowMemory() {
    }

    public synchronized void onStart() {
        ddd();
        this.f6070o.onStart();
    }

    public synchronized void onStop() {
        xxx();
        this.f6070o.onStop();
    }

    public void onTrimMemory(int i2) {
        if (i2 == 60 && this.ppp) {
            vvv();
        }
    }

    public void pf(@Nullable Target<?> target) {
        if (target != null) {
            qqq(target);
        }
    }

    @CheckResult
    @NonNull
    public th<Drawable> ppp(@Nullable String str) {
        return o().W(str);
    }

    public final void qqq(@NonNull Target<?> target) {
        boolean aaa = aaa(target);
        Request request = target.getRequest();
        if (!aaa && !this.f6068ad.ggg(target) && request != null) {
            target.yj((Request) null);
            request.clear();
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public synchronized de m395switch() {
        return this.when;
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.f6073uk + ", treeNode=" + this.f6069i + "}";
    }

    @CheckResult
    @NonNull
    public <ResourceType> th<ResourceType> uk(@NonNull Class<ResourceType> cls) {
        return new th<>(this.f6068ad, this, cls, this.f6072th);
    }

    public synchronized void vvv() {
        ggg();
        for (yj ggg2 : this.f6069i.qw()) {
            ggg2.ggg();
        }
    }

    @NonNull
    public <T> uk<?, T> when(Class<T> cls) {
        return this.f6068ad.i().rg(cls);
    }

    public synchronized void xxx() {
        this.f6073uk.fe();
    }

    public yj(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, pf pfVar, ConnectivityMonitorFactory connectivityMonitorFactory, Context context) {
        this.f6070o = new Cif();
        this.f6071pf = new qw();
        this.f6068ad = glide;
        this.f6074yj = lifecycle;
        this.f6069i = requestManagerTreeNode;
        this.f6073uk = pfVar;
        this.f6072th = context;
        this.f246if = connectivityMonitorFactory.qw(context.getApplicationContext(), new ad(pfVar));
        if (o.ggg()) {
            o.nn(this.f6071pf);
        } else {
            lifecycle.ad(this);
        }
        lifecycle.ad(this.f246if);
        this.f247switch = new CopyOnWriteArrayList<>(glide.i().de());
        nn(glide.i().fe());
        glide.ppp(this);
    }
}
