package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.HashMap;
import java.util.Map;

@GwtCompatible
@Beta
public final class CharEscaperBuilder {
    public final Map<Character, String> map = new HashMap();
    public int max = -1;

    @CanIgnoreReturnValue
    public CharEscaperBuilder addEscape(char c, String str) {
        this.map.put(Character.valueOf(c), Preconditions.checkNotNull(str));
        if (c > this.max) {
            this.max = c;
        }
        return this;
    }

    @CanIgnoreReturnValue
    public CharEscaperBuilder addEscapes(char[] cArr, String str) {
        Preconditions.checkNotNull(str);
        for (char addEscape : cArr) {
            addEscape(addEscape, str);
        }
        return this;
    }

    public char[][] toArray() {
        char[][] cArr = new char[(this.max + 1)][];
        for (Map.Entry next : this.map.entrySet()) {
            cArr[((Character) next.getKey()).charValue()] = ((String) next.getValue()).toCharArray();
        }
        return cArr;
    }

    public Escaper toEscaper() {
        return new CharArrayDecorator(toArray());
    }

    public static class CharArrayDecorator extends CharEscaper {
        public final int replaceLength;
        public final char[][] replacements;

        public CharArrayDecorator(char[][] cArr) {
            this.replacements = cArr;
            this.replaceLength = cArr.length;
        }

        public String escape(String str) {
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                char[][] cArr = this.replacements;
                if (charAt < cArr.length && cArr[charAt] != null) {
                    return escapeSlow(str, i2);
                }
            }
            return str;
        }

        public char[] escape(char c) {
            if (c < this.replaceLength) {
                return this.replacements[c];
            }
            return null;
        }
    }
}
