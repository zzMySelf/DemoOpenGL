package org.apache.commons.lang3;

import com.google.common.base.Ascii;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Pattern;

public class StringUtils {
    public static final String CR = "\r";
    public static final String EMPTY = "";
    public static final int INDEX_NOT_FOUND = -1;
    public static final String LF = "\n";
    public static final int PAD_LIMIT = 8192;
    public static final String SPACE = " ";

    public static String abbreviate(String str, int i2) {
        return abbreviate(str, 0, i2);
    }

    public static String abbreviateMiddle(String str, String str2, int i2) {
        if (isEmpty(str) || isEmpty(str2) || i2 >= str.length() || i2 < str2.length() + 2) {
            return str;
        }
        int length = i2 - str2.length();
        int i3 = length / 2;
        int i4 = (length % 2) + i3;
        int length2 = str.length() - i3;
        StringBuilder sb = new StringBuilder(i2);
        sb.append(str.substring(0, i4));
        sb.append(str2);
        sb.append(str.substring(length2));
        return sb.toString();
    }

    public static String appendIfMissing(String str, CharSequence charSequence, boolean z, CharSequence... charSequenceArr) {
        if (str == null || isEmpty(charSequence) || endsWith(str, charSequence, z)) {
            return str;
        }
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            for (CharSequence endsWith : charSequenceArr) {
                if (endsWith(str, endsWith, z)) {
                    return str;
                }
            }
        }
        return str + charSequence.toString();
    }

    public static String appendIfMissingIgnoreCase(String str, CharSequence charSequence, CharSequence... charSequenceArr) {
        return appendIfMissing(str, charSequence, true, charSequenceArr);
    }

    public static String capitalize(String str) {
        int length;
        char charAt;
        char titleCase;
        if (str == null || (length = str.length()) == 0 || (charAt = str.charAt(0)) == (titleCase = Character.toTitleCase(charAt))) {
            return str;
        }
        char[] cArr = new char[length];
        cArr[0] = titleCase;
        str.getChars(1, length, cArr, 1);
        return String.valueOf(cArr);
    }

    public static String center(String str, int i2) {
        return center(str, i2, (char) Ascii.CASE_MASK);
    }

    public static String chomp(String str) {
        if (isEmpty(str)) {
            return str;
        }
        if (str.length() == 1) {
            char charAt = str.charAt(0);
            return (charAt == 13 || charAt == 10) ? "" : str;
        }
        int length = str.length() - 1;
        char charAt2 = str.charAt(length);
        if (charAt2 == 10) {
            if (str.charAt(length - 1) == 13) {
                length--;
            }
        } else if (charAt2 != 13) {
            length++;
        }
        return str.substring(0, length);
    }

    public static String chop(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length < 2) {
            return "";
        }
        int i2 = length - 1;
        String substring = str.substring(0, i2);
        if (str.charAt(i2) == 10) {
            int i3 = i2 - 1;
            if (substring.charAt(i3) == 13) {
                return substring.substring(0, i3);
            }
        }
        return substring;
    }

    public static int compare(String str, String str2) {
        return compare(str, str2, true);
    }

    public static int compareIgnoreCase(String str, String str2) {
        return compareIgnoreCase(str, str2, true);
    }

    public static boolean contains(CharSequence charSequence, int i2) {
        if (!isEmpty(charSequence) && CharSequenceUtils.indexOf(charSequence, i2, 0) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean containsAny(CharSequence charSequence, char... cArr) {
        if (!isEmpty(charSequence) && !ArrayUtils.isEmpty(cArr)) {
            int length = charSequence.length();
            int length2 = cArr.length;
            int i2 = length - 1;
            int i3 = length2 - 1;
            for (int i4 = 0; i4 < length; i4++) {
                char charAt = charSequence.charAt(i4);
                for (int i5 = 0; i5 < length2; i5++) {
                    if (cArr[i5] == charAt) {
                        if (!Character.isHighSurrogate(charAt) || i5 == i3) {
                            return true;
                        }
                        if (i4 < i2 && cArr[i5 + 1] == charSequence.charAt(i4 + 1)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean containsIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        if (!(charSequence == null || charSequence2 == null)) {
            int length = charSequence2.length();
            int length2 = charSequence.length() - length;
            for (int i2 = 0; i2 <= length2; i2++) {
                if (CharSequenceUtils.regionMatches(charSequence, true, i2, charSequence2, 0, length)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containsNone(CharSequence charSequence, char... cArr) {
        if (!(charSequence == null || cArr == null)) {
            int length = charSequence.length();
            int i2 = length - 1;
            int length2 = cArr.length;
            int i3 = length2 - 1;
            for (int i4 = 0; i4 < length; i4++) {
                char charAt = charSequence.charAt(i4);
                for (int i5 = 0; i5 < length2; i5++) {
                    if (cArr[i5] == charAt) {
                        if (!Character.isHighSurrogate(charAt) || i5 == i3) {
                            return false;
                        }
                        if (i4 < i2 && cArr[i5 + 1] == charSequence.charAt(i4 + 1)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean containsOnly(CharSequence charSequence, char... cArr) {
        if (cArr == null || charSequence == null) {
            return false;
        }
        if (charSequence.length() == 0) {
            return true;
        }
        if (cArr.length != 0 && indexOfAnyBut(charSequence, cArr) == -1) {
            return true;
        }
        return false;
    }

    public static boolean containsWhitespace(CharSequence charSequence) {
        if (isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (Character.isWhitespace(charSequence.charAt(i2))) {
                return true;
            }
        }
        return false;
    }

    public static void convertRemainingAccentCharacters(StringBuilder sb) {
        for (int i2 = 0; i2 < sb.length(); i2++) {
            if (sb.charAt(i2) == 321) {
                sb.deleteCharAt(i2);
                sb.insert(i2, 'L');
            } else if (sb.charAt(i2) == 322) {
                sb.deleteCharAt(i2);
                sb.insert(i2, 'l');
            }
        }
    }

    public static int countMatches(CharSequence charSequence, CharSequence charSequence2) {
        int i2 = 0;
        if (isEmpty(charSequence) || isEmpty(charSequence2)) {
            return 0;
        }
        int i3 = 0;
        while (true) {
            int indexOf = CharSequenceUtils.indexOf(charSequence, charSequence2, i2);
            if (indexOf == -1) {
                return i3;
            }
            i3++;
            i2 = indexOf + charSequence2.length();
        }
    }

    public static <T extends CharSequence> T defaultIfBlank(T t, T t2) {
        return isBlank(t) ? t2 : t;
    }

    public static <T extends CharSequence> T defaultIfEmpty(T t, T t2) {
        return isEmpty(t) ? t2 : t;
    }

    public static String defaultString(String str) {
        return str == null ? "" : str;
    }

    public static String defaultString(String str, String str2) {
        return str == null ? str2 : str;
    }

    public static String deleteWhitespace(String str) {
        if (isEmpty(str)) {
            return str;
        }
        int length = str.length();
        char[] cArr = new char[length];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (!Character.isWhitespace(str.charAt(i3))) {
                cArr[i2] = str.charAt(i3);
                i2++;
            }
        }
        if (i2 == length) {
            return str;
        }
        return new String(cArr, 0, i2);
    }

    public static String difference(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        int indexOfDifference = indexOfDifference(str, str2);
        if (indexOfDifference == -1) {
            return "";
        }
        return str2.substring(indexOfDifference);
    }

    public static boolean endsWith(CharSequence charSequence, CharSequence charSequence2) {
        return endsWith(charSequence, charSequence2, false);
    }

    public static boolean endsWithAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (!isEmpty(charSequence) && !ArrayUtils.isEmpty((Object[]) charSequenceArr)) {
            for (CharSequence endsWith : charSequenceArr) {
                if (endsWith(charSequence, endsWith)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean endsWithIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        return endsWith(charSequence, charSequence2, true);
    }

    public static boolean equals(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return charSequence.equals(charSequence2);
        }
        return CharSequenceUtils.regionMatches(charSequence, false, 0, charSequence2, 0, charSequence.length());
    }

    public static boolean equalsAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (ArrayUtils.isNotEmpty((T[]) charSequenceArr)) {
            for (CharSequence equals : charSequenceArr) {
                if (equals(charSequence, equals)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean equalsAnyIgnoreCase(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (ArrayUtils.isNotEmpty((T[]) charSequenceArr)) {
            for (CharSequence equalsIgnoreCase : charSequenceArr) {
                if (equalsIgnoreCase(charSequence, equalsIgnoreCase)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean equalsIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            if (charSequence == charSequence2) {
                return true;
            }
            return false;
        } else if (charSequence == charSequence2) {
            return true;
        } else {
            if (charSequence.length() != charSequence2.length()) {
                return false;
            }
            return CharSequenceUtils.regionMatches(charSequence, true, 0, charSequence2, 0, charSequence.length());
        }
    }

    public static String getCommonPrefix(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        int indexOfDifference = indexOfDifference(strArr);
        if (indexOfDifference == -1) {
            if (strArr[0] == null) {
                return "";
            }
            return strArr[0];
        } else if (indexOfDifference == 0) {
            return "";
        } else {
            return strArr[0].substring(0, indexOfDifference);
        }
    }

    public static int getFuzzyDistance(CharSequence charSequence, CharSequence charSequence2, Locale locale) {
        if (charSequence == null || charSequence2 == null) {
            throw new IllegalArgumentException("Strings must not be null");
        } else if (locale != null) {
            String lowerCase = charSequence.toString().toLowerCase(locale);
            String lowerCase2 = charSequence2.toString().toLowerCase(locale);
            int i2 = Integer.MIN_VALUE;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < lowerCase2.length(); i5++) {
                char charAt = lowerCase2.charAt(i5);
                boolean z = false;
                while (i4 < lowerCase.length() && !z) {
                    if (charAt == lowerCase.charAt(i4)) {
                        i3++;
                        if (i2 + 1 == i4) {
                            i3 += 2;
                        }
                        z = true;
                        i2 = i4;
                    }
                    i4++;
                }
            }
            return i3;
        } else {
            throw new IllegalArgumentException("Locale must not be null");
        }
    }

    public static double getJaroWinklerDistance(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            throw new IllegalArgumentException("Strings must not be null");
        }
        int[] matches = matches(charSequence, charSequence2);
        double d = (double) matches[0];
        if (d == 0.0d) {
            return 0.0d;
        }
        double length = (((d / ((double) charSequence.length())) + (d / ((double) charSequence2.length()))) + ((d - ((double) matches[1])) / d)) / 3.0d;
        if (length >= 0.7d) {
            length += Math.min(0.1d, 1.0d / ((double) matches[3])) * ((double) matches[2]) * (1.0d - length);
        }
        return ((double) Math.round(length * 100.0d)) / 100.0d;
    }

    public static int getLevenshteinDistance(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            throw new IllegalArgumentException("Strings must not be null");
        }
        int length = charSequence.length();
        int length2 = charSequence2.length();
        if (length == 0) {
            return length2;
        }
        if (length2 == 0) {
            return length;
        }
        if (length > length2) {
            int i2 = length2;
            length2 = charSequence.length();
            length = i2;
        } else {
            CharSequence charSequence3 = charSequence2;
            charSequence2 = charSequence;
            charSequence = charSequence3;
        }
        int i3 = length + 1;
        int[] iArr = new int[i3];
        int[] iArr2 = new int[i3];
        for (int i4 = 0; i4 <= length; i4++) {
            iArr[i4] = i4;
        }
        int i5 = 1;
        while (i5 <= length2) {
            char charAt = charSequence.charAt(i5 - 1);
            iArr2[0] = i5;
            for (int i6 = 1; i6 <= length; i6++) {
                int i7 = i6 - 1;
                iArr2[i6] = Math.min(Math.min(iArr2[i7] + 1, iArr[i6] + 1), iArr[i7] + (charSequence2.charAt(i7) == charAt ? 0 : 1));
            }
            i5++;
            int[] iArr3 = iArr;
            iArr = iArr2;
            iArr2 = iArr3;
        }
        return iArr[length];
    }

    public static int indexOf(CharSequence charSequence, int i2) {
        if (isEmpty(charSequence)) {
            return -1;
        }
        return CharSequenceUtils.indexOf(charSequence, i2, 0);
    }

    public static int indexOfAny(CharSequence charSequence, char... cArr) {
        if (!isEmpty(charSequence) && !ArrayUtils.isEmpty(cArr)) {
            int length = charSequence.length();
            int i2 = length - 1;
            int length2 = cArr.length;
            int i3 = length2 - 1;
            for (int i4 = 0; i4 < length; i4++) {
                char charAt = charSequence.charAt(i4);
                for (int i5 = 0; i5 < length2; i5++) {
                    if (cArr[i5] == charAt && (i4 >= i2 || i5 >= i3 || !Character.isHighSurrogate(charAt) || cArr[i5 + 1] == charSequence.charAt(i4 + 1))) {
                        return i4;
                    }
                }
            }
        }
        return -1;
    }

    public static int indexOfAnyBut(CharSequence charSequence, char... cArr) {
        if (!isEmpty(charSequence) && !ArrayUtils.isEmpty(cArr)) {
            int length = charSequence.length();
            int i2 = length - 1;
            int length2 = cArr.length;
            int i3 = length2 - 1;
            int i4 = 0;
            while (i4 < length) {
                char charAt = charSequence.charAt(i4);
                int i5 = 0;
                while (i5 < length2) {
                    if (cArr[i5] != charAt || (i4 < i2 && i5 < i3 && Character.isHighSurrogate(charAt) && cArr[i5 + 1] != charSequence.charAt(i4 + 1))) {
                        i5++;
                    } else {
                        i4++;
                    }
                }
                return i4;
            }
        }
        return -1;
    }

    public static int indexOfDifference(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == charSequence2) {
            return -1;
        }
        int i2 = 0;
        if (!(charSequence == null || charSequence2 == null)) {
            while (i2 < charSequence.length() && i2 < charSequence2.length() && charSequence.charAt(i2) == charSequence2.charAt(i2)) {
                i2++;
            }
            if (i2 < charSequence2.length() || i2 < charSequence.length()) {
                return i2;
            }
            return -1;
        }
        return i2;
    }

    public static int indexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        return indexOfIgnoreCase(charSequence, charSequence2, 0);
    }

    public static boolean isAllLowerCase(CharSequence charSequence) {
        if (charSequence == null || isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isLowerCase(charSequence.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAllUpperCase(CharSequence charSequence) {
        if (charSequence == null || isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isUpperCase(charSequence.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlpha(CharSequence charSequence) {
        if (isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isLetter(charSequence.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlphaSpace(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isLetter(charSequence.charAt(i2)) && charSequence.charAt(i2) != ' ') {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlphanumeric(CharSequence charSequence) {
        if (isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isLetterOrDigit(charSequence.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlphanumericSpace(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isLetterOrDigit(charSequence.charAt(i2)) && charSequence.charAt(i2) != ' ') {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnyBlank(CharSequence... charSequenceArr) {
        if (ArrayUtils.isEmpty((Object[]) charSequenceArr)) {
            return true;
        }
        for (CharSequence isBlank : charSequenceArr) {
            if (isBlank(isBlank)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAnyEmpty(CharSequence... charSequenceArr) {
        if (ArrayUtils.isEmpty((Object[]) charSequenceArr)) {
            return true;
        }
        for (CharSequence isEmpty : charSequenceArr) {
            if (isEmpty(isEmpty)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAsciiPrintable(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!CharUtils.isAsciiPrintable(charSequence.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isBlank(CharSequence charSequence) {
        int length;
        if (!(charSequence == null || (length = charSequence.length()) == 0)) {
            for (int i2 = 0; i2 < length; i2++) {
                if (!Character.isWhitespace(charSequence.charAt(i2))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean isNoneBlank(CharSequence... charSequenceArr) {
        return !isAnyBlank(charSequenceArr);
    }

    public static boolean isNoneEmpty(CharSequence... charSequenceArr) {
        return !isAnyEmpty(charSequenceArr);
    }

    public static boolean isNotBlank(CharSequence charSequence) {
        return !isBlank(charSequence);
    }

    public static boolean isNotEmpty(CharSequence charSequence) {
        return !isEmpty(charSequence);
    }

    public static boolean isNumeric(CharSequence charSequence) {
        if (isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isDigit(charSequence.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumericSpace(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isDigit(charSequence.charAt(i2)) && charSequence.charAt(i2) != ' ') {
                return false;
            }
        }
        return true;
    }

    public static boolean isWhitespace(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isWhitespace(charSequence.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public static <T> String join(T... tArr) {
        return join((Object[]) tArr, (String) null);
    }

    public static String joinWith(String str, Object... objArr) {
        if (objArr != null) {
            String defaultString = defaultString(str, "");
            StringBuilder sb = new StringBuilder();
            Iterator it = Arrays.asList(objArr).iterator();
            while (it.hasNext()) {
                sb.append(ObjectUtils.toString(it.next()));
                if (it.hasNext()) {
                    sb.append(defaultString);
                }
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("Object varargs must not be null");
    }

    public static int lastIndexOf(CharSequence charSequence, int i2) {
        if (isEmpty(charSequence)) {
            return -1;
        }
        return CharSequenceUtils.lastIndexOf(charSequence, i2, charSequence.length());
    }

    public static int lastIndexOfAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        int lastIndexOf;
        int i2 = -1;
        if (!(charSequence == null || charSequenceArr == null)) {
            for (CharSequence charSequence2 : charSequenceArr) {
                if (charSequence2 != null && (lastIndexOf = CharSequenceUtils.lastIndexOf(charSequence, charSequence2, charSequence.length())) > i2) {
                    i2 = lastIndexOf;
                }
            }
        }
        return i2;
    }

    public static int lastIndexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        return lastIndexOfIgnoreCase(charSequence, charSequence2, charSequence.length());
    }

    public static int lastOrdinalIndexOf(CharSequence charSequence, CharSequence charSequence2, int i2) {
        return ordinalIndexOf(charSequence, charSequence2, i2, true);
    }

    public static String left(String str, int i2) {
        if (str == null) {
            return null;
        }
        if (i2 < 0) {
            return "";
        }
        if (str.length() <= i2) {
            return str;
        }
        return str.substring(0, i2);
    }

    public static String leftPad(String str, int i2) {
        return leftPad(str, i2, (char) Ascii.CASE_MASK);
    }

    public static int length(CharSequence charSequence) {
        if (charSequence == null) {
            return 0;
        }
        return charSequence.length();
    }

    public static String lowerCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase();
    }

    public static int[] matches(CharSequence charSequence, CharSequence charSequence2) {
        CharSequence charSequence3;
        CharSequence charSequence4;
        if (charSequence.length() > charSequence2.length()) {
            charSequence4 = charSequence;
            charSequence3 = charSequence2;
        } else {
            charSequence3 = charSequence;
            charSequence4 = charSequence2;
        }
        int max = Math.max((charSequence4.length() / 2) - 1, 0);
        int[] iArr = new int[charSequence3.length()];
        Arrays.fill(iArr, -1);
        boolean[] zArr = new boolean[charSequence4.length()];
        int i2 = 0;
        for (int i3 = 0; i3 < charSequence3.length(); i3++) {
            char charAt = charSequence3.charAt(i3);
            int max2 = Math.max(i3 - max, 0);
            int min = Math.min(i3 + max + 1, charSequence4.length());
            while (true) {
                if (max2 < min) {
                    if (!zArr[max2] && charAt == charSequence4.charAt(max2)) {
                        iArr[i3] = max2;
                        zArr[max2] = true;
                        i2++;
                        break;
                    }
                    max2++;
                } else {
                    break;
                }
            }
        }
        char[] cArr = new char[i2];
        char[] cArr2 = new char[i2];
        int i4 = 0;
        for (int i5 = 0; i5 < charSequence3.length(); i5++) {
            if (iArr[i5] != -1) {
                cArr[i4] = charSequence3.charAt(i5);
                i4++;
            }
        }
        int i6 = 0;
        for (int i7 = 0; i7 < charSequence4.length(); i7++) {
            if (zArr[i7]) {
                cArr2[i6] = charSequence4.charAt(i7);
                i6++;
            }
        }
        int i8 = 0;
        for (int i9 = 0; i9 < i2; i9++) {
            if (cArr[i9] != cArr2[i9]) {
                i8++;
            }
        }
        int i10 = 0;
        for (int i11 = 0; i11 < charSequence3.length(); i11++) {
            CharSequence charSequence5 = charSequence;
            if (charSequence.charAt(i11) != charSequence2.charAt(i11)) {
                break;
            }
            i10++;
        }
        return new int[]{i2, i8 / 2, i10, charSequence4.length()};
    }

    public static String mid(String str, int i2, int i3) {
        if (str == null) {
            return null;
        }
        if (i3 < 0 || i2 > str.length()) {
            return "";
        }
        if (i2 < 0) {
            i2 = 0;
        }
        int i4 = i3 + i2;
        if (str.length() <= i4) {
            return str.substring(i2);
        }
        return str.substring(i2, i4);
    }

    public static String normalizeSpace(String str) {
        if (isEmpty(str)) {
            return str;
        }
        int length = str.length();
        char[] cArr = new char[length];
        int i2 = 1;
        boolean z = true;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            char charAt = str.charAt(i5);
            if (!Character.isWhitespace(charAt)) {
                int i6 = i3 + 1;
                if (charAt == 160) {
                    charAt = Ascii.CASE_MASK;
                }
                cArr[i3] = charAt;
                i3 = i6;
                z = false;
                i4 = 0;
            } else {
                if (i4 == 0 && !z) {
                    cArr[i3] = " ".charAt(0);
                    i3++;
                }
                i4++;
            }
        }
        if (z) {
            return "";
        }
        if (i4 <= 0) {
            i2 = 0;
        }
        return new String(cArr, 0, i3 - i2).trim();
    }

    public static int ordinalIndexOf(CharSequence charSequence, CharSequence charSequence2, int i2) {
        return ordinalIndexOf(charSequence, charSequence2, i2, false);
    }

    public static String overlay(String str, String str2, int i2, int i3) {
        if (str == null) {
            return null;
        }
        if (str2 == null) {
            str2 = "";
        }
        int length = str.length();
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 > length) {
            i2 = length;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        if (i3 > length) {
            i3 = length;
        }
        if (i2 > i3) {
            int i4 = i3;
            i3 = i2;
            i2 = i4;
        }
        StringBuilder sb = new StringBuilder(((length + i2) - i3) + str2.length() + 1);
        sb.append(str.substring(0, i2));
        sb.append(str2);
        sb.append(str.substring(i3));
        return sb.toString();
    }

    public static String prependIfMissing(String str, CharSequence charSequence, boolean z, CharSequence... charSequenceArr) {
        if (str == null || isEmpty(charSequence) || startsWith(str, charSequence, z)) {
            return str;
        }
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            for (CharSequence startsWith : charSequenceArr) {
                if (startsWith(str, startsWith, z)) {
                    return str;
                }
            }
        }
        return charSequence.toString() + str;
    }

    public static String prependIfMissingIgnoreCase(String str, CharSequence charSequence, CharSequence... charSequenceArr) {
        return prependIfMissing(str, charSequence, true, charSequenceArr);
    }

    public static String remove(String str, String str2) {
        return (isEmpty(str) || isEmpty(str2)) ? str : replace(str, str2, "", -1);
    }

    public static String removeAll(String str, String str2) {
        return replaceAll(str, str2, "");
    }

    public static String removeEnd(String str, String str2) {
        return (isEmpty(str) || isEmpty(str2) || !str.endsWith(str2)) ? str : str.substring(0, str.length() - str2.length());
    }

    public static String removeEndIgnoreCase(String str, String str2) {
        return (isEmpty(str) || isEmpty(str2) || !endsWithIgnoreCase(str, str2)) ? str : str.substring(0, str.length() - str2.length());
    }

    public static String removeFirst(String str, String str2) {
        return replaceFirst(str, str2, "");
    }

    public static String removeIgnoreCase(String str, String str2) {
        return (isEmpty(str) || isEmpty(str2)) ? str : replaceIgnoreCase(str, str2, "", -1);
    }

    public static String removePattern(String str, String str2) {
        return replacePattern(str, str2, "");
    }

    public static String removeStart(String str, String str2) {
        return (isEmpty(str) || isEmpty(str2) || !str.startsWith(str2)) ? str : str.substring(str2.length());
    }

    public static String removeStartIgnoreCase(String str, String str2) {
        return (isEmpty(str) || isEmpty(str2) || !startsWithIgnoreCase(str, str2)) ? str : str.substring(str2.length());
    }

    public static String repeat(String str, int i2) {
        if (str == null) {
            return null;
        }
        if (i2 <= 0) {
            return "";
        }
        int length = str.length();
        if (i2 == 1 || length == 0) {
            return str;
        }
        if (length == 1 && i2 <= 8192) {
            return repeat(str.charAt(0), i2);
        }
        int i3 = length * i2;
        if (length == 1) {
            return repeat(str.charAt(0), i2);
        }
        if (length != 2) {
            StringBuilder sb = new StringBuilder(i3);
            for (int i4 = 0; i4 < i2; i4++) {
                sb.append(str);
            }
            return sb.toString();
        }
        char charAt = str.charAt(0);
        char charAt2 = str.charAt(1);
        char[] cArr = new char[i3];
        for (int i5 = (i2 * 2) - 2; i5 >= 0; i5 = (i5 - 1) - 1) {
            cArr[i5] = charAt;
            cArr[i5 + 1] = charAt2;
        }
        return new String(cArr);
    }

    public static String replace(String str, String str2, String str3) {
        return replace(str, str2, str3, -1);
    }

    public static String replaceAll(String str, String str2, String str3) {
        return (str == null || str2 == null || str3 == null) ? str : str.replaceAll(str2, str3);
    }

    public static String replaceChars(String str, char c, char c2) {
        if (str == null) {
            return null;
        }
        return str.replace(c, c2);
    }

    public static String replaceEach(String str, String[] strArr, String[] strArr2) {
        return replaceEach(str, strArr, strArr2, false, 0);
    }

    public static String replaceEachRepeatedly(String str, String[] strArr, String[] strArr2) {
        return replaceEach(str, strArr, strArr2, true, strArr == null ? 0 : strArr.length);
    }

    public static String replaceFirst(String str, String str2, String str3) {
        return (str == null || str2 == null || str3 == null) ? str : str.replaceFirst(str2, str3);
    }

    public static String replaceIgnoreCase(String str, String str2, String str3) {
        return replaceIgnoreCase(str, str2, str3, -1);
    }

    public static String replaceOnce(String str, String str2, String str3) {
        return replace(str, str2, str3, 1);
    }

    public static String replaceOnceIgnoreCase(String str, String str2, String str3) {
        return replaceIgnoreCase(str, str2, str3, 1);
    }

    public static String replacePattern(String str, String str2, String str3) {
        return (str == null || str2 == null || str3 == null) ? str : Pattern.compile(str2, 32).matcher(str).replaceAll(str3);
    }

    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }

    public static String reverseDelimited(String str, char c) {
        if (str == null) {
            return null;
        }
        String[] split = split(str, c);
        ArrayUtils.reverse((Object[]) split);
        return join((Object[]) split, c);
    }

    public static String right(String str, int i2) {
        if (str == null) {
            return null;
        }
        if (i2 < 0) {
            return "";
        }
        if (str.length() <= i2) {
            return str;
        }
        return str.substring(str.length() - i2);
    }

    public static String rightPad(String str, int i2) {
        return rightPad(str, i2, (char) Ascii.CASE_MASK);
    }

    public static String rotate(String str, int i2) {
        int i3;
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (i2 == 0 || length == 0 || (i3 = i2 % length) == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder(length);
        int i4 = -i3;
        sb.append(substring(str, i4));
        sb.append(substring(str, 0, i4));
        return sb.toString();
    }

    public static String[] split(String str) {
        return split(str, (String) null, -1);
    }

    public static String[] splitByCharacterType(String str) {
        return splitByCharacterType(str, false);
    }

    public static String[] splitByCharacterTypeCamelCase(String str) {
        return splitByCharacterType(str, true);
    }

    public static String[] splitByWholeSeparator(String str, String str2) {
        return splitByWholeSeparatorWorker(str, str2, -1, false);
    }

    public static String[] splitByWholeSeparatorPreserveAllTokens(String str, String str2) {
        return splitByWholeSeparatorWorker(str, str2, -1, true);
    }

    public static String[] splitByWholeSeparatorWorker(String str, String str2, int i2, boolean z) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        if (str2 == null || "".equals(str2)) {
            return splitWorker(str, (String) null, i2, z);
        }
        int length2 = str2.length();
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < length) {
            i3 = str.indexOf(str2, i4);
            if (i3 > -1) {
                if (i3 > i4) {
                    i5++;
                    if (i5 == i2) {
                        arrayList.add(str.substring(i4));
                    } else {
                        arrayList.add(str.substring(i4, i3));
                    }
                } else if (z) {
                    i5++;
                    if (i5 == i2) {
                        arrayList.add(str.substring(i4));
                        i3 = length;
                    } else {
                        arrayList.add("");
                    }
                }
                i4 = i3 + length2;
            } else {
                arrayList.add(str.substring(i4));
            }
            i3 = length;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] splitPreserveAllTokens(String str) {
        return splitWorker(str, (String) null, -1, true);
    }

    public static String[] splitWorker(String str, char c, boolean z) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        boolean z2 = false;
        boolean z3 = false;
        int i3 = 0;
        while (i2 < length) {
            if (str.charAt(i2) == c) {
                if (z2 || z) {
                    arrayList.add(str.substring(i3, i2));
                    z2 = false;
                    z3 = true;
                }
                i3 = i2 + 1;
                i2 = i3;
            } else {
                i2++;
                z2 = true;
                z3 = false;
            }
        }
        if (z2 || (z && z3)) {
            arrayList.add(str.substring(i3, i2));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean startsWith(CharSequence charSequence, CharSequence charSequence2) {
        return startsWith(charSequence, charSequence2, false);
    }

    public static boolean startsWithAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (!isEmpty(charSequence) && !ArrayUtils.isEmpty((Object[]) charSequenceArr)) {
            for (CharSequence startsWith : charSequenceArr) {
                if (startsWith(charSequence, startsWith)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean startsWithIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        return startsWith(charSequence, charSequence2, true);
    }

    public static String strip(String str) {
        return strip(str, (String) null);
    }

    public static String stripAccents(String str) {
        if (str == null) {
            return null;
        }
        Pattern compile = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        StringBuilder sb = new StringBuilder(Normalizer.normalize(str, Normalizer.Form.NFD));
        convertRemainingAccentCharacters(sb);
        return compile.matcher(sb).replaceAll("");
    }

    public static String[] stripAll(String... strArr) {
        return stripAll(strArr, (String) null);
    }

    public static String stripEnd(String str, String str2) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return str;
        }
        if (str2 == null) {
            while (length != 0 && Character.isWhitespace(str.charAt(length - 1))) {
                length--;
            }
        } else if (str2.isEmpty()) {
            return str;
        } else {
            while (length != 0 && str2.indexOf(str.charAt(length - 1)) != -1) {
                length--;
            }
        }
        return str.substring(0, length);
    }

    public static String stripStart(String str, String str2) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return str;
        }
        int i2 = 0;
        if (str2 == null) {
            while (i2 != length && Character.isWhitespace(str.charAt(i2))) {
                i2++;
            }
        } else if (str2.isEmpty()) {
            return str;
        } else {
            while (i2 != length && str2.indexOf(str.charAt(i2)) != -1) {
                i2++;
            }
        }
        return str.substring(i2);
    }

    public static String stripToEmpty(String str) {
        return str == null ? "" : strip(str, (String) null);
    }

    public static String stripToNull(String str) {
        if (str == null) {
            return null;
        }
        String strip = strip(str, (String) null);
        if (strip.isEmpty()) {
            return null;
        }
        return strip;
    }

    public static String substring(String str, int i2) {
        if (str == null) {
            return null;
        }
        if (i2 < 0) {
            i2 += str.length();
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 > str.length()) {
            return "";
        }
        return str.substring(i2);
    }

    public static String substringAfter(String str, String str2) {
        int indexOf;
        if (isEmpty(str)) {
            return str;
        }
        if (str2 == null || (indexOf = str.indexOf(str2)) == -1) {
            return "";
        }
        return str.substring(indexOf + str2.length());
    }

    public static String substringAfterLast(String str, String str2) {
        int lastIndexOf;
        if (isEmpty(str)) {
            return str;
        }
        if (isEmpty(str2) || (lastIndexOf = str.lastIndexOf(str2)) == -1 || lastIndexOf == str.length() - str2.length()) {
            return "";
        }
        return str.substring(lastIndexOf + str2.length());
    }

    public static String substringBefore(String str, String str2) {
        if (isEmpty(str) || str2 == null) {
            return str;
        }
        if (str2.isEmpty()) {
            return "";
        }
        int indexOf = str.indexOf(str2);
        if (indexOf == -1) {
            return str;
        }
        return str.substring(0, indexOf);
    }

    public static String substringBeforeLast(String str, String str2) {
        int lastIndexOf;
        if (isEmpty(str) || isEmpty(str2) || (lastIndexOf = str.lastIndexOf(str2)) == -1) {
            return str;
        }
        return str.substring(0, lastIndexOf);
    }

    public static String substringBetween(String str, String str2) {
        return substringBetween(str, str2, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0032, code lost:
        r5 = r5 + r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String[] substringsBetween(java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            r0 = 0
            if (r7 == 0) goto L_0x0058
            boolean r1 = isEmpty(r8)
            if (r1 != 0) goto L_0x0058
            boolean r1 = isEmpty(r9)
            if (r1 == 0) goto L_0x0010
            goto L_0x0058
        L_0x0010:
            int r1 = r7.length()
            if (r1 != 0) goto L_0x0019
            java.lang.String[] r7 = org.apache.commons.lang3.ArrayUtils.EMPTY_STRING_ARRAY
            return r7
        L_0x0019:
            int r2 = r9.length()
            int r3 = r8.length()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r5 = 0
        L_0x0027:
            int r6 = r1 - r2
            if (r5 >= r6) goto L_0x0044
            int r5 = r7.indexOf(r8, r5)
            if (r5 >= 0) goto L_0x0032
            goto L_0x0044
        L_0x0032:
            int r5 = r5 + r3
            int r6 = r7.indexOf(r9, r5)
            if (r6 >= 0) goto L_0x003a
            goto L_0x0044
        L_0x003a:
            java.lang.String r5 = r7.substring(r5, r6)
            r4.add(r5)
            int r5 = r6 + r2
            goto L_0x0027
        L_0x0044:
            boolean r7 = r4.isEmpty()
            if (r7 == 0) goto L_0x004b
            return r0
        L_0x004b:
            int r7 = r4.size()
            java.lang.String[] r7 = new java.lang.String[r7]
            java.lang.Object[] r7 = r4.toArray(r7)
            java.lang.String[] r7 = (java.lang.String[]) r7
            return r7
        L_0x0058:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.StringUtils.substringsBetween(java.lang.String, java.lang.String, java.lang.String):java.lang.String[]");
    }

    public static String swapCase(String str) {
        if (isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            char c = charArray[i2];
            if (Character.isUpperCase(c)) {
                charArray[i2] = Character.toLowerCase(c);
            } else if (Character.isTitleCase(c)) {
                charArray[i2] = Character.toLowerCase(c);
            } else if (Character.isLowerCase(c)) {
                charArray[i2] = Character.toUpperCase(c);
            }
        }
        return new String(charArray);
    }

    public static String toEncodedString(byte[] bArr, Charset charset) {
        if (charset == null) {
            charset = Charset.defaultCharset();
        }
        return new String(bArr, charset);
    }

    @Deprecated
    public static String toString(byte[] bArr, String str) throws UnsupportedEncodingException {
        String str2;
        if (str == null) {
            str2 = new String(bArr, Charset.defaultCharset());
        }
        return str2;
    }

    public static String trim(String str) {
        if (str == null) {
            return null;
        }
        return str.trim();
    }

    public static String trimToEmpty(String str) {
        return str == null ? "" : str.trim();
    }

    public static String trimToNull(String str) {
        String trim = trim(str);
        if (isEmpty(trim)) {
            return null;
        }
        return trim;
    }

    public static String truncate(String str, int i2) {
        return truncate(str, 0, i2);
    }

    public static String uncapitalize(String str) {
        int length;
        char charAt;
        char lowerCase;
        if (str == null || (length = str.length()) == 0 || (charAt = str.charAt(0)) == (lowerCase = Character.toLowerCase(charAt))) {
            return str;
        }
        char[] cArr = new char[length];
        cArr[0] = lowerCase;
        str.getChars(1, length, cArr, 1);
        return String.valueOf(cArr);
    }

    public static String upperCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase();
    }

    public static String wrap(String str, char c) {
        if (isEmpty(str) || c == 0) {
            return str;
        }
        return c + str + c;
    }

    public static String wrapIfMissing(String str, char c) {
        if (isEmpty(str) || c == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length() + 2);
        if (str.charAt(0) != c) {
            sb.append(c);
        }
        sb.append(str);
        if (str.charAt(str.length() - 1) != c) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static String abbreviate(String str, int i2, int i3) {
        if (str == null) {
            return null;
        }
        if (i3 < 4) {
            throw new IllegalArgumentException("Minimum abbreviation width is 4");
        } else if (str.length() <= i3) {
            return str;
        } else {
            if (i2 > str.length()) {
                i2 = str.length();
            }
            int i4 = i3 - 3;
            if (str.length() - i2 < i4) {
                i2 = str.length() - i4;
            }
            if (i2 <= 4) {
                return str.substring(0, i4) + "...";
            } else if (i3 < 7) {
                throw new IllegalArgumentException("Minimum abbreviation width with offset is 7");
            } else if ((i3 + i2) - 3 < str.length()) {
                return "..." + abbreviate(str.substring(i2), i4);
            } else {
                return "..." + str.substring(str.length() - i4);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r2.length();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String center(java.lang.String r2, int r3, char r4) {
        /*
            if (r2 == 0) goto L_0x0019
            if (r3 > 0) goto L_0x0005
            goto L_0x0019
        L_0x0005:
            int r0 = r2.length()
            int r1 = r3 - r0
            if (r1 > 0) goto L_0x000e
            return r2
        L_0x000e:
            int r1 = r1 / 2
            int r0 = r0 + r1
            java.lang.String r2 = leftPad((java.lang.String) r2, (int) r0, (char) r4)
            java.lang.String r2 = rightPad((java.lang.String) r2, (int) r3, (char) r4)
        L_0x0019:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.StringUtils.center(java.lang.String, int, char):java.lang.String");
    }

    public static int compare(String str, String str2, boolean z) {
        if (str == str2) {
            return 0;
        }
        if (str == null) {
            return z ? -1 : 1;
        }
        if (str2 == null) {
            return z ? 1 : -1;
        }
        return str.compareTo(str2);
    }

    public static int compareIgnoreCase(String str, String str2, boolean z) {
        if (str == str2) {
            return 0;
        }
        if (str == null) {
            return z ? -1 : 1;
        }
        if (str2 == null) {
            return z ? 1 : -1;
        }
        return str.compareToIgnoreCase(str2);
    }

    public static boolean endsWith(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        if (charSequence == null || charSequence2 == null) {
            if (charSequence == null && charSequence2 == null) {
                return true;
            }
            return false;
        } else if (charSequence2.length() > charSequence.length()) {
            return false;
        } else {
            return CharSequenceUtils.regionMatches(charSequence, z, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length());
        }
    }

    public static int indexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2, int i2) {
        if (!(charSequence == null || charSequence2 == null)) {
            if (i2 < 0) {
                i2 = 0;
            }
            int length = (charSequence.length() - charSequence2.length()) + 1;
            if (i2 > length) {
                return -1;
            }
            if (charSequence2.length() == 0) {
                return i2;
            }
            while (i2 < length) {
                if (CharSequenceUtils.regionMatches(charSequence, true, i2, charSequence2, 0, charSequence2.length())) {
                    return i2;
                }
                i2++;
            }
        }
        return -1;
    }

    public static String join(Object[] objArr, char c) {
        if (objArr == null) {
            return null;
        }
        return join(objArr, c, 0, objArr.length);
    }

    public static int lastIndexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2, int i2) {
        if (!(charSequence == null || charSequence2 == null)) {
            if (i2 > charSequence.length() - charSequence2.length()) {
                i2 = charSequence.length() - charSequence2.length();
            }
            if (i2 < 0) {
                return -1;
            }
            if (charSequence2.length() == 0) {
                return i2;
            }
            while (i2 >= 0) {
                if (CharSequenceUtils.regionMatches(charSequence, true, i2, charSequence2, 0, charSequence2.length())) {
                    return i2;
                }
                i2--;
            }
        }
        return -1;
    }

    public static String leftPad(String str, int i2, char c) {
        if (str == null) {
            return null;
        }
        int length = i2 - str.length();
        if (length <= 0) {
            return str;
        }
        if (length > 8192) {
            return leftPad(str, i2, String.valueOf(c));
        }
        return repeat(c, length).concat(str);
    }

    public static String lowerCase(String str, Locale locale) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase(locale);
    }

    public static int ordinalIndexOf(CharSequence charSequence, CharSequence charSequence2, int i2, boolean z) {
        int i3 = -1;
        if (charSequence == null || charSequence2 == null || i2 <= 0) {
            return i3;
        }
        int i4 = 0;
        if (charSequence2.length() != 0) {
            if (z) {
                i3 = charSequence.length();
            }
            do {
                if (z) {
                    i3 = CharSequenceUtils.lastIndexOf(charSequence, charSequence2, i3 - 1);
                } else {
                    i3 = CharSequenceUtils.indexOf(charSequence, charSequence2, i3 + 1);
                }
                if (i3 < 0) {
                    return i3;
                }
                i4++;
            } while (i4 < i2);
            return i3;
        } else if (z) {
            return charSequence.length();
        } else {
            return 0;
        }
    }

    public static String replace(String str, String str2, String str3, int i2) {
        return replace(str, str2, str3, i2, false);
    }

    public static String replaceChars(String str, String str2, String str3) {
        if (isEmpty(str) || isEmpty(str2)) {
            return str;
        }
        if (str3 == null) {
            str3 = "";
        }
        int length = str3.length();
        int length2 = str.length();
        StringBuilder sb = new StringBuilder(length2);
        boolean z = false;
        for (int i2 = 0; i2 < length2; i2++) {
            char charAt = str.charAt(i2);
            int indexOf = str2.indexOf(charAt);
            if (indexOf >= 0) {
                if (indexOf < length) {
                    sb.append(str3.charAt(indexOf));
                }
                z = true;
            } else {
                sb.append(charAt);
            }
        }
        return z ? sb.toString() : str;
    }

    public static String replaceEach(String str, String[] strArr, String[] strArr2, boolean z, int i2) {
        int length;
        if (str == null || str.isEmpty() || strArr == null || strArr.length == 0 || strArr2 == null || strArr2.length == 0) {
            return str;
        }
        if (i2 >= 0) {
            int length2 = strArr.length;
            int length3 = strArr2.length;
            if (length2 == length3) {
                boolean[] zArr = new boolean[length2];
                int i3 = -1;
                int i4 = -1;
                for (int i5 = 0; i5 < length2; i5++) {
                    if (!zArr[i5] && strArr[i5] != null && !strArr[i5].isEmpty() && strArr2[i5] != null) {
                        int indexOf = str.indexOf(strArr[i5]);
                        if (indexOf == -1) {
                            zArr[i5] = true;
                        } else if (i3 == -1 || indexOf < i3) {
                            i4 = i5;
                            i3 = indexOf;
                        }
                    }
                }
                if (i3 == -1) {
                    return str;
                }
                int i6 = 0;
                for (int i7 = 0; i7 < strArr.length; i7++) {
                    if (!(strArr[i7] == null || strArr2[i7] == null || (length = strArr2[i7].length() - strArr[i7].length()) <= 0)) {
                        i6 += length * 3;
                    }
                }
                StringBuilder sb = new StringBuilder(str.length() + Math.min(i6, str.length() / 5));
                int i8 = 0;
                while (i3 != -1) {
                    while (i8 < i3) {
                        sb.append(str.charAt(i8));
                        i8++;
                    }
                    sb.append(strArr2[i4]);
                    i8 = strArr[i4].length() + i3;
                    i3 = -1;
                    i4 = -1;
                    for (int i9 = 0; i9 < length2; i9++) {
                        if (!zArr[i9] && strArr[i9] != null && !strArr[i9].isEmpty() && strArr2[i9] != null) {
                            int indexOf2 = str.indexOf(strArr[i9], i8);
                            if (indexOf2 == -1) {
                                zArr[i9] = true;
                            } else if (i3 == -1 || indexOf2 < i3) {
                                i4 = i9;
                                i3 = indexOf2;
                            }
                        }
                    }
                }
                int length4 = str.length();
                while (i8 < length4) {
                    sb.append(str.charAt(i8));
                    i8++;
                }
                String sb2 = sb.toString();
                if (!z) {
                    return sb2;
                }
                return replaceEach(sb2, strArr, strArr2, z, i2 - 1);
            }
            throw new IllegalArgumentException("Search and Replace array lengths don't match: " + length2 + " vs " + length3);
        }
        throw new IllegalStateException("Aborting to protect against StackOverflowError - output of one loop is the input of another");
    }

    public static String replaceIgnoreCase(String str, String str2, String str3, int i2) {
        return replace(str, str2, str3, i2, true);
    }

    public static String rightPad(String str, int i2, char c) {
        if (str == null) {
            return null;
        }
        int length = i2 - str.length();
        if (length <= 0) {
            return str;
        }
        if (length > 8192) {
            return rightPad(str, i2, String.valueOf(c));
        }
        return str.concat(repeat(c, length));
    }

    public static String[] split(String str, char c) {
        return splitWorker(str, c, false);
    }

    public static String[] splitByCharacterType(String str, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.isEmpty()) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int type = Character.getType(charArray[0]);
        for (int i3 = 1; i3 < charArray.length; i3++) {
            int type2 = Character.getType(charArray[i3]);
            if (type2 != type) {
                if (z && type2 == 2 && type == 1) {
                    int i4 = i3 - 1;
                    if (i4 != i2) {
                        arrayList.add(new String(charArray, i2, i4 - i2));
                        i2 = i4;
                    }
                } else {
                    arrayList.add(new String(charArray, i2, i3 - i2));
                    i2 = i3;
                }
                type = type2;
            }
        }
        arrayList.add(new String(charArray, i2, charArray.length - i2));
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] splitByWholeSeparator(String str, String str2, int i2) {
        return splitByWholeSeparatorWorker(str, str2, i2, false);
    }

    public static String[] splitByWholeSeparatorPreserveAllTokens(String str, String str2, int i2) {
        return splitByWholeSeparatorWorker(str, str2, i2, true);
    }

    public static String[] splitPreserveAllTokens(String str, char c) {
        return splitWorker(str, c, true);
    }

    public static boolean startsWith(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        if (charSequence == null || charSequence2 == null) {
            if (charSequence == null && charSequence2 == null) {
                return true;
            }
            return false;
        } else if (charSequence2.length() > charSequence.length()) {
            return false;
        } else {
            return CharSequenceUtils.regionMatches(charSequence, z, 0, charSequence2, 0, charSequence2.length());
        }
    }

    public static String strip(String str, String str2) {
        if (isEmpty(str)) {
            return str;
        }
        return stripEnd(stripStart(str, str2), str2);
    }

    public static String[] stripAll(String[] strArr, String str) {
        int length;
        if (strArr == null || (length = strArr.length) == 0) {
            return strArr;
        }
        String[] strArr2 = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            strArr2[i2] = strip(strArr[i2], str);
        }
        return strArr2;
    }

    public static String substringBetween(String str, String str2, String str3) {
        int indexOf;
        int indexOf2;
        if (str == null || str2 == null || str3 == null || (indexOf = str.indexOf(str2)) == -1 || (indexOf2 = str.indexOf(str3, str2.length() + indexOf)) == -1) {
            return null;
        }
        return str.substring(indexOf + str2.length(), indexOf2);
    }

    public static String truncate(String str, int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException("offset cannot be negative");
        } else if (i3 < 0) {
            throw new IllegalArgumentException("maxWith cannot be negative");
        } else if (str == null) {
            return null;
        } else {
            if (i2 > str.length()) {
                return "";
            }
            if (str.length() <= i3) {
                return str.substring(i2);
            }
            int i4 = i3 + i2;
            if (i4 > str.length()) {
                i4 = str.length();
            }
            return str.substring(i2, i4);
        }
    }

    public static String upperCase(String str, Locale locale) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase(locale);
    }

    public static boolean contains(CharSequence charSequence, CharSequence charSequence2) {
        return (charSequence == null || charSequence2 == null || CharSequenceUtils.indexOf(charSequence, charSequence2, 0) < 0) ? false : true;
    }

    public static int indexOf(CharSequence charSequence, int i2, int i3) {
        if (isEmpty(charSequence)) {
            return -1;
        }
        return CharSequenceUtils.indexOf(charSequence, i2, i3);
    }

    public static String join(long[] jArr, char c) {
        if (jArr == null) {
            return null;
        }
        return join(jArr, c, 0, jArr.length);
    }

    public static int lastIndexOf(CharSequence charSequence, int i2, int i3) {
        if (isEmpty(charSequence)) {
            return -1;
        }
        return CharSequenceUtils.lastIndexOf(charSequence, i2, i3);
    }

    public static String remove(String str, char c) {
        if (isEmpty(str) || str.indexOf(c) == -1) {
            return str;
        }
        char[] charArray = str.toCharArray();
        int i2 = 0;
        for (int i3 = 0; i3 < charArray.length; i3++) {
            if (charArray[i3] != c) {
                charArray[i2] = charArray[i3];
                i2++;
            }
        }
        return new String(charArray, 0, i2);
    }

    public static String replace(String str, String str2, String str3, int i2, boolean z) {
        String str4;
        if (isEmpty(str) || isEmpty(str2) || str3 == null || i2 == 0) {
            return str;
        }
        if (z) {
            str4 = str.toLowerCase();
            str2 = str2.toLowerCase();
        } else {
            str4 = str;
        }
        int i3 = 0;
        int indexOf = str4.indexOf(str2, 0);
        if (indexOf == -1) {
            return str;
        }
        int length = str2.length();
        int length2 = str3.length() - length;
        if (length2 < 0) {
            length2 = 0;
        }
        int i4 = 64;
        if (i2 < 0) {
            i4 = 16;
        } else if (i2 <= 64) {
            i4 = i2;
        }
        StringBuilder sb = new StringBuilder(str.length() + (length2 * i4));
        while (indexOf != -1) {
            sb.append(str.substring(i3, indexOf));
            sb.append(str3);
            i3 = indexOf + length;
            i2--;
            if (i2 == 0) {
                break;
            }
            indexOf = str4.indexOf(str2, i3);
        }
        sb.append(str.substring(i3));
        return sb.toString();
    }

    public static String[] split(String str, String str2) {
        return splitWorker(str, str2, -1, false);
    }

    public static String[] splitPreserveAllTokens(String str, String str2) {
        return splitWorker(str, str2, -1, true);
    }

    public static String wrap(String str, String str2) {
        return (isEmpty(str) || isEmpty(str2)) ? str : str2.concat(str).concat(str2);
    }

    public static boolean containsOnly(CharSequence charSequence, String str) {
        if (charSequence == null || str == null) {
            return false;
        }
        return containsOnly(charSequence, str.toCharArray());
    }

    public static int countMatches(CharSequence charSequence, char c) {
        if (isEmpty(charSequence)) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < charSequence.length(); i3++) {
            if (c == charSequence.charAt(i3)) {
                i2++;
            }
        }
        return i2;
    }

    public static int indexOfDifference(CharSequence... charSequenceArr) {
        if (charSequenceArr != null && charSequenceArr.length > 1) {
            int length = charSequenceArr.length;
            int i2 = Integer.MAX_VALUE;
            boolean z = true;
            int i3 = 0;
            boolean z2 = false;
            for (int i4 = 0; i4 < length; i4++) {
                if (charSequenceArr[i4] == null) {
                    i2 = 0;
                    z2 = true;
                } else {
                    i2 = Math.min(charSequenceArr[i4].length(), i2);
                    i3 = Math.max(charSequenceArr[i4].length(), i3);
                    z = false;
                }
            }
            if (!z && (i3 != 0 || z2)) {
                if (i2 == 0) {
                    return 0;
                }
                int i5 = -1;
                for (int i6 = 0; i6 < i2; i6++) {
                    char charAt = charSequenceArr[0].charAt(i6);
                    int i7 = 1;
                    while (true) {
                        if (i7 >= length) {
                            break;
                        } else if (charSequenceArr[i7].charAt(i6) != charAt) {
                            i5 = i6;
                            break;
                        } else {
                            i7++;
                        }
                    }
                    if (i5 != -1) {
                        break;
                    }
                }
                return (i5 != -1 || i2 == i3) ? i5 : i2;
            }
        }
        return -1;
    }

    public static String join(int[] iArr, char c) {
        if (iArr == null) {
            return null;
        }
        return join(iArr, c, 0, iArr.length);
    }

    public static String[] split(String str, String str2, int i2) {
        return splitWorker(str, str2, i2, false);
    }

    public static String[] splitPreserveAllTokens(String str, String str2, int i2) {
        return splitWorker(str, str2, i2, true);
    }

    public static String substring(String str, int i2, int i3) {
        if (str == null) {
            return null;
        }
        if (i3 < 0) {
            i3 += str.length();
        }
        if (i2 < 0) {
            i2 += str.length();
        }
        if (i3 > str.length()) {
            i3 = str.length();
        }
        if (i2 > i3) {
            return "";
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        return str.substring(i2, i3);
    }

    public static String center(String str, int i2, String str2) {
        if (str == null || i2 <= 0) {
            return str;
        }
        if (isEmpty(str2)) {
            str2 = " ";
        }
        int length = str.length();
        int i3 = i2 - length;
        if (i3 <= 0) {
            return str;
        }
        return rightPad(leftPad(str, length + (i3 / 2), str2), i2, str2);
    }

    public static int indexOf(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        return CharSequenceUtils.indexOf(charSequence, charSequence2, 0);
    }

    public static String join(short[] sArr, char c) {
        if (sArr == null) {
            return null;
        }
        return join(sArr, c, 0, sArr.length);
    }

    public static int lastIndexOf(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        return CharSequenceUtils.lastIndexOf(charSequence, charSequence2, charSequence.length());
    }

    public static String leftPad(String str, int i2, String str2) {
        if (str == null) {
            return null;
        }
        if (isEmpty(str2)) {
            str2 = " ";
        }
        int length = str2.length();
        int length2 = i2 - str.length();
        if (length2 <= 0) {
            return str;
        }
        if (length == 1 && length2 <= 8192) {
            return leftPad(str, i2, str2.charAt(0));
        }
        if (length2 == length) {
            return str2.concat(str);
        }
        if (length2 < length) {
            return str2.substring(0, length2).concat(str);
        }
        char[] cArr = new char[length2];
        char[] charArray = str2.toCharArray();
        for (int i3 = 0; i3 < length2; i3++) {
            cArr[i3] = charArray[i3 % length];
        }
        return new String(cArr).concat(str);
    }

    public static String rightPad(String str, int i2, String str2) {
        if (str == null) {
            return null;
        }
        if (isEmpty(str2)) {
            str2 = " ";
        }
        int length = str2.length();
        int length2 = i2 - str.length();
        if (length2 <= 0) {
            return str;
        }
        if (length == 1 && length2 <= 8192) {
            return rightPad(str, i2, str2.charAt(0));
        }
        if (length2 == length) {
            return str.concat(str2);
        }
        if (length2 < length) {
            return str.concat(str2.substring(0, length2));
        }
        char[] cArr = new char[length2];
        char[] charArray = str2.toCharArray();
        for (int i3 = 0; i3 < length2; i3++) {
            cArr[i3] = charArray[i3 % length];
        }
        return str.concat(new String(cArr));
    }

    public static String appendIfMissing(String str, CharSequence charSequence, CharSequence... charSequenceArr) {
        return appendIfMissing(str, charSequence, false, charSequenceArr);
    }

    public static int indexOf(CharSequence charSequence, CharSequence charSequence2, int i2) {
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        return CharSequenceUtils.indexOf(charSequence, charSequence2, i2);
    }

    public static String join(byte[] bArr, char c) {
        if (bArr == null) {
            return null;
        }
        return join(bArr, c, 0, bArr.length);
    }

    public static int lastIndexOf(CharSequence charSequence, CharSequence charSequence2, int i2) {
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        return CharSequenceUtils.lastIndexOf(charSequence, charSequence2, i2);
    }

    public static String prependIfMissing(String str, CharSequence charSequence, CharSequence... charSequenceArr) {
        return prependIfMissing(str, charSequence, false, charSequenceArr);
    }

    public static boolean containsNone(CharSequence charSequence, String str) {
        if (charSequence == null || str == null) {
            return true;
        }
        return containsNone(charSequence, str.toCharArray());
    }

    public static String join(char[] cArr, char c) {
        if (cArr == null) {
            return null;
        }
        return join(cArr, c, 0, cArr.length);
    }

    @Deprecated
    public static String chomp(String str, String str2) {
        return removeEnd(str, str2);
    }

    public static boolean containsAny(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence2 == null) {
            return false;
        }
        return containsAny(charSequence, CharSequenceUtils.toCharArray(charSequence2));
    }

    public static int indexOfAny(CharSequence charSequence, String str) {
        if (isEmpty(charSequence) || isEmpty(str)) {
            return -1;
        }
        return indexOfAny(charSequence, str.toCharArray());
    }

    public static int indexOfAnyBut(CharSequence charSequence, CharSequence charSequence2) {
        if (!isEmpty(charSequence) && !isEmpty(charSequence2)) {
            int length = charSequence.length();
            int i2 = 0;
            while (i2 < length) {
                char charAt = charSequence.charAt(i2);
                boolean z = CharSequenceUtils.indexOf(charSequence2, (int) charAt, 0) >= 0;
                int i3 = i2 + 1;
                if (i3 < length && Character.isHighSurrogate(charAt)) {
                    char charAt2 = charSequence.charAt(i3);
                    if (z && CharSequenceUtils.indexOf(charSequence2, (int) charAt2, 0) < 0) {
                        return i2;
                    }
                } else if (!z) {
                    return i2;
                }
                i2 = i3;
            }
        }
        return -1;
    }

    public static String join(float[] fArr, char c) {
        if (fArr == null) {
            return null;
        }
        return join(fArr, c, 0, fArr.length);
    }

    public static String[] splitWorker(String str, String str2, int i2, boolean z) {
        int i3;
        int i4;
        boolean z2;
        boolean z3;
        int i5;
        boolean z4;
        boolean z5;
        int i6;
        boolean z6;
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        ArrayList arrayList = new ArrayList();
        if (str2 == null) {
            i3 = 0;
            z3 = false;
            z2 = false;
            i4 = 0;
            int i7 = 1;
            while (i3 < length) {
                if (Character.isWhitespace(str.charAt(i3))) {
                    if (z3 || z) {
                        int i8 = i7 + 1;
                        if (i7 == i2) {
                            i3 = length;
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        arrayList.add(str.substring(i4, i3));
                        i7 = i8;
                        z3 = false;
                    }
                    i4 = i3 + 1;
                    i3 = i4;
                } else {
                    i3++;
                    z3 = true;
                    z2 = false;
                }
            }
        } else {
            if (str2.length() == 1) {
                char charAt = str2.charAt(0);
                i6 = 0;
                z5 = false;
                z4 = false;
                i5 = 0;
                int i9 = 1;
                while (i6 < length) {
                    if (str.charAt(i6) == charAt) {
                        if (z5 || z) {
                            int i10 = i9 + 1;
                            if (i9 == i2) {
                                i6 = length;
                                z4 = false;
                            } else {
                                z4 = true;
                            }
                            arrayList.add(str.substring(i5, i6));
                            i9 = i10;
                            z5 = false;
                        }
                        i5 = i6 + 1;
                        i6 = i5;
                    } else {
                        i6++;
                        z5 = true;
                        z4 = false;
                    }
                }
            } else {
                int i11 = 0;
                z5 = false;
                z4 = false;
                i5 = 0;
                int i12 = 1;
                while (i6 < length) {
                    if (str2.indexOf(str.charAt(i6)) >= 0) {
                        if (z5 || z) {
                            int i13 = i12 + 1;
                            if (i12 == i2) {
                                i6 = length;
                                z6 = false;
                            } else {
                                z6 = true;
                            }
                            arrayList.add(str.substring(i5, i6));
                            i12 = i13;
                            z5 = false;
                        }
                        i5 = i6 + 1;
                        i11 = i5;
                    } else {
                        i11 = i6 + 1;
                        z5 = true;
                        z4 = false;
                    }
                }
            }
            i3 = i6;
            z3 = z5;
            z2 = z4;
            i4 = i5;
        }
        if (z3 || (z && z2)) {
            arrayList.add(str.substring(i4, i3));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean containsAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (!isEmpty(charSequence) && !ArrayUtils.isEmpty((Object[]) charSequenceArr)) {
            for (CharSequence contains : charSequenceArr) {
                if (contains(charSequence, contains)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String join(double[] dArr, char c) {
        if (dArr == null) {
            return null;
        }
        return join(dArr, c, 0, dArr.length);
    }

    public static String wrapIfMissing(String str, String str2) {
        if (isEmpty(str) || isEmpty(str2)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length() + str2.length() + str2.length());
        if (!str.startsWith(str2)) {
            sb.append(str2);
        }
        sb.append(str);
        if (!str.endsWith(str2)) {
            sb.append(str2);
        }
        return sb.toString();
    }

    public static int indexOfAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        int indexOf;
        if (charSequence == null || charSequenceArr == null) {
            return -1;
        }
        int i2 = Integer.MAX_VALUE;
        for (CharSequence charSequence2 : charSequenceArr) {
            if (!(charSequence2 == null || (indexOf = CharSequenceUtils.indexOf(charSequence, charSequence2, 0)) == -1 || indexOf >= i2)) {
                i2 = indexOf;
            }
        }
        if (i2 == Integer.MAX_VALUE) {
            return -1;
        }
        return i2;
    }

    public static String join(Object[] objArr, char c, int i2, int i3) {
        if (objArr == null) {
            return null;
        }
        int i4 = i3 - i2;
        if (i4 <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i4 * 16);
        for (int i5 = i2; i5 < i3; i5++) {
            if (i5 > i2) {
                sb.append(c);
            }
            if (objArr[i5] != null) {
                sb.append(objArr[i5]);
            }
        }
        return sb.toString();
    }

    public static int getLevenshteinDistance(CharSequence charSequence, CharSequence charSequence2, int i2) {
        int i3;
        int i4;
        CharSequence charSequence3;
        CharSequence charSequence4;
        int i5;
        int i6 = i2;
        if (charSequence == null || charSequence2 == null) {
            throw new IllegalArgumentException("Strings must not be null");
        } else if (i6 >= 0) {
            int length = charSequence.length();
            int length2 = charSequence2.length();
            if (length == 0) {
                if (length2 <= i6) {
                    return length2;
                }
                return -1;
            } else if (length2 == 0) {
                if (length <= i6) {
                    return length;
                }
                return -1;
            } else if (Math.abs(length - length2) > i6) {
                return -1;
            } else {
                if (length > length2) {
                    i3 = charSequence.length();
                    i4 = length2;
                    charSequence4 = charSequence;
                    charSequence3 = charSequence2;
                } else {
                    i4 = length;
                    i3 = length2;
                    charSequence3 = charSequence;
                    charSequence4 = charSequence2;
                }
                int i7 = i4 + 1;
                int[] iArr = new int[i7];
                int[] iArr2 = new int[i7];
                int min = Math.min(i4, i6) + 1;
                char c = 0;
                for (int i8 = 0; i8 < min; i8++) {
                    iArr[i8] = i8;
                }
                int i9 = Integer.MAX_VALUE;
                Arrays.fill(iArr, min, i7, Integer.MAX_VALUE);
                Arrays.fill(iArr2, Integer.MAX_VALUE);
                int i10 = 1;
                while (i10 <= i3) {
                    char charAt = charSequence4.charAt(i10 - 1);
                    iArr2[c] = i10;
                    int max = Math.max(1, i10 - i6);
                    if (i10 > i9 - i6) {
                        i5 = i4;
                    } else {
                        i5 = Math.min(i4, i10 + i6);
                    }
                    if (max > i5) {
                        return -1;
                    }
                    if (max > 1) {
                        iArr2[max - 1] = i9;
                    }
                    while (max <= i5) {
                        int i11 = max - 1;
                        if (charSequence3.charAt(i11) == charAt) {
                            iArr2[max] = iArr[i11];
                        } else {
                            iArr2[max] = Math.min(Math.min(iArr2[i11], iArr[max]), iArr[i11]) + 1;
                        }
                        max++;
                    }
                    i10++;
                    c = 0;
                    i9 = Integer.MAX_VALUE;
                    int[] iArr3 = iArr2;
                    iArr2 = iArr;
                    iArr = iArr3;
                }
                if (iArr[i4] <= i6) {
                    return iArr[i4];
                }
                return -1;
            }
        } else {
            throw new IllegalArgumentException("Threshold must not be negative");
        }
    }

    public static String repeat(String str, String str2, int i2) {
        if (str == null || str2 == null) {
            return repeat(str, i2);
        }
        return removeEnd(repeat(str + str2, i2), str2);
    }

    public static String join(long[] jArr, char c, int i2, int i3) {
        if (jArr == null) {
            return null;
        }
        int i4 = i3 - i2;
        if (i4 <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i4 * 16);
        for (int i5 = i2; i5 < i3; i5++) {
            if (i5 > i2) {
                sb.append(c);
            }
            sb.append(jArr[i5]);
        }
        return sb.toString();
    }

    public static String repeat(char c, int i2) {
        if (i2 <= 0) {
            return "";
        }
        char[] cArr = new char[i2];
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            cArr[i3] = c;
        }
        return new String(cArr);
    }

    public static String join(int[] iArr, char c, int i2, int i3) {
        if (iArr == null) {
            return null;
        }
        int i4 = i3 - i2;
        if (i4 <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i4 * 16);
        for (int i5 = i2; i5 < i3; i5++) {
            if (i5 > i2) {
                sb.append(c);
            }
            sb.append(iArr[i5]);
        }
        return sb.toString();
    }

    public static String join(byte[] bArr, char c, int i2, int i3) {
        if (bArr == null) {
            return null;
        }
        int i4 = i3 - i2;
        if (i4 <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i4 * 16);
        for (int i5 = i2; i5 < i3; i5++) {
            if (i5 > i2) {
                sb.append(c);
            }
            sb.append(bArr[i5]);
        }
        return sb.toString();
    }

    public static String join(short[] sArr, char c, int i2, int i3) {
        if (sArr == null) {
            return null;
        }
        int i4 = i3 - i2;
        if (i4 <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i4 * 16);
        for (int i5 = i2; i5 < i3; i5++) {
            if (i5 > i2) {
                sb.append(c);
            }
            sb.append(sArr[i5]);
        }
        return sb.toString();
    }

    public static String join(char[] cArr, char c, int i2, int i3) {
        if (cArr == null) {
            return null;
        }
        int i4 = i3 - i2;
        if (i4 <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i4 * 16);
        for (int i5 = i2; i5 < i3; i5++) {
            if (i5 > i2) {
                sb.append(c);
            }
            sb.append(cArr[i5]);
        }
        return sb.toString();
    }

    public static String join(double[] dArr, char c, int i2, int i3) {
        if (dArr == null) {
            return null;
        }
        int i4 = i3 - i2;
        if (i4 <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i4 * 16);
        for (int i5 = i2; i5 < i3; i5++) {
            if (i5 > i2) {
                sb.append(c);
            }
            sb.append(dArr[i5]);
        }
        return sb.toString();
    }

    public static String join(float[] fArr, char c, int i2, int i3) {
        if (fArr == null) {
            return null;
        }
        int i4 = i3 - i2;
        if (i4 <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i4 * 16);
        for (int i5 = i2; i5 < i3; i5++) {
            if (i5 > i2) {
                sb.append(c);
            }
            sb.append(fArr[i5]);
        }
        return sb.toString();
    }

    public static String join(Object[] objArr, String str) {
        if (objArr == null) {
            return null;
        }
        return join(objArr, str, 0, objArr.length);
    }

    public static String join(Object[] objArr, String str, int i2, int i3) {
        if (objArr == null) {
            return null;
        }
        if (str == null) {
            str = "";
        }
        int i4 = i3 - i2;
        if (i4 <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i4 * 16);
        for (int i5 = i2; i5 < i3; i5++) {
            if (i5 > i2) {
                sb.append(str);
            }
            if (objArr[i5] != null) {
                sb.append(objArr[i5]);
            }
        }
        return sb.toString();
    }

    public static String join(Iterator<?> it, char c) {
        if (it == null) {
            return null;
        }
        if (!it.hasNext()) {
            return "";
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return ObjectUtils.toString(next);
        }
        StringBuilder sb = new StringBuilder(256);
        if (next != null) {
            sb.append(next);
        }
        while (it.hasNext()) {
            sb.append(c);
            Object next2 = it.next();
            if (next2 != null) {
                sb.append(next2);
            }
        }
        return sb.toString();
    }

    public static String join(Iterator<?> it, String str) {
        if (it == null) {
            return null;
        }
        if (!it.hasNext()) {
            return "";
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return ObjectUtils.toString(next);
        }
        StringBuilder sb = new StringBuilder(256);
        if (next != null) {
            sb.append(next);
        }
        while (it.hasNext()) {
            if (str != null) {
                sb.append(str);
            }
            Object next2 = it.next();
            if (next2 != null) {
                sb.append(next2);
            }
        }
        return sb.toString();
    }

    public static String join(Iterable<?> iterable, char c) {
        if (iterable == null) {
            return null;
        }
        return join(iterable.iterator(), c);
    }

    public static String join(Iterable<?> iterable, String str) {
        if (iterable == null) {
            return null;
        }
        return join(iterable.iterator(), str);
    }
}
