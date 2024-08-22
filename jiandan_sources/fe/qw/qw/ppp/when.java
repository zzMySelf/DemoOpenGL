package fe.qw.qw.ppp;

import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.apollon.restnet.rest.g;
import com.dlife.ctaccountapi.t;
import com.dlife.ctaccountapi.v;
import com.dlife.ctaccountapi.w;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import fe.qw.qw.de;
import fe.qw.qw.p009switch.i.fe;
import fe.qw.qw.p009switch.uk.ad;
import fe.qw.qw.p009switch.uk.th;
import fe.qw.qw.vvv.qw;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class when {

    /* renamed from: ad  reason: collision with root package name */
    public static final JsonReader.qw f3404ad = JsonReader.qw.qw("p", "k");

    /* renamed from: de  reason: collision with root package name */
    public static final JsonReader.qw f3405de = JsonReader.qw.qw(GoogleApiAvailabilityLight.TRACKING_SOURCE_NOTIFICATION, v.d);
    public static JsonReader.qw qw = JsonReader.qw.qw(SearchView.IME_OPTION_NO_MICROPHONE, g.a, "o", t.a, "s", "e", w.a, "lc", "lj", "ml", "hd", "d");

    public static fe qw(JsonReader jsonReader, de deVar) throws IOException {
        fe.qw.qw.p009switch.uk.de deVar2;
        JsonReader jsonReader2 = jsonReader;
        de deVar3 = deVar;
        ArrayList arrayList = new ArrayList();
        String str = null;
        GradientType gradientType = null;
        fe.qw.qw.p009switch.uk.de deVar4 = null;
        th thVar = null;
        th thVar2 = null;
        ad adVar = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        float f = 0.0f;
        ad adVar2 = null;
        boolean z = false;
        fe.qw.qw.p009switch.uk.fe feVar = null;
        while (jsonReader.yj()) {
            switch (jsonReader2.ddd(qw)) {
                case 0:
                    str = jsonReader.ppp();
                    break;
                case 1:
                    int i2 = -1;
                    jsonReader.fe();
                    while (jsonReader.yj()) {
                        int ddd = jsonReader2.ddd(f3404ad);
                        if (ddd != 0) {
                            deVar2 = deVar4;
                            if (ddd != 1) {
                                jsonReader.nn();
                                jsonReader.mmm();
                            } else {
                                deVar4 = fe.yj(jsonReader2, deVar3, i2);
                            }
                        } else {
                            deVar2 = deVar4;
                            i2 = jsonReader.m4switch();
                        }
                        deVar4 = deVar2;
                    }
                    fe.qw.qw.p009switch.uk.de deVar5 = deVar4;
                    jsonReader.th();
                    break;
                case 2:
                    feVar = fe.uk(jsonReader, deVar);
                    break;
                case 3:
                    gradientType = jsonReader.m4switch() == 1 ? GradientType.LINEAR : GradientType.RADIAL;
                    break;
                case 4:
                    thVar = fe.i(jsonReader, deVar);
                    break;
                case 5:
                    thVar2 = fe.i(jsonReader, deVar);
                    break;
                case 6:
                    adVar = fe.rg(jsonReader, deVar);
                    break;
                case 7:
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.m4switch() - 1];
                    break;
                case 8:
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.m4switch() - 1];
                    break;
                case 9:
                    f = (float) jsonReader.pf();
                    break;
                case 10:
                    z = jsonReader.uk();
                    break;
                case 11:
                    jsonReader.de();
                    while (jsonReader.yj()) {
                        jsonReader.fe();
                        String str2 = null;
                        ad adVar3 = null;
                        while (jsonReader.yj()) {
                            int ddd2 = jsonReader2.ddd(f3405de);
                            if (ddd2 != 0) {
                                ad adVar4 = adVar2;
                                if (ddd2 != 1) {
                                    jsonReader.nn();
                                    jsonReader.mmm();
                                } else {
                                    adVar3 = fe.rg(jsonReader, deVar);
                                }
                                adVar2 = adVar4;
                            } else {
                                ad adVar5 = adVar2;
                                str2 = jsonReader.ppp();
                            }
                        }
                        ad adVar6 = adVar2;
                        jsonReader.th();
                        if (str2.equals("o")) {
                            adVar2 = adVar3;
                        } else {
                            if (str2.equals("d") || str2.equals(g.a)) {
                                deVar3.nn(true);
                                arrayList.add(adVar3);
                            }
                            adVar2 = adVar6;
                        }
                    }
                    ad adVar7 = adVar2;
                    jsonReader.rg();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                    }
                    adVar2 = adVar7;
                    break;
                default:
                    jsonReader.nn();
                    jsonReader.mmm();
                    break;
            }
        }
        if (feVar == null) {
            feVar = new fe.qw.qw.p009switch.uk.fe(Collections.singletonList(new qw(100)));
        }
        return new fe(str, gradientType, deVar4, feVar, thVar, thVar2, adVar, lineCapType, lineJoinType, f, arrayList, adVar2, z);
    }
}
