package fe.uk.qw.pf.rg;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.dxmbumptech.glide.load.model.ModelLoader;
import com.dxmbumptech.glide.load.model.ModelLoaderFactory;
import java.io.InputStream;

public class o<Data> implements ModelLoader<Integer, Data> {

    /* renamed from: ad  reason: collision with root package name */
    public final Resources f5915ad;
    public final ModelLoader<Uri, Data> qw;

    public static class ad implements ModelLoaderFactory<Integer, ParcelFileDescriptor> {
        public final Resources qw;

        public ad(Resources resources) {
            this.qw = resources;
        }

        @NonNull
        public ModelLoader<Integer, ParcelFileDescriptor> ad(i iVar) {
            return new o(this.qw, iVar.fe(Uri.class, ParcelFileDescriptor.class));
        }
    }

    public static class de implements ModelLoaderFactory<Integer, InputStream> {
        public final Resources qw;

        public de(Resources resources) {
            this.qw = resources;
        }

        @NonNull
        public ModelLoader<Integer, InputStream> ad(i iVar) {
            return new o(this.qw, iVar.fe(Uri.class, InputStream.class));
        }
    }

    public static class fe implements ModelLoaderFactory<Integer, Uri> {
        public final Resources qw;

        public fe(Resources resources) {
            this.qw = resources;
        }

        @NonNull
        public ModelLoader<Integer, Uri> ad(i iVar) {
            return new o(this.qw, Cswitch.de());
        }
    }

    public static final class qw implements ModelLoaderFactory<Integer, AssetFileDescriptor> {
        public final Resources qw;

        public qw(Resources resources) {
            this.qw = resources;
        }

        public ModelLoader<Integer, AssetFileDescriptor> ad(i iVar) {
            return new o(this.qw, iVar.fe(Uri.class, AssetFileDescriptor.class));
        }
    }

    public o(Resources resources, ModelLoader<Uri, Data> modelLoader) {
        this.f5915ad = resources;
        this.qw = modelLoader;
    }

    /* renamed from: de */
    public ModelLoader.qw<Data> ad(@NonNull Integer num, int i2, int i3, @NonNull fe.uk.qw.pf.ad adVar) {
        Uri fe2 = fe(num);
        if (fe2 == null) {
            return null;
        }
        return this.qw.ad(fe2, i2, i3, adVar);
    }

    @Nullable
    public final Uri fe(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.f5915ad.getResourcePackageName(num.intValue()) + '/' + this.f5915ad.getResourceTypeName(num.intValue()) + '/' + this.f5915ad.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException unused) {
            if (!Log.isLoggable("ResourceLoader", 5)) {
                return null;
            }
            "Received invalid resource id: " + num;
            return null;
        }
    }

    /* renamed from: rg */
    public boolean qw(@NonNull Integer num) {
        return true;
    }
}
