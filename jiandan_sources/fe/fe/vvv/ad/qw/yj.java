package fe.fe.vvv.ad.qw;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public abstract class yj {

    /* renamed from: ad  reason: collision with root package name */
    public static final ConcurrentHashMap<String, ad> f3167ad = new ConcurrentHashMap<>();
    public static final HashMap<String, yj> qw = new HashMap<>();

    public static class ad {

        /* renamed from: ad  reason: collision with root package name */
        public boolean f3168ad;
        public IBinder qw;

        public ad() {
            this.f3168ad = false;
        }
    }

    public static IBinder fe(String str) {
        yj yjVar = qw.get(str);
        if (yjVar != null) {
            yjVar.ad();
            return yjVar.de();
        }
        ad adVar = f3167ad.get(str);
        if (adVar == null) {
            return null;
        }
        if (adVar.f3168ad || Binder.getCallingUid() == Process.myUid()) {
            return adVar.qw;
        }
        throw new SecurityException();
    }

    public static void qw(String str, IBinder iBinder, boolean z) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        } else if (qw.get(str) == null) {
            ad adVar = new ad();
            adVar.qw = iBinder;
            adVar.f3168ad = z;
            f3167ad.put(str, adVar);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static boolean rg(String str) {
        if (Binder.getCallingUid() == Process.myUid()) {
            return f3167ad.remove(str) != null;
        }
        throw new SecurityException();
    }

    public void ad() {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }

    public abstract IBinder de();
}
