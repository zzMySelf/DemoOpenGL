package fe.uk.qw.o;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.common.base.Ascii;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class de {

    /* renamed from: ad  reason: collision with root package name */
    public ByteBuffer f5661ad;

    /* renamed from: de  reason: collision with root package name */
    public ad f5662de;

    /* renamed from: fe  reason: collision with root package name */
    public int f5663fe = 0;
    public final byte[] qw = new byte[256];

    public final boolean ad() {
        return this.f5662de.f5651ad != 0;
    }

    @NonNull
    public ad de() {
        if (this.f5661ad == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        } else if (ad()) {
            return this.f5662de;
        } else {
            pf();
            if (!ad()) {
                uk();
                ad adVar = this.f5662de;
                if (adVar.f5652de < 0) {
                    adVar.f5651ad = 1;
                }
            }
            return this.f5662de;
        }
    }

    public final int fe() {
        try {
            return this.f5661ad.get() & 255;
        } catch (Exception unused) {
            this.f5662de.f5651ad = 1;
            return 0;
        }
    }

    public de ggg(@NonNull ByteBuffer byteBuffer) {
        ppp();
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f5661ad = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.f5661ad.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public final void i(int i2) {
        boolean z = false;
        while (!z && !ad() && this.f5662de.f5652de <= i2) {
            int fe2 = fe();
            if (fe2 == 33) {
                int fe3 = fe();
                if (fe3 == 1) {
                    vvv();
                } else if (fe3 == 249) {
                    this.f5662de.f5653fe = new qw();
                    o();
                } else if (fe3 == 254) {
                    vvv();
                } else if (fe3 != 255) {
                    vvv();
                } else {
                    th();
                    StringBuilder sb = new StringBuilder();
                    for (int i3 = 0; i3 < 11; i3++) {
                        sb.append((char) this.qw[i3]);
                    }
                    if (sb.toString().equals("NETSCAPE2.0")) {
                        m370switch();
                    } else {
                        vvv();
                    }
                }
            } else if (fe2 == 44) {
                ad adVar = this.f5662de;
                if (adVar.f5653fe == null) {
                    adVar.f5653fe = new qw();
                }
                rg();
            } else if (fe2 != 59) {
                this.f5662de.f5651ad = 1;
            } else {
                z = true;
            }
        }
    }

    /* renamed from: if  reason: not valid java name */
    public final void m369if() {
        this.f5662de.f5658th = when();
        this.f5662de.f5660yj = when();
        int fe2 = fe();
        this.f5662de.f5659uk = (fe2 & 128) != 0;
        this.f5662de.f5654i = (int) Math.pow(2.0d, (double) ((fe2 & 7) + 1));
        this.f5662de.f5655o = fe();
        this.f5662de.f5656pf = fe();
    }

    public final void o() {
        fe();
        int fe2 = fe();
        qw qwVar = this.f5662de.f5653fe;
        int i2 = (fe2 & 28) >> 2;
        qwVar.f5683yj = i2;
        boolean z = true;
        if (i2 == 0) {
            qwVar.f5683yj = 1;
        }
        qw qwVar2 = this.f5662de.f5653fe;
        if ((fe2 & 1) == 0) {
            z = false;
        }
        qwVar2.f5681th = z;
        int when = when();
        if (when < 2) {
            when = 10;
        }
        qw qwVar3 = this.f5662de.f5653fe;
        qwVar3.f5677i = when * 10;
        qwVar3.f5682uk = fe();
        fe();
    }

    public final void pf() {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 6; i2++) {
            sb.append((char) fe());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.f5662de.f5651ad = 1;
            return;
        }
        m369if();
        if (this.f5662de.f5659uk && !ad()) {
            ad adVar = this.f5662de;
            adVar.qw = yj(adVar.f5654i);
            ad adVar2 = this.f5662de;
            adVar2.f230if = adVar2.qw[adVar2.f5655o];
        }
    }

    public final void ppp() {
        this.f5661ad = null;
        Arrays.fill(this.qw, (byte) 0);
        this.f5662de = new ad();
        this.f5663fe = 0;
    }

    public void qw() {
        this.f5661ad = null;
        this.f5662de = null;
    }

    public final void rg() {
        this.f5662de.f5653fe.qw = when();
        this.f5662de.f5653fe.f5674ad = when();
        this.f5662de.f5653fe.f5675de = when();
        this.f5662de.f5653fe.f5676fe = when();
        int fe2 = fe();
        boolean z = false;
        boolean z2 = (fe2 & 128) != 0;
        int pow = (int) Math.pow(2.0d, (double) ((fe2 & 7) + 1));
        qw qwVar = this.f5662de.f5653fe;
        if ((fe2 & 64) != 0) {
            z = true;
        }
        qwVar.f5680rg = z;
        if (z2) {
            this.f5662de.f5653fe.f5679pf = yj(pow);
        } else {
            this.f5662de.f5653fe.f5679pf = null;
        }
        this.f5662de.f5653fe.f5678o = this.f5661ad.position();
        xxx();
        if (!ad()) {
            ad adVar = this.f5662de;
            adVar.f5652de++;
            adVar.f5657rg.add(adVar.f5653fe);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* renamed from: switch  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m370switch() {
        /*
            r3 = this;
        L_0x0000:
            r3.th()
            byte[] r0 = r3.qw
            r1 = 0
            byte r1 = r0[r1]
            r2 = 1
            if (r1 != r2) goto L_0x001b
            byte r1 = r0[r2]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r2 = 2
            byte r0 = r0[r2]
            r0 = r0 & 255(0xff, float:3.57E-43)
            fe.uk.qw.o.ad r2 = r3.f5662de
            int r0 = r0 << 8
            r0 = r0 | r1
            r2.f231switch = r0
        L_0x001b:
            int r0 = r3.f5663fe
            if (r0 <= 0) goto L_0x0025
            boolean r0 = r3.ad()
            if (r0 == 0) goto L_0x0000
        L_0x0025:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.uk.qw.o.de.m370switch():void");
    }

    public final void th() {
        int fe2 = fe();
        this.f5663fe = fe2;
        if (fe2 > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.f5663fe) {
                try {
                    i3 = this.f5663fe - i2;
                    this.f5661ad.get(this.qw, i2, i3);
                    i2 += i3;
                } catch (Exception unused) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        "Error Reading Block n: " + i2 + " count: " + i3 + " blockSize: " + this.f5663fe;
                    }
                    this.f5662de.f5651ad = 1;
                    return;
                }
            }
        }
    }

    public final void uk() {
        i(Integer.MAX_VALUE);
    }

    public final void vvv() {
        int fe2;
        do {
            fe2 = fe();
            this.f5661ad.position(Math.min(this.f5661ad.position() + fe2, this.f5661ad.limit()));
        } while (fe2 > 0);
    }

    public final int when() {
        return this.f5661ad.getShort();
    }

    public final void xxx() {
        fe();
        vvv();
    }

    @Nullable
    public final int[] yj(int i2) {
        byte[] bArr = new byte[(i2 * 3)];
        int[] iArr = null;
        try {
            this.f5661ad.get(bArr);
            iArr = new int[256];
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2) {
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                int i7 = i6 + 1;
                int i8 = i3 + 1;
                iArr[i3] = ((bArr[i4] & 255) << Ascii.DLE) | -16777216 | ((bArr[i5] & 255) << 8) | (bArr[i6] & 255);
                i4 = i7;
                i3 = i8;
            }
        } catch (BufferUnderflowException unused) {
            boolean isLoggable = Log.isLoggable("GifHeaderParser", 3);
            this.f5662de.f5651ad = 1;
        }
        return iArr;
    }
}
