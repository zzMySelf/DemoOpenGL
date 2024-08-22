package fe.rg.qw.o.rg;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Encoder;
import fe.rg.qw.o.ad;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public class qw implements Encoder<ByteBuffer> {
    /* renamed from: de */
    public boolean qw(@NonNull ByteBuffer byteBuffer, @NonNull File file, @NonNull ad adVar) {
        try {
            fe.rg.qw.ggg.qw.fe(byteBuffer, file);
            return true;
        } catch (IOException unused) {
            boolean isLoggable = Log.isLoggable("ByteBufferEncoder", 3);
            return false;
        }
    }
}
