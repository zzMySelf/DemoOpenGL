package fe.qw.qw.ppp;

import com.airbnb.lottie.parser.moshi.JsonReader;
import fe.qw.qw.p009switch.ad;
import java.io.IOException;

public class pf {
    public static final JsonReader.qw qw = JsonReader.qw.qw("fFamily", "fName", "fStyle", "ascent");

    public static ad qw(JsonReader jsonReader) throws IOException {
        jsonReader.fe();
        String str = null;
        String str2 = null;
        String str3 = null;
        float f = 0.0f;
        while (jsonReader.yj()) {
            int ddd = jsonReader.ddd(qw);
            if (ddd == 0) {
                str = jsonReader.ppp();
            } else if (ddd == 1) {
                str2 = jsonReader.ppp();
            } else if (ddd == 2) {
                str3 = jsonReader.ppp();
            } else if (ddd != 3) {
                jsonReader.nn();
                jsonReader.mmm();
            } else {
                f = (float) jsonReader.pf();
            }
        }
        jsonReader.th();
        return new ad(str, str2, str3, f);
    }
}
