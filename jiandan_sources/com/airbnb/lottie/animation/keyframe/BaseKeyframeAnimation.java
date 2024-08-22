package com.airbnb.lottie.animation.keyframe;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseKeyframeAnimation<K, A> {

    /* renamed from: ad  reason: collision with root package name */
    public boolean f566ad = false;

    /* renamed from: de  reason: collision with root package name */
    public final de<K> f567de;

    /* renamed from: fe  reason: collision with root package name */
    public float f568fe = 0.0f;
    public final List<AnimationListener> qw = new ArrayList(1);
    @Nullable

    /* renamed from: rg  reason: collision with root package name */
    public fe.qw.qw.vvv.de<A> f569rg;
    @Nullable

    /* renamed from: th  reason: collision with root package name */
    public A f570th = null;

    /* renamed from: uk  reason: collision with root package name */
    public float f571uk = -1.0f;

    /* renamed from: yj  reason: collision with root package name */
    public float f572yj = -1.0f;

    public interface AnimationListener {
        void qw();
    }

    public static final class ad<T> implements de<T> {
        public ad() {
        }

        public fe.qw.qw.vvv.qw<T> ad() {
            throw new IllegalStateException("not implemented");
        }

        public boolean de(float f) {
            return false;
        }

        public float fe() {
            return 0.0f;
        }

        public boolean isEmpty() {
            return true;
        }

        public boolean qw(float f) {
            throw new IllegalStateException("not implemented");
        }

        public float rg() {
            return 1.0f;
        }
    }

    public interface de<T> {
        fe.qw.qw.vvv.qw<T> ad();

        boolean de(float f);

        @FloatRange(from = 0.0d, to = 1.0d)
        float fe();

        boolean isEmpty();

        boolean qw(float f);

        @FloatRange(from = 0.0d, to = 1.0d)
        float rg();
    }

    public static final class fe<T> implements de<T> {
        @NonNull

        /* renamed from: ad  reason: collision with root package name */
        public fe.qw.qw.vvv.qw<T> f573ad;

        /* renamed from: de  reason: collision with root package name */
        public fe.qw.qw.vvv.qw<T> f574de = null;

        /* renamed from: fe  reason: collision with root package name */
        public float f575fe = -1.0f;
        public final List<? extends fe.qw.qw.vvv.qw<T>> qw;

        public fe(List<? extends fe.qw.qw.vvv.qw<T>> list) {
            this.qw = list;
            this.f573ad = th(0.0f);
        }

        @NonNull
        public fe.qw.qw.vvv.qw<T> ad() {
            return this.f573ad;
        }

        public boolean de(float f) {
            if (this.f573ad.qw(f)) {
                return !this.f573ad.uk();
            }
            this.f573ad = th(f);
            return true;
        }

        public float fe() {
            return ((fe.qw.qw.vvv.qw) this.qw.get(0)).rg();
        }

        public boolean isEmpty() {
            return false;
        }

        public boolean qw(float f) {
            if (this.f574de == this.f573ad && this.f575fe == f) {
                return true;
            }
            this.f574de = this.f573ad;
            this.f575fe = f;
            return false;
        }

        public float rg() {
            List<? extends fe.qw.qw.vvv.qw<T>> list = this.qw;
            return ((fe.qw.qw.vvv.qw) list.get(list.size() - 1)).ad();
        }

        public final fe.qw.qw.vvv.qw<T> th(float f) {
            List<? extends fe.qw.qw.vvv.qw<T>> list = this.qw;
            fe.qw.qw.vvv.qw<T> qwVar = (fe.qw.qw.vvv.qw) list.get(list.size() - 1);
            if (f >= qwVar.rg()) {
                return qwVar;
            }
            for (int size = this.qw.size() - 2; size >= 1; size--) {
                fe.qw.qw.vvv.qw<T> qwVar2 = (fe.qw.qw.vvv.qw) this.qw.get(size);
                if (this.f573ad != qwVar2 && qwVar2.qw(f)) {
                    return qwVar2;
                }
            }
            return (fe.qw.qw.vvv.qw) this.qw.get(0);
        }
    }

    public static final class rg<T> implements de<T> {

        /* renamed from: ad  reason: collision with root package name */
        public float f576ad = -1.0f;
        @NonNull
        public final fe.qw.qw.vvv.qw<T> qw;

        public rg(List<? extends fe.qw.qw.vvv.qw<T>> list) {
            this.qw = (fe.qw.qw.vvv.qw) list.get(0);
        }

        public fe.qw.qw.vvv.qw<T> ad() {
            return this.qw;
        }

        public boolean de(float f) {
            return !this.qw.uk();
        }

        public float fe() {
            return this.qw.rg();
        }

        public boolean isEmpty() {
            return false;
        }

        public boolean qw(float f) {
            if (this.f576ad == f) {
                return true;
            }
            this.f576ad = f;
            return false;
        }

        public float rg() {
            return this.qw.ad();
        }
    }

    public BaseKeyframeAnimation(List<? extends fe.qw.qw.vvv.qw<K>> list) {
        this.f567de = when(list);
    }

    public static <T> de<T> when(List<? extends fe.qw.qw.vvv.qw<T>> list) {
        if (list.isEmpty()) {
            return new ad();
        }
        if (list.size() == 1) {
            return new rg(list);
        }
        return new fe(list);
    }

    public fe.qw.qw.vvv.qw<K> ad() {
        fe.qw.qw.ad.qw("BaseKeyframeAnimation#getCurrentKeyframe");
        fe.qw.qw.vvv.qw<K> ad2 = this.f567de.ad();
        fe.qw.qw.ad.ad("BaseKeyframeAnimation#getCurrentKeyframe");
        return ad2;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float de() {
        if (this.f571uk == -1.0f) {
            this.f571uk = this.f567de.rg();
        }
        return this.f571uk;
    }

    public float fe() {
        fe.qw.qw.vvv.qw ad2 = ad();
        if (ad2.uk()) {
            return 0.0f;
        }
        return ad2.f3527fe.getInterpolation(rg());
    }

    public abstract A i(fe.qw.qw.vvv.qw<K> qwVar, float f);

    /* renamed from: if  reason: not valid java name */
    public void m0if(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (!this.f567de.isEmpty()) {
            if (f < yj()) {
                f = yj();
            } else if (f > de()) {
                f = de();
            }
            if (f != this.f568fe) {
                this.f568fe = f;
                if (this.f567de.de(f)) {
                    o();
                }
            }
        }
    }

    public void o() {
        for (int i2 = 0; i2 < this.qw.size(); i2++) {
            this.qw.get(i2).qw();
        }
    }

    public void pf() {
        this.f566ad = true;
    }

    public void qw(AnimationListener animationListener) {
        this.qw.add(animationListener);
    }

    public float rg() {
        if (this.f566ad) {
            return 0.0f;
        }
        fe.qw.qw.vvv.qw ad2 = ad();
        if (ad2.uk()) {
            return 0.0f;
        }
        return (this.f568fe - ad2.rg()) / (ad2.ad() - ad2.rg());
    }

    /* renamed from: switch  reason: not valid java name */
    public void m1switch(@Nullable fe.qw.qw.vvv.de<A> deVar) {
        fe.qw.qw.vvv.de<A> deVar2 = this.f569rg;
        if (deVar2 != null) {
            deVar2.de((BaseKeyframeAnimation<?, ?>) null);
        }
        this.f569rg = deVar;
        if (deVar != null) {
            deVar.de(this);
        }
    }

    public float th() {
        return this.f568fe;
    }

    public A uk() {
        float fe2 = fe();
        if (this.f569rg == null && this.f567de.qw(fe2)) {
            return this.f570th;
        }
        A i2 = i(ad(), fe2);
        this.f570th = i2;
        return i2;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public final float yj() {
        if (this.f572yj == -1.0f) {
            this.f572yj = this.f567de.fe();
        }
        return this.f572yj;
    }
}
