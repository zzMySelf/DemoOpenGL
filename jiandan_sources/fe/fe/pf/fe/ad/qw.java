package fe.fe.pf.fe.ad;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserModel;
import com.baidu.helios.bridge.BaseBridge;
import fe.fe.pf.yj.fe.de.de;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class qw extends BaseBridge {

    /* renamed from: de  reason: collision with root package name */
    public BaseBridge f2725de;

    /* renamed from: fe  reason: collision with root package name */
    public boolean f2726fe;

    public qw(boolean z) {
        this.f2726fe = z;
    }

    public void fe() {
        this.f2725de.fe();
    }

    public final boolean i() {
        String uk2 = uk();
        return uk2 != null && uk2.contains(":helios");
    }

    public final boolean o() {
        String uk2 = uk();
        if (uk2 == null) {
            return true;
        }
        Context context = this.qw.f781de;
        String str = context.getApplicationInfo().processName;
        if (TextUtils.isEmpty(str)) {
            str = context.getPackageName();
        }
        if (uk2.startsWith(str)) {
            return uk2.length() == str.length() || uk2.charAt(str.length()) != ':';
        }
        return false;
    }

    public void qw(String str, Bundle bundle, BaseBridge.OnGetResultCallback<String> onGetResultCallback) {
        this.f2725de.qw(str, bundle, onGetResultCallback);
    }

    public boolean rg(String str) {
        return this.f2725de.rg(str);
    }

    public void th(BaseBridge.ad adVar) {
        BaseBridge baseBridge;
        if (this.f2726fe ? o() : i()) {
            baseBridge = new fe.fe.pf.fe.qw.qw();
        } else {
            baseBridge = new ad(this.f2726fe ? ".helios.ipc.default" : ".helios.ipc.isolate");
        }
        this.f2725de = baseBridge;
        baseBridge.ad(this.qw);
        this.f2725de.de(adVar);
    }

    public final String uk() {
        BufferedReader bufferedReader;
        Throwable th2;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File("/proc/self/cmdline")));
            try {
                String readLine = bufferedReader.readLine();
                if (!TextUtils.isEmpty(readLine)) {
                    de.ad(bufferedReader);
                    return readLine;
                }
            } catch (IOException unused) {
            } catch (Throwable th3) {
                th2 = th3;
                de.ad(bufferedReader);
                throw th2;
            }
        } catch (IOException unused2) {
            bufferedReader = null;
        } catch (Throwable th4) {
            Throwable th5 = th4;
            bufferedReader = null;
            th2 = th5;
            de.ad(bufferedReader);
            throw th2;
        }
        de.ad(bufferedReader);
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.qw.f781de.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.pid == Process.myPid()) {
                return next.processName;
            }
        }
        return null;
    }

    public BaseBridge.de yj(String str, Bundle bundle) {
        return this.f2725de.yj(str, bundle);
    }
}
