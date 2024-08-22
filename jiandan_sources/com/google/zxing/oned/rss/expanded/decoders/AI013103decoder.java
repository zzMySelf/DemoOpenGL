package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

public final class AI013103decoder extends AI013x0xDecoder {
    public AI013103decoder(BitArray bitArray) {
        super(bitArray);
    }

    public void addWeightCode(StringBuilder sb, int i2) {
        sb.append("(3103)");
    }

    public int checkWeight(int i2) {
        return i2;
    }
}
