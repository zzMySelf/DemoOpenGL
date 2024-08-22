package com.google.zxing.qrcode.decoder;

public enum ErrorCorrectionLevel {
    L(1),
    M(0),
    Q(3),
    H(2);
    
    public static final ErrorCorrectionLevel[] FOR_BITS = null;
    public final int bits;

    /* access modifiers changed from: public */
    static {
        ErrorCorrectionLevel errorCorrectionLevel;
        ErrorCorrectionLevel errorCorrectionLevel2;
        ErrorCorrectionLevel errorCorrectionLevel3;
        ErrorCorrectionLevel errorCorrectionLevel4;
        FOR_BITS = new ErrorCorrectionLevel[]{errorCorrectionLevel3, errorCorrectionLevel2, errorCorrectionLevel, errorCorrectionLevel4};
    }

    /* access modifiers changed from: public */
    ErrorCorrectionLevel(int i2) {
        this.bits = i2;
    }

    public static ErrorCorrectionLevel forBits(int i2) {
        if (i2 >= 0) {
            ErrorCorrectionLevel[] errorCorrectionLevelArr = FOR_BITS;
            if (i2 < errorCorrectionLevelArr.length) {
                return errorCorrectionLevelArr[i2];
            }
        }
        throw new IllegalArgumentException();
    }

    public int getBits() {
        return this.bits;
    }
}
