package fe.fe.nn.rg;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

public class o {

    /* renamed from: de  reason: collision with root package name */
    public static volatile o f2328de;

    /* renamed from: ad  reason: collision with root package name */
    public Handler f2329ad = null;
    public HandlerThread qw;

    public class qw extends Handler {
        public qw(o oVar, Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            yj yjVar = new yj();
            yjVar.qw = message.arg2;
            int i2 = message.arg1;
            if (i2 == -1) {
                i2 = uk.pf().qw();
            }
            uk.pf().fe(message.what, 3, 2019, i2, "out time.", yjVar, true);
        }
    }

    public o() {
        HandlerThread handlerThread = new HandlerThread("callback-handler");
        this.qw = handlerThread;
        handlerThread.start();
        this.f2329ad = new qw(this, this.qw.getLooper());
    }

    public static o qw() {
        if (f2328de == null) {
            synchronized (o.class) {
                if (f2328de == null) {
                    f2328de = new o();
                }
            }
        }
        return f2328de;
    }

    public void ad(int i2) {
        this.f2329ad.removeMessages(i2);
    }

    public void de(Message message, long j) {
        this.f2329ad.sendMessageDelayed(message, j);
    }
}
