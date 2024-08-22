package fe.qw.qw.ppp;

import com.airbnb.lottie.parser.moshi.JsonReader;
import fe.qw.qw.vvv.fe;
import java.io.IOException;

public class c implements k<fe> {
    public static final c qw = new c();

    /* renamed from: ad */
    public fe qw(JsonReader jsonReader, float f) throws IOException {
        boolean z = jsonReader.vvv() == JsonReader.Token.BEGIN_ARRAY;
        if (z) {
            jsonReader.de();
        }
        float pf2 = (float) jsonReader.pf();
        float pf3 = (float) jsonReader.pf();
        while (jsonReader.yj()) {
            jsonReader.mmm();
        }
        if (z) {
            jsonReader.rg();
        }
        return new fe((pf2 / 100.0f) * f, (pf3 / 100.0f) * f);
    }
}
