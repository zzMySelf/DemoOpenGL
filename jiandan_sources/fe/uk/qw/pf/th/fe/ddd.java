package fe.uk.qw.pf.th.fe;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.dxmbumptech.glide.load.ResourceDecoder;
import com.dxmbumptech.glide.load.engine.Resource;
import com.dxmbumptech.glide.load.resource.bitmap.Downsampler;
import fe.uk.qw.pf.ad;
import java.io.IOException;

@RequiresApi(21)
public final class ddd implements ResourceDecoder<ParcelFileDescriptor, Bitmap> {
    public final Downsampler qw;

    public ddd(Downsampler downsampler) {
        this.qw = downsampler;
    }

    @Nullable
    /* renamed from: de */
    public Resource<Bitmap> ad(@NonNull ParcelFileDescriptor parcelFileDescriptor, int i2, int i3, @NonNull ad adVar) throws IOException {
        return this.qw.fe(parcelFileDescriptor, i2, i3, adVar);
    }

    /* renamed from: fe */
    public boolean qw(@NonNull ParcelFileDescriptor parcelFileDescriptor, @NonNull ad adVar) {
        return this.qw.ppp(parcelFileDescriptor);
    }
}
