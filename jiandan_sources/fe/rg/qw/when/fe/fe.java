package fe.rg.qw.when.fe;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.transition.Transition;

public abstract class fe<Z> extends yj<ImageView, Z> implements Transition.ViewAdapter {
    @Nullable

    /* renamed from: if  reason: not valid java name */
    public Animatable f198if;

    public fe(ImageView imageView) {
        super(imageView);
    }

    public void ad(@Nullable Drawable drawable) {
        super.ad(drawable);
        Animatable animatable = this.f198if;
        if (animatable != null) {
            animatable.stop();
        }
        ppp((Object) null);
        m328switch(drawable);
    }

    public void de(@Nullable Drawable drawable) {
        super.de(drawable);
        ppp((Object) null);
        m328switch(drawable);
    }

    /* renamed from: if  reason: not valid java name */
    public final void m327if(@Nullable Z z) {
        if (z instanceof Animatable) {
            Animatable animatable = (Animatable) z;
            this.f198if = animatable;
            animatable.start();
            return;
        }
        this.f198if = null;
    }

    public void onStart() {
        Animatable animatable = this.f198if;
        if (animatable != null) {
            animatable.start();
        }
    }

    public void onStop() {
        Animatable animatable = this.f198if;
        if (animatable != null) {
            animatable.stop();
        }
    }

    public final void ppp(@Nullable Z z) {
        when(z);
        m327if(z);
    }

    public void qw(@Nullable Drawable drawable) {
        super.qw(drawable);
        ppp((Object) null);
        m328switch(drawable);
    }

    public void rg(@NonNull Z z, @Nullable Transition<? super Z> transition) {
        if (transition == null || !transition.qw(z, this)) {
            ppp(z);
        } else {
            m327if(z);
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public void m328switch(Drawable drawable) {
        ((ImageView) this.f5090th).setImageDrawable(drawable);
    }

    public abstract void when(@Nullable Z z);
}
