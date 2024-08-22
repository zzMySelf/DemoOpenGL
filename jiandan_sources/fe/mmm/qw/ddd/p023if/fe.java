package fe.mmm.qw.ddd.p023if;

import androidx.exifinterface.media.ExifInterface;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;

/* renamed from: fe.mmm.qw.ddd.if.fe  reason: invalid package */
public class fe {

    /* renamed from: de  reason: collision with root package name */
    public static final byte[] f7713de = {-1, ExifInterface.MARKER_SOI};

    /* renamed from: ad  reason: collision with root package name */
    public byte[] f7714ad = new byte[2];
    public int[][] qw = ((int[][]) Array.newInstance(int.class, new int[]{2, 64}));

    public final void ad(FileInputStream fileInputStream) {
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00b2, code lost:
        ad(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
        return;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void de(java.io.File r11) {
        /*
            r10 = this;
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00c2 }
            r1.<init>(r11)     // Catch:{ Exception -> 0x00c2 }
            r11 = 6
            byte[] r0 = new byte[r11]     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
            r2 = 0
            int r3 = r1.read(r0, r2, r11)     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
            if (r3 >= r11) goto L_0x0014
            r10.ad(r1)
            return
        L_0x0014:
            byte r11 = r0[r2]     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
            byte[] r4 = f7713de     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
            byte r4 = r4[r2]     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
            if (r11 != r4) goto L_0x00b6
            r11 = 1
            byte r4 = r0[r11]     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
            byte[] r5 = f7713de     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
            byte r5 = r5[r11]     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
            if (r4 == r5) goto L_0x0027
            goto L_0x00b6
        L_0x0027:
            r4 = 2
        L_0x0028:
            if (r3 <= r4) goto L_0x00b2
            int r3 = r4 + 2
            byte r3 = r0[r3]     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
            int r3 = r10.qw(r3)     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
            int r3 = r3 * 256
            int r5 = r4 + 3
            byte r5 = r0[r5]     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
            int r5 = r10.qw(r5)     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
            int r3 = r3 + r5
            byte r5 = r0[r4]     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
            r6 = -1
            if (r5 == r6) goto L_0x0044
            goto L_0x00b2
        L_0x0044:
            int r4 = r4 + 1
            byte r4 = r0[r4]     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
            r5 = -37
            if (r4 != r5) goto L_0x00a4
            int r3 = r3 + -2
            byte[] r0 = new byte[r3]     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
            int r4 = r1.read(r0, r2, r3)     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
            if (r4 >= r3) goto L_0x0057
            goto L_0x00b2
        L_0x0057:
            r3 = 0
        L_0x0058:
            if (r3 >= r4) goto L_0x00a0
            byte r5 = r0[r3]     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
            int r6 = r5 >> 4
            byte r6 = (byte) r6
            r5 = r5 & 15
            byte r5 = (byte) r5
            if (r6 == 0) goto L_0x0068
            r10.ad(r1)
            return
        L_0x0068:
            if (r5 < 0) goto L_0x009c
            if (r5 <= r11) goto L_0x006d
            goto L_0x009c
        L_0x006d:
            byte[] r6 = r10.f7714ad     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
            byte r6 = r6[r5]     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
            if (r6 == 0) goto L_0x007f
            byte[] r0 = r10.f7714ad     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
            r0[r2] = r2     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
            byte[] r0 = r10.f7714ad     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
            r0[r11] = r2     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
            r10.ad(r1)
            return
        L_0x007f:
            byte[] r6 = r10.f7714ad     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
            r6[r5] = r11     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
            r6 = 0
        L_0x0084:
            int[][] r7 = r10.qw     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
            r7 = r7[r5]     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
            int r7 = r7.length     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
            if (r6 >= r7) goto L_0x0099
            int[][] r7 = r10.qw     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
            r7 = r7[r5]     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
            int r8 = r3 + 1
            int r8 = r8 + r6
            byte r8 = r0[r8]     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
            r7[r6] = r8     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
            int r6 = r6 + 1
            goto L_0x0084
        L_0x0099:
            int r3 = r3 + 65
            goto L_0x0058
        L_0x009c:
            r10.ad(r1)
            return
        L_0x00a0:
            r9 = r4
            r4 = r3
            r3 = r9
            goto L_0x0028
        L_0x00a4:
            int r3 = r3 + -2
            long r3 = (long) r3
            r1.skip(r3)     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
            r3 = 4
            int r3 = r1.read(r0, r2, r3)     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
            r4 = 0
            goto L_0x0028
        L_0x00b2:
            r10.ad(r1)
            goto L_0x00c9
        L_0x00b6:
            r10.ad(r1)
            return
        L_0x00ba:
            r11 = move-exception
            r0 = r1
            goto L_0x00ca
        L_0x00bd:
            r11 = move-exception
            r0 = r1
            goto L_0x00c3
        L_0x00c0:
            r11 = move-exception
            goto L_0x00ca
        L_0x00c2:
            r11 = move-exception
        L_0x00c3:
            r11.printStackTrace()     // Catch:{ all -> 0x00c0 }
            r10.ad(r0)
        L_0x00c9:
            return
        L_0x00ca:
            r10.ad(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.ddd.p023if.fe.de(java.io.File):void");
    }

    public int[] fe(int i2) {
        if (i2 >= 2 || i2 < 0 || this.f7714ad[i2] == 0) {
            return null;
        }
        return this.qw[i2];
    }

    public final int qw(byte b) {
        return b & 255;
    }

    public boolean rg() {
        for (int i2 = 0; i2 < 2; i2++) {
            if (this.f7714ad[i2] != 0) {
                return true;
            }
        }
        return false;
    }
}
