package fe.qw.qw.pf.ad;

import android.graphics.Path;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import fe.qw.qw.p009switch.i.o;
import fe.qw.qw.p009switch.i.yj;
import fe.qw.qw.p009switch.o.qw;
import fe.qw.qw.rg;
import java.util.List;

public class when implements o, BaseKeyframeAnimation.AnimationListener {

    /* renamed from: ad  reason: collision with root package name */
    public final String f3360ad;

    /* renamed from: de  reason: collision with root package name */
    public final boolean f3361de;

    /* renamed from: fe  reason: collision with root package name */
    public final rg f3362fe;
    public final Path qw = new Path();

    /* renamed from: rg  reason: collision with root package name */
    public final BaseKeyframeAnimation<?, Path> f3363rg;

    /* renamed from: th  reason: collision with root package name */
    public boolean f3364th;

    /* renamed from: yj  reason: collision with root package name */
    public ad f3365yj = new ad();

    public when(rg rgVar, qw qwVar, o oVar) {
        this.f3360ad = oVar.ad();
        this.f3361de = oVar.fe();
        this.f3362fe = rgVar;
        BaseKeyframeAnimation<yj, Path> qw2 = oVar.de().qw();
        this.f3363rg = qw2;
        qwVar.i(qw2);
        this.f3363rg.qw(this);
    }

    public void ad(List<Content> list, List<Content> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            Content content = list.get(i2);
            if (content instanceof ggg) {
                ggg ggg = (ggg) content;
                if (ggg.i() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f3365yj.qw(ggg);
                    ggg.de(this);
                }
            }
        }
    }

    public final void de() {
        this.f3364th = false;
        this.f3362fe.invalidateSelf();
    }

    public String getName() {
        return this.f3360ad;
    }

    public Path getPath() {
        if (this.f3364th) {
            return this.qw;
        }
        this.qw.reset();
        if (this.f3361de) {
            this.f3364th = true;
            return this.qw;
        }
        this.qw.set(this.f3363rg.uk());
        this.qw.setFillType(Path.FillType.EVEN_ODD);
        this.f3365yj.ad(this.qw);
        this.f3364th = true;
        return this.qw;
    }

    public void qw() {
        de();
    }
}
