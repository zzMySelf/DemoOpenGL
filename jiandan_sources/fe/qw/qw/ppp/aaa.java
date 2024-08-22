package fe.qw.qw.ppp;

import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.model.content.MergePaths;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

public class aaa {
    public static final JsonReader.qw qw = JsonReader.qw.qw(SearchView.IME_OPTION_NO_MICROPHONE, "mm", "hd");

    public static MergePaths qw(JsonReader jsonReader) throws IOException {
        String str = null;
        MergePaths.MergePathsMode mergePathsMode = null;
        boolean z = false;
        while (jsonReader.yj()) {
            int ddd = jsonReader.ddd(qw);
            if (ddd == 0) {
                str = jsonReader.ppp();
            } else if (ddd == 1) {
                mergePathsMode = MergePaths.MergePathsMode.forId(jsonReader.m4switch());
            } else if (ddd != 2) {
                jsonReader.nn();
                jsonReader.mmm();
            } else {
                z = jsonReader.uk();
            }
        }
        return new MergePaths(str, mergePathsMode, z);
    }
}
