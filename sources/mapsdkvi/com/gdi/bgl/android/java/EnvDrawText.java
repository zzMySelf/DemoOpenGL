package mapsdkvi.com.gdi.bgl.android.java;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.TextPaint;
import android.util.SparseArray;
import com.baidu.mapapi.common.SysOSUtil;

public class EnvDrawText {
    public static boolean bBmpChange = false;
    public static Bitmap bmp;
    public static int[] buffer;
    public static SparseArray<a> fontCache;

    private static Paint.Align a(int i2) {
        return 1 == i2 ? Paint.Align.LEFT : 2 == i2 ? Paint.Align.RIGHT : Paint.Align.CENTER;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0328, code lost:
        return r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x026b  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x02cd  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x02c1 A[EDGE_INSN: B:133:0x02c1->B:111:0x02c1 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0221  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0247  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0254  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0257  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized int[] drawText(java.lang.String r26, int r27, int r28, int[] r29, int r30, int r31, int r32, int r33, int r34) {
        /*
            r0 = r26
            r1 = r29
            r2 = r30
            r3 = r31
            r4 = r32
            r5 = r33
            r6 = r34
            java.lang.Class<mapsdkvi.com.gdi.bgl.android.java.EnvDrawText> r7 = mapsdkvi.com.gdi.bgl.android.java.EnvDrawText.class
            monitor-enter(r7)
            android.graphics.Canvas r9 = new android.graphics.Canvas     // Catch:{ all -> 0x0329 }
            r9.<init>()     // Catch:{ all -> 0x0329 }
            android.text.TextPaint r10 = new android.text.TextPaint     // Catch:{ all -> 0x0329 }
            r10.<init>()     // Catch:{ all -> 0x0329 }
            java.lang.String r11 = com.baidu.mapapi.common.SysOSUtil.getPhoneType()     // Catch:{ all -> 0x0329 }
            r12 = 0
            if (r11 == 0) goto L_0x002d
            java.lang.String r13 = "vivo X3L"
            boolean r11 = r11.equals(r13)     // Catch:{ all -> 0x0329 }
            if (r11 == 0) goto L_0x002d
            r11 = r12
            goto L_0x002f
        L_0x002d:
            r11 = r28
        L_0x002f:
            r10.reset()     // Catch:{ all -> 0x0329 }
            r13 = 1
            r10.setSubpixelText(r13)     // Catch:{ all -> 0x0329 }
            r10.setAntiAlias(r13)     // Catch:{ all -> 0x0329 }
            r14 = r27
            float r14 = (float) r14     // Catch:{ all -> 0x0329 }
            r10.setTextSize(r14)     // Catch:{ all -> 0x0329 }
            r15 = 0
            r10.setShadowLayer(r15, r15, r15, r12)     // Catch:{ all -> 0x0329 }
            r8 = 2
            if (r11 == r13) goto L_0x0059
            if (r11 == r8) goto L_0x0052
            android.graphics.Typeface r15 = android.graphics.Typeface.DEFAULT     // Catch:{ all -> 0x0329 }
            android.graphics.Typeface r15 = android.graphics.Typeface.create(r15, r12)     // Catch:{ all -> 0x0329 }
        L_0x004e:
            r10.setTypeface(r15)     // Catch:{ all -> 0x0329 }
            goto L_0x0060
        L_0x0052:
            android.graphics.Typeface r15 = android.graphics.Typeface.DEFAULT     // Catch:{ all -> 0x0329 }
            android.graphics.Typeface r15 = android.graphics.Typeface.create(r15, r8)     // Catch:{ all -> 0x0329 }
            goto L_0x004e
        L_0x0059:
            android.graphics.Typeface r15 = android.graphics.Typeface.DEFAULT     // Catch:{ all -> 0x0329 }
            android.graphics.Typeface r15 = android.graphics.Typeface.create(r15, r13)     // Catch:{ all -> 0x0329 }
            goto L_0x004e
        L_0x0060:
            if (r5 == 0) goto L_0x0075
            float r15 = (float) r5     // Catch:{ all -> 0x0329 }
            r10.setStrokeWidth(r15)     // Catch:{ all -> 0x0329 }
            android.graphics.Paint$Cap r15 = android.graphics.Paint.Cap.ROUND     // Catch:{ all -> 0x0329 }
            r10.setStrokeCap(r15)     // Catch:{ all -> 0x0329 }
            android.graphics.Paint$Join r15 = android.graphics.Paint.Join.ROUND     // Catch:{ all -> 0x0329 }
            r10.setStrokeJoin(r15)     // Catch:{ all -> 0x0329 }
            android.graphics.Paint$Style r15 = android.graphics.Paint.Style.STROKE     // Catch:{ all -> 0x0329 }
            r10.setStyle(r15)     // Catch:{ all -> 0x0329 }
        L_0x0075:
            r10.setSubpixelText(r13)     // Catch:{ all -> 0x0329 }
            r10.setAntiAlias(r13)     // Catch:{ all -> 0x0329 }
            if (r11 == 0) goto L_0x008e
            android.util.SparseArray<mapsdkvi.com.gdi.bgl.android.java.a> r15 = fontCache     // Catch:{ all -> 0x0329 }
            if (r15 == 0) goto L_0x008e
            java.lang.Object r11 = r15.get(r11)     // Catch:{ all -> 0x0329 }
            mapsdkvi.com.gdi.bgl.android.java.a r11 = (mapsdkvi.com.gdi.bgl.android.java.a) r11     // Catch:{ all -> 0x0329 }
            if (r11 == 0) goto L_0x008e
            android.graphics.Typeface r11 = r11.f7792a     // Catch:{ all -> 0x0329 }
            r10.setTypeface(r11)     // Catch:{ all -> 0x0329 }
        L_0x008e:
            r10.setTextSize(r14)     // Catch:{ all -> 0x0329 }
            r11 = 92
            int r14 = r0.indexOf(r11, r12)     // Catch:{ all -> 0x0329 }
            r15 = -1
            r17 = 3
            r18 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r19 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            r11 = 4
            r21 = r9
            if (r14 != r15) goto L_0x0170
            android.graphics.Paint$FontMetrics r6 = r10.getFontMetrics()     // Catch:{ all -> 0x0329 }
            int r14 = r26.length()     // Catch:{ all -> 0x0329 }
            float r14 = android.text.Layout.getDesiredWidth(r0, r12, r14, r10)     // Catch:{ all -> 0x0329 }
            double r14 = (double) r14     // Catch:{ all -> 0x0329 }
            double r14 = r14 + r19
            int r14 = (int) r14     // Catch:{ all -> 0x0329 }
            float r15 = r6.descent     // Catch:{ all -> 0x0329 }
            float r8 = r6.ascent     // Catch:{ all -> 0x0329 }
            float r15 = r15 - r8
            double r8 = (double) r15     // Catch:{ all -> 0x0329 }
            double r8 = java.lang.Math.ceil(r8)     // Catch:{ all -> 0x0329 }
            int r8 = (int) r8     // Catch:{ all -> 0x0329 }
            r1[r12] = r14     // Catch:{ all -> 0x0329 }
            r1[r13] = r8     // Catch:{ all -> 0x0329 }
            int r9 = r1.length     // Catch:{ all -> 0x0329 }
            if (r9 != r11) goto L_0x00f8
            double r13 = (double) r14     // Catch:{ all -> 0x0329 }
            double r13 = java.lang.Math.log(r13)     // Catch:{ all -> 0x0329 }
            r19 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r22 = java.lang.Math.log(r19)     // Catch:{ all -> 0x0329 }
            double r13 = r13 / r22
            double r13 = java.lang.Math.ceil(r13)     // Catch:{ all -> 0x0329 }
            int r9 = (int) r13     // Catch:{ all -> 0x0329 }
            double r13 = (double) r9     // Catch:{ all -> 0x0329 }
            r11 = r19
            double r13 = java.lang.Math.pow(r11, r13)     // Catch:{ all -> 0x0329 }
            int r14 = (int) r13     // Catch:{ all -> 0x0329 }
            r24 = r10
            double r9 = (double) r8     // Catch:{ all -> 0x0329 }
            double r8 = java.lang.Math.log(r9)     // Catch:{ all -> 0x0329 }
            double r19 = java.lang.Math.log(r11)     // Catch:{ all -> 0x0329 }
            double r8 = r8 / r19
            double r8 = java.lang.Math.ceil(r8)     // Catch:{ all -> 0x0329 }
            int r8 = (int) r8     // Catch:{ all -> 0x0329 }
            double r8 = (double) r8     // Catch:{ all -> 0x0329 }
            double r8 = java.lang.Math.pow(r11, r8)     // Catch:{ all -> 0x0329 }
            int r8 = (int) r8     // Catch:{ all -> 0x0329 }
            goto L_0x00fa
        L_0x00f8:
            r24 = r10
        L_0x00fa:
            if (r14 != 0) goto L_0x0102
            if (r8 == 0) goto L_0x00ff
            goto L_0x0102
        L_0x00ff:
            r8 = 0
            r9 = 0
            goto L_0x0103
        L_0x0102:
            r9 = r14
        L_0x0103:
            int r10 = r1.length     // Catch:{ all -> 0x0329 }
            r11 = 4
            if (r10 != r11) goto L_0x010c
            r10 = 2
            r1[r10] = r9     // Catch:{ all -> 0x0329 }
            r1[r17] = r8     // Catch:{ all -> 0x0329 }
        L_0x010c:
            if (r9 <= 0) goto L_0x0125
            if (r8 <= 0) goto L_0x0125
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ all -> 0x0329 }
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createBitmap(r9, r8, r1)     // Catch:{ all -> 0x0329 }
            if (r1 != 0) goto L_0x011d
            r10 = 0
            int[] r0 = new int[r10]     // Catch:{ all -> 0x0329 }
            monitor-exit(r7)
            return r0
        L_0x011d:
            r10 = r21
            r10.setBitmap(r1)     // Catch:{ all -> 0x0329 }
            r16 = r1
            goto L_0x0129
        L_0x0125:
            r10 = r21
            r16 = 0
        L_0x0129:
            r1 = r4 & r18
            if (r1 != 0) goto L_0x0134
            r1 = 16777215(0xffffff, float:2.3509886E-38)
            r10.drawColor(r1)     // Catch:{ all -> 0x0329 }
            goto L_0x0137
        L_0x0134:
            r10.drawColor(r4)     // Catch:{ all -> 0x0329 }
        L_0x0137:
            if (r5 == 0) goto L_0x015a
            float r1 = (float) r5     // Catch:{ all -> 0x0329 }
            r11 = r24
            r11.setStrokeWidth(r1)     // Catch:{ all -> 0x0329 }
            android.graphics.Paint$Cap r1 = android.graphics.Paint.Cap.ROUND     // Catch:{ all -> 0x0329 }
            r11.setStrokeCap(r1)     // Catch:{ all -> 0x0329 }
            android.graphics.Paint$Join r1 = android.graphics.Paint.Join.ROUND     // Catch:{ all -> 0x0329 }
            r11.setStrokeJoin(r1)     // Catch:{ all -> 0x0329 }
            android.graphics.Paint$Style r1 = android.graphics.Paint.Style.STROKE     // Catch:{ all -> 0x0329 }
            r11.setStyle(r1)     // Catch:{ all -> 0x0329 }
            r11.setColor(r3)     // Catch:{ all -> 0x0329 }
            float r1 = r6.ascent     // Catch:{ all -> 0x0329 }
            r3 = 0
            float r15 = r3 - r1
            r10.drawText(r0, r3, r15, r11)     // Catch:{ all -> 0x0329 }
            goto L_0x015c
        L_0x015a:
            r11 = r24
        L_0x015c:
            android.graphics.Paint$Style r1 = android.graphics.Paint.Style.FILL     // Catch:{ all -> 0x0329 }
            r11.setStyle(r1)     // Catch:{ all -> 0x0329 }
            r11.setColor(r2)     // Catch:{ all -> 0x0329 }
            float r1 = r6.ascent     // Catch:{ all -> 0x0329 }
            r2 = 0
            float r15 = r2 - r1
            r10.drawText(r0, r2, r15, r11)     // Catch:{ all -> 0x0329 }
            r13 = r16
            goto L_0x0310
        L_0x0170:
            r11 = r10
            r10 = r21
            int r8 = r14 + 1
            r9 = 0
            java.lang.String r12 = r0.substring(r9, r14)     // Catch:{ all -> 0x0329 }
            float r12 = r11.measureText(r12)     // Catch:{ all -> 0x0329 }
            int r12 = (int) r12     // Catch:{ all -> 0x0329 }
            r9 = 92
            r14 = 2
        L_0x0182:
            int r15 = r0.indexOf(r9, r8)     // Catch:{ all -> 0x0329 }
            if (r15 <= 0) goto L_0x019b
            java.lang.String r8 = r0.substring(r8, r15)     // Catch:{ all -> 0x0329 }
            float r8 = r11.measureText(r8)     // Catch:{ all -> 0x0329 }
            int r8 = (int) r8     // Catch:{ all -> 0x0329 }
            if (r8 <= r12) goto L_0x0194
            r12 = r8
        L_0x0194:
            int r8 = r15 + 1
            int r14 = r14 + 1
            r9 = 92
            goto L_0x0182
        L_0x019b:
            int r9 = r26.length()     // Catch:{ all -> 0x0329 }
            if (r8 == r9) goto L_0x01b4
            int r9 = r26.length()     // Catch:{ all -> 0x0329 }
            java.lang.String r8 = r0.substring(r8, r9)     // Catch:{ all -> 0x0329 }
            float r8 = android.text.Layout.getDesiredWidth(r8, r11)     // Catch:{ all -> 0x0329 }
            double r8 = (double) r8     // Catch:{ all -> 0x0329 }
            double r8 = r8 + r19
            int r8 = (int) r8     // Catch:{ all -> 0x0329 }
            if (r8 <= r12) goto L_0x01b4
            r12 = r8
        L_0x01b4:
            android.graphics.Paint$FontMetrics r8 = r11.getFontMetrics()     // Catch:{ all -> 0x0329 }
            float r9 = r8.descent     // Catch:{ all -> 0x0329 }
            float r15 = r8.ascent     // Catch:{ all -> 0x0329 }
            float r9 = r9 - r15
            r15 = r14
            double r13 = (double) r9     // Catch:{ all -> 0x0329 }
            double r13 = java.lang.Math.ceil(r13)     // Catch:{ all -> 0x0329 }
            int r13 = (int) r13     // Catch:{ all -> 0x0329 }
            int r14 = r13 * r15
            r9 = 0
            r1[r9] = r12     // Catch:{ all -> 0x0329 }
            r15 = 1
            r1[r15] = r14     // Catch:{ all -> 0x0329 }
            int r15 = r1.length     // Catch:{ all -> 0x0329 }
            r9 = 4
            if (r15 != r9) goto L_0x020d
            r20 = r8
            double r8 = (double) r12     // Catch:{ all -> 0x0329 }
            double r8 = java.lang.Math.log(r8)     // Catch:{ all -> 0x0329 }
            r24 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r22 = java.lang.Math.log(r24)     // Catch:{ all -> 0x0329 }
            double r8 = r8 / r22
            double r8 = java.lang.Math.ceil(r8)     // Catch:{ all -> 0x0329 }
            int r8 = (int) r8     // Catch:{ all -> 0x0329 }
            double r8 = (double) r8     // Catch:{ all -> 0x0329 }
            r21 = r13
            r12 = r24
            double r8 = java.lang.Math.pow(r12, r8)     // Catch:{ all -> 0x0329 }
            int r8 = (int) r8     // Catch:{ all -> 0x0329 }
            double r12 = (double) r14     // Catch:{ all -> 0x0329 }
            double r12 = java.lang.Math.log(r12)     // Catch:{ all -> 0x0329 }
            r24 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r22 = java.lang.Math.log(r24)     // Catch:{ all -> 0x0329 }
            double r12 = r12 / r22
            double r12 = java.lang.Math.ceil(r12)     // Catch:{ all -> 0x0329 }
            int r9 = (int) r12     // Catch:{ all -> 0x0329 }
            double r12 = (double) r9     // Catch:{ all -> 0x0329 }
            r22 = r8
            r8 = r24
            double r8 = java.lang.Math.pow(r8, r12)     // Catch:{ all -> 0x0329 }
            int r8 = (int) r8     // Catch:{ all -> 0x0329 }
            r9 = r22
            goto L_0x0213
        L_0x020d:
            r20 = r8
            r21 = r13
            r9 = r12
            r8 = r14
        L_0x0213:
            if (r9 != 0) goto L_0x021b
            if (r8 == 0) goto L_0x0218
            goto L_0x021b
        L_0x0218:
            r8 = 0
            r12 = 0
            goto L_0x021d
        L_0x021b:
            r12 = r8
            r8 = r9
        L_0x021d:
            int r9 = r1.length     // Catch:{ all -> 0x0329 }
            r13 = 4
            if (r9 != r13) goto L_0x0226
            r9 = 2
            r1[r9] = r8     // Catch:{ all -> 0x0329 }
            r1[r17] = r12     // Catch:{ all -> 0x0329 }
        L_0x0226:
            if (r8 <= 0) goto L_0x023b
            if (r12 <= 0) goto L_0x023b
            android.graphics.Bitmap$Config r9 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ all -> 0x0329 }
            android.graphics.Bitmap r13 = android.graphics.Bitmap.createBitmap(r8, r12, r9)     // Catch:{ all -> 0x0329 }
            if (r13 != 0) goto L_0x0237
            r9 = 0
            int[] r0 = new int[r9]     // Catch:{ all -> 0x0329 }
            monitor-exit(r7)
            return r0
        L_0x0237:
            r10.setBitmap(r13)     // Catch:{ all -> 0x0329 }
            goto L_0x023c
        L_0x023b:
            r13 = 0
        L_0x023c:
            r14 = r4 & r18
            if (r14 != 0) goto L_0x0247
            r14 = 16777215(0xffffff, float:2.3509886E-38)
            r10.drawColor(r14)     // Catch:{ all -> 0x0329 }
            goto L_0x024a
        L_0x0247:
            r10.drawColor(r4)     // Catch:{ all -> 0x0329 }
        L_0x024a:
            android.graphics.Paint$Align r4 = a(r34)     // Catch:{ all -> 0x0329 }
            r11.setTextAlign(r4)     // Catch:{ all -> 0x0329 }
            r4 = 1
            if (r6 != r4) goto L_0x0257
            r1 = 0
            r6 = 0
            goto L_0x0262
        L_0x0257:
            r4 = 2
            if (r6 != r4) goto L_0x025e
            r6 = 0
            r1 = r1[r6]     // Catch:{ all -> 0x0329 }
            goto L_0x0262
        L_0x025e:
            r6 = 0
            r1 = r1[r6]     // Catch:{ all -> 0x0329 }
            int r1 = r1 / r4
        L_0x0262:
            r4 = r6
            r9 = 92
        L_0x0265:
            int r14 = r0.indexOf(r9, r6)     // Catch:{ all -> 0x0329 }
            if (r14 <= 0) goto L_0x02c1
            java.lang.String r6 = r0.substring(r6, r14)     // Catch:{ all -> 0x0329 }
            r11.measureText(r6)     // Catch:{ all -> 0x0329 }
            int r14 = r14 + 1
            if (r5 == 0) goto L_0x029d
            float r15 = (float) r5     // Catch:{ all -> 0x0329 }
            r11.setStrokeWidth(r15)     // Catch:{ all -> 0x0329 }
            android.graphics.Paint$Cap r15 = android.graphics.Paint.Cap.ROUND     // Catch:{ all -> 0x0329 }
            r11.setStrokeCap(r15)     // Catch:{ all -> 0x0329 }
            android.graphics.Paint$Join r15 = android.graphics.Paint.Join.ROUND     // Catch:{ all -> 0x0329 }
            r11.setStrokeJoin(r15)     // Catch:{ all -> 0x0329 }
            android.graphics.Paint$Style r15 = android.graphics.Paint.Style.STROKE     // Catch:{ all -> 0x0329 }
            r11.setStyle(r15)     // Catch:{ all -> 0x0329 }
            r11.setColor(r3)     // Catch:{ all -> 0x0329 }
            float r15 = (float) r1     // Catch:{ all -> 0x0329 }
            int r9 = r4 * r21
            float r9 = (float) r9     // Catch:{ all -> 0x0329 }
            r27 = r8
            r16 = r12
            r8 = r20
            float r12 = r8.ascent     // Catch:{ all -> 0x0329 }
            float r9 = r9 - r12
            r10.drawText(r6, r15, r9, r11)     // Catch:{ all -> 0x0329 }
            goto L_0x02a3
        L_0x029d:
            r27 = r8
            r16 = r12
            r8 = r20
        L_0x02a3:
            android.graphics.Paint$Style r9 = android.graphics.Paint.Style.FILL     // Catch:{ all -> 0x0329 }
            r11.setStyle(r9)     // Catch:{ all -> 0x0329 }
            r11.setColor(r2)     // Catch:{ all -> 0x0329 }
            float r9 = (float) r1     // Catch:{ all -> 0x0329 }
            int r12 = r4 * r21
            float r12 = (float) r12     // Catch:{ all -> 0x0329 }
            float r15 = r8.ascent     // Catch:{ all -> 0x0329 }
            float r12 = r12 - r15
            r10.drawText(r6, r9, r12, r11)     // Catch:{ all -> 0x0329 }
            int r4 = r4 + 1
            r20 = r8
            r6 = r14
            r12 = r16
            r9 = 92
            r8 = r27
            goto L_0x0265
        L_0x02c1:
            r27 = r8
            r16 = r12
            r8 = r20
            int r9 = r26.length()     // Catch:{ all -> 0x0329 }
            if (r6 == r9) goto L_0x030c
            int r9 = r26.length()     // Catch:{ all -> 0x0329 }
            java.lang.String r0 = r0.substring(r6, r9)     // Catch:{ all -> 0x0329 }
            android.text.Layout.getDesiredWidth(r0, r11)     // Catch:{ all -> 0x0329 }
            if (r5 == 0) goto L_0x02fa
            float r5 = (float) r5     // Catch:{ all -> 0x0329 }
            r11.setStrokeWidth(r5)     // Catch:{ all -> 0x0329 }
            android.graphics.Paint$Cap r5 = android.graphics.Paint.Cap.ROUND     // Catch:{ all -> 0x0329 }
            r11.setStrokeCap(r5)     // Catch:{ all -> 0x0329 }
            android.graphics.Paint$Join r5 = android.graphics.Paint.Join.ROUND     // Catch:{ all -> 0x0329 }
            r11.setStrokeJoin(r5)     // Catch:{ all -> 0x0329 }
            android.graphics.Paint$Style r5 = android.graphics.Paint.Style.STROKE     // Catch:{ all -> 0x0329 }
            r11.setStyle(r5)     // Catch:{ all -> 0x0329 }
            r11.setColor(r3)     // Catch:{ all -> 0x0329 }
            float r3 = (float) r1     // Catch:{ all -> 0x0329 }
            int r5 = r4 * r21
            float r5 = (float) r5     // Catch:{ all -> 0x0329 }
            float r6 = r8.ascent     // Catch:{ all -> 0x0329 }
            float r5 = r5 - r6
            r10.drawText(r0, r3, r5, r11)     // Catch:{ all -> 0x0329 }
        L_0x02fa:
            android.graphics.Paint$Style r3 = android.graphics.Paint.Style.FILL     // Catch:{ all -> 0x0329 }
            r11.setStyle(r3)     // Catch:{ all -> 0x0329 }
            r11.setColor(r2)     // Catch:{ all -> 0x0329 }
            float r1 = (float) r1     // Catch:{ all -> 0x0329 }
            int r4 = r4 * r21
            float r2 = (float) r4     // Catch:{ all -> 0x0329 }
            float r3 = r8.ascent     // Catch:{ all -> 0x0329 }
            float r2 = r2 - r3
            r10.drawText(r0, r1, r2, r11)     // Catch:{ all -> 0x0329 }
        L_0x030c:
            r9 = r27
            r8 = r16
        L_0x0310:
            int r9 = r9 * r8
            int[] r0 = new int[r9]     // Catch:{ all -> 0x0329 }
            if (r13 == 0) goto L_0x031c
            java.nio.IntBuffer r1 = java.nio.IntBuffer.wrap(r0)     // Catch:{ all -> 0x0329 }
            r13.copyPixelsToBuffer(r1)     // Catch:{ all -> 0x0329 }
        L_0x031c:
            if (r13 == 0) goto L_0x0327
            boolean r1 = r13.isRecycled()     // Catch:{ all -> 0x0329 }
            if (r1 != 0) goto L_0x0327
            r13.recycle()     // Catch:{ all -> 0x0329 }
        L_0x0327:
            monitor-exit(r7)
            return r0
        L_0x0329:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: mapsdkvi.com.gdi.bgl.android.java.EnvDrawText.drawText(java.lang.String, int, int, int[], int, int, int, int, int):int[]");
    }

    public static Bitmap drawTextAlpha(String str, int i2, int i3, int i4) {
        int desiredWidth;
        String str2 = str;
        int i5 = i4;
        Canvas canvas = new Canvas();
        TextPaint textPaint = new TextPaint();
        String phoneType = SysOSUtil.getPhoneType();
        int i6 = 0;
        int i7 = (phoneType == null || !phoneType.equals("vivo X3L")) ? i3 : 0;
        textPaint.reset();
        textPaint.setSubpixelText(false);
        textPaint.setAntiAlias(false);
        textPaint.setTextSize((float) i2);
        int i8 = 2;
        textPaint.setTypeface(i7 != 1 ? i7 != 2 ? Typeface.create(Typeface.DEFAULT, 0) : Typeface.create(Typeface.DEFAULT, 2) : Typeface.create(Typeface.DEFAULT, 1));
        float f2 = (((float) i5) * 1.3f) + 0.5f;
        int i9 = 92;
        int indexOf = str2.indexOf(92, 0);
        Bitmap bitmap = null;
        if (indexOf == -1) {
            Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
            int desiredWidth2 = (int) (Layout.getDesiredWidth(str2, 0, str.length(), textPaint) + f2);
            int ceil = (int) Math.ceil((double) (fontMetrics.descent - fontMetrics.ascent));
            if (desiredWidth2 > 0 && ceil > 0) {
                bitmap = Bitmap.createBitmap(desiredWidth2, ceil, Bitmap.Config.ALPHA_8);
                if (bitmap == null) {
                    return bitmap;
                }
                bitmap.eraseColor(0);
                canvas.setBitmap(bitmap);
            }
            textPaint.setStyle(Paint.Style.FILL);
            canvas.drawText(str2, f2 * 0.5f, 0.0f - fontMetrics.ascent, textPaint);
        } else {
            int i10 = indexOf + 1;
            int desiredWidth3 = (int) (((double) Layout.getDesiredWidth(str2.substring(0, indexOf), textPaint)) + 0.5d);
            while (true) {
                int indexOf2 = str2.indexOf(i9, i10);
                if (indexOf2 <= 0) {
                    break;
                }
                int desiredWidth4 = (int) (((double) Layout.getDesiredWidth(str2.substring(i10, indexOf2), textPaint)) + 0.5d);
                if (desiredWidth4 > desiredWidth3) {
                    desiredWidth3 = desiredWidth4;
                }
                i10 = indexOf2 + 1;
                i8++;
                i9 = 92;
            }
            if (i10 != str.length() && (desiredWidth = (int) (((double) Layout.getDesiredWidth(str2.substring(i10, str.length()), textPaint)) + 0.5d)) > desiredWidth3) {
                desiredWidth3 = desiredWidth;
            }
            Paint.FontMetrics fontMetrics2 = textPaint.getFontMetrics();
            int ceil2 = (int) Math.ceil((double) (fontMetrics2.descent - fontMetrics2.ascent));
            int i11 = desiredWidth3 + i5;
            int i12 = i8 * ceil2;
            if (i11 > 0 && i12 > 0) {
                bitmap = Bitmap.createBitmap(i11, i12, Bitmap.Config.ALPHA_8);
                if (bitmap == null) {
                    return bitmap;
                }
                bitmap.eraseColor(0);
                canvas.setBitmap(bitmap);
            }
            textPaint.setTextAlign(a(3));
            float f3 = ((float) i11) - (f2 * 0.5f);
            int i13 = 0;
            while (true) {
                int indexOf3 = str2.indexOf(92, i6);
                if (indexOf3 <= 0) {
                    break;
                }
                String substring = str2.substring(i6, indexOf3);
                Layout.getDesiredWidth(substring, textPaint);
                textPaint.setStyle(Paint.Style.FILL);
                canvas.drawText(substring, f3, ((float) (i13 * ceil2)) - fontMetrics2.ascent, textPaint);
                i13++;
                i6 = indexOf3 + 1;
            }
            if (i6 != str.length()) {
                String substring2 = str2.substring(i6, str.length());
                Layout.getDesiredWidth(substring2, textPaint);
                textPaint.setStyle(Paint.Style.FILL);
                canvas.drawText(substring2, f3, ((float) (i13 * ceil2)) - fontMetrics2.ascent, textPaint);
            }
        }
        return bitmap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:106:0x02c3, code lost:
        return r8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x010b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized android.graphics.Bitmap drawTextExt(java.lang.String r25, int r26, int r27, int[] r28, int r29, int r30, int r31, int r32, int r33) {
        /*
            r0 = r25
            r1 = r28
            r2 = r29
            r3 = r30
            r4 = r31
            r5 = r32
            r6 = r33
            java.lang.Class<mapsdkvi.com.gdi.bgl.android.java.EnvDrawText> r7 = mapsdkvi.com.gdi.bgl.android.java.EnvDrawText.class
            monitor-enter(r7)
            android.graphics.Canvas r9 = new android.graphics.Canvas     // Catch:{ all -> 0x02c4 }
            r9.<init>()     // Catch:{ all -> 0x02c4 }
            android.text.TextPaint r10 = new android.text.TextPaint     // Catch:{ all -> 0x02c4 }
            r10.<init>()     // Catch:{ all -> 0x02c4 }
            java.lang.String r11 = com.baidu.mapapi.common.SysOSUtil.getPhoneType()     // Catch:{ all -> 0x02c4 }
            r12 = 0
            if (r11 == 0) goto L_0x002d
            java.lang.String r13 = "vivo X3L"
            boolean r11 = r11.equals(r13)     // Catch:{ all -> 0x02c4 }
            if (r11 == 0) goto L_0x002d
            r11 = r12
            goto L_0x002f
        L_0x002d:
            r11 = r27
        L_0x002f:
            r10.reset()     // Catch:{ all -> 0x02c4 }
            r13 = 1
            r10.setSubpixelText(r13)     // Catch:{ all -> 0x02c4 }
            r10.setAntiAlias(r13)     // Catch:{ all -> 0x02c4 }
            r14 = r26
            float r14 = (float) r14     // Catch:{ all -> 0x02c4 }
            r10.setTextSize(r14)     // Catch:{ all -> 0x02c4 }
            r14 = 0
            r10.setShadowLayer(r14, r14, r14, r12)     // Catch:{ all -> 0x02c4 }
            r15 = 2
            if (r11 == r13) goto L_0x0059
            if (r11 == r15) goto L_0x0052
            android.graphics.Typeface r11 = android.graphics.Typeface.DEFAULT     // Catch:{ all -> 0x02c4 }
            android.graphics.Typeface r11 = android.graphics.Typeface.create(r11, r12)     // Catch:{ all -> 0x02c4 }
        L_0x004e:
            r10.setTypeface(r11)     // Catch:{ all -> 0x02c4 }
            goto L_0x0060
        L_0x0052:
            android.graphics.Typeface r11 = android.graphics.Typeface.DEFAULT     // Catch:{ all -> 0x02c4 }
            android.graphics.Typeface r11 = android.graphics.Typeface.create(r11, r15)     // Catch:{ all -> 0x02c4 }
            goto L_0x004e
        L_0x0059:
            android.graphics.Typeface r11 = android.graphics.Typeface.DEFAULT     // Catch:{ all -> 0x02c4 }
            android.graphics.Typeface r11 = android.graphics.Typeface.create(r11, r13)     // Catch:{ all -> 0x02c4 }
            goto L_0x004e
        L_0x0060:
            if (r5 == 0) goto L_0x0075
            float r11 = (float) r5     // Catch:{ all -> 0x02c4 }
            r10.setStrokeWidth(r11)     // Catch:{ all -> 0x02c4 }
            android.graphics.Paint$Cap r11 = android.graphics.Paint.Cap.ROUND     // Catch:{ all -> 0x02c4 }
            r10.setStrokeCap(r11)     // Catch:{ all -> 0x02c4 }
            android.graphics.Paint$Join r11 = android.graphics.Paint.Join.ROUND     // Catch:{ all -> 0x02c4 }
            r10.setStrokeJoin(r11)     // Catch:{ all -> 0x02c4 }
            android.graphics.Paint$Style r11 = android.graphics.Paint.Style.STROKE     // Catch:{ all -> 0x02c4 }
            r10.setStyle(r11)     // Catch:{ all -> 0x02c4 }
        L_0x0075:
            r11 = 92
            int r8 = r0.indexOf(r11, r12)     // Catch:{ all -> 0x02c4 }
            r11 = -1
            r16 = 3
            r17 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r18 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            if (r8 != r11) goto L_0x013f
            android.graphics.Paint$FontMetrics r6 = r10.getFontMetrics()     // Catch:{ all -> 0x02c4 }
            int r8 = r25.length()     // Catch:{ all -> 0x02c4 }
            float r8 = android.text.Layout.getDesiredWidth(r0, r12, r8, r10)     // Catch:{ all -> 0x02c4 }
            double r14 = (double) r8     // Catch:{ all -> 0x02c4 }
            double r14 = r14 + r18
            int r8 = (int) r14     // Catch:{ all -> 0x02c4 }
            float r11 = r6.descent     // Catch:{ all -> 0x02c4 }
            float r14 = r6.ascent     // Catch:{ all -> 0x02c4 }
            float r11 = r11 - r14
            double r14 = (double) r11     // Catch:{ all -> 0x02c4 }
            double r14 = java.lang.Math.ceil(r14)     // Catch:{ all -> 0x02c4 }
            int r11 = (int) r14     // Catch:{ all -> 0x02c4 }
            r1[r12] = r8     // Catch:{ all -> 0x02c4 }
            r1[r13] = r11     // Catch:{ all -> 0x02c4 }
            int r13 = r1.length     // Catch:{ all -> 0x02c4 }
            r14 = 4
            if (r13 != r14) goto L_0x00d7
            double r13 = (double) r8     // Catch:{ all -> 0x02c4 }
            double r13 = java.lang.Math.log(r13)     // Catch:{ all -> 0x02c4 }
            r18 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r20 = java.lang.Math.log(r18)     // Catch:{ all -> 0x02c4 }
            double r13 = r13 / r20
            double r13 = java.lang.Math.ceil(r13)     // Catch:{ all -> 0x02c4 }
            int r8 = (int) r13     // Catch:{ all -> 0x02c4 }
            double r13 = (double) r8     // Catch:{ all -> 0x02c4 }
            r2 = r18
            double r13 = java.lang.Math.pow(r2, r13)     // Catch:{ all -> 0x02c4 }
            int r8 = (int) r13     // Catch:{ all -> 0x02c4 }
            double r13 = (double) r11     // Catch:{ all -> 0x02c4 }
            double r13 = java.lang.Math.log(r13)     // Catch:{ all -> 0x02c4 }
            double r18 = java.lang.Math.log(r2)     // Catch:{ all -> 0x02c4 }
            double r13 = r13 / r18
            double r13 = java.lang.Math.ceil(r13)     // Catch:{ all -> 0x02c4 }
            int r11 = (int) r13     // Catch:{ all -> 0x02c4 }
            double r13 = (double) r11     // Catch:{ all -> 0x02c4 }
            double r2 = java.lang.Math.pow(r2, r13)     // Catch:{ all -> 0x02c4 }
            int r11 = (int) r2     // Catch:{ all -> 0x02c4 }
        L_0x00d7:
            if (r8 != 0) goto L_0x00de
            if (r11 == 0) goto L_0x00dc
            goto L_0x00de
        L_0x00dc:
            r11 = r12
            goto L_0x00df
        L_0x00de:
            r12 = r8
        L_0x00df:
            int r2 = r1.length     // Catch:{ all -> 0x02c4 }
            r3 = 4
            if (r2 != r3) goto L_0x00e8
            r2 = 2
            r1[r2] = r12     // Catch:{ all -> 0x02c4 }
            r1[r16] = r11     // Catch:{ all -> 0x02c4 }
        L_0x00e8:
            if (r12 <= 0) goto L_0x00fa
            if (r11 <= 0) goto L_0x00fa
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ all -> 0x02c4 }
            android.graphics.Bitmap r8 = android.graphics.Bitmap.createBitmap(r12, r11, r1)     // Catch:{ all -> 0x02c4 }
            if (r8 != 0) goto L_0x00f6
            monitor-exit(r7)
            return r8
        L_0x00f6:
            r9.setBitmap(r8)     // Catch:{ all -> 0x02c4 }
            goto L_0x00fb
        L_0x00fa:
            r8 = 0
        L_0x00fb:
            r1 = r4 & r17
            if (r1 != 0) goto L_0x0106
            r1 = 16777215(0xffffff, float:2.3509886E-38)
            r9.drawColor(r1)     // Catch:{ all -> 0x02c4 }
            goto L_0x0109
        L_0x0106:
            r9.drawColor(r4)     // Catch:{ all -> 0x02c4 }
        L_0x0109:
            if (r5 == 0) goto L_0x012b
            float r1 = (float) r5     // Catch:{ all -> 0x02c4 }
            r10.setStrokeWidth(r1)     // Catch:{ all -> 0x02c4 }
            android.graphics.Paint$Cap r1 = android.graphics.Paint.Cap.ROUND     // Catch:{ all -> 0x02c4 }
            r10.setStrokeCap(r1)     // Catch:{ all -> 0x02c4 }
            android.graphics.Paint$Join r1 = android.graphics.Paint.Join.ROUND     // Catch:{ all -> 0x02c4 }
            r10.setStrokeJoin(r1)     // Catch:{ all -> 0x02c4 }
            android.graphics.Paint$Style r1 = android.graphics.Paint.Style.STROKE     // Catch:{ all -> 0x02c4 }
            r10.setStyle(r1)     // Catch:{ all -> 0x02c4 }
            r2 = r30
            r10.setColor(r2)     // Catch:{ all -> 0x02c4 }
            float r1 = r6.ascent     // Catch:{ all -> 0x02c4 }
            r2 = 0
            float r14 = r2 - r1
            r9.drawText(r0, r2, r14, r10)     // Catch:{ all -> 0x02c4 }
        L_0x012b:
            android.graphics.Paint$Style r1 = android.graphics.Paint.Style.FILL     // Catch:{ all -> 0x02c4 }
            r10.setStyle(r1)     // Catch:{ all -> 0x02c4 }
            r3 = r29
            r10.setColor(r3)     // Catch:{ all -> 0x02c4 }
            float r1 = r6.ascent     // Catch:{ all -> 0x02c4 }
            r2 = 0
            float r14 = r2 - r1
            r9.drawText(r0, r2, r14, r10)     // Catch:{ all -> 0x02c4 }
            goto L_0x02c2
        L_0x013f:
            r24 = r3
            r3 = r2
            r2 = r24
            int r11 = r8 + 1
            java.lang.String r8 = r0.substring(r12, r8)     // Catch:{ all -> 0x02c4 }
            float r8 = android.text.Layout.getDesiredWidth(r8, r10)     // Catch:{ all -> 0x02c4 }
            double r14 = (double) r8     // Catch:{ all -> 0x02c4 }
            double r14 = r14 + r18
            int r8 = (int) r14     // Catch:{ all -> 0x02c4 }
            r14 = 2
        L_0x0153:
            r15 = 92
            int r13 = r0.indexOf(r15, r11)     // Catch:{ all -> 0x02c4 }
            if (r13 <= 0) goto L_0x0172
            java.lang.String r11 = r0.substring(r11, r13)     // Catch:{ all -> 0x02c4 }
            float r11 = android.text.Layout.getDesiredWidth(r11, r10)     // Catch:{ all -> 0x02c4 }
            r22 = r13
            double r12 = (double) r11     // Catch:{ all -> 0x02c4 }
            double r12 = r12 + r18
            int r11 = (int) r12     // Catch:{ all -> 0x02c4 }
            if (r11 <= r8) goto L_0x016c
            r8 = r11
        L_0x016c:
            int r11 = r22 + 1
            int r14 = r14 + 1
            r12 = 0
            goto L_0x0153
        L_0x0172:
            int r12 = r25.length()     // Catch:{ all -> 0x02c4 }
            if (r11 == r12) goto L_0x018b
            int r12 = r25.length()     // Catch:{ all -> 0x02c4 }
            java.lang.String r11 = r0.substring(r11, r12)     // Catch:{ all -> 0x02c4 }
            float r11 = android.text.Layout.getDesiredWidth(r11, r10)     // Catch:{ all -> 0x02c4 }
            double r11 = (double) r11     // Catch:{ all -> 0x02c4 }
            double r11 = r11 + r18
            int r11 = (int) r11     // Catch:{ all -> 0x02c4 }
            if (r11 <= r8) goto L_0x018b
            r8 = r11
        L_0x018b:
            android.graphics.Paint$FontMetrics r11 = r10.getFontMetrics()     // Catch:{ all -> 0x02c4 }
            float r12 = r11.descent     // Catch:{ all -> 0x02c4 }
            float r13 = r11.ascent     // Catch:{ all -> 0x02c4 }
            float r12 = r12 - r13
            double r12 = (double) r12     // Catch:{ all -> 0x02c4 }
            double r12 = java.lang.Math.ceil(r12)     // Catch:{ all -> 0x02c4 }
            int r12 = (int) r12     // Catch:{ all -> 0x02c4 }
            int r14 = r14 * r12
            r13 = 0
            r1[r13] = r8     // Catch:{ all -> 0x02c4 }
            r13 = 1
            r1[r13] = r14     // Catch:{ all -> 0x02c4 }
            int r13 = r1.length     // Catch:{ all -> 0x02c4 }
            r15 = 4
            if (r13 != r15) goto L_0x01d8
            r13 = r11
            r15 = r12
            double r11 = (double) r8     // Catch:{ all -> 0x02c4 }
            double r11 = java.lang.Math.log(r11)     // Catch:{ all -> 0x02c4 }
            r22 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r20 = java.lang.Math.log(r22)     // Catch:{ all -> 0x02c4 }
            double r11 = r11 / r20
            double r11 = java.lang.Math.ceil(r11)     // Catch:{ all -> 0x02c4 }
            int r8 = (int) r11     // Catch:{ all -> 0x02c4 }
            double r11 = (double) r8     // Catch:{ all -> 0x02c4 }
            r2 = r22
            double r11 = java.lang.Math.pow(r2, r11)     // Catch:{ all -> 0x02c4 }
            int r8 = (int) r11     // Catch:{ all -> 0x02c4 }
            double r11 = (double) r14     // Catch:{ all -> 0x02c4 }
            double r11 = java.lang.Math.log(r11)     // Catch:{ all -> 0x02c4 }
            double r20 = java.lang.Math.log(r2)     // Catch:{ all -> 0x02c4 }
            double r11 = r11 / r20
            double r11 = java.lang.Math.ceil(r11)     // Catch:{ all -> 0x02c4 }
            int r11 = (int) r11     // Catch:{ all -> 0x02c4 }
            double r11 = (double) r11     // Catch:{ all -> 0x02c4 }
            double r2 = java.lang.Math.pow(r2, r11)     // Catch:{ all -> 0x02c4 }
            int r14 = (int) r2     // Catch:{ all -> 0x02c4 }
            goto L_0x01da
        L_0x01d8:
            r13 = r11
            r15 = r12
        L_0x01da:
            if (r8 != 0) goto L_0x01e1
            if (r14 == 0) goto L_0x01df
            goto L_0x01e1
        L_0x01df:
            r8 = 0
            r14 = 0
        L_0x01e1:
            int r2 = r1.length     // Catch:{ all -> 0x02c4 }
            r3 = 4
            if (r2 != r3) goto L_0x01ea
            r2 = 2
            r1[r2] = r8     // Catch:{ all -> 0x02c4 }
            r1[r16] = r14     // Catch:{ all -> 0x02c4 }
        L_0x01ea:
            if (r8 <= 0) goto L_0x01fc
            if (r14 <= 0) goto L_0x01fc
            android.graphics.Bitmap$Config r2 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ all -> 0x02c4 }
            android.graphics.Bitmap r8 = android.graphics.Bitmap.createBitmap(r8, r14, r2)     // Catch:{ all -> 0x02c4 }
            if (r8 != 0) goto L_0x01f8
            monitor-exit(r7)
            return r8
        L_0x01f8:
            r9.setBitmap(r8)     // Catch:{ all -> 0x02c4 }
            goto L_0x01fd
        L_0x01fc:
            r8 = 0
        L_0x01fd:
            r2 = r4 & r17
            if (r2 != 0) goto L_0x0208
            r2 = 16777215(0xffffff, float:2.3509886E-38)
            r9.drawColor(r2)     // Catch:{ all -> 0x02c4 }
            goto L_0x020b
        L_0x0208:
            r9.drawColor(r4)     // Catch:{ all -> 0x02c4 }
        L_0x020b:
            android.graphics.Paint$Align r2 = a(r33)     // Catch:{ all -> 0x02c4 }
            r10.setTextAlign(r2)     // Catch:{ all -> 0x02c4 }
            r2 = 1
            if (r6 != r2) goto L_0x0218
            r1 = 0
            r3 = 0
            goto L_0x0222
        L_0x0218:
            r2 = 2
            r3 = 0
            if (r6 != r2) goto L_0x021f
            r1 = r1[r3]     // Catch:{ all -> 0x02c4 }
            goto L_0x0222
        L_0x021f:
            r1 = r1[r3]     // Catch:{ all -> 0x02c4 }
            int r1 = r1 / r2
        L_0x0222:
            r12 = r3
        L_0x0223:
            r2 = 92
            int r4 = r0.indexOf(r2, r12)     // Catch:{ all -> 0x02c4 }
            if (r4 <= 0) goto L_0x0276
            java.lang.String r6 = r0.substring(r12, r4)     // Catch:{ all -> 0x02c4 }
            android.text.Layout.getDesiredWidth(r6, r10)     // Catch:{ all -> 0x02c4 }
            int r12 = r4 + 1
            if (r5 == 0) goto L_0x0259
            float r4 = (float) r5     // Catch:{ all -> 0x02c4 }
            r10.setStrokeWidth(r4)     // Catch:{ all -> 0x02c4 }
            android.graphics.Paint$Cap r4 = android.graphics.Paint.Cap.ROUND     // Catch:{ all -> 0x02c4 }
            r10.setStrokeCap(r4)     // Catch:{ all -> 0x02c4 }
            android.graphics.Paint$Join r4 = android.graphics.Paint.Join.ROUND     // Catch:{ all -> 0x02c4 }
            r10.setStrokeJoin(r4)     // Catch:{ all -> 0x02c4 }
            android.graphics.Paint$Style r4 = android.graphics.Paint.Style.STROKE     // Catch:{ all -> 0x02c4 }
            r10.setStyle(r4)     // Catch:{ all -> 0x02c4 }
            r4 = r30
            r10.setColor(r4)     // Catch:{ all -> 0x02c4 }
            float r11 = (float) r1     // Catch:{ all -> 0x02c4 }
            int r14 = r3 * r15
            float r14 = (float) r14     // Catch:{ all -> 0x02c4 }
            float r2 = r13.ascent     // Catch:{ all -> 0x02c4 }
            float r14 = r14 - r2
            r9.drawText(r6, r11, r14, r10)     // Catch:{ all -> 0x02c4 }
            goto L_0x025b
        L_0x0259:
            r4 = r30
        L_0x025b:
            android.graphics.Paint$Style r2 = android.graphics.Paint.Style.FILL     // Catch:{ all -> 0x02c4 }
            r10.setStyle(r2)     // Catch:{ all -> 0x02c4 }
            r2 = r29
            r10.setColor(r2)     // Catch:{ all -> 0x02c4 }
            float r11 = (float) r1     // Catch:{ all -> 0x02c4 }
            int r14 = r3 * r15
            float r14 = (float) r14     // Catch:{ all -> 0x02c4 }
            r27 = r8
            float r8 = r13.ascent     // Catch:{ all -> 0x02c4 }
            float r14 = r14 - r8
            r9.drawText(r6, r11, r14, r10)     // Catch:{ all -> 0x02c4 }
            int r3 = r3 + 1
            r8 = r27
            goto L_0x0223
        L_0x0276:
            r2 = r29
            r4 = r30
            r27 = r8
            int r6 = r25.length()     // Catch:{ all -> 0x02c4 }
            if (r12 == r6) goto L_0x02c0
            int r6 = r25.length()     // Catch:{ all -> 0x02c4 }
            java.lang.String r0 = r0.substring(r12, r6)     // Catch:{ all -> 0x02c4 }
            android.text.Layout.getDesiredWidth(r0, r10)     // Catch:{ all -> 0x02c4 }
            if (r5 == 0) goto L_0x02af
            float r5 = (float) r5     // Catch:{ all -> 0x02c4 }
            r10.setStrokeWidth(r5)     // Catch:{ all -> 0x02c4 }
            android.graphics.Paint$Cap r5 = android.graphics.Paint.Cap.ROUND     // Catch:{ all -> 0x02c4 }
            r10.setStrokeCap(r5)     // Catch:{ all -> 0x02c4 }
            android.graphics.Paint$Join r5 = android.graphics.Paint.Join.ROUND     // Catch:{ all -> 0x02c4 }
            r10.setStrokeJoin(r5)     // Catch:{ all -> 0x02c4 }
            android.graphics.Paint$Style r5 = android.graphics.Paint.Style.STROKE     // Catch:{ all -> 0x02c4 }
            r10.setStyle(r5)     // Catch:{ all -> 0x02c4 }
            r10.setColor(r4)     // Catch:{ all -> 0x02c4 }
            float r4 = (float) r1     // Catch:{ all -> 0x02c4 }
            int r12 = r3 * r15
            float r5 = (float) r12     // Catch:{ all -> 0x02c4 }
            float r6 = r13.ascent     // Catch:{ all -> 0x02c4 }
            float r5 = r5 - r6
            r9.drawText(r0, r4, r5, r10)     // Catch:{ all -> 0x02c4 }
        L_0x02af:
            android.graphics.Paint$Style r4 = android.graphics.Paint.Style.FILL     // Catch:{ all -> 0x02c4 }
            r10.setStyle(r4)     // Catch:{ all -> 0x02c4 }
            r10.setColor(r2)     // Catch:{ all -> 0x02c4 }
            float r1 = (float) r1     // Catch:{ all -> 0x02c4 }
            int r3 = r3 * r15
            float r2 = (float) r3     // Catch:{ all -> 0x02c4 }
            float r3 = r13.ascent     // Catch:{ all -> 0x02c4 }
            float r2 = r2 - r3
            r9.drawText(r0, r1, r2, r10)     // Catch:{ all -> 0x02c4 }
        L_0x02c0:
            r8 = r27
        L_0x02c2:
            monitor-exit(r7)
            return r8
        L_0x02c4:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: mapsdkvi.com.gdi.bgl.android.java.EnvDrawText.drawTextExt(java.lang.String, int, int, int[], int, int, int, int, int):android.graphics.Bitmap");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0033 A[LOOP:0: B:10:0x0031->B:11:0x0033, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static short[] getTextSize(java.lang.String r8, int r9, int r10) {
        /*
            int r0 = r8.length()
            if (r0 != 0) goto L_0x0008
            r8 = 0
            return r8
        L_0x0008:
            android.text.TextPaint r1 = new android.text.TextPaint
            r1.<init>()
            r2 = 1
            r1.setSubpixelText(r2)
            r1.setAntiAlias(r2)
            float r9 = (float) r9
            r1.setTextSize(r9)
            r9 = 0
            if (r10 == r2) goto L_0x0025
            r2 = 2
            if (r10 == r2) goto L_0x0025
            android.graphics.Typeface r10 = android.graphics.Typeface.DEFAULT
            android.graphics.Typeface r10 = android.graphics.Typeface.create(r10, r9)
            goto L_0x002b
        L_0x0025:
            android.graphics.Typeface r10 = android.graphics.Typeface.DEFAULT
            android.graphics.Typeface r10 = android.graphics.Typeface.create(r10, r2)
        L_0x002b:
            r1.setTypeface(r10)
            short[] r10 = new short[r0]
            r2 = r9
        L_0x0031:
            if (r2 >= r0) goto L_0x0043
            int r3 = r2 + 1
            float r4 = android.text.Layout.getDesiredWidth(r8, r9, r3, r1)
            double r4 = (double) r4
            r6 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r4 = r4 + r6
            int r4 = (int) r4
            short r4 = (short) r4
            r10[r2] = r4
            r2 = r3
            goto L_0x0031
        L_0x0043:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: mapsdkvi.com.gdi.bgl.android.java.EnvDrawText.getTextSize(java.lang.String, int, int):short[]");
    }

    public static float[] getTextSizeExt(String str, int i2, int i3) {
        if (str.length() == 0) {
            return null;
        }
        Paint paint = new Paint();
        paint.setSubpixelText(true);
        paint.setAntiAlias(true);
        paint.setTextSize((float) i2);
        paint.setTypeface(i3 != 1 ? i3 != 2 ? Typeface.create(Typeface.DEFAULT, 0) : Typeface.create(Typeface.DEFAULT, 2) : Typeface.create(Typeface.DEFAULT, 1));
        return new float[]{paint.measureText(str), paint.descent() - paint.ascent()};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0037, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void registFontCache(int r2, android.graphics.Typeface r3) {
        /*
            java.lang.Class<mapsdkvi.com.gdi.bgl.android.java.EnvDrawText> r0 = mapsdkvi.com.gdi.bgl.android.java.EnvDrawText.class
            monitor-enter(r0)
            if (r2 == 0) goto L_0x003b
            if (r3 != 0) goto L_0x0008
            goto L_0x003b
        L_0x0008:
            android.util.SparseArray<mapsdkvi.com.gdi.bgl.android.java.a> r1 = fontCache     // Catch:{ all -> 0x0038 }
            if (r1 != 0) goto L_0x0013
            android.util.SparseArray r1 = new android.util.SparseArray     // Catch:{ all -> 0x0038 }
            r1.<init>()     // Catch:{ all -> 0x0038 }
            fontCache = r1     // Catch:{ all -> 0x0038 }
        L_0x0013:
            android.util.SparseArray<mapsdkvi.com.gdi.bgl.android.java.a> r1 = fontCache     // Catch:{ all -> 0x0038 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x0038 }
            mapsdkvi.com.gdi.bgl.android.java.a r1 = (mapsdkvi.com.gdi.bgl.android.java.a) r1     // Catch:{ all -> 0x0038 }
            if (r1 != 0) goto L_0x0030
            mapsdkvi.com.gdi.bgl.android.java.a r1 = new mapsdkvi.com.gdi.bgl.android.java.a     // Catch:{ all -> 0x0038 }
            r1.<init>()     // Catch:{ all -> 0x0038 }
            r1.f7792a = r3     // Catch:{ all -> 0x0038 }
            int r3 = r1.f7793b     // Catch:{ all -> 0x0038 }
            int r3 = r3 + 1
            r1.f7793b = r3     // Catch:{ all -> 0x0038 }
            android.util.SparseArray<mapsdkvi.com.gdi.bgl.android.java.a> r3 = fontCache     // Catch:{ all -> 0x0038 }
            r3.put(r2, r1)     // Catch:{ all -> 0x0038 }
            goto L_0x0036
        L_0x0030:
            int r2 = r1.f7793b     // Catch:{ all -> 0x0038 }
            int r2 = r2 + 1
            r1.f7793b = r2     // Catch:{ all -> 0x0038 }
        L_0x0036:
            monitor-exit(r0)
            return
        L_0x0038:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        L_0x003b:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: mapsdkvi.com.gdi.bgl.android.java.EnvDrawText.registFontCache(int, android.graphics.Typeface):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void removeFontCache(int r3) {
        /*
            java.lang.Class<mapsdkvi.com.gdi.bgl.android.java.EnvDrawText> r0 = mapsdkvi.com.gdi.bgl.android.java.EnvDrawText.class
            monitor-enter(r0)
            android.util.SparseArray<mapsdkvi.com.gdi.bgl.android.java.a> r1 = fontCache     // Catch:{ all -> 0x0020 }
            java.lang.Object r1 = r1.get(r3)     // Catch:{ all -> 0x0020 }
            mapsdkvi.com.gdi.bgl.android.java.a r1 = (mapsdkvi.com.gdi.bgl.android.java.a) r1     // Catch:{ all -> 0x0020 }
            if (r1 != 0) goto L_0x000f
            monitor-exit(r0)
            return
        L_0x000f:
            int r2 = r1.f7793b     // Catch:{ all -> 0x0020 }
            int r2 = r2 + -1
            r1.f7793b = r2     // Catch:{ all -> 0x0020 }
            int r1 = r1.f7793b     // Catch:{ all -> 0x0020 }
            if (r1 != 0) goto L_0x001e
            android.util.SparseArray<mapsdkvi.com.gdi.bgl.android.java.a> r1 = fontCache     // Catch:{ all -> 0x0020 }
            r1.remove(r3)     // Catch:{ all -> 0x0020 }
        L_0x001e:
            monitor-exit(r0)
            return
        L_0x0020:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: mapsdkvi.com.gdi.bgl.android.java.EnvDrawText.removeFontCache(int):void");
    }
}
