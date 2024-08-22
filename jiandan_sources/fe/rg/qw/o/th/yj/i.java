package fe.rg.qw.o.th.yj;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import fe.rg.qw.o.ad;
import fe.rg.qw.o.qw;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public class i implements ResourceDecoder<InputStream, de> {

    /* renamed from: ad  reason: collision with root package name */
    public final ResourceDecoder<ByteBuffer, de> f5000ad;

    /* renamed from: de  reason: collision with root package name */
    public final ArrayPool f5001de;
    public final List<ImageHeaderParser> qw;

    public i(List<ImageHeaderParser> list, ResourceDecoder<ByteBuffer, de> resourceDecoder, ArrayPool arrayPool) {
        this.qw = list;
        this.f5000ad = resourceDecoder;
        this.f5001de = arrayPool;
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
    public Resource<de> ad(@NonNull InputStream inputStream, int i2, int i3, @NonNull ad adVar) throws IOException {
        byte[] rg2 = rg(inputStream);
        if (rg2 == null) {
            return null;
        }
        return this.f5000ad.ad(ByteBuffer.wrap(rg2), i2, i3, adVar);
    }

    /* renamed from: fe */
    public boolean qw(@NonNull InputStream inputStream, @NonNull ad adVar) throws IOException {
        return !((Boolean) adVar.de(uk.f5009ad)).booleanValue() && qw.ad(this.qw, inputStream, this.f5001de) == ImageHeaderParser.ImageType.GIF;
    }
}
