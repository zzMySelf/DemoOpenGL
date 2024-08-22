package fe.o.ad;

import android.content.Context;
import android.media.ExifInterface;
import com.baidu.android.common.others.IStringUtil;
import io.flutter.plugin.common.MethodChannel;
import java.io.File;
import java.util.Arrays;

public class ad implements MethodChannel.MethodCallHandler {

    /* renamed from: ad  reason: collision with root package name */
    public final Context f4628ad;

    public ad(Context context) {
        this.f4628ad = context;
    }

    public static String ad(File file) {
        String name = file.getName();
        return name.indexOf(IStringUtil.CURRENT_PATH) > 0 ? name.substring(0, name.lastIndexOf(IStringUtil.CURRENT_PATH)) : name;
    }

    public final void de(ExifInterface exifInterface, ExifInterface exifInterface2, String str) {
        if (exifInterface.getAttribute(str) != null) {
            exifInterface2.setAttribute(str, exifInterface.getAttribute(str));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:117:0x02c7 A[SYNTHETIC, Splitter:B:117:0x02c7] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x02d6 A[SYNTHETIC, Splitter:B:124:0x02d6] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x02e5 A[SYNTHETIC, Splitter:B:131:0x02e5] */
    /* JADX WARNING: Removed duplicated region for block: B:163:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:164:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:121:0x02cd=Splitter:B:121:0x02cd, B:114:0x02be=Splitter:B:114:0x02be} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(io.flutter.plugin.common.MethodCall r24, io.flutter.plugin.common.MethodChannel.Result r25) {
        /*
            r23 = this;
            r1 = r23
            r0 = r24
            r2 = r25
            java.lang.String r3 = r0.method
            java.lang.String r4 = "compressImage"
            boolean r3 = r3.equals(r4)
            java.lang.String r4 = "something went wrong"
            java.lang.String r5 = ".jpg"
            java.lang.String r6 = "percentage"
            r8 = 4636737291354636288(0x4059000000000000, double:100.0)
            java.lang.String r10 = "quality"
            java.lang.String r11 = "file"
            java.lang.String r12 = "targetHeight"
            java.lang.String r13 = "targetWidth"
            java.lang.String r14 = "file does not exist"
            r15 = 0
            if (r3 == 0) goto L_0x00fd
            java.lang.Object r3 = r0.argument(r11)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r6 = r0.argument(r6)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            java.lang.Object r11 = r0.argument(r13)
            if (r11 != 0) goto L_0x003b
            r11 = 0
            goto L_0x0045
        L_0x003b:
            java.lang.Object r11 = r0.argument(r13)
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
        L_0x0045:
            java.lang.Object r13 = r0.argument(r12)
            if (r13 != 0) goto L_0x004d
            r12 = 0
            goto L_0x0057
        L_0x004d:
            java.lang.Object r12 = r0.argument(r12)
            java.lang.Integer r12 = (java.lang.Integer) r12
            int r12 = r12.intValue()
        L_0x0057:
            java.lang.Object r0 = r0.argument(r10)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            java.io.File r10 = new java.io.File
            r10.<init>(r3)
            boolean r13 = r10.exists()
            if (r13 != 0) goto L_0x0070
            r2.error(r14, r3, r15)
            return
        L_0x0070:
            android.graphics.Bitmap r13 = android.graphics.BitmapFactory.decodeFile(r3)
            java.io.ByteArrayOutputStream r15 = new java.io.ByteArrayOutputStream
            r15.<init>()
            if (r11 != 0) goto L_0x0087
            int r11 = r13.getWidth()
            r18 = r3
            double r2 = (double) r11
            double r2 = r2 / r8
            double r7 = (double) r6
            double r2 = r2 * r7
            goto L_0x008a
        L_0x0087:
            r18 = r3
            double r2 = (double) r11
        L_0x008a:
            if (r12 != 0) goto L_0x0098
            int r7 = r13.getHeight()
            double r7 = (double) r7
            r11 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r7 = r7 / r11
            double r11 = (double) r6
            double r7 = r7 * r11
            goto L_0x0099
        L_0x0098:
            double r7 = (double) r12
        L_0x0099:
            int r2 = (int) r2
            int r3 = (int) r7
            r6 = 1
            android.graphics.Bitmap r2 = android.graphics.Bitmap.createScaledBitmap(r13, r2, r3, r6)
            android.graphics.Bitmap$Config r3 = android.graphics.Bitmap.Config.RGB_565
            r6 = 0
            android.graphics.Bitmap r2 = r2.copy(r3, r6)
            android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.JPEG
            r2.compress(r3, r0, r15)
            java.lang.String r0 = ad(r10)     // Catch:{ FileNotFoundException -> 0x00f0, IOException -> 0x00e3 }
            java.lang.String r2 = "_compressed"
            java.lang.String r0 = r0.concat(r2)     // Catch:{ FileNotFoundException -> 0x00f0, IOException -> 0x00e3 }
            android.content.Context r2 = r1.f4628ad     // Catch:{ FileNotFoundException -> 0x00f0, IOException -> 0x00e3 }
            java.io.File r2 = r2.getExternalCacheDir()     // Catch:{ FileNotFoundException -> 0x00f0, IOException -> 0x00e3 }
            java.io.File r0 = java.io.File.createTempFile(r0, r5, r2)     // Catch:{ FileNotFoundException -> 0x00f0, IOException -> 0x00e3 }
            java.lang.String r0 = r0.getPath()     // Catch:{ FileNotFoundException -> 0x00f0, IOException -> 0x00e3 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x00f0, IOException -> 0x00e3 }
            r2.<init>(r0)     // Catch:{ FileNotFoundException -> 0x00f0, IOException -> 0x00e3 }
            r15.writeTo(r2)     // Catch:{ FileNotFoundException -> 0x00f0, IOException -> 0x00e3 }
            r3 = r18
            r1.qw(r3, r0)     // Catch:{ FileNotFoundException -> 0x00df, IOException -> 0x00db }
            r2 = r25
            r2.success(r0)     // Catch:{ FileNotFoundException -> 0x00d9, IOException -> 0x00d7 }
            goto L_0x00fc
        L_0x00d7:
            r0 = move-exception
            goto L_0x00e8
        L_0x00d9:
            r0 = move-exception
            goto L_0x00f5
        L_0x00db:
            r0 = move-exception
            r2 = r25
            goto L_0x00e8
        L_0x00df:
            r0 = move-exception
            r2 = r25
            goto L_0x00f5
        L_0x00e3:
            r0 = move-exception
            r2 = r25
            r3 = r18
        L_0x00e8:
            r0.printStackTrace()
            r5 = 0
            r2.error(r4, r3, r5)
            goto L_0x00fc
        L_0x00f0:
            r0 = move-exception
            r2 = r25
            r3 = r18
        L_0x00f5:
            r5 = 0
            r0.printStackTrace()
            r2.error(r14, r3, r5)
        L_0x00fc:
            return
        L_0x00fd:
            java.lang.String r3 = r0.method
            java.lang.String r7 = "memoryCompressImage"
            boolean r3 = r3.equals(r7)
            if (r3 == 0) goto L_0x019a
            java.lang.Object r3 = r0.argument(r11)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r4 = r0.argument(r6)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            java.lang.Object r5 = r0.argument(r13)
            if (r5 != 0) goto L_0x011f
            r5 = 0
            goto L_0x0129
        L_0x011f:
            java.lang.Object r5 = r0.argument(r13)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
        L_0x0129:
            java.lang.Object r6 = r0.argument(r12)
            if (r6 != 0) goto L_0x0131
            r6 = 0
            goto L_0x013b
        L_0x0131:
            java.lang.Object r6 = r0.argument(r12)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
        L_0x013b:
            java.lang.Object r0 = r0.argument(r10)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            java.io.File r7 = new java.io.File
            r7.<init>(r3)
            boolean r7 = r7.exists()
            if (r7 != 0) goto L_0x0155
            r7 = 0
            r2.error(r14, r3, r7)
            return
        L_0x0155:
            android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeFile(r3)
            java.io.ByteArrayOutputStream r7 = new java.io.ByteArrayOutputStream
            r7.<init>()
            if (r5 != 0) goto L_0x016c
            int r5 = r3.getWidth()
            double r8 = (double) r5
            r10 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r8 = r8 / r10
            double r12 = (double) r4
            double r8 = r8 * r12
            goto L_0x016f
        L_0x016c:
            r10 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r8 = (double) r5
        L_0x016f:
            if (r6 != 0) goto L_0x017b
            int r5 = r3.getHeight()
            double r5 = (double) r5
            double r5 = r5 / r10
            double r10 = (double) r4
            double r5 = r5 * r10
            goto L_0x017c
        L_0x017b:
            double r5 = (double) r6
        L_0x017c:
            int r4 = (int) r8
            int r5 = (int) r5
            r6 = 1
            android.graphics.Bitmap r3 = android.graphics.Bitmap.createScaledBitmap(r3, r4, r5, r6)
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.RGB_565
            r5 = 0
            android.graphics.Bitmap r3 = r3.copy(r4, r5)
            android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.JPEG
            r3.compress(r4, r0, r7)
            byte[] r0 = r7.toByteArray()
            r3.recycle()
            r2.success(r0)
            return
        L_0x019a:
            java.lang.String r3 = r0.method
            java.lang.String r6 = "getImageProperties"
            boolean r3 = r3.equals(r6)
            java.lang.String r6 = "height"
            java.lang.String r7 = "width"
            if (r3 == 0) goto L_0x01fc
            java.lang.Object r0 = r0.argument(r11)
            java.lang.String r0 = (java.lang.String) r0
            java.io.File r3 = new java.io.File
            r3.<init>(r0)
            boolean r3 = r3.exists()
            if (r3 != 0) goto L_0x01be
            r3 = 0
            r2.error(r14, r0, r3)
            return
        L_0x01be:
            android.graphics.BitmapFactory$Options r3 = new android.graphics.BitmapFactory$Options
            r3.<init>()
            r4 = 1
            r3.inJustDecodeBounds = r4
            android.graphics.BitmapFactory.decodeFile(r0, r3)
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            int r5 = r3.outWidth
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r4.put(r7, r5)
            int r3 = r3.outHeight
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r4.put(r6, r3)
            android.media.ExifInterface r3 = new android.media.ExifInterface     // Catch:{ IOException -> 0x01ed }
            r3.<init>(r0)     // Catch:{ IOException -> 0x01ed }
            java.lang.String r0 = "Orientation"
            r8 = 0
            int r15 = r3.getAttributeInt(r0, r8)     // Catch:{ IOException -> 0x01ee }
            goto L_0x01ef
        L_0x01ed:
            r8 = 0
        L_0x01ee:
            r15 = 0
        L_0x01ef:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r15)
            java.lang.String r3 = "orientation"
            r4.put(r3, r0)
            r2.success(r4)
            return
        L_0x01fc:
            r8 = 0
            java.lang.String r3 = r0.method
            java.lang.String r9 = "cropImage"
            boolean r3 = r3.equals(r9)
            r9 = 100
            if (r3 == 0) goto L_0x02ef
            java.lang.Object r3 = r0.argument(r11)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r8 = "originX"
            java.lang.Object r8 = r0.argument(r8)
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            java.lang.String r10 = "originY"
            java.lang.Object r10 = r0.argument(r10)
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            java.lang.Object r7 = r0.argument(r7)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            java.lang.Object r0 = r0.argument(r6)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            java.io.File r6 = new java.io.File
            r6.<init>(r3)
            boolean r11 = r6.exists()
            if (r11 != 0) goto L_0x024b
            r11 = 0
            r2.error(r14, r3, r11)
            return
        L_0x024b:
            java.lang.String r11 = r3.toLowerCase()
            java.lang.String r12 = ".png"
            boolean r11 = r11.contains(r12)
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r11)
            boolean r13 = r11.booleanValue()
            if (r13 == 0) goto L_0x0262
            android.graphics.Bitmap$CompressFormat r13 = android.graphics.Bitmap.CompressFormat.PNG
            goto L_0x0264
        L_0x0262:
            android.graphics.Bitmap$CompressFormat r13 = android.graphics.Bitmap.CompressFormat.JPEG
        L_0x0264:
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x026b
            r5 = r12
        L_0x026b:
            android.graphics.Bitmap r11 = android.graphics.BitmapFactory.decodeFile(r3)
            java.io.ByteArrayOutputStream r12 = new java.io.ByteArrayOutputStream
            r12.<init>()
            android.graphics.Bitmap r11 = android.graphics.Bitmap.createBitmap(r11, r8, r10, r7, r0)     // Catch:{ IllegalArgumentException -> 0x0279 }
            goto L_0x0284
        L_0x0279:
            r0 = move-exception
            r7 = r0
            r7.printStackTrace()
            java.lang.String r0 = "bounds are outside of the dimensions of the source image"
            r7 = 0
            r2.error(r0, r3, r7)
        L_0x0284:
            r11.compress(r13, r9, r12)
            r11.recycle()
            java.lang.String r0 = ad(r6)     // Catch:{ FileNotFoundException -> 0x02cb, IOException -> 0x02bc, all -> 0x02b8 }
            java.lang.String r6 = "_cropped"
            java.lang.String r0 = r0.concat(r6)     // Catch:{ FileNotFoundException -> 0x02cb, IOException -> 0x02bc, all -> 0x02b8 }
            android.content.Context r6 = r1.f4628ad     // Catch:{ FileNotFoundException -> 0x02cb, IOException -> 0x02bc, all -> 0x02b8 }
            java.io.File r6 = r6.getExternalCacheDir()     // Catch:{ FileNotFoundException -> 0x02cb, IOException -> 0x02bc, all -> 0x02b8 }
            java.io.File r0 = java.io.File.createTempFile(r0, r5, r6)     // Catch:{ FileNotFoundException -> 0x02cb, IOException -> 0x02bc, all -> 0x02b8 }
            java.lang.String r0 = r0.getPath()     // Catch:{ FileNotFoundException -> 0x02cb, IOException -> 0x02bc, all -> 0x02b8 }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x02cb, IOException -> 0x02bc, all -> 0x02b8 }
            r5.<init>(r0)     // Catch:{ FileNotFoundException -> 0x02cb, IOException -> 0x02bc, all -> 0x02b8 }
            r12.writeTo(r5)     // Catch:{ FileNotFoundException -> 0x02b6, IOException -> 0x02b4 }
            r1.qw(r3, r0)     // Catch:{ FileNotFoundException -> 0x02b6, IOException -> 0x02b4 }
            r2.success(r0)     // Catch:{ FileNotFoundException -> 0x02b6, IOException -> 0x02b4 }
            r5.close()     // Catch:{ IOException -> 0x02da }
            goto L_0x02df
        L_0x02b4:
            r0 = move-exception
            goto L_0x02be
        L_0x02b6:
            r0 = move-exception
            goto L_0x02cd
        L_0x02b8:
            r0 = move-exception
            r2 = r0
            r15 = 0
            goto L_0x02e3
        L_0x02bc:
            r0 = move-exception
            r5 = 0
        L_0x02be:
            r0.printStackTrace()     // Catch:{ all -> 0x02e0 }
            r6 = 0
            r2.error(r4, r3, r6)     // Catch:{ all -> 0x02e0 }
            if (r5 == 0) goto L_0x02df
            r5.close()     // Catch:{ IOException -> 0x02da }
            goto L_0x02df
        L_0x02cb:
            r0 = move-exception
            r5 = 0
        L_0x02cd:
            r0.printStackTrace()     // Catch:{ all -> 0x02e0 }
            r4 = 0
            r2.error(r14, r3, r4)     // Catch:{ all -> 0x02e0 }
            if (r5 == 0) goto L_0x02df
            r5.close()     // Catch:{ IOException -> 0x02da }
            goto L_0x02df
        L_0x02da:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()
        L_0x02df:
            return
        L_0x02e0:
            r0 = move-exception
            r2 = r0
            r15 = r5
        L_0x02e3:
            if (r15 == 0) goto L_0x02ee
            r15.close()     // Catch:{ IOException -> 0x02e9 }
            goto L_0x02ee
        L_0x02e9:
            r0 = move-exception
            r3 = r0
            r3.printStackTrace()
        L_0x02ee:
            throw r2
        L_0x02ef:
            java.lang.String r3 = r0.method
            java.lang.String r4 = "memoryResizeImage"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x038d
            java.lang.Object r3 = r0.argument(r11)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r4 = r0.argument(r13)
            if (r4 != 0) goto L_0x0307
            r6 = 0
            goto L_0x0311
        L_0x0307:
            java.lang.Object r4 = r0.argument(r13)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r6 = r4.intValue()
        L_0x0311:
            java.lang.Object r4 = r0.argument(r12)
            if (r4 != 0) goto L_0x0319
            r15 = 0
            goto L_0x0323
        L_0x0319:
            java.lang.Object r4 = r0.argument(r12)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r15 = r4.intValue()
        L_0x0323:
            java.lang.Object r4 = r0.argument(r10)
            if (r4 != 0) goto L_0x032a
            goto L_0x0334
        L_0x032a:
            java.lang.Object r0 = r0.argument(r10)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r9 = r0.intValue()
        L_0x0334:
            java.io.File r0 = new java.io.File
            r0.<init>(r3)
            boolean r0 = r0.exists()
            if (r0 != 0) goto L_0x0344
            r4 = 0
            r2.error(r14, r3, r4)
            return
        L_0x0344:
            android.graphics.Bitmap r16 = android.graphics.BitmapFactory.decodeFile(r3)
            android.graphics.Matrix r0 = new android.graphics.Matrix
            r0.<init>()
            float r3 = (float) r6
            r4 = 1065353216(0x3f800000, float:1.0)
            float r3 = r3 * r4
            int r5 = r16.getWidth()
            float r5 = (float) r5
            float r3 = r3 / r5
            float r5 = (float) r15
            float r5 = r5 * r4
            int r4 = r16.getHeight()
            float r4 = (float) r4
            float r5 = r5 / r4
            r0.postScale(r3, r5)
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream
            r3.<init>()
            r17 = 0
            r18 = 0
            int r19 = r16.getWidth()
            int r20 = r16.getHeight()
            r22 = 1
            r21 = r0
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r16, r17, r18, r19, r20, r21, r22)
            android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.JPEG
            r0.compress(r4, r9, r3)
            byte[] r3 = r3.toByteArray()
            r0.recycle()
            r2.success(r3)
            return
        L_0x038d:
            java.lang.String r0 = r0.method
            java.lang.String r3 = "getPlatformVersion"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x03ae
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "Android "
            r0.append(r3)
            java.lang.String r3 = android.os.Build.VERSION.RELEASE
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            r2.success(r0)
            goto L_0x03b1
        L_0x03ae:
            r25.notImplemented()
        L_0x03b1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.o.ad.ad.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    public final void qw(String str, String str2) {
        try {
            ExifInterface exifInterface = new ExifInterface(str);
            ExifInterface exifInterface2 = new ExifInterface(str2);
            for (String de2 : Arrays.asList(new String[]{androidx.exifinterface.media.ExifInterface.TAG_F_NUMBER, androidx.exifinterface.media.ExifInterface.TAG_EXPOSURE_TIME, androidx.exifinterface.media.ExifInterface.TAG_ISO_SPEED_RATINGS, androidx.exifinterface.media.ExifInterface.TAG_GPS_ALTITUDE, androidx.exifinterface.media.ExifInterface.TAG_GPS_ALTITUDE_REF, androidx.exifinterface.media.ExifInterface.TAG_FOCAL_LENGTH, androidx.exifinterface.media.ExifInterface.TAG_GPS_DATESTAMP, androidx.exifinterface.media.ExifInterface.TAG_WHITE_BALANCE, androidx.exifinterface.media.ExifInterface.TAG_GPS_PROCESSING_METHOD, androidx.exifinterface.media.ExifInterface.TAG_GPS_TIMESTAMP, androidx.exifinterface.media.ExifInterface.TAG_DATETIME, androidx.exifinterface.media.ExifInterface.TAG_FLASH, androidx.exifinterface.media.ExifInterface.TAG_GPS_LATITUDE, androidx.exifinterface.media.ExifInterface.TAG_GPS_LATITUDE_REF, androidx.exifinterface.media.ExifInterface.TAG_GPS_LONGITUDE, androidx.exifinterface.media.ExifInterface.TAG_GPS_LONGITUDE_REF, androidx.exifinterface.media.ExifInterface.TAG_MAKE, androidx.exifinterface.media.ExifInterface.TAG_MODEL, androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION})) {
                try {
                    de(exifInterface, exifInterface2, de2);
                } catch (Exception e) {
                    e = e;
                    "Error preserving Exif data on selected image: " + e;
                }
            }
            exifInterface2.saveAttributes();
        } catch (Exception e2) {
            e = e2;
            "Error preserving Exif data on selected image: " + e;
        }
    }
}
