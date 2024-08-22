package fe.mmm.qw.tt.qw;

import org.jetbrains.annotations.NotNull;

public final class qw {
    @NotNull
    public static final String qw(int i2) {
        if (i2 == -2) {
            return "code";
        }
        if (i2 == 0) {
            return "DocScan";
        }
        switch (i2) {
            case 10:
                return "RmHWR";
            case 11:
                return "Words_rec";
            case 12:
                return "pic2word";
            case 13:
                return "pic2excel";
            case 14:
                return "pic2pdf";
            case 15:
                return "RMwmk";
            default:
                switch (i2) {
                    case 19:
                        return "PicEnhance";
                    case 20:
                        return "Addwmk";
                    case 21:
                        return "RmHWR";
                    default:
                        return "";
                }
        }
    }
}
