package io.flutter.plugins.imagepicker;

import android.net.Uri;
import com.baidu.android.common.others.IStringUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtils {
    public static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                outputStream.flush();
                return;
            }
        }
    }

    public static String getImageExtension(Uri uri) {
        String str = null;
        try {
            String path = uri.getPath();
            if (!(path == null || path.lastIndexOf(IStringUtil.CURRENT_PATH) == -1)) {
                str = path.substring(path.lastIndexOf(IStringUtil.CURRENT_PATH) + 1);
            }
        } catch (Exception unused) {
        }
        if (str == null || str.isEmpty()) {
            str = "jpg";
        }
        return IStringUtil.CURRENT_PATH + str;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:4|5|6|7|(3:9|10|11)(1:13)|(2:15|16)|17|18|19) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0036, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0038, code lost:
        r5 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0039, code lost:
        r2 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x002f */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0038 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:4:0x0010] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0043 A[SYNTHETIC, Splitter:B:31:0x0043] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x004a A[SYNTHETIC, Splitter:B:35:0x004a] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0053 A[SYNTHETIC, Splitter:B:43:0x0053] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x005a A[SYNTHETIC, Splitter:B:47:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getPathFromUri(android.content.Context r5, android.net.Uri r6) {
        /*
            r4 = this;
            r0 = 0
            r1 = 0
            java.lang.String r2 = getImageExtension(r6)     // Catch:{ IOException -> 0x004e, all -> 0x003f }
            android.content.ContentResolver r3 = r5.getContentResolver()     // Catch:{ IOException -> 0x004e, all -> 0x003f }
            java.io.InputStream r6 = r3.openInputStream(r6)     // Catch:{ IOException -> 0x004e, all -> 0x003f }
            java.lang.String r3 = "image_picker"
            java.io.File r5 = r5.getCacheDir()     // Catch:{ IOException -> 0x003c, all -> 0x0038 }
            java.io.File r5 = java.io.File.createTempFile(r3, r2, r5)     // Catch:{ IOException -> 0x003c, all -> 0x0038 }
            r5.deleteOnExit()     // Catch:{ IOException -> 0x0036, all -> 0x0038 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0036, all -> 0x0038 }
            r2.<init>(r5)     // Catch:{ IOException -> 0x0036, all -> 0x0038 }
            if (r6 == 0) goto L_0x0029
            copy(r6, r2)     // Catch:{ IOException -> 0x0051, all -> 0x0027 }
            r3 = 1
            goto L_0x002a
        L_0x0027:
            r5 = move-exception
            goto L_0x003a
        L_0x0029:
            r3 = 0
        L_0x002a:
            if (r6 == 0) goto L_0x002f
            r6.close()     // Catch:{ IOException -> 0x002f }
        L_0x002f:
            r2.close()     // Catch:{ IOException -> 0x0034 }
            r0 = r3
            goto L_0x005d
        L_0x0034:
            goto L_0x005d
        L_0x0036:
            r2 = r1
            goto L_0x0051
        L_0x0038:
            r5 = move-exception
            r2 = r1
        L_0x003a:
            r1 = r6
            goto L_0x0041
        L_0x003c:
            r5 = r1
            r2 = r5
            goto L_0x0051
        L_0x003f:
            r5 = move-exception
            r2 = r1
        L_0x0041:
            if (r1 == 0) goto L_0x0048
            r1.close()     // Catch:{ IOException -> 0x0047 }
            goto L_0x0048
        L_0x0047:
        L_0x0048:
            if (r2 == 0) goto L_0x004d
            r2.close()     // Catch:{ IOException -> 0x004d }
        L_0x004d:
            throw r5
        L_0x004e:
            r5 = r1
            r6 = r5
            r2 = r6
        L_0x0051:
            if (r6 == 0) goto L_0x0058
            r6.close()     // Catch:{ IOException -> 0x0057 }
            goto L_0x0058
        L_0x0057:
        L_0x0058:
            if (r2 == 0) goto L_0x005d
            r2.close()     // Catch:{ IOException -> 0x0034 }
        L_0x005d:
            if (r0 == 0) goto L_0x0063
            java.lang.String r1 = r5.getPath()
        L_0x0063:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.imagepicker.FileUtils.getPathFromUri(android.content.Context, android.net.Uri):java.lang.String");
    }
}
