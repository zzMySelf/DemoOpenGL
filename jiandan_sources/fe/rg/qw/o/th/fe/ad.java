package fe.rg.qw.o.th.fe;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Resource;
import fe.rg.qw.ggg.uk;

public class ad implements Resource<byte[]> {

    /* renamed from: ad  reason: collision with root package name */
    public final byte[] f4984ad;

    public ad(byte[] bArr) {
        uk.fe(bArr);
        this.f4984ad = bArr;
    }

    @NonNull
    public Class<byte[]> ad() {
        return byte[].class;
    }

    @NonNull
    /* renamed from: de */
    public byte[] get() {
        return this.f4984ad;
    }

    public int qw() {
        return this.f4984ad.length;
    }

    public void recycle() {
    }
}
