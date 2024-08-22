package fe.qw.qw.ppp;

import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.parser.moshi.JsonReader;
import fe.qw.qw.de;
import fe.qw.qw.p009switch.i.i;
import java.io.IOException;
import java.util.ArrayList;

public class f {
    public static JsonReader.qw qw = JsonReader.qw.qw(SearchView.IME_OPTION_NO_MICROPHONE, "hd", "it");

    public static i qw(JsonReader jsonReader, de deVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        String str = null;
        boolean z = false;
        while (jsonReader.yj()) {
            int ddd = jsonReader.ddd(qw);
            if (ddd == 0) {
                str = jsonReader.ppp();
            } else if (ddd == 1) {
                z = jsonReader.uk();
            } else if (ddd != 2) {
                jsonReader.mmm();
            } else {
                jsonReader.de();
                while (jsonReader.yj()) {
                    ContentModel qw2 = yj.qw(jsonReader, deVar);
                    if (qw2 != null) {
                        arrayList.add(qw2);
                    }
                }
                jsonReader.rg();
            }
        }
        return new i(str, arrayList, z);
    }
}
