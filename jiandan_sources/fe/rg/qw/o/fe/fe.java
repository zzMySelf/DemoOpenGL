package fe.rg.qw.o.fe;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.engine.cache.DiskCache;
import fe.rg.qw.o.ad;
import java.io.File;

public class fe<DataType> implements DiskCache.Writer {

    /* renamed from: ad  reason: collision with root package name */
    public final DataType f4784ad;

    /* renamed from: de  reason: collision with root package name */
    public final ad f4785de;
    public final Encoder<DataType> qw;

    public fe(Encoder<DataType> encoder, DataType datatype, ad adVar) {
        this.qw = encoder;
        this.f4784ad = datatype;
        this.f4785de = adVar;
    }

    public boolean qw(@NonNull File file) {
        return this.qw.qw(this.f4784ad, file, this.f4785de);
    }
}
