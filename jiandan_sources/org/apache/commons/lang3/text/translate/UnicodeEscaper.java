package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;

public class UnicodeEscaper extends CodePointTranslator {
    public final int above;
    public final int below;
    public final boolean between;

    public UnicodeEscaper() {
        this(0, Integer.MAX_VALUE, true);
    }

    public static UnicodeEscaper above(int i2) {
        return outsideOf(0, i2);
    }

    public static UnicodeEscaper below(int i2) {
        return outsideOf(i2, Integer.MAX_VALUE);
    }

    public static UnicodeEscaper between(int i2, int i3) {
        return new UnicodeEscaper(i2, i3, true);
    }

    public static UnicodeEscaper outsideOf(int i2, int i3) {
        return new UnicodeEscaper(i2, i3, false);
    }

    public String toUtf16Escape(int i2) {
        return "\\u" + CharSequenceTranslator.hex(i2);
    }

    public boolean translate(int i2, Writer writer) throws IOException {
        if (this.between) {
            if (i2 < this.below || i2 > this.above) {
                return false;
            }
        } else if (i2 >= this.below && i2 <= this.above) {
            return false;
        }
        if (i2 > 65535) {
            writer.write(toUtf16Escape(i2));
            return true;
        }
        writer.write("\\u");
        writer.write(CharSequenceTranslator.HEX_DIGITS[(i2 >> 12) & 15]);
        writer.write(CharSequenceTranslator.HEX_DIGITS[(i2 >> 8) & 15]);
        writer.write(CharSequenceTranslator.HEX_DIGITS[(i2 >> 4) & 15]);
        writer.write(CharSequenceTranslator.HEX_DIGITS[i2 & 15]);
        return true;
    }

    public UnicodeEscaper(int i2, int i3, boolean z) {
        this.below = i2;
        this.above = i3;
        this.between = z;
    }
}
