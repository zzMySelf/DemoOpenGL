package ad.qw.qw.qw.qw.ad.de;

import _._._._._.__;
import com.baidu.netdisk.trade.privilege.config.IRequest;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

public final class qw implements Interceptor {
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        String str;
        Map<String, String> qw;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        Intrinsics.checkNotNullExpressionValue(request, "chain.request()");
        HttpUrl.Builder qw2 = qw(request);
        IRequest ad2 = __.f542ad.ad();
        if (ad2 == null || (str = ad2.de(qw2)) == null) {
            str = qw2.build().toString();
            Intrinsics.checkNotNullExpressionValue(str, "authorizedUrlBuilder.build().toString()");
        }
        Request.Builder url = request.newBuilder().method(request.method(), request.body()).url(str);
        Intrinsics.checkNotNullExpressionValue(url, "originalRequest.newBuild…            .url(fullUrl)");
        IRequest ad3 = __.f542ad.ad();
        if (!(ad3 == null || (qw = ad3.qw()) == null)) {
            url.headers(Headers.of(qw));
        }
        Response proceed = chain.proceed(url.build());
        Intrinsics.checkNotNullExpressionValue(proceed, "chain.proceed(builder.build())");
        return proceed;
    }

    public final HttpUrl.Builder qw(Request request) {
        String str;
        IRequest ad2 = __.f542ad.ad();
        if (ad2 == null || (str = ad2.ad()) == null) {
            str = request.url().host();
        }
        HttpUrl.Builder host = request.url().newBuilder().scheme(request.url().scheme()).host(str);
        Intrinsics.checkNotNullExpressionValue(host, "oldRequest.url()\n       …)\n            .host(host)");
        return host;
    }
}
