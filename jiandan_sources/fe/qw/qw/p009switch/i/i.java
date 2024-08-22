package fe.qw.qw.p009switch.i;

import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.content.ContentModel;
import fe.qw.qw.p009switch.o.qw;
import fe.qw.qw.pf.ad.de;
import fe.qw.qw.rg;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

/* renamed from: fe.qw.qw.switch.i.i  reason: invalid package */
public class i implements ContentModel {

    /* renamed from: ad  reason: collision with root package name */
    public final List<ContentModel> f3458ad;

    /* renamed from: de  reason: collision with root package name */
    public final boolean f3459de;
    public final String qw;

    public i(String str, List<ContentModel> list, boolean z) {
        this.qw = str;
        this.f3458ad = list;
        this.f3459de = z;
    }

    public List<ContentModel> ad() {
        return this.f3458ad;
    }

    public String de() {
        return this.qw;
    }

    public boolean fe() {
        return this.f3459de;
    }

    public Content qw(rg rgVar, qw qwVar) {
        return new de(rgVar, qwVar, this);
    }

    public String toString() {
        return "ShapeGroup{name='" + this.qw + "' Shapes: " + Arrays.toString(this.f3458ad.toArray()) + ExtendedMessageFormat.END_FE;
    }
}
