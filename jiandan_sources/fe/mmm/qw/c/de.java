package fe.mmm.qw.c;

import android.os.Process;
import androidx.core.os.TraceCompat;
import com.tera.scan.startup.StartupTaskListener;
import fe.mmm.qw.i.qw;

public class de implements StartupTaskListener {
    public void ad(th thVar) {
        qw.ad("NetdiskAppStartup 任务 START", "【" + Thread.currentThread().getName() + "】" + thVar.o());
        TraceCompat.beginSection(thVar.o());
        if (thVar.ppp()) {
            Process.setThreadPriority(-19);
        }
    }

    public void de(th thVar) {
    }

    public void qw(th thVar, long j, long j2) {
        if (thVar.ppp()) {
            Process.setThreadPriority(9);
        }
        TraceCompat.endSection();
        qw.ad("NetdiskAppStartup 任务 END", "【" + Thread.currentThread().getName() + "】" + thVar.o() + " 任务等待耗时:" + j + "，任务执行耗时:" + j2);
    }
}
