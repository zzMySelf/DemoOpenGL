package fe.uk.qw.pf.th.i;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.dxmbumptech.glide.load.engine.Resource;
import com.dxmbumptech.glide.load.resource.transcode.ResourceTranscoder;
import fe.uk.qw.pf.th.fe.xxx;
import fe.uk.qw.vvv.i;

public class ad implements ResourceTranscoder<Bitmap, BitmapDrawable> {
    public final Resources qw;

    public ad(@NonNull Resources resources) {
        i.fe(resources);
        this.qw = resources;
    }

    @Nullable
    public Resource<BitmapDrawable> qw(@NonNull Resource<Bitmap> resource, @NonNull fe.uk.qw.pf.ad adVar) {
        return xxx.fe(this.qw, resource);
    }
}
