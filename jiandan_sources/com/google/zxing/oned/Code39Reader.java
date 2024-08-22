package com.google.zxing.oned;

import androidx.core.location.GpsStatusWrapper;
import androidx.renderscript.ScriptIntrinsicBLAS;
import com.baidu.apollon.a;
import com.baidu.sapi2.activity.BindVerifyActivity;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.google.common.base.Ascii;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import com.google.zxing.maxicode.decoder.DecodedBitStreamParser;
import java.util.Arrays;
import java.util.Map;

public final class Code39Reader extends OneDReader {
    public static final String ALPHABET_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%";
    public static final int ASTERISK_ENCODING = 148;
    public static final int[] CHARACTER_ENCODINGS = {52, 289, 97, 352, 49, BindVerifyActivity.E, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, PayBeanFactory.BEAN_ID_MODIFY_MOBILE_PWD, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, GpsStatusWrapper.QZSS_SVID_MIN, 448, 145, 400, 208, ScriptIntrinsicBLAS.RsBlas_zsyrk, 388, 196, a.e, 162, ScriptIntrinsicBLAS.RsBlas_cherk, 42};
    public final int[] counters;
    public final StringBuilder decodeRowResult;
    public final boolean extendedMode;
    public final boolean usingCheckDigit;

    public Code39Reader() {
        this(false);
    }

    public static String decodeExtended(CharSequence charSequence) throws FormatException {
        char c;
        int i2;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i3 = 0;
        while (i3 < length) {
            char charAt = charSequence.charAt(i3);
            if (charAt == '+' || charAt == '$' || charAt == '%' || charAt == '/') {
                i3++;
                char charAt2 = charSequence.charAt(i3);
                if (charAt != '$') {
                    if (charAt != '%') {
                        if (charAt != '+') {
                            if (charAt == '/') {
                                if (charAt2 >= 'A' && charAt2 <= 'O') {
                                    i2 = charAt2 - ' ';
                                } else if (charAt2 == 'Z') {
                                    c = ':';
                                    sb.append(c);
                                } else {
                                    throw FormatException.getFormatInstance();
                                }
                            }
                        } else if (charAt2 < 'A' || charAt2 > 'Z') {
                            throw FormatException.getFormatInstance();
                        } else {
                            i2 = charAt2 + Ascii.CASE_MASK;
                        }
                    } else if (charAt2 >= 'A' && charAt2 <= 'E') {
                        i2 = charAt2 - '&';
                    } else if (charAt2 >= 'F' && charAt2 <= 'J') {
                        i2 = charAt2 + DecodedBitStreamParser.TWOSHIFTA;
                    } else if (charAt2 >= 'K' && charAt2 <= 'O') {
                        i2 = charAt2 + 16;
                    } else if (charAt2 >= 'P' && charAt2 <= 'T') {
                        i2 = charAt2 + '+';
                    } else if (charAt2 != 'U') {
                        if (charAt2 == 'V') {
                            c = '@';
                        } else if (charAt2 == 'W') {
                            c = '`';
                        } else if (charAt2 == 'X' || charAt2 == 'Y' || charAt2 == 'Z') {
                            c = Ascii.MAX;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                        sb.append(c);
                    }
                    c = 0;
                    sb.append(c);
                } else if (charAt2 < 'A' || charAt2 > 'Z') {
                    throw FormatException.getFormatInstance();
                } else {
                    i2 = charAt2 - '@';
                }
                c = (char) i2;
                sb.append(c);
            } else {
                sb.append(charAt);
            }
            i3++;
        }
        return sb.toString();
    }

    public static int[] findAsteriskPattern(BitArray bitArray, int[] iArr) throws NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        int length = iArr.length;
        int i2 = nextSet;
        boolean z = false;
        int i3 = 0;
        while (nextSet < size) {
            if (bitArray.get(nextSet) != z) {
                iArr[i3] = iArr[i3] + 1;
            } else {
                if (i3 != length - 1) {
                    i3++;
                } else if (toNarrowWidePattern(iArr) != 148 || !bitArray.isRange(Math.max(0, i2 - ((nextSet - i2) / 2)), i2, false)) {
                    i2 += iArr[0] + iArr[1];
                    int i4 = i3 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i4);
                    iArr[i4] = 0;
                    iArr[i3] = 0;
                    i3--;
                } else {
                    return new int[]{i2, nextSet};
                }
                iArr[i3] = 1;
                z = !z;
            }
            nextSet++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static char patternToChar(int i2) throws NotFoundException {
        int i3 = 0;
        while (true) {
            int[] iArr = CHARACTER_ENCODINGS;
            if (i3 < iArr.length) {
                if (iArr[i3] == i2) {
                    return ALPHABET_STRING.charAt(i3);
                }
                i3++;
            } else if (i2 == 148) {
                return '*';
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }

    public static int toNarrowWidePattern(int[] iArr) {
        int length = iArr.length;
        int i2 = 0;
        while (true) {
            int i3 = Integer.MAX_VALUE;
            for (int i4 : iArr) {
                if (i4 < i3 && i4 > i2) {
                    i3 = i4;
                }
            }
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < length; i8++) {
                int i9 = iArr[i8];
                if (i9 > i3) {
                    i6 |= 1 << ((length - 1) - i8);
                    i5++;
                    i7 += i9;
                }
            }
            if (i5 == 3) {
                for (int i10 = 0; i10 < length && i5 > 0; i10++) {
                    int i11 = iArr[i10];
                    if (i11 > i3) {
                        i5--;
                        if ((i11 << 1) >= i7) {
                            return -1;
                        }
                    }
                }
                return i6;
            } else if (i5 <= 3) {
                return -1;
            } else {
                i2 = i3;
            }
        }
    }

    public Result decodeRow(int i2, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        String str;
        int[] iArr = this.counters;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.decodeRowResult;
        sb.setLength(0);
        int[] findAsteriskPattern = findAsteriskPattern(bitArray, iArr);
        int nextSet = bitArray.getNextSet(findAsteriskPattern[1]);
        int size = bitArray.getSize();
        while (true) {
            OneDReader.recordPattern(bitArray, nextSet, iArr);
            int narrowWidePattern = toNarrowWidePattern(iArr);
            if (narrowWidePattern >= 0) {
                char patternToChar = patternToChar(narrowWidePattern);
                sb.append(patternToChar);
                int i3 = nextSet;
                for (int i4 : iArr) {
                    i3 += i4;
                }
                int nextSet2 = bitArray.getNextSet(i3);
                if (patternToChar == '*') {
                    sb.setLength(sb.length() - 1);
                    int i5 = 0;
                    for (int i6 : iArr) {
                        i5 += i6;
                    }
                    int i7 = (nextSet2 - nextSet) - i5;
                    if (nextSet2 == size || (i7 << 1) >= i5) {
                        if (this.usingCheckDigit) {
                            int length = sb.length() - 1;
                            int i8 = 0;
                            for (int i9 = 0; i9 < length; i9++) {
                                i8 += ALPHABET_STRING.indexOf(this.decodeRowResult.charAt(i9));
                            }
                            if (sb.charAt(length) == ALPHABET_STRING.charAt(i8 % 43)) {
                                sb.setLength(length);
                            } else {
                                throw ChecksumException.getChecksumInstance();
                            }
                        }
                        if (sb.length() != 0) {
                            if (this.extendedMode) {
                                str = decodeExtended(sb);
                            } else {
                                str = sb.toString();
                            }
                            float f = (float) i2;
                            return new Result(str, (byte[]) null, new ResultPoint[]{new ResultPoint(((float) (findAsteriskPattern[1] + findAsteriskPattern[0])) / 2.0f, f), new ResultPoint(((float) nextSet) + (((float) i5) / 2.0f), f)}, BarcodeFormat.CODE_39);
                        }
                        throw NotFoundException.getNotFoundInstance();
                    }
                    throw NotFoundException.getNotFoundInstance();
                }
                nextSet = nextSet2;
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }

    public Code39Reader(boolean z) {
        this(z, false);
    }

    public Code39Reader(boolean z, boolean z2) {
        this.usingCheckDigit = z;
        this.extendedMode = z2;
        this.decodeRowResult = new StringBuilder(20);
        this.counters = new int[9];
    }
}
