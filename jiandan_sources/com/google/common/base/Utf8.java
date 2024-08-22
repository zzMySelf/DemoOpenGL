package com.google.common.base;

import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true)
@Beta
public final class Utf8 {
    public static int encodedLength(CharSequence charSequence) {
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 < length) {
                char charAt = charSequence.charAt(i2);
                if (charAt >= 2048) {
                    i3 += encodedLengthGeneral(charSequence, i2);
                    break;
                }
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                break;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i3) + AnimatedStateListDrawableCompat.AnimatedStateListState.REVERSED_BIT));
    }

    public static int encodedLengthGeneral(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        int i3 = 0;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
            } else {
                i3 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i2) != charAt) {
                        i2++;
                    } else {
                        throw new IllegalArgumentException(unpairedSurrogateMsg(i2));
                    }
                }
            }
            i2++;
        }
        return i3;
    }

    public static boolean isWellFormed(byte[] bArr) {
        return isWellFormed(bArr, 0, bArr.length);
    }

    public static boolean isWellFormedSlowPath(byte[] bArr, int i2, int i3) {
        byte b;
        while (i2 < i3) {
            int i4 = i2 + 1;
            byte b2 = bArr[i2];
            if (b2 < 0) {
                if (b2 < -32) {
                    if (i4 != i3 && b2 >= -62) {
                        i2 = i4 + 1;
                        if (bArr[i4] > -65) {
                        }
                    }
                    return false;
                } else if (b2 < -16) {
                    int i5 = i4 + 1;
                    if (i5 < i3 && (b = bArr[i4]) <= -65 && ((b2 != -32 || b >= -96) && (b2 != -19 || -96 > b))) {
                        i2 = i5 + 1;
                        if (bArr[i5] > -65) {
                        }
                    }
                    return false;
                } else if (i4 + 2 >= i3) {
                    return false;
                } else {
                    int i6 = i4 + 1;
                    byte b3 = bArr[i4];
                    if (b3 <= -65 && (((b2 << Ascii.FS) + (b3 + 112)) >> 30) == 0) {
                        int i7 = i6 + 1;
                        if (bArr[i6] <= -65) {
                            i4 = i7 + 1;
                            if (bArr[i7] > -65) {
                            }
                        }
                    }
                    return false;
                }
            }
            i2 = i4;
        }
        return true;
    }

    public static String unpairedSurrogateMsg(int i2) {
        return "Unpaired surrogate at index " + i2;
    }

    public static boolean isWellFormed(byte[] bArr, int i2, int i3) {
        int i4 = i3 + i2;
        Preconditions.checkPositionIndexes(i2, i4, bArr.length);
        while (i2 < i4) {
            if (bArr[i2] < 0) {
                return isWellFormedSlowPath(bArr, i2, i4);
            }
            i2++;
        }
        return true;
    }
}
