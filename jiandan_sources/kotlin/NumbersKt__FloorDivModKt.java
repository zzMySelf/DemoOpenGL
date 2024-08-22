package kotlin;

import com.google.common.base.Ascii;
import kotlin.internal.InlineOnly;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\t\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0005H\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0001H\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0005H\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0001H\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\b\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\b\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\b\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0015\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\b\u001a\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0007H\b\u001a\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\bH\b\u001a\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H\b\u001a\u0015\u0010\u0006\u001a\u00020\b*\u00020\b2\u0006\u0010\u0003\u001a\u00020\bH\b\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\b\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\b\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0015\u0010\u0006\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0005H\b\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\b\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0001H\b\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0015\u0010\u0006\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0005H\b\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\b\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0001H\b\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0015\u0010\u0006\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\b¨\u0006\t"}, d2 = {"floorDiv", "", "", "other", "", "", "mod", "", "", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/NumbersKt")
public class NumbersKt__FloorDivModKt extends NumbersKt__BigIntegersKt {
    @SinceKotlin(version = "1.5")
    @InlineOnly
    public static final int floorDiv(byte b, byte b2) {
        int i2 = b / b2;
        return ((b ^ b2) >= 0 || b2 * i2 == b) ? i2 : i2 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    public static final byte mod(byte b, byte b2) {
        int i2 = b % b2;
        return (byte) (i2 + (b2 & (((i2 ^ b2) & ((-i2) | i2)) >> Ascii.US)));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    public static final int floorDiv(byte b, short s) {
        int i2 = b / s;
        return ((b ^ s) >= 0 || s * i2 == b) ? i2 : i2 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    public static final short mod(byte b, short s) {
        int i2 = b % s;
        return (short) (i2 + (s & (((i2 ^ s) & ((-i2) | i2)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    public static final int floorDiv(byte b, int i2) {
        int i3 = b / i2;
        return ((b ^ i2) >= 0 || i2 * i3 == b) ? i3 : i3 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    public static final int mod(byte b, int i2) {
        int i3 = b % i2;
        return i3 + (i2 & (((i3 ^ i2) & ((-i3) | i3)) >> 31));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    public static final long floorDiv(byte b, long j) {
        long j2 = (long) b;
        long j3 = j2 / j;
        return ((j2 ^ j) >= 0 || j * j3 == j2) ? j3 : j3 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    public static final long mod(byte b, long j) {
        long j2 = ((long) b) % j;
        return j2 + (j & (((j2 ^ j) & ((-j2) | j2)) >> 63));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    public static final int floorDiv(short s, byte b) {
        int i2 = s / b;
        return ((s ^ b) >= 0 || b * i2 == s) ? i2 : i2 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    public static final byte mod(short s, byte b) {
        int i2 = s % b;
        return (byte) (i2 + (b & (((i2 ^ b) & ((-i2) | i2)) >> Ascii.US)));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    public static final int floorDiv(short s, short s2) {
        int i2 = s / s2;
        return ((s ^ s2) >= 0 || s2 * i2 == s) ? i2 : i2 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    public static final short mod(short s, short s2) {
        int i2 = s % s2;
        return (short) (i2 + (s2 & (((i2 ^ s2) & ((-i2) | i2)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    public static final int floorDiv(short s, int i2) {
        int i3 = s / i2;
        return ((s ^ i2) >= 0 || i2 * i3 == s) ? i3 : i3 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    public static final int mod(short s, int i2) {
        int i3 = s % i2;
        return i3 + (i2 & (((i3 ^ i2) & ((-i3) | i3)) >> 31));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    public static final long floorDiv(short s, long j) {
        long j2 = (long) s;
        long j3 = j2 / j;
        return ((j2 ^ j) >= 0 || j * j3 == j2) ? j3 : j3 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    public static final long mod(short s, long j) {
        long j2 = ((long) s) % j;
        return j2 + (j & (((j2 ^ j) & ((-j2) | j2)) >> 63));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    public static final int floorDiv(int i2, byte b) {
        int i3 = i2 / b;
        return ((i2 ^ b) >= 0 || b * i3 == i2) ? i3 : i3 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    public static final byte mod(int i2, byte b) {
        int i3 = i2 % b;
        return (byte) (i3 + (b & (((i3 ^ b) & ((-i3) | i3)) >> Ascii.US)));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    public static final int floorDiv(int i2, short s) {
        int i3 = i2 / s;
        return ((i2 ^ s) >= 0 || s * i3 == i2) ? i3 : i3 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    public static final short mod(int i2, short s) {
        int i3 = i2 % s;
        return (short) (i3 + (s & (((i3 ^ s) & ((-i3) | i3)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    public static final int floorDiv(int i2, int i3) {
        int i4 = i2 / i3;
        return ((i2 ^ i3) >= 0 || i3 * i4 == i2) ? i4 : i4 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    public static final int mod(int i2, int i3) {
        int i4 = i2 % i3;
        return i4 + (i3 & (((i4 ^ i3) & ((-i4) | i4)) >> 31));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    public static final long floorDiv(int i2, long j) {
        long j2 = (long) i2;
        long j3 = j2 / j;
        return ((j2 ^ j) >= 0 || j * j3 == j2) ? j3 : j3 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    public static final long mod(int i2, long j) {
        long j2 = ((long) i2) % j;
        return j2 + (j & (((j2 ^ j) & ((-j2) | j2)) >> 63));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    public static final long floorDiv(long j, byte b) {
        long j2 = (long) b;
        long j3 = j / j2;
        return ((j ^ j2) >= 0 || j2 * j3 == j) ? j3 : j3 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    public static final byte mod(long j, byte b) {
        long j2 = (long) b;
        long j3 = j % j2;
        return (byte) ((int) (j3 + (j2 & (((j3 ^ j2) & ((-j3) | j3)) >> 63))));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    public static final long floorDiv(long j, short s) {
        long j2 = (long) s;
        long j3 = j / j2;
        return ((j ^ j2) >= 0 || j2 * j3 == j) ? j3 : j3 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    public static final short mod(long j, short s) {
        long j2 = (long) s;
        long j3 = j % j2;
        return (short) ((int) (j3 + (j2 & (((j3 ^ j2) & ((-j3) | j3)) >> 63))));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    public static final long floorDiv(long j, int i2) {
        long j2 = (long) i2;
        long j3 = j / j2;
        return ((j ^ j2) >= 0 || j2 * j3 == j) ? j3 : j3 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    public static final int mod(long j, int i2) {
        long j2 = (long) i2;
        long j3 = j % j2;
        return (int) (j3 + (j2 & (((j3 ^ j2) & ((-j3) | j3)) >> 63)));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    public static final long floorDiv(long j, long j2) {
        long j3 = j / j2;
        return ((j ^ j2) >= 0 || j2 * j3 == j) ? j3 : j3 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    public static final long mod(long j, long j2) {
        long j3 = j % j2;
        return j3 + (j2 & (((j3 ^ j2) & ((-j3) | j3)) >> 63));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    public static final float mod(float f, float f2) {
        float f3 = f % f2;
        boolean z = true;
        if (f3 == 0.0f) {
            return f3;
        }
        if (Math.signum(f3) != Math.signum(f2)) {
            z = false;
        }
        return !z ? f3 + f2 : f3;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    public static final double mod(float f, double d) {
        double d2 = ((double) f) % d;
        boolean z = true;
        if (d2 == 0.0d) {
            return d2;
        }
        if (Math.signum(d2) != Math.signum(d)) {
            z = false;
        }
        return !z ? d2 + d : d2;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    public static final double mod(double d, float f) {
        double d2 = (double) f;
        double d3 = d % d2;
        boolean z = true;
        if (d3 == 0.0d) {
            return d3;
        }
        if (Math.signum(d3) != Math.signum(d2)) {
            z = false;
        }
        return !z ? d3 + d2 : d3;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    public static final double mod(double d, double d2) {
        double d3 = d % d2;
        boolean z = true;
        if (d3 == 0.0d) {
            return d3;
        }
        if (Math.signum(d3) != Math.signum(d2)) {
            z = false;
        }
        return !z ? d3 + d2 : d3;
    }
}
