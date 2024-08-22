package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.CharCompanionObject;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible
@Beta
public final class Escapers {
    public static final Escaper NULL_ESCAPER = new CharEscaper() {
        public String escape(String str) {
            return (String) Preconditions.checkNotNull(str);
        }

        public char[] escape(char c) {
            return null;
        }
    };

    @Beta
    public static final class Builder {
        public final Map<Character, String> replacementMap;
        public char safeMax;
        public char safeMin;
        public String unsafeReplacement;

        @CanIgnoreReturnValue
        public Builder addEscape(char c, String str) {
            Preconditions.checkNotNull(str);
            this.replacementMap.put(Character.valueOf(c), str);
            return this;
        }

        public Escaper build() {
            return new ArrayBasedCharEscaper(this.replacementMap, this.safeMin, this.safeMax) {
                public final char[] replacementChars;

                {
                    this.replacementChars = Builder.this.unsafeReplacement != null ? Builder.this.unsafeReplacement.toCharArray() : null;
                }

                public char[] escapeUnsafe(char c) {
                    return this.replacementChars;
                }
            };
        }

        @CanIgnoreReturnValue
        public Builder setSafeRange(char c, char c2) {
            this.safeMin = c;
            this.safeMax = c2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setUnsafeReplacement(@NullableDecl String str) {
            this.unsafeReplacement = str;
            return this;
        }

        public Builder() {
            this.replacementMap = new HashMap();
            this.safeMin = 0;
            this.safeMax = CharCompanionObject.MAX_VALUE;
            this.unsafeReplacement = null;
        }
    }

    public static UnicodeEscaper asUnicodeEscaper(Escaper escaper) {
        Preconditions.checkNotNull(escaper);
        if (escaper instanceof UnicodeEscaper) {
            return (UnicodeEscaper) escaper;
        }
        if (escaper instanceof CharEscaper) {
            return wrap((CharEscaper) escaper);
        }
        throw new IllegalArgumentException("Cannot create a UnicodeEscaper from: " + escaper.getClass().getName());
    }

    public static Builder builder() {
        return new Builder();
    }

    public static String computeReplacement(CharEscaper charEscaper, char c) {
        return stringOrNull(charEscaper.escape(c));
    }

    public static Escaper nullEscaper() {
        return NULL_ESCAPER;
    }

    public static String stringOrNull(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        return new String(cArr);
    }

    public static UnicodeEscaper wrap(final CharEscaper charEscaper) {
        return new UnicodeEscaper() {
            public char[] escape(int i2) {
                if (i2 < 65536) {
                    return charEscaper.escape((char) i2);
                }
                char[] cArr = new char[2];
                Character.toChars(i2, cArr, 0);
                char[] escape = charEscaper.escape(cArr[0]);
                char[] escape2 = charEscaper.escape(cArr[1]);
                if (escape == null && escape2 == null) {
                    return null;
                }
                int length = escape != null ? escape.length : 1;
                char[] cArr2 = new char[((escape2 != null ? escape2.length : 1) + length)];
                if (escape != null) {
                    for (int i3 = 0; i3 < escape.length; i3++) {
                        cArr2[i3] = escape[i3];
                    }
                } else {
                    cArr2[0] = cArr[0];
                }
                if (escape2 != null) {
                    for (int i4 = 0; i4 < escape2.length; i4++) {
                        cArr2[length + i4] = escape2[i4];
                    }
                } else {
                    cArr2[length] = cArr[1];
                }
                return cArr2;
            }
        };
    }

    public static String computeReplacement(UnicodeEscaper unicodeEscaper, int i2) {
        return stringOrNull(unicodeEscaper.escape(i2));
    }
}
