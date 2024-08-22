package fe.qw.qw.ppp;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.apollon.utils.ResUtils;
import com.dlife.ctaccountapi.w;
import fe.qw.qw.p009switch.de;
import fe.qw.qw.p009switch.i.i;
import java.io.IOException;
import java.util.ArrayList;

public class o {

    /* renamed from: ad  reason: collision with root package name */
    public static final JsonReader.qw f3399ad = JsonReader.qw.qw("shapes");
    public static final JsonReader.qw qw = JsonReader.qw.qw("ch", "size", w.a, ResUtils.d, "fFamily", "data");

    public static de qw(JsonReader jsonReader, fe.qw.qw.de deVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.fe();
        String str = null;
        String str2 = null;
        double d = 0.0d;
        double d2 = 0.0d;
        char c = 0;
        while (jsonReader.yj()) {
            int ddd = jsonReader.ddd(qw);
            if (ddd == 0) {
                c = jsonReader.ppp().charAt(0);
            } else if (ddd == 1) {
                d = jsonReader.pf();
            } else if (ddd == 2) {
                d2 = jsonReader.pf();
            } else if (ddd == 3) {
                str = jsonReader.ppp();
            } else if (ddd == 4) {
                str2 = jsonReader.ppp();
            } else if (ddd != 5) {
                jsonReader.nn();
                jsonReader.mmm();
            } else {
                jsonReader.fe();
                while (jsonReader.yj()) {
                    if (jsonReader.ddd(f3399ad) != 0) {
                        jsonReader.nn();
                        jsonReader.mmm();
                    } else {
                        jsonReader.de();
                        while (jsonReader.yj()) {
                            arrayList.add((i) yj.qw(jsonReader, deVar));
                        }
                        jsonReader.rg();
                    }
                }
                jsonReader.th();
            }
        }
        jsonReader.th();
        return new de(arrayList, c, d, d2, str, str2);
    }
}
