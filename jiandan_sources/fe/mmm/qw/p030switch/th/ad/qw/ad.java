package fe.mmm.qw.p030switch.th.ad.qw;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* renamed from: fe.mmm.qw.switch.th.ad.qw.ad  reason: invalid package */
public abstract class ad<T> extends Handler {
    public WeakReference<T> qw;

    public ad(T t, Looper looper) {
        super(looper);
        this.qw = new WeakReference<>(t);
    }

    public final void handleMessage(Message message) {
        Object obj = this.qw.get();
        if (obj != null) {
            qw(obj, message);
        }
    }

    public abstract void qw(T t, Message message);
}
