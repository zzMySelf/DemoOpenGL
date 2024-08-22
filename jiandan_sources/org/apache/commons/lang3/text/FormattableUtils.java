package org.apache.commons.lang3.text;

import com.google.common.base.Ascii;
import java.util.Formattable;
import java.util.Formatter;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;

public class FormattableUtils {
    public static final String SIMPLEST_FORMAT = "%s";

    public static Formatter append(CharSequence charSequence, Formatter formatter, int i2, int i3, int i4) {
        return append(charSequence, formatter, i2, i3, i4, Ascii.CASE_MASK, (CharSequence) null);
    }

    public static String toString(Formattable formattable) {
        return String.format(SIMPLEST_FORMAT, new Object[]{formattable});
    }

    public static Formatter append(CharSequence charSequence, Formatter formatter, int i2, int i3, int i4, char c) {
        return append(charSequence, formatter, i2, i3, i4, c, (CharSequence) null);
    }

    public static Formatter append(CharSequence charSequence, Formatter formatter, int i2, int i3, int i4, CharSequence charSequence2) {
        return append(charSequence, formatter, i2, i3, i4, Ascii.CASE_MASK, charSequence2);
    }

    public static Formatter append(CharSequence charSequence, Formatter formatter, int i2, int i3, int i4, char c, CharSequence charSequence2) {
        boolean z = true;
        Validate.isTrue(charSequence2 == null || i4 < 0 || charSequence2.length() <= i4, "Specified ellipsis '%1$s' exceeds precision of %2$s", charSequence2, Integer.valueOf(i4));
        StringBuilder sb = new StringBuilder(charSequence);
        if (i4 >= 0 && i4 < charSequence.length()) {
            CharSequence charSequence3 = (CharSequence) ObjectUtils.defaultIfNull(charSequence2, "");
            sb.replace(i4 - charSequence3.length(), charSequence.length(), charSequence3.toString());
        }
        if ((i2 & 1) != 1) {
            z = false;
        }
        for (int length = sb.length(); length < i3; length++) {
            sb.insert(z ? length : 0, c);
        }
        formatter.format(sb.toString(), new Object[0]);
        return formatter;
    }
}
