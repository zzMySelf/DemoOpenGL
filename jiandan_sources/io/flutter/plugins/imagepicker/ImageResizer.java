package io.flutter.plugins.imagepicker;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageResizer {
    public final ExifDataCopier exifDataCopier;
    public final File externalFilesDirectory;

    public ImageResizer(File file, ExifDataCopier exifDataCopier2) {
        this.externalFilesDirectory = file;
        this.exifDataCopier = exifDataCopier2;
    }

    private void copyExif(String str, String str2) {
        this.exifDataCopier.copyExif(str, str2);
    }

    private File createFile(File file, String str) {
        File file2 = new File(file.getParentFile().getAbsolutePath() + "/BaiduNote/img/", System.currentTimeMillis() + str);
        if (!file2.getParentFile().exists()) {
            file2.getParentFile().mkdirs();
        }
        return file2;
    }

    private File createImageOnExternalDirectory(String str, Bitmap bitmap, int i2) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
        File createFile = createFile(this.externalFilesDirectory, str);
        FileOutputStream createOutputStream = createOutputStream(createFile);
        createOutputStream.write(byteArrayOutputStream.toByteArray());
        createOutputStream.close();
        return createFile;
    }

    private FileOutputStream createOutputStream(File file) throws IOException {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new FileOutputStream(file);
    }

    private Bitmap createScaledBitmap(Bitmap bitmap, int i2, int i3, boolean z) {
        return Bitmap.createScaledBitmap(bitmap, i2, i3, z);
    }

    private Bitmap decodeFile(String str) {
        return BitmapFactory.decodeFile(str);
    }

    public static int decodeImageFileDegree(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
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

    private boolean isImageQualityValid(Integer num) {
        return num != null && num.intValue() > 0 && num.intValue() < 100;
    }

    private File resizedImage(Bitmap bitmap, String str, Double d, Double d2, Integer num, String str2) throws IOException {
        double width = ((double) bitmap.getWidth()) * 1.0d;
        double height = ((double) bitmap.getHeight()) * 1.0d;
        Integer num2 = num;
        if (!isImageQualityValid(num2)) {
            num2 = 100;
        }
        boolean z = true;
        boolean z2 = d != null;
        boolean z3 = d2 != null;
        Double valueOf = Double.valueOf(z2 ? Math.min(width, d.doubleValue()) : width);
        Double valueOf2 = Double.valueOf(z3 ? Math.min(height, d2.doubleValue()) : height);
        boolean z4 = z2 && d.doubleValue() < width;
        boolean z5 = z3 && d2.doubleValue() < height;
        if (!z4 && !z5) {
            z = false;
        }
        if (z) {
            double doubleValue = (valueOf2.doubleValue() / height) * width;
            double doubleValue2 = (valueOf.doubleValue() / width) * height;
            if (valueOf.doubleValue() < valueOf2.doubleValue()) {
                if (!z2) {
                    valueOf = Double.valueOf(doubleValue);
                } else {
                    valueOf2 = Double.valueOf(doubleValue2);
                }
            } else if (valueOf2.doubleValue() < valueOf.doubleValue()) {
                if (!z3) {
                    valueOf2 = Double.valueOf(doubleValue2);
                } else {
                    valueOf = Double.valueOf(doubleValue);
                }
            } else if (width < height) {
                valueOf = Double.valueOf(doubleValue);
            } else if (height < width) {
                valueOf2 = Double.valueOf(doubleValue2);
            }
        }
        int decodeImageFileDegree = decodeImageFileDegree(str);
        Matrix matrix = new Matrix();
        if (decodeImageFileDegree != 0) {
            matrix.setRotate((float) decodeImageFileDegree);
        }
        return createImageOnExternalDirectory(str2, Bitmap.createBitmap(bitmap, 0, 0, valueOf.intValue(), valueOf2.intValue(), matrix, false), num2.intValue());
    }

    public static int sampleSize(int i2, int i3, int i4, int i5) {
        int i6 = 1;
        while (true) {
            int i7 = i6 * 2;
            if (i3 / i7 <= i5 || i2 / i7 <= i4) {
                return i6;
            }
            i6 = i7;
        }
        return i6;
    }

    public String resizeImageIfNeeded(String str, @Nullable Double d, @Nullable Double d2, @Nullable Integer num) {
        Bitmap decodeFile = decodeFile(str);
        if (decodeFile == null) {
            return null;
        }
        if (!((d == null && d2 == null && !isImageQualityValid(num)) ? false : true)) {
            return str;
        }
        try {
            String[] split = str.split("/");
            File resizedImage = resizedImage(decodeFile, str, d, d2, num, split[split.length - 1]);
            copyExif(str, resizedImage.getPath());
            return resizedImage.getPath();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String resizeImageWithLengthLimitIfNeeded(String str, int i2, int i3, int i4) {
        try {
            String resizedImageWithLengthLimit = resizedImageWithLengthLimit(str, System.currentTimeMillis() + ".jpg", i2, i3, i4);
            this.exifDataCopier.copyExif(str, resizedImageWithLengthLimit);
            return resizedImageWithLengthLimit;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: java.io.FileOutputStream} */
    /* JADX WARNING: type inference failed for: r8v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c6 A[SYNTHETIC, Splitter:B:42:0x00c6] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0112 A[SYNTHETIC, Splitter:B:65:0x0112] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0138 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String resizedImageWithLengthLimit(java.lang.String r17, java.lang.String r18, int r19, int r20, int r21) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            r2 = r18
            r3 = r19
            r4 = r20
            int r5 = decodeImageFileDegree(r17)
            r6 = 0
            android.graphics.BitmapFactory$Options r7 = new android.graphics.BitmapFactory$Options     // Catch:{ all -> 0x00b0 }
            r7.<init>()     // Catch:{ all -> 0x00b0 }
            r8 = 1
            r7.inJustDecodeBounds = r8     // Catch:{ all -> 0x00b0 }
            android.graphics.BitmapFactory.decodeFile(r0, r7)     // Catch:{ all -> 0x00b0 }
            android.graphics.BitmapFactory$Options r8 = new android.graphics.BitmapFactory$Options     // Catch:{ all -> 0x00b0 }
            r8.<init>()     // Catch:{ all -> 0x00b0 }
            int r9 = r7.outWidth     // Catch:{ all -> 0x00b0 }
            int r10 = r7.outHeight     // Catch:{ all -> 0x00b0 }
            int r9 = java.lang.Math.max(r9, r10)     // Catch:{ all -> 0x00b0 }
            int r10 = r7.outWidth     // Catch:{ all -> 0x00b0 }
            int r7 = r7.outHeight     // Catch:{ all -> 0x00b0 }
            int r7 = java.lang.Math.min(r10, r7)     // Catch:{ all -> 0x00b0 }
            int r7 = sampleSize(r9, r7, r4, r3)     // Catch:{ all -> 0x00b0 }
            r8.inSampleSize = r7     // Catch:{ all -> 0x00b0 }
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeFile(r0, r8)     // Catch:{ all -> 0x00b0 }
            int r0 = r7.getHeight()     // Catch:{ all -> 0x00ab }
            int r8 = r7.getWidth()     // Catch:{ all -> 0x00ab }
            int r0 = java.lang.Math.max(r0, r8)     // Catch:{ all -> 0x00ab }
            int r8 = r7.getHeight()     // Catch:{ all -> 0x00ab }
            int r9 = r7.getWidth()     // Catch:{ all -> 0x00ab }
            int r8 = java.lang.Math.min(r8, r9)     // Catch:{ all -> 0x00ab }
            float r4 = (float) r4     // Catch:{ all -> 0x00ab }
            float r0 = (float) r0     // Catch:{ all -> 0x00ab }
            r9 = 1065353216(0x3f800000, float:1.0)
            float r0 = r0 * r9
            float r4 = r4 / r0
            float r0 = (float) r3     // Catch:{ all -> 0x00ab }
            float r3 = (float) r8     // Catch:{ all -> 0x00ab }
            float r3 = r3 * r9
            float r0 = r0 / r3
            int r3 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r3 < 0) goto L_0x0062
            goto L_0x0063
        L_0x0062:
            r4 = r0
        L_0x0063:
            int r0 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r0 <= 0) goto L_0x0068
            goto L_0x0069
        L_0x0068:
            r9 = r4
        L_0x0069:
            android.graphics.Matrix r14 = new android.graphics.Matrix     // Catch:{ all -> 0x00ab }
            r14.<init>()     // Catch:{ all -> 0x00ab }
            r14.setScale(r9, r9)     // Catch:{ all -> 0x00ab }
            if (r5 == 0) goto L_0x0077
            float r0 = (float) r5     // Catch:{ all -> 0x00ab }
            r14.setRotate(r0)     // Catch:{ all -> 0x00ab }
        L_0x0077:
            r10 = 0
            r11 = 0
            int r12 = r7.getWidth()     // Catch:{ all -> 0x00ab }
            int r13 = r7.getHeight()     // Catch:{ all -> 0x00ab }
            r15 = 0
            r9 = r7
            android.graphics.Bitmap r3 = android.graphics.Bitmap.createBitmap(r9, r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x00ab }
            if (r3 == r7) goto L_0x008c
            r7.recycle()     // Catch:{ all -> 0x00a8 }
        L_0x008c:
            java.io.File r0 = r1.externalFilesDirectory     // Catch:{ all -> 0x00a8 }
            java.io.File r4 = r1.createFile(r0, r2)     // Catch:{ all -> 0x00a8 }
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ all -> 0x00a5 }
            r8.<init>(r4)     // Catch:{ all -> 0x00a5 }
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ all -> 0x00a3 }
            r9 = r21
            r3.compress(r0, r9, r8)     // Catch:{ all -> 0x00a3 }
            r3.recycle()     // Catch:{ all -> 0x00a3 }
            r0 = 0
            goto L_0x00c2
        L_0x00a3:
            r0 = move-exception
            goto L_0x00b5
        L_0x00a5:
            r0 = move-exception
            r8 = r6
            goto L_0x00b5
        L_0x00a8:
            r0 = move-exception
            r4 = r6
            goto L_0x00ae
        L_0x00ab:
            r0 = move-exception
            r3 = r6
            r4 = r3
        L_0x00ae:
            r8 = r4
            goto L_0x00b5
        L_0x00b0:
            r0 = move-exception
            r3 = r6
            r4 = r3
            r7 = r4
            r8 = r7
        L_0x00b5:
            boolean r0 = r0 instanceof java.lang.OutOfMemoryError
            if (r3 == 0) goto L_0x00c2
            boolean r9 = r3.isRecycled()
            if (r9 != 0) goto L_0x00c2
            r3.recycle()
        L_0x00c2:
            r14 = r7
            r15 = r8
            if (r0 == 0) goto L_0x0110
            android.graphics.Matrix r12 = new android.graphics.Matrix     // Catch:{ all -> 0x010c }
            r12.<init>()     // Catch:{ all -> 0x010c }
            if (r5 == 0) goto L_0x00d1
            float r0 = (float) r5     // Catch:{ all -> 0x010c }
            r12.setRotate(r0)     // Catch:{ all -> 0x010c }
        L_0x00d1:
            if (r14 == 0) goto L_0x0110
            boolean r0 = r14.isRecycled()     // Catch:{ all -> 0x010c }
            if (r0 != 0) goto L_0x0110
            r8 = 0
            r9 = 0
            int r10 = r14.getWidth()     // Catch:{ all -> 0x010c }
            int r11 = r14.getHeight()     // Catch:{ all -> 0x010c }
            r13 = 0
            r7 = r14
            android.graphics.Bitmap r3 = android.graphics.Bitmap.createBitmap(r7, r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x010c }
            if (r3 == r14) goto L_0x00ee
            r14.recycle()     // Catch:{ all -> 0x010c }
        L_0x00ee:
            java.io.File r0 = r1.externalFilesDirectory     // Catch:{ all -> 0x010c }
            java.io.File r2 = r1.createFile(r0, r2)     // Catch:{ all -> 0x010c }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ all -> 0x0109 }
            r4.<init>(r2)     // Catch:{ all -> 0x0109 }
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ all -> 0x0106 }
            r5 = 80
            r3.compress(r0, r5, r4)     // Catch:{ all -> 0x0106 }
            r3.recycle()     // Catch:{ all -> 0x0106 }
            r15 = r4
            r4 = r2
            goto L_0x0110
        L_0x0106:
            r0 = move-exception
            r15 = r4
            goto L_0x010a
        L_0x0109:
            r0 = move-exception
        L_0x010a:
            r4 = r2
            goto L_0x010d
        L_0x010c:
            r0 = move-exception
        L_0x010d:
            r0.printStackTrace()
        L_0x0110:
            if (r15 == 0) goto L_0x011b
            r15.close()     // Catch:{ IOException -> 0x0116 }
            goto L_0x011b
        L_0x0116:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()
        L_0x011b:
            if (r14 == 0) goto L_0x0126
            boolean r0 = r14.isRecycled()
            if (r0 != 0) goto L_0x0126
            r14.recycle()
        L_0x0126:
            if (r3 == 0) goto L_0x0131
            boolean r0 = r3.isRecycled()
            if (r0 != 0) goto L_0x0131
            r3.recycle()
        L_0x0131:
            if (r4 == 0) goto L_0x0138
            java.lang.String r0 = r4.getAbsolutePath()
            return r0
        L_0x0138:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.imagepicker.ImageResizer.resizedImageWithLengthLimit(java.lang.String, java.lang.String, int, int, int):java.lang.String");
    }
}
