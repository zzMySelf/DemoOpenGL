package fe.fe.mmm.n;

import android.text.TextUtils;
import com.baidu.apollon.statistics.Config;
import com.baidu.ubc.bypass.BypassConstants$Funnel;
import com.baidu.ubc.bypass.IBypass;
import java.text.SimpleDateFormat;
import org.json.JSONException;
import org.json.JSONObject;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public static final ThreadLocal<SimpleDateFormat> f2062ad = new C0108qw();
    public final IBypass qw;

    public static class ad {
        public static qw qw = new qw((C0108qw) null);
    }

    public static class de {

        /* renamed from: ad  reason: collision with root package name */
        public long f2063ad;

        /* renamed from: de  reason: collision with root package name */
        public long f2064de;

        /* renamed from: fe  reason: collision with root package name */
        public long f2065fe;
        public String qw;

        /* renamed from: rg  reason: collision with root package name */
        public long f2066rg;

        public String ad() {
            return this.qw;
        }

        public long de() {
            return this.f2064de;
        }

        public long fe() {
            return this.f2065fe;
        }

        public void i(long j) {
            this.f2065fe = j;
        }

        public void o(long j) {
            this.f2066rg = j;
        }

        public long qw() {
            return this.f2063ad;
        }

        public long rg() {
            return this.f2066rg;
        }

        public void th(long j) {
            this.f2063ad = j;
        }

        public void uk(long j) {
            this.f2064de = j;
        }

        public void yj(String str) {
            this.qw = str;
        }
    }

    /* renamed from: fe.fe.mmm.n.qw$qw  reason: collision with other inner class name */
    public class C0108qw extends ThreadLocal<SimpleDateFormat> {
        /* renamed from: qw */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMdd");
        }
    }

    public /* synthetic */ qw(C0108qw qwVar) {
        this();
    }

    public static void ad(String str, long j, long j2, long j3, long j4) {
        if (!TextUtils.isEmpty(str)) {
            de deVar = new de();
            deVar.yj(str);
            deVar.th(j);
            deVar.uk(j2);
            deVar.i(j3);
            deVar.o(j4);
            o(deVar);
        }
    }

    public static void de(BypassConstants$Funnel bypassConstants$Funnel) {
        ad(bypassConstants$Funnel.getName(), System.currentTimeMillis(), 0, 0, 0);
    }

    public static void fe(BypassConstants$Funnel bypassConstants$Funnel, long j) {
        ad(bypassConstants$Funnel.getName(), 0, j, 0, 0);
    }

    public static IBypass i() {
        return ad.qw.qw;
    }

    public static void o(de deVar) {
        if (deVar != null && i() != null) {
            i().qw("funnel_" + deVar.ad() + "_" + uk(deVar.qw()) + "_" + uk(deVar.de()) + "_" + uk(deVar.fe()) + "_" + uk(deVar.rg()));
        }
    }

    public static void qw(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && i() != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Config.k, str2);
                i().ad("initFail", str, jSONObject);
            } catch (JSONException unused) {
            }
        }
    }

    public static void rg(BypassConstants$Funnel bypassConstants$Funnel, long j, long j2) {
        ad(bypassConstants$Funnel.getName(), 0, j, j2, 0);
    }

    public static void th(BypassConstants$Funnel bypassConstants$Funnel, long j) {
        ad(bypassConstants$Funnel.getName(), 0, 0, j, 0);
    }

    public static String uk(long j) {
        SimpleDateFormat simpleDateFormat = f2062ad.get();
        return (simpleDateFormat == null || j <= 0) ? "" : simpleDateFormat.format(Long.valueOf(j));
    }

    public static void yj(BypassConstants$Funnel bypassConstants$Funnel, boolean z, long j, long j2) {
        String str = z ? "Retry" : "First";
        ad(bypassConstants$Funnel.getName() + str, 0, 0, j, j2);
    }

    public qw() {
        this.qw = (IBypass) fe.fe.vvv.ad.ad.ad.qw(IBypass.qw);
    }
}
