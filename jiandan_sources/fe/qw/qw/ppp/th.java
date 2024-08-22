package fe.qw.qw.ppp;

import android.graphics.Color;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

public class th implements k<Integer> {
    public static final th qw = new th();

    /* renamed from: ad */
    public Integer qw(JsonReader jsonReader, float f) throws IOException {
        boolean z = jsonReader.vvv() == JsonReader.Token.BEGIN_ARRAY;
        if (z) {
            jsonReader.de();
        }
        double pf2 = jsonReader.pf();
        double pf3 = jsonReader.pf();
        double pf4 = jsonReader.pf();
        double pf5 = jsonReader.vvv() == JsonReader.Token.NUMBER ? jsonReader.pf() : 1.0d;
        if (z) {
            jsonReader.rg();
        }
        if (pf2 <= 1.0d && pf3 <= 1.0d && pf4 <= 1.0d) {
            pf2 *= 255.0d;
            pf3 *= 255.0d;
            pf4 *= 255.0d;
            if (pf5 <= 1.0d) {
                pf5 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) pf5, (int) pf2, (int) pf3, (int) pf4));
    }
}
