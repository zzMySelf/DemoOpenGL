package fe.mmm.qw.tt.ad.ddd;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.apollon.heartbeat.a;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;

public class th {
    public Map<DecodeHintType, Object> qw = new EnumMap(DecodeHintType.class);

    public th() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(BarcodeFormat.QR_CODE);
        arrayList.add(BarcodeFormat.CODABAR);
        arrayList.add(BarcodeFormat.CODE_128);
        arrayList.add(BarcodeFormat.CODE_93);
        arrayList.add(BarcodeFormat.CODE_39);
        arrayList.add(BarcodeFormat.AZTEC);
        arrayList.add(BarcodeFormat.UPC_EAN_EXTENSION);
        this.qw.put(DecodeHintType.TRY_HARDER, BarcodeFormat.QR_CODE);
        this.qw.put(DecodeHintType.POSSIBLE_FORMATS, arrayList);
        this.qw.put(DecodeHintType.CHARACTER_SET, a.h);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0048 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0049 A[SYNTHETIC, Splitter:B:14:0x0049] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.zxing.Result ad(java.lang.String r12) {
        /*
            r11 = this;
            android.graphics.Bitmap r0 = r11.qw(r12)
            r12 = 0
            if (r0 != 0) goto L_0x0008
            return r12
        L_0x0008:
            int r8 = r0.getWidth()     // Catch:{ Exception -> 0x003b }
            int r9 = r0.getHeight()     // Catch:{ Exception -> 0x003b }
            int r1 = r8 * r9
            int[] r10 = new int[r1]     // Catch:{ Exception -> 0x003b }
            r2 = 0
            r4 = 0
            r5 = 0
            r1 = r10
            r3 = r8
            r6 = r8
            r7 = r9
            r0.getPixels(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x003b }
            com.google.zxing.RGBLuminanceSource r0 = new com.google.zxing.RGBLuminanceSource     // Catch:{ Exception -> 0x003b }
            r0.<init>(r8, r9, r10)     // Catch:{ Exception -> 0x003b }
            com.google.zxing.MultiFormatReader r1 = new com.google.zxing.MultiFormatReader     // Catch:{ Exception -> 0x0039 }
            r1.<init>()     // Catch:{ Exception -> 0x0039 }
            com.google.zxing.BinaryBitmap r2 = new com.google.zxing.BinaryBitmap     // Catch:{ Exception -> 0x0039 }
            com.google.zxing.common.HybridBinarizer r3 = new com.google.zxing.common.HybridBinarizer     // Catch:{ Exception -> 0x0039 }
            r3.<init>(r0)     // Catch:{ Exception -> 0x0039 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0039 }
            java.util.Map<com.google.zxing.DecodeHintType, java.lang.Object> r3 = r11.qw     // Catch:{ Exception -> 0x0039 }
            com.google.zxing.Result r12 = r1.decode(r2, r3)     // Catch:{ Exception -> 0x0039 }
            return r12
        L_0x0039:
            r1 = move-exception
            goto L_0x003d
        L_0x003b:
            r1 = move-exception
            r0 = r12
        L_0x003d:
            java.lang.String r1 = r1.getLocalizedMessage()
            java.lang.String r2 = "QRCodeParseUtils"
            fe.mmm.qw.i.qw.ad(r2, r1)
            if (r0 != 0) goto L_0x0049
            return r12
        L_0x0049:
            com.google.zxing.MultiFormatReader r1 = new com.google.zxing.MultiFormatReader     // Catch:{ all -> 0x005f }
            r1.<init>()     // Catch:{ all -> 0x005f }
            com.google.zxing.BinaryBitmap r3 = new com.google.zxing.BinaryBitmap     // Catch:{ all -> 0x005f }
            com.google.zxing.common.GlobalHistogramBinarizer r4 = new com.google.zxing.common.GlobalHistogramBinarizer     // Catch:{ all -> 0x005f }
            r4.<init>(r0)     // Catch:{ all -> 0x005f }
            r3.<init>(r4)     // Catch:{ all -> 0x005f }
            java.util.Map<com.google.zxing.DecodeHintType, java.lang.Object> r0 = r11.qw     // Catch:{ all -> 0x005f }
            com.google.zxing.Result r12 = r1.decode(r3, r0)     // Catch:{ all -> 0x005f }
            return r12
        L_0x005f:
            r0 = move-exception
            java.lang.String r0 = r0.getLocalizedMessage()
            fe.mmm.qw.i.qw.ad(r2, r0)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.tt.ad.ddd.th.ad(java.lang.String):com.google.zxing.Result");
    }

    public final Bitmap qw(String str) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int i2 = 1;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i3 = options.outHeight / 1080;
            if (i3 > 0) {
                i2 = i3;
            }
            options.inSampleSize = i2;
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(str, options);
        } catch (Exception unused) {
            return null;
        }
    }
}
