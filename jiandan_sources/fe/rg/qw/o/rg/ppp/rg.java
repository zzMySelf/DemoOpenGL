package fe.rg.qw.o.rg.ppp;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import fe.rg.qw.o.ad;
import fe.rg.qw.o.rg.de;
import fe.rg.qw.o.rg.i;
import java.io.InputStream;
import java.net.URL;

public class rg implements ModelLoader<URL, InputStream> {
    public final ModelLoader<de, InputStream> qw;

    public static class qw implements ModelLoaderFactory<URL, InputStream> {
        @NonNull
        public ModelLoader<URL, InputStream> ad(i iVar) {
            return new rg(iVar.fe(de.class, InputStream.class));
        }
    }

    public rg(ModelLoader<de, InputStream> modelLoader) {
        this.qw = modelLoader;
    }

    /* renamed from: de */
    public ModelLoader.qw<InputStream> ad(@NonNull URL url, int i2, int i3, @NonNull ad adVar) {
        return this.qw.ad(new de(url), i2, i3, adVar);
    }

    /* renamed from: fe */
    public boolean qw(@NonNull URL url) {
        return true;
    }
}
