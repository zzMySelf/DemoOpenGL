package fe.vvv.qw;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.otaliastudios.cameraview.BitmapCallback;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.FileCallback;
import com.otaliastudios.cameraview.controls.Facing;
import fe.vvv.qw.p037if.yj;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class de {
    public static final CameraLogger qw = CameraLogger.qw(de.class.getSimpleName());

    public class ad implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ byte[] f8942ad;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f8943i;

        /* renamed from: o  reason: collision with root package name */
        public final /* synthetic */ Handler f8944o;

        /* renamed from: pf  reason: collision with root package name */
        public final /* synthetic */ BitmapCallback f8945pf;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ int f8946th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ BitmapFactory.Options f8947uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ int f8948yj;

        public class qw implements Runnable {

            /* renamed from: ad  reason: collision with root package name */
            public final /* synthetic */ Bitmap f8949ad;

            public qw(Bitmap bitmap) {
                this.f8949ad = bitmap;
            }

            public void run() {
                ad.this.f8945pf.qw(this.f8949ad);
            }
        }

        public ad(byte[] bArr, int i2, int i3, BitmapFactory.Options options, int i4, Handler handler, BitmapCallback bitmapCallback) {
            this.f8942ad = bArr;
            this.f8946th = i2;
            this.f8948yj = i3;
            this.f8947uk = options;
            this.f8943i = i4;
            this.f8944o = handler;
            this.f8945pf = bitmapCallback;
        }

        public void run() {
            this.f8944o.post(new qw(de.de(this.f8942ad, this.f8946th, this.f8948yj, this.f8947uk, this.f8943i)));
        }
    }

    public class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ byte[] f8951ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ File f8952th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ FileCallback f8953uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ Handler f8954yj;

        /* renamed from: fe.vvv.qw.de$qw$qw  reason: collision with other inner class name */
        public class C0308qw implements Runnable {

            /* renamed from: ad  reason: collision with root package name */
            public final /* synthetic */ File f8955ad;

            public C0308qw(File file) {
                this.f8955ad = file;
            }

            public void run() {
                qw.this.f8953uk.qw(this.f8955ad);
            }
        }

        public qw(byte[] bArr, File file, Handler handler, FileCallback fileCallback) {
            this.f8951ad = bArr;
            this.f8952th = file;
            this.f8954yj = handler;
            this.f8953uk = fileCallback;
        }

        public void run() {
            this.f8954yj.post(new C0308qw(de.th(this.f8951ad, this.f8952th)));
        }
    }

    public static int ad(int i2, int i3, int i4, int i5) {
        int i6 = 1;
        if (i3 > i5 || i2 > i4) {
            while (true) {
                if (i3 / i6 < i5 && i2 / i6 < i4) {
                    break;
                }
                i6 *= 2;
            }
        }
        return i6;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0074 A[SYNTHETIC, Splitter:B:33:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x007f A[SYNTHETIC, Splitter:B:42:0x007f] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0099 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b0 A[Catch:{ OutOfMemoryError -> 0x00e8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c3 A[Catch:{ OutOfMemoryError -> 0x00e8 }] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap de(@androidx.annotation.NonNull byte[] r20, int r21, int r22, @androidx.annotation.NonNull android.graphics.BitmapFactory.Options r23, int r24) {
        /*
            r1 = r20
            r2 = r23
            r3 = 2147483647(0x7fffffff, float:NaN)
            if (r21 > 0) goto L_0x000d
            r4 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x000f
        L_0x000d:
            r4 = r21
        L_0x000f:
            if (r22 > 0) goto L_0x0015
            r5 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0017
        L_0x0015:
            r5 = r22
        L_0x0017:
            r0 = -1
            r6 = 0
            java.lang.String r7 = "decodeBitmap:"
            r8 = 3
            r9 = 2
            r10 = 1
            r11 = 0
            r12 = r24
            if (r12 != r0) goto L_0x0083
            java.io.ByteArrayInputStream r12 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x0061, all -> 0x005f }
            r12.<init>(r1)     // Catch:{ IOException -> 0x0061, all -> 0x005f }
            androidx.exifinterface.media.ExifInterface r0 = new androidx.exifinterface.media.ExifInterface     // Catch:{ IOException -> 0x005d }
            r0.<init>((java.io.InputStream) r12)     // Catch:{ IOException -> 0x005d }
            java.lang.String r13 = "Orientation"
            int r0 = r0.getAttributeInt(r13, r10)     // Catch:{ IOException -> 0x005d }
            int r13 = fe.vvv.qw.p037if.de.ad(r0)     // Catch:{ IOException -> 0x005d }
            if (r0 == r9) goto L_0x0045
            r14 = 4
            if (r0 == r14) goto L_0x0045
            r14 = 5
            if (r0 == r14) goto L_0x0045
            r14 = 7
            if (r0 != r14) goto L_0x0043
            goto L_0x0045
        L_0x0043:
            r0 = 0
            goto L_0x0046
        L_0x0045:
            r0 = 1
        L_0x0046:
            com.otaliastudios.cameraview.CameraLogger r14 = qw     // Catch:{ IOException -> 0x005d }
            java.lang.Object[] r15 = new java.lang.Object[r8]     // Catch:{ IOException -> 0x005d }
            r15[r11] = r7     // Catch:{ IOException -> 0x005d }
            java.lang.String r16 = "got orientation from EXIF."
            r15[r10] = r16     // Catch:{ IOException -> 0x005d }
            java.lang.Integer r16 = java.lang.Integer.valueOf(r13)     // Catch:{ IOException -> 0x005d }
            r15[r9] = r16     // Catch:{ IOException -> 0x005d }
            r14.de(r15)     // Catch:{ IOException -> 0x005d }
            r12.close()     // Catch:{ Exception -> 0x0079 }
            goto L_0x0079
        L_0x005d:
            r0 = move-exception
            goto L_0x0063
        L_0x005f:
            r0 = move-exception
            goto L_0x007d
        L_0x0061:
            r0 = move-exception
            r12 = r6
        L_0x0063:
            com.otaliastudios.cameraview.CameraLogger r13 = qw     // Catch:{ all -> 0x007b }
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ all -> 0x007b }
            r8[r11] = r7     // Catch:{ all -> 0x007b }
            java.lang.String r7 = "could not get orientation from EXIF."
            r8[r10] = r7     // Catch:{ all -> 0x007b }
            r8[r9] = r0     // Catch:{ all -> 0x007b }
            r13.ad(r8)     // Catch:{ all -> 0x007b }
            if (r12 == 0) goto L_0x0077
            r12.close()     // Catch:{ Exception -> 0x0077 }
        L_0x0077:
            r0 = 0
            r13 = 0
        L_0x0079:
            r12 = r13
            goto L_0x0097
        L_0x007b:
            r0 = move-exception
            r6 = r12
        L_0x007d:
            if (r6 == 0) goto L_0x0082
            r6.close()     // Catch:{ Exception -> 0x0082 }
        L_0x0082:
            throw r0
        L_0x0083:
            com.otaliastudios.cameraview.CameraLogger r0 = qw
            java.lang.Object[] r8 = new java.lang.Object[r8]
            r8[r11] = r7
            java.lang.String r7 = "got orientation from constructor."
            r8[r10] = r7
            java.lang.Integer r7 = java.lang.Integer.valueOf(r24)
            r8[r9] = r7
            r0.de(r8)
            r0 = 0
        L_0x0097:
            if (r4 < r3) goto L_0x00a2
            if (r5 >= r3) goto L_0x009c
            goto L_0x00a2
        L_0x009c:
            int r2 = r1.length     // Catch:{ OutOfMemoryError -> 0x00e8 }
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeByteArray(r1, r11, r2)     // Catch:{ OutOfMemoryError -> 0x00e8 }
            goto L_0x00c1
        L_0x00a2:
            r2.inJustDecodeBounds = r10     // Catch:{ OutOfMemoryError -> 0x00e8 }
            int r3 = r1.length     // Catch:{ OutOfMemoryError -> 0x00e8 }
            android.graphics.BitmapFactory.decodeByteArray(r1, r11, r3, r2)     // Catch:{ OutOfMemoryError -> 0x00e8 }
            int r3 = r2.outHeight     // Catch:{ OutOfMemoryError -> 0x00e8 }
            int r7 = r2.outWidth     // Catch:{ OutOfMemoryError -> 0x00e8 }
            int r8 = r12 % 180
            if (r8 == 0) goto L_0x00b4
            int r3 = r2.outWidth     // Catch:{ OutOfMemoryError -> 0x00e8 }
            int r7 = r2.outHeight     // Catch:{ OutOfMemoryError -> 0x00e8 }
        L_0x00b4:
            int r3 = ad(r7, r3, r4, r5)     // Catch:{ OutOfMemoryError -> 0x00e8 }
            r2.inSampleSize = r3     // Catch:{ OutOfMemoryError -> 0x00e8 }
            r2.inJustDecodeBounds = r11     // Catch:{ OutOfMemoryError -> 0x00e8 }
            int r3 = r1.length     // Catch:{ OutOfMemoryError -> 0x00e8 }
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeByteArray(r1, r11, r3, r2)     // Catch:{ OutOfMemoryError -> 0x00e8 }
        L_0x00c1:
            if (r12 != 0) goto L_0x00c8
            if (r0 == 0) goto L_0x00c6
            goto L_0x00c8
        L_0x00c6:
            r6 = r1
            goto L_0x00e8
        L_0x00c8:
            android.graphics.Matrix r0 = new android.graphics.Matrix     // Catch:{ OutOfMemoryError -> 0x00e8 }
            r0.<init>()     // Catch:{ OutOfMemoryError -> 0x00e8 }
            float r2 = (float) r12     // Catch:{ OutOfMemoryError -> 0x00e8 }
            r0.setRotate(r2)     // Catch:{ OutOfMemoryError -> 0x00e8 }
            r14 = 0
            r15 = 0
            int r16 = r1.getWidth()     // Catch:{ OutOfMemoryError -> 0x00e8 }
            int r17 = r1.getHeight()     // Catch:{ OutOfMemoryError -> 0x00e8 }
            r19 = 1
            r13 = r1
            r18 = r0
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r13, r14, r15, r16, r17, r18, r19)     // Catch:{ OutOfMemoryError -> 0x00e8 }
            r1.recycle()     // Catch:{ OutOfMemoryError -> 0x00e8 }
            r6 = r0
        L_0x00e8:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.vvv.qw.de.de(byte[], int, int, android.graphics.BitmapFactory$Options, int):android.graphics.Bitmap");
    }

    public static void fe(@NonNull byte[] bArr, int i2, int i3, @NonNull BitmapFactory.Options options, int i4, @NonNull BitmapCallback bitmapCallback) {
        yj.ad(new ad(bArr, i2, i3, options, i4, new Handler(), bitmapCallback));
    }

    public static boolean rg(@NonNull Context context, @NonNull Facing facing) {
        int ad2 = fe.vvv.qw.yj.th.qw.qw().ad(facing);
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i2 = 0; i2 < numberOfCameras; i2++) {
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == ad2) {
                return true;
            }
        }
        return false;
    }

    @WorkerThread
    @SuppressLint({"NewApi"})
    @Nullable
    public static File th(@NonNull byte[] bArr, @NonNull File file) {
        BufferedOutputStream bufferedOutputStream;
        if (file.exists() && !file.delete()) {
            return null;
        }
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            bufferedOutputStream.write(bArr);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            return file;
        } catch (IOException unused) {
            return null;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    public static void yj(@NonNull byte[] bArr, @NonNull File file, @NonNull FileCallback fileCallback) {
        yj.ad(new qw(bArr, file, new Handler(), fileCallback));
    }
}
