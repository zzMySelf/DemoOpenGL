package fe.fe.ddd.when.qw.rg;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.aperf.param.CommonUtils;
import com.baidu.searchbox.logsystem.javacrash.ProcessExceptionListener;
import com.baidu.searchbox.logsystem.logsys.LogExtra;
import com.baidu.searchbox.logsystem.logsys.LogType;
import com.baidu.searchbox.logsystem.logsys.eventscene.snapshot.ProcessSnapshotType;
import com.baidu.searchbox.track.Track;
import fe.fe.ddd.mmm.qw.uk;
import fe.fe.ddd.when.fe.i.ad.fe;
import fe.fe.ddd.when.fe.th;
import fe.fe.ddd.when.yj.ad;
import fe.fe.ddd.when.yj.de;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

public abstract class qw extends fe.fe.ddd.when.de.qw {

    /* renamed from: de  reason: collision with root package name */
    public final String f1704de;

    /* renamed from: fe  reason: collision with root package name */
    public final Context f1705fe;

    /* renamed from: rg  reason: collision with root package name */
    public long f1706rg = System.currentTimeMillis();

    public qw(@NonNull Context context, @Nullable List<ProcessExceptionListener> list) {
        super(list);
        Context applicationContext = context.getApplicationContext();
        this.f1705fe = applicationContext != null ? applicationContext : context;
        this.f1704de = fe.fe.vvv.ad.qw.qw.ad();
    }

    public final LogExtra ad(@NonNull Thread thread) {
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
        logExtra.mLaunchTime = String.valueOf(this.f1706rg);
        if (DeviceUtil.OSInfo.hasNougat()) {
            logExtra.mProcessLifeTime = String.valueOf(SystemClock.elapsedRealtime() - de.fe());
        }
        logExtra.mCrashThreadName = thread.getName();
        logExtra.mCrashThreadPriority = String.valueOf(thread.getPriority());
        logExtra.mForeground = String.valueOf(Track.fe().yj());
        logExtra.mTraceID = fe.fe.ddd.fe.de.qw.qw();
        logExtra.mHeapMem = CommonUtils.rg();
        logExtra.mVSSRSS = CommonUtils.xxx();
        logExtra.mPSS = CommonUtils.pf();
        logExtra.mSysMem = CommonUtils.vvv();
        logExtra.mSysLowMem = CommonUtils.nn() ^ true ? 1 : 0;
        return logExtra;
    }

    public abstract fe de();

    public void fe(@NonNull Context context, @NonNull JSONObject jSONObject) {
    }

    public void qw(@NonNull Thread thread, @NonNull Throwable th2) {
        HashSet hashSet;
        Set<fe.fe.ddd.when.fe.fe> th3;
        File o2 = th.o(this.f1704de);
        if (!o2.exists()) {
            o2.mkdirs();
        }
        LogExtra ad2 = ad(thread);
        JSONObject jSONObject = new JSONObject();
        fe(this.f1705fe, jSONObject);
        ad2.mJSONAttach = jSONObject.toString();
        String sb = new StringBuilder(Log.getStackTraceString(th2)).toString();
        fe de2 = de();
        File file = null;
        if (de2 != null) {
            hashSet = new HashSet(5);
            fe.fe.ddd.when.fe.i.qw qwVar = new fe.fe.ddd.when.fe.i.qw(LogType.JAVA_CRASH, sb);
            Set<ProcessSnapshotType> ad3 = de2.ad(this.f1705fe, qwVar);
            if (ad3 != null && ad3.size() > 0 && (th3 = fe.fe.ddd.when.qw.uk.qw.th(this.f1705fe, ad3, o2, this.f1704de, ad2)) != null && th3.size() > 0) {
                hashSet.addAll(th3);
            }
            Set<fe.fe.ddd.when.fe.fe> qw = de2.qw(this.f1705fe, o2, qwVar);
            if (qw != null && qw.size() > 0) {
                hashSet.addAll(qw);
            }
            fe.fe.ddd.when.fe.fe rg2 = fe.fe.ddd.when.qw.uk.qw.rg(this.f1705fe, de2, qwVar, o2, "pre_p_fragment_data");
            if (rg2 != null && rg2.qw.exists()) {
                hashSet.add(rg2);
            }
            if (ad.qw && hashSet.size() > 0) {
                "uploadLogFiles.size() = " + hashSet.size();
                for (int i2 = 0; i2 < hashSet.size(); i2++) {
                }
            }
        } else {
            hashSet = null;
        }
        rg(this.f1705fe);
        if (hashSet != null) {
            file = fe.fe.ddd.when.qw.uk.qw.qw(o2, hashSet);
            if (ad.qw && file != null) {
                "pathNameKeeper = " + file.getAbsolutePath();
            }
        }
        th(this.f1705fe, sb, file, ad2);
    }

    public void rg(@NonNull Context context) {
    }

    public abstract void th(@NonNull Context context, @NonNull String str, @Nullable File file, @Nullable LogExtra logExtra);
}
