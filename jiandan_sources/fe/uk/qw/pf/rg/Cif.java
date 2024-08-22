package fe.uk.qw.pf.rg;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.dxmbumptech.glide.load.model.ModelLoader;
import com.dxmbumptech.glide.load.model.ModelLoaderFactory;
import java.io.File;
import java.io.InputStream;

/* renamed from: fe.uk.qw.pf.rg.if  reason: invalid class name */
public class Cif<Data> implements ModelLoader<String, Data> {
    public final ModelLoader<Uri, Data> qw;

    /* renamed from: fe.uk.qw.pf.rg.if$ad */
    public static class ad implements ModelLoaderFactory<String, ParcelFileDescriptor> {
        @NonNull
        public ModelLoader<String, ParcelFileDescriptor> ad(@NonNull i iVar) {
            return new Cif(iVar.fe(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* renamed from: fe.uk.qw.pf.rg.if$de */
    public static class de implements ModelLoaderFactory<String, InputStream> {
        @NonNull
        public ModelLoader<String, InputStream> ad(@NonNull i iVar) {
            return new Cif(iVar.fe(Uri.class, InputStream.class));
        }
    }

    /* renamed from: fe.uk.qw.pf.rg.if$qw */
    public static final class qw implements ModelLoaderFactory<String, AssetFileDescriptor> {
        public ModelLoader<String, AssetFileDescriptor> ad(@NonNull i iVar) {
            return new Cif(iVar.fe(Uri.class, AssetFileDescriptor.class));
        }
    }

    public Cif(ModelLoader<Uri, Data> modelLoader) {
        this.qw = modelLoader;
    }

    @Nullable
    public static Uri rg(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) == '/') {
            return th(str);
        }
        Uri parse = Uri.parse(str);
        return parse.getScheme() == null ? th(str) : parse;
    }

    public static Uri th(String str) {
        return Uri.fromFile(new File(str));
    }

    /* renamed from: de */
    public ModelLoader.qw<Data> ad(@NonNull String str, int i2, int i3, @NonNull fe.uk.qw.pf.ad adVar) {
        Uri rg2 = rg(str);
        if (rg2 == null || !this.qw.qw(rg2)) {
            return null;
        }
        return this.qw.ad(rg2, i2, i3, adVar);
    }

    /* renamed from: fe */
    public boolean qw(@NonNull String str) {
        return true;
    }
}
