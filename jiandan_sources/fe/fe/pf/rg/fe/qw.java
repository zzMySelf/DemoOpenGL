package fe.fe.pf.rg.fe;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.system.Os;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import fe.fe.pf.rg.qw;
import fe.fe.pf.yj.fe.de.rg;
import fe.fe.pf.yj.rg.qw;
import java.io.File;
import org.json.JSONObject;

public class qw extends fe.fe.pf.rg.qw {

    /* renamed from: th  reason: collision with root package name */
    public qw.C0142qw f2846th;

    /* renamed from: yj  reason: collision with root package name */
    public ad f2847yj = new ad();

    public class ad {

        /* renamed from: ad  reason: collision with root package name */
        public long f2848ad;

        /* renamed from: de  reason: collision with root package name */
        public String f2849de;

        /* renamed from: fe  reason: collision with root package name */
        public boolean f2850fe;
        public rg qw = new rg();

        /* renamed from: rg  reason: collision with root package name */
        public boolean f2851rg = true;

        public ad() {
        }

        public void ad(long j) {
            if (this.f2848ad != j) {
                this.f2848ad = j;
                this.f2850fe = true;
            }
        }

        public void de(long j, long j2) {
            if (this.qw.de(j, j2)) {
                this.f2850fe = true;
            }
        }

        public void fe(String str) {
            if (!str.equals(this.f2849de)) {
                this.f2849de = str;
                this.f2850fe = true;
            }
        }

        public boolean i() {
            if (this.f2851rg) {
                if (this.f2850fe) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_id", this.f2849de);
                        jSONObject.put("pub_lst_ts", this.f2848ad);
                        jSONObject.put("d_form_ver", 1);
                        qw.this.f2846th.i("pub.dat", jSONObject.toString(), true);
                        this.f2850fe = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            throw new IllegalStateException();
        }

        public boolean o() {
            return qw.pf(qw.this.f2846th.fe("pub.dat"), true);
        }

        public long qw() {
            return this.f2848ad;
        }

        public boolean rg(PackageInfo packageInfo) {
            String yj2 = qw.this.f2846th.uk(new File(packageInfo.applicationInfo.dataDir)).yj("pub.dat", true);
            this.f2851rg = false;
            return yj(yj2);
        }

        public String th() {
            return this.f2849de;
        }

        public boolean uk() {
            return yj(qw.this.f2846th.yj("pub.dat", true));
        }

        public final boolean yj(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.f2848ad = jSONObject.getLong("pub_lst_ts");
                    this.f2849de = jSONObject.getString("pub_id");
                    jSONObject.getInt("d_form_ver");
                    this.f2850fe = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    public class de extends qw.de {

        /* renamed from: fe  reason: collision with root package name */
        public String f2853fe;

        /* renamed from: rg  reason: collision with root package name */
        public long f2854rg;

        /* renamed from: th  reason: collision with root package name */
        public long f2855th;

        /* renamed from: uk  reason: collision with root package name */
        public String f2856uk;

        /* renamed from: yj  reason: collision with root package name */
        public long f2857yj;

        public de(qw qwVar, String str) {
            super(qwVar.f2846th, str);
        }

        public void de(JSONObject jSONObject) {
            this.f2853fe = jSONObject.getString(SapiAccount.ExtraProperty.EXTRA_PKG);
            this.f2855th = (long) jSONObject.getInt("tar_pkg_lst_pub_ts");
            this.f2854rg = jSONObject.getLong("last_fe_ts");
            this.f2856uk = jSONObject.getString("id");
            this.f2857yj = jSONObject.getLong("tar_pkg_lst_up_ts");
            jSONObject.getInt("d_form_ver");
        }

        public boolean i(String str) {
            if (str.equals(this.f2853fe)) {
                return false;
            }
            this.f2853fe = str;
            qw(true);
            return true;
        }

        /* renamed from: if  reason: not valid java name */
        public boolean m197if(String str) {
            if (str.equals(this.f2856uk)) {
                return false;
            }
            this.f2856uk = str;
            qw(true);
            return true;
        }

        public String o() {
            return this.f2856uk;
        }

        public boolean pf(long j) {
            if (this.f2855th == j) {
                return false;
            }
            this.f2855th = j;
            qw(true);
            return true;
        }

        public void rg(JSONObject jSONObject) {
            jSONObject.put(SapiAccount.ExtraProperty.EXTRA_PKG, this.f2853fe);
            jSONObject.put("last_fe_ts", this.f2854rg);
            jSONObject.put("tar_pkg_lst_pub_ts", this.f2855th);
            jSONObject.put("id", this.f2856uk);
            jSONObject.put("tar_pkg_lst_up_ts", this.f2857yj);
            jSONObject.put("d_form_ver", 1);
        }

        /* renamed from: switch  reason: not valid java name */
        public long m198switch() {
            return this.f2857yj;
        }

        public String th() {
            return this.f2853fe;
        }

        public boolean uk(long j) {
            if (this.f2854rg == j) {
                return false;
            }
            this.f2854rg = j;
            qw(true);
            return true;
        }

        public boolean when(long j) {
            if (this.f2857yj == j) {
                return false;
            }
            this.f2857yj = j;
            qw(true);
            return true;
        }

        public void yj(ad adVar) {
            m197if(adVar.th());
            pf(adVar.qw());
        }
    }

    /* renamed from: fe.fe.pf.rg.fe.qw$qw  reason: collision with other inner class name */
    public static class C0135qw {
        public static boolean ad(File file) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    int i2 = Os.stat(file.getAbsolutePath()).st_mode;
                    if ((i2 & 1) == 0) {
                        Os.chmod(file.getAbsolutePath(), i2 | 1);
                    }
                    return true;
                } catch (Throwable unused) {
                }
            }
            return false;
        }

        public static boolean qw(qw.C0142qw qwVar, fe.fe.pf.yj.rg.qw qwVar2) {
            if (Build.VERSION.SDK_INT < 23) {
                while (qwVar != null && !qwVar.ad().equals(qwVar2.ad())) {
                    qwVar.ad().setExecutable(true, false);
                    qwVar = qwVar.rg();
                }
                return true;
            }
            while (qwVar != null) {
                if (!ad(qwVar.ad())) {
                    return false;
                }
                qwVar = qwVar.rg();
            }
            return ad(qwVar2.ad());
        }
    }

    public qw() {
        super("isc", 8000000);
    }

    public static boolean pf(File file, boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                Os.chmod(file.getAbsolutePath(), z ? 436 : 432);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        } else if (z) {
            try {
                return file.setReadable(true, false);
            } catch (Throwable unused2) {
                return false;
            }
        } else {
            return file.setReadable(false, false) && file.setReadable(true, true);
        }
    }

    public qw.uk ad(String str, qw.yj yjVar) {
        PackageInfo packageInfo;
        String th2;
        de deVar = null;
        try {
            packageInfo = this.qw.qw.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return qw.uk.ad(-2);
        }
        if (yjVar.qw) {
            deVar = new de(this, str);
            deVar.fe();
            if (str.equals(deVar.th()) && packageInfo.lastUpdateTime == deVar.m198switch()) {
                th2 = deVar.o();
                return qw.uk.th(th2);
            }
        }
        ad adVar = new ad();
        if (!adVar.rg(packageInfo)) {
            return qw.uk.ad(-2);
        }
        if (yjVar.qw && deVar != null) {
            deVar.yj(adVar);
            deVar.uk(System.currentTimeMillis());
            deVar.when(packageInfo.lastUpdateTime);
            deVar.i(str);
            deVar.ad();
        }
        th2 = adVar.th();
        return qw.uk.th(th2);
    }

    public final void i() {
        this.f2847yj.de((long) (C0135qw.qw(this.f2846th, this.qw.f2862ad) ? 1 : 2), 3);
    }

    public void rg(qw.fe feVar) {
        this.f2846th = this.f2859ad.th("isc");
    }

    public qw.th th(qw.rg rgVar) {
        Context context = this.qw.qw;
        if (Build.VERSION.SDK_INT >= 28 && context.getApplicationInfo().targetSdkVersion >= 28) {
            return qw.th.ad(-100);
        }
        this.f2847yj.uk();
        try {
            return uk(rgVar);
        } finally {
            this.f2847yj.i();
            i();
            this.f2847yj.i();
            this.f2847yj.o();
        }
    }

    public final qw.th uk(qw.rg rgVar) {
        this.f2847yj.uk();
        this.f2846th.qw();
        String de2 = this.qw.f2863de.qw("aid").de();
        if (de2.equals(this.f2847yj.th())) {
            return qw.th.fe();
        }
        this.f2847yj.fe(de2);
        this.f2847yj.ad(System.currentTimeMillis());
        return qw.th.fe();
    }
}
