package com.google.zxing.oned;

import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Map;

public final class Code128Writer extends OneDimensionalCodeWriter {
    public static final int CODE_CODE_A = 101;
    public static final int CODE_CODE_B = 100;
    public static final int CODE_CODE_C = 99;
    public static final int CODE_FNC_1 = 102;
    public static final int CODE_FNC_2 = 97;
    public static final int CODE_FNC_3 = 96;
    public static final int CODE_FNC_4_A = 101;
    public static final int CODE_FNC_4_B = 100;
    public static final int CODE_START_A = 103;
    public static final int CODE_START_B = 104;
    public static final int CODE_START_C = 105;
    public static final int CODE_STOP = 106;
    public static final char ESCAPE_FNC_1 = 'ñ';
    public static final char ESCAPE_FNC_2 = 'ò';
    public static final char ESCAPE_FNC_3 = 'ó';
    public static final char ESCAPE_FNC_4 = 'ô';

    public enum CType {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    public static int chooseCode(CharSequence charSequence, int i2, int i3) {
        CType findCType;
        CType findCType2;
        char charAt;
        CType findCType3 = findCType(charSequence, i2);
        if (findCType3 == CType.ONE_DIGIT) {
            return 100;
        }
        if (findCType3 == CType.UNCODABLE) {
            if (i2 >= charSequence.length() || ((charAt = charSequence.charAt(i2)) >= ' ' && (i3 != 101 || charAt >= '`'))) {
                return 100;
            }
            return 101;
        } else if (i3 == 99) {
            return 99;
        } else {
            if (i3 != 100) {
                if (findCType3 == CType.FNC_1) {
                    findCType3 = findCType(charSequence, i2 + 1);
                }
                if (findCType3 == CType.TWO_DIGITS) {
                    return 99;
                }
                return 100;
            } else if (findCType3 == CType.FNC_1 || (findCType = findCType(charSequence, i2 + 2)) == CType.UNCODABLE || findCType == CType.ONE_DIGIT) {
                return 100;
            } else {
                if (findCType != CType.FNC_1) {
                    int i4 = i2 + 4;
                    while (true) {
                        findCType2 = findCType(charSequence, i4);
                        if (findCType2 != CType.TWO_DIGITS) {
                            break;
                        }
                        i4 += 2;
                    }
                    if (findCType2 == CType.ONE_DIGIT) {
                        return 100;
                    }
                    return 99;
                } else if (findCType(charSequence, i2 + 3) == CType.TWO_DIGITS) {
                    return 99;
                } else {
                    return 100;
                }
            }
        }
    }

    public static CType findCType(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        if (i2 >= length) {
            return CType.UNCODABLE;
        }
        char charAt = charSequence.charAt(i2);
        if (charAt == 241) {
            return CType.FNC_1;
        }
        if (charAt < '0' || charAt > '9') {
            return CType.UNCODABLE;
        }
        int i3 = i2 + 1;
        if (i3 >= length) {
            return CType.ONE_DIGIT;
        }
        char charAt2 = charSequence.charAt(i3);
        if (charAt2 < '0' || charAt2 > '9') {
            return CType.ONE_DIGIT;
        }
        return CType.TWO_DIGITS;
    }

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_128) {
            return super.encode(str, barcodeFormat, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got ".concat(String.valueOf(barcodeFormat)));
    }

    public boolean[] encode(String str) {
        int length = str.length();
        if (length <= 0 || length > 80) {
            throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got ".concat(String.valueOf(length)));
        }
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            switch (charAt) {
                case 241:
                case 242:
                case LightappBusinessClient.REQUEST_PERMISSION_SELECT_PHONE_FROM_ADDRESSBOOK:
                case LightappBusinessClient.REQUEST_PERMISSION_RECORDAUDIO:
                    break;
                default:
                    if (charAt <= 127) {
                        break;
                    } else {
                        throw new IllegalArgumentException("Bad character in input: ".concat(String.valueOf(charAt)));
                    }
            }
        }
        ArrayList<int[]> arrayList = new ArrayList<>();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 1;
        while (true) {
            int i8 = 103;
            if (i4 < length) {
                int chooseCode = chooseCode(str, i4, i6);
                int i9 = 100;
                if (chooseCode == i6) {
                    switch (str.charAt(i4)) {
                        case 241:
                            i9 = 102;
                            break;
                        case 242:
                            i9 = 97;
                            break;
                        case LightappBusinessClient.REQUEST_PERMISSION_SELECT_PHONE_FROM_ADDRESSBOOK:
                            i9 = 96;
                            break;
                        case LightappBusinessClient.REQUEST_PERMISSION_RECORDAUDIO:
                            if (i6 == 101) {
                                i9 = 101;
                                break;
                            }
                            break;
                        default:
                            if (i6 != 100) {
                                if (i6 == 101) {
                                    i9 = str.charAt(i4) - ' ';
                                    if (i9 < 0) {
                                        i9 += 96;
                                        break;
                                    }
                                } else {
                                    i9 = Integer.parseInt(str.substring(i4, i4 + 2));
                                    i4++;
                                    break;
                                }
                            } else {
                                i9 = str.charAt(i4) - ' ';
                                break;
                            }
                            break;
                    }
                    i4++;
                } else {
                    if (i6 != 0) {
                        i8 = chooseCode;
                    } else if (chooseCode == 100) {
                        i8 = 104;
                    } else if (chooseCode != 101) {
                        i8 = 105;
                    }
                    i9 = i8;
                    i6 = chooseCode;
                }
                arrayList.add(Code128Reader.CODE_PATTERNS[i9]);
                i5 += i9 * i7;
                if (i4 != 0) {
                    i7++;
                }
            } else {
                arrayList.add(Code128Reader.CODE_PATTERNS[i5 % 103]);
                arrayList.add(Code128Reader.CODE_PATTERNS[106]);
                int i10 = 0;
                for (int[] iArr : arrayList) {
                    for (int i11 : (int[]) r13.next()) {
                        i10 += i11;
                    }
                }
                boolean[] zArr = new boolean[i10];
                for (int[] appendPattern : arrayList) {
                    i2 += OneDimensionalCodeWriter.appendPattern(zArr, i2, appendPattern, true);
                }
                return zArr;
            }
        }
    }
}
