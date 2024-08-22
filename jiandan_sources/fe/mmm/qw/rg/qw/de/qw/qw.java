package fe.mmm.qw.rg.qw.de.qw;

import android.content.Context;
import com.baidu.android.common.util.CommonParam;
import com.tera.scan.framework.kernel.architecture.ui.OldBaseActivity;
import com.tera.scan.network.network.request.RequestCommonParams;
import fe.mmm.qw.j.i;
import fe.mmm.qw.nn.de.o.ad;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw {
    @NotNull
    public static final qw qw = new qw();

    public final void qw(@Nullable Context context, @Nullable String str, @NotNull String str2, @NotNull ad adVar) {
        Intrinsics.checkNotNullParameter(str2, "url");
        Intrinsics.checkNotNullParameter(adVar, "params");
        adVar.ad("devuid", fe.mmm.qw.de.ad.qw.qw.f7750o);
        adVar.ad("appid", fe.mmm.qw.de.ad.qw.qw.f7754uk);
        if (!adVar.rg("clienttype")) {
            adVar.ad("clienttype", RequestCommonParams.rg());
        }
        adVar.ad("channel", RequestCommonParams.fe());
        adVar.ad("first_setup_channel", RequestCommonParams.yj());
        adVar.ad("version", fe.mmm.qw.de.ad.qw.qw.f7746ad);
        adVar.ad("logid", RequestCommonParams.uk());
        adVar.ad(OldBaseActivity.VIP_SERVICE, RequestCommonParams.pf());
        long j = fe.mmm.qw.de.ad.qw.qw.f7751pf;
        if (j > 0) {
            adVar.ad("firstlaunchtime", String.valueOf(j));
        }
        if (!StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) "&time=", false, 2, (Object) null) && !StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) "?time=", false, 2, (Object) null)) {
            adVar.ad("time", String.valueOf(i.ad()));
        }
        if (context != null) {
            adVar.ad("cuid", CommonParam.getCUID(context));
            fe.mmm.qw.nn.qw.qw.i.qw(context, adVar);
            adVar.ad("c3_aid", fe.mmm.qw.de.ad.qw.qw.f329if);
            adVar.ad("c3_oaid", fe.mmm.qw.de.ad.qw.qw.f330switch);
        }
        adVar.ad("apn_id", fe.mmm.qw.nn.qw.qw.i.fe());
    }
}
