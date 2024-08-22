package fe.uk.qw.pf.rg.ppp;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.dxmbumptech.glide.load.model.ModelLoader;
import com.dxmbumptech.glide.load.model.ModelLoaderFactory;
import com.dxmbumptech.glide.load.resource.bitmap.VideoDecoder;
import fe.uk.qw.pf.ad;
import fe.uk.qw.pf.rg.i;
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

    @Nullable
    /* renamed from: de */
    public ModelLoader.qw<InputStream> ad(@NonNull Uri uri, int i2, int i3, @NonNull ad adVar) {
        if (!fe.uk.qw.pf.de.when.ad.fe(i2, i3) || !rg(adVar)) {
            return null;
        }
        return new ModelLoader.qw<>(new fe.uk.qw.ggg.ad(uri), fe.uk.qw.pf.de.when.de.yj(this.qw, uri));
    }

    /* renamed from: fe */
    public boolean qw(@NonNull Uri uri) {
        return fe.uk.qw.pf.de.when.ad.de(uri);
    }

    public final boolean rg(ad adVar) {
        Long l = (Long) adVar.de(VideoDecoder.f3904fe);
        return l != null && l.longValue() == -1;
    }
}
