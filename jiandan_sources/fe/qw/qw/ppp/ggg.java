package fe.qw.qw.ppp;

import android.graphics.Color;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.dlife.ctaccountapi.x;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ggg {
    public static final JsonReader.qw qw = JsonReader.qw.qw(x.a, "y");

    public static /* synthetic */ class qw {
        public static final /* synthetic */ int[] qw;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.airbnb.lottie.parser.moshi.JsonReader$Token[] r0 = com.airbnb.lottie.parser.moshi.JsonReader.Token.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                qw = r0
                com.airbnb.lottie.parser.moshi.JsonReader$Token r1 = com.airbnb.lottie.parser.moshi.JsonReader.Token.NUMBER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.parser.moshi.JsonReader$Token r1 = com.airbnb.lottie.parser.moshi.JsonReader.Token.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.airbnb.lottie.parser.moshi.JsonReader$Token r1 = com.airbnb.lottie.parser.moshi.JsonReader.Token.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.qw.qw.ppp.ggg.qw.<clinit>():void");
        }
    }

    public static PointF ad(JsonReader jsonReader, float f) throws IOException {
        float pf2 = (float) jsonReader.pf();
        float pf3 = (float) jsonReader.pf();
        while (jsonReader.yj()) {
            jsonReader.mmm();
        }
        return new PointF(pf2 * f, pf3 * f);
    }

    public static PointF de(JsonReader jsonReader, float f) throws IOException {
        jsonReader.fe();
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (jsonReader.yj()) {
            int ddd = jsonReader.ddd(qw);
            if (ddd == 0) {
                f2 = yj(jsonReader);
            } else if (ddd != 1) {
                jsonReader.nn();
                jsonReader.mmm();
            } else {
                f3 = yj(jsonReader);
            }
        }
        jsonReader.th();
        return new PointF(f2 * f, f3 * f);
    }

    @ColorInt
    public static int fe(JsonReader jsonReader) throws IOException {
        jsonReader.de();
        int pf2 = (int) (jsonReader.pf() * 255.0d);
        int pf3 = (int) (jsonReader.pf() * 255.0d);
        int pf4 = (int) (jsonReader.pf() * 255.0d);
        while (jsonReader.yj()) {
            jsonReader.mmm();
        }
        jsonReader.rg();
        return Color.argb(255, pf2, pf3, pf4);
    }

    public static PointF qw(JsonReader jsonReader, float f) throws IOException {
        jsonReader.de();
        float pf2 = (float) jsonReader.pf();
        float pf3 = (float) jsonReader.pf();
        while (jsonReader.vvv() != JsonReader.Token.END_ARRAY) {
            jsonReader.mmm();
        }
        jsonReader.rg();
        return new PointF(pf2 * f, pf3 * f);
    }

    public static PointF rg(JsonReader jsonReader, float f) throws IOException {
        int i2 = qw.qw[jsonReader.vvv().ordinal()];
        if (i2 == 1) {
            return ad(jsonReader, f);
        }
        if (i2 == 2) {
            return qw(jsonReader, f);
        }
        if (i2 == 3) {
            return de(jsonReader, f);
        }
        throw new IllegalArgumentException("Unknown point starts with " + jsonReader.vvv());
    }

    public static List<PointF> th(JsonReader jsonReader, float f) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.de();
        while (jsonReader.vvv() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.de();
            arrayList.add(rg(jsonReader, f));
            jsonReader.rg();
        }
        jsonReader.rg();
        return arrayList;
    }

    public static float yj(JsonReader jsonReader) throws IOException {
        JsonReader.Token vvv = jsonReader.vvv();
        int i2 = qw.qw[vvv.ordinal()];
        if (i2 == 1) {
            return (float) jsonReader.pf();
        }
        if (i2 == 2) {
            jsonReader.de();
            float pf2 = (float) jsonReader.pf();
            while (jsonReader.yj()) {
                jsonReader.mmm();
            }
            jsonReader.rg();
            return pf2;
        }
        throw new IllegalArgumentException("Unknown value for token of type " + vvv);
    }
}
