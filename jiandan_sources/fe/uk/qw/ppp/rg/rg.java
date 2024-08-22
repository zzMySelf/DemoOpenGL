package fe.uk.qw.ppp.rg;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.dxmbumptech.glide.request.transition.Transition;

public abstract class rg<Z> extends yj<ImageView, Z> implements Transition.ViewAdapter {
    @Nullable

    /* renamed from: pf  reason: collision with root package name */
    public Animatable f6027pf;

    public rg(ImageView imageView) {
        super(imageView);
    }

    public void ad(@Nullable Drawable drawable) {
        super.ad(drawable);
        Animatable animatable = this.f6027pf;
        if (animatable != null) {
            animatable.stop();
        }
        ppp((Object) null);
        m389switch(drawable);
    }

    public void de(@Nullable Drawable drawable) {
        super.de(drawable);
        ppp((Object) null);
        m389switch(drawable);
    }

    public void fe(@NonNull Z z, @Nullable Transition<? super Z> transition) {
        if (transition == null || !transition.qw(z, this)) {
            ppp(z);
        } else {
            m388if(z);
        }
    }

    /* renamed from: if  reason: not valid java name */
    public final void m388if(@Nullable Z z) {
        if (z instanceof Animatable) {
            Animatable animatable = (Animatable) z;
            this.f6027pf = animatable;
            animatable.start();
            return;
        }
        this.f6027pf = null;
    }

    public void onStart() {
        Animatable animatable = this.f6027pf;
        if (animatable != null) {
            animatable.start();
        }
    }

    public void onStop() {
        Animatable animatable = this.f6027pf;
        if (animatable != null) {
            animatable.stop();
        }
    }

    public final void ppp(@Nullable Z z) {
        when(z);
        m388if(z);
    }

    public void qw(@Nullable Drawable drawable) {
        super.qw(drawable);
        ppp((Object) null);
        m389switch(drawable);
    }

    /* renamed from: switch  reason: not valid java name */
    public void m389switch(Drawable drawable) {
        ((ImageView) this.f6029ad).setImageDrawable(drawable);
    }

    public abstract void when(@Nullable Z z);
}
