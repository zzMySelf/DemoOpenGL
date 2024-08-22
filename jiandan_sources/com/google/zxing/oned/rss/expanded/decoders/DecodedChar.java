package com.google.zxing.oned.rss.expanded.decoders;

public final class DecodedChar extends DecodedObject {
    public static final char FNC1 = '$';
    public final char value;

    public DecodedChar(int i2, char c) {
        super(i2);
        this.value = c;
    }

    public char getValue() {
        return this.value;
    }

    public boolean isFNC1() {
        return this.value == '$';
    }
}
