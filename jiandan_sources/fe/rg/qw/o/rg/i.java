package fe.rg.qw.o.rg;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import fe.rg.qw.ggg.uk;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class i {

    /* renamed from: rg  reason: collision with root package name */
    public static final de f4928rg = new de();

    /* renamed from: th  reason: collision with root package name */
    public static final ModelLoader<Object, Object> f4929th = new qw();

    /* renamed from: ad  reason: collision with root package name */
    public final de f4930ad;

    /* renamed from: de  reason: collision with root package name */
    public final Set<ad<?, ?>> f4931de;

    /* renamed from: fe  reason: collision with root package name */
    public final Pools.Pool<List<Throwable>> f4932fe;
    public final List<ad<?, ?>> qw;

    public static class ad<Model, Data> {

        /* renamed from: ad  reason: collision with root package name */
        public final Class<Data> f4933ad;

        /* renamed from: de  reason: collision with root package name */
        public final ModelLoaderFactory<? extends Model, ? extends Data> f4934de;
        public final Class<Model> qw;

        public ad(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
            this.qw = cls;
            this.f4933ad = cls2;
            this.f4934de = modelLoaderFactory;
        }

        public boolean ad(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return qw(cls) && this.f4933ad.isAssignableFrom(cls2);
        }

        public boolean qw(@NonNull Class<?> cls) {
            return this.qw.isAssignableFrom(cls);
        }
    }

    public static class de {
        @NonNull
        public <Model, Data> uk<Model, Data> qw(@NonNull List<ModelLoader<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            return new uk<>(list, pool);
        }
    }

    public static class qw implements ModelLoader<Object, Object> {
        @Nullable
        public ModelLoader.qw<Object> ad(@NonNull Object obj, int i2, int i3, @NonNull fe.rg.qw.o.ad adVar) {
            return null;
        }

        public boolean qw(@NonNull Object obj) {
            return false;
        }
    }

    public i(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(pool, f4928rg);
    }

    @NonNull
    public static <Model, Data> ModelLoader<Model, Data> th() {
        return f4929th;
    }

    public synchronized <Model, Data> void ad(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        qw(cls, cls2, modelLoaderFactory, true);
    }

    @NonNull
    public final <Model, Data> ModelLoader<Model, Data> de(@NonNull ad<?, ?> adVar) {
        ModelLoader<? extends Model, ? extends Data> ad2 = adVar.f4934de.ad(this);
        uk.fe(ad2);
        return ad2;
    }

    @NonNull
    public synchronized <Model, Data> ModelLoader<Model, Data> fe(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (ad next : this.qw) {
                if (this.f4931de.contains(next)) {
                    z = true;
                } else if (next.ad(cls, cls2)) {
                    this.f4931de.add(next);
                    arrayList.add(de(next));
                    this.f4931de.remove(next);
                }
            }
            if (arrayList.size() > 1) {
                return this.f4930ad.qw(arrayList, this.f4932fe);
            } else if (arrayList.size() == 1) {
                return (ModelLoader) arrayList.get(0);
            } else if (z) {
                return th();
            } else {
                throw new Registry.NoModelLoaderAvailableException(cls, cls2);
            }
        } catch (Throwable th2) {
            this.f4931de.clear();
            throw th2;
        }
    }

    public final <Model, Data> void qw(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory, boolean z) {
        ad adVar = new ad(cls, cls2, modelLoaderFactory);
        List<ad<?, ?>> list = this.qw;
        list.add(z ? list.size() : 0, adVar);
    }

    @NonNull
    public synchronized <Model> List<ModelLoader<Model, ?>> rg(@NonNull Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (ad next : this.qw) {
                if (!this.f4931de.contains(next)) {
                    if (next.qw(cls)) {
                        this.f4931de.add(next);
                        arrayList.add(de(next));
                        this.f4931de.remove(next);
                    }
                }
            }
        } catch (Throwable th2) {
            this.f4931de.clear();
            throw th2;
        }
        return arrayList;
    }

    @NonNull
    public synchronized List<Class<?>> yj(@NonNull Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (ad next : this.qw) {
            if (!arrayList.contains(next.f4933ad) && next.qw(cls)) {
                arrayList.add(next.f4933ad);
            }
        }
        return arrayList;
    }

    @VisibleForTesting
    public i(@NonNull Pools.Pool<List<Throwable>> pool, @NonNull de deVar) {
        this.qw = new ArrayList();
        this.f4931de = new HashSet();
        this.f4932fe = pool;
        this.f4930ad = deVar;
    }
}
