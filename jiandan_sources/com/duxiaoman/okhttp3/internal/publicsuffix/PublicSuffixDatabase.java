package com.duxiaoman.okhttp3.internal.publicsuffix;

import androidx.exifinterface.media.ExifInterface;
import fe.th.de.rrr.fe;
import java.io.IOException;
import java.io.InputStream;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
import okio.Source;

public final class PublicSuffixDatabase {

    /* renamed from: rg  reason: collision with root package name */
    public static final byte[] f3807rg = {ExifInterface.START_CODE};

    /* renamed from: th  reason: collision with root package name */
    public static final String[] f3808th = new String[0];

    /* renamed from: uk  reason: collision with root package name */
    public static final PublicSuffixDatabase f3809uk = new PublicSuffixDatabase();

    /* renamed from: yj  reason: collision with root package name */
    public static final String[] f3810yj = {"*"};

    /* renamed from: ad  reason: collision with root package name */
    public final CountDownLatch f3811ad = new CountDownLatch(1);

    /* renamed from: de  reason: collision with root package name */
    public byte[] f3812de;

    /* renamed from: fe  reason: collision with root package name */
    public byte[] f3813fe;
    public final AtomicBoolean qw = new AtomicBoolean(false);

    public static PublicSuffixDatabase de() {
        return f3809uk;
    }

    public static String qw(byte[] bArr, byte[][] bArr2, int i2) {
        int i3;
        boolean z;
        byte b;
        int i4;
        byte[] bArr3 = bArr;
        byte[][] bArr4 = bArr2;
        int length = bArr3.length;
        int i5 = 0;
        while (i5 < length) {
            int i6 = (i5 + length) / 2;
            while (i6 > -1 && bArr3[i6] != 10) {
                i6--;
            }
            int i7 = i6 + 1;
            int i8 = 1;
            while (true) {
                i3 = i7 + i8;
                if (bArr3[i3] == 10) {
                    break;
                }
                i8++;
            }
            int i9 = i3 - i7;
            int i10 = i2;
            boolean z2 = false;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (z2) {
                    b = 46;
                    z = false;
                } else {
                    z = z2;
                    b = bArr4[i10][i11] & 255;
                }
                i4 = b - (bArr3[i7 + i12] & 255);
                if (i4 == 0) {
                    i12++;
                    i11++;
                    if (i12 == i9) {
                        break;
                    } else if (bArr4[i10].length != i11) {
                        z2 = z;
                    } else if (i10 == bArr4.length - 1) {
                        break;
                    } else {
                        i10++;
                        z2 = true;
                        i11 = -1;
                    }
                } else {
                    break;
                }
            }
            if (i4 >= 0) {
                if (i4 <= 0) {
                    int i13 = i9 - i12;
                    int length2 = bArr4[i10].length - i11;
                    while (true) {
                        i10++;
                        if (i10 >= bArr4.length) {
                            break;
                        }
                        length2 += bArr4[i10].length;
                    }
                    if (length2 >= i13) {
                        if (length2 <= i13) {
                            return new String(bArr3, i7, i9, fe.f5257i);
                        }
                    }
                }
                i5 = i3 + 1;
            }
            length = i7 - 1;
        }
        return null;
    }

    public final String[] ad(String[] strArr) {
        String str;
        String str2;
        String str3;
        String[] strArr2;
        String[] strArr3;
        int i2 = 0;
        if (this.qw.get() || !this.qw.compareAndSet(false, true)) {
            try {
                this.f3811ad.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            th();
        }
        synchronized (this) {
            if (this.f3812de == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        int length = strArr.length;
        byte[][] bArr = new byte[length][];
        for (int i3 = 0; i3 < strArr.length; i3++) {
            bArr[i3] = strArr[i3].getBytes(fe.f5257i);
        }
        int i4 = 0;
        while (true) {
            str = null;
            if (i4 >= length) {
                str2 = null;
                break;
            }
            str2 = qw(this.f3812de, bArr, i4);
            if (str2 != null) {
                break;
            }
            i4++;
        }
        if (length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            int i5 = 0;
            while (true) {
                if (i5 >= bArr2.length - 1) {
                    break;
                }
                bArr2[i5] = f3807rg;
                str3 = qw(this.f3812de, bArr2, i5);
                if (str3 != null) {
                    break;
                }
                i5++;
            }
        }
        str3 = null;
        if (str3 != null) {
            while (true) {
                if (i2 >= length - 1) {
                    break;
                }
                String qw2 = qw(this.f3813fe, bArr, i2);
                if (qw2 != null) {
                    str = qw2;
                    break;
                }
                i2++;
            }
        }
        if (str != null) {
            return ("!" + str).split("\\.");
        } else if (str2 == null && str3 == null) {
            return f3810yj;
        } else {
            if (str2 != null) {
                strArr2 = str2.split("\\.");
            } else {
                strArr2 = f3808th;
            }
            if (str3 != null) {
                strArr3 = str3.split("\\.");
            } else {
                strArr3 = f3808th;
            }
            return strArr2.length > strArr3.length ? strArr2 : strArr3;
        }
    }

    public String fe(String str) {
        int i2;
        int i3;
        if (str != null) {
            String[] split = IDN.toUnicode(str).split("\\.");
            String[] ad2 = ad(split);
            if (split.length == ad2.length && ad2[0].charAt(0) != '!') {
                return null;
            }
            if (ad2[0].charAt(0) == '!') {
                i3 = split.length;
                i2 = ad2.length;
            } else {
                i3 = split.length;
                i2 = ad2.length + 1;
            }
            StringBuilder sb = new StringBuilder();
            String[] split2 = str.split("\\.");
            for (int i4 = i3 - i2; i4 < split2.length; i4++) {
                sb.append(split2[i4]);
                sb.append('.');
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
        throw new NullPointerException("domain == null");
    }

    public final void rg() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream(okhttp3.internal.publicsuffix.PublicSuffixDatabase.PUBLIC_SUFFIX_RESOURCE);
        if (resourceAsStream != null) {
            BufferedSource buffer = Okio.buffer((Source) new GzipSource(Okio.source(resourceAsStream)));
            try {
                byte[] bArr = new byte[buffer.readInt()];
                buffer.readFully(bArr);
                byte[] bArr2 = new byte[buffer.readInt()];
                buffer.readFully(bArr2);
                synchronized (this) {
                    this.f3812de = bArr;
                    this.f3813fe = bArr2;
                }
                this.f3811ad.countDown();
            } finally {
                fe.yj(buffer);
            }
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0025 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void th() {
        /*
            r5 = this;
            r0 = 0
        L_0x0001:
            r5.rg()     // Catch:{ InterruptedIOException -> 0x0025, IOException -> 0x0010 }
            if (r0 == 0) goto L_0x000d
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x000d:
            return
        L_0x000e:
            r1 = move-exception
            goto L_0x002a
        L_0x0010:
            r1 = move-exception
            fe.th.de.rrr.if.yj r2 = fe.th.de.rrr.p019if.yj.m350switch()     // Catch:{ all -> 0x000e }
            r3 = 5
            java.lang.String r4 = "Failed to read public suffix list"
            r2.mmm(r3, r4, r1)     // Catch:{ all -> 0x000e }
            if (r0 == 0) goto L_0x0024
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x0024:
            return
        L_0x0025:
            java.lang.Thread.interrupted()     // Catch:{ all -> 0x000e }
            r0 = 1
            goto L_0x0001
        L_0x002a:
            if (r0 == 0) goto L_0x0033
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x0033:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duxiaoman.okhttp3.internal.publicsuffix.PublicSuffixDatabase.th():void");
    }
}
