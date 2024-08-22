package fe.uk.qw.pf.rg.ppp;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.dxmbumptech.glide.load.model.ModelLoader;
import com.dxmbumptech.glide.load.model.ModelLoaderFactory;
import fe.uk.qw.pf.de.when.de;
import fe.uk.qw.pf.rg.i;
import java.io.InputStream;

public class ad implements ModelLoader<Uri, InputStream> {
    public final Context qw;

    public static class qw implements ModelLoaderFactory<Uri, InputStream> {
        public final Context qw;

        public qw(Context context) {
            this.qw = context;
        }

        @NonNull
        public ModelLoader<Uri, InputStream> ad(i iVar) {
            return new ad(this.qw);
        }
    }

    public ad(Context context) {
        this.qw = context.getApplicationContext();
    }

    /* renamed from: de */
    public ModelLoader.qw<InputStream> ad(@NonNull Uri uri, int i2, int i3, @NonNull fe.uk.qw.pf.ad adVar) {
        if (fe.uk.qw.pf.de.when.ad.fe(i2, i3)) {
            return new ModelLoader.qw<>(new fe.uk.qw.ggg.ad(uri), de.rg(this.qw, uri));
        }
        return null;
    }

    /* renamed from: fe */
    public boolean qw(@NonNull Uri uri) {
        return fe.uk.qw.pf.de.when.ad.qw(uri);
    }
}
