package fe.qw.qw.pf.ad;

import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import fe.qw.qw.p009switch.o.qw;
import java.util.ArrayList;
import java.util.List;

public class ggg implements Content, BaseKeyframeAnimation.AnimationListener {

    /* renamed from: ad  reason: collision with root package name */
    public final boolean f3291ad;

    /* renamed from: de  reason: collision with root package name */
    public final List<BaseKeyframeAnimation.AnimationListener> f3292de = new ArrayList();

    /* renamed from: fe  reason: collision with root package name */
    public final ShapeTrimPath.Type f3293fe;
    public final String qw;

    /* renamed from: rg  reason: collision with root package name */
    public final BaseKeyframeAnimation<?, Float> f3294rg;

    /* renamed from: th  reason: collision with root package name */
    public final BaseKeyframeAnimation<?, Float> f3295th;

    /* renamed from: yj  reason: collision with root package name */
    public final BaseKeyframeAnimation<?, Float> f3296yj;

    public ggg(qw qwVar, ShapeTrimPath shapeTrimPath) {
        this.qw = shapeTrimPath.de();
        this.f3291ad = shapeTrimPath.yj();
        this.f3293fe = shapeTrimPath.th();
        this.f3294rg = shapeTrimPath.rg().qw();
        this.f3295th = shapeTrimPath.ad().qw();
        this.f3296yj = shapeTrimPath.fe().qw();
        qwVar.i(this.f3294rg);
        qwVar.i(this.f3295th);
        qwVar.i(this.f3296yj);
        this.f3294rg.qw(this);
        this.f3295th.qw(this);
        this.f3296yj.qw(this);
    }

    public void ad(List<Content> list, List<Content> list2) {
    }

    public void de(BaseKeyframeAnimation.AnimationListener animationListener) {
        this.f3292de.add(animationListener);
    }

    public BaseKeyframeAnimation<?, Float> fe() {
        return this.f3295th;
    }

    public String getName() {
        return this.qw;
    }

    public ShapeTrimPath.Type i() {
        return this.f3293fe;
    }

    public boolean o() {
        return this.f3291ad;
    }

    public void qw() {
        for (int i2 = 0; i2 < this.f3292de.size(); i2++) {
            this.f3292de.get(i2).qw();
        }
    }

    public BaseKeyframeAnimation<?, Float> th() {
        return this.f3296yj;
    }

    public BaseKeyframeAnimation<?, Float> uk() {
        return this.f3294rg;
    }
}
