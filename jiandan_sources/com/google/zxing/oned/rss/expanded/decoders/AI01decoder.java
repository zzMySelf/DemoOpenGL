package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

public abstract class AI01decoder extends AbstractExpandedDecoder {
    public static final int GTIN_SIZE = 40;

    public AI01decoder(BitArray bitArray) {
        super(bitArray);
    }

    public static void appendCheckDigit(StringBuilder sb, int i2) {
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < 13; i5++) {
            int charAt = sb.charAt(i5 + i2) - '0';
            if ((i5 & 1) == 0) {
                charAt *= 3;
            }
            i4 += charAt;
        }
        int i6 = 10 - (i4 % 10);
        if (i6 != 10) {
            i3 = i6;
        }
        sb.append(i3);
    }

    public final void encodeCompressedGtin(StringBuilder sb, int i2) {
        sb.append("(01)");
        int length = sb.length();
        sb.append('9');
        encodeCompressedGtinWithoutAI(sb, i2, length);
    }

    public final void encodeCompressedGtinWithoutAI(StringBuilder sb, int i2, int i3) {
        for (int i4 = 0; i4 < 4; i4++) {
            int extractNumericValueFromBitArray = getGeneralDecoder().extractNumericValueFromBitArray((i4 * 10) + i2, 10);
            if (extractNumericValueFromBitArray / 100 == 0) {
                sb.append('0');
            }
            if (extractNumericValueFromBitArray / 10 == 0) {
                sb.append('0');
            }
            sb.append(extractNumericValueFromBitArray);
        }
        appendCheckDigit(sb, i3);
    }
}
