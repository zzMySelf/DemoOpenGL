package fe.uk.qw.pf.th.fe;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import com.dxmbumptech.glide.load.ResourceDecoder;
import com.dxmbumptech.glide.load.engine.Resource;
import fe.uk.qw.pf.ad;
import fe.uk.qw.vvv.i;
import java.io.IOException;

public class qw<DataType> implements ResourceDecoder<DataType, BitmapDrawable> {

    /* renamed from: ad  reason: collision with root package name */
    public final Resources f5976ad;
    public final ResourceDecoder<DataType, Bitmap> qw;

    public qw(@NonNull Resources resources, @NonNull ResourceDecoder<DataType, Bitmap> resourceDecoder) {
        i.fe(resources);
        this.f5976ad = resources;
        i.fe(resourceDecoder);
        this.qw = resourceDecoder;
    }

    public Resource<BitmapDrawable> ad(@NonNull DataType datatype, int i2, int i3, @NonNull ad adVar) throws IOException {
        return xxx.fe(this.f5976ad, this.qw.ad(datatype, i2, i3, adVar));
    }

    public boolean qw(@NonNull DataType datatype, @NonNull ad adVar) throws IOException {
        return this.qw.qw(datatype, adVar);
    }
}
