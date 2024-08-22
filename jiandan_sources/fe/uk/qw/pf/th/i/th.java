package fe.uk.qw.pf.th.i;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.dxmbumptech.glide.load.engine.Resource;
import com.dxmbumptech.glide.load.resource.transcode.ResourceTranscoder;
import fe.uk.qw.pf.ad;

public class th<Z> implements ResourceTranscoder<Z, Z> {
    public static final th<?> qw = new th<>();

    public static <Z> ResourceTranscoder<Z, Z> ad() {
        return qw;
    }

    @Nullable
    public Resource<Z> qw(@NonNull Resource<Z> resource, @NonNull ad adVar) {
        return resource;
    }
}
