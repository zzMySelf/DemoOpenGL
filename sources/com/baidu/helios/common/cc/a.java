package com.baidu.helios.common.cc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.LongBuffer;
import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class a implements Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f13068a = true;

    /* renamed from: b  reason: collision with root package name */
    private static final int f13069b = 6;

    /* renamed from: c  reason: collision with root package name */
    private static final int f13070c = 64;

    /* renamed from: d  reason: collision with root package name */
    private static final int f13071d = 63;

    /* renamed from: e  reason: collision with root package name */
    private static final long f13072e = -1;

    /* renamed from: f  reason: collision with root package name */
    private static final ObjectStreamField[] f13073f = {new ObjectStreamField("bits", long[].class)};

    /* renamed from: j  reason: collision with root package name */
    private static final long f13074j = 7997698588986878753L;

    /* renamed from: g  reason: collision with root package name */
    private long[] f13075g;

    /* renamed from: h  reason: collision with root package name */
    private transient int f13076h = 0;

    /* renamed from: i  reason: collision with root package name */
    private transient boolean f13077i = false;

    public a() {
        j(64);
        this.f13077i = false;
    }

    public a(int i2) {
        if (i2 >= 0) {
            j(i2);
            this.f13077i = true;
            return;
        }
        throw new NegativeArraySizeException("nbits < 0: " + i2);
    }

    private a(long[] jArr) {
        this.f13075g = jArr;
        this.f13076h = jArr.length;
        h();
    }

    public static a a(ByteBuffer byteBuffer) {
        ByteBuffer order = byteBuffer.slice().order(ByteOrder.LITTLE_ENDIAN);
        int remaining = order.remaining();
        while (remaining > 0 && order.get(remaining - 1) == 0) {
            remaining--;
        }
        long[] jArr = new long[((remaining + 7) / 8)];
        order.limit(remaining);
        int i2 = 0;
        while (order.remaining() >= 8) {
            jArr[i2] = order.getLong();
            i2++;
        }
        int remaining2 = order.remaining();
        for (int i3 = 0; i3 < remaining2; i3++) {
            jArr[i2] = jArr[i2] | ((((long) order.get()) & 255) << (i3 * 8));
        }
        return new a(jArr);
    }

    public static a a(LongBuffer longBuffer) {
        LongBuffer slice = longBuffer.slice();
        int remaining = slice.remaining();
        while (remaining > 0 && slice.get(remaining - 1) == 0) {
            remaining--;
        }
        long[] jArr = new long[remaining];
        slice.get(jArr);
        return new a(jArr);
    }

    public static a a(byte[] bArr) {
        return a(ByteBuffer.wrap(bArr));
    }

    public static a a(long[] jArr) {
        int length = jArr.length;
        while (length > 0 && jArr[length - 1] == 0) {
            length--;
        }
        return new a(Arrays.copyOf(jArr, length));
    }

    private void a(ObjectInputStream objectInputStream) {
        long[] jArr = (long[]) objectInputStream.readFields().get("bits", (Object) null);
        this.f13075g = jArr;
        this.f13076h = jArr.length;
        i();
        long[] jArr2 = this.f13075g;
        boolean z = true;
        if (jArr2.length <= 0 || jArr2[jArr2.length - 1] != 0) {
            z = false;
        }
        this.f13077i = z;
        h();
    }

    private void a(ObjectOutputStream objectOutputStream) {
        h();
        if (!this.f13077i) {
            j();
        }
        objectOutputStream.putFields().put("bits", this.f13075g);
        objectOutputStream.writeFields();
    }

    private static void e(int i2, int i3) {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("fromIndex < 0: " + i2);
        } else if (i3 < 0) {
            throw new IndexOutOfBoundsException("toIndex < 0: " + i3);
        } else if (i2 > i3) {
            throw new IndexOutOfBoundsException("fromIndex: " + i2 + " > toIndex: " + i3);
        }
    }

    private void h() {
        int i2;
        int i3;
        boolean z = f13068a;
        if (!z && (i3 = this.f13076h) != 0 && this.f13075g[i3 - 1] == 0) {
            throw new AssertionError();
        } else if (!z && ((i2 = this.f13076h) < 0 || i2 > this.f13075g.length)) {
            throw new AssertionError();
        } else if (!z) {
            int i4 = this.f13076h;
            long[] jArr = this.f13075g;
            if (i4 != jArr.length && jArr[i4] != 0) {
                throw new AssertionError();
            }
        }
    }

    private static int i(int i2) {
        return i2 >> 6;
    }

    private void i() {
        int i2 = this.f13076h - 1;
        while (i2 >= 0 && this.f13075g[i2] == 0) {
            i2--;
        }
        this.f13076h = i2 + 1;
    }

    private void j() {
        int i2 = this.f13076h;
        long[] jArr = this.f13075g;
        if (i2 != jArr.length) {
            this.f13075g = Arrays.copyOf(jArr, i2);
            h();
        }
    }

    private void j(int i2) {
        this.f13075g = new long[(i(i2 - 1) + 1)];
    }

    private void k(int i2) {
        long[] jArr = this.f13075g;
        if (jArr.length < i2) {
            this.f13075g = Arrays.copyOf(this.f13075g, Math.max(jArr.length * 2, i2));
            this.f13077i = false;
        }
    }

    private void l(int i2) {
        int i3 = i2 + 1;
        if (this.f13076h < i3) {
            k(i3);
            this.f13076h = i3;
        }
    }

    public void a(int i2) {
        if (i2 >= 0) {
            int i3 = i(i2);
            l(i3);
            long[] jArr = this.f13075g;
            jArr[i3] = jArr[i3] ^ (1 << i2);
            i();
            h();
            return;
        }
        throw new IndexOutOfBoundsException("bitIndex < 0: " + i2);
    }

    public void a(int i2, int i3) {
        e(i2, i3);
        if (i2 != i3) {
            int i4 = i(i2);
            int i5 = i(i3 - 1);
            l(i5);
            long j2 = -1 << i2;
            long j3 = -1 >>> (-i3);
            if (i4 == i5) {
                long[] jArr = this.f13075g;
                jArr[i4] = (j3 & j2) ^ jArr[i4];
            } else {
                long[] jArr2 = this.f13075g;
                jArr2[i4] = jArr2[i4] ^ j2;
                while (true) {
                    i4++;
                    if (i4 >= i5) {
                        break;
                    }
                    long[] jArr3 = this.f13075g;
                    jArr3[i4] = ~jArr3[i4];
                }
                long[] jArr4 = this.f13075g;
                jArr4[i5] = j3 ^ jArr4[i5];
            }
            i();
            h();
        }
    }

    public void a(int i2, int i3, boolean z) {
        if (z) {
            b(i2, i3);
        } else {
            c(i2, i3);
        }
    }

    public void a(int i2, boolean z) {
        if (z) {
            b(i2);
        } else {
            c(i2);
        }
    }

    public boolean a(a aVar) {
        for (int min = Math.min(this.f13076h, aVar.f13076h) - 1; min >= 0; min--) {
            if ((this.f13075g[min] & aVar.f13075g[min]) != 0) {
                return true;
            }
        }
        return false;
    }

    public byte[] a() {
        int i2 = this.f13076h;
        if (i2 == 0) {
            return new byte[0];
        }
        int i3 = i2 - 1;
        int i4 = i3 * 8;
        for (long j2 = this.f13075g[i3]; j2 != 0; j2 >>>= 8) {
            i4++;
        }
        byte[] bArr = new byte[i4];
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        for (int i5 = 0; i5 < i3; i5++) {
            order.putLong(this.f13075g[i5]);
        }
        for (long j3 = this.f13075g[i3]; j3 != 0; j3 >>>= 8) {
            order.put((byte) ((int) (255 & j3)));
        }
        return bArr;
    }

    public void b(int i2) {
        if (i2 >= 0) {
            int i3 = i(i2);
            l(i3);
            long[] jArr = this.f13075g;
            jArr[i3] = jArr[i3] | (1 << i2);
            h();
            return;
        }
        throw new IndexOutOfBoundsException("bitIndex < 0: " + i2);
    }

    public void b(int i2, int i3) {
        e(i2, i3);
        if (i2 != i3) {
            int i4 = i(i2);
            int i5 = i(i3 - 1);
            l(i5);
            long j2 = -1 << i2;
            long j3 = -1 >>> (-i3);
            if (i4 == i5) {
                long[] jArr = this.f13075g;
                jArr[i4] = (j3 & j2) | jArr[i4];
            } else {
                long[] jArr2 = this.f13075g;
                jArr2[i4] = j2 | jArr2[i4];
                while (true) {
                    i4++;
                    if (i4 >= i5) {
                        break;
                    }
                    this.f13075g[i4] = -1;
                }
                long[] jArr3 = this.f13075g;
                jArr3[i5] = j3 | jArr3[i5];
            }
            h();
        }
    }

    public void b(a aVar) {
        if (this != aVar) {
            while (true) {
                int i2 = this.f13076h;
                if (i2 <= aVar.f13076h) {
                    break;
                }
                long[] jArr = this.f13075g;
                int i3 = i2 - 1;
                this.f13076h = i3;
                jArr[i3] = 0;
            }
            for (int i4 = 0; i4 < this.f13076h; i4++) {
                long[] jArr2 = this.f13075g;
                jArr2[i4] = jArr2[i4] & aVar.f13075g[i4];
            }
            i();
            h();
        }
    }

    public long[] b() {
        return Arrays.copyOf(this.f13075g, this.f13076h);
    }

    public void c() {
        while (true) {
            int i2 = this.f13076h;
            if (i2 > 0) {
                long[] jArr = this.f13075g;
                int i3 = i2 - 1;
                this.f13076h = i3;
                jArr[i3] = 0;
            } else {
                return;
            }
        }
    }

    public void c(int i2) {
        if (i2 >= 0) {
            int i3 = i(i2);
            if (i3 < this.f13076h) {
                long[] jArr = this.f13075g;
                jArr[i3] = jArr[i3] & (~(1 << i2));
                i();
                h();
                return;
            }
            return;
        }
        throw new IndexOutOfBoundsException("bitIndex < 0: " + i2);
    }

    public void c(int i2, int i3) {
        int i4;
        e(i2, i3);
        if (i2 != i3 && (i4 = i(i2)) < this.f13076h) {
            int i5 = i(i3 - 1);
            if (i5 >= this.f13076h) {
                i3 = d();
                i5 = this.f13076h - 1;
            }
            long j2 = -1 << i2;
            long j3 = -1 >>> (-i3);
            if (i4 == i5) {
                long[] jArr = this.f13075g;
                jArr[i4] = (~(j3 & j2)) & jArr[i4];
            } else {
                long[] jArr2 = this.f13075g;
                jArr2[i4] = (~j2) & jArr2[i4];
                while (true) {
                    i4++;
                    if (i4 >= i5) {
                        break;
                    }
                    this.f13075g[i4] = 0;
                }
                long[] jArr3 = this.f13075g;
                jArr3[i5] = (~j3) & jArr3[i5];
            }
            i();
            h();
        }
    }

    public void c(a aVar) {
        if (this != aVar) {
            int min = Math.min(this.f13076h, aVar.f13076h);
            int i2 = this.f13076h;
            int i3 = aVar.f13076h;
            if (i2 < i3) {
                k(i3);
                this.f13076h = aVar.f13076h;
            }
            for (int i4 = 0; i4 < min; i4++) {
                long[] jArr = this.f13075g;
                jArr[i4] = jArr[i4] | aVar.f13075g[i4];
            }
            if (min < aVar.f13076h) {
                System.arraycopy(aVar.f13075g, min, this.f13075g, min, this.f13076h - min);
            }
            h();
        }
    }

    public Object clone() {
        if (!this.f13077i) {
            j();
        }
        try {
            a aVar = (a) super.clone();
            aVar.f13075g = (long[]) this.f13075g.clone();
            aVar.h();
            return aVar;
        } catch (CloneNotSupportedException e2) {
            throw new InternalError();
        }
    }

    public int d() {
        int i2 = this.f13076h;
        if (i2 == 0) {
            return 0;
        }
        return ((i2 - 1) * 64) + (64 - Long.numberOfLeadingZeros(this.f13075g[i2 - 1]));
    }

    public a d(int i2, int i3) {
        int i4;
        long j2;
        e(i2, i3);
        h();
        int d2 = d();
        int i5 = 0;
        if (d2 <= i2 || i2 == i3) {
            return new a(0);
        }
        if (i3 > d2) {
            i3 = d2;
        }
        int i6 = i3 - i2;
        a aVar = new a(i6);
        int i7 = i(i6 - 1) + 1;
        int i8 = i(i2);
        int i9 = i2 & 63;
        boolean z = i9 == 0;
        while (true) {
            i4 = i7 - 1;
            if (i5 >= i4) {
                break;
            }
            long[] jArr = aVar.f13075g;
            long[] jArr2 = this.f13075g;
            jArr[i5] = z ? jArr2[i8] : (jArr2[i8] >>> i2) | (jArr2[i8 + 1] << (-i2));
            i5++;
            i8++;
        }
        long j3 = -1 >>> (-i3);
        long[] jArr3 = aVar.f13075g;
        if (((i3 - 1) & 63) < i9) {
            long[] jArr4 = this.f13075g;
            j2 = ((jArr4[i8 + 1] & j3) << (-i2)) | (jArr4[i8] >>> i2);
        } else {
            j2 = (this.f13075g[i8] & j3) >>> i2;
        }
        jArr3[i4] = j2;
        aVar.f13076h = i7;
        aVar.i();
        aVar.h();
        return aVar;
    }

    public void d(a aVar) {
        int min = Math.min(this.f13076h, aVar.f13076h);
        int i2 = this.f13076h;
        int i3 = aVar.f13076h;
        if (i2 < i3) {
            k(i3);
            this.f13076h = aVar.f13076h;
        }
        for (int i4 = 0; i4 < min; i4++) {
            long[] jArr = this.f13075g;
            jArr[i4] = jArr[i4] ^ aVar.f13075g[i4];
        }
        int i5 = aVar.f13076h;
        if (min < i5) {
            System.arraycopy(aVar.f13075g, min, this.f13075g, min, i5 - min);
        }
        i();
        h();
    }

    public boolean d(int i2) {
        if (i2 >= 0) {
            h();
            int i3 = i(i2);
            return i3 < this.f13076h && (this.f13075g[i3] & (1 << i2)) != 0;
        }
        throw new IndexOutOfBoundsException("bitIndex < 0: " + i2);
    }

    public int e(int i2) {
        if (i2 >= 0) {
            h();
            int i3 = i(i2);
            if (i3 >= this.f13076h) {
                return -1;
            }
            long j2 = this.f13075g[i3] & (-1 << i2);
            while (j2 == 0) {
                i3++;
                if (i3 == this.f13076h) {
                    return -1;
                }
                j2 = this.f13075g[i3];
            }
            return (i3 * 64) + Long.numberOfTrailingZeros(j2);
        }
        throw new IndexOutOfBoundsException("fromIndex < 0: " + i2);
    }

    public void e(a aVar) {
        for (int min = Math.min(this.f13076h, aVar.f13076h) - 1; min >= 0; min--) {
            long[] jArr = this.f13075g;
            jArr[min] = jArr[min] & (~aVar.f13075g[min]);
        }
        i();
        h();
    }

    public boolean e() {
        return this.f13076h == 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        a aVar = (a) obj;
        h();
        aVar.h();
        if (this.f13076h != aVar.f13076h) {
            return false;
        }
        for (int i2 = 0; i2 < this.f13076h; i2++) {
            if (this.f13075g[i2] != aVar.f13075g[i2]) {
                return false;
            }
        }
        return true;
    }

    public int f() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f13076h; i3++) {
            i2 += Long.bitCount(this.f13075g[i3]);
        }
        return i2;
    }

    public int f(int i2) {
        if (i2 >= 0) {
            h();
            int i3 = i(i2);
            if (i3 >= this.f13076h) {
                return i2;
            }
            long j2 = (~this.f13075g[i3]) & (-1 << i2);
            while (j2 == 0) {
                i3++;
                int i4 = this.f13076h;
                if (i3 == i4) {
                    return i4 * 64;
                }
                j2 = ~this.f13075g[i3];
            }
            return (i3 * 64) + Long.numberOfTrailingZeros(j2);
        }
        throw new IndexOutOfBoundsException("fromIndex < 0: " + i2);
    }

    public int g() {
        return this.f13075g.length * 64;
    }

    public int g(int i2) {
        if (i2 >= 0) {
            h();
            int i3 = i(i2);
            if (i3 >= this.f13076h) {
                return d() - 1;
            }
            long j2 = this.f13075g[i3] & (-1 >>> (-(i2 + 1)));
            while (j2 == 0) {
                int i4 = i3 - 1;
                if (i3 == 0) {
                    return -1;
                }
                j2 = this.f13075g[i4];
                i3 = i4;
            }
            return (((i3 + 1) * 64) - 1) - Long.numberOfLeadingZeros(j2);
        } else if (i2 == -1) {
            return -1;
        } else {
            throw new IndexOutOfBoundsException("fromIndex < -1: " + i2);
        }
    }

    public int h(int i2) {
        if (i2 >= 0) {
            h();
            int i3 = i(i2);
            if (i3 >= this.f13076h) {
                return i2;
            }
            long j2 = (~this.f13075g[i3]) & (-1 >>> (-(i2 + 1)));
            while (j2 == 0) {
                int i4 = i3 - 1;
                if (i3 == 0) {
                    return -1;
                }
                j2 = ~this.f13075g[i4];
                i3 = i4;
            }
            return (((i3 + 1) * 64) - 1) - Long.numberOfLeadingZeros(j2);
        } else if (i2 == -1) {
            return -1;
        } else {
            throw new IndexOutOfBoundsException("fromIndex < -1: " + i2);
        }
    }

    public int hashCode() {
        int i2 = this.f13076h;
        long j2 = 1234;
        while (true) {
            i2--;
            if (i2 < 0) {
                return (int) ((j2 >> 32) ^ j2);
            }
            j2 ^= this.f13075g[i2] * ((long) (i2 + 1));
        }
    }

    public String toString() {
        h();
        int i2 = this.f13076h;
        StringBuilder sb = new StringBuilder(((i2 > 128 ? f() : i2 * 64) * 6) + 2);
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        int e2 = e(0);
        if (e2 != -1) {
            sb.append(e2);
            while (true) {
                e2 = e(e2 + 1);
                if (e2 < 0) {
                    break;
                }
                int f2 = f(e2);
                do {
                    sb.append(", ").append(e2);
                    e2++;
                } while (e2 < f2);
            }
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }
}
