package fe.qw.qw.ppp;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.cmic.sso.sdk.e.i;
import com.dlife.ctaccountapi.v;
import fe.qw.qw.ggg.th;
import fe.qw.qw.p009switch.i.yj;
import fe.qw.qw.p009switch.qw;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class d implements k<yj> {

    /* renamed from: ad  reason: collision with root package name */
    public static final JsonReader.qw f3391ad = JsonReader.qw.qw("c", v.d, i.a, "o");
    public static final d qw = new d();

    /* renamed from: ad */
    public yj qw(JsonReader jsonReader, float f) throws IOException {
        if (jsonReader.vvv() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.de();
        }
        jsonReader.fe();
        List<PointF> list = null;
        List<PointF> list2 = null;
        List<PointF> list3 = null;
        boolean z = false;
        while (jsonReader.yj()) {
            int ddd = jsonReader.ddd(f3391ad);
            if (ddd == 0) {
                z = jsonReader.uk();
            } else if (ddd == 1) {
                list = ggg.th(jsonReader, f);
            } else if (ddd == 2) {
                list2 = ggg.th(jsonReader, f);
            } else if (ddd != 3) {
                jsonReader.nn();
                jsonReader.mmm();
            } else {
                list3 = ggg.th(jsonReader, f);
            }
        }
        jsonReader.th();
        if (jsonReader.vvv() == JsonReader.Token.END_ARRAY) {
            jsonReader.rg();
        }
        if (list == null || list2 == null || list3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        } else if (list.isEmpty()) {
            return new yj(new PointF(), false, Collections.emptyList());
        } else {
            int size = list.size();
            PointF pointF = list.get(0);
            ArrayList arrayList = new ArrayList(size);
            for (int i2 = 1; i2 < size; i2++) {
                PointF pointF2 = list.get(i2);
                int i3 = i2 - 1;
                arrayList.add(new qw(th.qw(list.get(i3), list3.get(i3)), th.qw(pointF2, list2.get(i2)), pointF2));
            }
            if (z) {
                PointF pointF3 = list.get(0);
                int i4 = size - 1;
                arrayList.add(new qw(th.qw(list.get(i4), list3.get(i4)), th.qw(pointF3, list2.get(0)), pointF3));
            }
            return new yj(pointF, z, arrayList);
        }
    }
}
