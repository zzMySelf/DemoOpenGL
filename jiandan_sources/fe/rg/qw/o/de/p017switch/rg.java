package fe.rg.qw.o.de.p017switch;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import fe.rg.qw.o.qw;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* renamed from: fe.rg.qw.o.de.switch.rg  reason: invalid package */
public class rg {

    /* renamed from: th  reason: collision with root package name */
    public static final qw f4740th = new qw();

    /* renamed from: ad  reason: collision with root package name */
    public final fe f4741ad;

    /* renamed from: de  reason: collision with root package name */
    public final ArrayPool f4742de;

    /* renamed from: fe  reason: collision with root package name */
    public final ContentResolver f4743fe;
    public final qw qw;

    /* renamed from: rg  reason: collision with root package name */
    public final List<ImageHeaderParser> f4744rg;

    public rg(List<ImageHeaderParser> list, fe feVar, ArrayPool arrayPool, ContentResolver contentResolver) {
        this(list, f4740th, feVar, arrayPool, contentResolver);
    }

    @Nullable
    public final String ad(@NonNull Uri uri) {
        Cursor qw2 = this.f4741ad.qw(uri);
        if (qw2 != null) {
            try {
                if (qw2.moveToFirst()) {
                    return qw2.getString(0);
                }
            } finally {
                if (qw2 != null) {
                    qw2.close();
                }
            }
        }
        if (qw2 != null) {
            qw2.close();
        }
        return null;
    }

    public final boolean de(File file) {
        return this.qw.qw(file) && 0 < this.qw.de(file);
    }

    public InputStream fe(Uri uri) throws FileNotFoundException {
        String ad2 = ad(uri);
        if (TextUtils.isEmpty(ad2)) {
            return null;
        }
        File ad3 = this.qw.ad(ad2);
        if (!de(ad3)) {
            return null;
        }
        Uri fromFile = Uri.fromFile(ad3);
        try {
            return this.f4743fe.openInputStream(fromFile);
        } catch (NullPointerException e) {
            throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + fromFile).initCause(e));
        }
    }

    public int qw(Uri uri) {
        InputStream inputStream = null;
        try {
            InputStream openInputStream = this.f4743fe.openInputStream(uri);
            int qw2 = qw.qw(this.f4744rg, openInputStream, this.f4742de);
            if (openInputStream != null) {
                try {
                    openInputStream.close();
                } catch (IOException unused) {
                }
            }
            return qw2;
        } catch (IOException | NullPointerException unused2) {
            if (Log.isLoggable("ThumbStreamOpener", 3)) {
                "Failed to open uri: " + uri;
            }
            if (inputStream == null) {
                return -1;
            }
            try {
                inputStream.close();
                return -1;
            } catch (IOException unused3) {
                return -1;
            }
        } catch (Throwable th2) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused4) {
                }
            }
            throw th2;
        }
    }

    public rg(List<ImageHeaderParser> list, qw qwVar, fe feVar, ArrayPool arrayPool, ContentResolver contentResolver) {
        this.qw = qwVar;
        this.f4741ad = feVar;
        this.f4742de = arrayPool;
        this.f4743fe = contentResolver;
        this.f4744rg = list;
    }
}
