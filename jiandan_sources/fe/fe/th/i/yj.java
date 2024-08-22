package fe.fe.th.i;

import android.os.Process;
import com.baidu.clientupdate.download.Download;

public class yj implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ Download f3119ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ uk f3120th;

    public yj(uk ukVar, Download download) {
        this.f3120th = ukVar;
        this.f3119ad = download;
    }

    public void run() {
        Process.setThreadPriority(10);
        long unused = this.f3120th.e(this.f3119ad);
    }
}
