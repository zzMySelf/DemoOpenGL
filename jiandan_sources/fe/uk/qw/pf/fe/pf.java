package fe.uk.qw.pf.fe;

import androidx.annotation.NonNull;
import com.dxmbumptech.glide.load.Key;
import com.dxmbumptech.glide.load.Transformation;
import fe.uk.qw.pf.ad;
import fe.uk.qw.vvv.i;
import java.security.MessageDigest;
import java.util.Map;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class pf implements Key {

    /* renamed from: ad  reason: collision with root package name */
    public final Object f5813ad;

    /* renamed from: de  reason: collision with root package name */
    public final int f5814de;

    /* renamed from: fe  reason: collision with root package name */
    public final int f5815fe;

    /* renamed from: i  reason: collision with root package name */
    public final ad f5816i;

    /* renamed from: o  reason: collision with root package name */
    public int f5817o;

    /* renamed from: rg  reason: collision with root package name */
    public final Class<?> f5818rg;

    /* renamed from: th  reason: collision with root package name */
    public final Class<?> f5819th;

    /* renamed from: uk  reason: collision with root package name */
    public final Map<Class<?>, Transformation<?>> f5820uk;

    /* renamed from: yj  reason: collision with root package name */
    public final Key f5821yj;

    public pf(Object obj, Key key, int i2, int i3, Map<Class<?>, Transformation<?>> map, Class<?> cls, Class<?> cls2, ad adVar) {
        i.fe(obj);
        this.f5813ad = obj;
        i.rg(key, "Signature must not be null");
        this.f5821yj = key;
        this.f5814de = i2;
        this.f5815fe = i3;
        i.fe(map);
        this.f5820uk = map;
        i.rg(cls, "Resource class must not be null");
        this.f5818rg = cls;
        i.rg(cls2, "Transcode class must not be null");
        this.f5819th = cls2;
        i.fe(adVar);
        this.f5816i = adVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof pf)) {
            return false;
        }
        pf pfVar = (pf) obj;
        if (!this.f5813ad.equals(pfVar.f5813ad) || !this.f5821yj.equals(pfVar.f5821yj) || this.f5815fe != pfVar.f5815fe || this.f5814de != pfVar.f5814de || !this.f5820uk.equals(pfVar.f5820uk) || !this.f5818rg.equals(pfVar.f5818rg) || !this.f5819th.equals(pfVar.f5819th) || !this.f5816i.equals(pfVar.f5816i)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        if (this.f5817o == 0) {
            int hashCode = this.f5813ad.hashCode();
            this.f5817o = hashCode;
            int hashCode2 = (hashCode * 31) + this.f5821yj.hashCode();
            this.f5817o = hashCode2;
            int i2 = (hashCode2 * 31) + this.f5814de;
            this.f5817o = i2;
            int i3 = (i2 * 31) + this.f5815fe;
            this.f5817o = i3;
            int hashCode3 = (i3 * 31) + this.f5820uk.hashCode();
            this.f5817o = hashCode3;
            int hashCode4 = (hashCode3 * 31) + this.f5818rg.hashCode();
            this.f5817o = hashCode4;
            int hashCode5 = (hashCode4 * 31) + this.f5819th.hashCode();
            this.f5817o = hashCode5;
            this.f5817o = (hashCode5 * 31) + this.f5816i.hashCode();
        }
        return this.f5817o;
    }

    public void qw(@NonNull MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return "EngineKey{model=" + this.f5813ad + ", width=" + this.f5814de + ", height=" + this.f5815fe + ", resourceClass=" + this.f5818rg + ", transcodeClass=" + this.f5819th + ", signature=" + this.f5821yj + ", hashCode=" + this.f5817o + ", transformations=" + this.f5820uk + ", options=" + this.f5816i + ExtendedMessageFormat.END_FE;
    }
}
