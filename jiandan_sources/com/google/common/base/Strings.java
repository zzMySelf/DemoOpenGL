package com.google.common.base;

import com.baidu.android.common.others.lang.StringUtil;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.text.FormattableUtils;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible
public final class Strings {
    public static String commonPrefix(CharSequence charSequence, CharSequence charSequence2) {
        Preconditions.checkNotNull(charSequence);
        Preconditions.checkNotNull(charSequence2);
        int min = Math.min(charSequence.length(), charSequence2.length());
        int i2 = 0;
        while (i2 < min && charSequence.charAt(i2) == charSequence2.charAt(i2)) {
            i2++;
        }
        int i3 = i2 - 1;
        if (validSurrogatePairAt(charSequence, i3) || validSurrogatePairAt(charSequence2, i3)) {
            i2--;
        }
        return charSequence.subSequence(0, i2).toString();
    }

    public static String commonSuffix(CharSequence charSequence, CharSequence charSequence2) {
        Preconditions.checkNotNull(charSequence);
        Preconditions.checkNotNull(charSequence2);
        int min = Math.min(charSequence.length(), charSequence2.length());
        int i2 = 0;
        while (i2 < min && charSequence.charAt((charSequence.length() - i2) - 1) == charSequence2.charAt((charSequence2.length() - i2) - 1)) {
            i2++;
        }
        if (validSurrogatePairAt(charSequence, (charSequence.length() - i2) - 1) || validSurrogatePairAt(charSequence2, (charSequence2.length() - i2) - 1)) {
            i2--;
        }
        return charSequence.subSequence(charSequence.length() - i2, charSequence.length()).toString();
    }

    @NullableDecl
    public static String emptyToNull(@NullableDecl String str) {
        return Platform.emptyToNull(str);
    }

    public static boolean isNullOrEmpty(@NullableDecl String str) {
        return Platform.stringIsNullOrEmpty(str);
    }

    public static String lenientFormat(@NullableDecl String str, @NullableDecl Object... objArr) {
        int indexOf;
        String valueOf = String.valueOf(str);
        int i2 = 0;
        if (objArr == null) {
            objArr = new Object[]{"(Object[])null"};
        } else {
            for (int i3 = 0; i3 < objArr.length; i3++) {
                objArr[i3] = lenientToString(objArr[i3]);
            }
        }
        StringBuilder sb = new StringBuilder(valueOf.length() + (objArr.length * 16));
        int i4 = 0;
        while (i2 < objArr.length && (indexOf = valueOf.indexOf(FormattableUtils.SIMPLEST_FORMAT, i4)) != -1) {
            sb.append(valueOf, i4, indexOf);
            sb.append(objArr[i2]);
            int i5 = i2 + 1;
            i4 = indexOf + 2;
            i2 = i5;
        }
        sb.append(valueOf, i4, valueOf.length());
        if (i2 < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i2]);
            for (int i6 = i2 + 1; i6 < objArr.length; i6++) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(objArr[i6]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    public static String lenientToString(@NullableDecl Object obj) {
        try {
            return String.valueOf(obj);
        } catch (Exception e) {
            String str = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
            Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for " + str, e);
            return "<" + str + " threw " + e.getClass().getName() + ">";
        }
    }

    public static String nullToEmpty(@NullableDecl String str) {
        return Platform.nullToEmpty(str);
    }

    public static String padEnd(String str, int i2, char c) {
        Preconditions.checkNotNull(str);
        if (str.length() >= i2) {
            return str;
        }
        StringBuilder sb = new StringBuilder(i2);
        sb.append(str);
        for (int length = str.length(); length < i2; length++) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static String padStart(String str, int i2, char c) {
        Preconditions.checkNotNull(str);
        if (str.length() >= i2) {
            return str;
        }
        StringBuilder sb = new StringBuilder(i2);
        for (int length = str.length(); length < i2; length++) {
            sb.append(c);
        }
        sb.append(str);
        return sb.toString();
    }

    public static String repeat(String str, int i2) {
        Preconditions.checkNotNull(str);
        boolean z = true;
        if (i2 <= 1) {
            if (i2 < 0) {
                z = false;
            }
            Preconditions.checkArgument(z, "invalid count: %s", i2);
            return i2 == 0 ? "" : str;
        }
        int length = str.length();
        long j = ((long) length) * ((long) i2);
        int i3 = (int) j;
        if (((long) i3) == j) {
            char[] cArr = new char[i3];
            str.getChars(0, length, cArr, 0);
            while (true) {
                int i4 = i3 - length;
                if (length < i4) {
                    System.arraycopy(cArr, 0, cArr, length, length);
                    length <<= 1;
                } else {
                    System.arraycopy(cArr, 0, cArr, length, i4);
                    return new String(cArr);
                }
            }
        } else {
            throw new ArrayIndexOutOfBoundsException("Required array size too large: " + j);
        }
    }

    @VisibleForTesting
    public static boolean validSurrogatePairAt(CharSequence charSequence, int i2) {
        if (i2 < 0 || i2 > charSequence.length() - 2 || !Character.isHighSurrogate(charSequence.charAt(i2)) || !Character.isLowSurrogate(charSequence.charAt(i2 + 1))) {
            return false;
        }
        return true;
    }
}
