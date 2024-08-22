package fe.rg.qw.o.rg;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import fe.rg.qw.ppp.de;
import java.io.File;
import java.io.FileNotFoundException;

public final class rg implements ModelLoader<Uri, File> {
    public final Context qw;

    public static class ad implements DataFetcher<File> {

        /* renamed from: yj  reason: collision with root package name */
        public static final String[] f4938yj = {"_data"};

        /* renamed from: ad  reason: collision with root package name */
        public final Context f4939ad;

        /* renamed from: th  reason: collision with root package name */
        public final Uri f4940th;

        public ad(Context context, Uri uri) {
            this.f4939ad = context;
            this.f4940th = uri;
        }

        public void ad() {
        }

        public void cancel() {
        }

        @NonNull
        public DataSource fe() {
            return DataSource.LOCAL;
        }

        @NonNull
        public Class<File> qw() {
            return File.class;
        }

        public void th(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super File> dataCallback) {
            Cursor query = this.f4939ad.getContentResolver().query(this.f4940th, f4938yj, (String) null, (String[]) null, (String) null);
            String str = null;
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        str = query.getString(query.getColumnIndexOrThrow("_data"));
                    }
                } finally {
                    query.close();
                }
            }
            if (TextUtils.isEmpty(str)) {
                dataCallback.de(new FileNotFoundException("Failed to find file path for: " + this.f4940th));
                return;
            }
            dataCallback.rg(new File(str));
        }
    }

    public static final class qw implements ModelLoaderFactory<Uri, File> {
        public final Context qw;

        public qw(Context context) {
            this.qw = context;
        }

        @NonNull
        public ModelLoader<Uri, File> ad(i iVar) {
            return new rg(this.qw);
        }
    }

    public rg(Context context) {
        this.qw = context;
    }

    /* renamed from: de */
    public ModelLoader.qw<File> ad(@NonNull Uri uri, int i2, int i3, @NonNull fe.rg.qw.o.ad adVar) {
        return new ModelLoader.qw<>(new de(uri), new ad(this.qw, uri));
    }

    /* renamed from: fe */
    public boolean qw(@NonNull Uri uri) {
        return fe.rg.qw.o.de.p017switch.ad.ad(uri);
    }
}
