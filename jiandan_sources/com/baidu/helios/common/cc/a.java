package com.baidu.helios.common.cc;

import com.baidu.android.common.others.lang.StringUtil;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.LongBuffer;
import java.util.Arrays;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class a implements Serializable, Cloneable {
    public static final /* synthetic */ boolean a = (!a.class.desiredAssertionStatus());
    public static final int b = 6;
    public static final int c = 64;
    public static final int d = 63;
    public static final long e = -1;
    public static final ObjectStreamField[] f = {new ObjectStreamField("bits", long[].class)};
    public static final long j = 7997698588986878753L;
    public long[] g;
    public transient int h = 0;

    /* renamed from: i  reason: collision with root package name */
    public transient boolean f812i = false;

    public a() {
        j(64);
        this.f812i = false;
    }

    public a(int i2) {
        if (i2 >= 0) {
            j(i2);
            this.f812i = true;
            return;
        }
        throw new NegativeArraySizeException("nbits < 0: " + i2);
    }

    public a(long[] jArr) {
        this.g = jArr;
        this.h = jArr.length;
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
        this.g = jArr;
        this.h = jArr.length;
        i();
        long[] jArr2 = this.g;
        boolean z = true;
        if (jArr2.length <= 0 || jArr2[jArr2.length - 1] != 0) {
            z = false;
        }
        this.f812i = z;
        h();
    }

    private void a(ObjectOutputStream objectOutputStream) {
        h();
        if (!this.f812i) {
            j();
        }
        objectOutputStream.putFields().put("bits", this.g);
        objectOutputStream.writeFields();
    }

    public static void e(int i2, int i3) {
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
        if (!a && (i3 = this.h) != 0 && this.g[i3 - 1] == 0) {
            throw new AssertionError();
        } else if (!a && ((i2 = this.h) < 0 || i2 > this.g.length)) {
            throw new AssertionError();
        } else if (!a) {
            int i4 = this.h;
            long[] jArr = this.g;
            if (i4 != jArr.length && jArr[i4] != 0) {
                throw new AssertionError();
            }
        }
    }

    public static int i(int i2) {
        return i2 >> 6;
    }

    private void i() {
        int i2 = this.h - 1;
        while (i2 >= 0 && this.g[i2] == 0) {
            i2--;
        }
        this.h = i2 + 1;
    }

    private void j() {
        int i2 = this.h;
        long[] jArr = this.g;
        if (i2 != jArr.length) {
            this.g = Arrays.copyOf(jArr, i2);
            h();
        }
    }

    private void j(int i2) {
        this.g = new long[(i(i2 - 1) + 1)];
    }

    private void k(int i2) {
        long[] jArr = this.g;
        if (jArr.length < i2) {
            this.g = Arrays.copyOf(this.g, Math.max(jArr.length * 2, i2));
            this.f812i = false;
        }
    }

    private void l(int i2) {
        int i3 = i2 + 1;
        if (this.h < i3) {
            k(i3);
            this.h = i3;
        }
    }

    public void a(int i2) {
        if (i2 >= 0) {
            int i3 = i(i2);
            l(i3);
            long[] jArr = this.g;
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
                long[] jArr = this.g;
                jArr[i4] = (j3 & j2) ^ jArr[i4];
            } else {
                long[] jArr2 = this.g;
                jArr2[i4] = jArr2[i4] ^ j2;
                while (true) {
                    i4++;
                    if (i4 >= i5) {
                        break;
                    }
                    long[] jArr3 = this.g;
                    jArr3[i4] = ~jArr3[i4];
                }
                long[] jArr4 = this.g;
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
        for (int min = Math.min(this.h, aVar.h) - 1; min >= 0; min--) {
            if ((this.g[min] & aVar.g[min]) != 0) {
                return true;
            }
        }
        return false;
    }

    public byte[] a() {
        int i2 = this.h;
        if (i2 == 0) {
            return new byte[0];
        }
        int i3 = i2 - 1;
        int i4 = i3 * 8;
        for (long j2 = this.g[i3]; j2 != 0; j2 >>>= 8) {
            i4++;
        }
        byte[] bArr = new byte[i4];
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        for (int i5 = 0; i5 < i3; i5++) {
            order.putLong(this.g[i5]);
        }
        for (long j3 = this.g[i3]; j3 != 0; j3 >>>= 8) {
            order.put((byte) ((int) (255 & j3)));
        }
        return bArr;
    }

    public void b(int i2) {
        if (i2 >= 0) {
            int i3 = i(i2);
            l(i3);
            long[] jArr = this.g;
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
                long[] jArr = this.g;
                jArr[i4] = (j3 & j2) | jArr[i4];
            } else {
                long[] jArr2 = this.g;
                jArr2[i4] = j2 | jArr2[i4];
                while (true) {
                    i4++;
                    if (i4 >= i5) {
                        break;
                    }
                    this.g[i4] = -1;
                }
                long[] jArr3 = this.g;
                jArr3[i5] = j3 | jArr3[i5];
            }
            h();
        }
    }

    public void b(a aVar) {
        if (this != aVar) {
            while (true) {
                int i2 = this.h;
                if (i2 <= aVar.h) {
                    break;
                }
                long[] jArr = this.g;
                int i3 = i2 - 1;
                this.h = i3;
                jArr[i3] = 0;
            }
            for (int i4 = 0; i4 < this.h; i4++) {
                long[] jArr2 = this.g;
                jArr2[i4] = jArr2[i4] & aVar.g[i4];
            }
            i();
            h();
        }
    }

    public long[] b() {
        return Arrays.copyOf(this.g, this.h);
    }

    public void c() {
        while (true) {
            int i2 = this.h;
            if (i2 > 0) {
                long[] jArr = this.g;
                int i3 = i2 - 1;
                this.h = i3;
                jArr[i3] = 0;
            } else {
                return;
            }
        }
    }

    public void c(int i2) {
        if (i2 >= 0) {
            int i3 = i(i2);
            if (i3 < this.h) {
                long[] jArr = this.g;
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
        if (i2 != i3 && (i4 = i(i2)) < this.h) {
            int i5 = i(i3 - 1);
            if (i5 >= this.h) {
                i3 = d();
                i5 = this.h - 1;
            }
            long j2 = -1 << i2;
            long j3 = -1 >>> (-i3);
            if (i4 == i5) {
                long[] jArr = this.g;
                jArr[i4] = (~(j3 & j2)) & jArr[i4];
            } else {
                long[] jArr2 = this.g;
                jArr2[i4] = (~j2) & jArr2[i4];
                while (true) {
                    i4++;
                    if (i4 >= i5) {
                        break;
                    }
                    this.g[i4] = 0;
                }
                long[] jArr3 = this.g;
                jArr3[i5] = (~j3) & jArr3[i5];
            }
            i();
            h();
        }
    }

    public void c(a aVar) {
        if (this != aVar) {
            int min = Math.min(this.h, aVar.h);
            int i2 = this.h;
            int i3 = aVar.h;
            if (i2 < i3) {
                k(i3);
                this.h = aVar.h;
            }
            for (int i4 = 0; i4 < min; i4++) {
                long[] jArr = this.g;
                jArr[i4] = jArr[i4] | aVar.g[i4];
            }
            if (min < aVar.h) {
                System.arraycopy(aVar.g, min, this.g, min, this.h - min);
            }
            h();
        }
    }

    public Object clone() {
        if (!this.f812i) {
            j();
        }
        try {
            a aVar = (a) super.clone();
            aVar.g = (long[]) this.g.clone();
            aVar.h();
            return aVar;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public int d() {
        int i2 = this.h;
        if (i2 == 0) {
            return 0;
        }
        return ((i2 - 1) * 64) + (64 - Long.numberOfLeadingZeros(this.g[i2 - 1]));
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
            long[] jArr = aVar.g;
            long[] jArr2 = this.g;
            jArr[i5] = z ? jArr2[i8] : (jArr2[i8] >>> i2) | (jArr2[i8 + 1] << (-i2));
            i5++;
            i8++;
        }
        long j3 = -1 >>> (-i3);
        long[] jArr3 = aVar.g;
        if (((i3 - 1) & 63) < i9) {
            long[] jArr4 = this.g;
            j2 = ((jArr4[i8 + 1] & j3) << (-i2)) | (jArr4[i8] >>> i2);
        } else {
            j2 = (this.g[i8] & j3) >>> i2;
        }
        jArr3[i4] = j2;
        aVar.h = i7;
        aVar.i();
        aVar.h();
        return aVar;
    }

    public void d(a aVar) {
        int min = Math.min(this.h, aVar.h);
        int i2 = this.h;
        int i3 = aVar.h;
        if (i2 < i3) {
            k(i3);
            this.h = aVar.h;
        }
        for (int i4 = 0; i4 < min; i4++) {
            long[] jArr = this.g;
            jArr[i4] = jArr[i4] ^ aVar.g[i4];
        }
        int i5 = aVar.h;
        if (min < i5) {
            System.arraycopy(aVar.g, min, this.g, min, i5 - min);
        }
        i();
        h();
    }

    public boolean d(int i2) {
        if (i2 >= 0) {
            h();
            int i3 = i(i2);
            return i3 < this.h && (this.g[i3] & (1 << i2)) != 0;
        }
        throw new IndexOutOfBoundsException("bitIndex < 0: " + i2);
    }

    public int e(int i2) {
        if (i2 >= 0) {
            h();
            int i3 = i(i2);
            if (i3 >= this.h) {
                return -1;
            }
            long j2 = this.g[i3] & (-1 << i2);
            while (j2 == 0) {
                i3++;
                if (i3 == this.h) {
                    return -1;
                }
                j2 = this.g[i3];
            }
            return (i3 * 64) + Long.numberOfTrailingZeros(j2);
        }
        throw new IndexOutOfBoundsException("fromIndex < 0: " + i2);
    }

    public void e(a aVar) {
        for (int min = Math.min(this.h, aVar.h) - 1; min >= 0; min--) {
            long[] jArr = this.g;
            jArr[min] = jArr[min] & (~aVar.g[min]);
        }
        i();
        h();
    }

    public boolean e() {
        return this.h == 0;
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
        if (this.h != aVar.h) {
            return false;
        }
        for (int i2 = 0; i2 < this.h; i2++) {
            if (this.g[i2] != aVar.g[i2]) {
                return false;
            }
        }
        return true;
    }

    public int f() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.h; i3++) {
            i2 += Long.bitCount(this.g[i3]);
        }
        return i2;
    }

    public int f(int i2) {
        if (i2 >= 0) {
            h();
            int i3 = i(i2);
            if (i3 >= this.h) {
                return i2;
            }
            long j2 = (~this.g[i3]) & (-1 << i2);
            while (j2 == 0) {
                i3++;
                int i4 = this.h;
                if (i3 == i4) {
                    return i4 * 64;
                }
                j2 = ~this.g[i3];
            }
            return (i3 * 64) + Long.numberOfTrailingZeros(j2);
        }
        throw new IndexOutOfBoundsException("fromIndex < 0: " + i2);
    }

    public int g() {
        return this.g.length * 64;
    }

    public int g(int i2) {
        if (i2 >= 0) {
            h();
            int i3 = i(i2);
            if (i3 >= this.h) {
                return d() - 1;
            }
            long j2 = this.g[i3] & (-1 >>> (-(i2 + 1)));
            while (j2 == 0) {
                int i4 = i3 - 1;
                if (i3 == 0) {
                    return -1;
                }
                j2 = this.g[i4];
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
            if (i3 >= this.h) {
                return i2;
            }
            long j2 = (~this.g[i3]) & (-1 >>> (-(i2 + 1)));
            while (j2 == 0) {
                int i4 = i3 - 1;
                if (i3 == 0) {
                    return -1;
                }
                j2 = ~this.g[i4];
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
        int i2 = this.h;
        long j2 = 1234;
        while (true) {
            i2--;
            if (i2 < 0) {
                return (int) ((j2 >> 32) ^ j2);
            }
            j2 ^= this.g[i2] * ((long) (i2 + 1));
        }
    }

    public String toString() {
        h();
        int i2 = this.h;
        StringBuilder sb = new StringBuilder(((i2 > 128 ? f() : i2 * 64) * 6) + 2);
        sb.append(ExtendedMessageFormat.START_FE);
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
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    sb.append(e2);
                    e2++;
                } while (e2 < f2);
            }
        }
        sb.append(ExtendedMessageFormat.END_FE);
        return sb.toString();
    }
}
