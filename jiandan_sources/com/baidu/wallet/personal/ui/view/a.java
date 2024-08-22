package com.baidu.wallet.personal.ui.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.motion.widget.Key;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;

public class a {
    public ImageView a;
    public ObjectAnimator b;
    public ObjectAnimator c;
    public ObjectAnimator d;
    public ObjectAnimator e;
    public float f = 0.0f;
    public float g = 1.0f;
    public boolean h = false;

    public a(View view) {
        this.a = (ImageView) view.findViewById(ResUtils.id(view.getContext(), "backTop"));
        f();
    }

    private void f() {
        ImageView imageView = this.a;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, Key.TRANSLATION_X, new float[]{this.f, (float) DisplayUtils.dip2px(imageView.getContext(), 60.0f)});
        this.b = ofFloat;
        ofFloat.setDuration(ItemTouchHelper.Callback.DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.a, Key.ALPHA, new float[]{this.g, 0.3f});
        this.c = ofFloat2;
        ofFloat2.setDuration(ItemTouchHelper.Callback.DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.a, Key.TRANSLATION_X, new float[]{this.f, 0.0f});
        this.d = ofFloat3;
        ofFloat3.setDuration(8000);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.a, Key.ALPHA, new float[]{this.g, 1.0f});
        this.e = ofFloat4;
        ofFloat4.setDuration(8000);
    }

    public void a() {
        this.a.setVisibility(0);
    }

    public void b() {
        this.a.setVisibility(8);
    }

    public void c() {
        if (this.h) {
            this.h = false;
            this.b.cancel();
            this.c.cancel();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, Key.TRANSLATION_X, new float[]{this.f, 0.0f});
            this.d = ofFloat;
            ofFloat.setDuration(800);
            this.d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float unused = a.this.f = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                }
            });
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.a, Key.ALPHA, new float[]{this.g, 1.0f});
            this.e = ofFloat2;
            ofFloat2.setDuration(800);
            this.e.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float unused = a.this.g = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                }
            });
            this.d.start();
            this.e.start();
        }
    }

    public void d() {
        if (!this.h) {
            this.d.cancel();
            this.e.cancel();
            this.h = true;
            ImageView imageView = this.a;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, Key.TRANSLATION_X, new float[]{this.f, (float) DisplayUtils.dip2px(imageView.getContext(), 50.0f)});
            this.b = ofFloat;
            ofFloat.setDuration(200);
            this.b.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float unused = a.this.f = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                }
            });
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.a, Key.ALPHA, new float[]{this.g, 0.3f});
            this.c = ofFloat2;
            ofFloat2.setDuration(200);
            this.c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float unused = a.this.g = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                }
            });
            this.b.start();
            this.c.start();
        }
    }

    public void e() {
        this.b.cancel();
        this.c.cancel();
        this.d.cancel();
        this.e.cancel();
    }
}
