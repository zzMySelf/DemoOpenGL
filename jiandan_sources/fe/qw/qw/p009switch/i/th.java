package fe.qw.qw.p009switch.i;

import androidx.annotation.Nullable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.content.ContentModel;
import fe.qw.qw.p009switch.o.qw;
import fe.qw.qw.p009switch.uk.Cif;
import fe.qw.qw.p009switch.uk.ad;
import fe.qw.qw.pf.ad.Cswitch;
import fe.qw.qw.rg;

/* renamed from: fe.qw.qw.switch.i.th  reason: invalid package */
public class th implements ContentModel {

    /* renamed from: ad  reason: collision with root package name */
    public final ad f3471ad;

    /* renamed from: de  reason: collision with root package name */
    public final ad f3472de;

    /* renamed from: fe  reason: collision with root package name */
    public final Cif f3473fe;
    public final String qw;

    /* renamed from: rg  reason: collision with root package name */
    public final boolean f3474rg;

    public th(String str, ad adVar, ad adVar2, Cif ifVar, boolean z) {
        this.qw = str;
        this.f3471ad = adVar;
        this.f3472de = adVar2;
        this.f3473fe = ifVar;
        this.f3474rg = z;
    }

    public ad ad() {
        return this.f3471ad;
    }

    public String de() {
        return this.qw;
    }

    public ad fe() {
        return this.f3472de;
    }

    @Nullable
    public Content qw(rg rgVar, qw qwVar) {
        return new Cswitch(rgVar, qwVar, this);
    }

    public Cif rg() {
        return this.f3473fe;
    }

    public boolean th() {
        return this.f3474rg;
    }
}
