package fe.mmm.qw.d.fe;

import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class de {
    public static Resources qw(AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration) {
        try {
            return new Resources(assetManager, displayMetrics, configuration);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
