package fe.rg.qw.o.th.de;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import fe.rg.qw.ggg.qw;
import fe.rg.qw.o.ad;
import java.io.IOException;
import java.nio.ByteBuffer;

public class th implements ResourceDecoder<ByteBuffer, Bitmap> {
    public final Downsampler qw;

    public th(Downsampler downsampler) {
        this.qw = downsampler;
    }

    /* renamed from: de */
    public Resource<Bitmap> ad(@NonNull ByteBuffer byteBuffer, int i2, int i3, @NonNull ad adVar) throws IOException {
        return this.qw.fe(qw.rg(byteBuffer), i2, i3, adVar);
    }

    /* renamed from: fe */
    public boolean qw(@NonNull ByteBuffer byteBuffer, @NonNull ad adVar) {
        return this.qw.when(byteBuffer);
    }
}
