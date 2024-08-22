package fe.mmm.qw.p024if.p026switch;

import android.app.Activity;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoostDelegate;
import com.tera.scan.framework.kernel.architecture.ui.OldBaseActivity;
import fe.mmm.qw.p024if.when.qw;
import fe.p036switch.qw.f;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fe.mmm.qw.if.switch.ad  reason: invalid package */
public class ad implements FlutterBoostDelegate {
    @NotNull
    public final String qw = "request_code";

    public void ad(@NotNull f fVar) {
        Activity fe2;
        Intrinsics.checkNotNullParameter(fVar, "flutterBoostRouteOptions");
        if (!de(fVar) && (fe2 = fe()) != null) {
            Map<String, Object> qw2 = fVar.qw();
            Integer num = null;
            Object remove = qw2 != null ? qw2.remove(this.qw) : null;
            if (remove instanceof Integer) {
                num = (Integer) remove;
            }
            String ad2 = fVar.ad();
            Intrinsics.checkNotNullExpressionValue(ad2, "flutterBoostRouteOptions.pageName()");
            qw.ad(fe2, num, ad2, new HashMap(fVar.qw()));
            Boolean bool = (Boolean) qw2.get("animated");
            if (bool != null && !bool.booleanValue()) {
                fe2.overridePendingTransition(0, 0);
            }
        }
    }

    public final boolean de(f fVar) {
        return de.qw().ad(fe(), fVar.ad(), fVar.qw(), fVar.de());
    }

    @Nullable
    public final Activity fe() {
        Activity fe2 = FlutterBoost.yj().fe();
        return fe2 == null ? OldBaseActivity.getTopActivity() : fe2;
    }

    public void qw(@NotNull f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "flutterBoostRouteOptions");
        de(fVar);
    }
}
