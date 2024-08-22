package fe.mmm.qw.tt.ad.vvv;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;

public class qw implements MessageQueue.IdleHandler, Handler.Callback {

    /* renamed from: ad  reason: collision with root package name */
    public final WeakReference<RecyclerView> f8429ad;

    /* renamed from: de  reason: collision with root package name */
    public final int f8430de;
    public final Handler qw = new Handler(this);

    public qw(RecyclerView recyclerView, int i2) {
        this.f8429ad = new WeakReference<>(recyclerView);
        this.f8430de = i2;
        this.qw.sendEmptyMessageDelayed(1024, 1000);
    }

    public boolean handleMessage(@NonNull Message message) {
        if (message.what != 1024) {
            return false;
        }
        fe.mmm.qw.i.qw.ad("OCRBottomBarScrollIdle", "force scroll to position " + System.currentTimeMillis());
        qw();
        return true;
    }

    public boolean queueIdle() {
        fe.mmm.qw.i.qw.ad("OCRBottomBarScrollIdle", "2 >>> " + System.currentTimeMillis());
        qw();
        fe.mmm.qw.i.qw.ad("OCRBottomBarScrollIdle", "3 >>> " + System.currentTimeMillis());
        return false;
    }

    public final void qw() {
        RecyclerView recyclerView = (RecyclerView) this.f8429ad.get();
        if (recyclerView != null) {
            recyclerView.smoothScrollToPosition(this.f8430de);
        }
        this.qw.removeMessages(1024);
        Looper.myQueue().removeIdleHandler(this);
    }
}
