package com.baidu.mapsdkplatform.comapi.a;

import android.animation.Animator;

class j implements Animator.AnimatorListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f14850a;

    j(k kVar) {
        this.f14850a = kVar;
    }

    public void onAnimationCancel(Animator animator) {
        if (this.f14850a.f14854d != null) {
            this.f14850a.f14854d.onAnimationCancel();
        }
    }

    public void onAnimationEnd(Animator animator) {
        if (this.f14850a.f14854d != null) {
            this.f14850a.f14854d.onAnimationEnd();
        }
    }

    public void onAnimationRepeat(Animator animator) {
        if (this.f14850a.f14854d != null) {
            this.f14850a.f14854d.onAnimationRepeat();
        }
    }

    public void onAnimationStart(Animator animator) {
        if (this.f14850a.f14854d != null) {
            this.f14850a.f14854d.onAnimationStart();
        }
    }
}
