package fe.mmm.qw.ad.ad.qw;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.util.CommonParam;
import com.tera.scan.framework.kernel.architecture.ui.OldBaseActivity;
import com.tera.scan.network.network.request.RequestCommonParams;
import com.tera.scan.security.URLHandler;
import fe.mmm.qw.de.ad.qw.qw;
import fe.mmm.qw.j.i;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ad {
    @NotNull
    public static final ad qw = new ad();

    @NotNull
    public final String qw(@NotNull HttpUrl.Builder builder, @Nullable Context context) {
        Intrinsics.checkNotNullParameter(builder, "authorizedUrlBuilder");
        builder.addQueryParameter("devuid", qw.f7750o).addQueryParameter("clienttype", RequestCommonParams.rg()).addQueryParameter("channel", RequestCommonParams.fe()).addQueryParameter("version", qw.f7746ad).addQueryParameter("logid", RequestCommonParams.uk()).addQueryParameter(OldBaseActivity.VIP_SERVICE, RequestCommonParams.pf()).addQueryParameter("appid", qw.f7754uk);
        long j = qw.f7751pf;
        if (j > 0) {
            builder.addQueryParameter("firstlaunchtime", String.valueOf(j));
        }
        String httpUrl = builder.build().toString();
        Intrinsics.checkNotNullExpressionValue(httpUrl, "authorizedUrlBuilder.build().toString()");
        fe.mmm.qw.i.qw.ad("RequestInterceptor", "url:" + httpUrl);
        if (!StringsKt__StringsKt.contains$default((CharSequence) httpUrl, (CharSequence) "&time=", false, 2, (Object) null) && !StringsKt__StringsKt.contains$default((CharSequence) httpUrl, (CharSequence) "?time=", false, 2, (Object) null)) {
            builder.addQueryParameter("time", String.valueOf(i.ad()));
        }
        if (context != null) {
            builder.addQueryParameter("cuid", CommonParam.getCUID(context));
            String qw2 = fe.mmm.qw.ppp.ad.qw.qw.qw(context);
            if (!TextUtils.isEmpty(qw2)) {
                builder.addQueryParameter("network_type", qw2);
            }
        }
        builder.addQueryParameter("c3_aid", qw.f329if).addQueryParameter("c3_oaid", qw.f330switch);
        String bduss = fe.mmm.qw.p030switch.rg.qw.qw().getBduss();
        String uid = fe.mmm.qw.p030switch.rg.qw.qw().getUid();
        builder.addQueryParameter("apn_id", fe.mmm.qw.nn.qw.qw.i.fe());
        String httpUrl2 = builder.build().toString();
        Intrinsics.checkNotNullExpressionValue(httpUrl2, "authorizedUrlBuilder.build().toString()");
        fe.mmm.qw.i.qw.ad("RequestInterceptor", "urlResult:" + httpUrl2);
        String handlerURL = new URLHandler().handlerURL(context, httpUrl2, bduss, uid);
        fe.mmm.qw.i.qw.ad("RequestInterceptor", "randUrl:" + handlerURL);
        Intrinsics.checkNotNullExpressionValue(handlerURL, "randUrl");
        return handlerURL;
    }
}
