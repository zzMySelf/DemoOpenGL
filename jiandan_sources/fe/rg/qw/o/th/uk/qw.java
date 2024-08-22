package fe.rg.qw.o.th.uk;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import fe.rg.qw.o.ad;
import java.io.ByteArrayOutputStream;

public class qw implements ResourceTranscoder<Bitmap, byte[]> {

    /* renamed from: ad  reason: collision with root package name */
    public final int f4989ad;
    public final Bitmap.CompressFormat qw;

    public qw() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    @Nullable
    public Resource<byte[]> qw(@NonNull Resource<Bitmap> resource, @NonNull ad adVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        resource.get().compress(this.qw, this.f4989ad, byteArrayOutputStream);
        resource.recycle();
        return new fe.rg.qw.o.th.fe.ad(byteArrayOutputStream.toByteArray());
    }

    public qw(@NonNull Bitmap.CompressFormat compressFormat, int i2) {
        this.qw = compressFormat;
        this.f4989ad = i2;
    }
}
