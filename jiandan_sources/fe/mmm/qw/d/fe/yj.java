package fe.mmm.qw.d.fe;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.baidu.apollon.utils.ResUtils;
import fe.mmm.qw.d.de.de;

public class yj {
    public static int ad() {
        int identifier;
        Resources ggg = de.when().ggg();
        if (ggg == null || (identifier = ggg.getIdentifier("bg_dn_home_page", ResUtils.f, de.when().pf())) <= 0) {
            return -1;
        }
        return ggg.getColor(identifier);
    }

    public static ColorStateList de(int i2) {
        return de.when().o(i2);
    }

    public static int fe(int i2) {
        return de.when().m964if(i2);
    }

    public static int qw(int i2) {
        return de.when().i(i2);
    }

    public static Drawable rg(int i2) {
        return de.when().m965switch(i2);
    }

    public static int th() {
        int identifier;
        Resources ggg = de.when().ggg();
        if (ggg == null || (identifier = ggg.getIdentifier("bg_dn_home_page_half", ResUtils.f, de.when().pf())) <= 0) {
            return -1;
        }
        return ggg.getColor(identifier);
    }
}
