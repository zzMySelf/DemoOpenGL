package fe.mmm.qw.d.ad;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import fe.mmm.qw.d.ad.ggg.de;

public class yj extends de {
    public void de(View view) {
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            if (yj()) {
                imageView.setImageDrawable(fe.mmm.qw.d.fe.yj.rg(this.f7683th));
            } else if (rg()) {
                imageView.setImageDrawable(new ColorDrawable(fe.mmm.qw.d.fe.yj.qw(this.f7683th)));
            }
        }
    }
}
