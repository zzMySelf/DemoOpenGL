package fe.rg.qw.o.fe.mmm;

import android.graphics.Bitmap;
import androidx.annotation.VisibleForTesting;
import com.dlife.ctaccountapi.x;
import fe.rg.qw.ggg.i;

public class ad implements o {

    /* renamed from: ad  reason: collision with root package name */
    public final th<qw, Bitmap> f4798ad = new th<>();
    public final C0206ad qw = new C0206ad();

    @VisibleForTesting
    /* renamed from: fe.rg.qw.o.fe.mmm.ad$ad  reason: collision with other inner class name */
    public static class C0206ad extends de<qw> {
        /* renamed from: fe */
        public qw qw() {
            return new qw(this);
        }

        public qw rg(int i2, int i3, Bitmap.Config config) {
            qw qwVar = (qw) ad();
            qwVar.ad(i2, i3, config);
            return qwVar;
        }
    }

    @VisibleForTesting
    public static class qw implements pf {

        /* renamed from: ad  reason: collision with root package name */
        public int f4799ad;

        /* renamed from: de  reason: collision with root package name */
        public int f4800de;

        /* renamed from: fe  reason: collision with root package name */
        public Bitmap.Config f4801fe;
        public final C0206ad qw;

        public qw(C0206ad adVar) {
            this.qw = adVar;
        }

        public void ad(int i2, int i3, Bitmap.Config config) {
            this.f4799ad = i2;
            this.f4800de = i3;
            this.f4801fe = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof qw)) {
                return false;
            }
            qw qwVar = (qw) obj;
            if (this.f4799ad == qwVar.f4799ad && this.f4800de == qwVar.f4800de && this.f4801fe == qwVar.f4801fe) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i2 = ((this.f4799ad * 31) + this.f4800de) * 31;
            Bitmap.Config config = this.f4801fe;
            return i2 + (config != null ? config.hashCode() : 0);
        }

        public void qw() {
            this.qw.de(this);
        }

        public String toString() {
            return ad.th(this.f4799ad, this.f4800de, this.f4801fe);
        }
    }

    public static String th(int i2, int i3, Bitmap.Config config) {
        return "[" + i2 + x.a + i3 + "], " + config;
    }

    public static String yj(Bitmap bitmap) {
        return th(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    public String ad(int i2, int i3, Bitmap.Config config) {
        return th(i2, i3, config);
    }

    public void de(Bitmap bitmap) {
        this.f4798ad.fe(this.qw.rg(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    public Bitmap fe(int i2, int i3, Bitmap.Config config) {
        return this.f4798ad.qw(this.qw.rg(i2, i3, config));
    }

    public String qw(Bitmap bitmap) {
        return yj(bitmap);
    }

    public Bitmap removeLast() {
        return this.f4798ad.th();
    }

    public int rg(Bitmap bitmap) {
        return i.yj(bitmap);
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.f4798ad;
    }
}
