package fe.vvv.qw.ddd.fe;

import com.otaliastudios.cameraview.internal.Pool;
import java.nio.ByteBuffer;

public class rg extends Pool<ByteBuffer> {

    public class qw implements Pool.Factory<ByteBuffer> {
        public final /* synthetic */ int qw;

        public qw(int i2) {
            this.qw = i2;
        }

        /* renamed from: ad */
        public ByteBuffer qw() {
            return ByteBuffer.allocateDirect(this.qw);
        }
    }

    public rg(int i2, int i3) {
        super(i3, new qw(i2));
    }
}
