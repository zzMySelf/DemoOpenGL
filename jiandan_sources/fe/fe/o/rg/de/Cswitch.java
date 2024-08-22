package fe.fe.o.rg.de;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.PointerIconCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.baidu.down.loopj.android.http.n;
import fe.fe.o.rg.ad.qw;

/* renamed from: fe.fe.o.rg.de.switch  reason: invalid class name */
public class Cswitch extends Handler {
    public final /* synthetic */ qw qw;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Cswitch(qw qwVar, Looper looper) {
        super(looper);
        this.qw = qwVar;
    }

    public void handleMessage(Message message) {
        try {
            if (message.what != 0) {
                if (message.what == 1) {
                    if (this.qw.f2639th.size() == 0 && this.qw.f2638rg.size() == 0) {
                        this.qw.f2636o.fe();
                        return;
                    }
                    return;
                } else if (message.what == 2) {
                    n nVar = this.qw.f2632ad.m163if();
                    this.qw.f2632ad.ppp();
                    n nVar2 = this.qw.f2632ad.m163if();
                    if (nVar == n.TYPE_UNKNOWN && nVar2 != n.TYPE_UNKNOWN && this.qw.f2639th.size() > 0) {
                        this.qw.f83if.removeMessages(5);
                        this.qw.f83if.sendEmptyMessageDelayed(5, ItemTouchHelper.Callback.DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS);
                    } else if (nVar2 == n.TYPE_UNKNOWN) {
                        this.qw.f83if.removeMessages(5);
                    }
                    th unused = this.qw.ppp = null;
                    this.qw.o();
                    return;
                } else if (message.what == 3) {
                    qw qwVar = (qw) message.obj;
                    if (qwVar.when == 1009) {
                        this.qw.f2638rg.offer(qwVar);
                    } else {
                        return;
                    }
                } else if (message.what == 4) {
                    for (qw qwVar2 : this.qw.f2634fe.values()) {
                        if (qwVar2.when != 1009) {
                            qwVar2.when = PointerIconCompat.TYPE_VERTICAL_TEXT;
                            this.qw.f2638rg.add(qwVar2);
                        }
                    }
                } else if (message.what == 5) {
                    for (qw qwVar3 : this.qw.f2639th) {
                        this.qw.f2632ad.de(qwVar3.C);
                    }
                    return;
                } else if (message.what == 6) {
                    ((uk) message.obj).qw();
                    return;
                } else if (message.what == 7) {
                    ((uk) message.obj).ad();
                    return;
                } else if (message.what == 8) {
                    ((uk) message.obj).de();
                    return;
                } else {
                    return;
                }
            }
            this.qw.m175if();
        } catch (Exception unused2) {
        }
    }
}
