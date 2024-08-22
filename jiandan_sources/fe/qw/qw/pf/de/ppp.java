package fe.qw.qw.pf.de;

import androidx.annotation.Nullable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import fe.qw.qw.vvv.de;
import fe.qw.qw.vvv.qw;
import java.util.Collections;

public class ppp<K, A> extends BaseKeyframeAnimation<K, A> {

    /* renamed from: i  reason: collision with root package name */
    public final A f3374i;

    public ppp(de<A> deVar) {
        this(deVar, (Object) null);
    }

    public float de() {
        return 1.0f;
    }

    public A i(qw<K> qwVar, float f) {
        return uk();
    }

    /* renamed from: if  reason: not valid java name */
    public void m236if(float f) {
        this.f568fe = f;
    }

    public void o() {
        if (this.f569rg != null) {
            super.o();
        }
    }

    public A uk() {
        de<A> deVar = this.f569rg;
        A a = this.f3374i;
        return deVar.ad(0.0f, 0.0f, a, a, th(), th(), th());
    }

    public ppp(de<A> deVar, @Nullable A a) {
        super(Collections.emptyList());
        m1switch(deVar);
        this.f3374i = a;
    }
}
