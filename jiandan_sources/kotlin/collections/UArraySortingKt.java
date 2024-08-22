package kotlin.collections;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0014\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0016\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010\u0018\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\u001a\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"partition", "", "array", "Lkotlin/UByteArray;", "left", "right", "partition-4UcCI2c", "([BII)I", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "quickSort-oBK06Vg", "([III)V", "quickSort--nroSd4", "([JII)V", "quickSort-Aa5vz7o", "([SII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-oBK06Vg", "sortArray--nroSd4", "sortArray-Aa5vz7o", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class UArraySortingKt {
    @ExperimentalUnsignedTypes
    /* renamed from: partition--nroSd4  reason: not valid java name */
    public static final int m1598partitionnroSd4(long[] jArr, int i2, int i3) {
        long j = ULongArray.m1386getsVKNKU(jArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (UnsignedKt.ulongCompare(ULongArray.m1386getsVKNKU(jArr, i2), j) < 0) {
                i2++;
            }
            while (UnsignedKt.ulongCompare(ULongArray.m1386getsVKNKU(jArr, i3), j) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                long j2 = ULongArray.m1386getsVKNKU(jArr, i2);
                ULongArray.m1391setk8EXiF4(jArr, i2, ULongArray.m1386getsVKNKU(jArr, i3));
                ULongArray.m1391setk8EXiF4(jArr, i3, j2);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-4UcCI2c  reason: not valid java name */
    public static final int m1599partition4UcCI2c(byte[] bArr, int i2, int i3) {
        byte b;
        byte b2 = UByteArray.m1230getw2LRezQ(bArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (true) {
                b = b2 & 255;
                if (Intrinsics.compare((int) UByteArray.m1230getw2LRezQ(bArr, i2) & 255, (int) b) >= 0) {
                    break;
                }
                i2++;
            }
            while (Intrinsics.compare((int) UByteArray.m1230getw2LRezQ(bArr, i3) & 255, (int) b) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                byte b3 = UByteArray.m1230getw2LRezQ(bArr, i2);
                UByteArray.m1235setVurrAj0(bArr, i2, UByteArray.m1230getw2LRezQ(bArr, i3));
                UByteArray.m1235setVurrAj0(bArr, i3, b3);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-Aa5vz7o  reason: not valid java name */
    public static final int m1600partitionAa5vz7o(short[] sArr, int i2, int i3) {
        short s;
        short s2 = UShortArray.m1490getMh2AYeg(sArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (true) {
                short s3 = UShortArray.m1490getMh2AYeg(sArr, i2) & UShort.MAX_VALUE;
                s = s2 & UShort.MAX_VALUE;
                if (Intrinsics.compare((int) s3, (int) s) >= 0) {
                    break;
                }
                i2++;
            }
            while (Intrinsics.compare((int) UShortArray.m1490getMh2AYeg(sArr, i3) & UShort.MAX_VALUE, (int) s) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                short s4 = UShortArray.m1490getMh2AYeg(sArr, i2);
                UShortArray.m1495set01HTLdE(sArr, i2, UShortArray.m1490getMh2AYeg(sArr, i3));
                UShortArray.m1495set01HTLdE(sArr, i3, s4);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-oBK06Vg  reason: not valid java name */
    public static final int m1601partitionoBK06Vg(int[] iArr, int i2, int i3) {
        int i4 = UIntArray.m1308getpVg5ArA(iArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (UnsignedKt.uintCompare(UIntArray.m1308getpVg5ArA(iArr, i2), i4) < 0) {
                i2++;
            }
            while (UnsignedKt.uintCompare(UIntArray.m1308getpVg5ArA(iArr, i3), i4) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                int i5 = UIntArray.m1308getpVg5ArA(iArr, i2);
                UIntArray.m1313setVXSXFK8(iArr, i2, UIntArray.m1308getpVg5ArA(iArr, i3));
                UIntArray.m1313setVXSXFK8(iArr, i3, i5);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort--nroSd4  reason: not valid java name */
    public static final void m1602quickSortnroSd4(long[] jArr, int i2, int i3) {
        int r0 = m1598partitionnroSd4(jArr, i2, i3);
        int i4 = r0 - 1;
        if (i2 < i4) {
            m1602quickSortnroSd4(jArr, i2, i4);
        }
        if (r0 < i3) {
            m1602quickSortnroSd4(jArr, r0, i3);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-4UcCI2c  reason: not valid java name */
    public static final void m1603quickSort4UcCI2c(byte[] bArr, int i2, int i3) {
        int r0 = m1599partition4UcCI2c(bArr, i2, i3);
        int i4 = r0 - 1;
        if (i2 < i4) {
            m1603quickSort4UcCI2c(bArr, i2, i4);
        }
        if (r0 < i3) {
            m1603quickSort4UcCI2c(bArr, r0, i3);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-Aa5vz7o  reason: not valid java name */
    public static final void m1604quickSortAa5vz7o(short[] sArr, int i2, int i3) {
        int r0 = m1600partitionAa5vz7o(sArr, i2, i3);
        int i4 = r0 - 1;
        if (i2 < i4) {
            m1604quickSortAa5vz7o(sArr, i2, i4);
        }
        if (r0 < i3) {
            m1604quickSortAa5vz7o(sArr, r0, i3);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-oBK06Vg  reason: not valid java name */
    public static final void m1605quickSortoBK06Vg(int[] iArr, int i2, int i3) {
        int r0 = m1601partitionoBK06Vg(iArr, i2, i3);
        int i4 = r0 - 1;
        if (i2 < i4) {
            m1605quickSortoBK06Vg(iArr, i2, i4);
        }
        if (r0 < i3) {
            m1605quickSortoBK06Vg(iArr, r0, i3);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray--nroSd4  reason: not valid java name */
    public static final void m1606sortArraynroSd4(@NotNull long[] jArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(jArr, "array");
        m1602quickSortnroSd4(jArr, i2, i3 - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-4UcCI2c  reason: not valid java name */
    public static final void m1607sortArray4UcCI2c(@NotNull byte[] bArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(bArr, "array");
        m1603quickSort4UcCI2c(bArr, i2, i3 - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-Aa5vz7o  reason: not valid java name */
    public static final void m1608sortArrayAa5vz7o(@NotNull short[] sArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(sArr, "array");
        m1604quickSortAa5vz7o(sArr, i2, i3 - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-oBK06Vg  reason: not valid java name */
    public static final void m1609sortArrayoBK06Vg(@NotNull int[] iArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "array");
        m1605quickSortoBK06Vg(iArr, i2, i3 - 1);
    }
}
