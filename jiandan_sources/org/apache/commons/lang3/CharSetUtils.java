package org.apache.commons.lang3;

public class CharSetUtils {
    public static boolean containsAny(String str, String... strArr) {
        if (!StringUtils.isEmpty(str) && !deepEmpty(strArr)) {
            CharSet instance = CharSet.getInstance(strArr);
            for (char contains : str.toCharArray()) {
                if (instance.contains(contains)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int count(String str, String... strArr) {
        if (StringUtils.isEmpty(str) || deepEmpty(strArr)) {
            return 0;
        }
        CharSet instance = CharSet.getInstance(strArr);
        int i2 = 0;
        for (char contains : str.toCharArray()) {
            if (instance.contains(contains)) {
                i2++;
            }
        }
        return i2;
    }

    public static boolean deepEmpty(String[] strArr) {
        if (strArr == null) {
            return true;
        }
        for (String isNotEmpty : strArr) {
            if (StringUtils.isNotEmpty(isNotEmpty)) {
                return false;
            }
        }
        return true;
    }

    public static String delete(String str, String... strArr) {
        return (StringUtils.isEmpty(str) || deepEmpty(strArr)) ? str : modify(str, strArr, false);
    }

    public static String keep(String str, String... strArr) {
        if (str == null) {
            return null;
        }
        return (str.isEmpty() || deepEmpty(strArr)) ? "" : modify(str, strArr, true);
    }

    public static String modify(String str, String[] strArr, boolean z) {
        CharSet instance = CharSet.getInstance(strArr);
        StringBuilder sb = new StringBuilder(str.length());
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (instance.contains(charArray[i2]) == z) {
                sb.append(charArray[i2]);
            }
        }
        return sb.toString();
    }

    public static String squeeze(String str, String... strArr) {
        if (StringUtils.isEmpty(str) || deepEmpty(strArr)) {
            return str;
        }
        CharSet instance = CharSet.getInstance(strArr);
        StringBuilder sb = new StringBuilder(str.length());
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        char c = charArray[0];
        sb.append(c);
        Character ch = null;
        Character ch2 = null;
        for (int i2 = 1; i2 < length; i2++) {
            char c2 = charArray[i2];
            if (c2 == c) {
                if (ch != null && c2 == ch.charValue()) {
                } else if (ch2 == null || c2 != ch2.charValue()) {
                    if (instance.contains(c2)) {
                        ch = Character.valueOf(c2);
                    } else {
                        ch2 = Character.valueOf(c2);
                    }
                }
            }
            sb.append(c2);
            c = c2;
        }
        return sb.toString();
    }
}
