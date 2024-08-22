package fe.rg.qw.o.fe;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import fe.rg.qw.ggg.i;
import fe.rg.qw.ggg.rg;
import fe.rg.qw.o.ad;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public final class xxx implements Key {

    /* renamed from: o  reason: collision with root package name */
    public static final rg<Class<?>, byte[]> f4905o = new rg<>(50);

    /* renamed from: ad  reason: collision with root package name */
    public final ArrayPool f4906ad;

    /* renamed from: de  reason: collision with root package name */
    public final Key f4907de;

    /* renamed from: fe  reason: collision with root package name */
    public final Key f4908fe;

    /* renamed from: i  reason: collision with root package name */
    public final Transformation<?> f4909i;

    /* renamed from: rg  reason: collision with root package name */
    public final int f4910rg;

    /* renamed from: th  reason: collision with root package name */
    public final int f4911th;

    /* renamed from: uk  reason: collision with root package name */
    public final ad f4912uk;

    /* renamed from: yj  reason: collision with root package name */
    public final Class<?> f4913yj;

    public xxx(ArrayPool arrayPool, Key key, Key key2, int i2, int i3, Transformation<?> transformation, Class<?> cls, ad adVar) {
        this.f4906ad = arrayPool;
        this.f4907de = key;
        this.f4908fe = key2;
        this.f4910rg = i2;
        this.f4911th = i3;
        this.f4909i = transformation;
        this.f4913yj = cls;
        this.f4912uk = adVar;
    }

    public final byte[] de() {
        byte[] yj2 = f4905o.yj(this.f4913yj);
        if (yj2 != null) {
            return yj2;
        }
        byte[] bytes = this.f4913yj.getName().getBytes(Key.qw);
        f4905o.pf(this.f4913yj, bytes);
        return bytes;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof xxx)) {
            return false;
        }
        xxx xxx = (xxx) obj;
        if (this.f4911th != xxx.f4911th || this.f4910rg != xxx.f4910rg || !i.de(this.f4909i, xxx.f4909i) || !this.f4913yj.equals(xxx.f4913yj) || !this.f4907de.equals(xxx.f4907de) || !this.f4908fe.equals(xxx.f4908fe) || !this.f4912uk.equals(xxx.f4912uk)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = (((((this.f4907de.hashCode() * 31) + this.f4908fe.hashCode()) * 31) + this.f4910rg) * 31) + this.f4911th;
        Transformation<?> transformation = this.f4909i;
        if (transformation != null) {
            hashCode = (hashCode * 31) + transformation.hashCode();
        }
        return (((hashCode * 31) + this.f4913yj.hashCode()) * 31) + this.f4912uk.hashCode();
    }

    public void qw(@NonNull MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f4906ad.fe(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f4910rg).putInt(this.f4911th).array();
        this.f4908fe.qw(messageDigest);
        this.f4907de.qw(messageDigest);
        messageDigest.update(bArr);
        Transformation<?> transformation = this.f4909i;
        if (transformation != null) {
            transformation.qw(messageDigest);
        }
        this.f4912uk.qw(messageDigest);
        messageDigest.update(de());
        this.f4906ad.put(bArr);
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f4907de + ", signature=" + this.f4908fe + ", width=" + this.f4910rg + ", height=" + this.f4911th + ", decodedResourceClass=" + this.f4913yj + ", transformation='" + this.f4909i + ExtendedMessageFormat.QUOTE + ", options=" + this.f4912uk + ExtendedMessageFormat.END_FE;
    }
}
