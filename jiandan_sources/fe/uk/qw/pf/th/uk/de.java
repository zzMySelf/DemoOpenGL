package fe.uk.qw.pf.th.uk;

import android.util.Log;
import androidx.annotation.NonNull;
import com.dxmbumptech.glide.load.EncodeStrategy;
import com.dxmbumptech.glide.load.ResourceEncoder;
import com.dxmbumptech.glide.load.engine.Resource;
import com.dxmbumptech.glide.load.resource.gif.GifDrawable;
import fe.uk.qw.pf.ad;
import fe.uk.qw.vvv.qw;
import java.io.File;
import java.io.IOException;

public class de implements ResourceEncoder<GifDrawable> {
    @NonNull
    public EncodeStrategy ad(@NonNull ad adVar) {
        return EncodeStrategy.SOURCE;
    }

    /* renamed from: de */
    public boolean qw(@NonNull Resource<GifDrawable> resource, @NonNull File file, @NonNull ad adVar) {
        try {
            qw.rg(resource.get().getBuffer(), file);
            return true;
        } catch (IOException unused) {
            boolean isLoggable = Log.isLoggable("GifEncoder", 5);
            return false;
        }
    }
}
