package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

public final class AI01320xDecoder extends AI013x0xDecoder {
    public AI01320xDecoder(BitArray bitArray) {
        super(bitArray);
    }

    public void addWeightCode(StringBuilder sb, int i2) {
        if (i2 < 10000) {
            sb.append("(3202)");
        } else {
            sb.append("(3203)");
        }
    }

    public int checkWeight(int i2) {
        return i2 < 10000 ? i2 : i2 - 10000;
    }
}
