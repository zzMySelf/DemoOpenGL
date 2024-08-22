package org.apache.commons.lang3;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharSet implements Serializable {
    public static final CharSet ASCII_ALPHA = new CharSet("a-zA-Z");
    public static final CharSet ASCII_ALPHA_LOWER = new CharSet("a-z");
    public static final CharSet ASCII_ALPHA_UPPER = new CharSet("A-Z");
    public static final CharSet ASCII_NUMERIC = new CharSet("0-9");
    public static final Map<String, CharSet> COMMON;
    public static final CharSet EMPTY = new CharSet(null);
    public static final long serialVersionUID = 5947847346149275958L;
    public final Set<CharRange> set = Collections.synchronizedSet(new HashSet());

    static {
        Map<String, CharSet> synchronizedMap = Collections.synchronizedMap(new HashMap());
        COMMON = synchronizedMap;
        synchronizedMap.put((Object) null, EMPTY);
        COMMON.put("", EMPTY);
        COMMON.put("a-zA-Z", ASCII_ALPHA);
        COMMON.put("A-Za-z", ASCII_ALPHA);
        COMMON.put("a-z", ASCII_ALPHA_LOWER);
        COMMON.put("A-Z", ASCII_ALPHA_UPPER);
        COMMON.put("0-9", ASCII_NUMERIC);
    }

    public CharSet(String... strArr) {
        for (String add : strArr) {
            add(add);
        }
    }

    public static CharSet getInstance(String... strArr) {
        CharSet charSet;
        if (strArr == null) {
            return null;
        }
        if (strArr.length != 1 || (charSet = COMMON.get(strArr[0])) == null) {
            return new CharSet(strArr);
        }
        return charSet;
    }

    public void add(String str) {
        if (str != null) {
            int length = str.length();
            int i2 = 0;
            while (i2 < length) {
                int i3 = length - i2;
                if (i3 >= 4 && str.charAt(i2) == '^' && str.charAt(i2 + 2) == '-') {
                    this.set.add(CharRange.isNotIn(str.charAt(i2 + 1), str.charAt(i2 + 3)));
                    i2 += 4;
                } else if (i3 >= 3 && str.charAt(i2 + 1) == '-') {
                    this.set.add(CharRange.isIn(str.charAt(i2), str.charAt(i2 + 2)));
                    i2 += 3;
                } else if (i3 < 2 || str.charAt(i2) != '^') {
                    this.set.add(CharRange.is(str.charAt(i2)));
                    i2++;
                } else {
                    this.set.add(CharRange.isNot(str.charAt(i2 + 1)));
                    i2 += 2;
                }
            }
        }
    }

    public boolean contains(char c) {
        for (CharRange contains : this.set) {
            if (contains.contains(c)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CharSet)) {
            return false;
        }
        return this.set.equals(((CharSet) obj).set);
    }

    public CharRange[] getCharRanges() {
        Set<CharRange> set2 = this.set;
        return (CharRange[]) set2.toArray(new CharRange[set2.size()]);
    }

    public int hashCode() {
        return this.set.hashCode() + 89;
    }

    public String toString() {
        return this.set.toString();
    }
}
