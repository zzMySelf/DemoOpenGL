package fe.vvv.qw.ddd.fe;

import android.media.MediaCodec;
import android.os.Build;
import androidx.annotation.RequiresApi;
import java.nio.ByteBuffer;

@RequiresApi(18)
public class uk {

    /* renamed from: ad  reason: collision with root package name */
    public final ByteBuffer[] f8933ad;

    /* renamed from: de  reason: collision with root package name */
    public ByteBuffer[] f8934de;
    public final MediaCodec qw;

    public uk(MediaCodec mediaCodec) {
        this.qw = mediaCodec;
        if (Build.VERSION.SDK_INT < 21) {
            this.f8933ad = mediaCodec.getInputBuffers();
            this.f8934de = mediaCodec.getOutputBuffers();
            return;
        }
        this.f8934de = null;
        this.f8933ad = null;
    }

    public ByteBuffer ad(int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.qw.getOutputBuffer(i2);
        }
        return this.f8934de[i2];
    }

    public void de() {
        if (Build.VERSION.SDK_INT < 21) {
            this.f8934de = this.qw.getOutputBuffers();
        }
    }

    public ByteBuffer qw(int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.qw.getInputBuffer(i2);
        }
        ByteBuffer byteBuffer = this.f8933ad[i2];
        byteBuffer.clear();
        return byteBuffer;
    }
}
