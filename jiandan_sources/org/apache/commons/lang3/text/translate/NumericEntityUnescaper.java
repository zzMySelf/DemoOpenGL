package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.EnumSet;

public class NumericEntityUnescaper extends CharSequenceTranslator {
    public final EnumSet<OPTION> options;

    public enum OPTION {
        semiColonRequired,
        semiColonOptional,
        errorIfNoSemiColon
    }

    public NumericEntityUnescaper(OPTION... optionArr) {
        if (optionArr.length > 0) {
            this.options = EnumSet.copyOf(Arrays.asList(optionArr));
            return;
        }
        this.options = EnumSet.copyOf(Arrays.asList(new OPTION[]{OPTION.semiColonRequired}));
    }

    public boolean isSet(OPTION option) {
        EnumSet<OPTION> enumSet = this.options;
        if (enumSet == null) {
            return false;
        }
        return enumSet.contains(option);
    }

    public int translate(CharSequence charSequence, int i2, Writer writer) throws IOException {
        int i3;
        int i4;
        int length = charSequence.length();
        if (charSequence.charAt(i2) == '&' && i2 < length - 2 && charSequence.charAt(i2 + 1) == '#') {
            int i5 = i2 + 2;
            char charAt = charSequence.charAt(i5);
            if (charAt == 'x' || charAt == 'X') {
                i5++;
                if (i5 == length) {
                    return 0;
                }
                i3 = 1;
            } else {
                i3 = 0;
            }
            int i6 = i5;
            while (i6 < length && ((charSequence.charAt(i6) >= '0' && charSequence.charAt(i6) <= '9') || ((charSequence.charAt(i6) >= 'a' && charSequence.charAt(i6) <= 'f') || (charSequence.charAt(i6) >= 'A' && charSequence.charAt(i6) <= 'F')))) {
                i6++;
            }
            int i7 = (i6 == length || charSequence.charAt(i6) != ';') ? 0 : 1;
            if (i7 == 0) {
                if (isSet(OPTION.semiColonRequired)) {
                    return 0;
                }
                if (isSet(OPTION.errorIfNoSemiColon)) {
                    throw new IllegalArgumentException("Semi-colon required at end of numeric entity");
                }
            }
            if (i3 != 0) {
                try {
                    i4 = Integer.parseInt(charSequence.subSequence(i5, i6).toString(), 16);
                } catch (NumberFormatException unused) {
                }
            } else {
                i4 = Integer.parseInt(charSequence.subSequence(i5, i6).toString(), 10);
            }
            if (i4 > 65535) {
                char[] chars = Character.toChars(i4);
                writer.write(chars[0]);
                writer.write(chars[1]);
            } else {
                writer.write(i4);
            }
            return ((i6 + 2) - i5) + i3 + i7;
        }
        return 0;
    }
}
