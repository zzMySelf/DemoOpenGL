package com.heytap.msp.push.encrypt;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.chatsearch.aisearch.resultpage.toolbar.discovery.span.RhetoricalTagUtilKt;
import com.baidu.searchbox.lockscreen.helper.SwipeGestureHelper;
import com.baidu.talos.core.archivers.tar.TarConstants;
import com.yy.transvod.player.core.NetStatManager;
import java.math.BigInteger;
import okio.Utf8;
import org.apache.commons.codec.binary.StringUtils;

public class Base64 extends BaseNCodec {
    private static final int BITS_PER_ENCODED_BYTE = 6;
    private static final int BYTES_PER_ENCODED_BLOCK = 4;
    private static final int BYTES_PER_UNENCODED_BLOCK = 3;
    static final byte[] CHUNK_SEPARATOR = {13, 10};
    private static final byte[] DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, Utf8.REPLACEMENT_BYTE, TarConstants.LF_BLK, TarConstants.LF_DIR, TarConstants.LF_FIFO, TarConstants.LF_CONTIG, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Constants.GZIP_CAST_TYPE, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, Utf8.REPLACEMENT_BYTE, -1, 26, 27, 28, 29, 30, 31, NetStatManager.ISPType.MOB, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_SYMLINK, TarConstants.LF_CHR};
    private static final int MASK_6BITS = 63;
    private static final byte[] STANDARD_ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, TarConstants.LF_GNUTYPE_LONGLINK, TarConstants.LF_GNUTYPE_LONGNAME, 77, 78, 79, 80, 81, 82, TarConstants.LF_GNUTYPE_SPARSE, 84, 85, 86, 87, TarConstants.LF_PAX_EXTENDED_HEADER_UC, 89, 90, 97, SwipeGestureHelper.BOTTOM_SWIPE, 99, 100, 101, 102, TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 104, 105, 106, 107, SwipeGestureHelper.LEFT_SWIPE, 109, 110, 111, 112, 113, SwipeGestureHelper.RIGHT_SWIPE, 115, SwipeGestureHelper.TOP_SWIPE, 117, 118, 119, TarConstants.LF_PAX_EXTENDED_HEADER_LC, 121, 122, TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_SYMLINK, TarConstants.LF_CHR, TarConstants.LF_BLK, TarConstants.LF_DIR, TarConstants.LF_FIFO, TarConstants.LF_CONTIG, 56, 57, 43, 47};
    private static final byte[] URL_SAFE_ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, TarConstants.LF_GNUTYPE_LONGLINK, TarConstants.LF_GNUTYPE_LONGNAME, 77, 78, 79, 80, 81, 82, TarConstants.LF_GNUTYPE_SPARSE, 84, 85, 86, 87, TarConstants.LF_PAX_EXTENDED_HEADER_UC, 89, 90, 97, SwipeGestureHelper.BOTTOM_SWIPE, 99, 100, 101, 102, TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 104, 105, 106, 107, SwipeGestureHelper.LEFT_SWIPE, 109, 110, 111, 112, 113, SwipeGestureHelper.RIGHT_SWIPE, 115, SwipeGestureHelper.TOP_SWIPE, 117, 118, 119, TarConstants.LF_PAX_EXTENDED_HEADER_LC, 121, 122, TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_SYMLINK, TarConstants.LF_CHR, TarConstants.LF_BLK, TarConstants.LF_DIR, TarConstants.LF_FIFO, TarConstants.LF_CONTIG, 56, 57, 45, 95};
    private int bitWorkArea;
    private final int decodeSize;
    private final byte[] decodeTable;
    private final int encodeSize;
    private final byte[] encodeTable;
    private final byte[] lineSeparator;

    public Base64() {
        this(0);
    }

    public Base64(boolean urlSafe) {
        this(76, CHUNK_SEPARATOR, urlSafe);
    }

    public Base64(int lineLength) {
        this(lineLength, CHUNK_SEPARATOR);
    }

    public Base64(int lineLength, byte[] lineSeparator2) {
        this(lineLength, lineSeparator2, false);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Base64(int lineLength, byte[] lineSeparator2, boolean urlSafe) {
        super(3, 4, lineLength, lineSeparator2 == null ? 0 : lineSeparator2.length);
        this.decodeTable = DECODE_TABLE;
        if (lineSeparator2 == null) {
            this.encodeSize = 4;
            this.lineSeparator = null;
        } else if (containsAlphabetOrPad(lineSeparator2)) {
            throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + StringUtils.newStringUtf8(lineSeparator2) + RhetoricalTagUtilKt.TAG_END_SYMBOL);
        } else if (lineLength > 0) {
            this.encodeSize = lineSeparator2.length + 4;
            byte[] bArr = new byte[lineSeparator2.length];
            this.lineSeparator = bArr;
            System.arraycopy(lineSeparator2, 0, bArr, 0, lineSeparator2.length);
        } else {
            this.encodeSize = 4;
            this.lineSeparator = null;
        }
        this.decodeSize = this.encodeSize - 1;
        this.encodeTable = urlSafe ? URL_SAFE_ENCODE_TABLE : STANDARD_ENCODE_TABLE;
    }

    public boolean isUrlSafe() {
        return this.encodeTable == URL_SAFE_ENCODE_TABLE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void encode(byte[] r9, int r10, int r11) {
        /*
            r8 = this;
            boolean r0 = r8.eof
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 0
            r1 = 1
            if (r11 >= 0) goto L_0x00d5
            r8.eof = r1
            int r1 = r8.modulus
            if (r1 != 0) goto L_0x0014
            int r1 = r8.lineLength
            if (r1 != 0) goto L_0x0014
            return
        L_0x0014:
            int r1 = r8.encodeSize
            r8.ensureBufferSize(r1)
            int r1 = r8.pos
            int r2 = r8.modulus
            r3 = 61
            switch(r2) {
                case 1: goto L_0x006f;
                case 2: goto L_0x0024;
                default: goto L_0x0022;
            }
        L_0x0022:
            goto L_0x00af
        L_0x0024:
            byte[] r2 = r8.buffer
            int r4 = r8.pos
            int r5 = r4 + 1
            r8.pos = r5
            byte[] r5 = r8.encodeTable
            int r6 = r8.bitWorkArea
            int r6 = r6 >> 10
            r6 = r6 & 63
            byte r5 = r5[r6]
            r2[r4] = r5
            byte[] r2 = r8.buffer
            int r4 = r8.pos
            int r5 = r4 + 1
            r8.pos = r5
            byte[] r5 = r8.encodeTable
            int r6 = r8.bitWorkArea
            int r6 = r6 >> 4
            r6 = r6 & 63
            byte r5 = r5[r6]
            r2[r4] = r5
            byte[] r2 = r8.buffer
            int r4 = r8.pos
            int r5 = r4 + 1
            r8.pos = r5
            byte[] r5 = r8.encodeTable
            int r6 = r8.bitWorkArea
            int r6 = r6 << 2
            r6 = r6 & 63
            byte r6 = r5[r6]
            r2[r4] = r6
            byte[] r2 = STANDARD_ENCODE_TABLE
            if (r5 != r2) goto L_0x00af
            byte[] r2 = r8.buffer
            int r4 = r8.pos
            int r5 = r4 + 1
            r8.pos = r5
            r2[r4] = r3
            goto L_0x00af
        L_0x006f:
            byte[] r2 = r8.buffer
            int r4 = r8.pos
            int r5 = r4 + 1
            r8.pos = r5
            byte[] r5 = r8.encodeTable
            int r6 = r8.bitWorkArea
            int r6 = r6 >> 2
            r6 = r6 & 63
            byte r5 = r5[r6]
            r2[r4] = r5
            byte[] r2 = r8.buffer
            int r4 = r8.pos
            int r5 = r4 + 1
            r8.pos = r5
            byte[] r5 = r8.encodeTable
            int r6 = r8.bitWorkArea
            int r6 = r6 << 4
            r6 = r6 & 63
            byte r6 = r5[r6]
            r2[r4] = r6
            byte[] r2 = STANDARD_ENCODE_TABLE
            if (r5 != r2) goto L_0x00af
            byte[] r2 = r8.buffer
            int r4 = r8.pos
            int r5 = r4 + 1
            r8.pos = r5
            r2[r4] = r3
            byte[] r2 = r8.buffer
            int r4 = r8.pos
            int r5 = r4 + 1
            r8.pos = r5
            r2[r4] = r3
        L_0x00af:
            int r2 = r8.currentLinePos
            int r3 = r8.pos
            int r3 = r3 - r1
            int r2 = r2 + r3
            r8.currentLinePos = r2
            int r2 = r8.lineLength
            if (r2 <= 0) goto L_0x00d3
            int r2 = r8.currentLinePos
            if (r2 <= 0) goto L_0x00d3
            byte[] r2 = r8.lineSeparator
            byte[] r3 = r8.buffer
            int r4 = r8.pos
            byte[] r5 = r8.lineSeparator
            int r5 = r5.length
            java.lang.System.arraycopy(r2, r0, r3, r4, r5)
            int r0 = r8.pos
            byte[] r2 = r8.lineSeparator
            int r2 = r2.length
            int r0 = r0 + r2
            r8.pos = r0
        L_0x00d3:
            goto L_0x0170
        L_0x00d5:
            r2 = 0
        L_0x00d6:
            if (r2 >= r11) goto L_0x0170
            int r3 = r8.encodeSize
            r8.ensureBufferSize(r3)
            int r3 = r8.modulus
            int r3 = r3 + r1
            int r3 = r3 % 3
            r8.modulus = r3
            int r3 = r10 + 1
            byte r10 = r9[r10]
            if (r10 >= 0) goto L_0x00ec
            int r10 = r10 + 256
        L_0x00ec:
            int r4 = r8.bitWorkArea
            int r4 = r4 << 8
            int r4 = r4 + r10
            r8.bitWorkArea = r4
            int r4 = r8.modulus
            if (r4 != 0) goto L_0x016b
            byte[] r4 = r8.buffer
            int r5 = r8.pos
            int r6 = r5 + 1
            r8.pos = r6
            byte[] r6 = r8.encodeTable
            int r7 = r8.bitWorkArea
            int r7 = r7 >> 18
            r7 = r7 & 63
            byte r6 = r6[r7]
            r4[r5] = r6
            byte[] r4 = r8.buffer
            int r5 = r8.pos
            int r6 = r5 + 1
            r8.pos = r6
            byte[] r6 = r8.encodeTable
            int r7 = r8.bitWorkArea
            int r7 = r7 >> 12
            r7 = r7 & 63
            byte r6 = r6[r7]
            r4[r5] = r6
            byte[] r4 = r8.buffer
            int r5 = r8.pos
            int r6 = r5 + 1
            r8.pos = r6
            byte[] r6 = r8.encodeTable
            int r7 = r8.bitWorkArea
            int r7 = r7 >> 6
            r7 = r7 & 63
            byte r6 = r6[r7]
            r4[r5] = r6
            byte[] r4 = r8.buffer
            int r5 = r8.pos
            int r6 = r5 + 1
            r8.pos = r6
            byte[] r6 = r8.encodeTable
            int r7 = r8.bitWorkArea
            r7 = r7 & 63
            byte r6 = r6[r7]
            r4[r5] = r6
            int r4 = r8.currentLinePos
            int r4 = r4 + 4
            r8.currentLinePos = r4
            int r4 = r8.lineLength
            if (r4 <= 0) goto L_0x016b
            int r4 = r8.lineLength
            int r5 = r8.currentLinePos
            if (r4 > r5) goto L_0x016b
            byte[] r4 = r8.lineSeparator
            byte[] r5 = r8.buffer
            int r6 = r8.pos
            byte[] r7 = r8.lineSeparator
            int r7 = r7.length
            java.lang.System.arraycopy(r4, r0, r5, r6, r7)
            int r4 = r8.pos
            byte[] r5 = r8.lineSeparator
            int r5 = r5.length
            int r4 = r4 + r5
            r8.pos = r4
            r8.currentLinePos = r0
        L_0x016b:
            int r2 = r2 + 1
            r10 = r3
            goto L_0x00d6
        L_0x0170:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.heytap.msp.push.encrypt.Base64.encode(byte[], int, int):void");
    }

    /* access modifiers changed from: package-private */
    public void decode(byte[] in, int inPos, int inAvail) {
        byte result;
        if (!this.eof) {
            if (inAvail < 0) {
                this.eof = true;
            }
            int i2 = 0;
            while (true) {
                if (i2 >= inAvail) {
                    break;
                }
                ensureBufferSize(this.decodeSize);
                int inPos2 = inPos + 1;
                byte b2 = in[inPos];
                if (b2 == 61) {
                    this.eof = true;
                    int i3 = inPos2;
                    break;
                }
                if (b2 >= 0) {
                    byte[] bArr = DECODE_TABLE;
                    if (b2 < bArr.length && (result = bArr[b2]) >= 0) {
                        this.modulus = (this.modulus + 1) % 4;
                        this.bitWorkArea = (this.bitWorkArea << 6) + result;
                        if (this.modulus == 0) {
                            byte[] bArr2 = this.buffer;
                            int i4 = this.pos;
                            this.pos = i4 + 1;
                            bArr2[i4] = (byte) ((this.bitWorkArea >> 16) & 255);
                            byte[] bArr3 = this.buffer;
                            int i5 = this.pos;
                            this.pos = i5 + 1;
                            bArr3[i5] = (byte) ((this.bitWorkArea >> 8) & 255);
                            byte[] bArr4 = this.buffer;
                            int i6 = this.pos;
                            this.pos = i6 + 1;
                            bArr4[i6] = (byte) (this.bitWorkArea & 255);
                        }
                    }
                }
                i2++;
                inPos = inPos2;
            }
            if (this.eof && this.modulus != 0) {
                ensureBufferSize(this.decodeSize);
                switch (this.modulus) {
                    case 2:
                        this.bitWorkArea >>= 4;
                        byte[] bArr5 = this.buffer;
                        int i7 = this.pos;
                        this.pos = i7 + 1;
                        bArr5[i7] = (byte) (this.bitWorkArea & 255);
                        return;
                    case 3:
                        this.bitWorkArea >>= 2;
                        byte[] bArr6 = this.buffer;
                        int i8 = this.pos;
                        this.pos = i8 + 1;
                        bArr6[i8] = (byte) ((this.bitWorkArea >> 8) & 255);
                        byte[] bArr7 = this.buffer;
                        int i9 = this.pos;
                        this.pos = i9 + 1;
                        bArr7[i9] = (byte) (this.bitWorkArea & 255);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public static boolean isArrayByteBase64(byte[] arrayOctet) {
        return isBase64(arrayOctet);
    }

    public static boolean isBase64(byte octet) {
        if (octet != 61) {
            if (octet >= 0) {
                byte[] bArr = DECODE_TABLE;
                if (octet >= bArr.length || bArr[octet] == -1) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public static boolean isBase64(String base64) {
        return isBase64(StringUtils.getBytesUtf8(base64));
    }

    public static boolean isBase64(byte[] arrayOctet) {
        for (int i2 = 0; i2 < arrayOctet.length; i2++) {
            if (!isBase64(arrayOctet[i2]) && !isWhiteSpace(arrayOctet[i2])) {
                return false;
            }
        }
        return true;
    }

    public static byte[] encodeBase64(byte[] binaryData) {
        return encodeBase64(binaryData, false);
    }

    public static String encodeBase64String(byte[] binaryData) {
        return StringUtils.newStringUtf8(encodeBase64(binaryData, false));
    }

    public static byte[] encodeBase64URLSafe(byte[] binaryData) {
        return encodeBase64(binaryData, false, true);
    }

    public static String encodeBase64URLSafeString(byte[] binaryData) {
        return StringUtils.newStringUtf8(encodeBase64(binaryData, false, true));
    }

    public static byte[] encodeBase64Chunked(byte[] binaryData) {
        return encodeBase64(binaryData, true);
    }

    public static byte[] encodeBase64(byte[] binaryData, boolean isChunked) {
        return encodeBase64(binaryData, isChunked, false);
    }

    public static byte[] encodeBase64(byte[] binaryData, boolean isChunked, boolean urlSafe) {
        return encodeBase64(binaryData, isChunked, urlSafe, Integer.MAX_VALUE);
    }

    public static byte[] encodeBase64(byte[] binaryData, boolean isChunked, boolean urlSafe, int maxResultSize) {
        Base64 b64;
        if (binaryData == null || binaryData.length == 0) {
            return binaryData;
        }
        if (!isChunked) {
            b64 = new Base64(0, CHUNK_SEPARATOR, urlSafe);
        }
        long len = b64.getEncodedLength(binaryData);
        if (len <= ((long) maxResultSize)) {
            return b64.encode(binaryData);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + len + ") than the specified maximum size of " + maxResultSize);
    }

    public static byte[] decodeBase64(String base64String) {
        return new Base64().decode(base64String);
    }

    public static byte[] decodeBase64(byte[] base64Data) {
        return new Base64().decode(base64Data);
    }

    public static BigInteger decodeInteger(byte[] pArray) {
        return new BigInteger(1, decodeBase64(pArray));
    }

    public static byte[] encodeInteger(BigInteger bigInt) {
        if (bigInt != null) {
            return encodeBase64(toIntegerBytes(bigInt), false);
        }
        throw new NullPointerException("encodeInteger called with null parameter");
    }

    static byte[] toIntegerBytes(BigInteger bigInt) {
        int bitlen = ((bigInt.bitLength() + 7) >> 3) << 3;
        byte[] bigBytes = bigInt.toByteArray();
        if (bigInt.bitLength() % 8 != 0 && (bigInt.bitLength() / 8) + 1 == bitlen / 8) {
            return bigBytes;
        }
        int startSrc = 0;
        int len = bigBytes.length;
        if (bigInt.bitLength() % 8 == 0) {
            startSrc = 1;
            len--;
        }
        byte[] resizedBytes = new byte[(bitlen / 8)];
        System.arraycopy(bigBytes, startSrc, resizedBytes, (bitlen / 8) - len, len);
        return resizedBytes;
    }

    /* access modifiers changed from: protected */
    public boolean isInAlphabet(byte octet) {
        if (octet >= 0) {
            byte[] bArr = this.decodeTable;
            return octet < bArr.length && bArr[octet] != -1;
        }
    }
}
