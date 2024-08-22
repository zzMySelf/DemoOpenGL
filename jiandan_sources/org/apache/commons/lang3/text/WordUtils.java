package org.apache.commons.lang3.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;

public class WordUtils {
    public static String capitalize(String str) {
        return capitalize(str, (char[]) null);
    }

    public static String capitalizeFully(String str) {
        return capitalizeFully(str, (char[]) null);
    }

    public static boolean containsAllWords(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (StringUtils.isEmpty(charSequence) || ArrayUtils.isEmpty((Object[]) charSequenceArr)) {
            return false;
        }
        for (CharSequence charSequence2 : charSequenceArr) {
            if (StringUtils.isBlank(charSequence2)) {
                return false;
            }
            if (!Pattern.compile(".*\\b" + charSequence2 + "\\b.*").matcher(charSequence).matches()) {
                return false;
            }
        }
        return true;
    }

    public static String initials(String str) {
        return initials(str, (char[]) null);
    }

    public static boolean isDelimiter(char c, char[] cArr) {
        if (cArr == null) {
            return Character.isWhitespace(c);
        }
        for (char c2 : cArr) {
            if (c == c2) {
                return true;
            }
        }
        return false;
    }

    public static String swapCase(String str) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        boolean z = true;
        for (int i2 = 0; i2 < charArray.length; i2++) {
            char c = charArray[i2];
            if (Character.isUpperCase(c)) {
                charArray[i2] = Character.toLowerCase(c);
            } else if (Character.isTitleCase(c)) {
                charArray[i2] = Character.toLowerCase(c);
            } else {
                if (!Character.isLowerCase(c)) {
                    z = Character.isWhitespace(c);
                } else if (z) {
                    charArray[i2] = Character.toTitleCase(c);
                } else {
                    charArray[i2] = Character.toUpperCase(c);
                }
            }
            z = false;
        }
        return new String(charArray);
    }

    public static String uncapitalize(String str) {
        return uncapitalize(str, (char[]) null);
    }

    public static String wrap(String str, int i2) {
        return wrap(str, i2, (String) null, false);
    }

    public static String capitalize(String str, char... cArr) {
        int length = cArr == null ? -1 : cArr.length;
        if (StringUtils.isEmpty(str) || length == 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        boolean z = true;
        for (int i2 = 0; i2 < charArray.length; i2++) {
            char c = charArray[i2];
            if (isDelimiter(c, cArr)) {
                z = true;
            } else if (z) {
                charArray[i2] = Character.toTitleCase(c);
                z = false;
            }
        }
        return new String(charArray);
    }

    public static String capitalizeFully(String str, char... cArr) {
        return (StringUtils.isEmpty(str) || (cArr == null ? -1 : cArr.length) == 0) ? str : capitalize(str.toLowerCase(), cArr);
    }

    public static String initials(String str, char... cArr) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        if (cArr != null && cArr.length == 0) {
            return "";
        }
        int length = str.length();
        char[] cArr2 = new char[((length / 2) + 1)];
        int i2 = 0;
        boolean z = true;
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (isDelimiter(charAt, cArr)) {
                z = true;
            } else if (z) {
                cArr2[i2] = charAt;
                i2++;
                z = false;
            }
        }
        return new String(cArr2, 0, i2);
    }

    public static String uncapitalize(String str, char... cArr) {
        int length = cArr == null ? -1 : cArr.length;
        if (StringUtils.isEmpty(str) || length == 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        boolean z = true;
        for (int i2 = 0; i2 < charArray.length; i2++) {
            char c = charArray[i2];
            if (isDelimiter(c, cArr)) {
                z = true;
            } else if (z) {
                charArray[i2] = Character.toLowerCase(c);
                z = false;
            }
        }
        return new String(charArray);
    }

    public static String wrap(String str, int i2, String str2, boolean z) {
        return wrap(str, i2, str2, z, " ");
    }

    public static String wrap(String str, int i2, String str2, boolean z, String str3) {
        if (str == null) {
            return null;
        }
        if (str2 == null) {
            str2 = SystemUtils.LINE_SEPARATOR;
        }
        if (i2 < 1) {
            i2 = 1;
        }
        if (StringUtils.isBlank(str3)) {
            str3 = " ";
        }
        Pattern compile = Pattern.compile(str3);
        int length = str.length();
        int i3 = 0;
        StringBuilder sb = new StringBuilder(length + 32);
        while (i3 < length) {
            int i4 = -1;
            int i5 = i3 + i2;
            Matcher matcher = compile.matcher(str.substring(i3, Math.min(i5 + 1, length)));
            if (matcher.find()) {
                if (matcher.start() == 0) {
                    i3 += matcher.end();
                } else {
                    i4 = matcher.start();
                }
            }
            if (length - i3 <= i2) {
                break;
            }
            while (matcher.find()) {
                i4 = matcher.start() + i3;
            }
            if (i4 >= i3) {
                sb.append(str.substring(i3, i4));
                sb.append(str2);
            } else if (z) {
                sb.append(str.substring(i3, i5));
                sb.append(str2);
                i3 = i5;
            } else {
                Matcher matcher2 = compile.matcher(str.substring(i5));
                if (matcher2.find()) {
                    i4 = matcher2.start() + i3 + i2;
                }
                if (i4 >= 0) {
                    sb.append(str.substring(i3, i4));
                    sb.append(str2);
                } else {
                    sb.append(str.substring(i3));
                    i3 = length;
                }
            }
            i3 = i4 + 1;
        }
        sb.append(str.substring(i3));
        return sb.toString();
    }
}
