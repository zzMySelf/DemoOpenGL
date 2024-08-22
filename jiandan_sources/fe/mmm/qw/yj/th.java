package fe.mmm.qw.yj;

import com.tera.scan.config.IAccountChecker;
import com.tera.scan.config.IParameter;
import fe.mmm.qw.i.qw;

public class th extends qw {

    /* renamed from: ad  reason: collision with root package name */
    public static volatile th f8723ad;

    public static th ppp() {
        if (f8723ad == null) {
            synchronized (th.class) {
                if (f8723ad == null) {
                    f8723ad = new th();
                }
            }
        }
        return f8723ad;
    }

    public void de() {
        this.qw = null;
        super.de();
    }

    public void ggg(IAccountChecker iAccountChecker, IParameter iParameter) {
        if (this.qw == null) {
            this.qw = new fe(iAccountChecker, iParameter);
            qw.ad("PersonalConfig", "config init " + this.qw);
        }
    }
}
