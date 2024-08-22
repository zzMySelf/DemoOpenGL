package fe.qw.qw.pf.ad;

import android.graphics.Path;
import fe.qw.qw.ggg.yj;
import java.util.ArrayList;
import java.util.List;

public class ad {
    public List<ggg> qw = new ArrayList();

    public void ad(Path path) {
        for (int size = this.qw.size() - 1; size >= 0; size--) {
            yj.ad(path, this.qw.get(size));
        }
    }

    public void qw(ggg ggg) {
        this.qw.add(ggg);
    }
}
