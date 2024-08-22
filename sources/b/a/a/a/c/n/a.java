package b.a.a.a.c.n;

import android.os.Handler;
import android.os.Message;
import com.baidu.platform.comapi.wnplatform.model.datastruct.WLocData;

/* compiled from: WTrackManager */
class a extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f1349a;

    a(b bVar) {
        this.f1349a = bVar;
    }

    public void handleMessage(Message message) {
        if (message.what == 1) {
            WLocData wLocData = (WLocData) message.obj;
            if (this.f1349a.f1358i != null) {
                this.f1349a.f1358i.a(wLocData);
            }
        }
    }
}
