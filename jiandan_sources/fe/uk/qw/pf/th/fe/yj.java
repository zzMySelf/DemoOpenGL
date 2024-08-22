package fe.uk.qw.pf.th.fe;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.dxmbumptech.glide.load.ResourceDecoder;
import com.dxmbumptech.glide.load.engine.Resource;
import com.dxmbumptech.glide.load.resource.bitmap.Downsampler;
import fe.uk.qw.pf.ad;
import fe.uk.qw.vvv.qw;
import java.io.IOException;
import java.nio.ByteBuffer;

public class yj implements ResourceDecoder<ByteBuffer, Bitmap> {
    public final Downsampler qw;

    public yj(Downsampler downsampler) {
        this.qw = downsampler;
    }

    /* renamed from: de */
    public Resource<Bitmap> ad(@NonNull ByteBuffer byteBuffer, int i2, int i3, @NonNull ad adVar) throws IOException {
        return this.qw.th(qw.th(byteBuffer), i2, i3, adVar);
    }

    /* renamed from: fe */
    public boolean qw(@NonNull ByteBuffer byteBuffer, @NonNull ad adVar) {
        return this.qw.vvv(byteBuffer);
    }
}
