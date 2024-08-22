package com.google.zxing.datamatrix.encoder;

public final class DataMatrixSymbolInfo144 extends SymbolInfo {
    public DataMatrixSymbolInfo144() {
        super(false, 1558, 620, 22, 22, 36, -1, 62);
    }

    public int getDataLengthForInterleavedBlock(int i2) {
        return i2 <= 8 ? 156 : 155;
    }

    public int getInterleavedBlockCount() {
        return 10;
    }
}
