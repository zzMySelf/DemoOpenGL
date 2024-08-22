package fe.qw.qw.p009switch.i;

import android.graphics.PointF;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.ContentModel;
import fe.qw.qw.p009switch.uk.th;
import fe.qw.qw.pf.ad.fe;
import fe.qw.qw.rg;

/* renamed from: fe.qw.qw.switch.i.qw  reason: invalid package */
public class qw implements ContentModel {

    /* renamed from: ad  reason: collision with root package name */
    public final AnimatableValue<PointF, PointF> f3463ad;

    /* renamed from: de  reason: collision with root package name */
    public final th f3464de;

    /* renamed from: fe  reason: collision with root package name */
    public final boolean f3465fe;
    public final String qw;

    /* renamed from: rg  reason: collision with root package name */
    public final boolean f3466rg;

    public qw(String str, AnimatableValue<PointF, PointF> animatableValue, th thVar, boolean z, boolean z2) {
        this.qw = str;
        this.f3463ad = animatableValue;
        this.f3464de = thVar;
        this.f3465fe = z;
        this.f3466rg = z2;
    }

    public String ad() {
        return this.qw;
    }

    public AnimatableValue<PointF, PointF> de() {
        return this.f3463ad;
    }

    public th fe() {
        return this.f3464de;
    }

    public Content qw(rg rgVar, fe.qw.qw.p009switch.o.qw qwVar) {
        return new fe(rgVar, qwVar, this);
    }

    public boolean rg() {
        return this.f3466rg;
    }

    public boolean th() {
        return this.f3465fe;
    }
}
