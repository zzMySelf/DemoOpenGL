package fe.mmm.qw.d.fe;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;

public class i {
    public static Typeface qw;

    public static Typeface qw(Context context) {
        String ad2 = th.ad(context, "skin_font_path");
        if (!TextUtils.isEmpty(ad2)) {
            return Typeface.createFromAsset(context.getAssets(), ad2);
        }
        Typeface typeface = Typeface.DEFAULT;
        th.fe(context, "skin_font_path", "");
        return typeface;
    }
}
