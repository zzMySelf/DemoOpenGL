package fe.fe.fe.ad;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.system.Os;
import android.text.TextUtils;
import com.baidu.cesium.h;
import com.baidu.sapi2.SapiAccount;
import fe.fe.fe.ad.qw;
import fe.fe.fe.yj.qw;
import java.io.File;
import org.json.JSONObject;

public class ad extends qw {

    /* renamed from: th  reason: collision with root package name */
    public qw.C0104qw f1796th;

    /* renamed from: yj  reason: collision with root package name */
    public C0101ad f1797yj = new C0101ad();

    /* renamed from: fe.fe.fe.ad.ad$ad  reason: collision with other inner class name */
    public class C0101ad {

        /* renamed from: ad  reason: collision with root package name */
        public long f1798ad;

        /* renamed from: de  reason: collision with root package name */
        public h.a f1799de;

        /* renamed from: fe  reason: collision with root package name */
        public boolean f1800fe;
        public fe.fe.fe.i.ad qw = new fe.fe.fe.i.ad();

        /* renamed from: rg  reason: collision with root package name */
        public boolean f1801rg = true;

        public C0101ad() {
        }

        public void ad(long j) {
            if (this.f1798ad != j) {
                this.f1798ad = j;
                this.f1800fe = true;
            }
        }

        public void de(long j, long j2) {
            if (this.qw.qw(j, j2)) {
                this.f1800fe = true;
            }
        }

        public void fe(h.a aVar) {
            if (!aVar.equals(this.f1799de)) {
                this.f1799de = aVar;
                this.f1800fe = true;
            }
        }

        public boolean i() {
            if (this.f1801rg) {
                if (this.f1800fe) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_info", this.f1799de.tt());
                        jSONObject.put("pub_lst_ts", this.f1798ad);
                        jSONObject.put("d_form_ver", 1);
                        ad.this.f1796th.rg("pub.dat", jSONObject.toString(), true);
                        this.f1800fe = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            throw new IllegalStateException();
        }

        public boolean o() {
            return ad.i(ad.this.f1796th.yj("pub.dat"), true);
        }

        public long qw() {
            return this.f1798ad;
        }

        public boolean rg(PackageInfo packageInfo) {
            String de2 = ad.this.f1796th.qw(new File(packageInfo.applicationInfo.dataDir)).de("pub.dat", true);
            this.f1801rg = false;
            return th(de2);
        }

        public final boolean th(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.f1798ad = jSONObject.getLong("pub_lst_ts");
                    this.f1799de = h.de(jSONObject.getString("pub_info"));
                    jSONObject.getInt("d_form_ver");
                    this.f1800fe = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public boolean uk() {
            return th(ad.this.f1796th.de("pub.dat", true));
        }

        public h.a yj() {
            return this.f1799de;
        }
    }

    public class de extends qw.de {

        /* renamed from: fe  reason: collision with root package name */
        public String f1803fe;

        /* renamed from: rg  reason: collision with root package name */
        public long f1804rg;

        /* renamed from: th  reason: collision with root package name */
        public long f1805th;

        /* renamed from: uk  reason: collision with root package name */
        public h.a f1806uk;

        /* renamed from: yj  reason: collision with root package name */
        public long f1807yj;

        public de(ad adVar, String str) {
            super(adVar.f1796th, str);
        }

        public void fe(JSONObject jSONObject) {
            jSONObject.put(SapiAccount.ExtraProperty.EXTRA_PKG, this.f1803fe);
            jSONObject.put("last_fe_ts", this.f1804rg);
            jSONObject.put("tar_pkg_lst_pub_ts", this.f1805th);
            jSONObject.put("info", this.f1806uk.tt());
            jSONObject.put("tar_pkg_lst_up_ts", this.f1807yj);
            jSONObject.put("d_form_ver", 1);
        }

        public boolean i(String str) {
            if (str.equals(this.f1803fe)) {
                return false;
            }
            this.f1803fe = str;
            ad(true);
            return true;
        }

        /* renamed from: if  reason: not valid java name */
        public boolean m99if(long j) {
            if (this.f1807yj == j) {
                return false;
            }
            this.f1807yj = j;
            ad(true);
            return true;
        }

        public boolean o(long j) {
            if (this.f1805th == j) {
                return false;
            }
            this.f1805th = j;
            ad(true);
            return true;
        }

        public String pf() {
            return this.f1803fe;
        }

        public void qw(JSONObject jSONObject) {
            this.f1803fe = jSONObject.getString(SapiAccount.ExtraProperty.EXTRA_PKG);
            this.f1805th = (long) jSONObject.getInt("tar_pkg_lst_pub_ts");
            this.f1804rg = jSONObject.getLong("last_fe_ts");
            this.f1806uk = h.de(jSONObject.getString("info"));
            this.f1807yj = jSONObject.getLong("tar_pkg_lst_up_ts");
            jSONObject.getInt("d_form_ver");
        }

        /* renamed from: switch  reason: not valid java name */
        public h.a m100switch() {
            return this.f1806uk;
        }

        public void th(C0101ad adVar) {
            uk(adVar.yj());
            o(adVar.qw());
        }

        public boolean uk(h.a aVar) {
            if (aVar.equals(this.f1806uk)) {
                return false;
            }
            this.f1806uk = aVar;
            ad(true);
            return true;
        }

        public long when() {
            return this.f1807yj;
        }

        public boolean yj(long j) {
            if (this.f1804rg == j) {
                return false;
            }
            this.f1804rg = j;
            ad(true);
            return true;
        }
    }

    public static class qw {
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

        public static boolean qw(qw.C0104qw qwVar, fe.fe.fe.yj.qw qwVar2) {
            if (Build.VERSION.SDK_INT < 23) {
                while (qwVar != null && !qwVar.th().equals(qwVar2.qw())) {
                    qwVar.th().setExecutable(true, false);
                    qwVar = qwVar.i();
                }
                return true;
            }
            while (qwVar != null) {
                if (!ad(qwVar.th())) {
                    return false;
                }
                qwVar = qwVar.i();
            }
            return ad(qwVar2.qw());
        }
    }

    public ad() {
        super("isc", 8000000);
    }

    public static boolean i(File file, boolean z) {
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
        h.a yj2;
        de deVar = null;
        boolean z = false;
        try {
            packageInfo = this.qw.qw.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return qw.uk.qw(-2);
        }
        if (yjVar.qw) {
            deVar = new de(this, str);
            deVar.de();
            if (str.equals(deVar.pf())) {
                h.a aVar = deVar.m100switch();
                boolean z2 = packageInfo.lastUpdateTime == deVar.when();
                if (aVar != null && aVar.xxx() && !TextUtils.isEmpty(aVar.ddd())) {
                    z = true;
                }
                if (z2 && z) {
                    yj2 = deVar.m100switch();
                    return qw.uk.ad(yj2);
                }
            }
        }
        C0101ad adVar = new C0101ad();
        if (!adVar.rg(packageInfo)) {
            return qw.uk.qw(-2);
        }
        if (yjVar.qw && deVar != null) {
            deVar.th(adVar);
            deVar.yj(System.currentTimeMillis());
            deVar.m99if(packageInfo.lastUpdateTime);
            deVar.i(str);
            deVar.rg();
        }
        yj2 = adVar.yj();
        return qw.uk.ad(yj2);
    }

    public final void o() {
        this.f1797yj.de((long) (qw.qw(this.f1796th, this.qw.f1828ad) ? 1 : 2), 3);
    }

    public qw.th qw(qw.rg rgVar, h.a aVar) {
        Context context = this.qw.qw;
        if (Build.VERSION.SDK_INT >= 28 && context.getApplicationInfo().targetSdkVersion >= 28) {
            return qw.th.qw(-100);
        }
        this.f1797yj.uk();
        try {
            return uk(rgVar, aVar);
        } finally {
            this.f1797yj.i();
            o();
            this.f1797yj.i();
            this.f1797yj.o();
        }
    }

    public void rg(qw.fe feVar) {
        this.f1796th = this.f1825ad.ad("isc");
    }

    public final qw.th uk(qw.rg rgVar, h.a aVar) {
        this.f1797yj.uk();
        this.f1796th.fe();
        if (aVar.equals(this.f1797yj.yj())) {
            return qw.th.ad();
        }
        this.f1797yj.fe(aVar);
        this.f1797yj.ad(System.currentTimeMillis());
        return qw.th.ad();
    }
}
