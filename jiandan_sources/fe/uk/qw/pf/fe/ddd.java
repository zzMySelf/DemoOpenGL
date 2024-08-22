package fe.uk.qw.pf.fe;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.dxmbumptech.glide.load.engine.Resource;

public class ddd {

    /* renamed from: ad  reason: collision with root package name */
    public final Handler f5748ad = new Handler(Looper.getMainLooper(), new qw());
    public boolean qw;

    public static final class qw implements Handler.Callback {
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((Resource) message.obj).recycle();
            return true;
        }
    }

    public synchronized void qw(Resource<?> resource, boolean z) {
        if (!this.qw) {
            if (!z) {
                this.qw = true;
                resource.recycle();
                this.qw = false;
            }
        }
        this.f5748ad.obtainMessage(1, resource).sendToTarget();
    }
}
