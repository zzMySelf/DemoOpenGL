package fe.fe.nn.vvv;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.baidu.sso.p.b;
import com.baidu.sso.q.c;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public c f2405ad;

    /* renamed from: de  reason: collision with root package name */
    public ServiceConnection f2406de;

    /* renamed from: fe  reason: collision with root package name */
    public b f2407fe;
    public Context qw = null;

    /* renamed from: fe.fe.nn.vvv.qw$qw  reason: collision with other inner class name */
    public class C0117qw implements ServiceConnection {
        public C0117qw() {
        }

        public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            qw.this.f2405ad = c.a.a(iBinder);
            b bVar = qw.this.f2407fe;
        }

        public void onServiceDisconnected(ComponentName componentName) {
            qw qwVar = qw.this;
            qwVar.f2405ad = null;
            b bVar = qwVar.f2407fe;
        }
    }

    public qw(Context context) {
        this.qw = context;
    }

    public void ad() {
        this.f2406de = new C0117qw();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        this.qw.bindService(intent, this.f2406de, 1);
    }

    public String qw() {
        try {
            c cVar = this.f2405ad;
            if (cVar != null) {
                return ((c.a.C0058a) cVar).a();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
