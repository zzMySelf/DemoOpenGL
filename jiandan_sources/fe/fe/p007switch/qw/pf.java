package fe.fe.p007switch.qw;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* renamed from: fe.fe.switch.qw.pf  reason: invalid package */
public abstract class pf {
    public static int qw = 2;

    public final void ad(int i2, String str) {
        if (yj() && i2 >= qw) {
            Log.println(i2, qw(), str);
        }
    }

    public void de(String str) {
        ad(3, str);
    }

    public void fe(Throwable th2) {
        ad(6, rg(th2));
    }

    public abstract String qw();

    public final String rg(Throwable th2) {
        if (th2 == null) {
            return "";
        }
        for (Throwable th3 = th2; th3 != null; th3 = th3.getCause()) {
            if (th3 instanceof UnknownHostException) {
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        th2.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public void th(String str) {
        ad(5, str);
    }

    public void uk(String str) {
        ad(6, str);
    }

    public abstract boolean yj();
}
