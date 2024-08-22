package fe.mmm.qw.p024if;

import android.app.Application;
import com.idlefish.flutterboost.FlutterBoost;
import com.mars.kotlin.extension.LoggerKt;
import fe.mmm.qw.p024if.p026switch.de;
import fe.mmm.qw.p024if.p026switch.qw;
import fe.p036switch.qw.g;
import io.flutter.embedding.engine.FlutterEngine;

/* renamed from: fe.mmm.qw.if.ad  reason: invalid package */
public class ad {
    public static void ad(Application application) {
        if (FlutterBoost.yj().rg() == null) {
            de.qw().de("globalPageHandler", new qw());
            long currentTimeMillis = System.currentTimeMillis();
            try {
                FlutterBoost.yj().pf(application, new fe.mmm.qw.p024if.p026switch.ad(), new qw(currentTimeMillis), g.qw());
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
    }

    public static /* synthetic */ void de(long j, FlutterEngine flutterEngine) {
        long currentTimeMillis = System.currentTimeMillis();
        LoggerKt.d("time spend:" + (currentTimeMillis - j), "flutter_engine_init");
    }

    public static void qw(Application application) {
        FlutterBoost.yj().m673switch(application);
    }
}
