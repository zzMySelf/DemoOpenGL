package fe.fe.mmm.u;

import fe.fe.mmm.tt;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class th {
    public static final boolean qw = tt.vvv();

    /* JADX WARNING: Can't wrap try/catch for region: R(3:22|23|(3:25|26|44)(1:41)) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0036, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r0 = qw;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0048, code lost:
        if (r2 != null) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x004e, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0051, code lost:
        if (qw != false) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0053, code lost:
        r2.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0056, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0038 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String ad(java.io.InputStream r2) {
        /*
            byte[] r0 = qw(r2)     // Catch:{ Exception -> 0x0038 }
            if (r0 == 0) goto L_0x0027
            java.lang.String r1 = new java.lang.String     // Catch:{ Exception -> 0x0038 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0038 }
            java.lang.String r0 = "﻿"
            boolean r0 = r1.startsWith(r0)     // Catch:{ Exception -> 0x0038 }
            if (r0 == 0) goto L_0x0018
            r0 = 1
            java.lang.String r1 = r1.substring(r0)     // Catch:{ Exception -> 0x0038 }
        L_0x0018:
            if (r2 == 0) goto L_0x0026
            r2.close()     // Catch:{ Exception -> 0x001e }
            goto L_0x0026
        L_0x001e:
            r2 = move-exception
            boolean r0 = qw
            if (r0 == 0) goto L_0x0026
            r2.toString()
        L_0x0026:
            return r1
        L_0x0027:
            if (r2 == 0) goto L_0x0046
            r2.close()     // Catch:{ Exception -> 0x002d }
            goto L_0x0046
        L_0x002d:
            r2 = move-exception
            boolean r0 = qw
            if (r0 == 0) goto L_0x0046
        L_0x0032:
            r2.toString()
            goto L_0x0046
        L_0x0036:
            r0 = move-exception
            goto L_0x0048
        L_0x0038:
            boolean r0 = qw     // Catch:{ all -> 0x0036 }
            if (r2 == 0) goto L_0x0046
            r2.close()     // Catch:{ Exception -> 0x0040 }
            goto L_0x0046
        L_0x0040:
            r2 = move-exception
            boolean r0 = qw
            if (r0 == 0) goto L_0x0046
            goto L_0x0032
        L_0x0046:
            r2 = 0
            return r2
        L_0x0048:
            if (r2 == 0) goto L_0x0056
            r2.close()     // Catch:{ Exception -> 0x004e }
            goto L_0x0056
        L_0x004e:
            r2 = move-exception
            boolean r1 = qw
            if (r1 == 0) goto L_0x0056
            r2.toString()
        L_0x0056:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.mmm.u.th.ad(java.io.InputStream):java.lang.String");
    }

    public static byte[] qw(InputStream inputStream) {
        int i2;
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                i2 = inputStream.read(bArr, 0, 1024);
            } catch (IOException e) {
                if (qw) {
                    e.toString();
                }
                i2 = 0;
            }
            if (i2 == -1) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, i2);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException e2) {
            if (qw) {
                e2.toString();
            }
        }
        return byteArray;
    }
}
