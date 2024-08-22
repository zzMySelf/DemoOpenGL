package fe.qw.qw.ppp;

import android.graphics.Color;
import android.graphics.Rect;
import android.view.animation.Interpolator;
import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.alipay.sdk.m.s.a;
import com.dlife.ctaccountapi.t;
import com.dlife.ctaccountapi.w;
import fe.qw.qw.de;
import fe.qw.qw.ggg.yj;
import fe.qw.qw.p009switch.uk.Cif;
import fe.qw.qw.p009switch.uk.ad;
import fe.qw.qw.p009switch.uk.o;
import fe.qw.qw.p009switch.uk.pf;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ddd {

    /* renamed from: ad  reason: collision with root package name */
    public static final JsonReader.qw f3392ad = JsonReader.qw.qw("d", "a");

    /* renamed from: de  reason: collision with root package name */
    public static final JsonReader.qw f3393de = JsonReader.qw.qw(SearchView.IME_OPTION_NO_MICROPHONE);
    public static final JsonReader.qw qw = JsonReader.qw.qw(SearchView.IME_OPTION_NO_MICROPHONE, "ind", "refId", a.s, "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", t.a, "ef", "sr", "st", w.a, "h", "ip", "op", "tm", "cl", "hd");

    public static /* synthetic */ class qw {
        public static final /* synthetic */ int[] qw;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.airbnb.lottie.model.layer.Layer$MatteType[] r0 = com.airbnb.lottie.model.layer.Layer.MatteType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                qw = r0
                com.airbnb.lottie.model.layer.Layer$MatteType r1 = com.airbnb.lottie.model.layer.Layer.MatteType.LUMA     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.model.layer.Layer$MatteType r1 = com.airbnb.lottie.model.layer.Layer.MatteType.LUMA_INVERTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.qw.qw.ppp.ddd.qw.<clinit>():void");
        }
    }

    public static Layer ad(JsonReader jsonReader, de deVar) throws IOException {
        ArrayList arrayList;
        ArrayList arrayList2;
        JsonReader jsonReader2 = jsonReader;
        de deVar2 = deVar;
        Layer.MatteType matteType = Layer.MatteType.NONE;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        jsonReader.fe();
        Float valueOf = Float.valueOf(1.0f);
        Float valueOf2 = Float.valueOf(0.0f);
        Layer.MatteType matteType2 = matteType;
        Layer.LayerType layerType = null;
        String str = null;
        Cif ifVar = null;
        o oVar = null;
        pf pfVar = null;
        ad adVar = null;
        long j = -1;
        float f = 0.0f;
        float f2 = 0.0f;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        float f3 = 1.0f;
        float f4 = 0.0f;
        int i5 = 0;
        int i6 = 0;
        boolean z = false;
        long j2 = 0;
        String str2 = null;
        String str3 = "UNSET";
        while (jsonReader.yj()) {
            switch (jsonReader2.ddd(qw)) {
                case 0:
                    str3 = jsonReader.ppp();
                    break;
                case 1:
                    j2 = (long) jsonReader.m4switch();
                    break;
                case 2:
                    str = jsonReader.ppp();
                    break;
                case 3:
                    int i7 = jsonReader.m4switch();
                    if (i7 >= Layer.LayerType.UNKNOWN.ordinal()) {
                        layerType = Layer.LayerType.UNKNOWN;
                        break;
                    } else {
                        layerType = Layer.LayerType.values()[i7];
                        break;
                    }
                case 4:
                    j = (long) jsonReader.m4switch();
                    break;
                case 5:
                    i2 = (int) (((float) jsonReader.m4switch()) * yj.rg());
                    break;
                case 6:
                    i3 = (int) (((float) jsonReader.m4switch()) * yj.rg());
                    break;
                case 7:
                    i4 = Color.parseColor(jsonReader.ppp());
                    break;
                case 8:
                    ifVar = de.yj(jsonReader, deVar);
                    break;
                case 9:
                    int i8 = jsonReader.m4switch();
                    if (i8 < Layer.MatteType.values().length) {
                        matteType2 = Layer.MatteType.values()[i8];
                        int i9 = qw.qw[matteType2.ordinal()];
                        if (i9 == 1) {
                            deVar2.qw("Unsupported matte type: Luma");
                        } else if (i9 == 2) {
                            deVar2.qw("Unsupported matte type: Luma Inverted");
                        }
                        deVar2.vvv(1);
                        break;
                    } else {
                        deVar2.qw("Unsupported matte type: " + i8);
                        break;
                    }
                case 10:
                    jsonReader.de();
                    while (jsonReader.yj()) {
                        arrayList3.add(mmm.qw(jsonReader, deVar));
                    }
                    deVar2.vvv(arrayList3.size());
                    jsonReader.rg();
                    break;
                case 11:
                    jsonReader.de();
                    while (jsonReader.yj()) {
                        ContentModel qw2 = yj.qw(jsonReader, deVar);
                        if (qw2 != null) {
                            arrayList4.add(qw2);
                        }
                    }
                    jsonReader.rg();
                    break;
                case 12:
                    jsonReader.fe();
                    while (jsonReader.yj()) {
                        int ddd = jsonReader2.ddd(f3392ad);
                        if (ddd == 0) {
                            oVar = fe.fe(jsonReader, deVar);
                        } else if (ddd != 1) {
                            jsonReader.nn();
                            jsonReader.mmm();
                        } else {
                            jsonReader.de();
                            if (jsonReader.yj()) {
                                pfVar = ad.qw(jsonReader, deVar);
                            }
                            while (jsonReader.yj()) {
                                jsonReader.mmm();
                            }
                            jsonReader.rg();
                        }
                    }
                    jsonReader.th();
                    break;
                case 13:
                    jsonReader.de();
                    ArrayList arrayList5 = new ArrayList();
                    while (jsonReader.yj()) {
                        jsonReader.fe();
                        while (jsonReader.yj()) {
                            if (jsonReader2.ddd(f3393de) != 0) {
                                jsonReader.nn();
                                jsonReader.mmm();
                            } else {
                                arrayList5.add(jsonReader.ppp());
                            }
                        }
                        jsonReader.th();
                    }
                    jsonReader.rg();
                    deVar2.qw("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList5);
                    break;
                case 14:
                    f3 = (float) jsonReader.pf();
                    break;
                case 15:
                    f4 = (float) jsonReader.pf();
                    break;
                case 16:
                    i5 = (int) (((float) jsonReader.m4switch()) * yj.rg());
                    break;
                case 17:
                    i6 = (int) (((float) jsonReader.m4switch()) * yj.rg());
                    break;
                case 18:
                    f = (float) jsonReader.pf();
                    break;
                case 19:
                    f2 = (float) jsonReader.pf();
                    break;
                case 20:
                    adVar = fe.th(jsonReader2, deVar2, false);
                    break;
                case 21:
                    str2 = jsonReader.ppp();
                    break;
                case 22:
                    z = jsonReader.uk();
                    break;
                default:
                    jsonReader.nn();
                    jsonReader.mmm();
                    break;
            }
        }
        jsonReader.th();
        float f5 = f / f3;
        float f6 = f2 / f3;
        ArrayList arrayList6 = new ArrayList();
        if (f5 > 0.0f) {
            fe.qw.qw.vvv.qw qwVar = r0;
            arrayList = arrayList3;
            arrayList2 = arrayList6;
            fe.qw.qw.vvv.qw qwVar2 = new fe.qw.qw.vvv.qw(deVar, valueOf2, valueOf2, (Interpolator) null, 0.0f, Float.valueOf(f5));
            arrayList2.add(qwVar);
        } else {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
        }
        if (f6 <= 0.0f) {
            f6 = deVar.th();
        }
        de deVar3 = deVar;
        arrayList2.add(new fe.qw.qw.vvv.qw(deVar3, valueOf, valueOf, (Interpolator) null, f5, Float.valueOf(f6)));
        arrayList2.add(new fe.qw.qw.vvv.qw(deVar3, valueOf2, valueOf2, (Interpolator) null, f6, Float.valueOf(Float.MAX_VALUE)));
        if (str3.endsWith(".ai") || "ai".equals(str2)) {
            deVar2.qw("Convert your Illustrator layers to shape layers.");
        }
        return new Layer(arrayList4, deVar, str3, j2, layerType, j, str, arrayList, ifVar, i2, i3, i4, f3, f4, i5, i6, oVar, pfVar, arrayList2, matteType2, adVar, z);
    }

    public static Layer qw(de deVar) {
        Rect ad2 = deVar.ad();
        List emptyList = Collections.emptyList();
        Layer.LayerType layerType = Layer.LayerType.PRE_COMP;
        List emptyList2 = Collections.emptyList();
        Cif ifVar = r4;
        Cif ifVar2 = new Cif();
        return new Layer(emptyList, deVar, "__container", -1, layerType, -1, (String) null, emptyList2, ifVar, 0, 0, 0, 0.0f, 0.0f, ad2.width(), ad2.height(), (o) null, (pf) null, Collections.emptyList(), Layer.MatteType.NONE, (ad) null, false);
    }
}
