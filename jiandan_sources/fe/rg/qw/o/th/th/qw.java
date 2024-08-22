package fe.rg.qw.o.th.th;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import fe.rg.qw.o.ad;
import java.io.File;

public class qw implements ResourceDecoder<File, File> {
    /* renamed from: de */
    public Resource<File> ad(@NonNull File file, int i2, int i3, @NonNull ad adVar) {
        return new ad(file);
    }

    /* renamed from: fe */
    public boolean qw(@NonNull File file, @NonNull ad adVar) {
        return true;
    }
}
