package fe.qw.qw.ppp;

import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.parser.moshi.JsonReader;
import fe.qw.qw.de;
import fe.qw.qw.p009switch.uk.ad;
import java.io.IOException;

public class j {
    public static JsonReader.qw qw = JsonReader.qw.qw("s", "e", "o", SearchView.IME_OPTION_NO_MICROPHONE, "m", "hd");

    public static ShapeTrimPath qw(JsonReader jsonReader, de deVar) throws IOException {
        String str = null;
        ShapeTrimPath.Type type = null;
        ad adVar = null;
        ad adVar2 = null;
        ad adVar3 = null;
        boolean z = false;
        while (jsonReader.yj()) {
            int ddd = jsonReader.ddd(qw);
            if (ddd == 0) {
                adVar = fe.th(jsonReader, deVar, false);
            } else if (ddd == 1) {
                adVar2 = fe.th(jsonReader, deVar, false);
            } else if (ddd == 2) {
                adVar3 = fe.th(jsonReader, deVar, false);
            } else if (ddd == 3) {
                str = jsonReader.ppp();
            } else if (ddd == 4) {
                type = ShapeTrimPath.Type.forId(jsonReader.m4switch());
            } else if (ddd != 5) {
                jsonReader.mmm();
            } else {
                z = jsonReader.uk();
            }
        }
        return new ShapeTrimPath(str, type, adVar, adVar2, adVar3, z);
    }
}
