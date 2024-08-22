package fe.uk.qw.ppp.rg;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.dxmbumptech.glide.request.Request;
import com.dxmbumptech.glide.request.target.SizeReadyCallback;
import com.dxmbumptech.glide.request.target.Target;
import fe.uk.qw.vvv.o;

public abstract class de<T> implements Target<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final int f6024ad;

    /* renamed from: th  reason: collision with root package name */
    public final int f6025th;
    @Nullable

    /* renamed from: yj  reason: collision with root package name */
    public Request f6026yj;

    public de() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public void de(@Nullable Drawable drawable) {
    }

    @Nullable
    public final Request getRequest() {
        return this.f6026yj;
    }

    public void onDestroy() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void qw(@Nullable Drawable drawable) {
    }

    public final void rg(@NonNull SizeReadyCallback sizeReadyCallback) {
    }

    public final void th(@NonNull SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.ad(this.f6024ad, this.f6025th);
    }

    public final void yj(@Nullable Request request) {
        this.f6026yj = request;
    }

    public de(int i2, int i3) {
        if (o.ddd(i2, i3)) {
            this.f6024ad = i2;
            this.f6025th = i3;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i2 + " and height: " + i3);
    }
}
