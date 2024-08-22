package fe.uk.qw;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.dxmbumptech.glide.Glide;
import com.dxmbumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.dxmbumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.dxmbumptech.glide.load.engine.cache.DiskCache;
import com.dxmbumptech.glide.load.engine.cache.MemoryCache;
import com.dxmbumptech.glide.load.engine.executor.GlideExecutor;
import com.dxmbumptech.glide.manager.ConnectivityMonitorFactory;
import com.dxmbumptech.glide.manager.RequestManagerRetriever;
import com.dxmbumptech.glide.request.RequestListener;
import fe.uk.qw.pf.fe.aaa.th;
import fe.uk.qw.pf.fe.mmm.i;
import fe.uk.qw.pf.fe.uk;
import fe.uk.qw.rg;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class de {

    /* renamed from: ad  reason: collision with root package name */
    public final rg.qw f5594ad = new rg.qw();

    /* renamed from: de  reason: collision with root package name */
    public uk f5595de;

    /* renamed from: fe  reason: collision with root package name */
    public BitmapPool f5596fe;
    public boolean ggg;

    /* renamed from: i  reason: collision with root package name */
    public DiskCache.Factory f5597i;

    /* renamed from: if  reason: not valid java name */
    public int f226if = 4;

    /* renamed from: o  reason: collision with root package name */
    public th f5598o;

    /* renamed from: pf  reason: collision with root package name */
    public ConnectivityMonitorFactory f5599pf;
    public GlideExecutor ppp;
    public final Map<Class<?>, uk<?, ?>> qw = new ArrayMap();

    /* renamed from: rg  reason: collision with root package name */
    public ArrayPool f5600rg;

    /* renamed from: switch  reason: not valid java name */
    public Glide.RequestOptionsFactory f227switch = new qw(this);

    /* renamed from: th  reason: collision with root package name */
    public MemoryCache f5601th;

    /* renamed from: uk  reason: collision with root package name */
    public GlideExecutor f5602uk;
    @Nullable
    public List<RequestListener<Object>> vvv;
    @Nullable
    public RequestManagerRetriever.RequestManagerFactory when;

    /* renamed from: yj  reason: collision with root package name */
    public GlideExecutor f5603yj;

    public static final class ad {
    }

    /* renamed from: fe.uk.qw.de$de  reason: collision with other inner class name */
    public static final class C0229de {
    }

    public static final class fe {
    }

    public class qw implements Glide.RequestOptionsFactory {
        public qw(de deVar) {
        }

        @NonNull
        public fe.uk.qw.ppp.de build() {
            return new fe.uk.qw.ppp.de();
        }
    }

    public void ad(@Nullable RequestManagerRetriever.RequestManagerFactory requestManagerFactory) {
        this.when = requestManagerFactory;
    }

    @NonNull
    public Glide qw(@NonNull Context context) {
        if (this.f5603yj == null) {
            this.f5603yj = GlideExecutor.yj();
        }
        if (this.f5602uk == null) {
            this.f5602uk = GlideExecutor.rg();
        }
        if (this.ppp == null) {
            this.ppp = GlideExecutor.de();
        }
        if (this.f5598o == null) {
            this.f5598o = new th.qw(context).qw();
        }
        if (this.f5599pf == null) {
            this.f5599pf = new fe.uk.qw.p021if.fe();
        }
        if (this.f5596fe == null) {
            int ad2 = this.f5598o.ad();
            if (ad2 > 0) {
                this.f5596fe = new i((long) ad2);
            } else {
                this.f5596fe = new fe.uk.qw.pf.fe.mmm.fe();
            }
        }
        if (this.f5600rg == null) {
            this.f5600rg = new fe.uk.qw.pf.fe.mmm.uk(this.f5598o.qw());
        }
        if (this.f5601th == null) {
            this.f5601th = new fe.uk.qw.pf.fe.aaa.rg((long) this.f5598o.fe());
        }
        if (this.f5597i == null) {
            this.f5597i = new fe.uk.qw.pf.fe.aaa.fe(context);
        }
        if (this.f5595de == null) {
            this.f5595de = new uk(this.f5601th, this.f5597i, this.f5602uk, this.f5603yj, GlideExecutor.uk(), this.ppp, this.ggg);
        }
        List<RequestListener<Object>> list = this.vvv;
        if (list == null) {
            this.vvv = Collections.emptyList();
        } else {
            this.vvv = Collections.unmodifiableList(list);
        }
        rg ad3 = this.f5594ad.ad();
        return new Glide(context, this.f5595de, this.f5601th, this.f5596fe, this.f5600rg, new RequestManagerRetriever(this.when, ad3), this.f5599pf, this.f226if, this.f227switch, this.qw, this.vvv, ad3);
    }
}
