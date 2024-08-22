package fe.fe.p007switch.qw;

import android.content.Context;
import com.baidu.mobstat.dxmpay.ActivityLifeObserver;
import com.baidu.mobstat.dxmpay.AutoTrack$MyActivityLifeCallback;
import com.baidu.mobstat.dxmpay.b$a;
import com.baidu.mobstat.dxmpay.d;

/* renamed from: fe.fe.switch.qw.qw  reason: invalid package */
public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public static ActivityLifeObserver.IActivityLifeCallback f3050ad = null;

    /* renamed from: de  reason: collision with root package name */
    public static ActivityLifeObserver.IActivityLifeCallback f3051de = null;
    public static boolean qw = false;

    public static synchronized void ad(Context context) {
        synchronized (qw.class) {
            if (!qw) {
                qw(context);
                ActivityLifeObserver.rg().de();
                ActivityLifeObserver.rg().ad(f3050ad);
                ActivityLifeObserver.rg().ad(f3051de);
                ActivityLifeObserver.rg().th(context);
                qw = true;
            }
        }
    }

    public static synchronized void qw(Context context) {
        synchronized (qw.class) {
            f3050ad = new AutoTrack$MyActivityLifeCallback(1);
            new b$a();
            new d.a();
            f3051de = new AutoTrack$MyActivityLifeCallback(2);
        }
    }
}
