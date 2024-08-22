package fe.mmm.qw.d.ad;

import android.content.res.ColorStateList;
import android.view.View;
import android.widget.TextView;
import fe.mmm.qw.d.ad.ggg.de;
import fe.mmm.qw.d.fe.yj;

public class ppp extends de {
    public void de(View view) {
        ColorStateList de2;
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (rg()) {
                textView.setTextColor(yj.qw(this.f7683th));
            } else if (yj() && (de2 = yj.de(this.f7683th)) != null) {
                textView.setTextColor(de2);
            }
        }
    }
}
