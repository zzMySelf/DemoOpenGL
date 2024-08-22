package fe.th.qw.qw.qw;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.duxiaoman.dxmpay.statistics.StatApi;
import com.duxiaoman.dxmpay.statistics.StrategyProcess;
import com.duxiaoman.dxmpay.statistics.internal.LogSender;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class rg {

    /* renamed from: ad  reason: collision with root package name */
    public static Handler f5585ad;
    public boolean qw;

    public static class ad {
        public static rg qw = new rg((qw) null);
    }

    public class qw extends Handler {
        public qw(rg rgVar, Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i2 = message.what;
            if (10001 == i2) {
                th thVar = (th) message.obj;
                ad.qw().de(StatApi.getAppContext(), thVar.f5591th);
                fe.qw().de(thVar);
            } else if (10003 == i2) {
                fe.qw().uk();
            }
        }
    }

    public /* synthetic */ rg(qw qwVar) {
        this();
    }

    public static rg qw() {
        return ad.qw;
    }

    public void ad(String str, String str2, String str3, String str4, long j) {
        ArrayList arrayList;
        if (str3 != null) {
            arrayList = new ArrayList(1);
            arrayList.add(str3);
        } else {
            arrayList = null;
        }
        de(str, str2, arrayList, (Map<String, Object>) null, str4, j);
    }

    public void de(String str, String str2, Collection<String> collection, Map<String, Object> map, String str3, long j) {
        String str4 = str;
        if (!StrategyProcess.getInstance().isIgnoreToSend(str)) {
            if (!fe() && StrategyProcess.getInstance().needDownloadStrategy()) {
                LogSender.getInstance().qw();
            }
            f5585ad.obtainMessage(10001, th.qw(str, j, str2, yj.qw(), qw.qw(), collection, map, str3)).sendToTarget();
        }
    }

    public boolean fe() {
        if (this.qw) {
            return false;
        }
        this.qw = true;
        f5585ad.sendEmptyMessage(10003);
        LogSender.getInstance().qw();
        return true;
    }

    public rg() {
        this.qw = false;
        f5585ad = new qw(this, de.qw().ad().getLooper());
    }
}
