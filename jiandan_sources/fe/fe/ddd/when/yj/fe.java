package fe.fe.ddd.when.yj;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.File;

public class fe {
    /* JADX WARNING: type inference failed for: r4v1, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void qw(java.io.File r5, java.util.List<fe.fe.ddd.when.yj.fe.qw> r6) throws java.io.IOException {
        /*
            if (r5 == 0) goto L_0x0093
            boolean r0 = r5.exists()
            if (r0 != 0) goto L_0x000a
            goto L_0x0093
        L_0x000a:
            if (r6 == 0) goto L_0x0093
            int r0 = r6.size()
            if (r0 != 0) goto L_0x0014
            goto L_0x0093
        L_0x0014:
            r0 = 4096(0x1000, float:5.74E-42)
            r1 = 0
            byte[] r0 = new byte[r0]     // Catch:{ FileNotFoundException -> 0x0083 }
            java.util.zip.ZipOutputStream r2 = new java.util.zip.ZipOutputStream     // Catch:{ FileNotFoundException -> 0x0083 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0083 }
            r3.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0083 }
            r2.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0083 }
            java.lang.String r5 = r5.getName()     // Catch:{ FileNotFoundException -> 0x007e, all -> 0x007b }
            r2.setComment(r5)     // Catch:{ FileNotFoundException -> 0x007e, all -> 0x007b }
            java.util.Iterator r5 = r6.iterator()     // Catch:{ FileNotFoundException -> 0x007e, all -> 0x007b }
        L_0x002e:
            boolean r6 = r5.hasNext()     // Catch:{ FileNotFoundException -> 0x007e, all -> 0x007b }
            if (r6 == 0) goto L_0x0074
            java.lang.Object r6 = r5.next()     // Catch:{ FileNotFoundException -> 0x007e, all -> 0x007b }
            fe.fe.ddd.when.yj.fe$qw r6 = (fe.fe.ddd.when.yj.fe.qw) r6     // Catch:{ FileNotFoundException -> 0x007e, all -> 0x007b }
            java.io.File r3 = r6.qw     // Catch:{ FileNotFoundException -> 0x007e, all -> 0x007b }
            boolean r4 = r3.canRead()     // Catch:{ FileNotFoundException -> 0x006b }
            if (r4 == 0) goto L_0x0065
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x006b }
            r4.<init>(r3)     // Catch:{ FileNotFoundException -> 0x006b }
            java.util.zip.ZipEntry r1 = new java.util.zip.ZipEntry     // Catch:{ FileNotFoundException -> 0x0062, all -> 0x005f }
            java.lang.String r6 = r6.f1732ad     // Catch:{ FileNotFoundException -> 0x0062, all -> 0x005f }
            r1.<init>(r6)     // Catch:{ FileNotFoundException -> 0x0062, all -> 0x005f }
            r2.putNextEntry(r1)     // Catch:{ FileNotFoundException -> 0x0062, all -> 0x005f }
        L_0x0051:
            int r6 = r4.read(r0)     // Catch:{ FileNotFoundException -> 0x0062, all -> 0x005f }
            r1 = -1
            if (r6 == r1) goto L_0x005d
            r1 = 0
            r2.write(r0, r1, r6)     // Catch:{ FileNotFoundException -> 0x0062, all -> 0x005f }
            goto L_0x0051
        L_0x005d:
            r1 = r4
            goto L_0x0065
        L_0x005f:
            r5 = move-exception
            r1 = r4
            goto L_0x0070
        L_0x0062:
            r6 = move-exception
            r1 = r4
            goto L_0x006c
        L_0x0065:
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r1)     // Catch:{ FileNotFoundException -> 0x007e, all -> 0x007b }
            goto L_0x002e
        L_0x0069:
            r5 = move-exception
            goto L_0x0070
        L_0x006b:
            r6 = move-exception
        L_0x006c:
            r6.printStackTrace()     // Catch:{ all -> 0x0069 }
            goto L_0x0065
        L_0x0070:
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r1)     // Catch:{ FileNotFoundException -> 0x007e, all -> 0x007b }
            throw r5     // Catch:{ FileNotFoundException -> 0x007e, all -> 0x007b }
        L_0x0074:
            r2.flush()     // Catch:{ FileNotFoundException -> 0x007e, all -> 0x007b }
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r2)
            goto L_0x008e
        L_0x007b:
            r5 = move-exception
            r1 = r2
            goto L_0x008f
        L_0x007e:
            r5 = move-exception
            r1 = r2
            goto L_0x0084
        L_0x0081:
            r5 = move-exception
            goto L_0x008f
        L_0x0083:
            r5 = move-exception
        L_0x0084:
            boolean r6 = fe.fe.ddd.when.yj.ad.qw     // Catch:{ all -> 0x0081 }
            if (r6 == 0) goto L_0x008b
            r5.printStackTrace()     // Catch:{ all -> 0x0081 }
        L_0x008b:
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r1)
        L_0x008e:
            return
        L_0x008f:
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r1)
            throw r5
        L_0x0093:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.ddd.when.yj.fe.qw(java.io.File, java.util.List):void");
    }

    public static final class qw {
        @NonNull

        /* renamed from: ad  reason: collision with root package name */
        public String f1732ad;
        @NonNull
        public File qw;

        public qw(@NonNull File file, @NonNull String str) {
            this.qw = file;
            if (TextUtils.isEmpty(str)) {
                this.f1732ad = this.qw.getName();
            } else {
                this.f1732ad = str;
            }
        }

        public qw(@NonNull File file) {
            this.qw = file;
            this.f1732ad = file.getName();
        }
    }
}
