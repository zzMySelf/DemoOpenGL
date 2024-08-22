package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.pdf417.PDF417ResultMetadata;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public final class DecodedBitStreamParser {
    public static final int AL = 28;
    public static final int AS = 27;
    public static final int BEGIN_MACRO_PDF417_CONTROL_BLOCK = 928;
    public static final int BEGIN_MACRO_PDF417_OPTIONAL_FIELD = 923;
    public static final int BYTE_COMPACTION_MODE_LATCH = 901;
    public static final int BYTE_COMPACTION_MODE_LATCH_6 = 924;
    public static final int ECI_CHARSET = 927;
    public static final int ECI_GENERAL_PURPOSE = 926;
    public static final int ECI_USER_DEFINED = 925;
    public static final BigInteger[] EXP900;
    public static final int LL = 27;
    public static final int MACRO_PDF417_OPTIONAL_FIELD_ADDRESSEE = 4;
    public static final int MACRO_PDF417_OPTIONAL_FIELD_CHECKSUM = 6;
    public static final int MACRO_PDF417_OPTIONAL_FIELD_FILE_NAME = 0;
    public static final int MACRO_PDF417_OPTIONAL_FIELD_FILE_SIZE = 5;
    public static final int MACRO_PDF417_OPTIONAL_FIELD_SEGMENT_COUNT = 1;
    public static final int MACRO_PDF417_OPTIONAL_FIELD_SENDER = 3;
    public static final int MACRO_PDF417_OPTIONAL_FIELD_TIME_STAMP = 2;
    public static final int MACRO_PDF417_TERMINATOR = 922;
    public static final int MAX_NUMERIC_CODEWORDS = 15;
    public static final char[] MIXED_CHARS = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
    public static final int ML = 28;
    public static final int MODE_SHIFT_TO_BYTE_COMPACTION_MODE = 913;
    public static final int NUMBER_OF_SEQUENCE_CODEWORDS = 2;
    public static final int NUMERIC_COMPACTION_MODE_LATCH = 902;
    public static final int PAL = 29;
    public static final int PL = 25;
    public static final int PS = 29;
    public static final char[] PUNCT_CHARS = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
    public static final int TEXT_COMPACTION_MODE_LATCH = 900;

    /* renamed from: com.google.zxing.pdf417.decoder.DecodedBitStreamParser$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode[] r0 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode = r0
                com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.LOWER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.MIXED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA_SHIFT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.AnonymousClass1.<clinit>():void");
        }
    }

    public enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        EXP900 = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900);
        EXP900[1] = valueOf;
        int i2 = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = EXP900;
            if (i2 < bigIntegerArr2.length) {
                bigIntegerArr2[i2] = bigIntegerArr2[i2 - 1].multiply(valueOf);
                i2++;
            } else {
                return;
            }
        }
    }

    public static int byteCompaction(int i2, int[] iArr, Charset charset, int i3, StringBuilder sb) {
        int i4;
        int i5;
        long j;
        int i6;
        int i7;
        int i8 = i2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        long j2 = 900;
        int i9 = 6;
        if (i8 == 901) {
            int[] iArr2 = new int[6];
            int i10 = i3 + 1;
            int i11 = iArr[i3];
            boolean z = false;
            while (true) {
                i7 = 0;
                long j3 = 0;
                while (i6 < iArr[0] && !z) {
                    int i12 = i7 + 1;
                    iArr2[i7] = i5;
                    j3 = (j3 * j) + ((long) i5);
                    int i13 = i6 + 1;
                    i11 = iArr[i6];
                    if (i11 != 928) {
                        switch (i11) {
                            case 900:
                            case 901:
                            case 902:
                                break;
                            default:
                                switch (i11) {
                                    case MACRO_PDF417_TERMINATOR /*922*/:
                                    case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /*923*/:
                                    case 924:
                                        break;
                                    default:
                                        if (i12 % 5 != 0 || i12 <= 0) {
                                            i5 = i11;
                                            i6 = i13;
                                            i7 = i12;
                                            j = 900;
                                            i9 = 6;
                                            break;
                                        } else {
                                            int i14 = 0;
                                            while (i14 < i9) {
                                                byteArrayOutputStream.write((byte) ((int) (j3 >> ((5 - i14) * 8))));
                                                i14++;
                                                i11 = i11;
                                                i9 = 6;
                                            }
                                            int i15 = i11;
                                            i10 = i13;
                                            j2 = 900;
                                        }
                                }
                                break;
                        }
                    }
                    i6 = i13 - 1;
                    i5 = i11;
                    i7 = i12;
                    j = 900;
                    i9 = 6;
                    z = true;
                }
            }
            if (i6 == iArr[0] && i5 < 900) {
                iArr2[i7] = i5;
                i7++;
            }
            for (int i16 = 0; i16 < i7; i16++) {
                byteArrayOutputStream.write((byte) iArr2[i16]);
            }
            i4 = i6;
        } else if (i8 != 924) {
            i4 = i3;
        } else {
            i4 = i3;
            boolean z2 = false;
            while (true) {
                int i17 = 0;
                long j4 = 0;
                while (i4 < iArr[0] && !z2) {
                    int i18 = i4 + 1;
                    int i19 = iArr[i4];
                    if (i19 < 900) {
                        i17++;
                        j4 = (j4 * 900) + ((long) i19);
                    } else {
                        if (i19 != 928) {
                            switch (i19) {
                                case 900:
                                case 901:
                                case 902:
                                    break;
                                default:
                                    switch (i19) {
                                        case MACRO_PDF417_TERMINATOR /*922*/:
                                        case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /*923*/:
                                        case 924:
                                            break;
                                    }
                            }
                        }
                        i4 = i18 - 1;
                        z2 = true;
                        if (i17 % 5 != 0 && i17 > 0) {
                            for (int i20 = 0; i20 < 6; i20++) {
                                byteArrayOutputStream.write((byte) ((int) (j4 >> ((5 - i20) * 8))));
                            }
                        }
                    }
                    i4 = i18;
                    if (i17 % 5 != 0) {
                    }
                }
            }
        }
        sb.append(new String(byteArrayOutputStream.toByteArray(), charset));
        return i4;
    }

    public static DecoderResult decode(int[] iArr, String str) throws FormatException {
        int i2;
        StringBuilder sb = new StringBuilder(iArr.length << 1);
        Charset charset = StandardCharsets.ISO_8859_1;
        int i3 = iArr[1];
        PDF417ResultMetadata pDF417ResultMetadata = new PDF417ResultMetadata();
        int i4 = 2;
        while (i4 < iArr[0]) {
            if (i3 != 913) {
                switch (i3) {
                    case 900:
                        i2 = textCompaction(iArr, i4, sb);
                        break;
                    case 901:
                        i2 = byteCompaction(i3, iArr, charset, i4, sb);
                        break;
                    case 902:
                        i2 = numericCompaction(iArr, i4, sb);
                        break;
                    default:
                        switch (i3) {
                            case MACRO_PDF417_TERMINATOR /*922*/:
                            case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /*923*/:
                                throw FormatException.getFormatInstance();
                            case 924:
                                break;
                            case 925:
                                i2 = i4 + 1;
                                break;
                            case 926:
                                i2 = i4 + 2;
                                break;
                            case 927:
                                i2 = i4 + 1;
                                charset = Charset.forName(CharacterSetECI.getCharacterSetECIByValue(iArr[i4]).name());
                                break;
                            case 928:
                                i2 = decodeMacroBlock(iArr, i4, pDF417ResultMetadata);
                                break;
                            default:
                                i2 = textCompaction(iArr, i4 - 1, sb);
                                break;
                        }
                        i2 = byteCompaction(i3, iArr, charset, i4, sb);
                        break;
                }
            } else {
                i2 = i4 + 1;
                sb.append((char) iArr[i4]);
            }
            if (i2 < iArr.length) {
                i4 = i2 + 1;
                i3 = iArr[i2];
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (sb.length() != 0) {
            DecoderResult decoderResult = new DecoderResult((byte[]) null, sb.toString(), (List<byte[]>) null, str);
            decoderResult.setOther(pDF417ResultMetadata);
            return decoderResult;
        }
        throw FormatException.getFormatInstance();
    }

    public static String decodeBase900toBase10(int[] iArr, int i2) throws FormatException {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i3 = 0; i3 < i2; i3++) {
            bigInteger = bigInteger.add(EXP900[(i2 - i3) - 1].multiply(BigInteger.valueOf((long) iArr[i3])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw FormatException.getFormatInstance();
    }

    public static int decodeMacroBlock(int[] iArr, int i2, PDF417ResultMetadata pDF417ResultMetadata) throws FormatException {
        if (i2 + 2 <= iArr[0]) {
            int[] iArr2 = new int[2];
            int i3 = 0;
            while (i3 < 2) {
                iArr2[i3] = iArr[i2];
                i3++;
                i2++;
            }
            pDF417ResultMetadata.setSegmentIndex(Integer.parseInt(decodeBase900toBase10(iArr2, 2)));
            StringBuilder sb = new StringBuilder();
            int textCompaction = textCompaction(iArr, i2, sb);
            pDF417ResultMetadata.setFileId(sb.toString());
            int i4 = iArr[textCompaction] == 923 ? textCompaction + 1 : -1;
            while (textCompaction < iArr[0]) {
                int i5 = iArr[textCompaction];
                if (i5 == 922) {
                    textCompaction++;
                    pDF417ResultMetadata.setLastSegment(true);
                } else if (i5 == 923) {
                    int i6 = textCompaction + 1;
                    switch (iArr[i6]) {
                        case 0:
                            StringBuilder sb2 = new StringBuilder();
                            textCompaction = textCompaction(iArr, i6 + 1, sb2);
                            pDF417ResultMetadata.setFileName(sb2.toString());
                            break;
                        case 1:
                            StringBuilder sb3 = new StringBuilder();
                            textCompaction = numericCompaction(iArr, i6 + 1, sb3);
                            pDF417ResultMetadata.setSegmentCount(Integer.parseInt(sb3.toString()));
                            break;
                        case 2:
                            StringBuilder sb4 = new StringBuilder();
                            textCompaction = numericCompaction(iArr, i6 + 1, sb4);
                            pDF417ResultMetadata.setTimestamp(Long.parseLong(sb4.toString()));
                            break;
                        case 3:
                            StringBuilder sb5 = new StringBuilder();
                            textCompaction = textCompaction(iArr, i6 + 1, sb5);
                            pDF417ResultMetadata.setSender(sb5.toString());
                            break;
                        case 4:
                            StringBuilder sb6 = new StringBuilder();
                            textCompaction = textCompaction(iArr, i6 + 1, sb6);
                            pDF417ResultMetadata.setAddressee(sb6.toString());
                            break;
                        case 5:
                            StringBuilder sb7 = new StringBuilder();
                            textCompaction = numericCompaction(iArr, i6 + 1, sb7);
                            pDF417ResultMetadata.setFileSize(Long.parseLong(sb7.toString()));
                            break;
                        case 6:
                            StringBuilder sb8 = new StringBuilder();
                            textCompaction = numericCompaction(iArr, i6 + 1, sb8);
                            pDF417ResultMetadata.setChecksum(Integer.parseInt(sb8.toString()));
                            break;
                        default:
                            throw FormatException.getFormatInstance();
                    }
                } else {
                    throw FormatException.getFormatInstance();
                }
            }
            if (i4 != -1) {
                int i7 = textCompaction - i4;
                if (pDF417ResultMetadata.isLastSegment()) {
                    i7--;
                }
                pDF417ResultMetadata.setOptionalData(Arrays.copyOfRange(iArr, i4, i7 + i4));
            }
            return textCompaction;
        }
        throw FormatException.getFormatInstance();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0034, code lost:
        r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
        r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00bf, code lost:
        r6 = (char) r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00cb, code lost:
        r6 = 0;
        r11 = r2;
        r2 = r0;
        r0 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00e0, code lost:
        if (r6 == 0) goto L_0x00e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00e2, code lost:
        r15.append(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00e5, code lost:
        r3 = r3 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void decodeTextCompaction(int[] r12, int[] r13, int r14, java.lang.StringBuilder r15) {
        /*
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            r1 = 0
            r2 = r0
            r3 = 0
        L_0x0005:
            if (r3 >= r14) goto L_0x00e9
            r4 = r12[r3]
            int[] r5 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.AnonymousClass1.$SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode
            int r6 = r0.ordinal()
            r5 = r5[r6]
            r6 = 32
            r7 = 29
            r8 = 26
            r9 = 913(0x391, float:1.28E-42)
            r10 = 900(0x384, float:1.261E-42)
            switch(r5) {
                case 1: goto L_0x00bb;
                case 2: goto L_0x009b;
                case 3: goto L_0x0070;
                case 4: goto L_0x0050;
                case 5: goto L_0x003f;
                case 6: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x00df
        L_0x0020:
            if (r4 >= r7) goto L_0x0027
            char[] r0 = PUNCT_CHARS
            char r6 = r0[r4]
            goto L_0x0044
        L_0x0027:
            if (r4 == r7) goto L_0x003b
            if (r4 == r10) goto L_0x0037
            if (r4 == r9) goto L_0x002e
            goto L_0x0034
        L_0x002e:
            r0 = r13[r3]
            char r0 = (char) r0
            r15.append(r0)
        L_0x0034:
            r0 = r2
            goto L_0x00df
        L_0x0037:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00df
        L_0x003b:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00df
        L_0x003f:
            if (r4 >= r8) goto L_0x0047
            int r4 = r4 + 65
            char r6 = (char) r4
        L_0x0044:
            r0 = r2
            goto L_0x00e0
        L_0x0047:
            if (r4 == r8) goto L_0x0044
            if (r4 == r10) goto L_0x004c
            goto L_0x0034
        L_0x004c:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00df
        L_0x0050:
            if (r4 >= r7) goto L_0x0058
            char[] r5 = PUNCT_CHARS
            char r6 = r5[r4]
            goto L_0x00e0
        L_0x0058:
            if (r4 == r7) goto L_0x006c
            if (r4 == r10) goto L_0x0068
            if (r4 == r9) goto L_0x0060
            goto L_0x00df
        L_0x0060:
            r4 = r13[r3]
            char r4 = (char) r4
            r15.append(r4)
            goto L_0x00df
        L_0x0068:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00df
        L_0x006c:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00df
        L_0x0070:
            r5 = 25
            if (r4 >= r5) goto L_0x007a
            char[] r5 = MIXED_CHARS
            char r6 = r5[r4]
            goto L_0x00e0
        L_0x007a:
            if (r4 == r10) goto L_0x0098
            if (r4 == r9) goto L_0x0091
            switch(r4) {
                case 25: goto L_0x008e;
                case 26: goto L_0x00e0;
                case 27: goto L_0x008a;
                case 28: goto L_0x0086;
                case 29: goto L_0x0083;
                default: goto L_0x0081;
            }
        L_0x0081:
            goto L_0x00df
        L_0x0083:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r2 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT
            goto L_0x00cb
        L_0x0086:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00df
        L_0x008a:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.LOWER
            goto L_0x00df
        L_0x008e:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT
            goto L_0x00df
        L_0x0091:
            r4 = r13[r3]
            char r4 = (char) r4
            r15.append(r4)
            goto L_0x00df
        L_0x0098:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00df
        L_0x009b:
            if (r4 >= r8) goto L_0x00a0
            int r4 = r4 + 97
            goto L_0x00bf
        L_0x00a0:
            if (r4 == r10) goto L_0x00b8
            if (r4 == r9) goto L_0x00b1
            switch(r4) {
                case 26: goto L_0x00e0;
                case 27: goto L_0x00ae;
                case 28: goto L_0x00ab;
                case 29: goto L_0x00a8;
                default: goto L_0x00a7;
            }
        L_0x00a7:
            goto L_0x00df
        L_0x00a8:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r2 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT
            goto L_0x00cb
        L_0x00ab:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.MIXED
            goto L_0x00df
        L_0x00ae:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r2 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA_SHIFT
            goto L_0x00cb
        L_0x00b1:
            r4 = r13[r3]
            char r4 = (char) r4
            r15.append(r4)
            goto L_0x00df
        L_0x00b8:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00df
        L_0x00bb:
            if (r4 >= r8) goto L_0x00c1
            int r4 = r4 + 65
        L_0x00bf:
            char r6 = (char) r4
            goto L_0x00e0
        L_0x00c1:
            if (r4 == r10) goto L_0x00dd
            if (r4 == r9) goto L_0x00d6
            switch(r4) {
                case 26: goto L_0x00e0;
                case 27: goto L_0x00d3;
                case 28: goto L_0x00d0;
                case 29: goto L_0x00c9;
                default: goto L_0x00c8;
            }
        L_0x00c8:
            goto L_0x00df
        L_0x00c9:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r2 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT
        L_0x00cb:
            r6 = 0
            r11 = r2
            r2 = r0
            r0 = r11
            goto L_0x00e0
        L_0x00d0:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.MIXED
            goto L_0x00df
        L_0x00d3:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.LOWER
            goto L_0x00df
        L_0x00d6:
            r4 = r13[r3]
            char r4 = (char) r4
            r15.append(r4)
            goto L_0x00df
        L_0x00dd:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
        L_0x00df:
            r6 = 0
        L_0x00e0:
            if (r6 == 0) goto L_0x00e5
            r15.append(r6)
        L_0x00e5:
            int r3 = r3 + 1
            goto L_0x0005
        L_0x00e9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.decodeTextCompaction(int[], int[], int, java.lang.StringBuilder):void");
    }

    public static int numericCompaction(int[] iArr, int i2, StringBuilder sb) throws FormatException {
        int[] iArr2 = new int[15];
        boolean z = false;
        int i3 = 0;
        while (i2 < iArr[0] && !z) {
            int i4 = i2 + 1;
            int i5 = iArr[i2];
            if (i4 == iArr[0]) {
                z = true;
            }
            if (i5 < 900) {
                iArr2[i3] = i5;
                i3++;
            } else {
                if (!(i5 == 900 || i5 == 901 || i5 == 928)) {
                    switch (i5) {
                        case MACRO_PDF417_TERMINATOR /*922*/:
                        case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /*923*/:
                        case 924:
                            break;
                    }
                }
                i4--;
                z = true;
            }
            if ((i3 % 15 == 0 || i5 == 902 || z) && i3 > 0) {
                sb.append(decodeBase900toBase10(iArr2, i3));
                i3 = 0;
            }
            i2 = i4;
        }
        return i2;
    }

    public static int textCompaction(int[] iArr, int i2, StringBuilder sb) {
        int[] iArr2 = new int[((iArr[0] - i2) << 1)];
        int[] iArr3 = new int[((iArr[0] - i2) << 1)];
        boolean z = false;
        int i3 = 0;
        while (i2 < iArr[0] && !z) {
            int i4 = i2 + 1;
            int i5 = iArr[i2];
            if (i5 < 900) {
                iArr2[i3] = i5 / 30;
                iArr2[i3 + 1] = i5 % 30;
                i3 += 2;
            } else if (i5 != 913) {
                if (i5 != 928) {
                    switch (i5) {
                        case 900:
                            iArr2[i3] = 900;
                            i3++;
                            break;
                        case 901:
                        case 902:
                            break;
                        default:
                            switch (i5) {
                                case MACRO_PDF417_TERMINATOR /*922*/:
                                case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /*923*/:
                                case 924:
                                    break;
                            }
                    }
                }
                i2 = i4 - 1;
                z = true;
            } else {
                iArr2[i3] = 913;
                i2 = i4 + 1;
                iArr3[i3] = iArr[i4];
                i3++;
            }
            i2 = i4;
        }
        decodeTextCompaction(iArr2, iArr3, i3, sb);
        return i2;
    }
}
