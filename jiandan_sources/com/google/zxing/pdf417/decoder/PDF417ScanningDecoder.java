package com.google.zxing.pdf417.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.pdf417.PDF417Common;
import com.google.zxing.pdf417.decoder.ec.ErrorCorrection;
import java.lang.reflect.Array;
import java.util.ArrayList;

public final class PDF417ScanningDecoder {
    public static final int CODEWORD_SKEW_SIZE = 2;
    public static final int MAX_EC_CODEWORDS = 512;
    public static final int MAX_ERRORS = 3;
    public static final ErrorCorrection errorCorrection = new ErrorCorrection();

    public static BoundingBox adjustBoundingBox(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn) throws NotFoundException {
        int[] rowHeights;
        if (detectionResultRowIndicatorColumn == null || (rowHeights = detectionResultRowIndicatorColumn.getRowHeights()) == null) {
            return null;
        }
        int max = getMax(rowHeights);
        int i2 = 0;
        int i3 = 0;
        for (int i4 : rowHeights) {
            i3 += max - i4;
            if (i4 > 0) {
                break;
            }
        }
        Codeword[] codewords = detectionResultRowIndicatorColumn.getCodewords();
        int i5 = 0;
        while (i3 > 0 && codewords[i5] == null) {
            i3--;
            i5++;
        }
        for (int length = rowHeights.length - 1; length >= 0; length--) {
            i2 += max - rowHeights[length];
            if (rowHeights[length] > 0) {
                break;
            }
        }
        int length2 = codewords.length - 1;
        while (i2 > 0 && codewords[length2] == null) {
            i2--;
            length2--;
        }
        return detectionResultRowIndicatorColumn.getBoundingBox().addMissingRows(i3, i2, detectionResultRowIndicatorColumn.isLeft());
    }

    public static void adjustCodewordCount(DetectionResult detectionResult, BarcodeValue[][] barcodeValueArr) throws NotFoundException {
        BarcodeValue barcodeValue = barcodeValueArr[0][1];
        int[] value = barcodeValue.getValue();
        int barcodeColumnCount = (detectionResult.getBarcodeColumnCount() * detectionResult.getBarcodeRowCount()) - getNumberOfECCodeWords(detectionResult.getBarcodeECLevel());
        if (value.length == 0) {
            if (barcodeColumnCount <= 0 || barcodeColumnCount > 928) {
                throw NotFoundException.getNotFoundInstance();
            }
            barcodeValue.setValue(barcodeColumnCount);
        } else if (value[0] != barcodeColumnCount) {
            barcodeValue.setValue(barcodeColumnCount);
        }
    }

    public static int adjustCodewordStartColumn(BitMatrix bitMatrix, int i2, int i3, boolean z, int i4, int i5) {
        int i6 = z ? -1 : 1;
        int i7 = i4;
        for (int i8 = 0; i8 < 2; i8++) {
            while (true) {
                if (!z) {
                    if (i7 >= i3) {
                        continue;
                        break;
                    }
                } else if (i7 < i2) {
                    continue;
                    break;
                }
                if (z != bitMatrix.get(i7, i5)) {
                    continue;
                    break;
                } else if (Math.abs(i4 - i7) > 2) {
                    return i4;
                } else {
                    i7 += i6;
                }
            }
            i6 = -i6;
            z = !z;
        }
        return i7;
    }

    public static boolean checkCodewordSkew(int i2, int i3, int i4) {
        return i3 + -2 <= i2 && i2 <= i4 + 2;
    }

    public static int correctErrors(int[] iArr, int[] iArr2, int i2) throws ChecksumException {
        if ((iArr2 == null || iArr2.length <= (i2 / 2) + 3) && i2 >= 0 && i2 <= 512) {
            return errorCorrection.decode(iArr, i2, iArr2);
        }
        throw ChecksumException.getChecksumInstance();
    }

    public static BarcodeValue[][] createBarcodeMatrix(DetectionResult detectionResult) {
        int rowNumber;
        int barcodeRowCount = detectionResult.getBarcodeRowCount();
        int[] iArr = new int[2];
        iArr[1] = detectionResult.getBarcodeColumnCount() + 2;
        iArr[0] = barcodeRowCount;
        BarcodeValue[][] barcodeValueArr = (BarcodeValue[][]) Array.newInstance(BarcodeValue.class, iArr);
        for (int i2 = 0; i2 < barcodeValueArr.length; i2++) {
            for (int i3 = 0; i3 < barcodeValueArr[i2].length; i3++) {
                barcodeValueArr[i2][i3] = new BarcodeValue();
            }
        }
        int i4 = 0;
        for (DetectionResultColumn detectionResultColumn : detectionResult.getDetectionResultColumns()) {
            if (detectionResultColumn != null) {
                for (Codeword codeword : detectionResultColumn.getCodewords()) {
                    if (codeword != null && (rowNumber = codeword.getRowNumber()) >= 0 && rowNumber < barcodeValueArr.length) {
                        barcodeValueArr[rowNumber][i4].setValue(codeword.getValue());
                    }
                }
            }
            i4++;
        }
        return barcodeValueArr;
    }

    public static DecoderResult createDecoderResult(DetectionResult detectionResult) throws FormatException, ChecksumException, NotFoundException {
        BarcodeValue[][] createBarcodeMatrix = createBarcodeMatrix(detectionResult);
        adjustCodewordCount(detectionResult, createBarcodeMatrix);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[(detectionResult.getBarcodeRowCount() * detectionResult.getBarcodeColumnCount())];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i2 = 0; i2 < detectionResult.getBarcodeRowCount(); i2++) {
            int i3 = 0;
            while (i3 < detectionResult.getBarcodeColumnCount()) {
                int i4 = i3 + 1;
                int[] value = createBarcodeMatrix[i2][i4].getValue();
                int barcodeColumnCount = (detectionResult.getBarcodeColumnCount() * i2) + i3;
                if (value.length == 0) {
                    arrayList.add(Integer.valueOf(barcodeColumnCount));
                } else if (value.length == 1) {
                    iArr[barcodeColumnCount] = value[0];
                } else {
                    arrayList3.add(Integer.valueOf(barcodeColumnCount));
                    arrayList2.add(value);
                }
                i3 = i4;
            }
        }
        int size = arrayList2.size();
        int[][] iArr2 = new int[size][];
        for (int i5 = 0; i5 < size; i5++) {
            iArr2[i5] = (int[]) arrayList2.get(i5);
        }
        return createDecoderResultFromAmbiguousValues(detectionResult.getBarcodeECLevel(), iArr, PDF417Common.toIntArray(arrayList), PDF417Common.toIntArray(arrayList3), iArr2);
    }

    public static DecoderResult createDecoderResultFromAmbiguousValues(int i2, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) throws FormatException, ChecksumException {
        int length = iArr3.length;
        int[] iArr5 = new int[length];
        int i3 = 100;
        while (true) {
            int i4 = i3 - 1;
            if (i3 > 0) {
                for (int i5 = 0; i5 < length; i5++) {
                    iArr[iArr3[i5]] = iArr4[i5][iArr5[i5]];
                }
                try {
                    return decodeCodewords(iArr, i2, iArr2);
                } catch (ChecksumException unused) {
                    if (length != 0) {
                        int i6 = 0;
                        while (true) {
                            if (i6 >= length) {
                                break;
                            } else if (iArr5[i6] < iArr4[i6].length - 1) {
                                iArr5[i6] = iArr5[i6] + 1;
                                break;
                            } else {
                                iArr5[i6] = 0;
                                if (i6 != length - 1) {
                                    i6++;
                                } else {
                                    throw ChecksumException.getChecksumInstance();
                                }
                            }
                        }
                        i3 = i4;
                    } else {
                        throw ChecksumException.getChecksumInstance();
                    }
                }
            } else {
                throw ChecksumException.getChecksumInstance();
            }
        }
    }

    public static DecoderResult decode(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i2, int i3) throws NotFoundException, FormatException, ChecksumException {
        DetectionResultColumn detectionResultColumn;
        int i4;
        int i5;
        int i6;
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn = null;
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2 = null;
        DetectionResult detectionResult = null;
        BoundingBox boundingBox = new BoundingBox(bitMatrix, resultPoint, resultPoint2, resultPoint3, resultPoint4);
        int i7 = 0;
        while (true) {
            if (i7 >= 2) {
                break;
            }
            if (resultPoint != null) {
                detectionResultRowIndicatorColumn = getRowIndicatorColumn(bitMatrix, boundingBox, resultPoint, true, i2, i3);
            }
            if (resultPoint3 != null) {
                detectionResultRowIndicatorColumn2 = getRowIndicatorColumn(bitMatrix, boundingBox, resultPoint3, false, i2, i3);
            }
            detectionResult = merge(detectionResultRowIndicatorColumn, detectionResultRowIndicatorColumn2);
            if (detectionResult == null) {
                throw NotFoundException.getNotFoundInstance();
            } else if (i7 != 0 || detectionResult.getBoundingBox() == null || (detectionResult.getBoundingBox().getMinY() >= boundingBox.getMinY() && detectionResult.getBoundingBox().getMaxY() <= boundingBox.getMaxY())) {
                detectionResult.setBoundingBox(boundingBox);
            } else {
                boundingBox = detectionResult.getBoundingBox();
                i7++;
            }
        }
        detectionResult.setBoundingBox(boundingBox);
        int barcodeColumnCount = detectionResult.getBarcodeColumnCount() + 1;
        detectionResult.setDetectionResultColumn(0, detectionResultRowIndicatorColumn);
        detectionResult.setDetectionResultColumn(barcodeColumnCount, detectionResultRowIndicatorColumn2);
        boolean z = detectionResultRowIndicatorColumn != null;
        int i8 = i2;
        int i9 = i3;
        for (int i10 = 1; i10 <= barcodeColumnCount; i10++) {
            int i11 = z ? i10 : barcodeColumnCount - i10;
            if (detectionResult.getDetectionResultColumn(i11) == null) {
                if (i11 == 0 || i11 == barcodeColumnCount) {
                    detectionResultColumn = new DetectionResultRowIndicatorColumn(boundingBox, i11 == 0);
                } else {
                    detectionResultColumn = new DetectionResultColumn(boundingBox);
                }
                detectionResult.setDetectionResultColumn(i11, detectionResultColumn);
                int i12 = -1;
                int minY = boundingBox.getMinY();
                int i13 = -1;
                while (minY <= boundingBox.getMaxY()) {
                    int startColumn = getStartColumn(detectionResult, i11, minY, z);
                    if (startColumn >= 0 && startColumn <= boundingBox.getMaxX()) {
                        i6 = startColumn;
                    } else if (i13 != i12) {
                        i6 = i13;
                    } else {
                        i5 = i13;
                        i4 = minY;
                        i13 = i5;
                        minY = i4 + 1;
                        i12 = -1;
                    }
                    i5 = i13;
                    int i14 = minY;
                    Codeword detectCodeword = detectCodeword(bitMatrix, boundingBox.getMinX(), boundingBox.getMaxX(), z, i6, i14, i8, i9);
                    i4 = i14;
                    if (detectCodeword != null) {
                        detectionResultColumn.setCodeword(i4, detectCodeword);
                        i8 = Math.min(i8, detectCodeword.getWidth());
                        i9 = Math.max(i9, detectCodeword.getWidth());
                        i13 = i6;
                        minY = i4 + 1;
                        i12 = -1;
                    }
                    i13 = i5;
                    minY = i4 + 1;
                    i12 = -1;
                }
            }
        }
        return createDecoderResult(detectionResult);
    }

    public static DecoderResult decodeCodewords(int[] iArr, int i2, int[] iArr2) throws FormatException, ChecksumException {
        if (iArr.length != 0) {
            int i3 = 1 << (i2 + 1);
            int correctErrors = correctErrors(iArr, iArr2, i3);
            verifyCodewordCount(iArr, i3);
            DecoderResult decode = DecodedBitStreamParser.decode(iArr, String.valueOf(i2));
            decode.setErrorsCorrected(Integer.valueOf(correctErrors));
            decode.setErasures(Integer.valueOf(iArr2.length));
            return decode;
        }
        throw FormatException.getFormatInstance();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0040, code lost:
        r7 = com.google.zxing.pdf417.decoder.PDF417CodewordDecoder.getDecodedValue(r7);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.zxing.pdf417.decoder.Codeword detectCodeword(com.google.zxing.common.BitMatrix r7, int r8, int r9, boolean r10, int r11, int r12, int r13, int r14) {
        /*
            int r11 = adjustCodewordStartColumn(r7, r8, r9, r10, r11, r12)
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            int[] r7 = getModuleBitCount(r0, r1, r2, r3, r4, r5)
            r8 = 0
            if (r7 != 0) goto L_0x0012
            return r8
        L_0x0012:
            int r9 = com.google.zxing.common.detector.MathUtils.sum(r7)
            if (r10 == 0) goto L_0x001b
            int r10 = r11 + r9
            goto L_0x0039
        L_0x001b:
            r10 = 0
        L_0x001c:
            int r12 = r7.length
            int r12 = r12 / 2
            if (r10 >= r12) goto L_0x0034
            r12 = r7[r10]
            int r0 = r7.length
            int r0 = r0 + -1
            int r0 = r0 - r10
            r0 = r7[r0]
            r7[r10] = r0
            int r0 = r7.length
            int r0 = r0 + -1
            int r0 = r0 - r10
            r7[r0] = r12
            int r10 = r10 + 1
            goto L_0x001c
        L_0x0034:
            int r10 = r11 - r9
            r6 = r11
            r11 = r10
            r10 = r6
        L_0x0039:
            boolean r9 = checkCodewordSkew(r9, r13, r14)
            if (r9 != 0) goto L_0x0040
            return r8
        L_0x0040:
            int r7 = com.google.zxing.pdf417.decoder.PDF417CodewordDecoder.getDecodedValue(r7)
            int r9 = com.google.zxing.pdf417.PDF417Common.getCodeword(r7)
            r12 = -1
            if (r9 != r12) goto L_0x004c
            return r8
        L_0x004c:
            com.google.zxing.pdf417.decoder.Codeword r8 = new com.google.zxing.pdf417.decoder.Codeword
            int r7 = getCodewordBucketNumber((int) r7)
            r8.<init>(r11, r10, r7, r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.PDF417ScanningDecoder.detectCodeword(com.google.zxing.common.BitMatrix, int, int, boolean, int, int, int, int):com.google.zxing.pdf417.decoder.Codeword");
    }

    public static BarcodeMetadata getBarcodeMetadata(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn, DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2) {
        BarcodeMetadata barcodeMetadata;
        BarcodeMetadata barcodeMetadata2;
        if (detectionResultRowIndicatorColumn == null || (barcodeMetadata = detectionResultRowIndicatorColumn.getBarcodeMetadata()) == null) {
            if (detectionResultRowIndicatorColumn2 == null) {
                return null;
            }
            return detectionResultRowIndicatorColumn2.getBarcodeMetadata();
        } else if (detectionResultRowIndicatorColumn2 == null || (barcodeMetadata2 = detectionResultRowIndicatorColumn2.getBarcodeMetadata()) == null || barcodeMetadata.getColumnCount() == barcodeMetadata2.getColumnCount() || barcodeMetadata.getErrorCorrectionLevel() == barcodeMetadata2.getErrorCorrectionLevel() || barcodeMetadata.getRowCount() == barcodeMetadata2.getRowCount()) {
            return barcodeMetadata;
        } else {
            return null;
        }
    }

    public static int[] getBitCountForCodeword(int i2) {
        int[] iArr = new int[8];
        int i3 = 0;
        int i4 = 7;
        while (true) {
            int i5 = i2 & 1;
            if (i5 != i3) {
                i4--;
                if (i4 < 0) {
                    return iArr;
                }
                i3 = i5;
            }
            iArr[i4] = iArr[i4] + 1;
            i2 >>= 1;
        }
    }

    public static int getCodewordBucketNumber(int i2) {
        return getCodewordBucketNumber(getBitCountForCodeword(i2));
    }

    public static int getMax(int[] iArr) {
        int i2 = -1;
        for (int max : iArr) {
            i2 = Math.max(i2, max);
        }
        return i2;
    }

    public static int[] getModuleBitCount(BitMatrix bitMatrix, int i2, int i3, boolean z, int i4, int i5) {
        int[] iArr = new int[8];
        int i6 = z ? 1 : -1;
        int i7 = 0;
        boolean z2 = z;
        while (true) {
            if (!z) {
                if (i4 < i2) {
                    break;
                }
            } else if (i4 >= i3) {
                break;
            }
            if (i7 >= 8) {
                break;
            } else if (bitMatrix.get(i4, i5) == z2) {
                iArr[i7] = iArr[i7] + 1;
                i4 += i6;
            } else {
                i7++;
                z2 = !z2;
            }
        }
        if (i7 != 8) {
            if (z) {
                i2 = i3;
            }
            if (!(i4 == i2 && i7 == 7)) {
                return null;
            }
        }
        return iArr;
    }

    public static int getNumberOfECCodeWords(int i2) {
        return 2 << i2;
    }

    public static DetectionResultRowIndicatorColumn getRowIndicatorColumn(BitMatrix bitMatrix, BoundingBox boundingBox, ResultPoint resultPoint, boolean z, int i2, int i3) {
        int i4;
        boolean z2 = z;
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn = new DetectionResultRowIndicatorColumn(boundingBox, z2);
        int i5 = 0;
        while (i5 < 2) {
            int i6 = i5 == 0 ? 1 : -1;
            int x = (int) resultPoint.getX();
            int y = (int) resultPoint.getY();
            while (y <= boundingBox.getMaxY() && y >= boundingBox.getMinY()) {
                Codeword detectCodeword = detectCodeword(bitMatrix, 0, bitMatrix.getWidth(), z, x, y, i2, i3);
                if (detectCodeword != null) {
                    detectionResultRowIndicatorColumn.setCodeword(y, detectCodeword);
                    if (z2) {
                        i4 = detectCodeword.getStartX();
                    } else {
                        i4 = detectCodeword.getEndX();
                    }
                    x = i4;
                }
                y += i6;
            }
            i5++;
        }
        return detectionResultRowIndicatorColumn;
    }

    public static int getStartColumn(DetectionResult detectionResult, int i2, int i3, boolean z) {
        int i4 = z ? 1 : -1;
        Codeword codeword = null;
        int i5 = i2 - i4;
        if (isValidBarcodeColumn(detectionResult, i5)) {
            codeword = detectionResult.getDetectionResultColumn(i5).getCodeword(i3);
        }
        if (codeword != null) {
            return z ? codeword.getEndX() : codeword.getStartX();
        }
        Codeword codewordNearby = detectionResult.getDetectionResultColumn(i2).getCodewordNearby(i3);
        if (codewordNearby != null) {
            return z ? codewordNearby.getStartX() : codewordNearby.getEndX();
        }
        if (isValidBarcodeColumn(detectionResult, i5)) {
            codewordNearby = detectionResult.getDetectionResultColumn(i5).getCodewordNearby(i3);
        }
        if (codewordNearby != null) {
            return z ? codewordNearby.getEndX() : codewordNearby.getStartX();
        }
        int i6 = 0;
        while (true) {
            i2 -= i4;
            if (isValidBarcodeColumn(detectionResult, i2)) {
                for (Codeword codeword2 : detectionResult.getDetectionResultColumn(i2).getCodewords()) {
                    if (codeword2 != null) {
                        return (z ? codeword2.getEndX() : codeword2.getStartX()) + (i4 * i6 * (codeword2.getEndX() - codeword2.getStartX()));
                    }
                }
                i6++;
            } else {
                BoundingBox boundingBox = detectionResult.getBoundingBox();
                return z ? boundingBox.getMinX() : boundingBox.getMaxX();
            }
        }
    }

    public static boolean isValidBarcodeColumn(DetectionResult detectionResult, int i2) {
        return i2 >= 0 && i2 <= detectionResult.getBarcodeColumnCount() + 1;
    }

    public static DetectionResult merge(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn, DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2) throws NotFoundException {
        BarcodeMetadata barcodeMetadata;
        if ((detectionResultRowIndicatorColumn == null && detectionResultRowIndicatorColumn2 == null) || (barcodeMetadata = getBarcodeMetadata(detectionResultRowIndicatorColumn, detectionResultRowIndicatorColumn2)) == null) {
            return null;
        }
        return new DetectionResult(barcodeMetadata, BoundingBox.merge(adjustBoundingBox(detectionResultRowIndicatorColumn), adjustBoundingBox(detectionResultRowIndicatorColumn2)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0067, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006d, code lost:
        r9.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0070, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String toString(com.google.zxing.pdf417.decoder.BarcodeValue[][] r9) {
        /*
            java.util.Formatter r0 = new java.util.Formatter
            r0.<init>()
            r1 = 0
            r2 = 0
        L_0x0007:
            int r3 = r9.length     // Catch:{ all -> 0x0065 }
            if (r2 >= r3) goto L_0x005d
            java.lang.String r3 = "Row %2d: "
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x0065 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0065 }
            r5[r1] = r6     // Catch:{ all -> 0x0065 }
            r0.format(r3, r5)     // Catch:{ all -> 0x0065 }
            r3 = 0
        L_0x0019:
            r5 = r9[r2]     // Catch:{ all -> 0x0065 }
            int r5 = r5.length     // Catch:{ all -> 0x0065 }
            if (r3 >= r5) goto L_0x0053
            r5 = r9[r2]     // Catch:{ all -> 0x0065 }
            r5 = r5[r3]     // Catch:{ all -> 0x0065 }
            int[] r6 = r5.getValue()     // Catch:{ all -> 0x0065 }
            int r6 = r6.length     // Catch:{ all -> 0x0065 }
            if (r6 != 0) goto L_0x0030
            java.lang.String r5 = "        "
            r6 = 0
            r0.format(r5, r6)     // Catch:{ all -> 0x0065 }
            goto L_0x0050
        L_0x0030:
            java.lang.String r6 = "%4d(%2d)"
            r7 = 2
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ all -> 0x0065 }
            int[] r8 = r5.getValue()     // Catch:{ all -> 0x0065 }
            r8 = r8[r1]     // Catch:{ all -> 0x0065 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0065 }
            r7[r1] = r8     // Catch:{ all -> 0x0065 }
            int[] r8 = r5.getValue()     // Catch:{ all -> 0x0065 }
            r8 = r8[r1]     // Catch:{ all -> 0x0065 }
            java.lang.Integer r5 = r5.getConfidence(r8)     // Catch:{ all -> 0x0065 }
            r7[r4] = r5     // Catch:{ all -> 0x0065 }
            r0.format(r6, r7)     // Catch:{ all -> 0x0065 }
        L_0x0050:
            int r3 = r3 + 1
            goto L_0x0019
        L_0x0053:
            java.lang.String r3 = "%n"
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ all -> 0x0065 }
            r0.format(r3, r4)     // Catch:{ all -> 0x0065 }
            int r2 = r2 + 1
            goto L_0x0007
        L_0x005d:
            java.lang.String r9 = r0.toString()     // Catch:{ all -> 0x0065 }
            r0.close()
            return r9
        L_0x0065:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x0067 }
        L_0x0067:
            r1 = move-exception
            r0.close()     // Catch:{ all -> 0x006c }
            goto L_0x0070
        L_0x006c:
            r0 = move-exception
            r9.addSuppressed(r0)
        L_0x0070:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.PDF417ScanningDecoder.toString(com.google.zxing.pdf417.decoder.BarcodeValue[][]):java.lang.String");
    }

    public static void verifyCodewordCount(int[] iArr, int i2) throws FormatException {
        if (iArr.length >= 4) {
            int i3 = iArr[0];
            if (i3 > iArr.length) {
                throw FormatException.getFormatInstance();
            } else if (i3 != 0) {
            } else {
                if (i2 < iArr.length) {
                    iArr[0] = iArr.length - i2;
                    return;
                }
                throw FormatException.getFormatInstance();
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    public static int getCodewordBucketNumber(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }
}
