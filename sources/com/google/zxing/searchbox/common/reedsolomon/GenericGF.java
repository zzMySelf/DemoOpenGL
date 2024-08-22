package com.google.zxing.searchbox.common.reedsolomon;

import com.baidu.ar.constants.DebugConstants;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public final class GenericGF {
    public static final GenericGF AZTEC_DATA_10 = new GenericGF(DebugConstants.HTTP_ERRCODE_VERSION_HIGH, 1024, 1);
    public static final GenericGF AZTEC_DATA_12 = new GenericGF(4201, 4096, 1);
    public static final GenericGF AZTEC_DATA_6;
    public static final GenericGF AZTEC_DATA_8;
    public static final GenericGF AZTEC_PARAM = new GenericGF(19, 16, 1);
    public static final GenericGF DATA_MATRIX_FIELD_256;
    private static final int INITIALIZATION_THRESHOLD = 0;
    public static final GenericGF MAXICODE_FIELD_64;
    public static final GenericGF QR_CODE_FIELD_256 = new GenericGF(285, 256, 0);
    private int[] expTable;
    private final int generatorBase;
    private boolean initialized = false;
    private int[] logTable;
    private GenericGFPoly one;
    private final int primitive;
    private final int size;
    private GenericGFPoly zero;

    static {
        GenericGF genericGF = new GenericGF(67, 64, 1);
        AZTEC_DATA_6 = genericGF;
        GenericGF genericGF2 = new GenericGF(301, 256, 1);
        DATA_MATRIX_FIELD_256 = genericGF2;
        AZTEC_DATA_8 = genericGF2;
        MAXICODE_FIELD_64 = genericGF;
    }

    public GenericGF(int primitive2, int size2, int b2) {
        this.primitive = primitive2;
        this.size = size2;
        this.generatorBase = b2;
        if (size2 <= 0) {
            initialize();
        }
    }

    private void initialize() {
        int i2 = this.size;
        this.expTable = new int[i2];
        this.logTable = new int[i2];
        int x = 1;
        int i3 = 0;
        while (true) {
            int i4 = this.size;
            if (i3 >= i4) {
                break;
            }
            this.expTable[i3] = x;
            x <<= 1;
            if (x >= i4) {
                x = (x ^ this.primitive) & (i4 - 1);
            }
            i3++;
        }
        for (int i5 = 0; i5 < this.size - 1; i5++) {
            this.logTable[this.expTable[i5]] = i5;
        }
        this.zero = new GenericGFPoly(this, new int[]{0});
        this.one = new GenericGFPoly(this, new int[]{1});
        this.initialized = true;
    }

    private void checkInit() {
        if (!this.initialized) {
            initialize();
        }
    }

    /* access modifiers changed from: package-private */
    public GenericGFPoly getZero() {
        checkInit();
        return this.zero;
    }

    /* access modifiers changed from: package-private */
    public GenericGFPoly getOne() {
        checkInit();
        return this.one;
    }

    /* access modifiers changed from: package-private */
    public GenericGFPoly buildMonomial(int degree, int coefficient) {
        checkInit();
        if (degree < 0) {
            throw new IllegalArgumentException();
        } else if (coefficient == 0) {
            return this.zero;
        } else {
            int[] coefficients = new int[(degree + 1)];
            coefficients[0] = coefficient;
            return new GenericGFPoly(this, coefficients);
        }
    }

    static int addOrSubtract(int a2, int b2) {
        return a2 ^ b2;
    }

    /* access modifiers changed from: package-private */
    public int exp(int a2) {
        checkInit();
        return this.expTable[a2];
    }

    /* access modifiers changed from: package-private */
    public int log(int a2) {
        checkInit();
        if (a2 != 0) {
            return this.logTable[a2];
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    public int inverse(int a2) {
        checkInit();
        if (a2 != 0) {
            return this.expTable[(this.size - this.logTable[a2]) - 1];
        }
        throw new ArithmeticException();
    }

    /* access modifiers changed from: package-private */
    public int multiply(int a2, int b2) {
        checkInit();
        if (a2 == 0 || b2 == 0) {
            return 0;
        }
        int[] iArr = this.expTable;
        int[] iArr2 = this.logTable;
        return iArr[(iArr2[a2] + iArr2[b2]) % (this.size - 1)];
    }

    public int getSize() {
        return this.size;
    }

    public int getGeneratorBase() {
        return this.generatorBase;
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.primitive) + AbstractJsonLexerKt.COMMA + this.size + ')';
    }
}
