package fe.mmm.qw.d.ad;

import android.view.View;
import android.widget.ProgressBar;
import fe.mmm.qw.d.ad.ggg.de;
import fe.mmm.qw.d.fe.yj;

public class when extends de {
    public void de(View view) {
        if (view instanceof ProgressBar) {
            ProgressBar progressBar = (ProgressBar) view;
            if (yj()) {
                progressBar.setProgressDrawable(yj.rg(this.f7683th));
            }
        }
    }
}
