package fe.fe.o.qw;

import android.os.SystemClock;
import com.baidu.down.a.e;
import fe.fe.o.rg.de.th;
import java.util.Timer;
import java.util.TimerTask;

public class de extends TimerTask {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ e f2579ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ long f2580th;

    /* renamed from: yj  reason: collision with root package name */
    public final /* synthetic */ ad f2581yj;

    public de(ad adVar, e eVar, long j) {
        this.f2581yj = adVar;
        this.f2579ad = eVar;
        this.f2580th = j;
    }

    public void run() {
        if (this.f2581yj.f2578ad != null) {
            Timer unused = this.f2581yj.f2578ad = null;
            e eVar = this.f2579ad;
            if (eVar != null) {
                eVar.qw(false, (th) null, 2);
            }
            long unused2 = this.f2581yj.qw = SystemClock.elapsedRealtime() - this.f2580th;
        }
    }
}
