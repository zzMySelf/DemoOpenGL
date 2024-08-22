package com.baidu.searchbox.socialshare.utils;

import android.graphics.Bitmap;
import com.baidu.searchbox.config.AppConfig;

public class ImageUtils {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final long DEFAULT_MAX_PIXELS = 131072;

    public static String getBase64ImageFromBitmap(Bitmap bitmap, long maxPixels) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= 0 || height <= 0) {
            return null;
        }
        while (((long) (width * height)) > maxPixels) {
            width = (int) (((double) width) / 1.2d);
            height = (int) (((double) height) / 1.2d);
        }
        return getBase64ImageFromBitmap(Bitmap.createScaledBitmap(bitmap, width, height, true));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0023, code lost:
        if (DEBUG == false) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0025, code lost:
        r2.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003c, code lost:
        if (DEBUG == false) goto L_0x004e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getBase64ImageFromBitmap(android.graphics.Bitmap r5) {
        /*
            r0 = 0
            if (r5 == 0) goto L_0x004e
            r1 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ OutOfMemoryError -> 0x002b }
            r2.<init>()     // Catch:{ OutOfMemoryError -> 0x002b }
            r1 = r2
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ OutOfMemoryError -> 0x002b }
            r3 = 100
            r5.compress(r2, r3, r1)     // Catch:{ OutOfMemoryError -> 0x002b }
            byte[] r2 = r1.toByteArray()     // Catch:{ OutOfMemoryError -> 0x002b }
            r3 = 0
            java.lang.String r2 = android.util.Base64.encodeToString(r2, r3)     // Catch:{ OutOfMemoryError -> 0x002b }
            r0 = r2
            r1.close()     // Catch:{ IOException -> 0x0020 }
        L_0x001f:
            goto L_0x004e
        L_0x0020:
            r2 = move-exception
            boolean r3 = DEBUG
            if (r3 == 0) goto L_0x001f
        L_0x0025:
            r2.printStackTrace()
            goto L_0x001f
        L_0x0029:
            r2 = move-exception
            goto L_0x003f
        L_0x002b:
            r2 = move-exception
            boolean r3 = DEBUG     // Catch:{ all -> 0x0029 }
            if (r3 == 0) goto L_0x0033
            r2.printStackTrace()     // Catch:{ all -> 0x0029 }
        L_0x0033:
            if (r1 == 0) goto L_0x004e
            r1.close()     // Catch:{ IOException -> 0x0039 }
            goto L_0x001f
        L_0x0039:
            r2 = move-exception
            boolean r3 = DEBUG
            if (r3 == 0) goto L_0x001f
            goto L_0x0025
        L_0x003f:
            if (r1 == 0) goto L_0x004d
            r1.close()     // Catch:{ IOException -> 0x0045 }
            goto L_0x004d
        L_0x0045:
            r3 = move-exception
            boolean r4 = DEBUG
            if (r4 == 0) goto L_0x004d
            r3.printStackTrace()
        L_0x004d:
            throw r2
        L_0x004e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.socialshare.utils.ImageUtils.getBase64ImageFromBitmap(android.graphics.Bitmap):java.lang.String");
    }
}
