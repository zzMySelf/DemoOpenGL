package fe.mmm.qw.nn.qw.qw;

import androidx.annotation.Nullable;
import com.tera.scan.network.network.interceptor.IStatisticsInterceptor;
import fe.mmm.qw.nn.de.rg;
import fe.mmm.qw.ppp.qw;

public class th implements IStatisticsInterceptor {
    public void ad(@Nullable yj yjVar) {
        if (yjVar != null) {
            o(yjVar);
        }
    }

    public void de(String str) {
        th("http_failed");
        uk("http_failed_reason", str, String.valueOf(new rg(qw.qw.qw()).ad()));
        th("http_succeeded_and_failed");
    }

    public void fe(boolean z) {
        yj("http_succeeded", String.valueOf(z));
        yj("http_succeeded_and_failed", String.valueOf(z));
    }

    public void i(String str, String str2, String str3, String str4) {
        if (fe.mmm.qw.nn.ad.qw.qw.qw.m988switch()) {
            fe.mmm.qw.nn.ad.qw.qw.qw.xxx(str, str2, str3, str4);
        }
    }

    public final void o(yj yjVar) {
        if (fe.mmm.qw.nn.ad.qw.qw.qw.m988switch()) {
            fe.mmm.qw.nn.ad.qw.qw.qw.nn(yjVar);
        }
    }

    public void qw(boolean z, String str) {
        yj("https_failed", String.valueOf(z));
        i("https_failed_reason", str, String.valueOf(new rg(qw.qw.qw()).ad()), String.valueOf(z));
        yj("https_succeeded_and_failed", String.valueOf(z));
    }

    public void rg(boolean z) {
        yj("https_succeeded", String.valueOf(z));
        yj("https_succeeded_and_failed", String.valueOf(z));
    }

    public void th(String str) {
        if (fe.mmm.qw.nn.ad.qw.qw.qw.m988switch()) {
            fe.mmm.qw.nn.ad.qw.qw.qw.ppp(str);
        }
    }

    public void uk(String str, String str2, String str3) {
        if (fe.mmm.qw.nn.ad.qw.qw.qw.m988switch()) {
            fe.mmm.qw.nn.ad.qw.qw.qw.vvv(str, str2, str3);
        }
    }

    public void yj(String str, String str2) {
        if (fe.mmm.qw.nn.ad.qw.qw.qw.m988switch()) {
            fe.mmm.qw.nn.ad.qw.qw.qw.ggg(str, str2);
        }
    }
}
