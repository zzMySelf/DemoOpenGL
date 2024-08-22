package fe.uk.qw.pf.rg;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.dxmbumptech.glide.Priority;
import com.dxmbumptech.glide.load.DataSource;
import com.dxmbumptech.glide.load.Key;
import com.dxmbumptech.glide.load.data.DataFetcher;
import com.dxmbumptech.glide.load.engine.GlideException;
import com.dxmbumptech.glide.load.model.ModelLoader;
import fe.uk.qw.pf.ad;
import fe.uk.qw.vvv.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class uk<Model, Data> implements ModelLoader<Model, Data> {

    /* renamed from: ad  reason: collision with root package name */
    public final Pools.Pool<List<Throwable>> f5935ad;
    public final List<ModelLoader<Model, Data>> qw;

    public static class qw<Data> implements DataFetcher<Data>, DataFetcher.DataCallback<Data> {

        /* renamed from: ad  reason: collision with root package name */
        public final List<DataFetcher<Data>> f5936ad;

        /* renamed from: i  reason: collision with root package name */
        public DataFetcher.DataCallback<? super Data> f5937i;
        @Nullable

        /* renamed from: o  reason: collision with root package name */
        public List<Throwable> f5938o;

        /* renamed from: pf  reason: collision with root package name */
        public boolean f5939pf;

        /* renamed from: th  reason: collision with root package name */
        public final Pools.Pool<List<Throwable>> f5940th;

        /* renamed from: uk  reason: collision with root package name */
        public Priority f5941uk;

        /* renamed from: yj  reason: collision with root package name */
        public int f5942yj = 0;

        public qw(@NonNull List<DataFetcher<Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            this.f5940th = pool;
            i.de(list);
            this.f5936ad = list;
        }

        public void ad() {
            List<Throwable> list = this.f5938o;
            if (list != null) {
                this.f5940th.release(list);
            }
            this.f5938o = null;
            for (DataFetcher<Data> ad2 : this.f5936ad) {
                ad2.ad();
            }
        }

        public void cancel() {
            this.f5939pf = true;
            for (DataFetcher<Data> cancel : this.f5936ad) {
                cancel.cancel();
            }
        }

        public void de(@NonNull Exception exc) {
            List<Throwable> list = this.f5938o;
            i.fe(list);
            list.add(exc);
            yj();
        }

        @NonNull
        public DataSource fe() {
            return this.f5936ad.get(0).fe();
        }

        @NonNull
        public Class<Data> qw() {
            return this.f5936ad.get(0).qw();
        }

        public void rg(@Nullable Data data) {
            if (data != null) {
                this.f5937i.rg(data);
            } else {
                yj();
            }
        }

        public void th(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super Data> dataCallback) {
            this.f5941uk = priority;
            this.f5937i = dataCallback;
            this.f5938o = this.f5940th.acquire();
            this.f5936ad.get(this.f5942yj).th(priority, this);
            if (this.f5939pf) {
                cancel();
            }
        }

        public final void yj() {
            if (!this.f5939pf) {
                if (this.f5942yj < this.f5936ad.size() - 1) {
                    this.f5942yj++;
                    th(this.f5941uk, this.f5937i);
                    return;
                }
                i.fe(this.f5938o);
                this.f5937i.de(new GlideException("Fetch failed", (List<Throwable>) new ArrayList(this.f5938o)));
            }
        }
    }

    public uk(@NonNull List<ModelLoader<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
        this.qw = list;
        this.f5935ad = pool;
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
                arrayList.add(ad2.f3879de);
            }
        }
        if (arrayList.isEmpty() || key == null) {
            return null;
        }
        return new ModelLoader.qw<>(key, new qw(arrayList, this.f5935ad));
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
