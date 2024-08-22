package fe.mmm.qw.nn.de.p028if;

import androidx.browser.trusted.sharing.ShareTarget;
import com.baidu.sapi2.utils.SapiUtils;
import com.tera.scan.network.network.interceptor.IFallbackInterceptor;
import com.tera.scan.network.network.request.RequestCommonParams;
import fe.mmm.qw.nn.qw.qw.fe;
import java.io.IOException;
import java.net.URL;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;

/* renamed from: fe.mmm.qw.nn.de.if.ad  reason: invalid package */
public final class ad implements Interceptor {

    /* renamed from: ad  reason: collision with root package name */
    public String[] f8096ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final IFallbackInterceptor f8097de;
    public final boolean qw;

    /* renamed from: fe.mmm.qw.nn.de.if.ad$ad  reason: collision with other inner class name */
    public static final class C0287ad implements IFallbackInterceptor.Builder<String> {
        public /* bridge */ /* synthetic */ Object ad(String str) {
            de(str);
            return str;
        }

        @NotNull
        public String de(@NotNull String str) throws JSONException {
            Intrinsics.checkNotNullParameter(str, "url");
            return str;
        }

        @NotNull
        /* renamed from: fe */
        public String[] qw(int i2) {
            return new String[]{""};
        }
    }

    /* renamed from: fe.mmm.qw.nn.de.if.ad$qw */
    public static final class qw {
        @Nullable

        /* renamed from: ad  reason: collision with root package name */
        public IFallbackInterceptor f8098ad;
        public boolean qw = true;

        @NotNull
        public final qw ad(boolean z) {
            this.qw = z;
            return this;
        }

        @NotNull
        public final qw de(@NotNull IFallbackInterceptor iFallbackInterceptor) {
            Intrinsics.checkNotNullParameter(iFallbackInterceptor, "interceptor");
            this.f8098ad = iFallbackInterceptor;
            return this;
        }

        public final boolean fe() {
            return this.qw;
        }

        @NotNull
        public final ad qw() {
            return new ad(this);
        }

        @Nullable
        public final IFallbackInterceptor rg() {
            return this.f8098ad;
        }
    }

    public ad(@NotNull qw qwVar) {
        IFallbackInterceptor iFallbackInterceptor;
        Intrinsics.checkNotNullParameter(qwVar, "builder");
        this.qw = qwVar.fe();
        if (qwVar.rg() == null) {
            iFallbackInterceptor = new fe();
        } else {
            iFallbackInterceptor = qwVar.rg();
            Intrinsics.checkNotNull(iFallbackInterceptor);
        }
        this.f8097de = iFallbackInterceptor;
    }

    public final String[] ad(String str) throws JSONException {
        Object[] ad2 = this.f8097de.ad(str, new C0287ad());
        Intrinsics.checkNotNullExpressionValue(ad2, "mFallbackInterceptor.bui…\n            }\n        })");
        return (String[]) ad2;
    }

    public final HttpUrl.Builder de(Request request) {
        HttpUrl.Builder host = request.url().newBuilder().scheme(request.url().scheme()).host(request.url().host());
        Intrinsics.checkNotNullExpressionValue(host, "oldRequest.url()\n       …(oldRequest.url().host())");
        return host;
    }

    public final Response fe(Request request) {
        Response build = new Response.Builder().code(10000).request(request).protocol(Protocol.HTTP_1_1).message(SapiUtils.KEY_QR_LOGIN_ERROR).body(de.qw).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .c…ody)\n            .build()");
        return build;
    }

    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        String[] strArr;
        Interceptor.Chain chain2 = chain;
        Intrinsics.checkNotNullParameter(chain2, "chain");
        Request request = chain.request();
        String httpUrl = request.url().toString();
        Intrinsics.checkNotNullExpressionValue(httpUrl, "oldRequest.url().toString()");
        try {
            String httpUrl2 = request.url().toString();
            Intrinsics.checkNotNullExpressionValue(httpUrl2, "oldRequest.url().toString()");
            strArr = ad(httpUrl2);
        } catch (JSONException e) {
            fe.mmm.qw.i.qw.th("RequestInterceptor", e.getMessage(), e);
            strArr = new String[]{httpUrl, httpUrl, httpUrl};
        }
        uk(strArr);
        Intrinsics.checkNotNullExpressionValue(request, "oldRequest");
        HttpUrl.Builder de2 = de(request);
        int min = Math.min(4, rg().length);
        boolean pf2 = fe.mmm.qw.nn.ad.qw.qw.qw.pf();
        Response response = null;
        int i2 = 0;
        int i3 = 0;
        while (i2 < min) {
            int i4 = min - 1;
            boolean z = i2 == i4;
            boolean z2 = z ? false : pf2;
            int length = (!z || i3 != i4) ? i2 : rg().length - 1;
            if (i2 > 0) {
                de2.scheme(new URL(rg()[length]).getProtocol());
                de2.addQueryParameter("wp_retry_num", String.valueOf(i2));
            }
            String yj2 = yj(de2, z2, length);
            boolean qw2 = this.f8097de.qw(yj2);
            boolean fe2 = this.f8097de.fe(yj2);
            if (rg().length > 1) {
                this.f8097de.rg(!fe2);
            }
            Request.Builder th2 = th(request, yj2);
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e2) {
                    fe.mmm.qw.i.qw.rg("RequestInterceptor", e2.getMessage());
                    if (fe2) {
                        i3++;
                    }
                } catch (Exception e3) {
                    fe.mmm.qw.i.qw.rg("RequestInterceptor", e3.getMessage());
                }
            }
            response = chain2.proceed(th2.build());
            this.f8097de.de(fe2, qw2);
            if (response != null && response.isSuccessful()) {
                break;
            }
            i2++;
            pf2 = z2;
        }
        return response == null ? fe(request) : response;
    }

    public final String qw(HttpUrl.Builder builder) {
        fe.mmm.qw.i.qw.uk("RequestInterceptor", "appendParams ");
        return fe.mmm.qw.nn.ad.qw.qw.qw.ad(builder);
    }

    @NotNull
    public final String[] rg() {
        String[] strArr = this.f8096ad;
        if (strArr != null) {
            return strArr;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mUrls");
        return null;
    }

    public final Request.Builder th(Request request, String str) {
        Request.Builder addHeader = request.newBuilder().method(request.method(), request.body()).url(str).addHeader("User-Agent", RequestCommonParams.o()).addHeader("Content-Type", ShareTarget.ENCODING_TYPE_URL_ENCODED).addHeader("Cookie", fe.mmm.qw.nn.ad.qw.qw.qw.fe());
        Intrinsics.checkNotNullExpressionValue(addHeader, "oldRequest.newBuilder()\n…dHeader(\"Cookie\", cookie)");
        return addHeader;
    }

    public final void uk(@NotNull String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "<set-?>");
        this.f8096ad = strArr;
    }

    public final String yj(HttpUrl.Builder builder, boolean z, int i2) {
        if (this.qw) {
            return qw(builder);
        }
        String httpUrl = builder.build().toString();
        Intrinsics.checkNotNullExpressionValue(httpUrl, "{\n            urlBuilder…ld().toString()\n        }");
        return httpUrl;
    }
}
