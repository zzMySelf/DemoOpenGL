package fe.fe.p007switch.qw;

import android.content.Context;
import com.baidu.mobstat.dxmpay.ExceptionAnalysis;
import java.lang.Thread;

/* renamed from: fe.fe.switch.qw.o  reason: invalid package */
public class o implements Thread.UncaughtExceptionHandler {

    /* renamed from: de  reason: collision with root package name */
    public static final o f3044de = new o();

    /* renamed from: ad  reason: collision with root package name */
    public Context f3045ad;
    public Thread.UncaughtExceptionHandler qw;

    public static o qw() {
        return f3044de;
    }

    public void ad(Context context) {
        this.f3045ad = context;
        if (this.qw == null) {
            this.qw = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    public void uncaughtException(Thread thread, Throwable th2) {
        ExceptionAnalysis.de().th(this.f3045ad, th2, true);
        if (!this.qw.equals(this)) {
            this.qw.uncaughtException(thread, th2);
        }
    }
}
