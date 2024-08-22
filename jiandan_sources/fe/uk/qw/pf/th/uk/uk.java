package fe.uk.qw.pf.th.uk;

import android.util.Log;
import androidx.annotation.NonNull;
import com.dxmbumptech.glide.load.ImageHeaderParser;
import com.dxmbumptech.glide.load.ResourceDecoder;
import com.dxmbumptech.glide.load.engine.Resource;
import com.dxmbumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.dxmbumptech.glide.load.resource.gif.GifDrawable;
import fe.uk.qw.pf.ad;
import fe.uk.qw.pf.qw;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public class uk implements ResourceDecoder<InputStream, GifDrawable> {

    /* renamed from: ad  reason: collision with root package name */
    public final ResourceDecoder<ByteBuffer, GifDrawable> f6003ad;

    /* renamed from: de  reason: collision with root package name */
    public final ArrayPool f6004de;
    public final List<ImageHeaderParser> qw;

    public uk(List<ImageHeaderParser> list, ResourceDecoder<ByteBuffer, GifDrawable> resourceDecoder, ArrayPool arrayPool) {
        this.qw = list;
        this.f6003ad = resourceDecoder;
        this.f6004de = arrayPool;
    }

    public static byte[] rg(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException unused) {
            boolean isLoggable = Log.isLoggable("StreamGifDecoder", 5);
            return null;
        }
    }

    /* renamed from: de */
    public Resource<GifDrawable> ad(@NonNull InputStream inputStream, int i2, int i3, @NonNull ad adVar) throws IOException {
        byte[] rg2 = rg(inputStream);
        if (rg2 == null) {
            return null;
        }
        return this.f6003ad.ad(ByteBuffer.wrap(rg2), i2, i3, adVar);
    }

    /* renamed from: fe */
    public boolean qw(@NonNull InputStream inputStream, @NonNull ad adVar) throws IOException {
        return !((Boolean) adVar.de(yj.f6005ad)).booleanValue() && qw.rg(this.qw, inputStream, this.f6004de) == ImageHeaderParser.ImageType.GIF;
    }
}
