package com.baidu.apollon.utils.support;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class AnimatorProxy extends Animation {
    public static final boolean NEEDS_PROXY = (Integer.valueOf(Build.VERSION.SDK).intValue() < 11);
    public static final WeakHashMap<View, AnimatorProxy> a = new WeakHashMap<>();
    public final WeakReference<View> b;
    public final Camera c = new Camera();
    public final RectF d = new RectF();
    public final RectF e = new RectF();
    public final Matrix f = new Matrix();
    public boolean g;
    public float h = 1.0f;

    /* renamed from: i  reason: collision with root package name */
    public float f720i;
    public float j;
    public float k;
    public float l;
    public float m;
    public float n = 1.0f;

    /* renamed from: o  reason: collision with root package name */
    public float f721o = 1.0f;
    public float p;
    public float q;

    public AnimatorProxy(View view) {
        setDuration(0);
        setFillAfter(true);
        view.setAnimation(this);
        this.b = new WeakReference<>(view);
    }

    private void a() {
        View view = (View) this.b.get();
        if (view != null) {
            a(this.d, view);
        }
    }

    private void b() {
        View view = (View) this.b.get();
        if (view != null && view.getParent() != null) {
            RectF rectF = this.e;
            a(rectF, view);
            rectF.union(this.d);
            ((View) view.getParent()).invalidate((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
        }
    }

    public static AnimatorProxy wrap(View view) {
        AnimatorProxy animatorProxy = a.get(view);
        if (animatorProxy != null && animatorProxy == view.getAnimation()) {
            return animatorProxy;
        }
        AnimatorProxy animatorProxy2 = new AnimatorProxy(view);
        a.put(view, animatorProxy2);
        return animatorProxy2;
    }

    public void applyTransformation(float f2, Transformation transformation) {
        View view = (View) this.b.get();
        if (view != null) {
            transformation.setAlpha(this.h);
            a(transformation.getMatrix(), view);
        }
    }

    public float getAlpha() {
        return this.h;
    }

    public float getPivotX() {
        return this.f720i;
    }

    public float getPivotY() {
        return this.j;
    }

    public float getRotation() {
        return this.m;
    }

    public float getRotationX() {
        return this.k;
    }

    public float getRotationY() {
        return this.l;
    }

    public float getScaleX() {
        return this.n;
    }

    public float getScaleY() {
        return this.f721o;
    }

    public int getScrollX() {
        View view = (View) this.b.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollX();
    }

    public int getScrollY() {
        View view = (View) this.b.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollY();
    }

    public float getTranslationX() {
        return this.p;
    }

    public float getTranslationY() {
        return this.q;
    }

    public float getX() {
        View view = (View) this.b.get();
        if (view == null) {
            return 0.0f;
        }
        return ((float) view.getLeft()) + this.p;
    }

    public float getY() {
        View view = (View) this.b.get();
        if (view == null) {
            return 0.0f;
        }
        return ((float) view.getTop()) + this.q;
    }

    public void setAlpha(float f2) {
        if (this.h != f2) {
            this.h = f2;
            View view = (View) this.b.get();
            if (view != null) {
                view.invalidate();
            }
        }
    }

    public void setPivotX(float f2) {
        if (!this.g || this.f720i != f2) {
            a();
            this.g = true;
            this.f720i = f2;
            b();
        }
    }

    public void setPivotY(float f2) {
        if (!this.g || this.j != f2) {
            a();
            this.g = true;
            this.j = f2;
            b();
        }
    }

    public void setRotation(float f2) {
        if (this.m != f2) {
            a();
            this.m = f2;
            b();
        }
    }

    public void setRotationX(float f2) {
        if (this.k != f2) {
            a();
            this.k = f2;
            b();
        }
    }

    public void setRotationY(float f2) {
        if (this.l != f2) {
            a();
            this.l = f2;
            b();
        }
    }

    public void setScaleX(float f2) {
        if (this.n != f2) {
            a();
            this.n = f2;
            b();
        }
    }

    public void setScaleY(float f2) {
        if (this.f721o != f2) {
            a();
            this.f721o = f2;
            b();
        }
    }

    public void setScrollX(int i2) {
        View view = (View) this.b.get();
        if (view != null) {
            view.scrollTo(i2, view.getScrollY());
        }
    }

    public void setScrollY(int i2) {
        View view = (View) this.b.get();
        if (view != null) {
            view.scrollTo(view.getScrollX(), i2);
        }
    }

    public void setTranslationX(float f2) {
        if (this.p != f2) {
            a();
            this.p = f2;
            b();
        }
    }

    public void setTranslationY(float f2) {
        if (this.q != f2) {
            a();
            this.q = f2;
            b();
        }
    }

    public void setX(float f2) {
        View view = (View) this.b.get();
        if (view != null) {
            setTranslationX(f2 - ((float) view.getLeft()));
        }
    }

    public void setY(float f2) {
        View view = (View) this.b.get();
        if (view != null) {
            setTranslationY(f2 - ((float) view.getTop()));
        }
    }

    private void a(RectF rectF, View view) {
        rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        Matrix matrix = this.f;
        matrix.reset();
        a(matrix, view);
        this.f.mapRect(rectF);
        rectF.offset((float) view.getLeft(), (float) view.getTop());
        float f2 = rectF.right;
        float f3 = rectF.left;
        if (f2 < f3) {
            rectF.right = f3;
            rectF.left = f2;
        }
        float f4 = rectF.bottom;
        float f5 = rectF.top;
        if (f4 < f5) {
            rectF.top = f4;
            rectF.bottom = f5;
        }
    }

    private void a(Matrix matrix, View view) {
        float width = (float) view.getWidth();
        float height = (float) view.getHeight();
        boolean z = this.g;
        float f2 = z ? this.f720i : width / 2.0f;
        float f3 = z ? this.j : height / 2.0f;
        float f4 = this.k;
        float f5 = this.l;
        float f6 = this.m;
        if (!(f4 == 0.0f && f5 == 0.0f && f6 == 0.0f)) {
            Camera camera = this.c;
            camera.save();
            camera.rotateX(f4);
            camera.rotateY(f5);
            camera.rotateZ(-f6);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-f2, -f3);
            matrix.postTranslate(f2, f3);
        }
        float f7 = this.n;
        float f8 = this.f721o;
        if (!(f7 == 1.0f && f8 == 1.0f)) {
            matrix.postScale(f7, f8);
            matrix.postTranslate((-(f2 / width)) * ((f7 * width) - width), (-(f3 / height)) * ((f8 * height) - height));
        }
        matrix.postTranslate(this.p, this.q);
    }
}
