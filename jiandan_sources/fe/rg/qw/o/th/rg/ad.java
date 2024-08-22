package fe.rg.qw.o.th.rg;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import fe.rg.qw.ggg.uk;
import fe.rg.qw.o.th.yj.de;

public abstract class ad<T extends Drawable> implements Resource<T>, Initializable {

    /* renamed from: ad  reason: collision with root package name */
    public final T f4986ad;

    public ad(T t) {
        uk.fe(t);
        this.f4986ad = (Drawable) t;
    }

    @NonNull
    /* renamed from: de */
    public final T get() {
        Drawable.ConstantState constantState = this.f4986ad.getConstantState();
        if (constantState == null) {
            return this.f4986ad;
        }
        return constantState.newDrawable();
    }

    public void initialize() {
        T t = this.f4986ad;
        if (t instanceof BitmapDrawable) {
            ((BitmapDrawable) t).getBitmap().prepareToDraw();
        } else if (t instanceof de) {
            ((de) t).fe().prepareToDraw();
        }
    }
}
