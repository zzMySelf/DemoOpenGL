package fe.uk.qw.pf.rg;

import android.util.Log;
import androidx.annotation.NonNull;
import com.dxmbumptech.glide.Priority;
import com.dxmbumptech.glide.load.DataSource;
import com.dxmbumptech.glide.load.data.DataFetcher;
import com.dxmbumptech.glide.load.model.ModelLoader;
import com.dxmbumptech.glide.load.model.ModelLoaderFactory;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ad implements ModelLoader<File, ByteBuffer> {

    /* renamed from: fe.uk.qw.pf.rg.ad$ad  reason: collision with other inner class name */
    public static class C0238ad implements ModelLoaderFactory<File, ByteBuffer> {
        @NonNull
        public ModelLoader<File, ByteBuffer> ad(@NonNull i iVar) {
            return new ad();
        }
    }

    public static final class qw implements DataFetcher<ByteBuffer> {

        /* renamed from: ad  reason: collision with root package name */
        public final File f5896ad;

        public qw(File file) {
            this.f5896ad = file;
        }

        public void ad() {
        }

        public void cancel() {
        }

        @NonNull
        public DataSource fe() {
            return DataSource.LOCAL;
        }

        @NonNull
        public Class<ByteBuffer> qw() {
            return ByteBuffer.class;
        }

        public void th(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super ByteBuffer> dataCallback) {
            try {
                dataCallback.rg(fe.uk.qw.vvv.qw.qw(this.f5896ad));
            } catch (IOException e) {
                boolean isLoggable = Log.isLoggable("ByteBufferFileLoader", 3);
                dataCallback.de(e);
            }
        }
    }

    /* renamed from: de */
    public ModelLoader.qw<ByteBuffer> ad(@NonNull File file, int i2, int i3, @NonNull fe.uk.qw.pf.ad adVar) {
        return new ModelLoader.qw<>(new fe.uk.qw.ggg.ad(file), new qw(file));
    }

    /* renamed from: fe */
    public boolean qw(@NonNull File file) {
        return true;
    }
}
