package fe.rg.qw.o.rg.ppp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import fe.rg.qw.o.ad;
import fe.rg.qw.o.de.uk;
import fe.rg.qw.o.rg.de;
import fe.rg.qw.o.rg.i;
import fe.rg.qw.o.rg.th;
import java.io.InputStream;

public class qw implements ModelLoader<de, InputStream> {

    /* renamed from: ad  reason: collision with root package name */
    public static final Option<Integer> f4937ad = Option.th("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);
    @Nullable
    public final th<de, de> qw;

    /* renamed from: fe.rg.qw.o.rg.ppp.qw$qw  reason: collision with other inner class name */
    public static class C0211qw implements ModelLoaderFactory<de, InputStream> {
        public final th<de, de> qw = new th<>(500);

        @NonNull
        public ModelLoader<de, InputStream> ad(i iVar) {
            return new qw(this.qw);
        }
    }

    public qw(@Nullable th<de, de> thVar) {
        this.qw = thVar;
    }

    /* renamed from: de */
    public ModelLoader.qw<InputStream> ad(@NonNull de deVar, int i2, int i3, @NonNull ad adVar) {
        th<de, de> thVar = this.qw;
        if (thVar != null) {
            de qw2 = thVar.qw(deVar, 0, 0);
            if (qw2 == null) {
                this.qw.ad(deVar, 0, 0, deVar);
            } else {
                deVar = qw2;
            }
        }
        return new ModelLoader.qw<>(deVar, new uk(deVar, ((Integer) adVar.de(f4937ad)).intValue()));
    }

    /* renamed from: fe */
    public boolean qw(@NonNull de deVar) {
        return true;
    }
}
