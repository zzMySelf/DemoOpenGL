package fe.fe.when.qw.qw.uk.ad;

import com.baidu.netdisk.trade.pay.order.__.___;
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
    public static final OkHttpClient f3188ad;

    /* renamed from: de  reason: collision with root package name */
    public static final Retrofit f3189de;
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public static final ___ f3190fe;
    @NotNull
    public static final ad qw = new ad();

    static {
        OkHttpClient.Builder addInterceptor = new OkHttpClient.Builder().connectTimeout(60, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS).writeTimeout(60, TimeUnit.SECONDS).addInterceptor(new qw());
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient build = addInterceptor.addInterceptor(httpLoggingInterceptor).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n        .conne…      })\n        .build()");
        f3188ad = build;
        Retrofit build2 = new Retrofit.Builder().baseUrl("https://pan.baidu.com/").addConverterFactory(GsonConverterFactory.create()).client(f3188ad).build();
        f3189de = build2;
        Object create = build2.create(___.class);
        Intrinsics.checkNotNullExpressionValue(create, "retrofit.create(ServerApi::class.java)");
        f3190fe = (___) create;
    }

    @NotNull
    public final ___ qw() {
        return f3190fe;
    }
}
