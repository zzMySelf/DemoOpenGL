package fe.when.ad;

import com.itextpdf.text.TabStop;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class rrr {

    /* renamed from: ad  reason: collision with root package name */
    public float f9890ad = 36.0f;
    public List<TabStop> qw = new ArrayList();

    public static TabStop ad(float f, rrr rrr) {
        if (rrr != null) {
            return rrr.qw(f);
        }
        return TabStop.th(f, 36.0f);
    }

    public TabStop qw(float f) {
        TabStop tabStop;
        List<TabStop> list = this.qw;
        if (list != null) {
            Iterator<TabStop> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                TabStop next = it.next();
                if (((double) (next.fe() - f)) > 0.001d) {
                    tabStop = new TabStop(next);
                    break;
                }
            }
        }
        tabStop = null;
        return tabStop == null ? TabStop.th(f, this.f9890ad) : tabStop;
    }
}
