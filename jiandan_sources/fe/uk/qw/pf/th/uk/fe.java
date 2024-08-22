package fe.uk.qw.pf.th.uk;

import androidx.annotation.NonNull;
import com.dxmbumptech.glide.load.engine.Initializable;
import com.dxmbumptech.glide.load.resource.gif.GifDrawable;
import fe.uk.qw.pf.th.th.ad;

public class fe extends ad<GifDrawable> implements Initializable {
    public fe(GifDrawable gifDrawable) {
        super(gifDrawable);
    }

    @NonNull
    public Class<GifDrawable> ad() {
        return GifDrawable.class;
    }

    public void initialize() {
        ((GifDrawable) this.f5994ad).getFirstFrame().prepareToDraw();
    }

    public int qw() {
        return ((GifDrawable) this.f5994ad).getSize();
    }

    public void recycle() {
        ((GifDrawable) this.f5994ad).stop();
        ((GifDrawable) this.f5994ad).recycle();
    }
}
