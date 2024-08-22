package fe.mmm.qw.d.ad;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import fe.mmm.qw.d.ad.ggg.de;
import fe.mmm.qw.d.fe.yj;

public class rg extends de {
    public void de(View view) {
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (yj()) {
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, yj.rg(this.f7683th), (Drawable) null, (Drawable) null);
            }
        }
    }
}
