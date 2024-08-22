package fe.fe.fe.i;

import java.io.Closeable;
import java.io.IOException;

public final class de {
    public static void ad(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                de(e);
            }
        }
    }

    public static void de(Throwable th2) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0032 A[SYNTHETIC, Splitter:B:22:0x0032] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x003f A[SYNTHETIC, Splitter:B:30:0x003f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String qw(java.io.File r5) {
        /*
            r0 = 0
            java.io.FileReader r1 = new java.io.FileReader     // Catch:{ Exception -> 0x002b, all -> 0x0029 }
            r1.<init>(r5)     // Catch:{ Exception -> 0x002b, all -> 0x0029 }
            r5 = 8192(0x2000, float:1.14794E-41)
            char[] r5 = new char[r5]     // Catch:{ Exception -> 0x0027 }
            java.io.CharArrayWriter r2 = new java.io.CharArrayWriter     // Catch:{ Exception -> 0x0027 }
            r2.<init>()     // Catch:{ Exception -> 0x0027 }
        L_0x000f:
            int r3 = r1.read(r5)     // Catch:{ Exception -> 0x0027 }
            if (r3 <= 0) goto L_0x001a
            r4 = 0
            r2.write(r5, r4, r3)     // Catch:{ Exception -> 0x0027 }
            goto L_0x000f
        L_0x001a:
            java.lang.String r5 = r2.toString()     // Catch:{ Exception -> 0x0027 }
            r1.close()     // Catch:{ Exception -> 0x0022 }
            goto L_0x0026
        L_0x0022:
            r0 = move-exception
            de(r0)
        L_0x0026:
            return r5
        L_0x0027:
            r5 = move-exception
            goto L_0x002d
        L_0x0029:
            r5 = move-exception
            goto L_0x003d
        L_0x002b:
            r5 = move-exception
            r1 = r0
        L_0x002d:
            de(r5)     // Catch:{ all -> 0x003b }
            if (r1 == 0) goto L_0x003a
            r1.close()     // Catch:{ Exception -> 0x0036 }
            goto L_0x003a
        L_0x0036:
            r5 = move-exception
            de(r5)
        L_0x003a:
            return r0
        L_0x003b:
            r5 = move-exception
            r0 = r1
        L_0x003d:
            if (r0 == 0) goto L_0x0047
            r0.close()     // Catch:{ Exception -> 0x0043 }
            goto L_0x0047
        L_0x0043:
            r0 = move-exception
            de(r0)
        L_0x0047:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.fe.i.de.qw(java.io.File):java.lang.String");
    }
}
