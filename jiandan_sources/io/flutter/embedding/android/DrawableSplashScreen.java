package io.flutter.embedding.android;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import th.qw.qw.qw.ad;

@Deprecated
public final class DrawableSplashScreen implements SplashScreen {
    public final long crossfadeDurationInMillis;
    public final Drawable drawable;
    public final ImageView.ScaleType scaleType;
    public DrawableSplashScreenView splashView;

    public static class DrawableSplashScreenView extends ImageView {
        public DrawableSplashScreenView(@NonNull Context context) {
            this(context, (AttributeSet) null, 0);
        }

        public void setSplashDrawable(@Nullable Drawable drawable) {
            setSplashDrawable(drawable, ImageView.ScaleType.FIT_XY);
        }

        public DrawableSplashScreenView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            this(context, attributeSet, 0);
        }

        public void setSplashDrawable(@Nullable Drawable drawable, @NonNull ImageView.ScaleType scaleType) {
            setScaleType(scaleType);
            setImageDrawable(drawable);
        }

        public DrawableSplashScreenView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
        }
    }

    public DrawableSplashScreen(@NonNull Drawable drawable2) {
        this(drawable2, ImageView.ScaleType.FIT_XY, 500);
    }

    @Nullable
    public View createSplashView(@NonNull Context context, @Nullable Bundle bundle) {
        DrawableSplashScreenView drawableSplashScreenView = new DrawableSplashScreenView(context);
        this.splashView = drawableSplashScreenView;
        drawableSplashScreenView.setSplashDrawable(this.drawable, this.scaleType);
        return this.splashView;
    }

    @SuppressLint({"NewApi"})
    public /* synthetic */ boolean doesSplashViewRememberItsTransition() {
        return ad.$default$doesSplashViewRememberItsTransition(this);
    }

    @SuppressLint({"NewApi"})
    @Nullable
    public /* synthetic */ Bundle saveSplashScreenState() {
        return ad.$default$saveSplashScreenState(this);
    }

    public void transitionToFlutter(@NonNull final Runnable runnable) {
        DrawableSplashScreenView drawableSplashScreenView = this.splashView;
        if (drawableSplashScreenView == null) {
            runnable.run();
        } else {
            drawableSplashScreenView.animate().alpha(0.0f).setDuration(this.crossfadeDurationInMillis).setListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                    runnable.run();
                }

                public void onAnimationEnd(Animator animator) {
                    runnable.run();
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }
            });
        }
    }

    public DrawableSplashScreen(@NonNull Drawable drawable2, @NonNull ImageView.ScaleType scaleType2, long j) {
        this.drawable = drawable2;
        this.scaleType = scaleType2;
        this.crossfadeDurationInMillis = j;
    }
}
