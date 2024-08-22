package fe.uk.qw.pf.rg;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.dxmbumptech.glide.Registry;
import com.dxmbumptech.glide.load.model.ModelLoader;
import com.dxmbumptech.glide.load.model.ModelLoaderFactory;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class i {

    /* renamed from: rg  reason: collision with root package name */
    public static final de f5908rg = new de();

    /* renamed from: th  reason: collision with root package name */
    public static final ModelLoader<Object, Object> f5909th = new qw();

    /* renamed from: ad  reason: collision with root package name */
    public final de f5910ad;

    /* renamed from: de  reason: collision with root package name */
    public final Set<ad<?, ?>> f5911de;

    /* renamed from: fe  reason: collision with root package name */
    public final Pools.Pool<List<Throwable>> f5912fe;
    public final List<ad<?, ?>> qw;

    public static class ad<Model, Data> {

        /* renamed from: ad  reason: collision with root package name */
        public final Class<Data> f5913ad;

        /* renamed from: de  reason: collision with root package name */
        public final ModelLoaderFactory<? extends Model, ? extends Data> f5914de;
        public final Class<Model> qw;

        public ad(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
            this.qw = cls;
            this.f5913ad = cls2;
            this.f5914de = modelLoaderFactory;
        }

        public boolean ad(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return qw(cls) && this.f5913ad.isAssignableFrom(cls2);
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
        public ModelLoader.qw<Object> ad(@NonNull Object obj, int i2, int i3, @NonNull fe.uk.qw.pf.ad adVar) {
            return null;
        }

        public boolean qw(@NonNull Object obj) {
            return false;
        }
    }

    public i(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(pool, f5908rg);
    }

    @NonNull
    public static <Model, Data> ModelLoader<Model, Data> th() {
        return f5909th;
    }

    public synchronized <Model, Data> void ad(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        qw(cls, cls2, modelLoaderFactory, true);
    }

    @NonNull
    public final <Model, Data> ModelLoader<Model, Data> de(@NonNull ad<?, ?> adVar) {
        ModelLoader<? extends Model, ? extends Data> ad2 = adVar.f5914de.ad(this);
        fe.uk.qw.vvv.i.fe(ad2);
        return ad2;
    }

    @NonNull
    public synchronized <Model, Data> ModelLoader<Model, Data> fe(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (ad next : this.qw) {
                if (this.f5911de.contains(next)) {
                    z = true;
                } else if (next.ad(cls, cls2)) {
                    this.f5911de.add(next);
                    arrayList.add(de(next));
                    this.f5911de.remove(next);
                }
            }
            if (arrayList.size() > 1) {
                return this.f5910ad.qw(arrayList, this.f5912fe);
            } else if (arrayList.size() == 1) {
                return (ModelLoader) arrayList.get(0);
            } else if (z) {
                return th();
            } else {
                throw new Registry.NoModelLoaderAvailableException((Class<?>) cls, (Class<?>) cls2);
            }
        } catch (Throwable th2) {
            this.f5911de.clear();
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
                if (!this.f5911de.contains(next)) {
                    if (next.qw(cls)) {
                        this.f5911de.add(next);
                        arrayList.add(de(next));
                        this.f5911de.remove(next);
                    }
                }
            }
        } catch (Throwable th2) {
            this.f5911de.clear();
            throw th2;
        }
        return arrayList;
    }

    @NonNull
    public synchronized List<Class<?>> yj(@NonNull Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (ad next : this.qw) {
            if (!arrayList.contains(next.f5913ad) && next.qw(cls)) {
                arrayList.add(next.f5913ad);
            }
        }
        return arrayList;
    }

    @VisibleForTesting
    public i(@NonNull Pools.Pool<List<Throwable>> pool, @NonNull de deVar) {
        this.qw = new ArrayList();
        this.f5911de = new HashSet();
        this.f5912fe = pool;
        this.f5910ad = deVar;
    }
}
