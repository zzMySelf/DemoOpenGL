package ad.qw.qw.qw.qw.ad.de;

import _._._._._.___.___.___;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class ad {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public static final ___ f545ad;

    /* renamed from: de  reason: collision with root package name */
    public static final ad f546de = new ad();
    public static final OkHttpClient qw;

    static {
        OkHttpClient.Builder addInterceptor = new OkHttpClient.Builder().connectTimeout(60, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS).writeTimeout(60, TimeUnit.SECONDS).addInterceptor(new qw());
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient build = addInterceptor.addInterceptor(httpLoggingInterceptor).build();
        Intrinsics.checkNotNullExpressionValue(build, "OkHttpClient.Builder()\n …      })\n        .build()");
        qw = build;
        Object create = new Retrofit.Builder().baseUrl("https://pan.baidu.com/rest/2.0/membership/").addConverterFactory(GsonConverterFactory.create()).client(qw).build().create(___.class);
        Intrinsics.checkNotNullExpressionValue(create, "retrofit.create(ServerApi::class.java)");
        f545ad = (___) create;
    }

    @NotNull
    public final ___ qw() {
        return f545ad;
    }
}
