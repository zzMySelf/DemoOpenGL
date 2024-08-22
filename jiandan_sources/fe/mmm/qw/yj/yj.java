package fe.mmm.qw.yj;

import android.content.Context;
import com.tera.scan.config.IAccountChecker;
import com.tera.scan.config.IParameter;

public class yj extends qw {

    /* renamed from: ad  reason: collision with root package name */
    public static volatile yj f8729ad;

    public class qw implements IParameter {
        public final /* synthetic */ Context qw;

        public qw(yj yjVar, Context context) {
            this.qw = context;
        }

        public String de() {
            return i.qw(this.qw.getApplicationInfo().dataDir, "shared_prefs");
        }

        public boolean fe() {
            return true;
        }

        public String qw() {
            return "EncryptConfig";
        }

        public String rg() {
            return "EncryptConfig.mmkv";
        }
    }

    public static yj ppp() {
        if (f8729ad == null) {
            synchronized (yj.class) {
                if (f8729ad == null) {
                    f8729ad = new yj();
                }
            }
        }
        return f8729ad;
    }

    public void ggg(Context context) {
        if (this.qw == null) {
            this.qw = new fe((IAccountChecker) null, new qw(this, context));
            fe.mmm.qw.i.qw.ad("EncryptConfig", "config init " + this.qw.toString());
        }
    }
}
