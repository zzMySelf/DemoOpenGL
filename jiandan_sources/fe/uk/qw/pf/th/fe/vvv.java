package fe.uk.qw.pf.th.fe;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.dxmbumptech.glide.load.ResourceDecoder;
import com.dxmbumptech.glide.load.engine.Resource;
import fe.uk.qw.pf.ad;
import fe.uk.qw.vvv.qw;
import java.io.IOException;
import java.io.InputStream;

@RequiresApi(api = 28)
public final class vvv implements ResourceDecoder<InputStream, Bitmap> {
    public final fe qw = new fe();

    @Nullable
    /* renamed from: de */
    public Resource<Bitmap> ad(@NonNull InputStream inputStream, int i2, int i3, @NonNull ad adVar) throws IOException {
        return this.qw.ad(ImageDecoder.createSource(qw.ad(inputStream)), i2, i3, adVar);
    }

    /* renamed from: fe */
    public boolean qw(@NonNull InputStream inputStream, @NonNull ad adVar) throws IOException {
        return true;
    }
}
