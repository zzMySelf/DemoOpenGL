package fe.mmm.qw.d.ad;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.CheckBox;
import fe.mmm.qw.d.ad.ggg.de;
import fe.mmm.qw.d.fe.yj;

public class ad extends de {
    public void de(View view) {
        if (yj()) {
            Drawable rg2 = yj.rg(this.f7683th);
            if (view instanceof CheckBox) {
                ((CheckBox) view).setButtonDrawable(rg2);
            }
        }
    }
}
