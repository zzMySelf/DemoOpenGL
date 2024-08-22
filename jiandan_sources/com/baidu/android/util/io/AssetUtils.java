package com.baidu.android.util.io;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public final class AssetUtils {
    public static final boolean DEBUG = false;
    public static final String TAG = "AssetUtils";

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean exists(android.content.Context r2, java.lang.String r3) {
        /*
            r0 = 0
            if (r2 == 0) goto L_0x0020
            boolean r1 = android.text.TextUtils.isEmpty(r3)
            if (r1 == 0) goto L_0x000a
            goto L_0x0020
        L_0x000a:
            android.content.res.AssetManager r2 = r2.getAssets()     // Catch:{ IOException -> 0x0020, all -> 0x001e }
            java.io.InputStream r2 = r2.open(r3, r0)     // Catch:{ IOException -> 0x0020, all -> 0x001e }
            r0 = 1
            if (r2 == 0) goto L_0x0020
            r2.close()     // Catch:{ IOException -> 0x0019 }
            goto L_0x0020
        L_0x0019:
            r2 = move-exception
            r2.printStackTrace()
            goto L_0x0020
        L_0x001e:
            r2 = move-exception
            throw r2
        L_0x0020:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.util.io.AssetUtils.exists(android.content.Context, java.lang.String):boolean");
    }

    public static boolean extractFileFromAsset(AssetManager assetManager, String str, String str2) {
        boolean z = false;
        try {
            z = StreamUtils.streamToFile(assetManager.open(str, 0), new File(str2));
            if (!z) {
                new File(str2).delete();
            }
        } catch (IOException unused) {
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0069 A[EDGE_INSN: B:23:0x0069->B:20:0x0069 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0066 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean extractFolderFromAsset(android.content.res.AssetManager r8, java.lang.String r9, java.lang.String r10) {
        /*
            r0 = 0
            java.lang.String[] r1 = r8.list(r9)     // Catch:{ IOException -> 0x006a }
            if (r1 == 0) goto L_0x006a
            int r2 = r1.length     // Catch:{ IOException -> 0x006a }
            r3 = 0
        L_0x0009:
            if (r0 >= r2) goto L_0x0069
            r4 = r1[r0]     // Catch:{ IOException -> 0x0069 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ IOException -> 0x0069 }
            if (r5 == 0) goto L_0x0014
            goto L_0x0066
        L_0x0014:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0069 }
            r5.<init>()     // Catch:{ IOException -> 0x0069 }
            r5.append(r9)     // Catch:{ IOException -> 0x0069 }
            java.lang.String r6 = java.io.File.separator     // Catch:{ IOException -> 0x0069 }
            r5.append(r6)     // Catch:{ IOException -> 0x0069 }
            r5.append(r4)     // Catch:{ IOException -> 0x0069 }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x0069 }
            java.lang.String[] r6 = r8.list(r5)     // Catch:{ IOException -> 0x0069 }
            if (r6 == 0) goto L_0x004b
            int r6 = r6.length     // Catch:{ IOException -> 0x0069 }
            if (r6 != 0) goto L_0x0032
            goto L_0x004b
        L_0x0032:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0069 }
            r6.<init>()     // Catch:{ IOException -> 0x0069 }
            r6.append(r10)     // Catch:{ IOException -> 0x0069 }
            java.lang.String r7 = java.io.File.separator     // Catch:{ IOException -> 0x0069 }
            r6.append(r7)     // Catch:{ IOException -> 0x0069 }
            r6.append(r4)     // Catch:{ IOException -> 0x0069 }
            java.lang.String r4 = r6.toString()     // Catch:{ IOException -> 0x0069 }
            boolean r3 = extractFolderFromAsset(r8, r5, r4)     // Catch:{ IOException -> 0x0069 }
            goto L_0x0063
        L_0x004b:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0069 }
            r6.<init>()     // Catch:{ IOException -> 0x0069 }
            r6.append(r10)     // Catch:{ IOException -> 0x0069 }
            java.lang.String r7 = java.io.File.separator     // Catch:{ IOException -> 0x0069 }
            r6.append(r7)     // Catch:{ IOException -> 0x0069 }
            r6.append(r4)     // Catch:{ IOException -> 0x0069 }
            java.lang.String r4 = r6.toString()     // Catch:{ IOException -> 0x0069 }
            boolean r3 = extractFileFromAsset(r8, r5, r4)     // Catch:{ IOException -> 0x0069 }
        L_0x0063:
            if (r3 != 0) goto L_0x0066
            goto L_0x0069
        L_0x0066:
            int r0 = r0 + 1
            goto L_0x0009
        L_0x0069:
            r0 = r3
        L_0x006a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.util.io.AssetUtils.extractFolderFromAsset(android.content.res.AssetManager, java.lang.String, java.lang.String):boolean");
    }

    @Deprecated
    public static String loadAssetsFile(Context context, String str) {
        return loadFile(context, str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v2, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String loadFile(android.content.Context r1, java.lang.String r2) {
        /*
            r0 = 0
            android.content.res.AssetManager r1 = r1.getAssets()     // Catch:{ IOException -> 0x001c, all -> 0x0017 }
            java.io.InputStream r1 = r1.open(r2)     // Catch:{ IOException -> 0x001c, all -> 0x0017 }
            if (r1 != 0) goto L_0x000f
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r1)
            return r0
        L_0x000f:
            java.lang.String r0 = com.baidu.android.util.io.StreamUtils.streamToString(r1)     // Catch:{ IOException -> 0x001d, all -> 0x0014 }
            goto L_0x001d
        L_0x0014:
            r2 = move-exception
            r0 = r1
            goto L_0x0018
        L_0x0017:
            r2 = move-exception
        L_0x0018:
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r0)
            throw r2
        L_0x001c:
            r1 = r0
        L_0x001d:
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.util.io.AssetUtils.loadFile(android.content.Context, java.lang.String):java.lang.String");
    }

    public static String readAsset(Context context, String str) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                inputStream = context.getAssets().open(str);
            } catch (IOException unused) {
                inputStream = null;
                Closeables.closeSafely((Closeable) inputStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                Closeables.closeSafely((Closeable) inputStream2);
                throw th;
            }
            try {
                String readInputStream = FileUtils.readInputStream(inputStream);
                Closeables.closeSafely((Closeable) inputStream);
                return readInputStream;
            } catch (IOException unused2) {
                Closeables.closeSafely((Closeable) inputStream);
                return null;
            } catch (Throwable th3) {
                th = th3;
                inputStream2 = inputStream;
                Closeables.closeSafely((Closeable) inputStream2);
                throw th;
            }
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.io.InputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean unzipFileFromAsset(java.lang.String r7, java.lang.String r8, android.content.Context r9) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            r1 = 0
            if (r0 != 0) goto L_0x00c1
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 == 0) goto L_0x000f
            goto L_0x00c1
        L_0x000f:
            java.io.File r0 = new java.io.File
            r0.<init>(r8)
            boolean r2 = r0.exists()
            if (r2 != 0) goto L_0x001d
            r0.mkdirs()
        L_0x001d:
            r0 = 0
            android.content.Context r9 = r9.getApplicationContext()     // Catch:{ IOException -> 0x00ba, all -> 0x00b1 }
            android.content.res.AssetManager r9 = r9.getAssets()     // Catch:{ IOException -> 0x00ba, all -> 0x00b1 }
            java.io.InputStream r7 = r9.open(r7)     // Catch:{ IOException -> 0x00ba, all -> 0x00b1 }
            java.util.zip.ZipInputStream r9 = new java.util.zip.ZipInputStream     // Catch:{ IOException -> 0x00ae, all -> 0x00aa }
            r9.<init>(r7)     // Catch:{ IOException -> 0x00ae, all -> 0x00aa }
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch:{ IOException -> 0x00af, all -> 0x00a8 }
        L_0x0033:
            java.util.zip.ZipEntry r3 = r9.getNextEntry()     // Catch:{ IOException -> 0x00af, all -> 0x00a8 }
            if (r3 == 0) goto L_0x00a0
            java.lang.String r4 = r3.getName()     // Catch:{ IOException -> 0x00af, all -> 0x00a8 }
            java.lang.String r5 = "../"
            boolean r4 = r4.contains(r5)     // Catch:{ IOException -> 0x00af, all -> 0x00a8 }
            if (r4 == 0) goto L_0x0046
            goto L_0x0033
        L_0x0046:
            java.io.File r4 = new java.io.File     // Catch:{ IOException -> 0x00af, all -> 0x00a8 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00af, all -> 0x00a8 }
            r5.<init>()     // Catch:{ IOException -> 0x00af, all -> 0x00a8 }
            r5.append(r8)     // Catch:{ IOException -> 0x00af, all -> 0x00a8 }
            java.lang.String r6 = java.io.File.separator     // Catch:{ IOException -> 0x00af, all -> 0x00a8 }
            r5.append(r6)     // Catch:{ IOException -> 0x00af, all -> 0x00a8 }
            java.lang.String r6 = r3.getName()     // Catch:{ IOException -> 0x00af, all -> 0x00a8 }
            r5.append(r6)     // Catch:{ IOException -> 0x00af, all -> 0x00a8 }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x00af, all -> 0x00a8 }
            r4.<init>(r5)     // Catch:{ IOException -> 0x00af, all -> 0x00a8 }
            boolean r3 = r3.isDirectory()     // Catch:{ IOException -> 0x00af, all -> 0x00a8 }
            if (r3 == 0) goto L_0x0073
            boolean r3 = r4.exists()     // Catch:{ IOException -> 0x00af, all -> 0x00a8 }
            if (r3 != 0) goto L_0x0033
            r4.mkdir()     // Catch:{ IOException -> 0x00af, all -> 0x00a8 }
            goto L_0x0033
        L_0x0073:
            boolean r3 = r4.exists()     // Catch:{ IOException -> 0x00af, all -> 0x00a8 }
            if (r3 != 0) goto L_0x0033
            com.baidu.android.util.io.FileUtils.createFileSafely(r4)     // Catch:{ IOException -> 0x00af, all -> 0x00a8 }
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x009b }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ all -> 0x009b }
            r5.<init>(r4)     // Catch:{ all -> 0x009b }
            r4 = 2048(0x800, float:2.87E-42)
            r3.<init>(r5, r4)     // Catch:{ all -> 0x009b }
        L_0x0088:
            int r0 = r9.read(r2)     // Catch:{ all -> 0x0098 }
            r4 = -1
            if (r0 == r4) goto L_0x0093
            r3.write(r2, r1, r0)     // Catch:{ all -> 0x0098 }
            goto L_0x0088
        L_0x0093:
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r3)     // Catch:{ IOException -> 0x00af, all -> 0x00a8 }
            r0 = r3
            goto L_0x0033
        L_0x0098:
            r8 = move-exception
            r0 = r3
            goto L_0x009c
        L_0x009b:
            r8 = move-exception
        L_0x009c:
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r0)     // Catch:{ IOException -> 0x00af, all -> 0x00a8 }
            throw r8     // Catch:{ IOException -> 0x00af, all -> 0x00a8 }
        L_0x00a0:
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r7)
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r9)
            r7 = 1
            return r7
        L_0x00a8:
            r8 = move-exception
            goto L_0x00ac
        L_0x00aa:
            r8 = move-exception
            r9 = r0
        L_0x00ac:
            r0 = r7
            goto L_0x00b3
        L_0x00ae:
            r9 = r0
        L_0x00af:
            r0 = r7
            goto L_0x00bb
        L_0x00b1:
            r8 = move-exception
            r9 = r0
        L_0x00b3:
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r0)
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r9)
            throw r8
        L_0x00ba:
            r9 = r0
        L_0x00bb:
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r0)
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r9)
        L_0x00c1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.util.io.AssetUtils.unzipFileFromAsset(java.lang.String, java.lang.String, android.content.Context):boolean");
    }
}
