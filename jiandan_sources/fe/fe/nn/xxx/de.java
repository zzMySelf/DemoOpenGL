package fe.fe.nn.xxx;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.baidu.sso.p.b;
import com.baidu.sso.r.a;

public class de implements ServiceConnection {
    public qw qw;

    public de(qw qwVar) {
        this.qw = qwVar;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.qw.qw = a.C0059a.a(iBinder);
        b bVar = this.qw.f2421rg;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        qw qwVar = this.qw;
        qwVar.qw = null;
        b bVar = qwVar.f2421rg;
        if (bVar != null) {
            bVar.a();
        }
    }
}
