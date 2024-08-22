package fe.qw.qw.ppp;

import android.graphics.Color;
import androidx.annotation.IntRange;
import com.airbnb.lottie.parser.moshi.JsonReader;
import fe.qw.qw.ggg.th;
import fe.qw.qw.p009switch.i.ad;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: fe.qw.qw.ppp.if  reason: invalid class name */
public class Cif implements k<ad> {
    public int qw;

    public Cif(int i2) {
        this.qw = i2;
    }

    public final void ad(ad adVar, List<Float> list) {
        int i2 = this.qw * 4;
        if (list.size() > i2) {
            int size = (list.size() - i2) / 2;
            double[] dArr = new double[size];
            double[] dArr2 = new double[size];
            int i3 = 0;
            while (i2 < list.size()) {
                if (i2 % 2 == 0) {
                    dArr[i3] = (double) list.get(i2).floatValue();
                } else {
                    dArr2[i3] = (double) list.get(i2).floatValue();
                    i3++;
                }
                i2++;
            }
            for (int i4 = 0; i4 < adVar.de(); i4++) {
                int i5 = adVar.qw()[i4];
                adVar.qw()[i4] = Color.argb(de((double) adVar.ad()[i4], dArr, dArr2), Color.red(i5), Color.green(i5), Color.blue(i5));
            }
        }
    }

    @IntRange(from = 0, to = 255)
    public final int de(double d, double[] dArr, double[] dArr2) {
        double d2;
        double[] dArr3 = dArr;
        double[] dArr4 = dArr2;
        int i2 = 1;
        while (true) {
            if (i2 >= dArr3.length) {
                d2 = dArr4[dArr4.length - 1];
                break;
            }
            int i3 = i2 - 1;
            double d3 = dArr3[i3];
            double d4 = dArr3[i2];
            if (dArr3[i2] >= d) {
                d2 = th.o(dArr4[i3], dArr4[i2], th.ad((d - d3) / (d4 - d3), 0.0d, 1.0d));
                break;
            }
            i2++;
        }
        return (int) (d2 * 255.0d);
    }

    /* renamed from: fe */
    public ad qw(JsonReader jsonReader, float f) throws IOException {
        ArrayList arrayList = new ArrayList();
        boolean z = jsonReader.vvv() == JsonReader.Token.BEGIN_ARRAY;
        if (z) {
            jsonReader.de();
        }
        while (jsonReader.yj()) {
            arrayList.add(Float.valueOf((float) jsonReader.pf()));
        }
        if (z) {
            jsonReader.rg();
        }
        if (this.qw == -1) {
            this.qw = arrayList.size() / 4;
        }
        int i2 = this.qw;
        float[] fArr = new float[i2];
        int[] iArr = new int[i2];
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < this.qw * 4; i5++) {
            int i6 = i5 / 4;
            double floatValue = (double) ((Float) arrayList.get(i5)).floatValue();
            int i7 = i5 % 4;
            if (i7 == 0) {
                fArr[i6] = (float) floatValue;
            } else if (i7 == 1) {
                i3 = (int) (floatValue * 255.0d);
            } else if (i7 == 2) {
                i4 = (int) (floatValue * 255.0d);
            } else if (i7 == 3) {
                iArr[i6] = Color.argb(255, i3, i4, (int) (floatValue * 255.0d));
            }
        }
        ad adVar = new ad(fArr, iArr);
        ad(adVar, arrayList);
        return adVar;
    }
}
