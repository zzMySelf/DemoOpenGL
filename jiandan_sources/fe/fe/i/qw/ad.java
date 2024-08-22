package fe.fe.i.qw;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.java.Supplier;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.aperf.param.CommonUtils;
import com.baidu.searchbox.logsystem.basic.LokiService;
import com.baidu.searchbox.logsystem.logsys.LogExtra;
import com.baidu.searchbox.logsystem.logsys.LogType;
import com.baidu.searchbox.logsystem.logsys.eventscene.snapshot.ProcessSnapshotType;
import com.baidu.searchbox.track.Track;
import fe.fe.ddd.mmm.qw.uk;
import fe.fe.ddd.when.fe.i.ad.fe;
import fe.fe.ddd.when.fe.i.ad.rg;
import fe.fe.ddd.when.fe.th;
import fe.fe.ddd.when.yj.de;
import fe.fe.vvv.ad.qw.qw;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

public class ad {

    /* renamed from: ad  reason: collision with root package name */
    public String f1903ad;

    /* renamed from: de  reason: collision with root package name */
    public Context f1904de;

    /* renamed from: fe  reason: collision with root package name */
    public long f1905fe;
    public Supplier<List<rg>> qw;

    public ad(@NonNull Context context) {
        if (context instanceof Application) {
            this.f1904de = context;
        } else {
            this.f1904de = context.getApplicationContext();
        }
        this.f1903ad = qw.ad();
        this.f1905fe = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT <= 19) {
            de();
        }
    }

    @NonNull
    public final fe ad() {
        fe feVar = new fe();
        if (Build.VERSION.SDK_INT > 19) {
            feVar.fe(new fe.fe.ddd.when.qw.fe.ad());
        }
        Supplier<List<rg>> supplier = this.qw;
        if (supplier != null && Build.VERSION.SDK_INT > 19) {
            feVar.rg(supplier.get());
        }
        return feVar;
    }

    public final void de() {
        fe.fe.ddd.when.qw.fe.ad.fe();
        LogType.init();
        fe.fe.ddd.when.qw.uk.qw.ad();
        fe.fe.ddd.when.fe.fe.qw();
        ProcessSnapshotType.init();
        de.rg();
        th.yj();
        LokiService.init();
        LogExtra.init();
        fe.fe.ddd.when.fe.de.ad();
        fe.fe.ddd.when.fe.qw.ad();
        fe.fe.ddd.when.qw.ad.qw();
    }

    public void fe(@NonNull Context context, @NonNull JSONObject jSONObject) {
    }

    public final void i(@NonNull String str, @NonNull LogExtra logExtra) {
        HashSet hashSet;
        Set<fe.fe.ddd.when.fe.fe> th2;
        File o2 = th.o(this.f1903ad);
        if (!o2.exists()) {
            o2.mkdirs();
        }
        JSONObject jSONObject = new JSONObject();
        fe(this.f1904de, jSONObject);
        logExtra.mJSONAttach = jSONObject.toString();
        fe ad2 = ad();
        File file = null;
        if (ad2 != null) {
            hashSet = new HashSet(5);
            fe.fe.ddd.when.fe.i.qw qwVar = new fe.fe.ddd.when.fe.i.qw(LogType.NATIVE_CRASH, str);
            Set<ProcessSnapshotType> ad3 = ad2.ad(this.f1904de, qwVar);
            if (ad3 != null && ad3.size() > 0 && (th2 = fe.fe.ddd.when.qw.uk.qw.th(this.f1904de, ad3, o2, this.f1903ad, logExtra)) != null && th2.size() > 0) {
                hashSet.addAll(th2);
            }
            Set<fe.fe.ddd.when.fe.fe> qw2 = ad2.qw(this.f1904de, o2, qwVar);
            if (qw2 != null && qw2.size() > 0) {
                hashSet.addAll(qw2);
            }
            fe.fe.ddd.when.fe.fe rg2 = fe.fe.ddd.when.qw.uk.qw.rg(this.f1904de, ad2, qwVar, o2, "pre_p_fragment_data");
            if (rg2 != null && rg2.qw.exists()) {
                hashSet.add(rg2);
            }
            if (fe.fe.ddd.when.yj.ad.qw && hashSet.size() > 0) {
                "uploadLogFiles.size() = " + hashSet.size();
                for (int i2 = 0; i2 < hashSet.size(); i2++) {
                }
            }
        } else {
            hashSet = null;
        }
        th(this.f1904de);
        if (hashSet != null) {
            file = fe.fe.ddd.when.qw.uk.qw.qw(o2, hashSet);
            if (fe.fe.ddd.when.yj.ad.qw && file != null) {
                "pathNameKeeper = " + file.getAbsolutePath();
            }
        }
        uk(this.f1904de, str, file, logExtra);
    }

    public void o(@NonNull String str, int i2, int i3) {
        try {
            i(str, qw());
        } catch (Throwable th2) {
            if (fe.fe.ddd.when.yj.ad.qw) {
                th2.printStackTrace();
            }
        }
    }

    public final LogExtra qw() {
        LogExtra logExtra = new LogExtra();
        uk rg2 = Track.fe().rg();
        if (rg2 != null) {
            if (!TextUtils.isEmpty(rg2.fe())) {
                logExtra.mPage = rg2.fe();
            } else {
                logExtra.mPage = rg2.qw();
            }
        }
        logExtra.mCrashTime = String.valueOf(System.currentTimeMillis());
        logExtra.mLaunchTime = String.valueOf(this.f1905fe);
        if (DeviceUtil.OSInfo.hasNougat()) {
            logExtra.mProcessLifeTime = String.valueOf(SystemClock.elapsedRealtime() - de.fe());
        }
        logExtra.mForeground = String.valueOf(Track.fe().yj());
        logExtra.mTraceID = fe.fe.ddd.fe.de.qw.qw();
        logExtra.mHeapMem = CommonUtils.rg();
        logExtra.mVSSRSS = CommonUtils.xxx();
        logExtra.mPSS = CommonUtils.pf();
        logExtra.mSysMem = CommonUtils.vvv();
        logExtra.mSysLowMem = CommonUtils.nn() ^ true ? 1 : 0;
        return logExtra;
    }

    public void rg() {
    }

    public void th(@NonNull Context context) {
    }

    public void uk(@NonNull Context context, @NonNull String str, @Nullable File file, @Nullable LogExtra logExtra) {
        fe.fe.ddd.when.qw.ad.fe(context, LogType.NATIVE_CRASH, str, file, logExtra);
    }

    public void yj(@NonNull String str, @NonNull String str2) {
    }
}
