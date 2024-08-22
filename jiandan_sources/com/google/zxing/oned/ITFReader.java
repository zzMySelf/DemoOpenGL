package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Map;

public final class ITFReader extends OneDReader {
    public static final int[] DEFAULT_ALLOWED_LENGTHS = {6, 8, 10, 12, 14};
    public static final int[][] END_PATTERN_REVERSED = {new int[]{1, 1, 2}, new int[]{1, 1, 3}};
    public static final float MAX_AVG_VARIANCE = 0.38f;
    public static final float MAX_INDIVIDUAL_VARIANCE = 0.5f;
    public static final int N = 1;
    public static final int[][] PATTERNS = {new int[]{1, 1, 2, 2, 1}, new int[]{2, 1, 1, 1, 2}, new int[]{1, 2, 1, 1, 2}, new int[]{2, 2, 1, 1, 1}, new int[]{1, 1, 2, 1, 2}, new int[]{2, 1, 2, 1, 1}, new int[]{1, 2, 2, 1, 1}, new int[]{1, 1, 1, 2, 2}, new int[]{2, 1, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};
    public static final int[] START_PATTERN = {1, 1, 1, 1};
    public static final int W = 3;
    public static final int w = 2;
    public int narrowLineWidth = -1;

    public static int decodeDigit(int[] iArr) throws NotFoundException {
        int length = PATTERNS.length;
        float f = 0.38f;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            float patternMatchVariance = OneDReader.patternMatchVariance(iArr, PATTERNS[i3], 0.5f);
            if (patternMatchVariance < f) {
                i2 = i3;
                f = patternMatchVariance;
            } else if (patternMatchVariance == f) {
                i2 = -1;
            }
        }
        if (i2 >= 0) {
            return i2 % 10;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:6|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        r0 = findGuardPattern(r7, r0, END_PATTERN_REVERSED[1]);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int[] decodeEnd(com.google.zxing.common.BitArray r7) throws com.google.zxing.NotFoundException {
        /*
            r6 = this;
            r7.reverse()
            int r0 = skipWhiteSpace(r7)     // Catch:{ all -> 0x0035 }
            r1 = 1
            r2 = 0
            int[][] r3 = END_PATTERN_REVERSED     // Catch:{ NotFoundException -> 0x0012 }
            r3 = r3[r2]     // Catch:{ NotFoundException -> 0x0012 }
            int[] r0 = findGuardPattern(r7, r0, r3)     // Catch:{ NotFoundException -> 0x0012 }
            goto L_0x001a
        L_0x0012:
            int[][] r3 = END_PATTERN_REVERSED     // Catch:{ all -> 0x0035 }
            r3 = r3[r1]     // Catch:{ all -> 0x0035 }
            int[] r0 = findGuardPattern(r7, r0, r3)     // Catch:{ all -> 0x0035 }
        L_0x001a:
            r3 = r0[r2]     // Catch:{ all -> 0x0035 }
            r6.validateQuietZone(r7, r3)     // Catch:{ all -> 0x0035 }
            r3 = r0[r2]     // Catch:{ all -> 0x0035 }
            int r4 = r7.getSize()     // Catch:{ all -> 0x0035 }
            r5 = r0[r1]     // Catch:{ all -> 0x0035 }
            int r4 = r4 - r5
            r0[r2] = r4     // Catch:{ all -> 0x0035 }
            int r2 = r7.getSize()     // Catch:{ all -> 0x0035 }
            int r2 = r2 - r3
            r0[r1] = r2     // Catch:{ all -> 0x0035 }
            r7.reverse()
            return r0
        L_0x0035:
            r0 = move-exception
            r7.reverse()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.ITFReader.decodeEnd(com.google.zxing.common.BitArray):int[]");
    }

    public static void decodeMiddle(BitArray bitArray, int i2, int i3, StringBuilder sb) throws NotFoundException {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i2 < i3) {
            OneDReader.recordPattern(bitArray, i2, iArr);
            for (int i4 = 0; i4 < 5; i4++) {
                int i5 = i4 * 2;
                iArr2[i4] = iArr[i5];
                iArr3[i4] = iArr[i5 + 1];
            }
            sb.append((char) (decodeDigit(iArr2) + 48));
            sb.append((char) (decodeDigit(iArr3) + 48));
            for (int i6 = 0; i6 < 10; i6++) {
                i2 += iArr[i6];
            }
        }
    }

    private int[] decodeStart(BitArray bitArray) throws NotFoundException {
        int[] findGuardPattern = findGuardPattern(bitArray, skipWhiteSpace(bitArray), START_PATTERN);
        this.narrowLineWidth = (findGuardPattern[1] - findGuardPattern[0]) / 4;
        validateQuietZone(bitArray, findGuardPattern[0]);
        return findGuardPattern;
    }

    public static int[] findGuardPattern(BitArray bitArray, int i2, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int size = bitArray.getSize();
        int i3 = i2;
        boolean z = false;
        int i4 = 0;
        while (i2 < size) {
            if (bitArray.get(i2) != z) {
                iArr2[i4] = iArr2[i4] + 1;
            } else {
                if (i4 != length - 1) {
                    i4++;
                } else if (OneDReader.patternMatchVariance(iArr2, iArr, 0.5f) < 0.38f) {
                    return new int[]{i3, i2};
                } else {
                    i3 += iArr2[0] + iArr2[1];
                    int i5 = i4 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i5);
                    iArr2[i5] = 0;
                    iArr2[i4] = 0;
                    i4--;
                }
                iArr2[i4] = 1;
                z = !z;
            }
            i2++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static int skipWhiteSpace(BitArray bitArray) throws NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        if (nextSet != size) {
            return nextSet;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private void validateQuietZone(BitArray bitArray, int i2) throws NotFoundException {
        int i3 = this.narrowLineWidth * 10;
        if (i3 >= i2) {
            i3 = i2;
        }
        int i4 = i2 - 1;
        while (i3 > 0 && i4 >= 0 && !bitArray.get(i4)) {
            i3--;
            i4--;
        }
        if (i3 != 0) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    public Result decodeRow(int i2, BitArray bitArray, Map<DecodeHintType, ?> map) throws FormatException, NotFoundException {
        boolean z;
        int[] decodeStart = decodeStart(bitArray);
        int[] decodeEnd = decodeEnd(bitArray);
        StringBuilder sb = new StringBuilder(20);
        decodeMiddle(bitArray, decodeStart[1], decodeEnd[0], sb);
        String sb2 = sb.toString();
        int[] iArr = map != null ? (int[]) map.get(DecodeHintType.ALLOWED_LENGTHS) : null;
        if (iArr == null) {
            iArr = DEFAULT_ALLOWED_LENGTHS;
        }
        int length = sb2.length();
        int length2 = iArr.length;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= length2) {
                z = false;
                break;
            }
            int i5 = iArr[i3];
            if (length == i5) {
                z = true;
                break;
            }
            if (i5 > i4) {
                i4 = i5;
            }
            i3++;
        }
        if (!z && length > i4) {
            z = true;
        }
        if (z) {
            float f = (float) i2;
            return new Result(sb2, (byte[]) null, new ResultPoint[]{new ResultPoint((float) decodeStart[1], f), new ResultPoint((float) decodeEnd[0], f)}, BarcodeFormat.ITF);
        }
        throw FormatException.getFormatInstance();
    }
}
