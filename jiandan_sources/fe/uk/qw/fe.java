package fe.uk.qw;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.dxmbumptech.glide.Glide;
import com.dxmbumptech.glide.Registry;
import com.dxmbumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.dxmbumptech.glide.request.RequestListener;
import fe.uk.qw.pf.fe.uk;
import fe.uk.qw.ppp.de;
import fe.uk.qw.ppp.rg.th;
import fe.uk.qw.ppp.rg.yj;
import java.util.List;
import java.util.Map;

public class fe extends ContextWrapper {
    @VisibleForTesting

    /* renamed from: pf  reason: collision with root package name */
    public static final uk<?, ?> f5604pf = new ad();

    /* renamed from: ad  reason: collision with root package name */
    public final Registry f5605ad;

    /* renamed from: de  reason: collision with root package name */
    public final th f5606de;

    /* renamed from: fe  reason: collision with root package name */
    public final Glide.RequestOptionsFactory f5607fe;

    /* renamed from: i  reason: collision with root package name */
    public final int f5608i;
    @GuardedBy("this")
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    public de f5609o;
    public final ArrayPool qw;

    /* renamed from: rg  reason: collision with root package name */
    public final List<RequestListener<Object>> f5610rg;

    /* renamed from: th  reason: collision with root package name */
    public final Map<Class<?>, uk<?, ?>> f5611th;

    /* renamed from: uk  reason: collision with root package name */
    public final rg f5612uk;

    /* renamed from: yj  reason: collision with root package name */
    public final uk f5613yj;

    public fe(@NonNull Context context, @NonNull ArrayPool arrayPool, @NonNull Registry registry, @NonNull th thVar, @NonNull Glide.RequestOptionsFactory requestOptionsFactory, @NonNull Map<Class<?>, uk<?, ?>> map, @NonNull List<RequestListener<Object>> list, @NonNull uk ukVar, @NonNull rg rgVar, int i2) {
        super(context.getApplicationContext());
        this.qw = arrayPool;
        this.f5605ad = registry;
        this.f5606de = thVar;
        this.f5607fe = requestOptionsFactory;
        this.f5610rg = list;
        this.f5611th = map;
        this.f5613yj = ukVar;
        this.f5612uk = rgVar;
        this.f5608i = i2;
    }

    @NonNull
    public ArrayPool ad() {
        return this.qw;
    }

    public List<RequestListener<Object>> de() {
        return this.f5610rg;
    }

    public synchronized de fe() {
        if (this.f5609o == null) {
            de build = this.f5607fe.build();
            build.l();
            this.f5609o = build;
        }
        return this.f5609o;
    }

    @NonNull
    public Registry i() {
        return this.f5605ad;
    }

    @NonNull
    public <X> yj<ImageView, X> qw(@NonNull ImageView imageView, @NonNull Class<X> cls) {
        return this.f5606de.qw(imageView, cls);
    }

    @NonNull
    public <T> uk<?, T> rg(@NonNull Class<T> cls) {
        uk<?, T> ukVar = this.f5611th.get(cls);
        if (ukVar == null) {
            for (Map.Entry next : this.f5611th.entrySet()) {
                if (((Class) next.getKey()).isAssignableFrom(cls)) {
                    ukVar = (uk) next.getValue();
                }
            }
        }
        return ukVar == null ? f5604pf : ukVar;
    }

    @NonNull
    public uk th() {
        return this.f5613yj;
    }

    public int uk() {
        return this.f5608i;
    }

    public rg yj() {
        return this.f5612uk;
    }
}
