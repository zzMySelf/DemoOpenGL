package fe.uk.qw.pf.th.yj;

import androidx.annotation.NonNull;
import com.dxmbumptech.glide.load.ResourceDecoder;
import com.dxmbumptech.glide.load.engine.Resource;
import fe.uk.qw.pf.ad;
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
