package fe.mmm.qw.m;

import android.os.Build;
import com.tera.scan.framework.kernel.BaseApplication;
import com.tera.scan.framework.kernel.architecture.ui.OldBaseActivity;
import com.tera.scan.network.network.request.RequestCommonParams;
import fe.mmm.qw.de.ad.qw.qw;
import fe.mmm.qw.nn.de.o.ad;
import fe.mmm.qw.nn.qw.qw.i;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class pf {
    @NotNull
    public static final pf qw = new pf();

    @NotNull
    public final String qw() {
        ad adVar = new ad();
        adVar.ad("appid", qw.f7754uk);
        adVar.ad("devuid", qw.f7750o);
        adVar.ad("clienttype", RequestCommonParams.rg());
        adVar.ad("channel", RequestCommonParams.fe());
        adVar.ad("version", qw.f7746ad);
        adVar.ad("logid", RequestCommonParams.uk());
        adVar.ad(OldBaseActivity.VIP_SERVICE, RequestCommonParams.pf());
        adVar.ad("devicename", Build.MODEL);
        long j = qw.f7751pf;
        if (j > 0) {
            adVar.ad("firstlaunchtime", String.valueOf(j));
        }
        adVar.ad("theme", "white");
        adVar.ad("apn_id", i.fe());
        i.qw(BaseApplication.getInstance(), adVar);
        String adVar2 = adVar.toString();
        Intrinsics.checkNotNullExpressionValue(adVar2, "HttpParams().apply {\n   …his)\n        }.toString()");
        return adVar2;
    }
}
