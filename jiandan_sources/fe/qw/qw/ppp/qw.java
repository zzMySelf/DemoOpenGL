package fe.qw.qw.ppp;

import android.graphics.PointF;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.dlife.ctaccountapi.x;
import fe.qw.qw.de;
import fe.qw.qw.ggg.yj;
import fe.qw.qw.p009switch.uk.ad;
import fe.qw.qw.p009switch.uk.i;
import fe.qw.qw.p009switch.uk.rg;
import java.io.IOException;
import java.util.ArrayList;

public class qw {
    public static JsonReader.qw qw = JsonReader.qw.qw("k", x.a, "y");

    public static AnimatableValue<PointF, PointF> ad(JsonReader jsonReader, de deVar) throws IOException {
        jsonReader.fe();
        rg rgVar = null;
        ad adVar = null;
        ad adVar2 = null;
        boolean z = false;
        while (jsonReader.vvv() != JsonReader.Token.END_OBJECT) {
            int ddd = jsonReader.ddd(qw);
            if (ddd != 0) {
                if (ddd != 1) {
                    if (ddd != 2) {
                        jsonReader.nn();
                        jsonReader.mmm();
                    } else if (jsonReader.vvv() == JsonReader.Token.STRING) {
                        jsonReader.mmm();
                    } else {
                        adVar2 = fe.rg(jsonReader, deVar);
                    }
                } else if (jsonReader.vvv() == JsonReader.Token.STRING) {
                    jsonReader.mmm();
                } else {
                    adVar = fe.rg(jsonReader, deVar);
                }
                z = true;
            } else {
                rgVar = qw(jsonReader, deVar);
            }
        }
        jsonReader.th();
        if (z) {
            deVar.qw("Lottie doesn't support expressions.");
        }
        if (rgVar != null) {
            return rgVar;
        }
        return new i(adVar, adVar2);
    }

    public static rg qw(JsonReader jsonReader, de deVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.vvv() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.de();
            while (jsonReader.yj()) {
                arrayList.add(qqq.qw(jsonReader, deVar));
            }
            jsonReader.rg();
            xxx.ad(arrayList);
        } else {
            arrayList.add(new fe.qw.qw.vvv.qw(ggg.rg(jsonReader, yj.rg())));
        }
        return new rg(arrayList);
    }
}
