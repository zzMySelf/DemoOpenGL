package fe.when.ad;

import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import com.google.zxing.pdf417.decoder.DecodedBitStreamParser;

public class eee {
    public static int ad(String str) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (qw(str.charAt(i2)) != ' ') {
                return i2;
            }
        }
        return -1;
    }

    public static char qw(char c) {
        switch (c) {
            case 913:
                return 'A';
            case 914:
                return 'B';
            case 915:
                return 'G';
            case 916:
                return 'D';
            case 917:
                return 'E';
            case 918:
                return 'Z';
            case 919:
                return 'H';
            case 920:
                return 'Q';
            case 921:
                return 'I';
            case DecodedBitStreamParser.MACRO_PDF417_TERMINATOR:
                return 'K';
            case DecodedBitStreamParser.BEGIN_MACRO_PDF417_OPTIONAL_FIELD:
                return 'L';
            case 924:
                return 'M';
            case 925:
                return 'N';
            case 926:
                return 'X';
            case 927:
                return 'O';
            case 928:
                return 'P';
            case PDF417Common.NUMBER_OF_CODEWORDS:
                return 'R';
            default:
                switch (c) {
                    case 931:
                        return 'S';
                    case 932:
                        return 'T';
                    case 933:
                        return 'U';
                    case 934:
                        return 'F';
                    case 935:
                        return 'C';
                    case 936:
                        return 'Y';
                    case 937:
                        return 'W';
                    default:
                        switch (c) {
                            case 945:
                                return 'a';
                            case 946:
                                return 'b';
                            case 947:
                                return 'g';
                            case 948:
                                return 'd';
                            case 949:
                                return 'e';
                            case 950:
                                return 'z';
                            case 951:
                                return 'h';
                            case 952:
                                return 'q';
                            case 953:
                                return 'i';
                            case 954:
                                return 'k';
                            case 955:
                                return 'l';
                            case 956:
                                return 'm';
                            case 957:
                                return 'n';
                            case 958:
                                return 'x';
                            case 959:
                                return 'o';
                            case 960:
                                return 'p';
                            case 961:
                                return 'r';
                            case 962:
                                return 'V';
                            case 963:
                                return 's';
                            case 964:
                                return 't';
                            case 965:
                                return 'u';
                            case 966:
                                return 'f';
                            case 967:
                                return 'c';
                            case 968:
                                return 'y';
                            case 969:
                                return 'w';
                            default:
                                return Ascii.CASE_MASK;
                        }
                }
        }
    }
}
