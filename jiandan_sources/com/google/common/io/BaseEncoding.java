package com.google.common.io;

import com.alipay.sdk.m.n.a;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.RoundingMode;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible(emulated = true)
public abstract class BaseEncoding {
    public static final BaseEncoding BASE16 = new Base16Encoding("base16()", "0123456789ABCDEF");
    public static final BaseEncoding BASE32;
    public static final BaseEncoding BASE32_HEX;
    public static final BaseEncoding BASE64;
    public static final BaseEncoding BASE64_URL;

    public static final class Alphabet {
        public final int bitsPerChar;
        public final int bytesPerChunk;
        public final char[] chars;
        public final int charsPerChunk;
        public final byte[] decodabet;
        public final int mask;
        public final String name;
        public final boolean[] validPadding;

        public Alphabet(String str, char[] cArr) {
            this.name = (String) Preconditions.checkNotNull(str);
            this.chars = (char[]) Preconditions.checkNotNull(cArr);
            try {
                int log2 = IntMath.log2(cArr.length, RoundingMode.UNNECESSARY);
                this.bitsPerChar = log2;
                int min = Math.min(8, Integer.lowestOneBit(log2));
                try {
                    this.charsPerChunk = 8 / min;
                    this.bytesPerChunk = this.bitsPerChar / min;
                    this.mask = cArr.length - 1;
                    byte[] bArr = new byte[128];
                    Arrays.fill(bArr, (byte) -1);
                    for (int i2 = 0; i2 < cArr.length; i2++) {
                        char c = cArr[i2];
                        Preconditions.checkArgument(c < 128, "Non-ASCII character: %s", c);
                        Preconditions.checkArgument(bArr[c] == -1, "Duplicate character: %s", c);
                        bArr[c] = (byte) i2;
                    }
                    this.decodabet = bArr;
                    boolean[] zArr = new boolean[this.charsPerChunk];
                    for (int i3 = 0; i3 < this.bytesPerChunk; i3++) {
                        zArr[IntMath.divide(i3 * 8, this.bitsPerChar, RoundingMode.CEILING)] = true;
                    }
                    this.validPadding = zArr;
                } catch (ArithmeticException e) {
                    throw new IllegalArgumentException("Illegal alphabet " + new String(cArr), e);
                }
            } catch (ArithmeticException e2) {
                throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e2);
            }
        }

        private boolean hasLowerCase() {
            for (char isLowerCase : this.chars) {
                if (Ascii.isLowerCase(isLowerCase)) {
                    return true;
                }
            }
            return false;
        }

        private boolean hasUpperCase() {
            for (char isUpperCase : this.chars) {
                if (Ascii.isUpperCase(isUpperCase)) {
                    return true;
                }
            }
            return false;
        }

        public boolean canDecode(char c) {
            return c <= 127 && this.decodabet[c] != -1;
        }

        public int decode(char c) throws DecodingException {
            if (c <= 127) {
                byte b = this.decodabet[c];
                if (b != -1) {
                    return b;
                }
                if (c <= ' ' || c == 127) {
                    throw new DecodingException("Unrecognized character: 0x" + Integer.toHexString(c));
                }
                throw new DecodingException("Unrecognized character: " + c);
            }
            throw new DecodingException("Unrecognized character: 0x" + Integer.toHexString(c));
        }

        public char encode(int i2) {
            return this.chars[i2];
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof Alphabet) {
                return Arrays.equals(this.chars, ((Alphabet) obj).chars);
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(this.chars);
        }

        public boolean isValidPaddingStartPosition(int i2) {
            return this.validPadding[i2 % this.charsPerChunk];
        }

        public Alphabet lowerCase() {
            if (!hasUpperCase()) {
                return this;
            }
            Preconditions.checkState(!hasLowerCase(), "Cannot call lowerCase() on a mixed-case alphabet");
            char[] cArr = new char[this.chars.length];
            int i2 = 0;
            while (true) {
                char[] cArr2 = this.chars;
                if (i2 < cArr2.length) {
                    cArr[i2] = Ascii.toLowerCase(cArr2[i2]);
                    i2++;
                } else {
                    return new Alphabet(this.name + ".lowerCase()", cArr);
                }
            }
        }

        public boolean matches(char c) {
            byte[] bArr = this.decodabet;
            return c < bArr.length && bArr[c] != -1;
        }

        public String toString() {
            return this.name;
        }

        public Alphabet upperCase() {
            if (!hasLowerCase()) {
                return this;
            }
            Preconditions.checkState(!hasUpperCase(), "Cannot call upperCase() on a mixed-case alphabet");
            char[] cArr = new char[this.chars.length];
            int i2 = 0;
            while (true) {
                char[] cArr2 = this.chars;
                if (i2 < cArr2.length) {
                    cArr[i2] = Ascii.toUpperCase(cArr2[i2]);
                    i2++;
                } else {
                    return new Alphabet(this.name + ".upperCase()", cArr);
                }
            }
        }
    }

    public static final class Base16Encoding extends StandardBaseEncoding {
        public final char[] encoding;

        public Base16Encoding(String str, String str2) {
            this(new Alphabet(str, str2.toCharArray()));
        }

        public int decodeTo(byte[] bArr, CharSequence charSequence) throws DecodingException {
            Preconditions.checkNotNull(bArr);
            if (charSequence.length() % 2 != 1) {
                int i2 = 0;
                int i3 = 0;
                while (i2 < charSequence.length()) {
                    bArr[i3] = (byte) ((this.alphabet.decode(charSequence.charAt(i2)) << 4) | this.alphabet.decode(charSequence.charAt(i2 + 1)));
                    i2 += 2;
                    i3++;
                }
                return i3;
            }
            throw new DecodingException("Invalid input length " + charSequence.length());
        }

        public void encodeTo(Appendable appendable, byte[] bArr, int i2, int i3) throws IOException {
            Preconditions.checkNotNull(appendable);
            Preconditions.checkPositionIndexes(i2, i2 + i3, bArr.length);
            for (int i4 = 0; i4 < i3; i4++) {
                byte b = bArr[i2 + i4] & 255;
                appendable.append(this.encoding[b]);
                appendable.append(this.encoding[b | 256]);
            }
        }

        public BaseEncoding newInstance(Alphabet alphabet, @NullableDecl Character ch) {
            return new Base16Encoding(alphabet);
        }

        public Base16Encoding(Alphabet alphabet) {
            super(alphabet, (Character) null);
            this.encoding = new char[512];
            Preconditions.checkArgument(alphabet.chars.length == 16);
            for (int i2 = 0; i2 < 256; i2++) {
                this.encoding[i2] = alphabet.encode(i2 >>> 4);
                this.encoding[i2 | 256] = alphabet.encode(i2 & 15);
            }
        }
    }

    public static final class Base64Encoding extends StandardBaseEncoding {
        public Base64Encoding(String str, String str2, @NullableDecl Character ch) {
            this(new Alphabet(str, str2.toCharArray()), ch);
        }

        public int decodeTo(byte[] bArr, CharSequence charSequence) throws DecodingException {
            Preconditions.checkNotNull(bArr);
            CharSequence trimTrailingPadding = trimTrailingPadding(charSequence);
            if (this.alphabet.isValidPaddingStartPosition(trimTrailingPadding.length())) {
                int i2 = 0;
                int i3 = 0;
                while (i2 < trimTrailingPadding.length()) {
                    int i4 = i2 + 1;
                    int i5 = i4 + 1;
                    int decode = (this.alphabet.decode(trimTrailingPadding.charAt(i2)) << 18) | (this.alphabet.decode(trimTrailingPadding.charAt(i4)) << 12);
                    int i6 = i3 + 1;
                    bArr[i3] = (byte) (decode >>> 16);
                    if (i5 < trimTrailingPadding.length()) {
                        int i7 = i5 + 1;
                        int decode2 = decode | (this.alphabet.decode(trimTrailingPadding.charAt(i5)) << 6);
                        i3 = i6 + 1;
                        bArr[i6] = (byte) ((decode2 >>> 8) & 255);
                        if (i7 < trimTrailingPadding.length()) {
                            i5 = i7 + 1;
                            i6 = i3 + 1;
                            bArr[i3] = (byte) ((decode2 | this.alphabet.decode(trimTrailingPadding.charAt(i7))) & 255);
                        } else {
                            i2 = i7;
                        }
                    }
                    i3 = i6;
                    i2 = i5;
                }
                return i3;
            }
            throw new DecodingException("Invalid input length " + trimTrailingPadding.length());
        }

        public void encodeTo(Appendable appendable, byte[] bArr, int i2, int i3) throws IOException {
            Preconditions.checkNotNull(appendable);
            int i4 = i2 + i3;
            Preconditions.checkPositionIndexes(i2, i4, bArr.length);
            while (i3 >= 3) {
                int i5 = i2 + 1;
                int i6 = i5 + 1;
                byte b = ((bArr[i2] & 255) << Ascii.DLE) | ((bArr[i5] & 255) << 8) | (bArr[i6] & 255);
                appendable.append(this.alphabet.encode(b >>> Ascii.DC2));
                appendable.append(this.alphabet.encode((b >>> 12) & 63));
                appendable.append(this.alphabet.encode((b >>> 6) & 63));
                appendable.append(this.alphabet.encode(b & 63));
                i3 -= 3;
                i2 = i6 + 1;
            }
            if (i2 < i4) {
                encodeChunkTo(appendable, bArr, i2, i4 - i2);
            }
        }

        public BaseEncoding newInstance(Alphabet alphabet, @NullableDecl Character ch) {
            return new Base64Encoding(alphabet, ch);
        }

        public Base64Encoding(Alphabet alphabet, @NullableDecl Character ch) {
            super(alphabet, ch);
            Preconditions.checkArgument(alphabet.chars.length == 64);
        }
    }

    public static final class DecodingException extends IOException {
        public DecodingException(String str) {
            super(str);
        }

        public DecodingException(Throwable th2) {
            super(th2);
        }
    }

    public static final class SeparatedBaseEncoding extends BaseEncoding {
        public final int afterEveryChars;
        public final BaseEncoding delegate;
        public final String separator;

        public SeparatedBaseEncoding(BaseEncoding baseEncoding, String str, int i2) {
            this.delegate = (BaseEncoding) Preconditions.checkNotNull(baseEncoding);
            this.separator = (String) Preconditions.checkNotNull(str);
            this.afterEveryChars = i2;
            Preconditions.checkArgument(i2 > 0, "Cannot add a separator after every %s chars", i2);
        }

        public boolean canDecode(CharSequence charSequence) {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < charSequence.length(); i2++) {
                char charAt = charSequence.charAt(i2);
                if (this.separator.indexOf(charAt) < 0) {
                    sb.append(charAt);
                }
            }
            return this.delegate.canDecode(sb);
        }

        public int decodeTo(byte[] bArr, CharSequence charSequence) throws DecodingException {
            StringBuilder sb = new StringBuilder(charSequence.length());
            for (int i2 = 0; i2 < charSequence.length(); i2++) {
                char charAt = charSequence.charAt(i2);
                if (this.separator.indexOf(charAt) < 0) {
                    sb.append(charAt);
                }
            }
            return this.delegate.decodeTo(bArr, sb);
        }

        @GwtIncompatible
        public InputStream decodingStream(Reader reader) {
            return this.delegate.decodingStream(BaseEncoding.ignoringReader(reader, this.separator));
        }

        public void encodeTo(Appendable appendable, byte[] bArr, int i2, int i3) throws IOException {
            this.delegate.encodeTo(BaseEncoding.separatingAppendable(appendable, this.separator, this.afterEveryChars), bArr, i2, i3);
        }

        @GwtIncompatible
        public OutputStream encodingStream(Writer writer) {
            return this.delegate.encodingStream(BaseEncoding.separatingWriter(writer, this.separator, this.afterEveryChars));
        }

        public BaseEncoding lowerCase() {
            return this.delegate.lowerCase().withSeparator(this.separator, this.afterEveryChars);
        }

        public int maxDecodedSize(int i2) {
            return this.delegate.maxDecodedSize(i2);
        }

        public int maxEncodedSize(int i2) {
            int maxEncodedSize = this.delegate.maxEncodedSize(i2);
            return maxEncodedSize + (this.separator.length() * IntMath.divide(Math.max(0, maxEncodedSize - 1), this.afterEveryChars, RoundingMode.FLOOR));
        }

        public BaseEncoding omitPadding() {
            return this.delegate.omitPadding().withSeparator(this.separator, this.afterEveryChars);
        }

        public String toString() {
            return this.delegate + ".withSeparator(\"" + this.separator + "\", " + this.afterEveryChars + ")";
        }

        public CharSequence trimTrailingPadding(CharSequence charSequence) {
            return this.delegate.trimTrailingPadding(charSequence);
        }

        public BaseEncoding upperCase() {
            return this.delegate.upperCase().withSeparator(this.separator, this.afterEveryChars);
        }

        public BaseEncoding withPadChar(char c) {
            return this.delegate.withPadChar(c).withSeparator(this.separator, this.afterEveryChars);
        }

        public BaseEncoding withSeparator(String str, int i2) {
            throw new UnsupportedOperationException("Already have a separator");
        }
    }

    public static class StandardBaseEncoding extends BaseEncoding {
        public final Alphabet alphabet;
        @MonotonicNonNullDecl
        public transient BaseEncoding lowerCase;
        @NullableDecl
        public final Character paddingChar;
        @MonotonicNonNullDecl
        public transient BaseEncoding upperCase;

        public StandardBaseEncoding(String str, String str2, @NullableDecl Character ch) {
            this(new Alphabet(str, str2.toCharArray()), ch);
        }

        public boolean canDecode(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            CharSequence trimTrailingPadding = trimTrailingPadding(charSequence);
            if (!this.alphabet.isValidPaddingStartPosition(trimTrailingPadding.length())) {
                return false;
            }
            for (int i2 = 0; i2 < trimTrailingPadding.length(); i2++) {
                if (!this.alphabet.canDecode(trimTrailingPadding.charAt(i2))) {
                    return false;
                }
            }
            return true;
        }

        public int decodeTo(byte[] bArr, CharSequence charSequence) throws DecodingException {
            Alphabet alphabet2;
            Preconditions.checkNotNull(bArr);
            CharSequence trimTrailingPadding = trimTrailingPadding(charSequence);
            if (this.alphabet.isValidPaddingStartPosition(trimTrailingPadding.length())) {
                int i2 = 0;
                int i3 = 0;
                while (i2 < trimTrailingPadding.length()) {
                    long j = 0;
                    int i4 = 0;
                    int i5 = 0;
                    while (true) {
                        alphabet2 = this.alphabet;
                        if (i4 >= alphabet2.charsPerChunk) {
                            break;
                        }
                        j <<= alphabet2.bitsPerChar;
                        if (i2 + i4 < trimTrailingPadding.length()) {
                            j |= (long) this.alphabet.decode(trimTrailingPadding.charAt(i5 + i2));
                            i5++;
                        }
                        i4++;
                    }
                    int i6 = alphabet2.bytesPerChunk;
                    int i7 = (i6 * 8) - (i5 * alphabet2.bitsPerChar);
                    int i8 = (i6 - 1) * 8;
                    while (i8 >= i7) {
                        bArr[i3] = (byte) ((int) ((j >>> i8) & 255));
                        i8 -= 8;
                        i3++;
                    }
                    i2 += this.alphabet.charsPerChunk;
                }
                return i3;
            }
            throw new DecodingException("Invalid input length " + trimTrailingPadding.length());
        }

        @GwtIncompatible
        public InputStream decodingStream(final Reader reader) {
            Preconditions.checkNotNull(reader);
            return new InputStream() {
                public int bitBuffer = 0;
                public int bitBufferLength = 0;
                public boolean hitPadding = false;
                public int readChars = 0;

                public void close() throws IOException {
                    reader.close();
                }

                public int read() throws IOException {
                    int i2;
                    while (true) {
                        int read = reader.read();
                        if (read != -1) {
                            this.readChars++;
                            char c = (char) read;
                            Character ch = StandardBaseEncoding.this.paddingChar;
                            if (ch == null || ch.charValue() != c) {
                                if (!this.hitPadding) {
                                    int i3 = this.bitBuffer;
                                    Alphabet alphabet = StandardBaseEncoding.this.alphabet;
                                    int i4 = i3 << alphabet.bitsPerChar;
                                    this.bitBuffer = i4;
                                    int decode = alphabet.decode(c) | i4;
                                    this.bitBuffer = decode;
                                    int i5 = this.bitBufferLength + StandardBaseEncoding.this.alphabet.bitsPerChar;
                                    this.bitBufferLength = i5;
                                    if (i5 >= 8) {
                                        int i6 = i5 - 8;
                                        this.bitBufferLength = i6;
                                        return (decode >> i6) & 255;
                                    }
                                } else {
                                    throw new DecodingException("Expected padding character but found '" + c + "' at index " + this.readChars);
                                }
                            } else if (this.hitPadding || ((i2 = this.readChars) != 1 && StandardBaseEncoding.this.alphabet.isValidPaddingStartPosition(i2 - 1))) {
                                this.hitPadding = true;
                            }
                        } else if (this.hitPadding || StandardBaseEncoding.this.alphabet.isValidPaddingStartPosition(this.readChars)) {
                            return -1;
                        } else {
                            throw new DecodingException("Invalid input length " + this.readChars);
                        }
                    }
                    throw new DecodingException("Padding cannot start at index " + this.readChars);
                }

                public int read(byte[] bArr, int i2, int i3) throws IOException {
                    int i4 = i3 + i2;
                    Preconditions.checkPositionIndexes(i2, i4, bArr.length);
                    int i5 = i2;
                    while (i5 < i4) {
                        int read = read();
                        if (read == -1) {
                            int i6 = i5 - i2;
                            if (i6 == 0) {
                                return -1;
                            }
                            return i6;
                        }
                        bArr[i5] = (byte) read;
                        i5++;
                    }
                    return i5 - i2;
                }
            };
        }

        public void encodeChunkTo(Appendable appendable, byte[] bArr, int i2, int i3) throws IOException {
            Preconditions.checkNotNull(appendable);
            Preconditions.checkPositionIndexes(i2, i2 + i3, bArr.length);
            int i4 = 0;
            Preconditions.checkArgument(i3 <= this.alphabet.bytesPerChunk);
            long j = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                j = (j | ((long) (bArr[i2 + i5] & 255))) << 8;
            }
            int i6 = ((i3 + 1) * 8) - this.alphabet.bitsPerChar;
            while (i4 < i3 * 8) {
                Alphabet alphabet2 = this.alphabet;
                appendable.append(alphabet2.encode(((int) (j >>> (i6 - i4))) & alphabet2.mask));
                i4 += this.alphabet.bitsPerChar;
            }
            if (this.paddingChar != null) {
                while (i4 < this.alphabet.bytesPerChunk * 8) {
                    appendable.append(this.paddingChar.charValue());
                    i4 += this.alphabet.bitsPerChar;
                }
            }
        }

        public void encodeTo(Appendable appendable, byte[] bArr, int i2, int i3) throws IOException {
            Preconditions.checkNotNull(appendable);
            Preconditions.checkPositionIndexes(i2, i2 + i3, bArr.length);
            int i4 = 0;
            while (i4 < i3) {
                encodeChunkTo(appendable, bArr, i2 + i4, Math.min(this.alphabet.bytesPerChunk, i3 - i4));
                i4 += this.alphabet.bytesPerChunk;
            }
        }

        @GwtIncompatible
        public OutputStream encodingStream(final Writer writer) {
            Preconditions.checkNotNull(writer);
            return new OutputStream() {
                public int bitBuffer = 0;
                public int bitBufferLength = 0;
                public int writtenChars = 0;

                public void close() throws IOException {
                    int i2 = this.bitBufferLength;
                    if (i2 > 0) {
                        int i3 = this.bitBuffer;
                        Alphabet alphabet = StandardBaseEncoding.this.alphabet;
                        writer.write(alphabet.encode((i3 << (alphabet.bitsPerChar - i2)) & alphabet.mask));
                        this.writtenChars++;
                        if (StandardBaseEncoding.this.paddingChar != null) {
                            while (true) {
                                int i4 = this.writtenChars;
                                StandardBaseEncoding standardBaseEncoding = StandardBaseEncoding.this;
                                if (i4 % standardBaseEncoding.alphabet.charsPerChunk == 0) {
                                    break;
                                }
                                writer.write(standardBaseEncoding.paddingChar.charValue());
                                this.writtenChars++;
                            }
                        }
                    }
                    writer.close();
                }

                public void flush() throws IOException {
                    writer.flush();
                }

                public void write(int i2) throws IOException {
                    int i3 = this.bitBuffer << 8;
                    this.bitBuffer = i3;
                    this.bitBuffer = (i2 & 255) | i3;
                    this.bitBufferLength += 8;
                    while (true) {
                        int i4 = this.bitBufferLength;
                        Alphabet alphabet = StandardBaseEncoding.this.alphabet;
                        int i5 = alphabet.bitsPerChar;
                        if (i4 >= i5) {
                            writer.write(alphabet.encode((this.bitBuffer >> (i4 - i5)) & alphabet.mask));
                            this.writtenChars++;
                            this.bitBufferLength -= StandardBaseEncoding.this.alphabet.bitsPerChar;
                        } else {
                            return;
                        }
                    }
                }
            };
        }

        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof StandardBaseEncoding)) {
                return false;
            }
            StandardBaseEncoding standardBaseEncoding = (StandardBaseEncoding) obj;
            if (!this.alphabet.equals(standardBaseEncoding.alphabet) || !Objects.equal(this.paddingChar, standardBaseEncoding.paddingChar)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.alphabet.hashCode() ^ Objects.hashCode(this.paddingChar);
        }

        public BaseEncoding lowerCase() {
            BaseEncoding baseEncoding = this.lowerCase;
            if (baseEncoding == null) {
                Alphabet lowerCase2 = this.alphabet.lowerCase();
                baseEncoding = lowerCase2 == this.alphabet ? this : newInstance(lowerCase2, this.paddingChar);
                this.lowerCase = baseEncoding;
            }
            return baseEncoding;
        }

        public int maxDecodedSize(int i2) {
            return (int) (((((long) this.alphabet.bitsPerChar) * ((long) i2)) + 7) / 8);
        }

        public int maxEncodedSize(int i2) {
            Alphabet alphabet2 = this.alphabet;
            return alphabet2.charsPerChunk * IntMath.divide(i2, alphabet2.bytesPerChunk, RoundingMode.CEILING);
        }

        public BaseEncoding newInstance(Alphabet alphabet2, @NullableDecl Character ch) {
            return new StandardBaseEncoding(alphabet2, ch);
        }

        public BaseEncoding omitPadding() {
            return this.paddingChar == null ? this : newInstance(this.alphabet, (Character) null);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("BaseEncoding.");
            sb.append(this.alphabet.toString());
            if (8 % this.alphabet.bitsPerChar != 0) {
                if (this.paddingChar == null) {
                    sb.append(".omitPadding()");
                } else {
                    sb.append(".withPadChar('");
                    sb.append(this.paddingChar);
                    sb.append("')");
                }
            }
            return sb.toString();
        }

        public CharSequence trimTrailingPadding(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            Character ch = this.paddingChar;
            if (ch == null) {
                return charSequence;
            }
            char charValue = ch.charValue();
            int length = charSequence.length() - 1;
            while (length >= 0 && charSequence.charAt(length) == charValue) {
                length--;
            }
            return charSequence.subSequence(0, length + 1);
        }

        public BaseEncoding upperCase() {
            BaseEncoding baseEncoding = this.upperCase;
            if (baseEncoding == null) {
                Alphabet upperCase2 = this.alphabet.upperCase();
                baseEncoding = upperCase2 == this.alphabet ? this : newInstance(upperCase2, this.paddingChar);
                this.upperCase = baseEncoding;
            }
            return baseEncoding;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
            r0 = r2.paddingChar;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.google.common.io.BaseEncoding withPadChar(char r3) {
            /*
                r2 = this;
                com.google.common.io.BaseEncoding$Alphabet r0 = r2.alphabet
                int r0 = r0.bitsPerChar
                r1 = 8
                int r1 = r1 % r0
                if (r1 == 0) goto L_0x001f
                java.lang.Character r0 = r2.paddingChar
                if (r0 == 0) goto L_0x0014
                char r0 = r0.charValue()
                if (r0 != r3) goto L_0x0014
                goto L_0x001f
            L_0x0014:
                com.google.common.io.BaseEncoding$Alphabet r0 = r2.alphabet
                java.lang.Character r3 = java.lang.Character.valueOf(r3)
                com.google.common.io.BaseEncoding r3 = r2.newInstance(r0, r3)
                return r3
            L_0x001f:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.BaseEncoding.StandardBaseEncoding.withPadChar(char):com.google.common.io.BaseEncoding");
        }

        public BaseEncoding withSeparator(String str, int i2) {
            boolean z = false;
            for (int i3 = 0; i3 < str.length(); i3++) {
                Preconditions.checkArgument(!this.alphabet.matches(str.charAt(i3)), "Separator (%s) cannot contain alphabet characters", (Object) str);
            }
            Character ch = this.paddingChar;
            if (ch != null) {
                if (str.indexOf(ch.charValue()) < 0) {
                    z = true;
                }
                Preconditions.checkArgument(z, "Separator (%s) cannot contain padding character", (Object) str);
            }
            return new SeparatedBaseEncoding(this, str, i2);
        }

        public StandardBaseEncoding(Alphabet alphabet2, @NullableDecl Character ch) {
            this.alphabet = (Alphabet) Preconditions.checkNotNull(alphabet2);
            Preconditions.checkArgument(ch == null || !alphabet2.matches(ch.charValue()), "Padding character %s was already in alphabet", (Object) ch);
            this.paddingChar = ch;
        }
    }

    static {
        Character valueOf = Character.valueOf(a.h);
        BASE64 = new Base64Encoding("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", valueOf);
        BASE64_URL = new Base64Encoding("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", valueOf);
        BASE32 = new StandardBaseEncoding("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", valueOf);
        BASE32_HEX = new StandardBaseEncoding("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", valueOf);
    }

    public static BaseEncoding base16() {
        return BASE16;
    }

    public static BaseEncoding base32() {
        return BASE32;
    }

    public static BaseEncoding base32Hex() {
        return BASE32_HEX;
    }

    public static BaseEncoding base64() {
        return BASE64;
    }

    public static BaseEncoding base64Url() {
        return BASE64_URL;
    }

    public static byte[] extract(byte[] bArr, int i2) {
        if (i2 == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, 0, bArr2, 0, i2);
        return bArr2;
    }

    @GwtIncompatible
    public static Reader ignoringReader(final Reader reader, final String str) {
        Preconditions.checkNotNull(reader);
        Preconditions.checkNotNull(str);
        return new Reader() {
            public void close() throws IOException {
                reader.close();
            }

            /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: 
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
                	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
                */
            public int read() throws java.io.IOException {
                /*
                    r3 = this;
                L_0x0000:
                    java.io.Reader r0 = r1
                    int r0 = r0.read()
                    r1 = -1
                    if (r0 == r1) goto L_0x0012
                    java.lang.String r1 = r2
                    char r2 = (char) r0
                    int r1 = r1.indexOf(r2)
                    if (r1 >= 0) goto L_0x0000
                L_0x0012:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.BaseEncoding.AnonymousClass3.read():int");
            }

            public int read(char[] cArr, int i2, int i3) throws IOException {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static Appendable separatingAppendable(final Appendable appendable, final String str, final int i2) {
        Preconditions.checkNotNull(appendable);
        Preconditions.checkNotNull(str);
        Preconditions.checkArgument(i2 > 0);
        return new Appendable() {
            public int charsUntilSeparator = i2;

            public Appendable append(char c) throws IOException {
                if (this.charsUntilSeparator == 0) {
                    appendable.append(str);
                    this.charsUntilSeparator = i2;
                }
                appendable.append(c);
                this.charsUntilSeparator--;
                return this;
            }

            public Appendable append(@NullableDecl CharSequence charSequence, int i2, int i3) throws IOException {
                throw new UnsupportedOperationException();
            }

            public Appendable append(@NullableDecl CharSequence charSequence) throws IOException {
                throw new UnsupportedOperationException();
            }
        };
    }

    @GwtIncompatible
    public static Writer separatingWriter(final Writer writer, String str, int i2) {
        final Appendable separatingAppendable = separatingAppendable(writer, str, i2);
        return new Writer() {
            public void close() throws IOException {
                writer.close();
            }

            public void flush() throws IOException {
                writer.flush();
            }

            public void write(int i2) throws IOException {
                separatingAppendable.append((char) i2);
            }

            public void write(char[] cArr, int i2, int i3) throws IOException {
                throw new UnsupportedOperationException();
            }
        };
    }

    public abstract boolean canDecode(CharSequence charSequence);

    public final byte[] decode(CharSequence charSequence) {
        try {
            return decodeChecked(charSequence);
        } catch (DecodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public final byte[] decodeChecked(CharSequence charSequence) throws DecodingException {
        CharSequence trimTrailingPadding = trimTrailingPadding(charSequence);
        byte[] bArr = new byte[maxDecodedSize(trimTrailingPadding.length())];
        return extract(bArr, decodeTo(bArr, trimTrailingPadding));
    }

    public abstract int decodeTo(byte[] bArr, CharSequence charSequence) throws DecodingException;

    @GwtIncompatible
    public final ByteSource decodingSource(final CharSource charSource) {
        Preconditions.checkNotNull(charSource);
        return new ByteSource() {
            public InputStream openStream() throws IOException {
                return BaseEncoding.this.decodingStream(charSource.openStream());
            }
        };
    }

    @GwtIncompatible
    public abstract InputStream decodingStream(Reader reader);

    public String encode(byte[] bArr) {
        return encode(bArr, 0, bArr.length);
    }

    public abstract void encodeTo(Appendable appendable, byte[] bArr, int i2, int i3) throws IOException;

    @GwtIncompatible
    public final ByteSink encodingSink(final CharSink charSink) {
        Preconditions.checkNotNull(charSink);
        return new ByteSink() {
            public OutputStream openStream() throws IOException {
                return BaseEncoding.this.encodingStream(charSink.openStream());
            }
        };
    }

    @GwtIncompatible
    public abstract OutputStream encodingStream(Writer writer);

    public abstract BaseEncoding lowerCase();

    public abstract int maxDecodedSize(int i2);

    public abstract int maxEncodedSize(int i2);

    public abstract BaseEncoding omitPadding();

    public CharSequence trimTrailingPadding(CharSequence charSequence) {
        return (CharSequence) Preconditions.checkNotNull(charSequence);
    }

    public abstract BaseEncoding upperCase();

    public abstract BaseEncoding withPadChar(char c);

    public abstract BaseEncoding withSeparator(String str, int i2);

    public final String encode(byte[] bArr, int i2, int i3) {
        Preconditions.checkPositionIndexes(i2, i2 + i3, bArr.length);
        StringBuilder sb = new StringBuilder(maxEncodedSize(i3));
        try {
            encodeTo(sb, bArr, i2, i3);
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
