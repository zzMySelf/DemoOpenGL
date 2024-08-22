package org.apache.commons.codec.binary4util;

import android.annotation.SuppressLint;
import androidx.exifinterface.media.ExifInterface;
import com.google.common.base.Ascii;
import java.math.BigInteger;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.apache.commons.base.binary4util.CodecStringUtils;
import org.apache.commons.codec.binary4util.BaseNCodec;

@SuppressLint({"BDThrowableCheck"})
public class Base64 extends BaseNCodec {
    public static final int BITS_PER_ENCODED_BYTE = 6;
    public static final int BYTES_PER_ENCODED_BLOCK = 4;
    public static final int BYTES_PER_UNENCODED_BLOCK = 3;
    public static final byte[] CHUNK_SEPARATOR = {13, 10};
    public static final byte[] DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, -1, -1, -1, -1, 63, -1, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 34, 35, 36, 37, 38, 39, 40, 41, ExifInterface.START_CODE, 43, 44, 45, 46, ExifInterface.WEBP_VP8L_SIGNATURE, 48, 49, 50, 51};
    public static final int MASK_6BITS = 63;
    public static final byte[] STANDARD_ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, ExifInterface.WEBP_VP8L_SIGNATURE};
    public static final byte[] URL_SAFE_ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    public final int decodeSize;
    public final byte[] decodeTable;
    public final int encodeSize;
    public final byte[] encodeTable;
    public final byte[] lineSeparator;

    public Base64() {
        this(0);
    }

    public static byte[] decodeBase64(String str) {
        return new Base64().decode(str);
    }

    public static BigInteger decodeInteger(byte[] bArr) {
        return new BigInteger(1, decodeBase64(bArr));
    }

    public static byte[] encodeBase64(byte[] bArr) {
        return encodeBase64(bArr, false);
    }

    public static byte[] encodeBase64Chunked(byte[] bArr) {
        return encodeBase64(bArr, true);
    }

    public static String encodeBase64String(byte[] bArr) {
        return CodecStringUtils.newStringUsAscii(encodeBase64(bArr, false));
    }

    public static byte[] encodeBase64URLSafe(byte[] bArr) {
        return encodeBase64(bArr, false, true);
    }

    public static String encodeBase64URLSafeString(byte[] bArr) {
        return CodecStringUtils.newStringUsAscii(encodeBase64(bArr, false, true));
    }

    public static byte[] encodeInteger(BigInteger bigInteger) {
        if (bigInteger != null) {
            return encodeBase64(toIntegerBytes(bigInteger), false);
        }
        throw new NullPointerException("encodeInteger called with null parameter");
    }

    @Deprecated
    public static boolean isArrayByteBase64(byte[] bArr) {
        return isBase64(bArr);
    }

    public static boolean isBase64(byte b) {
        if (b != 61) {
            if (b >= 0) {
                byte[] bArr = DECODE_TABLE;
                if (b >= bArr.length || bArr[b] == -1) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public static byte[] toIntegerBytes(BigInteger bigInteger) {
        int bitLength = ((bigInteger.bitLength() + 7) >> 3) << 3;
        byte[] byteArray = bigInteger.toByteArray();
        int i2 = 1;
        if (bigInteger.bitLength() % 8 != 0 && (bigInteger.bitLength() / 8) + 1 == bitLength / 8) {
            return byteArray;
        }
        int length = byteArray.length;
        if (bigInteger.bitLength() % 8 == 0) {
            length--;
        } else {
            i2 = 0;
        }
        int i3 = bitLength / 8;
        int i4 = i3 - length;
        byte[] bArr = new byte[i3];
        System.arraycopy(byteArray, i2, bArr, i4, length);
        return bArr;
    }

    public void decode(byte[] bArr, int i2, int i3, BaseNCodec.Context context) {
        byte b;
        if (!context.eof) {
            if (i3 < 0) {
                context.eof = true;
            }
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    break;
                }
                byte[] ensureBufferSize = ensureBufferSize(this.decodeSize, context);
                int i5 = i2 + 1;
                byte b2 = bArr[i2];
                if (b2 == this.pad) {
                    context.eof = true;
                    break;
                }
                if (b2 >= 0) {
                    byte[] bArr2 = DECODE_TABLE;
                    if (b2 < bArr2.length && (b = bArr2[b2]) >= 0) {
                        int i6 = (context.modulus + 1) % 4;
                        context.modulus = i6;
                        int i7 = (context.ibitWorkArea << 6) + b;
                        context.ibitWorkArea = i7;
                        if (i6 == 0) {
                            int i8 = context.pos;
                            int i9 = i8 + 1;
                            context.pos = i9;
                            ensureBufferSize[i8] = (byte) ((i7 >> 16) & 255);
                            int i10 = i9 + 1;
                            context.pos = i10;
                            ensureBufferSize[i9] = (byte) ((i7 >> 8) & 255);
                            context.pos = i10 + 1;
                            ensureBufferSize[i10] = (byte) (i7 & 255);
                        }
                    }
                }
                i4++;
                i2 = i5;
            }
            if (context.eof && context.modulus != 0) {
                byte[] ensureBufferSize2 = ensureBufferSize(this.decodeSize, context);
                int i11 = context.modulus;
                if (i11 == 1) {
                    return;
                }
                if (i11 == 2) {
                    int i12 = context.ibitWorkArea >> 4;
                    context.ibitWorkArea = i12;
                    int i13 = context.pos;
                    context.pos = i13 + 1;
                    ensureBufferSize2[i13] = (byte) (i12 & 255);
                } else if (i11 == 3) {
                    int i14 = context.ibitWorkArea >> 2;
                    context.ibitWorkArea = i14;
                    int i15 = context.pos;
                    int i16 = i15 + 1;
                    context.pos = i16;
                    ensureBufferSize2[i15] = (byte) ((i14 >> 8) & 255);
                    context.pos = i16 + 1;
                    ensureBufferSize2[i16] = (byte) (i14 & 255);
                } else {
                    throw new IllegalStateException("Impossible modulus " + context.modulus);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v21, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void encode(byte[] r10, int r11, int r12, org.apache.commons.codec.binary4util.BaseNCodec.Context r13) {
        /*
            r9 = this;
            boolean r0 = r13.eof
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 0
            r1 = 1
            if (r12 >= 0) goto L_0x00c0
            r13.eof = r1
            int r10 = r13.modulus
            if (r10 != 0) goto L_0x0014
            int r10 = r9.lineLength
            if (r10 != 0) goto L_0x0014
            return
        L_0x0014:
            int r10 = r9.encodeSize
            byte[] r10 = r9.ensureBufferSize(r10, r13)
            int r11 = r13.pos
            int r12 = r13.modulus
            if (r12 == 0) goto L_0x00a1
            if (r12 == r1) goto L_0x0073
            r1 = 2
            if (r12 != r1) goto L_0x005a
            int r12 = r11 + 1
            r13.pos = r12
            byte[] r2 = r9.encodeTable
            int r3 = r13.ibitWorkArea
            int r4 = r3 >> 10
            r4 = r4 & 63
            byte r4 = r2[r4]
            r10[r11] = r4
            int r4 = r12 + 1
            r13.pos = r4
            int r5 = r3 >> 4
            r5 = r5 & 63
            byte r5 = r2[r5]
            r10[r12] = r5
            int r12 = r4 + 1
            r13.pos = r12
            int r1 = r3 << 2
            r1 = r1 & 63
            byte r1 = r2[r1]
            r10[r4] = r1
            byte[] r1 = STANDARD_ENCODE_TABLE
            if (r2 != r1) goto L_0x00a1
            int r1 = r12 + 1
            r13.pos = r1
            byte r1 = r9.pad
            r10[r12] = r1
            goto L_0x00a1
        L_0x005a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "Impossible modulus "
            r11.append(r12)
            int r12 = r13.modulus
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        L_0x0073:
            int r12 = r11 + 1
            r13.pos = r12
            byte[] r1 = r9.encodeTable
            int r2 = r13.ibitWorkArea
            int r3 = r2 >> 2
            r3 = r3 & 63
            byte r3 = r1[r3]
            r10[r11] = r3
            int r3 = r12 + 1
            r13.pos = r3
            int r2 = r2 << 4
            r2 = r2 & 63
            byte r2 = r1[r2]
            r10[r12] = r2
            byte[] r12 = STANDARD_ENCODE_TABLE
            if (r1 != r12) goto L_0x00a1
            int r12 = r3 + 1
            r13.pos = r12
            byte r1 = r9.pad
            r10[r3] = r1
            int r2 = r12 + 1
            r13.pos = r2
            r10[r12] = r1
        L_0x00a1:
            int r12 = r13.currentLinePos
            int r1 = r13.pos
            int r11 = r1 - r11
            int r12 = r12 + r11
            r13.currentLinePos = r12
            int r11 = r9.lineLength
            if (r11 <= 0) goto L_0x0135
            if (r12 <= 0) goto L_0x0135
            byte[] r11 = r9.lineSeparator
            int r12 = r11.length
            java.lang.System.arraycopy(r11, r0, r10, r1, r12)
            int r10 = r13.pos
            byte[] r11 = r9.lineSeparator
            int r11 = r11.length
            int r10 = r10 + r11
            r13.pos = r10
            goto L_0x0135
        L_0x00c0:
            r2 = 0
        L_0x00c1:
            if (r2 >= r12) goto L_0x0135
            int r3 = r9.encodeSize
            byte[] r3 = r9.ensureBufferSize(r3, r13)
            int r4 = r13.modulus
            int r4 = r4 + r1
            int r4 = r4 % 3
            r13.modulus = r4
            int r4 = r11 + 1
            byte r11 = r10[r11]
            if (r11 >= 0) goto L_0x00d8
            int r11 = r11 + 256
        L_0x00d8:
            int r5 = r13.ibitWorkArea
            int r5 = r5 << 8
            int r5 = r5 + r11
            r13.ibitWorkArea = r5
            int r11 = r13.modulus
            if (r11 != 0) goto L_0x0131
            int r11 = r13.pos
            int r6 = r11 + 1
            r13.pos = r6
            byte[] r7 = r9.encodeTable
            int r8 = r5 >> 18
            r8 = r8 & 63
            byte r8 = r7[r8]
            r3[r11] = r8
            int r11 = r6 + 1
            r13.pos = r11
            int r8 = r5 >> 12
            r8 = r8 & 63
            byte r8 = r7[r8]
            r3[r6] = r8
            int r6 = r11 + 1
            r13.pos = r6
            int r8 = r5 >> 6
            r8 = r8 & 63
            byte r8 = r7[r8]
            r3[r11] = r8
            int r11 = r6 + 1
            r13.pos = r11
            r5 = r5 & 63
            byte r5 = r7[r5]
            r3[r6] = r5
            int r5 = r13.currentLinePos
            int r5 = r5 + 4
            r13.currentLinePos = r5
            int r6 = r9.lineLength
            if (r6 <= 0) goto L_0x0131
            if (r6 > r5) goto L_0x0131
            byte[] r5 = r9.lineSeparator
            int r6 = r5.length
            java.lang.System.arraycopy(r5, r0, r3, r11, r6)
            int r11 = r13.pos
            byte[] r3 = r9.lineSeparator
            int r3 = r3.length
            int r11 = r11 + r3
            r13.pos = r11
            r13.currentLinePos = r0
        L_0x0131:
            int r2 = r2 + 1
            r11 = r4
            goto L_0x00c1
        L_0x0135:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.binary4util.Base64.encode(byte[], int, int, org.apache.commons.codec.binary4util.BaseNCodec$Context):void");
    }

    public boolean isInAlphabet(byte b) {
        if (b >= 0) {
            byte[] bArr = this.decodeTable;
            return b < bArr.length && bArr[b] != -1;
        }
    }

    public boolean isUrlSafe() {
        return this.encodeTable == URL_SAFE_ENCODE_TABLE;
    }

    public Base64(boolean z) {
        this(76, CHUNK_SEPARATOR, z);
    }

    public static byte[] decodeBase64(byte[] bArr) {
        return new Base64().decode(bArr);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z) {
        return encodeBase64(bArr, z, false);
    }

    public static boolean isBase64(String str) {
        return isBase64(CodecStringUtils.getBytesUtf8(str));
    }

    public Base64(int i2) {
        this(i2, CHUNK_SEPARATOR);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z, boolean z2) {
        return encodeBase64(bArr, z, z2, Integer.MAX_VALUE);
    }

    public static boolean isBase64(byte[] bArr) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (!isBase64(bArr[i2]) && !BaseNCodec.isWhiteSpace(bArr[i2])) {
                return false;
            }
        }
        return true;
    }

    public Base64(int i2, byte[] bArr) {
        this(i2, bArr, false);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z, boolean z2, int i2) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        Base64 base64 = z ? new Base64(z2) : new Base64(0, CHUNK_SEPARATOR, z2);
        long encodedLength = base64.getEncodedLength(bArr);
        if (encodedLength <= ((long) i2)) {
            return base64.encode(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + encodedLength + ") than the specified maximum size of " + i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Base64(int i2, byte[] bArr, boolean z) {
        super(3, 4, i2, bArr == null ? 0 : bArr.length);
        this.decodeTable = DECODE_TABLE;
        if (bArr == null) {
            this.encodeSize = 4;
            this.lineSeparator = null;
        } else if (containsAlphabetOrPad(bArr)) {
            String newStringUtf8 = CodecStringUtils.newStringUtf8(bArr);
            throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + newStringUtf8 + "]");
        } else if (i2 > 0) {
            this.encodeSize = bArr.length + 4;
            byte[] bArr2 = new byte[bArr.length];
            this.lineSeparator = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        } else {
            this.encodeSize = 4;
            this.lineSeparator = null;
        }
        this.decodeSize = this.encodeSize - 1;
        this.encodeTable = z ? URL_SAFE_ENCODE_TABLE : STANDARD_ENCODE_TABLE;
    }
}
