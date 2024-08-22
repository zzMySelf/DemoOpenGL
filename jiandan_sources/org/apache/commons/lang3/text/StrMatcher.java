package org.apache.commons.lang3.text;

import com.google.common.base.Ascii;
import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;

public abstract class StrMatcher {
    public static final StrMatcher COMMA_MATCHER = new CharMatcher(',');
    public static final StrMatcher DOUBLE_QUOTE_MATCHER = new CharMatcher('\"');
    public static final StrMatcher NONE_MATCHER = new NoMatcher();
    public static final StrMatcher QUOTE_MATCHER = new CharSetMatcher("'\"".toCharArray());
    public static final StrMatcher SINGLE_QUOTE_MATCHER = new CharMatcher(ExtendedMessageFormat.QUOTE);
    public static final StrMatcher SPACE_MATCHER = new CharMatcher(Ascii.CASE_MASK);
    public static final StrMatcher SPLIT_MATCHER = new CharSetMatcher(" \t\n\r\f".toCharArray());
    public static final StrMatcher TAB_MATCHER = new CharMatcher(9);
    public static final StrMatcher TRIM_MATCHER = new TrimMatcher();

    public static final class CharMatcher extends StrMatcher {
        public final char ch;

        public CharMatcher(char c) {
            this.ch = c;
        }

        public int isMatch(char[] cArr, int i2, int i3, int i4) {
            return this.ch == cArr[i2] ? 1 : 0;
        }
    }

    public static final class CharSetMatcher extends StrMatcher {
        public final char[] chars;

        public CharSetMatcher(char[] cArr) {
            char[] cArr2 = (char[]) cArr.clone();
            this.chars = cArr2;
            Arrays.sort(cArr2);
        }

        public int isMatch(char[] cArr, int i2, int i3, int i4) {
            return Arrays.binarySearch(this.chars, cArr[i2]) >= 0 ? 1 : 0;
        }
    }

    public static final class NoMatcher extends StrMatcher {
        public int isMatch(char[] cArr, int i2, int i3, int i4) {
            return 0;
        }
    }

    public static final class StringMatcher extends StrMatcher {
        public final char[] chars;

        public StringMatcher(String str) {
            this.chars = str.toCharArray();
        }

        public int isMatch(char[] cArr, int i2, int i3, int i4) {
            int length = this.chars.length;
            if (i2 + length > i4) {
                return 0;
            }
            int i5 = 0;
            while (true) {
                char[] cArr2 = this.chars;
                if (i5 >= cArr2.length) {
                    return length;
                }
                if (cArr2[i5] != cArr[i2]) {
                    return 0;
                }
                i5++;
                i2++;
            }
        }

        public String toString() {
            return super.toString() + Ascii.CASE_MASK + Arrays.toString(this.chars);
        }
    }

    public static final class TrimMatcher extends StrMatcher {
        public int isMatch(char[] cArr, int i2, int i3, int i4) {
            return cArr[i2] <= ' ' ? 1 : 0;
        }
    }

    public static StrMatcher charMatcher(char c) {
        return new CharMatcher(c);
    }

    public static StrMatcher charSetMatcher(char... cArr) {
        if (cArr == null || cArr.length == 0) {
            return NONE_MATCHER;
        }
        if (cArr.length == 1) {
            return new CharMatcher(cArr[0]);
        }
        return new CharSetMatcher(cArr);
    }

    public static StrMatcher commaMatcher() {
        return COMMA_MATCHER;
    }

    public static StrMatcher doubleQuoteMatcher() {
        return DOUBLE_QUOTE_MATCHER;
    }

    public static StrMatcher noneMatcher() {
        return NONE_MATCHER;
    }

    public static StrMatcher quoteMatcher() {
        return QUOTE_MATCHER;
    }

    public static StrMatcher singleQuoteMatcher() {
        return SINGLE_QUOTE_MATCHER;
    }

    public static StrMatcher spaceMatcher() {
        return SPACE_MATCHER;
    }

    public static StrMatcher splitMatcher() {
        return SPLIT_MATCHER;
    }

    public static StrMatcher stringMatcher(String str) {
        if (StringUtils.isEmpty(str)) {
            return NONE_MATCHER;
        }
        return new StringMatcher(str);
    }

    public static StrMatcher tabMatcher() {
        return TAB_MATCHER;
    }

    public static StrMatcher trimMatcher() {
        return TRIM_MATCHER;
    }

    public int isMatch(char[] cArr, int i2) {
        return isMatch(cArr, i2, 0, cArr.length);
    }

    public abstract int isMatch(char[] cArr, int i2, int i3, int i4);

    public static StrMatcher charSetMatcher(String str) {
        if (StringUtils.isEmpty(str)) {
            return NONE_MATCHER;
        }
        if (str.length() == 1) {
            return new CharMatcher(str.charAt(0));
        }
        return new CharSetMatcher(str.toCharArray());
    }
}
