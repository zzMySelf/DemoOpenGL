package fe.rg.qw.o.rg.ppp;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import fe.rg.qw.o.rg.de;
import fe.rg.qw.o.rg.i;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ad implements ModelLoader<Uri, InputStream> {

    /* renamed from: ad  reason: collision with root package name */
    public static final Set<String> f4936ad = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"http", "https"})));
    public final ModelLoader<de, InputStream> qw;

    public static class qw implements ModelLoaderFactory<Uri, InputStream> {
        @NonNull
        public ModelLoader<Uri, InputStream> ad(i iVar) {
            return new ad(iVar.fe(de.class, InputStream.class));
        }
    }

    public ad(ModelLoader<de, InputStream> modelLoader) {
        this.qw = modelLoader;
    }

    /* renamed from: de */
    public ModelLoader.qw<InputStream> ad(@NonNull Uri uri, int i2, int i3, @NonNull fe.rg.qw.o.ad adVar) {
        return this.qw.ad(new de(uri.toString()), i2, i3, adVar);
    }

    /* renamed from: fe */
    public boolean qw(@NonNull Uri uri) {
        return f4936ad.contains(uri.getScheme());
    }
}
