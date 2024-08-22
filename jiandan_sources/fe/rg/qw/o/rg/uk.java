package fe.rg.qw.o.rg;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.model.ModelLoader;
import fe.rg.qw.o.ad;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class uk<Model, Data> implements ModelLoader<Model, Data> {

    /* renamed from: ad  reason: collision with root package name */
    public final Pools.Pool<List<Throwable>> f4945ad;
    public final List<ModelLoader<Model, Data>> qw;

    public static class qw<Data> implements DataFetcher<Data>, DataFetcher.DataCallback<Data> {

        /* renamed from: ad  reason: collision with root package name */
        public final List<DataFetcher<Data>> f4946ad;

        /* renamed from: i  reason: collision with root package name */
        public DataFetcher.DataCallback<? super Data> f4947i;
        @Nullable

        /* renamed from: o  reason: collision with root package name */
        public List<Throwable> f4948o;

        /* renamed from: th  reason: collision with root package name */
        public final Pools.Pool<List<Throwable>> f4949th;

        /* renamed from: uk  reason: collision with root package name */
        public Priority f4950uk;

        /* renamed from: yj  reason: collision with root package name */
        public int f4951yj = 0;

        public qw(@NonNull List<DataFetcher<Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            this.f4949th = pool;
            fe.rg.qw.ggg.uk.de(list);
            this.f4946ad = list;
        }

        public void ad() {
            List<Throwable> list = this.f4948o;
            if (list != null) {
                this.f4949th.release(list);
            }
            this.f4948o = null;
            for (DataFetcher<Data> ad2 : this.f4946ad) {
                ad2.ad();
            }
        }

        public void cancel() {
            for (DataFetcher<Data> cancel : this.f4946ad) {
                cancel.cancel();
            }
        }

        public void de(@NonNull Exception exc) {
            List<Throwable> list = this.f4948o;
            fe.rg.qw.ggg.uk.fe(list);
            list.add(exc);
            yj();
        }

        @NonNull
        public DataSource fe() {
            return this.f4946ad.get(0).fe();
        }

        @NonNull
        public Class<Data> qw() {
            return this.f4946ad.get(0).qw();
        }

        public void rg(@Nullable Data data) {
            if (data != null) {
                this.f4947i.rg(data);
            } else {
                yj();
            }
        }

        public void th(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super Data> dataCallback) {
            this.f4950uk = priority;
            this.f4947i = dataCallback;
            this.f4948o = this.f4949th.acquire();
            this.f4946ad.get(this.f4951yj).th(priority, this);
        }

        public final void yj() {
            if (this.f4951yj < this.f4946ad.size() - 1) {
                this.f4951yj++;
                th(this.f4950uk, this.f4947i);
                return;
            }
            fe.rg.qw.ggg.uk.fe(this.f4948o);
            this.f4947i.de(new GlideException("Fetch failed", (List<Throwable>) new ArrayList(this.f4948o)));
        }
    }

    public uk(@NonNull List<ModelLoader<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
        this.qw = list;
        this.f4945ad = pool;
    }

    public ModelLoader.qw<Data> ad(@NonNull Model model, int i2, int i3, @NonNull ad adVar) {
        ModelLoader.qw ad2;
        int size = this.qw.size();
        ArrayList arrayList = new ArrayList(size);
        Key key = null;
        for (int i4 = 0; i4 < size; i4++) {
            ModelLoader modelLoader = this.qw.get(i4);
            if (modelLoader.qw(model) && (ad2 = modelLoader.ad(model, i2, i3, adVar)) != null) {
                key = ad2.qw;
                arrayList.add(ad2.f3709de);
            }
        }
        if (arrayList.isEmpty() || key == null) {
            return null;
        }
        return new ModelLoader.qw<>(key, new qw(arrayList, this.f4945ad));
    }

    public boolean qw(@NonNull Model model) {
        for (ModelLoader<Model, Data> qw2 : this.qw) {
            if (qw2.qw(model)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.qw.toArray()) + ExtendedMessageFormat.END_FE;
    }
}
