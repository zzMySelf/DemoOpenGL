package fe.qw.qw.ppp;

import android.graphics.PointF;
import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.wallet.base.iddetect.UrlOcrConfig;
import fe.qw.qw.de;
import fe.qw.qw.p009switch.uk.ad;
import java.io.IOException;

public class tt {
    public static final JsonReader.qw qw = JsonReader.qw.qw(SearchView.IME_OPTION_NO_MICROPHONE, "sy", "pt", "p", "r", "or", UrlOcrConfig.IdCardKey.OS, "ir", "is", "hd");

    public static PolystarShape qw(JsonReader jsonReader, de deVar) throws IOException {
        String str = null;
        PolystarShape.Type type = null;
        ad adVar = null;
        AnimatableValue<PointF, PointF> animatableValue = null;
        ad adVar2 = null;
        ad adVar3 = null;
        ad adVar4 = null;
        ad adVar5 = null;
        ad adVar6 = null;
        boolean z = false;
        while (jsonReader.yj()) {
            switch (jsonReader.ddd(qw)) {
                case 0:
                    str = jsonReader.ppp();
                    break;
                case 1:
                    type = PolystarShape.Type.forValue(jsonReader.m4switch());
                    break;
                case 2:
                    adVar = fe.th(jsonReader, deVar, false);
                    break;
                case 3:
                    animatableValue = qw.ad(jsonReader, deVar);
                    break;
                case 4:
                    adVar2 = fe.th(jsonReader, deVar, false);
                    break;
                case 5:
                    adVar4 = fe.rg(jsonReader, deVar);
                    break;
                case 6:
                    adVar6 = fe.th(jsonReader, deVar, false);
                    break;
                case 7:
                    adVar3 = fe.rg(jsonReader, deVar);
                    break;
                case 8:
                    adVar5 = fe.th(jsonReader, deVar, false);
                    break;
                case 9:
                    z = jsonReader.uk();
                    break;
                default:
                    jsonReader.nn();
                    jsonReader.mmm();
                    break;
            }
        }
        return new PolystarShape(str, type, adVar, animatableValue, adVar2, adVar3, adVar4, adVar5, adVar6, z);
    }
}
