package fe.p013if.de.qw.uk;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import androidx.appcompat.widget.ActivityChooserModel;
import java.util.List;

/* renamed from: fe.if.de.qw.uk.de  reason: invalid package */
public class de {

    /* renamed from: ad  reason: collision with root package name */
    public static final Object f4613ad = new Object();
    public static volatile String qw;

    public static String ad(Context context) {
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getRunningAppProcesses();
        if (runningAppProcesses == null || runningAppProcesses.isEmpty()) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next != null && next.pid == myPid) {
                return next.processName;
            }
        }
        return null;
    }

    public static String qw() {
        if (qw != null) {
            return qw;
        }
        synchronized (f4613ad) {
            if (qw != null) {
                String str = qw;
                return str;
            }
            qw = ad(fe.p013if.de.qw.de.fe().th());
            String str2 = qw;
            return str2;
        }
    }
}
