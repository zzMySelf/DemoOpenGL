package com.baidu.searchbox.suspensionwindow;

import android.view.View;

abstract class FloatView {
    /* access modifiers changed from: package-private */
    public abstract void dismiss();

    /* access modifiers changed from: package-private */
    public abstract void init();

    /* access modifiers changed from: package-private */
    public abstract boolean isInited();

    /* access modifiers changed from: package-private */
    public abstract void setGravity(int i2, float f2, float f3);

    /* access modifiers changed from: package-private */
    public abstract void setSize(int i2, int i3);

    /* access modifiers changed from: package-private */
    public abstract void setView(View view2);

    FloatView() {
    }

    /* access modifiers changed from: package-private */
    public void updateXY(float x, float y) {
    }

    /* access modifiers changed from: package-private */
    public void updateX(float x) {
    }

    /* access modifiers changed from: package-private */
    public void updateY(float y) {
    }

    /* access modifiers changed from: package-private */
    public float getX() {
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public float getY() {
        return 0.0f;
    }
}
