package fe.fe.ddd.when.qw;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.disasterrecovery.jnicrash.NativeCrashCapture;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.aop.annotation.TimeSpendTrace;
import com.baidu.searchbox.logsystem.basic.LokiService;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.searchbox.track.Track;
import fe.fe.ddd.when.qw.rg.ad;
import fe.fe.vvv.ad.qw.qw;

public class de {

    /* renamed from: ad  reason: collision with root package name */
    public static volatile boolean f1689ad = false;
    public static volatile boolean qw = false;

    @TimeSpendTrace(tag = "AppInit")
    @DebugTrace
    public static void ad(@NonNull Context context, @NonNull ad adVar) {
        if (!th(qw.ad())) {
            uk(context);
            if (!qw && adVar != null) {
                qw = true;
                Thread.setDefaultUncaughtExceptionHandler(adVar);
            }
        }
    }

    public static void de(@NonNull Context context) {
        fe(context, true);
    }

    public static void fe(@NonNull Context context, boolean z) {
        if (!th(qw.ad())) {
            NativeCrashCapture.init(context, new fe.fe.i.qw.ad(context), z);
        }
    }

    public static void i() {
        if (!f1689ad) {
            f1689ad = true;
            Track.fe().ad(fe.fe.ddd.when.qw.th.qw.de());
            Track.fe().uk(fe.fe.ddd.i.qw.qw.qw());
        }
    }

    public static void qw(@NonNull Context context) {
        ad(context, new ad(context));
        i();
    }

    public static void rg() {
        if (th(qw.ad())) {
            LokiService.mProcessor = new qw();
        }
    }

    public static boolean th(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.endsWith(LokiService.LOG_SYSTEM_SERVICE);
        }
        return false;
    }

    public static void uk(Context context) {
        if (qw.th() && LogSystemUploaderStrategy.o()) {
            ad.ad(context);
        }
    }

    public static boolean yj() {
        return qw;
    }
}
