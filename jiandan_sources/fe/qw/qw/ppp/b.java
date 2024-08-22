package fe.qw.qw.ppp;

import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.parser.moshi.JsonReader;
import fe.qw.qw.de;
import fe.qw.qw.p009switch.i.th;
import fe.qw.qw.p009switch.uk.Cif;
import fe.qw.qw.p009switch.uk.ad;
import java.io.IOException;

public class b {
    public static JsonReader.qw qw = JsonReader.qw.qw(SearchView.IME_OPTION_NO_MICROPHONE, "c", "o", "tr", "hd");

    public static th qw(JsonReader jsonReader, de deVar) throws IOException {
        String str = null;
        ad adVar = null;
        ad adVar2 = null;
        Cif ifVar = null;
        boolean z = false;
        while (jsonReader.yj()) {
            int ddd = jsonReader.ddd(qw);
            if (ddd == 0) {
                str = jsonReader.ppp();
            } else if (ddd == 1) {
                adVar = fe.th(jsonReader, deVar, false);
            } else if (ddd == 2) {
                adVar2 = fe.th(jsonReader, deVar, false);
            } else if (ddd == 3) {
                ifVar = de.yj(jsonReader, deVar);
            } else if (ddd != 4) {
                jsonReader.mmm();
            } else {
                z = jsonReader.uk();
            }
        }
        return new th(str, adVar, adVar2, ifVar, z);
    }
}
