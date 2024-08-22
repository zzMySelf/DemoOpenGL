package fe.rg.qw.o.th.de;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import fe.rg.qw.o.ad;

public class de implements ResourceEncoder<Bitmap> {

    /* renamed from: ad  reason: collision with root package name */
    public static final Option<Integer> f4957ad = Option.th("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);

    /* renamed from: de  reason: collision with root package name */
    public static final Option<Bitmap.CompressFormat> f4958de = Option.rg("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");
    @Nullable
    public final ArrayPool qw;

    public de(@NonNull ArrayPool arrayPool) {
        this.qw = arrayPool;
    }

    @NonNull
    public EncodeStrategy ad(@NonNull ad adVar) {
        return EncodeStrategy.TRANSFORMED;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:21|(2:36|37)|38|39) */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005d, code lost:
        if (r6 != null) goto L_0x004d;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x00b2 */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00af A[SYNTHETIC, Splitter:B:36:0x00af] */
    /* renamed from: de */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean qw(@androidx.annotation.NonNull com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> r9, @androidx.annotation.NonNull java.io.File r10, @androidx.annotation.NonNull fe.rg.qw.o.ad r11) {
        /*
            r8 = this;
            java.lang.String r0 = "BitmapEncoder"
            java.lang.Object r9 = r9.get()
            android.graphics.Bitmap r9 = (android.graphics.Bitmap) r9
            android.graphics.Bitmap$CompressFormat r1 = r8.fe(r9, r11)
            int r2 = r9.getWidth()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            int r3 = r9.getHeight()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r4 = "encode: [%dx%d] %s"
            fe.rg.qw.ggg.o.qw.de(r4, r2, r3, r1)
            long r2 = fe.rg.qw.ggg.fe.ad()     // Catch:{ all -> 0x00b3 }
            com.bumptech.glide.load.Option<java.lang.Integer> r4 = f4957ad     // Catch:{ all -> 0x00b3 }
            java.lang.Object r4 = r11.de(r4)     // Catch:{ all -> 0x00b3 }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ all -> 0x00b3 }
            int r4 = r4.intValue()     // Catch:{ all -> 0x00b3 }
            r5 = 0
            r6 = 0
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0058 }
            r7.<init>(r10)     // Catch:{ IOException -> 0x0058 }
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r10 = r8.qw     // Catch:{ IOException -> 0x0054, all -> 0x0051 }
            if (r10 == 0) goto L_0x0045
            fe.rg.qw.o.de.de r10 = new fe.rg.qw.o.de.de     // Catch:{ IOException -> 0x0054, all -> 0x0051 }
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r6 = r8.qw     // Catch:{ IOException -> 0x0054, all -> 0x0051 }
            r10.<init>(r7, r6)     // Catch:{ IOException -> 0x0054, all -> 0x0051 }
            r6 = r10
            goto L_0x0046
        L_0x0045:
            r6 = r7
        L_0x0046:
            r9.compress(r1, r4, r6)     // Catch:{ IOException -> 0x0058 }
            r6.close()     // Catch:{ IOException -> 0x0058 }
            r5 = 1
        L_0x004d:
            r6.close()     // Catch:{ IOException -> 0x0060 }
            goto L_0x0060
        L_0x0051:
            r9 = move-exception
            r6 = r7
            goto L_0x00ad
        L_0x0054:
            r6 = r7
            goto L_0x0058
        L_0x0056:
            r9 = move-exception
            goto L_0x00ad
        L_0x0058:
            r10 = 3
            boolean r10 = android.util.Log.isLoggable(r0, r10)     // Catch:{ all -> 0x0056 }
            if (r6 == 0) goto L_0x0060
            goto L_0x004d
        L_0x0060:
            r10 = 2
            boolean r10 = android.util.Log.isLoggable(r0, r10)     // Catch:{ all -> 0x00b3 }
            if (r10 == 0) goto L_0x00a9
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b3 }
            r10.<init>()     // Catch:{ all -> 0x00b3 }
            java.lang.String r0 = "Compressed with type: "
            r10.append(r0)     // Catch:{ all -> 0x00b3 }
            r10.append(r1)     // Catch:{ all -> 0x00b3 }
            java.lang.String r0 = " of size "
            r10.append(r0)     // Catch:{ all -> 0x00b3 }
            int r0 = fe.rg.qw.ggg.i.yj(r9)     // Catch:{ all -> 0x00b3 }
            r10.append(r0)     // Catch:{ all -> 0x00b3 }
            java.lang.String r0 = " in "
            r10.append(r0)     // Catch:{ all -> 0x00b3 }
            double r0 = fe.rg.qw.ggg.fe.qw(r2)     // Catch:{ all -> 0x00b3 }
            r10.append(r0)     // Catch:{ all -> 0x00b3 }
            java.lang.String r0 = ", options format: "
            r10.append(r0)     // Catch:{ all -> 0x00b3 }
            com.bumptech.glide.load.Option<android.graphics.Bitmap$CompressFormat> r0 = f4958de     // Catch:{ all -> 0x00b3 }
            java.lang.Object r11 = r11.de(r0)     // Catch:{ all -> 0x00b3 }
            r10.append(r11)     // Catch:{ all -> 0x00b3 }
            java.lang.String r11 = ", hasAlpha: "
            r10.append(r11)     // Catch:{ all -> 0x00b3 }
            boolean r9 = r9.hasAlpha()     // Catch:{ all -> 0x00b3 }
            r10.append(r9)     // Catch:{ all -> 0x00b3 }
            r10.toString()     // Catch:{ all -> 0x00b3 }
        L_0x00a9:
            fe.rg.qw.ggg.o.qw.fe()
            return r5
        L_0x00ad:
            if (r6 == 0) goto L_0x00b2
            r6.close()     // Catch:{ IOException -> 0x00b2 }
        L_0x00b2:
            throw r9     // Catch:{ all -> 0x00b3 }
        L_0x00b3:
            r9 = move-exception
            fe.rg.qw.ggg.o.qw.fe()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.rg.qw.o.th.de.de.qw(com.bumptech.glide.load.engine.Resource, java.io.File, fe.rg.qw.o.ad):boolean");
    }

    public final Bitmap.CompressFormat fe(Bitmap bitmap, ad adVar) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) adVar.de(f4958de);
        if (compressFormat != null) {
            return compressFormat;
        }
        if (bitmap.hasAlpha()) {
            return Bitmap.CompressFormat.PNG;
        }
        return Bitmap.CompressFormat.JPEG;
    }
}
