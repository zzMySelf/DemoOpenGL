package fe.uk.qw.pf.rg;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.dxmbumptech.glide.Priority;
import com.dxmbumptech.glide.load.DataSource;
import com.dxmbumptech.glide.load.data.DataFetcher;
import com.dxmbumptech.glide.load.model.ModelLoader;
import com.dxmbumptech.glide.load.model.ModelLoaderFactory;
import java.io.File;
import java.io.FileNotFoundException;

public final class rg implements ModelLoader<Uri, File> {
    public final Context qw;

    public static class ad implements DataFetcher<File> {

        /* renamed from: yj  reason: collision with root package name */
        public static final String[] f5928yj = {"_data"};

        /* renamed from: ad  reason: collision with root package name */
        public final Context f5929ad;

        /* renamed from: th  reason: collision with root package name */
        public final Uri f5930th;

        public ad(Context context, Uri uri) {
            this.f5929ad = context;
            this.f5930th = uri;
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
            Cursor query = this.f5929ad.getContentResolver().query(this.f5930th, f5928yj, (String) null, (String[]) null, (String) null);
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
                dataCallback.de(new FileNotFoundException("Failed to find file path for: " + this.f5930th));
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
    public ModelLoader.qw<File> ad(@NonNull Uri uri, int i2, int i3, @NonNull fe.uk.qw.pf.ad adVar) {
        return new ModelLoader.qw<>(new fe.uk.qw.ggg.ad(uri), new ad(this.qw, uri));
    }

    /* renamed from: fe */
    public boolean qw(@NonNull Uri uri) {
        return fe.uk.qw.pf.de.when.ad.ad(uri);
    }
}
