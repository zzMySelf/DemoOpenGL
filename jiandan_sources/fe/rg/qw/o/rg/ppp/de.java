package fe.rg.qw.o.rg.ppp;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import fe.rg.qw.o.ad;
import fe.rg.qw.o.rg.i;
import java.io.InputStream;

public class de implements ModelLoader<Uri, InputStream> {
    public final Context qw;

    public static class qw implements ModelLoaderFactory<Uri, InputStream> {
        public final Context qw;

        public qw(Context context) {
            this.qw = context;
        }

        @NonNull
        public ModelLoader<Uri, InputStream> ad(i iVar) {
            return new de(this.qw);
        }
    }

    public de(Context context) {
        this.qw = context.getApplicationContext();
    }

    /* renamed from: de */
    public ModelLoader.qw<InputStream> ad(@NonNull Uri uri, int i2, int i3, @NonNull ad adVar) {
        if (fe.rg.qw.o.de.p017switch.ad.fe(i2, i3)) {
            return new ModelLoader.qw<>(new fe.rg.qw.ppp.de(uri), fe.rg.qw.o.de.p017switch.de.rg(this.qw, uri));
        }
        return null;
    }

    /* renamed from: fe */
    public boolean qw(@NonNull Uri uri) {
        return fe.rg.qw.o.de.p017switch.ad.qw(uri);
    }
}
