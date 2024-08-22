package fe.mmm.qw.yj;

import android.content.Context;
import com.tera.scan.config.IAccountChecker;
import com.tera.scan.config.IParameter;

public class de extends qw {

    /* renamed from: de  reason: collision with root package name */
    public static volatile de f8718de;

    /* renamed from: ad  reason: collision with root package name */
    public IParameter f8719ad = null;

    public class qw implements IParameter {
        public final /* synthetic */ Context qw;

        public qw(de deVar, Context context) {
            this.qw = context;
        }

        public String de() {
            return i.qw(this.qw.getApplicationInfo().dataDir, "shared_prefs");
        }

        public boolean fe() {
            return false;
        }

        public String qw() {
            return "globalbaidunetdisk.ini";
        }

        public String rg() {
            return "globalbaidunetdisk.mmkv";
        }
    }

    public static de ppp() {
        if (f8718de == null) {
            synchronized (de.class) {
                if (f8718de == null) {
                    f8718de = new de();
                }
            }
        }
        return f8718de;
    }

    public void ggg(Context context) {
        if (this.qw == null) {
            qw qwVar = new qw(this, context);
            this.f8719ad = qwVar;
            this.qw = new fe((IAccountChecker) null, qwVar);
            fe.mmm.qw.i.qw.ad("GlobalConfig", "config init " + this.qw.toString());
        }
    }
}
