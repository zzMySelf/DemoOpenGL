package fe.uk.qw.pf.th.rg;

import androidx.annotation.NonNull;
import com.dxmbumptech.glide.load.data.DataRewinder;
import java.nio.ByteBuffer;

public class qw implements DataRewinder<ByteBuffer> {
    public final ByteBuffer qw;

    /* renamed from: fe.uk.qw.pf.th.rg.qw$qw  reason: collision with other inner class name */
    public static class C0244qw implements DataRewinder.Factory<ByteBuffer> {
        @NonNull
        /* renamed from: de */
        public DataRewinder<ByteBuffer> ad(ByteBuffer byteBuffer) {
            return new qw(byteBuffer);
        }

        @NonNull
        public Class<ByteBuffer> qw() {
            return ByteBuffer.class;
        }
    }

    public qw(ByteBuffer byteBuffer) {
        this.qw = byteBuffer;
    }

    public void ad() {
    }

    @NonNull
    /* renamed from: de */
    public ByteBuffer qw() {
        this.qw.position(0);
        return this.qw;
    }
}
