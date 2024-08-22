package fe.uk.qw.pf.th.fe;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.dxmbumptech.glide.load.ResourceDecoder;
import com.dxmbumptech.glide.load.engine.Resource;
import fe.uk.qw.pf.ad;
import java.io.IOException;
import java.nio.ByteBuffer;

@RequiresApi(api = 28)
public final class uk implements ResourceDecoder<ByteBuffer, Bitmap> {
    public final fe qw = new fe();

    @Nullable
    /* renamed from: de */
    public Resource<Bitmap> ad(@NonNull ByteBuffer byteBuffer, int i2, int i3, @NonNull ad adVar) throws IOException {
        return this.qw.ad(ImageDecoder.createSource(byteBuffer), i2, i3, adVar);
    }

    /* renamed from: fe */
    public boolean qw(@NonNull ByteBuffer byteBuffer, @NonNull ad adVar) throws IOException {
        return true;
    }
}
