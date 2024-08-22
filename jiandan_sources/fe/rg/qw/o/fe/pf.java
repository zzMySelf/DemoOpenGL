package fe.rg.qw.o.fe;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import fe.rg.qw.ggg.uk;
import fe.rg.qw.o.ad;
import java.security.MessageDigest;
import java.util.Map;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class pf implements Key {

    /* renamed from: ad  reason: collision with root package name */
    public final Object f4838ad;

    /* renamed from: de  reason: collision with root package name */
    public final int f4839de;

    /* renamed from: fe  reason: collision with root package name */
    public final int f4840fe;

    /* renamed from: i  reason: collision with root package name */
    public final ad f4841i;

    /* renamed from: o  reason: collision with root package name */
    public int f4842o;

    /* renamed from: rg  reason: collision with root package name */
    public final Class<?> f4843rg;

    /* renamed from: th  reason: collision with root package name */
    public final Class<?> f4844th;

    /* renamed from: uk  reason: collision with root package name */
    public final Map<Class<?>, Transformation<?>> f4845uk;

    /* renamed from: yj  reason: collision with root package name */
    public final Key f4846yj;

    public pf(Object obj, Key key, int i2, int i3, Map<Class<?>, Transformation<?>> map, Class<?> cls, Class<?> cls2, ad adVar) {
        uk.fe(obj);
        this.f4838ad = obj;
        uk.rg(key, "Signature must not be null");
        this.f4846yj = key;
        this.f4839de = i2;
        this.f4840fe = i3;
        uk.fe(map);
        this.f4845uk = map;
        uk.rg(cls, "Resource class must not be null");
        this.f4843rg = cls;
        uk.rg(cls2, "Transcode class must not be null");
        this.f4844th = cls2;
        uk.fe(adVar);
        this.f4841i = adVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof pf)) {
            return false;
        }
        pf pfVar = (pf) obj;
        if (!this.f4838ad.equals(pfVar.f4838ad) || !this.f4846yj.equals(pfVar.f4846yj) || this.f4840fe != pfVar.f4840fe || this.f4839de != pfVar.f4839de || !this.f4845uk.equals(pfVar.f4845uk) || !this.f4843rg.equals(pfVar.f4843rg) || !this.f4844th.equals(pfVar.f4844th) || !this.f4841i.equals(pfVar.f4841i)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        if (this.f4842o == 0) {
            int hashCode = this.f4838ad.hashCode();
            this.f4842o = hashCode;
            int hashCode2 = (hashCode * 31) + this.f4846yj.hashCode();
            this.f4842o = hashCode2;
            int i2 = (hashCode2 * 31) + this.f4839de;
            this.f4842o = i2;
            int i3 = (i2 * 31) + this.f4840fe;
            this.f4842o = i3;
            int hashCode3 = (i3 * 31) + this.f4845uk.hashCode();
            this.f4842o = hashCode3;
            int hashCode4 = (hashCode3 * 31) + this.f4843rg.hashCode();
            this.f4842o = hashCode4;
            int hashCode5 = (hashCode4 * 31) + this.f4844th.hashCode();
            this.f4842o = hashCode5;
            this.f4842o = (hashCode5 * 31) + this.f4841i.hashCode();
        }
        return this.f4842o;
    }

    public void qw(@NonNull MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return "EngineKey{model=" + this.f4838ad + ", width=" + this.f4839de + ", height=" + this.f4840fe + ", resourceClass=" + this.f4843rg + ", transcodeClass=" + this.f4844th + ", signature=" + this.f4846yj + ", hashCode=" + this.f4842o + ", transformations=" + this.f4845uk + ", options=" + this.f4841i + ExtendedMessageFormat.END_FE;
    }
}
