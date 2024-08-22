package fe.rg.qw.o.th.uk;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import fe.rg.qw.o.ad;

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
