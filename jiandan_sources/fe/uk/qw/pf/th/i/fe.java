package fe.uk.qw.pf.th.i;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.dxmbumptech.glide.load.engine.Resource;
import com.dxmbumptech.glide.load.resource.gif.GifDrawable;
import com.dxmbumptech.glide.load.resource.transcode.ResourceTranscoder;
import fe.uk.qw.pf.ad;
import fe.uk.qw.vvv.qw;

public class fe implements ResourceTranscoder<GifDrawable, byte[]> {
    @Nullable
    public Resource<byte[]> qw(@NonNull Resource<GifDrawable> resource, @NonNull ad adVar) {
        return new fe.uk.qw.pf.th.rg.ad(qw.fe(resource.get().getBuffer()));
    }
}
