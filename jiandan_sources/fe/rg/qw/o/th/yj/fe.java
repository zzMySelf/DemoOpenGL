package fe.rg.qw.o.th.yj;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import fe.rg.qw.ggg.qw;
import fe.rg.qw.o.ad;
import java.io.File;
import java.io.IOException;

public class fe implements ResourceEncoder<de> {
    @NonNull
    public EncodeStrategy ad(@NonNull ad adVar) {
        return EncodeStrategy.SOURCE;
    }

    /* renamed from: de */
    public boolean qw(@NonNull Resource<de> resource, @NonNull File file, @NonNull ad adVar) {
        try {
            qw.fe(resource.get().ad(), file);
            return true;
        } catch (IOException unused) {
            boolean isLoggable = Log.isLoggable("GifEncoder", 5);
            return false;
        }
    }
}
