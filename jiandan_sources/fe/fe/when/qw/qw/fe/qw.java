package fe.fe.when.qw.qw.fe;

import com.baidu.netdisk.trade.pay.channel.ChannelMode;
import org.jetbrains.annotations.Nullable;

public final class qw {
    @Nullable
    public static final ChannelMode qw(int i2) {
        for (ChannelMode channelMode : ChannelMode.values()) {
            if (channelMode.getValue() == i2) {
                return channelMode;
            }
        }
        return null;
    }
}
