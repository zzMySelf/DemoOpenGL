package fe.rg.qw.o.rg;

import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import fe.rg.qw.ppp.de;

/* renamed from: fe.rg.qw.o.rg.switch  reason: invalid class name */
public class Cswitch<Model> implements ModelLoader<Model, Model> {
    public static final Cswitch<?> qw = new Cswitch<>();

    /* renamed from: fe.rg.qw.o.rg.switch$ad */
    public static class ad<Model> implements DataFetcher<Model> {

        /* renamed from: ad  reason: collision with root package name */
        public final Model f4941ad;

        public ad(Model model) {
            this.f4941ad = model;
        }

        public void ad() {
        }

        public void cancel() {
        }

        @NonNull
        public DataSource fe() {
            return DataSource.LOCAL;
        }

        @NonNull
        public Class<Model> qw() {
            return this.f4941ad.getClass();
        }

        public void th(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super Model> dataCallback) {
            dataCallback.rg(this.f4941ad);
        }
    }

    /* renamed from: fe.rg.qw.o.rg.switch$qw */
    public static class qw<Model> implements ModelLoaderFactory<Model, Model> {
        public static final qw<?> qw = new qw<>();

        public static <T> qw<T> qw() {
            return qw;
        }

        @NonNull
        public ModelLoader<Model, Model> ad(i iVar) {
            return Cswitch.de();
        }
    }

    public static <T> Cswitch<T> de() {
        return qw;
    }

    public ModelLoader.qw<Model> ad(@NonNull Model model, int i2, int i3, @NonNull fe.rg.qw.o.ad adVar) {
        return new ModelLoader.qw<>(new de(model), new ad(model));
    }

    public boolean qw(@NonNull Model model) {
        return true;
    }
}
