package fe.qw.qw.p009switch.uk;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ModifierContent;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.ContentModel;
import fe.qw.qw.p009switch.o.qw;
import fe.qw.qw.pf.de.when;
import fe.qw.qw.rg;

/* renamed from: fe.qw.qw.switch.uk.if  reason: invalid class name and invalid package */
public class Cif implements ModifierContent, ContentModel {
    @Nullable

    /* renamed from: ad  reason: collision with root package name */
    public final AnimatableValue<PointF, PointF> f3500ad;
    @Nullable

    /* renamed from: de  reason: collision with root package name */
    public final yj f3501de;
    @Nullable

    /* renamed from: fe  reason: collision with root package name */
    public final ad f3502fe;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public final ad f3503i;
    @Nullable
    public final rg qw;
    @Nullable

    /* renamed from: rg  reason: collision with root package name */
    public final fe f3504rg;
    @Nullable

    /* renamed from: th  reason: collision with root package name */
    public final ad f3505th;
    @Nullable

    /* renamed from: uk  reason: collision with root package name */
    public final ad f3506uk;
    @Nullable

    /* renamed from: yj  reason: collision with root package name */
    public final ad f3507yj;

    public Cif() {
        this((rg) null, (AnimatableValue<PointF, PointF>) null, (yj) null, (ad) null, (fe) null, (ad) null, (ad) null, (ad) null, (ad) null);
    }

    public when ad() {
        return new when(this);
    }

    @Nullable
    public rg de() {
        return this.qw;
    }

    @Nullable
    public ad fe() {
        return this.f3503i;
    }

    @Nullable
    public ad i() {
        return this.f3505th;
    }

    @Nullable
    public ad o() {
        return this.f3507yj;
    }

    @Nullable
    public ad pf() {
        return this.f3506uk;
    }

    @Nullable
    public Content qw(rg rgVar, qw qwVar) {
        return null;
    }

    @Nullable
    public fe rg() {
        return this.f3504rg;
    }

    @Nullable
    public AnimatableValue<PointF, PointF> th() {
        return this.f3500ad;
    }

    @Nullable
    public yj uk() {
        return this.f3501de;
    }

    @Nullable
    public ad yj() {
        return this.f3502fe;
    }

    public Cif(@Nullable rg rgVar, @Nullable AnimatableValue<PointF, PointF> animatableValue, @Nullable yj yjVar, @Nullable ad adVar, @Nullable fe feVar, @Nullable ad adVar2, @Nullable ad adVar3, @Nullable ad adVar4, @Nullable ad adVar5) {
        this.qw = rgVar;
        this.f3500ad = animatableValue;
        this.f3501de = yjVar;
        this.f3502fe = adVar;
        this.f3504rg = feVar;
        this.f3506uk = adVar2;
        this.f3503i = adVar3;
        this.f3505th = adVar4;
        this.f3507yj = adVar5;
    }
}
