package fe.mmm.qw.e;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.baidu.searchbox.config.AppConfig;
import com.tera.scan.scheduler.executor.task.ThreadPoolExecutor;
import fe.fe.ddd.ad;
import fe.fe.mmm.a;
import fe.fe.mmm.b;
import fe.mmm.qw.a.uk.rg;

public class de {
    public static boolean qw = false;

    public class qw extends rg {
        public final /* synthetic */ Context xxx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public qw(String str, Context context) {
            super(str);
            this.xxx = context;
        }

        public void when() throws Exception {
            fe.fe.ddd.when.qw.de.de(this.xxx);
        }
    }

    static {
        try {
            System.loadLibrary("c++_shared");
        } catch (Exception unused) {
        }
    }

    public static void ad(Context context) {
        String str = Build.MODEL;
        if ("Phytium Android Prototype" != str && "Kmre" != str && "AOSP on PC" != str) {
            if ("MI PAD 2" != str || Build.VERSION.SDK_INT != 22) {
                if (fe.fe.ddd.when.qw.de.th(fe.fe.vvv.ad.qw.qw.ad())) {
                    fe.fe.ddd.when.qw.de.rg();
                    return;
                }
                fe.mmm.qw.i.qw.ad("UBCApplication", "initLoki");
                fe.fe.ddd.when.qw.de.qw(context);
                fe.fe.ddd.when.qw.de.i();
                new qw("initLokiNative", context).mmm();
            }
        }
    }

    public static void de(Context context) {
        fe.mmm.qw.i.qw.ad("UBCApplication", "initRuka");
        fe.fe.ddd.nn.de.de(context);
        fe.fe.ddd.nn.de.fe(context);
    }

    public static void fe(Application application) {
        b.qw(application);
        AppConfig.de(false, false, qw, false);
        ad.ad();
        ad.qw();
    }

    public static void i(String str) {
    }

    public static void qw() {
        fe.fe.ddd.yj.qw.ad().uk("0");
    }

    public static void rg() {
        if (fe.fe.vvv.ad.qw.qw.yj()) {
            a.qw();
        }
        fe.fe.yj.ad.qw.ad().de(qw.f7756ad);
        fe.fe.ddd.ddd.qw.qw.fe().rg();
        try {
            ((ThreadPoolExecutor) fe.fe.ddd.p000if.ad.qw().ad()).rg(true);
        } catch (Exception unused) {
        }
    }

    public static void th(String str) {
    }

    public static void uk(boolean z) {
        qw = z;
    }

    public static void yj(boolean z) {
    }
}
