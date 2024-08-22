package fe.uk.qw.pf.rg;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.dxmbumptech.glide.load.model.ModelLoader;
import com.dxmbumptech.glide.load.model.ModelLoaderFactory;
import fe.uk.qw.pf.ad;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class when<Data> implements ModelLoader<Uri, Data> {

    /* renamed from: ad  reason: collision with root package name */
    public static final Set<String> f5943ad = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"http", "https"})));
    public final ModelLoader<de, Data> qw;

    public static class qw implements ModelLoaderFactory<Uri, InputStream> {
        @NonNull
        public ModelLoader<Uri, InputStream> ad(i iVar) {
            return new when(iVar.fe(de.class, InputStream.class));
        }
    }

    public when(ModelLoader<de, Data> modelLoader) {
        this.qw = modelLoader;
    }

    /* renamed from: de */
    public ModelLoader.qw<Data> ad(@NonNull Uri uri, int i2, int i3, @NonNull ad adVar) {
        return this.qw.ad(new de(uri.toString()), i2, i3, adVar);
    }

    /* renamed from: fe */
    public boolean qw(@NonNull Uri uri) {
        return f5943ad.contains(uri.getScheme());
    }
}
