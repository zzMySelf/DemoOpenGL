package fe.rg.qw.o.de.p017switch;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import fe.rg.qw.o.de.rg;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: fe.rg.qw.o.de.switch.de  reason: invalid package */
public class de implements DataFetcher<InputStream> {

    /* renamed from: ad  reason: collision with root package name */
    public final Uri f4735ad;

    /* renamed from: th  reason: collision with root package name */
    public final rg f4736th;

    /* renamed from: yj  reason: collision with root package name */
    public InputStream f4737yj;

    /* renamed from: fe.rg.qw.o.de.switch.de$ad */
    public static class ad implements fe {

        /* renamed from: ad  reason: collision with root package name */
        public static final String[] f4738ad = {"_data"};
        public final ContentResolver qw;

        public ad(ContentResolver contentResolver) {
            this.qw = contentResolver;
        }

        public Cursor qw(Uri uri) {
            String lastPathSegment = uri.getLastPathSegment();
            return this.qw.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f4738ad, "kind = 1 AND video_id = ?", new String[]{lastPathSegment}, (String) null);
        }
    }

    /* renamed from: fe.rg.qw.o.de.switch.de$qw */
    public static class qw implements fe {

        /* renamed from: ad  reason: collision with root package name */
        public static final String[] f4739ad = {"_data"};
        public final ContentResolver qw;

        public qw(ContentResolver contentResolver) {
            this.qw = contentResolver;
        }

        public Cursor qw(Uri uri) {
            String lastPathSegment = uri.getLastPathSegment();
            return this.qw.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f4739ad, "kind = 1 AND image_id = ?", new String[]{lastPathSegment}, (String) null);
        }
    }

    @VisibleForTesting
    public de(Uri uri, rg rgVar) {
        this.f4735ad = uri;
        this.f4736th = rgVar;
    }

    public static de de(Context context, Uri uri, fe feVar) {
        return new de(uri, new rg(fe.rg.qw.ad.de(context).o().yj(), feVar, fe.rg.qw.ad.de(context).rg(), context.getContentResolver()));
    }

    public static de rg(Context context, Uri uri) {
        return de(context, uri, new qw(context.getContentResolver()));
    }

    public static de yj(Context context, Uri uri) {
        return de(context, uri, new ad(context.getContentResolver()));
    }

    public void ad() {
        InputStream inputStream = this.f4737yj;
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
            this.f4737yj = uk2;
            dataCallback.rg(uk2);
        } catch (FileNotFoundException e) {
            boolean isLoggable = Log.isLoggable("MediaStoreThumbFetcher", 3);
            dataCallback.de(e);
        }
    }

    public final InputStream uk() throws FileNotFoundException {
        InputStream fe2 = this.f4736th.fe(this.f4735ad);
        int qw2 = fe2 != null ? this.f4736th.qw(this.f4735ad) : -1;
        return qw2 != -1 ? new rg(fe2, qw2) : fe2;
    }
}
