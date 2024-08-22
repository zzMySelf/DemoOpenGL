package com.baidu.wallet.base.iddetect.utils;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.util.Base64;
import com.baidu.android.util.io.FileUtils;
import com.baidu.wallet.paysdk.datamodel.Bank;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class BitmapUtil {
    public static final long MIN_SD_CARD_SPACE = 5242880;

    public static void base64ToBitmap(String str, String str2, String str3) {
        FileOutputStream fileOutputStream;
        byte[] decode = Base64.decode(str, 0);
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
        try {
            fileOutputStream = new FileOutputStream(new File(Environment.getExternalStorageDirectory().getAbsolutePath(), str2));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fileOutputStream = null;
        }
        if (decodeByteArray.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        } else if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, float f, float f2) {
        int i2 = options.outHeight;
        int i3 = options.outWidth;
        float f3 = (float) i2;
        if (f3 <= f2 && ((float) i3) <= f) {
            return 1;
        }
        int round = Math.round(f3 / f2);
        int round2 = Math.round(((float) i3) / f);
        return round < round2 ? round : round2;
    }

    public static Bitmap decodeSampledBitmapFromByteArray(byte[] bArr, float f, float f2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        options.inSampleSize = calculateInSampleSize(options, f, f2);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources resources, int i2, int i3, int i4) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i2, options);
        options.inSampleSize = calculateInSampleSize(options, (float) i3, (float) i4);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, i2, options);
    }

    public static void fileScan(Context context, String str) {
        context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse((FileUtils.FILE_SCHEMA + str).replaceAll("%", "%25").replaceAll(Bank.HOT_BANK_LETTER, "%23").replaceAll(" ", "%20"))));
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002e A[SYNTHETIC, Splitter:B:14:0x002e] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003d A[SYNTHETIC, Splitter:B:23:0x003d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getBase64(android.graphics.Bitmap r4) {
        /*
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x003a, all -> 0x002b }
            r1.<init>()     // Catch:{ Exception -> 0x003a, all -> 0x002b }
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x003b, all -> 0x0028 }
            r3 = 70
            r4.compress(r2, r3, r1)     // Catch:{ Exception -> 0x003b, all -> 0x0028 }
            r1.flush()     // Catch:{ Exception -> 0x003b, all -> 0x0028 }
            r1.close()     // Catch:{ Exception -> 0x003b, all -> 0x0028 }
            byte[] r4 = r1.toByteArray()     // Catch:{ Exception -> 0x003b, all -> 0x0028 }
            r2 = 2
            java.lang.String r4 = android.util.Base64.encodeToString(r4, r2)     // Catch:{ Exception -> 0x003b, all -> 0x0028 }
            r1.flush()     // Catch:{ IOException -> 0x0023 }
            r1.close()     // Catch:{ IOException -> 0x0023 }
            goto L_0x0027
        L_0x0023:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0027:
            return r4
        L_0x0028:
            r4 = move-exception
            r0 = r1
            goto L_0x002c
        L_0x002b:
            r4 = move-exception
        L_0x002c:
            if (r0 == 0) goto L_0x0039
            r0.flush()     // Catch:{ IOException -> 0x0035 }
            r0.close()     // Catch:{ IOException -> 0x0035 }
            goto L_0x0039
        L_0x0035:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0039:
            throw r4
        L_0x003a:
            r1 = r0
        L_0x003b:
            if (r1 == 0) goto L_0x0048
            r1.flush()     // Catch:{ IOException -> 0x0044 }
            r1.close()     // Catch:{ IOException -> 0x0044 }
            goto L_0x0048
        L_0x0044:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0048:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.base.iddetect.utils.BitmapUtil.getBase64(android.graphics.Bitmap):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003f A[SYNTHETIC, Splitter:B:21:0x003f] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x004e A[SYNTHETIC, Splitter:B:30:0x004e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String imgToBase64(java.lang.String r4) {
        /*
            r0 = 0
            if (r4 == 0) goto L_0x000e
            int r1 = r4.length()
            if (r1 <= 0) goto L_0x000e
            android.graphics.Bitmap r4 = readBitmap(r4)
            goto L_0x000f
        L_0x000e:
            r4 = r0
        L_0x000f:
            if (r4 != 0) goto L_0x0012
            return r0
        L_0x0012:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x004b, all -> 0x003c }
            r1.<init>()     // Catch:{ Exception -> 0x004b, all -> 0x003c }
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x004c, all -> 0x0039 }
            r3 = 100
            r4.compress(r2, r3, r1)     // Catch:{ Exception -> 0x004c, all -> 0x0039 }
            r1.flush()     // Catch:{ Exception -> 0x004c, all -> 0x0039 }
            r1.close()     // Catch:{ Exception -> 0x004c, all -> 0x0039 }
            byte[] r4 = r1.toByteArray()     // Catch:{ Exception -> 0x004c, all -> 0x0039 }
            r2 = 2
            java.lang.String r4 = android.util.Base64.encodeToString(r4, r2)     // Catch:{ Exception -> 0x004c, all -> 0x0039 }
            r1.flush()     // Catch:{ IOException -> 0x0034 }
            r1.close()     // Catch:{ IOException -> 0x0034 }
            goto L_0x0038
        L_0x0034:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0038:
            return r4
        L_0x0039:
            r4 = move-exception
            r0 = r1
            goto L_0x003d
        L_0x003c:
            r4 = move-exception
        L_0x003d:
            if (r0 == 0) goto L_0x004a
            r0.flush()     // Catch:{ IOException -> 0x0046 }
            r0.close()     // Catch:{ IOException -> 0x0046 }
            goto L_0x004a
        L_0x0046:
            r0 = move-exception
            r0.printStackTrace()
        L_0x004a:
            throw r4
        L_0x004b:
            r1 = r0
        L_0x004c:
            if (r1 == 0) goto L_0x0059
            r1.flush()     // Catch:{ IOException -> 0x0055 }
            r1.close()     // Catch:{ IOException -> 0x0055 }
            goto L_0x0059
        L_0x0055:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0059:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.base.iddetect.utils.BitmapUtil.imgToBase64(java.lang.String):java.lang.String");
    }

    public static boolean isSdcardFull() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return ((long) statFs.getBlockSize()) * (((long) statFs.getAvailableBlocks()) - 4) < MIN_SD_CARD_SPACE;
    }

    public static Bitmap readBitmap(String str) {
        try {
            return BitmapFactory.decodeFile(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static int readPictureDegree(String str) {
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

    public static boolean saveImage(Context context, Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, int i2) {
        if (isSdcardFull()) {
            return false;
        }
        File file = new File(str);
        new File(file.getParent()).mkdirs();
        if (file.exists()) {
            file.delete();
        }
        FileOutputStream fileOutputStream = null;
        try {
            file.createNewFile();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                bitmap.compress(compressFormat, i2, fileOutputStream2);
                fileOutputStream2.close();
                fileScan(context, str);
                IOUtils.closeQuietly((OutputStream) fileOutputStream2);
                return true;
            } catch (IOException e) {
                e = e;
                fileOutputStream = fileOutputStream2;
                try {
                    e.printStackTrace();
                    IOUtils.closeQuietly((OutputStream) fileOutputStream);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    IOUtils.closeQuietly((OutputStream) fileOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = fileOutputStream2;
                IOUtils.closeQuietly((OutputStream) fileOutputStream);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            e.printStackTrace();
            IOUtils.closeQuietly((OutputStream) fileOutputStream);
            return false;
        }
    }
}
