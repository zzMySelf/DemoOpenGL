package fe.fe.ddd.de.qw;

import android.os.Looper;
import android.text.TextUtils;
import fe.fe.ddd.fe.ad.ad;
import java.io.File;

public class qw {
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0061, code lost:
        r8 = r6.split("----- pid | at | -----$");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0069, code lost:
        if (r8.length < 3) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006b, code lost:
        fe.fe.ddd.de.ad.de.f1381th = r8[2];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0072, code lost:
        r4 = r5.readLine();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0076, code lost:
        if (r4 == null) goto L_0x00b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x007e, code lost:
        if (r4.contains("----- end ") == false) goto L_0x0081;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0085, code lost:
        if (r4.contains("\"main\" prio=") == false) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0087, code lost:
        r3.append(r4);
        r3.append(org.apache.commons.lang3.StringUtils.LF);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x008d, code lost:
        r8 = r5.readLine();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0091, code lost:
        if (r8 != null) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0093, code lost:
        r8 = r3.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x009f, code lost:
        if (r8.startsWith("  at ") == false) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00a1, code lost:
        r3.append(r8.replace("  at ", ""));
        r3.append(org.apache.commons.lang3.StringUtils.LF);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00af, code lost:
        if (r8.equals("") == false) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        r8 = r3.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00b1 A[PHI: r5 
      PHI: (r5v4 java.io.BufferedReader) = (r5v1 java.io.BufferedReader), (r5v5 java.io.BufferedReader) binds: [B:66:0x00c9, B:50:0x00af] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC, Splitter:B:51:0x00b1] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00d4 A[SYNTHETIC, Splitter:B:72:0x00d4] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String ad(java.lang.String r8) {
        /*
            java.lang.String r0 = "  at "
            java.lang.String r1 = "\n"
            java.lang.String r2 = ""
            if (r8 != 0) goto L_0x0009
            return r2
        L_0x0009:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.io.File r4 = new java.io.File
            r4.<init>(r8)
            boolean r8 = r4.exists()
            if (r8 != 0) goto L_0x001a
            return r2
        L_0x001a:
            r8 = 0
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00c3, all -> 0x00bf }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00c3, all -> 0x00bf }
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ IOException -> 0x00c3, all -> 0x00bf }
            r7.<init>(r4)     // Catch:{ IOException -> 0x00c3, all -> 0x00bf }
            r6.<init>(r7)     // Catch:{ IOException -> 0x00c3, all -> 0x00bf }
            r5.<init>(r6)     // Catch:{ IOException -> 0x00c3, all -> 0x00bf }
            java.lang.String r8 = "----- pid "
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00bd }
            r4.<init>()     // Catch:{ IOException -> 0x00bd }
            java.lang.String r6 = "Cmd line: "
            r4.append(r6)     // Catch:{ IOException -> 0x00bd }
            java.lang.String r6 = fe.fe.ddd.de.th.qw.ad()     // Catch:{ IOException -> 0x00bd }
            r4.append(r6)     // Catch:{ IOException -> 0x00bd }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x00bd }
        L_0x0041:
            java.lang.String r6 = r5.readLine()     // Catch:{ IOException -> 0x00bd }
            if (r6 != 0) goto L_0x004f
            java.lang.String r8 = r3.toString()     // Catch:{ IOException -> 0x00bd }
            r5.close()     // Catch:{ IOException -> 0x004e }
        L_0x004e:
            return r8
        L_0x004f:
            boolean r7 = r6.contains(r8)     // Catch:{ IOException -> 0x00bd }
            if (r7 == 0) goto L_0x0041
            java.lang.String r7 = r5.readLine()     // Catch:{ IOException -> 0x00bd }
            if (r7 == 0) goto L_0x0041
            boolean r7 = r7.equals(r4)     // Catch:{ IOException -> 0x00bd }
            if (r7 == 0) goto L_0x0041
            java.lang.String r8 = "----- pid | at | -----$"
            java.lang.String[] r8 = r6.split(r8)     // Catch:{ IOException -> 0x00bd }
            int r4 = r8.length     // Catch:{ IOException -> 0x00bd }
            r6 = 3
            if (r4 < r6) goto L_0x0070
            r4 = 2
            r8 = r8[r4]     // Catch:{ IOException -> 0x00bd }
            fe.fe.ddd.de.ad.de.f1381th = r8     // Catch:{ IOException -> 0x00bd }
        L_0x0070:
            java.lang.String r8 = "\"main\" prio="
        L_0x0072:
            java.lang.String r4 = r5.readLine()     // Catch:{ IOException -> 0x00bd }
            if (r4 == 0) goto L_0x00b5
            java.lang.String r6 = "----- end "
            boolean r6 = r4.contains(r6)     // Catch:{ IOException -> 0x00bd }
            if (r6 == 0) goto L_0x0081
            goto L_0x00b5
        L_0x0081:
            boolean r6 = r4.contains(r8)     // Catch:{ IOException -> 0x00bd }
            if (r6 == 0) goto L_0x0072
            r3.append(r4)     // Catch:{ IOException -> 0x00bd }
            r3.append(r1)     // Catch:{ IOException -> 0x00bd }
        L_0x008d:
            java.lang.String r8 = r5.readLine()     // Catch:{ IOException -> 0x00bd }
            if (r8 != 0) goto L_0x009b
            java.lang.String r8 = r3.toString()     // Catch:{ IOException -> 0x00bd }
            r5.close()     // Catch:{ IOException -> 0x009a }
        L_0x009a:
            return r8
        L_0x009b:
            boolean r4 = r8.startsWith(r0)     // Catch:{ IOException -> 0x00bd }
            if (r4 == 0) goto L_0x00ab
            java.lang.String r4 = r8.replace(r0, r2)     // Catch:{ IOException -> 0x00bd }
            r3.append(r4)     // Catch:{ IOException -> 0x00bd }
            r3.append(r1)     // Catch:{ IOException -> 0x00bd }
        L_0x00ab:
            boolean r8 = r8.equals(r2)     // Catch:{ IOException -> 0x00bd }
            if (r8 == 0) goto L_0x008d
        L_0x00b1:
            r5.close()     // Catch:{ IOException -> 0x00cc }
            goto L_0x00cc
        L_0x00b5:
            java.lang.String r8 = r3.toString()     // Catch:{ IOException -> 0x00bd }
            r5.close()     // Catch:{ IOException -> 0x00bc }
        L_0x00bc:
            return r8
        L_0x00bd:
            r8 = move-exception
            goto L_0x00c6
        L_0x00bf:
            r0 = move-exception
            r5 = r8
            r8 = r0
            goto L_0x00d2
        L_0x00c3:
            r0 = move-exception
            r5 = r8
            r8 = r0
        L_0x00c6:
            r8.printStackTrace()     // Catch:{ all -> 0x00d1 }
            if (r5 == 0) goto L_0x00cc
            goto L_0x00b1
        L_0x00cc:
            java.lang.String r8 = r3.toString()
            return r8
        L_0x00d1:
            r8 = move-exception
        L_0x00d2:
            if (r5 == 0) goto L_0x00d7
            r5.close()     // Catch:{ IOException -> 0x00d7 }
        L_0x00d7:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.ddd.de.qw.qw.ad(java.lang.String):java.lang.String");
    }

    public static String qw() {
        String ad2 = new File("/data/anr/traces.txt").canRead() ? ad("/data/anr/traces.txt") : null;
        return TextUtils.isEmpty(ad2) ? ad.ad(Looper.getMainLooper().getThread()) : ad2;
    }
}
