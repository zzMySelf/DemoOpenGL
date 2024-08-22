package fe.when.ad;

import androidx.core.location.GpsStatusWrapper;
import com.baidu.sapi2.activity.BindVerifyActivity;
import com.itextpdf.text.BadElementException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class when extends i {
    public static final int[] Y = {192, GpsStatusWrapper.QZSS_SVID_MIN, 194};
    public static final int[] Z = {195, 197, 198, 199, 200, 201, BindVerifyActivity.v, BindVerifyActivity.w, BindVerifyActivity.y, BindVerifyActivity.z, 207};
    public static final int[] a0 = {208, 209, 210, 211, 212, 213, 214, 215, 216, 1};
    public static final byte[] b0 = {74, 70, 73, 70, 0};
    public static final byte[] c0 = {56, 66, 73, 77, 3, -19};
    public byte[][] X;

    public when(URL url) throws BadElementException, IOException {
        super(url);
        O0();
    }

    public static final int M0(InputStream inputStream) throws IOException {
        return (inputStream.read() << 8) + inputStream.read();
    }

    public static final int N0(int i2) {
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int[] iArr = Y;
            if (i4 >= iArr.length) {
                int i5 = 0;
                while (true) {
                    int[] iArr2 = a0;
                    if (i5 >= iArr2.length) {
                        while (true) {
                            int[] iArr3 = Z;
                            if (i3 >= iArr3.length) {
                                return -1;
                            }
                            if (i2 == iArr3[i3]) {
                                return 1;
                            }
                            i3++;
                        }
                    } else if (i2 == iArr2[i5]) {
                        return 2;
                    } else {
                        i5++;
                    }
                }
            } else if (i2 == iArr[i4]) {
                return 0;
            } else {
                i4++;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0216, code lost:
        fe.when.ad.a.i(r3, 2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x021d, code lost:
        if (r3.read() != 8) goto L_0x0290;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x021f, code lost:
        r0 = (float) M0(r3);
        r1.n = r0;
        n(r0);
        r0 = (float) M0(r3);
        r1.m = r0;
        l(r0);
        r1.N = r3.read();
        r1.tt = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x023b, code lost:
        if (r3 == null) goto L_0x0240;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x023d, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0240, code lost:
        r1.k = rrr();
        r1.l = ggg();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x024e, code lost:
        if (r1.X == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0250, code lost:
        r0 = 0;
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0252, code lost:
        r4 = r1.X;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0255, code lost:
        if (r0 >= r4.length) goto L_0x0267;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0259, code lost:
        if (r4[r0] != null) goto L_0x025f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x025b, code lost:
        r1.X = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x025e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x025f, code lost:
        r3 = r3 + (r4[r0].length - 14);
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0267, code lost:
        r0 = new byte[r3];
        r3 = 0;
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x026b, code lost:
        r4 = r1.X;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x026e, code lost:
        if (r7 >= r4.length) goto L_0x0283;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0270, code lost:
        java.lang.System.arraycopy(r4[r7], 14, r0, r3, r4[r7].length - 14);
        r3 = r3 + (r1.X[r7].length - 14);
        r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:?, code lost:
        L0(fe.when.ad.f.mmm.de(r0, r1.N));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x02a0, code lost:
        throw new com.itextpdf.text.BadElementException(fe.when.ad.c.qw.ad("1.must.have.8.bits.per.component", r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:?, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x02ef  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void O0() throws com.itextpdf.text.BadElementException, java.io.IOException {
        /*
            r17 = this;
            r1 = r17
            r0 = 32
            r1.qqq = r0
            r0 = 1
            r1.H = r0
            byte[] r3 = r1.rrr     // Catch:{ all -> 0x02eb }
            if (r3 != 0) goto L_0x001e
            java.net.URL r3 = r1.eee     // Catch:{ all -> 0x02eb }
            java.io.InputStream r3 = r3.openStream()     // Catch:{ all -> 0x02eb }
            java.net.URL r4 = r1.eee     // Catch:{ all -> 0x001a }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x001a }
            goto L_0x0027
        L_0x001a:
            r0 = move-exception
            r2 = r3
            goto L_0x02ed
        L_0x001e:
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x02eb }
            byte[] r4 = r1.rrr     // Catch:{ all -> 0x02eb }
            r3.<init>(r4)     // Catch:{ all -> 0x02eb }
            java.lang.String r4 = "Byte array"
        L_0x0027:
            int r5 = r3.read()     // Catch:{ all -> 0x001a }
            r6 = 255(0xff, float:3.57E-43)
            r7 = 0
            if (r5 != r6) goto L_0x02da
            int r5 = r3.read()     // Catch:{ all -> 0x001a }
            r8 = 216(0xd8, float:3.03E-43)
            if (r5 != r8) goto L_0x02da
            r5 = 1
        L_0x0039:
            int r8 = r3.read()     // Catch:{ all -> 0x001a }
            if (r8 < 0) goto L_0x02cb
            if (r8 != r6) goto L_0x02c7
            int r8 = r3.read()     // Catch:{ all -> 0x001a }
            r9 = 16
            r10 = 1056964608(0x3f000000, float:0.5)
            r11 = 1076006748(0x40228f5c, float:2.54)
            r12 = 2
            if (r5 == 0) goto L_0x00c4
            r13 = 224(0xe0, float:3.14E-43)
            if (r8 != r13) goto L_0x00c4
            int r5 = M0(r3)     // Catch:{ all -> 0x001a }
            if (r5 >= r9) goto L_0x005f
            int r5 = r5 + -2
            fe.when.ad.a.i(r3, r5)     // Catch:{ all -> 0x001a }
            goto L_0x00b2
        L_0x005f:
            byte[] r8 = b0     // Catch:{ all -> 0x001a }
            int r8 = r8.length     // Catch:{ all -> 0x001a }
            byte[] r9 = new byte[r8]     // Catch:{ all -> 0x001a }
            int r13 = r3.read(r9)     // Catch:{ all -> 0x001a }
            if (r13 != r8) goto L_0x00b4
            r13 = 0
        L_0x006b:
            if (r13 >= r8) goto L_0x007a
            byte r14 = r9[r13]     // Catch:{ all -> 0x001a }
            byte[] r15 = b0     // Catch:{ all -> 0x001a }
            byte r15 = r15[r13]     // Catch:{ all -> 0x001a }
            if (r14 == r15) goto L_0x0077
            r9 = 0
            goto L_0x007b
        L_0x0077:
            int r13 = r13 + 1
            goto L_0x006b
        L_0x007a:
            r9 = 1
        L_0x007b:
            if (r9 != 0) goto L_0x0084
            int r5 = r5 + -2
            int r5 = r5 - r8
            fe.when.ad.a.i(r3, r5)     // Catch:{ all -> 0x001a }
            goto L_0x00b2
        L_0x0084:
            fe.when.ad.a.i(r3, r12)     // Catch:{ all -> 0x001a }
            int r9 = r3.read()     // Catch:{ all -> 0x001a }
            int r13 = M0(r3)     // Catch:{ all -> 0x001a }
            int r14 = M0(r3)     // Catch:{ all -> 0x001a }
            if (r9 != r0) goto L_0x009a
            r1.K = r13     // Catch:{ all -> 0x001a }
            r1.L = r14     // Catch:{ all -> 0x001a }
            goto L_0x00aa
        L_0x009a:
            if (r9 != r12) goto L_0x00aa
            float r9 = (float) r13     // Catch:{ all -> 0x001a }
            float r9 = r9 * r11
            float r9 = r9 + r10
            int r9 = (int) r9     // Catch:{ all -> 0x001a }
            r1.K = r9     // Catch:{ all -> 0x001a }
            float r9 = (float) r14     // Catch:{ all -> 0x001a }
            float r9 = r9 * r11
            float r9 = r9 + r10
            int r9 = (int) r9     // Catch:{ all -> 0x001a }
            r1.L = r9     // Catch:{ all -> 0x001a }
        L_0x00aa:
            int r5 = r5 + -2
            int r5 = r5 - r8
            int r5 = r5 + -7
            fe.when.ad.a.i(r3, r5)     // Catch:{ all -> 0x001a }
        L_0x00b2:
            r5 = 0
            goto L_0x0039
        L_0x00b4:
            com.itextpdf.text.BadElementException r2 = new com.itextpdf.text.BadElementException     // Catch:{ all -> 0x001a }
            java.lang.String r5 = "1.corrupted.jfif.marker"
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x001a }
            r0[r7] = r4     // Catch:{ all -> 0x001a }
            java.lang.String r0 = fe.when.ad.c.qw.ad(r5, r0)     // Catch:{ all -> 0x001a }
            r2.<init>((java.lang.String) r0)     // Catch:{ all -> 0x001a }
            throw r2     // Catch:{ all -> 0x001a }
        L_0x00c4:
            r13 = 238(0xee, float:3.34E-43)
            java.lang.String r14 = "ISO-8859-1"
            r15 = 12
            if (r8 != r13) goto L_0x00f4
            int r8 = M0(r3)     // Catch:{ all -> 0x001a }
            int r8 = r8 - r12
            byte[] r9 = new byte[r8]     // Catch:{ all -> 0x001a }
            r10 = 0
        L_0x00d4:
            if (r10 >= r8) goto L_0x00e0
            int r11 = r3.read()     // Catch:{ all -> 0x001a }
            byte r11 = (byte) r11     // Catch:{ all -> 0x001a }
            r9[r10] = r11     // Catch:{ all -> 0x001a }
            int r10 = r10 + 1
            goto L_0x00d4
        L_0x00e0:
            if (r8 < r15) goto L_0x02c8
            java.lang.String r8 = new java.lang.String     // Catch:{ all -> 0x001a }
            r10 = 5
            r8.<init>(r9, r7, r10, r14)     // Catch:{ all -> 0x001a }
            java.lang.String r9 = "Adobe"
            boolean r8 = r8.equals(r9)     // Catch:{ all -> 0x001a }
            if (r8 == 0) goto L_0x02c8
            r1.P = r0     // Catch:{ all -> 0x001a }
            goto L_0x02c8
        L_0x00f4:
            r13 = 226(0xe2, float:3.17E-43)
            r2 = 14
            if (r8 != r13) goto L_0x013c
            int r8 = M0(r3)     // Catch:{ all -> 0x001a }
            int r8 = r8 - r12
            byte[] r9 = new byte[r8]     // Catch:{ all -> 0x001a }
            r10 = 0
        L_0x0102:
            if (r10 >= r8) goto L_0x010e
            int r11 = r3.read()     // Catch:{ all -> 0x001a }
            byte r11 = (byte) r11     // Catch:{ all -> 0x001a }
            r9[r10] = r11     // Catch:{ all -> 0x001a }
            int r10 = r10 + 1
            goto L_0x0102
        L_0x010e:
            if (r8 < r2) goto L_0x02c8
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x001a }
            r8 = 11
            r2.<init>(r9, r7, r8, r14)     // Catch:{ all -> 0x001a }
            java.lang.String r8 = "ICC_PROFILE"
            boolean r2 = r2.equals(r8)     // Catch:{ all -> 0x001a }
            if (r2 == 0) goto L_0x02c8
            byte r2 = r9[r15]     // Catch:{ all -> 0x001a }
            r2 = r2 & r6
            r8 = 13
            byte r8 = r9[r8]     // Catch:{ all -> 0x001a }
            r8 = r8 & r6
            if (r2 >= r0) goto L_0x012a
            r2 = 1
        L_0x012a:
            if (r8 >= r0) goto L_0x012d
            r8 = 1
        L_0x012d:
            byte[][] r10 = r1.X     // Catch:{ all -> 0x001a }
            if (r10 != 0) goto L_0x0135
            byte[][] r8 = new byte[r8][]     // Catch:{ all -> 0x001a }
            r1.X = r8     // Catch:{ all -> 0x001a }
        L_0x0135:
            byte[][] r8 = r1.X     // Catch:{ all -> 0x001a }
            int r2 = r2 - r0
            r8[r2] = r9     // Catch:{ all -> 0x001a }
            goto L_0x02c8
        L_0x013c:
            r13 = 237(0xed, float:3.32E-43)
            r14 = 8
            if (r8 != r13) goto L_0x0210
            int r2 = M0(r3)     // Catch:{ all -> 0x001a }
            int r2 = r2 - r12
            byte[] r8 = new byte[r2]     // Catch:{ all -> 0x001a }
            r13 = 0
        L_0x014a:
            if (r13 >= r2) goto L_0x0156
            int r15 = r3.read()     // Catch:{ all -> 0x001a }
            byte r15 = (byte) r15     // Catch:{ all -> 0x001a }
            r8[r13] = r15     // Catch:{ all -> 0x001a }
            int r13 = r13 + 1
            goto L_0x014a
        L_0x0156:
            r13 = 0
        L_0x0157:
            byte[] r15 = c0     // Catch:{ all -> 0x001a }
            int r15 = r15.length     // Catch:{ all -> 0x001a }
            int r15 = r2 - r15
            if (r13 >= r15) goto L_0x017f
            r15 = 0
        L_0x015f:
            byte[] r7 = c0     // Catch:{ all -> 0x001a }
            int r7 = r7.length     // Catch:{ all -> 0x001a }
            if (r15 >= r7) goto L_0x0175
            int r7 = r13 + r15
            byte r7 = r8[r7]     // Catch:{ all -> 0x001a }
            byte[] r16 = c0     // Catch:{ all -> 0x001a }
            byte r10 = r16[r15]     // Catch:{ all -> 0x001a }
            if (r7 == r10) goto L_0x0170
            r7 = 0
            goto L_0x0176
        L_0x0170:
            int r15 = r15 + 1
            r10 = 1056964608(0x3f000000, float:0.5)
            goto L_0x015f
        L_0x0175:
            r7 = 1
        L_0x0176:
            if (r7 == 0) goto L_0x0179
            goto L_0x017f
        L_0x0179:
            int r13 = r13 + 1
            r7 = 0
            r10 = 1056964608(0x3f000000, float:0.5)
            goto L_0x0157
        L_0x017f:
            byte[] r7 = c0     // Catch:{ all -> 0x001a }
            int r7 = r7.length     // Catch:{ all -> 0x001a }
            int r13 = r13 + r7
            byte[] r7 = c0     // Catch:{ all -> 0x001a }
            int r7 = r7.length     // Catch:{ all -> 0x001a }
            int r2 = r2 - r7
            if (r13 >= r2) goto L_0x02c8
            byte r2 = r8[r13]     // Catch:{ all -> 0x001a }
            int r2 = r2 + r0
            byte r2 = (byte) r2     // Catch:{ all -> 0x001a }
            int r7 = r2 % 2
            if (r7 != r0) goto L_0x0194
            int r2 = r2 + 1
            byte r2 = (byte) r2     // Catch:{ all -> 0x001a }
        L_0x0194:
            int r13 = r13 + r2
            byte r2 = r8[r13]     // Catch:{ all -> 0x001a }
            int r2 = r2 << 24
            int r7 = r13 + 1
            byte r7 = r8[r7]     // Catch:{ all -> 0x001a }
            int r7 = r7 << r9
            int r2 = r2 + r7
            int r7 = r13 + 2
            byte r7 = r8[r7]     // Catch:{ all -> 0x001a }
            int r7 = r7 << r14
            int r2 = r2 + r7
            int r7 = r13 + 3
            byte r7 = r8[r7]     // Catch:{ all -> 0x001a }
            int r2 = r2 + r7
            if (r2 == r9) goto L_0x01ae
            goto L_0x02c8
        L_0x01ae:
            int r13 = r13 + 4
            byte r2 = r8[r13]     // Catch:{ all -> 0x001a }
            int r2 = r2 << r14
            int r7 = r13 + 1
            byte r7 = r8[r7]     // Catch:{ all -> 0x001a }
            r7 = r7 & r6
            int r2 = r2 + r7
            int r13 = r13 + 2
            int r13 = r13 + r12
            byte r7 = r8[r13]     // Catch:{ all -> 0x001a }
            int r7 = r7 << r14
            int r9 = r13 + 1
            byte r9 = r8[r9]     // Catch:{ all -> 0x001a }
            r9 = r9 & r6
            int r7 = r7 + r9
            int r13 = r13 + 2
            int r13 = r13 + r12
            byte r9 = r8[r13]     // Catch:{ all -> 0x001a }
            int r9 = r9 << r14
            int r10 = r13 + 1
            byte r10 = r8[r10]     // Catch:{ all -> 0x001a }
            r10 = r10 & r6
            int r9 = r9 + r10
            int r13 = r13 + 2
            int r13 = r13 + r12
            byte r10 = r8[r13]     // Catch:{ all -> 0x001a }
            int r10 = r10 << r14
            int r13 = r13 + 1
            byte r8 = r8[r13]     // Catch:{ all -> 0x001a }
            r8 = r8 & r6
            int r10 = r10 + r8
            if (r7 == r0) goto L_0x01e1
            if (r7 != r12) goto L_0x01f5
        L_0x01e1:
            if (r7 != r12) goto L_0x01ea
            float r2 = (float) r2     // Catch:{ all -> 0x001a }
            float r2 = r2 * r11
            r7 = 1056964608(0x3f000000, float:0.5)
            float r2 = r2 + r7
            int r2 = (int) r2     // Catch:{ all -> 0x001a }
        L_0x01ea:
            int r7 = r1.K     // Catch:{ all -> 0x001a }
            if (r7 == 0) goto L_0x01f3
            int r7 = r1.K     // Catch:{ all -> 0x001a }
            if (r7 == r2) goto L_0x01f3
            goto L_0x01f5
        L_0x01f3:
            r1.K = r2     // Catch:{ all -> 0x001a }
        L_0x01f5:
            if (r10 == r0) goto L_0x01f9
            if (r10 != r12) goto L_0x02c8
        L_0x01f9:
            if (r10 != r12) goto L_0x0202
            float r2 = (float) r9     // Catch:{ all -> 0x001a }
            float r2 = r2 * r11
            r7 = 1056964608(0x3f000000, float:0.5)
            float r2 = r2 + r7
            int r9 = (int) r2     // Catch:{ all -> 0x001a }
        L_0x0202:
            int r2 = r1.L     // Catch:{ all -> 0x001a }
            if (r2 == 0) goto L_0x020c
            int r2 = r1.L     // Catch:{ all -> 0x001a }
            if (r2 == r9) goto L_0x020c
            goto L_0x02c8
        L_0x020c:
            r1.L = r9     // Catch:{ all -> 0x001a }
            goto L_0x02c8
        L_0x0210:
            int r5 = N0(r8)     // Catch:{ all -> 0x001a }
            if (r5 != 0) goto L_0x02a1
            fe.when.ad.a.i(r3, r12)     // Catch:{ all -> 0x001a }
            int r5 = r3.read()     // Catch:{ all -> 0x001a }
            if (r5 != r14) goto L_0x0290
            int r0 = M0(r3)     // Catch:{ all -> 0x001a }
            float r0 = (float) r0     // Catch:{ all -> 0x001a }
            r1.n = r0     // Catch:{ all -> 0x001a }
            r1.n(r0)     // Catch:{ all -> 0x001a }
            int r0 = M0(r3)     // Catch:{ all -> 0x001a }
            float r0 = (float) r0     // Catch:{ all -> 0x001a }
            r1.m = r0     // Catch:{ all -> 0x001a }
            r1.l(r0)     // Catch:{ all -> 0x001a }
            int r0 = r3.read()     // Catch:{ all -> 0x001a }
            r1.N = r0     // Catch:{ all -> 0x001a }
            r1.tt = r14     // Catch:{ all -> 0x001a }
            if (r3 == 0) goto L_0x0240
            r3.close()
        L_0x0240:
            float r0 = r17.rrr()
            r1.k = r0
            float r0 = r17.ggg()
            r1.l = r0
            byte[][] r0 = r1.X
            if (r0 == 0) goto L_0x028f
            r0 = 0
            r3 = 0
        L_0x0252:
            byte[][] r4 = r1.X
            int r5 = r4.length
            if (r0 >= r5) goto L_0x0267
            r5 = r4[r0]
            if (r5 != 0) goto L_0x025f
            r5 = 0
            r1.X = r5
            return
        L_0x025f:
            r4 = r4[r0]
            int r4 = r4.length
            int r4 = r4 - r2
            int r3 = r3 + r4
            int r0 = r0 + 1
            goto L_0x0252
        L_0x0267:
            byte[] r0 = new byte[r3]
            r3 = 0
            r7 = 0
        L_0x026b:
            byte[][] r4 = r1.X
            int r5 = r4.length
            if (r7 >= r5) goto L_0x0283
            r5 = r4[r7]
            r4 = r4[r7]
            int r4 = r4.length
            int r4 = r4 - r2
            java.lang.System.arraycopy(r5, r2, r0, r3, r4)
            byte[][] r4 = r1.X
            r4 = r4[r7]
            int r4 = r4.length
            int r4 = r4 - r2
            int r3 = r3 + r4
            int r7 = r7 + 1
            goto L_0x026b
        L_0x0283:
            int r2 = r1.N     // Catch:{ IllegalArgumentException -> 0x028c }
            fe.when.ad.f.mmm r0 = fe.when.ad.f.mmm.de(r0, r2)     // Catch:{ IllegalArgumentException -> 0x028c }
            r1.L0(r0)     // Catch:{ IllegalArgumentException -> 0x028c }
        L_0x028c:
            r2 = 0
            r1.X = r2
        L_0x028f:
            return
        L_0x0290:
            com.itextpdf.text.BadElementException r2 = new com.itextpdf.text.BadElementException     // Catch:{ all -> 0x001a }
            java.lang.String r5 = "1.must.have.8.bits.per.component"
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x001a }
            r6 = 0
            r0[r6] = r4     // Catch:{ all -> 0x001a }
            java.lang.String r0 = fe.when.ad.c.qw.ad(r5, r0)     // Catch:{ all -> 0x001a }
            r2.<init>((java.lang.String) r0)     // Catch:{ all -> 0x001a }
            throw r2     // Catch:{ all -> 0x001a }
        L_0x02a1:
            r2 = 0
            if (r5 == r0) goto L_0x02b0
            if (r5 == r12) goto L_0x02ae
            int r5 = M0(r3)     // Catch:{ all -> 0x001a }
            int r5 = r5 - r12
            fe.when.ad.a.i(r3, r5)     // Catch:{ all -> 0x001a }
        L_0x02ae:
            r5 = 0
            goto L_0x02c8
        L_0x02b0:
            com.itextpdf.text.BadElementException r2 = new com.itextpdf.text.BadElementException     // Catch:{ all -> 0x001a }
            java.lang.String r5 = "1.unsupported.jpeg.marker.2"
            java.lang.Object[] r6 = new java.lang.Object[r12]     // Catch:{ all -> 0x001a }
            r7 = 0
            r6[r7] = r4     // Catch:{ all -> 0x001a }
            java.lang.String r4 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x001a }
            r6[r0] = r4     // Catch:{ all -> 0x001a }
            java.lang.String r0 = fe.when.ad.c.qw.ad(r5, r6)     // Catch:{ all -> 0x001a }
            r2.<init>((java.lang.String) r0)     // Catch:{ all -> 0x001a }
            throw r2     // Catch:{ all -> 0x001a }
        L_0x02c7:
            r2 = 0
        L_0x02c8:
            r7 = 0
            goto L_0x0039
        L_0x02cb:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x001a }
            java.lang.String r2 = "premature.eof.while.reading.jpg"
            r4 = 0
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x001a }
            java.lang.String r2 = fe.when.ad.c.qw.ad(r2, r4)     // Catch:{ all -> 0x001a }
            r0.<init>(r2)     // Catch:{ all -> 0x001a }
            throw r0     // Catch:{ all -> 0x001a }
        L_0x02da:
            com.itextpdf.text.BadElementException r2 = new com.itextpdf.text.BadElementException     // Catch:{ all -> 0x001a }
            java.lang.String r5 = "1.is.not.a.valid.jpeg.file"
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x001a }
            r6 = 0
            r0[r6] = r4     // Catch:{ all -> 0x001a }
            java.lang.String r0 = fe.when.ad.c.qw.ad(r5, r0)     // Catch:{ all -> 0x001a }
            r2.<init>((java.lang.String) r0)     // Catch:{ all -> 0x001a }
            throw r2     // Catch:{ all -> 0x001a }
        L_0x02eb:
            r0 = move-exception
            r2 = 0
        L_0x02ed:
            if (r2 == 0) goto L_0x02f2
            r2.close()
        L_0x02f2:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.when.O0():void");
    }

    public when(byte[] bArr) throws BadElementException, IOException {
        super((URL) null);
        this.rrr = bArr;
        this.I = bArr;
        O0();
    }
}
