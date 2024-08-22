package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.CharMatcher;
import java.util.BitSet;

@GwtIncompatible
public final class SmallCharMatcher extends CharMatcher.NamedFastMatcher {
    public static final int C1 = -862048943;
    public static final int C2 = 461845907;
    public static final double DESIRED_LOAD_FACTOR = 0.5d;
    public static final int MAX_SIZE = 1023;
    public final boolean containsZero;
    public final long filter;
    public final char[] table;

    public SmallCharMatcher(char[] cArr, long j, boolean z, String str) {
        super(str);
        this.table = cArr;
        this.filter = j;
        this.containsZero = z;
    }

    private boolean checkFilter(int i2) {
        return 1 == ((this.filter >> i2) & 1);
    }

    @VisibleForTesting
    public static int chooseTableSize(int i2) {
        if (i2 == 1) {
            return 2;
        }
        int highestOneBit = Integer.highestOneBit(i2 - 1) << 1;
        while (((double) highestOneBit) * 0.5d < ((double) i2)) {
            highestOneBit <<= 1;
        }
        return highestOneBit;
    }

    public static CharMatcher from(BitSet bitSet, String str) {
        int i2;
        int cardinality = bitSet.cardinality();
        boolean z = bitSet.get(0);
        int chooseTableSize = chooseTableSize(cardinality);
        char[] cArr = new char[chooseTableSize];
        int i3 = chooseTableSize - 1;
        int nextSetBit = bitSet.nextSetBit(0);
        long j = 0;
        while (nextSetBit != -1) {
            long j2 = (1 << nextSetBit) | j;
            int smear = smear(nextSetBit);
            while (true) {
                i2 = smear & i3;
                if (cArr[i2] == 0) {
                    break;
                }
                smear = i2 + 1;
            }
            cArr[i2] = (char) nextSetBit;
            nextSetBit = bitSet.nextSetBit(nextSetBit + 1);
            j = j2;
        }
        return new SmallCharMatcher(cArr, j, z, str);
    }

    public static int smear(int i2) {
        return Integer.rotateLeft(i2 * -862048943, 15) * 461845907;
    }

    public boolean matches(char c) {
        if (c == 0) {
            return this.containsZero;
        }
        if (!checkFilter(c)) {
            return false;
        }
        int length = this.table.length - 1;
        int smear = smear(c) & length;
        int i2 = smear;
        do {
            char[] cArr = this.table;
            if (cArr[i2] == 0) {
                return false;
            }
            if (cArr[i2] == c) {
                return true;
            }
            i2 = (i2 + 1) & length;
        } while (i2 != smear);
        return false;
    }

    public void setBits(BitSet bitSet) {
        if (this.containsZero) {
            bitSet.set(0);
        }
        for (char c : this.table) {
            if (c != 0) {
                bitSet.set(c);
            }
        }
    }
}
