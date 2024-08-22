package fe.rg.qw.o.th.uk;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import fe.rg.qw.ggg.uk;
import fe.rg.qw.o.th.de.ppp;

public class ad implements ResourceTranscoder<Bitmap, BitmapDrawable> {
    public final Resources qw;

    public ad(@NonNull Resources resources) {
        uk.fe(resources);
        this.qw = resources;
    }

    @Nullable
    public Resource<BitmapDrawable> qw(@NonNull Resource<Bitmap> resource, @NonNull fe.rg.qw.o.ad adVar) {
        return ppp.fe(this.qw, resource);
    }
}
