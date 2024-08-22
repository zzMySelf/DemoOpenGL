package fe.fe.ddd.when.qw.th;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.track.Track;
import fe.fe.ddd.mmm.qw.uk;
import fe.fe.ddd.when.fe.th;
import fe.fe.ddd.when.yj.de;
import java.io.File;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public static File f1707ad = null;

    /* renamed from: de  reason: collision with root package name */
    public static ThreadPoolExecutor f1708de = new ThreadPoolExecutor(1, 1, 5, TimeUnit.MINUTES, new LinkedBlockingQueue());

    /* renamed from: fe  reason: collision with root package name */
    public static Track.OnTrackUIListener f1709fe = new C0092qw();
    public static boolean qw = true;

    /* renamed from: fe.fe.ddd.when.qw.th.qw$qw  reason: collision with other inner class name */
    public static class C0092qw implements Track.OnTrackUIListener {

        /* renamed from: fe.fe.ddd.when.qw.th.qw$qw$qw  reason: collision with other inner class name */
        public class C0093qw implements Runnable {

            /* renamed from: ad  reason: collision with root package name */
            public final /* synthetic */ uk f1710ad;

            public C0093qw(C0092qw qwVar, uk ukVar) {
                this.f1710ad = ukVar;
            }

            public void run() {
                qw.rg(this.f1710ad);
            }
        }

        public void qw(uk ukVar) {
            qw.f1708de.execute(new C0093qw(this, ukVar));
        }
    }

    public static File ad() {
        File file = new File(th.ad().de().get(), "tracedir");
        if (!file.exists()) {
            file.mkdirs();
        }
        if (f1707ad == null) {
            f1707ad = new File(file, fe.fe.vvv.ad.qw.qw.ad() + ".tmp");
        }
        return f1707ad;
    }

    public static Track.OnTrackUIListener de() {
        return f1709fe;
    }

    public static boolean fe(@NonNull File file) {
        File ad2 = ad();
        if (ad2 == null || !ad2.exists() || FileUtils.copyFile(ad2, file) <= 0) {
            return false;
        }
        return true;
    }

    public static void rg(uk ukVar) {
        LinkedList<uk> de2;
        File ad2 = ad();
        if (qw) {
            qw = false;
            if (de.qw(ad2) && (de2 = Track.fe().de()) != null && de2.size() > 0) {
                for (int i2 = 0; i2 < de2.size(); i2++) {
                    uk ukVar2 = de2.get(i2);
                    if (ukVar2 != ukVar) {
                        if (AppConfig.rg()) {
                            "perTrack = " + th(ukVar2);
                        }
                        FileUtils.saveToFile(th(ukVar2) + 10, ad2, true);
                    }
                }
            }
        }
        if (AppConfig.rg()) {
            "uitrackStr = " + th(ukVar);
        }
        FileUtils.saveToFile(th(ukVar) + 10, ad2, true);
    }

    @NonNull
    public static String th(@NonNull uk ukVar) {
        StringBuilder sb = new StringBuilder(uk.th(ukVar.yj()));
        sb.append("\t");
        sb.append(ukVar.yj());
        sb.append("\t");
        sb.append(ukVar.qw());
        sb.append(ukVar.ad());
        if (!TextUtils.isEmpty(ukVar.fe())) {
            sb.append("->");
            sb.append(ukVar.fe());
            if (!TextUtils.isEmpty(ukVar.rg())) {
                sb.append(ukVar.rg());
            }
        }
        sb.append("\t");
        sb.append(ukVar.de());
        return sb.toString();
    }
}
