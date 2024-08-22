package fe.qw.qw.p009switch.i;

import androidx.annotation.Nullable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.ShapeStroke;
import fe.qw.qw.p009switch.o.qw;
import fe.qw.qw.p009switch.uk.ad;
import fe.qw.qw.p009switch.uk.de;
import fe.qw.qw.p009switch.uk.th;
import fe.qw.qw.pf.ad.yj;
import fe.qw.qw.rg;
import java.util.List;

/* renamed from: fe.qw.qw.switch.i.fe  reason: invalid package */
public class fe implements ContentModel {

    /* renamed from: ad  reason: collision with root package name */
    public final GradientType f3448ad;

    /* renamed from: de  reason: collision with root package name */
    public final de f3449de;

    /* renamed from: fe  reason: collision with root package name */
    public final fe.qw.qw.p009switch.uk.fe f3450fe;

    /* renamed from: i  reason: collision with root package name */
    public final ShapeStroke.LineJoinType f3451i;
    @Nullable

    /* renamed from: if  reason: not valid java name */
    public final ad f115if;

    /* renamed from: o  reason: collision with root package name */
    public final float f3452o;

    /* renamed from: pf  reason: collision with root package name */
    public final List<ad> f3453pf;
    public final String qw;

    /* renamed from: rg  reason: collision with root package name */
    public final th f3454rg;

    /* renamed from: switch  reason: not valid java name */
    public final boolean f116switch;

    /* renamed from: th  reason: collision with root package name */
    public final th f3455th;

    /* renamed from: uk  reason: collision with root package name */
    public final ShapeStroke.LineCapType f3456uk;

    /* renamed from: yj  reason: collision with root package name */
    public final ad f3457yj;

    public fe(String str, GradientType gradientType, de deVar, fe.qw.qw.p009switch.uk.fe feVar, th thVar, th thVar2, ad adVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<ad> list, @Nullable ad adVar2, boolean z) {
        this.qw = str;
        this.f3448ad = gradientType;
        this.f3449de = deVar;
        this.f3450fe = feVar;
        this.f3454rg = thVar;
        this.f3455th = thVar2;
        this.f3457yj = adVar;
        this.f3456uk = lineCapType;
        this.f3451i = lineJoinType;
        this.f3452o = f;
        this.f3453pf = list;
        this.f115if = adVar2;
        this.f116switch = z;
    }

    public ShapeStroke.LineCapType ad() {
        return this.f3456uk;
    }

    @Nullable
    public ad de() {
        return this.f115if;
    }

    public th fe() {
        return this.f3455th;
    }

    public float i() {
        return this.f3452o;
    }

    /* renamed from: if  reason: not valid java name */
    public th m240if() {
        return this.f3454rg;
    }

    public String o() {
        return this.qw;
    }

    public fe.qw.qw.p009switch.uk.fe pf() {
        return this.f3450fe;
    }

    public Content qw(rg rgVar, qw qwVar) {
        return new yj(rgVar, qwVar, this);
    }

    public de rg() {
        return this.f3449de;
    }

    /* renamed from: switch  reason: not valid java name */
    public ad m241switch() {
        return this.f3457yj;
    }

    public GradientType th() {
        return this.f3448ad;
    }

    public List<ad> uk() {
        return this.f3453pf;
    }

    public boolean when() {
        return this.f116switch;
    }

    public ShapeStroke.LineJoinType yj() {
        return this.f3451i;
    }
}
