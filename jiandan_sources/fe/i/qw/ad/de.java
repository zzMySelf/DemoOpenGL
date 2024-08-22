package fe.i.qw.ad;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.eventbus.EventBusException;

public final class de extends Handler {

    /* renamed from: ad  reason: collision with root package name */
    public final int f4468ad;

    /* renamed from: de  reason: collision with root package name */
    public final ad f4469de;

    /* renamed from: fe  reason: collision with root package name */
    public boolean f4470fe;
    public final rg qw = new rg();

    public de(ad adVar, Looper looper, int i2) {
        super(looper);
        this.f4469de = adVar;
        this.f4468ad = i2;
    }

    public void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                fe qw2 = this.qw.qw();
                if (qw2 == null) {
                    synchronized (this) {
                        qw2 = this.qw.qw();
                        if (qw2 == null) {
                            this.f4470fe = false;
                            this.f4470fe = false;
                            return;
                        }
                    }
                }
                this.f4469de.fe(qw2);
            } while (SystemClock.uptimeMillis() - uptimeMillis < ((long) this.f4468ad));
            if (sendMessage(obtainMessage())) {
                this.f4470fe = true;
                return;
            }
            throw new EventBusException("Could not send handler message");
        } catch (Throwable th2) {
            this.f4470fe = false;
            throw th2;
        }
    }

    public void qw(yj yjVar, EventBus.Event event) {
        fe qw2 = fe.qw(yjVar, event);
        synchronized (this) {
            this.qw.ad(qw2);
            if (!this.f4470fe) {
                this.f4470fe = true;
                if (!sendMessage(obtainMessage())) {
                    throw new EventBusException("Could not send handler message");
                }
            }
        }
    }
}
