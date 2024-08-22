package fe.uk.qw.pf.rg;

import com.dxmbumptech.glide.load.Encoder;
import com.dxmbumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.InputStream;

public class pf implements Encoder<InputStream> {
    public final ArrayPool qw;

    public pf(ArrayPool arrayPool) {
        this.qw = arrayPool;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0036 A[SYNTHETIC, Splitter:B:21:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0041 A[SYNTHETIC, Splitter:B:27:0x0041] */
    /* renamed from: de */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean qw(@androidx.annotation.NonNull java.io.InputStream r4, @androidx.annotation.NonNull java.io.File r5, @androidx.annotation.NonNull fe.uk.qw.pf.ad r6) {
        /*
            r3 = this;
            com.dxmbumptech.glide.load.engine.bitmap_recycle.ArrayPool r6 = r3.qw
            java.lang.Class<byte[]> r0 = byte[].class
            r1 = 65536(0x10000, float:9.18355E-41)
            java.lang.Object r6 = r6.de(r1, r0)
            byte[] r6 = (byte[]) r6
            r0 = 0
            r1 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x002d }
            r2.<init>(r5)     // Catch:{ IOException -> 0x002d }
        L_0x0013:
            int r5 = r4.read(r6)     // Catch:{ IOException -> 0x0029, all -> 0x0026 }
            r1 = -1
            if (r5 == r1) goto L_0x001e
            r2.write(r6, r0, r5)     // Catch:{ IOException -> 0x0029, all -> 0x0026 }
            goto L_0x0013
        L_0x001e:
            r2.close()     // Catch:{ IOException -> 0x0029, all -> 0x0026 }
            r0 = 1
            r2.close()     // Catch:{ IOException -> 0x0039 }
            goto L_0x0039
        L_0x0026:
            r4 = move-exception
            r1 = r2
            goto L_0x003f
        L_0x0029:
            r1 = r2
            goto L_0x002d
        L_0x002b:
            r4 = move-exception
            goto L_0x003f
        L_0x002d:
            java.lang.String r4 = "StreamEncoder"
            r5 = 3
            boolean r4 = android.util.Log.isLoggable(r4, r5)     // Catch:{ all -> 0x002b }
            if (r1 == 0) goto L_0x0039
            r1.close()     // Catch:{ IOException -> 0x0039 }
        L_0x0039:
            com.dxmbumptech.glide.load.engine.bitmap_recycle.ArrayPool r4 = r3.qw
            r4.put(r6)
            return r0
        L_0x003f:
            if (r1 == 0) goto L_0x0044
            r1.close()     // Catch:{ IOException -> 0x0044 }
        L_0x0044:
            com.dxmbumptech.glide.load.engine.bitmap_recycle.ArrayPool r5 = r3.qw
            r5.put(r6)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.uk.qw.pf.rg.pf.qw(java.io.InputStream, java.io.File, fe.uk.qw.pf.ad):boolean");
    }
}
