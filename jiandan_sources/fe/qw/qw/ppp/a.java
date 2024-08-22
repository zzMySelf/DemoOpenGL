package fe.qw.qw.ppp;

import android.graphics.PointF;
import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.parser.moshi.JsonReader;
import fe.qw.qw.de;
import fe.qw.qw.p009switch.i.rg;
import fe.qw.qw.p009switch.uk.ad;
import fe.qw.qw.p009switch.uk.th;
import java.io.IOException;

public class a {
    public static JsonReader.qw qw = JsonReader.qw.qw(SearchView.IME_OPTION_NO_MICROPHONE, "p", "s", "r", "hd");

    public static rg qw(JsonReader jsonReader, de deVar) throws IOException {
        String str = null;
        AnimatableValue<PointF, PointF> animatableValue = null;
        th thVar = null;
        ad adVar = null;
        boolean z = false;
        while (jsonReader.yj()) {
            int ddd = jsonReader.ddd(qw);
            if (ddd == 0) {
                str = jsonReader.ppp();
            } else if (ddd == 1) {
                animatableValue = qw.ad(jsonReader, deVar);
            } else if (ddd == 2) {
                thVar = fe.i(jsonReader, deVar);
            } else if (ddd == 3) {
                adVar = fe.rg(jsonReader, deVar);
            } else if (ddd != 4) {
                jsonReader.mmm();
            } else {
                z = jsonReader.uk();
            }
        }
        return new rg(str, animatableValue, thVar, adVar, z);
    }
}
