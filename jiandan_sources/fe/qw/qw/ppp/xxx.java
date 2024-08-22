package fe.qw.qw.ppp;

import com.airbnb.lottie.parser.moshi.JsonReader;
import fe.qw.qw.de;
import fe.qw.qw.pf.de.yj;
import fe.qw.qw.vvv.qw;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class xxx {
    public static JsonReader.qw qw = JsonReader.qw.qw("k");

    public static <T> void ad(List<? extends qw<T>> list) {
        int i2;
        T t;
        int size = list.size();
        int i3 = 0;
        while (true) {
            i2 = size - 1;
            if (i3 >= i2) {
                break;
            }
            qw qwVar = (qw) list.get(i3);
            i3++;
            qw qwVar2 = (qw) list.get(i3);
            qwVar.f3532th = Float.valueOf(qwVar2.f3531rg);
            if (qwVar.f3526de == null && (t = qwVar2.f3525ad) != null) {
                qwVar.f3526de = t;
                if (qwVar instanceof yj) {
                    ((yj) qwVar).i();
                }
            }
        }
        qw qwVar3 = (qw) list.get(i2);
        if ((qwVar3.f3525ad == null || qwVar3.f3526de == null) && list.size() > 1) {
            list.remove(qwVar3);
        }
    }

    public static <T> List<qw<T>> qw(JsonReader jsonReader, de deVar, float f, k<T> kVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.vvv() == JsonReader.Token.STRING) {
            deVar.qw("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.fe();
        while (jsonReader.yj()) {
            if (jsonReader.ddd(qw) != 0) {
                jsonReader.mmm();
            } else if (jsonReader.vvv() == JsonReader.Token.BEGIN_ARRAY) {
                jsonReader.de();
                if (jsonReader.vvv() == JsonReader.Token.NUMBER) {
                    arrayList.add(vvv.ad(jsonReader, deVar, f, kVar, false));
                } else {
                    while (jsonReader.yj()) {
                        arrayList.add(vvv.ad(jsonReader, deVar, f, kVar, true));
                    }
                }
                jsonReader.rg();
            } else {
                arrayList.add(vvv.ad(jsonReader, deVar, f, kVar, false));
            }
        }
        jsonReader.th();
        ad(arrayList);
        return arrayList;
    }
}
