package fe.rg.qw.o.th.de;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import fe.rg.qw.ggg.uk;
import fe.rg.qw.o.ad;
import java.io.IOException;

public class qw<DataType> implements ResourceDecoder<DataType, BitmapDrawable> {

    /* renamed from: ad  reason: collision with root package name */
    public final Resources f4972ad;
    public final ResourceDecoder<DataType, Bitmap> qw;

    public qw(@NonNull Resources resources, @NonNull ResourceDecoder<DataType, Bitmap> resourceDecoder) {
        uk.fe(resources);
        this.f4972ad = resources;
        uk.fe(resourceDecoder);
        this.qw = resourceDecoder;
    }

    public Resource<BitmapDrawable> ad(@NonNull DataType datatype, int i2, int i3, @NonNull ad adVar) throws IOException {
        return ppp.fe(this.f4972ad, this.qw.ad(datatype, i2, i3, adVar));
    }

    public boolean qw(@NonNull DataType datatype, @NonNull ad adVar) throws IOException {
        return this.qw.qw(datatype, adVar);
    }
}
