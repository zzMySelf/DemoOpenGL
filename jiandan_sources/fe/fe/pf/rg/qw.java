package fe.fe.pf.rg;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.helios.ids.IdProviderFactory;
import fe.fe.pf.yj.rg.qw;
import java.util.Comparator;
import org.json.JSONObject;

public abstract class qw {

    /* renamed from: rg  reason: collision with root package name */
    public static Comparator<qw> f2858rg = new C0136qw();

    /* renamed from: ad  reason: collision with root package name */
    public qw.C0142qw f2859ad;

    /* renamed from: de  reason: collision with root package name */
    public final String f2860de;

    /* renamed from: fe  reason: collision with root package name */
    public long f2861fe;
    public ad qw;

    public static class ad {

        /* renamed from: ad  reason: collision with root package name */
        public fe.fe.pf.yj.rg.qw f2862ad;

        /* renamed from: de  reason: collision with root package name */
        public IdProviderFactory f2863de;
        public Context qw;
    }

    public static abstract class de {

        /* renamed from: ad  reason: collision with root package name */
        public String f2864ad;

        /* renamed from: de  reason: collision with root package name */
        public boolean f2865de = true;
        public qw.C0142qw qw;

        public de(qw.C0142qw qwVar, String str) {
            this.qw = qwVar;
            this.f2864ad = "target-pkg-" + Base64.encodeToString(str.getBytes(), 3);
        }

        public boolean ad() {
            if (this.f2865de) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    rg(jSONObject);
                    this.qw.i(this.f2864ad, jSONObject.toString(), true);
                    qw(false);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public abstract void de(JSONObject jSONObject);

        public boolean fe() {
            String yj2 = this.qw.yj(this.f2864ad, true);
            if (!TextUtils.isEmpty(yj2)) {
                try {
                    de(new JSONObject(yj2));
                    qw(false);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public void qw(boolean z) {
            this.f2865de = z;
        }

        public abstract void rg(JSONObject jSONObject);
    }

    public static class fe {
    }

    /* renamed from: fe.fe.pf.rg.qw$qw  reason: collision with other inner class name */
    public class C0136qw implements Comparator<qw> {
        /* renamed from: qw */
        public int compare(qw qwVar, qw qwVar2) {
            int i2 = ((qwVar.fe() - qwVar2.fe()) > 0 ? 1 : ((qwVar.fe() - qwVar2.fe()) == 0 ? 0 : -1));
            return i2 != 0 ? i2 > 0 ? -1 : 1 : qwVar.de().compareTo(qwVar2.de());
        }
    }

    public static class rg {
    }

    public static class th {
        public th(int i2, int i3, Exception exc) {
        }

        public static th ad(int i2) {
            return new th(-1, i2, (Exception) null);
        }

        public static th de(Exception exc) {
            return new th(-1, 0, exc);
        }

        public static th fe() {
            return new th(0, 0, (Exception) null);
        }

        public static th qw() {
            return ad(0);
        }
    }

    public static class uk {

        /* renamed from: ad  reason: collision with root package name */
        public int f2866ad;

        /* renamed from: de  reason: collision with root package name */
        public Object f2867de;
        public String qw;

        public uk(int i2, String str, Exception exc) {
            this.f2866ad = i2;
            this.qw = str;
        }

        public static uk ad(int i2) {
            return new uk(i2, (String) null, (Exception) null);
        }

        public static uk de(int i2, Exception exc) {
            return new uk(i2, (String) null, exc);
        }

        public static uk fe(Exception exc) {
            return new uk(-1, (String) null, exc);
        }

        public static uk qw() {
            return ad(-1);
        }

        public static uk th(String str) {
            return new uk(0, str, (Exception) null);
        }

        public boolean rg() {
            return this.f2866ad == 0;
        }
    }

    public static class yj {

        /* renamed from: ad  reason: collision with root package name */
        public boolean f2868ad;
        public boolean qw;
    }

    public qw(String str, long j) {
        this.f2860de = str;
        this.f2861fe = j;
    }

    public abstract uk ad(String str, yj yjVar);

    public String de() {
        return this.f2860de;
    }

    public long fe() {
        return this.f2861fe;
    }

    public final void qw(ad adVar) {
        this.qw = adVar;
        this.f2859ad = adVar.f2862ad.fe().th("cs");
    }

    public abstract void rg(fe feVar);

    public abstract th th(rg rgVar);

    public void yj(long j) {
        this.f2861fe = j;
    }
}
