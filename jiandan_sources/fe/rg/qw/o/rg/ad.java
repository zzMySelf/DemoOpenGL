package fe.rg.qw.o.rg;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import fe.rg.qw.ppp.de;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ad implements ModelLoader<File, ByteBuffer> {

    /* renamed from: fe.rg.qw.o.rg.ad$ad  reason: collision with other inner class name */
    public static class C0210ad implements ModelLoaderFactory<File, ByteBuffer> {
        @NonNull
        public ModelLoader<File, ByteBuffer> ad(@NonNull i iVar) {
            return new ad();
        }
    }

    public static final class qw implements DataFetcher<ByteBuffer> {

        /* renamed from: ad  reason: collision with root package name */
        public final File f4916ad;

        public qw(File file) {
            this.f4916ad = file;
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
                dataCallback.rg(fe.rg.qw.ggg.qw.qw(this.f4916ad));
            } catch (IOException e) {
                boolean isLoggable = Log.isLoggable("ByteBufferFileLoader", 3);
                dataCallback.de(e);
            }
        }
    }

    /* renamed from: de */
    public ModelLoader.qw<ByteBuffer> ad(@NonNull File file, int i2, int i3, @NonNull fe.rg.qw.o.ad adVar) {
        return new ModelLoader.qw<>(new de(file), new qw(file));
    }

    /* renamed from: fe */
    public boolean qw(@NonNull File file) {
        return true;
    }
}
