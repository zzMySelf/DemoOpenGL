package fe.th.de.rrr.yj;

import androidx.browser.trusted.sharing.ShareTarget;
import com.duxiaoman.okhttp3.Interceptor;
import com.duxiaoman.okhttp3.internal.http.HttpCodec;
import fe.th.de.ddd;
import fe.th.de.eee;
import fe.th.de.ggg;
import fe.th.de.mmm;
import fe.th.de.rrr.uk.th;
import java.io.IOException;

public final class qw implements Interceptor {

    /* renamed from: ad  reason: collision with root package name */
    public static String f5503ad = "ConnectInterceptor";
    public final ggg qw;

    public qw(ggg ggg) {
        this.qw = ggg;
    }

    public static void qw(String str, ddd ddd, String str2) {
        eee.qw(str, ddd, str2, f5503ad);
    }

    public mmm intercept(Interceptor.Chain chain) throws IOException {
        th thVar = (th) chain;
        ddd request = thVar.request();
        th th2 = thVar.th();
        HttpCodec when = th2.when(this.qw, chain, !request.th().equals(ShareTarget.METHOD_GET));
        de fe2 = th2.fe();
        qw("isHappyEyeballsWorking:: ", request, "intercept");
        if (th2.m363switch()) {
            ddd.qw yj2 = request.yj();
            yj2.qw("X-Fallback-Connection", th2.m362if() ? "1" : "0");
            request = yj2.ad();
        }
        return thVar.rg(request, th2, when, fe2);
    }
}
