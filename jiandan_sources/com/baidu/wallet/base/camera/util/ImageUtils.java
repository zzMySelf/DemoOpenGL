package com.baidu.wallet.base.camera.util;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.baidu.apollon.imagemanager.ImageProcessor;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.utils.LogUtil;
import com.dlife.ctaccountapi.w;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class ImageUtils implements NoProguard {
    public static final boolean DEBUG = true;
    public static final String TAG = "ImageUtils";
    public static final int UNCONSTRAINED = -1;

    /* JADX WARNING: Removed duplicated region for block: B:30:0x005a A[SYNTHETIC, Splitter:B:30:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0066 A[SYNTHETIC, Splitter:B:37:0x0066] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int calSampleSize(android.content.Context r5, android.net.Uri r6) {
        /*
            r0 = 1
            if (r5 == 0) goto L_0x006e
            if (r6 != 0) goto L_0x0007
            goto L_0x006e
        L_0x0007:
            android.graphics.BitmapFactory$Options r1 = new android.graphics.BitmapFactory$Options
            r1.<init>()
            r1.inJustDecodeBounds = r0
            r2 = 0
            android.content.ContentResolver r3 = r5.getContentResolver()     // Catch:{ Exception -> 0x0063, all -> 0x0057 }
            java.lang.String r4 = "r"
            android.os.ParcelFileDescriptor r6 = r3.openFileDescriptor(r6, r4)     // Catch:{ Exception -> 0x0063, all -> 0x0057 }
            r3 = 0
            if (r6 == 0) goto L_0x002f
            java.io.FileDescriptor r4 = r6.getFileDescriptor()     // Catch:{ Exception -> 0x002d, all -> 0x002a }
            android.graphics.BitmapFactory.decodeFileDescriptor(r4, r2, r1)     // Catch:{ Exception -> 0x002d, all -> 0x002a }
            int r2 = r1.outWidth     // Catch:{ Exception -> 0x002d, all -> 0x002a }
            int r1 = r1.outHeight     // Catch:{ Exception -> 0x002d, all -> 0x002a }
            int r2 = r2 * r1
            goto L_0x0030
        L_0x002a:
            r5 = move-exception
            r2 = r6
            goto L_0x0058
        L_0x002d:
            r2 = r6
            goto L_0x0064
        L_0x002f:
            r2 = 0
        L_0x0030:
            if (r6 == 0) goto L_0x003a
            r6.close()     // Catch:{ IOException -> 0x0036 }
            goto L_0x003a
        L_0x0036:
            r6 = move-exception
            r6.printStackTrace()
        L_0x003a:
            if (r2 != 0) goto L_0x003d
            return r0
        L_0x003d:
            int[] r5 = getScreenSize(r5)
            if (r5 != 0) goto L_0x0044
            return r0
        L_0x0044:
            double r1 = (double) r2
            r6 = r5[r3]
            r5 = r5[r0]
            int r6 = r6 * r5
            double r5 = (double) r6
            double r1 = r1 / r5
            double r5 = java.lang.Math.sqrt(r1)
            double r5 = java.lang.Math.ceil(r5)
            int r5 = (int) r5
            return r5
        L_0x0057:
            r5 = move-exception
        L_0x0058:
            if (r2 == 0) goto L_0x0062
            r2.close()     // Catch:{ IOException -> 0x005e }
            goto L_0x0062
        L_0x005e:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0062:
            throw r5
        L_0x0063:
        L_0x0064:
            if (r2 == 0) goto L_0x006e
            r2.close()     // Catch:{ IOException -> 0x006a }
            goto L_0x006e
        L_0x006a:
            r5 = move-exception
            r5.printStackTrace()
        L_0x006e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.base.camera.util.ImageUtils.calSampleSize(android.content.Context, android.net.Uri):int");
    }

    public static synchronized String createFileName(String str) {
        String format;
        synchronized (ImageUtils.class) {
            format = String.format("%s.%s", new Object[]{new SimpleDateFormat("yyyy_MM_dd-HH_mm_ss-SSS").format(new Date()), str});
        }
        return format;
    }

    public static Bitmap getBPfromsdcard(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = ImageProcessor.a(options, 361, -1);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public static Bitmap getBitmapFromRGB888(byte[] bArr, int i2, int i3) {
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        int i4 = i2 * i3;
        int[] iArr = new int[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = i5 * 3;
            iArr[i5] = Color.rgb(bArr[i6] & 255, bArr[i6 + 1] & 255, bArr[i6 + 2] & 255);
        }
        createBitmap.setPixels(iArr, 0, i2, 0, 0, i2, i3);
        return createBitmap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: android.os.ParcelFileDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.graphics.Bitmap} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x002c A[SYNTHETIC, Splitter:B:18:0x002c] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0034 A[SYNTHETIC, Splitter:B:24:0x0034] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap getBitmapFromUri(android.content.Context r2, android.net.Uri r3, android.graphics.BitmapFactory.Options r4) {
        /*
            r0 = 0
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ Exception -> 0x0025, all -> 0x0023 }
            java.lang.String r1 = "r"
            android.os.ParcelFileDescriptor r2 = r2.openFileDescriptor(r3, r1)     // Catch:{ Exception -> 0x0025, all -> 0x0023 }
            if (r2 == 0) goto L_0x0018
            java.io.FileDescriptor r3 = r2.getFileDescriptor()     // Catch:{ Exception -> 0x0016 }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeFileDescriptor(r3, r0, r4)     // Catch:{ Exception -> 0x0016 }
            goto L_0x0018
        L_0x0016:
            r3 = move-exception
            goto L_0x0027
        L_0x0018:
            if (r2 == 0) goto L_0x002f
            r2.close()     // Catch:{ IOException -> 0x001e }
            goto L_0x002f
        L_0x001e:
            r2 = move-exception
            r2.printStackTrace()
            goto L_0x002f
        L_0x0023:
            r3 = move-exception
            goto L_0x0032
        L_0x0025:
            r3 = move-exception
            r2 = r0
        L_0x0027:
            r3.printStackTrace()     // Catch:{ all -> 0x0030 }
            if (r2 == 0) goto L_0x002f
            r2.close()     // Catch:{ IOException -> 0x001e }
        L_0x002f:
            return r0
        L_0x0030:
            r3 = move-exception
            r0 = r2
        L_0x0032:
            if (r0 == 0) goto L_0x003c
            r0.close()     // Catch:{ IOException -> 0x0038 }
            goto L_0x003c
        L_0x0038:
            r2 = move-exception
            r2.printStackTrace()
        L_0x003c:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.base.camera.util.ImageUtils.getBitmapFromUri(android.content.Context, android.net.Uri, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    public static int[] getScreenSize(Context context) {
        if (context == null) {
            return null;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return new int[]{displayMetrics.widthPixels, displayMetrics.heightPixels};
    }

    public static Bitmap rotateAReversalBitmap(int i2, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i2);
        matrix.postScale(-1.0f, 1.0f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap rotateBitmap(int i2, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i2);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static String saveBitmapToCache(Context context, Bitmap bitmap, String str) {
        return saveBitmapToCache(context, bitmap, str, 100);
    }

    public static String saveBitmapToSdcard(Context context, Bitmap bitmap, String str) {
        String str2;
        if (context.getApplicationInfo().targetSdkVersion < 29 || Build.VERSION.SDK_INT < 29) {
            try {
                File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                if (TextUtils.isEmpty(str)) {
                    str = createFileName("jpg");
                }
                File file = new File(externalStoragePublicDirectory, str);
                if (bitmap.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(file))) {
                    return file.getAbsolutePath();
                }
                return "";
            } catch (Throwable th2) {
                LogUtil.e(TAG, "FileNotFoundException", th2);
                return "";
            }
        } else {
            if (TextUtils.isEmpty(str)) {
                str = "jpg";
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("_display_name", str);
            contentValues.put("mime_type", "image/jpeg");
            ContentResolver contentResolver = context.getContentResolver();
            Uri insert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            try {
                ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(insert, w.a, (CancellationSignal) null);
                if (openFileDescriptor != null) {
                    if (bitmap.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(openFileDescriptor.getFileDescriptor()))) {
                        str2 = insert.toString();
                        contentValues.clear();
                        contentResolver.update(insert, contentValues, (String) null, (String[]) null);
                        openFileDescriptor.close();
                        return str2;
                    }
                }
                str2 = "";
                contentValues.clear();
                contentResolver.update(insert, contentValues, (String) null, (String[]) null);
                openFileDescriptor.close();
                return str2;
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x005a A[SYNTHETIC, Splitter:B:28:0x005a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String saveBitmapToCache(android.content.Context r4, android.graphics.Bitmap r5, java.lang.String r6, int r7) {
        /*
            java.lang.String r0 = ""
            if (r7 < 0) goto L_0x006a
            r1 = 100
            if (r7 <= r1) goto L_0x0009
            goto L_0x006a
        L_0x0009:
            r1 = 0
            java.io.File r4 = r4.getCacheDir()     // Catch:{ all -> 0x0050 }
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x0050 }
            java.lang.String r4 = r4.getAbsolutePath()     // Catch:{ all -> 0x0050 }
            java.lang.String r3 = "image_cache"
            r2.<init>(r4, r3)     // Catch:{ all -> 0x0050 }
            boolean r4 = r2.exists()     // Catch:{ all -> 0x0050 }
            if (r4 != 0) goto L_0x0022
            r2.mkdirs()     // Catch:{ all -> 0x0050 }
        L_0x0022:
            boolean r4 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0050 }
            if (r4 == 0) goto L_0x002e
            java.lang.String r4 = "jpg"
            java.lang.String r6 = createFileName(r4)     // Catch:{ all -> 0x0050 }
        L_0x002e:
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x0050 }
            r4.<init>(r2, r6)     // Catch:{ all -> 0x0050 }
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ all -> 0x0050 }
            r6.<init>(r4)     // Catch:{ all -> 0x0050 }
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ all -> 0x004d }
            boolean r5 = r5.compress(r1, r7, r6)     // Catch:{ all -> 0x004d }
            if (r5 == 0) goto L_0x0044
            java.lang.String r0 = r4.getAbsolutePath()     // Catch:{ all -> 0x004d }
        L_0x0044:
            r6.close()     // Catch:{ IOException -> 0x0048 }
            goto L_0x005d
        L_0x0048:
            r4 = move-exception
            r4.printStackTrace()
            goto L_0x005d
        L_0x004d:
            r4 = move-exception
            r1 = r6
            goto L_0x0051
        L_0x0050:
            r4 = move-exception
        L_0x0051:
            java.lang.String r5 = "ImageUtils"
            java.lang.String r6 = "FileNotFoundException"
            com.baidu.wallet.core.utils.LogUtil.e(r5, r6, r4)     // Catch:{ all -> 0x005e }
            if (r1 == 0) goto L_0x005d
            r1.close()     // Catch:{ IOException -> 0x0048 }
        L_0x005d:
            return r0
        L_0x005e:
            r4 = move-exception
            if (r1 == 0) goto L_0x0069
            r1.close()     // Catch:{ IOException -> 0x0065 }
            goto L_0x0069
        L_0x0065:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0069:
            throw r4
        L_0x006a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.base.camera.util.ImageUtils.saveBitmapToCache(android.content.Context, android.graphics.Bitmap, java.lang.String, int):java.lang.String");
    }
}
