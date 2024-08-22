package fe.uk.qw.pf.fe;

import androidx.annotation.NonNull;
import com.dxmbumptech.glide.load.Key;
import com.dxmbumptech.glide.load.Transformation;
import com.dxmbumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import fe.uk.qw.pf.ad;
import fe.uk.qw.vvv.o;
import fe.uk.qw.vvv.th;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public final class xxx implements Key {

    /* renamed from: o  reason: collision with root package name */
    public static final th<Class<?>, byte[]> f5881o = new th<>(50);

    /* renamed from: ad  reason: collision with root package name */
    public final ArrayPool f5882ad;

    /* renamed from: de  reason: collision with root package name */
    public final Key f5883de;

    /* renamed from: fe  reason: collision with root package name */
    public final Key f5884fe;

    /* renamed from: i  reason: collision with root package name */
    public final Transformation<?> f5885i;

    /* renamed from: rg  reason: collision with root package name */
    public final int f5886rg;

    /* renamed from: th  reason: collision with root package name */
    public final int f5887th;

    /* renamed from: uk  reason: collision with root package name */
    public final ad f5888uk;

    /* renamed from: yj  reason: collision with root package name */
    public final Class<?> f5889yj;

    public xxx(ArrayPool arrayPool, Key key, Key key2, int i2, int i3, Transformation<?> transformation, Class<?> cls, ad adVar) {
        this.f5882ad = arrayPool;
        this.f5883de = key;
        this.f5884fe = key2;
        this.f5886rg = i2;
        this.f5887th = i3;
        this.f5885i = transformation;
        this.f5889yj = cls;
        this.f5888uk = adVar;
    }

    public final byte[] de() {
        byte[] yj2 = f5881o.yj(this.f5889yj);
        if (yj2 != null) {
            return yj2;
        }
        byte[] bytes = this.f5889yj.getName().getBytes(Key.qw);
        f5881o.pf(this.f5889yj, bytes);
        return bytes;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof xxx)) {
            return false;
        }
        xxx xxx = (xxx) obj;
        if (this.f5887th != xxx.f5887th || this.f5886rg != xxx.f5886rg || !o.de(this.f5885i, xxx.f5885i) || !this.f5889yj.equals(xxx.f5889yj) || !this.f5883de.equals(xxx.f5883de) || !this.f5884fe.equals(xxx.f5884fe) || !this.f5888uk.equals(xxx.f5888uk)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = (((((this.f5883de.hashCode() * 31) + this.f5884fe.hashCode()) * 31) + this.f5886rg) * 31) + this.f5887th;
        Transformation<?> transformation = this.f5885i;
        if (transformation != null) {
            hashCode = (hashCode * 31) + transformation.hashCode();
        }
        return (((hashCode * 31) + this.f5889yj.hashCode()) * 31) + this.f5888uk.hashCode();
    }

    public void qw(@NonNull MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f5882ad.fe(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f5886rg).putInt(this.f5887th).array();
        this.f5884fe.qw(messageDigest);
        this.f5883de.qw(messageDigest);
        messageDigest.update(bArr);
        Transformation<?> transformation = this.f5885i;
        if (transformation != null) {
            transformation.qw(messageDigest);
        }
        this.f5888uk.qw(messageDigest);
        messageDigest.update(de());
        this.f5882ad.put(bArr);
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f5883de + ", signature=" + this.f5884fe + ", width=" + this.f5886rg + ", height=" + this.f5887th + ", decodedResourceClass=" + this.f5889yj + ", transformation='" + this.f5885i + ExtendedMessageFormat.QUOTE + ", options=" + this.f5888uk + ExtendedMessageFormat.END_FE;
    }
}
