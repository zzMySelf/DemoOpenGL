package fe.fe.pf.i.fe.ad;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.baidu.helios.ids.oid.brand.g;

public class qw {

    /* renamed from: fe.fe.pf.i.fe.ad.qw$qw  reason: collision with other inner class name */
    public class C0125qw implements ServiceConnection {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ g.a f2759ad;
        public final /* synthetic */ Class[] qw;

        public C0125qw(Class[] clsArr, g.a aVar) {
            this.qw = clsArr;
            this.f2759ad = aVar;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                Object invoke = this.qw[0].getMethod("asInterface", new Class[]{IBinder.class}).invoke((Object) null, new Object[]{iBinder});
                this.f2759ad.qw(true, (String) this.qw[0].getMethod("getID", new Class[0]).invoke(invoke, new Object[0]));
            } catch (Throwable unused) {
                this.f2759ad.qw(false, (String) null);
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
            clsArr[0] = Class.forName("com.asus.msa.SupplementaryDID.IDidAidlInterface$Stub");
        } catch (Throwable unused) {
        }
        if (clsArr[0] == null) {
            aVar.qw(false, (String) null);
            return;
        }
        try {
            C0125qw qwVar = new C0125qw(clsArr, aVar);
            Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
            intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
            context.bindService(intent, qwVar, 1);
        } catch (Throwable unused2) {
            aVar.qw(false, (String) null);
        }
    }
}
