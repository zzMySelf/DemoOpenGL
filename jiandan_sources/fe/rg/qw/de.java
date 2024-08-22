package fe.rg.qw;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import fe.rg.qw.o.fe.aaa.rg;
import fe.rg.qw.o.fe.aaa.th;
import fe.rg.qw.o.fe.mmm.i;
import fe.rg.qw.o.fe.uk;
import fe.rg.qw.pf.fe;
import fe.rg.qw.when.ad;
import java.util.Map;

public final class de {

    /* renamed from: ad  reason: collision with root package name */
    public uk f4652ad;

    /* renamed from: de  reason: collision with root package name */
    public BitmapPool f4653de;

    /* renamed from: fe  reason: collision with root package name */
    public ArrayPool f4654fe;

    /* renamed from: i  reason: collision with root package name */
    public th f4655i;

    /* renamed from: if  reason: not valid java name */
    public ad f174if = new ad();

    /* renamed from: o  reason: collision with root package name */
    public ConnectivityMonitorFactory f4656o;

    /* renamed from: pf  reason: collision with root package name */
    public int f4657pf = 4;
    public boolean ppp;
    public final Map<Class<?>, yj<?, ?>> qw = new ArrayMap();

    /* renamed from: rg  reason: collision with root package name */
    public MemoryCache f4658rg;
    @Nullable

    /* renamed from: switch  reason: not valid java name */
    public RequestManagerRetriever.RequestManagerFactory f175switch;

    /* renamed from: th  reason: collision with root package name */
    public GlideExecutor f4659th;

    /* renamed from: uk  reason: collision with root package name */
    public DiskCache.Factory f4660uk;
    public GlideExecutor when;

    /* renamed from: yj  reason: collision with root package name */
    public GlideExecutor f4661yj;

    public void ad(@Nullable RequestManagerRetriever.RequestManagerFactory requestManagerFactory) {
        this.f175switch = requestManagerFactory;
    }

    @NonNull
    public ad qw(@NonNull Context context) {
        if (this.f4659th == null) {
            this.f4659th = GlideExecutor.th();
        }
        if (this.f4661yj == null) {
            this.f4661yj = GlideExecutor.fe();
        }
        if (this.when == null) {
            this.when = GlideExecutor.ad();
        }
        if (this.f4655i == null) {
            this.f4655i = new th.qw(context).qw();
        }
        if (this.f4656o == null) {
            this.f4656o = new fe();
        }
        if (this.f4653de == null) {
            int ad2 = this.f4655i.ad();
            if (ad2 > 0) {
                this.f4653de = new i((long) ad2);
            } else {
                this.f4653de = new fe.rg.qw.o.fe.mmm.fe();
            }
        }
        if (this.f4654fe == null) {
            this.f4654fe = new fe.rg.qw.o.fe.mmm.uk(this.f4655i.qw());
        }
        if (this.f4658rg == null) {
            this.f4658rg = new rg((long) this.f4655i.fe());
        }
        if (this.f4660uk == null) {
            this.f4660uk = new fe.rg.qw.o.fe.aaa.fe(context);
        }
        if (this.f4652ad == null) {
            this.f4652ad = new uk(this.f4658rg, this.f4660uk, this.f4661yj, this.f4659th, GlideExecutor.uk(), GlideExecutor.ad(), this.ppp);
        }
        RequestManagerRetriever requestManagerRetriever = new RequestManagerRetriever(this.f175switch);
        uk ukVar = this.f4652ad;
        MemoryCache memoryCache = this.f4658rg;
        BitmapPool bitmapPool = this.f4653de;
        ArrayPool arrayPool = this.f4654fe;
        ConnectivityMonitorFactory connectivityMonitorFactory = this.f4656o;
        int i2 = this.f4657pf;
        ad adVar = this.f174if;
        adVar.p();
        return new ad(context, ukVar, memoryCache, bitmapPool, arrayPool, requestManagerRetriever, connectivityMonitorFactory, i2, adVar, this.qw);
    }
}
