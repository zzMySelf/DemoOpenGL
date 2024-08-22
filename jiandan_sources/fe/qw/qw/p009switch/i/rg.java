package fe.qw.qw.p009switch.i;

import android.graphics.PointF;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.ContentModel;
import fe.qw.qw.p009switch.o.qw;
import fe.qw.qw.p009switch.uk.ad;
import fe.qw.qw.p009switch.uk.th;
import fe.qw.qw.pf.ad.Cif;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

/* renamed from: fe.qw.qw.switch.i.rg  reason: invalid package */
public class rg implements ContentModel {

    /* renamed from: ad  reason: collision with root package name */
    public final AnimatableValue<PointF, PointF> f3467ad;

    /* renamed from: de  reason: collision with root package name */
    public final th f3468de;

    /* renamed from: fe  reason: collision with root package name */
    public final ad f3469fe;
    public final String qw;

    /* renamed from: rg  reason: collision with root package name */
    public final boolean f3470rg;

    public rg(String str, AnimatableValue<PointF, PointF> animatableValue, th thVar, ad adVar, boolean z) {
        this.qw = str;
        this.f3467ad = animatableValue;
        this.f3468de = thVar;
        this.f3469fe = adVar;
        this.f3470rg = z;
    }

    public ad ad() {
        return this.f3469fe;
    }

    public String de() {
        return this.qw;
    }

    public AnimatableValue<PointF, PointF> fe() {
        return this.f3467ad;
    }

    public Content qw(fe.qw.qw.rg rgVar, qw qwVar) {
        return new Cif(rgVar, qwVar, this);
    }

    public th rg() {
        return this.f3468de;
    }

    public boolean th() {
        return this.f3470rg;
    }

    public String toString() {
        return "RectangleShape{position=" + this.f3467ad + ", size=" + this.f3468de + ExtendedMessageFormat.END_FE;
    }
}
