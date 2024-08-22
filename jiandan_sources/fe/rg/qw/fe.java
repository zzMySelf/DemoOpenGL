package fe.rg.qw;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import fe.rg.qw.o.fe.uk;
import fe.rg.qw.when.ad;
import fe.rg.qw.when.fe.rg;
import fe.rg.qw.when.fe.yj;
import java.util.Map;

public class fe extends ContextWrapper {
    @VisibleForTesting

    /* renamed from: uk  reason: collision with root package name */
    public static final yj<?, ?> f4662uk = new qw();

    /* renamed from: ad  reason: collision with root package name */
    public final Registry f4663ad;

    /* renamed from: de  reason: collision with root package name */
    public final rg f4664de;

    /* renamed from: fe  reason: collision with root package name */
    public final ad f4665fe;
    public final ArrayPool qw;

    /* renamed from: rg  reason: collision with root package name */
    public final Map<Class<?>, yj<?, ?>> f4666rg;

    /* renamed from: th  reason: collision with root package name */
    public final uk f4667th;

    /* renamed from: yj  reason: collision with root package name */
    public final int f4668yj;

    public fe(@NonNull Context context, @NonNull ArrayPool arrayPool, @NonNull Registry registry, @NonNull rg rgVar, @NonNull ad adVar, @NonNull Map<Class<?>, yj<?, ?>> map, @NonNull uk ukVar, int i2) {
        super(context.getApplicationContext());
        this.qw = arrayPool;
        this.f4663ad = registry;
        this.f4664de = rgVar;
        this.f4665fe = adVar;
        this.f4666rg = map;
        this.f4667th = ukVar;
        this.f4668yj = i2;
        new Handler(Looper.getMainLooper());
    }

    @NonNull
    public ArrayPool ad() {
        return this.qw;
    }

    public ad de() {
        return this.f4665fe;
    }

    @NonNull
    public <T> yj<?, T> fe(@NonNull Class<T> cls) {
        yj<?, T> yjVar = this.f4666rg.get(cls);
        if (yjVar == null) {
            for (Map.Entry next : this.f4666rg.entrySet()) {
                if (((Class) next.getKey()).isAssignableFrom(cls)) {
                    yjVar = (yj) next.getValue();
                }
            }
        }
        return yjVar == null ? f4662uk : yjVar;
    }

    @NonNull
    public <X> yj<ImageView, X> qw(@NonNull ImageView imageView, @NonNull Class<X> cls) {
        return this.f4664de.qw(imageView, cls);
    }

    @NonNull
    public uk rg() {
        return this.f4667th;
    }

    public int th() {
        return this.f4668yj;
    }

    @NonNull
    public Registry yj() {
        return this.f4663ad;
    }
}
