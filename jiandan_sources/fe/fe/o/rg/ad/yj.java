package fe.fe.o.rg.ad;

import android.os.SystemClock;
import com.baidu.down.request.taskmanager.OnFetchDataRequestListener;
import fe.fe.o.fe.qw.de.Cswitch;
import fe.fe.o.fe.qw.de.o;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeSet;

public class yj extends TimerTask {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ OnFetchDataRequestListener f2609ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ long f2610th;

    /* renamed from: yj  reason: collision with root package name */
    public final /* synthetic */ rg f2611yj;

    public yj(rg rgVar, OnFetchDataRequestListener onFetchDataRequestListener, long j) {
        this.f2611yj = rgVar;
        this.f2609ad = onFetchDataRequestListener;
        this.f2610th = j;
    }

    public void run() {
        if (this.f2611yj.L != null) {
            Timer unused = this.f2611yj.L = null;
            OnFetchDataRequestListener onFetchDataRequestListener = this.f2609ad;
            if (onFetchDataRequestListener != null) {
                onFetchDataRequestListener.qw(false, (TreeSet) null);
            }
            long unused2 = this.f2611yj.I = SystemClock.elapsedRealtime() - this.f2610th;
            rg rgVar = this.f2611yj;
            o oVar = rgVar.f2601i;
            ((Cswitch) oVar).f80switch.f2449th = 2;
            ((Cswitch) oVar).f80switch.f2451yj = rgVar.I;
        }
    }
}
