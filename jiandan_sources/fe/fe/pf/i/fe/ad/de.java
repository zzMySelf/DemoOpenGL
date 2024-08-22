package fe.fe.pf.i.fe.ad;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.baidu.helios.ids.oid.brand.g;

public class de {

    public class qw implements ServiceConnection {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ g.a f2758ad;
        public final /* synthetic */ Class[] qw;

        public qw(Class[] clsArr, g.a aVar) {
            this.qw = clsArr;
            this.f2758ad = aVar;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                Object invoke = this.qw[0].getMethod("asInterface", new Class[]{IBinder.class}).invoke((Object) null, new Object[]{iBinder});
                this.f2758ad.qw(true, (String) this.qw[0].getMethod("a", new Class[0]).invoke(invoke, new Object[0]));
            } catch (Throwable unused) {
                this.f2758ad.qw(false, (String) null);
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static void qw(Context context, g.a aVar) {
        if (context == null) {
            aVar.qw(false, (String) null);
            return;
        }
        Class[] clsArr = new Class[1];
        try {
            clsArr[0] = Class.forName("com.zui.deviceidservice.IDeviceidInterface$Stub");
        } catch (Throwable unused) {
        }
        if (clsArr[0] == null) {
            aVar.qw(false, (String) null);
            return;
        }
        try {
            qw qwVar = new qw(clsArr, aVar);
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            context.bindService(intent, qwVar, 1);
        } catch (Throwable unused2) {
            aVar.qw(false, (String) null);
        }
    }
}
