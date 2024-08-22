package fe.mmm.qw.nn.de.p028if;

import com.tera.scan.network.network.interceptor.IFallbackInterceptor;
import com.tera.scan.network.network.retrofit.RetrofitServiceApi;
import fe.mmm.qw.nn.de.p028if.ad;
import fe.mmm.qw.nn.qw.qw.fe;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* renamed from: fe.mmm.qw.nn.de.if.qw  reason: invalid package */
public final class qw {
    @NotNull
    public IFallbackInterceptor qw = new fe();

    @NotNull
    public final RetrofitServiceApi ad(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        Object create = qw(str, 10000).create(RetrofitServiceApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "getRetrofit(baseUrl, Con…itServiceApi::class.java)");
        return (RetrofitServiceApi) create;
    }

    public final Retrofit qw(String str, long j) {
        ad.qw qwVar = new ad.qw();
        qwVar.ad(true);
        qwVar.de(this.qw);
        Retrofit build = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).client(new OkHttpClient.Builder().addInterceptor(qwVar.qw()).connectTimeout(j, TimeUnit.SECONDS).readTimeout(j, TimeUnit.SECONDS).build()).baseUrl(str).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n              …\n                .build()");
        return build;
    }
}
