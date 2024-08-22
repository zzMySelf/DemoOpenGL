package fe.qw.qw.ppp;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.dlife.ctaccountapi.v;
import com.dlife.ctaccountapi.w;
import fe.qw.qw.de;
import fe.qw.qw.ggg.fe;
import fe.qw.qw.ggg.yj;
import fe.qw.qw.p009switch.ad;
import fe.qw.qw.th;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class nn {

    /* renamed from: ad  reason: collision with root package name */
    public static JsonReader.qw f3396ad = JsonReader.qw.qw("id", "layers", w.a, "h", "p", "u");

    /* renamed from: de  reason: collision with root package name */
    public static final JsonReader.qw f3397de = JsonReader.qw.qw("list");

    /* renamed from: fe  reason: collision with root package name */
    public static final JsonReader.qw f3398fe = JsonReader.qw.qw("cm", "tm", "dr");
    public static final JsonReader.qw qw = JsonReader.qw.qw(w.a, "h", "ip", "op", "fr", v.d, "layers", "assets", "fonts", "chars", "markers");

    public static void ad(JsonReader jsonReader, de deVar, Map<String, List<Layer>> map, Map<String, th> map2) throws IOException {
        jsonReader.de();
        while (jsonReader.yj()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            jsonReader.fe();
            String str = null;
            String str2 = null;
            String str3 = null;
            int i2 = 0;
            int i3 = 0;
            while (jsonReader.yj()) {
                int ddd = jsonReader.ddd(f3396ad);
                if (ddd == 0) {
                    str = jsonReader.ppp();
                } else if (ddd == 1) {
                    jsonReader.de();
                    while (jsonReader.yj()) {
                        Layer ad2 = ddd.ad(jsonReader, deVar);
                        longSparseArray.put(ad2.ad(), ad2);
                        arrayList.add(ad2);
                    }
                    jsonReader.rg();
                } else if (ddd == 2) {
                    i2 = jsonReader.m4switch();
                } else if (ddd == 3) {
                    i3 = jsonReader.m4switch();
                } else if (ddd == 4) {
                    str2 = jsonReader.ppp();
                } else if (ddd != 5) {
                    jsonReader.nn();
                    jsonReader.mmm();
                } else {
                    str3 = jsonReader.ppp();
                }
            }
            jsonReader.th();
            if (str2 != null) {
                th thVar = new th(i2, i3, str, str2, str3);
                map2.put(thVar.fe(), thVar);
            } else {
                map.put(str, arrayList);
            }
        }
        jsonReader.rg();
    }

    public static void de(JsonReader jsonReader, de deVar, SparseArrayCompat<fe.qw.qw.p009switch.de> sparseArrayCompat) throws IOException {
        jsonReader.de();
        while (jsonReader.yj()) {
            fe.qw.qw.p009switch.de qw2 = o.qw(jsonReader, deVar);
            sparseArrayCompat.put(qw2.hashCode(), qw2);
        }
        jsonReader.rg();
    }

    public static void fe(JsonReader jsonReader, Map<String, ad> map) throws IOException {
        jsonReader.fe();
        while (jsonReader.yj()) {
            if (jsonReader.ddd(f3397de) != 0) {
                jsonReader.nn();
                jsonReader.mmm();
            } else {
                jsonReader.de();
                while (jsonReader.yj()) {
                    ad qw2 = pf.qw(jsonReader);
                    map.put(qw2.ad(), qw2);
                }
                jsonReader.rg();
            }
        }
        jsonReader.th();
    }

    public static de qw(JsonReader jsonReader) throws IOException {
        ArrayList arrayList;
        HashMap hashMap;
        JsonReader jsonReader2 = jsonReader;
        float rg2 = yj.rg();
        LongSparseArray longSparseArray = new LongSparseArray();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        SparseArrayCompat sparseArrayCompat = new SparseArrayCompat();
        de deVar = new de();
        jsonReader.fe();
        int i2 = 0;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i3 = 0;
        while (jsonReader.yj()) {
            switch (jsonReader2.ddd(qw)) {
                case 0:
                    HashMap hashMap5 = hashMap4;
                    ArrayList arrayList4 = arrayList3;
                    i2 = jsonReader.m4switch();
                    continue;
                case 1:
                    HashMap hashMap6 = hashMap4;
                    ArrayList arrayList5 = arrayList3;
                    i3 = jsonReader.m4switch();
                    continue;
                case 2:
                    HashMap hashMap7 = hashMap4;
                    ArrayList arrayList6 = arrayList3;
                    f = (float) jsonReader.pf();
                    continue;
                case 3:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f2 = ((float) jsonReader.pf()) - 0.01f;
                    break;
                case 4:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f3 = (float) jsonReader.pf();
                    break;
                case 5:
                    String[] split = jsonReader.ppp().split("\\.");
                    if (!yj.o(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 4, 4, 0)) {
                        deVar.qw("Lottie only supports bodymovin >= 4.4.0");
                        break;
                    }
                    break;
                case 6:
                    rg(jsonReader2, deVar, arrayList2, longSparseArray);
                    break;
                case 7:
                    ad(jsonReader2, deVar, hashMap2, hashMap3);
                    break;
                case 8:
                    fe(jsonReader2, hashMap4);
                    break;
                case 9:
                    de(jsonReader2, deVar, sparseArrayCompat);
                    break;
                case 10:
                    th(jsonReader2, deVar, arrayList3);
                    break;
                default:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    jsonReader.nn();
                    jsonReader.mmm();
                    break;
            }
            hashMap = hashMap4;
            arrayList = arrayList3;
            hashMap4 = hashMap;
            arrayList3 = arrayList;
            jsonReader2 = jsonReader;
        }
        ArrayList arrayList7 = arrayList3;
        deVar.xxx(new Rect(0, 0, (int) (((float) i2) * rg2), (int) (((float) i3) * rg2)), f, f2, f3, arrayList2, longSparseArray, hashMap2, hashMap3, sparseArrayCompat, hashMap4, arrayList3);
        return deVar;
    }

    public static void rg(JsonReader jsonReader, de deVar, List<Layer> list, LongSparseArray<Layer> longSparseArray) throws IOException {
        jsonReader.de();
        int i2 = 0;
        while (jsonReader.yj()) {
            Layer ad2 = ddd.ad(jsonReader, deVar);
            if (ad2.fe() == Layer.LayerType.IMAGE) {
                i2++;
            }
            list.add(ad2);
            longSparseArray.put(ad2.ad(), ad2);
            if (i2 > 4) {
                fe.de("You have " + i2 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.rg();
    }

    public static void th(JsonReader jsonReader, de deVar, List<fe.qw.qw.p009switch.th> list) throws IOException {
        jsonReader.de();
        while (jsonReader.yj()) {
            String str = null;
            jsonReader.fe();
            float f = 0.0f;
            float f2 = 0.0f;
            while (jsonReader.yj()) {
                int ddd = jsonReader.ddd(f3398fe);
                if (ddd == 0) {
                    str = jsonReader.ppp();
                } else if (ddd == 1) {
                    f = (float) jsonReader.pf();
                } else if (ddd != 2) {
                    jsonReader.nn();
                    jsonReader.mmm();
                } else {
                    f2 = (float) jsonReader.pf();
                }
            }
            jsonReader.th();
            list.add(new fe.qw.qw.p009switch.th(str, f, f2));
        }
        jsonReader.rg();
    }
}
