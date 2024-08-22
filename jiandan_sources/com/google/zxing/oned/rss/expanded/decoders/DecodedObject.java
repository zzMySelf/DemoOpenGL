package com.google.zxing.oned.rss.expanded.decoders;

public abstract class DecodedObject {
    public final int newPosition;

    public DecodedObject(int i2) {
        this.newPosition = i2;
    }

    public final int getNewPosition() {
        return this.newPosition;
    }
}
