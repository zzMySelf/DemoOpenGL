package fe.rg.qw.when.fe;

import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.Target;

@Deprecated
public abstract class qw<Z> implements Target<Z> {

    /* renamed from: ad  reason: collision with root package name */
    public Request f5084ad;

    public void ad(@Nullable Drawable drawable) {
    }

    public void de(@Nullable Drawable drawable) {
    }

    @Nullable
    public Request getRequest() {
        return this.f5084ad;
    }

    public void onDestroy() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void qw(@Nullable Drawable drawable) {
    }

    public void th(@Nullable Request request) {
        this.f5084ad = request;
    }
}
