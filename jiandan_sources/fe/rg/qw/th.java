package fe.rg.qw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.Priority;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.Target;
import fe.rg.qw.ggg.i;
import fe.rg.qw.pf.uk;
import fe.rg.qw.pf.yj;
import java.io.File;

public class th implements LifecycleListener {
    public static final fe.rg.qw.when.ad ppp;

    /* renamed from: ad  reason: collision with root package name */
    public final ad f5038ad;

    /* renamed from: i  reason: collision with root package name */
    public final RequestManagerTreeNode f5039i;

    /* renamed from: if  reason: not valid java name */
    public final Handler f192if;

    /* renamed from: o  reason: collision with root package name */
    public final uk f5040o;

    /* renamed from: pf  reason: collision with root package name */
    public final Runnable f5041pf;

    /* renamed from: switch  reason: not valid java name */
    public final ConnectivityMonitor f193switch;

    /* renamed from: th  reason: collision with root package name */
    public final Context f5042th;

    /* renamed from: uk  reason: collision with root package name */
    public final yj f5043uk;
    public fe.rg.qw.when.ad when;

    /* renamed from: yj  reason: collision with root package name */
    public final Lifecycle f5044yj;

    public class ad implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Target f5045ad;

        public ad(Target target) {
            this.f5045ad = target;
        }

        public void run() {
            th.this.pf(this.f5045ad);
        }
    }

    public static class de implements ConnectivityMonitor.ConnectivityListener {
        public final yj qw;

        public de(@NonNull yj yjVar) {
            this.qw = yjVar;
        }

        public void qw(boolean z) {
            if (z) {
                this.qw.rg();
            }
        }
    }

    public class qw implements Runnable {
        public qw() {
        }

        public void run() {
            th thVar = th.this;
            thVar.f5044yj.ad(thVar);
        }
    }

    static {
        fe.rg.qw.when.ad th2 = fe.rg.qw.when.ad.th(Bitmap.class);
        th2.p();
        ppp = th2;
        fe.rg.qw.when.ad.th(fe.rg.qw.o.th.yj.de.class).p();
        fe.rg.qw.when.ad.uk(fe.rg.qw.o.fe.yj.f4914ad).x(Priority.LOW).E(true);
    }

    public th(@NonNull ad adVar, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context) {
        this(adVar, lifecycle, requestManagerTreeNode, new yj(), adVar.yj(), context);
    }

    public boolean aaa(@NonNull Target<?> target) {
        Request request = target.getRequest();
        if (request == null) {
            return true;
        }
        if (!this.f5043uk.ad(request)) {
            return false;
        }
        this.f5040o.pf(target);
        target.th((Request) null);
        return true;
    }

    public void ddd() {
        i.qw();
        this.f5043uk.th();
    }

    @CheckResult
    @NonNull
    public rg<Drawable> ggg(@RawRes @DrawableRes @Nullable Integer num) {
        rg<Drawable> o2 = o();
        o2.xxx(num);
        return o2;
    }

    @CheckResult
    @NonNull
    public rg<Bitmap> i() {
        rg<Bitmap> uk2 = uk(Bitmap.class);
        uk2.de(ppp);
        return uk2;
    }

    /* renamed from: if  reason: not valid java name */
    public fe.rg.qw.when.ad m318if() {
        return this.when;
    }

    public void mmm(@NonNull Target<?> target, @NonNull Request request) {
        this.f5040o.o(target);
        this.f5043uk.yj(request);
    }

    public void nn(@NonNull fe.rg.qw.when.ad adVar) {
        fe.rg.qw.when.ad fe2 = adVar.clone();
        fe2.de();
        this.when = fe2;
    }

    @CheckResult
    @NonNull
    public rg<Drawable> o() {
        return uk(Drawable.class);
    }

    public void onDestroy() {
        this.f5040o.onDestroy();
        for (Target<?> pf2 : this.f5040o.i()) {
            pf(pf2);
        }
        this.f5040o.uk();
        this.f5043uk.de();
        this.f5044yj.qw(this);
        this.f5044yj.qw(this.f193switch);
        this.f192if.removeCallbacks(this.f5041pf);
        this.f5038ad.ddd(this);
    }

    public void onStart() {
        ddd();
        this.f5040o.onStart();
    }

    public void onStop() {
        xxx();
        this.f5040o.onStop();
    }

    public void pf(@Nullable Target<?> target) {
        if (target != null) {
            if (i.ggg()) {
                qqq(target);
            } else {
                this.f192if.post(new ad(target));
            }
        }
    }

    @CheckResult
    @NonNull
    public rg<Drawable> ppp(@Nullable File file) {
        rg<Drawable> o2 = o();
        o2.vvv(file);
        return o2;
    }

    public final void qqq(@NonNull Target<?> target) {
        if (!aaa(target) && !this.f5038ad.ggg(target) && target.getRequest() != null) {
            Request request = target.getRequest();
            target.th((Request) null);
            request.clear();
        }
    }

    @NonNull
    /* renamed from: switch  reason: not valid java name */
    public <T> yj<?, T> m319switch(Class<T> cls) {
        return this.f5038ad.i().fe(cls);
    }

    public String toString() {
        return super.toString() + "{tracker=" + this.f5043uk + ", treeNode=" + this.f5039i + "}";
    }

    @CheckResult
    @NonNull
    public <ResourceType> rg<ResourceType> uk(@NonNull Class<ResourceType> cls) {
        return new rg<>(this.f5038ad, this, cls, this.f5042th);
    }

    @CheckResult
    @NonNull
    public rg<Drawable> vvv(@Nullable String str) {
        rg<Drawable> o2 = o();
        o2.nn(str);
        return o2;
    }

    @CheckResult
    @NonNull
    public rg<Drawable> when(@Nullable Uri uri) {
        rg<Drawable> o2 = o();
        o2.ggg(uri);
        return o2;
    }

    public void xxx() {
        i.qw();
        this.f5043uk.fe();
    }

    public th(ad adVar, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, yj yjVar, ConnectivityMonitorFactory connectivityMonitorFactory, Context context) {
        this.f5040o = new uk();
        this.f5041pf = new qw();
        this.f192if = new Handler(Looper.getMainLooper());
        this.f5038ad = adVar;
        this.f5044yj = lifecycle;
        this.f5039i = requestManagerTreeNode;
        this.f5043uk = yjVar;
        this.f5042th = context;
        this.f193switch = connectivityMonitorFactory.qw(context.getApplicationContext(), new de(yjVar));
        if (i.ppp()) {
            this.f192if.post(this.f5041pf);
        } else {
            lifecycle.ad(this);
        }
        lifecycle.ad(this.f193switch);
        nn(adVar.i().de());
        adVar.ppp(this);
    }
}
