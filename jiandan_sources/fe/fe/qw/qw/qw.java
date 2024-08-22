package fe.fe.qw.qw;

import java.io.File;

public class qw {
    public String qw = null;

    public qw(File file) {
        this.qw = file.getAbsolutePath();
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0068 A[SYNTHETIC, Splitter:B:37:0x0068] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0070 A[Catch:{ Exception -> 0x006c }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x007c A[SYNTHETIC, Splitter:B:47:0x007c] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0084 A[Catch:{ Exception -> 0x0080 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean ad() {
        /*
            r6 = this;
            java.lang.String r0 = r6.qw
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 0
            if (r0 == 0) goto L_0x000a
            return r1
        L_0x000a:
            java.io.File r0 = new java.io.File
            java.lang.String r2 = r6.qw
            r0.<init>(r2)
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x005f, all -> 0x005c }
            r3.<init>(r0)     // Catch:{ Exception -> 0x005f, all -> 0x005c }
            java.util.zip.ZipInputStream r0 = new java.util.zip.ZipInputStream     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
            r0.<init>(r4)     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
        L_0x0021:
            java.util.zip.ZipEntry r2 = r0.getNextEntry()     // Catch:{ Exception -> 0x0053 }
            if (r2 == 0) goto L_0x0046
            boolean r4 = r2.isDirectory()     // Catch:{ Exception -> 0x0053 }
            if (r4 == 0) goto L_0x002e
            goto L_0x0021
        L_0x002e:
            java.lang.String r2 = r2.getName()     // Catch:{ Exception -> 0x0053 }
            java.lang.String r4 = "../"
            boolean r2 = r2.contains(r4)     // Catch:{ Exception -> 0x0053 }
            if (r2 == 0) goto L_0x0021
            r0.close()     // Catch:{ Exception -> 0x0041 }
            r3.close()     // Catch:{ Exception -> 0x0041 }
            goto L_0x0045
        L_0x0041:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0045:
            return r1
        L_0x0046:
            r0.close()     // Catch:{ Exception -> 0x004d }
            r3.close()     // Catch:{ Exception -> 0x004d }
            goto L_0x0051
        L_0x004d:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0051:
            r1 = 1
            goto L_0x0077
        L_0x0053:
            r2 = move-exception
            goto L_0x0063
        L_0x0055:
            r1 = move-exception
            goto L_0x007a
        L_0x0057:
            r0 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
            goto L_0x0063
        L_0x005c:
            r1 = move-exception
            r3 = r2
            goto L_0x007a
        L_0x005f:
            r0 = move-exception
            r3 = r2
            r2 = r0
            r0 = r3
        L_0x0063:
            r2.printStackTrace()     // Catch:{ all -> 0x0078 }
            if (r0 == 0) goto L_0x006e
            r0.close()     // Catch:{ Exception -> 0x006c }
            goto L_0x006e
        L_0x006c:
            r0 = move-exception
            goto L_0x0074
        L_0x006e:
            if (r3 == 0) goto L_0x0077
            r3.close()     // Catch:{ Exception -> 0x006c }
            goto L_0x0077
        L_0x0074:
            r0.printStackTrace()
        L_0x0077:
            return r1
        L_0x0078:
            r1 = move-exception
            r2 = r0
        L_0x007a:
            if (r2 == 0) goto L_0x0082
            r2.close()     // Catch:{ Exception -> 0x0080 }
            goto L_0x0082
        L_0x0080:
            r0 = move-exception
            goto L_0x0088
        L_0x0082:
            if (r3 == 0) goto L_0x008b
            r3.close()     // Catch:{ Exception -> 0x0080 }
            goto L_0x008b
        L_0x0088:
            r0.printStackTrace()
        L_0x008b:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.qw.qw.qw.ad():boolean");
    }

    public boolean qw() {
        return ad();
    }
}
