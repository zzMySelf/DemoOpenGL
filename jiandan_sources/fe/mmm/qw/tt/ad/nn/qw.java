package fe.mmm.qw.tt.ad.nn;

import com.tera.scan.scanner.ocr.OCRTakePhotoActivity;
import fe.vvv.qw.xxx.ad;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw {
    @NotNull
    public static final String ad(boolean z) {
        return z ? "open" : "close";
    }

    @NotNull
    public static final String de(@Nullable Integer num) {
        if (num != null && num.intValue() == 1) {
            return "camera";
        }
        if (num != null && num.intValue() == 2) {
            return "quick";
        }
        if (num != null && num.intValue() == 3) {
            return "files";
        }
        if (num != null && num.intValue() == 5) {
            return "toolbox";
        }
        if (num != null && num.intValue() == 6) {
            return "scan_edit";
        }
        return (num != null && num.intValue() == 7) ? "toword" : "other";
    }

    @NotNull
    public static final String fe(@Nullable Integer num) {
        if (num == null) {
            return "other";
        }
        num.intValue();
        int intValue = num.intValue();
        if (intValue == 0) {
            return "QRCode";
        }
        if (intValue == 1) {
            return "text";
        }
        if (intValue == 2) {
            return "files";
        }
        if (intValue == 6) {
            return "toword";
        }
        if (intValue != 8) {
            return "other";
        }
        return OCRTakePhotoActivity.ROUTER_INIT_TAB_TRANSLATE;
    }

    @NotNull
    public static final String qw(@Nullable ad adVar) {
        if (adVar == null) {
            return "other";
        }
        if (adVar.fe() > 4000) {
            return "HD";
        }
        if (adVar.fe() > 3000) {
            return "large";
        }
        if (adVar.fe() > 2000) {
            return "standard";
        }
        if (adVar.fe() > 1000) {
            return "medium";
        }
        return "other";
    }
}
