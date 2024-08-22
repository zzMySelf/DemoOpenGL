package fe.fe.ppp.de;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.baidu.pass.a;
import com.baidu.pass.permissions.PermissionsHelperActivity;

public class qw implements a {

    /* renamed from: yj  reason: collision with root package name */
    public static qw f2999yj;

    /* renamed from: ad  reason: collision with root package name */
    public de f3000ad;

    /* renamed from: th  reason: collision with root package name */
    public ad f3001th;

    /* renamed from: fe.fe.ppp.de.qw$qw  reason: collision with other inner class name */
    public class C0143qw extends ad {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ ad f3002ad;

        public C0143qw(ad adVar) {
            this.f3002ad = adVar;
        }

        public void onFailure(int i2) {
            qw.this.qw();
            this.f3002ad.onFailure(i2);
        }

        public void onSuccess() {
            qw.this.qw();
            this.f3002ad.onSuccess();
        }
    }

    public static boolean fe(String str, Context context) {
        try {
            if (Build.VERSION.SDK_INT < 23 || context.checkSelfPermission(str) != 0) {
                if (Build.VERSION.SDK_INT >= 23 || context.checkCallingOrSelfPermission(str) != 0) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
        }
    }

    public static synchronized qw rg() {
        qw qwVar;
        synchronized (qw.class) {
            if (f2999yj == null) {
                f2999yj = new qw();
            }
            qwVar = f2999yj;
        }
        return qwVar;
    }

    public boolean de(String... strArr) {
        for (String fe2 : strArr) {
            if (!fe(fe2, this.f3000ad.f2992ad)) {
                return false;
            }
        }
        return true;
    }

    public final void qw() {
        this.f3000ad = null;
        this.f3001th = null;
        f2999yj = null;
    }

    public ad th() {
        return this.f3001th;
    }

    public void uk(de deVar, ad adVar) {
        String[] strArr;
        if (deVar == null || deVar.f2992ad == null || (strArr = deVar.f2996th) == null || strArr.length == 0 || adVar == null) {
            throw new IllegalArgumentException("params is error");
        }
        this.f3000ad = deVar;
        this.f3001th = new C0143qw(adVar);
        if (de(deVar.f2996th)) {
            this.f3001th.onSuccess();
        } else if (Build.VERSION.SDK_INT < 23) {
            this.f3001th.onFailure(-1);
        } else {
            Intent intent = new Intent(deVar.f2992ad, PermissionsHelperActivity.class);
            Context context = deVar.f2992ad;
            if (context instanceof Activity) {
                context.startActivity(intent);
                return;
            }
            intent.setFlags(268435456);
            deVar.f2992ad.startActivity(intent);
        }
    }

    public de yj() {
        return this.f3000ad;
    }
}
