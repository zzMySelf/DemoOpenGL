package fe.uk.qw.pf.de.when;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.dxmbumptech.glide.load.ImageHeaderParser;
import com.dxmbumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import fe.uk.qw.pf.qw;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class rg {

    /* renamed from: th  reason: collision with root package name */
    public static final qw f5714th = new qw();

    /* renamed from: ad  reason: collision with root package name */
    public final fe f5715ad;

    /* renamed from: de  reason: collision with root package name */
    public final ArrayPool f5716de;

    /* renamed from: fe  reason: collision with root package name */
    public final ContentResolver f5717fe;
    public final qw qw;

    /* renamed from: rg  reason: collision with root package name */
    public final List<ImageHeaderParser> f5718rg;

    public rg(List<ImageHeaderParser> list, fe feVar, ArrayPool arrayPool, ContentResolver contentResolver) {
        this(list, f5714th, feVar, arrayPool, contentResolver);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x002c A[Catch:{ all -> 0x0042 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0046  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String ad(@androidx.annotation.NonNull android.net.Uri r5) {
        /*
            r4 = this;
            r0 = 0
            fe.uk.qw.pf.de.when.fe r1 = r4.f5715ad     // Catch:{ SecurityException -> 0x0022, all -> 0x0020 }
            android.database.Cursor r1 = r1.qw(r5)     // Catch:{ SecurityException -> 0x0022, all -> 0x0020 }
            if (r1 == 0) goto L_0x001a
            boolean r2 = r1.moveToFirst()     // Catch:{ SecurityException -> 0x0023 }
            if (r2 == 0) goto L_0x001a
            r2 = 0
            java.lang.String r5 = r1.getString(r2)     // Catch:{ SecurityException -> 0x0023 }
            if (r1 == 0) goto L_0x0019
            r1.close()
        L_0x0019:
            return r5
        L_0x001a:
            if (r1 == 0) goto L_0x001f
            r1.close()
        L_0x001f:
            return r0
        L_0x0020:
            r5 = move-exception
            goto L_0x0044
        L_0x0022:
            r1 = r0
        L_0x0023:
            java.lang.String r2 = "ThumbStreamOpener"
            r3 = 3
            boolean r2 = android.util.Log.isLoggable(r2, r3)     // Catch:{ all -> 0x0042 }
            if (r2 == 0) goto L_0x003c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0042 }
            r2.<init>()     // Catch:{ all -> 0x0042 }
            java.lang.String r3 = "Failed to query for thumbnail for Uri: "
            r2.append(r3)     // Catch:{ all -> 0x0042 }
            r2.append(r5)     // Catch:{ all -> 0x0042 }
            r2.toString()     // Catch:{ all -> 0x0042 }
        L_0x003c:
            if (r1 == 0) goto L_0x0041
            r1.close()
        L_0x0041:
            return r0
        L_0x0042:
            r5 = move-exception
            r0 = r1
        L_0x0044:
            if (r0 == 0) goto L_0x0049
            r0.close()
        L_0x0049:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.uk.qw.pf.de.when.rg.ad(android.net.Uri):java.lang.String");
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
            return this.f5717fe.openInputStream(fromFile);
        } catch (NullPointerException e) {
            throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + fromFile).initCause(e));
        }
    }

    public int qw(Uri uri) {
        InputStream inputStream = null;
        try {
            InputStream openInputStream = this.f5717fe.openInputStream(uri);
            int ad2 = qw.ad(this.f5718rg, openInputStream, this.f5716de);
            if (openInputStream != null) {
                try {
                    openInputStream.close();
                } catch (IOException unused) {
                }
            }
            return ad2;
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
        this.f5715ad = feVar;
        this.f5716de = arrayPool;
        this.f5717fe = contentResolver;
        this.f5718rg = list;
    }
}
