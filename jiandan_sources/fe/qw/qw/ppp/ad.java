package fe.qw.qw.ppp;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.dlife.ctaccountapi.t;
import fe.qw.qw.de;
import fe.qw.qw.p009switch.uk.pf;
import fe.qw.qw.p009switch.uk.qw;
import java.io.IOException;

public class ad {

    /* renamed from: ad  reason: collision with root package name */
    public static JsonReader.qw f3390ad = JsonReader.qw.qw("fc", "sc", "sw", t.a);
    public static JsonReader.qw qw = JsonReader.qw.qw("a");

    public static pf ad(JsonReader jsonReader, de deVar) throws IOException {
        jsonReader.fe();
        qw qwVar = null;
        qw qwVar2 = null;
        fe.qw.qw.p009switch.uk.ad adVar = null;
        fe.qw.qw.p009switch.uk.ad adVar2 = null;
        while (jsonReader.yj()) {
            int ddd = jsonReader.ddd(f3390ad);
            if (ddd == 0) {
                qwVar = fe.de(jsonReader, deVar);
            } else if (ddd == 1) {
                qwVar2 = fe.de(jsonReader, deVar);
            } else if (ddd == 2) {
                adVar = fe.rg(jsonReader, deVar);
            } else if (ddd != 3) {
                jsonReader.nn();
                jsonReader.mmm();
            } else {
                adVar2 = fe.rg(jsonReader, deVar);
            }
        }
        jsonReader.th();
        return new pf(qwVar, qwVar2, adVar, adVar2);
    }

    public static pf qw(JsonReader jsonReader, de deVar) throws IOException {
        jsonReader.fe();
        pf pfVar = null;
        while (jsonReader.yj()) {
            if (jsonReader.ddd(qw) != 0) {
                jsonReader.nn();
                jsonReader.mmm();
            } else {
                pfVar = ad(jsonReader, deVar);
            }
        }
        jsonReader.th();
        return pfVar == null ? new pf((qw) null, (qw) null, (fe.qw.qw.p009switch.uk.ad) null, (fe.qw.qw.p009switch.uk.ad) null) : pfVar;
    }
}
