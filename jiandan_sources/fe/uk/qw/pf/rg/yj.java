package fe.uk.qw.pf.rg;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.dxmbumptech.glide.Registry;
import com.dxmbumptech.glide.load.model.ModelLoader;
import com.dxmbumptech.glide.load.model.ModelLoaderFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class yj {

    /* renamed from: ad  reason: collision with root package name */
    public final qw f5944ad;
    public final i qw;

    public static class qw {
        public final Map<Class<?>, C0241qw<?>> qw = new HashMap();

        /* renamed from: fe.uk.qw.pf.rg.yj$qw$qw  reason: collision with other inner class name */
        public static class C0241qw<Model> {
            public final List<ModelLoader<Model, ?>> qw;

            public C0241qw(List<ModelLoader<Model, ?>> list) {
                this.qw = list;
            }
        }

        @Nullable
        public <Model> List<ModelLoader<Model, ?>> ad(Class<Model> cls) {
            C0241qw qwVar = this.qw.get(cls);
            if (qwVar == null) {
                return null;
            }
            return qwVar.qw;
        }

        public <Model> void de(Class<Model> cls, List<ModelLoader<Model, ?>> list) {
            if (this.qw.put(cls, new C0241qw(list)) != null) {
                throw new IllegalStateException("Already cached loaders for model: " + cls);
            }
        }

        public void qw() {
            this.qw.clear();
        }
    }

    public yj(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(new i(pool));
    }

    @NonNull
    public static <A> Class<A> ad(@NonNull A a) {
        return a.getClass();
    }

    @NonNull
    public synchronized List<Class<?>> de(@NonNull Class<?> cls) {
        return this.qw.yj(cls);
    }

    @NonNull
    public <A> List<ModelLoader<A, ?>> fe(@NonNull A a) {
        List rg2 = rg(ad(a));
        if (!rg2.isEmpty()) {
            int size = rg2.size();
            List<ModelLoader<A, ?>> emptyList = Collections.emptyList();
            boolean z = true;
            for (int i2 = 0; i2 < size; i2++) {
                ModelLoader modelLoader = (ModelLoader) rg2.get(i2);
                if (modelLoader.qw(a)) {
                    if (z) {
                        emptyList = new ArrayList<>(size - i2);
                        z = false;
                    }
                    emptyList.add(modelLoader);
                }
            }
            if (!emptyList.isEmpty()) {
                return emptyList;
            }
            throw new Registry.NoModelLoaderAvailableException(a, rg2);
        }
        throw new Registry.NoModelLoaderAvailableException(a);
    }

    public synchronized <Model, Data> void qw(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        this.qw.ad(cls, cls2, modelLoaderFactory);
        this.f5944ad.qw();
    }

    @NonNull
    public final synchronized <A> List<ModelLoader<A, ?>> rg(@NonNull Class<A> cls) {
        List<ModelLoader<A, ?>> ad2;
        ad2 = this.f5944ad.ad(cls);
        if (ad2 == null) {
            ad2 = Collections.unmodifiableList(this.qw.rg(cls));
            this.f5944ad.de(cls, ad2);
        }
        return ad2;
    }

    public yj(@NonNull i iVar) {
        this.f5944ad = new qw();
        this.qw = iVar;
    }
}
