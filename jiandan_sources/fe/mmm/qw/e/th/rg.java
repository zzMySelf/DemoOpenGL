package fe.mmm.qw.e.th;

import com.baidu.android.common.util.DeviceId;
import com.baidu.common.config.IAppIdentityConfig;
import com.baidu.common.param.ICommonParamContext;
import com.mars.kotlin.extension.LoggerKt;
import fe.fe.ddd.eee.qw;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class rg implements ICommonParamContext, IAppIdentityConfig {
    @Nullable
    public String ad() {
        return null;
    }

    @Nullable
    public String de() {
        return qw.fe().de();
    }

    @Nullable
    public String fe() {
        return fe.mmm.qw.e.qw.f7756ad;
    }

    @NotNull
    public String getAppName() {
        return fe.mmm.qw.e.qw.f7756ad;
    }

    @NotNull
    public String getDeviceId() {
        String cuid = DeviceId.getCUID(fe.fe.ddd.i.qw.qw.qw());
        Intrinsics.checkNotNullExpressionValue(cuid, "getCUID(AppRuntime.getAppContext())");
        return cuid;
    }

    @Nullable
    public String getZid() {
        return qw.fe().pf();
    }

    @Nullable
    public String qw() {
        return fe.mmm.qw.de.ad.qw.qw.f7752rg;
    }

    @Nullable
    public String rg() {
        return fe.mmm.qw.de.ad.qw.qw.f7753th;
    }

    @NotNull
    public String th() {
        return "0";
    }

    @Nullable
    public String yj(@Nullable String str, boolean z) {
        LoggerKt.d$default("processUrlExternal url", (Object) null, 1, (Object) null);
        return str;
    }
}
