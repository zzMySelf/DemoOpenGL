package fe.qw.qw.p009switch.i;

import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.content.ContentModel;
import fe.qw.qw.p009switch.o.qw;
import fe.qw.qw.p009switch.uk.uk;
import fe.qw.qw.pf.ad.when;
import fe.qw.qw.rg;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

/* renamed from: fe.qw.qw.switch.i.o  reason: invalid package */
public class o implements ContentModel {

    /* renamed from: ad  reason: collision with root package name */
    public final int f3460ad;

    /* renamed from: de  reason: collision with root package name */
    public final uk f3461de;

    /* renamed from: fe  reason: collision with root package name */
    public final boolean f3462fe;
    public final String qw;

    public o(String str, int i2, uk ukVar, boolean z) {
        this.qw = str;
        this.f3460ad = i2;
        this.f3461de = ukVar;
        this.f3462fe = z;
    }

    public String ad() {
        return this.qw;
    }

    public uk de() {
        return this.f3461de;
    }

    public boolean fe() {
        return this.f3462fe;
    }

    public Content qw(rg rgVar, qw qwVar) {
        return new when(rgVar, qwVar, this);
    }

    public String toString() {
        return "ShapePath{name=" + this.qw + ", index=" + this.f3460ad + ExtendedMessageFormat.END_FE;
    }
}
