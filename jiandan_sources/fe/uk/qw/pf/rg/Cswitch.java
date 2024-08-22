package fe.uk.qw.pf.rg;

import androidx.annotation.NonNull;
import com.dxmbumptech.glide.Priority;
import com.dxmbumptech.glide.load.DataSource;
import com.dxmbumptech.glide.load.data.DataFetcher;
import com.dxmbumptech.glide.load.model.ModelLoader;
import com.dxmbumptech.glide.load.model.ModelLoaderFactory;

/* renamed from: fe.uk.qw.pf.rg.switch  reason: invalid class name */
public class Cswitch<Model> implements ModelLoader<Model, Model> {
    public static final Cswitch<?> qw = new Cswitch<>();

    /* renamed from: fe.uk.qw.pf.rg.switch$ad */
    public static class ad<Model> implements DataFetcher<Model> {

        /* renamed from: ad  reason: collision with root package name */
        public final Model f5931ad;

        public ad(Model model) {
            this.f5931ad = model;
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
            return this.f5931ad.getClass();
        }

        public void th(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super Model> dataCallback) {
            dataCallback.rg(this.f5931ad);
        }
    }

    /* renamed from: fe.uk.qw.pf.rg.switch$qw */
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

    public ModelLoader.qw<Model> ad(@NonNull Model model, int i2, int i3, @NonNull fe.uk.qw.pf.ad adVar) {
        return new ModelLoader.qw<>(new fe.uk.qw.ggg.ad(model), new ad(model));
    }

    public boolean qw(@NonNull Model model) {
        return true;
    }
}
