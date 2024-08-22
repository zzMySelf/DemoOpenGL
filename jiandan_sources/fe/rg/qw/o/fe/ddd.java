package fe.rg.qw.o.fe;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bumptech.glide.load.engine.Resource;
import fe.rg.qw.ggg.i;

public class ddd {

    /* renamed from: ad  reason: collision with root package name */
    public final Handler f4781ad = new Handler(Looper.getMainLooper(), new qw());
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

    public void qw(Resource<?> resource) {
        i.qw();
        if (this.qw) {
            this.f4781ad.obtainMessage(1, resource).sendToTarget();
            return;
        }
        this.qw = true;
        resource.recycle();
        this.qw = false;
    }
}
