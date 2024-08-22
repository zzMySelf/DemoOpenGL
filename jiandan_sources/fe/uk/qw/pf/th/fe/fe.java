package fe.uk.qw.pf.th.fe;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.dlife.ctaccountapi.x;
import com.dxmbumptech.glide.load.engine.Resource;
import com.dxmbumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import fe.uk.qw.pf.th.qw;
import java.io.IOException;

@RequiresApi(api = 28)
public final class fe extends qw<Bitmap> {

    /* renamed from: ad  reason: collision with root package name */
    public final BitmapPool f5953ad = new fe.uk.qw.pf.fe.mmm.fe();

    public Resource<Bitmap> de(ImageDecoder.Source source, int i2, int i3, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException {
        Bitmap decodeBitmap = ImageDecoder.decodeBitmap(source, onHeaderDecodedListener);
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            "Decoded [" + decodeBitmap.getWidth() + x.a + decodeBitmap.getHeight() + "] for [" + i2 + x.a + i3 + "]";
        }
        return new rg(decodeBitmap, this.f5953ad);
    }
}
