package fe.mmm.qw.d.ad;

import android.view.View;
import android.widget.ListView;
import fe.mmm.qw.d.ad.ggg.de;
import fe.mmm.qw.d.fe.yj;

public class fe extends de {
    public void de(View view) {
        if ((view instanceof ListView) && th()) {
            ((ListView) view).setDividerHeight(yj.fe(this.f7683th));
        }
    }
}
