package com.google.zxing.oned.rss;

public final class Pair extends DataCharacter {
    public int count;
    public final FinderPattern finderPattern;

    public Pair(int i2, int i3, FinderPattern finderPattern2) {
        super(i2, i3);
        this.finderPattern = finderPattern2;
    }

    public int getCount() {
        return this.count;
    }

    public FinderPattern getFinderPattern() {
        return this.finderPattern;
    }

    public void incrementCount() {
        this.count++;
    }
}
