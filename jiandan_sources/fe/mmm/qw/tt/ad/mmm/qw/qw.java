package fe.mmm.qw.tt.ad.mmm.qw;

import com.baidu.aiscan.R;
import fe.vvv.qw.xxx.ad;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class qw {
    public static final int qw(@NotNull ad adVar) {
        Intrinsics.checkNotNullParameter(adVar, "size");
        if (adVar.fe() >= 4000) {
            return R.drawable.ocr_choose_size_hd;
        }
        if (adVar.fe() >= 3000) {
            return R.drawable.ocr_choose_size_large;
        }
        if (adVar.fe() >= 2000) {
            return R.drawable.ocr_choose_size_standard;
        }
        return R.drawable.ocr_choose_size_hd;
    }
}
