package fe.mmm.qw.p024if.pf.uk;

import android.media.ExifInterface;
import java.io.IOException;

/* renamed from: fe.mmm.qw.if.pf.uk.de  reason: invalid package */
public class de {
    public static int ad(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt == 6) {
                return 90;
            }
            if (attributeInt != 8) {
                return 0;
            }
            return 270;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int de(int i2, int i3) {
        int i4 = 1;
        while (true) {
            int i5 = i4 * 2;
            if (i3 / i5 <= 600 || i2 / i5 <= 1600) {
                return i4;
            }
            i4 = i5;
        }
        return i4;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: java.io.File} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v4, resolved type: java.io.File} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v12, resolved type: java.io.File} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v15, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v16, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v17, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v18, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v19, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v20, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v21, resolved type: android.graphics.Bitmap} */
    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r13v0 */
    /* JADX WARNING: type inference failed for: r13v1, types: [java.io.File] */
    /* JADX WARNING: type inference failed for: r13v2 */
    /* JADX WARNING: type inference failed for: r7v2 */
    /* JADX WARNING: type inference failed for: r7v3 */
    /* JADX WARNING: type inference failed for: r7v9 */
    /* JADX WARNING: type inference failed for: r7v10, types: [java.io.OutputStream, java.io.FileOutputStream] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c0 A[SYNTHETIC, Splitter:B:43:0x00c0] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0110 A[SYNTHETIC, Splitter:B:69:0x0110] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0136 A[RETURN] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String qw(java.lang.String r15, java.lang.String r16) {
        /*
            r0 = r15
            r1 = r16
            int r2 = ad(r15)
            r3 = 0
            android.graphics.BitmapFactory$Options r4 = new android.graphics.BitmapFactory$Options     // Catch:{ all -> 0x00a8 }
            r4.<init>()     // Catch:{ all -> 0x00a8 }
            r5 = 1
            r4.inJustDecodeBounds = r5     // Catch:{ all -> 0x00a8 }
            android.graphics.BitmapFactory.decodeFile(r15, r4)     // Catch:{ all -> 0x00a8 }
            android.graphics.BitmapFactory$Options r5 = new android.graphics.BitmapFactory$Options     // Catch:{ all -> 0x00a8 }
            r5.<init>()     // Catch:{ all -> 0x00a8 }
            int r6 = r4.outWidth     // Catch:{ all -> 0x00a8 }
            int r7 = r4.outHeight     // Catch:{ all -> 0x00a8 }
            int r6 = java.lang.Math.max(r6, r7)     // Catch:{ all -> 0x00a8 }
            int r7 = r4.outWidth     // Catch:{ all -> 0x00a8 }
            int r4 = r4.outHeight     // Catch:{ all -> 0x00a8 }
            int r4 = java.lang.Math.min(r7, r4)     // Catch:{ all -> 0x00a8 }
            int r4 = de(r6, r4)     // Catch:{ all -> 0x00a8 }
            r5.inSampleSize = r4     // Catch:{ all -> 0x00a8 }
            android.graphics.Bitmap r4 = android.graphics.BitmapFactory.decodeFile(r15, r5)     // Catch:{ all -> 0x00a8 }
            int r0 = r4.getHeight()     // Catch:{ all -> 0x00a5 }
            int r5 = r4.getWidth()     // Catch:{ all -> 0x00a5 }
            int r0 = java.lang.Math.max(r0, r5)     // Catch:{ all -> 0x00a5 }
            int r5 = r4.getHeight()     // Catch:{ all -> 0x00a5 }
            int r6 = r4.getWidth()     // Catch:{ all -> 0x00a5 }
            int r5 = java.lang.Math.min(r5, r6)     // Catch:{ all -> 0x00a5 }
            r6 = 1153957888(0x44c80000, float:1600.0)
            float r0 = (float) r0     // Catch:{ all -> 0x00a5 }
            r7 = 1065353216(0x3f800000, float:1.0)
            float r0 = r0 * r7
            float r6 = r6 / r0
            r0 = 1142292480(0x44160000, float:600.0)
            float r5 = (float) r5     // Catch:{ all -> 0x00a5 }
            float r5 = r5 * r7
            float r0 = r0 / r5
            int r5 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r5 < 0) goto L_0x005d
            goto L_0x005e
        L_0x005d:
            r6 = r0
        L_0x005e:
            int r0 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r0 <= 0) goto L_0x0063
            goto L_0x0064
        L_0x0063:
            r7 = r6
        L_0x0064:
            android.graphics.Matrix r11 = new android.graphics.Matrix     // Catch:{ all -> 0x00a5 }
            r11.<init>()     // Catch:{ all -> 0x00a5 }
            r11.setScale(r7, r7)     // Catch:{ all -> 0x00a5 }
            if (r2 == 0) goto L_0x0072
            float r0 = (float) r2     // Catch:{ all -> 0x00a5 }
            r11.setRotate(r0)     // Catch:{ all -> 0x00a5 }
        L_0x0072:
            r7 = 0
            r8 = 0
            int r9 = r4.getWidth()     // Catch:{ all -> 0x00a5 }
            int r10 = r4.getHeight()     // Catch:{ all -> 0x00a5 }
            r12 = 0
            r6 = r4
            android.graphics.Bitmap r5 = android.graphics.Bitmap.createBitmap(r6, r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x00a5 }
            if (r5 == r4) goto L_0x0087
            r4.recycle()     // Catch:{ all -> 0x00a2 }
        L_0x0087:
            java.io.File r6 = new java.io.File     // Catch:{ all -> 0x00a2 }
            r6.<init>(r1)     // Catch:{ all -> 0x00a2 }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ all -> 0x009f }
            r7.<init>(r6)     // Catch:{ all -> 0x009f }
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ all -> 0x009d }
            r8 = 100
            r5.compress(r0, r8, r7)     // Catch:{ all -> 0x009d }
            r5.recycle()     // Catch:{ all -> 0x009d }
            r0 = 0
            goto L_0x00ba
        L_0x009d:
            r0 = move-exception
            goto L_0x00ad
        L_0x009f:
            r0 = move-exception
            r7 = r3
            goto L_0x00ad
        L_0x00a2:
            r0 = move-exception
            r6 = r3
            goto L_0x00ac
        L_0x00a5:
            r0 = move-exception
            r5 = r3
            goto L_0x00ab
        L_0x00a8:
            r0 = move-exception
            r4 = r3
            r5 = r4
        L_0x00ab:
            r6 = r5
        L_0x00ac:
            r7 = r6
        L_0x00ad:
            boolean r0 = r0 instanceof java.lang.OutOfMemoryError
            if (r5 == 0) goto L_0x00ba
            boolean r8 = r5.isRecycled()
            if (r8 != 0) goto L_0x00ba
            r5.recycle()
        L_0x00ba:
            r11 = r4
            r12 = r5
            r13 = r6
            r14 = r7
            if (r0 == 0) goto L_0x010e
            android.graphics.Matrix r9 = new android.graphics.Matrix     // Catch:{ all -> 0x010a }
            r9.<init>()     // Catch:{ all -> 0x010a }
            if (r2 == 0) goto L_0x00cb
            float r0 = (float) r2     // Catch:{ all -> 0x010a }
            r9.setRotate(r0)     // Catch:{ all -> 0x010a }
        L_0x00cb:
            if (r11 == 0) goto L_0x010e
            boolean r0 = r11.isRecycled()     // Catch:{ all -> 0x010a }
            if (r0 != 0) goto L_0x010e
            r5 = 0
            r6 = 0
            int r7 = r11.getWidth()     // Catch:{ all -> 0x010a }
            int r8 = r11.getHeight()     // Catch:{ all -> 0x010a }
            r10 = 0
            r4 = r11
            android.graphics.Bitmap r2 = android.graphics.Bitmap.createBitmap(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x010a }
            if (r2 == r11) goto L_0x00e8
            r11.recycle()     // Catch:{ all -> 0x0107 }
        L_0x00e8:
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x0107 }
            r4.<init>(r1)     // Catch:{ all -> 0x0107 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x0103 }
            r1.<init>(r4)     // Catch:{ all -> 0x0103 }
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ all -> 0x0100 }
            r5 = 80
            r2.compress(r0, r5, r1)     // Catch:{ all -> 0x0100 }
            r2.recycle()     // Catch:{ all -> 0x0100 }
            r14 = r1
            r12 = r2
            r13 = r4
            goto L_0x010e
        L_0x0100:
            r0 = move-exception
            r14 = r1
            goto L_0x0104
        L_0x0103:
            r0 = move-exception
        L_0x0104:
            r12 = r2
            r13 = r4
            goto L_0x010b
        L_0x0107:
            r0 = move-exception
            r12 = r2
            goto L_0x010b
        L_0x010a:
            r0 = move-exception
        L_0x010b:
            r0.printStackTrace()
        L_0x010e:
            if (r14 == 0) goto L_0x0119
            r14.close()     // Catch:{ IOException -> 0x0114 }
            goto L_0x0119
        L_0x0114:
            r0 = move-exception
            r1 = r0
            r1.printStackTrace()
        L_0x0119:
            if (r11 == 0) goto L_0x0124
            boolean r0 = r11.isRecycled()
            if (r0 != 0) goto L_0x0124
            r11.recycle()
        L_0x0124:
            if (r12 == 0) goto L_0x012f
            boolean r0 = r12.isRecycled()
            if (r0 != 0) goto L_0x012f
            r12.recycle()
        L_0x012f:
            if (r13 == 0) goto L_0x0136
            java.lang.String r0 = r13.getAbsolutePath()
            return r0
        L_0x0136:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.p024if.pf.uk.de.qw(java.lang.String, java.lang.String):java.lang.String");
    }
}
