package fe.uk.qw.pf.fe.mmm;

import android.graphics.Bitmap;
import androidx.annotation.VisibleForTesting;
import com.dlife.ctaccountapi.x;
import fe.uk.qw.vvv.o;

public class ad implements o {

    /* renamed from: ad  reason: collision with root package name */
    public final th<qw, Bitmap> f5771ad = new th<>();
    public final C0232ad qw = new C0232ad();

    @VisibleForTesting
    /* renamed from: fe.uk.qw.pf.fe.mmm.ad$ad  reason: collision with other inner class name */
    public static class C0232ad extends de<qw> {
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
        public int f5772ad;

        /* renamed from: de  reason: collision with root package name */
        public int f5773de;

        /* renamed from: fe  reason: collision with root package name */
        public Bitmap.Config f5774fe;
        public final C0232ad qw;

        public qw(C0232ad adVar) {
            this.qw = adVar;
        }

        public void ad(int i2, int i3, Bitmap.Config config) {
            this.f5772ad = i2;
            this.f5773de = i3;
            this.f5774fe = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof qw)) {
                return false;
            }
            qw qwVar = (qw) obj;
            if (this.f5772ad == qwVar.f5772ad && this.f5773de == qwVar.f5773de && this.f5774fe == qwVar.f5774fe) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i2 = ((this.f5772ad * 31) + this.f5773de) * 31;
            Bitmap.Config config = this.f5774fe;
            return i2 + (config != null ? config.hashCode() : 0);
        }

        public void qw() {
            this.qw.de(this);
        }

        public String toString() {
            return ad.th(this.f5772ad, this.f5773de, this.f5774fe);
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
        this.f5771ad.fe(this.qw.rg(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    public Bitmap fe(int i2, int i3, Bitmap.Config config) {
        return this.f5771ad.qw(this.qw.rg(i2, i3, config));
    }

    public String qw(Bitmap bitmap) {
        return yj(bitmap);
    }

    public Bitmap removeLast() {
        return this.f5771ad.th();
    }

    public int rg(Bitmap bitmap) {
        return o.yj(bitmap);
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.f5771ad;
    }
}
