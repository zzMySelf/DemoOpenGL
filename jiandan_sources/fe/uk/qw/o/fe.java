package fe.uk.qw.o;

import android.graphics.Bitmap;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.dxmbumptech.glide.gifdecoder.GifDecoder;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

public class fe implements GifDecoder {
    public static final String mmm = "fe";
    @ColorInt

    /* renamed from: ad  reason: collision with root package name */
    public final int[] f5664ad;
    @Nullable
    public Boolean ddd;

    /* renamed from: de  reason: collision with root package name */
    public final GifDecoder.BitmapProvider f5665de;

    /* renamed from: fe  reason: collision with root package name */
    public ByteBuffer f5666fe;
    public int ggg;

    /* renamed from: i  reason: collision with root package name */
    public byte[] f5667i;

    /* renamed from: if  reason: not valid java name */
    public ad f232if;
    @NonNull
    public Bitmap.Config nn;
    @ColorInt

    /* renamed from: o  reason: collision with root package name */
    public int[] f5668o;

    /* renamed from: pf  reason: collision with root package name */
    public int f5669pf;
    public int ppp;
    @ColorInt
    public int[] qw;

    /* renamed from: rg  reason: collision with root package name */
    public byte[] f5670rg;

    /* renamed from: switch  reason: not valid java name */
    public Bitmap f233switch;

    /* renamed from: th  reason: collision with root package name */
    public short[] f5671th;

    /* renamed from: uk  reason: collision with root package name */
    public byte[] f5672uk;
    public int vvv;
    public boolean when;
    public int xxx;

    /* renamed from: yj  reason: collision with root package name */
    public byte[] f5673yj;

    public fe(@NonNull GifDecoder.BitmapProvider bitmapProvider, ad adVar, ByteBuffer byteBuffer, int i2) {
        this(bitmapProvider);
        xxx(adVar, byteBuffer, i2);
    }

    public void ad() {
        this.f5669pf = (this.f5669pf + 1) % this.f232if.f5652de;
    }

    public void clear() {
        this.f232if = null;
        byte[] bArr = this.f5667i;
        if (bArr != null) {
            this.f5665de.rg(bArr);
        }
        int[] iArr = this.f5668o;
        if (iArr != null) {
            this.f5665de.th(iArr);
        }
        Bitmap bitmap = this.f233switch;
        if (bitmap != null) {
            this.f5665de.qw(bitmap);
        }
        this.f233switch = null;
        this.f5666fe = null;
        this.ddd = null;
        byte[] bArr2 = this.f5670rg;
        if (bArr2 != null) {
            this.f5665de.rg(bArr2);
        }
    }

    public final Bitmap ddd(qw qwVar, qw qwVar2) {
        int i2;
        int i3;
        Bitmap bitmap;
        int[] iArr = this.f5668o;
        int i4 = 0;
        if (qwVar2 == null) {
            Bitmap bitmap2 = this.f233switch;
            if (bitmap2 != null) {
                this.f5665de.qw(bitmap2);
            }
            this.f233switch = null;
            Arrays.fill(iArr, 0);
        }
        if (qwVar2 != null && qwVar2.f5683yj == 3 && this.f233switch == null) {
            Arrays.fill(iArr, 0);
        }
        if (qwVar2 != null && (i3 = qwVar2.f5683yj) > 0) {
            if (i3 == 2) {
                if (!qwVar.f5681th) {
                    ad adVar = this.f232if;
                    int i5 = adVar.f230if;
                    if (qwVar.f5679pf == null || adVar.f5655o != qwVar.f5682uk) {
                        i4 = i5;
                    }
                }
                int i6 = qwVar2.f5676fe;
                int i7 = this.ggg;
                int i8 = i6 / i7;
                int i9 = qwVar2.f5674ad / i7;
                int i10 = qwVar2.f5675de / i7;
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
            } else if (i3 == 3 && (bitmap = this.f233switch) != null) {
                int i17 = this.xxx;
                bitmap.getPixels(iArr, 0, i17, 0, 0, i17, this.vvv);
            }
        }
        m372switch(qwVar);
        if (qwVar.f5680rg || this.ggg != 1) {
            pf(qwVar);
        } else {
            m371if(qwVar);
        }
        if (this.when && ((i2 = qwVar.f5683yj) == 0 || i2 == 1)) {
            if (this.f233switch == null) {
                this.f233switch = ppp();
            }
            Bitmap bitmap3 = this.f233switch;
            int i18 = this.xxx;
            bitmap3.setPixels(iArr, 0, i18, 0, 0, i18, this.vvv);
        }
        Bitmap ppp2 = ppp();
        int i19 = this.xxx;
        ppp2.setPixels(iArr, 0, i19, 0, 0, i19, this.vvv);
        return ppp2;
    }

    public int de() {
        return this.f232if.f5652de;
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
        return this.f5666fe;
    }

    public final int ggg() {
        int vvv2 = vvv();
        if (vvv2 <= 0) {
            return vvv2;
        }
        ByteBuffer byteBuffer = this.f5666fe;
        byteBuffer.get(this.f5670rg, 0, Math.min(vvv2, byteBuffer.remaining()));
        return vvv2;
    }

    public int i() {
        int i2 = this.f232if.f231switch;
        if (i2 == -1) {
            return 1;
        }
        if (i2 == 0) {
            return 0;
        }
        return i2 + 1;
    }

    /* renamed from: if  reason: not valid java name */
    public final void m371if(qw qwVar) {
        qw qwVar2 = qwVar;
        int[] iArr = this.f5668o;
        int i2 = qwVar2.f5676fe;
        int i3 = qwVar2.f5674ad;
        int i4 = qwVar2.f5675de;
        int i5 = qwVar2.qw;
        boolean z = this.f5669pf == 0;
        int i6 = this.xxx;
        byte[] bArr = this.f5667i;
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
            int i12 = qwVar2.f5675de * i7;
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
        Boolean bool = this.ddd;
        this.ddd = Boolean.valueOf((bool != null && bool.booleanValue()) || (this.ddd == null && z && b != -1));
    }

    @ColorInt
    public final int o(int i2, int i3, int i4) {
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = i2; i10 < this.ggg + i2; i10++) {
            byte[] bArr = this.f5667i;
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
            byte[] bArr2 = this.f5667i;
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

    public final void pf(qw qwVar) {
        boolean z;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        qw qwVar2 = qwVar;
        int[] iArr = this.f5668o;
        int i7 = qwVar2.f5676fe;
        int i8 = this.ggg;
        int i9 = i7 / i8;
        int i10 = qwVar2.f5674ad / i8;
        int i11 = qwVar2.f5675de / i8;
        int i12 = qwVar2.qw / i8;
        boolean z2 = this.f5669pf == 0;
        int i13 = this.ggg;
        int i14 = this.xxx;
        int i15 = this.vvv;
        byte[] bArr = this.f5667i;
        int[] iArr2 = this.qw;
        Boolean bool = this.ddd;
        int i16 = 8;
        int i17 = 0;
        int i18 = 0;
        int i19 = 1;
        while (i17 < i9) {
            Boolean bool2 = bool;
            if (qwVar2.f5680rg) {
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
                int i26 = i17 * i13 * qwVar2.f5675de;
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
                        int o2 = o(i26, i30, qwVar2.f5675de);
                        if (o2 != 0) {
                            iArr[i31] = o2;
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

    public final Bitmap ppp() {
        Boolean bool = this.ddd;
        Bitmap de2 = this.f5665de.de(this.xxx, this.vvv, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.nn);
        de2.setHasAlpha(true);
        return de2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00db, code lost:
        return null;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized android.graphics.Bitmap qw() {
        /*
            r8 = this;
            monitor-enter(r8)
            fe.uk.qw.o.ad r0 = r8.f232if     // Catch:{ all -> 0x00dc }
            int r0 = r0.f5652de     // Catch:{ all -> 0x00dc }
            r1 = 3
            r2 = 1
            if (r0 <= 0) goto L_0x000d
            int r0 = r8.f5669pf     // Catch:{ all -> 0x00dc }
            if (r0 >= 0) goto L_0x0035
        L_0x000d:
            java.lang.String r0 = mmm     // Catch:{ all -> 0x00dc }
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00dc }
            if (r0 == 0) goto L_0x0033
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00dc }
            r0.<init>()     // Catch:{ all -> 0x00dc }
            java.lang.String r3 = "Unable to decode frame, frameCount="
            r0.append(r3)     // Catch:{ all -> 0x00dc }
            fe.uk.qw.o.ad r3 = r8.f232if     // Catch:{ all -> 0x00dc }
            int r3 = r3.f5652de     // Catch:{ all -> 0x00dc }
            r0.append(r3)     // Catch:{ all -> 0x00dc }
            java.lang.String r3 = ", framePointer="
            r0.append(r3)     // Catch:{ all -> 0x00dc }
            int r3 = r8.f5669pf     // Catch:{ all -> 0x00dc }
            r0.append(r3)     // Catch:{ all -> 0x00dc }
            r0.toString()     // Catch:{ all -> 0x00dc }
        L_0x0033:
            r8.ppp = r2     // Catch:{ all -> 0x00dc }
        L_0x0035:
            int r0 = r8.ppp     // Catch:{ all -> 0x00dc }
            r3 = 0
            if (r0 == r2) goto L_0x00c0
            int r0 = r8.ppp     // Catch:{ all -> 0x00dc }
            r4 = 2
            if (r0 != r4) goto L_0x0041
            goto L_0x00c0
        L_0x0041:
            r0 = 0
            r8.ppp = r0     // Catch:{ all -> 0x00dc }
            byte[] r5 = r8.f5670rg     // Catch:{ all -> 0x00dc }
            if (r5 != 0) goto L_0x0052
            com.dxmbumptech.glide.gifdecoder.GifDecoder$BitmapProvider r5 = r8.f5665de     // Catch:{ all -> 0x00dc }
            r6 = 255(0xff, float:3.57E-43)
            byte[] r5 = r5.ad(r6)     // Catch:{ all -> 0x00dc }
            r8.f5670rg = r5     // Catch:{ all -> 0x00dc }
        L_0x0052:
            fe.uk.qw.o.ad r5 = r8.f232if     // Catch:{ all -> 0x00dc }
            java.util.List<fe.uk.qw.o.qw> r5 = r5.f5657rg     // Catch:{ all -> 0x00dc }
            int r6 = r8.f5669pf     // Catch:{ all -> 0x00dc }
            java.lang.Object r5 = r5.get(r6)     // Catch:{ all -> 0x00dc }
            fe.uk.qw.o.qw r5 = (fe.uk.qw.o.qw) r5     // Catch:{ all -> 0x00dc }
            int r6 = r8.f5669pf     // Catch:{ all -> 0x00dc }
            int r6 = r6 - r2
            if (r6 < 0) goto L_0x006e
            fe.uk.qw.o.ad r7 = r8.f232if     // Catch:{ all -> 0x00dc }
            java.util.List<fe.uk.qw.o.qw> r7 = r7.f5657rg     // Catch:{ all -> 0x00dc }
            java.lang.Object r6 = r7.get(r6)     // Catch:{ all -> 0x00dc }
            fe.uk.qw.o.qw r6 = (fe.uk.qw.o.qw) r6     // Catch:{ all -> 0x00dc }
            goto L_0x006f
        L_0x006e:
            r6 = r3
        L_0x006f:
            int[] r7 = r5.f5679pf     // Catch:{ all -> 0x00dc }
            if (r7 == 0) goto L_0x0076
            int[] r7 = r5.f5679pf     // Catch:{ all -> 0x00dc }
            goto L_0x007a
        L_0x0076:
            fe.uk.qw.o.ad r7 = r8.f232if     // Catch:{ all -> 0x00dc }
            int[] r7 = r7.qw     // Catch:{ all -> 0x00dc }
        L_0x007a:
            r8.qw = r7     // Catch:{ all -> 0x00dc }
            if (r7 != 0) goto L_0x009c
            java.lang.String r0 = mmm     // Catch:{ all -> 0x00dc }
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00dc }
            if (r0 == 0) goto L_0x0098
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00dc }
            r0.<init>()     // Catch:{ all -> 0x00dc }
            java.lang.String r1 = "No valid color table found for frame #"
            r0.append(r1)     // Catch:{ all -> 0x00dc }
            int r1 = r8.f5669pf     // Catch:{ all -> 0x00dc }
            r0.append(r1)     // Catch:{ all -> 0x00dc }
            r0.toString()     // Catch:{ all -> 0x00dc }
        L_0x0098:
            r8.ppp = r2     // Catch:{ all -> 0x00dc }
            monitor-exit(r8)
            return r3
        L_0x009c:
            boolean r1 = r5.f5681th     // Catch:{ all -> 0x00dc }
            if (r1 == 0) goto L_0x00ba
            int[] r1 = r8.f5664ad     // Catch:{ all -> 0x00dc }
            int r2 = r7.length     // Catch:{ all -> 0x00dc }
            java.lang.System.arraycopy(r7, r0, r1, r0, r2)     // Catch:{ all -> 0x00dc }
            int[] r1 = r8.f5664ad     // Catch:{ all -> 0x00dc }
            r8.qw = r1     // Catch:{ all -> 0x00dc }
            int r2 = r5.f5682uk     // Catch:{ all -> 0x00dc }
            r1[r2] = r0     // Catch:{ all -> 0x00dc }
            int r0 = r5.f5683yj     // Catch:{ all -> 0x00dc }
            if (r0 != r4) goto L_0x00ba
            int r0 = r8.f5669pf     // Catch:{ all -> 0x00dc }
            if (r0 != 0) goto L_0x00ba
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00dc }
            r8.ddd = r0     // Catch:{ all -> 0x00dc }
        L_0x00ba:
            android.graphics.Bitmap r0 = r8.ddd(r5, r6)     // Catch:{ all -> 0x00dc }
            monitor-exit(r8)
            return r0
        L_0x00c0:
            java.lang.String r0 = mmm     // Catch:{ all -> 0x00dc }
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00dc }
            if (r0 == 0) goto L_0x00da
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00dc }
            r0.<init>()     // Catch:{ all -> 0x00dc }
            java.lang.String r1 = "Unable to decode frame, status="
            r0.append(r1)     // Catch:{ all -> 0x00dc }
            int r1 = r8.ppp     // Catch:{ all -> 0x00dc }
            r0.append(r1)     // Catch:{ all -> 0x00dc }
            r0.toString()     // Catch:{ all -> 0x00dc }
        L_0x00da:
            monitor-exit(r8)
            return r3
        L_0x00dc:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.uk.qw.o.fe.qw():android.graphics.Bitmap");
    }

    public int rg() {
        int i2;
        if (this.f232if.f5652de <= 0 || (i2 = this.f5669pf) < 0) {
            return 0;
        }
        return when(i2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v15, resolved type: byte} */
    /* JADX WARNING: Incorrect type for immutable var: ssa=short, code=int, for r7v13, types: [short] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: switch  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m372switch(fe.uk.qw.o.qw r29) {
        /*
            r28 = this;
            r0 = r28
            r1 = r29
            if (r1 == 0) goto L_0x000d
            java.nio.ByteBuffer r2 = r0.f5666fe
            int r3 = r1.f5678o
            r2.position(r3)
        L_0x000d:
            if (r1 != 0) goto L_0x0016
            fe.uk.qw.o.ad r1 = r0.f232if
            int r2 = r1.f5658th
            int r1 = r1.f5660yj
            goto L_0x001a
        L_0x0016:
            int r2 = r1.f5675de
            int r1 = r1.f5676fe
        L_0x001a:
            int r2 = r2 * r1
            byte[] r1 = r0.f5667i
            if (r1 == 0) goto L_0x0023
            int r1 = r1.length
            if (r1 >= r2) goto L_0x002b
        L_0x0023:
            com.dxmbumptech.glide.gifdecoder.GifDecoder$BitmapProvider r1 = r0.f5665de
            byte[] r1 = r1.ad(r2)
            r0.f5667i = r1
        L_0x002b:
            byte[] r1 = r0.f5667i
            short[] r3 = r0.f5671th
            r4 = 4096(0x1000, float:5.74E-42)
            if (r3 != 0) goto L_0x0037
            short[] r3 = new short[r4]
            r0.f5671th = r3
        L_0x0037:
            short[] r3 = r0.f5671th
            byte[] r5 = r0.f5673yj
            if (r5 != 0) goto L_0x0041
            byte[] r5 = new byte[r4]
            r0.f5673yj = r5
        L_0x0041:
            byte[] r5 = r0.f5673yj
            byte[] r6 = r0.f5672uk
            if (r6 != 0) goto L_0x004d
            r6 = 4097(0x1001, float:5.741E-42)
            byte[] r6 = new byte[r6]
            r0.f5672uk = r6
        L_0x004d:
            byte[] r6 = r0.f5672uk
            int r7 = r28.vvv()
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
            byte[] r14 = r0.f5670rg
            r15 = -1
            r23 = r7
            r21 = r11
            r24 = r12
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r22 = -1
            r25 = 0
            r26 = 0
        L_0x0083:
            if (r13 >= r2) goto L_0x014c
            if (r16 != 0) goto L_0x0094
            int r16 = r28.ggg()
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
            r15 = r22
            r0 = r23
            r22 = r7
            r7 = r26
        L_0x00ae:
            if (r4 < r0) goto L_0x0136
            r23 = r11
            r11 = r19 & r24
            int r19 = r19 >> r0
            int r4 = r4 - r0
            if (r11 != r9) goto L_0x00c2
            r24 = r12
            r0 = r22
            r8 = r23
            r11 = r8
            r15 = -1
            goto L_0x00ae
        L_0x00c2:
            if (r11 != r10) goto L_0x00d9
            r18 = r4
            r26 = r7
            r21 = r8
            r7 = r22
            r11 = r23
            r4 = 4096(0x1000, float:5.74E-42)
            r8 = 1
            r23 = r0
            r22 = r15
            r15 = -1
            r0 = r28
            goto L_0x0083
        L_0x00d9:
            r26 = r4
            r4 = -1
            if (r15 != r4) goto L_0x00ed
            byte r7 = r5[r11]
            r1[r20] = r7
            int r20 = r20 + 1
            int r13 = r13 + 1
            r7 = r11
            r15 = r7
            r11 = r23
            r4 = r26
            goto L_0x00ae
        L_0x00ed:
            if (r11 < r8) goto L_0x00f6
            byte r7 = (byte) r7
            r6[r25] = r7
            int r25 = r25 + 1
            r7 = r15
            goto L_0x00f7
        L_0x00f6:
            r7 = r11
        L_0x00f7:
            if (r7 < r9) goto L_0x0102
            byte r21 = r5[r7]
            r6[r25] = r21
            int r25 = r25 + 1
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
            if (r25 <= 0) goto L_0x0116
            int r25 = r25 + -1
            byte r27 = r6[r25]
            r1[r20] = r27
            goto L_0x0109
        L_0x0116:
            r27 = r6
            r6 = 4096(0x1000, float:5.74E-42)
            if (r8 >= r6) goto L_0x012d
            short r15 = (short) r15
            r3[r8] = r15
            r5[r8] = r4
            int r8 = r8 + 1
            r4 = r8 & r24
            if (r4 != 0) goto L_0x012d
            if (r8 >= r6) goto L_0x012d
            int r0 = r0 + 1
            int r24 = r24 + r8
        L_0x012d:
            r15 = r11
            r11 = r23
            r4 = r26
            r6 = r27
            goto L_0x00ae
        L_0x0136:
            r26 = r4
            r23 = r0
            r21 = r8
            r18 = r26
            r4 = 4096(0x1000, float:5.74E-42)
            r8 = 1
            r0 = r28
            r26 = r7
            r7 = r22
            r22 = r15
            r15 = -1
            goto L_0x0083
        L_0x014c:
            r13 = r20
            r0 = 0
            java.util.Arrays.fill(r1, r13, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.uk.qw.o.fe.m372switch(fe.uk.qw.o.qw):void");
    }

    public void th() {
        this.f5669pf = -1;
    }

    public int uk() {
        return this.f5666fe.limit() + this.f5667i.length + (this.f5668o.length * 4);
    }

    public final int vvv() {
        return this.f5666fe.get() & 255;
    }

    public int when(int i2) {
        if (i2 >= 0) {
            ad adVar = this.f232if;
            if (i2 < adVar.f5652de) {
                return adVar.f5657rg.get(i2).f5677i;
            }
        }
        return -1;
    }

    public synchronized void xxx(@NonNull ad adVar, @NonNull ByteBuffer byteBuffer, int i2) {
        if (i2 > 0) {
            int highestOneBit = Integer.highestOneBit(i2);
            this.ppp = 0;
            this.f232if = adVar;
            this.f5669pf = -1;
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.f5666fe = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            this.f5666fe.order(ByteOrder.LITTLE_ENDIAN);
            this.when = false;
            Iterator<qw> it = adVar.f5657rg.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().f5683yj == 3) {
                        this.when = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            this.ggg = highestOneBit;
            this.xxx = adVar.f5658th / highestOneBit;
            this.vvv = adVar.f5660yj / highestOneBit;
            this.f5667i = this.f5665de.ad(adVar.f5658th * adVar.f5660yj);
            this.f5668o = this.f5665de.fe(this.xxx * this.vvv);
        } else {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i2);
        }
    }

    public int yj() {
        return this.f5669pf;
    }

    public fe(@NonNull GifDecoder.BitmapProvider bitmapProvider) {
        this.f5664ad = new int[256];
        this.nn = Bitmap.Config.ARGB_8888;
        this.f5665de = bitmapProvider;
        this.f232if = new ad();
    }
}
