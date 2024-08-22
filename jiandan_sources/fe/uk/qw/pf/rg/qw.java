package fe.uk.qw.pf.rg;

import android.util.Log;
import androidx.annotation.NonNull;
import com.dxmbumptech.glide.load.Encoder;
import fe.uk.qw.pf.ad;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public class qw implements Encoder<ByteBuffer> {
    /* renamed from: de */
    public boolean qw(@NonNull ByteBuffer byteBuffer, @NonNull File file, @NonNull ad adVar) {
        try {
            fe.uk.qw.vvv.qw.rg(byteBuffer, file);
            return true;
        } catch (IOException unused) {
            boolean isLoggable = Log.isLoggable("ByteBufferEncoder", 3);
            return false;
        }
    }
}
