package com.idlefish.flutterboost;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.idlefish.flutterboost.Messages;
import fe.p036switch.qw.d;
import fe.p036switch.qw.e;
import fe.p036switch.qw.g;
import fe.p036switch.qw.h;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.view.FlutterMain;
import java.util.HashMap;
import java.util.Map;

public class FlutterBoost {

    /* renamed from: ad  reason: collision with root package name */
    public e f6509ad;

    /* renamed from: de  reason: collision with root package name */
    public boolean f6510de;

    /* renamed from: fe  reason: collision with root package name */
    public qw f6511fe;
    public Activity qw;

    public interface Callback {
        void qw(FlutterEngine flutterEngine);
    }

    public static class ad {
        public static final FlutterBoost qw = new FlutterBoost((d) null);
    }

    public class qw implements Application.ActivityLifecycleCallbacks {

        /* renamed from: ad  reason: collision with root package name */
        public int f6512ad = 0;

        /* renamed from: th  reason: collision with root package name */
        public boolean f6513th = false;

        /* renamed from: yj  reason: collision with root package name */
        public boolean f6515yj = false;

        public qw(boolean z) {
            this.f6515yj = z;
        }

        public final void ad() {
            if (!this.f6515yj) {
                FlutterBoost.yj().o(false);
                FlutterBoost.yj().th().b();
            }
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            Activity unused = FlutterBoost.this.qw = activity;
        }

        public void onActivityDestroyed(Activity activity) {
            if (FlutterBoost.this.qw == activity) {
                Activity unused = FlutterBoost.this.qw = null;
            }
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
            Activity unused = FlutterBoost.this.qw = activity;
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            int i2 = this.f6512ad + 1;
            this.f6512ad = i2;
            if (i2 == 1 && !this.f6513th) {
                ad();
            }
        }

        public void onActivityStopped(Activity activity) {
            boolean isChangingConfigurations = activity.isChangingConfigurations();
            this.f6513th = isChangingConfigurations;
            int i2 = this.f6512ad - 1;
            this.f6512ad = i2;
            if (i2 == 0 && !isChangingConfigurations) {
                qw();
            }
        }

        public final void qw() {
            if (!this.f6515yj) {
                FlutterBoost.yj().o(true);
                FlutterBoost.yj().th().mmm();
            }
        }
    }

    public /* synthetic */ FlutterBoost(d dVar) {
        this();
    }

    public static /* synthetic */ void uk(Void voidR) {
    }

    public static FlutterBoost yj() {
        return ad.qw;
    }

    public void de(int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("lifecycleState", Integer.valueOf(i2));
        i("app_lifecycle_changed_key", hashMap);
    }

    public Activity fe() {
        return this.qw;
    }

    public void i(String str, Map<Object, Object> map) {
        Messages.qw qwVar = new Messages.qw();
        qwVar.uk(str);
        qwVar.yj(map);
        th().uk().xxx(qwVar, fe.p036switch.qw.qw.qw);
    }

    /* renamed from: if  reason: not valid java name */
    public final void m672if(Application application, boolean z) {
        qw qwVar = new qw(z);
        this.f6511fe = qwVar;
        application.registerActivityLifecycleCallbacks(qwVar);
    }

    public void o(boolean z) {
    }

    public void pf(Application application, FlutterBoostDelegate flutterBoostDelegate, Callback callback, g gVar) {
        if (gVar == null) {
            gVar = g.qw();
        }
        this.f6510de = gVar.rg();
        FlutterEngine rg2 = rg();
        if (rg2 == null) {
            rg2 = new FlutterEngine(application, gVar.fe());
            FlutterEngineCache.getInstance().put("flutter_boost_default_engine", rg2);
        }
        if (!rg2.getDartExecutor().isExecutingDart()) {
            rg2.getNavigationChannel().setInitialRoute(gVar.de());
            rg2.getDartExecutor().executeDartEntrypoint(new DartExecutor.DartEntrypoint(FlutterMain.findAppBundlePath(), gVar.ad()));
        }
        if (callback != null) {
            callback.qw(rg2);
        }
        th().e(flutterBoostDelegate);
        m672if(application, this.f6510de);
    }

    public FlutterEngine rg() {
        return FlutterEngineCache.getInstance().get("flutter_boost_default_engine");
    }

    /* renamed from: switch  reason: not valid java name */
    public void m673switch(Application application) {
        application.unregisterActivityLifecycleCallbacks(this.f6511fe);
        this.f6511fe = null;
        FlutterEngine rg2 = rg();
        if (rg2 != null) {
            rg2.destroy();
            FlutterEngineCache.getInstance().remove("flutter_boost_default_engine");
        }
        this.qw = null;
        this.f6509ad = null;
        this.f6510de = false;
    }

    public e th() {
        if (this.f6509ad == null) {
            FlutterEngine rg2 = rg();
            if (rg2 != null) {
                this.f6509ad = h.fe(rg2);
            } else {
                throw new RuntimeException("FlutterBoost might *not* have been initialized yet!!!");
            }
        }
        return this.f6509ad;
    }

    public FlutterBoost() {
        this.qw = null;
        this.f6510de = false;
    }
}
