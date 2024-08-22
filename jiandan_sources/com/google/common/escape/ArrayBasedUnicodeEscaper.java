package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Map;
import kotlin.jvm.internal.CharCompanionObject;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible
@Beta
public abstract class ArrayBasedUnicodeEscaper extends UnicodeEscaper {
    public final char[][] replacements;
    public final int replacementsLength;
    public final int safeMax;
    public final char safeMaxChar;
    public final int safeMin;
    public final char safeMinChar;

    public ArrayBasedUnicodeEscaper(Map<Character, String> map, int i2, int i3, @NullableDecl String str) {
        this(ArrayBasedEscaperMap.create(map), i2, i3, str);
    }

    public final String escape(String str) {
        Preconditions.checkNotNull(str);
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if ((charAt < this.replacementsLength && this.replacements[charAt] != null) || charAt > this.safeMaxChar || charAt < this.safeMinChar) {
                return escapeSlow(str, i2);
            }
        }
        return str;
    }

    public abstract char[] escapeUnsafe(int i2);

    public final int nextEscapeIndex(CharSequence charSequence, int i2, int i3) {
        while (i2 < i3) {
            char charAt = charSequence.charAt(i2);
            if ((charAt < this.replacementsLength && this.replacements[charAt] != null) || charAt > this.safeMaxChar || charAt < this.safeMinChar) {
                break;
            }
            i2++;
        }
        return i2;
    }

    public ArrayBasedUnicodeEscaper(ArrayBasedEscaperMap arrayBasedEscaperMap, int i2, int i3, @NullableDecl String str) {
        Preconditions.checkNotNull(arrayBasedEscaperMap);
        char[][] replacementArray = arrayBasedEscaperMap.getReplacementArray();
        this.replacements = replacementArray;
        this.replacementsLength = replacementArray.length;
        if (i3 < i2) {
            i3 = -1;
            i2 = Integer.MAX_VALUE;
        }
        this.safeMin = i2;
        this.safeMax = i3;
        if (i2 >= 55296) {
            this.safeMinChar = CharCompanionObject.MAX_VALUE;
            this.safeMaxChar = 0;
            return;
        }
        this.safeMinChar = (char) i2;
        this.safeMaxChar = (char) Math.min(i3, 55295);
    }

    public final char[] escape(int i2) {
        char[] cArr;
        if (i2 < this.replacementsLength && (cArr = this.replacements[i2]) != null) {
            return cArr;
        }
        if (i2 < this.safeMin || i2 > this.safeMax) {
            return escapeUnsafe(i2);
        }
        return null;
    }
}
