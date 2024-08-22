package fe.rg.qw.when.fe;

import androidx.annotation.NonNull;
import com.bumptech.glide.request.target.SizeReadyCallback;
import fe.rg.qw.ggg.i;

@Deprecated
public abstract class th<Z> extends qw<Z> {

    /* renamed from: th  reason: collision with root package name */
    public final int f5085th;

    /* renamed from: yj  reason: collision with root package name */
    public final int f5086yj;

    public th() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public void fe(@NonNull SizeReadyCallback sizeReadyCallback) {
    }

    public final void yj(@NonNull SizeReadyCallback sizeReadyCallback) {
        if (i.xxx(this.f5085th, this.f5086yj)) {
            sizeReadyCallback.ad(this.f5085th, this.f5086yj);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.f5085th + " and height: " + this.f5086yj + ", either provide dimensions in the constructor or call override()");
    }

    public th(int i2, int i3) {
        this.f5085th = i2;
        this.f5086yj = i3;
    }
}
