package fe.mmm.qw.k.i.de;

import androidx.browser.trusted.sharing.ShareTarget;
import com.baidu.netdisk.trade.pay.config.IRequest;
import com.tera.scan.network.network.request.RequestCommonParams;
import fe.mmm.qw.nn.ad.qw.qw;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;

public final class ad implements IRequest {
    @NotNull
    public String ad() {
        return "aiscan.baidu.com";
    }

    @NotNull
    public String de(@NotNull HttpUrl.Builder builder) {
        String invoke;
        Intrinsics.checkNotNullParameter(builder, "authorizedUrlBuilder");
        Function1<HttpUrl.Builder, String> i2 = qw.qw.i();
        if (i2 != null && (invoke = i2.invoke(builder)) != null) {
            return invoke;
        }
        String httpUrl = builder.build().toString();
        Intrinsics.checkNotNullExpressionValue(httpUrl, "authorizedUrlBuilder.build().toString()");
        return httpUrl;
    }

    @NotNull
    public String fe() {
        return "scan_app";
    }

    @NotNull
    public Map<String, String> qw() {
        return MapsKt__MapsKt.mutableMapOf(TuplesKt.to("User-Agent", RequestCommonParams.o()), TuplesKt.to("Content-Type", ShareTarget.ENCODING_TYPE_URL_ENCODED), TuplesKt.to("Cookie", qw.qw.fe()));
    }
}
