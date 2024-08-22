package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;

public final class Encoder {
    public static final int DEFAULT_AZTEC_LAYERS = 0;
    public static final int DEFAULT_EC_PERCENT = 33;
    public static final int MAX_NB_BITS = 32;
    public static final int MAX_NB_BITS_COMPACT = 4;
    public static final int[] WORD_SIZE = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    public static int[] bitsToWords(BitArray bitArray, int i2, int i3) {
        int[] iArr = new int[i3];
        int size = bitArray.getSize() / i2;
        for (int i4 = 0; i4 < size; i4++) {
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                i5 |= bitArray.get((i4 * i2) + i6) ? 1 << ((i2 - i6) - 1) : 0;
            }
            iArr[i4] = i5;
        }
        return iArr;
    }

    public static void drawBullsEye(BitMatrix bitMatrix, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4 += 2) {
            int i5 = i2 - i4;
            int i6 = i5;
            while (true) {
                int i7 = i2 + i4;
                if (i6 > i7) {
                    break;
                }
                bitMatrix.set(i6, i5);
                bitMatrix.set(i6, i7);
                bitMatrix.set(i5, i6);
                bitMatrix.set(i7, i6);
                i6++;
            }
        }
        int i8 = i2 - i3;
        bitMatrix.set(i8, i8);
        int i9 = i8 + 1;
        bitMatrix.set(i9, i8);
        bitMatrix.set(i8, i9);
        int i10 = i2 + i3;
        bitMatrix.set(i10, i8);
        bitMatrix.set(i10, i9);
        bitMatrix.set(i10, i10 - 1);
    }

    public static void drawModeMessage(BitMatrix bitMatrix, boolean z, int i2, BitArray bitArray) {
        int i3 = i2 / 2;
        int i4 = 0;
        if (z) {
            while (i4 < 7) {
                int i5 = (i3 - 3) + i4;
                if (bitArray.get(i4)) {
                    bitMatrix.set(i5, i3 - 5);
                }
                if (bitArray.get(i4 + 7)) {
                    bitMatrix.set(i3 + 5, i5);
                }
                if (bitArray.get(20 - i4)) {
                    bitMatrix.set(i5, i3 + 5);
                }
                if (bitArray.get(27 - i4)) {
                    bitMatrix.set(i3 - 5, i5);
                }
                i4++;
            }
            return;
        }
        while (i4 < 10) {
            int i6 = (i3 - 5) + i4 + (i4 / 5);
            if (bitArray.get(i4)) {
                bitMatrix.set(i6, i3 - 7);
            }
            if (bitArray.get(i4 + 10)) {
                bitMatrix.set(i3 + 7, i6);
            }
            if (bitArray.get(29 - i4)) {
                bitMatrix.set(i6, i3 + 7);
            }
            if (bitArray.get(39 - i4)) {
                bitMatrix.set(i3 - 7, i6);
            }
            i4++;
        }
    }

    public static AztecCode encode(byte[] bArr) {
        return encode(bArr, 33, 0);
    }

    public static BitArray generateCheckWords(BitArray bitArray, int i2, int i3) {
        ReedSolomonEncoder reedSolomonEncoder = new ReedSolomonEncoder(getGF(i3));
        int i4 = i2 / i3;
        int[] bitsToWords = bitsToWords(bitArray, i3, i4);
        reedSolomonEncoder.encode(bitsToWords, i4 - (bitArray.getSize() / i3));
        BitArray bitArray2 = new BitArray();
        bitArray2.appendBits(0, i2 % i3);
        for (int appendBits : bitsToWords) {
            bitArray2.appendBits(appendBits, i3);
        }
        return bitArray2;
    }

    public static BitArray generateModeMessage(boolean z, int i2, int i3) {
        BitArray bitArray = new BitArray();
        if (z) {
            bitArray.appendBits(i2 - 1, 2);
            bitArray.appendBits(i3 - 1, 6);
            return generateCheckWords(bitArray, 28, 4);
        }
        bitArray.appendBits(i2 - 1, 5);
        bitArray.appendBits(i3 - 1, 11);
        return generateCheckWords(bitArray, 40, 4);
    }

    public static GenericGF getGF(int i2) {
        if (i2 == 4) {
            return GenericGF.AZTEC_PARAM;
        }
        if (i2 == 6) {
            return GenericGF.AZTEC_DATA_6;
        }
        if (i2 == 8) {
            return GenericGF.AZTEC_DATA_8;
        }
        if (i2 == 10) {
            return GenericGF.AZTEC_DATA_10;
        }
        if (i2 == 12) {
            return GenericGF.AZTEC_DATA_12;
        }
        throw new IllegalArgumentException("Unsupported word size ".concat(String.valueOf(i2)));
    }

    public static BitArray stuffBits(BitArray bitArray, int i2) {
        BitArray bitArray2 = new BitArray();
        int size = bitArray.getSize();
        int i3 = (1 << i2) - 2;
        int i4 = 0;
        while (i4 < size) {
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                int i7 = i4 + i6;
                if (i7 >= size || bitArray.get(i7)) {
                    i5 |= 1 << ((i2 - 1) - i6);
                }
            }
            int i8 = i5 & i3;
            if (i8 == i3) {
                bitArray2.appendBits(i8, i2);
            } else if (i8 == 0) {
                bitArray2.appendBits(i5 | 1, i2);
            } else {
                bitArray2.appendBits(i5, i2);
                i4 += i2;
            }
            i4--;
            i4 += i2;
        }
        return bitArray2;
    }

    public static int totalBitsInLayer(int i2, boolean z) {
        return ((z ? 88 : 112) + (i2 << 4)) * i2;
    }

    public static AztecCode encode(byte[] bArr, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        boolean z;
        BitArray bitArray;
        int i7;
        BitArray encode = new HighLevelEncoder(bArr).encode();
        int i8 = 11;
        int size = ((encode.getSize() * i2) / 100) + 11;
        int size2 = encode.getSize() + size;
        int i9 = 32;
        int i10 = 0;
        int i11 = 1;
        if (i3 != 0) {
            z = i3 < 0;
            i5 = Math.abs(i3);
            if (z) {
                i9 = 4;
            }
            if (i5 <= i9) {
                i6 = totalBitsInLayer(i5, z);
                i4 = WORD_SIZE[i5];
                int i12 = i6 - (i6 % i4);
                bitArray = stuffBits(encode, i4);
                if (bitArray.getSize() + size > i12) {
                    throw new IllegalArgumentException("Data to large for user specified layer");
                } else if (z && bitArray.getSize() > (i4 << 6)) {
                    throw new IllegalArgumentException("Data to large for user specified layer");
                }
            } else {
                throw new IllegalArgumentException(String.format("Illegal value %s for layers", new Object[]{Integer.valueOf(i3)}));
            }
        } else {
            BitArray bitArray2 = null;
            int i13 = 0;
            int i14 = 0;
            while (i13 <= 32) {
                boolean z2 = i13 <= 3;
                int i15 = z2 ? i13 + 1 : i13;
                int i16 = totalBitsInLayer(i15, z2);
                if (size2 <= i16) {
                    if (bitArray2 == null || i14 != WORD_SIZE[i15]) {
                        int i17 = WORD_SIZE[i15];
                        i14 = i17;
                        bitArray2 = stuffBits(encode, i17);
                    }
                    int i18 = i16 - (i16 % i14);
                    if ((!z2 || bitArray2.getSize() <= (i14 << 6)) && bitArray2.getSize() + size <= i18) {
                        bitArray = bitArray2;
                        i4 = i14;
                        z = z2;
                        i5 = i15;
                        i6 = i16;
                    }
                }
                i13++;
                i10 = 0;
                i11 = 1;
            }
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        BitArray generateCheckWords = generateCheckWords(bitArray, i6, i4);
        int size3 = bitArray.getSize() / i4;
        BitArray generateModeMessage = generateModeMessage(z, i5, size3);
        if (!z) {
            i8 = 14;
        }
        int i19 = i8 + (i5 << 2);
        int[] iArr = new int[i19];
        int i20 = 2;
        if (z) {
            for (int i21 = 0; i21 < i19; i21++) {
                iArr[i21] = i21;
            }
            i7 = i19;
        } else {
            int i22 = i19 / 2;
            i7 = i19 + 1 + (((i22 - 1) / 15) * 2);
            int i23 = i7 / 2;
            for (int i24 = 0; i24 < i22; i24++) {
                int i25 = (i24 / 15) + i24;
                iArr[(i22 - i24) - i11] = (i23 - i25) - 1;
                iArr[i22 + i24] = i25 + i23 + i11;
            }
        }
        BitMatrix bitMatrix = new BitMatrix(i7);
        int i26 = 0;
        int i27 = 0;
        while (i26 < i5) {
            int i28 = ((i5 - i26) << i20) + (z ? 9 : 12);
            int i29 = 0;
            while (i29 < i28) {
                int i30 = i29 << 1;
                while (i10 < i20) {
                    if (generateCheckWords.get(i27 + i30 + i10)) {
                        int i31 = i26 << 1;
                        bitMatrix.set(iArr[i31 + i10], iArr[i31 + i29]);
                    }
                    if (generateCheckWords.get((i28 << 1) + i27 + i30 + i10)) {
                        int i32 = i26 << 1;
                        bitMatrix.set(iArr[i32 + i29], iArr[((i19 - 1) - i32) - i10]);
                    }
                    if (generateCheckWords.get((i28 << 2) + i27 + i30 + i10)) {
                        int i33 = (i19 - 1) - (i26 << 1);
                        bitMatrix.set(iArr[i33 - i10], iArr[i33 - i29]);
                    }
                    if (generateCheckWords.get((i28 * 6) + i27 + i30 + i10)) {
                        int i34 = i26 << 1;
                        bitMatrix.set(iArr[((i19 - 1) - i34) - i29], iArr[i34 + i10]);
                    }
                    i10++;
                    i20 = 2;
                }
                i29++;
                i10 = 0;
                i20 = 2;
            }
            i27 += i28 << 3;
            i26++;
            i10 = 0;
            i20 = 2;
        }
        drawModeMessage(bitMatrix, z, i7, generateModeMessage);
        if (z) {
            drawBullsEye(bitMatrix, i7 / 2, 5);
        } else {
            int i35 = i7 / 2;
            drawBullsEye(bitMatrix, i35, 7);
            int i36 = 0;
            int i37 = 0;
            while (i37 < (i19 / 2) - 1) {
                for (int i38 = i35 & 1; i38 < i7; i38 += 2) {
                    int i39 = i35 - i36;
                    bitMatrix.set(i39, i38);
                    int i40 = i35 + i36;
                    bitMatrix.set(i40, i38);
                    bitMatrix.set(i38, i39);
                    bitMatrix.set(i38, i40);
                }
                i37 += 15;
                i36 += 16;
            }
        }
        AztecCode aztecCode = new AztecCode();
        aztecCode.setCompact(z);
        aztecCode.setSize(i7);
        aztecCode.setLayers(i5);
        aztecCode.setCodeWords(size3);
        aztecCode.setMatrix(bitMatrix);
        return aztecCode;
    }
}
