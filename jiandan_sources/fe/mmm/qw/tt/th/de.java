package fe.mmm.qw.tt.th;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.aiscan.R;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.tera.scan.scanner.zxing.CaptureActivity;
import java.io.ByteArrayOutputStream;
import java.util.Map;

public final class de extends Handler {

    /* renamed from: fe  reason: collision with root package name */
    public static final String f8514fe = de.class.getSimpleName();

    /* renamed from: ad  reason: collision with root package name */
    public final MultiFormatReader f8515ad;

    /* renamed from: de  reason: collision with root package name */
    public boolean f8516de = true;
    public final CaptureActivity qw;

    public de(CaptureActivity captureActivity, Map<DecodeHintType, Object> map) {
        MultiFormatReader multiFormatReader = new MultiFormatReader();
        this.f8515ad = multiFormatReader;
        multiFormatReader.setHints(map);
        this.qw = captureActivity;
    }

    public static void qw(PlanarYUVLuminanceSource planarYUVLuminanceSource, Bundle bundle) {
        int[] renderThumbnail = planarYUVLuminanceSource.renderThumbnail();
        int thumbnailWidth = planarYUVLuminanceSource.getThumbnailWidth();
        Bitmap createBitmap = Bitmap.createBitmap(renderThumbnail, 0, thumbnailWidth, thumbnailWidth, planarYUVLuminanceSource.getThumbnailHeight(), Bitmap.Config.ARGB_8888);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        bundle.putByteArray("barcode_bitmap", byteArrayOutputStream.toByteArray());
        bundle.putFloat("barcode_scaled_factor", ((float) thumbnailWidth) / ((float) planarYUVLuminanceSource.getWidth()));
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ad(byte[] r7, int r8, int r9) {
        /*
            r6 = this;
            long r0 = java.lang.System.nanoTime()
            com.tera.scan.scanner.zxing.CaptureActivity r2 = r6.qw
            fe.mmm.qw.tt.th.uk.fe r2 = r2.getCameraManager()
            com.google.zxing.PlanarYUVLuminanceSource r7 = r2.qw(r7, r8, r9)
            if (r7 == 0) goto L_0x0032
            com.google.zxing.BinaryBitmap r8 = new com.google.zxing.BinaryBitmap
            com.google.zxing.common.HybridBinarizer r9 = new com.google.zxing.common.HybridBinarizer
            r9.<init>(r7)
            r8.<init>(r9)
            com.google.zxing.MultiFormatReader r9 = r6.f8515ad     // Catch:{ ReaderException -> 0x002d, all -> 0x0026 }
            com.google.zxing.Result r8 = r9.decodeWithState(r8)     // Catch:{ ReaderException -> 0x002d, all -> 0x0026 }
            com.google.zxing.MultiFormatReader r9 = r6.f8515ad
            r9.reset()
            goto L_0x0033
        L_0x0026:
            r7 = move-exception
            com.google.zxing.MultiFormatReader r8 = r6.f8515ad
            r8.reset()
            throw r7
        L_0x002d:
            com.google.zxing.MultiFormatReader r8 = r6.f8515ad
            r8.reset()
        L_0x0032:
            r8 = 0
        L_0x0033:
            com.tera.scan.scanner.zxing.CaptureActivity r9 = r6.qw
            android.os.Handler r9 = r9.getHandler()
            if (r8 == 0) goto L_0x0073
            long r2 = java.lang.System.nanoTime()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Found barcode in "
            r4.append(r5)
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r2 = r2 - r0
            long r0 = r5.toMillis(r2)
            r4.append(r0)
            java.lang.String r0 = " ms"
            r4.append(r0)
            r4.toString()
            if (r9 == 0) goto L_0x007f
            r0 = 2131362229(0x7f0a01b5, float:1.8344233E38)
            android.os.Message r8 = android.os.Message.obtain(r9, r0, r8)
            android.os.Bundle r9 = new android.os.Bundle
            r9.<init>()
            qw(r7, r9)
            r8.setData(r9)
            r8.sendToTarget()
            goto L_0x007f
        L_0x0073:
            if (r9 == 0) goto L_0x007f
            r7 = 2131362228(0x7f0a01b4, float:1.834423E38)
            android.os.Message r7 = android.os.Message.obtain(r9, r7)
            r7.sendToTarget()
        L_0x007f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.tt.th.de.ad(byte[], int, int):void");
    }

    public void handleMessage(Message message) {
        if (message != null && this.f8516de) {
            int i2 = message.what;
            if (i2 == R.id.decode) {
                ad((byte[]) message.obj, message.arg1, message.arg2);
            } else if (i2 == R.id.quit) {
                this.f8516de = false;
                Looper.myLooper().quit();
            }
        }
    }
}
