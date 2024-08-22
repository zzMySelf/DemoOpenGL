package fe.qw.qw.ppp;

import android.graphics.PointF;
import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.parser.moshi.JsonReader;
import fe.qw.qw.de;
import fe.qw.qw.p009switch.i.qw;
import fe.qw.qw.p009switch.uk.th;
import java.io.IOException;

public class rg {
    public static JsonReader.qw qw = JsonReader.qw.qw(SearchView.IME_OPTION_NO_MICROPHONE, "p", "s", "hd", "d");

    public static qw qw(JsonReader jsonReader, de deVar, int i2) throws IOException {
        boolean z = i2 == 3;
        String str = null;
        AnimatableValue<PointF, PointF> animatableValue = null;
        th thVar = null;
        boolean z2 = false;
        while (jsonReader.yj()) {
            int ddd = jsonReader.ddd(qw);
            if (ddd == 0) {
                str = jsonReader.ppp();
            } else if (ddd == 1) {
                animatableValue = qw.ad(jsonReader, deVar);
            } else if (ddd == 2) {
                thVar = fe.i(jsonReader, deVar);
            } else if (ddd == 3) {
                z2 = jsonReader.uk();
            } else if (ddd != 4) {
                jsonReader.nn();
                jsonReader.mmm();
            } else {
                z = jsonReader.m4switch() == 3;
            }
        }
        return new qw(str, animatableValue, thVar, z, z2);
    }
}
