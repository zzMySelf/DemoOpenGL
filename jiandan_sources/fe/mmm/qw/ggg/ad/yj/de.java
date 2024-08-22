package fe.mmm.qw.ggg.ad.yj;

import com.baidu.ubc.UBCManager;
import com.tera.scan.framework.kernel.architecture.ui.OldBaseActivity;
import fe.mmm.qw.i.qw;
import fe.mmm.qw.yj.th;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class de {

    /* renamed from: ad  reason: collision with root package name */
    public static long f7839ad = 0;
    @NotNull
    public static String qw = "";

    @NotNull
    public static final String ad() {
        if (qw.length() > 0) {
            return qw;
        }
        if (OldBaseActivity.getTopActivity() == null) {
            return "account_sync";
        }
        qw = "frontdesk";
        return "frontdesk";
    }

    public static final void qw(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, UBCManager.CONTENT_KEY_SOURCE);
        qw.ad("BackgroundWeak", "change start source " + str);
        if (!Intrinsics.areEqual((Object) qw, (Object) str)) {
            if (!Intrinsics.areEqual((Object) qw, (Object) "frontdesk") || !ad.o()) {
                boolean areEqual = Intrinsics.areEqual((Object) str, (Object) "frontdesk");
                boolean areEqual2 = Intrinsics.areEqual((Object) str, (Object) "job_schedule");
                long currentTimeMillis = System.currentTimeMillis();
                if (f7839ad == 0) {
                    f7839ad = currentTimeMillis;
                }
                if (currentTimeMillis - f7839ad <= 30000 || areEqual) {
                    if (!(qw.length() > 0) || !areEqual2) {
                        qw = str;
                        th.ppp().m1013switch("key_report_user_start_source", qw);
                    }
                }
            }
        }
    }
}
