package fe.fe.nn.qw;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import fe.fe.nn.ppp.ad;
import fe.fe.nn.ppp.de;
import fe.fe.nn.ppp.uk;
import java.util.UUID;
import org.json.JSONArray;

public class qw {

    /* renamed from: fe  reason: collision with root package name */
    public static volatile qw f2306fe;

    /* renamed from: ad  reason: collision with root package name */
    public final SharedPreferences f2307ad;

    /* renamed from: de  reason: collision with root package name */
    public SharedPreferences.Editor f2308de;
    public String qw;

    public qw(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("once_login_config", 0);
        this.f2307ad = sharedPreferences;
        context.getSharedPreferences("leroadcfg", 0);
        this.f2308de = sharedPreferences.edit();
        context.getApplicationContext();
    }

    public static qw uk(Context context) {
        if (f2306fe == null) {
            synchronized (qw.class) {
                if (f2306fe == null) {
                    f2306fe = new qw(context);
                }
            }
        }
        return f2306fe;
    }

    public void A(String str) {
        mmm("ky_n_ydc", str);
    }

    public void B(boolean z) {
        aaa("k_u_a_pr", z);
    }

    public int C() {
        return th("ky_lls", -1);
    }

    public long D() {
        return yj("ky_llt", 0);
    }

    public String E() {
        return i("last_Rp_d", "");
    }

    public long F() {
        return yj("rp_last_off_ti", 0);
    }

    public int G() {
        return th("ky_lvs", -1);
    }

    public long H() {
        return yj("ky_lvt", 0);
    }

    public String I() {
        return i("ky_n_ltc", "");
    }

    public String J() {
        return i("k_ma_code", "");
    }

    public int K() {
        int th2 = th("k_mask_num", 4);
        if (th2 <= 4) {
            return 4;
        }
        if (th2 >= 8) {
            return 8;
        }
        return th2;
    }

    public int L() {
        return th("one_d_3g_con", 50);
    }

    public long M() {
        return yj("ky_cfs_t", 0);
    }

    public int N() {
        return th("rp_off_gap", 3);
    }

    public String O() {
        return i("k_sdk_a_s", "");
    }

    public String P() {
        return i("ky_sg", "");
    }

    public long Q() {
        return yj("t_con_3g", 0);
    }

    public String R() {
        return i("ky_n_ydc", "");
    }

    public boolean S() {
        return ppp("k_sdk_cm_s", true);
    }

    public boolean T() {
        return ppp("k_sdk_ct_s", true);
    }

    public void a(long j) {
        nn("k_lt_crash_ts", j);
    }

    public final void aaa(String str, boolean z) {
        this.f2308de.putBoolean(str, z);
        this.f2308de.commit();
    }

    public boolean ad() {
        return ppp("k_crash_ck", true);
    }

    public void b(String str) {
        mmm("last_Rp_d", str);
    }

    public final void c(String str, int i2) {
        this.f2308de.putInt(str, i2);
        this.f2308de.commit();
    }

    public void d(String str, String str2) {
        if (str2 != null) {
            if (!TextUtils.isEmpty(str2)) {
                str2 = Base64.encodeToString(str2.getBytes(), 0);
            }
            mmm(str, str2);
        }
    }

    public void ddd(String str) {
        mmm("last_al_rp_d", str);
    }

    public boolean de() {
        return ppp("k_retry_switch", false);
    }

    public void e(boolean z) {
        aaa("k_sdk_cu_s", z);
    }

    public boolean eee(String str, int i2) {
        String i3 = i(str, "");
        if (!TextUtils.isEmpty(i3)) {
            try {
                JSONArray jSONArray = new JSONArray(new String(Base64.decode(i3, 0)));
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    if (jSONArray.getString(i4).equals(String.valueOf(i2))) {
                        return true;
                    }
                }
            } catch (Throwable th2) {
                de.fe(th2);
            }
        }
        return false;
    }

    public String f() {
        if (!TextUtils.isEmpty(this.qw)) {
            return this.qw;
        }
        String i2 = i("xyus", "");
        this.qw = i2;
        if (TextUtils.isEmpty(i2)) {
            String ad2 = uk.ad(UUID.randomUUID().toString());
            this.qw = ad2;
            mmm("xyus", ad2);
        }
        return this.qw;
    }

    public boolean fe() {
        return ppp("k_sdk_s", true);
    }

    public void g(long j) {
        nn("ky_llt", j);
    }

    public long ggg() {
        return yj("k_a_itl", ad.f2298ad * 24);
    }

    public void h(String str) {
        mmm("ky_n_ltc", str);
    }

    public final String i(String str, String str2) {
        return this.f2307ad.getString(str, str2);
    }

    /* renamed from: if  reason: not valid java name */
    public void m151if(long j) {
        nn("ky_cfo_t", j);
    }

    public void j(String str, String str2) {
        mmm("k_sdk_a_s", str + "_" + str2);
    }

    public void k(boolean z) {
        aaa("k_is_ig_env", z);
    }

    public String l() {
        return i("ky_n_dxc", "");
    }

    public void m(long j) {
        nn("rp_last_off_ti", j);
    }

    public final void mmm(String str, String str2) {
        this.f2308de.putString(str, str2);
        this.f2308de.commit();
    }

    public void n(String str) {
        if (!TextUtils.isEmpty(str)) {
            mmm("k_ma_code", str);
        }
    }

    public final void nn(String str, long j) {
        this.f2308de.putLong(str, j);
        this.f2308de.commit();
    }

    public void o() {
        mmm("k_sdk_a_s", "");
    }

    public void p(boolean z) {
        aaa("k_crash_ck", z);
    }

    public void pf(int i2) {
        c("ky_lls", i2);
    }

    public final boolean ppp(String str, boolean z) {
        return this.f2307ad.getBoolean(str, z);
    }

    public long q() {
        return yj("k_last_a_ts", 0);
    }

    public void qqq(boolean z) {
        aaa("k_sdk_ct_s", z);
    }

    public boolean qw() {
        return ppp("k_sdk_cu_s", true);
    }

    public void r(long j) {
        nn("ky_lvt", j);
    }

    public boolean rg() {
        return ppp("k_u_a_pr", false);
    }

    public long rrr() {
        return yj("ky_cfo_t", de.f2301de);
    }

    public void s(String str) {
        if (!TextUtils.isEmpty(str)) {
            mmm("k_sdk_ra_k", str);
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public void m152switch(String str) {
        mmm("ky_n_dxc", str);
    }

    public void t(boolean z) {
        aaa("k_retry_switch", z);
    }

    public final int th(String str, int i2) {
        return this.f2307ad.getInt(str, i2);
    }

    public void tt(int i2) {
        if (i2 > 4) {
            c("k_mask_num", i2);
        }
    }

    public String u() {
        return i("last_al_rp_d", "");
    }

    public void v(long j) {
        nn("ky_cfs_t", j);
    }

    public void vvv(int i2) {
        c("ky_lvs", i2);
    }

    public void w(String str) {
        mmm("ky_sg", str);
    }

    public void when(boolean z) {
        aaa("k_sdk_cm_s", z);
    }

    public void x(boolean z) {
        aaa("k_sdk_s", z);
    }

    public void xxx(long j) {
        nn("k_last_a_ts", j);
    }

    public long y() {
        return yj("k_lt_crash_ts", 0);
    }

    public final long yj(String str, long j) {
        return this.f2307ad.getLong(str, j);
    }

    public void z(long j) {
        nn("t_con_3g", j);
    }
}
