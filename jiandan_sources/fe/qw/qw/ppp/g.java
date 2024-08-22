package fe.qw.qw.ppp;

import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.parser.moshi.JsonReader;
import fe.qw.qw.de;
import fe.qw.qw.p009switch.i.o;
import fe.qw.qw.p009switch.uk.uk;
import java.io.IOException;

public class g {
    public static JsonReader.qw qw = JsonReader.qw.qw(SearchView.IME_OPTION_NO_MICROPHONE, "ind", "ks", "hd");

    public static o qw(JsonReader jsonReader, de deVar) throws IOException {
        int i2 = 0;
        String str = null;
        uk ukVar = null;
        boolean z = false;
        while (jsonReader.yj()) {
            int ddd = jsonReader.ddd(qw);
            if (ddd == 0) {
                str = jsonReader.ppp();
            } else if (ddd == 1) {
                i2 = jsonReader.m4switch();
            } else if (ddd == 2) {
                ukVar = fe.pf(jsonReader, deVar);
            } else if (ddd != 3) {
                jsonReader.mmm();
            } else {
                z = jsonReader.uk();
            }
        }
        return new o(str, i2, ukVar, z);
    }
}
