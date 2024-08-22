package kotlin.comparisons;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0005\n\u0002\u0010\u0012\n\u0002\u0010\u0006\n\u0002\u0010\u0013\n\u0002\u0010\u0007\n\u0002\u0010\u0014\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\u0010\t\n\u0002\u0010\u0016\n\u0002\u0010\n\n\u0002\u0010\u0017\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0005\u001a5\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u0006\u0010\u0006\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0007\u001a9\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\t\"\u0002H\u0001H\u0007¢\u0006\u0002\u0010\n\u001a\u0019\u0010\u0000\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000bH\b\u001a!\u0010\u0000\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000bH\b\u001a\u001c\u0010\u0000\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\n\u0010\b\u001a\u00020\f\"\u00020\u000bH\u0007\u001a\u0019\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\rH\b\u001a!\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\b\u001a\u001c\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\n\u0010\b\u001a\u00020\u000e\"\u00020\rH\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000fH\b\u001a!\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000fH\b\u001a\u001c\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\n\u0010\b\u001a\u00020\u0010\"\u00020\u000fH\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0011H\b\u001a!\u0010\u0000\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0011H\b\u001a\u001c\u0010\u0000\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\n\u0010\b\u001a\u00020\u0012\"\u00020\u0011H\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0013H\b\u001a!\u0010\u0000\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0013H\b\u001a\u001c\u0010\u0000\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\n\u0010\b\u001a\u00020\u0014\"\u00020\u0013H\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0015H\b\u001a!\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\b\u001a\u001c\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\n\u0010\b\u001a\u00020\u0016\"\u00020\u0015H\u0007\u001a-\u0010\u0017\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0005\u001a5\u0010\u0017\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u0006\u0010\u0006\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0007\u001a9\u0010\u0017\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\t\"\u0002H\u0001H\u0007¢\u0006\u0002\u0010\n\u001a\u0019\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000bH\b\u001a!\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000bH\b\u001a\u001c\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\n\u0010\b\u001a\u00020\f\"\u00020\u000bH\u0007\u001a\u0019\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\rH\b\u001a!\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\b\u001a\u001c\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\n\u0010\b\u001a\u00020\u000e\"\u00020\rH\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000fH\b\u001a!\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000fH\b\u001a\u001c\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\n\u0010\b\u001a\u00020\u0010\"\u00020\u000fH\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0011H\b\u001a!\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0011H\b\u001a\u001c\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\n\u0010\b\u001a\u00020\u0012\"\u00020\u0011H\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0013H\b\u001a!\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0013H\b\u001a\u001c\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\n\u0010\b\u001a\u00020\u0014\"\u00020\u0013H\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0015H\b\u001a!\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\b\u001a\u001c\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\n\u0010\b\u001a\u00020\u0016\"\u00020\u0015H\u0007¨\u0006\u0018"}, d2 = {"maxOf", "T", "", "a", "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "c", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "other", "", "(Ljava/lang/Comparable;[Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "", "", "", "", "", "", "", "", "", "", "", "minOf", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/comparisons/ComparisonsKt")
public class ComparisonsKt___ComparisonsJvmKt extends ComparisonsKt__ComparisonsKt {
    @NotNull
    @SinceKotlin(version = "1.1")
    public static final <T extends Comparable<? super T>> T maxOf(@NotNull T t, @NotNull T t2) {
        Intrinsics.checkNotNullParameter(t, "a");
        Intrinsics.checkNotNullParameter(t2, "b");
        return t.compareTo(t2) >= 0 ? t : t2;
    }

    @NotNull
    @SinceKotlin(version = "1.1")
    public static final <T extends Comparable<? super T>> T minOf(@NotNull T t, @NotNull T t2) {
        Intrinsics.checkNotNullParameter(t, "a");
        Intrinsics.checkNotNullParameter(t2, "b");
        return t.compareTo(t2) <= 0 ? t : t2;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final byte maxOf(byte b, byte b2) {
        return (byte) Math.max(b, b2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final byte minOf(byte b, byte b2) {
        return (byte) Math.min(b, b2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final short maxOf(short s, short s2) {
        return (short) Math.max(s, s2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final short minOf(short s, short s2) {
        return (short) Math.min(s, s2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final int maxOf(int i2, int i3) {
        return Math.max(i2, i3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final int minOf(int i2, int i3) {
        return Math.min(i2, i3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final long maxOf(long j, long j2) {
        return Math.max(j, j2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final long minOf(long j, long j2) {
        return Math.min(j, j2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final float maxOf(float f, float f2) {
        return Math.max(f, f2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final float minOf(float f, float f2) {
        return Math.min(f, f2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final double maxOf(double d, double d2) {
        return Math.max(d, d2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final double minOf(double d, double d2) {
        return Math.min(d, d2);
    }

    @NotNull
    @SinceKotlin(version = "1.1")
    public static final <T extends Comparable<? super T>> T maxOf(@NotNull T t, @NotNull T t2, @NotNull T t3) {
        Intrinsics.checkNotNullParameter(t, "a");
        Intrinsics.checkNotNullParameter(t2, "b");
        Intrinsics.checkNotNullParameter(t3, "c");
        return maxOf(t, (T) maxOf(t2, t3));
    }

    @NotNull
    @SinceKotlin(version = "1.1")
    public static final <T extends Comparable<? super T>> T minOf(@NotNull T t, @NotNull T t2, @NotNull T t3) {
        Intrinsics.checkNotNullParameter(t, "a");
        Intrinsics.checkNotNullParameter(t2, "b");
        Intrinsics.checkNotNullParameter(t3, "c");
        return minOf(t, (T) minOf(t2, t3));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final byte maxOf(byte b, byte b2, byte b3) {
        return (byte) Math.max(b, Math.max(b2, b3));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final byte minOf(byte b, byte b2, byte b3) {
        return (byte) Math.min(b, Math.min(b2, b3));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final short maxOf(short s, short s2, short s3) {
        return (short) Math.max(s, Math.max(s2, s3));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final short minOf(short s, short s2, short s3) {
        return (short) Math.min(s, Math.min(s2, s3));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final int maxOf(int i2, int i3, int i4) {
        return Math.max(i2, Math.max(i3, i4));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final int minOf(int i2, int i3, int i4) {
        return Math.min(i2, Math.min(i3, i4));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final long maxOf(long j, long j2, long j3) {
        return Math.max(j, Math.max(j2, j3));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final long minOf(long j, long j2, long j3) {
        return Math.min(j, Math.min(j2, j3));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final float maxOf(float f, float f2, float f3) {
        return Math.max(f, Math.max(f2, f3));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final float minOf(float f, float f2, float f3) {
        return Math.min(f, Math.min(f2, f3));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final double maxOf(double d, double d2, double d3) {
        return Math.max(d, Math.max(d2, d3));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final double minOf(double d, double d2, double d3) {
        return Math.min(d, Math.min(d2, d3));
    }

    @NotNull
    @SinceKotlin(version = "1.4")
    public static final <T extends Comparable<? super T>> T maxOf(@NotNull T t, @NotNull T... tArr) {
        Intrinsics.checkNotNullParameter(t, "a");
        Intrinsics.checkNotNullParameter(tArr, "other");
        for (T maxOf : tArr) {
            t = maxOf(t, maxOf);
        }
        return t;
    }

    @NotNull
    @SinceKotlin(version = "1.4")
    public static final <T extends Comparable<? super T>> T minOf(@NotNull T t, @NotNull T... tArr) {
        Intrinsics.checkNotNullParameter(t, "a");
        Intrinsics.checkNotNullParameter(tArr, "other");
        for (T minOf : tArr) {
            t = minOf(t, minOf);
        }
        return t;
    }

    @SinceKotlin(version = "1.4")
    public static final byte maxOf(byte b, @NotNull byte... bArr) {
        Intrinsics.checkNotNullParameter(bArr, "other");
        for (byte max : bArr) {
            b = (byte) Math.max(b, max);
        }
        return b;
    }

    @SinceKotlin(version = "1.4")
    public static final byte minOf(byte b, @NotNull byte... bArr) {
        Intrinsics.checkNotNullParameter(bArr, "other");
        for (byte min : bArr) {
            b = (byte) Math.min(b, min);
        }
        return b;
    }

    @SinceKotlin(version = "1.4")
    public static final short maxOf(short s, @NotNull short... sArr) {
        Intrinsics.checkNotNullParameter(sArr, "other");
        for (short max : sArr) {
            s = (short) Math.max(s, max);
        }
        return s;
    }

    @SinceKotlin(version = "1.4")
    public static final short minOf(short s, @NotNull short... sArr) {
        Intrinsics.checkNotNullParameter(sArr, "other");
        for (short min : sArr) {
            s = (short) Math.min(s, min);
        }
        return s;
    }

    @SinceKotlin(version = "1.4")
    public static final int maxOf(int i2, @NotNull int... iArr) {
        Intrinsics.checkNotNullParameter(iArr, "other");
        for (int max : iArr) {
            i2 = Math.max(i2, max);
        }
        return i2;
    }

    @SinceKotlin(version = "1.4")
    public static final int minOf(int i2, @NotNull int... iArr) {
        Intrinsics.checkNotNullParameter(iArr, "other");
        for (int min : iArr) {
            i2 = Math.min(i2, min);
        }
        return i2;
    }

    @SinceKotlin(version = "1.4")
    public static final long maxOf(long j, @NotNull long... jArr) {
        Intrinsics.checkNotNullParameter(jArr, "other");
        for (long max : jArr) {
            j = Math.max(j, max);
        }
        return j;
    }

    @SinceKotlin(version = "1.4")
    public static final long minOf(long j, @NotNull long... jArr) {
        Intrinsics.checkNotNullParameter(jArr, "other");
        for (long min : jArr) {
            j = Math.min(j, min);
        }
        return j;
    }

    @SinceKotlin(version = "1.4")
    public static final float maxOf(float f, @NotNull float... fArr) {
        Intrinsics.checkNotNullParameter(fArr, "other");
        for (float max : fArr) {
            f = Math.max(f, max);
        }
        return f;
    }

    @SinceKotlin(version = "1.4")
    public static final float minOf(float f, @NotNull float... fArr) {
        Intrinsics.checkNotNullParameter(fArr, "other");
        for (float min : fArr) {
            f = Math.min(f, min);
        }
        return f;
    }

    @SinceKotlin(version = "1.4")
    public static final double maxOf(double d, @NotNull double... dArr) {
        Intrinsics.checkNotNullParameter(dArr, "other");
        for (double max : dArr) {
            d = Math.max(d, max);
        }
        return d;
    }

    @SinceKotlin(version = "1.4")
    public static final double minOf(double d, @NotNull double... dArr) {
        Intrinsics.checkNotNullParameter(dArr, "other");
        for (double min : dArr) {
            d = Math.min(d, min);
        }
        return d;
    }
}
