package fe.qw.qw.ppp;

import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.wallet.paysdk.b.j;
import com.dlife.ctaccountapi.t;
import java.io.IOException;

public class uk implements k<DocumentData> {

    /* renamed from: ad  reason: collision with root package name */
    public static final JsonReader.qw f3401ad = JsonReader.qw.qw(t.a, "f", "s", j.q, "tr", "lh", "ls", "fc", "sc", "sw", "of");
    public static final uk qw = new uk();

    /* renamed from: ad */
    public DocumentData qw(JsonReader jsonReader, float f) throws IOException {
        DocumentData.Justification justification = DocumentData.Justification.CENTER;
        jsonReader.fe();
        DocumentData.Justification justification2 = justification;
        String str = null;
        String str2 = null;
        float f2 = 0.0f;
        int i2 = 0;
        float f3 = 0.0f;
        float f4 = 0.0f;
        int i3 = 0;
        int i4 = 0;
        float f5 = 0.0f;
        boolean z = true;
        while (jsonReader.yj()) {
            switch (jsonReader.ddd(f3401ad)) {
                case 0:
                    str = jsonReader.ppp();
                    break;
                case 1:
                    str2 = jsonReader.ppp();
                    break;
                case 2:
                    f2 = (float) jsonReader.pf();
                    break;
                case 3:
                    int i5 = jsonReader.m4switch();
                    if (i5 <= DocumentData.Justification.CENTER.ordinal() && i5 >= 0) {
                        justification2 = DocumentData.Justification.values()[i5];
                        break;
                    } else {
                        justification2 = DocumentData.Justification.CENTER;
                        break;
                    }
                case 4:
                    i2 = jsonReader.m4switch();
                    break;
                case 5:
                    f3 = (float) jsonReader.pf();
                    break;
                case 6:
                    f4 = (float) jsonReader.pf();
                    break;
                case 7:
                    i3 = ggg.fe(jsonReader);
                    break;
                case 8:
                    i4 = ggg.fe(jsonReader);
                    break;
                case 9:
                    f5 = (float) jsonReader.pf();
                    break;
                case 10:
                    z = jsonReader.uk();
                    break;
                default:
                    jsonReader.nn();
                    jsonReader.mmm();
                    break;
            }
        }
        JsonReader jsonReader2 = jsonReader;
        jsonReader.th();
        return new DocumentData(str, str2, f2, justification2, i2, f3, f4, i3, i4, f5, z);
    }
}
