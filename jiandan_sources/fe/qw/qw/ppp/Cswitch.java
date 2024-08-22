package fe.qw.qw.ppp;

import android.graphics.Path;
import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.apollon.restnet.rest.g;
import com.dlife.ctaccountapi.t;
import fe.qw.qw.p009switch.i.de;
import fe.qw.qw.p009switch.uk.ad;
import fe.qw.qw.p009switch.uk.fe;
import fe.qw.qw.p009switch.uk.th;
import fe.qw.qw.vvv.qw;
import java.io.IOException;
import java.util.Collections;

/* renamed from: fe.qw.qw.ppp.switch  reason: invalid class name */
public class Cswitch {

    /* renamed from: ad  reason: collision with root package name */
    public static final JsonReader.qw f3400ad = JsonReader.qw.qw("p", "k");
    public static final JsonReader.qw qw = JsonReader.qw.qw(SearchView.IME_OPTION_NO_MICROPHONE, g.a, "o", t.a, "s", "e", "r", "hd");

    public static de qw(JsonReader jsonReader, fe.qw.qw.de deVar) throws IOException {
        fe feVar = null;
        Path.FillType fillType = Path.FillType.WINDING;
        String str = null;
        GradientType gradientType = null;
        fe.qw.qw.p009switch.uk.de deVar2 = null;
        th thVar = null;
        th thVar2 = null;
        boolean z = false;
        while (jsonReader.yj()) {
            switch (jsonReader.ddd(qw)) {
                case 0:
                    str = jsonReader.ppp();
                    break;
                case 1:
                    int i2 = -1;
                    jsonReader.fe();
                    while (jsonReader.yj()) {
                        int ddd = jsonReader.ddd(f3400ad);
                        if (ddd == 0) {
                            i2 = jsonReader.m4switch();
                        } else if (ddd != 1) {
                            jsonReader.nn();
                            jsonReader.mmm();
                        } else {
                            deVar2 = fe.yj(jsonReader, deVar, i2);
                        }
                    }
                    jsonReader.th();
                    break;
                case 2:
                    feVar = fe.uk(jsonReader, deVar);
                    break;
                case 3:
                    gradientType = jsonReader.m4switch() == 1 ? GradientType.LINEAR : GradientType.RADIAL;
                    break;
                case 4:
                    thVar = fe.i(jsonReader, deVar);
                    break;
                case 5:
                    thVar2 = fe.i(jsonReader, deVar);
                    break;
                case 6:
                    fillType = jsonReader.m4switch() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case 7:
                    z = jsonReader.uk();
                    break;
                default:
                    jsonReader.nn();
                    jsonReader.mmm();
                    break;
            }
        }
        return new de(str, gradientType, fillType, deVar2, feVar == null ? new fe(Collections.singletonList(new qw(100))) : feVar, thVar, thVar2, (ad) null, (ad) null, z);
    }
}
