package fe.uk.qw.pf.th.th;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.dxmbumptech.glide.load.engine.Initializable;
import com.dxmbumptech.glide.load.engine.Resource;
import com.dxmbumptech.glide.load.resource.gif.GifDrawable;
import fe.uk.qw.vvv.i;

public abstract class ad<T extends Drawable> implements Resource<T>, Initializable {

    /* renamed from: ad  reason: collision with root package name */
    public final T f5994ad;

    public ad(T t) {
        i.fe(t);
        this.f5994ad = (Drawable) t;
    }

    @NonNull
    /* renamed from: de */
    public final T get() {
        Drawable.ConstantState constantState = this.f5994ad.getConstantState();
        if (constantState == null) {
            return this.f5994ad;
        }
        return constantState.newDrawable();
    }

    public void initialize() {
        T t = this.f5994ad;
        if (t instanceof BitmapDrawable) {
            ((BitmapDrawable) t).getBitmap().prepareToDraw();
        } else if (t instanceof GifDrawable) {
            ((GifDrawable) t).getFirstFrame().prepareToDraw();
        }
    }
}
