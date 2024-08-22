package _._._._._;

import com.baidu.netdisk.trade.privilege.config.IPrivilegeConfig;
import com.baidu.netdisk.trade.privilege.config.IRequest;
import com.baidu.netdisk.trade.privilege.config.IStore;
import fe.fe.vvv.ad.ad.ad;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

public final class __ {

    /* renamed from: ad  reason: collision with root package name */
    public static final __ f542ad = new __();
    public static final Lazy qw = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, _.f543_);

    public static final class _ extends Lambda implements Function0<IPrivilegeConfig> {

        /* renamed from: _  reason: collision with root package name */
        public static final _ f543_ = new _();

        public _() {
            super(0);
        }

        /* renamed from: _ */
        public final IPrivilegeConfig invoke() {
            return (IPrivilegeConfig) ad.qw(IPrivilegeConfig.qw);
        }
    }

    @Nullable
    public final IRequest ad() {
        IPrivilegeConfig qw2 = qw();
        if (qw2 != null) {
            return qw2.getRequest();
        }
        return null;
    }

    @Nullable
    public final IStore de() {
        IPrivilegeConfig qw2 = qw();
        if (qw2 != null) {
            return qw2.qw();
        }
        return null;
    }

    public final IPrivilegeConfig qw() {
        return (IPrivilegeConfig) qw.getValue();
    }
}
