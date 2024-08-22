package fe.rg.qw.o.rg.ppp;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import fe.rg.qw.o.ad;
import fe.rg.qw.o.rg.i;
import fe.rg.qw.o.th.de.nn;
import fe.rg.qw.ppp.de;
import java.io.InputStream;

public class fe implements ModelLoader<Uri, InputStream> {
    public final Context qw;

    public static class qw implements ModelLoaderFactory<Uri, InputStream> {
        public final Context qw;

        public qw(Context context) {
            this.qw = context;
        }

        @NonNull
        public ModelLoader<Uri, InputStream> ad(i iVar) {
            return new fe(this.qw);
        }
    }

    public fe(Context context) {
        this.qw = context.getApplicationContext();
    }

    @Nullable
    /* renamed from: de */
    public ModelLoader.qw<InputStream> ad(@NonNull Uri uri, int i2, int i3, @NonNull ad adVar) {
        if (!fe.rg.qw.o.de.p017switch.ad.fe(i2, i3) || !rg(adVar)) {
            return null;
        }
        return new ModelLoader.qw<>(new de(uri), fe.rg.qw.o.de.p017switch.de.yj(this.qw, uri));
    }

    /* renamed from: fe */
    public boolean qw(@NonNull Uri uri) {
        return fe.rg.qw.o.de.p017switch.ad.de(uri);
    }

    public final boolean rg(ad adVar) {
        Long l = (Long) adVar.de(nn.f4963fe);
        return l != null && l.longValue() == -1;
    }
}
