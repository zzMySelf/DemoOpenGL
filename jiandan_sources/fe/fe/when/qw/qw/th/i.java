package fe.fe.when.qw.qw.th;

import com.baidu.netdisk.trade.pay.channel.ChannelMode;
import com.baidu.netdisk.trade.pay.channel.DXMChannelValue;
import com.baidu.netdisk.trade.pay.channel._____;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class i {

    public /* synthetic */ class qw {
        public static final /* synthetic */ int[] qw;

        static {
            int[] iArr = new int[ChannelMode.values().length];
            iArr[ChannelMode.WEBCHAT.ordinal()] = 1;
            iArr[ChannelMode.DXM_BAIFUBAO.ordinal()] = 2;
            iArr[ChannelMode.DXM_WEBCHAT.ordinal()] = 3;
            iArr[ChannelMode.DXM_ALI.ordinal()] = 4;
            iArr[ChannelMode.DXM_SIGN.ordinal()] = 5;
            qw = iArr;
        }
    }

    @Nullable
    public final _____ qw(@NotNull ChannelMode channelMode) {
        Intrinsics.checkNotNullParameter(channelMode, "channel");
        int i2 = qw.qw[channelMode.ordinal()];
        if (i2 == 1) {
            return new Cswitch();
        }
        if (i2 == 2) {
            return new Cif();
        }
        if (i2 == 3) {
            return new o(DXMChannelValue.DXM_WEBCHAT);
        }
        if (i2 == 4) {
            return new o(DXMChannelValue.DXM_ALI);
        }
        if (i2 != 5) {
            return null;
        }
        return new pf();
    }
}
