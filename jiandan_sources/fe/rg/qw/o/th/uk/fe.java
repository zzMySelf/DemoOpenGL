package fe.rg.qw.o.th.uk;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import fe.rg.qw.ggg.qw;
import fe.rg.qw.o.ad;
import fe.rg.qw.o.th.yj.de;

public class fe implements ResourceTranscoder<de, byte[]> {
    @Nullable
    public Resource<byte[]> qw(@NonNull Resource<de> resource, @NonNull ad adVar) {
        return new fe.rg.qw.o.th.fe.ad(qw.de(resource.get().ad()));
    }
}
