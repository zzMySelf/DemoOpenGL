package fe.qw.qw.ppp;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.parser.moshi.JsonReader;
import fe.qw.qw.p009switch.uk.Cif;
import fe.qw.qw.p009switch.uk.ad;
import fe.qw.qw.p009switch.uk.i;
import fe.qw.qw.p009switch.uk.rg;
import fe.qw.qw.p009switch.uk.yj;
import fe.qw.qw.vvv.fe;
import fe.qw.qw.vvv.qw;
import java.io.IOException;

public class de {

    /* renamed from: ad  reason: collision with root package name */
    public static JsonReader.qw f3394ad = JsonReader.qw.qw("k");
    public static JsonReader.qw qw = JsonReader.qw.qw("a", "p", "s", "rz", "r", "o", "so", "eo", "sk", "sa");

    public static boolean ad(AnimatableValue<PointF, PointF> animatableValue) {
        if (animatableValue == null || (!(animatableValue instanceof i) && animatableValue.de() && ((PointF) animatableValue.ad().get(0).f3525ad).equals(0.0f, 0.0f))) {
            return true;
        }
        return false;
    }

    public static boolean de(ad adVar) {
        return adVar == null || (adVar.de() && ((Float) ((qw) adVar.ad().get(0)).f3525ad).floatValue() == 0.0f);
    }

    public static boolean fe(yj yjVar) {
        return yjVar == null || (yjVar.de() && ((fe) ((qw) yjVar.ad().get(0)).f3525ad).qw(1.0f, 1.0f));
    }

    public static boolean qw(rg rgVar) {
        return rgVar == null || (rgVar.de() && ((PointF) rgVar.ad().get(0).f3525ad).equals(0.0f, 0.0f));
    }

    public static boolean rg(ad adVar) {
        return adVar == null || (adVar.de() && ((Float) ((qw) adVar.ad().get(0)).f3525ad).floatValue() == 0.0f);
    }

    public static boolean th(ad adVar) {
        return adVar == null || (adVar.de() && ((Float) ((qw) adVar.ad().get(0)).f3525ad).floatValue() == 0.0f);
    }

    public static Cif yj(JsonReader jsonReader, fe.qw.qw.de deVar) throws IOException {
        JsonReader jsonReader2 = jsonReader;
        fe.qw.qw.de deVar2 = deVar;
        boolean z = false;
        boolean z2 = jsonReader.vvv() == JsonReader.Token.BEGIN_OBJECT;
        if (z2) {
            jsonReader.fe();
        }
        ad adVar = null;
        rg rgVar = null;
        AnimatableValue<PointF, PointF> animatableValue = null;
        yj yjVar = null;
        ad adVar2 = null;
        ad adVar3 = null;
        fe.qw.qw.p009switch.uk.fe feVar = null;
        ad adVar4 = null;
        ad adVar5 = null;
        while (jsonReader.yj()) {
            switch (jsonReader2.ddd(qw)) {
                case 0:
                    jsonReader.fe();
                    while (jsonReader.yj()) {
                        if (jsonReader2.ddd(f3394ad) != 0) {
                            jsonReader.nn();
                            jsonReader.mmm();
                        } else {
                            rgVar = qw.qw(jsonReader, deVar);
                        }
                    }
                    jsonReader.th();
                    break;
                case 1:
                    animatableValue = qw.ad(jsonReader, deVar);
                    break;
                case 2:
                    yjVar = fe.o(jsonReader, deVar);
                    break;
                case 3:
                    deVar2.qw("Lottie doesn't support 3D layers.");
                    break;
                case 4:
                    break;
                case 5:
                    feVar = fe.uk(jsonReader, deVar);
                    continue;
                case 6:
                    adVar4 = fe.th(jsonReader2, deVar2, z);
                    continue;
                case 7:
                    adVar5 = fe.th(jsonReader2, deVar2, z);
                    continue;
                case 8:
                    adVar2 = fe.th(jsonReader2, deVar2, z);
                    continue;
                case 9:
                    adVar3 = fe.th(jsonReader2, deVar2, z);
                    continue;
                default:
                    jsonReader.nn();
                    jsonReader.mmm();
                    break;
            }
            ad th2 = fe.th(jsonReader2, deVar2, z);
            if (th2.ad().isEmpty()) {
                qw qwVar = r1;
                qw qwVar2 = new qw(deVar, Float.valueOf(0.0f), Float.valueOf(0.0f), (Interpolator) null, 0.0f, Float.valueOf(deVar.th()));
                th2.ad().add(qwVar);
            } else if (((qw) th2.ad().get(0)).f3525ad == null) {
                th2.ad().set(0, new qw(deVar, Float.valueOf(0.0f), Float.valueOf(0.0f), (Interpolator) null, 0.0f, Float.valueOf(deVar.th())));
                adVar = th2;
                z = false;
            }
            adVar = th2;
            z = false;
        }
        if (z2) {
            jsonReader.th();
        }
        rg rgVar2 = qw(rgVar) ? null : rgVar;
        AnimatableValue<PointF, PointF> animatableValue2 = ad(animatableValue) ? null : animatableValue;
        ad adVar6 = de(adVar) ? null : adVar;
        if (fe(yjVar)) {
            yjVar = null;
        }
        return new Cif(rgVar2, animatableValue2, yjVar, adVar6, feVar, adVar4, adVar5, th(adVar2) ? null : adVar2, rg(adVar3) ? null : adVar3);
    }
}
