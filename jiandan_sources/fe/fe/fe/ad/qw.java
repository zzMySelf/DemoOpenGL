package fe.fe.fe.ad;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.cesium.h;
import fe.fe.fe.yj.qw;
import java.util.Comparator;
import org.json.JSONObject;

public abstract class qw {

    /* renamed from: rg  reason: collision with root package name */
    public static Comparator<qw> f1824rg = new C0103qw();

    /* renamed from: ad  reason: collision with root package name */
    public qw.C0104qw f1825ad;

    /* renamed from: de  reason: collision with root package name */
    public final String f1826de;

    /* renamed from: fe  reason: collision with root package name */
    public long f1827fe;
    public ad qw;

    public static class ad {

        /* renamed from: ad  reason: collision with root package name */
        public fe.fe.fe.yj.qw f1828ad;
        public Context qw;
    }

    public static abstract class de {

        /* renamed from: ad  reason: collision with root package name */
        public String f1829ad;

        /* renamed from: de  reason: collision with root package name */
        public boolean f1830de = true;
        public qw.C0104qw qw;

        public de(qw.C0104qw qwVar, String str) {
            this.qw = qwVar;
            this.f1829ad = "target-pkg-" + Base64.encodeToString(str.getBytes(), 3);
        }

        public void ad(boolean z) {
            this.f1830de = z;
        }

        public boolean de() {
            String de2 = this.qw.de(this.f1829ad, true);
            if (!TextUtils.isEmpty(de2)) {
                try {
                    qw(new JSONObject(de2));
                    ad(false);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public abstract void fe(JSONObject jSONObject);

        public abstract void qw(JSONObject jSONObject);

        public boolean rg() {
            if (this.f1830de) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    fe(jSONObject);
                    this.qw.rg(this.f1829ad, jSONObject.toString(), true);
                    ad(false);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    public static class fe {
    }

    /* renamed from: fe.fe.fe.ad.qw$qw  reason: collision with other inner class name */
    public static class C0103qw implements Comparator<qw> {
        /* renamed from: qw */
        public int compare(qw qwVar, qw qwVar2) {
            int i2 = ((qwVar.th() - qwVar2.th()) > 0 ? 1 : ((qwVar.th() - qwVar2.th()) == 0 ? 0 : -1));
            return i2 != 0 ? i2 > 0 ? -1 : 1 : qwVar.de().compareTo(qwVar2.de());
        }
    }

    public static class rg {
    }

    public static class th {
        public th(int i2, int i3, Exception exc) {
        }

        public static th ad() {
            return new th(0, 0, (Exception) null);
        }

        public static th de() {
            return qw(0);
        }

        public static th qw(int i2) {
            return new th(-1, i2, (Exception) null);
        }
    }

    public static class uk {

        /* renamed from: ad  reason: collision with root package name */
        public int f1831ad;
        public h.a qw;

        public uk(int i2, h.a aVar, Exception exc) {
            this.f1831ad = i2;
            this.qw = aVar;
        }

        public static uk ad(h.a aVar) {
            return new uk(0, aVar, (Exception) null);
        }

        public static uk fe() {
            return new uk(-1, (h.a) null, (Exception) null);
        }

        public static uk qw(int i2) {
            return new uk(i2, (h.a) null, (Exception) null);
        }

        public boolean de() {
            return this.f1831ad == 0;
        }
    }

    public static class yj {
        public boolean qw;
    }

    public qw(String str, long j) {
        this.f1826de = str;
        this.f1827fe = j;
    }

    public abstract uk ad(String str, yj yjVar);

    public String de() {
        return this.f1826de;
    }

    public final void fe(ad adVar) {
        this.qw = adVar;
        this.f1825ad = adVar.f1828ad.rg().ad("cs");
    }

    public abstract th qw(rg rgVar, h.a aVar);

    public abstract void rg(fe feVar);

    public long th() {
        return this.f1827fe;
    }
}
