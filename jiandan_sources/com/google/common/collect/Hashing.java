package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible
public final class Hashing {
    public static final long C1 = -862048943;
    public static final long C2 = 461845907;
    public static final int MAX_TABLE_SIZE = 1073741824;

    public static int closedTableSize(int i2, double d) {
        int max = Math.max(i2, 2);
        int highestOneBit = Integer.highestOneBit(max);
        if (max <= ((int) (d * ((double) highestOneBit)))) {
            return highestOneBit;
        }
        int i3 = highestOneBit << 1;
        if (i3 > 0) {
            return i3;
        }
        return 1073741824;
    }

    public static boolean needsResizing(int i2, int i3, double d) {
        return ((double) i2) > d * ((double) i3) && i3 < 1073741824;
    }

    public static int smear(int i2) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i2) * C1), 15)) * C2);
    }

    public static int smearedHash(@NullableDecl Object obj) {
        return smear(obj == null ? 0 : obj.hashCode());
    }
}
