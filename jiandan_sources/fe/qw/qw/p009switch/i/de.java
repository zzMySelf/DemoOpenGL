package fe.qw.qw.p009switch.i;

import android.graphics.Path;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.GradientType;
import fe.qw.qw.p009switch.o.qw;
import fe.qw.qw.p009switch.uk.ad;
import fe.qw.qw.p009switch.uk.fe;
import fe.qw.qw.p009switch.uk.th;
import fe.qw.qw.rg;

/* renamed from: fe.qw.qw.switch.i.de  reason: invalid package */
public class de implements ContentModel {

    /* renamed from: ad  reason: collision with root package name */
    public final Path.FillType f3441ad;

    /* renamed from: de  reason: collision with root package name */
    public final fe.qw.qw.p009switch.uk.de f3442de;

    /* renamed from: fe  reason: collision with root package name */
    public final fe f3443fe;
    public final GradientType qw;

    /* renamed from: rg  reason: collision with root package name */
    public final th f3444rg;

    /* renamed from: th  reason: collision with root package name */
    public final th f3445th;

    /* renamed from: uk  reason: collision with root package name */
    public final boolean f3446uk;

    /* renamed from: yj  reason: collision with root package name */
    public final String f3447yj;

    public de(String str, GradientType gradientType, Path.FillType fillType, fe.qw.qw.p009switch.uk.de deVar, fe feVar, th thVar, th thVar2, ad adVar, ad adVar2, boolean z) {
        this.qw = gradientType;
        this.f3441ad = fillType;
        this.f3442de = deVar;
        this.f3443fe = feVar;
        this.f3444rg = thVar;
        this.f3445th = thVar2;
        this.f3447yj = str;
        this.f3446uk = z;
    }

    public th ad() {
        return this.f3445th;
    }

    public Path.FillType de() {
        return this.f3441ad;
    }

    public fe.qw.qw.p009switch.uk.de fe() {
        return this.f3442de;
    }

    public boolean i() {
        return this.f3446uk;
    }

    public Content qw(rg rgVar, qw qwVar) {
        return new fe.qw.qw.pf.ad.th(rgVar, qwVar, this);
    }

    public GradientType rg() {
        return this.qw;
    }

    public String th() {
        return this.f3447yj;
    }

    public th uk() {
        return this.f3444rg;
    }

    public fe yj() {
        return this.f3443fe;
    }
}
