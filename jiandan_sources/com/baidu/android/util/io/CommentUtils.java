package com.baidu.android.util.io;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@Deprecated
public class CommentUtils {
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0043 A[SYNTHETIC, Splitter:B:18:0x0043] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e A[SYNTHETIC, Splitter:B:25:0x004e] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x005b A[SYNTHETIC, Splitter:B:33:0x005b] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:22:0x0049=Splitter:B:22:0x0049, B:15:0x003e=Splitter:B:15:0x003e} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String readApk(java.io.File r7) {
        /*
            r0 = 0
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch:{ FileNotFoundException -> 0x0047, IOException -> 0x003c, all -> 0x003a }
            java.lang.String r2 = "r"
            r1.<init>(r7, r2)     // Catch:{ FileNotFoundException -> 0x0047, IOException -> 0x003c, all -> 0x003a }
            long r2 = r1.length()     // Catch:{ FileNotFoundException -> 0x0038, IOException -> 0x0036 }
            r7 = 2
            byte[] r4 = new byte[r7]     // Catch:{ FileNotFoundException -> 0x0038, IOException -> 0x0036 }
            long r5 = (long) r7     // Catch:{ FileNotFoundException -> 0x0038, IOException -> 0x0036 }
            long r2 = r2 - r5
            r1.seek(r2)     // Catch:{ FileNotFoundException -> 0x0038, IOException -> 0x0036 }
            r1.readFully(r4)     // Catch:{ FileNotFoundException -> 0x0038, IOException -> 0x0036 }
            r7 = 0
            short r7 = stream2Short(r4, r7)     // Catch:{ FileNotFoundException -> 0x0038, IOException -> 0x0036 }
            byte[] r4 = new byte[r7]     // Catch:{ FileNotFoundException -> 0x0038, IOException -> 0x0036 }
            long r5 = (long) r7     // Catch:{ FileNotFoundException -> 0x0038, IOException -> 0x0036 }
            long r2 = r2 - r5
            r1.seek(r2)     // Catch:{ FileNotFoundException -> 0x0038, IOException -> 0x0036 }
            r1.readFully(r4)     // Catch:{ FileNotFoundException -> 0x0038, IOException -> 0x0036 }
            java.lang.String r7 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x0038, IOException -> 0x0036 }
            java.lang.String r2 = "utf-8"
            r7.<init>(r4, r2)     // Catch:{ FileNotFoundException -> 0x0038, IOException -> 0x0036 }
            r1.close()     // Catch:{ IOException -> 0x0031 }
            goto L_0x0035
        L_0x0031:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0035:
            return r7
        L_0x0036:
            r7 = move-exception
            goto L_0x003e
        L_0x0038:
            r7 = move-exception
            goto L_0x0049
        L_0x003a:
            r7 = move-exception
            goto L_0x0059
        L_0x003c:
            r7 = move-exception
            r1 = r0
        L_0x003e:
            r7.printStackTrace()     // Catch:{ all -> 0x0057 }
            if (r1 == 0) goto L_0x0056
            r1.close()     // Catch:{ IOException -> 0x0052 }
            goto L_0x0056
        L_0x0047:
            r7 = move-exception
            r1 = r0
        L_0x0049:
            r7.printStackTrace()     // Catch:{ all -> 0x0057 }
            if (r1 == 0) goto L_0x0056
            r1.close()     // Catch:{ IOException -> 0x0052 }
            goto L_0x0056
        L_0x0052:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0056:
            return r0
        L_0x0057:
            r7 = move-exception
            r0 = r1
        L_0x0059:
            if (r0 == 0) goto L_0x0063
            r0.close()     // Catch:{ IOException -> 0x005f }
            goto L_0x0063
        L_0x005f:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0063:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.util.io.CommentUtils.readApk(java.io.File):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x002b A[SYNTHETIC, Splitter:B:22:0x002b] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0038 A[SYNTHETIC, Splitter:B:29:0x0038] */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String readComment(java.io.File r3) {
        /*
            r0 = 0
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ IOException -> 0x0024, all -> 0x0022 }
            r2 = 19
            if (r1 < r2) goto L_0x0015
            java.util.zip.ZipFile r1 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x0024, all -> 0x0022 }
            r1.<init>(r3)     // Catch:{ IOException -> 0x0024, all -> 0x0022 }
            java.lang.String r0 = r1.getComment()     // Catch:{ IOException -> 0x0013 }
            r3 = r0
            r0 = r1
            goto L_0x0016
        L_0x0013:
            r3 = move-exception
            goto L_0x0026
        L_0x0015:
            r3 = r0
        L_0x0016:
            if (r0 == 0) goto L_0x0020
            r0.close()     // Catch:{ Exception -> 0x001c }
            goto L_0x0020
        L_0x001c:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0020:
            r0 = r3
            goto L_0x0033
        L_0x0022:
            r3 = move-exception
            goto L_0x0036
        L_0x0024:
            r3 = move-exception
            r1 = r0
        L_0x0026:
            r3.printStackTrace()     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x0033
            r1.close()     // Catch:{ Exception -> 0x002f }
            goto L_0x0033
        L_0x002f:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0033:
            return r0
        L_0x0034:
            r3 = move-exception
            r0 = r1
        L_0x0036:
            if (r0 == 0) goto L_0x0040
            r0.close()     // Catch:{ Exception -> 0x003c }
            goto L_0x0040
        L_0x003c:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0040:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.util.io.CommentUtils.readComment(java.io.File):java.lang.String");
    }

    public static byte[] short2Stream(short s) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putShort(s);
        allocate.flip();
        return allocate.array();
    }

    public static short stream2Short(byte[] bArr, int i2) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(bArr[i2]);
        allocate.put(bArr[i2 + 1]);
        return allocate.getShort(0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0086 A[SYNTHETIC, Splitter:B:44:0x0086] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x008e A[Catch:{ Exception -> 0x008a }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0093 A[Catch:{ Exception -> 0x008a }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009e A[SYNTHETIC, Splitter:B:56:0x009e] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00a6 A[Catch:{ Exception -> 0x00a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00ab A[Catch:{ Exception -> 0x00a2 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String writeApk(java.io.File r9, java.lang.String r10) {
        /*
            java.lang.String r0 = "bad"
            r1 = 0
            java.util.zip.ZipFile r2 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x007e, all -> 0x007a }
            r2.<init>(r9)     // Catch:{ IOException -> 0x007e, all -> 0x007a }
            java.lang.String r3 = ""
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ IOException -> 0x0075, all -> 0x0070 }
            r5 = 19
            if (r4 < r5) goto L_0x0014
            java.lang.String r3 = r2.getComment()     // Catch:{ IOException -> 0x0075, all -> 0x0070 }
        L_0x0014:
            if (r3 == 0) goto L_0x001f
            r2.close()     // Catch:{ Exception -> 0x001a }
            goto L_0x001e
        L_0x001a:
            r9 = move-exception
            r9.printStackTrace()
        L_0x001e:
            return r0
        L_0x001f:
            byte[] r10 = r10.getBytes()     // Catch:{ IOException -> 0x0075, all -> 0x0070 }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0075, all -> 0x0070 }
            r3.<init>()     // Catch:{ IOException -> 0x0075, all -> 0x0070 }
            r3.write(r10)     // Catch:{ IOException -> 0x006d, all -> 0x006a }
            int r10 = r10.length     // Catch:{ IOException -> 0x006d, all -> 0x006a }
            short r10 = (short) r10     // Catch:{ IOException -> 0x006d, all -> 0x006a }
            byte[] r10 = short2Stream(r10)     // Catch:{ IOException -> 0x006d, all -> 0x006a }
            r3.write(r10)     // Catch:{ IOException -> 0x006d, all -> 0x006a }
            byte[] r10 = r3.toByteArray()     // Catch:{ IOException -> 0x006d, all -> 0x006a }
            java.io.RandomAccessFile r4 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x006d, all -> 0x006a }
            java.lang.String r5 = "rw"
            r4.<init>(r9, r5)     // Catch:{ IOException -> 0x006d, all -> 0x006a }
            long r5 = r9.length()     // Catch:{ IOException -> 0x0068, all -> 0x0066 }
            r7 = 2
            long r5 = r5 - r7
            r4.seek(r5)     // Catch:{ IOException -> 0x0068, all -> 0x0066 }
            int r9 = r10.length     // Catch:{ IOException -> 0x0068, all -> 0x0066 }
            short r9 = (short) r9     // Catch:{ IOException -> 0x0068, all -> 0x0066 }
            byte[] r9 = short2Stream(r9)     // Catch:{ IOException -> 0x0068, all -> 0x0066 }
            r4.write(r9)     // Catch:{ IOException -> 0x0068, all -> 0x0066 }
            r4.write(r10)     // Catch:{ IOException -> 0x0068, all -> 0x0066 }
            java.lang.String r9 = "good"
            r2.close()     // Catch:{ Exception -> 0x0061 }
            r3.close()     // Catch:{ Exception -> 0x0061 }
            r4.close()     // Catch:{ Exception -> 0x0061 }
            goto L_0x0065
        L_0x0061:
            r10 = move-exception
            r10.printStackTrace()
        L_0x0065:
            return r9
        L_0x0066:
            r9 = move-exception
            goto L_0x0073
        L_0x0068:
            r9 = move-exception
            goto L_0x0078
        L_0x006a:
            r9 = move-exception
            r4 = r1
            goto L_0x0073
        L_0x006d:
            r9 = move-exception
            r4 = r1
            goto L_0x0078
        L_0x0070:
            r9 = move-exception
            r3 = r1
            r4 = r3
        L_0x0073:
            r1 = r2
            goto L_0x009c
        L_0x0075:
            r9 = move-exception
            r3 = r1
            r4 = r3
        L_0x0078:
            r1 = r2
            goto L_0x0081
        L_0x007a:
            r9 = move-exception
            r3 = r1
            r4 = r3
            goto L_0x009c
        L_0x007e:
            r9 = move-exception
            r3 = r1
            r4 = r3
        L_0x0081:
            r9.printStackTrace()     // Catch:{ all -> 0x009b }
            if (r1 == 0) goto L_0x008c
            r1.close()     // Catch:{ Exception -> 0x008a }
            goto L_0x008c
        L_0x008a:
            r9 = move-exception
            goto L_0x0097
        L_0x008c:
            if (r3 == 0) goto L_0x0091
            r3.close()     // Catch:{ Exception -> 0x008a }
        L_0x0091:
            if (r4 == 0) goto L_0x009a
            r4.close()     // Catch:{ Exception -> 0x008a }
            goto L_0x009a
        L_0x0097:
            r9.printStackTrace()
        L_0x009a:
            return r0
        L_0x009b:
            r9 = move-exception
        L_0x009c:
            if (r1 == 0) goto L_0x00a4
            r1.close()     // Catch:{ Exception -> 0x00a2 }
            goto L_0x00a4
        L_0x00a2:
            r10 = move-exception
            goto L_0x00af
        L_0x00a4:
            if (r3 == 0) goto L_0x00a9
            r3.close()     // Catch:{ Exception -> 0x00a2 }
        L_0x00a9:
            if (r4 == 0) goto L_0x00b2
            r4.close()     // Catch:{ Exception -> 0x00a2 }
            goto L_0x00b2
        L_0x00af:
            r10.printStackTrace()
        L_0x00b2:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.util.io.CommentUtils.writeApk(java.io.File, java.lang.String):java.lang.String");
    }
}
