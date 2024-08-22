package fe.fe.ddd.pf.qw.fe;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.datacollector.growth.utils.IDeviceCallback;
import com.baidu.ubc.UBCManager;
import fe.fe.ddd.pf.qw.rg.de;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class qw {

    /* renamed from: fe  reason: collision with root package name */
    public static final boolean f1531fe = AppConfig.rg();

    /* renamed from: rg  reason: collision with root package name */
    public static volatile qw f1532rg;

    /* renamed from: ad  reason: collision with root package name */
    public UBCManager f1533ad;

    /* renamed from: de  reason: collision with root package name */
    public long f1534de;
    public ExecutorService qw;

    public class ad implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ fe.fe.ddd.pf.qw.ad.ad f1535ad;

        public ad(fe.fe.ddd.pf.qw.ad.ad adVar) {
            this.f1535ad = adVar;
        }

        public void run() {
            qw.this.ggg(this.f1535ad);
        }
    }

    public class de implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Context f1537ad;

        public de(Context context) {
            this.f1537ad = context;
        }

        public void run() {
            qw.this.vvv(this.f1537ad);
        }
    }

    public class fe implements IDeviceCallback {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Context f1539ad;
        public final /* synthetic */ fe.fe.ddd.pf.qw.ad.qw qw;

        public fe(fe.fe.ddd.pf.qw.ad.qw qwVar, Context context) {
            this.qw = qwVar;
            this.f1539ad = context;
        }

        public void onSuccess(String str) {
            if (qw.f1531fe) {
                "oaid: " + str;
            }
            qw.this.xxx(this.qw, this.f1539ad, str);
        }

        public void qw() {
            boolean fe2 = qw.f1531fe;
            qw.this.xxx(this.qw, this.f1539ad, "");
        }
    }

    /* renamed from: fe.fe.ddd.pf.qw.fe.qw$qw  reason: collision with other inner class name */
    public class C0083qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ fe.fe.ddd.pf.qw.ad.qw f1541ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ Context f1542th;

        public C0083qw(fe.fe.ddd.pf.qw.ad.qw qwVar, Context context) {
            this.f1541ad = qwVar;
            this.f1542th = context;
        }

        public void run() {
            qw.this.ppp(this.f1541ad, this.f1542th);
        }
    }

    public class rg implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ fe.fe.ddd.pf.qw.ad.qw f1544ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ Context f1545th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ String f1547yj;

        public rg(fe.fe.ddd.pf.qw.ad.qw qwVar, Context context, String str) {
            this.f1544ad = qwVar;
            this.f1545th = context;
            this.f1547yj = str;
        }

        public void run() {
            qw.this.i(this.f1544ad, this.f1545th, this.f1547yj);
        }
    }

    public class th implements IDeviceCallback {
        public final /* synthetic */ Context qw;

        public th(Context context) {
            this.qw = context;
        }

        public void onSuccess(String str) {
            qw.this.ddd(this.qw, str);
        }

        public void qw() {
            qw.this.ddd(this.qw, "");
        }
    }

    public class yj implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Context f1549ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ String f1550th;

        public yj(Context context, String str) {
            this.f1549ad = context;
            this.f1550th = str;
        }

        public void run() {
            qw.this.m74if(this.f1549ad, this.f1550th);
        }
    }

    public qw() {
        when();
    }

    /* renamed from: switch  reason: not valid java name */
    public static qw m73switch() {
        if (f1532rg == null) {
            synchronized (qw.class) {
                if (f1532rg == null) {
                    f1532rg = new qw();
                }
            }
        }
        return f1532rg;
    }

    public void aaa(Context context) {
        if (context != null) {
            this.qw.execute(new de(context));
        }
    }

    public final void ddd(Context context, String str) {
        this.qw.execute(new yj(context, str));
    }

    public final void ggg(fe.fe.ddd.pf.qw.ad.ad adVar) {
        if (this.f1533ad != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", adVar.th());
                jSONObject.put(UBCManager.CONTENT_KEY_SOURCE, adVar.rg());
                jSONObject.put("launch_ch", adVar.de());
                jSONObject.put("down_ch", adVar.qw());
                jSONObject.put("schema", adVar.fe());
                JSONObject ad2 = adVar.ad();
                if (ad2 != null) {
                    jSONObject.put(UBCManager.CONTENT_KEY_EXT, ad2);
                }
                if (f1531fe) {
                    "channel content: " + jSONObject;
                }
                this.f1533ad.onEvent("1611", jSONObject);
            } catch (JSONException e) {
                if (f1531fe) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final void i(fe.fe.ddd.pf.qw.ad.qw qwVar, Context context, String str) {
        String de2 = qwVar.de();
        if (TextUtils.isEmpty(de2)) {
            de2 = "active";
        }
        String qw2 = fe.fe.ddd.pf.qw.rg.ad.qw(context);
        String ad2 = fe.fe.ddd.pf.qw.rg.ad.ad(context);
        de.qw de3 = fe.fe.ddd.pf.qw.rg.de.de(pf(qwVar, context, str));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", de2);
            jSONObject.put("fit", qw2);
            jSONObject.put("lut", ad2);
            jSONObject.put("aes_key", de3.qw);
            jSONObject.put("uss", de3.f1552ad);
            JSONObject ad3 = qwVar.ad();
            if (ad3 != null) {
                jSONObject.put(UBCManager.CONTENT_KEY_EXT, ad3);
            }
            if (f1531fe) {
                "active content: " + jSONObject;
            }
            this.f1533ad.onEvent("1716", jSONObject);
        } catch (JSONException e) {
            if (f1531fe) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: if  reason: not valid java name */
    public final void m74if(Context context, String str) {
        de.qw de2 = fe.fe.ddd.pf.qw.rg.de.de(o(context, str));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "deviceInfo");
            jSONObject.put("aes_key", de2.qw);
            jSONObject.put("uss", de2.f1552ad);
            if (f1531fe) {
                "device content: " + jSONObject;
            }
            this.f1533ad.onEvent("3705", jSONObject);
            SharedPreferences.Editor edit = context.getSharedPreferences("GrowthDataCollect", 0).edit();
            long currentTimeMillis = System.currentTimeMillis();
            edit.putLong("ldt", currentTimeMillis);
            edit.apply();
            this.f1534de = currentTimeMillis;
            if (f1531fe) {
                "update device record time: " + currentTimeMillis;
            }
        } catch (JSONException e) {
            if (f1531fe) {
                e.printStackTrace();
            }
        }
    }

    public void mmm(fe.fe.ddd.pf.qw.ad.ad adVar) {
        if (adVar != null) {
            this.qw.execute(new ad(adVar));
        }
    }

    public void nn(fe.fe.ddd.pf.qw.ad.qw qwVar, Context context) {
        if (qwVar != null && context != null) {
            this.qw.execute(new C0083qw(qwVar, context));
        }
    }

    public final String o(Context context, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", fe.fe.ddd.pf.qw.rg.qw.ad(context));
            jSONObject.put("oaid", str);
        } catch (JSONException e) {
            if (f1531fe) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public final String pf(fe.fe.ddd.pf.qw.ad.qw qwVar, Context context, String str) {
        JSONObject jSONObject = new JSONObject();
        String qw2 = qwVar.qw();
        String ad2 = fe.fe.ddd.pf.qw.rg.qw.ad(context);
        try {
            jSONObject.put("channel", qw2);
            jSONObject.put("imei", ad2);
            jSONObject.put("oaid", str);
        } catch (JSONException e) {
            if (f1531fe) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public final void ppp(fe.fe.ddd.pf.qw.ad.qw qwVar, Context context) {
        if (this.f1533ad != null) {
            fe.fe.ddd.pf.qw.rg.qw.qw(!(context instanceof Application) ? context.getApplicationContext() : context, new fe(qwVar, context));
        }
    }

    public final void vvv(Context context) {
        if (this.f1533ad != null && context != null) {
            if (this.f1534de == 0) {
                this.f1534de = context.getSharedPreferences("GrowthDataCollect", 0).getLong("ldt", 0);
            }
            long currentTimeMillis = System.currentTimeMillis() - this.f1534de;
            if (currentTimeMillis > 86400000) {
                fe.fe.ddd.pf.qw.rg.qw.qw(!(context instanceof Application) ? context.getApplicationContext() : context, new th(context));
            } else if (f1531fe) {
                "diffTime: " + currentTimeMillis + ", not record this data";
            }
        }
    }

    public final void when() {
        this.qw = new ThreadPoolExecutor(1, 1, 600000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        this.f1533ad = (UBCManager) fe.fe.vvv.ad.ad.ad.qw(UBCManager.SERVICE_REFERENCE);
    }

    public final void xxx(fe.fe.ddd.pf.qw.ad.qw qwVar, Context context, String str) {
        this.qw.execute(new rg(qwVar, context, str));
    }
}
