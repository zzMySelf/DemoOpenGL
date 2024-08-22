package fe.fe.pf.rg.de;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import fe.fe.pf.rg.qw;
import fe.fe.pf.yj.rg.qw;
import java.io.File;
import org.json.JSONObject;

public class qw extends fe.fe.pf.rg.qw {

    /* renamed from: th  reason: collision with root package name */
    public qw.C0142qw f2835th;

    /* renamed from: yj  reason: collision with root package name */
    public C0134qw f2836yj = new C0134qw();

    public class ad extends qw.de {

        /* renamed from: fe  reason: collision with root package name */
        public String f2837fe;

        /* renamed from: rg  reason: collision with root package name */
        public long f2838rg;

        /* renamed from: th  reason: collision with root package name */
        public long f2839th;

        /* renamed from: uk  reason: collision with root package name */
        public String f2840uk;

        /* renamed from: yj  reason: collision with root package name */
        public long f2841yj;

        public ad(qw qwVar, String str) {
            super(qwVar.f2835th, str);
        }

        public void de(JSONObject jSONObject) {
            this.f2837fe = jSONObject.getString(SapiAccount.ExtraProperty.EXTRA_PKG);
            this.f2839th = (long) jSONObject.getInt("tar_pkg_lst_pub_ts");
            this.f2838rg = jSONObject.getLong("last_fe_ts");
            this.f2840uk = jSONObject.getString("id");
            this.f2841yj = jSONObject.getLong("tar_pkg_lst_up_ts");
            jSONObject.getInt("d_form_ver");
        }

        public boolean i(String str) {
            if (str.equals(this.f2837fe)) {
                return false;
            }
            this.f2837fe = str;
            qw(true);
            return true;
        }

        /* renamed from: if  reason: not valid java name */
        public boolean m195if(String str) {
            if (str.equals(this.f2840uk)) {
                return false;
            }
            this.f2840uk = str;
            qw(true);
            return true;
        }

        public String o() {
            return this.f2840uk;
        }

        public boolean pf(long j) {
            if (this.f2839th == j) {
                return false;
            }
            this.f2839th = j;
            qw(true);
            return true;
        }

        public void rg(JSONObject jSONObject) {
            jSONObject.put(SapiAccount.ExtraProperty.EXTRA_PKG, this.f2837fe);
            jSONObject.put("last_fe_ts", this.f2838rg);
            jSONObject.put("tar_pkg_lst_pub_ts", this.f2839th);
            jSONObject.put("id", this.f2840uk);
            jSONObject.put("tar_pkg_lst_up_ts", this.f2841yj);
            jSONObject.put("d_form_ver", 1);
        }

        /* renamed from: switch  reason: not valid java name */
        public long m196switch() {
            return this.f2841yj;
        }

        public String th() {
            return this.f2837fe;
        }

        public boolean uk(long j) {
            if (this.f2838rg == j) {
                return false;
            }
            this.f2838rg = j;
            qw(true);
            return true;
        }

        public boolean when(long j) {
            if (this.f2841yj == j) {
                return false;
            }
            this.f2841yj = j;
            qw(true);
            return true;
        }

        public void yj(C0134qw qwVar) {
            m195if(qwVar.fe());
            pf(qwVar.qw());
        }
    }

    /* renamed from: fe.fe.pf.rg.de.qw$qw  reason: collision with other inner class name */
    public class C0134qw {

        /* renamed from: ad  reason: collision with root package name */
        public String f2842ad;

        /* renamed from: de  reason: collision with root package name */
        public boolean f2843de;

        /* renamed from: fe  reason: collision with root package name */
        public boolean f2844fe = true;
        public long qw;

        public C0134qw() {
        }

        public void ad(long j) {
            if (this.qw != j) {
                this.qw = j;
                this.f2843de = true;
            }
        }

        public void de(String str) {
            if (!str.equals(this.f2842ad)) {
                this.f2842ad = str;
                this.f2843de = true;
            }
        }

        public String fe() {
            return this.f2842ad;
        }

        public boolean i() {
            try {
                File externalCacheDir = qw.this.qw.qw.getExternalCacheDir();
                File file = new File(externalCacheDir, "com.baidu.helios" + File.separator + "esc-es");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pub_id", this.f2842ad);
                jSONObject.put("pub_lst_ts", this.qw);
                jSONObject.put("d_form_ver", 1);
                fe.fe.pf.yj.rg.qw.th(file, "pub.dat", jSONObject.toString(), "UTF-8", true);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public long qw() {
            return this.qw;
        }

        public boolean rg(String str) {
            Context context;
            this.f2844fe = false;
            try {
                context = qw.this.qw.qw.createPackageContext(str, 0);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                context = null;
            }
            if (context == null) {
                return false;
            }
            try {
                File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir == null) {
                    return false;
                }
                return yj(fe.fe.pf.yj.rg.qw.rg(new File(externalCacheDir, "com.baidu.helios" + File.separator + "esc-es"), "pub.dat", "UTF-8", true));
            } catch (Throwable unused) {
                return false;
            }
        }

        public boolean th() {
            return yj(qw.this.f2835th.yj("pub.dat", true));
        }

        public boolean uk() {
            if (this.f2844fe) {
                if (this.f2843de) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_id", this.f2842ad);
                        jSONObject.put("pub_lst_ts", this.qw);
                        jSONObject.put("d_form_ver", 1);
                        qw.this.f2835th.i("pub.dat", jSONObject.toString(), true);
                        this.f2843de = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            throw new IllegalStateException();
        }

        public final boolean yj(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.qw = jSONObject.getLong("pub_lst_ts");
                    this.f2842ad = jSONObject.getString("pub_id");
                    jSONObject.getInt("d_form_ver");
                    this.f2843de = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    public qw() {
        super("esc-es", 7000000);
    }

    public qw.uk ad(String str, qw.yj yjVar) {
        PackageInfo packageInfo;
        Context context = this.qw.qw;
        boolean z = false;
        ad adVar = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return qw.uk.ad(-1);
        }
        if (yjVar.qw) {
            adVar = new ad(this, str);
            adVar.fe();
            if (str.equals(adVar.th()) && packageInfo.lastUpdateTime == adVar.m196switch()) {
                String o2 = adVar.o();
                if (!TextUtils.isEmpty(o2)) {
                    return qw.uk.th(o2);
                }
            }
        }
        if (context.checkPermission("android.permission.READ_EXTERNAL_STORAGE", Process.myPid(), Process.myUid()) == 0) {
            z = true;
        }
        if (!z) {
            return qw.uk.ad(-100);
        }
        C0134qw qwVar = new C0134qw();
        if (!qwVar.rg(str)) {
            return qw.uk.ad(-2);
        }
        if (yjVar.qw && adVar != null) {
            adVar.yj(qwVar);
            adVar.uk(System.currentTimeMillis());
            adVar.when(packageInfo.lastUpdateTime);
            adVar.i(str);
            adVar.ad();
        }
        return qw.uk.th(qwVar.fe());
    }

    public final qw.th i(qw.rg rgVar) {
        String de2 = this.qw.f2863de.qw("aid").de();
        if (de2.equals(this.f2836yj.fe())) {
            return qw.th.fe();
        }
        this.f2836yj.de(de2);
        this.f2836yj.ad(System.currentTimeMillis());
        this.f2836yj.uk();
        return this.f2836yj.i() ? qw.th.fe() : qw.th.qw();
    }

    public void rg(qw.fe feVar) {
        this.f2835th = this.f2859ad.th("esc-es");
    }

    public qw.th th(qw.rg rgVar) {
        if (Build.VERSION.SDK_INT >= 28) {
            return qw.th.qw();
        }
        this.f2836yj.th();
        try {
            return i(rgVar);
        } finally {
            this.f2836yj.uk();
        }
    }
}
