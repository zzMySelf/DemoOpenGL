package fe.qw.qw.ppp;

import android.graphics.Path;
import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.parser.moshi.JsonReader;
import fe.qw.qw.de;
import fe.qw.qw.p009switch.i.uk;
import fe.qw.qw.p009switch.uk.fe;
import fe.qw.qw.p009switch.uk.qw;
import java.io.IOException;
import java.util.Collections;

public class e {
    public static final JsonReader.qw qw = JsonReader.qw.qw(SearchView.IME_OPTION_NO_MICROPHONE, "c", "o", "fillEnabled", "r", "hd");

    public static uk qw(JsonReader jsonReader, de deVar) throws IOException {
        fe feVar = null;
        String str = null;
        qw qwVar = null;
        int i2 = 1;
        boolean z = false;
        boolean z2 = false;
        while (jsonReader.yj()) {
            int ddd = jsonReader.ddd(qw);
            if (ddd == 0) {
                str = jsonReader.ppp();
            } else if (ddd == 1) {
                qwVar = fe.de(jsonReader, deVar);
            } else if (ddd == 2) {
                feVar = fe.uk(jsonReader, deVar);
            } else if (ddd == 3) {
                z = jsonReader.uk();
            } else if (ddd == 4) {
                i2 = jsonReader.m4switch();
            } else if (ddd != 5) {
                jsonReader.nn();
                jsonReader.mmm();
            } else {
                z2 = jsonReader.uk();
            }
        }
        return new uk(str, z, i2 == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, qwVar, feVar == null ? new fe(Collections.singletonList(new fe.qw.qw.vvv.qw(100))) : feVar, z2);
    }
}
