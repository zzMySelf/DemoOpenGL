package fe.mmm.qw.k;

import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import fe.mmm.qw.e.rg;
import org.json.JSONObject;

public final class ad {
    public static final void ad() {
        rg.qw("7481", "aiscan", "clk", "Homepage", "MemberIcon_clk", "");
    }

    public static final void de() {
        rg.qw("7481", "aiscan", "display", "Homepage", "MemberIcon", "");
    }

    public static final void fe() {
        String str = fe.mmm.qw.k.fe.ad.qw.qw() ? "Member" : "No_Member";
        JSONObject jSONObject = new JSONObject();
        try {
            ExpectKt.success(jSONObject.put("user", str));
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            ExpectKt.failure(th2);
        }
        rg.ad("7481", "aiscan", "clk", "PCntr", "Banner_clk", "", jSONObject);
    }

    public static final void qw() {
        rg.qw("7487", "aiscan", "clk", "", "Close_clk1", "");
    }

    public static final void rg() {
        String str = fe.mmm.qw.k.fe.ad.qw.qw() ? "Member" : "No_Member";
        JSONObject jSONObject = new JSONObject();
        try {
            ExpectKt.success(jSONObject.put("user", str));
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            ExpectKt.failure(th2);
        }
        rg.ad("7481", "aiscan", "display", "PCntr", "Banner", "", jSONObject);
    }
}
