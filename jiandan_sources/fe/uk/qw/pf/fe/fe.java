package fe.uk.qw.pf.fe;

import androidx.annotation.NonNull;
import com.dxmbumptech.glide.load.Encoder;
import com.dxmbumptech.glide.load.engine.cache.DiskCache;
import fe.uk.qw.pf.ad;
import java.io.File;

public class fe<DataType> implements DiskCache.Writer {

    /* renamed from: ad  reason: collision with root package name */
    public final DataType f5751ad;

    /* renamed from: de  reason: collision with root package name */
    public final ad f5752de;
    public final Encoder<DataType> qw;

    public fe(Encoder<DataType> encoder, DataType datatype, ad adVar) {
        this.qw = encoder;
        this.f5751ad = datatype;
        this.f5752de = adVar;
    }

    public boolean qw(@NonNull File file) {
        return this.qw.qw(this.f5751ad, file, this.f5752de);
    }
}
