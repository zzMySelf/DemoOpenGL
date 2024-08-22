package fe.mmm.qw.k.i.de;

import com.baidu.netdisk.trade.pay.config.IPayConfig;
import com.baidu.netdisk.trade.pay.config.IRequest;
import org.jetbrains.annotations.NotNull;

public final class qw extends fe.fe.vvv.ad.ad.qw<IPayConfig> {

    /* renamed from: fe.mmm.qw.k.i.de.qw$qw  reason: collision with other inner class name */
    public static final class C0285qw implements IPayConfig {
        @NotNull
        public IRequest getRequest() {
            return new ad();
        }
    }

    @NotNull
    /* renamed from: ad */
    public IPayConfig qw() {
        return new C0285qw();
    }
}
