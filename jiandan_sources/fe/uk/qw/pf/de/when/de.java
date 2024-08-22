package fe.uk.qw.pf.de.when;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.dxmbumptech.glide.Glide;
import com.dxmbumptech.glide.Priority;
import com.dxmbumptech.glide.load.DataSource;
import com.dxmbumptech.glide.load.data.DataFetcher;
import fe.uk.qw.pf.de.rg;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class de implements DataFetcher<InputStream> {

    /* renamed from: ad  reason: collision with root package name */
    public final Uri f5709ad;

    /* renamed from: th  reason: collision with root package name */
    public final rg f5710th;

    /* renamed from: yj  reason: collision with root package name */
    public InputStream f5711yj;

    public static class ad implements fe {

        /* renamed from: ad  reason: collision with root package name */
        public static final String[] f5712ad = {"_data"};
        public final ContentResolver qw;

        public ad(ContentResolver contentResolver) {
            this.qw = contentResolver;
        }

        public Cursor qw(Uri uri) {
            String lastPathSegment = uri.getLastPathSegment();
            return this.qw.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f5712ad, "kind = 1 AND video_id = ?", new String[]{lastPathSegment}, (String) null);
        }
    }

    public static class qw implements fe {

        /* renamed from: ad  reason: collision with root package name */
        public static final String[] f5713ad = {"_data"};
        public final ContentResolver qw;

        public qw(ContentResolver contentResolver) {
            this.qw = contentResolver;
        }

        public Cursor qw(Uri uri) {
            String lastPathSegment = uri.getLastPathSegment();
            return this.qw.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f5713ad, "kind = 1 AND image_id = ?", new String[]{lastPathSegment}, (String) null);
        }
    }

    @VisibleForTesting
    public de(Uri uri, rg rgVar) {
        this.f5709ad = uri;
        this.f5710th = rgVar;
    }

    public static de de(Context context, Uri uri, fe feVar) {
        return new de(uri, new rg(Glide.de(context).o().yj(), feVar, Glide.de(context).rg(), context.getContentResolver()));
    }

    public static de rg(Context context, Uri uri) {
        return de(context, uri, new qw(context.getContentResolver()));
    }

    public static de yj(Context context, Uri uri) {
        return de(context, uri, new ad(context.getContentResolver()));
    }

    public void ad() {
        InputStream inputStream = this.f5711yj;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public void cancel() {
    }

    @NonNull
    public DataSource fe() {
        return DataSource.LOCAL;
    }

    @NonNull
    public Class<InputStream> qw() {
        return InputStream.class;
    }

    public void th(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super InputStream> dataCallback) {
        try {
            InputStream uk2 = uk();
            this.f5711yj = uk2;
            dataCallback.rg(uk2);
        } catch (FileNotFoundException e) {
            boolean isLoggable = Log.isLoggable("MediaStoreThumbFetcher", 3);
            dataCallback.de(e);
        }
    }

    public final InputStream uk() throws FileNotFoundException {
        InputStream fe2 = this.f5710th.fe(this.f5709ad);
        int qw2 = fe2 != null ? this.f5710th.qw(this.f5709ad) : -1;
        return qw2 != -1 ? new rg(fe2, qw2) : fe2;
    }
}
