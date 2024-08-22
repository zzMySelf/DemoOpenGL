package fe.uk.qw.pf.th.rg;

import androidx.annotation.NonNull;
import com.dxmbumptech.glide.load.engine.Resource;
import fe.uk.qw.vvv.i;

public class ad implements Resource<byte[]> {

    /* renamed from: ad  reason: collision with root package name */
    public final byte[] f5993ad;

    public ad(byte[] bArr) {
        i.fe(bArr);
        this.f5993ad = bArr;
    }

    @NonNull
    public Class<byte[]> ad() {
        return byte[].class;
    }

    @NonNull
    /* renamed from: de */
    public byte[] get() {
        return this.f5993ad;
    }

    public int qw() {
        return this.f5993ad.length;
    }

    public void recycle() {
    }
}
