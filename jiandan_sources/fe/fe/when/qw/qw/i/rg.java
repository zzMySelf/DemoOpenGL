package fe.fe.when.qw.qw.i;

import com.baidu.netdisk.trade.pay.polymer.PolymerMode;
import com.baidu.netdisk.trade.pay.polymer.__;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class rg {

    public /* synthetic */ class qw {
        public static final /* synthetic */ int[] qw;

        static {
            int[] iArr = new int[PolymerMode.values().length];
            iArr[PolymerMode.BaiduWallet.ordinal()] = 1;
            qw = iArr;
        }
    }

    @Nullable
    public final __ qw(@NotNull PolymerMode polymerMode) {
        Intrinsics.checkNotNullParameter(polymerMode, "polymerMode");
        if (qw.qw[polymerMode.ordinal()] == 1) {
            return new fe();
        }
        return null;
    }
}
