package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;

public class NumericEntityEscaper extends CodePointTranslator {
    public final int above;
    public final int below;
    public final boolean between;

    public NumericEntityEscaper(int i2, int i3, boolean z) {
        this.below = i2;
        this.above = i3;
        this.between = z;
    }

    public static NumericEntityEscaper above(int i2) {
        return outsideOf(0, i2);
    }

    public static NumericEntityEscaper below(int i2) {
        return outsideOf(i2, Integer.MAX_VALUE);
    }

    public static NumericEntityEscaper between(int i2, int i3) {
        return new NumericEntityEscaper(i2, i3, true);
    }

    public static NumericEntityEscaper outsideOf(int i2, int i3) {
        return new NumericEntityEscaper(i2, i3, false);
    }

    public boolean translate(int i2, Writer writer) throws IOException {
        if (this.between) {
            if (i2 < this.below || i2 > this.above) {
                return false;
            }
        } else if (i2 >= this.below && i2 <= this.above) {
            return false;
        }
        writer.write("&#");
        writer.write(Integer.toString(i2, 10));
        writer.write(59);
        return true;
    }

    public NumericEntityEscaper() {
        this(0, Integer.MAX_VALUE, true);
    }
}
