package fe.rg.qw.i;

import android.graphics.Bitmap;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.gifdecoder.GifDecoder;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

public class fe implements GifDecoder {
    public static final String mmm = "fe";
    @ColorInt

    /* renamed from: ad  reason: collision with root package name */
    public final int[] f4697ad;
    @Nullable
    public Boolean ddd;

    /* renamed from: de  reason: collision with root package name */
    public final GifDecoder.BitmapProvider f4698de;

    /* renamed from: fe  reason: collision with root package name */
    public ByteBuffer f4699fe;
    public int ggg;

    /* renamed from: i  reason: collision with root package name */
    public byte[] f4700i;

    /* renamed from: if  reason: not valid java name */
    public ad f178if;
    @NonNull
    public Bitmap.Config nn;
    @ColorInt

    /* renamed from: o  reason: collision with root package name */
    public int[] f4701o;

    /* renamed from: pf  reason: collision with root package name */
    public int f4702pf;
    public int ppp;
    @ColorInt
    public int[] qw;

    /* renamed from: rg  reason: collision with root package name */
    public byte[] f4703rg;

    /* renamed from: switch  reason: not valid java name */
    public Bitmap f179switch;

    /* renamed from: th  reason: collision with root package name */
    public short[] f4704th;

    /* renamed from: uk  reason: collision with root package name */
    public byte[] f4705uk;
    public int vvv;
    public boolean when;
    public int xxx;

    /* renamed from: yj  reason: collision with root package name */
    public byte[] f4706yj;

    public fe(@NonNull GifDecoder.BitmapProvider bitmapProvider, ad adVar, ByteBuffer byteBuffer, int i2) {
        this(bitmapProvider);
        vvv(adVar, byteBuffer, i2);
    }

    public void ad() {
        this.f4702pf = (this.f4702pf + 1) % this.f178if.f4685de;
    }

    public void clear() {
        this.f178if = null;
        byte[] bArr = this.f4700i;
        if (bArr != null) {
            this.f4698de.rg(bArr);
        }
        int[] iArr = this.f4701o;
        if (iArr != null) {
            this.f4698de.th(iArr);
        }
        Bitmap bitmap = this.f179switch;
        if (bitmap != null) {
            this.f4698de.qw(bitmap);
        }
        this.f179switch = null;
        this.f4699fe = null;
        this.ddd = null;
        byte[] bArr2 = this.f4703rg;
        if (bArr2 != null) {
            this.f4698de.rg(bArr2);
        }
    }

    public int de() {
        return this.f178if.f4685de;
    }

    public void fe(@NonNull Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888 || config == Bitmap.Config.RGB_565) {
            this.nn = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
    }

    @NonNull
    public ByteBuffer getData() {
        return this.f4699fe;
    }

    public final int ggg() {
        return this.f4699fe.get() & 255;
    }

    @ColorInt
    public final int i(int i2, int i3, int i4) {
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = i2; i10 < this.ggg + i2; i10++) {
            byte[] bArr = this.f4700i;
            if (i10 >= bArr.length || i10 >= i3) {
                break;
            }
            int i11 = this.qw[bArr[i10] & 255];
            if (i11 != 0) {
                i5 += (i11 >> 24) & 255;
                i6 += (i11 >> 16) & 255;
                i7 += (i11 >> 8) & 255;
                i8 += i11 & 255;
                i9++;
            }
        }
        int i12 = i2 + i4;
        for (int i13 = i12; i13 < this.ggg + i12; i13++) {
            byte[] bArr2 = this.f4700i;
            if (i13 >= bArr2.length || i13 >= i3) {
                break;
            }
            int i14 = this.qw[bArr2[i13] & 255];
            if (i14 != 0) {
                i5 += (i14 >> 24) & 255;
                i6 += (i14 >> 16) & 255;
                i7 += (i14 >> 8) & 255;
                i8 += i14 & 255;
                i9++;
            }
        }
        if (i9 == 0) {
            return 0;
        }
        return ((i5 / i9) << 24) | ((i6 / i9) << 16) | ((i7 / i9) << 8) | (i8 / i9);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: byte} */
    /* JADX WARNING: Incorrect type for immutable var: ssa=short, code=int, for r7v13, types: [short] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: if  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m303if(fe.rg.qw.i.qw r29) {
        /*
            r28 = this;
            r0 = r28
            r1 = r29
            if (r1 == 0) goto L_0x000d
            java.nio.ByteBuffer r2 = r0.f4699fe
            int r3 = r1.f4711o
            r2.position(r3)
        L_0x000d:
            if (r1 != 0) goto L_0x0016
            fe.rg.qw.i.ad r1 = r0.f178if
            int r2 = r1.f4691th
            int r1 = r1.f4693yj
            goto L_0x001a
        L_0x0016:
            int r2 = r1.f4708de
            int r1 = r1.f4709fe
        L_0x001a:
            int r2 = r2 * r1
            byte[] r1 = r0.f4700i
            if (r1 == 0) goto L_0x0023
            int r1 = r1.length
            if (r1 >= r2) goto L_0x002b
        L_0x0023:
            com.bumptech.glide.gifdecoder.GifDecoder$BitmapProvider r1 = r0.f4698de
            byte[] r1 = r1.ad(r2)
            r0.f4700i = r1
        L_0x002b:
            byte[] r1 = r0.f4700i
            short[] r3 = r0.f4704th
            r4 = 4096(0x1000, float:5.74E-42)
            if (r3 != 0) goto L_0x0037
            short[] r3 = new short[r4]
            r0.f4704th = r3
        L_0x0037:
            short[] r3 = r0.f4704th
            byte[] r5 = r0.f4706yj
            if (r5 != 0) goto L_0x0041
            byte[] r5 = new byte[r4]
            r0.f4706yj = r5
        L_0x0041:
            byte[] r5 = r0.f4706yj
            byte[] r6 = r0.f4705uk
            if (r6 != 0) goto L_0x004d
            r6 = 4097(0x1001, float:5.741E-42)
            byte[] r6 = new byte[r6]
            r0.f4705uk = r6
        L_0x004d:
            byte[] r6 = r0.f4705uk
            int r7 = r28.ggg()
            r8 = 1
            int r9 = r8 << r7
            int r10 = r9 + 1
            int r11 = r9 + 2
            int r7 = r7 + r8
            int r12 = r8 << r7
            int r12 = r12 - r8
            r13 = 0
            r14 = 0
        L_0x0060:
            if (r14 >= r9) goto L_0x006a
            r3[r14] = r13
            byte r15 = (byte) r14
            r5[r14] = r15
            int r14 = r14 + 1
            goto L_0x0060
        L_0x006a:
            byte[] r14 = r0.f4703rg
            r15 = -1
            r23 = r7
            r21 = r11
            r22 = r12
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r24 = -1
            r25 = 0
            r26 = 0
        L_0x0083:
            if (r13 >= r2) goto L_0x014c
            if (r16 != 0) goto L_0x0094
            int r16 = r28.ppp()
            if (r16 > 0) goto L_0x0092
            r3 = 3
            r0.ppp = r3
            goto L_0x014c
        L_0x0092:
            r17 = 0
        L_0x0094:
            byte r4 = r14[r17]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r4 = r4 << r18
            int r19 = r19 + r4
            int r18 = r18 + 8
            int r17 = r17 + 1
            int r16 = r16 + -1
            r4 = r18
            r8 = r21
            r15 = r23
            r0 = r24
            r23 = r7
            r7 = r25
        L_0x00ae:
            if (r4 < r15) goto L_0x0136
            r24 = r11
            r11 = r19 & r22
            int r19 = r19 >> r15
            int r4 = r4 - r15
            if (r11 != r9) goto L_0x00c2
            r22 = r12
            r15 = r23
            r8 = r24
            r11 = r8
            r0 = -1
            goto L_0x00ae
        L_0x00c2:
            if (r11 != r10) goto L_0x00d9
            r18 = r4
            r25 = r7
            r21 = r8
            r7 = r23
            r11 = r24
            r4 = 4096(0x1000, float:5.74E-42)
            r8 = 1
            r24 = r0
            r23 = r15
            r15 = -1
            r0 = r28
            goto L_0x0083
        L_0x00d9:
            r25 = r4
            r4 = -1
            if (r0 != r4) goto L_0x00ed
            byte r0 = r5[r11]
            r1[r20] = r0
            int r20 = r20 + 1
            int r13 = r13 + 1
            r0 = r11
            r7 = r0
            r11 = r24
            r4 = r25
            goto L_0x00ae
        L_0x00ed:
            if (r11 < r8) goto L_0x00f6
            byte r7 = (byte) r7
            r6[r26] = r7
            int r26 = r26 + 1
            r7 = r0
            goto L_0x00f7
        L_0x00f6:
            r7 = r11
        L_0x00f7:
            if (r7 < r9) goto L_0x0102
            byte r21 = r5[r7]
            r6[r26] = r21
            int r26 = r26 + 1
            short r7 = r3[r7]
            goto L_0x00f7
        L_0x0102:
            byte r7 = r5[r7]
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r4 = (byte) r7
            r1[r20] = r4
        L_0x0109:
            int r20 = r20 + 1
            int r13 = r13 + 1
            if (r26 <= 0) goto L_0x0116
            int r26 = r26 + -1
            byte r27 = r6[r26]
            r1[r20] = r27
            goto L_0x0109
        L_0x0116:
            r27 = r6
            r6 = 4096(0x1000, float:5.74E-42)
            if (r8 >= r6) goto L_0x012d
            short r0 = (short) r0
            r3[r8] = r0
            r5[r8] = r4
            int r8 = r8 + 1
            r0 = r8 & r22
            if (r0 != 0) goto L_0x012d
            if (r8 >= r6) goto L_0x012d
            int r15 = r15 + 1
            int r22 = r22 + r8
        L_0x012d:
            r0 = r11
            r11 = r24
            r4 = r25
            r6 = r27
            goto L_0x00ae
        L_0x0136:
            r25 = r4
            r24 = r0
            r21 = r8
            r18 = r25
            r4 = 4096(0x1000, float:5.74E-42)
            r8 = 1
            r0 = r28
            r25 = r7
            r7 = r23
            r23 = r15
            r15 = -1
            goto L_0x0083
        L_0x014c:
            r13 = r20
            r0 = 0
            java.util.Arrays.fill(r1, r13, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.rg.qw.i.fe.m303if(fe.rg.qw.i.qw):void");
    }

    public final void o(qw qwVar) {
        boolean z;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        qw qwVar2 = qwVar;
        int[] iArr = this.f4701o;
        int i7 = qwVar2.f4709fe;
        int i8 = this.ggg;
        int i9 = i7 / i8;
        int i10 = qwVar2.f4707ad / i8;
        int i11 = qwVar2.f4708de / i8;
        int i12 = qwVar2.qw / i8;
        boolean z2 = this.f4702pf == 0;
        int i13 = this.ggg;
        int i14 = this.xxx;
        int i15 = this.vvv;
        byte[] bArr = this.f4700i;
        int[] iArr2 = this.qw;
        Boolean bool = this.ddd;
        int i16 = 8;
        int i17 = 0;
        int i18 = 0;
        int i19 = 1;
        while (i17 < i9) {
            Boolean bool2 = bool;
            if (qwVar2.f4713rg) {
                if (i18 >= i9) {
                    i2 = i9;
                    int i20 = i19 + 1;
                    if (i20 == 2) {
                        i19 = i20;
                        i18 = 4;
                    } else if (i20 == 3) {
                        i19 = i20;
                        i18 = 2;
                        i16 = 4;
                    } else if (i20 != 4) {
                        i19 = i20;
                    } else {
                        i19 = i20;
                        i18 = 1;
                        i16 = 2;
                    }
                } else {
                    i2 = i9;
                }
                i3 = i18 + i16;
            } else {
                i2 = i9;
                i3 = i18;
                i18 = i17;
            }
            int i21 = i18 + i10;
            boolean z3 = i13 == 1;
            if (i21 < i15) {
                int i22 = i21 * i14;
                int i23 = i22 + i12;
                int i24 = i23 + i11;
                int i25 = i22 + i14;
                if (i25 < i24) {
                    i24 = i25;
                }
                i4 = i3;
                int i26 = i17 * i13 * qwVar2.f4708de;
                if (z3) {
                    int i27 = i23;
                    while (i27 < i24) {
                        int i28 = i10;
                        int i29 = iArr2[bArr[i26] & 255];
                        if (i29 != 0) {
                            iArr[i27] = i29;
                        } else if (z2 && bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        i26 += i13;
                        i27++;
                        i10 = i28;
                    }
                } else {
                    i6 = i10;
                    int i30 = ((i24 - i23) * i13) + i26;
                    int i31 = i23;
                    while (true) {
                        i5 = i11;
                        if (i31 >= i24) {
                            break;
                        }
                        int i32 = i(i26, i30, qwVar2.f4708de);
                        if (i32 != 0) {
                            iArr[i31] = i32;
                        } else if (z2 && bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        i26 += i13;
                        i31++;
                        i11 = i5;
                    }
                    bool = bool2;
                    i17++;
                    i10 = i6;
                    i11 = i5;
                    i9 = i2;
                    i18 = i4;
                }
            } else {
                i4 = i3;
            }
            i6 = i10;
            i5 = i11;
            bool = bool2;
            i17++;
            i10 = i6;
            i11 = i5;
            i9 = i2;
            i18 = i4;
        }
        Boolean bool3 = bool;
        if (this.ddd == null) {
            if (bool3 == null) {
                z = false;
            } else {
                z = bool3.booleanValue();
            }
            this.ddd = Boolean.valueOf(z);
        }
    }

    public final void pf(qw qwVar) {
        qw qwVar2 = qwVar;
        int[] iArr = this.f4701o;
        int i2 = qwVar2.f4709fe;
        int i3 = qwVar2.f4707ad;
        int i4 = qwVar2.f4708de;
        int i5 = qwVar2.qw;
        boolean z = this.f4702pf == 0;
        int i6 = this.xxx;
        byte[] bArr = this.f4700i;
        int[] iArr2 = this.qw;
        int i7 = 0;
        byte b = -1;
        while (i7 < i2) {
            int i8 = (i7 + i3) * i6;
            int i9 = i8 + i5;
            int i10 = i9 + i4;
            int i11 = i8 + i6;
            if (i11 < i10) {
                i10 = i11;
            }
            int i12 = qwVar2.f4708de * i7;
            int i13 = i9;
            while (i13 < i10) {
                byte b2 = bArr[i12];
                int i14 = i2;
                byte b3 = b2 & 255;
                if (b3 != b) {
                    int i15 = iArr2[b3];
                    if (i15 != 0) {
                        iArr[i13] = i15;
                    } else {
                        b = b2;
                    }
                }
                i12++;
                i13++;
                qw qwVar3 = qwVar;
                i2 = i14;
            }
            int i16 = i2;
            i7++;
            qwVar2 = qwVar;
        }
        this.ddd = Boolean.valueOf(this.ddd == null && z && b != -1);
    }

    public final int ppp() {
        int ggg2 = ggg();
        if (ggg2 <= 0) {
            return ggg2;
        }
        ByteBuffer byteBuffer = this.f4699fe;
        byteBuffer.get(this.f4703rg, 0, Math.min(ggg2, byteBuffer.remaining()));
        return ggg2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00cf, code lost:
        return null;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized android.graphics.Bitmap qw() {
        /*
            r7 = this;
            monitor-enter(r7)
            fe.rg.qw.i.ad r0 = r7.f178if     // Catch:{ all -> 0x00d0 }
            int r0 = r0.f4685de     // Catch:{ all -> 0x00d0 }
            r1 = 3
            r2 = 1
            if (r0 <= 0) goto L_0x000d
            int r0 = r7.f4702pf     // Catch:{ all -> 0x00d0 }
            if (r0 >= 0) goto L_0x0035
        L_0x000d:
            java.lang.String r0 = mmm     // Catch:{ all -> 0x00d0 }
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00d0 }
            if (r0 == 0) goto L_0x0033
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d0 }
            r0.<init>()     // Catch:{ all -> 0x00d0 }
            java.lang.String r3 = "Unable to decode frame, frameCount="
            r0.append(r3)     // Catch:{ all -> 0x00d0 }
            fe.rg.qw.i.ad r3 = r7.f178if     // Catch:{ all -> 0x00d0 }
            int r3 = r3.f4685de     // Catch:{ all -> 0x00d0 }
            r0.append(r3)     // Catch:{ all -> 0x00d0 }
            java.lang.String r3 = ", framePointer="
            r0.append(r3)     // Catch:{ all -> 0x00d0 }
            int r3 = r7.f4702pf     // Catch:{ all -> 0x00d0 }
            r0.append(r3)     // Catch:{ all -> 0x00d0 }
            r0.toString()     // Catch:{ all -> 0x00d0 }
        L_0x0033:
            r7.ppp = r2     // Catch:{ all -> 0x00d0 }
        L_0x0035:
            int r0 = r7.ppp     // Catch:{ all -> 0x00d0 }
            r3 = 0
            if (r0 == r2) goto L_0x00b4
            int r0 = r7.ppp     // Catch:{ all -> 0x00d0 }
            r4 = 2
            if (r0 != r4) goto L_0x0041
            goto L_0x00b4
        L_0x0041:
            r0 = 0
            r7.ppp = r0     // Catch:{ all -> 0x00d0 }
            byte[] r4 = r7.f4703rg     // Catch:{ all -> 0x00d0 }
            if (r4 != 0) goto L_0x0052
            com.bumptech.glide.gifdecoder.GifDecoder$BitmapProvider r4 = r7.f4698de     // Catch:{ all -> 0x00d0 }
            r5 = 255(0xff, float:3.57E-43)
            byte[] r4 = r4.ad(r5)     // Catch:{ all -> 0x00d0 }
            r7.f4703rg = r4     // Catch:{ all -> 0x00d0 }
        L_0x0052:
            fe.rg.qw.i.ad r4 = r7.f178if     // Catch:{ all -> 0x00d0 }
            java.util.List<fe.rg.qw.i.qw> r4 = r4.f4690rg     // Catch:{ all -> 0x00d0 }
            int r5 = r7.f4702pf     // Catch:{ all -> 0x00d0 }
            java.lang.Object r4 = r4.get(r5)     // Catch:{ all -> 0x00d0 }
            fe.rg.qw.i.qw r4 = (fe.rg.qw.i.qw) r4     // Catch:{ all -> 0x00d0 }
            int r5 = r7.f4702pf     // Catch:{ all -> 0x00d0 }
            int r5 = r5 - r2
            if (r5 < 0) goto L_0x006e
            fe.rg.qw.i.ad r6 = r7.f178if     // Catch:{ all -> 0x00d0 }
            java.util.List<fe.rg.qw.i.qw> r6 = r6.f4690rg     // Catch:{ all -> 0x00d0 }
            java.lang.Object r5 = r6.get(r5)     // Catch:{ all -> 0x00d0 }
            fe.rg.qw.i.qw r5 = (fe.rg.qw.i.qw) r5     // Catch:{ all -> 0x00d0 }
            goto L_0x006f
        L_0x006e:
            r5 = r3
        L_0x006f:
            int[] r6 = r4.f4712pf     // Catch:{ all -> 0x00d0 }
            if (r6 == 0) goto L_0x0076
            int[] r6 = r4.f4712pf     // Catch:{ all -> 0x00d0 }
            goto L_0x007a
        L_0x0076:
            fe.rg.qw.i.ad r6 = r7.f178if     // Catch:{ all -> 0x00d0 }
            int[] r6 = r6.qw     // Catch:{ all -> 0x00d0 }
        L_0x007a:
            r7.qw = r6     // Catch:{ all -> 0x00d0 }
            if (r6 != 0) goto L_0x009c
            java.lang.String r0 = mmm     // Catch:{ all -> 0x00d0 }
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00d0 }
            if (r0 == 0) goto L_0x0098
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d0 }
            r0.<init>()     // Catch:{ all -> 0x00d0 }
            java.lang.String r1 = "No valid color table found for frame #"
            r0.append(r1)     // Catch:{ all -> 0x00d0 }
            int r1 = r7.f4702pf     // Catch:{ all -> 0x00d0 }
            r0.append(r1)     // Catch:{ all -> 0x00d0 }
            r0.toString()     // Catch:{ all -> 0x00d0 }
        L_0x0098:
            r7.ppp = r2     // Catch:{ all -> 0x00d0 }
            monitor-exit(r7)
            return r3
        L_0x009c:
            boolean r1 = r4.f4714th     // Catch:{ all -> 0x00d0 }
            if (r1 == 0) goto L_0x00ae
            int[] r1 = r7.f4697ad     // Catch:{ all -> 0x00d0 }
            int r2 = r6.length     // Catch:{ all -> 0x00d0 }
            java.lang.System.arraycopy(r6, r0, r1, r0, r2)     // Catch:{ all -> 0x00d0 }
            int[] r1 = r7.f4697ad     // Catch:{ all -> 0x00d0 }
            r7.qw = r1     // Catch:{ all -> 0x00d0 }
            int r2 = r4.f4715uk     // Catch:{ all -> 0x00d0 }
            r1[r2] = r0     // Catch:{ all -> 0x00d0 }
        L_0x00ae:
            android.graphics.Bitmap r0 = r7.xxx(r4, r5)     // Catch:{ all -> 0x00d0 }
            monitor-exit(r7)
            return r0
        L_0x00b4:
            java.lang.String r0 = mmm     // Catch:{ all -> 0x00d0 }
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00d0 }
            if (r0 == 0) goto L_0x00ce
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d0 }
            r0.<init>()     // Catch:{ all -> 0x00d0 }
            java.lang.String r1 = "Unable to decode frame, status="
            r0.append(r1)     // Catch:{ all -> 0x00d0 }
            int r1 = r7.ppp     // Catch:{ all -> 0x00d0 }
            r0.append(r1)     // Catch:{ all -> 0x00d0 }
            r0.toString()     // Catch:{ all -> 0x00d0 }
        L_0x00ce:
            monitor-exit(r7)
            return r3
        L_0x00d0:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.rg.qw.i.fe.qw():android.graphics.Bitmap");
    }

    public int rg() {
        int i2;
        if (this.f178if.f4685de <= 0 || (i2 = this.f4702pf) < 0) {
            return 0;
        }
        return m304switch(i2);
    }

    /* renamed from: switch  reason: not valid java name */
    public int m304switch(int i2) {
        if (i2 >= 0) {
            ad adVar = this.f178if;
            if (i2 < adVar.f4685de) {
                return adVar.f4690rg.get(i2).f4710i;
            }
        }
        return -1;
    }

    public void th() {
        this.f4702pf = -1;
    }

    public int uk() {
        return this.f4699fe.limit() + this.f4700i.length + (this.f4701o.length * 4);
    }

    public synchronized void vvv(@NonNull ad adVar, @NonNull ByteBuffer byteBuffer, int i2) {
        if (i2 > 0) {
            int highestOneBit = Integer.highestOneBit(i2);
            this.ppp = 0;
            this.f178if = adVar;
            this.f4702pf = -1;
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.f4699fe = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            this.f4699fe.order(ByteOrder.LITTLE_ENDIAN);
            this.when = false;
            Iterator<qw> it = adVar.f4690rg.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().f4716yj == 3) {
                        this.when = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            this.ggg = highestOneBit;
            this.xxx = adVar.f4691th / highestOneBit;
            this.vvv = adVar.f4693yj / highestOneBit;
            this.f4700i = this.f4698de.ad(adVar.f4691th * adVar.f4693yj);
            this.f4701o = this.f4698de.fe(this.xxx * this.vvv);
        } else {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i2);
        }
    }

    public final Bitmap when() {
        Boolean bool = this.ddd;
        Bitmap de2 = this.f4698de.de(this.xxx, this.vvv, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.nn);
        de2.setHasAlpha(true);
        return de2;
    }

    public final Bitmap xxx(qw qwVar, qw qwVar2) {
        int i2;
        int i3;
        Bitmap bitmap;
        int[] iArr = this.f4701o;
        int i4 = 0;
        if (qwVar2 == null) {
            Bitmap bitmap2 = this.f179switch;
            if (bitmap2 != null) {
                this.f4698de.qw(bitmap2);
            }
            this.f179switch = null;
            Arrays.fill(iArr, 0);
        }
        if (qwVar2 != null && qwVar2.f4716yj == 3 && this.f179switch == null) {
            Arrays.fill(iArr, 0);
        }
        if (qwVar2 != null && (i3 = qwVar2.f4716yj) > 0) {
            if (i3 == 2) {
                if (!qwVar.f4714th) {
                    ad adVar = this.f178if;
                    int i5 = adVar.f176if;
                    if (qwVar.f4712pf == null || adVar.f4688o != qwVar.f4715uk) {
                        i4 = i5;
                    }
                } else if (this.f4702pf == 0) {
                    this.ddd = Boolean.TRUE;
                }
                int i6 = qwVar2.f4709fe;
                int i7 = this.ggg;
                int i8 = i6 / i7;
                int i9 = qwVar2.f4707ad / i7;
                int i10 = qwVar2.f4708de / i7;
                int i11 = qwVar2.qw / i7;
                int i12 = this.xxx;
                int i13 = (i9 * i12) + i11;
                int i14 = (i8 * i12) + i13;
                while (i13 < i14) {
                    int i15 = i13 + i10;
                    for (int i16 = i13; i16 < i15; i16++) {
                        iArr[i16] = i4;
                    }
                    i13 += this.xxx;
                }
            } else if (i3 == 3 && (bitmap = this.f179switch) != null) {
                int i17 = this.xxx;
                bitmap.getPixels(iArr, 0, i17, 0, 0, i17, this.vvv);
            }
        }
        m303if(qwVar);
        if (qwVar.f4713rg || this.ggg != 1) {
            o(qwVar);
        } else {
            pf(qwVar);
        }
        if (this.when && ((i2 = qwVar.f4716yj) == 0 || i2 == 1)) {
            if (this.f179switch == null) {
                this.f179switch = when();
            }
            Bitmap bitmap3 = this.f179switch;
            int i18 = this.xxx;
            bitmap3.setPixels(iArr, 0, i18, 0, 0, i18, this.vvv);
        }
        Bitmap when2 = when();
        int i19 = this.xxx;
        when2.setPixels(iArr, 0, i19, 0, 0, i19, this.vvv);
        return when2;
    }

    public int yj() {
        return this.f4702pf;
    }

    public fe(@NonNull GifDecoder.BitmapProvider bitmapProvider) {
        this.f4697ad = new int[256];
        this.nn = Bitmap.Config.ARGB_8888;
        this.f4698de = bitmapProvider;
        this.f178if = new ad();
    }
}
