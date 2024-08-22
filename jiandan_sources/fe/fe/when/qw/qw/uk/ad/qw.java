package fe.fe.when.qw.qw.uk.ad;

import com.baidu.netdisk.trade.pay.config.IRequest;
import com.baidu.netdisk.trade.pay.config._;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

@Tag("PayInterceptor")
public final class qw implements Interceptor {
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        Map<String, String> qw;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        Intrinsics.checkNotNullExpressionValue(request, "chain.request()");
        HttpUrl.Builder qw2 = qw(request);
        LoggerKt.d$default("authorizedUrlBuilder:" + qw2, (Object) null, 1, (Object) null);
        IRequest qw3 = _.qw.qw();
        String de2 = qw3 != null ? qw3.de(qw2) : null;
        String httpUrl = de2 == null || de2.length() == 0 ? qw2.build().toString() : de2;
        Intrinsics.checkNotNullExpressionValue(httpUrl, "if (payUrl.isNullOrEmpty…().toString() else payUrl");
        LoggerKt.d$default("fullUrl:" + httpUrl + "  payUrl:" + de2, (Object) null, 1, (Object) null);
        Request.Builder url = request.newBuilder().method(request.method(), request.body()).url(httpUrl);
        Intrinsics.checkNotNullExpressionValue(url, "originalRequest.newBuild…            .url(fullUrl)");
        IRequest qw4 = _.qw.qw();
        if (!(qw4 == null || (qw = qw4.qw()) == null)) {
            url.headers(Headers.of(qw));
        }
        Response proceed = chain.proceed(url.build());
        Intrinsics.checkNotNullExpressionValue(proceed, "chain.proceed(builder.build())");
        return proceed;
    }

    public final HttpUrl.Builder qw(Request request) {
        IRequest qw = _.qw.qw();
        String ad2 = qw != null ? qw.ad() : null;
        boolean z = true;
        LoggerKt.d$default("oldRequest:" + request.url() + "  payHost:" + ad2, (Object) null, 1, (Object) null);
        if (!(ad2 == null || ad2.length() == 0)) {
            z = false;
        }
        if (z) {
            ad2 = request.url().host();
        }
        HttpUrl.Builder host = request.url().newBuilder().scheme(request.url().scheme()).host(ad2);
        Intrinsics.checkNotNullExpressionValue(host, "oldRequest.url()\n       …)\n            .host(host)");
        return host;
    }
}
