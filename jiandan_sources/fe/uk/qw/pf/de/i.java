package fe.uk.qw.pf.de;

import androidx.annotation.NonNull;
import com.baidubce.services.bos.BosClientConfiguration;
import com.dxmbumptech.glide.load.data.DataRewinder;
import com.dxmbumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.dxmbumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class i implements DataRewinder<InputStream> {
    public final RecyclableBufferedInputStream qw;

    public static final class qw implements DataRewinder.Factory<InputStream> {
        public final ArrayPool qw;

        public qw(ArrayPool arrayPool) {
            this.qw = arrayPool;
        }

        @NonNull
        /* renamed from: de */
        public DataRewinder<InputStream> ad(InputStream inputStream) {
            return new i(inputStream, this.qw);
        }

        @NonNull
        public Class<InputStream> qw() {
            return InputStream.class;
        }
    }

    public i(InputStream inputStream, ArrayPool arrayPool) {
        RecyclableBufferedInputStream recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        this.qw = recyclableBufferedInputStream;
        recyclableBufferedInputStream.mark(BosClientConfiguration.DEFAULT_STREAM_BUFFER_SIZE);
    }

    public void ad() {
        this.qw.release();
    }

    public void de() {
        this.qw.de();
    }

    @NonNull
    /* renamed from: fe */
    public InputStream qw() throws IOException {
        this.qw.reset();
        return this.qw;
    }
}
