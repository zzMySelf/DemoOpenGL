package com.google.protobuf;

import java.util.Arrays;

public final class TextFormatParseLocation {
    public static final TextFormatParseLocation EMPTY = new TextFormatParseLocation(-1, -1);
    public final int column;
    public final int line;

    public TextFormatParseLocation(int i2, int i3) {
        this.line = i2;
        this.column = i3;
    }

    public static TextFormatParseLocation create(int i2, int i3) {
        if (i2 == -1 && i3 == -1) {
            return EMPTY;
        }
        if (i2 >= 0 && i3 >= 0) {
            return new TextFormatParseLocation(i2, i3);
        }
        throw new IllegalArgumentException(String.format("line and column values must be >= 0: line %d, column: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TextFormatParseLocation)) {
            return false;
        }
        TextFormatParseLocation textFormatParseLocation = (TextFormatParseLocation) obj;
        if (this.line == textFormatParseLocation.getLine() && this.column == textFormatParseLocation.getColumn()) {
            return true;
        }
        return false;
    }

    public int getColumn() {
        return this.column;
    }

    public int getLine() {
        return this.line;
    }

    public int hashCode() {
        return Arrays.hashCode(new int[]{this.line, this.column});
    }

    public String toString() {
        return String.format("ParseLocation{line=%d, column=%d}", new Object[]{Integer.valueOf(this.line), Integer.valueOf(this.column)});
    }
}
