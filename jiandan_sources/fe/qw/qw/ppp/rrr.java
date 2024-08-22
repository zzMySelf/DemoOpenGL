package fe.qw.qw.ppp;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

public class rrr implements k<PointF> {
    public static final rrr qw = new rrr();

    /* renamed from: ad */
    public PointF qw(JsonReader jsonReader, float f) throws IOException {
        JsonReader.Token vvv = jsonReader.vvv();
        if (vvv == JsonReader.Token.BEGIN_ARRAY) {
            return ggg.rg(jsonReader, f);
        }
        if (vvv == JsonReader.Token.BEGIN_OBJECT) {
            return ggg.rg(jsonReader, f);
        }
        if (vvv == JsonReader.Token.NUMBER) {
            PointF pointF = new PointF(((float) jsonReader.pf()) * f, ((float) jsonReader.pf()) * f);
            while (jsonReader.yj()) {
                jsonReader.mmm();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + vvv);
    }
}
