package fe.when.ad.f;

import androidx.exifinterface.media.ExifInterface;
import com.alipay.sdk.m.n.a;
import com.google.common.base.Ascii;
import com.google.common.xml.XmlEscapers;
import com.google.zxing.datamatrix.encoder.HighLevelEncoder;
import com.google.zxing.maxicode.decoder.DecodedBitStreamParser;
import com.google.zxing.oned.Code128Writer;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.pdf.ExtraEncoding;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import kotlin.text.Typography;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class a0 {

    /* renamed from: ad  reason: collision with root package name */
    public static final char[] f9341ad = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, CharUtils.CR, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, DecodedBitStreamParser.FS, DecodedBitStreamParser.GS, DecodedBitStreamParser.RS, XmlEscapers.MAX_ASCII_CONTROL_CHAR, Ascii.CASE_MASK, '!', '\"', '#', '$', '%', Typography.amp, ExtendedMessageFormat.QUOTE, '(', ')', '*', '+', ',', '-', '.', '/', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ':', ';', Typography.less, a.h, Typography.greater, '?', '@', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '[', '\\', ']', '^', '_', '`', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ExtendedMessageFormat.START_FE, '|', ExtendedMessageFormat.END_FE, '~', Ascii.MAX, Typography.bullet, Typography.dagger, Typography.doubleDagger, Typography.ellipsis, Typography.mdash, Typography.ndash, 402, 8260, 8249, 8250, 8722, 8240, Typography.lowDoubleQuote, Typography.leftDoubleQuote, Typography.rightDoubleQuote, Typography.leftSingleQuote, Typography.rightSingleQuote, Typography.lowSingleQuote, Typography.tm, 64257, 64258, 321, 338, 352, 376, 381, 305, 322, 339, 353, 382, 65533, Typography.euro, 161, Typography.cent, Typography.pound, 164, 165, 166, Typography.section, 168, Typography.copyright, 170, 171, 172, 173, Typography.registered, 175, Typography.degree, Typography.plusMinus, 178, 179, 180, 181, Typography.paragraph, Typography.middleDot, 184, 185, 186, 187, 188, Typography.half, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, Typography.times, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, HighLevelEncoder.LATCH_TO_C40, HighLevelEncoder.LATCH_TO_BASE256, 232, 233, 234, HighLevelEncoder.UPPER_SHIFT, HighLevelEncoder.MACRO_05, HighLevelEncoder.MACRO_06, HighLevelEncoder.LATCH_TO_ANSIX12, HighLevelEncoder.LATCH_TO_TEXT, HighLevelEncoder.LATCH_TO_EDIFACT, Code128Writer.ESCAPE_FNC_1, Code128Writer.ESCAPE_FNC_2, Code128Writer.ESCAPE_FNC_3, Code128Writer.ESCAPE_FNC_4, 245, 246, 247, 248, 249, 250, 251, 252, 253, 254, 255};

    /* renamed from: de  reason: collision with root package name */
    public static final aaa f9342de = new aaa();

    /* renamed from: fe  reason: collision with root package name */
    public static final aaa f9343fe = new aaa();
    public static final char[] qw = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, CharUtils.CR, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, DecodedBitStreamParser.FS, DecodedBitStreamParser.GS, DecodedBitStreamParser.RS, XmlEscapers.MAX_ASCII_CONTROL_CHAR, Ascii.CASE_MASK, '!', '\"', '#', '$', '%', Typography.amp, ExtendedMessageFormat.QUOTE, '(', ')', '*', '+', ',', '-', '.', '/', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ':', ';', Typography.less, a.h, Typography.greater, '?', '@', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '[', '\\', ']', '^', '_', '`', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ExtendedMessageFormat.START_FE, '|', ExtendedMessageFormat.END_FE, '~', Ascii.MAX, Typography.euro, 65533, Typography.lowSingleQuote, 402, Typography.lowDoubleQuote, Typography.ellipsis, Typography.dagger, Typography.doubleDagger, 710, 8240, 352, 8249, 338, 65533, 381, 65533, 65533, Typography.leftSingleQuote, Typography.rightSingleQuote, Typography.leftDoubleQuote, Typography.rightDoubleQuote, Typography.bullet, Typography.ndash, Typography.mdash, 732, Typography.tm, 353, 8250, 339, 65533, 382, 376, Typography.nbsp, 161, Typography.cent, Typography.pound, 164, 165, 166, Typography.section, 168, Typography.copyright, 170, 171, 172, 173, Typography.registered, 175, Typography.degree, Typography.plusMinus, 178, 179, 180, 181, Typography.paragraph, Typography.middleDot, 184, 185, 186, 187, 188, Typography.half, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, Typography.times, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, HighLevelEncoder.LATCH_TO_C40, HighLevelEncoder.LATCH_TO_BASE256, 232, 233, 234, HighLevelEncoder.UPPER_SHIFT, HighLevelEncoder.MACRO_05, HighLevelEncoder.MACRO_06, HighLevelEncoder.LATCH_TO_ANSIX12, HighLevelEncoder.LATCH_TO_TEXT, HighLevelEncoder.LATCH_TO_EDIFACT, Code128Writer.ESCAPE_FNC_1, Code128Writer.ESCAPE_FNC_2, Code128Writer.ESCAPE_FNC_3, Code128Writer.ESCAPE_FNC_4, 245, 246, 247, 248, 249, 250, 251, 252, 253, 254, 255};

    /* renamed from: rg  reason: collision with root package name */
    public static HashMap<String, ExtraEncoding> f9344rg = new HashMap<>();

    public static class ad implements ExtraEncoding {

        /* renamed from: ad  reason: collision with root package name */
        public static final char[] f9345ad = {199, 252, 233, 226, 228, 224, 229, HighLevelEncoder.LATCH_TO_BASE256, 234, HighLevelEncoder.UPPER_SHIFT, 232, HighLevelEncoder.LATCH_TO_TEXT, HighLevelEncoder.LATCH_TO_ANSIX12, HighLevelEncoder.MACRO_05, 196, 197, 201, HighLevelEncoder.LATCH_TO_C40, 198, Code128Writer.ESCAPE_FNC_4, 246, Code128Writer.ESCAPE_FNC_2, 251, 249, 255, 214, 220, Typography.cent, Typography.pound, 165, 8359, 402, 225, HighLevelEncoder.MACRO_06, Code128Writer.ESCAPE_FNC_3, 250, Code128Writer.ESCAPE_FNC_1, 209, 170, 186, 191, 8976, 172, Typography.half, 188, 161, 171, 187, 9617, 9618, 9619, 9474, 9508, 9569, 9570, 9558, 9557, 9571, 9553, 9559, 9565, 9564, 9563, 9488, 9492, 9524, 9516, 9500, 9472, 9532, 9566, 9567, 9562, 9556, 9577, 9574, 9568, 9552, 9580, 9575, 9576, 9572, 9573, 9561, 9560, 9554, 9555, 9579, 9578, 9496, 9484, 9608, 9604, 9612, 9616, 9600, 945, 223, 915, 960, 931, 963, 181, 964, 934, 920, 937, 948, 8734, 966, 949, 8745, 8801, Typography.plusMinus, Typography.greaterOrEqual, Typography.lessOrEqual, 8992, 8993, 247, Typography.almostEqual, Typography.degree, 8729, Typography.middleDot, 8730, 8319, 178, 9632, Typography.nbsp};
        public static aaa qw = new aaa();

        static {
            int i2 = 0;
            while (true) {
                char[] cArr = f9345ad;
                if (i2 < cArr.length) {
                    qw.rg(cArr[i2], i2 + 128);
                    i2++;
                } else {
                    return;
                }
            }
        }

        public ad() {
        }

        public String ad(byte[] bArr, String str) {
            int i2;
            char[] cArr = new char[r8];
            int i3 = 0;
            for (byte b : bArr) {
                byte b2 = b & 255;
                if (b2 >= 32) {
                    if (b2 < 128) {
                        i2 = i3 + 1;
                        cArr[i3] = (char) b2;
                    } else {
                        i2 = i3 + 1;
                        cArr[i3] = f9345ad[b2 - 128];
                    }
                    i3 = i2;
                }
            }
            return new String(cArr, 0, i3);
        }

        public byte[] de(String str, String str2) {
            int i2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            int i3 = 0;
            for (char c : charArray) {
                if (c < 128) {
                    i2 = i3 + 1;
                    bArr[i3] = (byte) c;
                } else {
                    byte de2 = (byte) qw.de(c);
                    if (de2 != 0) {
                        i2 = i3 + 1;
                        bArr[i3] = de2;
                    }
                }
                i3 = i2;
            }
            if (i3 == r0) {
                return bArr;
            }
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, 0, bArr2, 0, i3);
            return bArr2;
        }

        public byte[] qw(char c, String str) {
            if (c < 128) {
                return new byte[]{(byte) c};
            }
            byte de2 = (byte) qw.de(c);
            if (de2 == 0) {
                return new byte[0];
            }
            return new byte[]{de2};
        }
    }

    public static class de implements ExtraEncoding {

        /* renamed from: ad  reason: collision with root package name */
        public static final aaa f9346ad = new aaa();

        /* renamed from: de  reason: collision with root package name */
        public static final aaa f9347de = new aaa();

        /* renamed from: fe  reason: collision with root package name */
        public static final char[] f9348fe = {Ascii.CASE_MASK, '!', 8704, '#', 8707, '%', Typography.amp, 8715, '(', ')', '*', '+', ',', '-', '.', '/', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ':', ';', Typography.less, a.h, Typography.greater, '?', 8773, 913, 914, 935, 916, 917, 934, 915, 919, 921, 977, 922, 923, 924, 925, 927, 928, 920, 929, 931, 932, 933, 962, 937, 926, 936, 918, '[', 8756, ']', 8869, '_', 773, 945, 946, 967, 948, 949, 981, 947, 951, 953, 966, 954, 955, 956, 957, 959, 960, 952, 961, 963, 964, 965, 982, 969, 958, 968, 950, ExtendedMessageFormat.START_FE, '|', ExtendedMessageFormat.END_FE, '~', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, Typography.euro, 978, Typography.prime, Typography.lessOrEqual, 8260, 8734, 402, 9827, 9830, 9829, 9824, 8596, 8592, 8593, 8594, 8595, Typography.degree, Typography.plusMinus, Typography.doublePrime, Typography.greaterOrEqual, Typography.times, 8733, 8706, Typography.bullet, 247, Typography.notEqual, 8801, Typography.almostEqual, Typography.ellipsis, 9474, 9472, 8629, 8501, 8465, 8476, 8472, 8855, 8853, 8709, 8745, 8746, 8835, 8839, 8836, 8834, 8838, 8712, 8713, 8736, 8711, Typography.registered, Typography.copyright, Typography.tm, 8719, 8730, Typography.bullet, 172, 8743, 8744, 8660, 8656, 8657, 8658, 8659, 9674, 9001, 0, 0, 0, 8721, 9115, 9116, 9117, 9121, 9122, 9123, 9127, 9128, 9129, 9130, 0, 9002, 8747, 8992, 9134, 8993, 9118, 9119, 9120, 9124, 9125, 9126, 9131, 9132, 9133, 0};

        /* renamed from: rg  reason: collision with root package name */
        public static final char[] f9349rg = {Ascii.CASE_MASK, 9985, 9986, 9987, 9988, 9742, 9990, 9991, 9992, 9993, 9755, 9758, 9996, 9997, 9998, 9999, 10000, 10001, 10002, 10003, 10004, 10005, 10006, 10007, 10008, 10009, 10010, 10011, 10012, 10013, 10014, 10015, 10016, 10017, 10018, 10019, 10020, 10021, 10022, 10023, 9733, 10025, 10026, 10027, 10028, 10029, 10030, 10031, 10032, 10033, 10034, 10035, 10036, 10037, 10038, 10039, 10040, 10041, 10042, 10043, 10044, 10045, 10046, 10047, 10048, 10049, 10050, 10051, 10052, 10053, 10054, 10055, 10056, 10057, 10058, 10059, 9679, 10061, 9632, 10063, 10064, 10065, 10066, 9650, 9660, 9670, 10070, 9687, 10072, 10073, 10074, 10075, 10076, 10077, 10078, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10081, 10082, 10083, 10084, 10085, 10086, 10087, 9827, 9830, 9829, 9824, 9312, 9313, 9314, 9315, 9316, 9317, 9318, 9319, 9320, 9321, 10102, 10103, 10104, 10105, 10106, 10107, 10108, 10109, 10110, 10111, 10112, 10113, 10114, 10115, 10116, 10117, 10118, 10119, 10120, 10121, 10122, 10123, 10124, 10125, 10126, 10127, 10128, 10129, 10130, 10131, 10132, 8594, 8596, 8597, 10136, 10137, 10138, 10139, 10140, 10141, 10142, 10143, 10144, 10145, 10146, 10147, 10148, 10149, 10150, 10151, 10152, 10153, 10154, 10155, 10156, 10157, 10158, 10159, 0, 10161, 10162, 10163, 10164, 10165, 10166, 10167, 10168, 10169, 10170, 10171, 10172, 10173, 10174, 0};
        public aaa qw;

        static {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                char[] cArr = f9348fe;
                if (i3 >= cArr.length) {
                    break;
                }
                char c = cArr[i3];
                if (c != 0) {
                    f9346ad.rg(c, i3 + 32);
                }
                i3++;
            }
            while (true) {
                char[] cArr2 = f9349rg;
                if (i2 < cArr2.length) {
                    char c2 = cArr2[i2];
                    if (c2 != 0) {
                        f9347de.rg(c2, i2 + 32);
                    }
                    i2++;
                } else {
                    return;
                }
            }
        }

        public de(boolean z) {
            if (z) {
                this.qw = f9346ad;
            } else {
                this.qw = f9347de;
            }
        }

        public String ad(byte[] bArr, String str) {
            return null;
        }

        public byte[] de(String str, String str2) {
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            int i2 = 0;
            for (char de2 : charArray) {
                byte de3 = (byte) this.qw.de(de2);
                if (de3 != 0) {
                    bArr[i2] = de3;
                    i2++;
                }
            }
            if (i2 == r0) {
                return bArr;
            }
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, 0, bArr2, 0, i2);
            return bArr2;
        }

        public byte[] qw(char c, String str) {
            byte de2 = (byte) this.qw.de(c);
            if (de2 == 0) {
                return new byte[0];
            }
            return new byte[]{de2};
        }
    }

    public static class fe implements ExtraEncoding {
        public fe() {
        }

        public String ad(byte[] bArr, String str) {
            return null;
        }

        public byte[] de(String str, String str2) {
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            int i2 = 0;
            for (char c : charArray) {
                char c2 = 65280 & c;
                if (c2 == 0 || c2 == 61440) {
                    bArr[i2] = (byte) c;
                    i2++;
                }
            }
            if (i2 == r0) {
                return bArr;
            }
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, 0, bArr2, 0, i2);
            return bArr2;
        }

        public byte[] qw(char c, String str) {
            char c2 = 65280 & c;
            if (c2 != 0 && c2 != 61440) {
                return new byte[0];
            }
            return new byte[]{(byte) c};
        }
    }

    public static class rg implements ExtraEncoding {
        public static final byte[] qw = {0, 35, 34, 0, 0, 0, 41, 62, 81, ExifInterface.START_CODE, 0, 0, 65, 63, 0, 0, 0, 0, 0, -4, 0, 0, 0, -5, 0, 0, 0, 0, 0, 0, 86, 0, 88, 89, 0, 0, 0, 0, 0, 0, 0, 0, -75, 0, 0, 0, 0, 0, -74, 0, 0, 0, -83, -81, -84, 0, 0, 0, 0, 0, 0, 0, 0, 124, 123, 0, 0, 0, 84, 0, 0, 0, 0, 0, 0, 0, 0, -90, 0, 0, 0, 113, 114, 0, 0, 0, 117, 0, 0, 0, 0, 0, 0, 125, 126, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -116, -115, -114, -113, -112, -111, -110, -109, -108, -107, -127, -126, -125, -124, -123, -122, -121, -120, -119, -118, -116, -115, -114, -113, -112, -111, -110, -109, -108, -107, -24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -24, ExifInterface.MARKER_SOI, 0, 0, -60, ExifInterface.MARKER_SOF6, 0, 0, -16, 0, 0, 0, 0, 0, 0, 0, 0, 0, -36, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        public rg() {
        }

        public String ad(byte[] bArr, String str) {
            return null;
        }

        public byte[] de(String str, String str2) {
            byte b;
            int i2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            int i3 = 0;
            for (char c : charArray) {
                if (c == ' ') {
                    i2 = i3 + 1;
                    bArr[i3] = (byte) c;
                } else {
                    if (c >= 9985 && c <= 10174 && (b = qw[c - 9984]) != 0) {
                        i2 = i3 + 1;
                        bArr[i3] = b;
                    }
                }
                i3 = i2;
            }
            if (i3 == r0) {
                return bArr;
            }
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, 0, bArr2, 0, i3);
            return bArr2;
        }

        public byte[] qw(char c, String str) {
            byte b;
            if (c == ' ') {
                return new byte[]{(byte) c};
            } else if (c < 9985 || c > 10174 || (b = qw[c - 9984]) == 0) {
                return new byte[0];
            } else {
                return new byte[]{b};
            }
        }
    }

    static {
        for (int i2 = 128; i2 < 161; i2++) {
            char c = qw[i2];
            if (c != 65533) {
                f9342de.rg(c, i2);
            }
        }
        for (int i3 = 128; i3 < 161; i3++) {
            char c2 = f9341ad[i3];
            if (c2 != 65533) {
                f9343fe.rg(c2, i3);
            }
        }
        qw("Wingdings", new rg());
        qw("Symbol", new de(true));
        qw("ZapfDingbats", new de(false));
        qw("SymbolTT", new fe());
        qw("Cp437", new ad());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v13, resolved type: char} */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0043, code lost:
        if (r4 <= 255) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0046, code lost:
        r4 = r2.de(r4);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final byte[] ad(char r4, java.lang.String r5) {
        /*
            r0 = 1
            r1 = 0
            if (r5 == 0) goto L_0x009f
            int r2 = r5.length()
            if (r2 != 0) goto L_0x000c
            goto L_0x009f
        L_0x000c:
            java.util.HashMap<java.lang.String, com.itextpdf.text.pdf.ExtraEncoding> r2 = f9344rg
            java.lang.String r3 = r5.toLowerCase()
            java.lang.Object r2 = r2.get(r3)
            com.itextpdf.text.pdf.ExtraEncoding r2 = (com.itextpdf.text.pdf.ExtraEncoding) r2
            if (r2 == 0) goto L_0x0021
            byte[] r2 = r2.qw(r4, r5)
            if (r2 == 0) goto L_0x0021
            return r2
        L_0x0021:
            r2 = 0
            java.lang.String r3 = "Cp1252"
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x002d
            fe.when.ad.f.aaa r2 = f9342de
            goto L_0x0037
        L_0x002d:
            java.lang.String r3 = "PDF"
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x0037
            fe.when.ad.f.aaa r2 = f9343fe
        L_0x0037:
            r3 = 255(0xff, float:3.57E-43)
            if (r2 == 0) goto L_0x0055
            r5 = 128(0x80, float:1.794E-43)
            if (r4 < r5) goto L_0x004a
            r5 = 160(0xa0, float:2.24E-43)
            if (r4 <= r5) goto L_0x0046
            if (r4 > r3) goto L_0x0046
            goto L_0x004a
        L_0x0046:
            int r4 = r2.de(r4)
        L_0x004a:
            if (r4 == 0) goto L_0x0052
            byte[] r5 = new byte[r0]
            byte r4 = (byte) r4
            r5[r1] = r4
            return r5
        L_0x0052:
            byte[] r4 = new byte[r1]
            return r4
        L_0x0055:
            java.lang.String r2 = "UnicodeBig"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0072
            r5 = 4
            byte[] r5 = new byte[r5]
            r2 = -2
            r5[r1] = r2
            r1 = -1
            r5[r0] = r1
            r0 = 2
            int r1 = r4 >> 8
            byte r1 = (byte) r1
            r5[r0] = r1
            r0 = 3
            r4 = r4 & r3
            byte r4 = (byte) r4
            r5[r0] = r4
            return r5
        L_0x0072:
            java.nio.charset.Charset r5 = java.nio.charset.Charset.forName(r5)     // Catch:{ IOException -> 0x0098 }
            java.nio.charset.CharsetEncoder r5 = r5.newEncoder()     // Catch:{ IOException -> 0x0098 }
            java.nio.charset.CodingErrorAction r2 = java.nio.charset.CodingErrorAction.IGNORE     // Catch:{ IOException -> 0x0098 }
            r5.onUnmappableCharacter(r2)     // Catch:{ IOException -> 0x0098 }
            char[] r0 = new char[r0]     // Catch:{ IOException -> 0x0098 }
            r0[r1] = r4     // Catch:{ IOException -> 0x0098 }
            java.nio.CharBuffer r4 = java.nio.CharBuffer.wrap(r0)     // Catch:{ IOException -> 0x0098 }
            java.nio.ByteBuffer r4 = r5.encode(r4)     // Catch:{ IOException -> 0x0098 }
            r4.rewind()     // Catch:{ IOException -> 0x0098 }
            int r5 = r4.limit()     // Catch:{ IOException -> 0x0098 }
            byte[] r5 = new byte[r5]     // Catch:{ IOException -> 0x0098 }
            r4.get(r5)     // Catch:{ IOException -> 0x0098 }
            return r5
        L_0x0098:
            r4 = move-exception
            com.itextpdf.text.ExceptionConverter r5 = new com.itextpdf.text.ExceptionConverter
            r5.<init>(r4)
            throw r5
        L_0x009f:
            byte[] r5 = new byte[r0]
            byte r4 = (byte) r4
            r5[r1] = r4
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.a0.ad(char, java.lang.String):byte[]");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: char} */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0054, code lost:
        if (r6 <= 255) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0057, code lost:
        r6 = r1.de(r6);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final byte[] de(java.lang.String r8, java.lang.String r9) {
        /*
            r0 = 0
            if (r8 != 0) goto L_0x0006
            byte[] r8 = new byte[r0]
            return r8
        L_0x0006:
            if (r9 == 0) goto L_0x00cc
            int r1 = r9.length()
            if (r1 != 0) goto L_0x0010
            goto L_0x00cc
        L_0x0010:
            java.util.HashMap<java.lang.String, com.itextpdf.text.pdf.ExtraEncoding> r1 = f9344rg
            java.lang.String r2 = r9.toLowerCase()
            java.lang.Object r1 = r1.get(r2)
            com.itextpdf.text.pdf.ExtraEncoding r1 = (com.itextpdf.text.pdf.ExtraEncoding) r1
            if (r1 == 0) goto L_0x0025
            byte[] r1 = r1.de(r8, r9)
            if (r1 == 0) goto L_0x0025
            return r1
        L_0x0025:
            r1 = 0
            java.lang.String r2 = "Cp1252"
            boolean r2 = r9.equals(r2)
            if (r2 == 0) goto L_0x0031
            fe.when.ad.f.aaa r1 = f9342de
            goto L_0x003b
        L_0x0031:
            java.lang.String r2 = "PDF"
            boolean r2 = r9.equals(r2)
            if (r2 == 0) goto L_0x003b
            fe.when.ad.f.aaa r1 = f9343fe
        L_0x003b:
            r2 = 255(0xff, float:3.57E-43)
            if (r1 == 0) goto L_0x006f
            char[] r8 = r8.toCharArray()
            int r9 = r8.length
            byte[] r3 = new byte[r9]
            r4 = 0
            r5 = 0
        L_0x0048:
            if (r4 >= r9) goto L_0x0066
            char r6 = r8[r4]
            r7 = 128(0x80, float:1.794E-43)
            if (r6 < r7) goto L_0x005b
            r7 = 160(0xa0, float:2.24E-43)
            if (r6 <= r7) goto L_0x0057
            if (r6 > r2) goto L_0x0057
            goto L_0x005b
        L_0x0057:
            int r6 = r1.de(r6)
        L_0x005b:
            if (r6 == 0) goto L_0x0063
            int r7 = r5 + 1
            byte r6 = (byte) r6
            r3[r5] = r6
            r5 = r7
        L_0x0063:
            int r4 = r4 + 1
            goto L_0x0048
        L_0x0066:
            if (r5 != r9) goto L_0x0069
            return r3
        L_0x0069:
            byte[] r8 = new byte[r5]
            java.lang.System.arraycopy(r3, r0, r8, r0, r5)
            return r8
        L_0x006f:
            java.lang.String r1 = "UnicodeBig"
            boolean r1 = r9.equals(r1)
            if (r1 == 0) goto L_0x009f
            char[] r8 = r8.toCharArray()
            int r9 = r8.length
            int r1 = r8.length
            r3 = 2
            int r1 = r1 * 2
            int r1 = r1 + r3
            byte[] r1 = new byte[r1]
            r4 = -2
            r1[r0] = r4
            r4 = -1
            r5 = 1
            r1[r5] = r4
        L_0x008a:
            if (r0 >= r9) goto L_0x009e
            char r4 = r8[r0]
            int r5 = r3 + 1
            int r6 = r4 >> 8
            byte r6 = (byte) r6
            r1[r3] = r6
            int r3 = r5 + 1
            r4 = r4 & r2
            byte r4 = (byte) r4
            r1[r5] = r4
            int r0 = r0 + 1
            goto L_0x008a
        L_0x009e:
            return r1
        L_0x009f:
            java.nio.charset.Charset r9 = java.nio.charset.Charset.forName(r9)     // Catch:{ IOException -> 0x00c5 }
            java.nio.charset.CharsetEncoder r9 = r9.newEncoder()     // Catch:{ IOException -> 0x00c5 }
            java.nio.charset.CodingErrorAction r0 = java.nio.charset.CodingErrorAction.IGNORE     // Catch:{ IOException -> 0x00c5 }
            r9.onUnmappableCharacter(r0)     // Catch:{ IOException -> 0x00c5 }
            char[] r8 = r8.toCharArray()     // Catch:{ IOException -> 0x00c5 }
            java.nio.CharBuffer r8 = java.nio.CharBuffer.wrap(r8)     // Catch:{ IOException -> 0x00c5 }
            java.nio.ByteBuffer r8 = r9.encode(r8)     // Catch:{ IOException -> 0x00c5 }
            r8.rewind()     // Catch:{ IOException -> 0x00c5 }
            int r9 = r8.limit()     // Catch:{ IOException -> 0x00c5 }
            byte[] r9 = new byte[r9]     // Catch:{ IOException -> 0x00c5 }
            r8.get(r9)     // Catch:{ IOException -> 0x00c5 }
            return r9
        L_0x00c5:
            r8 = move-exception
            com.itextpdf.text.ExceptionConverter r9 = new com.itextpdf.text.ExceptionConverter
            r9.<init>(r8)
            throw r9
        L_0x00cc:
            int r9 = r8.length()
            byte[] r1 = new byte[r9]
        L_0x00d2:
            if (r0 >= r9) goto L_0x00de
            char r2 = r8.charAt(r0)
            byte r2 = (byte) r2
            r1[r0] = r2
            int r0 = r0 + 1
            goto L_0x00d2
        L_0x00de:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.a0.de(java.lang.String, java.lang.String):byte[]");
    }

    public static final String fe(byte[] bArr, String str) {
        String ad2;
        if (bArr == null) {
            return "";
        }
        int i2 = 0;
        if (str == null || str.length() == 0) {
            char[] cArr = new char[bArr.length];
            while (i2 < bArr.length) {
                cArr[i2] = (char) (bArr[i2] & 255);
                i2++;
            }
            return new String(cArr);
        }
        ExtraEncoding extraEncoding = f9344rg.get(str.toLowerCase());
        if (extraEncoding != null && (ad2 = extraEncoding.ad(bArr, str)) != null) {
            return ad2;
        }
        char[] cArr2 = null;
        if (str.equals("Cp1252")) {
            cArr2 = qw;
        } else if (str.equals("PDF")) {
            cArr2 = f9341ad;
        }
        if (cArr2 != null) {
            int length = bArr.length;
            char[] cArr3 = new char[length];
            while (i2 < length) {
                cArr3[i2] = cArr2[bArr[i2] & 255];
                i2++;
            }
            return new String(cArr3);
        }
        try {
            return new String(bArr, str);
        } catch (UnsupportedEncodingException e) {
            throw new ExceptionConverter(e);
        }
    }

    public static void qw(String str, ExtraEncoding extraEncoding) {
        synchronized (f9344rg) {
            HashMap<String, ExtraEncoding> hashMap = (HashMap) f9344rg.clone();
            hashMap.put(str.toLowerCase(), extraEncoding);
            f9344rg = hashMap;
        }
    }

    public static boolean rg(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt >= 128 && ((charAt <= 160 || charAt > 255) && !f9343fe.ad(charAt))) {
                return false;
            }
        }
        return true;
    }
}
