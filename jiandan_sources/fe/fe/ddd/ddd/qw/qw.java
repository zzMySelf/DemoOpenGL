package fe.fe.ddd.ddd.qw;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.searchbox.config.AppConfig;
import fe.fe.ddd.ddd.ad.de;
import org.json.JSONObject;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public static final boolean f1331ad = AppConfig.rg();

    /* renamed from: de  reason: collision with root package name */
    public static volatile qw f1332de;
    public Handler qw;

    /* renamed from: fe.fe.ddd.ddd.qw.qw$qw  reason: collision with other inner class name */
    public class C0070qw implements Runnable {
        public C0070qw() {
        }

        public void run() {
            qw.this.ad();
        }
    }

    public qw(Context context) {
        if (context != null) {
            context.getApplicationContext();
            this.qw = new Handler(Looper.getMainLooper());
        }
    }

    public static qw fe() {
        if (f1332de == null) {
            synchronized (qw.class) {
                if (f1332de == null) {
                    f1332de = new qw(fe.fe.ddd.i.qw.qw.qw());
                }
            }
        }
        return f1332de;
    }

    public final void ad() {
        String de2 = fe.fe.ddd.ddd.de.de.fe.qw.ad().de();
        int fe2 = fe.fe.ddd.ddd.de.de.fe.qw.ad().fe();
        if (f1331ad) {
            "originData " + de2;
            "retryCount " + fe2;
        }
        if (!TextUtils.isEmpty(de2) && fe2 <= 3) {
            fe.fe.ddd.ddd.de.de.fe.qw.ad().yj(fe2 + 1);
            try {
                de.de(new JSONObject(de2));
            } catch (Exception e) {
                if (f1331ad) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void de(JSONObject jSONObject) {
        if (jSONObject != null) {
            fe.fe.ddd.ddd.de.de.fe.qw.ad().th(jSONObject.toString());
            fe.fe.ddd.ddd.de.de.fe.qw.ad().yj(0);
            de.de(jSONObject);
        }
    }

    public synchronized void rg() {
        this.qw.postDelayed(new C0070qw(), 30000);
    }
}
