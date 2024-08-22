package fe.qw.qw.p009switch.i;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.content.ContentModel;
import fe.qw.qw.p009switch.uk.fe;
import fe.qw.qw.p009switch.uk.qw;
import fe.qw.qw.rg;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

/* renamed from: fe.qw.qw.switch.i.uk  reason: invalid package */
public class uk implements ContentModel {

    /* renamed from: ad  reason: collision with root package name */
    public final Path.FillType f3475ad;

    /* renamed from: de  reason: collision with root package name */
    public final String f3476de;
    @Nullable

    /* renamed from: fe  reason: collision with root package name */
    public final qw f3477fe;
    public final boolean qw;
    @Nullable

    /* renamed from: rg  reason: collision with root package name */
    public final fe f3478rg;

    /* renamed from: th  reason: collision with root package name */
    public final boolean f3479th;

    public uk(String str, boolean z, Path.FillType fillType, @Nullable qw qwVar, @Nullable fe feVar, boolean z2) {
        this.f3476de = str;
        this.qw = z;
        this.f3475ad = fillType;
        this.f3477fe = qwVar;
        this.f3478rg = feVar;
        this.f3479th = z2;
    }

    @Nullable
    public qw ad() {
        return this.f3477fe;
    }

    public Path.FillType de() {
        return this.f3475ad;
    }

    public String fe() {
        return this.f3476de;
    }

    public Content qw(rg rgVar, fe.qw.qw.p009switch.o.qw qwVar) {
        return new fe.qw.qw.pf.ad.rg(rgVar, qwVar, this);
    }

    @Nullable
    public fe rg() {
        return this.f3478rg;
    }

    public boolean th() {
        return this.f3479th;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.qw + ExtendedMessageFormat.END_FE;
    }
}
