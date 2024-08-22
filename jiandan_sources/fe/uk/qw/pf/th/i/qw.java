package fe.uk.qw.pf.th.i;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.dxmbumptech.glide.load.engine.Resource;
import com.dxmbumptech.glide.load.resource.transcode.ResourceTranscoder;
import fe.uk.qw.pf.ad;
import java.io.ByteArrayOutputStream;

public class qw implements ResourceTranscoder<Bitmap, byte[]> {

    /* renamed from: ad  reason: collision with root package name */
    public final int f5984ad;
    public final Bitmap.CompressFormat qw;

    public qw() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    @Nullable
    public Resource<byte[]> qw(@NonNull Resource<Bitmap> resource, @NonNull ad adVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        resource.get().compress(this.qw, this.f5984ad, byteArrayOutputStream);
        resource.recycle();
        return new fe.uk.qw.pf.th.rg.ad(byteArrayOutputStream.toByteArray());
    }

    public qw(@NonNull Bitmap.CompressFormat compressFormat, int i2) {
        this.qw = compressFormat;
        this.f5984ad = i2;
    }
}
