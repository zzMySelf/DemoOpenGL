package fe.fe.ddd.ddd.de.de.fe;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.File;

public class ad {
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0085 A[SYNTHETIC, Splitter:B:44:0x0085] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x008f A[SYNTHETIC, Splitter:B:49:0x008f] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x009b A[SYNTHETIC, Splitter:B:55:0x009b] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00a5 A[SYNTHETIC, Splitter:B:60:0x00a5] */
    /* JADX WARNING: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void qw(java.io.File r5, java.util.List<fe.fe.ddd.ddd.de.de.fe.ad.qw> r6) throws java.io.IOException {
        /*
            if (r5 == 0) goto L_0x00ae
            boolean r0 = r5.exists()
            if (r0 != 0) goto L_0x000a
            goto L_0x00ae
        L_0x000a:
            if (r6 == 0) goto L_0x00ae
            int r0 = r6.size()
            if (r0 != 0) goto L_0x0014
            goto L_0x00ae
        L_0x0014:
            r0 = 4096(0x1000, float:5.74E-42)
            r1 = 0
            byte[] r0 = new byte[r0]     // Catch:{ FileNotFoundException -> 0x007e, all -> 0x007b }
            java.util.zip.ZipOutputStream r2 = new java.util.zip.ZipOutputStream     // Catch:{ FileNotFoundException -> 0x007e, all -> 0x007b }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x007e, all -> 0x007b }
            r3.<init>(r5)     // Catch:{ FileNotFoundException -> 0x007e, all -> 0x007b }
            r2.<init>(r3)     // Catch:{ FileNotFoundException -> 0x007e, all -> 0x007b }
            java.lang.String r5 = r5.getName()     // Catch:{ FileNotFoundException -> 0x0079 }
            r2.setComment(r5)     // Catch:{ FileNotFoundException -> 0x0079 }
            java.util.Iterator r5 = r6.iterator()     // Catch:{ FileNotFoundException -> 0x0079 }
        L_0x002e:
            boolean r6 = r5.hasNext()     // Catch:{ FileNotFoundException -> 0x0079 }
            if (r6 == 0) goto L_0x0068
            java.lang.Object r6 = r5.next()     // Catch:{ FileNotFoundException -> 0x0079 }
            fe.fe.ddd.ddd.de.de.fe.ad$qw r6 = (fe.fe.ddd.ddd.de.de.fe.ad.qw) r6     // Catch:{ FileNotFoundException -> 0x0079 }
            java.io.File r3 = r6.qw     // Catch:{ FileNotFoundException -> 0x0079 }
            boolean r4 = r3.canRead()     // Catch:{ FileNotFoundException -> 0x0079 }
            if (r4 == 0) goto L_0x002e
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0079 }
            r4.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0079 }
            java.util.zip.ZipEntry r1 = new java.util.zip.ZipEntry     // Catch:{ FileNotFoundException -> 0x0065, all -> 0x0062 }
            java.lang.String r6 = r6.f1322ad     // Catch:{ FileNotFoundException -> 0x0065, all -> 0x0062 }
            r1.<init>(r6)     // Catch:{ FileNotFoundException -> 0x0065, all -> 0x0062 }
            r2.putNextEntry(r1)     // Catch:{ FileNotFoundException -> 0x0065, all -> 0x0062 }
        L_0x0051:
            int r6 = r4.read(r0)     // Catch:{ FileNotFoundException -> 0x0065, all -> 0x0062 }
            r1 = -1
            if (r6 == r1) goto L_0x005d
            r1 = 0
            r2.write(r0, r1, r6)     // Catch:{ FileNotFoundException -> 0x0065, all -> 0x0062 }
            goto L_0x0051
        L_0x005d:
            r4.close()     // Catch:{ FileNotFoundException -> 0x0065, all -> 0x0062 }
            r1 = r4
            goto L_0x002e
        L_0x0062:
            r5 = move-exception
            r1 = r4
            goto L_0x0099
        L_0x0065:
            r5 = move-exception
            r1 = r4
            goto L_0x0080
        L_0x0068:
            r2.flush()     // Catch:{ FileNotFoundException -> 0x0079 }
            if (r1 == 0) goto L_0x0075
            r1.close()     // Catch:{ IOException -> 0x0071 }
            goto L_0x0075
        L_0x0071:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0075:
            r2.close()     // Catch:{ IOException -> 0x0093 }
            goto L_0x0097
        L_0x0079:
            r5 = move-exception
            goto L_0x0080
        L_0x007b:
            r5 = move-exception
            r2 = r1
            goto L_0x0099
        L_0x007e:
            r5 = move-exception
            r2 = r1
        L_0x0080:
            r5.printStackTrace()     // Catch:{ all -> 0x0098 }
            if (r1 == 0) goto L_0x008d
            r1.close()     // Catch:{ IOException -> 0x0089 }
            goto L_0x008d
        L_0x0089:
            r5 = move-exception
            r5.printStackTrace()
        L_0x008d:
            if (r2 == 0) goto L_0x0097
            r2.close()     // Catch:{ IOException -> 0x0093 }
            goto L_0x0097
        L_0x0093:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0097:
            return
        L_0x0098:
            r5 = move-exception
        L_0x0099:
            if (r1 == 0) goto L_0x00a3
            r1.close()     // Catch:{ IOException -> 0x009f }
            goto L_0x00a3
        L_0x009f:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00a3:
            if (r2 == 0) goto L_0x00ad
            r2.close()     // Catch:{ IOException -> 0x00a9 }
            goto L_0x00ad
        L_0x00a9:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00ad:
            throw r5
        L_0x00ae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.ddd.ddd.de.de.fe.ad.qw(java.io.File, java.util.List):void");
    }

    public static final class qw {
        @NonNull

        /* renamed from: ad  reason: collision with root package name */
        public String f1322ad;
        @NonNull
        public File qw;

        public qw(@NonNull File file, @NonNull String str) {
            this.qw = file;
            if (TextUtils.isEmpty(str)) {
                this.f1322ad = this.qw.getName();
            } else {
                this.f1322ad = str;
            }
        }

        public qw(@NonNull File file, @NonNull String str, boolean z) {
            this.qw = file;
            if (TextUtils.isEmpty(str)) {
                this.f1322ad = this.qw.getName();
            } else {
                this.f1322ad = str;
            }
        }
    }
}
