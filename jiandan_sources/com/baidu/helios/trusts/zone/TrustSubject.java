package com.baidu.helios.trusts.zone;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.helios.common.gene.interfaces.HeliosKey;
import fe.fe.pf.yj.fe.de.rg;
import fe.fe.pf.yj.rg.qw;
import java.io.File;
import java.io.FileFilter;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TrustSubject {

    /* renamed from: uk  reason: collision with root package name */
    public static Comparator<TrustSubject> f841uk = new ad();

    /* renamed from: yj  reason: collision with root package name */
    public static Comparator<TrustSubject> f842yj = new qw();

    /* renamed from: ad  reason: collision with root package name */
    public final fe.fe.pf.pf.qw.de.qw f843ad = new fe.fe.pf.pf.qw.de.qw();

    /* renamed from: de  reason: collision with root package name */
    public final fe.fe.pf.pf.qw.ad.qw f844de = new fe.fe.pf.pf.qw.ad.qw();

    /* renamed from: fe  reason: collision with root package name */
    public Context f845fe;
    public final String qw;

    /* renamed from: rg  reason: collision with root package name */
    public qw.C0142qw f846rg;

    /* renamed from: th  reason: collision with root package name */
    public de f847th = new de();

    public static class ConfigNotFoundException extends Exception {
        public ConfigNotFoundException(String str) {
            super(str);
        }

        public ConfigNotFoundException(String str, Throwable th2) {
            super(str, th2);
        }

        public ConfigNotFoundException(Throwable th2) {
            super(th2);
        }
    }

    public class ad implements Comparator<TrustSubject> {
        /* renamed from: qw */
        public int compare(TrustSubject trustSubject, TrustSubject trustSubject2) {
            int i2 = ((trustSubject.f847th.th() - trustSubject2.f847th.th()) > 0 ? 1 : ((trustSubject.f847th.th() - trustSubject2.f847th.th()) == 0 ? 0 : -1));
            if (i2 != 0) {
                return i2 > 0 ? -1 : 1;
            }
            return trustSubject.qw.compareTo(trustSubject2.qw);
        }
    }

    public class de {

        /* renamed from: ad  reason: collision with root package name */
        public long f848ad;

        /* renamed from: de  reason: collision with root package name */
        public long f849de;

        /* renamed from: fe  reason: collision with root package name */
        public long f850fe;
        public int qw;

        /* renamed from: rg  reason: collision with root package name */
        public long f852rg;

        /* renamed from: th  reason: collision with root package name */
        public rg f853th = new rg();

        /* renamed from: uk  reason: collision with root package name */
        public Set<String> f854uk = new HashSet();

        /* renamed from: yj  reason: collision with root package name */
        public boolean f855yj = true;

        public de() {
        }

        public long ad() {
            return this.f852rg;
        }

        public long de(long j) {
            return this.f853th.qw(j);
        }

        public long fe() {
            return this.f848ad;
        }

        public boolean ggg(boolean z) {
            return m23if(z ? 1 : 2, 3);
        }

        public void i() {
            String yj2 = TrustSubject.this.f846rg.yj("ts_info", true);
            if (!TextUtils.isEmpty(yj2)) {
                try {
                    JSONObject jSONObject = new JSONObject(yj2);
                    this.f848ad = jSONObject.getLong("last_update_time");
                    this.qw = jSONObject.getInt("version_code");
                    this.f849de = jSONObject.getLong("trust_priority");
                    this.f850fe = jSONObject.getLong("quick_config_version");
                    this.f852rg = jSONObject.getLong("config_version");
                    this.f853th.ad(jSONObject.getLong("flags"));
                    this.f854uk.clear();
                    JSONArray optJSONArray = jSONObject.optJSONArray("pkg_sigs");
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            this.f854uk.add(optJSONArray.getString(i2));
                        }
                    }
                    this.f855yj = false;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        /* renamed from: if  reason: not valid java name */
        public boolean m23if(long j, long j2) {
            if (!this.f853th.de(j, j2)) {
                return false;
            }
            this.f855yj = true;
            return true;
        }

        public boolean o() {
            if (this.f855yj) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("last_update_time", this.f848ad);
                    jSONObject.put("version_code", this.qw);
                    jSONObject.put("trust_priority", this.f849de);
                    jSONObject.put("quick_config_version", this.f850fe);
                    jSONObject.put("config_version", this.f852rg);
                    jSONObject.put("flags", this.f853th.fe());
                    if (this.f854uk.size() > 0) {
                        JSONArray jSONArray = new JSONArray();
                        for (String put : this.f854uk) {
                            jSONArray.put(put);
                        }
                        jSONObject.put("pkg_sigs", jSONArray);
                    }
                    TrustSubject.this.f846rg.i("ts_info", jSONObject.toString(), true);
                    this.f855yj = false;
                    return true;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return false;
        }

        public boolean pf(long j) {
            if (this.f852rg == j) {
                return false;
            }
            this.f852rg = j;
            this.f855yj = true;
            return true;
        }

        public boolean ppp(long j) {
            if (this.f850fe == j) {
                return false;
            }
            this.f850fe = j;
            return true;
        }

        public Set<String> rg() {
            return this.f854uk;
        }

        /* renamed from: switch  reason: not valid java name */
        public boolean m24switch(long j) {
            if (this.f848ad == j) {
                return false;
            }
            this.f848ad = j;
            this.f855yj = true;
            return true;
        }

        public long th() {
            return this.f850fe;
        }

        public int uk() {
            return this.qw;
        }

        public boolean vvv(long j) {
            if (this.f849de == j) {
                return false;
            }
            this.f849de = j;
            this.f855yj = true;
            return true;
        }

        public void when(Set<String> set) {
            if (set == null || set.size() == 0) {
                if (this.f854uk.size() != 0) {
                    this.f854uk.clear();
                    this.f855yj = true;
                }
            } else if (!this.f854uk.equals(set)) {
                this.f854uk.clear();
                this.f854uk.addAll(set);
                this.f855yj = true;
            }
        }

        public boolean xxx(int i2) {
            if (this.qw == i2) {
                return false;
            }
            this.qw = i2;
            this.f855yj = true;
            return true;
        }

        public long yj() {
            return this.f849de;
        }
    }

    public static class fe implements FileFilter {
        public boolean accept(File file) {
            return file.isDirectory() && file.getName().startsWith("pkg-");
        }
    }

    public class qw implements Comparator<TrustSubject> {
        /* renamed from: qw */
        public int compare(TrustSubject trustSubject, TrustSubject trustSubject2) {
            int i2 = ((trustSubject.f847th.yj() - trustSubject2.f847th.yj()) > 0 ? 1 : ((trustSubject.f847th.yj() - trustSubject2.f847th.yj()) == 0 ? 0 : -1));
            if (i2 != 0) {
                return i2 > 0 ? -1 : 1;
            }
            return trustSubject.qw.compareTo(trustSubject2.qw);
        }
    }

    public TrustSubject(String str, Context context, qw.C0142qw qwVar) {
        this.f845fe = context;
        this.qw = str;
        this.f846rg = qwVar.th(fe(str));
        de();
    }

    public static String ddd(String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 4) {
            return null;
        }
        try {
            return new String(Base64.decode(str.substring(4), 3));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String fe(String str) {
        return "pkg-" + Base64.encodeToString(str.getBytes(), 3);
    }

    public void aaa() {
        try {
            PackageInfo packageInfo = this.f845fe.getPackageManager().getPackageInfo(this.qw, 0);
            long j = packageInfo.lastUpdateTime;
            int i2 = packageInfo.versionCode;
            this.f847th.m24switch(j);
            this.f847th.xxx(i2);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    public final void de() {
        this.f843ad.qw(this.qw, this.f845fe);
        this.f844de.ad(this.qw, this.f845fe, this.f846rg);
    }

    public void eee(HeliosKey heliosKey) {
        this.f843ad.th(heliosKey, true);
        this.f847th.ggg(this.f843ad.uk());
        this.f847th.vvv(this.f843ad.fe());
        this.f847th.when(this.f843ad.de());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrustSubject.class != obj.getClass()) {
            return false;
        }
        return this.qw.equals(((TrustSubject) obj).qw);
    }

    public boolean ggg() {
        return this.f847th.th() == this.f847th.ad();
    }

    public int hashCode() {
        return this.qw.hashCode();
    }

    public String i(String str) throws ConfigNotFoundException {
        this.f844de.pf();
        return this.f844de.th(str);
    }

    /* renamed from: if  reason: not valid java name */
    public long m21if() {
        return this.f847th.yj();
    }

    public boolean mmm() {
        int qw2 = this.f844de.qw();
        if (qw2 == 0) {
            this.f847th.m23if(16, 48);
            this.f847th.m23if(64, 64);
            this.f847th.m23if(4, 12);
            xxx();
            this.f847th.pf(this.f844de.i());
            return true;
        } else if (qw2 != 3) {
            this.f847th.m23if(32, 48);
            this.f847th.m23if(0, 64);
            return false;
        } else {
            this.f847th.m23if(32, 48);
            this.f847th.m23if(8, 12);
            return false;
        }
    }

    public boolean nn() {
        return this.f847th.o();
    }

    public Set<String> o() {
        return new HashSet(this.f847th.rg());
    }

    public long pf() {
        return this.f847th.f852rg;
    }

    public boolean ppp() {
        PackageInfo packageInfo;
        try {
            packageInfo = this.f845fe.getPackageManager().getPackageInfo(this.qw, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public void qqq() {
        long o2 = this.f844de.o();
        if (o2 > -1) {
            this.f847th.m23if(128, 384);
        } else {
            this.f847th.m23if(256, 384);
        }
        this.f847th.ppp(o2);
    }

    public void rg() {
        this.f844de.de();
    }

    /* renamed from: switch  reason: not valid java name */
    public void m22switch() {
        this.f847th.i();
    }

    public void th() {
        this.f844de.fe();
    }

    public de uk() {
        return this.f847th;
    }

    public boolean vvv() {
        try {
            PackageInfo packageInfo = this.f845fe.getPackageManager().getPackageInfo(this.qw, 0);
            long j = packageInfo.lastUpdateTime;
            int i2 = packageInfo.versionCode;
            if (this.f847th.fe() == j && this.f847th.uk() == i2) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean when() {
        return this.f847th.de(12) == 4;
    }

    public void xxx() {
        this.f844de.pf();
    }

    public void yj() {
        this.f844de.rg();
        this.f847th.m23if(0, 64);
    }
}
